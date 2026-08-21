package org.conscrypt;

import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public interface CertPinManager {
    void checkChainPinning(String str, List<X509Certificate> list);
}
