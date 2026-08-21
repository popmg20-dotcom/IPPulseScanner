package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.logging.Level;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class zj0 extends Exception implements Serializable {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c6 A[Catch: all -> 0x00f0, XmlPullParserException -> 0x00f2, TryCatch #2 {XmlPullParserException -> 0x00f2, blocks: (B:41:0x00a5, B:43:0x00b2, B:45:0x00be, B:48:0x00c8, B:47:0x00c6, B:49:0x00cd, B:54:0x00da, B:56:0x00e0, B:58:0x00ec, B:63:0x00f4), top: B:84:0x00a5, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zj0(String str, Exception exc, kk3 kk3Var, int i) {
        cq cqVarX;
        XmlPullParser xmlPullParserNewPullParser;
        mk3 mk3Var;
        pj2 pj2VarB;
        exc = (i & 2) != 0 ? null : exc;
        kk3Var = (i & 4) != 0 ? null : kk3Var;
        super(str, exc);
        if (kk3Var != null) {
            cm2 cm2Var = kk3Var.b;
            ok3 ok3Var = kk3Var.Z;
            kk3Var.toString();
            try {
                cm2Var.toString();
                ej3 ej3Var = (ej3) cm2Var.X;
                if (ej3Var != null && (pj2VarB = ej3Var.b()) != null && l72.M(pj2VarB)) {
                    hp hpVar = new hp();
                    ej3Var.c(hpVar);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    hpVar.O0(byteArrayOutputStream, Math.min(hpVar.f, 10240L));
                    Charset charsetA = pj2VarB.a(y30.a);
                    charsetA.getClass();
                    byteArrayOutputStream.toString(charsetA.name());
                }
            } catch (Exception e) {
                yj0.a.log(Level.WARNING, "Couldn't read HTTP request", (Throwable) e);
                e.getMessage();
            }
            try {
                if (ok3Var != null) {
                    try {
                        cqVarX = ok3Var.x();
                    } catch (IOException e2) {
                        yj0.a.log(Level.WARNING, "Couldn't read HTTP response", (Throwable) e2);
                        e2.getMessage();
                        if (ok3Var == null) {
                            return;
                        }
                    }
                } else {
                    cqVarX = null;
                }
                if (cqVarX != null) {
                    nk3 nk3VarS = kk3Var.s();
                    pj2 pj2Var = nk3VarS.z;
                    if (pj2Var != null && l72.M(pj2Var)) {
                        nk3VarS.C();
                    }
                    if (ok3Var != null) {
                        try {
                            pj2 pj2VarS = ok3Var.s();
                            if (pj2VarS != null) {
                                if (qe.a0(pj2VarS.b, new String[]{"application", "text"}) && pj2VarS.c.equals("xml")) {
                                    try {
                                        xmlPullParserNewPullParser = gy4.a.newPullParser();
                                        xmlPullParserNewPullParser.getClass();
                                        mk3Var = ok3Var.b;
                                    } catch (XmlPullParserException e3) {
                                        yj0.a.log(Level.WARNING, "Couldn't parse XML response", (Throwable) e3);
                                    }
                                    if (mk3Var == null) {
                                        cq cqVarX2 = ok3Var.x();
                                        pj2 pj2VarS2 = ok3Var.s();
                                        if (pj2VarS2 != null) {
                                            uh3 uh3Var = pj2.e;
                                            Charset charsetA2 = pj2VarS2.a(null);
                                            charsetA2 = charsetA2 == null ? y30.a : charsetA2;
                                            mk3Var = new mk3(cqVarX2, charsetA2);
                                            ok3Var.b = mk3Var;
                                        }
                                        ok3Var.close();
                                    }
                                    xmlPullParserNewPullParser.setInput(mk3Var);
                                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                                        if (eventType == 2) {
                                            if (xmlPullParserNewPullParser.getDepth() == 1 && gy4.b(xmlPullParserNewPullParser).equals(s51.f)) {
                                                vo.H(xmlPullParserNewPullParser);
                                            }
                                        }
                                    }
                                }
                            }
                            ok3Var.close();
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                ez4.l(ok3Var, th);
                                throw th2;
                            }
                        }
                    }
                }
                if (ok3Var == null) {
                    return;
                }
                ok3Var.close();
            } catch (Throwable th3) {
                if (ok3Var != null) {
                    ok3Var.close();
                }
                throw th3;
            }
        }
    }
}
