package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jx {
    public static final jx a = new jx();

    public void a(yx1 yx1Var, e10 e10Var) {
        int i;
        f10 f10Var = (f10) yx1Var.p(mn4.b0, null);
        sw2 sw2Var = sw2.z;
        pg pgVar = f10.h;
        HashSet hashSet = new HashSet();
        qn2 qn2VarC = qn2.c();
        ArrayList arrayList = new ArrayList();
        vn2 vn2VarA = vn2.a();
        ArrayList arrayList2 = new ArrayList(hashSet);
        sw2 sw2VarA = sw2.a(qn2VarC);
        ArrayList arrayList3 = new ArrayList(arrayList);
        pa4 pa4Var = pa4.b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = vn2VarA.a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        new f10(arrayList2, sw2VarA, -1, arrayList3, false, new pa4(arrayMap), null);
        if (f10Var != null) {
            int i2 = f10Var.c;
            e10Var.a(f10Var.d);
            sw2Var = f10Var.b;
            i = i2;
        } else {
            i = -1;
        }
        e10Var.A = qn2.d(sw2Var);
        e10Var.b = ((Integer) yx1Var.p(rx.A, Integer.valueOf(i))).intValue();
        e10Var.b(new d10((CameraCaptureSession.CaptureCallback) yx1Var.p(rx.y0, new ix())));
        e10Var.d(qx.d(yx1Var).c());
    }
}
