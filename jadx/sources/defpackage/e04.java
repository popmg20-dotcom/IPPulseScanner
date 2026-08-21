package defpackage;

import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakeException;
import java.security.cert.PKIXRevocationChecker;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e04 implements s54, ChannelFactory, yb4, w23, v23 {
    public final /* synthetic */ int b;
    public static final e04 f = new e04(11);
    public static final e04 z = new e04(12);
    public static final e04 A = new e04(13);
    public static final e04 X = new e04(14);
    public static final e04 Y = new e04(15);

    public /* synthetic */ e04(int i) {
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ PKIXRevocationChecker c(Object obj) {
        return (PKIXRevocationChecker) obj;
    }

    public static /* synthetic */ void e(int i, Object obj, Object obj2) {
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + obj + obj2 + i);
    }

    public static /* synthetic */ void f(Object obj) {
        throw new IllegalArgumentException(obj.toString());
    }

    public static /* synthetic */ void g(Object obj, HttpResponse httpResponse) {
        throw new WebSocketClientHandshakeException("Invalid handshake response connection: " + obj, httpResponse);
    }

    public static /* synthetic */ void h(String str) {
        throw new NoSuchElementException(str);
    }

    public static /* synthetic */ void j(String str, Object obj, HttpResponse httpResponse) {
        throw new WebSocketClientHandshakeException(str + obj, httpResponse);
    }

    public static /* synthetic */ void l(String str, Throwable th) {
        throw new IllegalStateException(str, th);
    }

    @Override // defpackage.s54
    public Object get() {
        throw new IllegalStateException();
    }

    @Override // defpackage.v23
    public boolean i(Preference preference, Object obj) {
        return VpnSettingsFragment.onViewCreated$lambda$1$0(preference, obj);
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        return VpnSettingsFragment.onViewCreated$lambda$0(preference);
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public Channel newChannel() {
        switch (this.b) {
            case 8:
                return new NioServerSocketChannel();
            default:
                return new NioSocketChannel();
        }
    }
}
