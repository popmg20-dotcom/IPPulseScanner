package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z65 extends pe5 {
    public final /* synthetic */ int Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z65(ff5 ff5Var, int i) {
        super(ff5Var);
        this.Z = i;
    }

    public static boolean B1(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean C1(lc5 lc5Var, int i) {
        if (i < ((wc5) lc5Var).z * 64) {
            return ((1 << (i % 64)) & ((Long) ((wc5) lc5Var).get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static ArrayList D1(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static zb5 I1(zb5 zb5Var, byte[] bArr) throws pc5 {
        pb5 pb5VarN;
        pb5 pb5Var = pb5.b;
        if (pb5Var == null) {
            synchronized (pb5.class) {
                try {
                    pb5VarN = pb5.b;
                    if (pb5VarN == null) {
                        od5 od5Var = od5.c;
                        pb5VarN = xb5.N();
                        pb5.b = pb5VarN;
                    }
                } finally {
                }
            }
            pb5Var = pb5VarN;
        }
        if (pb5Var != null) {
            zb5Var.getClass();
            zb5Var.g(bArr, bArr.length, pb5Var);
            return zb5Var;
        }
        zb5Var.getClass();
        int length = bArr.length;
        pb5 pb5Var2 = pb5.b;
        od5 od5Var2 = od5.c;
        zb5Var.g(bArr, length, pb5.c);
        return zb5Var;
    }

    public static int J1(String str, l85 l85Var) {
        for (int i = 0; i < ((n85) l85Var.f).T1(); i++) {
            if (str.equals(((n85) l85Var.f).U1(i).p())) {
                return i;
            }
        }
        return -1;
    }

    public static Bundle[] K1(mc5 mc5Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = mc5Var.iterator();
        while (it.hasNext()) {
            b85 b85Var = (b85) it.next();
            if (b85Var != null) {
                Bundle bundle = new Bundle();
                for (b85 b85Var2 : b85Var.x()) {
                    if (b85Var2.p()) {
                        bundle.putString(b85Var2.o(), b85Var2.q());
                    } else if (b85Var2.r()) {
                        bundle.putLong(b85Var2.o(), b85Var2.s());
                    } else if (b85Var2.v()) {
                        bundle.putDouble(b85Var2.o(), b85Var2.w());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static HashMap L1(Bundle bundle, boolean z) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(L1((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(L1((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(L1((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static z25 Z0(y05 y05Var) {
        Object obj;
        Bundle bundleA1 = a1(y05Var.c, true);
        String string = (!bundleA1.containsKey("_o") || (obj = bundleA1.get("_o")) == null) ? "app" : obj.toString();
        String strZ = n12.Z(y05Var.a, xb5.Z, xb5.z0);
        if (strZ == null) {
            strZ = y05Var.a;
        }
        return new z25(strZ, new y25(bundleA1), string, y05Var.b);
    }

    public static Bundle a1(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(a1((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static final void b1(v75 v75Var, String str, Long l) {
        List listH = v75Var.h();
        int i = 0;
        while (true) {
            if (i >= listH.size()) {
                i = -1;
                break;
            } else if (str.equals(((b85) listH.get(i)).o())) {
                break;
            } else {
                i++;
            }
        }
        z75 z75VarZ = b85.z();
        z75VarZ.h(str);
        z75VarZ.j(l.longValue());
        if (i < 0) {
            v75Var.l(z75VarZ);
        } else {
            v75Var.c();
            ((w75) v75Var.f).y(i, (b85) z75VarZ.e());
        }
    }

    public static final Bundle c1(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b85 b85Var = (b85) it.next();
            String strO = b85Var.o();
            if (b85Var.v()) {
                bundle.putDouble(strO, b85Var.w());
            } else if (b85Var.t()) {
                bundle.putFloat(strO, b85Var.u());
            } else if (b85Var.p()) {
                bundle.putString(strO, b85Var.q());
            } else if (b85Var.r()) {
                bundle.putLong(strO, b85Var.s());
            }
        }
        return bundle;
    }

    public static final b85 d1(String str, w75 w75Var) {
        for (b85 b85Var : w75Var.n()) {
            if (b85Var.o().equals(str)) {
                return b85Var;
            }
        }
        return null;
    }

    public static final Serializable e1(String str, w75 w75Var) {
        b85 b85VarD1 = d1(str, w75Var);
        if (b85VarD1 == null) {
            return null;
        }
        return k1(b85VarD1);
    }

    public static final void h1(int i, StringBuilder sb) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    public static final void i1(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static final String j1(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable k1(b85 b85Var) {
        if (b85Var.p()) {
            return b85Var.q();
        }
        if (b85Var.r()) {
            return Long.valueOf(b85Var.s());
        }
        if (b85Var.v()) {
            return Double.valueOf(b85Var.w());
        }
        if (b85Var.y() > 0) {
            return K1((mc5) b85Var.x());
        }
        return null;
    }

    public static final void l1(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                i1(builder, str3, string, set);
            }
        }
    }

    public static final void m1(StringBuilder sb, String str, t85 t85Var) {
        if (t85Var == null) {
            return;
        }
        h1(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (t85Var.q() != 0) {
            h1(4, sb);
            sb.append("results: ");
            int i = 0;
            for (Long l : t85Var.p()) {
                int i2 = i + 1;
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i = i2;
            }
            sb.append('\n');
        }
        if (t85Var.o() != 0) {
            h1(4, sb);
            sb.append("status: ");
            int i3 = 0;
            for (Long l2 : t85Var.n()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i3 = i4;
            }
            sb.append('\n');
        }
        if (t85Var.s() != 0) {
            h1(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int i5 = 0;
            for (u75 u75Var : t85Var.r()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(u75Var.n() ? Integer.valueOf(u75Var.o()) : null);
                sb.append(":");
                sb.append(u75Var.p() ? Long.valueOf(u75Var.q()) : null);
                i5 = i6;
            }
            sb.append("}\n");
        }
        if (t85Var.u() != 0) {
            h1(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int i7 = 0;
            for (w85 w85Var : t85Var.t()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(w85Var.n() ? Integer.valueOf(w85Var.o()) : null);
                sb.append(": [");
                Iterator it = w85Var.p().iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i10 = i9 + 1;
                    if (i9 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i9 = i10;
                }
                sb.append("]");
                i7 = i8;
            }
            sb.append("}\n");
        }
        h1(3, sb);
        sb.append("}\n");
    }

    public static final void n1(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        h1(i + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void o1(StringBuilder sb, int i, String str, k55 k55Var) {
        if (k55Var == null) {
            return;
        }
        h1(i, sb);
        sb.append(str);
        sb.append(" {\n");
        if (k55Var.n()) {
            int iX = k55Var.x();
            n1(sb, i, "comparison_type", iX != 1 ? iX != 2 ? iX != 3 ? iX != 4 ? "BETWEEN" : "EQUAL" : "GREATER_THAN" : "LESS_THAN" : "UNKNOWN_COMPARISON_TYPE");
        }
        if (k55Var.o()) {
            n1(sb, i, "match_as_float", Boolean.valueOf(k55Var.p()));
        }
        if (k55Var.q()) {
            n1(sb, i, "comparison_value", k55Var.r());
        }
        if (k55Var.s()) {
            n1(sb, i, "min_comparison_value", k55Var.t());
        }
        if (k55Var.u()) {
            n1(sb, i, "max_comparison_value", k55Var.v());
        }
        h1(i, sb);
        sb.append("}\n");
    }

    public Parcelable A1(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                parcelObtain.unmarshall(bArr, 0, bArr.length);
                parcelObtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(parcelObtain);
            } catch (uo3 unused) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                t65Var.z0.a("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            parcelObtain.recycle();
        }
    }

    public List E1(lc5 lc5Var, List list) {
        int i;
        k85 k85Var = (k85) this.f;
        ArrayList arrayList = new ArrayList(lc5Var);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.C0.b(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.C0.c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public boolean F1(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            return true;
        }
        ((k85) this.f).B0.getClass();
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    public long G1(byte[] bArr) {
        tj4.i(bArr);
        k85 k85Var = (k85) this.f;
        qf5 qf5Var = k85Var.z0;
        k85.f(qf5Var);
        qf5Var.V0();
        MessageDigest messageDigestM1 = qf5.m1();
        if (messageDigestM1 != null) {
            return qf5.n1(messageDigestM1.digest(bArr));
        }
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.z0.a("Failed to get MD5");
        return 0L;
    }

    public byte[] H1(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.z0.b(e, "Failed to gzip content");
            throw e;
        }
    }

    @Override // defpackage.pe5
    public final void Y0() {
        int i = this.Z;
    }

    public void f1(StringBuilder sb, int i, mc5 mc5Var) {
        if (mc5Var == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = mc5Var.iterator();
        while (it.hasNext()) {
            b85 b85Var = (b85) it.next();
            if (b85Var != null) {
                h1(i2, sb);
                sb.append("param {\n");
                n1(sb, i2, "name", b85Var.n() ? ((k85) this.f).A0.b(b85Var.o()) : null);
                n1(sb, i2, "string_value", b85Var.p() ? b85Var.q() : null);
                n1(sb, i2, "int_value", b85Var.r() ? Long.valueOf(b85Var.s()) : null);
                n1(sb, i2, "double_value", b85Var.v() ? Double.valueOf(b85Var.w()) : null);
                if (b85Var.y() > 0) {
                    f1(sb, i2, (mc5) b85Var.x());
                }
                h1(i2, sb);
                sb.append("}\n");
            }
        }
    }

    public void g1(StringBuilder sb, int i, h55 h55Var) {
        String str;
        if (h55Var == null) {
            return;
        }
        h1(i, sb);
        sb.append("filter {\n");
        if (h55Var.r()) {
            n1(sb, i, "complement", Boolean.valueOf(h55Var.s()));
        }
        if (h55Var.t()) {
            n1(sb, i, "param_name", ((k85) this.f).A0.b(h55Var.u()));
        }
        if (h55Var.n()) {
            int i2 = i + 1;
            n55 n55VarO = h55Var.o();
            if (n55VarO != null) {
                h1(i2, sb);
                sb.append("string_filter {\n");
                if (n55VarO.n()) {
                    switch (n55VarO.v()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    n1(sb, i2, "match_type", str);
                }
                if (n55VarO.o()) {
                    n1(sb, i2, "expression", n55VarO.p());
                }
                if (n55VarO.q()) {
                    n1(sb, i2, "case_sensitive", Boolean.valueOf(n55VarO.r()));
                }
                if (n55VarO.t() > 0) {
                    h1(i + 2, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : n55VarO.s()) {
                        h1(i + 3, sb);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                h1(i2, sb);
                sb.append("}\n");
            }
        }
        if (h55Var.p()) {
            o1(sb, i + 1, "number_filter", h55Var.q());
        }
        h1(i, sb);
        sb.append("}\n");
    }

    public boolean p1() {
        W0();
        ConnectivityManager connectivityManager = (ConnectivityManager) ((k85) this.f).b.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void t1(String str, re5 re5Var, j85 j85Var, v65 v65Var) {
        String str2;
        URL url;
        byte[] bArrA;
        f85 f85Var;
        Map map;
        String str3 = re5Var.a;
        k85 k85Var = (k85) this.f;
        V0();
        W0();
        try {
            url = new URI(str3).toURL();
            this.X.h0();
            bArrA = j85Var.a();
            f85Var = k85Var.Z;
            k85.h(f85Var);
            map = re5Var.b;
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            str2 = str;
        }
        try {
            f85Var.h1(new x65(this, str2, url, bArrA, map, v65Var));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.c("Failed to parse URL. Not uploading MeasurementBatch. appId", t65.Z0(str2), str3);
        }
    }

    public void u1(z85 z85Var, Object obj) {
        z85Var.c();
        ((a95) z85Var.f).C();
        z85Var.c();
        ((a95) z85Var.f).E();
        z85Var.c();
        ((a95) z85Var.f).G();
        if (obj instanceof String) {
            z85Var.c();
            ((a95) z85Var.f).B((String) obj);
        } else if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            z85Var.c();
            ((a95) z85Var.f).D(jLongValue);
        } else if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            z85Var.c();
            ((a95) z85Var.f).F(dDoubleValue);
        } else {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.z0.b(obj, "Ignoring invalid (type) user attribute value");
        }
    }

    public void v1(z75 z75Var, Object obj) {
        z75Var.c();
        ((b85) z75Var.f).C();
        z75Var.c();
        ((b85) z75Var.f).E();
        z75Var.c();
        ((b85) z75Var.f).G();
        z75Var.c();
        ((b85) z75Var.f).J();
        if (obj instanceof String) {
            z75Var.i((String) obj);
            return;
        }
        if (obj instanceof Long) {
            z75Var.j(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            z75Var.c();
            ((b85) z75Var.f).F(dDoubleValue);
            return;
        }
        if (!(obj instanceof Bundle[])) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.z0.b(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                z75 z75VarZ = b85.z();
                for (String str : bundle.keySet()) {
                    z75 z75VarZ2 = b85.z();
                    z75VarZ2.h(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        z75VarZ2.j(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        z75VarZ2.i((String) obj2);
                    } else if (obj2 instanceof Double) {
                        double dDoubleValue2 = ((Double) obj2).doubleValue();
                        z75VarZ2.c();
                        ((b85) z75VarZ2.f).F(dDoubleValue2);
                    }
                    z75VarZ.c();
                    ((b85) z75VarZ.f).H((b85) z75VarZ2.e());
                }
                if (((b85) z75VarZ.f).y() > 0) {
                    arrayList.add((b85) z75VarZ.e());
                }
            }
        }
        z75Var.c();
        ((b85) z75Var.f).I(arrayList);
    }

    public ee5 w1(String str, l85 l85Var, v75 v75Var, String str2) {
        int iIndexOf;
        mg5.a();
        k85 k85Var = (k85) this.f;
        x15 x15Var = k85Var.A;
        if (!x15Var.f1(str, r55.Q0)) {
            return null;
        }
        k85Var.B0.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArrSplit = x15Var.b1(str, r55.v0).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                vp1.h(str3, "duplicate element: ");
                return null;
            }
        }
        Set setUnmodifiableSet = DesugarCollections.unmodifiableSet(hashSet);
        ff5 ff5Var = this.X;
        te5 te5Var = ff5Var.A0;
        x75 x75Var = ff5Var.b;
        x75 x75Var2 = te5Var.X.b;
        ff5.R(x75Var2);
        String strI1 = x75Var2.i1(str);
        Uri.Builder builder = new Uri.Builder();
        x15 x15Var2 = ((k85) te5Var.f).A;
        builder.scheme(x15Var2.b1(str, r55.o0));
        if (TextUtils.isEmpty(strI1)) {
            builder.authority(x15Var2.b1(str, r55.p0));
        } else {
            String strB1 = x15Var2.b1(str, r55.p0);
            StringBuilder sb = new StringBuilder(String.valueOf(strI1).length() + 1 + String.valueOf(strB1).length());
            sb.append(strI1);
            sb.append(".");
            sb.append(strB1);
            builder.authority(sb.toString());
        }
        builder.path(x15Var2.b1(str, r55.q0));
        i1(builder, "gmp_app_id", ((n85) l85Var.f).C(), setUnmodifiableSet);
        x15Var.a1();
        i1(builder, "gmp_version", String.valueOf(133005L), setUnmodifiableSet);
        String strW = ((n85) l85Var.f).w();
        q55 q55Var = r55.T0;
        if (x15Var.f1(str, q55Var)) {
            ff5.R(x75Var);
            if (x75Var.o1(str)) {
                strW = "";
            }
        }
        i1(builder, "app_instance_id", strW, setUnmodifiableSet);
        i1(builder, "rdid", ((n85) l85Var.f).t(), setUnmodifiableSet);
        i1(builder, "bundle_id", l85Var.o(), setUnmodifiableSet);
        String strN = v75Var.n();
        String strZ = n12.Z(strN, xb5.z0, xb5.Z);
        if (true != TextUtils.isEmpty(strZ)) {
            strN = strZ;
        }
        i1(builder, "app_event_name", strN, setUnmodifiableSet);
        i1(builder, "app_version", String.valueOf(((n85) l85Var.f).I()), setUnmodifiableSet);
        String strG2 = ((n85) l85Var.f).g2();
        if (x15Var.f1(str, q55Var)) {
            ff5.R(x75Var);
            if (x75Var.n1(str) && !TextUtils.isEmpty(strG2) && (iIndexOf = strG2.indexOf(".")) != -1) {
                strG2 = strG2.substring(0, iIndexOf);
            }
        }
        i1(builder, "os_version", strG2, setUnmodifiableSet);
        i1(builder, "timestamp", String.valueOf(v75Var.o()), setUnmodifiableSet);
        if (((n85) l85Var.f).v()) {
            i1(builder, "lat", "1", setUnmodifiableSet);
        }
        i1(builder, "privacy_sandbox_version", String.valueOf(((n85) l85Var.f).E0()), setUnmodifiableSet);
        i1(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        i1(builder, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), setUnmodifiableSet);
        i1(builder, "request_uuid", str2, setUnmodifiableSet);
        List<b85> listH = v75Var.h();
        Bundle bundle = new Bundle();
        for (b85 b85Var : listH) {
            String strO = b85Var.o();
            if (b85Var.v()) {
                bundle.putString(strO, String.valueOf(b85Var.w()));
            } else if (b85Var.t()) {
                bundle.putString(strO, String.valueOf(b85Var.u()));
            } else if (b85Var.p()) {
                bundle.putString(strO, b85Var.q());
            } else if (b85Var.r()) {
                bundle.putString(strO, String.valueOf(b85Var.s()));
            }
        }
        l1(builder, x15Var.b1(str, r55.u0).split("\\|"), bundle, setUnmodifiableSet);
        List<a95> listUnmodifiableList = DesugarCollections.unmodifiableList(((n85) l85Var.f).S1());
        Bundle bundle2 = new Bundle();
        for (a95 a95Var : listUnmodifiableList) {
            String strP = a95Var.p();
            if (a95Var.w()) {
                bundle2.putString(strP, String.valueOf(a95Var.x()));
            } else if (a95Var.u()) {
                bundle2.putString(strP, String.valueOf(a95Var.v()));
            } else if (a95Var.q()) {
                bundle2.putString(strP, a95Var.r());
            } else if (a95Var.s()) {
                bundle2.putString(strP, String.valueOf(a95Var.t()));
            }
        }
        l1(builder, x15Var.b1(str, r55.t0).split("\\|"), bundle2, setUnmodifiableSet);
        i1(builder, "dma", true != ((n85) l85Var.f).B0() ? "0" : "1", setUnmodifiableSet);
        if (!((n85) l85Var.f).D0().isEmpty()) {
            i1(builder, "dma_cps", ((n85) l85Var.f).D0(), setUnmodifiableSet);
        }
        if (((n85) l85Var.f).J0()) {
            d75 d75VarK0 = ((n85) l85Var.f).K0();
            if (!d75VarK0.x().isEmpty()) {
                i1(builder, "dl_gclid", d75VarK0.x(), setUnmodifiableSet);
            }
            if (!d75VarK0.z().isEmpty()) {
                i1(builder, "dl_gbraid", d75VarK0.z(), setUnmodifiableSet);
            }
            if (!d75VarK0.B().isEmpty()) {
                i1(builder, "dl_gs", d75VarK0.B(), setUnmodifiableSet);
            }
            if (d75VarK0.D() > 0) {
                i1(builder, "dl_ss_ts", String.valueOf(d75VarK0.D()), setUnmodifiableSet);
            }
            if (!d75VarK0.F().isEmpty()) {
                i1(builder, "mr_gclid", d75VarK0.F(), setUnmodifiableSet);
            }
            if (!d75VarK0.H().isEmpty()) {
                i1(builder, "mr_gbraid", d75VarK0.H(), setUnmodifiableSet);
            }
            if (!d75VarK0.J().isEmpty()) {
                i1(builder, "mr_gs", d75VarK0.J(), setUnmodifiableSet);
            }
            if (d75VarK0.L() > 0) {
                i1(builder, "mr_click_ts", String.valueOf(d75VarK0.L()), setUnmodifiableSet);
            }
        }
        return new ee5(1, jCurrentTimeMillis, builder.build().toString());
    }

    public w75 x1(v25 v25Var) {
        v75 v75VarX = w75.x();
        long j = v25Var.e;
        v75VarX.c();
        ((w75) v75VarX.f).F(j);
        Bundle bundle = v25Var.f.b;
        for (String str : bundle.keySet()) {
            z75 z75VarZ = b85.z();
            z75VarZ.h(str);
            Object obj = bundle.get(str);
            tj4.i(obj);
            v1(z75VarZ, obj);
            v75VarX.l(z75VarZ);
        }
        String str2 = v25Var.c;
        if (!TextUtils.isEmpty(str2) && bundle.get("_o") == null) {
            z75 z75VarZ2 = b85.z();
            z75VarZ2.h("_o");
            z75VarZ2.i(str2);
            v75VarX.k((b85) z75VarZ2.e());
        }
        return (w75) v75VarX.e();
    }

    public String y1(j85 j85Var) {
        i75 i75VarG0;
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (j85Var.s()) {
            n1(sb, 0, "upload_subdomain", j85Var.t());
        }
        if (j85Var.q()) {
            n1(sb, 0, "sgtm_join_id", j85Var.r());
        }
        for (n85 n85Var : j85Var.n()) {
            if (n85Var != null) {
                h1(1, sb);
                sb.append("bundle {\n");
                if (n85Var.N()) {
                    n1(sb, 1, "protocol_version", Integer.valueOf(n85Var.N0()));
                }
                k85 k85Var = (k85) this.f;
                x15 x15Var = k85Var.A;
                k65 k65Var = k85Var.A0;
                if (x15Var.f1(n85Var.n(), r55.N0) && n85Var.t0()) {
                    n1(sb, 1, "session_stitching_token", n85Var.u0());
                }
                n1(sb, 1, "platform", n85Var.f2());
                if (n85Var.p()) {
                    n1(sb, 1, "gmp_version", Long.valueOf(n85Var.q()));
                }
                if (n85Var.r()) {
                    n1(sb, 1, "uploading_gmp_version", Long.valueOf(n85Var.s()));
                }
                if (n85Var.p0()) {
                    n1(sb, 1, "dynamite_version", Long.valueOf(n85Var.q0()));
                }
                if (n85Var.J()) {
                    n1(sb, 1, "config_version", Long.valueOf(n85Var.K()));
                }
                n1(sb, 1, "gmp_app_id", n85Var.C());
                n1(sb, 1, "app_id", n85Var.n());
                n1(sb, 1, "app_version", n85Var.o());
                if (n85Var.H()) {
                    n1(sb, 1, "app_version_major", Integer.valueOf(n85Var.I()));
                }
                n1(sb, 1, "firebase_instance_id", n85Var.G());
                if (n85Var.x()) {
                    n1(sb, 1, "dev_cert_hash", Long.valueOf(n85Var.y()));
                }
                n1(sb, 1, "app_store", n85Var.l2());
                if (n85Var.V1()) {
                    n1(sb, 1, "upload_timestamp_millis", Long.valueOf(n85Var.W1()));
                }
                if (n85Var.X1()) {
                    n1(sb, 1, "start_timestamp_millis", Long.valueOf(n85Var.Y1()));
                }
                if (n85Var.Z1()) {
                    n1(sb, 1, "end_timestamp_millis", Long.valueOf(n85Var.a2()));
                }
                if (n85Var.b2()) {
                    n1(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(n85Var.c2()));
                }
                if (n85Var.d2()) {
                    n1(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(n85Var.e2()));
                }
                n1(sb, 1, "app_instance_id", n85Var.w());
                n1(sb, 1, "resettable_device_id", n85Var.t());
                n1(sb, 1, "ds_id", n85Var.M());
                if (n85Var.u()) {
                    n1(sb, 1, "limited_ad_tracking", Boolean.valueOf(n85Var.v()));
                }
                n1(sb, 1, "os_version", n85Var.g2());
                n1(sb, 1, "device_model", n85Var.h2());
                n1(sb, 1, "user_default_language", n85Var.i2());
                if (n85Var.j2()) {
                    n1(sb, 1, "time_zone_offset_minutes", Integer.valueOf(n85Var.k2()));
                }
                if (n85Var.z()) {
                    n1(sb, 1, "bundle_sequential_index", Integer.valueOf(n85Var.A()));
                }
                if (n85Var.H0()) {
                    n1(sb, 1, "delivery_index", Integer.valueOf(n85Var.I0()));
                }
                if (n85Var.D()) {
                    n1(sb, 1, "service_upload", Boolean.valueOf(n85Var.E()));
                }
                n1(sb, 1, "health_monitor", n85Var.B());
                if (n85Var.n0()) {
                    n1(sb, 1, "retry_counter", Integer.valueOf(n85Var.o0()));
                }
                if (n85Var.r0()) {
                    n1(sb, 1, "consent_signals", n85Var.s0());
                }
                if (n85Var.A0()) {
                    n1(sb, 1, "is_dma_region", Boolean.valueOf(n85Var.B0()));
                }
                if (n85Var.C0()) {
                    n1(sb, 1, "core_platform_services", n85Var.D0());
                }
                if (n85Var.y0()) {
                    n1(sb, 1, "consent_diagnostics", n85Var.z0());
                }
                if (n85Var.v0()) {
                    n1(sb, 1, "target_os_version", Long.valueOf(n85Var.w0()));
                }
                mg5.a();
                if (k85Var.A.f1(n85Var.n(), r55.Q0)) {
                    n1(sb, 1, "ad_services_version", Integer.valueOf(n85Var.E0()));
                    if (n85Var.F0() && (i75VarG0 = n85Var.G0()) != null) {
                        h1(2, sb);
                        sb.append("attribution_eligibility_status {\n");
                        n1(sb, 2, "eligible", Boolean.valueOf(i75VarG0.n()));
                        n1(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(i75VarG0.o()));
                        n1(sb, 2, "pre_r", Boolean.valueOf(i75VarG0.p()));
                        n1(sb, 2, "r_extensions_too_old", Boolean.valueOf(i75VarG0.q()));
                        n1(sb, 2, "adservices_extension_too_old", Boolean.valueOf(i75VarG0.r()));
                        n1(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(i75VarG0.s()));
                        n1(sb, 2, "measurement_manager_disabled", Boolean.valueOf(i75VarG0.t()));
                        h1(2, sb);
                        sb.append("}\n");
                    }
                }
                if (n85Var.J0()) {
                    d75 d75VarK0 = n85Var.K0();
                    h1(2, sb);
                    sb.append("ad_campaign_info {\n");
                    if (d75VarK0.w()) {
                        n1(sb, 2, "deep_link_gclid", d75VarK0.x());
                    }
                    if (d75VarK0.y()) {
                        n1(sb, 2, "deep_link_gbraid", d75VarK0.z());
                    }
                    if (d75VarK0.A()) {
                        n1(sb, 2, "deep_link_gad_source", d75VarK0.B());
                    }
                    if (d75VarK0.C()) {
                        n1(sb, 2, "deep_link_session_millis", Long.valueOf(d75VarK0.D()));
                    }
                    if (d75VarK0.E()) {
                        n1(sb, 2, "market_referrer_gclid", d75VarK0.F());
                    }
                    if (d75VarK0.G()) {
                        n1(sb, 2, "market_referrer_gbraid", d75VarK0.H());
                    }
                    if (d75VarK0.I()) {
                        n1(sb, 2, "market_referrer_gad_source", d75VarK0.J());
                    }
                    if (d75VarK0.K()) {
                        n1(sb, 2, "market_referrer_click_millis", Long.valueOf(d75VarK0.L()));
                    }
                    h1(2, sb);
                    sb.append("}\n");
                }
                if (n85Var.O()) {
                    n1(sb, 1, "batching_timestamp_millis", Long.valueOf(n85Var.P()));
                }
                if (n85Var.L0()) {
                    y85 y85VarM0 = n85Var.M0();
                    h1(2, sb);
                    sb.append("sgtm_diagnostics {\n");
                    int iR = y85VarM0.r();
                    n1(sb, 2, "upload_type", iR != 1 ? iR != 2 ? iR != 3 ? iR != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    n1(sb, 2, "client_upload_eligibility", qe4.t(y85VarM0.n()));
                    int iS = y85VarM0.s();
                    n1(sb, 2, "service_upload_eligibility", iS != 1 ? iS != 2 ? iS != 3 ? iS != 4 ? iS != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    h1(2, sb);
                    sb.append("}\n");
                }
                if (n85Var.Q()) {
                    r75 r75VarR = n85Var.R();
                    h1(2, sb);
                    sb.append("consent_info_extra {\n");
                    for (q75 q75Var : r75VarR.n()) {
                        h1(3, sb);
                        sb.append("limited_data_modes {\n");
                        int iO = q75Var.o();
                        n1(sb, 3, "type", iO != 1 ? iO != 2 ? iO != 3 ? iO != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int iP = q75Var.p();
                        n1(sb, 3, RtspHeaders.Values.MODE, iP != 1 ? iP != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        h1(3, sb);
                        sb.append("}\n");
                    }
                    h1(2, sb);
                    sb.append("}\n");
                }
                mc5<a95> mc5VarS1 = n85Var.S1();
                if (mc5VarS1 != null) {
                    for (a95 a95Var : mc5VarS1) {
                        if (a95Var != null) {
                            h1(2, sb);
                            sb.append("user_property {\n");
                            n1(sb, 2, "set_timestamp_millis", a95Var.n() ? Long.valueOf(a95Var.o()) : null);
                            n1(sb, 2, "name", k65Var.c(a95Var.p()));
                            n1(sb, 2, "string_value", a95Var.r());
                            n1(sb, 2, "int_value", a95Var.s() ? Long.valueOf(a95Var.t()) : null);
                            n1(sb, 2, "double_value", a95Var.w() ? Double.valueOf(a95Var.x()) : null);
                            h1(2, sb);
                            sb.append("}\n");
                        }
                    }
                }
                mc5<k75> mc5VarF = n85Var.F();
                if (mc5VarF != null) {
                    for (k75 k75Var : mc5VarF) {
                        if (k75Var != null) {
                            h1(2, sb);
                            sb.append("audience_membership {\n");
                            if (k75Var.n()) {
                                n1(sb, 2, "audience_id", Integer.valueOf(k75Var.o()));
                            }
                            if (k75Var.s()) {
                                n1(sb, 2, "new_audience", Boolean.valueOf(k75Var.t()));
                            }
                            m1(sb, "current_data", k75Var.p());
                            if (k75Var.q()) {
                                m1(sb, "previous_data", k75Var.r());
                            }
                            h1(2, sb);
                            sb.append("}\n");
                        }
                    }
                }
                List<w75> listN1 = n85Var.N1();
                if (listN1 != null) {
                    for (w75 w75Var : listN1) {
                        if (w75Var != null) {
                            h1(2, sb);
                            sb.append("event {\n");
                            n1(sb, 2, "name", k65Var.a(w75Var.q()));
                            if (w75Var.r()) {
                                n1(sb, 2, "timestamp_millis", Long.valueOf(w75Var.s()));
                            }
                            if (w75Var.t()) {
                                n1(sb, 2, "previous_timestamp_millis", Long.valueOf(w75Var.u()));
                            }
                            if (w75Var.v()) {
                                n1(sb, 2, "count", Integer.valueOf(w75Var.w()));
                            }
                            if (w75Var.o() != 0) {
                                f1(sb, 2, (mc5) w75Var.n());
                            }
                            h1(2, sb);
                            sb.append("}\n");
                        }
                    }
                }
                h1(1, sb);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    public String z1(m55 m55Var) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (m55Var.n()) {
            n1(sb, 0, "filter_id", Integer.valueOf(m55Var.o()));
        }
        n1(sb, 0, "property_name", ((k85) this.f).A0.c(m55Var.p()));
        String strJ1 = j1(m55Var.r(), m55Var.s(), m55Var.u());
        if (!strJ1.isEmpty()) {
            n1(sb, 0, "filter_type", strJ1);
        }
        g1(sb, 1, m55Var.q());
        sb.append("}\n");
        return sb.toString();
    }

    private final void q1() {
    }

    private final void r1() {
    }

    private final void s1() {
    }
}
