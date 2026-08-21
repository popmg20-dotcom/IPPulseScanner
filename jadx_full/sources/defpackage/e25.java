package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e25 implements d25 {
    public final String b;
    public final ArrayList f;

    public e25(String str, ArrayList arrayList) {
        this.b = str;
        ArrayList arrayList2 = new ArrayList();
        this.f = arrayList2;
        arrayList2.addAll(arrayList);
    }

    @Override // defpackage.d25
    public final Boolean d() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e25)) {
            return false;
        }
        e25 e25Var = (e25) obj;
        String str = e25Var.b;
        String str2 = this.b;
        if (str2 != null) {
            if (!str2.equals(str)) {
                return false;
            }
        } else if (str != null) {
            return false;
        }
        return this.f.equals(e25Var.f);
    }

    @Override // defpackage.d25
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // defpackage.d25
    public final Double g() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override // defpackage.d25
    public final String h() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final int hashCode() {
        String str = this.b;
        return this.f.hashCode() + ((str != null ? str.hashCode() : 0) * 31);
    }

    @Override // defpackage.d25
    public final d25 i() {
        return this;
    }
}
