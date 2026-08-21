package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kd1 {
    public static final kd1 d;
    public final jy3 a;
    public boolean b;
    public boolean c;

    static {
        kd1 kd1Var = new kd1(jy3.g());
        kd1Var.m();
        d = kd1Var;
    }

    public kd1() {
        this.a = jy3.g();
    }

    public static jy3 a(jy3 jy3Var, boolean z, boolean z2) {
        jy3 jy3VarG = jy3.g();
        int i = jy3Var.f;
        for (int i2 = 0; i2 < i; i2++) {
            b(jy3VarG, jy3Var.c(i2), z, z2);
        }
        Iterator it = jy3Var.d().iterator();
        while (it.hasNext()) {
            b(jy3VarG, (Map.Entry) it.next(), z, z2);
        }
        return jy3VarG;
    }

    public static void b(jy3 jy3Var, Map.Entry entry, boolean z, boolean z2) {
        ft0 ft0Var = (ft0) entry.getKey();
        Object value = entry.getValue();
        if (z2 && (value instanceof d92)) {
            jy3Var.put(ft0Var, ((d92) value).b());
        } else if (z && (value instanceof List)) {
            jy3Var.put(ft0Var, new ArrayList((List) value));
        } else {
            jy3Var.put(ft0Var, value);
        }
    }

    public static int c(aw4 aw4Var, int i, Object obj) {
        int iH = q60.h(i);
        if (aw4Var == aw4.z) {
            iH *= 2;
        }
        return d(aw4Var, obj) + iH;
    }

    public static int d(aw4 aw4Var, Object obj) {
        int size;
        int iJ;
        switch (aw4Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = q60.d;
                return 8;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = q60.d;
                return 4;
            case 2:
                return q60.l(((Long) obj).longValue());
            case 3:
                return q60.l(((Long) obj).longValue());
            case 4:
                return q60.l(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = q60.d;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = q60.d;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = q60.d;
                return 1;
            case 8:
                if (!(obj instanceof zt)) {
                    return q60.g((String) obj);
                }
                Logger logger6 = q60.d;
                size = ((zt) obj).size();
                iJ = q60.j(size);
                break;
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((nl2) obj).h();
            case 10:
                if (obj instanceof d92) {
                    return ((d92) obj).a();
                }
                Logger logger7 = q60.d;
                size = ((nl2) obj).h();
                iJ = q60.j(size);
                break;
            case 11:
                if (!(obj instanceof zt)) {
                    Logger logger8 = q60.d;
                    size = ((byte[]) obj).length;
                    iJ = q60.j(size);
                } else {
                    Logger logger9 = q60.d;
                    size = ((zt) obj).size();
                    iJ = q60.j(size);
                }
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return q60.j(((Integer) obj).intValue());
            case 13:
                return obj instanceof g12 ? q60.l(((g12) obj).a()) : q60.l(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                Logger logger10 = q60.d;
                return 4;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ((Long) obj).getClass();
                Logger logger11 = q60.d;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return q60.j((iIntValue >> 31) ^ (iIntValue << 1));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return q60.l((jLongValue >> 63) ^ (jLongValue << 1));
            default:
                zo2.w("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
        return iJ + size;
    }

    public static int e(ft0 ft0Var, Object obj) {
        aw4 aw4VarO = ft0Var.o();
        int i = ft0Var.z.Z;
        if (!ft0Var.y()) {
            return c(aw4VarO, i, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i2 = 0;
        if (!ft0Var.x()) {
            int iC = 0;
            while (i2 < size) {
                iC += c(aw4VarO, i, list.get(i2));
                i2++;
            }
            return iC;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iD = 0;
        while (i2 < size) {
            iD += d(aw4VarO, list.get(i2));
            i2++;
        }
        return q60.j(iD) + q60.h(i) + iD;
    }

    public static int g(Map.Entry entry) {
        ft0 ft0Var = (ft0) entry.getKey();
        Object value = entry.getValue();
        if (ft0Var.o().b != cw4.MESSAGE || ft0Var.y() || ft0Var.x()) {
            return e(ft0Var, value);
        }
        if (!(value instanceof d92)) {
            int i = ((ft0) entry.getKey()).z.Z;
            return q60.f(3, (nl2) value) + q60.i(2, i) + (q60.h(1) * 2);
        }
        int i2 = ((ft0) entry.getKey()).z.Z;
        return ((d92) value).a() + q60.h(3) + q60.i(2, i2) + (q60.h(1) * 2);
    }

    public static boolean k(Map.Entry entry) {
        boolean zC;
        ft0 ft0Var = (ft0) entry.getKey();
        if (ft0Var.o().b == cw4.MESSAGE) {
            if (!ft0Var.y()) {
                Object value = entry.getValue();
                if (value instanceof ol2) {
                    return ((ol2) value).c();
                }
                if (value instanceof d92) {
                    return true;
                }
                xe.k("Wrong object type used with protocol message reflection.");
                return false;
            }
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj instanceof ol2) {
                    zC = ((ol2) obj).c();
                } else {
                    if (!(obj instanceof d92)) {
                        xe.k("Wrong object type used with protocol message reflection.");
                        return false;
                    }
                    zC = true;
                }
                if (!zC) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean l(aw4 aw4Var, Object obj) {
        Charset charset = i12.a;
        obj.getClass();
        switch (aw4Var.b) {
            case BYTE_STRING:
                if ((obj instanceof zt) || (obj instanceof byte[])) {
                }
                break;
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof g12)) {
                }
                break;
            case MESSAGE:
                if ((obj instanceof nl2) || (obj instanceof d92)) {
                }
                break;
        }
        return false;
    }

    public static void o(ft0 ft0Var, Object obj) {
        if (l(ft0Var.o(), obj)) {
            return;
        }
        zo2.p("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(ft0Var.z.Z), ft0Var.o().b, obj.getClass().getName()});
    }

    public static void p(q60 q60Var, aw4 aw4Var, int i, Object obj) {
        if (aw4Var != aw4.z) {
            q60Var.x(i, aw4Var.f);
            q(q60Var, aw4Var, obj);
        } else {
            q60Var.x(i, 3);
            ((nl2) obj).d(q60Var);
            q60Var.x(i, 4);
        }
    }

    public static void q(q60 q60Var, aw4 aw4Var, Object obj) throws a60 {
        int i;
        switch (aw4Var.ordinal()) {
            case 0:
                double dDoubleValue = ((Double) obj).doubleValue();
                q60Var.getClass();
                q60Var.r(Double.doubleToRawLongBits(dDoubleValue));
                return;
            case 1:
                float fFloatValue = ((Float) obj).floatValue();
                q60Var.getClass();
                q60Var.q(Float.floatToRawIntBits(fFloatValue));
                return;
            case 2:
                q60Var.B(((Long) obj).longValue());
                return;
            case 3:
                q60Var.B(((Long) obj).longValue());
                return;
            case 4:
                q60Var.t(((Integer) obj).intValue());
                return;
            case 5:
                q60Var.r(((Long) obj).longValue());
                return;
            case 6:
                q60Var.q(((Integer) obj).intValue());
                return;
            case 7:
                byte b = ((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0;
                int i2 = q60Var.c;
                try {
                    i = i2 + 1;
                } catch (IndexOutOfBoundsException e) {
                    e = e;
                }
                try {
                    q60Var.a[i2] = b;
                    q60Var.c = i;
                    return;
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                    i2 = i;
                    throw new a60(i2, q60Var.b, 1, e);
                }
            case 8:
                if (obj instanceof zt) {
                    q60Var.p((zt) obj);
                    return;
                } else {
                    q60Var.w((String) obj);
                    return;
                }
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                q60Var.getClass();
                ((nl2) obj).d(q60Var);
                return;
            case 10:
                nl2 nl2Var = (nl2) obj;
                q60Var.getClass();
                q60Var.z(nl2Var.h());
                nl2Var.d(q60Var);
                return;
            case 11:
                if (obj instanceof zt) {
                    q60Var.p((zt) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                q60Var.getClass();
                int length = bArr.length;
                q60Var.z(length);
                q60Var.m(bArr, 0, length);
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                q60Var.z(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof g12) {
                    q60Var.t(((g12) obj).a());
                    return;
                } else {
                    q60Var.t(((Integer) obj).intValue());
                    return;
                }
            case 14:
                q60Var.q(((Integer) obj).intValue());
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                q60Var.r(((Long) obj).longValue());
                return;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                Logger logger = q60.d;
                q60Var.z((iIntValue >> 31) ^ (iIntValue << 1));
                return;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                Logger logger2 = q60.d;
                q60Var.B((jLongValue >> 63) ^ (jLongValue << 1));
                return;
            default:
                return;
        }
    }

    public static void r(ft0 ft0Var, Object obj, q60 q60Var) {
        aw4 aw4VarO = ft0Var.o();
        int i = ft0Var.z.Z;
        if (!ft0Var.y()) {
            if (obj instanceof d92) {
                p(q60Var, aw4VarO, i, ((d92) obj).b());
                return;
            } else {
                p(q60Var, aw4VarO, i, obj);
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        int i2 = 0;
        if (!ft0Var.x()) {
            while (i2 < size) {
                p(q60Var, aw4VarO, i, list.get(i2));
                i2++;
            }
        } else {
            if (list.isEmpty()) {
                return;
            }
            q60Var.x(i, 2);
            int iD = 0;
            for (int i3 = 0; i3 < size; i3++) {
                iD += d(aw4VarO, list.get(i3));
            }
            q60Var.z(iD);
            while (i2 < size) {
                q(q60Var, aw4VarO, list.get(i2));
                i2++;
            }
        }
    }

    public static void s(Map.Entry entry, q60 q60Var) throws a60 {
        zt ztVar;
        ft0 ft0Var = (ft0) entry.getKey();
        if (ft0Var.o().b != cw4.MESSAGE || ft0Var.y() || ft0Var.x()) {
            r(ft0Var, entry.getValue(), q60Var);
            return;
        }
        Object value = entry.getValue();
        if (!(value instanceof d92)) {
            int i = ((ft0) entry.getKey()).z.Z;
            q60Var.x(1, 3);
            q60Var.y(2, i);
            q60Var.u(3, (nl2) value);
            q60Var.x(1, 4);
            return;
        }
        d92 d92Var = (d92) value;
        if (d92Var.d != null) {
            ztVar = d92Var.d;
        } else {
            ztVar = d92Var.a;
            if (ztVar == null) {
                synchronized (d92Var) {
                    try {
                        if (d92Var.d != null) {
                            ztVar = d92Var.d;
                        } else {
                            if (d92Var.c == null) {
                                d92Var.d = zt.z;
                            } else {
                                d92Var.d = d92Var.c.g();
                            }
                            ztVar = d92Var.d;
                        }
                    } finally {
                    }
                }
            }
        }
        q60Var.v(((ft0) entry.getKey()).z.Z, ztVar);
    }

    public final Object clone() {
        kd1 kd1Var = new kd1();
        jy3 jy3Var = this.a;
        int i = jy3Var.f;
        for (int i2 = 0; i2 < i; i2++) {
            ly3 ly3VarC = jy3Var.c(i2);
            kd1Var.n((ft0) ly3VarC.b, ly3VarC.f);
        }
        for (Map.Entry entry : jy3Var.d()) {
            kd1Var.n((ft0) entry.getKey(), entry.getValue());
        }
        kd1Var.c = this.c;
        return kd1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kd1) {
            return this.a.equals(((kd1) obj).a);
        }
        return false;
    }

    public final Map f() {
        boolean z = this.c;
        jy3 jy3Var = this.a;
        if (!z) {
            return jy3Var.A ? jy3Var : DesugarCollections.unmodifiableMap(jy3Var);
        }
        jy3 jy3VarA = a(jy3Var, false, true);
        if (jy3Var.A) {
            jy3VarA.f();
        }
        return jy3VarA;
    }

    public final int h() {
        jy3 jy3Var = this.a;
        int i = jy3Var.f;
        int iE = 0;
        for (int i2 = 0; i2 < i; i2++) {
            ly3 ly3VarC = jy3Var.c(i2);
            iE += e((ft0) ly3VarC.b, ly3VarC.f);
        }
        for (Map.Entry entry : jy3Var.d()) {
            iE += e((ft0) entry.getKey(), entry.getValue());
        }
        return iE;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean i(ft0 ft0Var) {
        if (!ft0Var.y()) {
            return this.a.get(ft0Var) != null;
        }
        xe.k("hasField() can only be called on non-repeated fields.");
        return false;
    }

    public final boolean j() {
        jy3 jy3Var = this.a;
        int i = jy3Var.f;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                Iterator it = jy3Var.d().iterator();
                while (it.hasNext()) {
                    if (!k((Map.Entry) it.next())) {
                    }
                }
                return true;
            }
            if (!k(jy3Var.c(i2))) {
                break;
            }
            i2++;
        }
        return false;
    }

    public final void m() {
        if (this.b) {
            return;
        }
        jy3 jy3Var = this.a;
        int i = jy3Var.f;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = jy3Var.c(i2).f;
        }
        Iterator it = jy3Var.d().iterator();
        while (it.hasNext()) {
            ((Map.Entry) it.next()).getValue();
        }
        jy3Var.f();
        this.b = true;
    }

    public final void n(ft0 ft0Var, Object obj) {
        if (!ft0Var.y()) {
            o(ft0Var, obj);
        } else {
            if (!(obj instanceof List)) {
                xe.k("Wrong object type used with protocol message reflection.");
                return;
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                o(ft0Var, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof d92) {
            this.c = true;
        }
        this.a.put(ft0Var, obj);
    }

    public kd1(jy3 jy3Var) {
        this.a = jy3Var;
        m();
    }
}
