package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dx2 {
    public final OutputConfiguration a;
    public String b;
    public long c = 1;

    public dx2(OutputConfiguration outputConfiguration) {
        this.a = outputConfiguration;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof dx2)) {
            return false;
        }
        dx2 dx2Var = (dx2) obj;
        return this.a.equals(dx2Var.a) && this.c == dx2Var.c && Objects.equals(this.b, dx2Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        int i = (iHashCode << 5) - iHashCode;
        String str = this.b;
        int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i;
        long j = this.c;
        return ((int) (j ^ (j >>> 32))) ^ ((iHashCode2 << 5) - iHashCode2);
    }
}
