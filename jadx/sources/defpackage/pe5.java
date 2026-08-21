package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pe5 extends he5 {
    public boolean Y;

    public pe5(ff5 ff5Var) {
        super(ff5Var);
        this.X.I0++;
    }

    public final void W0() {
        if (this.Y) {
            return;
        }
        xe.q("Not initialized");
    }

    public final void X0() {
        if (this.Y) {
            xe.q("Can't initialize twice");
            return;
        }
        Y0();
        this.X.J0++;
        this.Y = true;
    }

    public abstract void Y0();
}
