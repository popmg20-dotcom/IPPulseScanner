package defpackage;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.util.internal.StringUtil;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
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

    public static final om3 a(String str, String str2, ad1 ad1Var, pl1 pl1Var) throws IOException {
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(defpackage.t53 r29, defpackage.a02 r30) throws java.net.UnknownHostException {
        /*
            Method dump skipped, instruction units count: 1810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c63.e(t53, a02):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(java.lang.String r12, android.net.Uri r13, defpackage.ed1 r14, defpackage.cd1 r15, defpackage.ad1 r16, defpackage.ie0 r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof defpackage.y53
            if (r1 == 0) goto L15
            r1 = r0
            y53 r1 = (defpackage.y53) r1
            int r2 = r1.X
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.X = r2
            goto L1a
        L15:
            y53 r1 = new y53
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.A
            int r2 = r1.X
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            defpackage.n12.S(r0)
            goto L4d
        L27:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r12)
            r12 = 0
            return r12
        L2e:
            defpackage.n12.S(r0)
            gm0 r0 = defpackage.qv0.a
            pl0 r0 = defpackage.pl0.z
            a63 r4 = new a63
            r10 = 0
            r11 = 0
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r9 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r1.X = r3
            java.lang.Object r0 = defpackage.ji0.b0(r0, r4, r1)
            mf0 r12 = defpackage.mf0.b
            if (r0 != r12) goto L4d
            return r12
        L4d:
            uk3 r0 = (defpackage.uk3) r0
            java.lang.Object r12 = r0.b
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c63.h(java.lang.String, android.net.Uri, ed1, cd1, ad1, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(java.lang.String r12, java.io.ByteArrayInputStream r13, defpackage.ed1 r14, defpackage.cd1 r15, defpackage.ad1 r16, defpackage.ie0 r17) {
        /*
            r0 = r17
            boolean r1 = r0 instanceof defpackage.b63
            if (r1 == 0) goto L15
            r1 = r0
            b63 r1 = (defpackage.b63) r1
            int r2 = r1.X
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.X = r2
            goto L1a
        L15:
            b63 r1 = new b63
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.A
            int r2 = r1.X
            r3 = 1
            if (r2 == 0) goto L2e
            if (r2 != r3) goto L27
            defpackage.n12.S(r0)
            goto L4d
        L27:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r12)
            r12 = 0
            return r12
        L2e:
            defpackage.n12.S(r0)
            gm0 r0 = defpackage.qv0.a
            pl0 r0 = defpackage.pl0.z
            a63 r4 = new a63
            r10 = 0
            r11 = 1
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r9 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r1.X = r3
            java.lang.Object r0 = defpackage.ji0.b0(r0, r4, r1)
            mf0 r12 = defpackage.mf0.b
            if (r0 != r12) goto L4d
            return r12
        L4d:
            uk3 r0 = (defpackage.uk3) r0
            java.lang.Object r12 = r0.b
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c63.i(java.lang.String, java.io.ByteArrayInputStream, ed1, cd1, ad1, ie0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(defpackage.t53 r40, defpackage.a02 r41, defpackage.cd1 r42) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c63.k(t53, a02, cd1):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.tn3 t(java.lang.String[] r30, defpackage.ed1 r31, defpackage.ad1 r32, java.lang.String r33, int r34, defpackage.pl1 r35) throws java.net.UnknownHostException {
        /*
            Method dump skipped, instruction units count: 3022
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c63.t(java.lang.String[], ed1, ad1, java.lang.String, int, pl1):tn3");
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
