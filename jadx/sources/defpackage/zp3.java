package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zp3 {
    public final Optional a;
    public final String b;

    public zp3(String str, Optional optional) {
        Objects.requireNonNull(optional);
        this.a = optional;
        this.b = str;
    }

    public zp3(int i, String str, Optional optional) {
        this.b = str;
        this.a = optional;
    }
}
