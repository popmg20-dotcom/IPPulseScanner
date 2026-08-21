package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bx2 {
    public final OutputConfiguration a;
    public String b;
    public boolean c;
    public long d = 1;

    public bx2(OutputConfiguration outputConfiguration) {
        this.a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bx2)) {
            return false;
        }
        bx2 bx2Var = (bx2) obj;
        return this.a.equals(bx2Var.a) && this.c == bx2Var.c && this.d == bx2Var.d && Objects.equals(this.b, bx2Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        int i = (this.c ? 1 : 0) ^ ((iHashCode << 5) - iHashCode);
        int i2 = (i << 5) - i;
        String str = this.b;
        int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i2;
        long j = this.d;
        return ((int) (j ^ (j >>> 32))) ^ ((iHashCode2 << 5) - iHashCode2);
    }
}
