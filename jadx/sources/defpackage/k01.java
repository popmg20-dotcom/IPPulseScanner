package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.RectF;
import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class k01 implements eo0, ed1, mn1, cd5, lp, yt, xy, rw1, hn0, ya1, gf1, pk3, xv0 {
    public static qe3 z0;
    public final /* synthetic */ int b;
    public static final k01 f = new k01(2);
    public static final k01 z = new k01(3);
    public static final k01 A = new k01(4);
    public static final k01 X = new k01(5);
    public static final hw2 Y = new hw2(1);
    public static final hw2 Z = new hw2(0);
    public static final k01 y0 = new k01(7);
    public static final k01 A0 = new k01(8);

    public /* synthetic */ k01(int i) {
        this.b = i;
    }

    public static void j(int i, int[] iArr, int i2, v92 v92Var) {
        boolean zG;
        int i3;
        up3 up3Var = (up3) v92Var.b;
        k0 k0Var = up3Var.c;
        fu fuVar = (fu) v92Var.f;
        fu fuVar2 = (fu) v92Var.z;
        dn dnVar = fuVar.b;
        if (fuVar2 == null) {
            zG = false;
        } else if (k0.i(i) == k0.i(iArr[0])) {
            zG = true;
        } else {
            zG = fuVar2.g(i, k0Var);
            if (fuVar2.h()) {
                zG = !zG;
            }
        }
        if (i2 != 1) {
            if (fuVar.g(i, k0Var)) {
                if (ja0.l && fuVar.h()) {
                    return;
                }
                j44 j44Var = null;
                for (int i4 = 0; i4 < i2; i4++) {
                    if (i4 == 0) {
                        j44Var = new j44();
                        j44Var.d |= 2;
                    }
                    j44Var.b(iArr[i4], k0Var);
                }
                bc2 bc2VarB = bc2.b(null, j44Var);
                bc2 bc2Var = (bc2) v92Var.X;
                if (bc2Var == null) {
                    v92Var.A = bc2VarB;
                } else {
                    bc2Var.b = bc2VarB;
                }
                v92Var.X = bc2VarB;
                return;
            }
            return;
        }
        boolean zG2 = fuVar.g(i, k0Var);
        int i5 = k0Var.b;
        if (ja0.l) {
            if (((!zG2 || fuVar.h()) && (zG2 || !fuVar.h())) || !zG) {
                return;
            }
            if (i5 <= 1 && (i3 = iArr[0]) < 256 && k0Var.g(i3) <= 1) {
                dnVar.g(iArr[0]);
                return;
            } else {
                int i6 = iArr[0];
                fuVar.d(up3Var, i6, i6, false);
                return;
            }
        }
        if (zG2 && zG) {
            if (i5 <= 1 && iArr[0] < 256) {
                if (fuVar.h()) {
                    dnVar.b(iArr[0]);
                    return;
                } else {
                    dnVar.g(iArr[0]);
                    return;
                }
            }
            if (fuVar.h() && fuVar.h()) {
                dnVar.c();
                if (!k0Var.z) {
                    fuVar.c = g20.i(up3Var, fuVar.c);
                }
                fuVar.a &= -2;
            }
            int i7 = iArr[0];
            fuVar.d(up3Var, i7, i7, false);
        }
    }

    public static void v(View view, String str, Uri uri, boolean z2, boolean z3) {
        view.getClass();
        str.getClass();
        uri.getClass();
        Intent intent = new Intent(view.getContext(), (Class<?>) ProfileEditorActivity.class);
        intent.setDataAndType(uri, HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE);
        intent.addFlags(1);
        intent.putExtra("name", str);
        intent.putExtra("gzip", z3);
        if (z2) {
            intent.addFlags(2);
        }
        view.getContext().startActivity(intent, l72.z(view));
    }

    @Override // defpackage.xy
    public nc2 X(boolean z2) {
        return zy1.z;
    }

    @Override // defpackage.yt
    public byte[] a(int i, int i2, byte[] bArr) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    @Override // defpackage.hn0
    public boolean b(SSLSocket sSLSocket) {
        return ib0.b && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // defpackage.ed1
    public String c(String str, String str2) throws IOException {
        str.getClass();
        str2.getClass();
        xn3 xn3VarE = tj4.E(str);
        if (xn3VarE != null) {
            if (System.currentTimeMillis() - xn3VarE.d > 86400000) {
                boolean z2 = nj3.a;
                (nj3.a ? nj3.f : nj3.e).a(new bd1(str2, new br1(str, 2)));
            }
            return gb4.c0(xn3VarE.b);
        }
        boolean z3 = nj3.a;
        String strB = nj3.b(str2, nj3.a);
        ez4.X("save_rule_set", new zc1(str, strB, 4));
        return strB;
    }

    @Override // defpackage.xy
    public ka0 c0() {
        return null;
    }

    @Override // defpackage.eo0
    public float d(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    @Override // defpackage.gf1
    public void e(RectF rectF, float f2, aw awVar) {
        rectF.bottom -= Math.abs(awVar.f - awVar.d) * f2;
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
        cr2.f(cr2.c, new ei0(i24.z, null));
    }

    @Override // defpackage.cd5
    public boolean g(Class cls) {
        return dc5.class.isAssignableFrom(cls);
    }

    @Override // defpackage.cd5
    public qd5 h(Class cls) {
        if (!dc5.class.isAssignableFrom(cls)) {
            xe.k("Unsupported message type: ".concat(cls.getName()));
            return null;
        }
        try {
            return (qd5) dc5.j(cls.asSubclass(dc5.class)).m(3);
        } catch (Exception e) {
            zo2.o("Unable to get message info for ".concat(cls.getName()), e);
            return null;
        }
    }

    @Override // defpackage.ya1
    public w90 l(float f2, float f3, float f4) {
        return new w90(fh4.e(f3, f4, f2, DnsRecord.CLASS_ANY, 0), fh4.e(f3, f4, f2, 0, DnsRecord.CLASS_ANY), false);
    }

    @Override // defpackage.rw1
    public String[] m() {
        switch (this.b) {
            case 13:
                return new String[]{"CLIPBOARD"};
            default:
                return new String[]{"RANDOM", "RANDOM_HEX", "UUID"};
        }
    }

    @Override // defpackage.gf1
    public boolean n(aw awVar) {
        return awVar.d > awVar.f;
    }

    @Override // defpackage.hn0
    public xy3 o(SSLSocket sSLSocket) {
        return new ib0();
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        String str = (String) obj;
        if (str == null || str.length() == 0) {
            cr2.f(cr2.c, new ei0(i24.z, null));
        } else if (xz1.a(str)) {
            cr2.f(cr2.c, new ei0(i24.f, str));
        } else {
            cr2.c(str);
        }
    }

    public SparseIntArray[] q() {
        return null;
    }

    @Override // defpackage.gf1
    public aw r(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float fD = fh4.d(f5, f7, f3, f4, f2, true);
        float f9 = fD / f5;
        float f10 = fD / f7;
        return new aw(f9, f10, fD, f6 * f9, fD, f8 * f10);
    }

    public Signature[] s(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public SparseIntArray[] t(Activity activity) {
        return null;
    }

    public String toString() {
        switch (this.b) {
            case 10:
                return "EMPTY";
            default:
                return super.toString();
        }
    }

    public SparseIntArray[] u() {
        return null;
    }

    public SparseIntArray[] w() {
        return null;
    }

    @Override // defpackage.xy
    public void N() {
    }

    @Override // defpackage.xy
    public void n0() {
    }

    @Override // defpackage.xy
    public void I(int i) {
    }

    @Override // defpackage.xy
    public void M(vx1 vx1Var) {
    }

    @Override // defpackage.xy
    public void Q(pt3 pt3Var) {
    }

    public void i(Activity activity) {
    }

    @Override // defpackage.xy
    public void x(ka0 ka0Var) {
    }

    @Override // defpackage.mn1
    public void k(int i, q60 q60Var) {
    }
}
