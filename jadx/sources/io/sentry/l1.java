package io.sentry;

import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface l1 {
    void a(Object obj, Writer writer);

    Object b(Reader reader, Class cls);

    io.sentry.internal.debugmeta.c c(BufferedInputStream bufferedInputStream);

    String d(Map map);

    void e(io.sentry.internal.debugmeta.c cVar, OutputStream outputStream);
}
