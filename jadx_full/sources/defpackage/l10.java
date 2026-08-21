package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l10 implements wv {
    public final /* synthetic */ o10 b;

    public /* synthetic */ l10(o10 o10Var) {
        this.b = o10Var;
    }

    public void a() {
        o10 o10Var = this.b;
        synchronized (o10Var.a) {
            try {
                if (o10Var.j == 8) {
                    o10Var.m(o10Var.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.wv
    public Object n(vv vvVar) {
        String str;
        o10 o10Var = this.b;
        synchronized (o10Var.a) {
            r25.j("Release completer expected to be null", o10Var.l == null);
            o10Var.l = vvVar;
            str = "Release[session=" + o10Var + "]";
        }
        return str;
    }
}
