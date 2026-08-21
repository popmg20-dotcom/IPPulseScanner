package defpackage;

import android.util.Size;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kg {
    public final String a;
    public final Class b;
    public final tt3 c;
    public final mn4 d;
    public final Size e;
    public final ih f;
    public final List g;

    public kg(String str, Class cls, tt3 tt3Var, mn4 mn4Var, Size size, ih ihVar, ArrayList arrayList) {
        this.a = str;
        this.b = cls;
        if (tt3Var == null) {
            zo2.n("Null sessionConfig");
            throw null;
        }
        this.c = tt3Var;
        if (mn4Var == null) {
            zo2.n("Null useCaseConfig");
            throw null;
        }
        this.d = mn4Var;
        this.e = size;
        this.f = ihVar;
        this.g = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kg)) {
            return false;
        }
        kg kgVar = (kg) obj;
        if (!this.a.equals(kgVar.a) || !this.b.equals(kgVar.b) || !this.c.equals(kgVar.c) || !this.d.equals(kgVar.d)) {
            return false;
        }
        Size size = kgVar.e;
        Size size2 = this.e;
        if (size2 == null) {
            if (size != null) {
                return false;
            }
        } else if (!size2.equals(size)) {
            return false;
        }
        ih ihVar = kgVar.f;
        ih ihVar2 = this.f;
        if (ihVar2 == null) {
            if (ihVar != null) {
                return false;
            }
        } else if (!ihVar2.equals(ihVar)) {
            return false;
        }
        List list = kgVar.g;
        List list2 = this.g;
        return list2 == null ? list == null : list2.equals(list);
    }

    public final int hashCode() {
        int iHashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Size size = this.e;
        int iHashCode2 = (iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        ih ihVar = this.f;
        int iHashCode3 = (iHashCode2 ^ (ihVar == null ? 0 : ihVar.hashCode())) * 1000003;
        List list = this.g;
        return iHashCode3 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "UseCaseInfo{useCaseId=" + this.a + ", useCaseType=" + this.b + ", sessionConfig=" + this.c + ", useCaseConfig=" + this.d + ", surfaceResolution=" + this.e + ", streamSpec=" + this.f + ", captureTypes=" + this.g + "}";
    }
}
