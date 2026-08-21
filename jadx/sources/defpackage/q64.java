package defpackage;

import java.io.IOException;
import java.util.LinkedHashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q64 extends r82 implements pl1 {
    public final /* synthetic */ m64 A;
    public final /* synthetic */ int f;
    public final /* synthetic */ XmlPullParser z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q64(XmlPullParser xmlPullParser, m64 m64Var, int i) {
        super(0);
        this.f = i;
        this.z = xmlPullParser;
        this.A = m64Var;
    }

    @Override // defpackage.pl1
    public final Object a() throws XmlPullParserException, IOException {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        m64 m64Var = this.A;
        XmlPullParser xmlPullParser = this.z;
        switch (i) {
            case 0:
                LinkedHashSet linkedHashSet = m64Var.b;
                xmlPullParser.nextTag();
                if (xmlPullParser.getEventType() == 4) {
                    linkedHashSet.add(xmlPullParser.getText());
                } else if (xmlPullParser.getEventType() == 2) {
                    linkedHashSet.add(xmlPullParser.getNamespace() + xmlPullParser.getName());
                }
                break;
            default:
                XmlPullParserFactory xmlPullParserFactory = gy4.a;
                gy4.a(xmlPullParser, m64.i, new q64(xmlPullParser, m64Var, 0));
                break;
        }
        return xl4Var;
    }
}
