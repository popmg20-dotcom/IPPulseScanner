package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ub5 {
    public static final /* synthetic */ int c = 0;
    public final xd5 a = new xd5();
    public boolean b;

    static {
        new ub5(0);
    }

    public ub5(int i) {
        a();
        a();
    }

    public static void b(kb5 kb5Var, se5 se5Var, int i, Object obj) throws a60 {
        if (se5Var == se5.A) {
            Charset charset = nc5.a;
            kb5Var.c(i, 3);
            ((dc5) ((va5) obj)).c(kb5Var);
            kb5Var.c(i, 4);
            return;
        }
        kb5Var.c(i, se5Var.f);
        ue5 ue5Var = ue5.b;
        switch (se5Var.ordinal()) {
            case 0:
                kb5Var.o(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                kb5Var.m(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                kb5Var.n(((Long) obj).longValue());
                break;
            case 3:
                kb5Var.n(((Long) obj).longValue());
                break;
            case 4:
                kb5Var.k(((Integer) obj).intValue());
                break;
            case 5:
                kb5Var.o(((Long) obj).longValue());
                break;
            case 6:
                kb5Var.m(((Integer) obj).intValue());
                break;
            case 7:
                kb5Var.j(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof hb5)) {
                    kb5Var.q((String) obj);
                } else {
                    kb5Var.i((hb5) obj);
                }
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((dc5) ((va5) obj)).c(kb5Var);
                break;
            case 10:
                dc5 dc5Var = (dc5) ((va5) obj);
                kb5Var.l(dc5Var.i());
                dc5Var.c(kb5Var);
                break;
            case 11:
                if (!(obj instanceof hb5)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    kb5Var.l(length);
                    kb5Var.p(length, bArr);
                } else {
                    kb5Var.i((hb5) obj);
                }
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                kb5Var.l(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof hc5)) {
                    kb5Var.k(((Integer) obj).intValue());
                } else {
                    kb5Var.k(((hc5) obj).a());
                }
                break;
            case 14:
                kb5Var.m(((Integer) obj).intValue());
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                kb5Var.o(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                kb5Var.l((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                kb5Var.n((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public final void a() {
        if (this.b) {
            return;
        }
        xd5 xd5Var = this.a;
        int i = xd5Var.f;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = xd5Var.a(i2).f;
            if (obj instanceof dc5) {
                dc5 dc5Var = (dc5) obj;
                od5.c.a(dc5Var.getClass()).g(dc5Var);
                dc5Var.e();
            }
        }
        Iterator it = xd5Var.b().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof dc5) {
                dc5 dc5Var2 = (dc5) value;
                od5.c.a(dc5Var2.getClass()).g(dc5Var2);
                dc5Var2.e();
            }
        }
        if (!xd5Var.A) {
            if (xd5Var.f > 0) {
                xd5Var.a(0).b.getClass();
                st4.n();
                return;
            } else {
                Iterator it2 = xd5Var.b().iterator();
                if (it2.hasNext()) {
                    ((Map.Entry) it2.next()).getKey().getClass();
                    st4.n();
                    return;
                }
            }
        }
        if (!xd5Var.A) {
            xd5Var.z = xd5Var.z.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(xd5Var.z);
            xd5Var.Y = xd5Var.Y.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(xd5Var.Y);
            xd5Var.A = true;
        }
        this.b = true;
    }

    public final Object clone() {
        ub5 ub5Var = new ub5();
        xd5 xd5Var = this.a;
        if (xd5Var.f > 0) {
            xd5Var.a(0).b.getClass();
            st4.n();
            return null;
        }
        Iterator it = xd5Var.b().iterator();
        if (!it.hasNext()) {
            return ub5Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            st4.n();
            return null;
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ub5) {
            return this.a.equals(((ub5) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public ub5() {
    }
}
