package defpackage;

import io.netty.channel.internal.ChannelUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class co1 extends d1 {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, co1> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected dm4 unknownFields;

    public co1() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = dm4.f;
    }

    public static co1 d(Class cls) {
        co1 co1Var = defaultInstanceMap.get(cls);
        if (co1Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                co1Var = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                e04.l("Class initialization cannot fail.", e);
                return null;
            }
        }
        if (co1Var != null) {
            return co1Var;
        }
        try {
            co1 co1Var2 = (co1) ((co1) xm4.a.allocateInstance(cls)).c(6);
            if (co1Var2 != null) {
                defaultInstanceMap.put(cls, co1Var2);
                return co1Var2;
            }
            st4.g();
            return null;
        } catch (InstantiationException e2) {
            zo2.q(e2);
            return null;
        }
    }

    public static Object e(Method method, co1 co1Var, Object... objArr) {
        try {
            return method.invoke(co1Var, objArr);
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

    public static final boolean f(co1 co1Var, boolean z) {
        byte bByteValue = ((Byte) co1Var.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        v93 v93Var = v93.c;
        v93Var.getClass();
        boolean zC = v93Var.a(co1Var.getClass()).c(co1Var);
        if (z) {
            co1Var.c(2);
        }
        return zC;
    }

    public static void j(Class cls, co1 co1Var) {
        co1Var.h();
        defaultInstanceMap.put(cls, co1Var);
    }

    @Override // defpackage.d1
    public final int a(gq3 gq3Var) {
        int iG;
        int iG2;
        if (g()) {
            if (gq3Var == null) {
                v93 v93Var = v93.c;
                v93Var.getClass();
                iG2 = v93Var.a(getClass()).g(this);
            } else {
                iG2 = gq3Var.g(this);
            }
            if (iG2 >= 0) {
                return iG2;
            }
            xe.q(dw2.A(iG2, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.memoizedSerializedSize;
        if ((i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL) != Integer.MAX_VALUE) {
            return i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        if (gq3Var == null) {
            v93 v93Var2 = v93.c;
            v93Var2.getClass();
            iG = v93Var2.a(getClass()).g(this);
        } else {
            iG = gq3Var.g(this);
        }
        k(iG);
        return iG;
    }

    @Override // defpackage.d1
    public final void b(r60 r60Var) {
        v93 v93Var = v93.c;
        v93Var.getClass();
        gq3 gq3VarA = v93Var.a(getClass());
        zf2 zf2Var = r60Var.a;
        if (zf2Var == null) {
            zf2Var = new zf2(r60Var);
        }
        gq3VarA.d(this, zf2Var);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v93 v93Var = v93.c;
        v93Var.getClass();
        return v93Var.a(getClass()).e(this, (co1) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public final int hashCode() {
        if (g()) {
            v93 v93Var = v93.c;
            v93Var.getClass();
            return v93Var.a(getClass()).f(this);
        }
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        v93 v93Var2 = v93.c;
        v93Var2.getClass();
        int iF = v93Var2.a(getClass()).f(this);
        this.memoizedHashCode = iF;
        return iF;
    }

    public final co1 i() {
        return (co1) c(4);
    }

    public final void k(int i) {
        if (i < 0) {
            xe.q(dw2.A(i, "serialized size must be non-negative, was "));
        } else {
            this.memoizedSerializedSize = (i & ChannelUtils.WRITE_STATUS_SNDBUF_FULL) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        }
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = pl2.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        pl2.c(this, sb, 0);
        return sb.toString();
    }
}
