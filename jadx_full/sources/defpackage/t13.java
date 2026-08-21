package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t13 implements ld3, r13 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ t13(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.r13
    public final Object b(String str, am1 am1Var, ie0 ie0Var) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((z13) obj).b(str, am1Var, ie0Var);
            default:
                return ((h64) obj).b(str, am1Var, ie0Var);
        }
    }

    @Override // defpackage.ld3
    public final go3 c() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((z13) obj).a;
            default:
                return ((h64) obj).a;
        }
    }
}
