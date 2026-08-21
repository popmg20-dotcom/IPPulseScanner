package defpackage;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class p84 implements fg4, n90, c35, wz0, xz0 {
    public static p84 f;
    public final /* synthetic */ int b;
    public static final /* synthetic */ p84 z = new p84(5);
    public static final /* synthetic */ p84 A = new p84(6);
    public static final /* synthetic */ p84 X = new p84(7);
    public static final /* synthetic */ p84 Y = new p84(8);
    public static final /* synthetic */ p84 Z = new p84(9);
    public static final /* synthetic */ p84 y0 = new p84(10);
    public static final /* synthetic */ p84 z0 = new p84(11);
    public static final /* synthetic */ p84 A0 = new p84(12);
    public static final /* synthetic */ p84 B0 = new p84(13);
    public static final /* synthetic */ p84 C0 = new p84(14);
    public static final /* synthetic */ p84 D0 = new p84(15);
    public static final /* synthetic */ p84 E0 = new p84(16);
    public static final /* synthetic */ p84 F0 = new p84(17);
    public static final /* synthetic */ p84 G0 = new p84(18);
    public static final /* synthetic */ p84 H0 = new p84(19);
    public static final /* synthetic */ p84 I0 = new p84(20);
    public static final /* synthetic */ p84 J0 = new p84(22);
    public static final /* synthetic */ p84 K0 = new p84(23);
    public static final /* synthetic */ p84 L0 = new p84(24);

    public /* synthetic */ p84(int i) {
        this.b = i;
    }

    public static RectF d(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.Y0 || !(view instanceof ga4)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        ga4 ga4Var = (ga4) view;
        int contentWidth = ga4Var.getContentWidth();
        int contentHeight = ga4Var.getContentHeight();
        int iY = (int) tj4.y(ga4Var.getContext(), 24);
        if (contentWidth < iY) {
            contentWidth = iY;
        }
        int right = (ga4Var.getRight() + ga4Var.getLeft()) / 2;
        int bottom = (ga4Var.getBottom() + ga4Var.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    @Override // defpackage.c35
    public Object a() {
        switch (this.b) {
            case 6:
                List list = r55.a;
                af5.f.get();
                Long l = (Long) df5.b.b();
                l.getClass();
                return l;
            case 7:
                List list2 = r55.a;
                Boolean bool = (Boolean) ze5.a.b();
                bool.getClass();
                return bool;
            case 8:
                List list3 = r55.a;
                af5.f.get();
                return (String) df5.u0.b();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                List list4 = r55.a;
                af5.f.get();
                Long l2 = (Long) df5.U.b();
                l2.getClass();
                return l2;
            case 10:
                List list5 = r55.a;
                af5.f.get();
                Long l3 = (Long) df5.S.b();
                l3.getClass();
                return l3;
            case 11:
                List list6 = r55.a;
                af5.f.get();
                Long l4 = (Long) df5.v0.b();
                l4.getClass();
                return l4;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list7 = r55.a;
                af5.f.get();
                Long l5 = (Long) df5.V.b();
                l5.getClass();
                return l5;
            case 13:
                List list8 = r55.a;
                af5.f.get();
                Long l6 = (Long) df5.p0.b();
                l6.getClass();
                return l6;
            case 14:
                List list9 = r55.a;
                kg5.f.get();
                Boolean bool2 = (Boolean) lg5.a.b();
                bool2.getClass();
                return bool2;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                List list10 = r55.a;
                kg5.f.get();
                Double d = (Double) lg5.c.b();
                d.getClass();
                return d;
            case 16:
                List list11 = r55.a;
                af5.f.get();
                Long l7 = (Long) df5.e0.b();
                l7.getClass();
                return l7;
            case 17:
                List list12 = r55.a;
                af5.f.get();
                return (String) df5.a0.b();
            case 18:
                List list13 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.r0.b()).longValue());
            case 19:
                List list14 = r55.a;
                af5.f.get();
                Boolean bool3 = (Boolean) df5.c.b();
                bool3.getClass();
                return bool3;
            case 20:
                List list15 = r55.a;
                Boolean bool4 = (Boolean) vf5.c.b();
                bool4.getClass();
                return bool4;
            case 21:
            default:
                return new Boolean(((Boolean) fg5.a.b()).booleanValue());
            case 22:
                List list16 = r55.a;
                mg5.f.get();
                Boolean bool5 = (Boolean) ng5.a.b();
                bool5.getClass();
                return bool5;
            case 23:
                List list17 = r55.a;
                Boolean bool6 = (Boolean) nf5.a.b();
                bool6.getClass();
                return bool6;
        }
    }

    @Override // defpackage.wz0
    public int b(Context context, String str, boolean z2) {
        return yz0.d(context, str, z2);
    }

    @Override // defpackage.wz0
    public int c(Context context, String str) {
        return yz0.a(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r3
      0x001b: PHI (r3v2 int) = (r3v1 int), (r3v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.xz0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public fm0 e(Context context, String str, wz0 wz0Var) {
        fm0 fm0Var = new fm0();
        fm0Var.a = wz0Var.c(context, str);
        int i = 1;
        int iB = wz0Var.b(context, str, true);
        fm0Var.b = iB;
        int i2 = fm0Var.a;
        if (i2 == 0) {
            i2 = 0;
            if (iB == 0) {
                i = 0;
            } else if (i2 >= iB) {
                i = -1;
            }
        }
        fm0Var.c = i;
        return fm0Var;
    }

    public void f(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        RectF rectFD = d(tabLayout, view);
        RectF rectFD2 = d(tabLayout, view2);
        drawable.setBounds(t8.c((int) rectFD.left, f2, (int) rectFD2.left), drawable.getBounds().top, t8.c((int) rectFD.right, f2, (int) rectFD2.right), drawable.getBounds().bottom);
    }

    @Override // defpackage.n90
    public /* synthetic */ Object g(rk3 rk3Var) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(rk3Var);
    }
}
