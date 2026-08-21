package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vj extends ob0 {
    public int B0;
    public wj C0;

    public boolean getAllowsGoneWidget() {
        return this.C0.s0;
    }

    public int getMargin() {
        return this.C0.t0;
    }

    public int getType() {
        return this.B0;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.C0.s0 = z;
    }

    public void setDpMargin(int i) {
        this.C0.t0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.C0.t0 = i;
    }

    public void setType(int i) {
        this.B0 = i;
    }
}
