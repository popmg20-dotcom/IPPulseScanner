package defpackage;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d65 extends u55 {
    public String A0;
    public long B0;
    public final long C0;
    public final long D0;
    public List E0;
    public String F0;
    public int G0;
    public String H0;
    public String I0;
    public long J0;
    public String K0;
    public String Y;
    public String Z;
    public int y0;
    public String z0;

    public d65(k85 k85Var, long j, long j2) {
        super(k85Var);
        this.J0 = 0L;
        this.K0 = null;
        this.C0 = j;
        this.D0 = j2;
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x025d  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.tg5 Z0(java.lang.String r47) {
        /*
            Method dump skipped, instruction units count: 832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d65.Z0(java.lang.String):tg5");
    }

    public final void a1() {
        String str;
        V0();
        k85 k85Var = (k85) this.f;
        l75 l75Var = k85Var.X;
        t65 t65Var = k85Var.Y;
        k85.f(l75Var);
        if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            qf5 qf5Var = k85Var.z0;
            k85.f(qf5Var);
            qf5Var.U1().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            k85.h(t65Var);
            t65Var.G0.a("Analytics Storage consent is not granted");
            str = null;
        }
        k85.h(t65Var);
        t65Var.G0.a("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.I0 = str;
        k85Var.B0.getClass();
        this.J0 = System.currentTimeMillis();
    }

    public final String b1() {
        W0();
        tj4.i(this.Y);
        return this.Y;
    }

    public final String c1() {
        V0();
        W0();
        tj4.i(this.H0);
        return this.H0;
    }
}
