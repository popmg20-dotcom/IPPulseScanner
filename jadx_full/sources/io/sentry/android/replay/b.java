package io.sentry.android.replay;

import defpackage.ek0;
import defpackage.n12;
import defpackage.p44;
import defpackage.p95;
import defpackage.st4;
import defpackage.uh2;
import defpackage.uh3;
import defpackage.vw0;
import defpackage.w44;
import defpackage.z82;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.sentry.n2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.y3;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements y3 {
    public static final z82 c = ek0.v(a.z);
    public static final HashSet d;
    public String a;
    public final Map b = DesugarCollections.synchronizedMap(new vw0());

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("status_code");
        hashSet.add("method");
        hashSet.add("response_content_length");
        hashSet.add("request_content_length");
        hashSet.add("http.response_content_length");
        hashSet.add("http.request_content_length");
        d = hashSet;
    }

    public b(p6 p6Var) {
        p6Var.setBeforeBreadcrumb(new n2(this, p6Var.getBeforeBreadcrumb()));
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0232  */
    @Override // io.sentry.y3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final io.sentry.rrweb.b a(io.sentry.g gVar) {
        String str;
        p5 p5Var;
        Object obj;
        String strP0;
        double dLongValue;
        double dLongValue2;
        String string;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (n12.c(gVar.Z, "http")) {
            Object obj2 = gVar.b().get(RtspHeaders.Values.URL);
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            if (str2 == null || str2.length() == 0) {
                return null;
            }
            Map mapB = gVar.b();
            mapB.getClass();
            if (!mapB.containsKey("http.start_timestamp")) {
                return null;
            }
            Map mapB2 = gVar.b();
            mapB2.getClass();
            if (!mapB2.containsKey("http.end_timestamp")) {
                return null;
            }
            Object obj3 = gVar.b().get("http.start_timestamp");
            Object obj4 = gVar.b().get("http.end_timestamp");
            io.sentry.rrweb.l lVar = new io.sentry.rrweb.l();
            lVar.f = gVar.c().getTime();
            lVar.A = "resource.http";
            Object obj5 = gVar.b().get(RtspHeaders.Values.URL);
            obj5.getClass();
            lVar.X = (String) obj5;
            if (obj3 instanceof Double) {
                dLongValue = ((Number) obj3).doubleValue();
            } else {
                obj3.getClass();
                dLongValue = ((Long) obj3).longValue();
            }
            lVar.Y = dLongValue / 1000.0d;
            if (obj4 instanceof Double) {
                dLongValue2 = ((Number) obj4).doubleValue();
            } else {
                obj4.getClass();
                dLongValue2 = ((Long) obj4).longValue();
            }
            lVar.Z = dLongValue2 / 1000.0d;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (this.b.remove(gVar) != null) {
                st4.n();
                return null;
            }
            Map mapB3 = gVar.b();
            mapB3.getClass();
            for (Map.Entry entry : mapB3.entrySet()) {
                String str3 = (String) entry.getKey();
                Object value = entry.getValue();
                if (d.contains(str3)) {
                    str3.getClass();
                    String strO0 = p44.O0(w44.i0(str3, "content_length", "body_size"), ".");
                    uh3 uh3Var = (uh3) c.getValue();
                    uh3Var.getClass();
                    Matcher matcher = uh3Var.b.matcher(strO0);
                    matcher.getClass();
                    int i = 0;
                    uh2 uh2VarK = p95.k(matcher, 0, strO0);
                    if (uh2VarK == null) {
                        string = strO0.toString();
                    } else {
                        int length = strO0.length();
                        StringBuilder sb = new StringBuilder(length);
                        do {
                            sb.append((CharSequence) strO0, i, uh2VarK.b().b);
                            String strGroup = uh2VarK.a.group();
                            strGroup.getClass();
                            String upperCase = String.valueOf(p44.y0(strGroup)).toUpperCase(Locale.ROOT);
                            upperCase.getClass();
                            sb.append((CharSequence) upperCase);
                            i = uh2VarK.b().f + 1;
                            uh2VarK = uh2VarK.c();
                            if (i >= length) {
                                break;
                            }
                        } while (uh2VarK != null);
                        if (i < length) {
                            sb.append((CharSequence) strO0, i, length);
                        }
                        string = sb.toString();
                    }
                    linkedHashMap2.put(string, value);
                }
            }
            lVar.y0 = new ConcurrentHashMap(linkedHashMap2);
            return lVar;
        }
        String str4 = "navigation";
        if (n12.c(gVar.X, "navigation") && n12.c(gVar.Z, "app.lifecycle")) {
            str4 = "app." + gVar.b().get("state");
        } else {
            if (!n12.c(gVar.X, "navigation") || !n12.c(gVar.Z, "device.orientation")) {
                if (n12.c(gVar.X, "navigation")) {
                    if (n12.c(gVar.b().get("state"), "resumed")) {
                        Object obj6 = gVar.b().get("screen");
                        String str5 = obj6 instanceof String ? (String) obj6 : null;
                        strP0 = str5 != null ? p44.P0(str5, '.', str5) : null;
                        if (strP0 != null) {
                            return null;
                        }
                        linkedHashMap.put("to", strP0);
                    } else {
                        Map mapB4 = gVar.b();
                        mapB4.getClass();
                        if (mapB4.containsKey("to")) {
                            Object obj7 = gVar.b().get("to");
                            if (obj7 instanceof String) {
                                strP0 = (String) obj7;
                            }
                            if (strP0 != null) {
                            }
                        }
                    }
                    if (str4 != null && str4.length() != 0) {
                        io.sentry.rrweb.a aVar = new io.sentry.rrweb.a();
                        aVar.f = gVar.c().getTime();
                        aVar.A = gVar.c().getTime() / 1000.0d;
                        aVar.X = "default";
                        aVar.Y = str4;
                        aVar.Z = str;
                        aVar.y0 = p5Var;
                        aVar.z0 = new ConcurrentHashMap(linkedHashMap);
                        return aVar;
                    }
                }
                if (n12.c(gVar.Z, "ui.click")) {
                    Object obj8 = gVar.b().get("view.id");
                    if (obj8 == null && (obj8 = gVar.b().get("view.tag")) == null) {
                        obj8 = gVar.b().get("view.class");
                    }
                    str = obj8 instanceof String ? (String) obj8 : null;
                    if (str == null) {
                        return null;
                    }
                    Map mapB5 = gVar.b();
                    mapB5.getClass();
                    linkedHashMap.putAll(mapB5);
                    str4 = "ui.tap";
                    p5Var = null;
                } else if (n12.c(gVar.X, "system") && n12.c(gVar.Z, "network.event")) {
                    if (n12.c(gVar.b().get("action"), "NETWORK_LOST")) {
                        obj = "offline";
                    } else {
                        Map mapB6 = gVar.b();
                        mapB6.getClass();
                        if (!mapB6.containsKey("network_type")) {
                            return null;
                        }
                        Object obj9 = gVar.b().get("network_type");
                        String str6 = obj9 instanceof String ? (String) obj9 : null;
                        if (str6 == null || str6.length() == 0) {
                            return null;
                        }
                        obj = gVar.b().get("network_type");
                    }
                    linkedHashMap.put("state", obj);
                    if (n12.c(this.a, linkedHashMap.get("state"))) {
                        return null;
                    }
                    Object obj10 = linkedHashMap.get("state");
                    this.a = obj10 instanceof String ? (String) obj10 : null;
                    str4 = "device.connectivity";
                } else if (n12.c(gVar.b().get("action"), "BATTERY_CHANGED")) {
                    Map mapB7 = gVar.b();
                    mapB7.getClass();
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry2 : mapB7.entrySet()) {
                        String str7 = (String) entry2.getKey();
                        if (n12.c(str7, "level") || n12.c(str7, "charging")) {
                            linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    linkedHashMap.putAll(linkedHashMap3);
                    str4 = "device.battery";
                } else {
                    str4 = gVar.Z;
                    str = gVar.A;
                    p5Var = gVar.z0;
                    Map mapB8 = gVar.b();
                    mapB8.getClass();
                    linkedHashMap.putAll(mapB8);
                }
                return str4 != null ? null : null;
            }
            str4 = gVar.Z;
            str4.getClass();
            Object obj11 = gVar.b().get("position");
            if (!n12.c(obj11, "landscape") && !n12.c(obj11, "portrait")) {
                return null;
            }
            linkedHashMap.put("position", obj11);
        }
        str = null;
        p5Var = null;
        if (str4 != null) {
        }
    }
}
