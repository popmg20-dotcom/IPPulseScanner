package defpackage;

import android.net.IpPrefix;
import android.view.inputmethod.SurroundingText;
import android.view.inputmethod.TextSnapshot;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class f11 {
    public static /* synthetic */ IpPrefix a(InetAddress inetAddress, int i) {
        return new IpPrefix(inetAddress, i);
    }

    public static /* synthetic */ TextSnapshot b(SurroundingText surroundingText, int i, int i2, int i3) {
        return new TextSnapshot(surroundingText, i, i2, i3);
    }
}
