package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class we extends te {
    public final String e;

    public we(sj4 sj4Var, nm nmVar, String str) {
        super(sj4Var, nmVar, 1);
        this.e = str;
    }

    @Override // defpackage.ak4, defpackage.zj4
    public final String b() {
        return this.e;
    }

    @Override // defpackage.te, defpackage.zj4
    public j72 c() {
        return j72.b;
    }

    @Override // defpackage.te
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public we g(nm nmVar) {
        return this.b == nmVar ? this : new we(this.a, nmVar, this.e);
    }
}
