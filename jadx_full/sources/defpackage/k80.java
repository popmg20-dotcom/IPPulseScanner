package defpackage;

import j$.time.Duration;
import j$.util.DesugarCollections;
import j$.util.Optional;
import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k80 {
    public static final j83 a;

    static {
        dw2.v("allow-insecure-auth", false);
        dw2.v("allow-non-integrity-auth", false);
        zt3 zt3Var = zt3.b;
        n12.g("session-connection-heartbeat-type", "No name provided");
        Optional.ofNullable(zt3Var);
        DesugarCollections.unmodifiableSet(EnumSet.allOf(zt3.class));
        Duration duration = Duration.ZERO;
        n12.g("session-connection-heartbeat-interval", "No name provided");
        Optional.ofNullable(duration);
        n12.g("sshd-hexdump-chunk-size", "No name provided");
        Optional.ofNullable(64);
        a = new j83("sshd-close-wait-time", Duration.ofSeconds(15L));
    }
}
