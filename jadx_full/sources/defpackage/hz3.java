package defpackage;

import android.os.Process;
import android.system.OsConstants;
import android.util.Log;
import com.getsurfboard.vpn.JniKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.socksx.SocksMessage;
import io.netty.handler.codec.socksx.SocksVersion;
import io.netty.handler.codec.socksx.v5.Socks5CommandRequest;
import io.netty.handler.codec.socksx.v5.Socks5CommandRequestDecoder;
import io.netty.handler.codec.socksx.v5.Socks5CommandType;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequest;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequestDecoder;
import io.netty.resolver.NoopAddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hz3 extends SimpleChannelInboundHandler {
    public final /* synthetic */ int b = 0;
    public final Object f;

    public hz3(cm2 cm2Var) {
        cm2Var.getClass();
        this.f = cm2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0318 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fd  */
    @Override // io.netty.channel.SimpleChannelInboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void channelRead0(final ChannelHandlerContext channelHandlerContext, Object obj) {
        boolean z;
        InetSocketAddress inetSocketAddress;
        q93 q93Var;
        String str;
        String hostAddress;
        final int i;
        final String str2;
        String string;
        Promise promiseNewPromise;
        ChannelFutureListener channelFutureListener;
        final Channel channel;
        boolean zC;
        hz3 hz3Var;
        Integer numM0;
        switch (this.b) {
            case 0:
                SocksMessage socksMessage = (SocksMessage) obj;
                channelHandlerContext.getClass();
                socksMessage.getClass();
                if (socksMessage.version() == SocksVersion.SOCKS5) {
                    if (socksMessage instanceof Socks5InitialRequest) {
                        channelHandlerContext.pipeline().addFirst(new Socks5CommandRequestDecoder());
                        channelHandlerContext.channel().writeAndFlush(iz3.a).addListener2(new GenericFutureListener() { // from class: gz3
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public final void operationComplete(Future future) {
                                if (future.isSuccess()) {
                                    channelHandlerContext.pipeline().remove(Socks5InitialRequestDecoder.class);
                                }
                            }
                        });
                        return;
                    } else if ((socksMessage instanceof Socks5CommandRequest) && n12.c(((Socks5CommandRequest) socksMessage).type(), Socks5CommandType.CONNECT)) {
                        channelHandlerContext.pipeline().addLast(new fz3((cm2) this.f));
                        channelHandlerContext.pipeline().remove(this);
                        channelHandlerContext.fireChannelRead((Object) socksMessage);
                        return;
                    }
                }
                channelHandlerContext.close();
                return;
            default:
                HttpObject httpObject = (HttpObject) obj;
                channelHandlerContext.getClass();
                httpObject.getClass();
                if (httpObject instanceof HttpRequest) {
                    final Channel channel2 = channelHandlerContext.channel();
                    SocketAddress socketAddressRemoteAddress = channel2.remoteAddress();
                    socketAddressRemoteAddress.getClass();
                    InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socketAddressRemoteAddress;
                    SocketAddress socketAddressLocalAddress = channel2.localAddress();
                    socketAddressLocalAddress.getClass();
                    InetSocketAddress inetSocketAddress3 = (InetSocketAddress) socketAddressLocalAddress;
                    HttpRequest httpRequest = (HttpRequest) httpObject;
                    String strUri = httpRequest.headers().get(HttpHeaderNames.HOST);
                    if (strUri == null || !p44.o0(strUri, ":", false)) {
                        strUri = httpRequest.uri();
                        strUri.getClass();
                        if (w44.j0(strUri, "http://", false)) {
                            strUri = p44.F0(strUri, "http://");
                            if (p44.o0(strUri, "/", false)) {
                                strUri = (String) p44.L0(strUri, new String[]{"/"}, 6).get(0);
                            }
                            if (!p44.o0(strUri, ":", false)) {
                                strUri = strUri.concat(":80");
                            }
                        }
                    }
                    List listL0 = p44.L0(strUri, new String[]{":"}, 6);
                    String str3 = (String) d70.f0(0, listL0);
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = (String) d70.f0(1, listL0);
                    int iIntValue = (str4 == null || (numM0 = w44.m0(str4)) == null) ? 80 : numM0.intValue();
                    InetSocketAddress inetSocketAddressCreateUnresolved = InetSocketAddress.createUnresolved(str3, iIntValue);
                    final int iIntValue2 = ((Number) ((i94) this.f).b.k(inetSocketAddress2, inetSocketAddress3)).intValue();
                    String str5 = httpRequest.headers().get("SurfboardProxy");
                    String strUri2 = httpRequest.uri();
                    HttpMethod httpMethodMethod = httpRequest.method();
                    HttpMethod httpMethod = HttpMethod.CONNECT;
                    boolean zC2 = n12.c(httpMethodMethod, httpMethod);
                    if (!zC2) {
                        strUri2.getClass();
                        z = zC2;
                        if (w44.j0(strUri2, "http://", false)) {
                            String strF0 = p44.F0(strUri2, "http://");
                            inetSocketAddress = inetSocketAddress2;
                            int iU0 = p44.u0(strF0, '/', 0, 6);
                            String strSubstring = iU0 >= 0 ? strF0.substring(iU0) : "";
                            if (((i94) this.f).f) {
                                q93Var = null;
                            } else {
                                s93 s93VarU = t93.J0.u();
                                i94 i94Var = (i94) this.f;
                                int i2 = OsConstants.IPPROTO_TCP;
                                s93VarU.Z = i2;
                                s93VarU.X |= 2;
                                s93VarU.S();
                                String hostAddress2 = inetSocketAddress.getAddress().getHostAddress();
                                s93VarU.A0 = hostAddress2 != null ? hostAddress2 : "";
                                s93VarU.X |= 16;
                                s93VarU.S();
                                s93VarU.B0 = inetSocketAddress.getPort();
                                s93VarU.X |= 32;
                                s93VarU.S();
                                s93VarU.C0 = str3;
                                s93VarU.X |= 64;
                                s93VarU.S();
                                s93VarU.D0 = iIntValue;
                                s93VarU.X |= 128;
                                s93VarU.S();
                                s93VarU.z0 = str3;
                                s93VarU.X |= 8;
                                s93VarU.S();
                                s93VarU.y0 = iIntValue2;
                                s93VarU.X |= 4;
                                s93VarU.S();
                                String str6 = !z ? "HTTP" : (String) i94Var.e.k(Integer.valueOf(i2), Integer.valueOf(iIntValue));
                                str6.getClass();
                                s93VarU.G0 = str6;
                                s93VarU.X |= 1024;
                                s93VarU.S();
                                if (strSubstring.length() > 0) {
                                    s93VarU.H0 = strSubstring;
                                    s93VarU.X |= 2048;
                                    s93VarU.S();
                                }
                                if (str5 != null) {
                                    s93VarU.F0 = str5;
                                    s93VarU.X |= 512;
                                    s93VarU.S();
                                }
                                String str7 = httpRequest.headers().get(HttpHeaderNames.USER_AGENT);
                                if (str7 != null && str7.length() != 0) {
                                    s93VarU.I0 = str7;
                                    s93VarU.X |= 4096;
                                    s93VarU.S();
                                }
                                t93 t93VarQ = s93VarU.q();
                                if (!t93VarQ.c()) {
                                    throw a1.C(t93VarQ);
                                }
                                q93Var = (q93) ((i94) this.f).d.g(t93VarQ);
                            }
                            String str8 = (String) ((i94) this.f).c.g(Integer.valueOf(iIntValue2));
                            str = httpRequest.headers().get(HttpHeaderNames.USER_AGENT);
                            if (str == null) {
                                str = "N/A";
                            }
                            hostAddress = inetSocketAddress.getAddress().getHostAddress();
                            if (hostAddress == null) {
                                hostAddress = "?";
                            }
                            int port = inetSocketAddress.getPort();
                            String hostString = inetSocketAddressCreateUnresolved.getHostString();
                            int port2 = inetSocketAddressCreateUnresolved.getPort();
                            i = iIntValue;
                            str2 = str3;
                            StringBuilder sbE = fw.E("Request app=", str8, "(", str, "), src=");
                            sbE.append(hostAddress);
                            sbE.append(":");
                            sbE.append(port);
                            sbE.append(", dst=");
                            sbE.append(hostString);
                            sbE.append(":");
                            sbE.append(port2);
                            string = sbE.toString();
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("SystemHttpProxy", string, null);
                            }
                            boolean z2 = q93Var != null && (q93Var.X == JniKt.proxyReject() || q93Var.X == JniKt.proxyRejectDrop());
                            if (((i94) this.f).f && z2) {
                                channel2.writeAndFlush(j94.b).addListener2(ChannelFutureListener.CLOSE);
                                return;
                            }
                            promiseNewPromise = channelHandlerContext.executor().newPromise();
                            final long jCurrentTimeMillis = System.currentTimeMillis();
                            channelFutureListener = new ChannelFutureListener() { // from class: b94
                                @Override // io.netty.util.concurrent.GenericFutureListener
                                public final void operationComplete(Future future) {
                                    long j = jCurrentTimeMillis;
                                    Channel channel3 = channel2;
                                    String str9 = str2;
                                    int i3 = i;
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - j;
                                    if (!((ChannelFuture) future).isSuccess()) {
                                        StringBuilder sb = new StringBuilder("Connect FAILED to ");
                                        sb.append(str9);
                                        sb.append(":");
                                        sb.append(i3);
                                        sb.append(" in ");
                                        String strC = dw2.C(sb, "ms", jCurrentTimeMillis2);
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strC);
                                        }
                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                            Log.d("SystemHttpProxy", strC, null);
                                        }
                                        channel3.writeAndFlush(j94.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                                        return;
                                    }
                                    if (jCurrentTimeMillis2 > 2000) {
                                        String str10 = "Slow connect: " + jCurrentTimeMillis2 + "ms to " + str9 + ":" + i3;
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                                        }
                                        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                            return;
                                        }
                                        Log.d("SystemHttpProxy", str10, null);
                                    }
                                }
                            };
                            channel = channel2;
                            final boolean z3 = q93Var != null && q93Var.X == JniKt.proxySocks5();
                            zC = n12.c(httpRequest.method(), httpMethod);
                            final i94 i94Var2 = (i94) this.f;
                            if (zC) {
                                GenericFutureListener genericFutureListener = new GenericFutureListener() { // from class: c94
                                    @Override // io.netty.util.concurrent.GenericFutureListener
                                    public final void operationComplete(Future future) {
                                        boolean zIsSuccess = future.isSuccess();
                                        Channel channel3 = channel;
                                        if (!zIsSuccess) {
                                            channel3.writeAndFlush(j94.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                                            return;
                                        }
                                        Object now = future.getNow();
                                        now.getClass();
                                        Channel channel4 = (Channel) now;
                                        channel3.writeAndFlush(j94.a).addListener2((GenericFutureListener<? extends Future<? super Void>>) new d94(i94Var2, channel4, channel3, iIntValue2, z3, this, 0));
                                    }
                                };
                                channel = channel;
                                promiseNewPromise.addListener2(genericFutureListener);
                                hz3Var = this;
                            } else {
                                hz3Var = this;
                                promiseNewPromise.addListener2((GenericFutureListener) new d94(httpObject, channel, i94Var2, iIntValue2, z3, this));
                            }
                            if (((i94) hz3Var.f).f && q93Var != null && q93Var.X == JniKt.proxySocks5()) {
                                int i3 = q93Var.z0;
                                promiseNewPromise.getClass();
                                Bootstrap bootstrapResolver = new Bootstrap().group(channel.eventLoop()).channelFactory((ChannelFactory) new e04(9)).resolver(NoopAddressResolverGroup.INSTANCE);
                                ChannelOption<Boolean> channelOption = ChannelOption.TCP_NODELAY;
                                Boolean bool = Boolean.TRUE;
                                bootstrapResolver.option(channelOption, bool).option(ChannelOption.SO_KEEPALIVE, bool).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000).handler(new h94(i3, promiseNewPromise)).connect(InetSocketAddress.createUnresolved(str2, i)).addListener2((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                                return;
                            }
                            i94 i94Var3 = (i94) hz3Var.f;
                            promiseNewPromise.getClass();
                            Bootstrap bootstrapChannelFactory = new Bootstrap().group(channel.eventLoop()).channelFactory((ChannelFactory) new o73(10, i94Var3));
                            ChannelOption<Boolean> channelOption2 = ChannelOption.TCP_NODELAY;
                            Boolean bool2 = Boolean.TRUE;
                            bootstrapChannelFactory.option(channelOption2, bool2).option(ChannelOption.SO_KEEPALIVE, bool2).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000).handler(new vu0(promiseNewPromise)).connect(str2, i).addListener2((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                            return;
                        }
                        if (((i94) this.f).f) {
                        }
                        String str82 = (String) ((i94) this.f).c.g(Integer.valueOf(iIntValue2));
                        str = httpRequest.headers().get(HttpHeaderNames.USER_AGENT);
                        if (str == null) {
                        }
                        hostAddress = inetSocketAddress.getAddress().getHostAddress();
                        if (hostAddress == null) {
                        }
                        int port3 = inetSocketAddress.getPort();
                        String hostString2 = inetSocketAddressCreateUnresolved.getHostString();
                        int port22 = inetSocketAddressCreateUnresolved.getPort();
                        i = iIntValue;
                        str2 = str3;
                        StringBuilder sbE2 = fw.E("Request app=", str82, "(", str, "), src=");
                        sbE2.append(hostAddress);
                        sbE2.append(":");
                        sbE2.append(port3);
                        sbE2.append(", dst=");
                        sbE2.append(hostString2);
                        sbE2.append(":");
                        sbE2.append(port22);
                        string = sbE2.toString();
                        if (fy4.b) {
                        }
                        if (((Boolean) le2.a.a()).booleanValue()) {
                            Log.d("SystemHttpProxy", string, null);
                        }
                        if (q93Var != null) {
                        }
                        if (((i94) this.f).f) {
                        }
                        promiseNewPromise = channelHandlerContext.executor().newPromise();
                        final long jCurrentTimeMillis2 = System.currentTimeMillis();
                        channelFutureListener = new ChannelFutureListener() { // from class: b94
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public final void operationComplete(Future future) {
                                long j = jCurrentTimeMillis2;
                                Channel channel3 = channel2;
                                String str9 = str2;
                                int i32 = i;
                                long jCurrentTimeMillis22 = System.currentTimeMillis() - j;
                                if (!((ChannelFuture) future).isSuccess()) {
                                    StringBuilder sb = new StringBuilder("Connect FAILED to ");
                                    sb.append(str9);
                                    sb.append(":");
                                    sb.append(i32);
                                    sb.append(" in ");
                                    String strC = dw2.C(sb, "ms", jCurrentTimeMillis22);
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strC);
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        Log.d("SystemHttpProxy", strC, null);
                                    }
                                    channel3.writeAndFlush(j94.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                                    return;
                                }
                                if (jCurrentTimeMillis22 > 2000) {
                                    String str10 = "Slow connect: " + jCurrentTimeMillis22 + "ms to " + str9 + ":" + i32;
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                                    }
                                    if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                        return;
                                    }
                                    Log.d("SystemHttpProxy", str10, null);
                                }
                            }
                        };
                        channel = channel2;
                        if (q93Var != null) {
                        }
                        zC = n12.c(httpRequest.method(), httpMethod);
                        final i94 i94Var22 = (i94) this.f;
                        if (zC) {
                        }
                        if (((i94) hz3Var.f).f) {
                        }
                        i94 i94Var32 = (i94) hz3Var.f;
                        promiseNewPromise.getClass();
                        Bootstrap bootstrapChannelFactory2 = new Bootstrap().group(channel.eventLoop()).channelFactory((ChannelFactory) new o73(10, i94Var32));
                        ChannelOption<Boolean> channelOption22 = ChannelOption.TCP_NODELAY;
                        Boolean bool22 = Boolean.TRUE;
                        bootstrapChannelFactory2.option(channelOption22, bool22).option(ChannelOption.SO_KEEPALIVE, bool22).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000).handler(new vu0(promiseNewPromise)).connect(str2, i).addListener2((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                        return;
                    }
                    z = zC2;
                    inetSocketAddress = inetSocketAddress2;
                    if (((i94) this.f).f) {
                    }
                    String str822 = (String) ((i94) this.f).c.g(Integer.valueOf(iIntValue2));
                    str = httpRequest.headers().get(HttpHeaderNames.USER_AGENT);
                    if (str == null) {
                    }
                    hostAddress = inetSocketAddress.getAddress().getHostAddress();
                    if (hostAddress == null) {
                    }
                    int port32 = inetSocketAddress.getPort();
                    String hostString22 = inetSocketAddressCreateUnresolved.getHostString();
                    int port222 = inetSocketAddressCreateUnresolved.getPort();
                    i = iIntValue;
                    str2 = str3;
                    StringBuilder sbE22 = fw.E("Request app=", str822, "(", str, "), src=");
                    sbE22.append(hostAddress);
                    sbE22.append(":");
                    sbE22.append(port32);
                    sbE22.append(", dst=");
                    sbE22.append(hostString22);
                    sbE22.append(":");
                    sbE22.append(port222);
                    string = sbE22.toString();
                    if (fy4.b) {
                    }
                    if (((Boolean) le2.a.a()).booleanValue()) {
                    }
                    if (q93Var != null) {
                    }
                    if (((i94) this.f).f) {
                    }
                    promiseNewPromise = channelHandlerContext.executor().newPromise();
                    final long jCurrentTimeMillis22 = System.currentTimeMillis();
                    channelFutureListener = new ChannelFutureListener() { // from class: b94
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public final void operationComplete(Future future) {
                            long j = jCurrentTimeMillis22;
                            Channel channel3 = channel2;
                            String str9 = str2;
                            int i32 = i;
                            long jCurrentTimeMillis222 = System.currentTimeMillis() - j;
                            if (!((ChannelFuture) future).isSuccess()) {
                                StringBuilder sb = new StringBuilder("Connect FAILED to ");
                                sb.append(str9);
                                sb.append(":");
                                sb.append(i32);
                                sb.append(" in ");
                                String strC = dw2.C(sb, "ms", jCurrentTimeMillis222);
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strC);
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d("SystemHttpProxy", strC, null);
                                }
                                channel3.writeAndFlush(j94.b).addListener2((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                                return;
                            }
                            if (jCurrentTimeMillis222 > 2000) {
                                String str10 = "Slow connect: " + jCurrentTimeMillis222 + "ms to " + str9 + ":" + i32;
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 1, "SystemHttpProxy", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str10);
                                }
                                if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                    return;
                                }
                                Log.d("SystemHttpProxy", str10, null);
                            }
                        }
                    };
                    channel = channel2;
                    if (q93Var != null) {
                    }
                    zC = n12.c(httpRequest.method(), httpMethod);
                    final i94 i94Var222 = (i94) this.f;
                    if (zC) {
                    }
                    if (((i94) hz3Var.f).f) {
                    }
                    i94 i94Var322 = (i94) hz3Var.f;
                    promiseNewPromise.getClass();
                    Bootstrap bootstrapChannelFactory22 = new Bootstrap().group(channel.eventLoop()).channelFactory((ChannelFactory) new o73(10, i94Var322));
                    ChannelOption<Boolean> channelOption222 = ChannelOption.TCP_NODELAY;
                    Boolean bool222 = Boolean.TRUE;
                    bootstrapChannelFactory22.option(channelOption222, bool222).option(ChannelOption.SO_KEEPALIVE, bool222).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 4000).handler(new vu0(promiseNewPromise)).connect(str2, i).addListener2((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                    return;
                }
                return;
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        switch (this.b) {
            case 1:
                channelHandlerContext.getClass();
                th.getClass();
                channelHandlerContext.close();
                break;
            default:
                super.exceptionCaught(channelHandlerContext, th);
                break;
        }
    }

    public hz3(i94 i94Var) {
        this.f = i94Var;
    }
}
