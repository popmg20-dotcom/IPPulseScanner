package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hv4 extends gv4 {
    @Override // defpackage.fv4, defpackage.vo
    public final void J(boolean z) {
        this.L0.setSystemBarsAppearance(z ? 16 : 0, 16);
    }

    @Override // defpackage.fv4, defpackage.vo
    public final void K(boolean z) {
        this.L0.setSystemBarsAppearance(z ? 8 : 0, 8);
    }

    @Override // defpackage.fv4, defpackage.vo
    public final boolean y() {
        return (this.L0.getSystemBarsAppearance() & 8) != 0;
    }
}
