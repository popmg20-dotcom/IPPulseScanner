package j$.time.temporal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements n {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ o(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    @Override // j$.time.temporal.n
    public final m k(m mVar) {
        int i = this.a;
        int i2 = this.b;
        switch (i) {
            case 0:
                int iH = mVar.h(a.DAY_OF_WEEK);
                if (iH == i2) {
                    return mVar;
                }
                return mVar.d(iH - i2 >= 0 ? 7 - r0 : -r0, b.DAYS);
            default:
                int iH2 = mVar.h(a.DAY_OF_WEEK);
                if (iH2 == i2) {
                    return mVar;
                }
                return mVar.p(i2 - iH2 >= 0 ? 7 - r2 : -r2, b.DAYS);
        }
    }
}
