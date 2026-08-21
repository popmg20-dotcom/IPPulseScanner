package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b61 extends ef0 {
    public static final /* synthetic */ int Y = 0;
    public boolean A;
    public ae X;
    public long z;

    public final void F0(boolean z) {
        this.z = (z ? 4294967296L : 1L) + this.z;
        if (z) {
            return;
        }
        this.A = true;
    }

    public abstract long G0();

    public final boolean H0() {
        ae aeVar = this.X;
        if (aeVar == null) {
            return false;
        }
        ov0 ov0Var = (ov0) (aeVar.isEmpty() ? null : aeVar.removeFirst());
        if (ov0Var == null) {
            return false;
        }
        ov0Var.run();
        return true;
    }

    @Override // defpackage.ef0
    public final ef0 r0(int i) {
        vf2.d(1);
        return this;
    }

    public abstract void shutdown();

    public final void x0(boolean z) {
        long j = this.z - (z ? 4294967296L : 1L);
        this.z = j;
        if (j <= 0 && this.A) {
            shutdown();
        }
    }

    public final void z0(ov0 ov0Var) {
        ae aeVar = this.X;
        if (aeVar == null) {
            aeVar = new ae();
            this.X = aeVar;
        }
        aeVar.addLast(ov0Var);
    }
}
