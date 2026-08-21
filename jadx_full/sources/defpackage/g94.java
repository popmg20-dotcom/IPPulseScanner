package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g94 extends ChannelInboundHandlerAdapter {
    public final boolean A;
    public final AtomicBoolean X;
    public final boolean Y;
    public final /* synthetic */ i94 Z;
    public final Channel b;
    public final int f;

    public g94(i94 i94Var, SocketAddress socketAddress, Channel channel, int i, boolean z, AtomicBoolean atomicBoolean, boolean z2) {
        this.Z = i94Var;
        this.b = channel;
        this.f = i;
        this.A = z;
        this.X = atomicBoolean;
        this.Y = z2;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelInactive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.getClass();
        Channel channel = this.b;
        if (channel.isActive()) {
            channel.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        }
        if (this.X.compareAndSet(false, true)) {
            i94 i94Var = this.Z;
            i94Var.h.g(Integer.valueOf(i94Var.m.decrementAndGet()));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.getClass();
        obj.getClass();
        Channel channel = channelHandlerContext.channel();
        if (channel.config().isAutoRead()) {
            channel.config().setAutoRead(false);
        }
        Channel channel2 = this.b;
        if (!channel2.isActive()) {
            ReferenceCountUtil.release(obj);
        } else {
            channel2.writeAndFlush(obj).addListener2((GenericFutureListener<? extends Future<? super Void>>) new f94(((ByteBuf) obj).readableBytes(), this, channel));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.getClass();
        th.getClass();
        String str = "exceptionCaught: " + th;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SystemHttpProxy", str, null);
        }
        channelHandlerContext.close();
        if (this.X.compareAndSet(false, true)) {
            i94 i94Var = this.Z;
            i94Var.h.g(Integer.valueOf(i94Var.m.decrementAndGet()));
        }
    }
}
