package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ys3 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Runnable f;

    public /* synthetic */ ys3(Runnable runnable, int i) {
        this.b = i;
        this.f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Runnable runnable = this.f;
        switch (i) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return this.f.toString();
            default:
                return super.toString();
        }
    }
}
