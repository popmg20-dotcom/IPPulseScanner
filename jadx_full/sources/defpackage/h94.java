package defpackage;

import com.getsurfboard.vpn.JniKt;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.proxy.Socks5ProxyHandler;
import io.netty.util.concurrent.Promise;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h94 extends ChannelInitializer {
    public final /* synthetic */ int b;
    public final /* synthetic */ Promise f;

    public h94(int i, Promise promise) {
        this.b = i;
        this.f = promise;
    }

    @Override // io.netty.channel.ChannelInitializer
    public final void initChannel(Channel channel) {
        channel.getClass();
        channel.pipeline().addLast(new Socks5ProxyHandler(new InetSocketAddress(JniKt.getXRayAddress(), this.b)));
        channel.pipeline().addLast(new vu0(this.f));
    }
}
