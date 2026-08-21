package defpackage;

import android.content.Context;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l74 implements rw1, w42, c35 {
    public final /* synthetic */ int b;
    public static final /* synthetic */ l74 f = new l74(6);
    public static final /* synthetic */ l74 z = new l74(7);
    public static final /* synthetic */ l74 A = new l74(8);
    public static final /* synthetic */ l74 X = new l74(9);
    public static final /* synthetic */ l74 Y = new l74(10);
    public static final /* synthetic */ l74 Z = new l74(11);
    public static final /* synthetic */ l74 y0 = new l74(12);
    public static final /* synthetic */ l74 z0 = new l74(13);
    public static final /* synthetic */ l74 A0 = new l74(14);
    public static final /* synthetic */ l74 B0 = new l74(15);
    public static final /* synthetic */ l74 C0 = new l74(16);
    public static final /* synthetic */ l74 D0 = new l74(17);
    public static final /* synthetic */ l74 E0 = new l74(18);
    public static final /* synthetic */ l74 F0 = new l74(19);
    public static final /* synthetic */ l74 G0 = new l74(20);
    public static final /* synthetic */ l74 H0 = new l74(21);
    public static final /* synthetic */ l74 I0 = new l74(22);
    public static final /* synthetic */ l74 J0 = new l74(23);
    public static final /* synthetic */ l74 K0 = new l74(24);
    public static final /* synthetic */ l74 L0 = new l74(25);

    public l74(Context context, zo2 zo2Var) {
        this.b = 5;
        ViewConfiguration.get(context).getScaledTouchSlop();
        new GestureDetector(context, new ro(1, this));
    }

    @Override // defpackage.c35
    public Object a() {
        switch (this.b) {
            case 6:
                return new Boolean(((Boolean) jf5.b.b()).booleanValue());
            case 7:
                List list = r55.a;
                Boolean bool = (Boolean) dh5.a.b();
                bool.getClass();
                return bool;
            case 8:
                List list2 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.o0.b()).longValue());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                List list3 = r55.a;
                af5.f.get();
                return (String) df5.M.b();
            case 10:
                List list4 = r55.a;
                af5.f.get();
                Long l = (Long) df5.L.b();
                l.getClass();
                return l;
            case 11:
                List list5 = r55.a;
                af5.f.get();
                Long l2 = (Long) df5.Q.b();
                l2.getClass();
                return l2;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list6 = r55.a;
                af5.f.get();
                Long l3 = (Long) df5.E.b();
                l3.getClass();
                return l3;
            case 13:
                List list7 = r55.a;
                af5.f.get();
                Long l4 = (Long) df5.g0.b();
                l4.getClass();
                return l4;
            case 14:
                List list8 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.o.b()).longValue());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                List list9 = r55.a;
                af5.f.get();
                return (String) df5.g.b();
            case 16:
                List list10 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.u.b()).longValue());
            case 17:
                List list11 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.x.b()).longValue());
            case 18:
                List list12 = r55.a;
                af5.f.get();
                return (String) df5.D.b();
            case 19:
                List list13 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.W.b()).longValue());
            case 20:
                List list14 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.B.b()).longValue());
            case 21:
                List list15 = r55.a;
                Boolean bool2 = (Boolean) fh5.a.b();
                bool2.getClass();
                return bool2;
            case 22:
                List list16 = r55.a;
                Boolean bool3 = (Boolean) xg5.a.b();
                bool3.getClass();
                return bool3;
            case 23:
                List list17 = r55.a;
                mg5.f.get();
                Boolean bool4 = (Boolean) ng5.g.b();
                bool4.getClass();
                return bool4;
            case 24:
                List list18 = r55.a;
                mg5.f.get();
                Boolean bool5 = (Boolean) ng5.d.b();
                bool5.getClass();
                return bool5;
            default:
                return new Boolean(((Boolean) pg5.a.b()).booleanValue());
        }
    }

    @Override // defpackage.rw1
    public String[] m() {
        return new String[]{"CURRENT_YEAR", "CURRENT_YEAR_SHORT", "CURRENT_MONTH", "CURRENT_DATE", "CURRENT_HOUR", "CURRENT_MINUTE", "CURRENT_SECOND", "CURRENT_DAY_NAME", "CURRENT_DAY_NAME_SHORT", "CURRENT_MONTH_NAME", "CURRENT_MONTH_NAME_SHORT", "CURRENT_SECONDS_UNIX"};
    }

    public /* synthetic */ l74(int i) {
        this.b = i;
    }
}
