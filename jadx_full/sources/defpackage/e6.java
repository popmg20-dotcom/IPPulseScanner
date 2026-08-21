package defpackage;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e6 extends ot1 {
    public static final e6 b = new e6(0);
    public static final e6 c = new e6(1);
    public static final e6 d = new e6(2);
    public static final e6 e = new e6(3);
    public static final e6 f = new e6(4);
    public static final e6 g = new e6(5);
    public static final e6 h = new e6(6);
    public static final e6 i = new e6(7);
    public final /* synthetic */ int a;

    public /* synthetic */ e6(int i2) {
        this.a = i2;
    }

    @Override // defpackage.n83
    public final l83 a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        switch (this.a) {
            case 0:
                f6 f6Var = new f6();
                ot1.b(xmlPullParser, f6Var);
                return f6Var;
            case 1:
                iv ivVar = new iv();
                ot1.b(xmlPullParser, ivVar);
                return ivVar;
            case 2:
                jv jvVar = new jv();
                ot1.b(xmlPullParser, jvVar);
                return jvVar;
            case 3:
                kv kvVar = new kv();
                ot1.b(xmlPullParser, kvVar);
                return kvVar;
            case 4:
                nv nvVar = new nv();
                ot1.b(xmlPullParser, nvVar);
                return nvVar;
            case 5:
                dq1 dq1Var = new dq1();
                ot1.b(xmlPullParser, dq1Var);
                return dq1Var;
            case 6:
                wx2 wx2Var = new wx2();
                ot1.b(xmlPullParser, wx2Var);
                return wx2Var;
            default:
                mz3 mz3Var = new mz3();
                ot1.b(xmlPullParser, mz3Var);
                return mz3Var;
        }
    }

    @Override // defpackage.n83
    public final k83 getName() {
        switch (this.a) {
            case 0:
                return f6.b;
            case 1:
                return iv.b;
            case 2:
                return jv.b;
            case 3:
                return kv.b;
            case 4:
                return nv.b;
            case 5:
                return dq1.b;
            case 6:
                return wx2.b;
            default:
                return mz3.b;
        }
    }
}
