package defpackage;

import android.content.Context;
import android.content.Intent;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.service.SurfboardVpn;
import java.io.File;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zw1 {
    public static final Map a;
    public static final Map b;
    public static final Map c;
    public static final Map d;
    public static final List e;
    public static final List f;
    public static long g;
    public static final Set h;

    static {
        Map mapSingletonMap = Collections.singletonMap("0.0.0.0", 0);
        mapSingletonMap.getClass();
        a = mapSingletonMap;
        Map mapSingletonMap2 = Collections.singletonMap("::", 0);
        mapSingletonMap2.getClass();
        b = mapSingletonMap2;
        c = fh2.V(new e03("2000::", 3), new e03("ff00::", 8));
        d = fh2.V(new e03("1.0.0.0", 8), new e03("2.0.0.0", 7), new e03("4.0.0.0", 6), new e03("8.0.0.0", 7), new e03("11.0.0.0", 8), new e03("12.0.0.0", 6), new e03("16.0.0.0", 4), new e03("32.0.0.0", 3), new e03("64.0.0.0", 3), new e03("96.0.0.0", 4), new e03("112.0.0.0", 5), new e03("120.0.0.0", 6), new e03("124.0.0.0", 7), new e03("126.0.0.0", 8), new e03("128.0.0.0", 3), new e03("160.0.0.0", 5), new e03("168.0.0.0", 8), new e03("169.0.0.0", 9), new e03("169.128.0.0", 10), new e03("169.192.0.0", 11), new e03("169.224.0.0", 12), new e03("169.240.0.0", 13), new e03("169.248.0.0", 14), new e03("169.252.0.0", 15), new e03("169.255.0.0", 16), new e03("170.0.0.0", 7), new e03("172.0.0.0", 12), new e03("172.32.0.0", 11), new e03("172.64.0.0", 10), new e03("172.128.0.0", 9), new e03("173.0.0.0", 8), new e03("174.0.0.0", 7), new e03("176.0.0.0", 4), new e03("192.0.0.0", 9), new e03("192.128.0.0", 11), new e03("192.160.0.0", 13), new e03("192.169.0.0", 16), new e03("192.170.0.0", 15), new e03("192.172.0.0", 14), new e03("192.176.0.0", 12), new e03("192.192.0.0", 10), new e03("193.0.0.0", 8), new e03("194.0.0.0", 7), new e03("196.0.0.0", 6), new e03("200.0.0.0", 5), new e03("208.0.0.0", 4), new e03("224.0.0.0", 3));
        e = e70.K(new e03(InetAddress.getByName("0.0.0.0"), 8), new e03(InetAddress.getByName("10.0.0.0"), 8), new e03(InetAddress.getByName("100.64.0.0"), 10), new e03(InetAddress.getByName("169.254.0.0"), 16), new e03(InetAddress.getByName("172.16.0.0"), 12), new e03(InetAddress.getByName("192.0.0.0"), 24), new e03(InetAddress.getByName("192.88.99.0"), 24), new e03(InetAddress.getByName("192.168.0.0"), 16), new e03(InetAddress.getByName("198.51.100.0"), 24), new e03(InetAddress.getByName("203.0.113.0"), 24), new e03(InetAddress.getByName("224.0.0.0"), 4), new e03(InetAddress.getByName("233.252.0.0"), 24), new e03(InetAddress.getByName("240.0.0.0"), 4), new e03(InetAddress.getByName("255.255.255.255"), 32));
        f = e70.K(new e03(InetAddress.getByName("fe80::"), 10), new e03(InetAddress.getByName("fc00::"), 7), new e03(InetAddress.getByName("ff00::"), 8));
        h = qe.t0(new String[]{"ipv4.icanhazip.com", "api.ipify.org", "v4.ident.me"});
    }

    public static final void a(Context context, Class cls, String str, String str2, String str3, boolean z) {
        context.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        Intent intentPutExtra = new Intent(context, (Class<?>) cls).putExtra("change_proxy_group", true).putExtra("profile_name", str).putExtra("group_name", str2).putExtra("proxy_name", str3).putExtra("manually", z);
        intentPutExtra.getClass();
        if (yw1.G0) {
            v9.z(context, intentPutExtra);
        } else {
            context.startService(intentPutExtra);
        }
    }

    public static final File b() {
        return new File(ContextUtilsKt.getContext().getDir("vpn", 0), "PROFILE");
    }

    public static final void c(Context context) {
        Intent intentPutExtra = new Intent(context, (Class<?>) SurfboardVpn.class).putExtra("print_tcp_info", true);
        intentPutExtra.getClass();
        if (yw1.G0) {
            v9.z(context, intentPutExtra);
        } else {
            context.startService(intentPutExtra);
        }
    }

    public static final void d(Context context) {
        context.getClass();
        Intent intentPutExtra = new Intent(context, (Class<?>) SurfboardVpn.class).putExtra("stop", true);
        intentPutExtra.getClass();
        if (yw1.G0) {
            v9.z(context, intentPutExtra);
        } else {
            context.startService(intentPutExtra);
        }
    }
}
