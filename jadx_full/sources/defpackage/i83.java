package defpackage;

import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i83 {
    public static final k83 c = new k83("DAV:", "propstat");
    public static final qt d;
    public static final qt e;
    public final LinkedList a;
    public final qt b;

    static {
        int i = 13;
        ba3 ba3Var = ba3.HTTP_1_1;
        d = new qt(200, i, ba3Var, "Assuming OK");
        e = new qt(500, i, ba3Var, "Invalid status line");
    }

    public i83(LinkedList linkedList, qt qtVar) {
        qtVar.getClass();
        this.a = linkedList;
        this.b = qtVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i83)) {
            return false;
        }
        i83 i83Var = (i83) obj;
        return this.a.equals(i83Var.a) && n12.c(this.b, i83Var.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
    }

    public final String toString() {
        return "PropStat(properties=" + this.a + ", status=" + this.b + ", error=null)";
    }
}
