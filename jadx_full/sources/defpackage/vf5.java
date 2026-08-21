package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vf5 {
    public static final oa5 a;
    public static final oa5 b;
    public static final oa5 c;

    static {
        sn snVar = new sn(ma5.a(), true, true);
        snVar.v("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        a = snVar.v("measurement.audience.refresh_event_count_filters_timestamp", false);
        b = snVar.v("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        c = snVar.v("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
