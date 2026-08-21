package defpackage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.socksx.SocksPortUnificationServerHandler;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ga3 extends ChannelInitializer {
    public final cm2 b;
    public final Proxy.Type f;

    public ga3(cm2 cm2Var, Proxy.Type type) {
        type.getClass();
        this.b = cm2Var;
        this.f = type;
    }

    @Override // io.netty.channel.ChannelInitializer
    public final void initChannel(Channel channel) {
        SocketChannel socketChannel = (SocketChannel) channel;
        socketChannel.getClass();
        ChannelPipeline channelPipelinePipeline = socketChannel.pipeline();
        int[] iArr = fa3.a;
        Proxy.Type type = this.f;
        int i = iArr[type.ordinal()];
        cm2 cm2Var = this.b;
        if (i == 1) {
            channelPipelinePipeline.addLast(new HttpServerCodec());
            channelPipelinePipeline.addLast(new wu1(cm2Var));
        } else if (i != 2) {
            vp1.h(type, "unsupported proxy type ");
        } else {
            channelPipelinePipeline.addLast(new SocksPortUnificationServerHandler());
            channelPipelinePipeline.addLast(new hz3(cm2Var));
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public final boolean isSharable() {
        return true;
    }
}
