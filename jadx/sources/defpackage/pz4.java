package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pz4 implements ci {
    public final /* synthetic */ tp1 a;

    public pz4(tp1 tp1Var) {
        this.a = tp1Var;
    }

    @Override // defpackage.ci
    public final void a(boolean z) {
        s05 s05Var = this.a.m;
        s05Var.sendMessage(s05Var.obtainMessage(1, Boolean.valueOf(z)));
    }
}
