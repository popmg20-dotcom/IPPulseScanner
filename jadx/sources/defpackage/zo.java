package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zo {
    public static final /* synthetic */ zo a = new zo();
    public static final String b = ap.class.getSimpleName();

    public static ap a() {
        int i = Build.VERSION.SDK_INT;
        return i >= 30 ? bp.b : i >= 29 ? d7.A : i >= 28 ? t60.A : i >= 24 ? wl3.z : vd3.f;
    }
}
