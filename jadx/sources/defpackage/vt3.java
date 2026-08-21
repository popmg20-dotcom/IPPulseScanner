package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vt3 implements wt3 {
    public final List a;
    public final py b;
    public final at3 c;
    public final int d;
    public j02 e = null;

    public vt3(int i, ArrayList arrayList, at3 at3Var, py pyVar) {
        this.d = i;
        this.a = DesugarCollections.unmodifiableList(new ArrayList(arrayList));
        this.b = pyVar;
        this.c = at3Var;
    }

    @Override // defpackage.wt3
    public final int b() {
        return this.d;
    }

    @Override // defpackage.wt3
    public final Object c() {
        return null;
    }

    @Override // defpackage.wt3
    public final j02 d() {
        return this.e;
    }

    @Override // defpackage.wt3
    public final Executor e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof vt3) {
            vt3 vt3Var = (vt3) obj;
            List list = vt3Var.a;
            if (Objects.equals(this.e, vt3Var.e) && this.d == vt3Var.d) {
                List list2 = this.a;
                if (list2.size() == list.size()) {
                    for (int i = 0; i < list2.size(); i++) {
                        if (!((ax2) list2.get(i)).equals(list.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.wt3
    public final CameraCaptureSession.StateCallback f() {
        return this.b;
    }

    @Override // defpackage.wt3
    public final List g() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        int i = (iHashCode << 5) - iHashCode;
        j02 j02Var = this.e;
        int iHashCode2 = (j02Var == null ? 0 : j02Var.a.a.hashCode()) ^ i;
        return this.d ^ ((iHashCode2 << 5) - iHashCode2);
    }

    @Override // defpackage.wt3
    public final void i(j02 j02Var) {
        if (this.d != 1) {
            this.e = j02Var;
        } else {
            vp1.n("Method not supported for high speed session types");
        }
    }

    @Override // defpackage.wt3
    public final void h(CaptureRequest captureRequest) {
    }
}
