package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q55 {
    public static final Object f = new Object();
    public final String a;
    public final c35 b;
    public final Object c;
    public final Object d = new Object();
    public volatile Object e = null;

    public /* synthetic */ q55(String str, Object obj, c35 c35Var) {
        this.a = str;
        this.c = obj;
        this.b = c35Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Object obj) {
        c35 c35Var;
        synchronized (this.d) {
        }
        if (obj != null) {
            return obj;
        }
        if (p95.m == null) {
            return this.c;
        }
        synchronized (f) {
            try {
                if (d84.j()) {
                    return this.e == null ? this.c : this.e;
                }
                try {
                } catch (SecurityException unused) {
                }
                for (q55 q55Var : r55.a) {
                    if (d84.j()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    Object objA = null;
                    try {
                        c35 c35Var2 = q55Var.b;
                        if (c35Var2 != null) {
                            objA = c35Var2.a();
                        }
                    } catch (IllegalStateException unused2) {
                    }
                    synchronized (f) {
                        q55Var.e = objA;
                    }
                    c35Var = this.b;
                    if (c35Var != null) {
                        try {
                            return c35Var.a();
                        } catch (IllegalStateException | SecurityException unused3) {
                        }
                    }
                    return this.c;
                }
                c35Var = this.b;
                if (c35Var != null) {
                }
                return this.c;
            } finally {
            }
        }
    }
}
