package defpackage;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.v5.DefaultSocks5CommandResponse;
import io.netty.handler.codec.socksx.v5.Socks5AddressType;
import io.netty.handler.codec.socksx.v5.Socks5CommandRequest;
import io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fz3 extends l1 {
    public static final ez3 f = new ez3();
    public final cm2 b;

    public fz3(cm2 cm2Var) {
        cm2Var.getClass();
        this.b = cm2Var;
    }

    @Override // io.netty.channel.SimpleChannelInboundHandler
    public final void channelRead0(final ChannelHandlerContext channelHandlerContext, Object obj) {
        SocksMessage socksMessage = (SocksMessage) obj;
        channelHandlerContext.getClass();
        socksMessage.getClass();
        final Channel channel = channelHandlerContext.channel();
        final Socks5CommandRequest socks5CommandRequest = (Socks5CommandRequest) socksMessage;
        String strDstAddr = socks5CommandRequest.dstAddr();
        final int iDstPort = socks5CommandRequest.dstPort();
        Promise promiseNewPromise = channelHandlerContext.executor().newPromise();
        promiseNewPromise.addListener2(new GenericFutureListener() { // from class: bz3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public final void operationComplete(Future future) {
                boolean zIsSuccess = future.isSuccess();
                final Channel channel2 = channel;
                final fz3 fz3Var = this;
                if (!zIsSuccess) {
                    channel2.writeAndFlush(new DefaultSocks5CommandResponse(Socks5CommandStatus.FAILURE, socks5CommandRequest.dstAddrType()));
                    ((Map) fz3Var.b.Z).values().remove(channel2.remoteAddress());
                    return;
                }
                Object now = future.getNow();
                now.getClass();
                final Channel channel3 = (Channel) now;
                SocketAddress socketAddressRemoteAddress = channel3.remoteAddress();
                socketAddressRemoteAddress.getClass();
                InetAddress address = ((InetSocketAddress) socketAddressRemoteAddress).getAddress();
                address.getClass();
                Pattern pattern = xz1.b;
                DefaultSocks5CommandResponse defaultSocks5CommandResponse = new DefaultSocks5CommandResponse(Socks5CommandStatus.SUCCESS, xz1.b(address.getHostAddress()) ? Socks5AddressType.IPv4 : Socks5AddressType.IPv6, address.getHostAddress(), iDstPort);
                final ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
                channelHandlerContext2.writeAndFlush(defaultSocks5CommandResponse).addListener2(new GenericFutureListener() { // from class: dz3
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public final void operationComplete(Future future2) {
                        fz3 fz3Var2 = fz3Var;
                        cm2 cm2Var = fz3Var2.b;
                        boolean zIsSuccess2 = future2.isSuccess();
                        ChannelHandlerContext channelHandlerContext3 = channelHandlerContext2;
                        Channel channel4 = channel2;
                        if (!zIsSuccess2) {
                            channelHandlerContext3.close();
                            ((Map) cm2Var.Z).values().remove(channel4.remoteAddress());
                            return;
                        }
                        Channel channel5 = channel3;
                        ChannelPipeline channelPipelinePipeline = channel5.pipeline();
                        channelPipelinePipeline.addLast(new IdleStateHandler(0, 0, 60));
                        ez3 ez3Var = fz3.f;
                        channelPipelinePipeline.addLast(ez3Var);
                        SocketAddress socketAddressLocalAddress = channel5.localAddress();
                        socketAddressLocalAddress.getClass();
                        channel4.getClass();
                        channelPipelinePipeline.addLast(new ob3(cm2Var, socketAddressLocalAddress, channel4));
                        channelHandlerContext3.pipeline().remove(fz3Var2);
                        ChannelPipeline channelPipelinePipeline2 = channelHandlerContext3.pipeline();
                        channelPipelinePipeline2.addLast(new IdleStateHandler(0, 0, 60));
                        channelPipelinePipeline2.addLast(ez3Var);
                        SocketAddress socketAddressLocalAddress2 = channel5.localAddress();
                        socketAddressLocalAddress2.getClass();
                        channelPipelinePipeline2.addLast(new ob3(cm2Var, socketAddressLocalAddress2, channel5));
                    }
                });
            }
        });
        ChannelFutureListener channelFutureListener = new ChannelFutureListener() { // from class: cz3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public final void operationComplete(Future future) {
                ChannelFuture channelFuture = (ChannelFuture) future;
                boolean zIsSuccess = channelFuture.isSuccess();
                Channel channel2 = channel;
                if (!zIsSuccess) {
                    channel2.writeAndFlush(new DefaultSocks5CommandResponse(Socks5CommandStatus.FAILURE, socks5CommandRequest.dstAddrType()));
                    return;
                }
                Map map = (Map) this.b.b.Z;
                map.getClass();
                map.put(channelFuture.channel().localAddress(), channel2.remoteAddress());
            }
        };
        channel.getClass();
        strDstAddr.getClass();
        l1.g(channel, strDstAddr, iDstPort, channelFutureListener, promiseNewPromise);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.getClass();
        th.getClass();
        channelHandlerContext.channel().writeAndFlush(Unpooled.EMPTY_BUFFER).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
    }
}
