package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pc0 extends qc0 {
    public final int a;

    public pc0(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof pc0) && this.a == ((pc0) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return ha0.p(new StringBuilder("ConstraintsNotMet(reason="), this.a, ')');
    }
}
