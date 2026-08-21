package io.netty.handler.ssl.util;

import defpackage.xe;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FingerprintTrustManagerFactoryBuilder {
    private final String algorithm;
    private final List<String> fingerprints = new ArrayList();

    public FingerprintTrustManagerFactoryBuilder(String str) {
        this.algorithm = (String) ObjectUtil.checkNotNull(str, "algorithm");
    }

    public FingerprintTrustManagerFactory build() {
        if (!this.fingerprints.isEmpty()) {
            return new FingerprintTrustManagerFactory(this.algorithm, FingerprintTrustManagerFactory.toFingerprintArray(this.fingerprints));
        }
        xe.q("No fingerprints provided");
        return null;
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(Iterable<? extends CharSequence> iterable) {
        ObjectUtil.checkNotNull(iterable, "fingerprints");
        for (CharSequence charSequence : iterable) {
            ObjectUtil.checkNotNullWithIAE(charSequence, "fingerprint");
            this.fingerprints.add(charSequence.toString());
        }
        return this;
    }

    public FingerprintTrustManagerFactoryBuilder fingerprints(CharSequence... charSequenceArr) {
        return fingerprints(Arrays.asList((Object[]) ObjectUtil.checkNotNull(charSequenceArr, "fingerprints")));
    }
}
