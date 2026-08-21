package defpackage;

import android.content.Context;
import android.os.Looper;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d84 implements f84, pg2, c35, xz0, cd5 {
    public final /* synthetic */ int b;
    public static final /* synthetic */ d84 f = new d84(6);
    public static final /* synthetic */ d84 z = new d84(7);
    public static final /* synthetic */ d84 A = new d84(8);
    public static final /* synthetic */ d84 X = new d84(9);
    public static final /* synthetic */ d84 Y = new d84(10);
    public static final /* synthetic */ d84 Z = new d84(11);
    public static final /* synthetic */ d84 y0 = new d84(12);
    public static final /* synthetic */ d84 z0 = new d84(13);
    public static final /* synthetic */ d84 A0 = new d84(14);
    public static final /* synthetic */ d84 B0 = new d84(15);
    public static final /* synthetic */ d84 C0 = new d84(16);
    public static final /* synthetic */ d84 D0 = new d84(17);
    public static final /* synthetic */ d84 E0 = new d84(18);
    public static final /* synthetic */ d84 F0 = new d84(19);
    public static final /* synthetic */ d84 G0 = new d84(20);
    public static final /* synthetic */ d84 H0 = new d84(21);
    public static final /* synthetic */ d84 I0 = new d84(22);
    public static final /* synthetic */ d84 J0 = new d84(23);
    public static final /* synthetic */ d84 K0 = new d84(24);

    public /* synthetic */ d84(int i) {
        this.b = i;
    }

    public static qn4 i(in4 in4Var) {
        in4Var.getClass();
        return in4Var instanceof j43 ? qn4.z : in4Var instanceof xx1 ? qn4.A : j00.F(in4Var) ? qn4.X : in4Var instanceof z34 ? qn4.Y : qn4.Z;
    }

    public static final boolean j() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // defpackage.c35
    public Object a() {
        switch (this.b) {
            case 6:
                return new Boolean(((Boolean) xf5.a.b()).booleanValue());
            case 7:
                List list = r55.a;
                af5.f.get();
                return (String) df5.e.b();
            case 8:
                List list2 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.q0.b()).longValue());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                List list3 = r55.a;
                af5.f.get();
                Long l = (Long) df5.T.b();
                l.getClass();
                return l;
            case 10:
                List list4 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.P.b()).longValue());
            case 11:
                List list5 = r55.a;
                af5.f.get();
                Long l2 = (Long) df5.f.b();
                l2.getClass();
                return l2;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list6 = r55.a;
                af5.f.get();
                Long l3 = (Long) df5.z.b();
                l3.getClass();
                return l3;
            case 13:
                List list7 = r55.a;
                af5.f.get();
                Long l4 = (Long) df5.t0.b();
                l4.getClass();
                return l4;
            case 14:
                List list8 = r55.a;
                af5.f.get();
                Long l5 = (Long) df5.G.b();
                l5.getClass();
                return l5;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                List list9 = r55.a;
                kg5.f.get();
                Long l6 = (Long) lg5.b.b();
                l6.getClass();
                return l6;
            case 16:
                List list10 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.d.b()).longValue());
            case 17:
                List list11 = r55.a;
                af5.f.get();
                return (String) df5.c0.b();
            case 18:
                List list12 = r55.a;
                af5.f.get();
                return (String) df5.k.b();
            case 19:
                List list13 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.w.b()).longValue());
            case 20:
                List list14 = r55.a;
                Boolean bool = (Boolean) vf5.a.b();
                bool.getClass();
                return bool;
            case 21:
                List list15 = r55.a;
                return Integer.valueOf((int) ((Long) gf5.a.b()).longValue());
            case 22:
                List list16 = r55.a;
                mg5.f.get();
                Boolean bool2 = (Boolean) ng5.f.b();
                bool2.getClass();
                return bool2;
            case 23:
                List list17 = r55.a;
                mg5.f.get();
                Boolean bool3 = (Boolean) ng5.e.b();
                bool3.getClass();
                return bool3;
            default:
                List list18 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.n0.b()).longValue());
        }
    }

    @Override // defpackage.pg2
    public ld4 b(ql2 ql2Var) {
        sd4 sd4Var = (sd4) ql2Var;
        return sd4Var instanceof ld4 ? (ld4) sd4Var : ((kd4) sd4Var).p();
    }

    @Override // defpackage.f84
    public boolean c(ld0 ld0Var) {
        return ld0Var.m().a();
    }

    @Override // defpackage.f84
    public boolean d(CodeEditor codeEditor) {
        return true;
    }

    @Override // defpackage.xz0
    public fm0 e(Context context, String str, wz0 wz0Var) {
        fm0 fm0Var = new fm0();
        int iC = wz0Var.c(context, str);
        fm0Var.a = iC;
        if (iC != 0) {
            fm0Var.c = -1;
            return fm0Var;
        }
        int iB = wz0Var.b(context, str, true);
        fm0Var.b = iB;
        if (iB != 0) {
            fm0Var.c = 1;
        }
        return fm0Var;
    }

    @Override // defpackage.pg2
    public ig2 f() {
        return ye4.a;
    }

    @Override // defpackage.cd5
    public boolean g(Class cls) {
        return false;
    }

    @Override // defpackage.cd5
    public qd5 h(Class cls) {
        throw new IllegalStateException("This should never be called.");
    }
}
