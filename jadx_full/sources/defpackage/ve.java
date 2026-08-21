package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ve extends ak4 {
    public final String c;

    public ve(sj4 sj4Var, nm nmVar, String str) {
        super(sj4Var, nmVar);
        this.c = str;
    }

    @Override // defpackage.zj4
    public final zj4 a(nm nmVar) {
        return this.b == nmVar ? this : new ve(this.a, nmVar, this.c);
    }

    @Override // defpackage.ak4, defpackage.zj4
    public final String b() {
        return this.c;
    }

    @Override // defpackage.zj4
    public final j72 c() {
        return j72.A;
    }
}
