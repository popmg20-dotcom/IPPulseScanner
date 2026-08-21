package io.sentry;

import io.sentry.protocol.DebugImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l2 implements l1 {
    public static final Charset c = Charset.forName("UTF-8");
    public final p6 a;
    public final HashMap b;

    public l2(p6 p6Var) {
        this.a = p6Var;
        HashMap map = new HashMap();
        this.b = map;
        int i = 4;
        map.put(io.sentry.protocol.a.class, new io.sentry.clientreport.a(i));
        map.put(g.class, new f(0));
        int i2 = 5;
        map.put(io.sentry.protocol.d.class, new io.sentry.clientreport.a(i2));
        map.put(io.sentry.protocol.e.class, new io.sentry.clientreport.a(6));
        int i3 = 7;
        map.put(DebugImage.class, new io.sentry.clientreport.a(i3));
        int i4 = 8;
        map.put(io.sentry.protocol.f.class, new io.sentry.clientreport.a(i4));
        int i5 = 9;
        map.put(io.sentry.protocol.h.class, new io.sentry.clientreport.a(i5));
        int i6 = 10;
        map.put(io.sentry.protocol.g.class, new io.sentry.clientreport.a(i6));
        int i7 = 12;
        map.put(io.sentry.protocol.k.class, new io.sentry.clientreport.a(i7));
        int i8 = 14;
        map.put(io.sentry.protocol.m.class, new io.sentry.clientreport.a(i8));
        map.put(io.sentry.protocol.b0.class, new io.sentry.clientreport.a(29));
        map.put(io.sentry.protocol.n.class, new io.sentry.clientreport.a(15));
        int i9 = 16;
        map.put(io.sentry.protocol.o.class, new io.sentry.clientreport.a(i9));
        int i10 = 17;
        map.put(io.sentry.protocol.p.class, new io.sentry.clientreport.a(i10));
        int i11 = 18;
        map.put(io.sentry.protocol.q.class, new io.sentry.clientreport.a(i11));
        map.put(s3.class, new f(1));
        int i12 = 2;
        map.put(t3.class, new f(i12));
        int i13 = 3;
        map.put(v3.class, new f(i13));
        map.put(w3.class, new f(i));
        map.put(io.sentry.profilemeasurements.a.class, new io.sentry.clientreport.a(i12));
        map.put(io.sentry.profilemeasurements.b.class, new io.sentry.clientreport.a(i13));
        int i14 = 19;
        map.put(io.sentry.protocol.r.class, new io.sentry.clientreport.a(i14));
        map.put(b4.class, new f(i2));
        map.put(io.sentry.rrweb.a.class, new io.sentry.protocol.d0(i5));
        map.put(io.sentry.rrweb.c.class, new io.sentry.protocol.d0(i6));
        map.put(io.sentry.rrweb.g.class, new io.sentry.protocol.d0(i7));
        map.put(io.sentry.rrweb.i.class, new io.sentry.protocol.d0(i8));
        map.put(io.sentry.rrweb.j.class, new io.sentry.protocol.d0(i9));
        map.put(io.sentry.rrweb.l.class, new io.sentry.protocol.d0(i10));
        map.put(io.sentry.rrweb.m.class, new io.sentry.protocol.d0(i11));
        map.put(io.sentry.protocol.t.class, new io.sentry.clientreport.a(20));
        int i15 = 21;
        map.put(io.sentry.protocol.u.class, new io.sentry.clientreport.a(i15));
        map.put(y4.class, new f(i3));
        map.put(e5.class, new f(i4));
        map.put(f5.class, new f(i5));
        int i16 = 22;
        map.put(io.sentry.protocol.v.class, new io.sentry.clientreport.a(i16));
        map.put(o5.class, new f(i6));
        map.put(p5.class, new f(11));
        map.put(q5.class, new f(i7));
        map.put(s5.class, new f(15));
        map.put(w5.class, new f(i11));
        int i17 = 24;
        map.put(io.sentry.protocol.x.class, new io.sentry.clientreport.a(i17));
        map.put(io.sentry.protocol.y.class, new io.sentry.clientreport.a(25));
        map.put(r6.class, new f(i14));
        int i18 = 26;
        map.put(io.sentry.protocol.z.class, new io.sentry.clientreport.a(i18));
        map.put(io.sentry.protocol.a0.class, new io.sentry.clientreport.a(27));
        map.put(io.sentry.protocol.c0.class, new io.sentry.clientreport.a(28));
        map.put(q4.class, new f(6));
        map.put(io.sentry.protocol.e0.class, new io.sentry.protocol.d0(0));
        map.put(io.sentry.protocol.f0.class, new io.sentry.protocol.d0(1));
        map.put(z6.class, new f(i15));
        map.put(b7.class, new f(i16));
        map.put(d7.class, new f(23));
        map.put(f7.class, new f(i17));
        map.put(io.sentry.protocol.j0.class, new io.sentry.protocol.d0(i12));
        map.put(io.sentry.protocol.l.class, new io.sentry.clientreport.a(13));
        map.put(m7.class, new f(i18));
        map.put(io.sentry.clientreport.b.class, new io.sentry.clientreport.a(0));
        map.put(io.sentry.protocol.l0.class, new io.sentry.protocol.d0(i));
        map.put(io.sentry.protocol.k0.class, new io.sentry.protocol.d0(3));
    }

    @Override // io.sentry.l1
    public final void a(Object obj, Writer writer) throws IOException {
        io.sentry.util.b.r(obj, "The entity is required.");
        p6 p6Var = this.a;
        ILogger logger = p6Var.getLogger();
        p5 p5Var = p5.DEBUG;
        if (logger.i(p5Var)) {
            p6Var.getLogger().h(p5Var, "Serializing object: %s", f(obj, p6Var.isEnablePrettySerializationOutput()));
        }
        io.sentry.internal.debugmeta.c cVar = new io.sentry.internal.debugmeta.c(writer, p6Var.getMaxDepth());
        ((j2) cVar.z).c(cVar, p6Var.getLogger(), obj);
        writer.flush();
    }

    @Override // io.sentry.l1
    public final Object b(Reader reader, Class cls) {
        Object objO0;
        p6 p6Var = this.a;
        try {
            i2 i2Var = new i2(reader);
            try {
                x1 x1Var = (x1) this.b.get(cls);
                if (x1Var != null) {
                    objO0 = cls.cast(x1Var.a(i2Var, p6Var.getLogger()));
                } else {
                    if (!cls.isArray() && !Collection.class.isAssignableFrom(cls) && !String.class.isAssignableFrom(cls) && !Map.class.isAssignableFrom(cls)) {
                        i2Var.close();
                        return null;
                    }
                    objO0 = i2Var.o0();
                }
                i2Var.close();
                return objO0;
            } finally {
            }
        } catch (Exception e) {
            p6Var.getLogger().d(p5.ERROR, "Error when deserializing", e);
            return null;
        }
    }

    @Override // io.sentry.l1
    public final io.sentry.internal.debugmeta.c c(BufferedInputStream bufferedInputStream) {
        p6 p6Var = this.a;
        try {
            return p6Var.getEnvelopeReader().a(bufferedInputStream);
        } catch (IOException e) {
            p6Var.getLogger().d(p5.ERROR, "Error deserializing envelope.", e);
            return null;
        }
    }

    @Override // io.sentry.l1
    public final String d(Map map) {
        return f(map, false);
    }

    @Override // io.sentry.l1
    public final void e(io.sentry.internal.debugmeta.c cVar, OutputStream outputStream) throws IOException {
        p6 p6Var = this.a;
        io.sentry.util.b.r(cVar, "The SentryEnvelope object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), c), 512);
        try {
            ((y4) cVar.f).serialize(new io.sentry.internal.debugmeta.c(bufferedWriter, p6Var.getMaxDepth()), p6Var.getLogger());
            bufferedWriter.write("\n");
            for (d5 d5Var : (Iterable) cVar.z) {
                try {
                    byte[] bArrG = d5Var.g();
                    d5Var.a.serialize(new io.sentry.internal.debugmeta.c(bufferedWriter, p6Var.getMaxDepth()), p6Var.getLogger());
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                    outputStream.write(bArrG);
                    bufferedWriter.write("\n");
                } catch (Exception e) {
                    p6Var.getLogger().d(p5.ERROR, "Failed to create envelope item. Dropping it.", e);
                }
            }
        } finally {
            bufferedWriter.flush();
        }
    }

    public final String f(Object obj, boolean z) throws IOException {
        StringWriter stringWriter = new StringWriter();
        p6 p6Var = this.a;
        io.sentry.internal.debugmeta.c cVar = new io.sentry.internal.debugmeta.c(stringWriter, p6Var.getMaxDepth());
        if (z) {
            cVar.s("\t");
        }
        ((j2) cVar.z).c(cVar, p6Var.getLogger(), obj);
        return stringWriter.toString();
    }
}
