package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xm4 {
    public static final Unsafe a;
    public static final Class b;
    public static final vm4 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    static {
        Unsafe unsafe;
        vm4 um4Var = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new qm4(1));
        } catch (Throwable unused) {
            unsafe = null;
        }
        a = unsafe;
        b = m7.a;
        boolean zD = d(Long.TYPE);
        boolean zD2 = d(Integer.TYPE);
        if (unsafe != null) {
            if (!m7.a()) {
                um4Var = new um4(unsafe, 1);
            } else if (zD) {
                um4Var = new sm4(unsafe, 1);
            } else if (zD2) {
                um4Var = new sm4(unsafe, 0);
            }
        }
        c = um4Var;
        d = um4Var == null ? false : um4Var.j();
        e = um4Var == null ? false : um4Var.i();
        f = a(byte[].class);
        a(boolean[].class);
        b(boolean[].class);
        a(int[].class);
        b(int[].class);
        a(long[].class);
        b(long[].class);
        a(float[].class);
        b(float[].class);
        a(double[].class);
        b(double[].class);
        a(Object[].class);
        b(Object[].class);
        Field fieldC = c();
        if (fieldC != null && um4Var != null) {
            um4Var.b.objectFieldOffset(fieldC);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static int a(Class cls) {
        if (e) {
            return c.b.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void b(Class cls) {
        if (e) {
            c.b.arrayIndexScale(cls);
        }
    }

    public static Field c() {
        Field declaredField;
        Field declaredField2;
        if (m7.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(Class cls) {
        if (!m7.a()) {
            return false;
        }
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

    public static boolean e(long j, Object obj) {
        return ((byte) ((f(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & DnsRecord.CLASS_ANY)) != 0;
    }

    public static int f(Object obj, long j) {
        return c.b.getInt(obj, j);
    }

    public static long g(Object obj, long j) {
        return c.b.getLong(obj, j);
    }

    public static Object h(Object obj, long j) {
        return c.b.getObject(obj, j);
    }

    public static void i(Throwable th) {
        Logger.getLogger(xm4.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void j(byte[] bArr, long j, byte b2) {
        c.f(bArr, f + j, b2);
    }

    public static void k(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iF = f(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        m(obj, j2, ((255 & b2) << i) | (iF & (~(DnsRecord.CLASS_ANY << i))));
    }

    public static void l(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        m(obj, j2, ((255 & b2) << i) | (f(obj, j2) & (~(DnsRecord.CLASS_ANY << i))));
    }

    public static void m(Object obj, long j, int i) {
        c.b.putInt(obj, j, i);
    }

    public static void n(Object obj, long j, long j2) {
        c.b.putLong(obj, j, j2);
    }

    public static void o(Object obj, long j, Object obj2) {
        c.b.putObject(obj, j, obj2);
    }
}
