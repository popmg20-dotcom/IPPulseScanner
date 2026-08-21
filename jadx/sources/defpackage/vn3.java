package defpackage;

import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.sn b(java.util.Collection r16, defpackage.zv1 r17, defpackage.rd3 r18) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn3.b(java.util.Collection, zv1, rd3):sn");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static wn3 c(sd3 sd3Var, zv1 zv1Var, rd3 rd3Var) {
        if (((wn3) sd3Var.get("id")) == null) {
            ((xp1) zv1Var).f(new un3(sd3Var, zv1Var, rd3Var, 0));
        }
        return (wn3) sd3Var.get("id");
    }
}
