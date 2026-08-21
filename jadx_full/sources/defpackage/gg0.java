package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gg0 implements qg4 {
    public final int b;

    public gg0(int i) {
        this.b = i;
        if (i > 0) {
            return;
        }
        xe.k("durationMillis must be > 0.");
        throw null;
    }

    @Override // defpackage.qg4
    public final ug4 a(ty1 ty1Var, sy1 sy1Var) {
        return !(sy1Var instanceof l54) ? new ms2(ty1Var, sy1Var) : ((l54) sy1Var).c == pi0.b ? new ms2(ty1Var, sy1Var) : new qt(ty1Var, sy1Var, this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gg0) {
            return this.b == ((gg0) obj).b;
        }
        return false;
    }

    public final int hashCode() {
        return (this.b * 31) + 1237;
    }
}
