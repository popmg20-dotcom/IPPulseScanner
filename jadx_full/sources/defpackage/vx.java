package defpackage;

import android.content.Context;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.compat.quirk.PreviewUnderExposureQuirk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vx implements pn4 {
    public final sv0 b;

    public vx(Context context) {
        this.b = sv0.b(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x003b  */
    @Override // defpackage.pn4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ka0 a(on4 on4Var, int i) {
        int i2;
        qn2 qn2VarC = qn2.c();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashSet hashSet = new HashSet();
        qn2 qn2VarC2 = qn2.c();
        ArrayList arrayList = new ArrayList();
        vn2 vn2VarA = vn2.a();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int iOrdinal = on4Var.ordinal();
        if (iOrdinal != 0) {
            i2 = (iOrdinal == 3 && xt0.a.z(PreviewUnderExposureQuirk.class) == null) ? 3 : 1;
        } else if (i == 2) {
            i2 = 5;
        }
        pg pgVar = mn4.a0;
        ArrayList arrayList5 = new ArrayList(linkedHashSet);
        ArrayList arrayList6 = new ArrayList(arrayList2);
        ArrayList arrayList7 = new ArrayList(arrayList3);
        ArrayList arrayList8 = new ArrayList(arrayList4);
        ArrayList arrayList9 = new ArrayList(hashSet);
        sw2 sw2VarA = sw2.a(qn2VarC2);
        ArrayList arrayList10 = new ArrayList(arrayList);
        pa4 pa4Var = pa4.b;
        ArrayMap arrayMap = new ArrayMap();
        for (String str : vn2VarA.a.keySet()) {
            arrayMap.put(str, vn2VarA.a.get(str));
            arrayList6 = arrayList6;
        }
        qn2VarC.g(pgVar, new tt3(arrayList5, arrayList6, arrayList7, arrayList8, new f10(arrayList9, sw2VarA, i2, arrayList10, false, new pa4(arrayMap), null), null, null, 0, null));
        qn2VarC.g(mn4.c0, ux.a);
        HashSet hashSet2 = new HashSet();
        qn2 qn2VarC3 = qn2.c();
        ArrayList arrayList11 = new ArrayList();
        vn2 vn2VarA2 = vn2.a();
        int iOrdinal2 = on4Var.ordinal();
        int i3 = iOrdinal2 != 0 ? (iOrdinal2 == 3 && xt0.a.z(PreviewUnderExposureQuirk.class) == null) ? 3 : 1 : i == 2 ? 5 : 2;
        pg pgVar2 = mn4.b0;
        ArrayList arrayList12 = new ArrayList(hashSet2);
        sw2 sw2VarA2 = sw2.a(qn2VarC3);
        ArrayList arrayList13 = new ArrayList(arrayList11);
        pa4 pa4Var2 = pa4.b;
        ArrayMap arrayMap2 = new ArrayMap();
        for (String str2 : vn2VarA2.a.keySet()) {
            arrayMap2.put(str2, vn2VarA2.a.get(str2));
        }
        qn2VarC.g(pgVar2, new f10(arrayList12, sw2VarA2, i3, arrayList13, false, new pa4(arrayMap2), null));
        qn2VarC.g(mn4.d0, on4Var == on4.b ? zx1.b : jx.a);
        if (on4Var == on4.f) {
            qn2VarC.g(hy1.D, this.b.e());
        }
        qn2VarC.g(hy1.w, Integer.valueOf(this.b.c(true).getRotation()));
        if (on4Var == on4.A || on4Var == on4.X) {
            qn2VarC.g(mn4.i0, Boolean.TRUE);
        }
        return sw2.a(qn2VarC);
    }
}
