package io.sentry.config;

import defpackage.fw;
import io.sentry.util.p;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d {
    public final String a;
    public final Properties b;

    public e(String str, Properties properties) {
        this.a = str;
        io.sentry.util.b.r(properties, "properties are required");
        this.b = properties;
    }

    @Override // io.sentry.config.d
    public final Map a() {
        String strY = fw.y(new StringBuilder(), this.a, "tags.");
        HashMap map = new HashMap();
        for (Map.Entry entry : this.b.entrySet()) {
            if ((entry.getKey() instanceof String) && (entry.getValue() instanceof String)) {
                String str = (String) entry.getKey();
                if (str.startsWith(strY)) {
                    map.put(str.substring(strY.length()), p.c((String) entry.getValue()));
                }
            }
        }
        return map;
    }

    @Override // io.sentry.config.d
    public final String getProperty(String str) {
        return p.c(this.b.getProperty(this.a + str));
    }

    public e(Properties properties) {
        this("", properties);
    }
}
