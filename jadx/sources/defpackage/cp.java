package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.cm2 b(defpackage.kk3 r11, defpackage.ue1 r12) throws java.net.ProtocolException {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cp.b(kk3, ue1):cm2");
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
