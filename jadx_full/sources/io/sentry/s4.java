package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s4 implements x4 {
    public final x4 a;

    public s4() {
        if (io.sentry.util.j.a || !io.sentry.util.j.b) {
            this.a = new m5(1);
        } else {
            this.a = new m5(0);
        }
    }

    @Override // io.sentry.x4
    public final w4 a() {
        return this.a.a();
    }
}
