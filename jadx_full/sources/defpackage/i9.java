package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class i9 extends c9 {
    public final cp1[] D0;

    public i9(yj4 yj4Var, cp1 cp1Var, cp1[] cp1VarArr) {
        super(yj4Var, cp1Var);
        this.D0 = cp1VarArr;
    }

    public final h9 U(int i) {
        nj4 nj4VarW = W(i);
        cp1[] cp1VarArr = this.D0;
        return new h9(this, nj4VarW, this.B0, (cp1VarArr == null || i < 0 || i >= cp1VarArr.length) ? null : cp1VarArr[i], i);
    }

    public abstract int V();

    public abstract nj4 W(int i);

    public abstract Class X(int i);
}
