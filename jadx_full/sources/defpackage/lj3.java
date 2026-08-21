package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lj3 {
    public long a;
    public int b;

    public synchronized long a(int i) {
        if (i != 429 && (i < 500 || i >= 600)) {
            return 86400000L;
        }
        return (long) Math.min(Math.pow(2.0d, this.b) + ((long) (Math.random() * 1000.0d)), 1800000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean b() {
        boolean z;
        if (this.b != 0) {
            z = System.currentTimeMillis() > this.a;
        }
        return z;
    }

    public synchronized void c() {
        this.b = 0;
    }

    public synchronized void d(int i) {
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            c();
            return;
        }
        this.b++;
        this.a = System.currentTimeMillis() + a(i);
    }
}
