package defpackage;

import j$.util.Objects;
import j$.util.Optional;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ex0 extends x51 {
    public final boolean c;
    public final Map d;

    public ex0(boolean z, Optional optional, Map map, Optional optional2, Optional optional3) {
        super(optional2, optional3);
        this.c = z;
        Objects.requireNonNull(optional);
        Objects.requireNonNull(map);
        this.d = map;
    }

    @Override // defpackage.x51
    public final int a() {
        return 4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("+DOC");
        if (this.c) {
            sb.append(" ---");
        }
        return sb.toString();
    }
}
