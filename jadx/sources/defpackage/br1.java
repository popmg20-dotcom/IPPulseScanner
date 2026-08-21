package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class br1 implements pk3 {
    public static final br1 A;
    public static final br1 z;
    public final /* synthetic */ int b;
    public final String f;

    static {
        int i = 0;
        z = new br1("FOLD", i);
        A = new br1("HINGE", i);
    }

    public /* synthetic */ br1(String str, int i) {
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
        ez4.X("save_rule_set", new zc1(this.f, str, 5));
    }

    public String toString() {
        int i = this.b;
        String str = this.f;
        switch (i) {
            case 0:
                return str;
            case 3:
                return fw.x(new StringBuilder("<"), str, '>');
            default:
                return super.toString();
        }
    }
}
