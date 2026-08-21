package defpackage;

import android.view.View;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vp1 implements nw0, ChannelFactory, mu2 {
    public final /* synthetic */ int b;

    public /* synthetic */ vp1(int i) {
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ Class a() {
        return Path.class;
    }

    public static /* bridge */ /* synthetic */ SNIHostName c(Object obj) {
        return (SNIHostName) obj;
    }

    public static /* bridge */ /* synthetic */ SNIMatcher d(Object obj) {
        return (SNIMatcher) obj;
    }

    public static /* bridge */ /* synthetic */ SNIServerName f(Object obj) {
        return (SNIServerName) obj;
    }

    public static /* synthetic */ void g() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void h(Object obj, String str) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void i(String str) throws IOException {
        throw new IOException(str);
    }

    public static /* synthetic */ void j(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException(str + obj + obj2);
    }

    public static /* synthetic */ void k(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void l(Throwable th) {
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(th);
    }

    public static /* synthetic */ void m() {
        throw new x92(null);
    }

    public static /* synthetic */ void n(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static /* synthetic */ void o(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void p(Throwable th) {
        throw new RuntimeException(th);
    }

    public static /* synthetic */ void q() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        switch (this.b) {
            case 20:
                view.getClass();
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), bv4Var.a.h(8).d);
                break;
            default:
                view.getClass();
                view.setPadding(view.getPaddingLeft(), bv4Var.a.h(1).b, view.getPaddingRight(), view.getPaddingBottom());
                break;
        }
        return bv4Var;
    }

    @Override // defpackage.nw0
    public List e(String str) throws UnknownHostException {
        str.getClass();
        try {
            return ((pw0) pu1.a.getValue()).e(str);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                allByName.getClass();
                return qe.s0(allByName);
            } catch (NullPointerException e2) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
                unknownHostException.initCause(e2);
                throw unknownHostException;
            }
        }
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public Channel newChannel() {
        return new NioServerSocketChannel();
    }
}
