package io.sentry.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final e b;
    public volatile Object a = null;
    public final a c = new a();

    public f(e eVar) {
        this.b = eVar;
    }

    public final Object a() {
        if (this.a == null) {
            a aVar = this.c;
            aVar.g();
            try {
                if (this.a == null) {
                    this.a = this.b.e();
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return this.a;
    }

    public final void b(Object obj) {
        a aVar = this.c;
        aVar.g();
        try {
            this.a = obj;
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
