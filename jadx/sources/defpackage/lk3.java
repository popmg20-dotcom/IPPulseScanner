package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lk3 {
    public static final k83 h = new k83("DAV:", "response");
    public static final k83 i = new k83("DAV:", "multistatus");
    public static final k83 j = new k83("DAV:", "status");
    public static final k83 k = new k83("DAV:", "location");
    public final ev1 a;
    public final ev1 b;
    public final qt c;
    public final ArrayList d;
    public final List e;
    public final ev1 f;
    public final n84 g = new n84(new v10(5, this));

    public lk3(ev1 ev1Var, ev1 ev1Var2, qt qtVar, ArrayList arrayList, ArrayList arrayList2, ev1 ev1Var3) {
        this.a = ev1Var;
        this.b = ev1Var2;
        this.c = qtVar;
        this.d = arrayList;
        this.e = arrayList2;
        this.f = ev1Var3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lk3)) {
            return false;
        }
        lk3 lk3Var = (lk3) obj;
        return this.a.equals(lk3Var.a) && this.b.equals(lk3Var.b) && n12.c(this.c, lk3Var.c) && this.d.equals(lk3Var.d) && n12.c(this.e, lk3Var.e) && n12.c(this.f, lk3Var.f);
    }

    public final int hashCode() {
        int iW = dw2.w(this.a.i.hashCode() * 31, 31, this.b.i);
        qt qtVar = this.c;
        int iHashCode = (this.d.hashCode() + ((iW + (qtVar == null ? 0 : qtVar.hashCode())) * 31)) * 31;
        List list = this.e;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        ev1 ev1Var = this.f;
        return iHashCode2 + (ev1Var != null ? ev1Var.i.hashCode() : 0);
    }

    public final String toString() {
        return "Response(requestedUrl=" + this.a + ", href=" + this.b + ", status=" + this.c + ", propstat=" + this.d + ", error=" + this.e + ", newLocation=" + this.f + ')';
    }
}
