package defpackage;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class sb3 {
    public static final bu b = new bu(Arrays.copyOf(new byte[]{42}, 1));
    public static final List c = p95.x(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
    public static final sb3 d = new sb3(new cm2(3));
    public final cm2 a;

    public sb3(cm2 cm2Var) {
        this.a = cm2Var;
    }

    public static List b(String str) {
        List listK0 = p44.K0(str, new char[]{'.'}, 6);
        if (!n12.c(d70.k0(listK0), "")) {
            return listK0;
        }
        int size = listK0.size() - 1;
        return d70.v0(size >= 0 ? size : 0, listK0);
    }

    public final String a(String str) {
        String strD;
        String strD2;
        String strD3;
        List listK0;
        int size;
        int size2;
        str.getClass();
        String unicode = IDN.toUnicode(str);
        unicode.getClass();
        List listB = b(unicode);
        cm2 cm2Var = this.a;
        AtomicBoolean atomicBoolean = (AtomicBoolean) cm2Var.f;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                ((CountDownLatch) cm2Var.z).await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        try {
                            cm2Var.z();
                            break;
                        } catch (InterruptedIOException unused2) {
                            Thread.interrupted();
                            z = true;
                        }
                    } catch (IOException e) {
                        cm2Var.Y = e;
                        if (z) {
                        }
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (((bu) cm2Var.A) == null) {
            StringBuilder sb = new StringBuilder("Unable to load ");
            sb.append(cm2Var.Z);
            sb.append(" resource.");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            illegalStateException.initCause((IOException) cm2Var.Y);
            throw illegalStateException;
        }
        int size3 = listB.size();
        bu[] buVarArr = new bu[size3];
        for (int i = 0; i < size3; i++) {
            bu buVar = bu.A;
            buVarArr[i] = t60.n((String) listB.get(i));
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                strD = null;
                break;
            }
            bu buVar2 = (bu) cm2Var.A;
            if (buVar2 == null) {
                n12.T("bytes");
                throw null;
            }
            strD = uf2.d(buVar2, buVarArr, i2);
            if (strD != null) {
                break;
            }
            i2++;
        }
        if (size3 > 1) {
            bu[] buVarArr2 = (bu[]) buVarArr.clone();
            int length = buVarArr2.length - 1;
            for (int i3 = 0; i3 < length; i3++) {
                buVarArr2[i3] = b;
                bu buVar3 = (bu) cm2Var.A;
                if (buVar3 == null) {
                    n12.T("bytes");
                    throw null;
                }
                strD2 = uf2.d(buVar3, buVarArr2, i3);
                if (strD2 != null) {
                    break;
                }
            }
            strD2 = null;
        } else {
            strD2 = null;
        }
        if (strD2 != null) {
            int i4 = size3 - 1;
            for (int i5 = 0; i5 < i4; i5++) {
                bu buVar4 = (bu) cm2Var.X;
                if (buVar4 == null) {
                    n12.T("exceptionBytes");
                    throw null;
                }
                strD3 = uf2.d(buVar4, buVarArr, i5);
                if (strD3 != null) {
                    break;
                }
            }
            strD3 = null;
        } else {
            strD3 = null;
        }
        if (strD3 != null) {
            listK0 = p44.K0("!".concat(strD3), new char[]{'.'}, 6);
        } else if (strD == null && strD2 == null) {
            listK0 = c;
        } else {
            List listK02 = g41.b;
            List listK03 = strD != null ? p44.K0(strD, new char[]{'.'}, 6) : listK02;
            if (strD2 != null) {
                listK02 = p44.K0(strD2, new char[]{'.'}, 6);
            }
            listK0 = listK03.size() > listK02.size() ? listK03 : listK02;
        }
        if (listB.size() == listK0.size() && ((String) listK0.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listK0.get(0)).charAt(0) == '!') {
            size = listB.size();
            size2 = listK0.size();
        } else {
            size = listB.size();
            size2 = listK0.size() + 1;
        }
        int i6 = size - size2;
        ss3 j70Var = new j70(0, b(str));
        if (i6 < 0) {
            e04.f(ha0.k("Requested element count ", i6, " is less than zero."));
            return null;
        }
        if (i6 != 0) {
            j70Var = j70Var instanceof qy0 ? ((qy0) j70Var).a(i6) : new py0(j70Var, i6);
        }
        return ws3.U(j70Var, ".");
    }
}
