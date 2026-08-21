package defpackage;

import java.io.IOException;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ot1 implements n83 {
    public static void b(XmlPullParser xmlPullParser, pt1 pt1Var) throws XmlPullParserException, IOException {
        xmlPullParser.getClass();
        XmlPullParserFactory xmlPullParserFactory = gy4.a;
        k83 k83Var = ck0.g;
        LinkedList linkedList = pt1Var.a;
        k83Var.getClass();
        int depth = xmlPullParser.getDepth();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if ((eventType == 3 || eventType == 1) && xmlPullParser.getDepth() == depth) {
                return;
            }
            if (eventType == 2 && xmlPullParser.getDepth() == depth + 1 && gy4.b(xmlPullParser).equals(k83Var)) {
                String strNextText = xmlPullParser.nextText();
                strNextText.getClass();
                linkedList.add(strNextText);
            }
            eventType = xmlPullParser.next();
        }
    }
}
