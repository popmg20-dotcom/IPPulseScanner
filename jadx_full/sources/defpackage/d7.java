package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Process;
import android.util.Log;
import android.view.View;
import androidx.work.WorkerParameters;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.ssl.ApplicationProtocolNames;
import io.sentry.android.core.a1;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d7 implements c7, ap, cd1, n90, hw4, mr4, xt, bf0, za1, s41, sq3 {
    public static volatile d7 f;
    public final /* synthetic */ int b;
    public static final d7 z = new d7(1);
    public static final d7 A = new d7(2);
    public static final d7 X = new d7(3);
    public static final d7 Y = new d7(4);
    public static final d7 Z = new d7(5);
    public static final d7 y0 = new d7(6);
    public static final d7 z0 = new d7(8);

    public /* synthetic */ d7(int i) {
        this.b = i;
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static lb i(Context context, String[] strArr, String str) {
        int i;
        String[] strArrR = r(context);
        int length = strArrR.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArrR[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                i = 5;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder("lib");
                            char c = File.separatorChar;
                            sb.append(c);
                            sb.append(str3);
                            sb.append(c);
                            sb.append(str);
                            String string = sb.toString();
                            ha1.A("Looking for %s in APK %s...", string, str2);
                            ZipEntry entry = zipFile.getEntry(string);
                            if (entry != null) {
                                lb lbVar = new lb(i, z2);
                                lbVar.f = zipFile;
                                lbVar.z = entry;
                                return lbVar;
                            }
                        }
                        i5 = i6;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
        }
    }

    public static ba3 k(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return ba3.HTTP_1_0;
        }
        if (str.equals(ApplicationProtocolNames.HTTP_1_1)) {
            return ba3.HTTP_1_1;
        }
        if (str.equals("h2_prior_knowledge")) {
            return ba3.H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals(ApplicationProtocolNames.HTTP_2)) {
            return ba3.HTTP_2;
        }
        if (str.equals(ApplicationProtocolNames.SPDY_3_1)) {
            return ba3.SPDY_3;
        }
        if (str.equals("quic")) {
            return ba3.QUIC;
        }
        if (w44.j0(str, "h3", false)) {
            return ba3.HTTP_3;
        }
        vp1.i("Unexpected protocol: ".concat(str));
        return null;
    }

    public static String[] m(Context context, String str) {
        StringBuilder sb = new StringBuilder("lib");
        char c = File.separatorChar;
        sb.append(c);
        sb.append("([^\\");
        sb.append(c);
        sb.append("]*)");
        sb.append(c);
        sb.append(str);
        Pattern patternCompile = Pattern.compile(sb.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : r(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public static w40 n(String str) {
        w40 w40Var = new w40(str);
        w40.d.put(str, w40Var);
        return w40Var;
    }

    public static qn3 o(String str, String str2) throws UnknownHostException {
        str.getClass();
        str2.getClass();
        if (w44.j0(str, "SSID:", false)) {
            return new nn3(p44.F0(str, "SSID:"), str2);
        }
        if (w44.j0(str, "BSSID:", false)) {
            return new kn3(p44.F0(str, "BSSID:"), str2);
        }
        if (w44.j0(str, "ROUTER:", false)) {
            String strF0 = p44.F0(str, "ROUTER:");
            if (!xz1.a(strF0)) {
                return null;
            }
            InetAddress byName = InetAddress.getByName(strF0);
            byName.getClass();
            return new mn3(byName, str2);
        }
        if (w44.j0(str, "TYPE:", false)) {
            try {
                return new pn3(on3.valueOf(p44.F0(str, "TYPE:")), str2);
            } catch (IllegalArgumentException unused) {
                String strConcat = "Invalid subnet TYPE: ".concat(str);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "Rule", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                }
                if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                    return null;
                }
                Log.d("Rule", strConcat, null);
                return null;
            }
        }
        if (!w44.j0(str, "MCCMNC:", false)) {
            return null;
        }
        try {
            List listK0 = p44.K0(p44.F0(str, "MCCMNC:"), new char[]{'-'}, 6);
            if (listK0.size() == 2) {
                return new ln3(Integer.parseInt((String) listK0.get(0)), Integer.parseInt((String) listK0.get(1)), str2);
            }
            throw new IllegalArgumentException("Failed requirement.");
        } catch (IllegalArgumentException unused2) {
            String strConcat2 = "Invalid subnet MCCMNC: ".concat(str);
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "Rule", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat2);
            }
            if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                return null;
            }
            Log.d("Rule", strConcat2, null);
            return null;
        }
    }

    public static cp1 p(kz kzVar, r90 r90Var) {
        wc1 wc1VarU;
        cp1 cp1Var = new cp1(21, kzVar);
        List list = (List) r90Var.d;
        ez4.o("ResolvedFeatureGroup", "resolveFeatureGroup: sessionConfig = " + r90Var + ", lensFacing = " + kzVar.i());
        Set set = (Set) r90Var.c;
        if (set.isEmpty() && list.isEmpty()) {
            return null;
        }
        List list2 = (List) r90Var.e;
        if (set.isEmpty() && list.isEmpty()) {
            xe.k("Must have at least one required or preferred feature");
            return null;
        }
        Iterator it = list2.iterator();
        while (true) {
            if (it.hasNext()) {
                in4 in4Var = (in4) it.next();
                qn4.f.getClass();
                if (d84.i(in4Var) == qn4.Z) {
                    wc1VarU = new uc1(in4Var);
                    break;
                }
            } else {
                Iterator it2 = set.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        vc1 vc1VarV = cp1.V((eq1) it2.next(), list2);
                        if (vc1VarV != null) {
                            wc1VarU = vc1VarV;
                            break;
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            vc1 vc1VarV2 = cp1.V((eq1) obj, list2);
                            if (vc1VarV2 != null) {
                                ez4.o("DefaultFeatureGroupResolver", "resolveFeatureGroup: filtered out preferred feature due to " + vc1VarV2);
                            } else {
                                vc1VarV2 = null;
                            }
                            if (vc1VarV2 == null) {
                                arrayList.add(obj);
                            }
                        }
                        ez4.o("DefaultFeatureGroupResolver", "resolveFeatureGroup: filteredPreferredFeatures = " + arrayList);
                        wc1VarU = cp1Var.U(r90Var, arrayList, 0, g41.b);
                    }
                }
            }
        }
        if (wc1VarU instanceof sc1) {
            cp1 cp1Var2 = ((sc1) wc1VarU).a;
            ez4.o("ResolvedFeatureGroup", "resolvedFeatureGroup = " + cp1Var2);
            return cp1Var2;
        }
        if (wc1VarU instanceof tc1) {
            xe.k("Feature group is not supported");
            return null;
        }
        if (wc1VarU instanceof uc1) {
            throw new IllegalArgumentException(((uc1) wc1VarU).a + " is not supported");
        }
        if (!(wc1VarU instanceof vc1)) {
            g.d();
            return null;
        }
        vc1 vc1Var = (vc1) wc1VarU;
        xe.r(vc1Var.a, " must be added for ", vc1Var.b);
        return null;
    }

    public static String[] r(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // defpackage.xt
    public byte[] a(int i, int i2, byte[] bArr) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public tc2 e(Context context, String str, WorkerParameters workerParameters) {
        str.getClass();
        workerParameters.getClass();
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str).asSubclass(tc2.class);
            clsAsSubclass.getClass();
            try {
                Object objNewInstance = clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                objNewInstance.getClass();
                tc2 tc2Var = (tc2) objNewInstance;
                if (!tc2Var.d) {
                    return tc2Var;
                }
                throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
            } catch (Throwable th) {
                ue2.g().f(mx4.a, "Could not instantiate ".concat(str), th);
                throw th;
            }
        } catch (Throwable th2) {
            ue2.g().f(mx4.a, "Invalid class: ".concat(str), th2);
            throw th2;
        }
    }

    @Override // defpackage.cd1
    public String f(String str, String str2) {
        n13 n13VarO = fx3.o(str);
        byte[] bArr = n13VarO != null ? n13VarO.b : null;
        if (bArr != null) {
            return gb4.c0(bArr);
        }
        g.g("can not find local policy path: ".concat(str2));
        return null;
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        Object objD = rk3Var.d(new fc3(xk4.class, Executor.class));
        objD.getClass();
        return n12.x((Executor) objD);
    }

    @Override // defpackage.ap
    public Rect h(Activity activity) throws Exception {
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            objInvoke.getClass();
            return new Rect((Rect) objInvoke);
        } catch (Exception e) {
            if (!(e instanceof NoSuchFieldException) && !(e instanceof NoSuchMethodException) && !(e instanceof IllegalAccessException) && !(e instanceof InvocationTargetException)) {
                throw e;
            }
            ap.d.getClass();
            a1.m(zo.b, e);
            return t60.A.h(activity);
        }
    }

    public synchronized w40 j(String str) {
        w40 w40Var;
        try {
            str.getClass();
            LinkedHashMap linkedHashMap = w40.d;
            w40Var = (w40) linkedHashMap.get(str);
            if (w40Var == null) {
                w40Var = (w40) linkedHashMap.get(w44.j0(str, "TLS_", false) ? "SSL_".concat(str.substring(4)) : w44.j0(str, "SSL_", false) ? "TLS_".concat(str.substring(4)) : str);
                if (w40Var == null) {
                    w40Var = new w40(str);
                }
                linkedHashMap.put(str, w40Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return w40Var;
    }

    @Override // defpackage.za1
    public w90 l(float f2, float f3, float f4) {
        return new w90(eh4.e(f3, f4, f2, DnsRecord.CLASS_ANY, 0), DnsRecord.CLASS_ANY, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0081 -> B:25:0x0064). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0084 -> B:25:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object q(List list, ti0 ti0Var, ie0 ie0Var) throws Throwable {
        mi0 mi0Var;
        List list2;
        Iterator it;
        bh3 bh3Var;
        Throwable th;
        if (ie0Var instanceof mi0) {
            mi0Var = (mi0) ie0Var;
            int i = mi0Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                mi0Var.y0 = i - Integer.MIN_VALUE;
            } else {
                mi0Var = new mi0(this, ie0Var);
            }
        }
        Object obj = mi0Var.Y;
        int i2 = mi0Var.y0;
        Object obj2 = mf0.b;
        if (i2 == 0) {
            n12.S(obj);
            ArrayList arrayList = new ArrayList();
            aj ajVar = new aj(list, arrayList, null);
            mi0Var.A = arrayList;
            mi0Var.y0 = 1;
            if (ti0Var.a(ajVar, mi0Var) != obj2) {
                list2 = arrayList;
            }
            return obj2;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            it = mi0Var.X;
            bh3Var = (bh3) mi0Var.A;
            try {
                n12.S(obj);
            } catch (Throwable th2) {
                Object obj3 = bh3Var.b;
                if (obj3 == null) {
                    bh3Var.b = th2;
                } else {
                    ek0.b((Throwable) obj3, th2);
                }
            }
            while (it.hasNext()) {
                am1 am1Var = (am1) it.next();
                mi0Var.A = bh3Var;
                mi0Var.X = it;
                mi0Var.y0 = 2;
                if (am1Var.g(mi0Var) == obj2) {
                    return obj2;
                }
            }
            th = (Throwable) bh3Var.b;
            if (th != null) {
                return xl4.a;
            }
            throw th;
        }
        list2 = (List) mi0Var.A;
        n12.S(obj);
        bh3 bh3Var2 = new bh3();
        it = list2.iterator();
        bh3Var = bh3Var2;
        while (it.hasNext()) {
        }
        th = (Throwable) bh3Var.b;
        if (th != null) {
        }
    }

    public String toString() {
        switch (this.b) {
            case 6:
                return "coil.request.NullRequestData";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.mr4
    public bv4 u(View view, bv4 bv4Var, nr4 nr4Var) {
        nr4Var.d = bv4Var.a() + nr4Var.d;
        boolean z2 = view.getLayoutDirection() == 1;
        int iB = bv4Var.b();
        int iC = bv4Var.c();
        int i = nr4Var.a + (z2 ? iC : iB);
        nr4Var.a = i;
        int i2 = nr4Var.c;
        if (!z2) {
            iB = iC;
        }
        int i3 = i2 + iB;
        nr4Var.c = i3;
        view.setPaddingRelative(i, nr4Var.b, i3, nr4Var.d);
        return bv4Var;
    }

    @Override // defpackage.hw4
    public int c(int i, int i2) {
        return i2;
    }

    @Override // defpackage.s41
    public int b(int i, int i2, byte[] bArr) {
        return i2;
    }

    @Override // defpackage.sq3
    public void onScrollLimit(int i, int i2, int i3, boolean z2) {
    }

    @Override // defpackage.sq3
    public void onScrollProgress(int i, int i2, int i3, int i4) {
    }
}
