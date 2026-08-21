package defpackage;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ez extends CameraDevice.StateCallback {
    public final /* synthetic */ int a;
    public final Object b;

    public ez(ArrayList arrayList) {
        this.a = 0;
        this.b = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CameraDevice.StateCallback stateCallback = (CameraDevice.StateCallback) it.next();
            if (!(stateCallback instanceof fz)) {
                ((ArrayList) this.b).add(stateCallback);
            }
        }
    }

    public void a() {
        ArrayList<m84> arrayListS;
        synchronized (((cm2) this.b).z) {
            arrayListS = ((cm2) this.b).s();
            ((LinkedHashSet) ((cm2) this.b).Y).clear();
            ((LinkedHashSet) ((cm2) this.b).A).clear();
            ((LinkedHashSet) ((cm2) this.b).X).clear();
        }
        for (m84 m84Var : arrayListS) {
            m84Var.p();
            m84Var.u.s();
        }
    }

    public void b() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (((cm2) this.b).z) {
            linkedHashSet.addAll((LinkedHashSet) ((cm2) this.b).Y);
            linkedHashSet.addAll((LinkedHashSet) ((cm2) this.b).A);
        }
        ((at3) ((cm2) this.b).f).execute(new d4(10, linkedHashSet));
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        switch (this.a) {
            case 0:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((CameraDevice.StateCallback) it.next()).onClosed(cameraDevice);
                }
                break;
            default:
                b();
                a();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        switch (this.a) {
            case 0:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((CameraDevice.StateCallback) it.next()).onDisconnected(cameraDevice);
                }
                break;
            default:
                b();
                a();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        switch (this.a) {
            case 0:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((CameraDevice.StateCallback) it.next()).onError(cameraDevice, i);
                }
                return;
            default:
                b();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                synchronized (((cm2) this.b).z) {
                    linkedHashSet.addAll((LinkedHashSet) ((cm2) this.b).Y);
                    linkedHashSet.addAll((LinkedHashSet) ((cm2) this.b).A);
                    break;
                }
                ((at3) ((cm2) this.b).f).execute(new jw(i, 1, linkedHashSet));
                a();
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        switch (this.a) {
            case 0:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    ((CameraDevice.StateCallback) it.next()).onOpened(cameraDevice);
                }
                break;
        }
    }

    private final void c(CameraDevice cameraDevice) {
    }

    public ez(cm2 cm2Var) {
        this.a = 1;
        this.b = cm2Var;
    }
}
