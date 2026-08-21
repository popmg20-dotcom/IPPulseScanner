package defpackage;

import android.net.Network;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z74 extends v74 implements Function2 {
    public String[] A0;
    public Collection B0;
    public String C0;
    public Collection D0;
    public boolean E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public final /* synthetic */ b84 N0;
    public final /* synthetic */ Network O0;
    public JSONObject X;
    public String Y;
    public String[] Z;
    public b84 y0;
    public Network z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z74(b84 b84Var, Network network, ge0 ge0Var) {
        super(2, ge0Var);
        this.N0 = b84Var;
        this.O0 = network;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((z74) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new z74(this.N0, this.O0, ge0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0275 A[Catch: Exception -> 0x02ac, TRY_LEAVE, TryCatch #3 {Exception -> 0x02ac, blocks: (B:84:0x0254, B:101:0x0275), top: B:130:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd A[Catch: Exception -> 0x005f, TryCatch #1 {Exception -> 0x005f, blocks: (B:13:0x004e, B:19:0x0087, B:22:0x009e, B:47:0x0139, B:49:0x0154, B:50:0x0160, B:23:0x00a3, B:32:0x00c9, B:34:0x00dd, B:36:0x0100, B:38:0x010e, B:40:0x0112, B:41:0x0116, B:44:0x012a, B:26:0x00b0, B:29:0x00c1), top: B:130:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154 A[Catch: Exception -> 0x005f, LOOP:0: B:48:0x0152->B:49:0x0154, LOOP_END, TryCatch #1 {Exception -> 0x005f, blocks: (B:13:0x004e, B:19:0x0087, B:22:0x009e, B:47:0x0139, B:49:0x0154, B:50:0x0160, B:23:0x00a3, B:32:0x00c9, B:34:0x00dd, B:36:0x0100, B:38:0x010e, B:40:0x0112, B:41:0x0116, B:44:0x012a, B:26:0x00b0, B:29:0x00c1), top: B:130:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x024b  */
    /* JADX WARN: Type inference failed for: r0v53, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v12, types: [ge0] */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.net.Network, b84, java.lang.String, java.lang.String[], java.util.Collection, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x022a -> B:15:0x0058). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        Object obj2;
        ?? r11;
        Object obj3;
        mf0 mf0Var;
        boolean zQ0;
        Object objB0;
        JSONObject jSONObject;
        String str;
        String str2;
        String string;
        tq1 tq1Var;
        gd gdVar;
        boolean zC;
        int length;
        String[] strArr;
        int i;
        Collection arrayList;
        String str3;
        b84 b84Var;
        String[] strArr2;
        Network network;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        Collection collection;
        String[] strArr3;
        b84 b84Var2;
        int i8;
        mf0 mf0Var2;
        Collection collection2;
        String str4;
        int i9;
        int i10;
        int i11;
        String[] strArr4;
        mf0 mf0Var3;
        ed4 ed4Var;
        b84 b84Var3;
        boolean z2;
        Network network2;
        Object objB02;
        Collection collection3;
        String str5;
        int i12;
        mf0 mf0Var4;
        int i13;
        int i14;
        Object objB03;
        mf0 mf0Var5 = mf0.b;
        try {
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        switch (this.M0) {
            case 0:
                obj2 = null;
                n12.S(obj);
                Network network3 = this.O0;
                this.M0 = 1;
                gm0 gm0Var = qv0.a;
                r11 = 0;
                try {
                    objB0 = ji0.b0(pl0.z, new gt(network3, null, 10), this);
                    if (objB0 == mf0Var5) {
                        return mf0Var5;
                    }
                    jSONObject = (JSONObject) objB0;
                    String str6 = "fetchDataJson: " + jSONObject;
                    if (fy4.b) {
                        str = "SwitchMediaImportDialogFragment";
                        str2 = str6;
                    } else {
                        Xlog.logWrite2(0L, 1, "SwitchMediaImportDialogFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                        str = "SwitchMediaImportDialogFragment";
                        str2 = str6;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d(str, str2, null);
                    }
                    string = jSONObject.getString("ConsoleName");
                    gm0 gm0Var2 = qv0.a;
                    tq1Var = qf2.a;
                    gdVar = new gd(this.N0, string, null, 19);
                    this.X = jSONObject;
                    this.Y = string;
                    this.M0 = 2;
                    if (ji0.b0(tq1Var, gdVar, this) == mf0Var5) {
                        return mf0Var5;
                    }
                    zC = n12.c(jSONObject.getString("FileType"), "photo");
                    JSONArray jSONArray = jSONObject.getJSONArray("FileNames");
                    length = jSONArray.length();
                    strArr = new String[length];
                    for (i = 0; i < length; i++) {
                        String string2 = jSONArray.getString(i);
                        string2.getClass();
                        strArr[i] = string2;
                    }
                    b84 b84Var4 = this.N0;
                    Network network4 = this.O0;
                    arrayList = new ArrayList(length);
                    str3 = string;
                    b84Var = b84Var4;
                    strArr2 = strArr;
                    network = network4;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    b84 b84Var5 = this.N0;
                    r92 lifecycle = b84Var5.getLifecycle();
                    q92 q92Var = q92.X;
                    gm0 gm0Var3 = qv0.a;
                    tq1 tq1Var2 = qf2.a.X;
                    cf0 cf0Var = this.f;
                    cf0Var.getClass();
                    zQ0 = tq1Var2.q0(cf0Var);
                    if (zQ0) {
                    }
                }
                if (i2 < length) {
                    try {
                        try {
                            try {
                                try {
                                    str5 = strArr[i2];
                                    gm0 gm0Var4 = qv0.a;
                                    tq1 tq1Var3 = qf2.a;
                                    uf ufVar = new uf(b84Var, str3, i5, strArr2, (ge0) null);
                                    this.X = null;
                                    this.Y = str3;
                                    this.Z = strArr2;
                                    this.y0 = b84Var;
                                    this.z0 = network;
                                    this.A0 = strArr;
                                    this.B0 = arrayList;
                                    this.C0 = str5;
                                    this.D0 = arrayList;
                                    this.E0 = zC;
                                    this.F0 = i3;
                                    this.G0 = i4;
                                    this.H0 = i12;
                                    this.I0 = i2;
                                    this.J0 = i13;
                                    this.K0 = i5;
                                    i14 = i3;
                                    this.L0 = 0;
                                    this.M0 = 3;
                                    objB03 = ji0.b0(tq1Var3, ufVar, this);
                                    mf0Var3 = mf0Var4;
                                } catch (Exception e4) {
                                    e = e4;
                                    obj3 = null;
                                    r11 = obj3;
                                    e.printStackTrace();
                                    b84 b84Var52 = this.N0;
                                    r92 lifecycle2 = b84Var52.getLifecycle();
                                    q92 q92Var2 = q92.X;
                                    gm0 gm0Var32 = qv0.a;
                                    tq1 tq1Var22 = qf2.a.X;
                                    cf0 cf0Var2 = this.f;
                                    cf0Var2.getClass();
                                    zQ0 = tq1Var22.q0(cf0Var2);
                                    if (zQ0) {
                                        kt ktVar = new kt(12, b84Var52, e);
                                        this.X = r11;
                                        this.Y = r11;
                                        this.Z = r11;
                                        this.y0 = r11;
                                        this.z0 = r11;
                                        this.A0 = r11;
                                        this.B0 = r11;
                                        this.C0 = r11;
                                        this.D0 = r11;
                                        this.F0 = 0;
                                        this.G0 = 0;
                                        this.E0 = zQ0;
                                        this.M0 = 6;
                                        if (ji0.V(lifecycle2, q92Var2, zQ0, tq1Var22, ktVar, this) == mf0Var5) {
                                            return mf0Var5;
                                        }
                                    } else {
                                        if (lifecycle2.b() == q92.b) {
                                            vp1.m();
                                            return obj2;
                                        }
                                        if (lifecycle2.b().compareTo(q92Var2) >= 0) {
                                            b84Var52.j(false, false);
                                            String message = e.getMessage();
                                            if (message == null) {
                                                message = b84Var52.getString(R.string.unknown_error);
                                                message.getClass();
                                            }
                                            p95.D(message);
                                        }
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                obj3 = null;
                                mf0Var = mf0Var4;
                                mf0Var5 = mf0Var;
                                r11 = obj3;
                                e.printStackTrace();
                                b84 b84Var522 = this.N0;
                                r92 lifecycle22 = b84Var522.getLifecycle();
                                q92 q92Var22 = q92.X;
                                gm0 gm0Var322 = qv0.a;
                                tq1 tq1Var222 = qf2.a.X;
                                cf0 cf0Var22 = this.f;
                                cf0Var22.getClass();
                                zQ0 = tq1Var222.q0(cf0Var22);
                                if (zQ0) {
                                }
                                return xl4.a;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            mf0Var = mf0Var4;
                            obj3 = null;
                            mf0Var5 = mf0Var;
                            r11 = obj3;
                            e.printStackTrace();
                            b84 b84Var5222 = this.N0;
                            r92 lifecycle222 = b84Var5222.getLifecycle();
                            q92 q92Var222 = q92.X;
                            gm0 gm0Var3222 = qv0.a;
                            tq1 tq1Var2222 = qf2.a.X;
                            cf0 cf0Var222 = this.f;
                            cf0Var222.getClass();
                            zQ0 = tq1Var2222.q0(cf0Var222);
                            if (zQ0) {
                            }
                            return xl4.a;
                        }
                        mf0Var4 = mf0Var5;
                        i13 = length;
                    } catch (Exception e7) {
                        e = e7;
                        mf0Var = mf0Var5;
                    }
                    i12 = i5 + 1;
                    if (objB03 != mf0Var3) {
                        i10 = i2;
                        str4 = str5;
                        collection2 = arrayList;
                        mf0Var2 = mf0Var3;
                        i9 = i13;
                        strArr3 = strArr;
                        i7 = i4;
                        strArr4 = strArr2;
                        i6 = i12;
                        collection = collection2;
                        b84Var2 = b84Var;
                        z = zC;
                        i11 = i14;
                        i8 = 0;
                        try {
                            ed4Var = b84Var2.I0;
                        } catch (Exception e8) {
                            e = e8;
                            mf0Var = mf0Var2;
                        }
                        if (ed4Var != null) {
                            mf0Var = mf0Var2;
                            try {
                                n12.T("binding");
                                throw null;
                            } catch (Exception e9) {
                                e = e9;
                                obj3 = null;
                                mf0Var5 = mf0Var;
                                r11 = obj3;
                                e.printStackTrace();
                                b84 b84Var52222 = this.N0;
                                r92 lifecycle2222 = b84Var52222.getLifecycle();
                                q92 q92Var2222 = q92.X;
                                gm0 gm0Var32222 = qv0.a;
                                tq1 tq1Var22222 = qf2.a.X;
                                cf0 cf0Var2222 = this.f;
                                cf0Var2222.getClass();
                                zQ0 = tq1Var22222.q0(cf0Var2222);
                                if (zQ0) {
                                }
                                return xl4.a;
                            }
                        }
                        try {
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ed4Var.z;
                            this.X = null;
                            this.Y = str3;
                            this.Z = strArr4;
                            this.y0 = b84Var2;
                            this.z0 = network;
                            this.A0 = strArr3;
                            this.B0 = collection;
                            this.C0 = null;
                            this.D0 = collection2;
                            this.E0 = z;
                            this.F0 = i11;
                            this.G0 = i7;
                            this.H0 = i6;
                            this.I0 = i10;
                            this.J0 = i9;
                            this.K0 = i5;
                            this.L0 = i8;
                            this.M0 = 4;
                            gm0 gm0Var5 = qv0.a;
                            b84Var3 = b84Var2;
                            z2 = z;
                            network2 = network;
                            objB02 = ji0.b0(pl0.z, new y74(b84Var3, z2, str4, network2, linearProgressIndicator, null), this);
                            mf0Var3 = mf0Var2;
                        } catch (Exception e10) {
                            e = e10;
                            mf0Var3 = mf0Var2;
                            mf0Var5 = mf0Var3;
                            r11 = 0;
                            e.printStackTrace();
                            b84 b84Var522222 = this.N0;
                            r92 lifecycle22222 = b84Var522222.getLifecycle();
                            q92 q92Var22222 = q92.X;
                            gm0 gm0Var322222 = qv0.a;
                            tq1 tq1Var222222 = qf2.a.X;
                            cf0 cf0Var22222 = this.f;
                            cf0Var22222.getClass();
                            zQ0 = tq1Var222222.q0(cf0Var22222);
                            if (zQ0) {
                            }
                            return xl4.a;
                        }
                        if (objB02 != mf0Var3) {
                            try {
                                collection3 = collection2;
                                b84Var = b84Var3;
                                network = network2;
                                collection3.add((Uri) objB02);
                                length = i9;
                                i2 = i10 + 1;
                                i3 = i11;
                                i5 = i;
                                mf0Var5 = mf0Var3;
                                zC = z2;
                            } catch (Exception e11) {
                                e = e11;
                                mf0Var5 = mf0Var3;
                                r11 = 0;
                                e.printStackTrace();
                                b84 b84Var5222222 = this.N0;
                                r92 lifecycle222222 = b84Var5222222.getLifecycle();
                                q92 q92Var222222 = q92.X;
                                gm0 gm0Var3222222 = qv0.a;
                                tq1 tq1Var2222222 = qf2.a.X;
                                cf0 cf0Var222222 = this.f;
                                cf0Var222222.getClass();
                                zQ0 = tq1Var2222222.q0(cf0Var222222);
                                if (zQ0) {
                                }
                                return xl4.a;
                            }
                            int i15 = i6;
                            i4 = i7;
                            arrayList = collection;
                            strArr2 = strArr4;
                            strArr = strArr3;
                            if (i2 < length) {
                                mf0 mf0Var6 = mf0Var5;
                                List list = (List) arrayList;
                                gm0 gm0Var6 = qv0.a;
                                tq1 tq1Var4 = qf2.a;
                                mf0Var5 = mf0Var6;
                                r11 = 0;
                                boolean z3 = zC;
                                i63 i63Var = new i63(this.N0, z3, list, r11, 1);
                                this.X = null;
                                this.Y = null;
                                this.Z = null;
                                this.y0 = null;
                                this.z0 = null;
                                this.A0 = null;
                                this.B0 = null;
                                this.C0 = null;
                                this.D0 = null;
                                this.E0 = z3;
                                this.M0 = 5;
                                if (ji0.b0(tq1Var4, i63Var, this) == mf0Var5) {
                                    return mf0Var5;
                                }
                                return xl4.a;
                            }
                        }
                        break;
                    }
                    return mf0Var3;
                }
                break;
            case 1:
                obj2 = null;
                n12.S(obj);
                objB0 = obj;
                jSONObject = (JSONObject) objB0;
                String str62 = "fetchDataJson: " + jSONObject;
                if (fy4.b) {
                }
                if (((Boolean) le2.a.a()).booleanValue()) {
                    Log.d(str, str2, null);
                }
                string = jSONObject.getString("ConsoleName");
                gm0 gm0Var22 = qv0.a;
                tq1Var = qf2.a;
                gdVar = new gd(this.N0, string, null, 19);
                this.X = jSONObject;
                this.Y = string;
                this.M0 = 2;
                if (ji0.b0(tq1Var, gdVar, this) == mf0Var5) {
                }
                zC = n12.c(jSONObject.getString("FileType"), "photo");
                JSONArray jSONArray2 = jSONObject.getJSONArray("FileNames");
                length = jSONArray2.length();
                strArr = new String[length];
                while (i < length) {
                }
                b84 b84Var42 = this.N0;
                Network network42 = this.O0;
                arrayList = new ArrayList(length);
                str3 = string;
                b84Var = b84Var42;
                strArr2 = strArr;
                network = network42;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                if (i2 < length) {
                }
                break;
            case 2:
                obj2 = null;
                string = this.Y;
                jSONObject = this.X;
                n12.S(obj);
                zC = n12.c(jSONObject.getString("FileType"), "photo");
                JSONArray jSONArray22 = jSONObject.getJSONArray("FileNames");
                length = jSONArray22.length();
                strArr = new String[length];
                while (i < length) {
                }
                b84 b84Var422 = this.N0;
                Network network422 = this.O0;
                arrayList = new ArrayList(length);
                str3 = string;
                b84Var = b84Var422;
                strArr2 = strArr;
                network = network422;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                if (i2 < length) {
                }
                break;
            case 3:
                obj2 = null;
                int i16 = this.L0;
                int i17 = this.K0;
                int i18 = this.J0;
                int i19 = this.I0;
                i6 = this.H0;
                i7 = this.G0;
                int i20 = this.F0;
                z = this.E0;
                Collection collection4 = this.D0;
                String str7 = this.C0;
                collection = this.B0;
                strArr3 = this.A0;
                network = this.z0;
                b84Var2 = this.y0;
                i8 = i16;
                String[] strArr5 = this.Z;
                String str8 = this.Y;
                n12.S(obj);
                mf0Var2 = mf0Var5;
                collection2 = collection4;
                str4 = str7;
                str3 = str8;
                i5 = i17;
                i9 = i18;
                i10 = i19;
                i11 = i20;
                strArr4 = strArr5;
                ed4Var = b84Var2.I0;
                if (ed4Var != null) {
                }
                break;
            case 4:
                i9 = this.J0;
                i10 = this.I0;
                i6 = this.H0;
                i7 = this.G0;
                int i21 = this.F0;
                boolean z4 = this.E0;
                collection3 = this.D0;
                collection = this.B0;
                strArr3 = this.A0;
                network = this.z0;
                obj2 = null;
                b84 b84Var6 = this.y0;
                strArr4 = this.Z;
                str3 = this.Y;
                n12.S(obj);
                objB02 = obj;
                z2 = z4;
                b84Var = b84Var6;
                i11 = i21;
                mf0Var3 = mf0Var5;
                int i152 = i6;
                i4 = i7;
                arrayList = collection;
                strArr2 = strArr4;
                strArr = strArr3;
                collection3.add((Uri) objB02);
                length = i9;
                i2 = i10 + 1;
                i3 = i11;
                i5 = i152;
                mf0Var5 = mf0Var3;
                zC = z2;
                if (i2 < length) {
                }
                break;
            case 5:
                try {
                    n12.S(obj);
                    break;
                } catch (Exception e12) {
                    e = e12;
                    obj2 = null;
                    r11 = 0;
                    e.printStackTrace();
                    b84 b84Var52222222 = this.N0;
                    r92 lifecycle2222222 = b84Var52222222.getLifecycle();
                    q92 q92Var2222222 = q92.X;
                    gm0 gm0Var32222222 = qv0.a;
                    tq1 tq1Var22222222 = qf2.a.X;
                    cf0 cf0Var2222222 = this.f;
                    cf0Var2222222.getClass();
                    zQ0 = tq1Var22222222.q0(cf0Var2222222);
                    if (zQ0) {
                    }
                }
                return xl4.a;
            case 6:
                n12.S(obj);
                return xl4.a;
            default:
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
