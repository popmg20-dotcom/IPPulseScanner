package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.l1;
import io.sentry.p5;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final Charset a = Charset.forName("UTF-8");

    public static long a(l1 l1Var, ILogger iLogger, k2 k2Var) {
        try {
            c cVar = new c();
            l1Var.a(k2Var, cVar);
            return cVar.b;
        } catch (Throwable th) {
            iLogger.d(p5.ERROR, "Could not calculate size of serializable", th);
            return 0L;
        }
    }

    public static HashMap b(Calendar calendar) {
        HashMap map = new HashMap();
        map.put("year", Integer.valueOf(calendar.get(1)));
        map.put("month", Integer.valueOf(calendar.get(2)));
        map.put("dayOfMonth", Integer.valueOf(calendar.get(5)));
        map.put("hourOfDay", Integer.valueOf(calendar.get(11)));
        map.put("minute", Integer.valueOf(calendar.get(12)));
        map.put("second", Integer.valueOf(calendar.get(13)));
        return map;
    }
}
