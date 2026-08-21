package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ck0 {
    public static final pj2 d;
    public static final k83 e;
    public static final k83 f;
    public static final k83 g;
    public static final byte[] h;
    public final lu2 a;
    public final Logger b;
    public ev1 c;

    static {
        uh3 uh3Var = pj2.e;
        d = p95.n("application/xml; charset=utf-8");
        e = new k83("DAV:", "propfind");
        f = new k83("DAV:", "prop");
        g = new k83("DAV:", "href");
        byte[] bytes = "<?xml".getBytes(y30.a);
        bytes.getClass();
        h = bytes;
    }

    public ck0(lu2 lu2Var, ev1 ev1Var) {
        Logger logger = yj0.a;
        logger.getClass();
        this.a = lu2Var;
        this.b = logger;
        if (lu2Var.h) {
            xe.k("httpClient must not follow redirects automatically");
            throw null;
        }
        this.c = ev1Var;
    }

    public static void a(kk3 kk3Var) throws qu1 {
        int i = kk3Var.A;
        if (i / 100 == 2) {
            return;
        }
        if (i == 401) {
            throw new ra0(kk3Var);
        }
        if (i != 409 && i != 412) {
            if (i != 503) {
                if (i == 403) {
                    throw new ra0(kk3Var);
                }
                if (i == 404) {
                    throw new rs2(kk3Var);
                }
                throw new qu1(kk3Var);
            }
            ra0 ra0Var = new ra0(kk3Var);
            String strG = kk3.g(kk3Var, "Retry-After");
            if (strG == null || fv1.a(strG) != null) {
                throw ra0Var;
            }
            try {
                int i2 = Integer.parseInt(strG);
                Calendar calendar = Calendar.getInstance();
                calendar.add(13, i2);
                calendar.getTime();
            } catch (NumberFormatException unused) {
                yj0.a.warning("Received Retry-After which was not a HTTP-date nor delta-seconds: ".concat(strG));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4 A[EDGE_INSN: B:73:0x01a4->B:74:0x01a5 BREAK  A[LOOP:4: B:67:0x0185->B:214:?]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0210 A[PHI: r8 r10
      0x0210: PHI (r8v2 ev1) = (r8v25 ev1), (r8v26 ev1), (r8v27 ev1), (r8v8 ev1), (r8v9 ev1) binds: [B:76:0x01b9, B:78:0x01c1, B:100:0x022c, B:95:0x020f, B:94:0x0209] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r10v2 qt) = (r10v1 qt), (r10v1 qt), (r10v6 qt), (r10v1 qt), (r10v1 qt) binds: [B:76:0x01b9, B:78:0x01c1, B:100:0x022c, B:95:0x020f, B:94:0x0209] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(org.xmlpull.v1.XmlPullParser r23, defpackage.ck0 r24, defpackage.zm2 r25, java.util.ArrayList r26) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 982
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ck0.e(org.xmlpull.v1.XmlPullParser, ck0, zm2, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.kk3 b(defpackage.pl1 r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            r2 = r0
        L3:
            r3 = 6
            java.lang.String r4 = "response"
            if (r1 >= r3) goto L7b
            java.lang.Object r2 = r9.a()
            kk3 r2 = (defpackage.kk3) r2
            if (r2 == 0) goto L77
            boolean r5 = r2.I0
            if (r5 == 0) goto L7b
            java.lang.String r4 = "Location"
            java.lang.String r4 = defpackage.kk3.g(r2, r4)     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L31
            ev1 r5 = r8.c     // Catch: java.lang.Throwable -> L2f
            dv1 r6 = new dv1     // Catch: java.lang.IllegalArgumentException -> L27 java.lang.Throwable -> L2f
            r6.<init>()     // Catch: java.lang.IllegalArgumentException -> L27 java.lang.Throwable -> L2f
            r6.c(r5, r4)     // Catch: java.lang.IllegalArgumentException -> L27 java.lang.Throwable -> L2f
            goto L28
        L27:
            r6 = r0
        L28:
            if (r6 == 0) goto L31
            ev1 r4 = r6.a()     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r8 = move-exception
            goto L71
        L31:
            r4 = r0
        L32:
            if (r4 == 0) goto L69
            java.util.logging.Logger r5 = r8.b     // Catch: java.lang.Throwable -> L2f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r6.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = "Redirected, new location = "
            r6.append(r7)     // Catch: java.lang.Throwable -> L2f
            r6.append(r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L2f
            r5.fine(r6)     // Catch: java.lang.Throwable -> L2f
            ev1 r5 = r8.c     // Catch: java.lang.Throwable -> L2f
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L2f
            if (r5 == 0) goto L61
            boolean r5 = r4.f()     // Catch: java.lang.Throwable -> L2f
            if (r5 == 0) goto L59
            goto L61
        L59:
            zj0 r8 = new zj0     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = "Received redirect from HTTPS to HTTP"
            r8.<init>(r9, r0, r0, r3)     // Catch: java.lang.Throwable -> L2f
            throw r8     // Catch: java.lang.Throwable -> L2f
        L61:
            r8.c = r4     // Catch: java.lang.Throwable -> L2f
            r2.close()
            int r1 = r1 + 1
            goto L3
        L69:
            zj0 r8 = new zj0     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = "Redirected without new Location"
            r8.<init>(r9, r0, r0, r3)     // Catch: java.lang.Throwable -> L2f
            throw r8     // Catch: java.lang.Throwable -> L2f
        L71:
            throw r8     // Catch: java.lang.Throwable -> L72
        L72:
            r9 = move-exception
            defpackage.ez4.l(r2, r8)
            throw r9
        L77:
            defpackage.n12.T(r4)
            throw r0
        L7b:
            if (r2 == 0) goto L7e
            return r2
        L7e:
            defpackage.n12.T(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ck0.b(pl1):kk3");
    }

    public final ArrayList c(Reader reader, zm2 zm2Var) throws XmlPullParserException, zj0, IOException {
        ArrayList arrayList = new ArrayList();
        XmlPullParser xmlPullParserNewPullParser = gy4.a.newPullParser();
        xmlPullParserNewPullParser.getClass();
        try {
            xmlPullParserNewPullParser.setInput(reader);
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 2 && xmlPullParserNewPullParser.getDepth() == 1 && gy4.b(xmlPullParserNewPullParser).equals(lk3.i)) {
                    e(xmlPullParserNewPullParser, this, zm2Var, arrayList);
                    return arrayList;
                }
            }
            throw new zj0("Multi-Status response didn't contain multistatus XML element", null, null, 6);
        } catch (EOFException e2) {
            throw new zj0("Incomplete multistatus XML element", e2, null, 4);
        } catch (XmlPullParserException e3) {
            throw new zj0("Couldn't parse multistatus XML element", e3, null, 4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0 A[Catch: all -> 0x00c2, TryCatch #1 {all -> 0x00c2, blocks: (B:38:0x009c, B:40:0x00a0, B:42:0x00ac, B:45:0x00b6, B:44:0x00b4, B:46:0x00bb), top: B:60:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4 A[Catch: all -> 0x00c2, TryCatch #1 {all -> 0x00c2, blocks: (B:38:0x009c, B:40:0x00a0, B:42:0x00ac, B:45:0x00b6, B:44:0x00b4, B:46:0x00bb), top: B:60:0x009c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(defpackage.kk3 r13, defpackage.zm2 r14) throws defpackage.zj0, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ck0.d(kk3, zm2):void");
    }

    public final void f(int i, k83[] k83VarArr, zm2 zm2Var) {
        XmlSerializer xmlSerializerNewSerializer = gy4.a.newSerializer();
        xmlSerializerNewSerializer.getClass();
        StringWriter stringWriter = new StringWriter();
        xmlSerializerNewSerializer.setOutput(stringWriter);
        xmlSerializerNewSerializer.setPrefix("", "DAV:");
        xmlSerializerNewSerializer.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        xmlSerializerNewSerializer.setPrefix("CARD", "urn:ietf:params:xml:ns:carddav");
        xmlSerializerNewSerializer.startDocument("UTF-8", null);
        k83 k83Var = e;
        k83Var.getClass();
        String str = k83Var.b;
        String str2 = k83Var.f;
        xmlSerializerNewSerializer.startTag(str, str2);
        XmlPullParserFactory xmlPullParserFactory = gy4.a;
        k83 k83Var2 = f;
        k83Var2.getClass();
        String str3 = k83Var2.b;
        String str4 = k83Var2.f;
        xmlSerializerNewSerializer.startTag(str3, str4);
        for (k83 k83Var3 : k83VarArr) {
            XmlPullParserFactory xmlPullParserFactory2 = gy4.a;
            k83Var3.getClass();
            String str5 = k83Var3.b;
            String str6 = k83Var3.f;
            xmlSerializerNewSerializer.startTag(str5, str6);
            xmlSerializerNewSerializer.endTag(str5, str6);
        }
        xmlSerializerNewSerializer.endTag(str3, str4);
        xmlSerializerNewSerializer.endTag(str, str2);
        xmlSerializerNewSerializer.endDocument();
        kk3 kk3VarB = b(new bk0(this, stringWriter, i));
        try {
            d(kk3VarB, zm2Var);
            kk3VarB.close();
        } finally {
        }
    }

    public final String toString() {
        return this.c.i;
    }
}
