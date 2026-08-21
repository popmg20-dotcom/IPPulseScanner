package defpackage;

import android.net.Uri;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.StringUtil;
import io.sentry.android.core.a1;
import io.sentry.p6;
import j$.util.DesugarCollections;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class c63 {
    public static final HashMap a = new HashMap();

    public static final om3 a(String str, String str2, ad1 ad1Var, pl1 pl1Var) {
        String absolutePath;
        String str3;
        str.getClass();
        ad1Var.getClass();
        File file = new File(new File(ContextUtilsKt.getContext().getFilesDir(), "sft"), ha0.x(r25.K(str), ".sft"));
        int i = 0;
        if (file.exists()) {
            String absolutePath2 = file.getAbsolutePath();
            absolutePath2.getClass();
            File file2 = new File(absolutePath2);
            if (file2.exists() && file2.length() >= 32) {
                try {
                    ByteBuffer byteBufferOrder = ByteBuffer.allocate(32).order(ByteOrder.LITTLE_ENDIAN);
                    FileChannel channel = new FileInputStream(file2).getChannel();
                    try {
                        if (channel.read(byteBufferOrder) < 32) {
                            channel.close();
                        } else {
                            channel.close();
                            byteBufferOrder.flip();
                            if (byteBufferOrder.getInt() == 5523027 && byteBufferOrder.getInt() == 2) {
                                byteBufferOrder.getInt();
                                byteBufferOrder.getInt();
                                byteBufferOrder.getInt();
                                i = byteBufferOrder.getInt();
                            }
                        }
                    } finally {
                    }
                } catch (Exception unused) {
                }
            }
            if (i == 0) {
                file.delete();
            }
        }
        int i2 = i;
        if (i2 > 0) {
            String absolutePath3 = file.getAbsolutePath();
            absolutePath3.getClass();
            return new om3(str, str2, false, false, null, i2, absolutePath3, null, 128);
        }
        if (pl1Var != null) {
            pl1Var.a();
        }
        String strConcat = "DOMAIN-SET fetch START: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileDecoder", strConcat, null);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM = ad1Var.m(str, str);
        int length = strM.length();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sb = new StringBuilder("DOMAIN-SET fetch DONE: ");
        sb.append(length);
        sb.append(" bytes, ");
        sb.append(jCurrentTimeMillis2);
        String strY = fw.y(sb, "ms — ", str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strY);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileDecoder", strY, null);
        }
        if (pl1Var != null) {
            pl1Var.a();
        }
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(strM));
        try {
            List listV = ws3.V(new oe1(new go1(new kb0(new j70(1, bufferedReader)), new ji(23), 1), true, new gj(13, new zg3(), pl1Var)));
            bufferedReader.close();
            int length2 = strM.length();
            int size = listV.size();
            long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
            StringBuilder sbA = fw.A(length2, size, "DOMAIN-SET parse: ", "B → ", " rules, ");
            sbA.append(jCurrentTimeMillis4);
            sbA.append("ms — ");
            sbA.append(str);
            String string = sbA.toString();
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ProfileDecoder", string, null);
            }
            if (listV.size() > 1000) {
                if (pl1Var != null) {
                    pl1Var.a();
                }
                try {
                    long jCurrentTimeMillis5 = System.currentTimeMillis();
                    fx3.a(listV, file);
                    String str4 = "DOMAIN-SET native tree build: " + (System.currentTimeMillis() - jCurrentTimeMillis5) + "ms — " + str;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
                        str3 = str4;
                    } else {
                        str3 = str4;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileDecoder", str3, null);
                    }
                } catch (UnsatisfiedLinkError e) {
                    String strU = fw.u("DOMAIN-SET native tree build unavailable, falling back: ", e.getMessage(), " — ", str);
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileDecoder", strU, null);
                    }
                }
                absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
            } else {
                absolutePath = "";
            }
            return pr1.o(listV, str, str2, false, false, absolutePath, 56);
        } finally {
        }
    }

    public static final ArrayList b(String str, String str2, ed1 ed1Var, ad1 ad1Var, int i, pl1 pl1Var) {
        tn3 tn3VarT;
        str.getClass();
        ed1Var.getClass();
        ad1Var.getClass();
        if (pl1Var != null) {
            pl1Var.a();
        }
        String strConcat = "RULE-SET fetch START: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileDecoder", strConcat, null);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ed1 ed1Var2 = ed1Var;
        String strC = ed1Var2.c(str, str);
        int length = strC.length();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sb = new StringBuilder("RULE-SET fetch DONE: ");
        sb.append(length);
        sb.append(" bytes, ");
        sb.append(jCurrentTimeMillis2);
        String strY = fw.y(sb, "ms — ", str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strY);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileDecoder", strY, null);
        }
        if (pl1Var != null) {
            pl1Var.a();
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : p44.B0(strC)) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                e70.P();
                throw null;
            }
            String str3 = (String) obj;
            if (i2 % 200 == 0 && pl1Var != null) {
                pl1Var.a();
            }
            if (!p44.M0(str3, '#') && !p44.M0(str3, ';') && !w44.j0(str3, "//", false)) {
                List listK0 = p44.K0(str3, new char[]{StringUtil.COMMA}, 6);
                ArrayList arrayList2 = new ArrayList(f70.Q(10, listK0));
                Iterator it = listK0.iterator();
                while (it.hasNext()) {
                    arrayList2.add(p44.U0((String) it.next()).toString());
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[0]);
                if (strArr.length != 0 && (tn3VarT = t(strArr, ed1Var2, ad1Var, str2, i - 1, pl1Var)) != null) {
                    arrayList.add(tn3VarT);
                }
            }
            ed1Var2 = ed1Var;
            i2 = i3;
        }
        return arrayList;
    }

    public static final void c(t53 t53Var) {
        LinkedHashMap linkedHashMap = t53Var.G0;
        String str = t53Var.b;
        LinkedHashMap linkedHashMap2 = t53Var.H0;
        SystemClock.elapsedRealtime();
        t53Var.I0 = new ka3("Global Proxy", t53Var.t(true), (LinkedHashSet) null, (String) null, (LinkedHashMap) null, 0, false, false, false, (LinkedHashSet) null, 2044);
        LinkedHashSet linkedHashSetT = t53Var.t(false);
        SystemClock.elapsedRealtime();
        for (tn3 tn3Var : t53Var.J0) {
            if (!n(tn3Var.S(), linkedHashMap2, linkedHashSetT)) {
                e04.f(ha0.x(tn3Var.S(), " not found"));
                return;
            }
        }
        SystemClock.elapsedRealtime();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            if (((na3) entry.getValue()).f()) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap3.entrySet().iterator();
        while (it.hasNext()) {
            na3 na3Var = (na3) ((Map.Entry) it.next()).getValue();
            String strR = na3Var.r();
            strR.getClass();
            Pattern patternCompile = Pattern.compile(strR);
            patternCompile.getClass();
            LinkedHashSet linkedHashSetW = na3Var.w();
            Set setKeySet = linkedHashMap.keySet();
            setKeySet.getClass();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setKeySet) {
                String str2 = (String) obj;
                str2.getClass();
                if (patternCompile.matcher(str2).find()) {
                    arrayList.add(obj);
                }
            }
            linkedHashSetW.addAll(arrayList);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!((na3) entry2.getValue()).z().isEmpty()) {
                linkedHashMap4.put(entry2.getKey(), entry2.getValue());
            }
        }
        Iterator it2 = linkedHashMap4.values().iterator();
        while (it2.hasNext()) {
            t53Var.D((na3) it2.next());
        }
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            if (((na3) entry3.getValue()).z().isEmpty()) {
                linkedHashMap5.put(entry3.getKey(), entry3.getValue());
            }
        }
        Iterator it3 = linkedHashMap5.values().iterator();
        while (it3.hasNext()) {
            ((na3) it3.next()).Y();
        }
        Iterator it4 = linkedHashMap2.entrySet().iterator();
        while (it4.hasNext()) {
            na3 na3Var2 = (na3) ((Map.Entry) it4.next()).getValue();
            for (String str3 : na3Var2.w()) {
                if (!n(str3, linkedHashMap2, linkedHashSetT)) {
                    s53.h(str, ": ", str3, " not found");
                    return;
                }
            }
            if (!(na3Var2 instanceof ka3) && !(na3Var2 instanceof ja3) && !(na3Var2 instanceof la3)) {
                if (na3Var2 instanceof ma3) {
                    ma3 ma3Var = (ma3) na3Var2;
                    String str4 = ma3Var.Z;
                    if (str4 != null && !w44.j0(str4, "http://", false)) {
                        s53.h(str, ": proxyGroup ", ma3Var.b, " only support http url test");
                        return;
                    }
                } else {
                    if (!(na3Var2 instanceof ia3)) {
                        g.d();
                        return;
                    }
                    ia3 ia3Var = (ia3) na3Var2;
                    String str5 = ia3Var.Z;
                    if (str5 != null && !w44.j0(str5, "http://", false)) {
                        s53.h(str, ": proxyGroup ", ia3Var.b, " only support http url test");
                        return;
                    }
                }
            }
        }
        SystemClock.elapsedRealtime();
        Set setKeySet2 = linkedHashMap.keySet();
        setKeySet2.getClass();
        Set setKeySet3 = linkedHashMap2.keySet();
        setKeySet3.getClass();
        Collection<ea3> collectionValues = linkedHashMap.values();
        collectionValues.getClass();
        for (ea3 ea3Var : collectionValues) {
            String strQ = ea3Var.q();
            if (strQ != null && !setKeySet2.contains(strQ) && !setKeySet3.contains(strQ)) {
                throw new IllegalArgumentException((str + ": underlying-proxy '" + strQ + "' not found in proxies or groups (referenced by " + ea3Var.getName() + ")").toString());
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Set<String> setKeySet4 = linkedHashMap.keySet();
        setKeySet4.getClass();
        for (String str6 : setKeySet4) {
            str6.getClass();
            if (v(linkedHashSet2, linkedHashSet, t53Var, str6)) {
                s53.h(str, ": circular underlying-proxy detected starting from proxy '", str6, "'");
                return;
            }
        }
    }

    public static final boolean d(String str, String... strArr) {
        str.getClass();
        String strQ0 = p44.Q0(str, '=');
        if (strQ0.equals(str)) {
            return false;
        }
        return qe.a0(p44.U0(strQ0).toString(), strArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x066e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void e(t53 t53Var, a02 a02Var) throws UnknownHostException {
        InetSocketAddress inetSocketAddress;
        InetSocketAddress inetSocketAddress2;
        Integer numM0;
        Collection<b02> collectionB = a02Var.b();
        collectionB.getClass();
        for (b02 b02Var : collectionB) {
            String str = b02Var.a;
            int i = 6;
            int i2 = 1;
            switch (str.hashCode()) {
                case -1777255744:
                    if (str.equals("internet-test-url")) {
                        String strA = b02Var.a();
                        strA.getClass();
                        if (!strA.startsWith("http://")) {
                            e04.f(ha0.n("internet-test-url must be http, not https: ", b02Var.a()));
                            return;
                        } else {
                            String string = new URL(b02Var.a()).toString();
                            string.getClass();
                            t53Var.z0 = string;
                        }
                    } else {
                        continue;
                    }
                    break;
                case -1487043499:
                    if (str.equals("udp-policy-not-supported-behaviour")) {
                        String strA2 = b02Var.a();
                        int iHashCode = strA2.hashCode();
                        if (iHashCode != -1881380961) {
                            if (iHashCode == 2016710633 && strA2.equals("DIRECT")) {
                                tu0 tu0Var = lb3.a;
                                tu0Var.getClass();
                                t53Var.B0 = tu0Var;
                            } else {
                                String strN = ha0.n("unknown udp-policy-not-supported-behaviour value: ", b02Var.a());
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                                }
                                if (!((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    a1.o("ProfileDecoder", strN, null);
                                }
                            }
                        } else if (strA2.equals("REJECT")) {
                            ii3 ii3Var = lb3.b;
                            ii3Var.getClass();
                            t53Var.B0 = ii3Var;
                        } else {
                            String strN2 = ha0.n("unknown udp-policy-not-supported-behaviour value: ", b02Var.a());
                            if (fy4.b) {
                            }
                            if (!((Boolean) le2.a.a()).booleanValue()) {
                            }
                        }
                    } else {
                        continue;
                    }
                    break;
                case -956463624:
                    if (str.equals("always-real-ip")) {
                        ArrayList arrayList = t53Var.E0;
                        String[] strArr = b02Var.b;
                        strArr.getClass();
                        d70.V(arrayList, strArr);
                    } else {
                        continue;
                    }
                    break;
                case -925407072:
                    if (str.equals("skip-proxy")) {
                        String[] strArr2 = b02Var.b;
                        strArr2.getClass();
                        int length = strArr2.length;
                        int i3 = 0;
                        while (i3 < length) {
                            String str2 = strArr2[i3];
                            str2.getClass();
                            if (p44.p0(str2, '/')) {
                                List listL0 = p44.L0(str2, new String[]{"/"}, i);
                                if (listL0.size() == 2) {
                                    Pattern pattern = xz1.b;
                                    if (xz1.a((String) listL0.get(0))) {
                                        InetAddress byName = InetAddress.getByName((String) listL0.get(0));
                                        byName.getClass();
                                        um3 um3Var = new um3(new fm3(byName, Integer.parseInt((String) listL0.get(1))), "DIRECT");
                                        if (um3Var.a()) {
                                            t53Var.C0.add(um3Var);
                                        } else {
                                            String[] strArr3 = b02Var.b;
                                            strArr3.getClass();
                                            String strConcat = "Illegal skip-proxy: ".concat(qe.o0(strArr3, null, 63));
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                Log.d("ProfileDecoder", strConcat, null);
                                            }
                                        }
                                    }
                                }
                            } else if (xz1.a(str2)) {
                                InetAddress byName2 = InetAddress.getByName(str2);
                                ArrayList arrayList2 = t53Var.C0;
                                byName2.getClass();
                                arrayList2.add(new um3(new fm3(byName2, byName2.getAddress().length * 8), "DIRECT"));
                            } else if (str2.equals("localhost")) {
                                ArrayList arrayList3 = t53Var.C0;
                                InetAddress byName3 = InetAddress.getByName("127.0.0.1");
                                byName3.getClass();
                                arrayList3.add(new um3(new fm3(byName3, 32), "DIRECT"));
                                ArrayList arrayList4 = t53Var.C0;
                                InetAddress byName4 = InetAddress.getByName("::1");
                                byName4.getClass();
                                arrayList4.add(new um3(new fm3(byName4, 128), "DIRECT"));
                            } else if (p44.p0(str2, '*')) {
                                t53Var.C0.add(new qm3(str2, "DIRECT", false, false));
                            } else if (kx0.c().e(str2)) {
                                t53Var.C0.add(new mm3(str2, "DIRECT", false, false));
                            } else {
                                String strConcat2 = "unsupported skip-proxy value: ".concat(str2);
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat2);
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    a1.o("ProfileDecoder", strConcat2, null);
                                }
                            }
                            i3++;
                            i = 6;
                        }
                    } else {
                        continue;
                    }
                    break;
                case -629717332:
                    if (str.equals("http-listen")) {
                    }
                    break;
                case -491150233:
                    if (str.equals("dns-server")) {
                        String[] strArr4 = b02Var.b;
                        strArr4.getClass();
                        int length2 = strArr4.length;
                        int i4 = 0;
                        while (i4 < length2) {
                            String str3 = strArr4[i4];
                            str3.getClass();
                            int iIntValue = 53;
                            if (str3.equals("system")) {
                                inetSocketAddress2 = InetSocketAddress.createUnresolved("system", 53);
                            } else if (w44.j0(str3, "[", false)) {
                                int iV0 = p44.v0(str3, "]", 0, false, 6);
                                if (iV0 == -1) {
                                    String strConcat3 = "unrecognized dns: ".concat(str3);
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, 4, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat3);
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        a1.e("ProfileDecoder", strConcat3, null);
                                    }
                                } else {
                                    String strSubstring = str3.substring(i2, iV0);
                                    int i5 = iV0 + 2;
                                    if (i5 <= str3.length() && str3.charAt(iV0 + 1) == ':' && (numM0 = w44.m0(str3.substring(i5))) != null) {
                                        iIntValue = numM0.intValue();
                                    }
                                    if (xz1.a(strSubstring)) {
                                        inetSocketAddress2 = new InetSocketAddress(strSubstring, iIntValue);
                                    } else {
                                        String strConcat4 = "unrecognized dns: ".concat(str3);
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, 4, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat4);
                                        }
                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                            a1.e("ProfileDecoder", strConcat4, null);
                                        }
                                    }
                                }
                                inetSocketAddress2 = null;
                            } else {
                                int iA0 = p44.A0(str3, ":", 6);
                                if (iA0 != -1) {
                                    if (iA0 == p44.v0(str3, ":", 0, false, 6)) {
                                        String strSubstring2 = str3.substring(0, iA0);
                                        Integer numM02 = w44.m0(str3.substring(iA0 + 1));
                                        if (numM02 == null || !xz1.b(strSubstring2)) {
                                            String strConcat5 = "unrecognized dns: ".concat(str3);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 4, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat5);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.e("ProfileDecoder", strConcat5, null);
                                            }
                                        } else {
                                            inetSocketAddress2 = new InetSocketAddress(strSubstring2, numM02.intValue());
                                        }
                                    } else if (xz1.c(str3)) {
                                        inetSocketAddress = new InetSocketAddress(str3, 53);
                                        inetSocketAddress2 = inetSocketAddress;
                                    } else {
                                        String strConcat6 = "unrecognized dns: ".concat(str3);
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, 4, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat6);
                                        }
                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                            a1.e("ProfileDecoder", strConcat6, null);
                                        }
                                    }
                                    inetSocketAddress2 = null;
                                } else if (xz1.a(str3)) {
                                    inetSocketAddress = new InetSocketAddress(str3, 53);
                                    inetSocketAddress2 = inetSocketAddress;
                                } else {
                                    String strConcat7 = "unrecognized dns: ".concat(str3);
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, 4, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat7);
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        a1.e("ProfileDecoder", strConcat7, null);
                                    }
                                    inetSocketAddress2 = null;
                                }
                            }
                            if (inetSocketAddress2 != null) {
                                t53Var.D0.add(inetSocketAddress2);
                            }
                            i4++;
                            i2 = 1;
                        }
                    } else {
                        continue;
                    }
                    break;
                case 3239399:
                    if (str.equals("ipv6")) {
                        t53Var.A = ji0.W(b02Var.a());
                    } else {
                        continue;
                    }
                    break;
                case 5318099:
                    if (str.equals("doh-server")) {
                        ArrayList arrayList5 = t53Var.Z;
                        String[] strArr5 = b02Var.b;
                        strArr5.getClass();
                        d70.V(arrayList5, strArr5);
                    } else {
                        continue;
                    }
                    break;
                case 452838182:
                    if (str.equals("test-timeout")) {
                        try {
                            String strA3 = b02Var.a();
                            strA3.getClass();
                            t53Var.A0 = Integer.parseInt(strA3);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            String strN3 = ha0.n("unknown test-timeout value: ", b02Var.a());
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN3);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                a1.o("ProfileDecoder", strN3, null);
                            }
                        }
                    } else {
                        continue;
                    }
                    break;
                case 1361291406:
                    if (str.equals("socks5-listen")) {
                    }
                    break;
                case 1793948211:
                    if (str.equals("proxy-test-url")) {
                        String strA4 = b02Var.a();
                        strA4.getClass();
                        if (!strA4.startsWith("http://")) {
                            e04.f(ha0.n("proxy-test-url must be http, not https: ", b02Var.a()));
                            return;
                        } else {
                            String string2 = new URL(b02Var.a()).toString();
                            string2.getClass();
                            t53Var.y0 = string2;
                        }
                    } else {
                        continue;
                    }
                    break;
            }
            String strA5 = b02Var.a();
            strA5.getClass();
            List listL02 = p44.L0(strA5, new String[]{":"}, 6);
            if (listL02.size() != 2) {
                String strN4 = ha0.n("unsupported http-listen value: ", b02Var.a());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN4);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("ProfileDecoder", strN4, null);
                }
            } else {
                Pattern pattern2 = xz1.b;
                if (!xz1.a((String) listL02.get(0))) {
                    String strN5 = ha0.n("unsupported http-listen value: ", b02Var.a());
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN5);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.o("ProfileDecoder", strN5, null);
                    }
                } else if (w44.m0((String) listL02.get(1)) == null) {
                    String strN6 = ha0.n("unsupported http-listen value: ", b02Var.a());
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN6);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.o("ProfileDecoder", strN6, null);
                    }
                } else {
                    int i6 = Integer.parseInt((String) listL02.get(1));
                    if (1025 > i6 || i6 >= 65536) {
                        String strN7 = ha0.n("unsupported http-listen value: ", b02Var.a());
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN7);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.o("ProfileDecoder", strN7, null);
                        }
                    } else if (n12.c(b02Var.a, "http-listen")) {
                        t53Var.X = new InetSocketAddress((String) listL02.get(0), Integer.parseInt((String) listL02.get(1)));
                    } else {
                        t53Var.Y = new InetSocketAddress((String) listL02.get(0), Integer.parseInt((String) listL02.get(1)));
                    }
                }
            }
        }
    }

    public static final void f(ad1 ad1Var, ed1 ed1Var, pl1 pl1Var, a02 a02Var, t53 t53Var) {
        Collection<b02> collectionB = a02Var.b();
        collectionB.getClass();
        for (b02 b02Var : collectionB) {
            try {
                LinkedHashMap linkedHashMap = t53Var.F0;
                String str = b02Var.a;
                str.getClass();
                String[] strArr = b02Var.b;
                e03 e03VarG = ye.g(str, (String[]) Arrays.copyOf(strArr, strArr.length), ad1Var, ed1Var, pl1Var);
                linkedHashMap.put(e03VarG.b, e03VarG.f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static final void g(t53 t53Var, a02 a02Var) {
        Collection<b02> collectionB = a02Var.b();
        collectionB.getClass();
        for (b02 b02Var : collectionB) {
            String str = b02Var.a;
            str.getClass();
            String[] strArr = b02Var.b;
            strArr.getClass();
            String strG0 = null;
            String strI0 = null;
            g03 g03Var = null;
            for (String str2 : strArr) {
                str2.getClass();
                if (d(str2, "title")) {
                    String strS = s(str2, "title");
                    strG0 = strS != null ? p44.G0("\"", p44.F0(strS, "\"")) : null;
                } else if (d(str2, "content")) {
                    String strS2 = s(str2, "content");
                    strI0 = strS2 != null ? w44.i0(p44.G0("\"", p44.F0(strS2, "\"")), "\\n", "\n") : null;
                } else if (d(str2, "style")) {
                    String strS3 = s(str2, "style");
                    g03[] g03VarArrValues = g03.values();
                    int length = g03VarArrValues.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            g03Var = null;
                            break;
                        }
                        g03 g03Var2 = g03VarArrValues[i];
                        if (g03Var2.b.equals(strS3)) {
                            g03Var = g03Var2;
                            break;
                        }
                        i++;
                    }
                }
            }
            if (strG0 == null) {
                String strConcat = "title is null in panel: ".concat(str);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("ProfileDecoder", strConcat, null);
                }
            } else if (strI0 == null) {
                String strConcat2 = "content is null in panel: ".concat(str);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat2);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("ProfileDecoder", strConcat2, null);
                }
            } else {
                t53Var.L0.add(new h03(str, strG0, strI0, g03Var));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object h(String str, Uri uri, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, ie0 ie0Var) {
        y53 y53Var;
        if (ie0Var instanceof y53) {
            y53Var = (y53) ie0Var;
            int i = y53Var.X;
            if ((i & Integer.MIN_VALUE) != 0) {
                y53Var.X = i - Integer.MIN_VALUE;
            } else {
                y53Var = new y53(ie0Var);
            }
        }
        Object objB0 = y53Var.A;
        int i2 = y53Var.X;
        if (i2 == 0) {
            n12.S(objB0);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            a63 a63Var = new a63(str, uri, ed1Var, cd1Var, ad1Var, null, 0);
            y53Var.X = 1;
            objB0 = ji0.b0(pl0Var, a63Var, y53Var);
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object i(String str, ByteArrayInputStream byteArrayInputStream, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, ie0 ie0Var) {
        b63 b63Var;
        if (ie0Var instanceof b63) {
            b63Var = (b63) ie0Var;
            int i = b63Var.X;
            if ((i & Integer.MIN_VALUE) != 0) {
                b63Var.X = i - Integer.MIN_VALUE;
            } else {
                b63Var = new b63(ie0Var);
            }
        }
        Object objB0 = b63Var.A;
        int i2 = b63Var.X;
        if (i2 == 0) {
            n12.S(objB0);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            a63 a63Var = new a63(str, byteArrayInputStream, ed1Var, cd1Var, ad1Var, null, 1);
            b63Var.X = 1;
            objB0 = ji0.b0(pl0Var, a63Var, b63Var);
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

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Serializable j(String str, InputStream inputStream, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, pl1 pl1Var) {
        String str2;
        String str3;
        str.getClass();
        inputStream.getClass();
        ed1Var.getClass();
        cd1Var.getClass();
        ad1Var.getClass();
        try {
            try {
                String strT = l72.T(new BufferedReader(new InputStreamReader(inputStream, y30.a), 8192));
                inputStream.close();
                ExecutorService executorService = jm2.c;
                bd0 bd0Var = new bd0(strT, 3);
                Exception[] excArr = {null};
                oj1 oj1Var = new oj1(13, excArr);
                jm2 jm2Var = new jm2(bd0Var);
                try {
                    yd3 yd3Var = jm2Var.a;
                    if (yd3Var != null) {
                        jm2Var.a(yd3Var.read());
                    }
                } catch (Exception e) {
                    ((Exception[]) oj1Var.f)[0] = e;
                }
                Exception exc = excArr[0];
                if (exc != null) {
                    throw exc;
                }
                t53 t53Var = new t53(str, strT.hashCode());
                t53Var.z = xb5.h((String) d70.e0(p44.B0(strT)));
                Collection<a02> collectionUnmodifiableCollection = DesugarCollections.unmodifiableCollection(jm2Var.b.values());
                collectionUnmodifiableCollection.getClass();
                for (a02 a02Var : collectionUnmodifiableCollection) {
                    String str4 = a02Var.a;
                    switch (str4.hashCode()) {
                        case -2031058419:
                            if (str4.equals("Proxy Group")) {
                                SystemClock.elapsedRealtime();
                                k(t53Var, a02Var, cd1Var);
                            }
                            break;
                        case 2255304:
                            if (str4.equals("Host")) {
                                SystemClock.elapsedRealtime();
                                f(ad1Var, ed1Var, pl1Var, a02Var, t53Var);
                            }
                            break;
                        case 2558748:
                            if (str4.equals("Rule")) {
                                String str5 = str + ": start decode [Rule] section";
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str5);
                                    str2 = str5;
                                } else {
                                    str2 = str5;
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d("ProfileDecoder", str2, null);
                                }
                                SystemClock.elapsedRealtime();
                                m(ad1Var, ed1Var, pl1Var, a02Var, t53Var);
                                String str6 = str + ": done decode [Rule] section";
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                                    str3 = str6;
                                } else {
                                    str3 = str6;
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d("ProfileDecoder", str3, null);
                                }
                            }
                            break;
                        case 76880356:
                            if (str4.equals("Panel")) {
                                SystemClock.elapsedRealtime();
                                g(t53Var, a02Var);
                            }
                            break;
                        case 77388366:
                            if (str4.equals("Proxy")) {
                                SystemClock.elapsedRealtime();
                                Collection collectionUnmodifiableCollection2 = DesugarCollections.unmodifiableCollection(jm2Var.b.values());
                                collectionUnmodifiableCollection2.getClass();
                                for (ea3 ea3Var : l(a02Var, collectionUnmodifiableCollection2)) {
                                    String name = ea3Var.getName();
                                    name.getClass();
                                    t53Var.G0.put(name, ea3Var);
                                }
                            }
                            break;
                        case 1584505032:
                            if (str4.equals("General")) {
                                SystemClock.elapsedRealtime();
                                e(t53Var, a02Var);
                            }
                            break;
                    }
                }
                SystemClock.elapsedRealtime();
                c(t53Var);
                return new e03(t53Var, strT);
            } finally {
            }
        } catch (Throwable th) {
            return new tk3(th);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03b3, code lost:
    
        if (r4.equals("fallback") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03b6, code lost:
    
        r1 = r8;
        r11 = r18;
        r8 = r24;
        r5 = r26;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03c6, code lost:
    
        if (r4.equals("smart") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03cd, code lost:
    
        if (r4.equals("ssid") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03d4, code lost:
    
        if (r4.equals("subnet") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03d7, code lost:
    
        r6 = new java.util.LinkedHashMap();
        r0 = r21.iterator();
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x03e5, code lost:
    
        if (r0.hasNext() == false) goto L292;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03e7, code lost:
    
        r4 = (java.lang.String) r0.next();
        r5 = defpackage.p44.L0(r4, new java.lang.String[]{"="}, 2);
        r10 = new java.util.ArrayList(defpackage.f70.Q(10, r5));
        r5 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0409, code lost:
    
        if (r5.hasNext() == false) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x040b, code lost:
    
        r10.add(defpackage.p44.U0((java.lang.String) r5.next()).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0422, code lost:
    
        if (r10.size() != 2) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x042d, code lost:
    
        if (defpackage.n12.c(r10.get(0), "default") == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x042f, code lost:
    
        r1 = r10.get(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0435, code lost:
    
        r5 = defpackage.d7.o((java.lang.String) r10.get(0), (java.lang.String) r10.get(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x044a, code lost:
    
        if (r5 == null) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x044c, code lost:
    
        r6.put(r5, r10.get(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0454, code lost:
    
        r39 = defpackage.fw.u("Unknown subnet condition in ", r3, ": ", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0460, code lost:
    
        if (defpackage.fy4.b == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0462, code lost:
    
        com.tencent.mars.xlog.Xlog.logWrite2(0, 3, "ProxyGroup", "", "", 0, android.os.Process.myPid(), android.os.Process.myTid(), defpackage.le2.b, r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x048c, code lost:
    
        if (((java.lang.Boolean) defpackage.le2.a.a()).booleanValue() == false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0490, code lost:
    
        if (defpackage.fy4.b != false) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0492, code lost:
    
        io.sentry.android.core.a1.o("ProxyGroup", r39, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x049b, code lost:
    
        if (r1 == null) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x049d, code lost:
    
        r4 = new java.util.LinkedHashSet(defpackage.fh2.U(1));
        defpackage.qe.r0(new java.lang.String[]{r1}, r4);
        r4.addAll(r6.values());
        r4.addAll(r8);
        r8 = r9.b.pattern();
        r8.getClass();
        r0 = new defpackage.e03(r3, new defpackage.la3(r3, r4, (java.lang.String) r1, r6, r26, r8, r7, r24, r25, r14, r18, r13, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x04dc, code lost:
    
        r15 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x04df, code lost:
    
        defpackage.e04.f(defpackage.ha0.o("Subnet group ", r3, " must have a 'default' policy"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x04ea, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0575, code lost:
    
        if (r4.equals("url-test") == false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0579, code lost:
    
        r0 = r21.iterator();
        r10 = 600;
        r13 = r14;
        r14 = r11;
        r11 = 100;
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x058b, code lost:
    
        if (r0.hasNext() == false) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x058d, code lost:
    
        r41 = r0;
        r0 = (java.lang.String) r0.next();
        r17 = r1;
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x05a5, code lost:
    
        if (d(r0, io.netty.handler.codec.rtsp.RtspHeaders.Values.URL) == false) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x05a7, code lost:
    
        r15 = s(r0, io.netty.handler.codec.rtsp.RtspHeaders.Values.URL);
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x05ac, code lost:
    
        r2 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x05b9, code lost:
    
        if (d(r0, "interval") == false) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x05bb, code lost:
    
        r0 = q(r0, "interval", "s");
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x05bf, code lost:
    
        if (r0 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x05c1, code lost:
    
        r10 = r0.intValue();
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x05d0, code lost:
    
        if (d(r0, "tolerance") == false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x05d2, code lost:
    
        r0 = q(r0, "tolerance", "ms");
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x05d8, code lost:
    
        if (r0 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x05da, code lost:
    
        r11 = r0.intValue();
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x05df, code lost:
    
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x05e9, code lost:
    
        if (d(r0, io.netty.handler.codec.rtsp.RtspHeaders.Values.TIMEOUT) == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x05eb, code lost:
    
        r2 = q(r0, io.netty.handler.codec.rtsp.RtspHeaders.Values.TIMEOUT, "s");
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x05f0, code lost:
    
        r0 = r41;
        r1 = r17;
        r15 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x05f5, code lost:
    
        r17 = r1;
        r18 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x05f9, code lost:
    
        if (r15 == 0) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0602, code lost:
    
        if (defpackage.w44.j0(r15, "http://", false) == false) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0605, code lost:
    
        defpackage.xe.k(defpackage.fw.u("Decode ", r4, " ProxyGroup but url is not http scheme: ", r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0610, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0611, code lost:
    
        r0 = r4.equals("fallback");
        r1 = r9.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0617, code lost:
    
        if (r0 == false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0619, code lost:
    
        r6 = r1.pattern();
        r6.getClass();
        r0 = new defpackage.e03(r3, new defpackage.ia3(r3, r17, r5, r6, r7, r8, r15, r10, r18, r25, r13, r14, r13, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0638, code lost:
    
        r6 = r1.pattern();
        r6.getClass();
        r0 = new defpackage.e03(r3, new defpackage.ma3(r3, r17, r5, r6, r7, r8, r15, r10, r11, r18, r25, r13, r14, r13, false));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x054a  */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object[], java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r0v72 */
    /* JADX WARN: Type inference failed for: r0v73, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v2, types: [e03] */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void k(t53 t53Var, a02 a02Var, cd1 cd1Var) throws Exception {
        Exception exc;
        Object next;
        Integer numQ;
        ?? e03Var;
        boolean z;
        LinkedHashSet linkedHashSet;
        boolean zW;
        boolean zEquals;
        Object ja3Var;
        boolean z2;
        LinkedHashSet linkedHashSet2;
        String str;
        String string;
        char c;
        Object next2;
        Collection collectionB = a02Var.b();
        collectionB.getClass();
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            b02 b02Var = (b02) it.next();
            String str2 = b02Var.a;
            str2.getClass();
            String[] strArr = b02Var.b;
            strArr.getClass();
            cd1Var.getClass();
            String str3 = (String) qe.m0(0, strArr);
            if (!qe.a0(str3, wl3.y0)) {
                e04.f(ha0.o("proxyGroup type ", str3, " is not supported"));
                return;
            }
            if (strArr.length < 2) {
                e04.f(ha0.o("proxyGroup ", str2, " count error"));
                return;
            }
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashSet linkedHashSet4 = new LinkedHashSet();
            String str4 = p6.DEFAULT_PROPAGATION_TARGETS;
            uh3 uh3Var = new uh3(p6.DEFAULT_PROPAGATION_TARGETS);
            LinkedHashSet linkedHashSet5 = new LinkedHashSet();
            List listSubList = qe.s0(strArr).subList(1, strArr.length);
            Iterator it2 = listSubList.iterator();
            while (true) {
                exc = null;
                if (it2.hasNext()) {
                    next = it2.next();
                    if (d((String) next, "policy-regex-filter")) {
                    }
                } else {
                    next = null;
                }
            }
            String str5 = (String) next;
            if (str5 != null) {
                String strS = s(str5, "policy-regex-filter");
                if (strS != null) {
                    str4 = strS;
                }
                uh3Var = new uh3(str4);
            }
            Iterator it3 = listSubList.iterator();
            int iIntValue = 86400;
            boolean zW2 = false;
            boolean zW3 = false;
            boolean zW4 = false;
            while (true) {
                Iterator it4 = it;
                Iterator it5 = it3;
                if (it3.hasNext()) {
                    int i = iIntValue;
                    String str6 = (String) it5.next();
                    List list = listSubList;
                    if (d(str6, "policy-regex-filter") || d(str6, "evaluate-before-use") || d(str6, "icon-url")) {
                        linkedHashSet2 = linkedHashSet3;
                        z2 = zW2;
                    } else {
                        z2 = zW2;
                        if (d(str6, "policy-path")) {
                            String strS2 = s(str6, "policy-path");
                            try {
                                new URL(strS2);
                                strS2.getClass();
                                String strF = cd1Var.f(strS2, strS2);
                                linkedHashSet3.add(strS2);
                                if (!p44.o0(strF, "[Proxy]", false)) {
                                    strF = "[Proxy]\n".concat(strF);
                                }
                                byte[] bytes = strF.getBytes(y30.a);
                                bytes.getClass();
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                                ExecutorService executorService = jm2.c;
                                o73 o73Var = new o73(2, byteArrayInputStream);
                                Exception[] excArr = {exc};
                                oj1 oj1Var = new oj1(13, excArr);
                                jm2 jm2Var = new jm2(o73Var);
                                try {
                                    yd3 yd3Var = jm2Var.a;
                                    if (yd3Var != null) {
                                        jm2Var.a(yd3Var.read());
                                    }
                                    c = 0;
                                } catch (Exception e) {
                                    c = 0;
                                    ((Exception[]) oj1Var.f)[0] = e;
                                }
                                Exception exc2 = excArr[c];
                                if (exc2 != null) {
                                    throw exc2;
                                }
                                LinkedHashSet linkedHashSet6 = new LinkedHashSet();
                                Collection collectionUnmodifiableCollection = DesugarCollections.unmodifiableCollection(jm2Var.b.values());
                                collectionUnmodifiableCollection.getClass();
                                Iterator it6 = collectionUnmodifiableCollection.iterator();
                                while (true) {
                                    if (it6.hasNext()) {
                                        next2 = it6.next();
                                        if (n12.c(((a02) next2).a, "Proxy")) {
                                        }
                                    } else {
                                        next2 = exc;
                                    }
                                }
                                a02 a02Var2 = (a02) next2;
                                if (a02Var2 != null) {
                                    Collection collectionUnmodifiableCollection2 = DesugarCollections.unmodifiableCollection(jm2Var.b.values());
                                    collectionUnmodifiableCollection2.getClass();
                                    ArrayList arrayListL = l(a02Var2, collectionUnmodifiableCollection2);
                                    ArrayList<ea3> arrayList = new ArrayList();
                                    for (Object obj : arrayListL) {
                                        String name = ((ea3) obj).getName();
                                        name.getClass();
                                        if (uh3Var.b.matcher(name).find()) {
                                            arrayList.add(obj);
                                        }
                                    }
                                    for (ea3 ea3Var : arrayList) {
                                        linkedHashMap.put(ea3Var.getName(), ea3Var);
                                        linkedHashSet6.add(ea3Var.getName());
                                    }
                                }
                                linkedHashSet4.addAll(linkedHashSet6);
                                linkedHashSet2 = linkedHashSet3;
                            } catch (MalformedURLException e2) {
                                e2.printStackTrace();
                                st4.l(fw.u("invalid policy-path url (", strS2, ") in ", str2), e2);
                                return;
                            }
                        } else {
                            linkedHashSet2 = linkedHashSet3;
                            if (d(str6, "no-alert")) {
                                zW2 = ji0.W(s(str6, "no-alert"));
                                iIntValue = i;
                                listSubList = list;
                                it = it4;
                                it3 = it5;
                                linkedHashSet3 = linkedHashSet2;
                                exc = null;
                            } else if (d(str6, "hidden")) {
                                zW3 = ji0.W(s(str6, "hidden"));
                            } else if (d(str6, "update-interval")) {
                                Integer numQ2 = q(str6, "update-interval", "s");
                                if (numQ2 != null) {
                                    iIntValue = numQ2.intValue();
                                }
                                zW2 = z2;
                                listSubList = list;
                                it = it4;
                                it3 = it5;
                                linkedHashSet3 = linkedHashSet2;
                                exc = null;
                            } else if (d(str6, "include-all-proxies")) {
                                zW4 = ji0.W(s(str6, "include-all-proxies"));
                            } else if (d(str6, "include-other-group")) {
                                String strS3 = s(str6, "include-other-group");
                                ?? string2 = strS3 != null ? p44.U0(p44.F0(p44.G0("\"", strS3), "\"")).toString() : exc;
                                for (String str7 : string2 != 0 ? p44.K0(string2, new char[]{StringUtil.COMMA}, 6) : g41.b) {
                                    if (!p44.x0(str7)) {
                                        linkedHashSet5.add(p44.U0(str7).toString());
                                    }
                                }
                            } else if ((!qe.a0(str3, new String[]{"subnet", "ssid"}) || (str = (String) d70.e0(p44.L0(str6, new String[]{"="}, 2))) == null || (string = p44.U0(str).toString()) == null || (!string.equals("default") && d7.o(string, "") == null)) && !d(str6, "policy-regex-filter", RtspHeaders.Values.URL, "interval", "tolerance", RtspHeaders.Values.TIMEOUT, "persistent")) {
                                if (str6.length() <= 0) {
                                    e04.f("Empty proxy name in group ".concat(str2));
                                    return;
                                }
                                if (w44.j0(str6, "DEVICE:", false)) {
                                    String strConcat = "Unsupported ponte proxy will be ignored: ".concat(str6);
                                    if (fy4.b) {
                                        Xlog.logWrite2(0L, 3, "ProxyGroup", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                                    }
                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                        a1.o("ProxyGroup", strConcat, exc);
                                    }
                                } else {
                                    linkedHashSet4.add(str6);
                                }
                            }
                        }
                    }
                    iIntValue = i;
                    zW2 = z2;
                    listSubList = list;
                    it = it4;
                    it3 = it5;
                    linkedHashSet3 = linkedHashSet2;
                    exc = null;
                } else {
                    LinkedHashSet linkedHashSet7 = linkedHashSet3;
                    int i2 = iIntValue;
                    List<String> list2 = listSubList;
                    boolean z3 = zW2;
                    if (str3 != null) {
                        switch (str3.hashCode()) {
                            case -1016353232:
                                LinkedHashSet linkedHashSet8 = linkedHashSet4;
                                boolean z4 = zW4;
                                int i3 = i2;
                                LinkedHashSet linkedHashSet9 = linkedHashSet7;
                                numQ = null;
                                break;
                            case -906021636:
                                z = zW4;
                                linkedHashSet = linkedHashSet7;
                                if (!str3.equals("select")) {
                                    numQ = null;
                                    e03Var = numQ;
                                }
                                if (str3.equals("load-balance")) {
                                    zW = false;
                                } else {
                                    zW = false;
                                    for (String str8 : list2) {
                                        if (d(str8, "persistent")) {
                                            zW = ji0.W(s(str8, "persistent"));
                                        }
                                    }
                                }
                                zEquals = str3.equals("select");
                                Pattern pattern = uh3Var.b;
                                if (zEquals) {
                                    String strPattern = pattern.pattern();
                                    strPattern.getClass();
                                    ja3Var = new ja3(str2, linkedHashSet4, linkedHashSet, strPattern, linkedHashMap, i2, z3, zW3, zW, z, linkedHashSet5, false);
                                } else {
                                    String strPattern2 = pattern.pattern();
                                    strPattern2.getClass();
                                    ja3Var = new ka3(str2, linkedHashSet4, linkedHashSet, strPattern2, linkedHashMap, i2, z3, zW3, z, linkedHashSet5, 1024);
                                }
                                e03Var = new e03(str2, ja3Var);
                                break;
                            case -891534499:
                                break;
                            case 3539835:
                                break;
                            case 109549001:
                                break;
                            case 761243362:
                                break;
                            case 1997000949:
                                if (str3.equals("load-balance")) {
                                    z = zW4;
                                    linkedHashSet = linkedHashSet7;
                                    if (str3.equals("load-balance")) {
                                    }
                                    zEquals = str3.equals("select");
                                    Pattern pattern2 = uh3Var.b;
                                    if (zEquals) {
                                    }
                                    e03Var = new e03(str2, ja3Var);
                                }
                                numQ = null;
                                e03Var = numQ;
                                break;
                            default:
                                numQ = null;
                                e03Var = numQ;
                                break;
                        }
                    }
                    if (e03Var != 0) {
                        t53Var.H0.put(e03Var.b, e03Var.f);
                    }
                    it = it4;
                }
            }
        }
    }

    public static final ArrayList l(a02 a02Var, Collection collection) {
        Collection<b02> collectionB = a02Var.b();
        collectionB.getClass();
        ArrayList arrayList = new ArrayList();
        for (b02 b02Var : collectionB) {
            String str = b02Var.a;
            str.getClass();
            String[] strArr = b02Var.b;
            strArr.getClass();
            arrayList.add(ok0.a(str, strArr, collection));
        }
        return arrayList;
    }

    public static final void m(ad1 ad1Var, ed1 ed1Var, pl1 pl1Var, a02 a02Var, t53 t53Var) throws UnknownHostException {
        Object next;
        Collection collectionB = a02Var.b();
        collectionB.getClass();
        ArrayList arrayList = t53Var.J0;
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            String[] strArr = ((b02) it.next()).b;
            strArr.getClass();
            ad1 ad1Var2 = ad1Var;
            ed1 ed1Var2 = ed1Var;
            pl1 pl1Var2 = pl1Var;
            tn3 tn3VarT = t(strArr, ed1Var2, ad1Var2, null, 16, pl1Var2);
            if (tn3VarT != null) {
                arrayList.add(tn3VarT);
            }
            ed1Var = ed1Var2;
            ad1Var = ad1Var2;
            pl1Var = pl1Var2;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (((tn3) next) instanceof tm3) {
                    break;
                }
            }
        }
        t53Var.K0 = (tm3) next;
    }

    public static final boolean n(String str, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet) {
        return o(str, linkedHashMap, linkedHashSet) || o(p44.H0(str, "\""), linkedHashMap, linkedHashSet) || o(p44.H0(str, "'"), linkedHashMap, linkedHashSet);
    }

    public static final boolean o(String str, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet) {
        return n12.c(str, "direct") || n12.c(str, "DIRECT") || n12.c(str, "reject") || n12.c(str, "REJECT") || n12.c(str, "reject-tinygif") || n12.c(str, "REJECT-TINYGIF") || n12.c(str, "reject-drop") || n12.c(str, "REJECT-DROP") || n12.c(str, "reject-no-drop") || n12.c(str, "REJECT-NO-DROP") || linkedHashMap.containsKey(str) || linkedHashSet.contains(str);
    }

    public static final boolean p(String str, String str2) {
        return ji0.W(s(str, str2));
    }

    public static final Integer q(String str, String str2, String str3) {
        String strS = s(str, str2);
        if (strS != null) {
            return Integer.valueOf(Integer.parseInt(p44.G0(str3, strS)));
        }
        return null;
    }

    public static final String s(String str, String str2) {
        if (d(str, str2)) {
            return u(p44.U0(p44.N0(str, '=')).toString());
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x05cb, code lost:
    
        if (r3.equals("PROTOCOL") == false) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0609, code lost:
    
        if (r3.equals("DOMAIN-KEYWORD") == false) goto L573;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x06ca, code lost:
    
        if (r3.equals("IP-CIDR") == false) goto L573;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06c0  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0965  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0968  */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r4v2, types: [tn3] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final tn3 t(String[] strArr, ed1 ed1Var, ad1 ad1Var, String str, int i, pl1 pl1Var) throws UnknownHostException {
        gn3 gn3Var;
        Parcelable parcelable;
        Object obj;
        Object obj2;
        int i2;
        List listK0;
        Parcelable kn3Var;
        Parcelable ln3Var;
        int i3;
        boolean z;
        boolean z2;
        Parcelable parcelableA;
        Parcelable in3Var;
        char c;
        Parcelable gn3Var2;
        en3 en3Var;
        Parcelable parcelableN;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str2 = (String) qe.m0(0, strArr);
        if (str2 != null) {
            int i4 = 1;
            switch (str2.hashCode()) {
                case -1840977456:
                    obj = "SRC-IP";
                    obj2 = "IN-PORT";
                    i2 = 3;
                    if (str2.equals(obj)) {
                        if (strArr.length >= (str != null ? 2 : i2)) {
                            String str3 = strArr[0];
                            switch (str3.hashCode()) {
                                case -1840977456:
                                    if (str3.equals(obj)) {
                                        String str4 = strArr[1];
                                        if (xz1.a(str4)) {
                                            gn3Var2 = new gn3(str4, str == null ? strArr[2] : str);
                                            gn3Var = null;
                                        } else {
                                            String strConcat = "Illegal SRC-IP rule: ".concat(qe.o0(strArr, null, 63));
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                                            }
                                            if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                                gn3Var = null;
                                            } else {
                                                gn3Var = null;
                                                Log.d("ProfileDecoder", strConcat, null);
                                            }
                                            gn3Var2 = gn3Var;
                                        }
                                        parcelable = gn3Var2;
                                    }
                                    in3Var = null;
                                    gn3Var = null;
                                    parcelable = in3Var;
                                    break;
                                case -1654613975:
                                    if (str3.equals(obj2)) {
                                        Integer numM0 = w44.m0(strArr[1]);
                                        if (numM0 == null || numM0.intValue() <= 0 || numM0.intValue() > 65535) {
                                            String strConcat2 = "Illegal IN-PORT rule: ".concat(qe.o0(strArr, null, 63));
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat2);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                Log.d("ProfileDecoder", strConcat2, null);
                                            }
                                            ln3Var = null;
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        } else {
                                            ln3Var = new dn3(numM0.intValue(), str == null ? strArr[2] : str);
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        }
                                    }
                                    in3Var = null;
                                    gn3Var = null;
                                    parcelable = in3Var;
                                    break;
                                case -206537064:
                                    if (str3.equals("PROTOCOL")) {
                                        en3[] en3VarArrValues = en3.values();
                                        int length = en3VarArrValues.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 < length) {
                                                en3Var = en3VarArrValues[i5];
                                                if (!en3Var.b.equals(strArr[1])) {
                                                    i5++;
                                                }
                                            } else {
                                                en3Var = null;
                                            }
                                        }
                                        if (en3Var != null) {
                                            in3Var = new fn3(en3Var, str == null ? strArr[2] : str);
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        } else {
                                            String strConcat3 = "Illegal PROTOCOL rule: ".concat(qe.o0(strArr, null, 63));
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat3);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                Log.d("ProfileDecoder", strConcat3, null);
                                            }
                                            in3Var = null;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        }
                                    } else {
                                        in3Var = null;
                                        gn3Var = null;
                                        parcelable = in3Var;
                                    }
                                    break;
                                case 444240076:
                                    if (str3.equals("DEST-PORT")) {
                                        Integer numM02 = w44.m0(strArr[1]);
                                        if (numM02 == null || numM02.intValue() <= 0 || numM02.intValue() > 65535) {
                                            String strConcat4 = "Illegal DEST-PORT rule: ".concat(qe.o0(strArr, null, 63));
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat4);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                Log.d("ProfileDecoder", strConcat4, null);
                                            }
                                            ln3Var = null;
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        } else {
                                            ln3Var = new cn3(numM02.intValue(), str == null ? strArr[2] : str);
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        }
                                    }
                                    in3Var = null;
                                    gn3Var = null;
                                    parcelable = in3Var;
                                    break;
                            }
                        }
                    }
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
                case -1838205091:
                    if (str2.equals("SUBNET")) {
                        if (strArr.length < (str != null ? 2 : 3)) {
                            ln3Var = null;
                            in3Var = ln3Var;
                            gn3Var = null;
                            parcelable = in3Var;
                        } else {
                            if (!w44.j0(strArr[1], "SSID:", false)) {
                                if (!w44.j0(strArr[1], "BSSID:", false)) {
                                    if (!w44.j0(strArr[1], "ROUTER:", false)) {
                                        if (w44.j0(strArr[1], "TYPE:", false)) {
                                            try {
                                                ln3Var = new pn3(on3.valueOf(p44.F0(strArr[1], "TYPE:")), str == null ? strArr[2] : str);
                                            } catch (IllegalArgumentException unused) {
                                                String strN = ha0.n("Illegal SUBNET TYPE value: ", strArr[1]);
                                                if (fy4.b) {
                                                    Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                                                }
                                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                    Log.d("ProfileDecoder", strN, null);
                                                }
                                                ln3Var = null;
                                            }
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        } else {
                                            if (w44.j0(strArr[1], "MCCMNC:", false)) {
                                                try {
                                                    listK0 = p44.K0(p44.F0(strArr[1], "MCCMNC:"), new char[]{'-'}, 6);
                                                } catch (IllegalArgumentException e) {
                                                    e.printStackTrace();
                                                    ln3Var = null;
                                                }
                                                if (listK0.size() != 2) {
                                                    throw new IllegalArgumentException(("size not correct: " + listK0.size()).toString());
                                                }
                                                ln3Var = new ln3(Integer.parseInt((String) listK0.get(0)), Integer.parseInt((String) listK0.get(1)), str == null ? strArr[2] : str);
                                                in3Var = ln3Var;
                                                gn3Var = null;
                                                parcelable = in3Var;
                                            } else {
                                                String strConcat5 = "Illegal SUBNET rule: ".concat(qe.o0(strArr, null, 63));
                                                if (fy4.b) {
                                                    Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat5);
                                                }
                                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                    Log.d("ProfileDecoder", strConcat5, null);
                                                }
                                            }
                                            ln3Var = null;
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        }
                                        break;
                                    } else {
                                        String strF0 = p44.F0(strArr[1], "ROUTER:");
                                        if (xz1.a(strF0)) {
                                            InetAddress byName = InetAddress.getByName(strF0);
                                            byName.getClass();
                                            ln3Var = new mn3(byName, str == null ? strArr[2] : str);
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        } else {
                                            String strN2 = ha0.n("Illegal SUBNET ROUTER value: ", strArr[1]);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN2);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                Log.d("ProfileDecoder", strN2, null);
                                            }
                                            ln3Var = null;
                                            in3Var = ln3Var;
                                            gn3Var = null;
                                            parcelable = in3Var;
                                        }
                                    }
                                } else {
                                    kn3Var = new kn3(p44.F0(strArr[1], "BSSID:"), str == null ? strArr[2] : str);
                                }
                            } else {
                                kn3Var = new nn3(p44.F0(strArr[1], "SSID:"), str == null ? strArr[2] : str);
                            }
                            ln3Var = kn3Var;
                            in3Var = ln3Var;
                            gn3Var = null;
                            parcelable = in3Var;
                        }
                    }
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
                case -1654613975:
                    obj2 = "IN-PORT";
                    i2 = 3;
                    if (str2.equals(obj2)) {
                        obj = "SRC-IP";
                        if (strArr.length >= (str != null ? 2 : i2)) {
                        }
                    }
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
                case -1597749158:
                    i3 = 3;
                    break;
                case -898018880:
                    break;
                case -759006279:
                    if (str2.equals("DOMAIN-SET")) {
                        String str5 = (String) qe.m0(1, strArr);
                        String str6 = (String) qe.m0(2, strArr);
                        parcelableA = (str6 == null || !(str5 != null && (w44.j0(str5, "https://", false) || w44.j0(str5, "http://", false)))) ? null : a(str5, str6, ad1Var, pl1Var);
                        in3Var = parcelableA;
                        gn3Var = null;
                        parcelable = in3Var;
                    }
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
                case -206537064:
                    break;
                case -1113271:
                    if (str2.equals("PROCESS-NAME")) {
                        if (strArr.length >= (str != null ? 2 : 3)) {
                            if (strArr.length > 3) {
                                z2 = false;
                                boolean z7 = false;
                                for (String str7 : qe.q0(strArr, gb4.d0(3, strArr.length))) {
                                    if (n12.c(str7, "force-remote-dns")) {
                                        z7 = true;
                                    } else if (n12.c(str7, "enhanced-mode")) {
                                        z2 = true;
                                    }
                                }
                                z = z7;
                            } else {
                                z = false;
                                z2 = false;
                            }
                            in3Var = new in3(strArr[1], str == null ? strArr[2] : str, z, z2);
                        }
                        gn3Var = null;
                        parcelable = in3Var;
                    }
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
                case 2531:
                    if (!str2.equals("OR")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    String str8 = strArr[0];
                    if (i <= 0) {
                        String string = Arrays.toString(strArr);
                        string.getClass();
                        String str9 = "Logical rule recursion limit reached: " + str8 + ", " + string;
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str9);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.o("ProfileDecoder", str9, null);
                            parcelableA = null;
                        }
                        in3Var = parcelableA;
                        gn3Var = null;
                        parcelable = in3Var;
                    } else {
                        String strO0 = qe.o0(strArr, null, 62);
                        int iV0 = p44.v0(strO0, "((", 0, false, 6);
                        int iA0 = p44.A0(strO0, "))", 6);
                        if (iV0 == -1 || iA0 == -1 || iV0 >= iA0) {
                            String strConcat6 = "Malformed logical rule format (missing (()) or indices invalid): ".concat(strO0);
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat6);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                a1.o("ProfileDecoder", strConcat6, null);
                            }
                        } else {
                            String strSubstring = strO0.substring(iV0 + 1, iA0 + 1);
                            String string2 = p44.U0(strO0.substring(iA0 + 2)).toString();
                            String string3 = string2.length() > 0 ? p44.U0((String) d70.d0(p44.L0(p44.F0(string2, ","), new String[]{","}, 6))).toString() : str;
                            if (string3 == null || string3.length() == 0) {
                                String strConcat7 = "Logical rule missing proxy policy: ".concat(strO0);
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat7);
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    a1.o("ProfileDecoder", strConcat7, null);
                                }
                            } else {
                                ArrayList arrayList = new ArrayList();
                                StringBuilder sb = new StringBuilder();
                                int length2 = strSubstring.length();
                                int i6 = 0;
                                int i7 = 0;
                                while (true) {
                                    char c2 = StringUtil.COMMA;
                                    char c3 = ')';
                                    if (i6 >= length2) {
                                        ArrayList arrayList2 = new ArrayList();
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            String string4 = p44.U0(p44.G0(")", p44.F0((String) it.next(), "("))).toString();
                                            ArrayList arrayList3 = new ArrayList();
                                            StringBuilder sb2 = new StringBuilder();
                                            int length3 = string4.length();
                                            int i8 = i4;
                                            int i9 = 0;
                                            int i10 = 0;
                                            while (i9 < length3) {
                                                char cCharAt = string4.charAt(i9);
                                                if (cCharAt == '(') {
                                                    c = StringUtil.COMMA;
                                                    i10++;
                                                    sb2.append(cCharAt);
                                                } else if (cCharAt != c3) {
                                                    c = StringUtil.COMMA;
                                                    if (cCharAt != ',') {
                                                        sb2.append(cCharAt);
                                                    } else if (i10 == 0) {
                                                        arrayList3.add(p44.U0(sb2.toString()).toString());
                                                        sb2 = new StringBuilder();
                                                    } else {
                                                        sb2.append(cCharAt);
                                                    }
                                                } else {
                                                    c = StringUtil.COMMA;
                                                    i10--;
                                                    sb2.append(cCharAt);
                                                }
                                                i9++;
                                                c2 = c;
                                                c3 = ')';
                                            }
                                            char c4 = c2;
                                            if (sb2.length() > 0) {
                                                arrayList3.add(p44.U0(sb2.toString()).toString());
                                            }
                                            tn3 tn3VarT = t((String[]) arrayList3.toArray(new String[0]), ed1Var, ad1Var, string3, i - 1, pl1Var);
                                            String str10 = string3;
                                            if (tn3VarT != null) {
                                                arrayList2.add(tn3VarT);
                                            }
                                            string3 = str10;
                                            c2 = c4;
                                            i4 = i8;
                                            c3 = ')';
                                        }
                                        int i11 = i4;
                                        String str11 = string3;
                                        if (arrayList2.size() != arrayList.size()) {
                                            String strConcat8 = "Logical rule discarded: some sub-rules failed to parse in ".concat(strO0);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat8);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.o("ProfileDecoder", strConcat8, null);
                                            }
                                        } else if (!arrayList2.isEmpty()) {
                                            int iHashCode = str8.hashCode();
                                            if (iHashCode != 2531) {
                                                if (iHashCode != 64951) {
                                                    if (iHashCode == 77491 && str8.equals("NOT")) {
                                                        if (arrayList2.size() == i11) {
                                                            parcelableA = new zm3((tn3) d70.d0(arrayList2), str11);
                                                            in3Var = parcelableA;
                                                            gn3Var = null;
                                                            parcelable = in3Var;
                                                        } else {
                                                            String strConcat9 = "NOT rule requires exactly 1 sub-rule: ".concat(strO0);
                                                            if (fy4.b) {
                                                                Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat9);
                                                            }
                                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                                a1.o("ProfileDecoder", strConcat9, null);
                                                            }
                                                        }
                                                    }
                                                    break;
                                                } else if (str8.equals("AND")) {
                                                    if (arrayList2.size() >= 2) {
                                                        parcelableA = new xm3(str11, arrayList2);
                                                        in3Var = parcelableA;
                                                        gn3Var = null;
                                                        parcelable = in3Var;
                                                    } else {
                                                        String strConcat10 = "AND rule requires at least 2 sub-rules: ".concat(strO0);
                                                        if (fy4.b) {
                                                            Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat10);
                                                        }
                                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                            a1.o("ProfileDecoder", strConcat10, null);
                                                        }
                                                    }
                                                    break;
                                                }
                                            } else {
                                                if (str8.equals("OR")) {
                                                    if (arrayList2.size() >= 2) {
                                                        parcelableA = new an3(str11, arrayList2);
                                                        in3Var = parcelableA;
                                                        gn3Var = null;
                                                        parcelable = in3Var;
                                                    } else {
                                                        String strConcat11 = "OR rule requires at least 2 sub-rules: ".concat(strO0);
                                                        if (fy4.b) {
                                                            Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat11);
                                                        }
                                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                            a1.o("ProfileDecoder", strConcat11, null);
                                                        }
                                                    }
                                                }
                                                break;
                                            }
                                        } else {
                                            String strConcat12 = "Logical rule discarded: no sub-rules found in ".concat(strO0);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, 3, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat12);
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.o("ProfileDecoder", strConcat12, null);
                                            }
                                        }
                                    } else {
                                        char cCharAt2 = strSubstring.charAt(i6);
                                        if (cCharAt2 == '(') {
                                            i7++;
                                            sb.append(cCharAt2);
                                        } else if (cCharAt2 == ')') {
                                            i7--;
                                            sb.append(cCharAt2);
                                            if (i7 == 0) {
                                                arrayList.add(p44.U0(sb.toString()).toString());
                                                sb = new StringBuilder();
                                            }
                                        } else if (cCharAt2 != ',') {
                                            if (i7 > 0) {
                                                sb.append(cCharAt2);
                                            }
                                        } else if (i7 > 0) {
                                            sb.append(cCharAt2);
                                        }
                                        i6++;
                                    }
                                }
                            }
                        }
                        in3Var = parcelableA;
                        gn3Var = null;
                        parcelable = in3Var;
                    }
                    break;
                case 64951:
                    if (!str2.equals("AND")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    String str82 = strArr[0];
                    if (i <= 0) {
                    }
                    break;
                case 77491:
                    if (!str2.equals("NOT")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    String str822 = strArr[0];
                    if (i <= 0) {
                    }
                    break;
                case 66898262:
                    if (str2.equals("FINAL")) {
                        parcelableN = strArr.length >= (str != null ? 1 : 2) ? new tm3(str == null ? strArr[1] : str) : null;
                        gn3Var = null;
                        parcelable = parcelableN;
                    } else {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    break;
                case 67703832:
                    if (str2.equals("GEOIP")) {
                        if (strArr.length >= (str != null ? 2 : 3)) {
                            parcelableN = new vm3(strArr[1], str == null ? strArr[2] : str);
                        }
                        gn3Var = null;
                        parcelable = parcelableN;
                    } else {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    break;
                case 444240076:
                    if (!str2.equals("DEST-PORT")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    obj = "SRC-IP";
                    obj2 = "IN-PORT";
                    i2 = 3;
                    if (strArr.length >= (str != null ? 2 : i2)) {
                    }
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
                case 530021571:
                    if (!str2.equals("DOMAIN-WILDCARD")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    if (strArr.length >= (str != null ? 2 : 3)) {
                        if (strArr.length > 3) {
                            z5 = false;
                            z6 = false;
                            for (String str12 : qe.q0(strArr, gb4.d0(3, strArr.length))) {
                                if (n12.c(str12, "force-remote-dns")) {
                                    z5 = true;
                                } else if (n12.c(str12, "enhanced-mode")) {
                                    z6 = true;
                                }
                            }
                        } else {
                            z5 = false;
                            z6 = false;
                        }
                        String str13 = strArr[0];
                        switch (str13.hashCode()) {
                            case -898018880:
                                if (str13.equals("DOMAIN-KEYWORD")) {
                                    in3Var = new nm3(strArr[1], str == null ? strArr[2] : str, z5, z6);
                                    break;
                                }
                                break;
                            case 530021571:
                                if (str13.equals("DOMAIN-WILDCARD")) {
                                    in3Var = new qm3(strArr[1], str == null ? strArr[2] : str, z5, z6);
                                    break;
                                }
                                break;
                            case 1461184634:
                                if (str13.equals("DOMAIN-SUFFIX")) {
                                    in3Var = new pm3(strArr[1], str == null ? strArr[2] : str, z5, z6);
                                    break;
                                }
                                break;
                            case 2022099140:
                                if (str13.equals("DOMAIN")) {
                                    in3Var = new mm3(strArr[1], str == null ? strArr[2] : str, z5, z6);
                                    break;
                                }
                                break;
                        }
                        gn3Var = null;
                        parcelable = in3Var;
                        break;
                    }
                    break;
                case 1461184634:
                    if (!str2.equals("DOMAIN-SUFFIX")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    if (strArr.length >= (str != null ? 2 : 3)) {
                    }
                    break;
                case 1545889265:
                    if (str2.equals("RULE-SET")) {
                        if (str != null) {
                            String string5 = Arrays.toString(strArr);
                            string5.getClass();
                            g.g("Recursive RULE-SET decode ".concat(string5));
                            return null;
                        }
                        String str14 = (String) qe.m0(1, strArr);
                        String str15 = (String) qe.m0(2, strArr);
                        boolean z8 = (str14 == null || str14.equals("SYSTEM") || str14.equals("LAN") || (!w44.j0(str14, "https://", false) && !w44.j0(str14, "http://", false))) ? false : true;
                        if (str15 == null || !z8) {
                            parcelable = null;
                            gn3Var = null;
                        } else {
                            parcelableN = yr2.n(str15, str14, b(str14, str15, ed1Var, ad1Var, i, pl1Var));
                            gn3Var = null;
                            parcelable = parcelableN;
                        }
                    } else {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    break;
                case 1887567459:
                    if (str2.equals("USER-AGENT")) {
                        if (strArr.length >= (str != null ? 2 : 3)) {
                            if (strArr.length > 3) {
                                z4 = false;
                                boolean z9 = false;
                                for (String str16 : qe.q0(strArr, gb4.d0(3, strArr.length))) {
                                    if (n12.c(str16, "force-remote-dns")) {
                                        z9 = true;
                                    } else if (n12.c(str16, "enhanced-mode")) {
                                        z4 = true;
                                    }
                                }
                                z3 = z9;
                            } else {
                                z3 = false;
                                z4 = false;
                            }
                            parcelableN = new rn3(strArr[1], str == null ? strArr[2] : str, z3, z4);
                        }
                        gn3Var = null;
                        parcelable = parcelableN;
                    } else {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    break;
                case 2009383708:
                    if (!str2.equals("IP-CIDR6")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                        break;
                    } else {
                        i3 = 3;
                        if (strArr.length >= (str != null ? 2 : i3)) {
                            List listL0 = p44.L0(strArr[1], new String[]{"/"}, 6);
                            if (listL0.size() == 2) {
                                Pattern pattern = xz1.b;
                                if (xz1.a((String) listL0.get(0))) {
                                    InetAddress byName2 = InetAddress.getByName((String) listL0.get(0));
                                    byName2.getClass();
                                    um3 um3Var = new um3(new fm3(byName2, Integer.parseInt((String) listL0.get(1))), str == null ? strArr[2] : str);
                                    boolean zA = um3Var.a();
                                    ln3Var = um3Var;
                                    if (!zA) {
                                        String strConcat13 = "Illegal CIDR rule: ".concat(qe.o0(strArr, null, 63));
                                        if (fy4.b) {
                                            Xlog.logWrite2(0L, 1, "ProfileDecoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat13);
                                        }
                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                            Log.d("ProfileDecoder", strConcat13, null);
                                        }
                                        ln3Var = null;
                                    }
                                    in3Var = ln3Var;
                                    gn3Var = null;
                                    parcelable = in3Var;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2022099140:
                    if (!str2.equals("DOMAIN")) {
                        gn3Var = null;
                        parcelable = gn3Var;
                    }
                    if (strArr.length >= (str != null ? 2 : 3)) {
                    }
                    break;
                default:
                    gn3Var = null;
                    parcelable = gn3Var;
                    break;
            }
        } else {
            gn3Var = null;
            parcelable = gn3Var;
        }
        if (parcelable == null) {
            return gn3Var;
        }
        ?? r0 = a;
        if (r0.containsKey(parcelable)) {
            return (tn3) r0.get(parcelable);
        }
        r0.put(parcelable, parcelable);
        return parcelable;
    }

    public static final String u(String str) {
        if (str == null) {
            return null;
        }
        boolean z = false;
        if ((w44.j0(str, "'", false) && w44.d0(str, "'", false)) || (w44.j0(str, "\"", false) && w44.d0(str, "\"", false))) {
            z = true;
        }
        return (str.length() < 2 || !z) ? str : w44.i0(w44.i0(str.substring(1, str.length() - 1), "\\\"", "\""), "\\'", "'");
    }

    public static final boolean v(LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, t53 t53Var, String str) {
        LinkedHashMap linkedHashMap = t53Var.G0;
        if (linkedHashSet.contains(str)) {
            return true;
        }
        if (linkedHashSet2.contains(str)) {
            return false;
        }
        linkedHashSet2.add(str);
        linkedHashSet.add(str);
        ea3 ea3Var = (ea3) linkedHashMap.get(str);
        String strQ = ea3Var != null ? ea3Var.q() : null;
        if (strQ != null && linkedHashMap.containsKey(strQ) && v(linkedHashSet, linkedHashSet2, t53Var, strQ)) {
            linkedHashSet.remove(str);
            return true;
        }
        linkedHashSet.remove(str);
        return false;
    }
}
