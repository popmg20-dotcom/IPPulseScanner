package defpackage;

import android.app.Activity;
import android.content.ContentValues;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import com.google.firebase.components.ComponentRegistrar;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, defpackage.ie0 r34) throws defpackage.x53 {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd3.u(java.lang.String, java.lang.String, java.lang.String, long, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object v(java.lang.String r28, java.lang.String r29, boolean r30, long r31, defpackage.ie0 r33) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd3.v(java.lang.String, java.lang.String, boolean, long, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e A[EDGE_INSN: B:96:0x015e->B:79:0x015e BREAK  A[LOOP:2: B:57:0x00ff->B:98:?]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object w(java.lang.String r21, java.lang.String r22, boolean r23, long r24, defpackage.ie0 r26) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd3.w(java.lang.String, java.lang.String, boolean, long, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x(java.lang.String r24, defpackage.ie0 r25) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vd3.x(java.lang.String, ie0):java.lang.Object");
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
