package defpackage;

import j$.time.Duration;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class j83 implements to2 {
    public final String b;
    public final Class f = Duration.class;
    public final Optional z;

    public j83(String str, Duration duration) {
        this.b = n12.g(str, "No name provided");
        this.z = Optional.ofNullable(duration);
    }

    @Override // defpackage.to2
    public final String getName() {
        return this.b;
    }

    public final String toString() {
        return "Property[" + this.b + "](" + this.f.getSimpleName() + "]";
    }
}
