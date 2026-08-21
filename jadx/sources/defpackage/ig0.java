package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ig0 extends r82 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ig0(int i, Object obj, Object obj2) {
        super(0);
        this.f = i;
        this.A = obj;
        this.z = obj2;
    }

    @Override // defpackage.pl1
    public final Object a() throws XmlPullParserException, IOException {
        int i = this.f;
        pj2 pj2VarN = null;
        xl4 xl4Var = xl4.a;
        Object obj = this.A;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                XmlPullParserFactory xmlPullParserFactory = gy4.a;
                ((bh3) obj).b = gy4.c((XmlPullParser) obj2);
                break;
            case 1:
                kg0 kg0Var = (kg0) obj;
                XmlPullParser xmlPullParser = (XmlPullParser) obj2;
                int depth = xmlPullParser.getDepth();
                int eventType = xmlPullParser.getEventType();
                while (true) {
                    if (eventType != 3 || xmlPullParser.getDepth() != depth) {
                        if (eventType == 2 && xmlPullParser.getDepth() == depth + 1) {
                            k83 k83VarB = gy4.b(xmlPullParser);
                            if (k83VarB.equals(kg0.h)) {
                                kg0Var.a = true;
                            } else if (k83VarB.equals(kg0.i)) {
                                kg0Var.d = true;
                                kg0Var.e = true;
                                kg0Var.b = true;
                                kg0Var.c = true;
                            } else if (k83VarB.equals(kg0.j)) {
                                kg0Var.b = true;
                            } else if (k83VarB.equals(kg0.k)) {
                                kg0Var.c = true;
                            } else if (k83VarB.equals(kg0.l)) {
                                kg0Var.d = true;
                            } else if (k83VarB.equals(kg0.m)) {
                                kg0Var.e = true;
                            } else if (k83VarB.equals(kg0.n)) {
                                kg0Var.a = true;
                                kg0Var.d = true;
                                kg0Var.e = true;
                                kg0Var.b = true;
                                kg0Var.c = true;
                            }
                        }
                        eventType = xmlPullParser.next();
                    }
                    break;
                }
                break;
            case 2:
                ck0 ck0Var = (ck0) obj;
                lu2 lu2Var = ck0Var.a;
                v92 v92Var = new v92(15);
                v92Var.m("MKCOL", (ej3) obj2);
                v92Var.b = ck0Var.c;
                break;
            case 3:
                v92 v92Var2 = new v92(15);
                v92Var2.m("PUT", (bj3) obj);
                ck0 ck0Var2 = (ck0) obj2;
                v92Var2.b = ck0Var2.c;
                break;
            case 4:
                ((zr1) obj).removeView((View) obj2);
                break;
            case 5:
                break;
            case 6:
                SharedPreferences sharedPreferences = ((Context) obj).getSharedPreferences((String) obj2, 0);
                sharedPreferences.getClass();
                break;
            case 7:
                XmlPullParser xmlPullParser2 = (XmlPullParser) obj2;
                String attributeValue = xmlPullParser2.getAttributeValue(null, "content-type");
                if (attributeValue != null) {
                    m64 m64Var = (m64) obj;
                    String attributeValue2 = xmlPullParser2.getAttributeValue(null, "version");
                    if (attributeValue2 != null) {
                        attributeValue = ha0.o(attributeValue, "; version=", attributeValue2);
                    }
                    uh3 uh3Var = pj2.e;
                    try {
                        pj2VarN = p95.n(attributeValue);
                        break;
                    } catch (IllegalArgumentException unused) {
                    }
                    if (pj2VarN != null) {
                        m64Var.b.add(pj2VarN);
                    }
                }
                break;
            default:
                XmlPullParser xmlPullParser3 = (XmlPullParser) obj2;
                String attributeValue3 = xmlPullParser3.getAttributeValue(null, "content-type");
                if (attributeValue3 != null) {
                    m64 m64Var2 = (m64) obj;
                    String attributeValue4 = xmlPullParser3.getAttributeValue(null, "version");
                    if (attributeValue4 != null) {
                        attributeValue3 = ha0.o(attributeValue3, "; version=", attributeValue4);
                    }
                    uh3 uh3Var2 = pj2.e;
                    try {
                        pj2VarN = p95.n(attributeValue3);
                        break;
                    } catch (IllegalArgumentException unused2) {
                    }
                    if (pj2VarN != null) {
                        m64Var2.b.add(pj2VarN);
                    }
                }
                break;
        }
        return xl4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ig0(XmlPullParser xmlPullParser, l83 l83Var, int i) {
        super(0);
        this.f = i;
        this.z = xmlPullParser;
        this.A = l83Var;
    }
}
