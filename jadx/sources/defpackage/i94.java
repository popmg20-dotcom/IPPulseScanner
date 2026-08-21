package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i94 {
    public final InetSocketAddress a;
    public final dt b;
    public final x12 c;
    public final m32 d;
    public final cd e;
    public final boolean f;
    public final m32 g;
    public final m32 h;
    public final ServerBootstrap i;
    public final NioEventLoopGroup j;
    public final NioEventLoopGroup k;
    public InetSocketAddress l;
    public final AtomicInteger m;

    public i94(InetSocketAddress inetSocketAddress, dt dtVar, x12 x12Var, m32 m32Var, cd cdVar, boolean z, m32 m32Var2, m32 m32Var3) {
        this.a = inetSocketAddress;
        this.b = dtVar;
        this.c = x12Var;
        this.d = m32Var;
        this.e = cdVar;
        this.f = z;
        this.g = m32Var2;
        this.h = m32Var3;
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        this.i = serverBootstrap;
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(1);
        this.j = nioEventLoopGroup;
        NioEventLoopGroup nioEventLoopGroup2 = new NioEventLoopGroup(3);
        this.k = nioEventLoopGroup2;
        this.m = new AtomicInteger(0);
        ServerBootstrap serverBootstrapOption = serverBootstrap.group(nioEventLoopGroup, nioEventLoopGroup2).channelFactory((ChannelFactory) new e04(8)).handler(new z84()).childHandler(new a94(this)).option(ChannelOption.SO_BACKLOG, 2048);
        ChannelOption<Boolean> channelOption = ChannelOption.SO_REUSEADDR;
        Boolean bool = Boolean.TRUE;
        serverBootstrapOption.option(channelOption, bool).childOption(ChannelOption.SO_KEEPALIVE, bool).childOption(ChannelOption.TCP_NODELAY, bool);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.channel.ChannelFuture] */
    public final void a() {
        InetAddress address;
        Channel channel = this.i.bind(this.a).sync2().channel();
        SocketAddress socketAddressLocalAddress = channel.localAddress();
        InetSocketAddress inetSocketAddress = socketAddressLocalAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddressLocalAddress : null;
        this.l = inetSocketAddress;
        String hostAddress = (inetSocketAddress == null || (address = inetSocketAddress.getAddress()) == null) ? null : address.getHostAddress();
        InetSocketAddress inetSocketAddress2 = this.l;
        String str = "SystemHttpProxy listen in " + hostAddress + ":" + (inetSocketAddress2 != null ? Integer.valueOf(inetSocketAddress2.getPort()) : null);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("SystemHttpProxy", str, null);
        }
        channel.closeFuture().sync2();
    }
}
