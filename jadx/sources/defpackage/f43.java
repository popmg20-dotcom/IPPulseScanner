package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f43 extends mw2 {
    public final Object b;

    public f43(Object obj) {
        this.b = obj;
    }

    @Override // defpackage.mw2
    public final Object a() {
        return this.b;
    }

    @Override // defpackage.mw2
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f43) {
            return this.b.equals(((f43) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.b + ")";
    }
}
