package defpackage;

import android.widget.EditText;
import android.window.OnBackInvokedDispatcher;
import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements ChannelFactory, v23, l01 {
    public final /* synthetic */ int b;

    public /* synthetic */ g(int i) {
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ OnBackInvokedDispatcher c(Object obj) {
        return (OnBackInvokedDispatcher) obj;
    }

    public static /* synthetic */ void d() {
        throw new t80();
    }

    public static /* synthetic */ void e(long j, long j2) throws IOException {
        throw new IOException("Out of size: " + j + ((Object) " > ") + j2);
    }

    public static /* synthetic */ void g(Object obj) {
        throw new IllegalStateException(obj.toString());
    }

    public static /* synthetic */ void h(String str, Object[] objArr) {
        throw new IndexOutOfBoundsException(String.format(str, objArr));
    }

    @Override // defpackage.l01
    public void a(EditText editText) {
        AppSettingsFragment.onViewCreated$lambda$9$0(editText);
    }

    @Override // defpackage.v23
    public boolean i(Preference preference, Object obj) {
        switch (this.b) {
            case 26:
                return AppSettingsFragment.onViewCreated$lambda$1$2(preference, obj);
            case 27:
                return AppSettingsFragment.onViewCreated$lambda$3$0(preference, obj);
            default:
                return AppSettingsFragment.onViewCreated$lambda$4$0(preference, obj);
        }
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public Channel newChannel() {
        return new NioSocketChannel();
    }
}
