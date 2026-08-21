package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ya4 extends va4 {
    public final Runnable z;

    public ya4(Runnable runnable, long j, boolean z) {
        super(j, z);
        this.z = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.z.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.z;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(ek0.l(runnable));
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        return fw.x(sb, this.f ? "Blocking" : "Non-blocking", ']');
    }
}
