package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class iq4 {
    public final jq4 a = new jq4();

    public final void a(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        jq4 jq4Var = this.a;
        if (jq4Var.d) {
            jq4.a(autoCloseable);
            return;
        }
        synchronized (jq4Var.a) {
            autoCloseable2 = (AutoCloseable) jq4Var.b.put(str, autoCloseable);
        }
        jq4.a(autoCloseable2);
    }

    public final void b() {
        jq4 jq4Var = this.a;
        if (!jq4Var.d) {
            jq4Var.d = true;
            synchronized (jq4Var.a) {
                try {
                    Iterator it = jq4Var.b.values().iterator();
                    while (it.hasNext()) {
                        jq4.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = jq4Var.c.iterator();
                    while (it2.hasNext()) {
                        jq4.a((AutoCloseable) it2.next());
                    }
                    jq4Var.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d();
    }

    public final AutoCloseable c(String str) {
        AutoCloseable autoCloseable;
        jq4 jq4Var = this.a;
        synchronized (jq4Var.a) {
            autoCloseable = (AutoCloseable) jq4Var.b.get(str);
        }
        return autoCloseable;
    }

    public void d() {
    }
}
