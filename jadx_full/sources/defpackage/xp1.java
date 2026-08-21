package defpackage;

import android.util.Log;
import j$.lang.Iterable$EL;
import j$.time.Duration;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xp1 implements nv1, zv1 {
    public static final ve2 l = ve2.a(xp1.class.getName());
    public final String a;
    public volatile wn3 b;
    public final iv1 f;
    public final od3 g;
    public final iv1 h;
    public ArrayList i;
    public final em j;
    public int c = 0;
    public final HashMap d = new HashMap();
    public final HashMap e = new HashMap();
    public final ArrayList k = new ArrayList();

    public xp1(String str, od3 od3Var, int i, Map map, iv1 iv1Var, iv1 iv1Var2) {
        this.a = str;
        this.j = new em(i, map);
        this.f = iv1Var;
        this.g = e(od3Var, null);
        this.h = iv1Var2;
    }

    public static od3 e(od3 od3Var, sd3 sd3Var) {
        WeakHashMap weakHashMap = qt2.a;
        od3 od3Var2 = (od3) qt2.a(od3Var, new IdentityHashMap());
        rd3 rd3VarB = od3Var2.b();
        sd3 sd3Var2 = new sd3();
        sd3Var2.h(od3Var2.c());
        sd3Var2.i((Collection) od3Var2.get("patterns"));
        rd3VarB.put("$self", sd3Var2);
        if (sd3Var == null) {
            sd3Var = rd3VarB.b("$self");
        }
        rd3VarB.put("$base", sd3Var);
        return od3Var2;
    }

    public final void a(ArrayList arrayList, String str, sd3 sd3Var, zv1 zv1Var) {
        rh2 rh2Var = new rh2(str);
        wn3 wn3VarC = vn3.c(sd3Var, zv1Var, this.g.b());
        for (vh2 vh2Var : rh2Var.a) {
            arrayList.add(new e02(str, vh2Var.a, wn3VarC, vh2Var.b));
        }
    }

    public final od3 b(String str, rd3 rd3Var) {
        HashMap map = this.e;
        if (map.containsKey(str)) {
            return (od3) map.get(str);
        }
        od3 od3VarS = this.f.s(str);
        if (od3VarS == null) {
            return null;
        }
        map.put(str, e(od3VarS, rd3Var != null ? rd3Var.b("$base") : null));
        return (od3) map.get(str);
    }

    public final List c() {
        ArrayList arrayList = this.i;
        if (arrayList == null) {
            arrayList = new ArrayList();
            String str = this.a;
            od3 od3VarB = Objects.equals(str, str) ? this.g : b(str, null);
            if (od3VarB != null) {
                Map map = (Map) od3VarB.get("injections");
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        a(arrayList, (String) entry.getKey(), (sd3) entry.getValue(), this);
                    }
                }
                Collection collection = (Collection) ((HashMap) this.f.A).get(str);
                if (collection != null) {
                    Iterable$EL.forEach(collection, new t90(3, this, arrayList));
                }
            }
            Collections.sort(arrayList, new i60(5));
            this.i = arrayList;
            if (!arrayList.isEmpty()) {
                String strO = ha0.o("Grammar ", str, " contains the following injections:");
                ve2 ve2Var = l;
                Log.i(ve2Var.a, strO);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.i(ve2Var.a, "  - " + ((e02) it.next()).a);
                }
            }
        }
        return arrayList;
    }

    public final sn3 d(wn3 wn3Var) {
        HashMap map = this.d;
        sn3 sn3Var = (sn3) map.get(wn3Var);
        if (sn3Var != null) {
            return sn3Var;
        }
        throw new IndexOutOfBoundsException("No rule with index " + wn3Var.a + " found. Possible values: 0.." + map.size());
    }

    public final sn3 f(Function function) {
        int i = this.c + 1;
        this.c = i;
        if (i < 0) {
            xe.k("[id] must be > 0");
            return null;
        }
        wn3 wn3Var = new wn3(i);
        sn3 sn3Var = (sn3) function.apply(wn3Var);
        this.d.put(wn3Var, sn3Var);
        return sn3Var;
    }

    public final e24 g(String str, t24 t24Var, Duration duration) {
        qt qtVar;
        boolean z;
        int i;
        int i2;
        String strConcat = str;
        t24 t24Var2 = t24Var;
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = vn3.c(this.g.b().b("$self"), this, this.g.b());
                        c();
                    }
                } finally {
                }
            }
        }
        wn3 wn3Var = this.b;
        int i3 = -1;
        boolean z2 = false;
        if (t24Var2 == null || t24Var2 == t24.j) {
            am amVar = this.j.a;
            z44 z44Var = ((bd4) this.h.X).c;
            int iT = co4.T(0, amVar.a, amVar.b, z44Var.a, z44Var.b, z44Var.c);
            Object obj = null;
            String strC = d(wn3Var).c(null, null);
            int i4 = 6;
            int i5 = 23;
            if (strC != null) {
                am amVarC = this.j.c(strC);
                v62 v62Var = new v62(i5, obj, strC, z2);
                z44 z44VarB = ((bd4) this.h.X).b(v62Var);
                if (z44VarB != null) {
                    i3 = z44VarB.a;
                    int i6 = z44VarB.b;
                    i2 = z44VarB.c;
                    i = i6;
                } else {
                    i = 0;
                    i2 = 0;
                }
                qtVar = new qt(obj, v62Var, co4.T(iT, amVarC.a, amVarC.b, i3, i, i2), i4);
            } else {
                qtVar = new qt(obj, new v62(i5, obj, "unknown", z2), iT, i4);
            }
            t24Var2 = new t24(null, wn3Var, -1, -1, false, null, qtVar, qtVar);
            z = true;
        } else {
            for (t24 t24Var3 = t24Var2; t24Var3 != null; t24Var3 = t24Var3.d) {
                t24Var3.a = -1;
                t24Var3.b = -1;
            }
            z = false;
        }
        t24 t24Var4 = t24Var2;
        int i7 = 10;
        if (strConcat.isEmpty() || strConcat.charAt(strConcat.length() - 1) != '\n') {
            strConcat = strConcat.concat("\n");
        }
        zv2 zv2VarC = zv2.c(strConcat);
        int length = strConcat.length();
        ua2 ua2Var = new ua2(this.k);
        wn1 wn1VarB = ta2.b(this, zv2VarC, z, 0, t24Var4, ua2Var, true, duration == null ? Duration.ZERO : duration);
        return new e24(i7, ua2Var.a((t24) wn1VarB.f, length), (t24) wn1VarB.f, z2);
    }

    public final String toString() {
        return m44.e(this, new dg(6, this));
    }
}
