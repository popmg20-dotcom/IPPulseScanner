package defpackage;

import android.util.Rational;
import android.util.Size;
import io.sentry.android.core.q0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List b(defpackage.mn4 r13) {
        /*
            Method dump skipped, instruction units count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kw2.b(mn4):java.util.List");
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
