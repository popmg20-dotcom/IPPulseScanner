package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.CamcorderProfile;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.google.firebase.components.ComponentRegistrar;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLSocket;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vd3 implements ap, bf0, ad1, n90, hn0, fg, xt, bw, gr2, ya1, gf1, jm1, pk3, a73, s94 {
    public static volatile vd3 z0;
    public final /* synthetic */ int b;
    public static final vd3 f = new vd3(1);
    public static final /* synthetic */ vd3 z = new vd3(2);
    public static final vd3 A = new vd3(3);
    public static final vd3 X = new vd3(4);
    public static final vd3 Y = new vd3(5);
    public static final vd3 Z = new vd3(6);
    public static final vd3 y0 = new vd3(7);

    public vd3(xx1 xx1Var) {
        this.b = 21;
    }

    @Override // defpackage.xt
    public byte[] a(int i, int i2, byte[] bArr) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    @Override // defpackage.hn0
    public boolean b(SSLSocket sSLSocket) {
        return w44.j0(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // defpackage.fg
    public void c(gl1 gl1Var) {
        gl1Var.getClass();
        gl1Var.C("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
        int i = 0;
        Object[] objArr = new Object[0];
        if (contentValues.size() == 0) {
            xe.k("Empty values");
            return;
        }
        int size = contentValues.size();
        int length = objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(gl1.f[3]);
        sb.append("WorkSpec SET ");
        int i2 = 0;
        for (String str : contentValues.keySet()) {
            sb.append(i2 > 0 ? "," : "");
            sb.append(str);
            objArr2[i2] = contentValues.get(str);
            sb.append("=?");
            i2++;
        }
        for (int i3 = size; i3 < length; i3++) {
            objArr2[i3] = objArr[i3 - size];
        }
        if (!TextUtils.isEmpty("last_enqueue_time = 0 AND interval_duration <> 0 ")) {
            sb.append(" WHERE last_enqueue_time = 0 AND interval_duration <> 0 ");
        }
        nl1 nl1VarS = gl1Var.s(sb.toString());
        while (i < length) {
            Object obj = objArr2[i];
            i++;
            if (obj == null) {
                nl1VarS.l(i);
            } else if (obj instanceof byte[]) {
                nl1VarS.b.bindBlob(i, (byte[]) obj);
            } else if (obj instanceof Float) {
                nl1VarS.z(i, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                nl1VarS.z(i, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                nl1VarS.j(i, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                nl1VarS.j(i, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                nl1VarS.j(i, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                nl1VarS.j(i, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                nl1VarS.b.bindString(i, (String) obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
                nl1VarS.j(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
            }
        }
        nl1VarS.f.executeUpdateDelete();
    }

    @Override // defpackage.bw
    public CamcorderProfile d(int i, int i2) {
        return CamcorderProfile.get(i, i2);
    }

    @Override // defpackage.gf1
    public void e(RectF rectF, float f2, aw awVar) {
        float fAbs = (Math.abs(awVar.e - awVar.c) / 2.0f) * f2;
        rectF.left += fAbs;
        rectF.right -= fAbs;
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
        cr2.f(cr2.c, new ei0(i24.z, null));
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        Object objD = rk3Var.d(new fc3(bi.class, Executor.class));
        objD.getClass();
        return n12.x((Executor) objD);
    }

    @Override // defpackage.ap
    public Rect h(Activity activity) {
        int i;
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getClass();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Rect rect = new Rect();
        int i2 = point.x;
        if (i2 == 0 || (i = point.y) == 0) {
            defaultDisplay.getRectSize(rect);
            return rect;
        }
        rect.right = i2;
        rect.bottom = i;
        return rect;
    }

    @Override // defpackage.gr2
    public boolean i() {
        return true;
    }

    @Override // defpackage.a73
    public void j() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // defpackage.a73
    public void k(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            a1.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    @Override // defpackage.ya1
    public w90 l(float f2, float f3, float f4) {
        switch (this.b) {
            case 17:
                return new w90(DnsRecord.CLASS_ANY, fh4.e(f3, f4, f2, 0, DnsRecord.CLASS_ANY), true);
            default:
                float fH = ha0.h(f4, f3, 0.35f, f3);
                return new w90(fh4.e(f3, fH, f2, DnsRecord.CLASS_ANY, 0), fh4.e(fH, f4, f2, 0, DnsRecord.CLASS_ANY), false);
        }
    }

    @Override // defpackage.ad1
    public String m(String str, String str2) throws IOException {
        str.getClass();
        str2.getClass();
        hx0 hx0VarQ = vo.q(str);
        if (hx0VarQ != null) {
            if (System.currentTimeMillis() - hx0VarQ.d > 86400000) {
                boolean z2 = nj3.a;
                (nj3.a ? nj3.f : nj3.e).a(new bd1(str2, new sh1(str, 1)));
            }
            return gb4.c0(hx0VarQ.b);
        }
        boolean z3 = nj3.a;
        String strB = nj3.b(str2, nj3.a);
        ez4.X("save_domain_set", new zc1(str, strB, 0));
        return strB;
    }

    @Override // defpackage.gf1
    public boolean n(aw awVar) {
        return awVar.c > awVar.e;
    }

    @Override // defpackage.hn0
    public xy3 o(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                xe.i(dw2.B(cls, "No OpenSSLSocketImpl superclass of socket of type "));
                return null;
            }
        }
        return new a8(superclass);
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        String str = (String) obj;
        if (str == null || str.length() == 0) {
            cr2.f(cr2.c, new ei0(i24.z, null));
        } else {
            cr2.f(cr2.c, new ei0(i24.f, str));
        }
    }

    @Override // defpackage.bw
    public boolean q(int i, int i2) {
        return CamcorderProfile.hasProfile(i, i2);
    }

    @Override // defpackage.gf1
    public aw r(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float fD = fh4.d(f6, f8, f3, f4, f2, true);
        float f9 = fD / f6;
        float f10 = fD / f8;
        return new aw(f9, f10, f5 * f9, fD, f7 * f10, fD);
    }

    @Override // defpackage.s94
    public e93 s() {
        return new td3();
    }

    @Override // defpackage.s94
    public e93 t(t94 t94Var, Class cls) {
        return List.class.isAssignableFrom(cls) ? new fe2() : new td3();
    }

    public String toString() {
        switch (this.b) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return "chacha20-poly1305";
            case 29:
                return "SharingStarted.Eagerly";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object u(String str, String str2, String str3, long j, ie0 ie0Var) throws x53 {
        u63 u63Var;
        String str4;
        gm0 gm0Var;
        String message;
        if (ie0Var instanceof u63) {
            u63Var = (u63) ie0Var;
            int i = u63Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                u63Var.Z = i - Integer.MIN_VALUE;
            } else {
                u63Var = new u63(this, ie0Var);
            }
        }
        Object objB0 = u63Var.X;
        mf0 mf0Var = mf0.b;
        int i2 = u63Var.Z;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                String str5 = u63Var.A;
                try {
                    n12.S(objB0);
                    str4 = str5;
                    return ((uk3) objB0).b;
                } catch (Exception e) {
                    e = e;
                    str4 = str5;
                    message = e.getMessage();
                    if (message == null) {
                    }
                    throw new x53(message, str4, e);
                }
            }
            n12.S(objB0);
            long j2 = 20 * j;
            long j3 = j2 < 60000 ? 60000L : j2;
            StringBuilder sbC = fw.C("decodeRawContent: httpTimeout=", "ms, decodeTimeout=", j);
            sbC.append(j3);
            sbC.append("ms (");
            sbC.append(j3 / 1000);
            sbC.append("s)");
            String string = sbC.toString();
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ProfileFetcher", string, null);
            }
            try {
                gm0Var = qv0.a;
                str4 = str2;
            } catch (Exception e2) {
                e = e2;
                str4 = str2;
                message = e.getMessage();
                if (message == null) {
                    message = "decode failed";
                }
                throw new x53(message, str4, e);
            }
            try {
                v63 v63Var = new v63(j3, str4, str, str3, null);
                u63Var.A = str4;
                u63Var.Z = 1;
                objB0 = ji0.b0(gm0Var, v63Var, u63Var);
                if (objB0 == mf0Var) {
                    return mf0Var;
                }
                return ((uk3) objB0).b;
            } catch (Exception e3) {
                e = e3;
                message = e.getMessage();
                if (message == null) {
                }
                throw new x53(message, str4, e);
            }
        } catch (CancellationException e4) {
            throw e4;
        } catch (x53 e5) {
            throw e5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object v(String str, String str2, boolean z2, long j, ie0 ie0Var) {
        w63 w63Var;
        vd3 vd3Var;
        String str3;
        String str4;
        boolean z3;
        String str5;
        long j2;
        if (ie0Var instanceof w63) {
            w63Var = (w63) ie0Var;
            int i = w63Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                w63Var.z0 = i - Integer.MIN_VALUE;
                vd3Var = this;
            } else {
                vd3Var = this;
                w63Var = new w63(vd3Var, ie0Var);
            }
        }
        w63 w63Var2 = w63Var;
        Object obj = w63Var2.Z;
        mf0 mf0Var = mf0.b;
        int i2 = w63Var2.z0;
        try {
            if (i2 != 0) {
                if (i2 == 1) {
                    n12.S(obj);
                } else if (i2 == 2) {
                    n12.S(obj);
                } else if (i2 == 3) {
                    j2 = w63Var2.Y;
                    z3 = w63Var2.X;
                    String str6 = w63Var2.A;
                    n12.S(obj);
                    str5 = str6;
                } else {
                    if (i2 != 4) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return ((uk3) obj).b;
            }
            n12.S(obj);
            List listE = s63.e(str);
            if (!listE.isEmpty()) {
                LinkedHashMap linkedHashMapA = s63.a(listE);
                String strD = g73.d("Profile");
                k01 k01Var = k01.A;
                t60 t60Var = t60.Y;
                vd3 vd3Var2 = A;
                w63Var2.A = null;
                w63Var2.X = z2;
                w63Var2.Y = j;
                w63Var2.z0 = 1;
                Object objC = s63.c(strD, null, linkedHashMapA, k01Var, t60Var, vd3Var2, w63Var2);
                if (objC != mf0Var) {
                    return objC;
                }
            } else if (xj.c(str)) {
                String strA = xj.a(0, str);
                w63Var2.A = null;
                w63Var2.X = z2;
                w63Var2.Y = j;
                w63Var2.z0 = 2;
                Object objV = vd3Var.v(strA, str2, z2, j, w63Var2);
                if (objV != mf0Var) {
                    return objV;
                }
            } else {
                String strH = s63.h(str);
                if (p44.B0(strH).size() > 1) {
                    throw new t63();
                }
                String str7 = "start fetch profile from '" + strH + "'";
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str7);
                    str3 = "ProfileFetcher";
                    str4 = str7;
                } else {
                    str3 = "ProfileFetcher";
                    str4 = str7;
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d(str3, str4, null);
                }
                String strB = str2 == null ? g73.b(strH) : str2;
                w63Var2.A = strH;
                w63Var2.X = z2;
                w63Var2.Y = j;
                w63Var2.z0 = 3;
                Object objW = w(strB, strH, z2, j, w63Var2);
                w63Var2 = w63Var2;
                if (objW != mf0Var) {
                    z3 = z2;
                    obj = objW;
                    str5 = strH;
                    j2 = j;
                }
            }
            md3 md3Var = (md3) obj;
            String str8 = md3Var.c;
            String strD2 = (z3 || str8 == null) ? md3Var.a : g73.d(str8);
            String str9 = md3Var.b;
            w63Var2.A = null;
            w63Var2.X = z3;
            w63Var2.Y = j2;
            w63Var2.z0 = 4;
            Object objU = u(strD2, str9, str5, j2, w63Var2);
            return objU == mf0Var ? mf0Var : objU;
        } catch (Exception e) {
            e.printStackTrace();
            return new tk3(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e A[EDGE_INSN: B:96:0x015e->B:79:0x015e BREAK  A[LOOP:2: B:57:0x00ff->B:98:?]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object w(String str, String str2, boolean z2, long j, ie0 ie0Var) throws UnsupportedEncodingException {
        x63 x63Var;
        String str3;
        boolean z3;
        String strDecode;
        List list;
        String str4;
        Object next;
        String str5;
        Object next2;
        String str6;
        String str7;
        if (ie0Var instanceof x63) {
            x63Var = (x63) ie0Var;
            int i = x63Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                x63Var.y0 = i - Integer.MIN_VALUE;
            } else {
                x63Var = new x63(this, ie0Var);
            }
        }
        Object objX = x63Var.Y;
        mf0 mf0Var = mf0.b;
        int i2 = x63Var.y0;
        int i3 = 1;
        ge0 ge0Var = null;
        if (i2 == 0) {
            n12.S(objX);
            jo1 jo1Var = new jo1(str2, ge0Var, i3);
            x63Var.A = str;
            x63Var.X = z2;
            x63Var.y0 = 1;
            objX = r25.X(j, jo1Var, x63Var);
            if (objX == mf0Var) {
                return mf0Var;
            }
            str3 = str;
            z3 = z2;
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            z3 = x63Var.X;
            str3 = x63Var.A;
            n12.S(objX);
        }
        yu1 yu1Var = (yu1) objX;
        if (z3 || (list = (List) yu1Var.b.get("content-disposition")) == null || (str4 = (String) d70.e0(list)) == null) {
            strDecode = null;
        } else {
            List listL0 = p44.L0(str4, new String[]{";"}, 6);
            if (!listL0.isEmpty()) {
                Iterator it = listL0.iterator();
                while (it.hasNext()) {
                    if (p44.o0((String) it.next(), "filename*=", false)) {
                        Iterator it2 = listL0.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it2.next();
                            if (p44.o0((String) next2, "filename*=", false)) {
                                break;
                            }
                        }
                        String str8 = (String) next2;
                        String strG0 = (str8 == null || (str6 = (String) d70.f0(1, p44.L0(str8, new String[]{"filename*="}, 6))) == null || (str7 = (String) d70.l0(p44.K0(str6, new char[]{'\''}, 6))) == null) ? null : p44.G0(".conf", str7);
                        if (strG0 != null && !p44.x0(strG0)) {
                            strDecode = URLDecoder.decode(strG0, "utf-8");
                        }
                    }
                }
                if (listL0.isEmpty()) {
                }
            } else if (listL0.isEmpty()) {
                Iterator it3 = listL0.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (p44.o0((String) it3.next(), "filename=", false)) {
                        Iterator it4 = listL0.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it4.next();
                            if (p44.o0((String) next, "filename=", false)) {
                                break;
                            }
                        }
                        String str9 = (String) next;
                        String strG02 = (str9 == null || (str5 = (String) d70.f0(1, p44.L0(str9, new String[]{"filename="}, 6))) == null) ? null : p44.G0(".conf", p44.G0("\"", p44.F0(str5, "\"")));
                        if (strG02 == null || p44.x0(strG02)) {
                            break;
                        }
                        strDecode = URLDecoder.decode(strG02, "utf-8");
                    }
                }
                strDecode = null;
            }
        }
        String strV = fw.v("fetched profile '", str3, "', remoteName='", strDecode, "'");
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strV);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileFetcher", strV, null);
        }
        return new md3(str3, yu1Var.a, strDecode);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object x(String str, ie0 ie0Var) {
        y63 y63Var;
        long j;
        xl4 xl4Var = xl4.a;
        if (ie0Var instanceof y63) {
            y63Var = (y63) ie0Var;
            int i = y63Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                y63Var.Z = i - Integer.MIN_VALUE;
            } else {
                y63Var = new y63(this, ie0Var);
            }
        }
        Object obj = y63Var.X;
        mf0 mf0Var = mf0.b;
        int i2 = y63Var.Z;
        ge0 ge0Var = null;
        if (i2 == 0) {
            n12.S(obj);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            uh3 uh3Var = new uh3("(DOMAIN-SET|RULE-SET)\\s*[,:]\\s*(https?://[^\\s,]+)");
            str.getClass();
            if (str.length() < 0) {
                throw new IndexOutOfBoundsException("Start index out of bounds: 0, input length: " + str.length());
            }
            fo1 fo1Var = new fo1(new go1(new qi(8, uh3Var, str), sh3.y0, 0));
            while (fo1Var.hasNext()) {
                uh2 uh2Var = (uh2) fo1Var.next();
                String str2 = (String) ((sh2) uh2Var.a()).get(1);
                String str3 = (String) ((sh2) uh2Var.a()).get(2);
                if (n12.c(str2, "DOMAIN-SET")) {
                    arrayList.add(str3);
                } else if (n12.c(str2, "RULE-SET")) {
                    arrayList2.add(str3);
                }
            }
            int size = arrayList2.size() + arrayList.size();
            if (size != 0) {
                String strW = fw.w(" DOMAIN-SET)", fw.A(size, arrayList2.size(), "prefetchExternalResources: ", " resources (", " RULE-SET + "), arrayList.size());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strW);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ProfileFetcher", strW, null);
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                uf ufVar = new uf(arrayList, arrayList2, ge0Var, 19);
                y63Var.A = jCurrentTimeMillis;
                y63Var.Z = 1;
                if (p95.h(ufVar, y63Var) == mf0Var) {
                    return mf0Var;
                }
                j = jCurrentTimeMillis;
            }
            return xl4Var;
        }
        if (i2 != 1) {
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        j = y63Var.A;
        n12.S(obj);
        String str4 = "prefetchExternalResources DONE: " + (System.currentTimeMillis() - j) + "ms";
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileFetcher", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileFetcher", str4, null);
        }
        return xl4Var;
    }

    public List y(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (x80 x80Var : componentRegistrar.getComponents()) {
            String str = x80Var.a;
            if (str != null) {
                x80Var = new x80(str, x80Var.b, x80Var.c, x80Var.d, x80Var.e, new ed(3, str, x80Var), x80Var.g);
            }
            arrayList.add(x80Var);
        }
        return arrayList;
    }

    public /* synthetic */ vd3(int i) {
        this.b = i;
    }

    @Override // defpackage.gr2
    public void shutdown() {
    }

    @Override // defpackage.jm1
    public Object apply(Object obj) {
        return obj;
    }
}
