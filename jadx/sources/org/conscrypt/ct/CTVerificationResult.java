package org.conscrypt.ct;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import org.conscrypt.ct.VerifiedSCT;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class CTVerificationResult {
    private final ArrayList<VerifiedSCT> validSCTs = new ArrayList<>();
    private final ArrayList<VerifiedSCT> invalidSCTs = new ArrayList<>();

    public void add(VerifiedSCT verifiedSCT) {
        if (verifiedSCT.status == VerifiedSCT.Status.VALID) {
            this.validSCTs.add(verifiedSCT);
        } else {
            this.invalidSCTs.add(verifiedSCT);
        }
    }

    public List<VerifiedSCT> getInvalidSCTs() {
        return DesugarCollections.unmodifiableList(this.invalidSCTs);
    }

    public List<VerifiedSCT> getValidSCTs() {
        return DesugarCollections.unmodifiableList(this.validSCTs);
    }
}
