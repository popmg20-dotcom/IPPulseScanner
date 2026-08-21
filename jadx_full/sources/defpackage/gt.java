package defpackage;

import android.app.ApplicationExitInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Network;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gt extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ Object Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gt(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Throwable {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                ((gt) n((ge0) obj2, (qc0) obj)).p(xl4Var);
                return xl4Var;
            case 2:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 6:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 7:
                ((gt) n((ge0) obj2, (ag1) obj)).p(xl4Var);
                return xl4Var;
            case 8:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 10:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.Y;
        switch (i) {
            case 0:
                return new gt((BypassConfigActivity) obj2, ge0Var, 0);
            case 1:
                return new gt((gx4) obj2, ge0Var, 1);
            case 2:
                return new gt((jv0) obj2, ge0Var, 2);
            case 3:
                return new gt((ApplicationExitInfo) obj2, ge0Var, 3);
            case 4:
                return new gt((Uri) obj2, ge0Var, 4);
            case 5:
                return new gt((HostsListActivity) obj2, ge0Var, 5);
            case 6:
                return new gt((Context) obj2, ge0Var, 6);
            case 7:
                return new gt((gn2) obj2, ge0Var, 7);
            case 8:
                return new gt((String[]) obj2, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new gt((e03[]) obj2, ge0Var, 9);
            case 10:
                return new gt((Network) obj2, ge0Var, 10);
            default:
                return new gt((jr4) obj2, ge0Var, 11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01bd  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        int i;
        int i2;
        qj0 qj0Var = null;
        switch (this.X) {
            case 0:
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) this.Y;
                n12.S(obj);
                try {
                    if (!t23.d("bypass_list_compatible_mode", false)) {
                        PackageManager packageManager = bypassConfigActivity.getPackageManager();
                        packageManager.getClass();
                        return k2.b(packageManager);
                    }
                    Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
                    intentAddCategory.getClass();
                    List<ResolveInfo> listQueryIntentActivities = bypassConfigActivity.getPackageManager().queryIntentActivities(intentAddCategory, 0);
                    listQueryIntentActivities.getClass();
                    ArrayList arrayList = new ArrayList(f70.Q(10, listQueryIntentActivities));
                    for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                        PackageManager packageManager2 = bypassConfigActivity.getPackageManager();
                        packageManager2.getClass();
                        String str = resolveInfo.activityInfo.packageName;
                        str.getClass();
                        arrayList.add(k2.e(packageManager2, str, 4096));
                    }
                    return arrayList;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return g41.b;
                }
            case 1:
                n12.S(obj);
                ue2.g().a(ic0.a, "Constraints changed for " + ((gx4) this.Y));
                return xl4.a;
            case 2:
                n12.S(obj);
                jv0 jv0Var = (jv0) this.Y;
                synchronized (jv0Var) {
                    if (!jv0Var.C0 || jv0Var.D0) {
                        return xl4.a;
                    }
                    try {
                        jv0Var.U();
                        break;
                    } catch (IOException unused) {
                        jv0Var.E0 = true;
                    }
                    try {
                        if (jv0Var.z0 >= 2000) {
                            jv0Var.Z();
                        }
                        break;
                    } catch (IOException unused2) {
                        jv0Var.F0 = true;
                        jv0Var.A0 = new ge3(new ln());
                    }
                    return xl4.a;
                }
            case 3:
                n12.S(obj);
                SimpleDateFormat simpleDateFormat = g81.a;
                return g81.d((ApplicationExitInfo) this.Y);
            case 4:
                n12.S(obj);
                ContentResolver contentResolver = ContextUtilsKt.getContext().getContentResolver();
                Uri uri = (Uri) this.Y;
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    try {
                        ko1.c.mkdirs();
                        File file = ko1.d;
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            l72.h(inputStreamOpenInputStream, fileOutputStream);
                            fileOutputStream.close();
                            qj0Var = new qj0(new eg0(file));
                            inputStreamOpenInputStream.close();
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } finally {
                        try {
                            throw th;
                        } catch (Throwable th) {
                            ez4.l(inputStreamOpenInputStream, th);
                        }
                    }
                } else {
                    st4.i(uri, "Failed to open input stream from ");
                }
                return qj0Var;
            case 5:
                n12.S(obj);
                List list = ((HostsListActivity) this.Y).W0.d.f;
                list.getClass();
                ArrayList arrayList2 = new ArrayList(list);
                ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(new Integer(((ls1) it.next()).b));
                }
                List listT0 = d70.t0(arrayList3);
                int i3 = 0;
                for (Object obj2 : arrayList2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        e70.P();
                        throw null;
                    }
                    ((ls1) obj2).b = ((Number) listT0.get(i3)).intValue();
                    i3 = i4;
                }
                os1 os1VarS = oj0.a.s();
                ke0.r(os1VarS.a, false, true, new gj(6, os1VarS, arrayList2));
                return xl4.a;
            case 6:
                n12.S(obj);
                File fileN = xb5.n((Context) this.Y);
                File file2 = fileN != null ? new File(fileN, "mini.hprof") : null;
                return Boolean.valueOf(file2 != null && file2.exists() && file2.length() > 0);
            case 7:
                n12.S(obj);
                return xl4.a;
            case 8:
                n12.S(obj);
                ArrayList<t53> arrayList4 = new ArrayList();
                for (String str2 : (String[]) this.Y) {
                    Serializable serializableJ = c63.j(str2, new FileInputStream(d73.g(str2)), pr1.A, d7.Y, wl3.X, null);
                    Throwable thA = uk3.a(serializableJ);
                    if (thA == null) {
                        e03 e03Var = (e03) serializableJ;
                        on2 on2Var = d73.c;
                        t53 t53Var = (t53) on2Var.d();
                        if (n12.c(t53Var != null ? t53Var.b : null, str2)) {
                            on2Var.i(e03Var.b);
                        }
                        arrayList4.add(e03Var.b);
                    } else {
                        String strU = fw.u("reloadProfilesLocally: ", str2, ", ", thA.getMessage());
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 4, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.e("ProfileManager", strU, null);
                        }
                    }
                }
                List list2 = (List) d73.b.d();
                if (list2 == null) {
                    return null;
                }
                ArrayList arrayList5 = new ArrayList(list2);
                boolean z = false;
                int i5 = 0;
                for (Object obj3 : arrayList5) {
                    int i6 = i5 + 1;
                    if (i5 < 0) {
                        e70.P();
                        throw null;
                    }
                    zk zkVar = (zk) obj3;
                    for (t53 t53Var2 : arrayList4) {
                        if (n12.c(zkVar.getName(), t53Var2.b)) {
                            arrayList5.set(i5, t53Var2);
                            z = true;
                        }
                    }
                    i5 = i6;
                }
                if (z) {
                    d73.b.i(arrayList5);
                }
                return xl4.a;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                n12.S(obj);
                e1 e1Var = d73.a;
                e03[] e03VarArr = (e03[]) this.Y;
                e03[] e03VarArr2 = (e03[]) Arrays.copyOf(e03VarArr, e03VarArr.length);
                String strConcat = "saveProfilesSync: ".concat(qe.o0(e03VarArr2, new ji(24), 31));
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ProfileManager", strConcat, null);
                }
                d73.k(true);
                Object objD = d73.b.d();
                objD.getClass();
                ArrayList arrayList6 = new ArrayList((Collection) objD);
                Throwable e2 = null;
                for (e03 e03Var2 : e03VarArr2) {
                    t53 t53Var3 = (t53) e03Var2.b;
                    String str3 = (String) e03Var2.f;
                    e1 e1Var2 = d73.a;
                    zk zkVarE = d73.e(t53Var3.b);
                    if (zkVarE instanceof t53) {
                        t53 t53Var4 = (t53) zkVarE;
                        if (t53Var4.f == t53Var3.f) {
                            String strN = ha0.n("skip saving profile because content not changed: ", t53Var3.b);
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("ProfileManager", strN, null);
                            }
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            File fileG = d73.g(t53Var3.b);
                            String str4 = t53Var3.b;
                            str4.getClass();
                            if (!d73.g(str4).exists()) {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(fileG);
                                try {
                                    byte[] bytes = str3.getBytes(y30.a);
                                    bytes.getClass();
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                                    try {
                                        l72.h(byteArrayInputStream, fileOutputStream2);
                                        byteArrayInputStream.close();
                                        fileOutputStream2.close();
                                    } finally {
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } finally {
                                    }
                                }
                            }
                            if (fileG.setLastModified(jCurrentTimeMillis)) {
                                t53 t53VarA = t53.a(t53Var4, null, 4194303);
                                t53VarA.M0 = jCurrentTimeMillis;
                                int iIndexOf = arrayList6.indexOf(zkVarE);
                                if (iIndexOf != -1) {
                                    arrayList6.set(iIndexOf, t53VarA);
                                } else {
                                    e2 = new IllegalArgumentException(ha0.o("can not find ", t53Var4.b, " in profile list"));
                                }
                            } else {
                                e2 = new IllegalArgumentException("set profile last modified failed");
                            }
                        } else {
                            String strN2 = ha0.n("saveProfile: ", t53Var3.b);
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN2);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("ProfileManager", strN2, null);
                            }
                            try {
                                ji0.w(t53Var3);
                                File fileG2 = d73.g(t53Var3.b);
                                File parentFile = fileG2.getParentFile();
                                int i7 = 8;
                                if ((parentFile == null || !parentFile.exists()) && !fileG2.mkdirs()) {
                                    String str5 = t53Var3.b;
                                    str5.getClass();
                                    ua3 ua3VarT = oj0.a.t();
                                    ua3VarT.getClass();
                                    ke0.r(ua3VarT.a, false, true, new ko0(str5, i7));
                                    e2 = new IllegalArgumentException("saveProfile mkdirs failed");
                                } else if (fileG2.exists() || fileG2.createNewFile()) {
                                    int iIndexOf2 = arrayList6.indexOf(zkVarE);
                                    if (iIndexOf2 != -1) {
                                        arrayList6.set(iIndexOf2, t53Var3);
                                    } else {
                                        arrayList6.add(t53Var3);
                                        h70.T(arrayList6, d73.a);
                                    }
                                    FileOutputStream fileOutputStream3 = new FileOutputStream(fileG2);
                                    try {
                                        byte[] bytes2 = str3.getBytes(y30.a);
                                        bytes2.getClass();
                                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bytes2);
                                        try {
                                            l72.h(byteArrayInputStream2, fileOutputStream3);
                                            byteArrayInputStream2.close();
                                            fileOutputStream3.close();
                                            Map mapX = yr2.x(new ha1(19, t53.n(t53Var3)));
                                            Bundle bundle = new Bundle();
                                            bundle.putInt("host_count", t53Var3.F0.size());
                                            bundle.putInt("rule_count", t53Var3.J0.size());
                                            bundle.putInt("policy_count", t53Var3.H0.size());
                                            ArrayList arrayList7 = t53Var3.J0;
                                            if ((arrayList7 != null) && arrayList7.isEmpty()) {
                                                i = 0;
                                            } else {
                                                Iterator it2 = arrayList7.iterator();
                                                i = 0;
                                                while (it2.hasNext()) {
                                                    if ((((tn3) it2.next()) instanceof jn3) && (i = i + 1) < 0) {
                                                        e70.O();
                                                        throw null;
                                                    }
                                                }
                                            }
                                            bundle.putInt("ruleset_count", i);
                                            ArrayList arrayList8 = t53Var3.J0;
                                            if ((arrayList8 != null) && arrayList8.isEmpty()) {
                                                i2 = 0;
                                            } else {
                                                Iterator it3 = arrayList8.iterator();
                                                i2 = 0;
                                                while (it3.hasNext()) {
                                                    if ((((tn3) it3.next()) instanceof om3) && (i2 = i2 + 1) < 0) {
                                                        e70.O();
                                                        throw null;
                                                    }
                                                }
                                            }
                                            bundle.putInt("domainset_count", i2);
                                            for (Map.Entry entry : ((LinkedHashMap) mapX).entrySet()) {
                                                bundle.putInt(((String) entry.getKey()) + "_count", ((Number) entry.getValue()).intValue());
                                            }
                                            e7.a(bundle, "save_profile");
                                        } catch (Throwable th3) {
                                            try {
                                                throw th3;
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                    } catch (Throwable th5) {
                                    }
                                } else {
                                    String str6 = t53Var3.b;
                                    str6.getClass();
                                    ua3 ua3VarT2 = oj0.a.t();
                                    ua3VarT2.getClass();
                                    ke0.r(ua3VarT2.a, false, true, new ko0(str6, i7));
                                    e2 = new IllegalArgumentException("saveProfile createNewFile failed");
                                }
                            } catch (Exception e3) {
                                e2 = e3;
                            }
                        }
                    }
                }
                d73.b.i(arrayList6);
                d73.k(false);
                if (e2 == null) {
                    return xl4.a;
                }
                throw e2;
            case 10:
                n12.S(obj);
                URLConnection uRLConnectionOpenConnection = ((Network) this.Y).openConnection(new URL("http://192.168.0.1/data.json"));
                uRLConnectionOpenConnection.setDoInput(true);
                uRLConnectionOpenConnection.connect();
                InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                try {
                    inputStream.getClass();
                    String strT = l72.T(new BufferedReader(new InputStreamReader(inputStream, y30.a), 8192));
                    inputStream.close();
                    return new JSONObject(strT);
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        ez4.l(inputStream, th6);
                        throw th7;
                    }
                }
            default:
                n12.S(obj);
                jr4 jr4Var = (jr4) this.Y;
                ir4 ir4Var = jr4Var.z;
                if (ir4Var != null) {
                    r92 r92Var = ir4Var.A;
                    ir4Var.X.g(null);
                    ty1 ty1Var = ir4Var.z;
                    if (ty1Var instanceof ca2) {
                        r92Var.c(ty1Var);
                    }
                    r92Var.c(ir4Var);
                }
                jr4Var.z = null;
                return xl4.a;
        }
    }
}
