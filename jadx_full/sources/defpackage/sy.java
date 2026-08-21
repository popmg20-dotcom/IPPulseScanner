package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sy {
    public final w7 b;
    public final String c;
    public final HashMap a = new HashMap();
    public n02 d = null;

    public sy(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new ry(15, cameraCharacteristics);
        } else {
            this.b = new w7(15, cameraCharacteristics);
        }
        this.c = str;
    }

    public final Object a(CameraCharacteristics.Key key) {
        if (key.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {
            return ((CameraCharacteristics) this.b.f).get(key);
        }
        synchronized (this) {
            try {
                Object obj = this.a.get(key);
                if (obj != null) {
                    return obj;
                }
                Object obj2 = ((CameraCharacteristics) this.b.f).get(key);
                if (obj2 != null) {
                    this.a.put(key, obj2);
                }
                return obj2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int b() {
        Integer num = (!d() || Build.VERSION.SDK_INT < 35) ? null : (Integer) a(CameraCharacteristics.FLASH_TORCH_STRENGTH_DEFAULT_LEVEL);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final n02 c() {
        n02 n02Var = this.d;
        if (n02Var == null) {
            n02Var = null;
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    xe.k("StreamConfigurationMap is null!");
                    return null;
                }
                n02 n02Var2 = new n02(streamConfigurationMap, new v62(this.c));
                this.d = n02Var2;
                return n02Var2;
            } catch (AssertionError | NullPointerException e) {
                xe.k(e.getMessage());
            }
        }
        return n02Var;
    }

    public final boolean d() {
        Boolean bool = (Boolean) a(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        return bool != null && bool.booleanValue();
    }

    public final boolean e() {
        int i;
        if (!d() || (i = Build.VERSION.SDK_INT) < 35) {
            return false;
        }
        Integer num = (!d() || i < 35) ? null : (Integer) a(CameraCharacteristics.FLASH_TORCH_STRENGTH_MAX_LEVEL);
        return (num == null ? 1 : num.intValue()) > 1;
    }

    public final boolean f() {
        if (Build.VERSION.SDK_INT >= 34) {
            int[] iArr = (int[]) ((CameraCharacteristics) this.b.f).get(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
