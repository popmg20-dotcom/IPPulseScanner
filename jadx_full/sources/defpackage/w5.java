package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.regex.Matcher;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w5 implements n83 {
    public final /* synthetic */ int a;
    public static final w5 b = new w5(0);
    public static final w5 c = new w5(1);
    public static final w5 d = new w5(2);
    public static final w5 e = new w5(3);
    public static final w5 f = new w5(4);
    public static final w5 g = new w5(5);
    public static final w5 h = new w5(6);
    public static final w5 i = new w5(7);
    public static final w5 j = new w5(8);
    public static final w5 k = new w5(9);
    public static final w5 l = new w5(10);
    public static final w5 m = new w5(11);
    public static final w5 n = new w5(12);
    public static final w5 o = new w5(13);
    public static final w5 p = new w5(14);
    public static final w5 q = new w5(15);
    public static final w5 r = new w5(16);
    public static final w5 s = new w5(17);
    public static final w5 t = new w5(18);
    public static final w5 u = new w5(19);
    public static final w5 v = new w5(20);
    public static final w5 w = new w5(21);
    public static final w5 x = new w5(22);
    public static final w5 y = new w5(23);
    public static final w5 z = new w5(24);
    public static final w5 A = new w5(25);
    public static final w5 B = new w5(26);

    public /* synthetic */ w5(int i2) {
        this.a = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0143 A[PHI: r3
      0x0143: PHI (r3v19 k83) = (r3v13 k83), (r3v14 k83), (r3v15 k83), (r3v16 k83), (r3v17 k83) binds: [B:72:0x0141, B:75:0x014b, B:78:0x0154, B:81:0x015d, B:84:0x0166] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.n83
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l83 a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String upperCase;
        String strNextText = null;
        pj2VarN = null;
        pj2 pj2VarN = null;
        switch (this.a) {
            case 0:
                XmlPullParserFactory xmlPullParserFactory = gy4.a;
                k83 k83Var = ck0.g;
                k83Var.getClass();
                int depth = xmlPullParser.getDepth();
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    if ((eventType == 3 || eventType == 1) && xmlPullParser.getDepth() == depth) {
                        return new x5(strNextText);
                    }
                    if (eventType == 2 && xmlPullParser.getDepth() == depth + 1 && gy4.b(xmlPullParser).equals(k83Var)) {
                        strNextText = xmlPullParser.nextText();
                    }
                    eventType = xmlPullParser.next();
                }
                break;
            case 1:
                return new b6(gy4.c(xmlPullParser));
            case 2:
                String strC = gy4.c(xmlPullParser);
                d6 d6Var = new d6();
                d6Var.a = strC;
                return d6Var;
            case 3:
                String strC2 = gy4.c(xmlPullParser);
                if (strC2 == null) {
                    return null;
                }
                try {
                    Matcher matcher = fv.c.matcher(strC2);
                    if (!matcher.find()) {
                        throw new IllegalArgumentException("Couldn't parse color value: ".concat(strC2));
                    }
                    int i2 = Integer.parseInt(matcher.group(1), 16);
                    String strGroup = matcher.group(2);
                    int i3 = DnsRecord.CLASS_ANY;
                    if (strGroup != null) {
                        i3 = 255 & Integer.parseInt(matcher.group(2), 16);
                    }
                    return new fv(i2 | (i3 << 24));
                } catch (IllegalArgumentException e2) {
                    yj0.a.log(Level.WARNING, "Couldn't parse color, ignoring", (Throwable) e2);
                    return null;
                }
            case 4:
                return new gv(gy4.c(xmlPullParser));
            case 5:
                return new hv(gy4.c(xmlPullParser));
            case 6:
                return new mv(gy4.c(xmlPullParser));
            case 7:
                String strC3 = gy4.c(xmlPullParser);
                if (strC3 == null) {
                    return null;
                }
                bg0 bg0Var = new bg0();
                bg0Var.a = strC3;
                return bg0Var;
            case 8:
                bh3 bh3Var = new bh3();
                XmlPullParserFactory xmlPullParserFactory2 = gy4.a;
                gy4.a(xmlPullParser, ck0.g, new ig0(0, bh3Var, xmlPullParser));
                return new jg0((String) bh3Var.b);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                kg0 kg0Var = new kg0();
                kg0Var.a = false;
                kg0Var.b = false;
                kg0Var.c = false;
                kg0Var.d = false;
                kg0Var.e = false;
                XmlPullParserFactory xmlPullParserFactory3 = gy4.a;
                gy4.a(xmlPullParser, kg0.g, new ig0(xmlPullParser, kg0Var, 1));
                return kg0Var;
            case 10:
                return new tv0(gy4.c(xmlPullParser));
            case 11:
                return new ro1(gy4.c(xmlPullParser));
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                String strC4 = gy4.c(xmlPullParser);
                if (strC4 == null) {
                    return null;
                }
                try {
                    return new so1(Long.parseLong(strC4));
                } catch (NumberFormatException e3) {
                    yj0.a.log(Level.WARNING, "Couldn't parse " + so1.b + ": " + strC4, (Throwable) e3);
                    return null;
                }
            case 13:
                String strC5 = gy4.c(xmlPullParser);
                if (strC5 != null) {
                    uh3 uh3Var = pj2.e;
                    try {
                        pj2VarN = p95.n(strC5);
                        break;
                    } catch (IllegalArgumentException unused) {
                    }
                }
                return new to1(pj2VarN);
            case 14:
                return new uo1(gy4.c(xmlPullParser));
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                String strC6 = gy4.c(xmlPullParser);
                if (strC6 == null) {
                    return null;
                }
                Date dateA = fv1.a(strC6);
                if (dateA == null) {
                    yj0.a.warning("Couldn't parse Last-Modified date");
                    return null;
                }
                long time = dateA.getTime();
                wo1 wo1Var = new wo1();
                wo1Var.a = time;
                return wo1Var;
            case 16:
                String strC7 = gy4.c(xmlPullParser);
                if (strC7 == null) {
                    return null;
                }
                try {
                    return new dj2(Long.parseLong(strC7));
                } catch (NumberFormatException e4) {
                    yj0.a.log(Level.WARNING, "Couldn't parse " + dj2.b + ": " + strC7, (Throwable) e4);
                    return null;
                }
            case 17:
                String strC8 = gy4.c(xmlPullParser);
                if (strC8 == null) {
                    return null;
                }
                try {
                    return new hj2(Long.parseLong(strC8));
                } catch (NumberFormatException e5) {
                    yj0.a.log(Level.WARNING, "Couldn't parse " + hj2.b + ": " + strC8, (Throwable) e5);
                    return null;
                }
            case 18:
                String strC9 = gy4.c(xmlPullParser);
                if (strC9 == null) {
                    return null;
                }
                try {
                    return new lc3(Long.parseLong(strC9));
                } catch (NumberFormatException e6) {
                    yj0.a.log(Level.WARNING, "Couldn't parse " + lc3.b + ": " + strC9, (Throwable) e6);
                    return null;
                }
            case 19:
                String strC10 = gy4.c(xmlPullParser);
                if (strC10 == null) {
                    return null;
                }
                try {
                    return new mc3(Long.parseLong(strC10));
                } catch (NumberFormatException e7) {
                    yj0.a.log(Level.WARNING, "Couldn't parse " + mc3.b + ": " + strC10, (Throwable) e7);
                    return null;
                }
            case 20:
                ek3 ek3Var = new ek3();
                int depth2 = xmlPullParser.getDepth();
                int eventType2 = xmlPullParser.getEventType();
                while (true) {
                    if (eventType2 == 3 && xmlPullParser.getDepth() == depth2) {
                        xmlPullParser.getDepth();
                        return ek3Var;
                    }
                    if (eventType2 == 2 && xmlPullParser.getDepth() == depth2 + 1) {
                        String namespace = xmlPullParser.getNamespace();
                        namespace.getClass();
                        String name = xmlPullParser.getName();
                        name.getClass();
                        k83 k83Var2 = new k83(namespace, name);
                        k83 k83Var3 = ek3.c;
                        if (k83Var2.equals(k83Var3)) {
                            k83Var2 = k83Var3;
                            ek3Var.a.add(k83Var2);
                        } else {
                            k83Var3 = ek3.d;
                            if (!k83Var2.equals(k83Var3)) {
                                k83Var3 = ek3.e;
                                if (!k83Var2.equals(k83Var3)) {
                                    k83Var3 = ek3.f;
                                    if (!k83Var2.equals(k83Var3)) {
                                        k83Var3 = ek3.g;
                                        if (k83Var2.equals(k83Var3)) {
                                        }
                                        ek3Var.a.add(k83Var2);
                                    }
                                }
                            }
                        }
                    }
                    eventType2 = xmlPullParser.next();
                }
                break;
            case 21:
                return new cq3(gy4.c(xmlPullParser));
            case 22:
                m64 m64Var = new m64(0);
                try {
                    XmlPullParserFactory xmlPullParserFactory4 = gy4.a;
                    gy4.a(xmlPullParser, m64.d, new ig0(xmlPullParser, m64Var, 7));
                    return m64Var;
                } catch (XmlPullParserException e8) {
                    yj0.a.log(Level.SEVERE, "Couldn't parse <resourcetype>", (Throwable) e8);
                    return null;
                }
            case 23:
                n64 n64Var = new n64();
                n64Var.a = false;
                n64Var.b = false;
                n64Var.c = false;
                int depth3 = xmlPullParser.getDepth();
                int eventType3 = xmlPullParser.getEventType();
                while (true) {
                    if (eventType3 == 3 && xmlPullParser.getDepth() == depth3) {
                        return n64Var;
                    }
                    if (eventType3 == 2 && xmlPullParser.getDepth() == depth3 + 1) {
                        k83 k83VarB = gy4.b(xmlPullParser);
                        if (k83VarB.equals(n64.e)) {
                            n64Var.a = true;
                            n64Var.b = true;
                            n64Var.c = true;
                        } else if (k83VarB.equals(n64.f)) {
                            String attributeValue = xmlPullParser.getAttributeValue(null, "name");
                            if (attributeValue != null) {
                                upperCase = attributeValue.toUpperCase(Locale.ROOT);
                                upperCase.getClass();
                            } else {
                                upperCase = null;
                            }
                            if (upperCase != null) {
                                int iHashCode = upperCase.hashCode();
                                if (iHashCode != -1766506524) {
                                    if (iHashCode != -1143648767) {
                                        if (iHashCode == 82003356 && upperCase.equals("VTODO")) {
                                            n64Var.b = true;
                                        }
                                    } else if (upperCase.equals("VJOURNAL")) {
                                        n64Var.c = true;
                                    }
                                } else if (upperCase.equals("VEVENT")) {
                                    n64Var.a = true;
                                }
                            }
                        }
                    }
                    eventType3 = xmlPullParser.next();
                }
                break;
            case 24:
                m64 m64Var2 = new m64(1);
                try {
                    XmlPullParserFactory xmlPullParserFactory5 = gy4.a;
                    gy4.a(xmlPullParser, m64.f, new ig0(xmlPullParser, m64Var2, 8));
                    return m64Var2;
                } catch (XmlPullParserException e9) {
                    yj0.a.log(Level.SEVERE, "Couldn't parse <resourcetype>", (Throwable) e9);
                    return null;
                }
            case 25:
                m64 m64Var3 = new m64(2);
                XmlPullParserFactory xmlPullParserFactory6 = gy4.a;
                gy4.a(xmlPullParser, m64.h, new q64(xmlPullParser, m64Var3, 1));
                return m64Var3;
            default:
                return new h84(gy4.c(xmlPullParser));
        }
    }

    @Override // defpackage.n83
    public final k83 getName() {
        switch (this.a) {
            case 0:
                return x5.b;
            case 1:
                return b6.b;
            case 2:
                return d6.b;
            case 3:
                return fv.b;
            case 4:
                return gv.b;
            case 5:
                return hv.b;
            case 6:
                return mv.b;
            case 7:
                return bg0.b;
            case 8:
                return jg0.b;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return kg0.f;
            case 10:
                return tv0.b;
            case 11:
                return ro1.b;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return so1.b;
            case 13:
                return to1.b;
            case 14:
                return uo1.b;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return wo1.b;
            case 16:
                return dj2.b;
            case 17:
                return hj2.b;
            case 18:
                return lc3.b;
            case 19:
                return mc3.b;
            case 20:
                return ek3.b;
            case 21:
                return cq3.b;
            case 22:
                return m64.c;
            case 23:
                return n64.d;
            case 24:
                return m64.e;
            case 25:
                return m64.g;
            default:
                return h84.b;
        }
    }
}
