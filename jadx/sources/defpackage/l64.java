package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l64 implements io3 {
    public final gl1 b;
    public final String f;
    public boolean z;

    public l64(gl1 gl1Var, String str) {
        this.b = gl1Var;
        this.f = str;
    }

    @Override // defpackage.io3
    public final boolean L() {
        return getLong(0) != 0;
    }

    public final void g() {
        if (this.z) {
            ez4.Y(21, "statement is closed");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final int v0() {
        return (int) getLong(0);
    }
}
