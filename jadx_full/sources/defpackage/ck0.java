package defpackage;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
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
    */
    public static final void e(XmlPullParser xmlPullParser, ck0 ck0Var, zm2 zm2Var, ArrayList arrayList) throws XmlPullParserException, IOException {
        int i;
        String strC;
        int i2;
        ev1 ev1Var;
        int i3;
        String str;
        qt qtVar;
        dv1 dv1Var;
        int i4;
        int i5;
        ev1 ev1Var2;
        qt qtVarG;
        ev1 ev1Var3;
        int i6;
        l83 l83VarA;
        n83 n83Var;
        dv1 dv1Var2;
        int iU0;
        boolean zEquals;
        int i7;
        int depth = xmlPullParser.getDepth();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            int i8 = 3;
            if (eventType == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
            int i9 = 2;
            if (eventType == 2 && xmlPullParser.getDepth() == depth + 1) {
                k83 k83VarB = gy4.b(xmlPullParser);
                if (k83VarB.equals(lk3.h)) {
                    ev1 ev1Var4 = ck0Var.c;
                    int depth2 = xmlPullParser.getDepth();
                    ArrayList arrayList2 = new ArrayList();
                    int eventType2 = xmlPullParser.getEventType();
                    String str2 = null;
                    ev1 ev1VarA = 0;
                    qt qtVar2 = null;
                    ArrayList arrayListH = null;
                    Object objA = null;
                    while (true) {
                        if (eventType2 == i8 && xmlPullParser.getDepth() == depth2) {
                            break;
                        }
                        ev1 ev1Var5 = ev1Var4;
                        ev1VarA = ev1VarA;
                        if (eventType2 == i9) {
                            ev1VarA = ev1VarA;
                            if (xmlPullParser.getDepth() == depth2 + 1) {
                                k83 k83VarB2 = gy4.b(xmlPullParser);
                                if (k83VarB2.equals(g)) {
                                    String strNextText = xmlPullParser.nextText();
                                    strNextText.getClass();
                                    if (!w44.j0(strNextText, "/", false) && (iU0 = p44.u0(strNextText, ':', 0, 6)) != -1) {
                                        if (!strNextText.substring(iU0, iU0 + 3).equals("://")) {
                                            strNextText = "./".concat(strNextText);
                                        }
                                    }
                                    try {
                                        dv1 dv1Var3 = new dv1();
                                        dv1Var3.c(ev1Var5, strNextText);
                                        dv1Var2 = dv1Var3;
                                    } catch (IllegalArgumentException unused) {
                                        dv1Var2 = str2;
                                    }
                                    ev1VarA = dv1Var2 != 0 ? dv1Var2.a() : str2;
                                } else {
                                    k83 k83Var = lk3.j;
                                    if (k83VarB2.equals(k83Var)) {
                                        try {
                                            String strNextText2 = xmlPullParser.nextText();
                                            strNextText2.getClass();
                                            qtVar = vo.G(strNextText2);
                                        } catch (ProtocolException unused2) {
                                            yj0.a.warning("Invalid status line, treating as HTTP error 500");
                                            qtVar = new qt(500, 13, ba3.HTTP_1_1, "Invalid status line");
                                        }
                                        qtVar2 = qtVar;
                                        ev1VarA = ev1VarA;
                                    } else {
                                        if (k83VarB2.equals(i83.c)) {
                                            int depth3 = xmlPullParser.getDepth();
                                            LinkedList linkedList = new LinkedList();
                                            int eventType3 = xmlPullParser.getEventType();
                                            Object obj = str2;
                                            while (true) {
                                                if (eventType3 == 3 && xmlPullParser.getDepth() == depth3) {
                                                    break;
                                                }
                                                if (eventType3 == i9 && xmlPullParser.getDepth() == depth3 + 1) {
                                                    k83 k83VarB3 = gy4.b(xmlPullParser);
                                                    if (k83VarB3.equals(f)) {
                                                        int depth4 = xmlPullParser.getDepth();
                                                        LinkedList linkedList2 = new LinkedList();
                                                        int eventType4 = xmlPullParser.getEventType();
                                                        i4 = depth;
                                                        while (true) {
                                                            if (eventType4 == 3 && xmlPullParser.getDepth() == depth4) {
                                                                break;
                                                            }
                                                            if (eventType4 == 2 && xmlPullParser.getDepth() == depth4 + 1) {
                                                                xmlPullParser.getDepth();
                                                                String namespace = xmlPullParser.getNamespace();
                                                                namespace.getClass();
                                                                ev1Var3 = ev1Var5;
                                                                String name = xmlPullParser.getName();
                                                                name.getClass();
                                                                k83 k83Var2 = new k83(namespace, name);
                                                                try {
                                                                    n83Var = (n83) t83.a.get(k83Var2);
                                                                } catch (XmlPullParserException e2) {
                                                                    e = e2;
                                                                }
                                                                if (n83Var != null) {
                                                                    try {
                                                                        l83VarA = n83Var.a(xmlPullParser);
                                                                        i6 = depth2;
                                                                    } catch (XmlPullParserException e3) {
                                                                        e = e3;
                                                                        i6 = depth2;
                                                                        yj0.a.log(Level.WARNING, "Couldn't parse " + k83Var2, (Throwable) e);
                                                                        l83VarA = null;
                                                                    }
                                                                    xmlPullParser.getDepth();
                                                                    if (l83VarA == null) {
                                                                        linkedList2.add(l83VarA);
                                                                    } else {
                                                                        yj0.a.fine("Ignoring unknown property " + k83Var2);
                                                                    }
                                                                } else {
                                                                    i6 = depth2;
                                                                    l83VarA = null;
                                                                    xmlPullParser.getDepth();
                                                                    if (l83VarA == null) {
                                                                    }
                                                                }
                                                            } else {
                                                                ev1Var3 = ev1Var5;
                                                                i6 = depth2;
                                                            }
                                                            eventType4 = xmlPullParser.next();
                                                            ev1Var5 = ev1Var3;
                                                            depth2 = i6;
                                                        }
                                                        linkedList.addAll(linkedList2);
                                                    } else {
                                                        i4 = depth;
                                                        ev1Var2 = ev1Var5;
                                                        i5 = depth2;
                                                        if (k83VarB3.equals(k83Var)) {
                                                            try {
                                                                String strNextText3 = xmlPullParser.nextText();
                                                                strNextText3.getClass();
                                                                qtVarG = vo.G(strNextText3);
                                                            } catch (ProtocolException unused3) {
                                                                qtVarG = i83.e;
                                                            }
                                                            obj = qtVarG;
                                                        }
                                                        eventType3 = xmlPullParser.next();
                                                        depth = i4;
                                                        ev1Var5 = ev1Var2;
                                                        depth2 = i5;
                                                        i9 = 2;
                                                    }
                                                } else {
                                                    i4 = depth;
                                                }
                                                ev1Var2 = ev1Var5;
                                                i5 = depth2;
                                                eventType3 = xmlPullParser.next();
                                                depth = i4;
                                                ev1Var5 = ev1Var2;
                                                depth2 = i5;
                                                i9 = 2;
                                            }
                                            if (obj == null) {
                                                obj = i83.d;
                                            }
                                            arrayList2.add(new i83(linkedList, obj));
                                            i2 = depth;
                                            ev1Var = ev1Var5;
                                            i3 = depth2;
                                        } else {
                                            i2 = depth;
                                            ev1Var = ev1Var5;
                                            i3 = depth2;
                                            if (k83VarB2.equals(s51.f)) {
                                                arrayListH = vo.H(xmlPullParser);
                                            } else if (k83VarB2.equals(lk3.k)) {
                                                String strNextText4 = xmlPullParser.nextText();
                                                strNextText4.getClass();
                                                try {
                                                    dv1Var = new dv1();
                                                    str = null;
                                                } catch (IllegalArgumentException unused4) {
                                                    str = null;
                                                }
                                                try {
                                                    dv1Var.c(null, strNextText4);
                                                    objA = dv1Var.a();
                                                } catch (IllegalArgumentException unused5) {
                                                    objA = str;
                                                }
                                            }
                                        }
                                        str = null;
                                    }
                                }
                                i2 = depth;
                                ev1Var = ev1Var5;
                                i3 = depth2;
                                str = str2;
                            } else {
                                i2 = depth;
                                ev1Var = ev1Var5;
                                i3 = depth2;
                                str = str2;
                            }
                        }
                        eventType2 = xmlPullParser.next();
                        str2 = str;
                        depth = i2;
                        ev1Var4 = ev1Var;
                        depth2 = i3;
                        i8 = 3;
                        i9 = 2;
                        ev1VarA = ev1VarA;
                    }
                    if (ev1VarA == 0) {
                        yj0.a.warning("Ignoring XML response element without valid href");
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj2 : arrayList2) {
                            if (((i83) obj2).b.b / 100 == i9) {
                                arrayList3.add(obj2);
                            }
                        }
                        ArrayList arrayList4 = new ArrayList(f70.Q(10, arrayList3));
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(((i83) it.next()).a);
                        }
                        ek3 ek3Var = (ek3) d70.e0(d70.b0(ek3.class, arrayList4));
                        ev1 ev1VarA2 = ev1VarA;
                        if (ek3Var != null) {
                            ev1VarA2 = ev1VarA;
                            if (ek3Var.a.contains(ek3.c)) {
                                ArrayList arrayList5 = ev1VarA.f;
                                ev1VarA2 = ev1VarA;
                                if (!n12.c(arrayList5.get(arrayList5.size() - 1), "")) {
                                    dv1 dv1VarG = ev1VarA.g();
                                    dv1VarG.d("", 0, 0, false, false);
                                    ev1VarA2 = dv1VarG.a();
                                }
                            }
                        }
                        ev1 ev1VarJ = co4.J(ev1VarA2);
                        ev1 ev1VarJ2 = co4.J(ev1Var4);
                        if (ev1VarJ.equals(ev1VarJ2)) {
                            zEquals = true;
                        } else {
                            dv1 dv1VarG2 = ev1VarJ.g();
                            dv1VarG2.h = str2;
                            URI uriI = dv1VarG2.a().i();
                            dv1 dv1VarG3 = ev1VarJ2.g();
                            dv1VarG3.h = str2;
                            URI uriI2 = dv1VarG3.a().i();
                            try {
                                zEquals = new URI(uriI.getScheme(), uriI.getSchemeSpecificPart(), uriI.getFragment()).equals(new URI(uriI2.getScheme(), uriI2.getSchemeSpecificPart(), uriI2.getFragment()));
                            } catch (URISyntaxException unused6) {
                                zEquals = false;
                            }
                        }
                        if (zEquals) {
                            i7 = 1;
                        } else {
                            if (!n12.c(ev1Var4.a, ev1VarA2.a) || !n12.c(ev1Var4.d, ev1VarA2.d) || ev1Var4.e != ev1VarA2.e) {
                                i7 = 3;
                                break;
                            }
                            ArrayList arrayList6 = ev1Var4.f;
                            ArrayList arrayList7 = ev1VarA2.f;
                            int size = arrayList6.size();
                            if (n12.c(arrayList6.get(size - 1), "")) {
                                size--;
                            }
                            if (arrayList7.size() > size) {
                                Iterable iterableD0 = gb4.d0(0, size);
                                if (!(iterableD0 instanceof Collection) || !((Collection) iterableD0).isEmpty()) {
                                    Iterator it2 = iterableD0.iterator();
                                    while (((a12) it2).z) {
                                        int iNextInt = ((a12) it2).nextInt();
                                        if (!n12.c(arrayList6.get(iNextInt), arrayList7.get(iNextInt))) {
                                            i7 = 3;
                                            break;
                                        }
                                    }
                                }
                                i7 = i9;
                            }
                        }
                        zm2Var.l(new lk3(ev1Var4, ev1VarA2, qtVar2, arrayList2, arrayListH, objA), i7);
                    }
                    i = depth;
                } else {
                    i = depth;
                    if (k83VarB.equals(h84.b) && (strC = gy4.c(xmlPullParser)) != null) {
                        arrayList.add(new h84(strC));
                    }
                }
            } else {
                i = depth;
            }
            eventType = xmlPullParser.next();
            depth = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final kk3 b(pl1 pl1Var) {
        ev1 ev1VarA;
        dv1 dv1Var;
        kk3 kk3Var = null;
        for (int i = 1; i < 6; i++) {
            kk3Var = (kk3) pl1Var.a();
            if (kk3Var == null) {
                n12.T("response");
                throw null;
            }
            if (!kk3Var.I0) {
                break;
            }
            try {
                String strG = kk3.g(kk3Var, HttpHeaders.Names.LOCATION);
                if (strG != null) {
                    ev1 ev1Var = this.c;
                    try {
                        dv1Var = new dv1();
                        dv1Var.c(ev1Var, strG);
                    } catch (IllegalArgumentException unused) {
                        dv1Var = null;
                    }
                    ev1VarA = dv1Var != null ? dv1Var.a() : null;
                }
                if (ev1VarA == null) {
                    throw new zj0("Redirected without new Location", null, null, 6);
                }
                this.b.fine("Redirected, new location = " + ev1VarA);
                if (this.c.f() && !ev1VarA.f()) {
                    throw new zj0("Received redirect from HTTPS to HTTP", null, null, 6);
                }
                this.c = ev1VarA;
                kk3Var.close();
            } finally {
            }
        }
        if (kk3Var != null) {
            return kk3Var;
        }
        n12.T("response");
        throw null;
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
    */
    public final void d(kk3 kk3Var, zm2 zm2Var) throws zj0, IOException {
        xl4 xl4Var;
        mk3 mk3Var;
        ok3 ok3Var = kk3Var.Z;
        a(kk3Var);
        int i = kk3Var.A;
        if (i != 207) {
            throw new zj0("Expected 207 Multi-Status, got " + i + ' ' + kk3Var.z, null, kk3Var, 2);
        }
        if (ok3Var == null) {
            throw new zj0("Received 207 Multi-Status without body", null, kk3Var, 2);
        }
        pj2 pj2VarS = ok3Var.s();
        try {
            if (pj2VarS != null) {
                String str = pj2VarS.b;
                if ((!str.equals("application") && !str.equals("text")) || !pj2VarS.c.equals("xml")) {
                    try {
                        byte[] bArr = h;
                        int length = bArr.length;
                        byte[] bArr2 = new byte[length];
                        he3 he3VarPeek = ok3Var.x().peek();
                        hp hpVar = he3VarPeek.f;
                        try {
                            he3VarPeek.X(length);
                            hpVar.c0(bArr2);
                            if (Arrays.equals(bArr, bArr2)) {
                                yj0.a.warning("Received 207 Multi-Status that seems to be XML but has MIME type " + pj2VarS);
                                mk3Var = ok3Var.b;
                                if (mk3Var == null) {
                                    cq cqVarX = ok3Var.x();
                                    pj2 pj2VarS2 = ok3Var.s();
                                    if (pj2VarS2 != null) {
                                        uh3 uh3Var = pj2.e;
                                        Charset charsetA = pj2VarS2.a(null);
                                        if (charsetA == null) {
                                            charsetA = y30.a;
                                        }
                                        mk3Var = new mk3(cqVarX, charsetA);
                                        ok3Var.b = mk3Var;
                                    }
                                }
                                c(mk3Var, zm2Var);
                                ok3Var.close();
                                return;
                            }
                        } catch (EOFException e2) {
                            int i2 = 0;
                            while (true) {
                                long j = hpVar.f;
                                if (j <= 0) {
                                    throw e2;
                                }
                                int i3 = hpVar.read(bArr2, i2, (int) j);
                                if (i3 == -1) {
                                    throw new AssertionError();
                                }
                                i2 += i3;
                            }
                        }
                    } catch (Exception e3) {
                        yj0.a.log(Level.WARNING, "Couldn't scan for XML signature", (Throwable) e3);
                    }
                    throw new zj0("Received non-XML 207 Multi-Status", null, kk3Var, 2);
                }
                xl4Var = xl4.a;
            } else {
                xl4Var = null;
            }
            mk3Var = ok3Var.b;
            if (mk3Var == null) {
            }
            c(mk3Var, zm2Var);
            ok3Var.close();
            return;
        } finally {
        }
        if (xl4Var == null) {
            this.b.warning("Received 207 Multi-Status without Content-Type, assuming XML");
        }
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
