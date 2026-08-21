package defpackage;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.media.ImageReader;
import android.os.Process;
import android.util.Log;
import android.view.View;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.HttpHeaders;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yr2 {
    public static final float[][] a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] c = {95.047f, 100.0f, 108.883f};
    public static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final String[] e = {"http", "https", "vmess", "trojan", "ss", "anytls"};
    public static final zs2 f = new zs2(7);

    public static final float A(jc1 jc1Var, jc1 jc1Var2) {
        jc1Var.getClass();
        List list = jc1Var.a;
        jc1Var2.getClass();
        List list2 = jc1Var2.a;
        if ((jc1Var instanceof gc1) && (jc1Var2 instanceof gc1) && ((gc1) jc1Var).d != ((gc1) jc1Var2).d) {
            return Float.MAX_VALUE;
        }
        float fA = (((hg0) d70.k0(list)).a() + ((hg0) d70.d0(list)).a[0]) / 2.0f;
        float fB = (((hg0) d70.k0(list)).b() + ((hg0) d70.d0(list)).a[1]) / 2.0f;
        float fA2 = (((hg0) d70.k0(list2)).a() + ((hg0) d70.d0(list2)).a[0]) / 2.0f;
        float f2 = fA - fA2;
        float fB2 = fB - ((((hg0) d70.k0(list2)).b() + ((hg0) d70.d0(list2)).a[1]) / 2.0f);
        return (fB2 * fB2) + (f2 * f2);
    }

    public static long B(ud0 ud0Var, int i, int i2) {
        char c2;
        char[] cArr = ud0Var.b;
        while (i < i2 && ((c2 = cArr[i]) == '\t' || c2 == ' ')) {
            i++;
        }
        if (i != i2) {
            while (i2 > 0) {
                char c3 = cArr[i2 - 1];
                if (c3 != '\t' && c3 != ' ') {
                    break;
                }
                i2--;
            }
        }
        return ez4.M(i, i2);
    }

    public static int C(o0 o0Var) throws qy4 {
        int i = o0Var.f;
        if (i != 3) {
            return i;
        }
        n nVar = o0Var.r;
        if (nVar != null) {
            return nVar.h;
        }
        st4.j("AesExtraDataRecord not present in local header for aes encrypted data");
        return 0;
    }

    public static final long D(long j) {
        float fSqrt = (float) Math.sqrt((I(j) * I(j)) + (H(j) * H(j)));
        if (fSqrt > 0.0f) {
            return t(j, fSqrt);
        }
        xe.k("Can't get the direction of a 0-length vector");
        return 0L;
    }

    public static jr2 E(aj3 aj3Var, List list) {
        ju juVar = aj3Var.B0;
        if (juVar == null) {
            return new jr2(304, null, true, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((ir1) it.next()).a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = juVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (ir1 ir1Var : juVar.h) {
                    if (!treeSet.contains(ir1Var.a)) {
                        arrayList.add(ir1Var);
                    }
                }
            }
        } else if (!juVar.g.isEmpty()) {
            for (Map.Entry entry : juVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new ir1((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return new jr2(304, juVar.a, true, arrayList);
    }

    public static final float H(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    public static final float I(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    public static byte[] J(InputStream inputStream, int i, qt qtVar) throws Throwable {
        byte[] bArrI;
        a23 a23Var = new a23(qtVar, i);
        try {
            bArrI = qtVar.i(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrI);
                    if (i2 == -1) {
                        break;
                    }
                    a23Var.write(bArrI, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        qs4.d("Error occurred when closing InputStream", new Object[0]);
                    }
                    qtVar.s(bArrI);
                    a23Var.close();
                    throw th;
                }
            }
            byte[] byteArray = a23Var.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                qs4.d("Error occurred when closing InputStream", new Object[0]);
            }
            qtVar.s(bArrI);
            a23Var.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrI = null;
        }
    }

    public static int K(float f2) {
        if (f2 < 1.0f) {
            return -16777216;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f3 = (f2 + 16.0f) / 116.0f;
        float f4 = f2 > 8.0f ? f3 * f3 * f3 : f2 / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z = f5 > 0.008856452f;
        float f6 = z ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = c;
        return u70.a(f6 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static boolean L(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpHeaders.Names.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.Names.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.Names.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static boolean M(Context context, int i) {
        if (q0(i, context, "com.google.android.gms")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                wp1 wp1VarA = wp1.a(context);
                if (packageInfo != null) {
                    if (!wp1.c(packageInfo, false)) {
                        if (wp1.c(packageInfo, true)) {
                            if (!up1.a(wp1VarA.a)) {
                                a1.n("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean N(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean O(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object P(java.util.ArrayList r4, defpackage.ie0 r5) {
        /*
            boolean r0 = r5 instanceof defpackage.vh
            if (r0 == 0) goto L13
            r0 = r5
            vh r0 = (defpackage.vh) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            vh r0 = new vh
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.X
            int r1 = r0.Y
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            java.util.Iterator r4 = r0.A
            defpackage.n12.S(r5)
            goto L35
        L27:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L2e:
            defpackage.n12.S(r5)
            java.util.Iterator r4 = r4.iterator()
        L35:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r4.next()
            v32 r5 = (defpackage.v32) r5
            r0.A = r4
            r0.Y = r2
            java.lang.Object r5 = r5.i0(r0)
            mf0 r1 = defpackage.mf0.b
            if (r5 != r1) goto L35
            return r1
        L4e:
            xl4 r4 = defpackage.xl4.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yr2.P(java.util.ArrayList, ie0):java.lang.Object");
    }

    public static float Q(int i) {
        float f2 = i / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static double[] R(double[] dArr, double[][] dArr2) {
        double d2 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d3 = dArr3[0] * d2;
        double d4 = dArr[1];
        double d5 = (dArr3[1] * d4) + d3;
        double d6 = dArr[2];
        double d7 = (dArr3[2] * d6) + d5;
        double[] dArr4 = dArr2[1];
        double d8 = (dArr4[2] * d6) + (dArr4[1] * d4) + (dArr4[0] * d2);
        double[] dArr5 = dArr2[2];
        return new double[]{d7, d8, (d6 * dArr5[2]) + (d4 * dArr5[1]) + (d2 * dArr5[0])};
    }

    public static Set S(Set set, Set set2) {
        set.getClass();
        if (set2.isEmpty()) {
            return d70.C0(set);
        }
        if (!(set2 instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(set2);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (Object obj : set) {
            if (!set2.contains(obj)) {
                linkedHashSet2.add(obj);
            }
        }
        return linkedHashSet2;
    }

    public static final long T(long j, long j2) {
        return qf1.a(H(j) - H(j2), I(j) - I(j2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(ArrayList arrayList, v74 v74Var) {
        if (arrayList.isEmpty()) {
            return g41.b;
        }
        fn0[] fn0VarArr = (fn0[]) arrayList.toArray(new fn0[0]);
        uh uhVar = new uh(fn0VarArr);
        z00 z00Var = new z00(1, p95.u(v74Var));
        z00Var.w();
        int length = fn0VarArr.length;
        sh[] shVarArr = new sh[length];
        for (int i = 0; i < length; i++) {
            is2 is2Var = fn0VarArr[i];
            ((e42) is2Var).start();
            sh shVar = new sh(uhVar, z00Var);
            shVar.Y = je.K(is2Var, true, shVar);
            shVarArr[i] = shVar;
        }
        th thVar = new th(shVarArr);
        for (int i2 = 0; i2 < length; i2++) {
            sh shVar2 = shVarArr[i2];
            shVar2.getClass();
            re.a.putObjectVolatile(shVar2, sh.y0, thVar);
        }
        if (z00Var.v() instanceof ps2) {
            z00Var.z(thVar);
        } else {
            thVar.a();
        }
        return z00Var.u();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a0(int r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yr2.a0(int, java.lang.String):long");
    }

    public static cu3 b(cu3 cu3Var) {
        dg2 dg2Var = cu3Var.b;
        dg2Var.b();
        return dg2Var.z0 > 0 ? cu3Var : cu3.f;
    }

    public static LinkedHashSet b0(Set set, Collection collection) {
        set.getClass();
        collection.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(fh2.U(set.size() + Integer.valueOf(collection.size()).intValue()));
        linkedHashSet.addAll(set);
        d70.U(collection, linkedHashSet);
        return linkedHashSet;
    }

    public static x21 c(float f2) {
        if (f2 == 0.0f) {
            return x21.c;
        }
        if (f2 == -1.0f) {
            return x21.d;
        }
        if (f2 <= 1.0f) {
            xe.k("Ratio must be greater than 1.");
            return null;
        }
        return new x21(f2, "ratio:" + f2);
    }

    public static final long c0(long j, long j2) {
        return qf1.a(H(j2) + H(j), I(j2) + I(j));
    }

    public static int f0(InputStream inputStream, byte[] bArr) throws IOException {
        int i = inputStream.read(bArr);
        if (i == -1) {
            vp1.i("Unexpected EOF reached when trying to read stream");
            return 0;
        }
        if (i == bArr.length) {
            return i;
        }
        if (i < 0) {
            vp1.i("Invalid readLength");
            return 0;
        }
        if (i == 0) {
            i = 0;
        } else {
            int length = bArr.length - i;
            int i2 = 0;
            for (int i3 = 1; i < bArr.length && i2 != -1 && i3 < 15; i3++) {
                i2 = inputStream.read(bArr, i, length);
                if (i2 > 0) {
                    i += i2;
                    length -= i2;
                }
            }
        }
        if (i == bArr.length) {
            return i;
        }
        vp1.i("Cannot read fully into byte buffer");
        return 0;
    }

    public static void g(int i) {
        if (2 > i || i >= 37) {
            xe.n(dw2.D("radix ", i, " was not in valid range "), new b12(2, 36, 1));
        }
    }

    public static int g0(InputStream inputStream, byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i < 0) {
            xe.k("Negative offset");
            return 0;
        }
        if (i2 < 0) {
            xe.k("Negative length");
            return 0;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i + i2 > bArr.length) {
            xe.k("Length greater than buffer size");
            return 0;
        }
        while (true) {
            if (i3 == i2) {
                break;
            }
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 != -1) {
                i3 += i4;
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    public static final void h0(Object[] objArr, int i, int i2) {
        objArr.getClass();
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.cn i0(defpackage.cn r22, int r23, int r24, defpackage.d13 r25) throws defpackage.qs2 {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yr2.i0(cn, int, int, d13):cn");
    }

    public static lr1 j(lr1 lr1Var, lr1 lr1Var2) {
        ArrayList arrayList = new ArrayList(20);
        int size = lr1Var.size();
        for (int i = 0; i < size; i++) {
            String strZ = gb4.z(lr1Var, i);
            String strB = gb4.B(lr1Var, i);
            if ((!HttpHeaders.Names.WARNING.equalsIgnoreCase(strZ) || !w44.j0(strB, "1", false)) && ("Content-Length".equalsIgnoreCase(strZ) || "Content-Encoding".equalsIgnoreCase(strZ) || "Content-Type".equalsIgnoreCase(strZ) || !L(strZ) || lr1Var2.a(strZ) == null)) {
                gb4.O(strZ);
                arrayList.add(strZ);
                arrayList.add(p44.U0(strB).toString());
            }
        }
        int size2 = lr1Var2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String strZ2 = gb4.z(lr1Var2, i2);
            if (!"Content-Length".equalsIgnoreCase(strZ2) && !"Content-Encoding".equalsIgnoreCase(strZ2) && !"Content-Type".equalsIgnoreCase(strZ2) && L(strZ2)) {
                String strB2 = gb4.B(lr1Var2, i2);
                gb4.O(strZ2);
                arrayList.add(strZ2);
                arrayList.add(p44.U0(strB2).toString());
            }
        }
        return new lr1((String[]) arrayList.toArray(new String[0]));
    }

    public static double j0(double d2) {
        double d3 = d2 % 360.0d;
        return d3 < 0.0d ? d3 + 360.0d : d3;
    }

    public static byte[] k(char[] cArr, boolean z) {
        int i = 0;
        if (!z) {
            byte[] bArr = new byte[cArr.length];
            while (i < cArr.length) {
                bArr[i] = (byte) cArr[i];
                i++;
            }
            return bArr;
        }
        try {
            ByteBuffer byteBufferEncode = m12.a.encode(CharBuffer.wrap(cArr));
            byte[] bArr2 = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr2);
            return bArr2;
        } catch (Exception unused) {
            byte[] bArr3 = new byte[cArr.length];
            while (i < cArr.length) {
                bArr3[i] = (byte) cArr[i];
                i++;
            }
            return bArr3;
        }
    }

    public static Set k0(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        setSingleton.getClass();
        return setSingleton;
    }

    public static final List l(String str) {
        List listL0 = p44.L0(str, new String[]{"."}, 6);
        ArrayList arrayList = new ArrayList(listL0.size() * 2);
        int size = listL0.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) listL0.get(i);
            if (i == 0 && str2.length() == 0 && listL0.size() > 1) {
                arrayList.add(".");
            } else {
                arrayList.add(str2);
                if (i < listL0.size() - 1) {
                    arrayList.add(".");
                }
            }
        }
        if (!arrayList.isEmpty() && n12.c(d70.k0(arrayList), ".")) {
            arrayList.remove(arrayList.size() - 1);
        }
        return d70.s0(arrayList);
    }

    public static boolean l0(String str, String str2, boolean z) {
        if (str.length() >= str2.length()) {
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt == cCharAt2 || (z && Character.toLowerCase(cCharAt) == Character.toLowerCase(cCharAt2))) {
                }
            }
            return true;
        }
        return false;
    }

    public static long m(CharSequence charSequence) {
        char cCharAt;
        Objects.requireNonNull(charSequence);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length() && ((cCharAt = charSequence.charAt(i3)) == '\t' || cCharAt == ' '); i3++) {
            if (cCharAt == '\t') {
                i2++;
            } else {
                i++;
            }
        }
        return ez4.M(i, i2);
    }

    public static final String m0(Object[] objArr, int i, int i2, f1 f1Var) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i + i3];
            if (obj == f1Var) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static tn3 n(String str, String str2, List list) {
        int i;
        String strN;
        str2.getClass();
        list.getClass();
        if (list.isEmpty()) {
            return new jn3(str, str2, list);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            tn3 tn3Var = (tn3) list.get(i2);
            if (tn3Var instanceof rm3) {
                i = i2;
                ArrayList arrayList2 = new ArrayList();
                int i3 = i;
                while (i3 < list.size()) {
                    tn3 tn3Var2 = (tn3) list.get(i3);
                    if ((!(tn3Var2 instanceof mm3) && !(tn3Var2 instanceof pm3)) || !n12.c(tn3Var2.S(), tn3Var.S())) {
                        break;
                    }
                    rm3 rm3Var = (rm3) tn3Var2;
                    rm3 rm3Var2 = (rm3) tn3Var;
                    if (rm3Var.x() != rm3Var2.x() || rm3Var.G() != rm3Var2.G()) {
                        break;
                    }
                    if (rm3Var instanceof mm3) {
                        strN = ((mm3) tn3Var2).b;
                    } else {
                        if (!(rm3Var instanceof pm3)) {
                            g.d();
                            return null;
                        }
                        pm3 pm3Var = (pm3) tn3Var2;
                        boolean zJ0 = w44.j0(pm3Var.b, ".", false);
                        strN = pm3Var.b;
                        if (!zJ0) {
                            strN = ha0.n(".", strN);
                        }
                    }
                    arrayList2.add(strN);
                    i3++;
                }
                if (arrayList2.size() >= 10) {
                    String strK = ha0.k("Optimize RULE-SET segment: ", arrayList2.size(), " domain rules merged into Domain.Set");
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "Rule", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strK);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("Rule", strK, null);
                    }
                    rm3 rm3Var3 = (rm3) tn3Var;
                    arrayList.add(pr1.o(arrayList2, str2, tn3Var.S(), rm3Var3.x(), rm3Var3.G(), null, 64));
                    i2 = i3;
                } else {
                    arrayList.add(tn3Var);
                }
            } else {
                i = i2;
                arrayList.add(tn3Var);
            }
            i2 = i + 1;
        }
        if (arrayList.size() != 1 || !(arrayList.get(0) instanceof om3)) {
            return new jn3(str, str2, arrayList);
        }
        String strConcat = "RULE-SET fully optimized into Domain.Set: ".concat(str2);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "Rule", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("Rule", strConcat, null);
        }
        return (tn3) arrayList.get(0);
    }

    public static final long n0(long j, float f2) {
        return qf1.a(H(j) * f2, I(j) * f2);
    }

    public static String o(int i, int i2, boolean z) {
        int i3;
        int iMax = Math.max(0, i);
        if (z) {
            i3 = iMax / i2;
            iMax %= i2;
        } else {
            i3 = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append('\t');
        }
        for (int i5 = 0; i5 < iMax; i5++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static final long o0(long j, v62 v62Var) {
        float fH = H(j);
        float fI = I(j);
        float[] fArr = (float[]) v62Var.f;
        fArr[0] = fH;
        fArr[1] = fI;
        ((Matrix) v62Var.z).mapPoints(fArr);
        long jA = qf1.a(fArr[0], fArr[1]);
        return qf1.a(Float.intBitsToFloat((int) (jA >> 32)), Float.intBitsToFloat((int) (jA & 4294967295L)));
    }

    public static fa5 p(int i, int i2, int i3, int i4) {
        return new fa5(ImageReader.newInstance(i, i2, i3, i4));
    }

    public static int q(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static boolean q0(int i, Context context, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) ay4.a(context).a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static String r(String str) {
        str.getClass();
        int length = str.length();
        if (length < 2 || str.charAt(0) != '\"') {
            return str;
        }
        int i = length - 1;
        if (str.charAt(i) != '\"') {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        int i2 = 1;
        while (i2 < i) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\\' && i2 != length - 2) {
                i2++;
                cCharAt = str.charAt(i2);
            }
            stringBuffer.append(cCharAt);
            i2++;
        }
        String string = stringBuffer.toString();
        string.getClass();
        return string;
    }

    public static float r0() {
        return ((float) Math.pow(0.5689655172413793d, 3.0d)) * 100.0f;
    }

    public static int s(char c2) {
        g(16);
        int iDigit = Character.digit((int) c2, 16);
        Integer numValueOf = Integer.valueOf(iDigit);
        if (iDigit < 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a digit in the given radix=16");
    }

    public static String s0(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    String strZ = fw.z(new StringBuilder(name.length() + 1 + String.valueOf(hexString).length()), name, "@", hexString);
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strZ), (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb = new StringBuilder(name2.length() + strZ.length() + 8 + 1);
                    sb.append("<");
                    sb.append(strZ);
                    sb.append(" threw ");
                    sb.append(name2);
                    sb.append(">");
                    string = sb.toString();
                }
            }
            objArr[i2] = string;
            i2++;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb2.append((CharSequence) str, i3, iIndexOf);
            sb2.append(objArr[i]);
            i++;
            i3 = iIndexOf + 2;
        }
        sb2.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb2.append(" [");
            sb2.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb2.append(", ");
                sb2.append(objArr[i4]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public static final long t(long j, float f2) {
        return qf1.a(H(j) / f2, I(j) / f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ArrayList u(ub2 ub2Var, ub2 ub2Var2) {
        Iterator it = e70.I(ub2Var2).iterator();
        a12 a12Var = (a12) it;
        if (!a12Var.z) {
            vp1.g();
            return null;
        }
        a12 a12Var2 = (a12) it;
        int iNextInt = a12Var2.nextInt();
        if (a12Var.z) {
            float fA = A(((h83) ub2Var.get(0)).b, ((h83) ub2Var2.get(iNextInt)).b);
            do {
                int iNextInt2 = a12Var2.nextInt();
                float fA2 = A(((h83) ub2Var.get(0)).b, ((h83) ub2Var2.get(iNextInt2)).b);
                if (Float.compare(fA, fA2) > 0) {
                    iNextInt = iNextInt2;
                    fA = fA2;
                }
            } while (a12Var.z);
        }
        int iA = ub2Var.a();
        int iA2 = ub2Var2.a();
        ArrayList arrayListL = e70.L(ub2Var2.get(iNextInt));
        int i = iNextInt;
        for (int i2 = 1; i2 < iA; i2++) {
            int i3 = iNextInt - (iA - i2);
            if (i3 <= i) {
                i3 += iA2;
            }
            Iterator it2 = new b12(i + 1, i3, 1).iterator();
            a12 a12Var3 = (a12) it2;
            if (!a12Var3.z) {
                vp1.g();
                return null;
            }
            a12 a12Var4 = (a12) it2;
            int iNextInt3 = a12Var4.nextInt();
            if (a12Var3.z) {
                float fA3 = A(((h83) ub2Var.get(i2)).b, ((h83) ub2Var2.get(iNextInt3 % iA2)).b);
                do {
                    int iNextInt4 = a12Var4.nextInt();
                    float fA4 = A(((h83) ub2Var.get(i2)).b, ((h83) ub2Var2.get(iNextInt4 % iA2)).b);
                    if (Float.compare(fA3, fA4) > 0) {
                        iNextInt3 = iNextInt4;
                        fA3 = fA4;
                    }
                } while (a12Var3.z);
            }
            i = iNextInt3;
            arrayListL.add(ub2Var2.get(i % iA2));
        }
        return arrayListL;
    }

    public static boolean v(String str, String str2) {
        return n12.c(str, str2) || (w44.d0(str, str2, false) && str.charAt((str.length() - str2.length()) - 1) == '.' && !fz4.a.d(str));
    }

    public static final float w(long j, long j2) {
        return (I(j2) * I(j)) + (H(j2) * H(j));
    }

    public static Map x(ha1 ha1Var) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ((LinkedHashSet) ha1Var.f).iterator();
        while (it.hasNext()) {
            String type = ((ea3) it.next()).getType();
            Object zg3Var = linkedHashMap.get(type);
            if (zg3Var == null && !linkedHashMap.containsKey(type)) {
                zg3Var = new zg3();
            }
            zg3 zg3Var2 = (zg3) zg3Var;
            zg3Var2.b++;
            linkedHashMap.put(type, zg3Var2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            entry.getClass();
            if ((entry instanceof z72) && !(entry instanceof bg2)) {
                tj4.h0(entry, "kotlin.collections.MutableMap.MutableEntry");
                throw null;
            }
            entry.setValue(Integer.valueOf(((zg3) entry.getValue()).b));
        }
        tj4.b(linkedHashMap);
        return linkedHashMap;
    }

    public static long y(long j) {
        long j2;
        if (j < 0) {
            return 2162688L;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        if (i < 1980) {
            j2 = 2162688;
        } else {
            j2 = (calendar.get(13) >> 1) | ((i - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
        }
        if (j2 != 2162688) {
            return j2 + ((j % 2000) << 32);
        }
        return 2162688L;
    }

    public static final boolean z(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public int F(View view) {
        return 0;
    }

    public int G() {
        return 0;
    }

    public abstract void X(int i);

    public abstract void Y(View view, int i, int i2);

    public abstract void Z(View view, float f2, float f3);

    public abstract boolean d(x1 x1Var, s1 s1Var, s1 s1Var2);

    public abstract void d0(w1 w1Var, w1 w1Var2);

    public abstract boolean e(x1 x1Var, Object obj, Object obj2);

    public abstract void e0(w1 w1Var, Thread thread);

    public abstract boolean f(x1 x1Var, w1 w1Var, w1 w1Var2);

    public abstract int h(View view, int i);

    public abstract int i(View view, int i);

    public abstract boolean p0(View view, int i);

    public void U(int i) {
    }

    public void V(int i) {
    }

    public void W(View view, int i) {
    }
}
