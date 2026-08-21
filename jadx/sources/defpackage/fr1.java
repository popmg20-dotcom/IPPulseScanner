package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class fr1 {
    public final int a;
    public fr1 b;
    public final fr1 c;
    public final fr1 d;
    public Object e;

    public fr1(int i, fr1 fr1Var, Object obj, fr1 fr1Var2) {
        this.a = i;
        this.b = fr1Var;
        this.e = obj;
        this.d = fr1Var2;
        fr1 fr1Var3 = fr1Var2.c;
        this.c = fr1Var3;
        fr1Var3.d = this;
        fr1Var2.c = this;
    }

    public fr1() {
        this.a = 0;
        this.d = this;
        this.c = this;
    }
}
