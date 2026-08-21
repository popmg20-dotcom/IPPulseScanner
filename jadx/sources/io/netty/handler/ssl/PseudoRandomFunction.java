package io.netty.handler.ssl;

import defpackage.ha0;
import defpackage.st4;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class PseudoRandomFunction {
    private PseudoRandomFunction() {
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, bArrCopyOf, bArr.length, bArr2.length);
        return bArrCopyOf;
    }

    public static byte[] hash(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, String str) {
        ObjectUtil.checkPositiveOrZero(i, "length");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(bArr, str));
            int iCeil = (int) Math.ceil(((double) i) / ((double) mac.getMacLength()));
            byte[] bArrConcat = EmptyArrays.EMPTY_BYTES;
            byte[] bArrConcat2 = concat(bArr2, bArr3);
            byte[] bArrDoFinal = bArrConcat2;
            for (int i2 = 0; i2 < iCeil; i2++) {
                bArrDoFinal = mac.doFinal(bArrDoFinal);
                bArrConcat = concat(bArrConcat, mac.doFinal(concat(bArrDoFinal, bArrConcat2)));
            }
            return Arrays.copyOf(bArrConcat, i);
        } catch (GeneralSecurityException e) {
            st4.l(ha0.n("Could not find algo: ", str), e);
            return null;
        }
    }
}
