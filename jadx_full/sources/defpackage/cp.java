package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cp implements e12 {
    public final /* synthetic */ int b = 1;
    public final Object f;

    public cp(ne0 ne0Var) {
        ne0Var.getClass();
        this.f = ne0Var;
    }

    public static int d(kk3 kk3Var, int i) {
        String strG = kk3.g(kk3Var, "Retry-After");
        if (strG == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        patternCompile.getClass();
        if (!patternCompile.matcher(strG).matches()) {
            return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        Integer numValueOf = Integer.valueOf(strG);
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v24 ye3, still in use, count: 2, list:
          (r0v24 ye3) from 0x0076: MOVE (r18v1 ye3) = (r0v24 ye3) (LINE:119)
          (r0v24 ye3) from 0x0062: MOVE (r18v4 ye3) = (r0v24 ye3) (LINE:99)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // defpackage.e12
    public final defpackage.kk3 a(defpackage.ve3 r37) {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cp.a(ve3):kk3");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public cm2 b(kk3 kk3Var, ue1 ue1Var) throws ProtocolException {
        dv1 dv1Var;
        kk3 kk3Var2;
        em3 em3Var = ue1Var != null ? ue1Var.k().c : null;
        int i = kk3Var.A;
        String str = (String) kk3Var.b.z;
        if (i == 307 || i == 308) {
            lu2 lu2Var = (lu2) this.f;
            if (lu2Var.h) {
                String strG = kk3.g(kk3Var, HttpHeaders.Names.LOCATION);
                cm2 cm2Var = kk3Var.b;
                if (strG != null) {
                    ev1 ev1Var = (ev1) cm2Var.f;
                    ev1Var.getClass();
                    try {
                        dv1Var = new dv1();
                        dv1Var.c(ev1Var, strG);
                    } catch (IllegalArgumentException unused) {
                        dv1Var = null;
                    }
                    ev1 ev1VarA = dv1Var != null ? dv1Var.a() : null;
                    if (ev1VarA != null && (n12.c(ev1VarA.a, ((ev1) cm2Var.f).a) || lu2Var.i)) {
                        v92 v92VarW = cm2Var.w();
                        if (ek0.z(str)) {
                            int i2 = kk3Var.A;
                            boolean z = str.equals("PROPFIND") || i2 == 308 || i2 == 307;
                            if (str.equals("PROPFIND") || i2 == 308 || i2 == 307) {
                                v92VarW.m(str, z ? (ej3) cm2Var.X : null);
                            } else {
                                v92VarW.m("GET", null);
                            }
                            if (!z) {
                                ((m20) v92VarW.z).a(HttpHeaders.Names.TRANSFER_ENCODING);
                                ((m20) v92VarW.z).a("Content-Length");
                                ((m20) v92VarW.z).a("Content-Type");
                            }
                        }
                        if (!jz4.a((ev1) cm2Var.f, ev1VarA)) {
                            ((m20) v92VarW.z).a("Authorization");
                        }
                        v92VarW.b = ev1VarA;
                        return new cm2(v92VarW);
                    }
                }
            }
        } else {
            if (i == 401) {
                return ((lu2) this.f).g.h(em3Var, kk3Var);
            }
            if (i != 421) {
                if (i == 503) {
                    kk3 kk3Var3 = kk3Var.B0;
                    if ((kk3Var3 == null || kk3Var3.A != 503) && d(kk3Var, ChannelUtils.WRITE_STATUS_SNDBUF_FULL) == 0) {
                        return kk3Var.b;
                    }
                } else {
                    if (i == 407) {
                        em3Var.getClass();
                        if (em3Var.b.type() != Proxy.Type.HTTP) {
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                        ((lu2) this.f).n.getClass();
                        return null;
                    }
                    if (i != 408) {
                        switch (i) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                            default:
                                return null;
                        }
                    } else if (((lu2) this.f).e && (((kk3Var2 = kk3Var.B0) == null || kk3Var2.A != 408) && d(kk3Var, 0) <= 0)) {
                        return kk3Var.b;
                    }
                }
            } else if (ue1Var != null && !n12.c(((s61) ue1Var.z).k().i.i.d, ((r61) ue1Var.A).j().g().a.i.d)) {
                me3 me3VarK = ue1Var.k();
                synchronized (me3VarK) {
                    me3VarK.k = true;
                }
                return kk3Var.b;
            }
        }
        return null;
    }

    public boolean c(IOException iOException, le3 le3Var, cm2 cm2Var) {
        boolean z = iOException instanceof bb0;
        if (!((lu2) this.f).e) {
            return false;
        }
        if ((!z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException)) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || !z) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        ue1 ue1Var = le3Var.H0;
        if (ue1Var == null || !ue1Var.f) {
            return false;
        }
        s61 s61Var = le3Var.Z;
        s61Var.getClass();
        ye3 ye3VarK = s61Var.k();
        ue1 ue1Var2 = le3Var.H0;
        return ye3VarK.a(ue1Var2 != null ? ue1Var2.k() : null);
    }

    public cp(lu2 lu2Var) {
        lu2Var.getClass();
        this.f = lu2Var;
    }
}
