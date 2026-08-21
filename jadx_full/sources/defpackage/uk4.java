package defpackage;

import j$.util.Objects;
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
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        Boolean bool;
        e52 e52VarK = l34.k(gt3Var, nmVar, this.b);
        if (e52VarK == null) {
            bool = null;
        } else {
            d52 d52Var = e52VarK.f;
            if (d52Var == d52.A0) {
                bool = Boolean.TRUE;
            } else if (d52Var == d52.z0) {
                bool = Boolean.FALSE;
            }
        }
        return !Objects.equals(bool, this.A) ? new uk4(bool) : this;
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
