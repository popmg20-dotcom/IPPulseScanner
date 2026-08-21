package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xv extends x1 {
    public final /* synthetic */ yv y0;

    public xv(yv yvVar) {
        this.y0 = yvVar;
    }

    @Override // defpackage.x1
    public final String h() {
        vv vvVar = (vv) this.y0.b.get();
        if (vvVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + vvVar.a + "]";
    }
}
