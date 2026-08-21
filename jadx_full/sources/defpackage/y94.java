package defpackage;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class y94 {
    public static final ve2 a = ve2.a(y94.class.getName());
    public static final y94 b = new y94();

    public static e93 a(StringReader stringReader, s94 s94Var) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        sAXParserFactoryNewInstance.setNamespaceAware(true);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        XMLReader xMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
        xMLReader.setEntityResolver(new v94());
        e93 e93VarS = s94Var.s();
        xMLReader.setContentHandler(new w94(e93VarS, s94Var));
        xMLReader.parse(new InputSource(stringReader));
        return e93VarS;
    }
}
