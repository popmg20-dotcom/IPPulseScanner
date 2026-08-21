package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zz implements dl3 {
    public final /* synthetic */ int b;
    public final dl3 c;

    public zz(long j, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.c = new ie4(j, new yz(j));
                break;
            default:
                this.c = new zz(j, 1);
                break;
        }
    }

    @Override // defpackage.dl3
    public final long a() {
        int i = this.b;
        dl3 dl3Var = this.c;
        switch (i) {
            case 0:
                return ((ie4) ((zz) dl3Var).c).b;
            default:
                return ((ie4) dl3Var).b;
        }
    }

    @Override // defpackage.dl3
    public final cl3 b(xz xzVar) {
        int i = this.b;
        dl3 dl3Var = this.c;
        switch (i) {
            case 0:
                if (((ie4) ((zz) dl3Var).c).b(xzVar).b) {
                    return cl3.e;
                }
                Throwable th = xzVar.c;
                if (th instanceof k00) {
                    ez4.q("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                    if (((k00) th).b > 0) {
                        return cl3.f;
                    }
                }
                return cl3.d;
            default:
                return ((ie4) dl3Var).b(xzVar);
        }
    }
}
