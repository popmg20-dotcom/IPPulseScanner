package defpackage;

import io.github.rosemoe.oniguruma.OnigNative;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bp2 implements tv2 {
    public final String a;
    public long b;

    public bp2(String str, boolean z) {
        this.a = str;
        long jNewRegex = OnigNative.newRegex(str, z);
        this.b = jNewRegex;
        if (jNewRegex == 0) {
            throw new r94(ha0.o("Parsing regex pattern \"", str, "\" failed"));
        }
    }

    @Override // defpackage.tv2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final g20 a(zv2 zv2Var) {
        int[] iArrRegexSearch = OnigNative.regexSearch(this.b, zv2Var.d, zv2Var.c, 0, zv2Var.b);
        if (iArrRegexSearch != null) {
            return new g20(iArrRegexSearch, false);
        }
        return null;
    }

    public final void finalize() throws Throwable {
        try {
            long j = this.b;
            if (j != 0) {
                OnigNative.releaseRegex(j);
                this.b = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    @Override // defpackage.tv2
    public final String pattern() {
        return this.a;
    }

    public final String toString() {
        return m44.e(this, new dg(9, this));
    }
}
