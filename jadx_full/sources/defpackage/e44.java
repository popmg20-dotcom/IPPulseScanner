package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Range;
import androidx.camera.camera2.internal.compat.quirk.PreviewUnderExposureQuirk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class e44 {
    public static final pg a;
    public static final dg2 b;
    public static final dg2 c;

    static {
        Class cls = Long.TYPE;
        cls.getClass();
        a = new pg("camera2.streamSpec.streamUseCase", cls, null);
        dg2 dg2Var = new dg2();
        int i = Build.VERSION.SDK_INT;
        on4 on4Var = on4.A;
        on4 on4Var2 = on4.b;
        on4 on4Var3 = on4.f;
        if (i >= 33) {
            on4 on4Var4 = on4.Y;
            on4 on4Var5 = on4.z;
            dg2Var.put(4L, qe.t0(new on4[]{on4Var3, on4Var4, on4Var5}));
            dg2Var.put(1L, qe.t0(new on4[]{on4Var3, on4Var4, on4Var5}));
            dg2Var.put(2L, yr2.k0(on4Var2));
            dg2Var.put(3L, yr2.k0(on4Var));
        }
        b = dg2Var.b();
        dg2 dg2Var2 = new dg2();
        if (i >= 33) {
            dg2Var2.put(4L, qe.t0(new on4[]{on4Var3, on4Var2, on4Var}));
            dg2Var2.put(3L, qe.t0(new on4[]{on4Var3, on4Var}));
        }
        c = dg2Var2.b();
    }

    public static final boolean a(sy syVar, List list) {
        long[] jArr;
        syVar.getClass();
        if (Build.VERSION.SDK_INT >= 33 && (jArr = (long[]) syVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(Long.valueOf(j));
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!hashSet.contains(Long.valueOf(((w64) it.next()).c.b))) {
                }
            }
            return true;
        }
        return false;
    }

    public static rx b(ka0 ka0Var, Long l) {
        pg pgVar = a;
        if (ka0Var.K(pgVar) && n12.c(ka0Var.u(pgVar), l)) {
            return null;
        }
        qn2 qn2VarD = qn2.d(ka0Var);
        qn2VarD.g(pgVar, l);
        return new rx(14, qn2VarD);
    }

    public static boolean c(on4 on4Var, long j, List list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (on4Var != on4.X) {
            Long lValueOf = Long.valueOf(j);
            dg2 dg2Var = b;
            if (!dg2Var.containsKey(lValueOf)) {
                return false;
            }
            Object obj = dg2Var.get(Long.valueOf(j));
            obj.getClass();
            return ((Set) obj).contains(on4Var);
        }
        Long lValueOf2 = Long.valueOf(j);
        dg2 dg2Var2 = c;
        if (!dg2Var2.containsKey(lValueOf2)) {
            return false;
        }
        Object obj2 = dg2Var2.get(Long.valueOf(j));
        obj2.getClass();
        Set set = (Set) obj2;
        if (list.size() != set.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!set.contains((on4) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(sy syVar) {
        long[] jArr;
        syVar.getClass();
        return (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) syVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
    }

    public static boolean e(ka0 ka0Var, on4 on4Var) {
        Object objP = ka0Var.p(mn4.i0, Boolean.FALSE);
        objP.getClass();
        if (((Boolean) objP).booleanValue()) {
            return false;
        }
        pg pgVar = yx1.f;
        if (!ka0Var.K(pgVar)) {
            return false;
        }
        Object objU = ka0Var.u(pgVar);
        objU.getClass();
        int iIntValue = ((Number) objU).intValue();
        int iOrdinal = on4Var.ordinal();
        if (iOrdinal == 0) {
            return iIntValue == 2;
        }
        if (iOrdinal != 3) {
            return false;
        }
        xt0.a.z(PreviewUnderExposureQuirk.class);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean f(sy syVar, ArrayList arrayList, HashMap map, HashMap map2) {
        boolean z;
        boolean z2;
        syVar.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            ArrayList<mn4> arrayList2 = new ArrayList(map.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((jg) it.next()).f.getClass();
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                Object obj = map.get((mn4) it2.next());
                obj.getClass();
                ((ih) obj).f.getClass();
            }
            long[] jArr = (long[]) syVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
            if (jArr != null && jArr.length != 0) {
                HashSet hashSet = new HashSet();
                for (long j : jArr) {
                    hashSet.add(Long.valueOf(j));
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator it3 = arrayList.iterator();
                if (it3.hasNext()) {
                    jg jgVar = (jg) it3.next();
                    ka0 ka0Var = jgVar.f;
                    ka0Var.getClass();
                    pg pgVar = rx.X;
                    if (ka0Var.K(pgVar)) {
                        ka0 ka0Var2 = jgVar.f;
                        ka0Var2.getClass();
                        Object objU = ka0Var2.u(pgVar);
                        objU.getClass();
                        if (((Number) objU).longValue() != 0) {
                            z2 = false;
                            z = true;
                        }
                    } else {
                        z = false;
                        z2 = true;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                for (mn4 mn4Var : arrayList2) {
                    pg pgVar2 = rx.X;
                    if (mn4Var.K(pgVar2)) {
                        Object objU2 = mn4Var.u(pgVar2);
                        objU2.getClass();
                        long jLongValue = ((Number) objU2).longValue();
                        if (jLongValue != 0) {
                            if (z2) {
                                xe.k("Either all use cases must have non-default stream use case assigned or none should have it");
                                return false;
                            }
                            linkedHashSet.add(Long.valueOf(jLongValue));
                            z = true;
                        } else if (z) {
                            xe.k("Either all use cases must have non-default stream use case assigned or none should have it");
                            return false;
                        }
                    } else if (z) {
                        xe.k("Either all use cases must have non-default stream use case assigned or none should have it");
                        return false;
                    }
                    z2 = true;
                }
                if (!z2) {
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        if (!hashSet.contains(Long.valueOf(((Number) it4.next()).longValue()))) {
                        }
                    }
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        jg jgVar2 = (jg) it5.next();
                        ka0 ka0Var3 = jgVar2.f;
                        ka0Var3.getClass();
                        rx rxVarB = b(ka0Var3, (Long) ka0Var3.u(rx.X));
                        if (rxVarB != null) {
                            r90 r90VarA = ih.a(jgVar2.c);
                            r90VarA.d = Integer.valueOf(jgVar2.g);
                            Range range = jgVar2.h;
                            if (range == null) {
                                zo2.n("Null expectedFrameRateRange");
                                return false;
                            }
                            r90VarA.e = range;
                            oz0 oz0Var = jgVar2.d;
                            if (oz0Var == null) {
                                zo2.n("Null dynamicRange");
                                return false;
                            }
                            r90VarA.c = oz0Var;
                            r90VarA.f = rxVarB;
                            map2.put(jgVar2, r90VarA.e());
                        }
                    }
                    for (mn4 mn4Var2 : arrayList2) {
                        ih ihVar = (ih) map.get(mn4Var2);
                        ihVar.getClass();
                        ka0 ka0Var4 = ihVar.f;
                        ka0Var4.getClass();
                        rx rxVarB2 = b(ka0Var4, (Long) ka0Var4.u(rx.X));
                        if (rxVarB2 != null) {
                            r90 r90VarB = ihVar.b();
                            r90VarB.f = rxVarB2;
                            map.put(mn4Var2, r90VarB.e());
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
