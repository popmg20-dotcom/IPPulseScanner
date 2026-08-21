package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mq3 implements vx1 {
    public final vx1 a;
    public final Object b = new Object();
    public boolean c;

    public mq3(vx1 vx1Var) {
        this.a = vx1Var;
    }

    public final void a() {
        synchronized (this.b) {
            try {
                if (this.c) {
                    vx1 vx1Var = this.a;
                    if (vx1Var != null) {
                        vx1Var.clear();
                    } else {
                        ez4.q("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    ez4.a0("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.c = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.b) {
        }
    }

    @Override // defpackage.vx1
    public final void clear() {
        a();
    }
}
