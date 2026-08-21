package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pz {
    public final lb a;
    public final ArrayMap b = new ArrayMap(4);

    public pz(lb lbVar) {
        this.a = lbVar;
    }

    public static pz a(Context context, Handler handler) {
        int i = Build.VERSION.SDK_INT;
        return new pz(i >= 30 ? new sz(context, null) : i >= 29 ? new rz(context, null) : i >= 28 ? new qz(context, null) : new lb(context, new tz(handler)));
    }

    public final sy b(String str) {
        sy syVar;
        synchronized (this.b) {
            syVar = (sy) this.b.get(str);
            if (syVar == null) {
                try {
                    sy syVar2 = new sy(this.a.w(str), str);
                    this.b.put(str, syVar2);
                    syVar = syVar2;
                } catch (AssertionError e) {
                    throw new xx(e.getMessage(), e);
                }
            }
        }
        return syVar;
    }

    public final String[] c() {
        try {
            return ((CameraManager) this.a.f).getCameraIdList();
        } catch (CameraAccessException e) {
            throw new xx(e);
        }
    }
}
