package defpackage;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import io.sentry.android.core.q0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kw2 {
    public int a;
    public int b;
    public final Object c;
    public Object d;
    public Object e;

    public kw2(kz kzVar, Size size) {
        Rational rational;
        this.c = kzVar;
        this.a = kzVar.c();
        this.b = kzVar.i();
        if (size != null) {
            rational = new Rational(size.getWidth(), size.getHeight());
        } else {
            List listO = kzVar.o(256);
            if (listO.isEmpty()) {
                rational = null;
            } else {
                Size size2 = (Size) Collections.max(listO, new l80(false));
                rational = new Rational(size2.getWidth(), size2.getHeight());
            }
        }
        this.d = rational;
        this.e = new o64(kzVar, rational);
    }

    public static ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(af.a);
        arrayList2.add(af.c);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList2.contains(rational)) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        arrayList2.add(rational);
                        break;
                    }
                    if (af.a((Rational) it2.next(), size)) {
                        break;
                    }
                }
            }
        }
        return arrayList2;
    }

    public static Rational c(int i, boolean z) {
        if (i == -1) {
            return null;
        }
        if (i == 0) {
            return z ? af.a : af.b;
        }
        if (i == 1) {
            return z ? af.c : af.d;
        }
        ez4.q("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i);
        return null;
    }

    public static HashMap d(ArrayList arrayList) {
        HashMap map = new HashMap();
        Iterator it = a(arrayList).iterator();
        while (it.hasNext()) {
            map.put((Rational) it.next(), new ArrayList());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Size size = (Size) it2.next();
            for (Rational rational : map.keySet()) {
                if (af.a(rational, size)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }

    public static void e(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = (Size) list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    public static void f(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = (Size) list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List b(mn4 mn4Var) {
        Size[] sizeArr;
        kz kzVar = (kz) this.c;
        hy1 hy1Var = (hy1) mn4Var;
        ArrayList arrayListA = hy1Var.A();
        if (arrayListA != null) {
            return arrayListA;
        }
        sj3 sj3VarB = hy1Var.B();
        List<Pair> listJ = hy1Var.j();
        int iN = mn4Var.n();
        Rational rational = null;
        if (listJ != null) {
            for (Pair pair : listJ) {
                if (((Integer) pair.first).intValue() == iN) {
                    sizeArr = (Size[]) pair.second;
                    break;
                }
            }
            sizeArr = null;
        } else {
            sizeArr = null;
        }
        List listAsList = sizeArr == null ? null : Arrays.asList(sizeArr);
        if (listAsList == null) {
            listAsList = kzVar.o(iN);
        }
        ArrayList arrayList = new ArrayList(listAsList);
        Collections.sort(arrayList, new l80(true));
        if (arrayList.isEmpty()) {
            ez4.a0("SupportedOutputSizesCollector", "The retrieved supported resolutions from camera info internal is empty. Format is " + iN + ".");
        }
        if (sj3VarB != null) {
            Size sizeC0 = ((hy1) mn4Var).c0();
            hy1Var.f0(0);
            if (!mn4Var.z()) {
                mn4Var.n();
            }
            ez4.o("SupportedOutputSizesCollector", "useCaseConfig = " + mn4Var + ", candidateSizes = " + arrayList);
            sj3 sj3VarK = hy1Var.k();
            Rational rational2 = (Rational) this.d;
            pr1 pr1Var = sj3VarK.a;
            HashMap mapD = d(arrayList);
            boolean z = rational2 == null || rational2.getNumerator() >= rational2.getDenominator();
            pr1Var.getClass();
            Rational rationalC = c(0, z);
            ArrayList<Rational> arrayList2 = new ArrayList(mapD.keySet());
            Collections.sort(arrayList2, new ze(rationalC, rational2));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Rational rational3 : arrayList2) {
                linkedHashMap.put(rational3, (List) mapD.get(rational3));
            }
            if (sizeC0 != null) {
                Size size = yx3.a;
                int height = sizeC0.getHeight() * sizeC0.getWidth();
                Iterator it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    List<Size> list = (List) linkedHashMap.get((Rational) it.next());
                    ArrayList arrayList3 = new ArrayList();
                    for (Size size2 : list) {
                        if (yx3.a(size2) <= height) {
                            arrayList3.add(size2);
                        }
                    }
                    list.clear();
                    list.addAll(arrayList3);
                }
            }
            tj3 tj3Var = sj3VarK.b;
            if (tj3Var != null) {
                Iterator it2 = linkedHashMap.keySet().iterator();
                while (it2.hasNext()) {
                    List list2 = (List) linkedHashMap.get((Rational) it2.next());
                    if (!list2.isEmpty()) {
                        int i = tj3Var.b;
                        if (tj3Var != tj3.c) {
                            Size size3 = tj3Var.a;
                            if (i == 0) {
                                boolean zContains = list2.contains(size3);
                                list2.clear();
                                if (zContains) {
                                    list2.add(size3);
                                }
                            } else if (i == 1) {
                                e(list2, size3, true);
                            } else if (i == 2) {
                                e(list2, size3, false);
                            } else if (i == 3) {
                                f(list2, size3, true);
                            } else if (i == 4) {
                                f(list2, size3, false);
                            }
                        }
                    }
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = linkedHashMap.values().iterator();
            while (it3.hasNext()) {
                for (Size size4 : (List) it3.next()) {
                    if (!arrayList4.contains(size4)) {
                        arrayList4.add(size4);
                    }
                }
            }
            return arrayList4;
        }
        o64 o64Var = (o64) this.e;
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList<Size> arrayList5 = new ArrayList(arrayList);
        Collections.sort(arrayList5, new l80(true));
        ArrayList arrayList6 = new ArrayList();
        hy1 hy1Var2 = (hy1) mn4Var;
        Size sizeC02 = hy1Var2.c0();
        Size size5 = (Size) arrayList5.get(0);
        if (sizeC02 != null) {
            if (yx3.a(size5) < sizeC02.getHeight() * sizeC02.getWidth()) {
                sizeC02 = size5;
            }
        }
        Size sizeA = o64Var.a(hy1Var2);
        Size size6 = yx3.b;
        int iA = yx3.a(size6);
        if (yx3.a(sizeC02) < iA) {
            size6 = yx3.a;
        } else if (sizeA != null) {
            if (sizeA.getHeight() * sizeA.getWidth() < iA) {
                size6 = sizeA;
            }
        }
        for (Size size7 : arrayList5) {
            if (yx3.a(size7) <= sizeC02.getHeight() * sizeC02.getWidth()) {
                if (size7.getHeight() * size7.getWidth() >= yx3.a(size6) && !arrayList6.contains(size7)) {
                    arrayList6.add(size7);
                }
            }
        }
        if (arrayList6.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size6 + "\nmaxSize = " + sizeC02 + "\ninitial size list: " + arrayList5);
        }
        if (hy1Var2.R()) {
            rational = c(hy1Var2.T(), o64Var.d);
        } else {
            Size sizeA2 = o64Var.a(hy1Var2);
            if (sizeA2 != null) {
                Iterator it4 = a(arrayList6).iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        rational = new Rational(sizeA2.getWidth(), sizeA2.getHeight());
                        break;
                    }
                    rational = (Rational) it4.next();
                    if (af.a(rational, sizeA2)) {
                        break;
                    }
                }
            }
        }
        if (sizeA == null) {
            sizeA = hy1Var2.H();
        }
        ArrayList arrayList7 = new ArrayList();
        new HashMap();
        if (rational == null) {
            arrayList7.addAll(arrayList6);
            if (sizeA != null) {
                e(arrayList7, sizeA, true);
                return arrayList7;
            }
        } else {
            HashMap mapD2 = d(arrayList6);
            if (sizeA != null) {
                Iterator it5 = mapD2.keySet().iterator();
                while (it5.hasNext()) {
                    e((List) mapD2.get((Rational) it5.next()), sizeA, true);
                }
            }
            ArrayList arrayList8 = new ArrayList(mapD2.keySet());
            Collections.sort(arrayList8, new ze(rational, o64Var.c));
            Iterator it6 = arrayList8.iterator();
            while (it6.hasNext()) {
                for (Size size8 : (List) mapD2.get((Rational) it6.next())) {
                    if (!arrayList7.contains(size8)) {
                        arrayList7.add(size8);
                    }
                }
            }
        }
        return arrayList7;
    }

    public kw2(int i) {
        switch (i) {
            case 2:
                this.c = new q0();
                break;
            default:
                this.c = new hm2(0);
                break;
        }
    }
}
