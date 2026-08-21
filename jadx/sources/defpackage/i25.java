package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i25 implements Iterable, d25 {
    public final String b;

    public i25(String str) {
        if (str != null) {
            this.b = str;
        } else {
            xe.k("StringValue cannot be null.");
            throw null;
        }
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.valueOf(!this.b.isEmpty());
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return new f25(this, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i25) {
            return this.b.equals(((i25) obj).b);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e4 A[PHI: r8
      0x02e4: PHI (r8v6 boolean) = (r8v12 boolean), (r8v13 boolean), (r8v16 boolean) binds: [B:100:0x02d0, B:101:0x02d2, B:103:0x02e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ee A[LOOP:0: B:108:0x02ec->B:109:0x02ee, LOOP_END] */
    @Override // defpackage.d25
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.d25 f(java.lang.String r29, defpackage.ih4 r30, java.util.ArrayList r31) {
        /*
            Method dump skipped, instruction units count: 1606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i25.f(java.lang.String, ih4, java.util.ArrayList):d25");
    }

    @Override // defpackage.d25
    public final Double g() {
        String str = this.b;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // defpackage.d25
    public final String h() {
        return this.b;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.d25
    public final d25 i() {
        return new i25(this.b);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new f25(this, 1);
    }

    public final String toString() {
        String str = this.b;
        return fw.z(new StringBuilder(str.length() + 2), "\"", str, "\"");
    }
}
