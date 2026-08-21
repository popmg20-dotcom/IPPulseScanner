package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vt2 {
    public static final vt2 f = new vt2(p83.X, Object.class, null, false, null);
    public final p83 a;
    public final Class b;
    public final Class c;
    public final Class d;
    public final boolean e;

    public vt2(p83 p83Var, Class cls, Class cls2, boolean z, Class cls3) {
        this.a = p83Var;
        this.d = cls;
        this.b = cls2;
        this.e = z;
        this.c = cls3 == null ? fx3.class : cls3;
    }

    public final String toString() {
        return "ObjectIdInfo: propName=" + this.a + ", scope=" + n50.t(this.d) + ", generatorType=" + n50.t(this.b) + ", alwaysAsId=" + this.e;
    }
}
