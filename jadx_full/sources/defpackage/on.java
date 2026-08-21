package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class on {
    public final int[] a;
    public int b = 0;
    public int c;
    public on d;
    public final /* synthetic */ qn e;

    public on(qn qnVar) {
        this.e = qnVar;
        this.a = new int[qnVar.b + 5];
    }

    public final void a() {
        int iMax = 0;
        for (int i = 0; i < this.b; i++) {
            iMax = Math.max(iMax, this.a[i]);
        }
        this.c = iMax;
    }
}
