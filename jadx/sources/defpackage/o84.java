package defpackage;

import androidx.camera.camera2.internal.compat.quirk.UseTorchAsFlashQuirk;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o84 implements pg2, w15, c35 {
    public final /* synthetic */ int b;
    public static final /* synthetic */ o84 f = new o84(5);
    public static final /* synthetic */ o84 z = new o84(6);
    public static final /* synthetic */ o84 A = new o84(7);
    public static final /* synthetic */ o84 X = new o84(8);
    public static final /* synthetic */ o84 Y = new o84(9);
    public static final /* synthetic */ o84 Z = new o84(10);
    public static final /* synthetic */ o84 y0 = new o84(11);
    public static final /* synthetic */ o84 z0 = new o84(12);
    public static final /* synthetic */ o84 A0 = new o84(13);
    public static final /* synthetic */ o84 B0 = new o84(14);
    public static final /* synthetic */ o84 C0 = new o84(15);
    public static final /* synthetic */ o84 D0 = new o84(16);
    public static final /* synthetic */ o84 E0 = new o84(17);
    public static final /* synthetic */ o84 F0 = new o84(18);
    public static final /* synthetic */ o84 G0 = new o84(19);
    public static final /* synthetic */ o84 H0 = new o84(20);
    public static final /* synthetic */ o84 I0 = new o84(21);
    public static final /* synthetic */ o84 J0 = new o84(22);
    public static final /* synthetic */ o84 K0 = new o84(23);
    public static final /* synthetic */ o84 L0 = new o84(24);

    public o84(oj1 oj1Var) {
        this.b = 3;
        oj1Var.y(UseTorchAsFlashQuirk.class);
    }

    public static final ad5 c(Object obj, Object obj2) {
        ad5 ad5VarA = (ad5) obj;
        ad5 ad5Var = (ad5) obj2;
        if (!ad5Var.isEmpty()) {
            if (!ad5VarA.b) {
                ad5VarA = ad5VarA.a();
            }
            ad5VarA.c();
            if (!ad5Var.isEmpty()) {
                ad5VarA.putAll(ad5Var);
            }
        }
        return ad5VarA;
    }

    @Override // defpackage.c35
    public Object a() {
        switch (this.b) {
            case 6:
                return new Boolean(((Boolean) dg5.a.b()).booleanValue());
            case 7:
                List list = r55.a;
                af5.f.get();
                return (String) df5.l.b();
            case 8:
                List list2 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.r.b()).longValue());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                List list3 = r55.a;
                af5.f.get();
                Long l = (Long) df5.A.b();
                l.getClass();
                return l;
            case 10:
                List list4 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.O.b()).longValue());
            case 11:
                List list5 = r55.a;
                af5.f.get();
                Long l2 = (Long) df5.f0.b();
                l2.getClass();
                return l2;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list6 = r55.a;
                af5.f.get();
                Long l3 = (Long) df5.y.b();
                l3.getClass();
                return l3;
            case 13:
                List list7 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.s0.b()).longValue());
            case 14:
                List list8 = r55.a;
                af5.f.get();
                Long l4 = (Long) df5.H.b();
                l4.getClass();
                return l4;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                List list9 = r55.a;
                kg5.f.get();
                return Integer.valueOf((int) ((Long) lg5.d.b()).longValue());
            case 16:
                List list10 = r55.a;
                af5.f.get();
                Long l5 = (Long) df5.d0.b();
                l5.getClass();
                return l5;
            case 17:
                List list11 = r55.a;
                af5.f.get();
                return (String) df5.Y.b();
            case 18:
                List list12 = r55.a;
                af5.f.get();
                return (String) df5.b0.b();
            case 19:
                List list13 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.v.b()).longValue());
            case 20:
                List list14 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.i0.b()).longValue());
            case 21:
                List list15 = r55.a;
                Boolean bool = (Boolean) tf5.a.b();
                bool.getClass();
                return bool;
            case 22:
                List list16 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.m0.b()).longValue());
            case 23:
                List list17 = r55.a;
                Boolean bool2 = (Boolean) nf5.b.b();
                bool2.getClass();
                return bool2;
            default:
                List list18 = r55.a;
                af5.f.get();
                Long l6 = (Long) df5.a.b();
                l6.getClass();
                return l6;
        }
    }

    @Override // defpackage.pg2
    public ld4 b(ql2 ql2Var) {
        sd4 sd4Var = (sd4) ql2Var;
        return sd4Var instanceof ld4 ? (ld4) sd4Var : ((kd4) sd4Var).p();
    }

    @Override // defpackage.pg2
    public ig2 f() {
        return ze4.a;
    }

    @Override // defpackage.w15
    public /* synthetic */ String j0(String str, String str2) {
        return null;
    }

    public o84(AppMeasurementReceiver appMeasurementReceiver) {
        this.b = 25;
    }

    public /* synthetic */ o84(int i) {
        this.b = i;
    }
}
