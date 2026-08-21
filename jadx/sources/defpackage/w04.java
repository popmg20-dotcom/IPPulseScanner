package defpackage;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w04 {
    public static final fz0 p = new fz0(1);
    public static final fz0 q = new fz0(2);
    public static final fz0 r = new fz0(3);
    public static final fz0 s = new fz0(4);
    public static final fz0 t = new fz0(5);
    public static final fz0 u = new fz0(0);
    public float a;
    public float b;
    public boolean c;
    public final Object d;
    public final co4 e;
    public boolean f;
    public float g;
    public float h;
    public long i;
    public float j;
    public final ArrayList k;
    public final ArrayList l;
    public x04 m;
    public float n;
    public boolean o;

    public w04(Object obj, co4 co4Var) {
        this.a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -3.4028235E38f;
        this.i = 0L;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = obj;
        this.e = co4Var;
        if (co4Var == r || co4Var == s || co4Var == t) {
            this.j = 0.1f;
        } else if (co4Var == u) {
            this.j = 0.00390625f;
        } else if (co4Var == p || co4Var == q) {
            this.j = 0.002f;
        } else {
            this.j = 1.0f;
        }
        this.m = null;
        this.n = Float.MAX_VALUE;
        this.o = false;
    }

    public final void a(float f) {
        if (this.f) {
            this.n = f;
            return;
        }
        x04 x04Var = this.m;
        if (x04Var == null) {
            x04Var = new x04(f);
            this.m = x04Var;
        }
        double d = f;
        x04Var.i = d;
        double d2 = (float) d;
        if (d2 > this.g) {
            vp1.n("Final position of the spring cannot be greater than the max value.");
            return;
        }
        if (d2 < this.h) {
            vp1.n("Final position of the spring cannot be less than the min value.");
            return;
        }
        double dAbs = Math.abs(this.j * 0.75f);
        x04Var.d = dAbs;
        x04Var.e = dAbs * 62.5d;
        if (Thread.currentThread() != ((Looper) s8.b().e.z).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z = this.f;
        if (z || z) {
            return;
        }
        this.f = true;
        if (!this.c) {
            this.b = this.e.C(this.d);
        }
        float f2 = this.b;
        if (f2 > this.g || f2 < this.h) {
            xe.k("Starting value need to be in between min value and max value");
        } else {
            s8.b().a(this);
        }
    }

    public final void b(float f) {
        if (f > 0.0f) {
            this.j = f;
        } else {
            xe.k("Minimum visible change must be positive.");
        }
    }

    public final void c(float f) {
        ArrayList arrayList;
        this.e.W(this.d, f);
        int i = 0;
        while (true) {
            arrayList = this.l;
            if (i >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i) != null) {
                sg4 sg4Var = (sg4) arrayList.get(i);
                float f2 = this.b;
                ch4 ch4Var = sg4Var.g;
                long jMax = Math.max(-1L, Math.min(ch4Var.Q0 + 1, Math.round(f2)));
                ch4Var.K(jMax, sg4Var.a);
                sg4Var.a = jMax;
            }
            i++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void d() {
        if (this.m.b <= 0.0d) {
            vp1.n("Spring animations can only come to an end when there is damping");
            return;
        }
        if (Thread.currentThread() != ((Looper) s8.b().e.z).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f) {
            this.o = true;
        }
    }

    public w04(sf1 sf1Var) {
        this.a = 0.0f;
        this.b = Float.MAX_VALUE;
        this.c = false;
        this.f = false;
        this.g = Float.MAX_VALUE;
        this.h = -3.4028235E38f;
        this.i = 0L;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.d = null;
        this.e = new gz0(sf1Var);
        this.j = 1.0f;
        this.m = null;
        this.n = Float.MAX_VALUE;
        this.o = false;
    }
}
