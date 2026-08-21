package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pt3 extends ot3 {
    public static pt3 d(mn4 mn4Var, Size size) {
        if (mn4Var.x() == null) {
            zo2.v(mn4Var.F(mn4Var.toString()), "Implementation is missing option unpacker for ");
            return null;
        }
        pt3 pt3Var = new pt3();
        tt3 tt3VarE = mn4Var.E();
        sw2 sw2Var = sw2.z;
        int i = tt3.a().g.c;
        if (tt3VarE != null) {
            i = tt3VarE.g.c;
            for (CameraDevice.StateCallback stateCallback : tt3VarE.c) {
                ArrayList arrayList = pt3Var.c;
                if (!arrayList.contains(stateCallback)) {
                    arrayList.add(stateCallback);
                }
            }
            for (CameraCaptureSession.StateCallback stateCallback2 : tt3VarE.d) {
                ArrayList arrayList2 = pt3Var.d;
                if (!arrayList2.contains(stateCallback2)) {
                    arrayList2.add(stateCallback2);
                }
            }
            pt3Var.b.a(tt3VarE.g.d);
            sw2Var = tt3VarE.g.b;
        }
        pt3Var.b.A = qn2.d(sw2Var);
        if (mn4Var instanceof k43) {
            Rational rational = l43.a;
            if (((PreviewPixelHDRnetQuirk) xt0.a.z(PreviewPixelHDRnetQuirk.class)) != null && !l43.a.equals(new Rational(size.getWidth(), size.getHeight()))) {
                qn2 qn2VarC = qn2.c();
                qn2VarC.g(rx.k0(CaptureRequest.TONEMAP_MODE), 2);
                pt3Var.b.d(new rx(14, sw2.a(qn2VarC)));
            }
        }
        pt3Var.b.b = ((Integer) mn4Var.p(rx.A, Integer.valueOf(i))).intValue();
        CameraDevice.StateCallback stateCallback3 = (CameraDevice.StateCallback) mn4Var.p(rx.Y, new fz());
        ArrayList arrayList3 = pt3Var.c;
        if (!arrayList3.contains(stateCallback3)) {
            arrayList3.add(stateCallback3);
        }
        CameraCaptureSession.StateCallback stateCallback4 = (CameraCaptureSession.StateCallback) mn4Var.p(rx.Z, new qy());
        ArrayList arrayList4 = pt3Var.d;
        if (!arrayList4.contains(stateCallback4)) {
            arrayList4.add(stateCallback4);
        }
        d10 d10Var = new d10((CameraCaptureSession.CaptureCallback) mn4Var.p(rx.y0, new ix()));
        pt3Var.b.b(d10Var);
        ArrayList arrayList5 = pt3Var.e;
        if (!arrayList5.contains(d10Var)) {
            arrayList5.add(d10Var);
        }
        int iN = mn4Var.N();
        if (iN != 0) {
            e10 e10Var = pt3Var.b;
            if (iN != 0) {
                ((qn2) e10Var.A).g(mn4.m0, Integer.valueOf(iN));
            }
        }
        int iW = mn4Var.W();
        if (iW != 0) {
            e10 e10Var2 = pt3Var.b;
            if (iW != 0) {
                ((qn2) e10Var2.A).g(mn4.l0, Integer.valueOf(iW));
            }
        }
        qn2 qn2VarC2 = qn2.c();
        pg pgVar = rx.z0;
        qn2VarC2.g(pgVar, (String) mn4Var.p(pgVar, null));
        pg pgVar2 = rx.X;
        Long l = (Long) mn4Var.p(pgVar2, -1L);
        l.getClass();
        qn2VarC2.g(pgVar2, l);
        pt3Var.b.d(qn2VarC2);
        pt3Var.b.d(qx.d(mn4Var).c());
        return pt3Var;
    }

    public final void a(ka0 ka0Var) {
        this.b.d(ka0Var);
    }

    public final void b(dn0 dn0Var, oz0 oz0Var, int i) {
        v92 v92VarA = fh.a(dn0Var);
        if (oz0Var == null) {
            zo2.n("Null dynamicRange");
            return;
        }
        v92VarA.X = oz0Var;
        v92VarA.z = Integer.valueOf(i);
        this.a.add(v92VarA.e());
        ((HashSet) this.b.z).add(dn0Var);
    }

    public final tt3 c() {
        return new tt3(new ArrayList(this.a), new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.e), this.b.e(), this.f, this.g, this.h, this.i);
    }
}
