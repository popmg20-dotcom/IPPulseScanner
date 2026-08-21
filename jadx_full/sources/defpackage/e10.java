package defpackage;

import android.content.Context;
import android.util.ArrayMap;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e10 implements oy1 {
    public Object A;
    public Object X;
    public Object Y;
    public Object Z;
    public int b;
    public boolean f;
    public Object z;

    public e10(f10 f10Var) {
        HashSet hashSet = new HashSet();
        this.z = hashSet;
        this.A = qn2.c();
        this.b = -1;
        ArrayList arrayList = new ArrayList();
        this.X = arrayList;
        this.f = false;
        this.Y = vn2.a();
        hashSet.addAll(f10Var.a);
        this.A = qn2.d(f10Var.b);
        this.b = f10Var.c;
        arrayList.addAll(f10Var.d);
        this.f = f10Var.e;
        pa4 pa4Var = f10Var.f;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = pa4Var.a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        this.Y = new vn2(arrayMap);
    }

    public void a(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b((yx) it.next());
        }
    }

    public void b(yx yxVar) {
        ArrayList arrayList = (ArrayList) this.X;
        if (arrayList.contains(yxVar)) {
            return;
        }
        arrayList.add(yxVar);
    }

    @Override // defpackage.oy1
    public int c() {
        int iC;
        synchronized (this.z) {
            iC = ((oy1) this.A).c();
        }
        return iC;
    }

    @Override // defpackage.oy1
    public void close() {
        synchronized (this.z) {
            try {
                Surface surface = (Surface) this.X;
                if (surface != null) {
                    surface.release();
                }
                ((oy1) this.A).close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(ka0 ka0Var) {
        for (pg pgVar : ka0Var.t()) {
            ((qn2) this.A).p(pgVar, null);
            ((qn2) this.A).f(pgVar, ka0Var.S(pgVar), ka0Var.u(pgVar));
        }
    }

    public f10 e() {
        ArrayList arrayList = new ArrayList((HashSet) this.z);
        sw2 sw2VarA = sw2.a((qn2) this.A);
        int i = this.b;
        ArrayList arrayList2 = new ArrayList((ArrayList) this.X);
        boolean z = this.f;
        vn2 vn2Var = (vn2) this.Y;
        pa4 pa4Var = pa4.b;
        ArrayMap arrayMap = new ArrayMap();
        for (String str : vn2Var.a.keySet()) {
            arrayMap.put(str, vn2Var.a.get(str));
        }
        return new f10(arrayList, sw2VarA, i, arrayList2, z, new pa4(arrayMap), (fy) this.Z);
    }

    @Override // defpackage.oy1
    public int f() {
        int iF;
        synchronized (this.z) {
            iF = ((oy1) this.A).f();
        }
        return iF;
    }

    public void g(ry1 ry1Var, g51 g51Var) {
        Context context = ry1Var.a;
        ry1 ry1Var2 = (ry1) this.z;
        if (context != ry1Var2.a) {
            ad0.j("Interceptor '", g51Var, "' cannot modify the request's context.");
            return;
        }
        if (ry1Var.b == d7.y0) {
            ad0.j("Interceptor '", g51Var, "' cannot set the request's data to null.");
            return;
        }
        if (ry1Var.c != ry1Var2.c) {
            ad0.j("Interceptor '", g51Var, "' cannot modify the request's target.");
        } else if (ry1Var.r != ry1Var2.r) {
            ad0.j("Interceptor '", g51Var, "' cannot modify the request's lifecycle.");
        } else {
            if (ry1Var.s == ry1Var2.s) {
                return;
            }
            ad0.j("Interceptor '", g51Var, "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.");
        }
    }

    @Override // defpackage.oy1
    public Surface getSurface() {
        Surface surface;
        synchronized (this.z) {
            surface = ((oy1) this.A).getSurface();
        }
        return surface;
    }

    public boolean h() {
        return this.b < ((List) this.Y).size() || !((ArrayList) this.X).isEmpty();
    }

    @Override // defpackage.oy1
    public my1 i() {
        rx1 rx1Var;
        synchronized (this.z) {
            my1 my1VarI = ((oy1) this.A).i();
            if (my1VarI != null) {
                this.b++;
                rx1Var = new rx1(my1VarI);
                rx1Var.g((qx1) this.Z);
            } else {
                rx1Var = null;
            }
        }
        return rx1Var;
    }

    @Override // defpackage.oy1
    public int j() {
        int iJ;
        synchronized (this.z) {
            iJ = ((oy1) this.A).j();
        }
        return iJ;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object k(ry1 ry1Var, ie0 ie0Var) {
        ue3 ue3Var;
        ry1 ry1Var2;
        g51 g51Var;
        Object objD;
        e10 e10Var = this;
        List list = (List) e10Var.A;
        int i = e10Var.b;
        if (ie0Var instanceof ue3) {
            ue3Var = (ue3) ie0Var;
            int i2 = ue3Var.y0;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ue3Var.y0 = i2 - Integer.MIN_VALUE;
            } else {
                ue3Var = new ue3(e10Var, ie0Var);
            }
        }
        Object obj = ue3Var.Y;
        int i3 = ue3Var.y0;
        if (i3 == 0) {
            n12.S(obj);
            if (i > 0) {
                ry1Var2 = ry1Var;
                e10Var.g(ry1Var2, (g51) list.get(i - 1));
            } else {
                ry1Var2 = ry1Var;
            }
            g51Var = (g51) list.get(i);
            e10 e10Var2 = new e10((ry1) e10Var.z, (List) e10Var.A, i + 1, ry1Var2, (wx3) e10Var.Y, (z51) e10Var.Z, e10Var.f);
            ue3Var.A = e10Var;
            ue3Var.X = g51Var;
            ue3Var.y0 = 1;
            objD = g51Var.d(e10Var2, ue3Var);
            mf0 mf0Var = mf0.b;
            if (objD == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i3 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            g51 g51Var2 = ue3Var.X;
            e10 e10Var3 = ue3Var.A;
            n12.S(obj);
            g51Var = g51Var2;
            e10Var = e10Var3;
            objD = obj;
        }
        sy1 sy1Var = (sy1) objD;
        e10Var.g(sy1Var.b(), g51Var);
        return sy1Var;
    }

    @Override // defpackage.oy1
    public void l() {
        synchronized (this.z) {
            ((oy1) this.A).l();
        }
    }

    public void m() {
        synchronized (this.z) {
            try {
                this.f = true;
                ((oy1) this.A).l();
                if (this.b == 0) {
                    close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.oy1
    public void p(ny1 ny1Var, Executor executor) {
        synchronized (this.z) {
            ((oy1) this.A).p(new ed(15, this, ny1Var), executor);
        }
    }

    @Override // defpackage.oy1
    public int s() {
        int iS;
        synchronized (this.z) {
            iS = ((oy1) this.A).s();
        }
        return iS;
    }

    @Override // defpackage.oy1
    public my1 t() {
        rx1 rx1Var;
        synchronized (this.z) {
            my1 my1VarT = ((oy1) this.A).t();
            if (my1VarT != null) {
                this.b++;
                rx1Var = new rx1(my1VarT);
                rx1Var.g((qx1) this.Z);
            } else {
                rx1Var = null;
            }
        }
        return rx1Var;
    }

    public e10(oy1 oy1Var) {
        this.z = new Object();
        this.b = 0;
        this.f = false;
        this.Z = new qx1(1, this);
        this.A = oy1Var;
        this.X = oy1Var.getSurface();
    }

    public e10(Object obj, g72 g72Var) {
        this.z = obj;
        this.X = null;
        this.Z = g72Var;
    }

    public e10() {
        this.z = new HashSet();
        this.A = qn2.c();
        this.b = -1;
        this.X = new ArrayList();
        this.f = false;
        this.Y = vn2.a();
    }

    public e10(ry1 ry1Var, List list, int i, ry1 ry1Var2, wx3 wx3Var, z51 z51Var, boolean z) {
        this.z = ry1Var;
        this.A = list;
        this.b = i;
        this.X = ry1Var2;
        this.Y = wx3Var;
        this.Z = z51Var;
        this.f = z;
    }
}
