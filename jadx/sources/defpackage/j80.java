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
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(defpackage.wz2 r8, defpackage.ie0 r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.d
            pl3 r0 = (defpackage.pl3) r0
            boolean r1 = r9 instanceof defpackage.g80
            if (r1 == 0) goto L17
            r1 = r9
            g80 r1 = (defpackage.g80) r1
            int r2 = r1.Y
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.Y = r2
            goto L1c
        L17:
            g80 r1 = new g80
            r1.<init>(r7, r9)
        L1c:
            java.lang.Object r9 = r1.A
            int r2 = r1.Y
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L37
            if (r2 == r5) goto L33
            if (r2 != r4) goto L2d
            defpackage.n12.S(r9)     // Catch: java.lang.Exception -> L8e
            goto L8b
        L2d:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            return r3
        L33:
            defpackage.n12.S(r9)     // Catch: java.lang.Exception -> L8e
            goto L7f
        L37:
            defpackage.n12.S(r9)
            java.lang.Object r9 = r7.g
            java.util.concurrent.atomic.AtomicBoolean r9 = (java.util.concurrent.atomic.AtomicBoolean) r9
            r2 = 0
            boolean r9 = r9.compareAndSet(r2, r5)
            if (r9 == 0) goto L55
            lf0 r9 = r0.f()
            h80 r6 = new h80
            r6.<init>(r7, r3, r2)
            r2 = 3
            z14 r9 = defpackage.ji0.B(r9, r3, r3, r6, r2)
            r7.h = r9
        L55:
            java.lang.Object r9 = r7.f
            java.util.concurrent.atomic.AtomicInteger r9 = (java.util.concurrent.atomic.AtomicInteger) r9
            int r9 = r9.get()
            r2 = -1
            mf0 r6 = defpackage.mf0.b
            if (r9 != r2) goto L82
            r1.Y = r5     // Catch: java.lang.Exception -> L8e
            uf r9 = new uf     // Catch: java.lang.Exception -> L8e
            r2 = 4
            r9.<init>(r7, r8, r3, r2)     // Catch: java.lang.Exception -> L8e
            lf0 r7 = r0.f()     // Catch: java.lang.Exception -> L8e
            ce0 r7 = (defpackage.ce0) r7     // Catch: java.lang.Exception -> L8e
            cf0 r7 = r7.b     // Catch: java.lang.Exception -> L8e
            w53 r8 = new w53     // Catch: java.lang.Exception -> L8e
            r2 = 7
            r8.<init>(r0, r9, r3, r2)     // Catch: java.lang.Exception -> L8e
            java.lang.Object r9 = defpackage.ji0.b0(r7, r8, r1)     // Catch: java.lang.Exception -> L8e
            if (r9 != r6) goto L7f
            goto L8a
        L7f:
            a03 r9 = (defpackage.a03) r9     // Catch: java.lang.Exception -> L8e
            return r9
        L82:
            r1.Y = r4     // Catch: java.lang.Exception -> L8e
            java.lang.Object r9 = r7.e(r8, r9, r1)     // Catch: java.lang.Exception -> L8e
            if (r9 != r6) goto L8b
        L8a:
            return r6
        L8b:
            a03 r9 = (defpackage.a03) r9     // Catch: java.lang.Exception -> L8e
            return r9
        L8e:
            r7 = move-exception
            xz2 r8 = new xz2
            r8.<init>(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j80.d(wz2, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(defpackage.wz2 r8, int r9, defpackage.ie0 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof defpackage.i80
            if (r0 == 0) goto L13
            r0 = r10
            i80 r0 = (defpackage.i80) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            i80 r0 = new i80
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.Y
            int r1 = r0.y0
            r2 = 0
            r3 = 2
            r4 = 1
            mf0 r5 = defpackage.mf0.b
            if (r1 == 0) goto L3b
            if (r1 == r4) goto L35
            if (r1 != r3) goto L2f
            a03 r7 = r0.X
            j80 r8 = r0.A
            defpackage.n12.S(r10)
            goto L75
        L2f:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            return r2
        L35:
            j80 r7 = r0.A
            defpackage.n12.S(r10)
            goto L51
        L3b:
            defpackage.n12.S(r10)
            java.lang.Object r10 = r7.e
            sl3 r10 = (defpackage.sl3) r10
            java.lang.Object r1 = r7.c
            sp r1 = (defpackage.sp) r1
            r0.A = r7
            r0.y0 = r4
            java.lang.Object r10 = defpackage.uf2.J(r8, r10, r9, r1, r0)
            if (r10 != r5) goto L51
            goto L71
        L51:
            r8 = r10
            a03 r8 = (defpackage.a03) r8
            java.lang.Object r9 = r7.d
            pl3 r9 = (defpackage.pl3) r9
            lf0 r9 = r9.f()
            ce0 r9 = (defpackage.ce0) r9
            cf0 r9 = r9.b
            h80 r10 = new h80
            r10.<init>(r7, r2, r4)
            r0.A = r7
            r0.X = r8
            r0.y0 = r3
            java.lang.Object r9 = defpackage.ji0.b0(r9, r10, r0)
            if (r9 != r5) goto L72
        L71:
            return r5
        L72:
            r6 = r8
            r8 = r7
            r7 = r6
        L75:
            java.lang.Object r8 = r8.b
            hj3 r8 = (defpackage.hj3) r8
            ue1 r8 = r8.a
            boolean r8 = r8.f
            if (r8 == 0) goto L81
            yz2 r7 = defpackage.j80.i
        L81:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j80.e(wz2, int, ie0):java.lang.Object");
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
