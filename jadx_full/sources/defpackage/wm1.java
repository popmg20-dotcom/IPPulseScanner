package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wm1 {
    public static final wm1 b = new wm1(true);
    public final boolean a;

    public wm1(boolean z) {
        this.a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof wm1) && this.a == ((wm1) obj).a;
    }

    public final int hashCode() {
        return ((this.a ? 1231 : 1237) * 31) + 1231;
    }

    public final String toString() {
        return "FuzzyScoreOptions(firstMatchCanBeWeak=" + this.a + ", boostFullMatch=true)";
    }
}
