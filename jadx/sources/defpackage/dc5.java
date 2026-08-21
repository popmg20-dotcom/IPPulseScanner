package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.cache.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dc5 extends va5 {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb;
    protected fe5 zzc;

    public dc5() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = fe5.f;
    }

    public static dc5 j(Class cls) {
        Map map = zzd;
        dc5 dc5Var = (dc5) map.get(cls);
        if (dc5Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                dc5Var = (dc5) map.get(cls);
            } catch (ClassNotFoundException e) {
                e04.l("Class initialization cannot fail.", e);
                return null;
            }
        }
        if (dc5Var != null) {
            return dc5Var;
        }
        try {
            dc5 dc5Var2 = (dc5) ((dc5) me5.a.allocateInstance(cls)).m(6);
            if (dc5Var2 != null) {
                map.put(cls, dc5Var2);
                return dc5Var2;
            }
            st4.g();
            return null;
        } catch (InstantiationException e2) {
            zo2.q(e2);
            return null;
        }
    }

    public static void k(Class cls, dc5 dc5Var) {
        dc5Var.e();
        zzd.put(cls, dc5Var);
    }

    public static Object l(Method method, dc5 dc5Var, Object... objArr) {
        try {
            return method.invoke(dc5Var, objArr);
        } catch (IllegalAccessException e) {
            zo2.o("Couldn't use Java reflection to implement protocol message reflection.", e);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            zo2.o("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    @Override // defpackage.va5
    public final int b(sd5 sd5Var) {
        if (d()) {
            int iH = sd5Var.h(this);
            if (iH >= 0) {
                return iH;
            }
            a.a(String.valueOf(iH).length() + 42, iH);
            return 0;
        }
        int i = this.zzb & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iH2 = sd5Var.h(this);
        if (iH2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iH2;
            return iH2;
        }
        a.a(String.valueOf(iH2).length() + 42, iH2);
        return 0;
    }

    public final void c(kb5 kb5Var) {
        sd5 sd5VarA = od5.c.a(getClass());
        ub4 ub4Var = kb5Var.a;
        if (ub4Var == null) {
            ub4Var = new ub4();
            Charset charset = nc5.a;
            ub4Var.b = kb5Var;
            kb5Var.a = ub4Var;
        }
        sd5VarA.d(this, ub4Var);
    }

    public final boolean d() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void e() {
        this.zzb &= ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return od5.c.a(getClass()).e(this, (dc5) obj);
    }

    public final zb5 f() {
        return (zb5) m(5);
    }

    public final zb5 g() {
        zb5 zb5Var = (zb5) m(5);
        zb5Var.f(this);
        return zb5Var;
    }

    public final void h() {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public final int hashCode() {
        if (d()) {
            return od5.c.a(getClass()).b(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iB = od5.c.a(getClass()).b(this);
        this.zza = iB;
        return iB;
    }

    public final int i() {
        if (d()) {
            int iH = od5.c.a(getClass()).h(this);
            if (iH >= 0) {
                return iH;
            }
            a.a(String.valueOf(iH).length() + 42, iH);
            return 0;
        }
        int i = this.zzb & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iH2 = od5.c.a(getClass()).h(this);
        if (iH2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iH2;
            return iH2;
        }
        a.a(String.valueOf(iH2).length() + 42, iH2);
        return 0;
    }

    public abstract Object m(int i);

    public final String toString() {
        String string = super.toString();
        char[] cArr = gd5.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        gd5.b(this, sb, 0);
        return sb.toString();
    }
}
