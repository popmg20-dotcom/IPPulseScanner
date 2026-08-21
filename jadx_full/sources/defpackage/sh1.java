package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sh1 implements pk3 {
    public static final sh1 A;
    public static final sh1 z;
    public final /* synthetic */ int b;
    public final String f;

    static {
        int i = 0;
        z = new sh1("VERTICAL", i);
        A = new sh1("HORIZONTAL", i);
    }

    public /* synthetic */ sh1(String str, int i) {
        this.b = i;
        this.f = str;
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        String str = (String) obj;
        str.getClass();
        ez4.X("save_domain_set", new zc1(this.f, str, 1));
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return this.f;
            default:
                return super.toString();
        }
    }
}
