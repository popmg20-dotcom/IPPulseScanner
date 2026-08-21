package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rw4 implements pl1 {
    public final /* synthetic */ int b;

    @Override // defpackage.pl1
    public final Object a() {
        switch (this.b) {
            case 0:
                return new vd3(0);
            default:
                throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
        }
    }
}
