package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a25 implements d25 {
    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.FALSE;
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof a25;
    }

    @Override // defpackage.d25
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        throw new IllegalStateException("null has no function ".concat(str));
    }

    @Override // defpackage.d25
    public final Double g() {
        return Double.valueOf(0.0d);
    }

    @Override // defpackage.d25
    public final String h() {
        return "null";
    }

    public final int hashCode() {
        return 1;
    }

    @Override // defpackage.d25
    public final d25 i() {
        return d25.r0;
    }
}
