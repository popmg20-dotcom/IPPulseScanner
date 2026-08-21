package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class um4 extends vm4 {
    @Override // defpackage.vm4
    public final boolean a(long j, Object obj) {
        return this.b.getBoolean(obj, j);
    }

    @Override // defpackage.vm4
    public final double c(long j, Object obj) {
        return this.b.getDouble(obj, j);
    }

    @Override // defpackage.vm4
    public final float d(long j, Object obj) {
        return this.b.getFloat(obj, j);
    }

    @Override // defpackage.vm4
    public final void e(Object obj, long j, boolean z) {
        this.b.putBoolean(obj, j, z);
    }

    @Override // defpackage.vm4
    public final void f(Object obj, long j, byte b) {
        this.b.putByte(obj, j, b);
    }

    @Override // defpackage.vm4
    public final void g(Object obj, long j, double d) {
        this.b.putDouble(obj, j, d);
    }

    @Override // defpackage.vm4
    public final void h(Object obj, long j, float f) {
        this.b.putFloat(obj, j, f);
    }

    @Override // defpackage.vm4
    public final boolean i() {
        if (!super.i()) {
            return false;
        }
        try {
            Class<?> cls = this.b.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            xm4.i(th);
            return false;
        }
    }

    @Override // defpackage.vm4
    public final boolean j() {
        Unsafe unsafe = this.b;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (xm4.c() != null) {
                    try {
                        Class<?> cls3 = unsafe.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        xm4.i(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                xm4.i(th2);
            }
        }
        return false;
    }
}
