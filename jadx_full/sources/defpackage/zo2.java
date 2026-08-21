package defpackage;

import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.settings.NotificationSettingsFragment;
import com.getsurfboard.ui.fragment.settings.OthersSettingsFragment;
import com.getsurfboard.ui.fragment.settings.OverrideSettingsFragment;
import java.net.SocketOption;
import java.nio.channels.MembershipKey;
import java.nio.channels.NetworkChannel;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import javax.net.ssl.X509ExtendedTrustManager;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zo2 implements v23, w23, jm1 {
    public final /* synthetic */ int b;

    public static /* bridge */ /* synthetic */ SocketOption b(Object obj) {
        return (SocketOption) obj;
    }

    public static /* bridge */ /* synthetic */ MembershipKey c(Object obj) {
        return (MembershipKey) obj;
    }

    public static /* bridge */ /* synthetic */ NetworkChannel d(Object obj) {
        return (NetworkChannel) obj;
    }

    public static /* bridge */ /* synthetic */ Path e(Object obj) {
        return (Path) obj;
    }

    public static /* synthetic */ void g() {
        throw new Error();
    }

    public static /* synthetic */ void h(int i, Object obj, Object obj2, Object obj3) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(i);
        sb.append(obj3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void j(int i, StringBuilder sb) {
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void l(Object obj, Object obj2, long j, Object obj3) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(j);
        sb.append(obj3);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void n(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void o(String str, Throwable th) {
        throw new RuntimeException(str, th);
    }

    public static /* synthetic */ void p(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static /* synthetic */ void q(Throwable th) {
        throw new IllegalStateException(th);
    }

    public static /* bridge */ /* synthetic */ boolean r(Object obj) {
        return obj instanceof X509ExtendedTrustManager;
    }

    public static /* synthetic */ void t(Object obj, String str) {
        throw new hy4(str + obj);
    }

    public static /* synthetic */ void u(String str) throws InvalidKeyException {
        throw new InvalidKeyException(str);
    }

    public static /* synthetic */ void v(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void w(String str) {
        throw new RuntimeException(str);
    }

    @Override // defpackage.jm1
    public Object apply(Object obj) {
        return j53.b;
    }

    @Override // defpackage.v23
    public boolean i(Preference preference, Object obj) {
        switch (this.b) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return NotificationSettingsFragment.onViewCreated$lambda$0$0(preference, obj);
            default:
                return OverrideSettingsFragment.onViewCreated$lambda$4$0(preference, obj);
        }
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        return OthersSettingsFragment.onViewCreated$lambda$5$0(preference);
    }

    public /* synthetic */ zo2(int i) {
        this.b = i;
    }
}
