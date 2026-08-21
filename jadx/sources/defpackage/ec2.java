package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ec2 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ hc2 f;

    public /* synthetic */ ec2(hc2 hc2Var, int i) {
        this.b = i;
        this.f = hc2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        hc2 hc2Var = this.f;
        switch (i) {
            case 0:
                jy0 jy0Var = hc2Var.z;
                if (jy0Var != null) {
                    jy0Var.setListSelectionHidden(true);
                    jy0Var.requestLayout();
                }
                break;
            default:
                jy0 jy0Var2 = hc2Var.z;
                if (jy0Var2 != null && jy0Var2.isAttachedToWindow() && hc2Var.z.getCount() > hc2Var.z.getChildCount() && hc2Var.z.getChildCount() <= hc2Var.D0) {
                    hc2Var.Q0.setInputMethodMode(2);
                    hc2Var.g();
                    break;
                }
                break;
        }
    }
}
