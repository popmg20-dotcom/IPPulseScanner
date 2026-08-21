package defpackage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.http.HttpServerCodec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a94 extends ChannelInitializer {
    public final /* synthetic */ i94 b;

    public a94(i94 i94Var) {
        this.b = i94Var;
    }

    @Override // io.netty.channel.ChannelInitializer
    public final void initChannel(Channel channel) {
        channel.getClass();
        channel.pipeline().addLast(new HttpServerCodec());
        channel.pipeline().addLast(new hz3(this.b));
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public final boolean isSharable() {
        return true;
    }
}
