package defpackage;

import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nt1 {
    public static final hr1[] a;
    public static final Map b;

    static {
        hr1 hr1Var = new hr1(hr1.i, "");
        bu buVar = hr1.f;
        hr1 hr1Var2 = new hr1(buVar, "GET");
        hr1 hr1Var3 = new hr1(buVar, "POST");
        bu buVar2 = hr1.g;
        hr1 hr1Var4 = new hr1(buVar2, "/");
        hr1 hr1Var5 = new hr1(buVar2, "/index.html");
        bu buVar3 = hr1.h;
        hr1 hr1Var6 = new hr1(buVar3, "http");
        hr1 hr1Var7 = new hr1(buVar3, "https");
        bu buVar4 = hr1.e;
        hr1[] hr1VarArr = {hr1Var, hr1Var2, hr1Var3, hr1Var4, hr1Var5, hr1Var6, hr1Var7, new hr1(buVar4, "200"), new hr1(buVar4, "204"), new hr1(buVar4, "206"), new hr1(buVar4, "304"), new hr1(buVar4, "400"), new hr1(buVar4, "404"), new hr1(buVar4, "500"), new hr1("accept-charset", ""), new hr1("accept-encoding", "gzip, deflate"), new hr1("accept-language", ""), new hr1("accept-ranges", ""), new hr1("accept", ""), new hr1("access-control-allow-origin", ""), new hr1("age", ""), new hr1("allow", ""), new hr1("authorization", ""), new hr1("cache-control", ""), new hr1("content-disposition", ""), new hr1("content-encoding", ""), new hr1("content-language", ""), new hr1("content-length", ""), new hr1("content-location", ""), new hr1("content-range", ""), new hr1("content-type", ""), new hr1("cookie", ""), new hr1("date", ""), new hr1("etag", ""), new hr1("expect", ""), new hr1("expires", ""), new hr1("from", ""), new hr1("host", ""), new hr1("if-match", ""), new hr1("if-modified-since", ""), new hr1("if-none-match", ""), new hr1("if-range", ""), new hr1("if-unmodified-since", ""), new hr1("last-modified", ""), new hr1("link", ""), new hr1("location", ""), new hr1("max-forwards", ""), new hr1("proxy-authenticate", ""), new hr1("proxy-authorization", ""), new hr1("range", ""), new hr1("referer", ""), new hr1("refresh", ""), new hr1("retry-after", ""), new hr1("server", ""), new hr1("set-cookie", ""), new hr1("strict-transport-security", ""), new hr1("transfer-encoding", ""), new hr1("user-agent", ""), new hr1("vary", ""), new hr1("via", ""), new hr1("www-authenticate", "")};
        a = hr1VarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61, 1.0f);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(hr1VarArr[i].a)) {
                linkedHashMap.put(hr1VarArr[i].a, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = DesugarCollections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        b = mapUnmodifiableMap;
    }

    public static void a(bu buVar) throws IOException {
        buVar.getClass();
        int iD = buVar.d();
        for (int i = 0; i < iD; i++) {
            byte bI = buVar.i(i);
            if (65 <= bI && bI < 91) {
                vp1.i("PROTOCOL_ERROR response malformed: mixed case name: ".concat(buVar.r()));
                return;
            }
        }
    }
}
