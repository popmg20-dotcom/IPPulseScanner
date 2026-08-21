package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ld1 {
    public static final /* synthetic */ int c = 0;
    public final ky3 a = ky3.f();
    public boolean b;

    static {
        new ld1(0);
    }

    public ld1(int i) {
        a();
        a();
    }

    public static void b(r60 r60Var, bw4 bw4Var, int i, Object obj) {
        if (bw4Var == bw4.A) {
            r60Var.B(i, 3);
            ((d1) obj).b(r60Var);
            r60Var.B(i, 4);
        }
        r60Var.B(i, bw4Var.f);
        switch (bw4Var.ordinal()) {
            case 0:
                r60Var.u(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                r60Var.s(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                r60Var.F(((Long) obj).longValue());
                break;
            case 3:
                r60Var.F(((Long) obj).longValue());
                break;
            case 4:
                r60Var.w(((Integer) obj).intValue());
                break;
            case 5:
                r60Var.u(((Long) obj).longValue());
                break;
            case 6:
                r60Var.s(((Integer) obj).intValue());
                break;
            case 7:
                r60Var.m(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof au)) {
                    r60Var.A((String) obj);
                } else {
                    r60Var.q((au) obj);
                }
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((d1) obj).b(r60Var);
                break;
            case 10:
                d1 d1Var = (d1) obj;
                r60Var.D(((co1) d1Var).a(null));
                d1Var.b(r60Var);
                break;
            case 11:
                if (!(obj instanceof au)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    r60Var.D(length);
                    r60Var.n(bArr, 0, length);
                } else {
                    r60Var.q((au) obj);
                }
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                r60Var.D(((Integer) obj).intValue());
                break;
            case 13:
                r60Var.w(((Integer) obj).intValue());
                break;
            case 14:
                r60Var.s(((Integer) obj).intValue());
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                r60Var.u(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                r60Var.D((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                r60Var.F((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.b) {
            return;
        }
        ky3 ky3Var = this.a;
        int size = ky3Var.b.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryC = ky3Var.c(i);
            if (entryC.getValue() instanceof co1) {
                co1 co1Var = (co1) entryC.getValue();
                co1Var.getClass();
                v93 v93Var = v93.c;
                v93Var.getClass();
                v93Var.a(co1Var.getClass()).b(co1Var);
                co1Var.h();
            }
        }
        if (!ky3Var.z) {
            if (ky3Var.b.size() > 0) {
                ky3Var.c(0).getKey().getClass();
                st4.n();
                return;
            } else {
                Iterator it = ky3Var.d().iterator();
                if (it.hasNext()) {
                    ((Map.Entry) it.next()).getKey().getClass();
                    st4.n();
                    return;
                }
            }
        }
        if (!ky3Var.z) {
            ky3Var.f = ky3Var.f.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(ky3Var.f);
            ky3Var.X = ky3Var.X.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(ky3Var.X);
            ky3Var.z = true;
        }
        this.b = true;
    }

    public final Object clone() {
        ld1 ld1Var = new ld1();
        ky3 ky3Var = this.a;
        if (ky3Var.b.size() > 0) {
            Map.Entry entryC = ky3Var.c(0);
            if (entryC.getKey() != null) {
                st4.n();
                return null;
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = ky3Var.d().iterator();
        if (!it.hasNext()) {
            return ld1Var;
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
        if (obj instanceof ld1) {
            return this.a.equals(((ld1) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public ld1() {
    }
}
