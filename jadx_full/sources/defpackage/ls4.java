package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ls4 implements Serializable {
    public static final ls4 Y;
    public static final ls4 Z;
    public final r42 A;
    public final r42 X;
    public final r42 b;
    public final r42 f;
    public final r42 z;

    static {
        r42 r42Var = r42.b;
        r42 r42Var2 = r42.f;
        Y = new ls4(r42Var2, r42Var2, r42Var, r42Var, r42Var2);
        Z = new ls4(r42Var2, r42Var2, r42Var2, r42Var2, r42Var2);
    }

    public ls4(r42 r42Var, r42 r42Var2, r42 r42Var3, r42 r42Var4, r42 r42Var5) {
        this.b = r42Var;
        this.f = r42Var2;
        this.z = r42Var3;
        this.A = r42Var4;
        this.X = r42Var5;
    }

    public final String toString() {
        return "[Visibility: getter=" + this.b + ",isGetter=" + this.f + ",setter=" + this.z + ",creator=" + this.A + ",field=" + this.X + "]";
    }
}
