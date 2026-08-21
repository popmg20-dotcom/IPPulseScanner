package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import j$.util.DesugarCollections;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yx4 {
    public final gx4 a;
    public final Context b;
    public final String c;
    public final ih4 d;
    public final na0 e;
    public final n53 f;
    public final WorkDatabase g;
    public final jx4 h;
    public final mo0 i;
    public final ArrayList j;
    public final String k;
    public final x32 l;

    public yx4(uf4 uf4Var) {
        gx4 gx4Var = (gx4) uf4Var.f;
        this.a = gx4Var;
        this.b = (Context) uf4Var.b;
        String str = gx4Var.a;
        this.c = str;
        this.d = (ih4) uf4Var.c;
        this.e = (na0) uf4Var.a;
        this.f = (n53) uf4Var.d;
        WorkDatabase workDatabase = (WorkDatabase) uf4Var.e;
        this.g = workDatabase;
        this.h = workDatabase.x();
        this.i = workDatabase.s();
        ArrayList arrayList = (ArrayList) uf4Var.g;
        this.j = arrayList;
        this.k = fw.y(fw.D("Work [ id=", str, ", tags={ "), d70.j0(arrayList, ",", null, null, null, 62), " } ]");
        this.l = je.b();
    }

    public final void a(int i) {
        jx4 jx4Var = this.h;
        ww4 ww4Var = ww4.b;
        String str = this.c;
        jx4Var.h(ww4Var, str);
        jx4Var.g(System.currentTimeMillis(), str);
        jx4Var.f(this.a.v, str);
        jx4Var.e(-1L, str);
        jx4Var.i(i, str);
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        jx4 jx4Var = this.h;
        String str = this.c;
        jx4Var.g(jCurrentTimeMillis, str);
        jx4Var.h(ww4.b, str);
        pl3 pl3Var = jx4Var.a;
        ((Number) ke0.r(pl3Var, false, true, new ko0(str, 18))).intValue();
        jx4Var.f(this.a.v, str);
        ke0.r(pl3Var, false, true, new ko0(str, 19));
        jx4Var.e(-1L, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(ie0 ie0Var) {
        wx4 wx4Var;
        char c;
        fn fnVar;
        WorkDatabase workDatabase;
        OverwritingInputMerger overwritingInputMerger;
        di0 di0VarF;
        gx4 gx4Var = this.a;
        String str = gx4Var.c;
        String str2 = gx4Var.d;
        if (ie0Var instanceof wx4) {
            wx4Var = (wx4) ie0Var;
            int i = wx4Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                wx4Var.Y = i - Integer.MIN_VALUE;
            } else {
                wx4Var = new wx4(this, ie0Var);
            }
        }
        wx4 wx4Var2 = wx4Var;
        Object objB0 = wx4Var2.A;
        int i2 = wx4Var2.Y;
        String str3 = this.k;
        try {
            if (i2 == 0) {
                n12.S(objB0);
                final boolean zA = vo.A();
                final String str4 = gx4Var.x;
                final int i3 = 0;
                if (!zA || str4 == null) {
                    c = 1;
                    fnVar = new fn(18, new Callable(this) { // from class: px4
                        public final /* synthetic */ yx4 b;

                        {
                            this.b = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            int i4 = i3;
                            ww4 ww4Var = ww4.b;
                            yx4 yx4Var = this.b;
                            switch (i4) {
                                case 0:
                                    gx4 gx4Var2 = yx4Var.a;
                                    String str5 = gx4Var2.c;
                                    if (gx4Var2.b != ww4Var) {
                                        String str6 = zx4.a;
                                        ue2.g().a(str6, str5 + " is not in ENQUEUED state. Nothing more to do");
                                        return Boolean.TRUE;
                                    }
                                    if ((!gx4Var2.c() && (gx4Var2.b != ww4Var || gx4Var2.k <= 0)) || System.currentTimeMillis() >= gx4Var2.a()) {
                                        return Boolean.FALSE;
                                    }
                                    ue2.g().a(zx4.a, "Delaying execution for " + str5 + " because it is being executed before schedule.");
                                    return Boolean.TRUE;
                                default:
                                    jx4 jx4Var = yx4Var.h;
                                    String str7 = yx4Var.c;
                                    boolean z = false;
                                    if (jx4Var.b(str7) == ww4Var) {
                                        jx4Var.h(ww4.f, str7);
                                        ((Number) ke0.r(jx4Var.a, false, true, new ko0(str7, 21))).intValue();
                                        jx4Var.i(-256, str7);
                                        z = true;
                                    }
                                    return Boolean.valueOf(z);
                            }
                        }
                    });
                    workDatabase = this.g;
                    if (((Boolean) workDatabase.p(fnVar)).booleanValue()) {
                        return new tx4();
                    }
                    boolean zC = gx4Var.c();
                    String str5 = this.c;
                    if (zC) {
                        di0VarF = gx4Var.e;
                    } else {
                        str2.getClass();
                        String str6 = p02.a;
                        try {
                            Object objNewInstance = Class.forName(str2).getDeclaredConstructor(null).newInstance(null);
                            objNewInstance.getClass();
                            overwritingInputMerger = (OverwritingInputMerger) objNewInstance;
                        } catch (Exception e) {
                            ue2.g().f(p02.a, "Trouble instantiating ".concat(str2), e);
                            overwritingInputMerger = null;
                        }
                        if (overwritingInputMerger == null) {
                            String str7 = zx4.a;
                            ue2.g().e(str7, "Could not create Input Merger " + str2);
                            return new rx4();
                        }
                        List listX = p95.x(gx4Var.e);
                        jx4 jx4Var = this.h;
                        jx4Var.getClass();
                        str5.getClass();
                        ArrayList arrayListM0 = d70.m0(listX, (List) ke0.r(jx4Var.a, c, false, new ko0(str5, 20)));
                        cp1 cp1Var = new cp1(19);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Iterator it = arrayListM0.iterator();
                        while (it.hasNext()) {
                            Map mapUnmodifiableMap = DesugarCollections.unmodifiableMap(((di0) it.next()).a);
                            mapUnmodifiableMap.getClass();
                            linkedHashMap.putAll(mapUnmodifiableMap);
                        }
                        cp1Var.g0(linkedHashMap);
                        di0VarF = cp1Var.f();
                    }
                    UUID uuidFromString = UUID.fromString(str5);
                    na0 na0Var = this.e;
                    ExecutorService executorService = na0Var.a;
                    gm0 gm0Var = na0Var.b;
                    d7 d7Var = d7.X;
                    n53 n53Var = this.f;
                    ih4 ih4Var = this.d;
                    uw4 uw4Var = new uw4(workDatabase, n53Var, ih4Var);
                    WorkerParameters workerParameters = new WorkerParameters();
                    workerParameters.a = uuidFromString;
                    workerParameters.b = di0VarF;
                    new HashSet(this.j);
                    workerParameters.c = executorService;
                    workerParameters.d = gm0Var;
                    workerParameters.e = ih4Var;
                    workerParameters.f = d7Var;
                    try {
                        final tc2 tc2VarE = d7Var.e(this.b, str, workerParameters);
                        final int i4 = 1;
                        tc2VarE.d = true;
                        cf0 cf0Var = wx4Var2.f;
                        cf0Var.getClass();
                        af0 af0VarZ = cf0Var.Z(pr1.X);
                        af0VarZ.getClass();
                        v32 v32Var = (v32) af0VarZ;
                        v32Var.M(new am1() { // from class: qx4
                            @Override // defpackage.am1
                            public final Object g(Object obj) {
                                String str8;
                                Throwable th = (Throwable) obj;
                                if (th instanceof nx4) {
                                    tc2VarE.c.compareAndSet(-256, ((nx4) th).b);
                                }
                                if (zA && (str8 = str4) != null) {
                                    int iHashCode = this.a.hashCode();
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        yf4.b(iHashCode, vo.O(str8));
                                    } else {
                                        String strO = vo.O(str8);
                                        try {
                                            Method method = vo.J0;
                                            if (method == null) {
                                                method = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                                                vo.J0 = method;
                                            }
                                            method.invoke(null, Long.valueOf(vo.G0), strO, Integer.valueOf(iHashCode));
                                        } catch (Exception e2) {
                                            vo.x("asyncTraceEnd", e2);
                                        }
                                    }
                                }
                                return xl4.a;
                            }
                        });
                        Object objP = workDatabase.p(new fn(18, new Callable(this) { // from class: px4
                            public final /* synthetic */ yx4 b;

                            {
                                this.b = this;
                            }

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                int i42 = i4;
                                ww4 ww4Var = ww4.b;
                                yx4 yx4Var = this.b;
                                switch (i42) {
                                    case 0:
                                        gx4 gx4Var2 = yx4Var.a;
                                        String str52 = gx4Var2.c;
                                        if (gx4Var2.b != ww4Var) {
                                            String str62 = zx4.a;
                                            ue2.g().a(str62, str52 + " is not in ENQUEUED state. Nothing more to do");
                                            return Boolean.TRUE;
                                        }
                                        if ((!gx4Var2.c() && (gx4Var2.b != ww4Var || gx4Var2.k <= 0)) || System.currentTimeMillis() >= gx4Var2.a()) {
                                            return Boolean.FALSE;
                                        }
                                        ue2.g().a(zx4.a, "Delaying execution for " + str52 + " because it is being executed before schedule.");
                                        return Boolean.TRUE;
                                    default:
                                        jx4 jx4Var2 = yx4Var.h;
                                        String str72 = yx4Var.c;
                                        boolean z = false;
                                        if (jx4Var2.b(str72) == ww4Var) {
                                            jx4Var2.h(ww4.f, str72);
                                            ((Number) ke0.r(jx4Var2.a, false, true, new ko0(str72, 21))).intValue();
                                            jx4Var2.i(-256, str72);
                                            z = true;
                                        }
                                        return Boolean.valueOf(z);
                                }
                            }
                        }));
                        objP.getClass();
                        if (!((Boolean) objP).booleanValue()) {
                            return new tx4();
                        }
                        if (v32Var.isCancelled()) {
                            return new tx4();
                        }
                        fs1 fs1Var = (fs1) ih4Var.d;
                        fs1Var.getClass();
                        ef0 ef0VarX = n12.x(fs1Var);
                        xx4 xx4Var = new xx4(this, tc2VarE, uw4Var, null, 0);
                        wx4Var2.Y = 1;
                        objB0 = ji0.b0(ef0VarX, xx4Var, wx4Var2);
                        mf0 mf0Var = mf0.b;
                        if (objB0 == mf0Var) {
                            return mf0Var;
                        }
                    } catch (Throwable unused) {
                        String str8 = zx4.a;
                        ue2.g().e(str8, "Could not create Worker " + str);
                        return new rx4();
                    }
                } else {
                    int iHashCode = gx4Var.hashCode();
                    if (Build.VERSION.SDK_INT >= 29) {
                        yf4.a(iHashCode, vo.O(str4));
                        c = 1;
                        fnVar = new fn(18, new Callable(this) { // from class: px4
                            public final /* synthetic */ yx4 b;

                            {
                                this.b = this;
                            }

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                int i42 = i3;
                                ww4 ww4Var = ww4.b;
                                yx4 yx4Var = this.b;
                                switch (i42) {
                                    case 0:
                                        gx4 gx4Var2 = yx4Var.a;
                                        String str52 = gx4Var2.c;
                                        if (gx4Var2.b != ww4Var) {
                                            String str62 = zx4.a;
                                            ue2.g().a(str62, str52 + " is not in ENQUEUED state. Nothing more to do");
                                            return Boolean.TRUE;
                                        }
                                        if ((!gx4Var2.c() && (gx4Var2.b != ww4Var || gx4Var2.k <= 0)) || System.currentTimeMillis() >= gx4Var2.a()) {
                                            return Boolean.FALSE;
                                        }
                                        ue2.g().a(zx4.a, "Delaying execution for " + str52 + " because it is being executed before schedule.");
                                        return Boolean.TRUE;
                                    default:
                                        jx4 jx4Var2 = yx4Var.h;
                                        String str72 = yx4Var.c;
                                        boolean z = false;
                                        if (jx4Var2.b(str72) == ww4Var) {
                                            jx4Var2.h(ww4.f, str72);
                                            ((Number) ke0.r(jx4Var2.a, false, true, new ko0(str72, 21))).intValue();
                                            jx4Var2.i(-256, str72);
                                            z = true;
                                        }
                                        return Boolean.valueOf(z);
                                }
                            }
                        });
                        workDatabase = this.g;
                        if (((Boolean) workDatabase.p(fnVar)).booleanValue()) {
                        }
                    } else {
                        String strO = vo.O(str4);
                        try {
                            Method method = vo.I0;
                            if (method == null) {
                                c = 1;
                                try {
                                    method = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                                    vo.I0 = method;
                                } catch (Exception e2) {
                                    e = e2;
                                    vo.x("asyncTraceBegin", e);
                                }
                            } else {
                                c = 1;
                            }
                            Long lValueOf = Long.valueOf(vo.G0);
                            Integer numValueOf = Integer.valueOf(iHashCode);
                            Object[] objArr = new Object[3];
                            objArr[0] = lValueOf;
                            objArr[c] = strO;
                            objArr[2] = numValueOf;
                            method.invoke(null, objArr);
                        } catch (Exception e3) {
                            e = e3;
                            c = 1;
                        }
                        fnVar = new fn(18, new Callable(this) { // from class: px4
                            public final /* synthetic */ yx4 b;

                            {
                                this.b = this;
                            }

                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                int i42 = i3;
                                ww4 ww4Var = ww4.b;
                                yx4 yx4Var = this.b;
                                switch (i42) {
                                    case 0:
                                        gx4 gx4Var2 = yx4Var.a;
                                        String str52 = gx4Var2.c;
                                        if (gx4Var2.b != ww4Var) {
                                            String str62 = zx4.a;
                                            ue2.g().a(str62, str52 + " is not in ENQUEUED state. Nothing more to do");
                                            return Boolean.TRUE;
                                        }
                                        if ((!gx4Var2.c() && (gx4Var2.b != ww4Var || gx4Var2.k <= 0)) || System.currentTimeMillis() >= gx4Var2.a()) {
                                            return Boolean.FALSE;
                                        }
                                        ue2.g().a(zx4.a, "Delaying execution for " + str52 + " because it is being executed before schedule.");
                                        return Boolean.TRUE;
                                    default:
                                        jx4 jx4Var2 = yx4Var.h;
                                        String str72 = yx4Var.c;
                                        boolean z = false;
                                        if (jx4Var2.b(str72) == ww4Var) {
                                            jx4Var2.h(ww4.f, str72);
                                            ((Number) ke0.r(jx4Var2.a, false, true, new ko0(str72, 21))).intValue();
                                            jx4Var2.i(-256, str72);
                                            z = true;
                                        }
                                        return Boolean.valueOf(z);
                                }
                            }
                        });
                        workDatabase = this.g;
                        if (((Boolean) workDatabase.p(fnVar)).booleanValue()) {
                        }
                    }
                }
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(objB0);
            }
            sc2 sc2Var = (sc2) objB0;
            sc2Var.getClass();
            return new sx4(sc2Var);
        } catch (CancellationException e4) {
            String str9 = zx4.a;
            ue2 ue2VarG = ue2.g();
            String strConcat = str3.concat(" was cancelled");
            if (ue2VarG.b <= 4) {
                Log.i(str9, strConcat, e4);
            }
            throw e4;
        } catch (Throwable th) {
            ue2.g().f(zx4.a, str3.concat(" failed because it threw an exception/error"), th);
            return new rx4();
        }
    }

    public final void d(sc2 sc2Var) {
        String str = this.c;
        ArrayList arrayListL = e70.L(str);
        while (true) {
            boolean zIsEmpty = arrayListL.isEmpty();
            jx4 jx4Var = this.h;
            if (zIsEmpty) {
                di0 di0Var = ((pc2) sc2Var).a;
                di0Var.getClass();
                jx4Var.f(this.a.v, str);
                ke0.r(jx4Var.a, false, true, new gj(25, di0Var, str));
                return;
            }
            String str2 = (String) d70.p0(arrayListL);
            if (jx4Var.b(str2) != ww4.Y) {
                jx4Var.h(ww4.A, str2);
            }
            arrayListL.addAll(this.i.a(str2));
        }
    }
}
