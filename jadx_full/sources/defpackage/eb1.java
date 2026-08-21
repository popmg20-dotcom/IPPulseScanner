package defpackage;

import com.getsurfboard.vpn.JniKt;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class eb1 {
    public static final int a;
    public static final int b;
    public static final int c;

    static {
        InetAddress byName = InetAddress.getByName(JniKt.getFakeIpMapperStart());
        byName.getClass();
        int iI0 = tj4.i0(byName);
        a = iI0;
        InetAddress byName2 = InetAddress.getByName(JniKt.getFakeIpMapperEnd());
        byName2.getClass();
        int iI02 = tj4.i0(byName2);
        b = iI02;
        c = iI02 - iI0;
    }
}
