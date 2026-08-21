package defpackage;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Pair;
import android.util.Size;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gx implements kz {
    public final String a;
    public final sy b;
    public final w7 c;
    public nw e;
    public final vg3 g;
    public final oj1 i;
    public final Object d = new Object();
    public vg3 f = null;
    public ArrayList h = null;

    public gx(pz pzVar, String str) {
        str.getClass();
        this.a = str;
        sy syVarB = pzVar.b(str);
        this.b = syVarB;
        w7 w7Var = new w7(14);
        w7Var.f = this;
        this.c = w7Var;
        this.i = p95.m(syVarB);
        new HashMap();
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            ez4.a0("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
        }
        this.g = new vg3(new lg(5, null));
    }

    @Override // defpackage.kz
    public final yc2 a() {
        return this.g;
    }

    @Override // defpackage.kz
    public final Set b() {
        return ((rz0) sz0.d(this.b).a).b();
    }

    @Override // defpackage.kz
    public final int c() {
        return k(0);
    }

    @Override // defpackage.kz
    public final String d() {
        return this.a;
    }

    @Override // defpackage.kz
    public final yc2 e() {
        synchronized (this.d) {
            try {
                nw nwVar = this.e;
                vg3 vg3Var = this.f;
                if (nwVar == null) {
                    if (vg3Var == null) {
                        vg3Var = new vg3(0);
                        this.f = vg3Var;
                    }
                    return vg3Var;
                }
                if (vg3Var != null) {
                    return vg3Var;
                }
                return nwVar.z0.b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.kz
    public final /* synthetic */ boolean f(cp1 cp1Var, r90 r90Var) {
        return fw.a(this, r90Var, cp1Var);
    }

    @Override // defpackage.kz
    public final void g(Executor executor, kw kwVar) {
        synchronized (this.d) {
            try {
                nw nwVar = this.e;
                if (nwVar != null) {
                    nwVar.f.execute(new b0(1, nwVar, executor, kwVar));
                    return;
                }
                ArrayList arrayList = this.h;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.h = arrayList;
                }
                arrayList.add(new Pair(kwVar, executor));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.kz
    public final Rect h() {
        Rect rect = (Rect) this.b.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if ("robolectric".equals(Build.FINGERPRINT) && rect == null) {
            return new Rect(0, 0, 4000, 3000);
        }
        rect.getClass();
        return rect;
    }

    @Override // defpackage.kz
    public final int i() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.LENS_FACING);
        r25.f(num != null, "Unable to get the lens facing of the camera.");
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return 0;
        }
        if (iIntValue == 1) {
            return 1;
        }
        if (iIntValue == 2) {
            return 2;
        }
        ez4.a0("LensFacingUtil", "The given lens facing integer: " + iIntValue + " can not be recognized.");
        return -1;
    }

    @Override // defpackage.kz
    public final String j() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        return num.intValue() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    @Override // defpackage.kz
    public final int k(int i) {
        Integer num = (Integer) this.b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        num.getClass();
        return r25.B(r25.T(i), num.intValue(), 1 == i());
    }

    @Override // defpackage.kz
    public final Object l() {
        return (CameraCharacteristics) this.b.b.f;
    }

    @Override // defpackage.kz
    public final boolean m() {
        sy syVar = this.b;
        Objects.requireNonNull(syVar);
        return gb4.R(new fx(syVar, 0));
    }

    @Override // defpackage.kz
    public final oj1 n() {
        return this.i;
    }

    @Override // defpackage.kz
    public final List o(int i) {
        Size[] sizeArrT = this.b.c().t(i);
        return sizeArrT != null ? Arrays.asList(sizeArrT) : Collections.EMPTY_LIST;
    }

    @Override // defpackage.kz
    public final Set p() {
        HashSet hashSet = new HashSet();
        int[] iArr = (int[]) this.b.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
        }
        return hashSet;
    }

    @Override // defpackage.kz
    public final Set q() {
        int[] outputFormats;
        try {
            outputFormats = ((StreamConfigurationMap) ((oj1) this.b.c().f).f).getOutputFormats();
        } catch (IllegalArgumentException | NullPointerException e) {
            ez4.b0("StreamConfigurationMapCompatBaseImpl", "Failed to get output formats from StreamConfigurationMap", e);
            outputFormats = null;
        }
        int[] iArr = outputFormats != null ? (int[]) outputFormats.clone() : null;
        if (iArr == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (int i : iArr) {
            hashSet.add(Integer.valueOf(i));
        }
        return hashSet;
    }

    @Override // defpackage.kz
    public final void r(yx yxVar) {
        synchronized (this.d) {
            try {
                nw nwVar = this.e;
                if (nwVar != null) {
                    nwVar.f.execute(new s7(5, nwVar, yxVar));
                    return;
                }
                ArrayList arrayList = this.h;
                if (arrayList == null) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((Pair) it.next()).first == yxVar) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.kz
    public final void s(iv1 iv1Var) {
        iv1Var.getClass();
        r25.j = iv1Var;
    }

    public final void t(nw nwVar) {
        synchronized (this.d) {
            try {
                this.e = nwVar;
                vg3 vg3Var = this.f;
                if (vg3Var != null) {
                    vg3Var.n(nwVar.z0.b);
                }
                ArrayList<Pair> arrayList = this.h;
                int i = 1;
                if (arrayList != null) {
                    for (Pair pair : arrayList) {
                        nw nwVar2 = this.e;
                        nwVar2.f.execute(new b0(i, nwVar2, (Executor) pair.second, (yx) pair.first));
                    }
                    this.h = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Integer num = (Integer) this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        num.getClass();
        int iIntValue = num.intValue();
        ez4.D("Camera2CameraInfo", "Device Level: ".concat(iIntValue != 0 ? iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? dw2.A(iIntValue, "Unknown value: ") : "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL" : "INFO_SUPPORTED_HARDWARE_LEVEL_3" : "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY" : "INFO_SUPPORTED_HARDWARE_LEVEL_FULL" : "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED"));
    }

    @Override // defpackage.kz
    public final kz getImplementation() {
        return this;
    }
}
