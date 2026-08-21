package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.SslProtocols;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class c84 implements f84, xv0, c35 {
    public static c84 f;
    public final /* synthetic */ int b;
    public static final /* synthetic */ c84 z = new c84(5);
    public static final /* synthetic */ c84 A = new c84(6);
    public static final /* synthetic */ c84 X = new c84(7);
    public static final /* synthetic */ c84 Y = new c84(8);
    public static final /* synthetic */ c84 Z = new c84(9);
    public static final /* synthetic */ c84 y0 = new c84(10);
    public static final /* synthetic */ c84 z0 = new c84(11);
    public static final /* synthetic */ c84 A0 = new c84(12);
    public static final /* synthetic */ c84 B0 = new c84(13);
    public static final /* synthetic */ c84 C0 = new c84(14);
    public static final /* synthetic */ c84 D0 = new c84(15);
    public static final /* synthetic */ c84 E0 = new c84(16);
    public static final /* synthetic */ c84 F0 = new c84(17);
    public static final /* synthetic */ c84 G0 = new c84(18);
    public static final /* synthetic */ c84 H0 = new c84(19);
    public static final /* synthetic */ c84 I0 = new c84(20);
    public static final /* synthetic */ c84 J0 = new c84(21);
    public static final /* synthetic */ c84 K0 = new c84(22);
    public static final /* synthetic */ c84 L0 = new c84(23);
    public static final /* synthetic */ c84 M0 = new c84(24);
    public static final /* synthetic */ c84 N0 = new c84(25);

    public /* synthetic */ c84(int i) {
        this.b = i;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ne4 b(String str) {
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals(SslProtocols.TLS_v1_1)) {
                            return ne4.X;
                        }
                        break;
                    case -503070502:
                        if (str.equals(SslProtocols.TLS_v1_2)) {
                            return ne4.A;
                        }
                        break;
                    case -503070501:
                        if (str.equals(SslProtocols.TLS_v1_3)) {
                            return ne4.z;
                        }
                        break;
                }
            } else if (str.equals(SslProtocols.TLS_v1)) {
                return ne4.Y;
            }
        } else if (str.equals(SslProtocols.SSL_v3)) {
            return ne4.Z;
        }
        xe.k("Unexpected TLS version: ".concat(str));
        return null;
    }

    @Override // defpackage.c35
    public Object a() {
        switch (this.b) {
            case 6:
                return new Boolean(((Boolean) rf5.a.b()).booleanValue());
            case 7:
                List list = r55.a;
                Boolean bool = (Boolean) vg5.a.b();
                bool.getClass();
                return bool;
            case 8:
                List list2 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.k0.b()).longValue());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                List list3 = r55.a;
                af5.f.get();
                return (String) df5.N.b();
            case 10:
                List list4 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.K.b()).longValue());
            case 11:
                List list5 = r55.a;
                af5.f.get();
                Long l = (Long) df5.I.b();
                l.getClass();
                return l;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list6 = r55.a;
                af5.f.get();
                Long l2 = (Long) df5.i.b();
                l2.getClass();
                return l2;
            case 13:
                List list7 = r55.a;
                af5.f.get();
                return (String) df5.h.b();
            case 14:
                List list8 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.t.b()).longValue());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                List list9 = r55.a;
                kg5.f.get();
                Long l3 = (Long) lg5.e.b();
                l3.getClass();
                return l3;
            case 16:
                List list10 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.q.b()).longValue());
            case 17:
                List list11 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.p.b()).longValue());
            case 18:
                List list12 = r55.a;
                af5.f.get();
                return (String) df5.w0.b();
            case 19:
                List list13 = r55.a;
                af5.f.get();
                return Integer.valueOf((int) ((Long) df5.X.b()).longValue());
            case 20:
                List list14 = r55.a;
                Boolean bool2 = (Boolean) vf5.b.b();
                bool2.getClass();
                return bool2;
            case 21:
                List list15 = r55.a;
                Boolean bool3 = (Boolean) hh5.a.b();
                bool3.getClass();
                return bool3;
            case 22:
                List list16 = r55.a;
                Boolean bool4 = (Boolean) bh5.a.b();
                bool4.getClass();
                return bool4;
            case 23:
                List list17 = r55.a;
                mg5.f.get();
                Boolean bool5 = (Boolean) ng5.b.b();
                bool5.getClass();
                return bool5;
            case 24:
                List list18 = r55.a;
                Boolean bool6 = (Boolean) rg5.a.b();
                bool6.getClass();
                return bool6;
            default:
                return new Boolean(((Boolean) zg5.a.b()).booleanValue());
        }
    }

    @Override // defpackage.f84
    public boolean c(ld0 ld0Var) {
        return ld0Var.m().a();
    }

    @Override // defpackage.f84
    public boolean d(CodeEditor codeEditor) {
        return true;
    }

    public boolean e(CharSequence charSequence) {
        return false;
    }
}
