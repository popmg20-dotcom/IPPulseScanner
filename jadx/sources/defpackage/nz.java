package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nz implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ oz f;
    public final /* synthetic */ String z;

    public /* synthetic */ nz(oz ozVar, String str, int i) {
        this.b = i;
        this.f = ozVar;
        this.z = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        String str = this.z;
        oz ozVar = this.f;
        switch (i) {
            case 0:
                ozVar.b.onCameraAvailable(str);
                break;
            default:
                ozVar.b.onCameraUnavailable(str);
                break;
        }
    }
}
