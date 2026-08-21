package defpackage;

import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h51 {
    public static final String a = ue2.i("EnqueueRunnable");

    public static void a(nw4 nw4Var) {
        boolean z;
        xw4 xw4Var = nw4Var.a;
        HashSet hashSet = new HashSet();
        hashSet.addAll(nw4Var.e);
        HashSet hashSetB = nw4.b(nw4Var);
        Iterator it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                hashSet.removeAll(nw4Var.e);
                z = false;
                break;
            } else if (hashSetB.contains((String) it.next())) {
                z = true;
                break;
            }
        }
        if (z) {
            throw new IllegalStateException("WorkContinuation has cycles (" + nw4Var + ")");
        }
        WorkDatabase workDatabase = xw4Var.c;
        na0 na0Var = xw4Var.b;
        workDatabase.b();
        try {
            p95.f(workDatabase, na0Var, nw4Var);
            boolean zB = b(nw4Var);
            workDatabase.q();
            if (zB) {
                fq3.b(na0Var, xw4Var.c, xw4Var.e);
            }
        } finally {
            workDatabase.m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(nw4 nw4Var) {
        boolean z;
        boolean z2;
        boolean z3;
        xw4 xw4Var;
        boolean z4;
        WorkDatabase workDatabase;
        boolean z5;
        Iterator it;
        boolean z6;
        nw4 nw4Var2;
        boolean z7;
        HashSet hashSetB = nw4.b(nw4Var);
        xw4 xw4Var2 = nw4Var.a;
        List list = nw4Var.d;
        String[] strArr = (String[]) hashSetB.toArray(new String[0]);
        String str = nw4Var.b;
        o71 o71Var = nw4Var.c;
        d84 d84Var = xw4Var2.b.d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase2 = xw4Var2.c;
        boolean z8 = strArr != null && strArr.length > 0;
        ww4 ww4Var = ww4.z;
        ww4 ww4Var2 = ww4.Y;
        ww4 ww4Var3 = ww4.A;
        if (z8) {
            int length = strArr.length;
            int i = 0;
            z2 = false;
            z3 = false;
            z = true;
            while (i < length) {
                String str2 = strArr[i];
                List list2 = list;
                gx4 gx4VarC = workDatabase2.x().c(str2);
                if (gx4VarC == null) {
                    ue2.g().e(a, "Prerequisite " + str2 + " doesn't exist; not enqueuing");
                    break;
                }
                ww4 ww4Var4 = gx4VarC.b;
                z &= ww4Var4 == ww4Var;
                if (ww4Var4 == ww4Var3) {
                    z3 = true;
                } else if (ww4Var4 == ww4Var2) {
                    z2 = true;
                }
                i++;
                list = list2;
            }
        } else {
            z = true;
            z2 = false;
            z3 = false;
        }
        List list3 = list;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        ww4 ww4Var5 = ww4.b;
        if (zIsEmpty || z8) {
            xw4Var = xw4Var2;
            z4 = zIsEmpty;
            workDatabase = workDatabase2;
            z5 = false;
            it = list3.iterator();
            boolean z9 = z5;
            while (it.hasNext()) {
                ex4 ex4Var = (ex4) it.next();
                gx4 gx4Var = ex4Var.b;
                UUID uuid = ex4Var.a;
                if (!z8 || z) {
                    gx4Var.n = jCurrentTimeMillis;
                } else if (z3) {
                    gx4Var.b = ww4Var3;
                } else if (z2) {
                    gx4Var.b = ww4Var2;
                } else {
                    gx4Var.b = ww4.X;
                }
                if (gx4Var.b == ww4Var5) {
                    z9 = true;
                }
                jx4 jx4VarX = workDatabase.x();
                xw4 xw4Var3 = xw4Var;
                gx4 gx4VarG = p95.G(xw4Var3.e, gx4Var);
                jx4VarX.getClass();
                Iterator it2 = it;
                ww4 ww4Var6 = ww4Var5;
                ke0.r(jx4VarX.a, false, true, new ix4(jx4VarX, gx4VarG, 0));
                if (z8) {
                    int i2 = 0;
                    for (int length2 = strArr.length; i2 < length2; length2 = length2) {
                        String str3 = strArr[i2];
                        String string = uuid.toString();
                        string.getClass();
                        go0 go0Var = new go0(string, str3);
                        mo0 mo0VarS = workDatabase.s();
                        mo0VarS.getClass();
                        ke0.r(mo0VarS.a, false, true, new gj(1, mo0VarS, go0Var));
                        i2++;
                        strArr = strArr;
                    }
                }
                String[] strArr2 = strArr;
                lx4 lx4VarY = workDatabase.y();
                String string2 = uuid.toString();
                string2.getClass();
                lx4VarY.a(string2, ex4Var.c);
                if (!z4) {
                    ax4 ax4VarV = workDatabase.v();
                    String string3 = uuid.toString();
                    string3.getClass();
                    zw4 zw4Var = new zw4(str, string3);
                    ax4VarV.getClass();
                    ke0.r(ax4VarV.a, false, true, new gj(23, ax4VarV, zw4Var));
                }
                xw4Var = xw4Var3;
                it = it2;
                ww4Var5 = ww4Var6;
                strArr = strArr2;
            }
            z6 = true;
            nw4Var2 = nw4Var;
            z7 = z9;
        } else {
            List listD = workDatabase2.x().d(str);
            if (!listD.isEmpty()) {
                o71 o71Var2 = o71.z;
                z4 = zIsEmpty;
                o71 o71Var3 = o71.A;
                if (o71Var == o71Var2 || o71Var == o71Var3) {
                    mo0 mo0VarS2 = workDatabase2.s();
                    ArrayList arrayList = new ArrayList();
                    Iterator it3 = listD.iterator();
                    while (it3.hasNext()) {
                        WorkDatabase workDatabase3 = workDatabase2;
                        fx4 fx4Var = (fx4) it3.next();
                        Iterator it4 = it3;
                        String str4 = fx4Var.a;
                        mo0VarS2.getClass();
                        str4.getClass();
                        mo0 mo0Var = mo0VarS2;
                        xw4 xw4Var4 = xw4Var2;
                        if (!((Boolean) ke0.r(mo0VarS2.a, true, false, new ko0(str4, 0))).booleanValue()) {
                            ww4 ww4Var7 = fx4Var.b;
                            boolean z10 = z & (ww4Var7 == ww4Var);
                            if (ww4Var7 == ww4Var3) {
                                z3 = true;
                            } else if (ww4Var7 == ww4Var2) {
                                z2 = true;
                            }
                            arrayList.add(fx4Var.a);
                            z = z10;
                        }
                        it3 = it4;
                        workDatabase2 = workDatabase3;
                        mo0VarS2 = mo0Var;
                        xw4Var2 = xw4Var4;
                    }
                    xw4Var = xw4Var2;
                    workDatabase = workDatabase2;
                    List list4 = arrayList;
                    list4 = arrayList;
                    if (o71Var == o71Var3 && (z2 || z3)) {
                        jx4 jx4VarX2 = workDatabase.x();
                        Iterator it5 = jx4VarX2.d(str).iterator();
                        while (it5.hasNext()) {
                            jx4VarX2.a(((fx4) it5.next()).a);
                        }
                        z2 = false;
                        z3 = false;
                        list4 = Collections.EMPTY_LIST;
                    }
                    strArr = (String[]) list4.toArray(strArr);
                    z8 = strArr.length > 0;
                } else {
                    if (o71Var == o71.f) {
                        Iterator it6 = listD.iterator();
                        while (it6.hasNext()) {
                            ww4 ww4Var8 = ((fx4) it6.next()).b;
                            if (ww4Var8 == ww4Var5 || ww4Var8 == ww4.f) {
                                nw4Var2 = nw4Var;
                                z6 = true;
                                z7 = false;
                            }
                        }
                    }
                    workDatabase2.getClass();
                    workDatabase2.p(new fn(19, new b0(4, workDatabase2, str, xw4Var2)));
                    jx4 jx4VarX3 = workDatabase2.x();
                    Iterator it7 = listD.iterator();
                    while (it7.hasNext()) {
                        jx4VarX3.a(((fx4) it7.next()).a);
                    }
                    xw4Var = xw4Var2;
                    workDatabase = workDatabase2;
                    z5 = true;
                    it = list3.iterator();
                    boolean z92 = z5;
                    while (it.hasNext()) {
                    }
                    z6 = true;
                    nw4Var2 = nw4Var;
                    z7 = z92;
                }
            }
            z5 = false;
            it = list3.iterator();
            boolean z922 = z5;
            while (it.hasNext()) {
            }
            z6 = true;
            nw4Var2 = nw4Var;
            z7 = z922;
        }
        nw4Var2.g = z6;
        return z7;
    }
}
