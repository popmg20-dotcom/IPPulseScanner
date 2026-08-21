package defpackage;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uk4 extends ue4 implements ee0 {
    public static final char[] X = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final Boolean A;

    public uk4(Boolean bool) {
        super(UUID.class);
        this.A = bool;
    }

    public static final void p(int i, int i2, byte[] bArr) {
        bArr[i2] = (byte) (i >> 24);
        bArr[i2 + 1] = (byte) (i >> 16);
        bArr[i2 + 2] = (byte) (i >> 8);
        bArr[i2 + 3] = (byte) i;
    }

    public static void q(char[] cArr, int i, int i2) {
        char[] cArr2 = X;
        cArr[i2] = cArr2[(i >> 12) & 15];
        cArr[i2 + 1] = cArr2[(i >> 8) & 15];
        cArr[i2 + 2] = cArr2[(i >> 4) & 15];
        cArr[i2 + 3] = cArr2[i & 15];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r2, defpackage.nm r3) {
        /*
            r1 = this;
            java.lang.Class r0 = r1.b
            e52 r2 = defpackage.l34.k(r2, r3, r0)
            if (r2 == 0) goto L18
            d52 r2 = r2.f
            d52 r3 = defpackage.d52.A0
            if (r2 != r3) goto L11
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L19
        L11:
            d52 r3 = defpackage.d52.z0
            if (r2 != r3) goto L18
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L19
        L18:
            r2 = 0
        L19:
            java.lang.Boolean r3 = r1.A
            boolean r3 = j$.util.Objects.equals(r2, r3)
            if (r3 != 0) goto L26
            uk4 r1 = new uk4
            r1.<init>(r2)
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uk4.a(gt3, nm):b72");
    }

    @Override // defpackage.ue4, defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        UUID uuid = (UUID) obj;
        return uuid.getLeastSignificantBits() == 0 && uuid.getMostSignificantBits() == 0;
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        boolean zBooleanValue;
        UUID uuid = (UUID) obj;
        Boolean bool = this.A;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            i52Var.getClass();
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            byte[] bArr = new byte[16];
            long mostSignificantBits = uuid.getMostSignificantBits();
            long leastSignificantBits = uuid.getLeastSignificantBits();
            p((int) (mostSignificantBits >> 32), 0, bArr);
            p((int) mostSignificantBits, 4, bArr);
            p((int) (leastSignificantBits >> 32), 8, bArr);
            p((int) leastSignificantBits, 12, bArr);
            i52Var.getClass();
            i52Var.C(zj.a, bArr, 0, 16);
            return;
        }
        char[] cArr = new char[36];
        long mostSignificantBits2 = uuid.getMostSignificantBits();
        int i = (int) (mostSignificantBits2 >> 32);
        q(cArr, i >> 16, 0);
        q(cArr, i, 4);
        cArr[8] = '-';
        int i2 = (int) mostSignificantBits2;
        q(cArr, i2 >>> 16, 9);
        cArr[13] = '-';
        q(cArr, i2, 14);
        cArr[18] = '-';
        long leastSignificantBits2 = uuid.getLeastSignificantBits();
        q(cArr, (int) (leastSignificantBits2 >>> 48), 19);
        cArr[23] = '-';
        q(cArr, (int) (leastSignificantBits2 >>> 32), 24);
        int i3 = (int) leastSignificantBits2;
        q(cArr, i3 >> 16, 28);
        q(cArr, i3, 32);
        i52Var.H0(cArr, 0, 36);
    }
}
