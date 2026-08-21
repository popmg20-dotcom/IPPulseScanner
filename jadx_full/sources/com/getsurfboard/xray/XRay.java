package com.getsurfboard.xray;

import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import defpackage.ai4;
import defpackage.az3;
import defpackage.d70;
import defpackage.e03;
import defpackage.e70;
import defpackage.ea3;
import defpackage.ew4;
import defpackage.f70;
import defpackage.fh2;
import defpackage.fm3;
import defpackage.fw4;
import defpackage.fy4;
import defpackage.gv1;
import defpackage.ha0;
import defpackage.ha3;
import defpackage.ii3;
import defpackage.ji0;
import defpackage.jv1;
import defpackage.le2;
import defpackage.li3;
import defpackage.ms4;
import defpackage.mu3;
import defpackage.ou1;
import defpackage.p95;
import defpackage.s9;
import defpackage.sy3;
import defpackage.t4;
import defpackage.t53;
import defpackage.tu0;
import defpackage.vo;
import defpackage.xh4;
import defpackage.zy3;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class XRay {
    public static final Companion d = new Companion();
    public static volatile XRay e;
    public final HashMap a = new HashMap();
    public volatile boolean b;
    public t4 c;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Companion {
        public final void onSystemTimeError() throws NoSuchMethodException, UnknownHostException {
            t4 t4Var;
            XRay xRay = XRay.e;
            if (xRay == null || (t4Var = xRay.c) == null) {
                return;
            }
            t4Var.a();
        }
    }

    static {
        System.loadLibrary("xlog");
        System.loadLibrary("xray");
        File file = new File(ContextUtilsKt.getContext().getFilesDir(), "crash/xray_crash.log");
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        nativeInit(absolutePath);
    }

    private static final native void nativeInit(String str);

    private static final native String nativeStart(String str, String str2, boolean z);

    private static final native void nativeStop();

    public static final void onSystemTimeError() throws NoSuchMethodException, UnknownHostException {
        d.onSystemTimeError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str, LinkedHashSet linkedHashSet, boolean z, boolean z2, boolean z3, boolean z4, t53 t53Var, HashMap map) {
        Iterator it;
        String str2;
        LinkedList linkedList;
        LinkedHashMap linkedHashMap;
        ArrayList arrayList;
        JSONObject jSONObject;
        JSONArray jSONArray;
        ea3 ea3Var;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        JSONArray jSONArray2;
        ArrayList arrayList2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        t53 t53Var2 = t53Var;
        HashMap map2 = map;
        str.getClass();
        map2.getClass();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        JSONObject jSONObject11 = new JSONObject("{\n    \"log\": {\n        \"loglevel\": \"info\",\n        \"access\": \"none\",\n        \"error\": \"\"\n    },\n    \"routing\": {\n        \"domainStrategy\": \"AsIs\",\n        \"rules\": []\n    },\n    \"inbounds\": [],\n    \"outbounds\": []\n}");
        JSONArray jSONArray5 = jSONObject11.getJSONObject("routing").getJSONArray("rules");
        JSONArray jSONArray6 = jSONObject11.getJSONArray("outbounds");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : linkedHashSet) {
            ea3 ea3Var2 = (ea3) obj;
            if (!(ea3Var2 instanceof tu0) && !(ea3Var2 instanceof ii3) && !(ea3Var2 instanceof li3)) {
                arrayList4.add(obj);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList4) {
            ArrayList arrayList7 = arrayList4;
            if (((ea3) obj2).A(t53Var2, map2, z2)) {
                arrayList5.add(obj2);
            } else {
                arrayList6.add(obj2);
            }
            arrayList4 = arrayList7;
        }
        ArrayList<ea3> arrayList8 = arrayList4;
        int size = arrayList5.size();
        int i = 1;
        LinkedList linkedListP = ji0.p(size, str, true);
        int i2 = 0;
        LinkedList linkedListP2 = ji0.p(arrayList6.size(), str, false);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (ea3 ea3Var3 : arrayList8) {
            int i3 = i;
            int i4 = i2;
            String strC = ea3Var3.C();
            Integer num = (Integer) linkedHashMap2.get(strC);
            int iIntValue = num != null ? num.intValue() : i4;
            LinkedList linkedList2 = linkedListP;
            linkedHashMap2.put(strC, Integer.valueOf(iIntValue + 1));
            if (iIntValue != 0) {
                strC = strC + " (" + iIntValue + ")";
            }
            linkedHashMap3.put(ea3Var3, strC);
            i = i3;
            i2 = i4;
            linkedListP = linkedList2;
        }
        LinkedList linkedList3 = linkedListP;
        int i5 = i;
        int i6 = i2;
        Iterator it2 = arrayList8.iterator();
        JSONArray jSONArray7 = jSONArray6;
        while (it2.hasNext()) {
            ea3 ea3Var4 = (ea3) it2.next();
            Object obj3 = linkedHashMap3.get(ea3Var4);
            obj3.getClass();
            String str3 = (String) obj3;
            if (ea3Var4.q() != null) {
                String strQ = ea3Var4.q();
                strQ.getClass();
                ea3 ea3VarL = t53Var2.l(strQ, map2);
                if (ea3VarL != null) {
                    String strC2 = (String) linkedHashMap3.get(ea3VarL);
                    if (strC2 == null) {
                        strC2 = ea3VarL.C();
                    }
                    str2 = strC2;
                    it = it2;
                } else {
                    it = it2;
                    str2 = null;
                }
            }
            if (ea3Var4 instanceof zy3) {
                zy3 zy3Var = (zy3) ea3Var4;
                linkedList = linkedListP2;
                linkedHashMap = linkedHashMap3;
                JSONObject jSONObjectW = vo.w(zy3Var.z, zy3Var.f, str3, zy3Var.A, zy3Var.X);
                vo.c(jSONObjectW, z4);
                if (str2 != null) {
                    vo.b(jSONObjectW, str2);
                }
                jSONObject10 = jSONObjectW;
            } else {
                linkedList = linkedListP2;
                linkedHashMap = linkedHashMap3;
                if (ea3Var4 instanceof az3) {
                    az3 az3Var = (az3) ea3Var4;
                    JSONObject jSONObjectD = vo.d(vo.w(az3Var.z, az3Var.f, str3, az3Var.A, az3Var.X), az3Var.f, az3Var.Z, (z || az3Var.y0 != null || az3Var.Y) ? i5 : i6, z3, az3Var.y0);
                    vo.c(jSONObjectD, z4);
                    jSONObject10 = jSONObjectD;
                    if (str2 != null) {
                        vo.b(jSONObjectD, str2);
                        jSONObject10 = jSONObjectD;
                    }
                } else if (ea3Var4 instanceof ou1) {
                    ou1 ou1Var = (ou1) ea3Var4;
                    JSONObject jSONObjectS = vo.s(ou1Var.z, ou1Var.f, str3, ou1Var.A, ou1Var.X);
                    vo.c(jSONObjectS, z4);
                    jSONObject10 = jSONObjectS;
                    if (str2 != null) {
                        vo.b(jSONObjectS, str2);
                        jSONObject10 = jSONObjectS;
                    }
                } else if (ea3Var4 instanceof gv1) {
                    gv1 gv1Var = (gv1) ea3Var4;
                    jSONObject = jSONObject11;
                    arrayList = arrayList3;
                    JSONObject jSONObjectD2 = vo.d(vo.s(gv1Var.z, gv1Var.f, str3, gv1Var.A, gv1Var.X), gv1Var.f, gv1Var.Z, (z || gv1Var.y0 != null || gv1Var.Y) ? i5 : i6, z3, gv1Var.y0);
                    vo.c(jSONObjectD2, z4);
                    jSONObjectD2.getJSONObject("streamSettings").getJSONObject("tlsSettings").put("alpn", new JSONArray((Collection) p95.x(ApplicationProtocolNames.HTTP_1_1)));
                    if (str2 != null) {
                        vo.b(jSONObjectD2, str2);
                    }
                    ea3Var = ea3Var4;
                    jSONObject9 = jSONObjectD2;
                    jSONArray = jSONArray5;
                    jSONObject8 = jSONObject9;
                    jSONArray2 = jSONArray7;
                    jSONObject2 = jSONObject8;
                    if (jSONObject2 != null) {
                        jSONArray4 = jSONArray2;
                        jSONArray4.put(jSONObject2);
                        t53Var2 = t53Var;
                        map2 = map;
                        boolean zA = ea3Var.A(t53Var2, map2, z2);
                        JSONObject jSONObject12 = new JSONObject(String.format("{\n    \"type\": \"field\",\n    \"network\": \"%s\"\n}", Arrays.copyOf(new Object[]{zA ? "tcp,udp" : "tcp"}, 1)));
                        jSONObject12.put("inboundTag", new JSONArray().put(str3));
                        jSONObject12.put("outboundTag", str3);
                        jSONArray3 = jSONArray;
                        jSONArray3.put(jSONObject12);
                        int iIntValue2 = -1;
                        if (zA) {
                            Integer num2 = (Integer) linkedList3.poll();
                            if (num2 != null) {
                                iIntValue2 = num2.intValue();
                            }
                        } else {
                            Integer num3 = (Integer) linkedList.poll();
                            if (num3 != null) {
                                iIntValue2 = num3.intValue();
                            }
                        }
                        ha3 ha3Var = new ha3(str3, iIntValue2, zA);
                        arrayList2 = arrayList;
                        arrayList2.add(ha3Var);
                    } else {
                        t53Var2 = t53Var;
                        map2 = map;
                        arrayList2 = arrayList;
                        jSONArray3 = jSONArray;
                        jSONArray4 = jSONArray2;
                    }
                    arrayList3 = arrayList2;
                    jSONArray7 = jSONArray4;
                    jSONArray5 = jSONArray3;
                    it2 = it;
                    linkedListP2 = linkedList;
                    linkedHashMap3 = linkedHashMap;
                    jSONObject11 = jSONObject;
                    i5 = 1;
                    i6 = 0;
                } else {
                    arrayList = arrayList3;
                    jSONObject = jSONObject11;
                    if (ea3Var4 instanceof mu3) {
                        mu3 mu3Var = (mu3) ea3Var4;
                        String str4 = mu3Var.f;
                        int i7 = mu3Var.z;
                        String str5 = mu3Var.A;
                        String str6 = mu3Var.X;
                        String str7 = mu3Var.Y.b;
                        jSONArray = jSONArray5;
                        String str8 = (String) mu3Var.C0.getValue();
                        String str9 = (String) mu3Var.D0.getValue();
                        Integer numValueOf = Integer.valueOf(i7);
                        Object[] objArr = new Object[4];
                        objArr[i6] = str4;
                        objArr[i5] = numValueOf;
                        objArr[2] = str5;
                        objArr[3] = str6;
                        JSONObject jSONObject13 = new JSONObject(String.format("{\n    \"protocol\": \"shadowsocks\",\n    \"settings\": {\n        \"servers\": [\n            {\n                \"address\": \"%s\",\n                \"port\": %d,\n                \"method\": \"%s\",\n                \"password\": \"%s\"\n            }\n        ]\n    }\n}", Arrays.copyOf(objArr, 4)));
                        jSONObject13.put("tag", str3);
                        if (str7.length() != 0 && !str7.equals("none")) {
                            JSONObject jSONObject14 = jSONObject13.getJSONObject("settings").getJSONArray("servers").getJSONObject(i6);
                            jSONObject14.put("obfs", str7);
                            if (str8 != null && str8.length() != 0) {
                                jSONObject14.put("obfsHost", str8);
                            }
                            if (str9 != null && str9.length() != 0) {
                                jSONObject14.put("obfsUri", str9);
                            }
                        }
                        vo.c(jSONObject13, z4);
                        if (str2 != null) {
                            vo.b(jSONObject13, str2);
                        }
                        jSONObject8 = jSONObject13;
                        ea3Var = ea3Var4;
                        jSONArray2 = jSONArray7;
                        jSONObject2 = jSONObject8;
                        if (jSONObject2 != null) {
                        }
                        arrayList3 = arrayList2;
                        jSONArray7 = jSONArray4;
                        jSONArray5 = jSONArray3;
                        it2 = it;
                        linkedListP2 = linkedList;
                        linkedHashMap3 = linkedHashMap;
                        jSONObject11 = jSONObject;
                        i5 = 1;
                        i6 = 0;
                    } else {
                        jSONArray = jSONArray5;
                        JSONArray jSONArray8 = jSONArray7;
                        if (ea3Var4 instanceof xh4) {
                            xh4 xh4Var = (xh4) ea3Var4;
                            Map map3 = xh4Var.Z;
                            String str10 = xh4Var.f;
                            int i8 = xh4Var.z;
                            String str11 = xh4Var.A;
                            Integer numValueOf2 = Integer.valueOf(i8);
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = str10;
                            objArr2[i5] = numValueOf2;
                            objArr2[2] = str11;
                            jSONObject4 = new JSONObject(String.format("{\n    \"protocol\": \"trojan\",\n    \"settings\": {\n        \"servers\": [\n            {\n                \"address\": \"%s\",\n                \"port\": %d,\n                \"password\": \"%s\"\n            }\n        ]\n    }\n}", Arrays.copyOf(objArr2, 3)));
                            jSONObject4.put("tag", str3);
                            vo.d(jSONObject4, xh4Var.f, xh4Var.z0, (z || xh4Var.A0 != null) ? i5 : xh4Var.y0, z3, xh4Var.A0);
                            vo.c(jSONObject4, z4);
                            if (xh4Var.X) {
                                if (jSONObject4.has("streamSettings")) {
                                    jSONObject7 = jSONObject4.getJSONObject("streamSettings");
                                    jSONObject7.getClass();
                                } else {
                                    jSONObject7 = new JSONObject();
                                    jSONObject4.put("streamSettings", jSONObject7);
                                }
                                int i9 = i5;
                                Object[] objArr3 = new Object[i9];
                                objArr3[0] = xh4Var.Y;
                                JSONObject jSONObject15 = new JSONObject(String.format("{\n    \"network\": \"ws\",\n    \"wsSettings\": {\n        \"path\": \"%s\",\n        \"headers\": {}\n    }\n}", Arrays.copyOf(objArr3, i9)));
                                if (!map3.isEmpty()) {
                                    JSONObject jSONObject16 = jSONObject15.getJSONObject("wsSettings").getJSONObject("headers");
                                    for (Map.Entry entry : map3.entrySet()) {
                                        jSONObject16.put((String) entry.getKey(), entry.getValue());
                                    }
                                }
                                if (!map3.containsKey("Host")) {
                                    jSONObject15.getJSONObject("wsSettings").getJSONObject("headers").put("Host", "");
                                }
                                Iterator<String> itKeys = jSONObject15.keys();
                                itKeys.getClass();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    jSONObject7.put(next, jSONObject15.get(next));
                                }
                            }
                            if (str2 != null) {
                                vo.b(jSONObject4, str2);
                            }
                        } else {
                            if (ea3Var4 instanceof fw4) {
                                fw4 fw4Var = (fw4) ea3Var4;
                                String str12 = fw4Var.f;
                                String str13 = fw4Var.z;
                                String str14 = fw4Var.A;
                                LinkedHashSet linkedHashSet2 = fw4Var.X;
                                ew4 ew4Var = fw4Var.Z;
                                String str15 = ew4Var.b;
                                String str16 = ew4Var.f;
                                ArrayList arrayList9 = ew4Var.z;
                                e03 e03Var = ew4Var.A;
                                int i10 = ew4Var.X;
                                int i11 = fw4Var.Y;
                                ArrayList arrayListL = e70.L(ha0.x(str13, "/32"));
                                if (str14 != null && str14.length() != 0) {
                                    arrayListL.add(str14.concat("/128"));
                                }
                                JSONObject jSONObject17 = new JSONObject(String.format("{\n    \"protocol\": \"wireguard\",\n    \"settings\": {\n        \"secretKey\": \"%s\",\n        \"address\": %s,\n        \"peers\": [\n            {\n                \"publicKey\": \"%s\",\n                \"allowedIPs\":[],\n                \"endpoint\": \"%s\",\n                \"keepAlive\": %d\n            }\n        ],\n        \"isClient\": true,\n        \"mtu\": %d\n    }\n}", Arrays.copyOf(new Object[]{str12, new JSONArray((Collection) arrayListL).toString(), str15, e03Var.b + ":" + e03Var.f, Integer.valueOf(i10), Integer.valueOf(i11)}, 6)));
                                jSONObject17.put("tag", str3);
                                JSONObject jSONObject18 = jSONObject17.getJSONObject("settings");
                                JSONObject jSONObject19 = jSONObject18.getJSONArray("peers").getJSONObject(0);
                                if (str16 != null) {
                                    jSONObject19.put("preSharedKey", str16);
                                }
                                JSONArray jSONArray9 = jSONObject19.getJSONArray("allowedIPs");
                                Iterator it3 = arrayList9.iterator();
                                while (it3.hasNext()) {
                                    jSONArray9.put(((fm3) it3.next()).toString());
                                }
                                if (!linkedHashSet2.isEmpty()) {
                                    jSONObject18.put("dns", new JSONArray((Collection) linkedHashSet2));
                                }
                                vo.c(jSONObject17, z4);
                                jSONObject6 = jSONObject17;
                                if (str2 != null) {
                                    vo.b(jSONObject17, str2);
                                    jSONObject6 = jSONObject17;
                                }
                            } else if (ea3Var4 instanceof ms4) {
                                ms4 ms4Var = (ms4) ea3Var4;
                                Map map4 = ms4Var.y0;
                                jSONObject4 = new JSONObject(String.format("{\n    \"protocol\": \"vmess\",\n    \"settings\": {\n        \"vnext\": [\n            {\n                \"address\": \"%s\",\n                \"port\": %d,\n                \"users\": [\n                    {\n                        \"id\": \"%s\",\n                        \"alterId\": %d,\n                        \"security\": \"auto\"\n                    }\n                ]\n            }\n        ]\n    }\n}", Arrays.copyOf(new Object[]{ms4Var.f, Integer.valueOf(ms4Var.z), ms4Var.A, Integer.valueOf(!ms4Var.D0 ? 1 : 0)}, 4)));
                                jSONObject4.put("tag", str3);
                                if (ms4Var.X) {
                                    vo.d(jSONObject4, ms4Var.f, ms4Var.A0, (z || ms4Var.B0 != null) ? true : ms4Var.z0, z3, ms4Var.B0);
                                }
                                vo.c(jSONObject4, z4);
                                if (ms4Var.Y) {
                                    if (jSONObject4.has("streamSettings")) {
                                        jSONObject5 = jSONObject4.getJSONObject("streamSettings");
                                        jSONObject5.getClass();
                                    } else {
                                        jSONObject5 = new JSONObject();
                                        jSONObject4.put("streamSettings", jSONObject5);
                                    }
                                    JSONObject jSONObject20 = new JSONObject(String.format("{\n    \"network\": \"ws\",\n    \"wsSettings\": {\n        \"path\": \"%s\",\n        \"headers\": {}\n    }\n}", Arrays.copyOf(new Object[]{ms4Var.Z}, 1)));
                                    if (!map4.isEmpty()) {
                                        JSONObject jSONObject21 = jSONObject20.getJSONObject("wsSettings").getJSONObject("headers");
                                        for (Map.Entry entry2 : map4.entrySet()) {
                                            jSONObject21.put((String) entry2.getKey(), entry2.getValue());
                                        }
                                    }
                                    if (!map4.containsKey("Host")) {
                                        jSONObject20.getJSONObject("wsSettings").getJSONObject("headers").put("Host", "");
                                    }
                                    Iterator<String> itKeys2 = jSONObject20.keys();
                                    itKeys2.getClass();
                                    while (itKeys2.hasNext()) {
                                        String next2 = itKeys2.next();
                                        jSONObject5.put(next2, jSONObject20.get(next2));
                                    }
                                }
                                if (str2 != null) {
                                    vo.b(jSONObject4, str2);
                                }
                            } else if (ea3Var4 instanceof jv1) {
                                jv1 jv1Var = (jv1) ea3Var4;
                                JSONObject jSONObject22 = new JSONObject(String.format("{\n    \"protocol\": \"hysteria\",\n    \"settings\": {\n        \"version\": 2,\n        \"address\": \"%s\",\n        \"port\": %d\n    }\n}", Arrays.copyOf(new Object[]{jv1Var.f, Integer.valueOf(jv1Var.z)}, 2)));
                                jSONObject22.put("tag", str3);
                                vo.d(jSONObject22, jv1Var.f, jv1Var.A0, (z || jv1Var.B0 != null) ? true : jv1Var.z0, z3, jv1Var.B0);
                                JSONObject jSONObject23 = jSONObject22;
                                JSONObject jSONObjectOptJSONObject = jSONObject23.optJSONObject("streamSettings");
                                JSONObject jSONObject24 = jSONObjectOptJSONObject;
                                if (jSONObjectOptJSONObject == null) {
                                    JSONObject jSONObject25 = new JSONObject();
                                    jSONObject23.put("streamSettings", jSONObject25);
                                    jSONObject24 = jSONObject25;
                                }
                                jSONObject24.put("network", "hysteria");
                                JSONObject jSONObject26 = new JSONObject();
                                jSONObject26.put("version", 2);
                                String str17 = jv1Var.A;
                                String str18 = jv1Var.y0;
                                jSONObject26.put("auth", str17);
                                jSONObject26.put("up", "0");
                                Integer num4 = jv1Var.X;
                                jSONObject26.put("down", num4 != null ? num4 + " mbps" : "0");
                                if (str18 != null) {
                                    jSONObject26.put("obfs", "salamander");
                                    jSONObject26.put("obfsPassword", str18);
                                }
                                List list = jv1Var.Y;
                                if (list != null && !list.isEmpty()) {
                                    JSONObject jSONObject27 = new JSONObject();
                                    jSONObject27.put(RtspHeaders.Values.PORT, d70.j0(list, ",", null, null, null, 62));
                                    Integer num5 = jv1Var.Z;
                                    jSONObject27.put("interval", num5 != null ? num5.intValue() : 30);
                                    jSONObject26.put("udphop", jSONObject27);
                                }
                                jSONObject24.put("hysteriaSettings", jSONObject26);
                                vo.c(jSONObject23, z4);
                                jSONObject6 = jSONObject23;
                                if (str2 != null) {
                                    vo.b(jSONObject23, str2);
                                    jSONObject6 = jSONObject23;
                                }
                            } else {
                                if (ea3Var4 instanceof ai4) {
                                    ai4 ai4Var = (ai4) ea3Var4;
                                    JSONObject jSONObject28 = new JSONObject(String.format("{\n    \"protocol\": \"tuic\",\n    \"settings\": {\n        \"version\": 5,\n        \"address\": \"%s\",\n        \"port\": %d\n    }\n}", Arrays.copyOf(new Object[]{ai4Var.f, Integer.valueOf(ai4Var.z)}, 2)));
                                    jSONObject28.put("tag", str3);
                                    vo.d(jSONObject28, ai4Var.f, ai4Var.A0, (z || ai4Var.B0 != null) ? true : ai4Var.z0, z3, ai4Var.B0);
                                    JSONObject jSONObjectOptJSONObject2 = jSONObject28.optJSONObject("streamSettings");
                                    JSONObject jSONObject29 = jSONObjectOptJSONObject2;
                                    if (jSONObjectOptJSONObject2 == null) {
                                        JSONObject jSONObject30 = new JSONObject();
                                        jSONObject28.put("streamSettings", jSONObject30);
                                        jSONObject29 = jSONObject30;
                                    }
                                    jSONObject29.put("network", "tuic");
                                    JSONObject jSONObject31 = new JSONObject();
                                    jSONObject31.put("uuid", ai4Var.A);
                                    jSONObject31.put("password", ai4Var.X);
                                    String str19 = ai4Var.Y;
                                    if (str19 != null) {
                                        jSONObject31.put("alpn", str19);
                                    }
                                    List list2 = ai4Var.Z;
                                    if (list2 != null && !list2.isEmpty()) {
                                        JSONObject jSONObject32 = new JSONObject();
                                        jSONObject32.put(RtspHeaders.Values.PORT, d70.j0(list2, ",", null, null, null, 62));
                                        Integer num6 = ai4Var.y0;
                                        jSONObject32.put("interval", num6 != null ? num6.intValue() : 30);
                                        jSONObject31.put("udphop", jSONObject32);
                                    }
                                    jSONObject29.put("tuicSettings", jSONObject31);
                                    vo.c(jSONObject28, z4);
                                    if (str2 != null) {
                                        vo.b(jSONObject28, str2);
                                    }
                                    jSONObject3 = jSONObject28;
                                } else if (ea3Var4 instanceof s9) {
                                    s9 s9Var = (s9) ea3Var4;
                                    JSONObject jSONObject33 = new JSONObject(String.format("{\n    \"protocol\": \"anytls\",\n    \"settings\": {\n        \"server\": [\n            {\n                \"address\": \"%s\",\n                \"port\": %d\n            }\n        ],\n        \"password\": \"%s\",\n        \"reuse\": %s\n    }\n}", Arrays.copyOf(new Object[]{s9Var.f, Integer.valueOf(s9Var.z), s9Var.A, s9Var.y0 ? "true" : "false"}, 4)));
                                    jSONObject33.put("tag", str3);
                                    vo.d(jSONObject33, s9Var.f, s9Var.Y, (z || s9Var.Z != null) ? true : s9Var.X, z3, s9Var.Z);
                                    JSONObject jSONObject34 = jSONObject33;
                                    vo.c(jSONObject34, z4);
                                    jSONObject3 = jSONObject34;
                                    if (str2 != null) {
                                        vo.b(jSONObject34, str2);
                                        jSONObject3 = jSONObject34;
                                    }
                                } else {
                                    if (ea3Var4 instanceof sy3) {
                                        sy3 sy3Var = (sy3) ea3Var4;
                                        String str20 = sy3Var.f;
                                        int i12 = sy3Var.z;
                                        String str21 = sy3Var.A;
                                        int i13 = sy3Var.X;
                                        String str22 = sy3Var.Y;
                                        String str23 = sy3Var.Z;
                                        String str24 = sy3Var.y0;
                                        ea3Var = ea3Var4;
                                        JSONObject jSONObject35 = new JSONObject(String.format("{\n    \"protocol\": \"snell\",\n    \"settings\": {\n        \"server\": [\n            {\n                \"address\": \"%s\",\n                \"port\": %d\n            }\n        ]\n    }\n}", Arrays.copyOf(new Object[]{str20, Integer.valueOf(i12)}, 2)));
                                        jSONObject35.put("tag", str3);
                                        JSONObject jSONObject36 = jSONObject35.getJSONObject("settings").getJSONArray("server").getJSONObject(0);
                                        jSONObject36.put("psk", str21);
                                        if (i13 > 4) {
                                            i13 = 4;
                                        }
                                        jSONObject36.put("version", i13);
                                        if (str22 != null && str22.length() != 0) {
                                            jSONObject36.put("obfs", str22);
                                        }
                                        if (str23 != null && str23.length() != 0) {
                                            jSONObject36.put("obfsHost", str23);
                                        }
                                        if (str24 != null && str24.length() != 0) {
                                            jSONObject36.put("obfsUri", str24);
                                        }
                                        vo.c(jSONObject35, z4);
                                        if (str2 != null) {
                                            vo.b(jSONObject35, str2);
                                        }
                                        jSONObject2 = jSONObject35;
                                        jSONArray2 = jSONArray8;
                                    } else {
                                        ea3Var = ea3Var4;
                                        jSONObject2 = null;
                                        jSONArray2 = jSONArray8;
                                    }
                                    if (jSONObject2 != null) {
                                    }
                                    arrayList3 = arrayList2;
                                    jSONArray7 = jSONArray4;
                                    jSONArray5 = jSONArray3;
                                    it2 = it;
                                    linkedListP2 = linkedList;
                                    linkedHashMap3 = linkedHashMap;
                                    jSONObject11 = jSONObject;
                                    i5 = 1;
                                    i6 = 0;
                                }
                                ea3Var = ea3Var4;
                                jSONObject2 = jSONObject3;
                                jSONArray2 = jSONArray8;
                                if (jSONObject2 != null) {
                                }
                                arrayList3 = arrayList2;
                                jSONArray7 = jSONArray4;
                                jSONArray5 = jSONArray3;
                                it2 = it;
                                linkedListP2 = linkedList;
                                linkedHashMap3 = linkedHashMap;
                                jSONObject11 = jSONObject;
                                i5 = 1;
                                i6 = 0;
                            }
                            jSONObject3 = jSONObject6;
                            ea3Var = ea3Var4;
                            jSONObject2 = jSONObject3;
                            jSONArray2 = jSONArray8;
                            if (jSONObject2 != null) {
                            }
                            arrayList3 = arrayList2;
                            jSONArray7 = jSONArray4;
                            jSONArray5 = jSONArray3;
                            it2 = it;
                            linkedListP2 = linkedList;
                            linkedHashMap3 = linkedHashMap;
                            jSONObject11 = jSONObject;
                            i5 = 1;
                            i6 = 0;
                        }
                        jSONObject3 = jSONObject4;
                        ea3Var = ea3Var4;
                        jSONObject2 = jSONObject3;
                        jSONArray2 = jSONArray8;
                        if (jSONObject2 != null) {
                        }
                        arrayList3 = arrayList2;
                        jSONArray7 = jSONArray4;
                        jSONArray5 = jSONArray3;
                        it2 = it;
                        linkedListP2 = linkedList;
                        linkedHashMap3 = linkedHashMap;
                        jSONObject11 = jSONObject;
                        i5 = 1;
                        i6 = 0;
                    }
                }
            }
            arrayList = arrayList3;
            ea3Var = ea3Var4;
            jSONObject = jSONObject11;
            jSONObject9 = jSONObject10;
            jSONArray = jSONArray5;
            jSONObject8 = jSONObject9;
            jSONArray2 = jSONArray7;
            jSONObject2 = jSONObject8;
            if (jSONObject2 != null) {
            }
            arrayList3 = arrayList2;
            jSONArray7 = jSONArray4;
            jSONArray5 = jSONArray3;
            it2 = it;
            linkedListP2 = linkedList;
            linkedHashMap3 = linkedHashMap;
            jSONObject11 = jSONObject;
            i5 = 1;
            i6 = 0;
        }
        ArrayList<ha3> arrayList10 = arrayList3;
        JSONObject jSONObject37 = jSONObject11;
        JSONArray jSONArray10 = jSONObject37.getJSONArray("inbounds");
        for (ha3 ha3Var2 : arrayList10) {
            ha3Var2.getClass();
            JSONObject jSONObject38 = new JSONObject(String.format("{\n    \"listen\": \"%s\",\n    \"protocol\": \"socks\",\n    \"port\": %d,\n    \"settings\": {\n        \"udp\": %b,\n        \"ip\": \"%s\"\n    }\n}", Arrays.copyOf(new Object[]{str, Integer.valueOf(ha3Var2.b), Boolean.valueOf(ha3Var2.c), str}, 4)));
            jSONObject38.put("tag", ha3Var2.a);
            jSONArray10.put(jSONObject38);
        }
        this.a.clear();
        HashMap map5 = this.a;
        int iU = fh2.U(f70.Q(10, arrayList10));
        if (iU < 16) {
            iU = 16;
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(iU);
        for (ha3 ha3Var3 : arrayList10) {
            linkedHashMap4.put(ha3Var3.a, Integer.valueOf(ha3Var3.b));
        }
        map5.putAll(linkedHashMap4);
        String absolutePath = new File(ContextUtilsKt.getContext().getNoBackupFilesDir(), "protect_path").getAbsolutePath();
        e = this;
        String string = jSONObject37.toString(0);
        string.getClass();
        absolutePath.getClass();
        String strNativeStart = nativeStart(string, absolutePath, false);
        this.b = strNativeStart == null;
        if (strNativeStart != null) {
            e = null;
        }
        return strNativeStart;
    }

    public final void b() {
        if (this.b) {
            this.b = false;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "XRay", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop xray");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("XRay", "stop xray", null);
            }
            nativeStop();
        }
        if (e == this) {
            e = null;
        }
    }
}
