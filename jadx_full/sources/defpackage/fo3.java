package defpackage;

import org.bouncycastle.pqc.crypto.ntruprime.SNTRUPrimeParameters;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class fo3 {
    public static boolean a() {
        if (nr3.g()) {
            return false;
        }
        return SNTRUPrimeParameters.sntrup761.getSessionKeySize() == 256;
    }
}
