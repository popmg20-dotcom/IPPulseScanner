package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w94 extends DefaultHandler {
    public final ArrayList a = new ArrayList();
    public final z94 b = new z94();
    public final StringBuilder c = new StringBuilder();
    public final /* synthetic */ e93 d;
    public final /* synthetic */ s94 e;

    public w94(e93 e93Var, s94 s94Var) {
        this.d = e93Var;
        this.e = s94Var;
    }

    public final void a(Object obj) {
        z94 z94Var = this.b;
        z94Var.remove(z94Var.size() - 1);
        x94 x94Var = (x94) fw.r(this.a, 1);
        String str = x94Var.a;
        e93 e93Var = x94Var.b;
        if (str.equals("dict")) {
            e93Var.a(obj, x94Var.c.toString());
            return;
        }
        if (str.equals("array")) {
            Integer num = (Integer) x94Var.c;
            e93Var.a(obj, num.toString());
            Integer numValueOf = Integer.valueOf(num.intValue() + 1);
            x94Var.c = numValueOf;
            z94Var.add(numValueOf);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        this.c.append(cArr, i, i2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        str2.getClass();
        byte b = -1;
        switch (str2.hashCode()) {
            case -891985903:
                if (str2.equals("string")) {
                    b = 0;
                }
                break;
            case 106079:
                if (str2.equals("key")) {
                    b = 1;
                }
                break;
            case 3076010:
                if (str2.equals("data")) {
                    b = 2;
                }
                break;
            case 3076014:
                if (str2.equals("date")) {
                    b = 3;
                }
                break;
            case 3083190:
                if (str2.equals("dict")) {
                    b = 4;
                }
                break;
            case 3496350:
                if (str2.equals("real")) {
                    b = 5;
                }
                break;
            case 3569038:
                if (str2.equals("true")) {
                    b = 6;
                }
                break;
            case 93090393:
                if (str2.equals("array")) {
                    b = 7;
                }
                break;
            case 97196323:
                if (str2.equals("false")) {
                    b = 8;
                }
                break;
            case 106756366:
                if (str2.equals("plist")) {
                    b = 9;
                }
                break;
            case 1958052158:
                if (str2.equals("integer")) {
                    b = 10;
                }
                break;
        }
        z94 z94Var = this.b;
        ArrayList arrayList = this.a;
        StringBuilder sb = this.c;
        switch (b) {
            case 0:
            case 2:
                a(sb.toString());
                break;
            case 1:
                x94 x94Var = (x94) fw.r(arrayList, 1);
                if (!"dict".equals(x94Var.a)) {
                    a1.d(y94.a.a, "<key> tag can only be used inside an open <dict> element");
                } else {
                    String string = sb.toString();
                    x94Var.c = string;
                    z94Var.add(string);
                }
                break;
            case 3:
                try {
                    a(ZonedDateTime.parse(sb.toString()));
                } catch (DateTimeParseException e) {
                    a1.d(y94.a.a, "Failed to parse date '" + ((Object) sb) + "'. " + e);
                    return;
                }
                break;
            case 4:
                x94 x94Var2 = (x94) arrayList.remove(arrayList.size() - 1);
                if (!arrayList.isEmpty()) {
                    a(x94Var2.b);
                }
                break;
            case 5:
                try {
                    a(Float.valueOf(Float.parseFloat(sb.toString())));
                } catch (NumberFormatException e2) {
                    a1.d(y94.a.a, "Failed to parse real as float '" + ((Object) sb) + "'. " + e2);
                    return;
                }
                break;
            case 6:
                a(Boolean.TRUE);
                break;
            case 7:
                x94 x94Var3 = (x94) arrayList.remove(arrayList.size() - 1);
                z94Var.remove(z94Var.size() - 1);
                a(x94Var3.b);
                break;
            case 8:
                a(Boolean.FALSE);
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                break;
            case 10:
                try {
                    a(Integer.valueOf(Integer.parseInt(sb.toString())));
                } catch (NumberFormatException e3) {
                    a1.d(y94.a.a, "Failed to parse integer '" + ((Object) sb) + "'. " + e3);
                    return;
                }
                break;
            default:
                a1.d(y94.a.a, "Invalid tag name: ".concat(str2));
                break;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.c.setLength(0);
        str2.getClass();
        boolean zEquals = str2.equals("dict");
        s94 s94Var = this.e;
        ArrayList arrayList = this.a;
        z94 z94Var = this.b;
        if (zEquals) {
            if (arrayList.isEmpty()) {
                arrayList.add(new x94(str2, this.d));
                return;
            } else {
                arrayList.add(new x94(str2, s94Var.t(z94Var, Map.class)));
                return;
            }
        }
        if (str2.equals("array")) {
            x94 x94Var = new x94(str2, s94Var.t(z94Var, List.class));
            arrayList.add(x94Var);
            x94Var.c = 0;
            z94Var.add(0);
        }
    }
}
