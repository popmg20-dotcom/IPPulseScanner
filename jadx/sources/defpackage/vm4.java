package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class vm4 {
    public final /* synthetic */ int a;
    public final Unsafe b;

    public /* synthetic */ vm4(Unsafe unsafe, int i) {
        this.a = i;
        this.b = unsafe;
    }

    public abstract boolean a(long j, Object obj);

    public abstract byte b(long j, Object obj);

    public abstract double c(long j, Object obj);

    public abstract float d(long j, Object obj);

    public abstract void e(Object obj, long j, boolean z);

    public abstract void f(Object obj, long j, byte b);

    public abstract void g(Object obj, long j, double d);

    public abstract void h(Object obj, long j, float f);

    public boolean i() {
        int i = this.a;
        Class<?> cls = Integer.TYPE;
        Class<?> cls2 = Long.TYPE;
        Unsafe unsafe = this.b;
        switch (i) {
            case 0:
                if (unsafe != null) {
                    try {
                        Class<?> cls3 = unsafe.getClass();
                        cls3.getMethod("objectFieldOffset", Field.class);
                        cls3.getMethod("arrayBaseOffset", Class.class);
                        cls3.getMethod("arrayIndexScale", Class.class);
                        cls3.getMethod("getInt", Object.class, cls2);
                        cls3.getMethod("putInt", Object.class, cls2, cls);
                        cls3.getMethod("getLong", Object.class, cls2);
                        cls3.getMethod("putLong", Object.class, cls2, cls2);
                        cls3.getMethod("getObject", Object.class, cls2);
                        cls3.getMethod("putObject", Object.class, cls2, Object.class);
                    } catch (Throwable th) {
                        wm4.f(th);
                    }
                }
                break;
            default:
                if (unsafe != null) {
                    try {
                        Class<?> cls4 = unsafe.getClass();
                        cls4.getMethod("objectFieldOffset", Field.class);
                        cls4.getMethod("arrayBaseOffset", Class.class);
                        cls4.getMethod("arrayIndexScale", Class.class);
                        cls4.getMethod("getInt", Object.class, cls2);
                        cls4.getMethod("putInt", Object.class, cls2, cls);
                        cls4.getMethod("getLong", Object.class, cls2);
                        cls4.getMethod("putLong", Object.class, cls2, cls2);
                        cls4.getMethod("getObject", Object.class, cls2);
                        cls4.getMethod("putObject", Object.class, cls2, Object.class);
                    } catch (Throwable th2) {
                        xm4.i(th2);
                    }
                }
                break;
        }
        return false;
    }

    public abstract boolean j();

    public abstract void k(Object obj, long j, byte b);

    public abstract boolean l(long j, Object obj);

    public abstract void m(Object obj, long j, boolean z);

    public abstract float n(long j, Object obj);

    public abstract void o(Object obj, long j, float f);

    public abstract double p(long j, Object obj);

    public abstract void q(Object obj, long j, double d);
}
