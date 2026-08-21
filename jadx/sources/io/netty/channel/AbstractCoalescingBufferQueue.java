package io.netty.channel;

import defpackage.s53;
import defpackage.zo2;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractCoalescingBufferQueue.class);
    private final ArrayDeque<Object> bufAndListenerPairs;
    private int readableBytes;
    private final PendingBytesTracker tracker;

    public AbstractCoalescingBufferQueue(Channel channel, int i) {
        this.bufAndListenerPairs = new ArrayDeque<>(i);
        this.tracker = channel == null ? null : PendingBytesTracker.newTracker(channel);
    }

    private void addFirst(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.addFirst(channelFutureListener);
        }
        this.bufAndListenerPairs.addFirst(byteBuf);
        incrementReadableBytes(byteBuf.readableBytes());
    }

    private void decrementReadableBytes(int i) {
        this.readableBytes -= i;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.decrementPendingOutboundBytes(i);
        }
    }

    private void incrementReadableBytes(int i) {
        int i2 = this.readableBytes;
        int i3 = i2 + i;
        if (i3 < i2) {
            s53.e(this.readableBytes, i, " + ", "buffer queue length overflow: ");
            return;
        }
        this.readableBytes = i3;
        PendingBytesTracker pendingBytesTracker = this.tracker;
        if (pendingBytesTracker != null) {
            pendingBytesTracker.incrementPendingOutboundBytes(i);
        }
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        Throwable th = null;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                break;
            }
            try {
                if (objPoll instanceof ByteBuf) {
                    ByteBuf byteBuf = (ByteBuf) objPoll;
                    decrementReadableBytes(byteBuf.readableBytes());
                    ReferenceCountUtil.safeRelease(byteBuf);
                } else {
                    ((ChannelFutureListener) objPoll).operationComplete(channelFuture);
                }
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    logger.info("Throwable being suppressed because Throwable {} is already pending", th, th2);
                }
            }
        }
        if (th == null) {
            return;
        }
        zo2.q(th);
    }

    private static ChannelFutureListener toChannelFutureListener(ChannelPromise channelPromise) {
        if (channelPromise.isVoid()) {
            return null;
        }
        return new DelegatingChannelPromiseNotifier(channelPromise);
    }

    public final void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        this.bufAndListenerPairs.add(byteBuf);
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.add(channelFutureListener);
        }
        incrementReadableBytes(byteBuf.readableBytes());
    }

    public abstract ByteBuf compose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);

    public final ByteBuf composeIntoComposite(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        CompositeByteBuf compositeByteBufCompositeBuffer = byteBufAllocator.compositeBuffer(size() + 2);
        try {
            compositeByteBufCompositeBuffer.addComponent(true, byteBuf);
            compositeByteBufCompositeBuffer.addComponent(true, byteBuf2);
            return compositeByteBufCompositeBuffer;
        } catch (Throwable th) {
            compositeByteBufCompositeBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
            return compositeByteBufCompositeBuffer;
        }
    }

    public final ByteBuf copyAndCompose(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        ByteBuf byteBufIoBuffer = byteBufAllocator.ioBuffer(byteBuf2.readableBytes() + byteBuf.readableBytes());
        try {
            byteBufIoBuffer.writeBytes(byteBuf).writeBytes(byteBuf2);
        } catch (Throwable th) {
            byteBufIoBuffer.release();
            ReferenceCountUtil.safeRelease(byteBuf2);
            PlatformDependent.throwException(th);
        }
        byteBuf.release();
        byteBuf2.release();
        return byteBufIoBuffer;
    }

    public final void copyTo(AbstractCoalescingBufferQueue abstractCoalescingBufferQueue) {
        abstractCoalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        abstractCoalescingBufferQueue.incrementReadableBytes(this.readableBytes);
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    public final void releaseAndFailAll(ChannelOutboundInvoker channelOutboundInvoker, Throwable th) {
        releaseAndCompleteAll(channelOutboundInvoker.newFailedFuture(th));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        r5.bufAndListenerPairs.addFirst(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r1 <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r0 = r3.readRetainedSlice(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (r2 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r6 = composeFirst(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        r6 = compose(r6, r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.netty.buffer.ByteBuf remove(io.netty.buffer.ByteBufAllocator r6, int r7, io.netty.channel.ChannelPromise r8) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "bytes"
            io.netty.util.internal.ObjectUtil.checkPositiveOrZero(r7, r0)
            java.lang.String r0 = "aggregatePromise"
            io.netty.util.internal.ObjectUtil.checkNotNull(r8, r0)
            java.util.ArrayDeque<java.lang.Object> r0 = r5.bufAndListenerPairs
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L17
            io.netty.buffer.ByteBuf r5 = r5.removeEmptyValue()
            return r5
        L17:
            int r0 = r5.readableBytes
            int r7 = java.lang.Math.min(r7, r0)
            r0 = 0
            r1 = r7
            r2 = r0
        L20:
            java.util.ArrayDeque<java.lang.Object> r3 = r5.bufAndListenerPairs     // Catch: java.lang.Throwable -> L33
            java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L33
            if (r3 != 0) goto L29
            goto L77
        L29:
            boolean r4 = r3 instanceof io.netty.channel.ChannelFutureListener     // Catch: java.lang.Throwable -> L33
            if (r4 == 0) goto L35
            io.netty.channel.ChannelFutureListener r3 = (io.netty.channel.ChannelFutureListener) r3     // Catch: java.lang.Throwable -> L33
            r8.addListener2(r3)     // Catch: java.lang.Throwable -> L33
            goto L20
        L33:
            r6 = move-exception
            goto L6b
        L35:
            io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3     // Catch: java.lang.Throwable -> L33
            int r4 = r3.readableBytes()     // Catch: java.lang.Throwable -> L57
            if (r4 <= r1) goto L5a
            java.util.ArrayDeque<java.lang.Object> r0 = r5.bufAndListenerPairs     // Catch: java.lang.Throwable -> L57
            r0.addFirst(r3)     // Catch: java.lang.Throwable -> L57
            if (r1 <= 0) goto L77
            io.netty.buffer.ByteBuf r0 = r3.readRetainedSlice(r1)     // Catch: java.lang.Throwable -> L57
            if (r2 != 0) goto L50
            io.netty.buffer.ByteBuf r6 = r5.composeFirst(r6, r0)     // Catch: java.lang.Throwable -> L33
        L4e:
            r2 = r6
            goto L55
        L50:
            io.netty.buffer.ByteBuf r6 = r5.compose(r6, r2, r0)     // Catch: java.lang.Throwable -> L33
            goto L4e
        L55:
            r1 = 0
            goto L77
        L57:
            r6 = move-exception
            r0 = r3
            goto L6b
        L5a:
            int r4 = r3.readableBytes()     // Catch: java.lang.Throwable -> L57
            int r1 = r1 - r4
            if (r2 != 0) goto L66
            io.netty.buffer.ByteBuf r2 = r5.composeFirst(r6, r3)     // Catch: java.lang.Throwable -> L57
            goto L20
        L66:
            io.netty.buffer.ByteBuf r2 = r5.compose(r6, r2, r3)     // Catch: java.lang.Throwable -> L57
            goto L20
        L6b:
            io.netty.util.ReferenceCountUtil.safeRelease(r0)
            io.netty.util.ReferenceCountUtil.safeRelease(r2)
            r8.setFailure(r6)
            io.netty.util.internal.PlatformDependent.throwException(r6)
        L77:
            int r7 = r7 - r1
            r5.decrementReadableBytes(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractCoalescingBufferQueue.remove(io.netty.buffer.ByteBufAllocator, int, io.netty.channel.ChannelPromise):io.netty.buffer.ByteBuf");
    }

    public abstract ByteBuf removeEmptyValue();

    public final ByteBuf removeFirst(ChannelPromise channelPromise) {
        Object objPoll = this.bufAndListenerPairs.poll();
        if (objPoll == null) {
            return null;
        }
        ByteBuf byteBuf = (ByteBuf) objPoll;
        decrementReadableBytes(byteBuf.readableBytes());
        Object objPeek = this.bufAndListenerPairs.peek();
        if (objPeek instanceof ChannelFutureListener) {
            channelPromise.addListener2((GenericFutureListener<? extends Future<? super Void>>) objPeek);
            this.bufAndListenerPairs.poll();
        }
        return byteBuf;
    }

    public final int size() {
        return this.bufAndListenerPairs.size();
    }

    public String toString() {
        return "bytes: " + this.readableBytes + " buffers: " + (size() >> 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void writeAndRemoveAll(io.netty.channel.ChannelHandlerContext r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L3:
            java.util.ArrayDeque<java.lang.Object> r3 = r6.bufAndListenerPairs
            java.lang.Object r3 = r3.poll()
            if (r3 != 0) goto L25
            if (r1 == 0) goto L1e
            int r3 = r1.readableBytes()     // Catch: java.lang.Throwable -> L1c
            r6.decrementReadableBytes(r3)     // Catch: java.lang.Throwable -> L1c
            io.netty.channel.ChannelPromise r3 = r7.voidPromise()     // Catch: java.lang.Throwable -> L1c
            r7.write(r1, r3)     // Catch: java.lang.Throwable -> L1c
            goto L1e
        L1c:
            r3 = move-exception
            goto L60
        L1e:
            if (r2 != 0) goto L21
            return
        L21:
            defpackage.zo2.q(r2)
            return
        L25:
            boolean r4 = r3 instanceof io.netty.buffer.ByteBuf     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L3d
            if (r1 == 0) goto L39
            int r4 = r1.readableBytes()     // Catch: java.lang.Throwable -> L1c
            r6.decrementReadableBytes(r4)     // Catch: java.lang.Throwable -> L1c
            io.netty.channel.ChannelPromise r4 = r7.voidPromise()     // Catch: java.lang.Throwable -> L1c
            r7.write(r1, r4)     // Catch: java.lang.Throwable -> L1c
        L39:
            io.netty.buffer.ByteBuf r3 = (io.netty.buffer.ByteBuf) r3     // Catch: java.lang.Throwable -> L1c
            r1 = r3
            goto L3
        L3d:
            boolean r4 = r3 instanceof io.netty.channel.ChannelPromise     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L4f
            int r4 = r1.readableBytes()     // Catch: java.lang.Throwable -> L1c
            r6.decrementReadableBytes(r4)     // Catch: java.lang.Throwable -> L1c
            io.netty.channel.ChannelPromise r3 = (io.netty.channel.ChannelPromise) r3     // Catch: java.lang.Throwable -> L1c
            r7.write(r1, r3)     // Catch: java.lang.Throwable -> L1c
        L4d:
            r1 = r0
            goto L3
        L4f:
            int r4 = r1.readableBytes()     // Catch: java.lang.Throwable -> L1c
            r6.decrementReadableBytes(r4)     // Catch: java.lang.Throwable -> L1c
            io.netty.channel.ChannelFuture r4 = r7.write(r1)     // Catch: java.lang.Throwable -> L1c
            io.netty.channel.ChannelFutureListener r3 = (io.netty.channel.ChannelFutureListener) r3     // Catch: java.lang.Throwable -> L1c
            r4.addListener2(r3)     // Catch: java.lang.Throwable -> L1c
            goto L4d
        L60:
            if (r2 != 0) goto L64
            r2 = r3
            goto L3
        L64:
            io.netty.util.internal.logging.InternalLogger r4 = io.netty.channel.AbstractCoalescingBufferQueue.logger
            java.lang.String r5 = "Throwable being suppressed because Throwable {} is already pending"
            r4.info(r5, r2, r3)
            goto L3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.AbstractCoalescingBufferQueue.writeAndRemoveAll(io.netty.channel.ChannelHandlerContext):void");
    }

    public final void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        add(byteBuf, toChannelFutureListener(channelPromise));
    }

    public final void addFirst(ByteBuf byteBuf, ChannelPromise channelPromise) {
        addFirst(byteBuf, toChannelFutureListener(channelPromise));
    }

    public final void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public ByteBuf composeFirst(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        return byteBuf;
    }
}
