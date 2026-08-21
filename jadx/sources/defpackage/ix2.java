package defpackage;

import android.util.Size;
import android.view.Surface;
import j$.util.Objects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ix2 {
    public final List a;
    public final Size b;
    public final int c;
    public final int d;
    public String e;
    public boolean f = false;
    public long g = 1;

    public ix2(Surface surface) {
        Size size;
        int iIntValue;
        int iIntValue2 = 0;
        this.a = Collections.singletonList(surface);
        try {
            Method declaredMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("getSurfaceSize", Surface.class);
            declaredMethod.setAccessible(true);
            size = (Size) declaredMethod.invoke(null, surface);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            ez4.r("OutputConfigCompat", "Unable to retrieve surface size.", e);
            size = null;
        }
        this.b = size;
        try {
            iIntValue2 = ((Integer) Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("detectSurfaceType", Surface.class).invoke(null, surface)).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            ez4.r("OutputConfigCompat", "Unable to retrieve surface format.", e2);
        }
        this.c = iIntValue2;
        try {
            iIntValue = ((Integer) Surface.class.getDeclaredMethod("getGenerationId", null).invoke(surface, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            ez4.r("OutputConfigCompat", "Unable to retrieve surface generation id.", e3);
            iIntValue = -1;
        }
        this.d = iIntValue;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ix2) {
            ix2 ix2Var = (ix2) obj;
            List list = ix2Var.a;
            if (this.b.equals(ix2Var.b) && this.c == ix2Var.c && this.d == ix2Var.d && this.f == ix2Var.f && this.g == ix2Var.g && Objects.equals(this.e, ix2Var.e)) {
                List list2 = this.a;
                int iMin = Math.min(list2.size(), list.size());
                for (int i = 0; i < iMin; i++) {
                    if (list2.get(i) == list.get(i)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 31;
        int i = this.d ^ ((iHashCode << 5) - iHashCode);
        int iHashCode2 = this.b.hashCode() ^ ((i << 5) - i);
        int i2 = this.c ^ ((iHashCode2 << 5) - iHashCode2);
        int i3 = (this.f ? 1 : 0) ^ ((i2 << 5) - i2);
        int i4 = (i3 << 5) - i3;
        String str = this.e;
        int iHashCode3 = (str == null ? 0 : str.hashCode()) ^ i4;
        long j = this.g;
        return ((int) (j ^ (j >>> 32))) ^ ((iHashCode3 << 5) - iHashCode3);
    }
}
