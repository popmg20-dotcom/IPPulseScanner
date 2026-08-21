package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rb extends yi1 {
    public final /* synthetic */ yb A0;
    public final /* synthetic */ bc B0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb(bc bcVar, bc bcVar2, yb ybVar) {
        super(bcVar2);
        this.B0 = bcVar;
        this.A0 = ybVar;
    }

    @Override // defpackage.yi1
    public final wv3 b() {
        return this.A0;
    }

    @Override // defpackage.yi1
    public final boolean c() {
        bc bcVar = this.B0;
        if (bcVar.getInternalPopup().b()) {
            return true;
        }
        bcVar.z0.n(bcVar.getTextDirection(), bcVar.getTextAlignment());
        return true;
    }
}
