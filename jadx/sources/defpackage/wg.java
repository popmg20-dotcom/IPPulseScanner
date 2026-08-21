package defpackage;

import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wg implements cy1 {
    public final pa4 a;
    public final long b;
    public final int c;
    public final Matrix d;
    public final int e;

    public wg(pa4 pa4Var, long j, int i, Matrix matrix, int i2) {
        if (pa4Var == null) {
            zo2.n("Null tagBundle");
            throw null;
        }
        this.a = pa4Var;
        this.b = j;
        this.c = i;
        this.d = matrix;
        this.e = i2;
    }

    @Override // defpackage.cy1
    public final pa4 a() {
        return this.a;
    }

    @Override // defpackage.cy1
    public final int b() {
        return this.e;
    }

    @Override // defpackage.cy1
    public final long c() {
        return this.b;
    }

    @Override // defpackage.cy1
    public final int d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wg)) {
            return false;
        }
        wg wgVar = (wg) obj;
        return this.a.equals(wgVar.a) && this.b == wgVar.b && this.c == wgVar.c && this.d.equals(wgVar.d) && this.e == wgVar.e;
    }

    public final int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        return this.e ^ ((((((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ImmutableImageInfo{tagBundle=");
        sb.append(this.a);
        sb.append(", timestamp=");
        sb.append(this.b);
        sb.append(", rotationDegrees=");
        sb.append(this.c);
        sb.append(", sensorToBufferTransformMatrix=");
        sb.append(this.d);
        sb.append(", flashState=");
        return fw.w("}", sb, this.e);
    }
}
