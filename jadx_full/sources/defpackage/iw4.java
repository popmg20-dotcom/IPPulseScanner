package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iw4 {
    public final int a;
    public final int b;
    public final List c;
    public int d;
    public final float e;
    public final boolean f;

    public iw4(int i, int i2, int i3, List list, float f, boolean z) {
        this.d = i;
        this.a = i2;
        this.b = i3;
        this.c = list;
        this.e = f;
        this.f = z;
    }

    public final float a(float f) {
        if (!this.f) {
            return 0.0f;
        }
        float f2 = this.e;
        if (f > f2) {
            return f - f2;
        }
        return 0.0f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RowRegion{startColumn=");
        sb.append(this.a);
        sb.append(", endColumn=");
        sb.append(this.b);
        sb.append(", line=");
        return ha0.p(sb, this.d, '}');
    }
}
