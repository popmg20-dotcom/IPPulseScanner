package defpackage;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.VMPCRandomGenerator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class so extends n1 {
    public so() {
        nr3.h();
        n12.i("BouncyCastle not registered", nr3.c("BC") != null);
        new VMPCRandomGenerator().addSeedMaterial(new SecureRandom().generateSeed(8));
    }

    @Override // defpackage.to2
    public final String getName() {
        return "BC";
    }
}
