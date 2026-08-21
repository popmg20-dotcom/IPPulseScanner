package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iw0 extends kw0 {
    public final hw0 d;
    public final boolean e;

    public iw0(int i, int i2, hw0 hw0Var, boolean z) {
        super(i, i2);
        this.d = hw0Var;
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iw0)) {
            return false;
        }
        iw0 iw0Var = (iw0) obj;
        return this.a == iw0Var.a && this.b == iw0Var.b && this.d.equals(iw0Var.d) && this.e == iw0Var.e;
    }

    public final int hashCode() {
        return ((this.d.hashCode() + (((this.a * 31) + this.b) * 31)) * 31) + (this.e ? 1231 : 1237);
    }

    @Override // defpackage.kw0
    public final String toString() {
        return iw0.class.getSimpleName() + "{width=" + this.a + ", color=" + this.b + ", primaryContainerDragRange=" + this.d + ", isDraggingToFullscreenAllowed=" + this.e + '}';
    }
}
