package defpackage;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.divider.MaterialDivider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j80 {
    public static final yz2 i = new yz2();
    public final Object a;
    public Object b;
    public Object c;
    public final Object d;
    public Object e;
    public Object f;
    public final Object g;
    public Object h;

    public j80(Class cls, Class cls2, String str) {
        this.a = yn1.y(cls, ha0.o("get", str, "List"), new Class[0]);
        this.b = yn1.y(cls2, ha0.o("get", str, "List"), new Class[0]);
        String strN = ha0.n("get", str);
        Class cls3 = Integer.TYPE;
        Method methodY = yn1.y(cls, strN, cls3);
        this.c = methodY;
        this.d = yn1.y(cls2, ha0.n("get", str), cls3);
        Class<?> returnType = methodY.getReturnType();
        yn1.y(cls2, ha0.n("set", str), cls3, returnType);
        this.e = yn1.y(cls2, ha0.n("add", str), returnType);
        this.f = yn1.y(cls, ha0.o("get", str, "Count"), new Class[0]);
        this.g = yn1.y(cls2, ha0.o("get", str, "Count"), new Class[0]);
        this.h = yn1.y(cls2, ha0.n("clear", str), new Class[0]);
    }

    public static s92 a(j80 j80Var, da2 da2Var, b00 b00Var, r90 r90Var) {
        s92 s92VarH;
        lb lbVar = lb.X;
        Trace.beginSection(vo.O("CX:bindToLifecycle-internal"));
        try {
            co4.h();
            n00 n00Var = (n00) j80Var.e;
            n00Var.getClass();
            mz mzVarC = b00Var.c(n00Var.a.c());
            mzVarC.getClass();
            mzVarC.q(true);
            h5 h5VarC = j80Var.c(b00Var);
            vg vgVar = (vg) ((zf2) h5VarC.c).f;
            String strD = h5VarC.a.d();
            strD.getClass();
            jz jzVar = new jz(e70.L(strD), vgVar);
            v92 v92Var = (v92) j80Var.d;
            synchronized (v92Var.b) {
                s92VarH = (s92) ((HashMap) v92Var.f).get(new ah(System.identityHashCode(da2Var), jzVar));
            }
            Collection collectionJ = ((v92) j80Var.d).j();
            for (in4 in4Var : (List) r90Var.e) {
                for (Object obj : collectionJ) {
                    obj.getClass();
                    s92 s92Var = (s92) obj;
                    if (s92Var.u(in4Var) && !s92Var.j().equals(da2Var)) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{in4Var}, 1)));
                    }
                }
            }
            if (s92VarH == null) {
                v92 v92Var2 = (v92) j80Var.d;
                n00 n00Var2 = (n00) j80Var.e;
                n00Var2.getClass();
                iv1 iv1Var = n00Var2.k;
                if (iv1Var == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                s92VarH = v92Var2.h(da2Var, new j00(mzVarC, null, h5VarC, null, lbVar, lbVar, (ow) iv1Var.z, (e24) iv1Var.X, (pn4) iv1Var.A));
            }
            if (!((List) r90Var.e).isEmpty()) {
                v92 v92Var3 = (v92) j80Var.d;
                n00 n00Var3 = (n00) j80Var.e;
                n00Var3.getClass();
                rw rwVar = n00Var3.g;
                if (rwVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                v92Var3.d(s92VarH, r90Var, rwVar.b);
                ((HashSet) j80Var.h).add(new ah(System.identityHashCode(da2Var), jzVar));
            }
            return s92VarH;
        } finally {
            Trace.endSection();
        }
    }

    public zf2 b(b00 b00Var) {
        Iterator it = b00Var.a.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            vg vgVar = k92.b;
            if (!n12.c(vgVar, vgVar)) {
                synchronized (b91.a) {
                }
                ((Context) this.f).getClass();
            }
        }
        return wy.a;
    }

    public h5 c(b00 b00Var) {
        Object h5Var;
        Trace.beginSection(vo.O("CX:getCameraInfo"));
        try {
            n00 n00Var = (n00) this.e;
            n00Var.getClass();
            kz kzVarR = b00Var.c(n00Var.a.c()).r();
            kzVarR.getClass();
            zf2 zf2VarB = b(b00Var);
            String strD = kzVarR.d();
            strD.getClass();
            jz jzVar = new jz(e70.L(strD), (vg) zf2VarB.f);
            synchronized (this.a) {
                h5Var = ((HashMap) this.g).get(jzVar);
                if (h5Var == null) {
                    h5Var = new h5(kzVarR, zf2VarB);
                    ((HashMap) this.g).put(jzVar, h5Var);
                }
            }
            return (h5) h5Var;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
    
        if (r9 == r6) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(wz2 wz2Var, ie0 ie0Var) {
        g80 g80Var;
        pl3 pl3Var = (pl3) this.d;
        if (ie0Var instanceof g80) {
            g80Var = (g80) ie0Var;
            int i2 = g80Var.Y;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                g80Var.Y = i2 - Integer.MIN_VALUE;
            } else {
                g80Var = new g80(this, ie0Var);
            }
        }
        Object objE = g80Var.A;
        int i3 = g80Var.Y;
        ge0 ge0Var = null;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    n12.S(objE);
                    return (a03) objE;
                }
                if (i3 == 2) {
                    n12.S(objE);
                    return (a03) objE;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objE);
            int i4 = 0;
            if (((AtomicBoolean) this.g).compareAndSet(false, true)) {
                this.h = ji0.B(pl3Var.f(), null, null, new h80(this, ge0Var, i4), 3);
            }
            int i5 = ((AtomicInteger) this.f).get();
            Object obj = mf0.b;
            if (i5 == -1) {
                g80Var.Y = 1;
                objE = ji0.b0(((ce0) pl3Var.f()).b, new w53(pl3Var, new uf(this, wz2Var, ge0Var, 4), ge0Var, 7), g80Var);
                if (objE == obj) {
                }
                return (a03) objE;
            }
            g80Var.Y = 2;
            objE = e(wz2Var, i5, g80Var);
            return obj;
        } catch (Exception e) {
            return new xz2(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object e(wz2 wz2Var, int i2, ie0 ie0Var) {
        i80 i80Var;
        j80 j80Var;
        a03 a03Var;
        if (ie0Var instanceof i80) {
            i80Var = (i80) ie0Var;
            int i3 = i80Var.y0;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                i80Var.y0 = i3 - Integer.MIN_VALUE;
            } else {
                i80Var = new i80(this, ie0Var);
            }
        }
        Object objJ = i80Var.Y;
        int i4 = i80Var.y0;
        ge0 ge0Var = null;
        int i5 = 1;
        mf0 mf0Var = mf0.b;
        if (i4 == 0) {
            n12.S(objJ);
            sl3 sl3Var = (sl3) this.e;
            sp spVar = (sp) this.c;
            i80Var.A = this;
            i80Var.y0 = 1;
            objJ = uf2.J(wz2Var, sl3Var, i2, spVar, i80Var);
            if (objJ != mf0Var) {
            }
            return mf0Var;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a03Var = i80Var.X;
            j80Var = i80Var.A;
            n12.S(objJ);
            return !((hj3) j80Var.b).a.f ? i : a03Var;
        }
        this = i80Var.A;
        n12.S(objJ);
        a03 a03Var2 = (a03) objJ;
        cf0 cf0Var = ((ce0) ((pl3) this.d).f()).b;
        h80 h80Var = new h80(this, ge0Var, i5);
        i80Var.A = this;
        i80Var.X = a03Var2;
        i80Var.y0 = 2;
        if (ji0.b0(cf0Var, h80Var, i80Var) != mf0Var) {
            j80Var = this;
            a03Var = a03Var2;
            if (!((hj3) j80Var.b).a.f) {
            }
        }
        return mf0Var;
    }

    public void f(int i2) {
        n00 n00Var = (n00) this.e;
        if (n00Var == null) {
            return;
        }
        rw rwVar = n00Var.g;
        if (rwVar == null) {
            xe.q("CameraX not initialized yet.");
            return;
        }
        ow owVar = rwVar.b;
        synchronized (owVar.a) {
            try {
                int i3 = owVar.g;
                if (i2 == i3) {
                    return;
                }
                owVar.g = i2;
                ArrayList arrayList = new ArrayList(owVar.c);
                if (i3 == 2 && i2 != 2) {
                    owVar.f.clear();
                }
                ow.d(arrayList, i3, i2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g() {
        Trace.beginSection(vo.O("CX:unbindAll"));
        try {
            co4.h();
            f(0);
            ((v92) this.d).s((HashSet) this.h);
        } finally {
            Trace.endSection();
        }
    }

    public j80(String[] strArr, hj3 hj3Var, sp spVar) {
        this.a = strArr;
        this.b = hj3Var;
        this.c = spVar;
        this.d = hj3Var.c;
        this.e = hj3Var.b;
        this.f = new AtomicInteger(-1);
        this.g = new AtomicBoolean(false);
        hj3Var.b(new fn(1, this));
    }

    public j80() {
        v92 v92Var;
        this.a = new Object();
        this.c = zy1.z;
        synchronized (v92.Y) {
            try {
                v92Var = v92.Z;
                if (v92Var == null) {
                    v92Var = new v92(0);
                    v92.Z = v92Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.d = v92Var;
        this.g = new HashMap();
        this.h = new HashSet();
    }

    public /* synthetic */ j80(View view, View view2, Object obj, View view3, View view4, View view5, Toolbar toolbar, MaterialDivider materialDivider) {
        this.a = view;
        this.b = view2;
        this.c = obj;
        this.d = view3;
        this.e = view4;
        this.f = view5;
        this.g = toolbar;
        this.h = materialDivider;
    }
}
