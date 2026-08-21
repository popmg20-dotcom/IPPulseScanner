package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kz3 {
    public final ax3 a;
    public vm1 b;

    public kz3(ax3 ax3Var, vm1 vm1Var) {
        vm1Var.getClass();
        this.a = ax3Var;
        this.b = vm1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kz3)) {
            return false;
        }
        kz3 kz3Var = (kz3) obj;
        return this.a == kz3Var.a && this.b == kz3Var.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "SortedCompletionItem(completionItem=" + this.a + ", score=" + this.b + ")";
    }
}
