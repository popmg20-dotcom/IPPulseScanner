package defpackage;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class gy4 {
    public static final XmlPullParserFactory a;

    static {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.getClass();
            a = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            zo2.o("Couldn't create XmlPullParserFactory", e);
        }
    }

    public static void a(XmlPullParser xmlPullParser, k83 k83Var, pl1 pl1Var) throws XmlPullParserException, IOException {
        xmlPullParser.getClass();
        k83Var.getClass();
        int depth = xmlPullParser.getDepth();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if ((eventType == 3 || eventType == 1) && xmlPullParser.getDepth() == depth) {
                return;
            }
            if (eventType == 2 && xmlPullParser.getDepth() == depth + 1 && b(xmlPullParser).equals(k83Var)) {
                pl1Var.a();
            }
            eventType = xmlPullParser.next();
        }
    }

    public static k83 b(XmlPullParser xmlPullParser) {
        xmlPullParser.getClass();
        String namespace = xmlPullParser.getNamespace();
        String name = xmlPullParser.getName();
        if (namespace != null && name != null) {
            return new k83(namespace, name);
        }
        xe.q("Current event must be START_TAG or END_TAG");
        return null;
    }

    public static String c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        xmlPullParser.getClass();
        int depth = xmlPullParser.getDepth();
        int eventType = xmlPullParser.getEventType();
        String text = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getDepth() == depth) {
                return text;
            }
            if (eventType == 4 && xmlPullParser.getDepth() == depth) {
                text = xmlPullParser.getText();
            }
            eventType = xmlPullParser.next();
        }
    }
}
