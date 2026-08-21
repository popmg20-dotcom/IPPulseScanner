package io.sentry;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum r4 {
    STRING,
    BOOLEAN,
    INTEGER,
    DOUBLE,
    ARRAY;

    public static r4 inferFrom(Object obj) {
        return obj instanceof Boolean ? BOOLEAN : ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof BigInteger) || (obj instanceof AtomicInteger) || (obj instanceof AtomicLong)) ? INTEGER : obj instanceof Number ? DOUBLE : ((obj instanceof Collection) || (obj != null && obj.getClass().isArray())) ? ARRAY : STRING;
    }

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
