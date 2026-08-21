package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jf5 {
    public static final oa5 a;
    public static final oa5 b;

    static {
        sn snVar = new sn(ma5.a(), true, true);
        snVar.v("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        snVar.v("measurement.set_default_event_parameters_with_backfill.service", true);
        snVar.t(0L, "measurement.id.set_default_event_parameters.fix_service_request_ordering");
        a = snVar.v("measurement.set_default_event_parameters.fix_app_update_logging", true);
        b = snVar.v("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        snVar.v("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }
}
