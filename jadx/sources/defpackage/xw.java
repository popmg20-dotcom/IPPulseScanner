package defpackage;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.util.ArrayMap;
import android.view.Surface;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xw extends CameraDevice.StateCallback {
    public final /* synthetic */ int a = 0;
    public final Object b;
    public final Object c;

    public xw(Executor executor, CameraDevice.StateCallback stateCallback) {
        this.c = executor;
        this.b = stateCallback;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((ex) obj).w("openCameraConfigAndClose camera closed", null);
                ((vv) this.b).b(null);
                break;
            default:
                ((Executor) obj).execute(new zy(this, cameraDevice, 0));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                ((ex) obj).w("openCameraConfigAndClose camera disconnected", null);
                ((vv) this.b).b(null);
                break;
            default:
                ((Executor) obj).execute(new zy(this, cameraDevice, 1));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        int i2 = this.a;
        Object obj = this.c;
        switch (i2) {
            case 0:
                ((ex) obj).w("openCameraConfigAndClose camera error " + i, null);
                ((vv) this.b).b(null);
                break;
            default:
                ((Executor) obj).execute(new iw(this, cameraDevice, i, 3));
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                ex exVar = (ex) obj;
                at3 at3Var = exVar.z;
                exVar.w("openCameraConfigAndClose camera opened", null);
                o10 o10Var = new o10(exVar.Z0, new oj1(Collections.EMPTY_LIST), false);
                SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                surfaceTexture.setDefaultBufferSize(640, 480);
                Surface surface = new Surface(surfaceTexture);
                az1 az1Var = new az1(surface);
                n12.K(az1Var.e).a(new s7(8, surface, surfaceTexture), yu0.a());
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashSet hashSet = new HashSet();
                qn2 qn2VarC = qn2.c();
                ArrayList arrayList = new ArrayList();
                vn2 vn2VarA = vn2.a();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                v92 v92VarA = fh.a(az1Var);
                v92VarA.X = oz0.d;
                linkedHashSet.add(v92VarA.e());
                exVar.w("Start configAndClose.", null);
                ArrayList arrayList5 = new ArrayList(linkedHashSet);
                ArrayList arrayList6 = new ArrayList(arrayList2);
                ArrayList arrayList7 = new ArrayList(arrayList3);
                ArrayList arrayList8 = new ArrayList(arrayList4);
                ArrayList arrayList9 = new ArrayList(hashSet);
                sw2 sw2VarA = sw2.a(qn2VarC);
                ArrayList arrayList10 = new ArrayList(arrayList);
                pa4 pa4Var = pa4.b;
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = vn2VarA.a;
                for (String str : arrayMap2.keySet()) {
                    arrayMap.put(str, arrayMap2.get(str));
                    arrayList5 = arrayList5;
                }
                tt3 tt3Var = new tt3(arrayList5, arrayList6, arrayList7, arrayList8, new f10(arrayList9, sw2VarA, 1, arrayList10, false, new pa4(arrayMap), null), null, null, 0, null);
                cm2 cm2Var = exVar.T0;
                r20 r20VarW = n12.W(pm1.b(fx3.m(new rm1(o10Var.n(tt3Var, cameraDevice, new m84((oj1) cm2Var.Y, (oj1) cm2Var.Z, (cm2) cm2Var.X, (at3) cm2Var.f, (xq1) cm2Var.z, (Handler) cm2Var.A)), 1))), new ed(1, o10Var, az1Var), at3Var);
                Objects.requireNonNull(cameraDevice);
                r20VarW.a(new d4(3, cameraDevice), at3Var);
                break;
            default:
                ((Executor) obj).execute(new zy(this, cameraDevice, 2));
                break;
        }
    }

    public xw(ex exVar, vv vvVar) {
        this.c = exVar;
        this.b = vvVar;
    }
}
