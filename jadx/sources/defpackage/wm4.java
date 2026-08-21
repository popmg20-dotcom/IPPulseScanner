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
public abstract class wm4 {
    public static final Class a;
    public static final vm4 b;
    public static final boolean c;
    public static final boolean d;
    public static final long e;
    public static final boolean f;

    static {
        Unsafe unsafe;
        vm4 tm4Var = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new qm4(0));
        } catch (Throwable unused) {
            unsafe = null;
        }
        a = l7.a;
        boolean zD = d(Long.TYPE);
        boolean zD2 = d(Integer.TYPE);
        if (unsafe != null) {
            if (!l7.a()) {
                tm4Var = new tm4(unsafe, 0);
            } else if (zD) {
                tm4Var = new rm4(unsafe, 1);
            } else if (zD2) {
                tm4Var = new rm4(unsafe, 0);
            }
        }
        b = tm4Var;
        c = tm4Var == null ? false : tm4Var.j();
        d = tm4Var == null ? false : tm4Var.i();
        e = a(byte[].class);
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
        if (fieldC != null && tm4Var != null) {
            tm4Var.b.objectFieldOffset(fieldC);
        }
        f = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static int a(Class cls) {
        if (d) {
            return b.b.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void b(Class cls) {
        if (d) {
            b.b.arrayIndexScale(cls);
        }
    }

    public static Field c() {
        Field declaredField;
        Field declaredField2;
        if (l7.a()) {
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
        if (!l7.a()) {
            return false;
        }
        try {
            Class cls2 = a;
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

    public static byte e(byte[] bArr, long j) {
        return b.b(e + j, bArr);
    }

    public static void f(Throwable th) {
        Logger.getLogger(wm4.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static void g(byte[] bArr, long j, byte b2) {
        b.f(bArr, e + j, b2);
    }

    public static void h(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        vm4 vm4Var = b;
        int i = vm4Var.b.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        vm4Var.b.putInt(obj, j2, ((255 & b2) << i2) | (i & (~(DnsRecord.CLASS_ANY << i2))));
    }

    public static void i(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        vm4 vm4Var = b;
        int i = (((int) j) & 3) << 3;
        vm4Var.b.putInt(obj, j2, ((255 & b2) << i) | (vm4Var.b.getInt(obj, j2) & (~(DnsRecord.CLASS_ANY << i))));
    }
}
