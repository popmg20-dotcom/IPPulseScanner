package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dj3 extends ej3 {
    public final /* synthetic */ pj2 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ byte[] d;

    public dj3(pj2 pj2Var, int i, byte[] bArr) {
        this.b = pj2Var;
        this.c = i;
        this.d = bArr;
    }

    @Override // defpackage.ej3
    public final long a() {
        return this.c;
    }

    @Override // defpackage.ej3
    public final pj2 b() {
        return this.b;
    }

    @Override // defpackage.ej3
    public final void c(bq bqVar) {
        bqVar.P(this.c, this.d);
    }
}
