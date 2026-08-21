package defpackage;

import android.content.Context;
import android.graphics.RectF;
import android.os.Process;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pr1 implements bf0, ed1, fl2, bg, fg4, rw1, ne0, nw0, za1, hf1, e64, pk3, a73, s94 {
    public static final pr1 b = new pr1();
    public static final /* synthetic */ pr1 f = new pr1();
    public static final pr1 z = new pr1();
    public static final pr1 A = new pr1();
    public static final /* synthetic */ pr1 X = new pr1();
    public static final pr1 Y = new pr1();

    public static om3 o(List list, String str, String str2, boolean z2, boolean z3, String str3, int i) {
        List list2;
        boolean z4 = (i & 8) != 0 ? false : z2;
        boolean z5 = (i & 16) != 0 ? false : z3;
        String str4 = (i & 32) != 0 ? null : "RULE-SET";
        String absolutePath = (i & 64) != 0 ? "" : str3;
        str.getClass();
        str2.getClass();
        if (list.size() <= 1000) {
            n54 n54Var = new n54();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n54Var.a((String) it.next());
            }
            return new om3(str, str2, z4, z5, str4, n54Var.f, null, n54Var, 64);
        }
        if (absolutePath.length() == 0) {
            try {
                File file = new File(ContextUtilsKt.getContext().getFilesDir(), "sft");
                file.mkdirs();
                File file2 = new File(file, r25.K(str) + ".sft");
                if (file2.exists()) {
                    list2 = list;
                } else {
                    list2 = list;
                    try {
                        fx3.a(list2, file2);
                    } catch (Exception unused) {
                        String strT = fw.t(list2.size(), "Failed to build native suffix tree for ", str, ", falling back to in-memory tree (", " rules)");
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 3, "Rule", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strT);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.o("Rule", strT, null);
                        }
                        n54 n54Var2 = new n54();
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            n54Var2.a((String) it2.next());
                        }
                        return new om3(str, str2, z4, z5, str4, n54Var2.f, null, n54Var2, 64);
                    }
                }
                absolutePath = file2.getAbsolutePath();
                absolutePath.getClass();
            } catch (Exception unused2) {
                list2 = list;
            }
        } else {
            list2 = list;
        }
        return new om3(str, str2, z4, z5, str4, list2.size(), absolutePath, null, 128);
    }

    public static u03 q(String str) {
        str.getClass();
        bu buVar = f.a;
        hp hpVar = new hp();
        hpVar.Q0(str);
        return f.d(hpVar, false);
    }

    public static u03 r(File file) {
        String str = u03.f;
        String string = file.toString();
        string.getClass();
        return q(string);
    }

    public static rn2 v(FileInputStream fileInputStream) throws sf0 {
        byte[] bArr;
        try {
            z33 z33VarO = z33.o(fileInputStream);
            rn2 rn2Var = new rn2(false);
            v33[] v33VarArr = (v33[]) Arrays.copyOf(new v33[0], 0);
            rn2Var.b();
            if (v33VarArr.length > 0) {
                v33 v33Var = v33VarArr[0];
                throw null;
            }
            Map mapL = z33VarO.l();
            mapL.getClass();
            for (Map.Entry entry : mapL.entrySet()) {
                String str = (String) entry.getKey();
                d43 d43Var = (d43) entry.getValue();
                str.getClass();
                d43Var.getClass();
                int iU = d43Var.u();
                switch (iU == 0 ? -1 : w33.a[fw.G(iU)]) {
                    case -1:
                        throw new sf0("Value case is null.", null);
                    case 0:
                    default:
                        g.d();
                        return null;
                    case 1:
                        rn2Var.d(new u33(str), Boolean.valueOf(d43Var.l()));
                        break;
                    case 2:
                        rn2Var.d(new u33(str), Float.valueOf(d43Var.p()));
                        break;
                    case 3:
                        rn2Var.d(new u33(str), Double.valueOf(d43Var.o()));
                        break;
                    case 4:
                        rn2Var.d(new u33(str), Integer.valueOf(d43Var.q()));
                        break;
                    case 5:
                        rn2Var.d(new u33(str), Long.valueOf(d43Var.r()));
                        break;
                    case 6:
                        u33 u33Var = new u33(str);
                        String strS = d43Var.s();
                        strS.getClass();
                        rn2Var.d(u33Var, strS);
                        break;
                    case 7:
                        u33 u33Var2 = new u33(str);
                        h12 h12VarN = d43Var.t().n();
                        h12VarN.getClass();
                        rn2Var.d(u33Var2, d70.C0(h12VarN));
                        break;
                    case 8:
                        u33 u33Var3 = new u33(str);
                        au auVarM = d43Var.m();
                        int size = auVarM.size();
                        if (size == 0) {
                            bArr = j12.b;
                        } else {
                            byte[] bArr2 = new byte[size];
                            auVarM.d(size, bArr2);
                            bArr = bArr2;
                        }
                        bArr.getClass();
                        rn2Var.d(u33Var3, bArr);
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        throw new sf0("Value not set.", null);
                }
            }
            return new rn2(new LinkedHashMap(rn2Var.a()), true);
        } catch (t12 e) {
            throw new sf0("Unable to parse preferences proto.", e);
        }
    }

    public static void w(Object obj, zk4 zk4Var) {
        co1 co1VarA;
        Map mapA = ((rn2) obj).a();
        x33 x33VarN = z33.n();
        for (Map.Entry entry : mapA.entrySet()) {
            u33 u33Var = (u33) entry.getKey();
            Object value = entry.getValue();
            String str = u33Var.a;
            if (value instanceof Boolean) {
                c43 c43VarV = d43.v();
                boolean zBooleanValue = ((Boolean) value).booleanValue();
                c43VarV.c();
                ((d43) c43VarV.f).w(zBooleanValue);
                co1VarA = c43VarV.a();
            } else if (value instanceof Float) {
                c43 c43VarV2 = d43.v();
                float fFloatValue = ((Number) value).floatValue();
                c43VarV2.c();
                ((d43) c43VarV2.f).z(fFloatValue);
                co1VarA = c43VarV2.a();
            } else if (value instanceof Double) {
                c43 c43VarV3 = d43.v();
                double dDoubleValue = ((Number) value).doubleValue();
                c43VarV3.c();
                ((d43) c43VarV3.f).y(dDoubleValue);
                co1VarA = c43VarV3.a();
            } else if (value instanceof Integer) {
                c43 c43VarV4 = d43.v();
                int iIntValue = ((Number) value).intValue();
                c43VarV4.c();
                ((d43) c43VarV4.f).A(iIntValue);
                co1VarA = c43VarV4.a();
            } else if (value instanceof Long) {
                c43 c43VarV5 = d43.v();
                long jLongValue = ((Number) value).longValue();
                c43VarV5.c();
                ((d43) c43VarV5.f).B(jLongValue);
                co1VarA = c43VarV5.a();
            } else if (value instanceof String) {
                c43 c43VarV6 = d43.v();
                c43VarV6.c();
                ((d43) c43VarV6.f).C((String) value);
                co1VarA = c43VarV6.a();
            } else if (value instanceof Set) {
                c43 c43VarV7 = d43.v();
                a43 a43VarO = b43.o();
                a43VarO.c();
                ((b43) a43VarO.f).l((Set) value);
                c43VarV7.c();
                ((d43) c43VarV7.f).D((b43) a43VarO.a());
                co1VarA = c43VarV7.a();
            } else {
                if (!(value instanceof byte[])) {
                    xe.q("PreferencesSerializer does not support type: ".concat(value.getClass().getName()));
                    return;
                }
                c43 c43VarV8 = d43.v();
                byte[] bArr = (byte[]) value;
                au auVarC = au.c(0, bArr.length, bArr);
                c43VarV8.c();
                ((d43) c43VarV8.f).x(auVarC);
                co1VarA = c43VarV8.a();
            }
            x33VarN.getClass();
            str.getClass();
            x33VarN.c();
            ((z33) x33VarN.f).m().put(str, (d43) co1VarA);
        }
        z33 z33Var = (z33) x33VarN.a();
        int iA = z33Var.a(null);
        Logger logger = r60.f;
        if (iA > 4096) {
            iA = 4096;
        }
        r60 r60Var = new r60(zk4Var, iA);
        z33Var.b(r60Var);
        if (r60Var.d > 0) {
            r60Var.k();
        }
    }

    @Override // defpackage.e64
    public f64 b(a40 a40Var) {
        return new ll1((Context) a40Var.z, (String) a40Var.A, (t6) a40Var.X, a40Var.b, a40Var.f);
    }

    @Override // defpackage.ed1
    public String c(String str, String str2) throws IOException {
        xn3 xn3VarE = tj4.E(str);
        byte[] bArr = xn3VarE != null ? xn3VarE.b : null;
        if (bArr != null) {
            return gb4.c0(bArr);
        }
        g.g("can not find local rule set: ".concat(str2));
        return null;
    }

    @Override // defpackage.hf1
    public boolean d(aw awVar) {
        return awVar.d > awVar.f;
    }

    @Override // defpackage.nw0
    public List e(String str) throws UnknownHostException {
        str.getClass();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            allByName.getClass();
            return qe.s0(allByName);
        } catch (NullPointerException e) {
            UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
        cr2.f(cr2.c, new ei0(i24.z, null));
    }

    @Override // defpackage.ne0
    public void g(ev1 ev1Var, List list) {
        ev1Var.getClass();
    }

    @Override // defpackage.bg
    public cm2 h(em3 em3Var, kk3 kk3Var) {
        return null;
    }

    @Override // defpackage.hf1
    public aw i(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float fD = eh4.d(f5, f7, f3, f4, f2, true);
        float f9 = fD / f5;
        float f10 = fD / f7;
        return new aw(f9, f10, fD, f6 * f9, fD, f8 * f10);
    }

    @Override // defpackage.fl2
    public boolean i0(nk2 nk2Var) {
        return false;
    }

    @Override // defpackage.za1
    public w90 l(float f2, float f3, float f4) {
        return new w90(eh4.e(f3, f4, f2, DnsRecord.CLASS_ANY, 0), eh4.e(f3, f4, f2, 0, DnsRecord.CLASS_ANY), false);
    }

    @Override // defpackage.rw1
    public String[] m() {
        return new String[]{"LINE_COMMENT", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END"};
    }

    @Override // defpackage.hf1
    public void n(RectF rectF, float f2, aw awVar) {
        rectF.bottom -= Math.abs(awVar.f - awVar.d) * f2;
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        jSONObject.getClass();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("dns");
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("ip") : null;
        if (strOptString == null || strOptString.length() == 0) {
            cr2.f(cr2.c, new ei0(i24.z, null));
        } else if (xz1.a(strOptString)) {
            cr2.f(cr2.c, new ei0(i24.f, strOptString));
        } else {
            cr2.c(strOptString);
        }
    }

    @Override // defpackage.s94
    public e93 s() {
        return new od3();
    }

    @Override // defpackage.s94
    public e93 t(t94 t94Var, Class cls) {
        z94 z94Var = (z94) t94Var;
        if (z94Var.isEmpty()) {
            vp1.g();
            return null;
        }
        String string = z94Var.get(z94Var.size() - 1).toString();
        string.getClass();
        switch (string) {
            case "whileCaptures":
            case "endCaptures":
            case "captures":
            case "beginCaptures":
                return new kd3();
            case "repository":
                return new rd3();
            default:
                return List.class.isAssignableFrom(cls) ? new fe2() : new sd3();
        }
    }

    @Override // defpackage.ne0
    public List u(ev1 ev1Var) {
        ev1Var.getClass();
        return g41.b;
    }

    @Override // defpackage.a73
    public void j() {
    }

    @Override // defpackage.fl2
    public void a(nk2 nk2Var, boolean z2) {
    }

    @Override // defpackage.a73
    public void k(int i, Object obj) {
    }
}
