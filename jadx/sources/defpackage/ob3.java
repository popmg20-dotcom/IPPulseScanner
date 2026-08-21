package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ob3 extends ChannelInboundHandlerAdapter {
    public final Channel A;
    public final cm2 b;
    public final SocketAddress f;

    public ob3(cm2 cm2Var, SocketAddress socketAddress, Channel channel) {
        cm2Var.getClass();
        channel.getClass();
        this.b = cm2Var;
        this.f = socketAddress;
        this.A = channel;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelInactive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.getClass();
        Channel channel = this.A;
        if (channel.isActive()) {
            channel.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        }
        ((Map) this.b.Z).remove(this.f);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.getClass();
        obj.getClass();
        Channel channel = channelHandlerContext.channel();
        if (channel.config().isAutoRead()) {
            channel.config().setAutoRead(false);
        }
        Channel channel2 = this.A;
        if (channel2.isActive()) {
            channel2.writeAndFlush(obj).addListener2((GenericFutureListener<? extends Future<? super Void>>) new nb3(channel, this));
        } else {
            ReferenceCountUtil.release(obj);
            ((Map) this.b.Z).remove(this.f);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.getClass();
        th.getClass();
        String str = "exceptionCaught: " + th;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProxyRelayHandler", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProxyRelayHandler", str, null);
        }
        channelHandlerContext.close();
        ((Map) this.b.Z).remove(this.f);
    }
}
