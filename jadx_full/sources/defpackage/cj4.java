package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cj4 implements ii4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ hi4 z;

    public /* synthetic */ cj4(Object obj, hi4 hi4Var, int i) {
        this.b = i;
        this.f = obj;
        this.z = hi4Var;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        int i = this.b;
        hi4 hi4Var = this.z;
        Object obj = this.f;
        switch (i) {
            case 0:
                if (bk4Var.a == ((Class) obj)) {
                    return hi4Var;
                }
                return null;
            case 1:
                Class<?> cls = bk4Var.a;
                if (((Class) obj).isAssignableFrom(cls)) {
                    return new b70(this, cls);
                }
                return null;
            default:
                if (bk4Var.equals((bk4) obj)) {
                    return hi4Var;
                }
                return null;
        }
    }

    public String toString() {
        int i = this.b;
        hi4 hi4Var = this.z;
        Object obj = this.f;
        switch (i) {
            case 0:
                return "Factory[type=" + ((Class) obj).getName() + ",adapter=" + hi4Var + "]";
            case 1:
                return "Factory[typeHierarchy=" + ((Class) obj).getName() + ",adapter=" + hi4Var + "]";
            default:
                return super.toString();
        }
    }
}
