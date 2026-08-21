package defpackage;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mj2 extends oj2 {
    /* JADX WARN: Illegal instructions before constructor call */
    public mj2(Context context, int i) {
        context.getClass();
        switch (i) {
            case 1:
                Object systemService = context.getSystemService((Class<Object>) MeasurementManager.class);
                systemService.getClass();
                super((MeasurementManager) systemService);
                break;
            default:
                MeasurementManager measurementManager = MeasurementManager.get(context);
                measurementManager.getClass();
                super(measurementManager);
                break;
        }
    }
}
