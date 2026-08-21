package defpackage;

import android.net.Uri;
import android.os.Process;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.StringUtil;
import io.sentry.android.core.a1;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class s63 {
    public static final Set a = qe.t0(new String[]{"surfboard", "surge", "surge3"});

    public static final LinkedHashMap a(List list) {
        ea3 ea3VarD;
        ArrayList<ea3> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ea3VarD = d((String) it.next());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                ea3VarD = null;
            }
            if (ea3VarD != null) {
                arrayList.add(ea3VarD);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ea3 ea3Var : arrayList) {
            String strB = b(linkedHashMap, ea3Var.getName(), 0);
            ea3Var.K(strB);
            linkedHashMap.put(strB, ea3Var);
        }
        return linkedHashMap;
    }

    public static final String b(LinkedHashMap linkedHashMap, String str, int i) {
        String str2;
        if (i == 0) {
            str2 = str;
        } else {
            str2 = str + "(" + i + ")";
        }
        return linkedHashMap.containsKey(str2) ? b(linkedHashMap, str, i + 1) : str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object c(String str, String str2, LinkedHashMap linkedHashMap, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, ie0 ie0Var) {
        q63 q63Var;
        if (ie0Var instanceof q63) {
            q63Var = (q63) ie0Var;
            int i = q63Var.X;
            if ((i & Integer.MIN_VALUE) != 0) {
                q63Var.X = i - Integer.MIN_VALUE;
            } else {
                q63Var = new q63(ie0Var);
            }
        }
        Object objB0 = q63Var.A;
        int i2 = q63Var.X;
        if (i2 == 0) {
            n12.S(objB0);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            r63 r63Var = new r63(str, str2, linkedHashMap, ed1Var, cd1Var, ad1Var, null);
            q63Var.X = 1;
            objB0 = ji0.b0(pl0Var, r63Var, q63Var);
            mf0 mf0Var = mf0.b;
            if (objB0 == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objB0);
        }
        return ((uk3) objB0).b;
    }

    public static final ea3 d(String str) {
        String strDecode;
        Map map;
        int i;
        String strDecode2;
        int i2;
        char c;
        e03 e03VarU;
        ArrayList arrayList;
        int i3;
        String str2;
        i23 i23Var;
        String str3;
        Map map2;
        String str4;
        String str5;
        String str6;
        lu3 lu3Var;
        String str7;
        String str8;
        String str9;
        Iterator it;
        lu3 lu3Var2;
        ke2 ke2Var = ke2.ERROR;
        lu3 lu3Var3 = lu3.NONE;
        lu3 lu3Var4 = lu3.HTTP;
        lu3 lu3Var5 = lu3.TLS;
        Map linkedHashMap = h41.b;
        str.getClass();
        Uri uri = Uri.parse(str);
        String strDecode3 = "";
        int i4 = 0;
        if (n12.c(uri.getScheme(), "anytls")) {
            try {
                URI uri2 = new URI(str);
                String query = uri2.getQuery();
                if (query != null) {
                    List<String> listK0 = p44.K0(query, new char[]{'&'}, 6);
                    int iU = fh2.U(f70.Q(10, listK0));
                    if (iU < 16) {
                        iU = 16;
                    }
                    linkedHashMap = new LinkedHashMap(iU);
                    for (String str10 : listK0) {
                        char[] cArr = new char[1];
                        cArr[i4] = '=';
                        List listK02 = p44.K0(str10, cArr, 6);
                        e03 e03VarU2 = listK02.size() == 2 ? n12.U(listK02.get(i4), listK02.get(1)) : n12.U(listK02.get(i4), "");
                        linkedHashMap.put(e03VarU2.b, e03VarU2.f);
                        i4 = 0;
                    }
                }
                String userInfo = uri2.getUserInfo();
                if (userInfo != null) {
                    strDecode3 = userInfo;
                }
                String str11 = (String) linkedHashMap.get("sni");
                String str12 = (String) linkedHashMap.get("insecure");
                String host = uri2.getHost();
                host.getClass();
                if (w44.j0(host, "[", false) && w44.d0(host, "]", false)) {
                    host = host.substring(1, host.length() - 1);
                }
                String fragment = uri2.getFragment();
                if (fragment == null || (strDecode = Uri.decode(fragment)) == null) {
                    strDecode = "AnyTls" + str.hashCode();
                }
                int port = uri2.getPort() == -1 ? 443 : uri2.getPort();
                String strDecode4 = Uri.decode(strDecode3);
                strDecode4.getClass();
                return new s9(strDecode, host, port, strDecode4, n12.c(str12, "1"), str11 != null ? Uri.decode(str11) : null, null, true, true, tn.b, null);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        String string = null;
        if (n12.c(uri.getScheme(), "ss")) {
            if (uri.getUserInfo() == null) {
                String host2 = uri.getHost();
                host2.getClass();
                Uri uri3 = Uri.parse("ss://".concat(xj.a(8, host2)));
                if (uri3.getUserInfo() == null) {
                    return null;
                }
                String userInfo2 = uri3.getUserInfo();
                userInfo2.getClass();
                List listK03 = p44.K0(userInfo2, new char[]{':'}, 6);
                String queryParameter = uri3.getQueryParameter("Remark");
                if (queryParameter == null && (queryParameter = uri.getQueryParameter("remark")) == null && (queryParameter = uri.getFragment()) == null) {
                    queryParameter = String.valueOf(str.hashCode());
                }
                String str13 = queryParameter;
                String queryParameter2 = uri3.getQueryParameter("plugin");
                if (queryParameter2 == null || !w44.j0(queryParameter2, "obfs-local;", false)) {
                    str4 = null;
                    str5 = null;
                    str6 = null;
                } else {
                    String string2 = null;
                    String string3 = null;
                    for (String str14 : p44.K0(queryParameter2, new char[]{';'}, 6)) {
                        if (!n12.c(str14, "obfs-local")) {
                            if (w44.j0(str14, "obfs-host", false)) {
                                string2 = p44.U0((String) p44.K0(str14, new char[]{'='}, 6).get(1)).toString();
                            } else if (w44.j0(str14, "obfs-uri", false)) {
                                string3 = p44.U0((String) p44.K0(str14, new char[]{'='}, 6).get(1)).toString();
                            } else if (w44.j0(str14, "obfs", false)) {
                                string = p44.U0((String) p44.K0(str14, new char[]{'='}, 6).get(1)).toString();
                            }
                        }
                    }
                    str5 = string2;
                    str6 = string3;
                    str4 = string;
                }
                String host3 = uri3.getHost();
                host3.getClass();
                int port2 = uri3.getPort();
                String str15 = (String) listK03.get(0);
                String str16 = (String) listK03.get(1);
                lu3.f.getClass();
                return new mu3(str13, host3, port2, str15, str16, n12.c(str4, "tls") ? lu3Var5 : n12.c(str4, "http") ? lu3Var4 : lu3Var3, str5, str6);
            }
            String userInfo3 = uri.getUserInfo();
            userInfo3.getClass();
            List listK04 = p44.K0(xj.a(8, userInfo3), new char[]{':'}, 6);
            String queryParameter3 = uri.getQueryParameter("plugin");
            if ((queryParameter3 == null || !w44.j0(queryParameter3, "obfs-local;", false)) && (queryParameter3 == null || !w44.j0(queryParameter3, "simple-obfs;", false))) {
                lu3Var = lu3Var4;
                str7 = null;
                str8 = null;
                str9 = null;
            } else {
                Iterator it2 = p44.K0(queryParameter3, new char[]{';'}, 6).iterator();
                String string4 = null;
                String string5 = null;
                while (it2.hasNext()) {
                    String str17 = (String) it2.next();
                    if (n12.c(str17, "obfs-local") || n12.c(str17, "simple-obfs")) {
                        it = it2;
                    } else if (w44.j0(str17, "obfs-host", false)) {
                        it = it2;
                        string4 = p44.U0((String) p44.K0(str17, new char[]{'='}, 6).get(1)).toString();
                    } else {
                        it = it2;
                        if (w44.j0(str17, "obfs-uri", false)) {
                            string5 = p44.U0((String) p44.K0(str17, new char[]{'='}, 6).get(1)).toString();
                        } else {
                            lu3Var2 = lu3Var4;
                            if (w44.j0(str17, "obfs", false)) {
                                string = p44.U0((String) p44.K0(str17, new char[]{'='}, 6).get(1)).toString();
                            }
                            it2 = it;
                            lu3Var4 = lu3Var2;
                        }
                    }
                    lu3Var2 = lu3Var4;
                    it2 = it;
                    lu3Var4 = lu3Var2;
                }
                lu3Var = lu3Var4;
                str8 = string4;
                str9 = string5;
                str7 = string;
            }
            String fragment2 = uri.getFragment();
            if (fragment2 == null) {
                fragment2 = String.valueOf(str.hashCode());
            }
            String str18 = fragment2;
            String host4 = uri.getHost();
            host4.getClass();
            int port3 = uri.getPort();
            String str19 = (String) listK04.get(0);
            String str20 = (String) listK04.get(1);
            lu3.f.getClass();
            return new mu3(str18, host4, port3, str19, str20, n12.c(str7, "tls") ? lu3Var5 : n12.c(str7, "http") ? lu3Var : lu3Var3, str8, str9);
        }
        if (n12.c(uri.getScheme(), "vmess")) {
            try {
                String schemeSpecificPart = uri.getSchemeSpecificPart();
                schemeSpecificPart.getClass();
                JSONObject jSONObject = new JSONObject(xj.a(0, p44.F0(schemeSpecificPart, "//")));
                String strOptString = jSONObject.optString("ps");
                strOptString.getClass();
                boolean z = p44.p0(strOptString, '#') || p44.p0(strOptString, ';') || p44.o0(strOptString, "// ", false);
                if (p44.x0(strOptString) || z) {
                    strOptString = "VMESS" + str.hashCode();
                }
                String str21 = strOptString;
                String strOptString2 = jSONObject.optString("type");
                if (!n12.c(strOptString2, "none") && !n12.c(strOptString2, "auto") && !n12.c(strOptString2, "")) {
                    throw new JSONException("not support vmess type " + strOptString2);
                }
                String string6 = jSONObject.getString("add");
                String strOptString3 = jSONObject.optString("host");
                int i5 = jSONObject.getInt(RtspHeaders.Values.PORT);
                String string7 = jSONObject.getString("id");
                boolean zC = n12.c(jSONObject.getString("tls"), "tls");
                String strOptString4 = jSONObject.optString("sni");
                boolean zC2 = n12.c(jSONObject.getString("net"), "ws");
                String strOptString5 = jSONObject.optString("path");
                strOptString3.getClass();
                if (p44.x0(strOptString3)) {
                    map = linkedHashMap;
                } else {
                    e03 e03VarU3 = n12.U("Host", strOptString3);
                    Map mapSingletonMap = Collections.singletonMap(e03VarU3.b, e03VarU3.f);
                    mapSingletonMap.getClass();
                    map = mapSingletonMap;
                }
                boolean z2 = jSONObject.getInt("aid") == 0;
                string6.getClass();
                string7.getClass();
                return new ms4(str21, string6, i5, string7, zC, zC2, p44.x0(strOptString5) ? "/" : strOptString5, map, false, p44.x0(strOptString4) ? null : strOptString4, null, false, z2, tn.b, null);
            } catch (JSONException e2) {
                String schemeSpecificPart2 = uri.getSchemeSpecificPart();
                schemeSpecificPart2.getClass();
                new IllegalArgumentException("invalid proxy json content: ".concat(xj.a(0, p44.F0(schemeSpecificPart2, "//"))), e2).printStackTrace();
                return null;
            }
        }
        if (n12.c(uri.getScheme(), "trojan")) {
            String queryParameter4 = uri.getQueryParameter("sni");
            String queryParameter5 = uri.getQueryParameter("type");
            String queryParameter6 = uri.getQueryParameter("path");
            String str22 = queryParameter6 == null ? "/" : queryParameter6;
            String queryParameter7 = uri.getQueryParameter("host");
            String queryParameter8 = uri.getQueryParameter("allowInsecure");
            String userInfo4 = uri.getUserInfo();
            if (queryParameter4 == null || kx0.c().e(queryParameter4)) {
                str3 = queryParameter4;
            } else {
                String str23 = ((Object) queryParameter4) + " is not a valid sni value";
                if (fy4.b) {
                    Xlog.logWrite2(0L, ke2Var.a(), "ProfileFetchUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str23);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("ProfileFetchUtils", str23, null);
                }
                str3 = null;
            }
            if (userInfo4 != null && userInfo4.length() != 0) {
                String fragment3 = uri.getFragment();
                if (fragment3 == null) {
                    fragment3 = dw2.A(str.hashCode(), "Trojan");
                }
                String str24 = fragment3;
                String host5 = uri.getHost();
                host5.getClass();
                int port4 = uri.getPort();
                boolean zW = ji0.W(queryParameter8);
                boolean zC3 = n12.c(queryParameter5, "ws");
                if (queryParameter7 != null) {
                    e03 e03VarU4 = n12.U("Host", queryParameter7);
                    Map mapSingletonMap2 = Collections.singletonMap(e03VarU4.b, e03VarU4.f);
                    mapSingletonMap2.getClass();
                    map2 = mapSingletonMap2;
                } else {
                    map2 = linkedHashMap;
                }
                return new xh4(str24, host5, port4, userInfo4, zC3, str22, map2, zW, str3, null, false, tn.b, null);
            }
            if (fy4.b) {
                Xlog.logWrite2(0L, ke2Var.a(), "ProfileFetchUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "empty trojan password");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("ProfileFetchUtils", "empty trojan password", null);
                return null;
            }
        } else if (n12.c(uri.getScheme(), "hysteria2") || n12.c(uri.getScheme(), "hy2")) {
            try {
                String strF0 = p44.F0(p44.F0(str, "hysteria2://"), "hy2://");
                int iU0 = p44.u0(strF0, '#', 0, 6);
                if (iU0 != -1) {
                    strDecode2 = Uri.decode(strF0.substring(iU0 + 1));
                    i = -1;
                } else {
                    i = -1;
                    strDecode2 = null;
                }
                if (iU0 != i) {
                    i2 = 0;
                    strF0 = strF0.substring(0, iU0);
                } else {
                    i2 = 0;
                }
                int iU02 = p44.u0(strF0, '?', i2, 6);
                String strSubstring = iU02 != -1 ? strF0.substring(iU02 + 1) : "";
                if (iU02 != -1) {
                    c = 0;
                    strF0 = strF0.substring(0, iU02);
                } else {
                    c = 0;
                }
                char[] cArr2 = new char[1];
                cArr2[c] = '&';
                List listK05 = p44.K0(strSubstring, cArr2, 6);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listK05) {
                    if (((String) obj).length() > 0) {
                        arrayList2.add(obj);
                    }
                }
                int iU2 = fh2.U(f70.Q(10, arrayList2));
                if (iU2 < 16) {
                    iU2 = 16;
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(iU2);
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    List listK06 = p44.K0((String) it3.next(), new char[]{'='}, 2);
                    e03 e03VarU5 = n12.U(listK06.get(0), listK06.size() == 2 ? Uri.decode((String) listK06.get(1)) : "");
                    linkedHashMap2.put(e03VarU5.b, e03VarU5.f);
                }
                if (linkedHashMap2.containsKey("obfs")) {
                    throw new IllegalArgumentException("hysteria2 obfs is not supported");
                }
                int iZ0 = p44.z0(strF0, '@', 0, 6);
                int i6 = -1;
                if (iZ0 != -1) {
                    strDecode3 = Uri.decode(strF0.substring(0, iZ0));
                    i6 = -1;
                }
                if (iZ0 != i6) {
                    strF0 = strF0.substring(iZ0 + 1);
                }
                if (w44.j0(strF0, "[", false)) {
                    int iU03 = p44.u0(strF0, ']', 0, 6);
                    int i7 = iU03 + 1;
                    e03VarU = n12.U(strF0.substring(1, iU03), (i7 >= strF0.length() || strF0.charAt(i7) != ':') ? null : strF0.substring(iU03 + 2));
                } else {
                    int iZ02 = p44.z0(strF0, ':', 0, 6);
                    e03VarU = iZ02 != -1 ? n12.U(strF0.substring(0, iZ02), strF0.substring(iZ02 + 1)) : n12.U(strF0, null);
                }
                String str25 = (String) e03VarU.b;
                String str26 = (String) e03VarU.f;
                if (str26 != null) {
                    List listK07 = p44.K0(str26, new char[]{StringUtil.COMMA}, 6);
                    arrayList = new ArrayList(f70.Q(10, listK07));
                    Iterator it4 = listK07.iterator();
                    while (it4.hasNext()) {
                        List listK08 = p44.K0(p44.U0((String) it4.next()).toString(), new char[]{'-'}, 2);
                        if (listK08.size() == 2) {
                            i23Var = new i23(Integer.parseInt((String) listK08.get(0)), Integer.parseInt((String) listK08.get(1)));
                        } else {
                            int i8 = Integer.parseInt((String) listK08.get(0));
                            i23Var = new i23(i8, i8);
                        }
                        arrayList.add(i23Var);
                    }
                    int i9 = ((i23) d70.d0(arrayList)).b;
                    if (listK07.size() <= 1 && ((i23) d70.d0(arrayList)).b == ((i23) d70.d0(arrayList)).f) {
                        arrayList = null;
                    }
                    i3 = i9;
                } else {
                    arrayList = null;
                    i3 = 443;
                }
                if (strDecode2 == null) {
                    strDecode2 = "Hysteria2" + str.hashCode();
                }
                String str27 = strDecode2;
                strDecode3.getClass();
                boolean zC4 = n12.c(linkedHashMap2.get("insecure"), "1");
                String str28 = (String) linkedHashMap2.get("sni");
                if (str28 != null) {
                    if (p44.x0(str28)) {
                        str28 = null;
                    }
                    str2 = str28;
                } else {
                    str2 = null;
                }
                return new jv1(str27, str25, i3, strDecode3, null, arrayList, null, null, zC4, str2, null, true, tn.b, null);
            } catch (IllegalArgumentException e3) {
                throw e3;
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static final List e(String str) {
        str.getClass();
        if (str.length() == 0) {
            return g41.b;
        }
        List listB0 = p44.B0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB0) {
            if (!p44.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!g((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            if (f((String) obj3)) {
                arrayList3.add(obj3);
            }
        }
        return arrayList3;
    }

    public static final boolean f(String str) {
        str.getClass();
        return w44.j0(str, "trojan://", false) || w44.j0(str, "ss://", false) || w44.j0(str, "vmess://", false) || w44.j0(str, "anytls://", false) || w44.j0(str, "hysteria2://", false) || w44.j0(str, "hy2://", false);
    }

    public static final boolean g(String str) {
        str.getClass();
        return new gn4(new String[]{"http", "https"}).a(str) || w44.j0(str, "surfboard://", false) || w44.j0(str, "surge://", false) || w44.j0(str, "surge3://", false);
    }

    public static final String h(String str) {
        String queryParameter;
        str.getClass();
        Uri uri = Uri.parse(str);
        return (d70.W(uri.getScheme(), a) && n12.c(uri.getPath(), "/install-config") && uri.getQueryParameterNames().contains(RtspHeaders.Values.URL) && (queryParameter = uri.getQueryParameter(RtspHeaders.Values.URL)) != null && new gn4(new String[]{"http", "https"}).a(queryParameter)) ? queryParameter : str;
    }
}
