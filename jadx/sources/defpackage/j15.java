package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j15 implements d25 {
    public final boolean b;

    public j15(Boolean bool) {
        this.b = bool == null ? false : bool.booleanValue();
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.valueOf(this.b);
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j15) && this.b == ((j15) obj).b;
    }

    @Override // defpackage.d25
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        boolean zEquals = "toString".equals(str);
        boolean z = this.b;
        if (zEquals) {
            return new i25(Boolean.toString(z));
        }
        throw new IllegalArgumentException(Boolean.toString(z) + "." + str + " is not a function.");
    }

    @Override // defpackage.d25
    public final Double g() {
        return Double.valueOf(true != this.b ? 0.0d : 1.0d);
    }

    @Override // defpackage.d25
    public final String h() {
        return Boolean.toString(this.b);
    }

    public final int hashCode() {
        return Boolean.valueOf(this.b).hashCode();
    }

    @Override // defpackage.d25
    public final d25 i() {
        return new j15(Boolean.valueOf(this.b));
    }

    public final String toString() {
        return String.valueOf(this.b);
    }
}
