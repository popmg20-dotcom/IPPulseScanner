package defpackage;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class id0 implements ar1 {
    public boolean b;

    public id0(int i) {
        switch (i) {
            case 4:
                this.b = vt0.a.z(SurfaceOrderQuirk.class) != null;
                break;
            case 5:
                this.b = xt0.a.z(TorchIsClosedAfterImageCapturingQuirk.class) != null;
                break;
            default:
                this.b = ((StillCaptureFlashStopRepeatingQuirk) xt0.a.z(StillCaptureFlashStopRepeatingQuirk.class)) != null;
                break;
        }
    }

    public static f10 a(f10 f10Var) {
        e10 e10Var = new e10();
        e10Var.b = f10Var.c;
        Iterator it = DesugarCollections.unmodifiableList(f10Var.a).iterator();
        while (it.hasNext()) {
            ((HashSet) e10Var.z).add((dn0) it.next());
        }
        e10Var.d(f10Var.b);
        qn2 qn2VarC = qn2.c();
        qn2VarC.g(rx.k0(CaptureRequest.FLASH_MODE), 0);
        e10Var.d(new rx(14, sw2.a(qn2VarC)));
        return e10Var.e();
    }

    @Override // defpackage.ar1
    public boolean b(wx3 wx3Var) {
        return this.b;
    }

    public boolean c(ArrayList arrayList, boolean z) {
        if (!this.b || !z) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) ((CaptureRequest) it.next()).get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean d(ArrayList arrayList, boolean z) {
        if (!this.b || !z) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) ((CaptureRequest) it.next()).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
            if (iIntValue == 2 || iIntValue == 3) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ar1
    public boolean j() {
        return this.b;
    }

    public id0(boolean z) {
        this.b = z;
    }
}
