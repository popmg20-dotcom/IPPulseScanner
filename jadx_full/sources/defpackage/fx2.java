package defpackage;

import android.hardware.camera2.params.OutputConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fx2 {
    public final OutputConfiguration a;
    public long b = 1;

    public fx2(OutputConfiguration outputConfiguration) {
        this.a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof fx2)) {
            return false;
        }
        fx2 fx2Var = (fx2) obj;
        return this.a.equals(fx2Var.a) && this.b == fx2Var.b;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        long j = this.b;
        return ((int) (j ^ (j >>> 32))) ^ ((iHashCode << 5) - iHashCode);
    }
}
