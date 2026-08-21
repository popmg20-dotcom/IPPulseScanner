package defpackage;

import android.content.Context;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q84 implements bf0, c35, xz0 {
    public final /* synthetic */ int b;
    public static final /* synthetic */ q84 f = new q84(5);
    public static final /* synthetic */ q84 z = new q84(6);
    public static final /* synthetic */ q84 A = new q84(7);
    public static final /* synthetic */ q84 X = new q84(8);
    public static final /* synthetic */ q84 Y = new q84(9);
    public static final /* synthetic */ q84 Z = new q84(10);
    public static final /* synthetic */ q84 y0 = new q84(11);
    public static final /* synthetic */ q84 z0 = new q84(12);
    public static final /* synthetic */ q84 A0 = new q84(13);
    public static final /* synthetic */ q84 B0 = new q84(14);
    public static final /* synthetic */ q84 C0 = new q84(15);
    public static final /* synthetic */ q84 D0 = new q84(16);
    public static final /* synthetic */ q84 E0 = new q84(17);
    public static final /* synthetic */ q84 F0 = new q84(18);
    public static final /* synthetic */ q84 G0 = new q84(19);
    public static final /* synthetic */ q84 H0 = new q84(20);
    public static final /* synthetic */ q84 I0 = new q84(21);
    public static final /* synthetic */ q84 J0 = new q84(22);
    public static final /* synthetic */ q84 K0 = new q84(23);
    public static final /* synthetic */ q84 L0 = new q84(24);

    public /* synthetic */ q84(int i) {
        this.b = i;
    }

    @Override // defpackage.c35
    public Object a() {
        switch (this.b) {
            case 5:
                return new Boolean(((Boolean) jf5.a.b()).booleanValue());
            case 6:
                List list = r55.a;
                mg5.f.get();
                Boolean bool = (Boolean) ng5.c.b();
                bool.getClass();
                return bool;
            case 7:
                List list2 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.l0.b()).longValue());
            case 8:
                List list3 = r55.a;
                af5.f.get();
                return (String) df5.n.b();
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                List list4 = r55.a;
                af5.f.get();
                Long l = (Long) df5.J.b();
                l.getClass();
                return l;
            case 10:
                List list5 = r55.a;
                af5.f.get();
                Long l2 = (Long) df5.R.b();
                l2.getClass();
                return l2;
            case 11:
                List list6 = r55.a;
                af5.f.get();
                Long l3 = (Long) df5.h0.b();
                l3.getClass();
                return l3;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list7 = r55.a;
                af5.f.get();
                Long l4 = (Long) df5.F.b();
                l4.getClass();
                return l4;
            case 13:
                List list8 = r55.a;
                af5.f.get();
                Long l5 = (Long) df5.m.b();
                l5.getClass();
                return l5;
            case 14:
                List list9 = r55.a;
                kg5.f.get();
                return (String) lg5.f.b();
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                List list10 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.s.b()).longValue());
            case 16:
                List list11 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.j0.b()).longValue());
            case 17:
                List list12 = r55.a;
                af5.f.get();
                Long l6 = (Long) df5.j.b();
                l6.getClass();
                return l6;
            case 18:
                List list13 = r55.a;
                af5.f.get();
                Long l7 = (Long) df5.Z.b();
                l7.getClass();
                return l7;
            case 19:
                List list14 = r55.a;
                af5.f.get();
                Boolean bool2 = (Boolean) df5.C.b();
                bool2.getClass();
                return bool2;
            case 20:
                List list15 = r55.a;
                Boolean bool3 = (Boolean) jg5.a.b();
                bool3.getClass();
                return bool3;
            case 21:
                List list16 = r55.a;
                Boolean bool4 = (Boolean) tf5.b.b();
                bool4.getClass();
                return bool4;
            case 22:
                List list17 = r55.a;
                mg5.f.get();
                Boolean bool5 = (Boolean) ng5.h.b();
                bool5.getClass();
                return bool5;
            case 23:
                List list18 = r55.a;
                Boolean bool6 = (Boolean) we5.a.b();
                bool6.getClass();
                return bool6;
            default:
                return new Boolean(((Boolean) hg5.a.b()).booleanValue());
        }
    }

    @Override // defpackage.xz0
    public fm0 e(Context context, String str, wz0 wz0Var) {
        int iB;
        fm0 fm0Var = new fm0();
        int iC = wz0Var.c(context, str);
        fm0Var.a = iC;
        int i = 1;
        int i2 = 0;
        if (iC != 0) {
            iB = wz0Var.b(context, str, false);
            fm0Var.b = iB;
        } else {
            iB = wz0Var.b(context, str, true);
            fm0Var.b = iB;
        }
        int i3 = fm0Var.a;
        if (i3 == 0) {
            if (iB == 0) {
                i = 0;
            }
            fm0Var.c = i;
            return fm0Var;
        }
        i2 = i3;
        if (i2 >= iB) {
            i = -1;
        }
        fm0Var.c = i;
        return fm0Var;
    }
}
