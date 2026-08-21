package io.netty.handler.traffic;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ArrayDeque<ToSend> messagesQueue;
    private long queueSize;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class ToSend {
        final ChannelPromise promise;
        final long relativeTimeAction;
        final Object toSend;

        private ToSend(long j, Object obj, ChannelPromise channelPromise) {
            this.relativeTimeAction = j;
            this.toSend = obj;
            this.promise = channelPromise;
        }
    }

    public ChannelTrafficShapingHandler(long j, long j2, long j3, long j4) {
        super(j, j2, j3, j4);
        this.messagesQueue = new ArrayDeque<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext channelHandlerContext, long j) {
        synchronized (this) {
            try {
                ToSend toSendPollFirst = this.messagesQueue.pollFirst();
                while (true) {
                    if (toSendPollFirst != null) {
                        if (toSendPollFirst.relativeTimeAction > j) {
                            this.messagesQueue.addFirst(toSendPollFirst);
                            break;
                        }
                        long jCalculateSize = calculateSize(toSendPollFirst.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(jCalculateSize);
                        this.queueSize -= jCalculateSize;
                        channelHandlerContext.write(toSendPollFirst.toSend, toSendPollFirst.promise);
                        toSendPollFirst = this.messagesQueue.pollFirst();
                    } else {
                        break;
                    }
                }
                if (this.messagesQueue.isEmpty()) {
                    releaseWriteSuspended(channelHandlerContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        TrafficCounter trafficCounter = new TrafficCounter(this, channelHandlerContext.executor(), "ChannelTC" + channelHandlerContext.channel().hashCode(), this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        this.trafficCounter.stop();
        synchronized (this) {
            try {
                boolean zIsActive = channelHandlerContext.channel().isActive();
                ArrayDeque<ToSend> arrayDeque = this.messagesQueue;
                if (zIsActive) {
                    for (ToSend toSend : arrayDeque) {
                        long jCalculateSize = calculateSize(toSend.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(jCalculateSize);
                        this.queueSize -= jCalculateSize;
                        channelHandlerContext.write(toSend.toSend, toSend.promise);
                    }
                } else {
                    Iterator<ToSend> it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        Object obj = it.next().toSend;
                        if (obj instanceof ByteBuf) {
                            ((ByteBuf) obj).release();
                        }
                    }
                }
                this.messagesQueue.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        releaseWriteSuspended(channelHandlerContext);
        releaseReadSuspended(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    public long queueSize() {
        return this.queueSize;
    }

    @Override // io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void submitWrite(final ChannelHandlerContext channelHandlerContext, Object obj, long j, long j2, long j3, ChannelPromise channelPromise) {
        synchronized (this) {
            if (j2 == 0) {
                try {
                    if (this.messagesQueue.isEmpty()) {
                        this.trafficCounter.bytesRealWriteFlowControl(j);
                        channelHandlerContext.write(obj, channelPromise);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            ToSend toSend = new ToSend(j2 + j3, obj, channelPromise);
            this.messagesQueue.addLast(toSend);
            long j4 = this.queueSize + j;
            this.queueSize = j4;
            checkWriteSuspend(channelHandlerContext, j2, j4);
            final long j5 = toSend.relativeTimeAction;
            channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.traffic.ChannelTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelTrafficShapingHandler.this.sendAllValid(channelHandlerContext, j5);
                }
            }, j2, TimeUnit.MILLISECONDS);
        }
    }

    public ChannelTrafficShapingHandler(long j, long j2, long j3) {
        super(j, j2, j3);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j, long j2) {
        super(j, j2);
        this.messagesQueue = new ArrayDeque<>();
    }

    public ChannelTrafficShapingHandler(long j) {
        super(j);
        this.messagesQueue = new ArrayDeque<>();
    }
}
