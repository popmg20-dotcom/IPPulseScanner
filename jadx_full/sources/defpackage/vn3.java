package defpackage;

import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class vn3 {
    public static final ve2 a = ve2.a(vn3.class.getName());

    /* JADX WARN: Multi-variable type inference failed */
    public static List a(kd3 kd3Var, zv1 zv1Var, rd3 rd3Var) {
        int i;
        int i2;
        if (kd3Var == null) {
            return Collections.EMPTY_LIST;
        }
        Iterator it = kd3Var.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            try {
                i2 = Integer.parseInt((String) it.next(), 10);
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            if (i2 > i3) {
                i3 = i2;
            }
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 <= i3; i4++) {
            arrayList.add(null);
        }
        for (String str : kd3Var.keySet()) {
            try {
                i = Integer.parseInt(str, 10);
            } catch (NumberFormatException unused2) {
                i = 0;
            }
            sd3 sd3Var = (sd3) kd3Var.get(str);
            arrayList.set(i, (j10) ((xp1) zv1Var).f(new un3(sd3Var.c(), (String) sd3Var.get("contentName"), sd3Var.d() == null ? wn3.b : c((sd3) kd3Var.get(str), zv1Var, rd3Var), 1)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static sn b(Collection collection, zv1 zv1Var, rd3 rd3Var) {
        wn3 wn3VarC;
        sn3 sn3VarD;
        qt qtVar;
        int i = 0;
        if (collection == null) {
            return new sn((Object) new wn3[0], false);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            sd3 sd3Var = (sd3) it.next();
            String str = (String) sd3Var.get("include");
            ve2 ve2Var = a;
            if (str != null) {
                if (str.equals("$base")) {
                    qtVar = qt.f;
                } else if (str.equals("$self")) {
                    qtVar = qt.g;
                } else {
                    int iIndexOf = str.indexOf("#");
                    qtVar = iIndexOf != -1 ? iIndexOf != 0 ? new qt(str.substring(i, iIndexOf), 5, str.substring(iIndexOf + 1)) : new qt("", 3, str.substring(1)) : new qt(str, 4, "");
                }
                String str2 = (String) qtVar.d;
                int i2 = qtVar.b;
                int iG = fw.G(i2);
                if (iG == 0) {
                    wn3VarC = c(rd3Var.b("$base"), zv1Var, rd3Var);
                } else if (iG == 1) {
                    wn3VarC = c(rd3Var.b("$self"), zv1Var, rd3Var);
                } else if (iG == 2) {
                    sd3 sd3Var2 = (sd3) rd3Var.get(str2);
                    if (sd3Var2 != null) {
                        wn3VarC = c(sd3Var2, zv1Var, rd3Var);
                    } else {
                        rd3Var.b("$base").c();
                        a1.n(ve2Var.a, "CANNOT find rule for scopeName [{0}]. I am [{1}]");
                        wn3VarC = null;
                    }
                } else if (iG == 3 || iG == 4) {
                    xp1 xp1Var = (xp1) zv1Var;
                    od3 od3VarB = xp1Var.b((String) qtVar.c, rd3Var);
                    if (od3VarB != null) {
                        rd3 rd3VarB = od3VarB.b();
                        if (i2 != 5) {
                            str2 = null;
                        }
                        if (str2 != null) {
                            sd3 sd3Var3 = (sd3) rd3VarB.get(str2);
                            if (sd3Var3 != null) {
                                wn3VarC = c(sd3Var3, xp1Var, rd3VarB);
                            } else {
                                rd3Var.b("$base").c();
                                a1.n(ve2Var.a, "CANNOT find rule for scopeName [{0}]. I am [{1}]");
                            }
                        } else {
                            wn3VarC = c(rd3VarB.b("$self"), xp1Var, rd3VarB);
                        }
                    } else {
                        rd3Var.b("$base").c();
                        a1.n(ve2Var.a, "CANNOT find grammar for scopeName [{0}]. I am [{1}]");
                    }
                    wn3VarC = null;
                } else {
                    wn3VarC = null;
                }
            } else {
                wn3VarC = c(sd3Var, zv1Var, rd3Var);
            }
            wn3 wn3Var = wn3VarC;
            if (wn3Var != null) {
                try {
                    sn3VarD = ((xp1) zv1Var).d(wn3Var);
                } catch (IndexOutOfBoundsException e) {
                    if (str == null) {
                        e.printStackTrace();
                    }
                    sn3VarD = null;
                }
                if (sn3VarD instanceof nz1) {
                    nz1 nz1Var = (nz1) sn3VarD;
                    if (nz1Var.f && nz1Var.g.length == 0) {
                        a1.n(ve2Var.a, "REMOVING " + sn3VarD + " ENTIRELY DUE TO EMPTY PATTERNS THAT ARE MISSING");
                    } else {
                        arrayList.add(wn3Var);
                    }
                } else if (sn3VarD instanceof um) {
                    um umVar = (um) sn3VarD;
                    if (!umVar.l || umVar.m.length != 0) {
                    }
                } else {
                    if (sn3VarD instanceof vm) {
                        vm vmVar = (vm) sn3VarD;
                        if (!vmVar.k || vmVar.l.length != 0) {
                        }
                    }
                    arrayList.add(wn3Var);
                }
            }
            i = 0;
        }
        return new sn((wn3[]) arrayList.toArray(new wn3[0]), collection.size() != arrayList.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static wn3 c(sd3 sd3Var, zv1 zv1Var, rd3 rd3Var) {
        if (((wn3) sd3Var.get("id")) == null) {
            ((xp1) zv1Var).f(new un3(sd3Var, zv1Var, rd3Var, 0));
        }
        return (wn3) sd3Var.get("id");
    }
}
