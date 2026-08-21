package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q80 implements ge0 {
    public static final q80 f = new q80(0);
    public static final q80 z = new q80(1);
    public final /* synthetic */ int b;

    public /* synthetic */ q80(int i) {
        this.b = i;
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        switch (this.b) {
            case 0:
                throw new IllegalStateException("This continuation is already complete");
            default:
                return;
        }
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        switch (this.b) {
            case 0:
                throw new IllegalStateException("This continuation is already complete");
            default:
                return c41.b;
        }
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return "This continuation is already complete";
            default:
                return super.toString();
        }
    }

    private final void a(Object obj) {
    }
}
