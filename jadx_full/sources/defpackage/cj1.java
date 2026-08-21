package defpackage;

import android.util.Range;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cj1 extends eq1 {
    public static final Range d = new Range(30, 30);
    public final int a = 60;
    public final int b = 60;
    public final xc1 c = xc1.f;

    @Override // defpackage.eq1
    public final xc1 a() {
        return this.c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FpsRangeFeature(minFps=");
        sb.append(this.a);
        sb.append(", maxFps=");
        return ha0.p(sb, this.b, ')');
    }
}
