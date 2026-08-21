package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gy implements cy1 {
    public final fy a;

    public gy(fy fyVar) {
        this.a = fyVar;
    }

    @Override // defpackage.cy1
    public final pa4 a() {
        return this.a.a();
    }

    @Override // defpackage.cy1
    public final int b() {
        int iG = fw.G(this.a.b());
        if (iG == 1) {
            return 2;
        }
        if (iG != 2) {
            return iG != 3 ? 0 : 1;
        }
        return 3;
    }

    @Override // defpackage.cy1
    public final long c() {
        return this.a.c();
    }

    @Override // defpackage.cy1
    public final int d() {
        return 0;
    }
}
