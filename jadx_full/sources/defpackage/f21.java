package defpackage;

import android.content.Context;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f21 {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public f21(Context context) {
        boolean zB = ek0.B(context, R.attr.elevationOverlayEnabled, false);
        int iZ = n12.z(context, R.attr.elevationOverlayColor, 0);
        int iZ2 = n12.z(context, R.attr.elevationOverlayAccentColor, 0);
        int iZ3 = n12.z(context, R.attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = zB;
        this.b = iZ;
        this.c = iZ2;
        this.d = iZ3;
        this.e = f2;
    }
}
