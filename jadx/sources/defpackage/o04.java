package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o04 {
    public static final o04 b = new o04(0);
    public static final o04 c = new o04(1);
    public static final o04 d = new o04(2);
    public final int a;

    public o04(int i) {
        this.a = i;
    }

    public final String toString() {
        int i = this.a;
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "SplitSupportStatus: ERROR_SPLIT_PROPERTY_NOT_DECLARED" : "SplitSupportStatus: UNAVAILABLE" : "SplitSupportStatus: AVAILABLE";
    }
}
