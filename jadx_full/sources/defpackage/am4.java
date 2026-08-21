package defpackage;

import j$.util.Objects;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class am4 {
    public static final /* synthetic */ int f = 0;
    public ze2 a;
    public x02 b;
    public ze2 c;
    public List d;
    public List e;

    static {
        new zl4().a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof am4)) {
            return false;
        }
        am4 am4Var = (am4) obj;
        return Objects.equals(this.a, am4Var.a) && Objects.equals(this.b, am4Var.b) && Objects.equals(this.c, am4Var.c) && Objects.equals(this.d, am4Var.d) && Objects.equals(this.e, am4Var.e);
    }

    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.b) + ((Objects.hashCode(this.a) + 31) * 31)) * 31)) * 31)) * 31);
    }
}
