package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lg5 {
    public static final oa5 a;
    public static final oa5 b;
    public static final oa5 c;
    public static final oa5 d;
    public static final oa5 e;
    public static final oa5 f;

    static {
        sn snVar = new sn(ma5.a(), true, true);
        a = snVar.v("measurement.test.boolean_flag", false);
        b = snVar.t(-1L, "measurement.test.cached_long_flag");
        Double dValueOf = Double.valueOf(-3.0d);
        Object obj = oa5.g;
        c = new oa5(snVar, "measurement.test.double_flag", dValueOf, 2);
        d = snVar.t(-2L, "measurement.test.int_flag");
        e = snVar.t(-1L, "measurement.test.long_flag");
        f = snVar.y("measurement.test.string_flag", "---");
    }
}
