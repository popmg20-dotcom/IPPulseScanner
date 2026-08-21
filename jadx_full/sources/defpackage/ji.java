package defpackage;

import com.getsurfboard.vpn.JniKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ji implements am1 {
    public final /* synthetic */ int b;

    public /* synthetic */ ji(int i) {
        this.b = i;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        io3 io3VarD0;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                String str = (String) obj;
                str.getClass();
                return Boolean.valueOf(d73.g(str).exists());
            case 1:
                i73.b((String) obj);
                return xl4Var;
            case 2:
                af0 af0Var = (af0) obj;
                if (af0Var instanceof ef0) {
                    return (ef0) af0Var;
                }
                return null;
            case 3:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(" : ");
                if (value instanceof Object[]) {
                    value = Arrays.toString((Object[]) value);
                    value.getClass();
                }
                sb.append(value);
                return sb.toString();
            case 4:
                ((DefaultDnsResponse) ((e03) obj).b).release();
                return xl4Var;
            case 5:
                e03 e03Var = (e03) obj;
                return e03Var.b + ": " + ((Exception) e03Var.f).getMessage();
            case 6:
                obj.getClass();
                throw new ClassCastException();
            case 7:
                return Boolean.valueOf(!((b11) obj).c);
            case 8:
                ((vy3) obj).getClass();
                return false;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return 300L;
            case 10:
                return obj;
            case 11:
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                io3VarD0 = go3Var.D0("SELECT * from hosts ORDER BY id ASC");
                try {
                    int iP = p95.p(io3VarD0, "id");
                    int iP2 = p95.p(io3VarD0, "key");
                    int iP3 = p95.p(io3VarD0, "value");
                    ArrayList arrayList = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList.add(new ls1(io3VarD0.e0(iP2), (int) io3VarD0.getLong(iP), io3VarD0.e0(iP3)));
                        break;
                    }
                    return arrayList;
                } finally {
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                go3 go3Var2 = (go3) obj;
                go3Var2.getClass();
                io3VarD0 = go3Var2.D0("SELECT * from hosts ORDER BY id ASC");
                try {
                    int iP4 = p95.p(io3VarD0, "id");
                    int iP5 = p95.p(io3VarD0, "key");
                    int iP6 = p95.p(io3VarD0, "value");
                    ArrayList arrayList2 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList2.add(new ls1(io3VarD0.e0(iP5), (int) io3VarD0.getLong(iP4), io3VarD0.e0(iP6)));
                        break;
                    }
                    return arrayList2;
                } finally {
                }
            case 13:
                InetAddress inetAddress = (InetAddress) obj;
                inetAddress.getClass();
                return tj4.f0(inetAddress);
            case 14:
                OutputStream outputStream = (OutputStream) obj;
                outputStream.getClass();
                outputStream.write(JniKt.getPcapHeaderBytes());
                return xl4Var;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                zz3 zz3Var = (zz3) obj;
                zz3Var.getClass();
                p95.e(zz3Var.j);
                return Boolean.TRUE;
            case 16:
                InetAddress inetAddress2 = (InetAddress) obj;
                inetAddress2.getClass();
                return tj4.f0(inetAddress2);
            case 17:
                lb2 lb2Var = (lb2) obj;
                lb2Var.getClass();
                p95 p95Var = lb2Var.p;
                if (p95Var instanceof lb2) {
                    return (lb2) p95Var;
                }
                return null;
            case 18:
                lb2 lb2Var2 = (lb2) obj;
                lb2Var2.getClass();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(lb2Var2.n);
                sb2.append('=');
                sb2.append(lb2Var2.o);
                return sb2.toString();
            case 19:
                pl1 pl1Var = (pl1) obj;
                pl1Var.getClass();
                pl1Var.a();
                return xl4Var;
            case 20:
                return Boolean.valueOf(((HttpCookie) obj).hasExpired());
            case 21:
                HttpCookie httpCookie = (HttpCookie) obj;
                try {
                    httpCookie.getClass();
                    return wn1.A(httpCookie);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            case 22:
                return j53.b;
            case 23:
                String str3 = (String) obj;
                str3.getClass();
                return p44.U0(str3).toString();
            case 24:
                e03 e03Var2 = (e03) obj;
                e03Var2.getClass();
                return ((t53) e03Var2.b).b;
            case 25:
                go3 go3Var3 = (go3) obj;
                go3Var3.getClass();
                io3VarD0 = go3Var3.D0("SELECT profileName FROM proxy_group_selection");
                try {
                    ArrayList arrayList3 = new ArrayList();
                    while (io3VarD0.C0()) {
                        arrayList3.add(io3VarD0.e0(0));
                        break;
                    }
                    return arrayList3;
                } finally {
                }
            case 26:
                vs4 vs4Var = (vs4) ws4.c.d();
                if (vs4Var != null && vs4Var.b) {
                    boolean z = nj3.a;
                    nj3.a(new t4(18));
                }
                return xl4Var;
            case 27:
                go3 go3Var4 = (go3) obj;
                go3Var4.getClass();
                try {
                    go3Var4.D0("DELETE FROM requests").C0();
                    return xl4Var;
                } finally {
                }
            case 28:
                ((nj0) obj).getClass();
                throw new ss2(0);
            default:
                return Boolean.valueOf(obj == null);
        }
    }

    public /* synthetic */ ji(int i, Object obj) {
        this.b = i;
    }
}
