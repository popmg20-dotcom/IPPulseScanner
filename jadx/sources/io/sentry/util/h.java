package io.sentry.util;

import defpackage.vp1;
import io.sentry.ILogger;
import io.sentry.m3;
import io.sentry.p5;
import io.sentry.x1;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h implements m3 {
    public final ArrayDeque b;

    public h(Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.b = arrayDeque;
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, map));
    }

    @Override // io.sentry.m3
    public final void B0() throws IOException {
        ArrayDeque arrayDeque = this.b;
        Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
        if (entry == null) {
            vp1.i("No more entries");
            return;
        }
        Object value = entry.getValue();
        if (!(value instanceof List)) {
            vp1.i("Current token is not an object");
            return;
        }
        arrayDeque.removeLast();
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, io.sentry.vendor.gson.stream.b.END_ARRAY));
        List list = (List) value;
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayDeque.addLast(new AbstractMap.SimpleEntry(null, list.get(size)));
        }
    }

    @Override // io.sentry.m3
    public final TimeZone E(ILogger iLogger) {
        String str = (String) g();
        if (str != null) {
            return DesugarTimeZone.getTimeZone(str);
        }
        return null;
    }

    @Override // io.sentry.m3
    public final String G() {
        return (String) g();
    }

    @Override // io.sentry.m3
    public final HashMap J(ILogger iLogger, x1 x1Var) throws IOException {
        if (peek() == io.sentry.vendor.gson.stream.b.NULL) {
            if (g() == null) {
                return null;
            }
            io.sentry.android.core.cache.a.f(peek(), "Expected null but was ");
            return null;
        }
        try {
            p0();
            HashMap map = new HashMap();
            if (peek() == io.sentry.vendor.gson.stream.b.NAME) {
                while (true) {
                    String strR = R();
                    int size = this.b.size();
                    try {
                        map.put(strR, x1Var.a(this, iLogger));
                    } catch (Exception e) {
                        iLogger.d(p5.WARNING, "Failed to deserialize object in map.", e);
                        n(size);
                    }
                    if (peek() != io.sentry.vendor.gson.stream.b.BEGIN_OBJECT && peek() != io.sentry.vendor.gson.stream.b.NAME) {
                        break;
                    }
                }
            }
            V();
            return map;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.m3
    public final Double O() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return Double.valueOf(((Number) objG).doubleValue());
        }
        return null;
    }

    @Override // io.sentry.m3
    public final String R() throws IOException {
        Map.Entry entry = (Map.Entry) this.b.peekLast();
        if (entry != null && entry.getKey() != null) {
            return (String) entry.getKey();
        }
        io.sentry.android.core.cache.a.f(peek(), "Expected a name but was ");
        return null;
    }

    @Override // io.sentry.m3
    public final void V() {
        ArrayDeque arrayDeque = this.b;
        if (arrayDeque.size() > 1) {
            arrayDeque.removeLast();
        }
    }

    @Override // io.sentry.m3
    public final Date Y(ILogger iLogger) {
        String str = (String) g();
        if (str == null) {
            return null;
        }
        try {
            try {
                return io.sentry.config.a.h(str);
            } catch (Exception unused) {
                return io.sentry.config.a.i(str);
            }
        } catch (Exception e) {
            iLogger.d(p5.ERROR, "Error when deserializing millis timestamp format.", e);
            return null;
        }
    }

    @Override // io.sentry.m3
    public final Boolean b0() {
        return (Boolean) g();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.clear();
    }

    public final Object g() throws IOException {
        try {
            ArrayDeque arrayDeque = this.b;
            Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
            if (entry == null) {
                return null;
            }
            Object value = entry.getValue();
            arrayDeque.removeLast();
            return value;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @Override // io.sentry.m3
    public final boolean hasNext() {
        return !this.b.isEmpty();
    }

    @Override // io.sentry.m3
    public final Float l0() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return Float.valueOf(((Number) objG).floatValue());
        }
        return null;
    }

    @Override // io.sentry.m3
    public final Object m0(ILogger iLogger, x1 x1Var) {
        ArrayDeque arrayDeque = this.b;
        Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
        if (entry == null) {
            return null;
        }
        Object value = entry.getValue();
        if (iLogger != null) {
            return x1Var.a(this, iLogger);
        }
        arrayDeque.removeLast();
        return value;
    }

    public final void n(int i) {
        while (true) {
            ArrayDeque arrayDeque = this.b;
            if (arrayDeque.isEmpty() || arrayDeque.size() < i) {
                return;
            } else {
                arrayDeque.removeLast();
            }
        }
    }

    @Override // io.sentry.m3
    public final double nextDouble() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return ((Number) objG).doubleValue();
        }
        vp1.i("Expected double");
        return 0.0d;
    }

    @Override // io.sentry.m3
    public final float nextFloat() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return ((Number) objG).floatValue();
        }
        vp1.i("Expected float");
        return 0.0f;
    }

    @Override // io.sentry.m3
    public final int nextInt() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return ((Number) objG).intValue();
        }
        vp1.i("Expected int");
        return 0;
    }

    @Override // io.sentry.m3
    public final long nextLong() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return ((Number) objG).longValue();
        }
        vp1.i("Expected long");
        return 0L;
    }

    @Override // io.sentry.m3
    public final Object o0() {
        return g();
    }

    @Override // io.sentry.m3
    public final void p0() throws IOException {
        ArrayDeque arrayDeque = this.b;
        Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
        if (entry == null) {
            vp1.i("No more entries");
            return;
        }
        Object value = entry.getValue();
        if (!(value instanceof Map)) {
            vp1.i("Current token is not an object");
            return;
        }
        arrayDeque.removeLast();
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, io.sentry.vendor.gson.stream.b.END_OBJECT));
        Iterator it = ((Map) value).entrySet().iterator();
        while (it.hasNext()) {
            arrayDeque.addLast((Map.Entry) it.next());
        }
    }

    @Override // io.sentry.m3
    public final io.sentry.vendor.gson.stream.b peek() {
        ArrayDeque arrayDeque = this.b;
        if (arrayDeque.isEmpty()) {
            return io.sentry.vendor.gson.stream.b.END_DOCUMENT;
        }
        Map.Entry entry = (Map.Entry) arrayDeque.peekLast();
        if (entry == null) {
            return io.sentry.vendor.gson.stream.b.END_DOCUMENT;
        }
        if (entry.getKey() != null) {
            return io.sentry.vendor.gson.stream.b.NAME;
        }
        Object value = entry.getValue();
        return value instanceof Map ? io.sentry.vendor.gson.stream.b.BEGIN_OBJECT : value instanceof List ? io.sentry.vendor.gson.stream.b.BEGIN_ARRAY : value instanceof String ? io.sentry.vendor.gson.stream.b.STRING : value instanceof Number ? io.sentry.vendor.gson.stream.b.NUMBER : value instanceof Boolean ? io.sentry.vendor.gson.stream.b.BOOLEAN : value instanceof io.sentry.vendor.gson.stream.b ? (io.sentry.vendor.gson.stream.b) value : io.sentry.vendor.gson.stream.b.END_DOCUMENT;
    }

    @Override // io.sentry.m3
    public final String q() throws IOException {
        String str = (String) g();
        if (str != null) {
            return str;
        }
        vp1.i("Expected string");
        return null;
    }

    @Override // io.sentry.m3
    public final void t() {
        ArrayDeque arrayDeque = this.b;
        if (arrayDeque.isEmpty()) {
            return;
        }
        arrayDeque.removeLast();
    }

    @Override // io.sentry.m3
    public final Integer u() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return Integer.valueOf(((Number) objG).intValue());
        }
        return null;
    }

    @Override // io.sentry.m3
    public final void w(ILogger iLogger, AbstractMap abstractMap, String str) {
        int size = this.b.size();
        try {
            abstractMap.put(str, g());
        } catch (Exception e) {
            iLogger.b(p5.ERROR, e, "Error deserializing unknown key: %s", str);
            n(size);
        }
    }

    @Override // io.sentry.m3
    public final void w0() {
        ArrayDeque arrayDeque = this.b;
        if (arrayDeque.size() > 1) {
            arrayDeque.removeLast();
        }
    }

    @Override // io.sentry.m3
    public final Long y() throws IOException {
        Object objG = g();
        if (objG instanceof Number) {
            return Long.valueOf(((Number) objG).longValue());
        }
        return null;
    }

    @Override // io.sentry.m3
    public final ArrayList y0(ILogger iLogger, x1 x1Var) throws IOException {
        if (peek() == io.sentry.vendor.gson.stream.b.NULL) {
            if (g() == null) {
                return null;
            }
            io.sentry.android.core.cache.a.f(peek(), "Expected null but was ");
            return null;
        }
        try {
            B0();
            ArrayList arrayList = new ArrayList();
            while (peek() != io.sentry.vendor.gson.stream.b.END_ARRAY) {
                int size = this.b.size();
                try {
                    arrayList.add(x1Var.a(this, iLogger));
                } catch (Exception e) {
                    iLogger.d(p5.WARNING, "Failed to deserialize object in list.", e);
                    n(size);
                }
            }
            w0();
            return arrayList;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.m3
    public final void H(boolean z) {
    }
}
