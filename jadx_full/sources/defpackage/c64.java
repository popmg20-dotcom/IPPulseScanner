package defpackage;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c64 implements go3 {
    public final gl1 b;

    public c64(gl1 gl1Var) {
        gl1Var.getClass();
        this.b = gl1Var;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // defpackage.go3
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final l64 D0(String str) {
        int i;
        str.getClass();
        gl1 gl1Var = this.b;
        gl1Var.getClass();
        String upperCase = p44.U0(str).toString().toUpperCase(Locale.ROOT);
        upperCase.getClass();
        int length = upperCase.length() - 2;
        int i2 = -1;
        if (length >= 0) {
            int iU0 = 0;
            loop0: while (iU0 < length) {
                char cCharAt = upperCase.charAt(iU0);
                if (n12.l(cCharAt, 32) > 0) {
                    if (cCharAt != '-') {
                        if (cCharAt == '/') {
                            int iU02 = iU0 + 1;
                            if (upperCase.charAt(iU02) == '*') {
                                do {
                                    iU02 = p44.u0(upperCase, '*', iU02 + 1, 4);
                                    if (iU02 >= 0) {
                                        i = iU02 + 1;
                                        if (i >= length) {
                                            break;
                                        }
                                    } else {
                                        break loop0;
                                    }
                                } while (upperCase.charAt(i) != '/');
                                iU0 = iU02 + 2;
                            }
                        }
                        i2 = iU0;
                        break;
                    }
                    if (upperCase.charAt(iU0 + 1) == '-') {
                        iU0 = p44.u0(upperCase, '\n', iU0 + 2, 4);
                        if (iU0 < 0) {
                            break;
                        }
                    } else {
                        i2 = iU0;
                        break;
                    }
                }
                iU0++;
            }
        }
        String strSubstring = (i2 < 0 || i2 > upperCase.length()) ? null : upperCase.substring(i2, Math.min(i2 + 3, upperCase.length()));
        if (strSubstring == null) {
            return new k64(gl1Var, str);
        }
        int iHashCode = strSubstring.hashCode();
        if (iHashCode == 79487 ? !strSubstring.equals("PRA") : iHashCode == 81978 ? !strSubstring.equals("SEL") : !(iHashCode == 85954 && strSubstring.equals("WIT"))) {
            return new k64(gl1Var, str);
        }
        j64 j64Var = new j64(gl1Var, str);
        j64Var.A = new int[0];
        j64Var.X = new long[0];
        j64Var.Y = new double[0];
        j64Var.Z = new String[0];
        j64Var.y0 = new byte[0][];
        return j64Var;
    }
}
