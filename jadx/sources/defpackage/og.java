package defpackage;

import android.util.Size;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class og {
    public az1 a;
    public az1 b;
    public final az1 c = null;
    public final Size d;
    public final int e;
    public final ArrayList f;
    public final boolean g;
    public final i01 h;
    public final i01 i;

    public og(Size size, int i, ArrayList arrayList, boolean z, i01 i01Var, i01 i01Var2) {
        if (size == null) {
            zo2.n("Null size");
            throw null;
        }
        this.d = size;
        this.e = i;
        this.f = arrayList;
        this.g = z;
        this.h = i01Var;
        this.i = i01Var2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof og) {
            og ogVar = (og) obj;
            return this.d.equals(ogVar.d) && this.e == ogVar.e && this.f.equals(ogVar.f) && this.g == ogVar.g && this.h == ogVar.h && this.i == ogVar.i;
        }
        return false;
    }

    public final int hashCode() {
        return this.i.hashCode() ^ ((((((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode()) * 1000003) ^ (this.g ? 1231 : 1237)) * 583896283) ^ this.h.hashCode()) * 1000003);
    }

    public final String toString() {
        return "In{size=" + this.d + ", inputFormat=" + this.e + ", outputFormats=" + this.f + ", virtualCamera=" + this.g + ", imageReaderProxyProvider=null, postviewSettings=null, requestEdge=" + this.h + ", errorEdge=" + this.i + "}";
    }
}
