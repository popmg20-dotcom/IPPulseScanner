package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dz4 {
    public final sy a;
    public final at3 b;
    public final e24 c;
    public boolean d = false;
    public final boolean e;
    public final boolean f;
    public e10 g;
    public az1 h;
    public e24 i;

    public dz4(sy syVar, at3 at3Var) {
        boolean z;
        this.e = false;
        this.f = false;
        this.a = syVar;
        this.b = at3Var;
        int[] iArr = (int[]) syVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 4) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        this.e = z;
        this.f = xt0.a.z(ZslDisablerQuirk.class) != null;
        this.c = new e24(new st4(5));
    }

    public final void a() {
        e10 e10Var = this.g;
        if (e10Var != null) {
            e10Var.l();
            this.g = null;
        }
        e24 e24Var = this.i;
        if (e24Var != null) {
            ((AtomicBoolean) e24Var.z).set(false);
            this.i = null;
        }
        b();
        az1 az1Var = this.h;
        if (az1Var != null) {
            az1Var.a();
            this.h = null;
        }
    }

    public final void b() {
        boolean zIsEmpty;
        e24 e24Var = this.c;
        while (true) {
            synchronized (e24Var.z) {
                zIsEmpty = ((ArrayDeque) e24Var.f).isEmpty();
            }
            if (zIsEmpty) {
                return;
            } else {
                ((my1) e24Var.i()).close();
            }
        }
    }
}
