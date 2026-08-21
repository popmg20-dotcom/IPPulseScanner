package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class me5 {
    public static final Unsafe a;
    public static final Class b;
    public static final vm4 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    static {
        Unsafe unsafe;
        boolean z;
        boolean z2;
        vm4 vm4Var;
        je5 je5Var = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new qm4(2));
        } catch (Throwable unused) {
            unsafe = null;
        }
        a = unsafe;
        int i = ya5.a;
        b = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zJ = j(cls);
        Class<?> cls2 = Integer.TYPE;
        boolean zJ2 = j(cls2);
        char c2 = 1;
        int i2 = 0;
        if (unsafe != null) {
            if (zJ) {
                je5Var = new je5(unsafe, c2 == true ? 1 : 0);
            } else if (zJ2) {
                je5Var = new je5(unsafe, i2);
            }
        }
        c = je5Var;
        if (je5Var == null) {
            z = false;
        } else {
            try {
                Class<?> cls3 = je5Var.b.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (b() != null) {
                    z = true;
                }
            } catch (Throwable th) {
                Logger.getLogger(me5.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
            }
        }
        d = z;
        vm4 vm4Var2 = c;
        if (vm4Var2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls4 = vm4Var2.b.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                Logger.getLogger(me5.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th2.toString()));
                z2 = false;
            }
        }
        e = z2;
        f = m(byte[].class);
        m(boolean[].class);
        a(boolean[].class);
        m(int[].class);
        a(int[].class);
        m(long[].class);
        a(long[].class);
        m(float[].class);
        a(float[].class);
        m(double[].class);
        a(double[].class);
        m(Object[].class);
        a(Object[].class);
        Field fieldB = b();
        if (fieldB != null && (vm4Var = c) != null) {
            vm4Var.b.objectFieldOffset(fieldB);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Class cls) {
        if (e) {
            c.b.arrayIndexScale(cls);
        }
    }

    public static Field b() {
        Field declaredField;
        Field declaredField2;
        int i = ya5.a;
        try {
            declaredField = Buffer.class.getDeclaredField("effectiveDirectAddress");
        } catch (Throwable unused) {
            declaredField = null;
        }
        if (declaredField != null) {
            return declaredField;
        }
        try {
            declaredField2 = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField2 = null;
        }
        if (declaredField2 == null || declaredField2.getType() != Long.TYPE) {
            return null;
        }
        return declaredField2;
    }

    public static void c(Object obj, long j, byte b2) {
        Unsafe unsafe = c.b;
        long j2 = (-4) & j;
        int i = unsafe.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b2) << i2) | (i & (~(DnsRecord.CLASS_ANY << i2))));
    }

    public static void d(Object obj, long j, byte b2) {
        Unsafe unsafe = c.b;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j2, ((255 & b2) << i) | (unsafe.getInt(obj, j2) & (~(DnsRecord.CLASS_ANY << i))));
    }

    public static int e(long j, Object obj) {
        return c.b.getInt(obj, j);
    }

    public static void f(Object obj, long j, int i) {
        c.b.putInt(obj, j, i);
    }

    public static long g(long j, Object obj) {
        return c.b.getLong(obj, j);
    }

    public static Object h(long j, Object obj) {
        return c.b.getObject(obj, j);
    }

    public static void i(Object obj, long j, Object obj2) {
        c.b.putObject(obj, j, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean j(Class cls) {
        int i = ya5.a;
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean k(long j, Object obj) {
        return ((byte) ((c.b.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & DnsRecord.CLASS_ANY)) != 0;
    }

    public static /* synthetic */ boolean l(long j, Object obj) {
        return ((byte) ((c.b.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & DnsRecord.CLASS_ANY)) != 0;
    }

    public static int m(Class cls) {
        if (e) {
            return c.b.arrayBaseOffset(cls);
        }
        return -1;
    }
}
