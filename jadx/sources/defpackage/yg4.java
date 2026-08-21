package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yg4 extends xg4 {
    public final /* synthetic */ ie a;
    public final /* synthetic */ zg4 b;

    public yg4(zg4 zg4Var, ie ieVar) {
        this.b = zg4Var;
        this.a = ieVar;
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void c(vg4 vg4Var) {
        ((ArrayList) this.a.get(this.b.f)).remove(vg4Var);
        vg4Var.E(this);
    }
}
