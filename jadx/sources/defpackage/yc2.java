package defpackage;

import android.os.Looper;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yc2 {
    public static final Object k = new Object();
    public final Object a;
    public final to3 b;
    public int c;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final f33 j;

    public yc2() {
        this.a = new Object();
        this.b = new to3();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new f33(17, this);
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        ym0 ym0Var = rd.w0().z0;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        xe.q(ha0.o("Cannot invoke ", str, " on a background thread"));
    }

    public final void b(xc2 xc2Var) {
        if (xc2Var.f) {
            if (!xc2Var.d()) {
                xc2Var.a(false);
                return;
            }
            int i = xc2Var.z;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            xc2Var.z = i2;
            xc2Var.b.b(this.e);
        }
    }

    public final void c(xc2 xc2Var) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (xc2Var != null) {
                b(xc2Var);
                xc2Var = null;
            } else {
                to3 to3Var = this.b;
                ro3 ro3Var = new ro3(to3Var);
                to3Var.z.put(ro3Var, Boolean.FALSE);
                while (ro3Var.hasNext()) {
                    b((xc2) ((Map.Entry) ro3Var.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object d() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    public final void e(da2 da2Var, hu2 hu2Var) {
        Object obj;
        a("observe");
        if (da2Var.getLifecycle().b() == q92.b) {
            return;
        }
        wc2 wc2Var = new wc2(this, da2Var, hu2Var);
        to3 to3Var = this.b;
        qo3 qo3VarA = to3Var.a(hu2Var);
        if (qo3VarA != null) {
            obj = qo3VarA.f;
        } else {
            qo3 qo3Var = new qo3(hu2Var, wc2Var);
            to3Var.A++;
            qo3 qo3Var2 = to3Var.f;
            if (qo3Var2 == null) {
                to3Var.b = qo3Var;
                to3Var.f = qo3Var;
            } else {
                qo3Var2.z = qo3Var;
                qo3Var.A = qo3Var2;
                to3Var.f = qo3Var;
            }
            obj = null;
        }
        xc2 xc2Var = (xc2) obj;
        if (xc2Var != null && !xc2Var.c(da2Var)) {
            xe.k("Cannot add the same observer with different lifecycles");
        } else {
            if (xc2Var != null) {
                return;
            }
            da2Var.getLifecycle().a(wc2Var);
        }
    }

    public final void f(hu2 hu2Var) {
        Object obj;
        a("observeForever");
        vc2 vc2Var = new vc2(this, hu2Var);
        to3 to3Var = this.b;
        qo3 qo3VarA = to3Var.a(hu2Var);
        if (qo3VarA != null) {
            obj = qo3VarA.f;
        } else {
            qo3 qo3Var = new qo3(hu2Var, vc2Var);
            to3Var.A++;
            qo3 qo3Var2 = to3Var.f;
            if (qo3Var2 == null) {
                to3Var.b = qo3Var;
                to3Var.f = qo3Var;
            } else {
                qo3Var2.z = qo3Var;
                qo3Var.A = qo3Var2;
                to3Var.f = qo3Var;
            }
            obj = null;
        }
        xc2 xc2Var = (xc2) obj;
        if (xc2Var instanceof wc2) {
            xe.k("Cannot add the same observer with different lifecycles");
        } else {
            if (xc2Var != null) {
                return;
            }
            vc2Var.a(true);
        }
    }

    public void i(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = obj;
        }
        if (z) {
            rd.w0().x0(this.j);
        }
    }

    public final void j(hu2 hu2Var) {
        a("removeObserver");
        xc2 xc2Var = (xc2) this.b.b(hu2Var);
        if (xc2Var == null) {
            return;
        }
        xc2Var.b();
        xc2Var.a(false);
    }

    public final void k(da2 da2Var) {
        a("removeObservers");
        Iterator it = this.b.iterator();
        while (true) {
            po3 po3Var = (po3) it;
            if (!po3Var.hasNext()) {
                return;
            }
            Map.Entry entry = (Map.Entry) po3Var.next();
            if (((xc2) entry.getValue()).c(da2Var)) {
                j((hu2) entry.getKey());
            }
        }
    }

    public void l(Object obj) {
        a("setValue");
        this.g++;
        this.e = obj;
        c(null);
    }

    public void g() {
    }

    public void h() {
    }

    public yc2(Object obj) {
        this.a = new Object();
        this.b = new to3();
        this.c = 0;
        this.f = k;
        this.j = new f33(17, this);
        this.e = obj;
        this.g = 0;
    }
}
