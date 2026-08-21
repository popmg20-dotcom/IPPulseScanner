package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class d61 extends e61 {
    public final Runnable z;

    public d61(Runnable runnable, long j) {
        super(j);
        this.z = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.z.run();
    }

    @Override // defpackage.e61
    public final String toString() {
        return super.toString() + this.z;
    }
}
