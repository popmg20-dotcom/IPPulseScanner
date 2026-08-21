package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class u55 extends z45 {
    public boolean X;

    public u55(k85 k85Var) {
        super(k85Var);
        ((k85) this.f).R0++;
    }

    public final void W0() {
        if (this.X) {
            return;
        }
        xe.q("Not initialized");
    }

    public final void X0() {
        if (this.X) {
            xe.q("Can't initialize twice");
        } else {
            if (Y0()) {
                return;
            }
            ((k85) this.f).T0.incrementAndGet();
            this.X = true;
        }
    }

    public abstract boolean Y0();
}
