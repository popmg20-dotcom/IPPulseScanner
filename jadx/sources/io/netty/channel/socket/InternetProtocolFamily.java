package io.netty.channel.socket;

import defpackage.s53;
import defpackage.st4;
import io.netty.util.NetUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum InternetProtocolFamily {
    IPv4(Inet4Address.class, 1),
    IPv6(Inet6Address.class, 2);

    private final int addressNumber;
    private final Class<? extends InetAddress> addressType;

    /* JADX INFO: renamed from: io.netty.channel.socket.InternetProtocolFamily$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    InternetProtocolFamily(Class cls, int i) {
        this.addressType = cls;
        this.addressNumber = i;
    }

    public static InternetProtocolFamily of(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return IPv4;
        }
        if (inetAddress instanceof Inet6Address) {
            return IPv6;
        }
        st4.p("address ", inetAddress, " not supported");
        return null;
    }

    public int addressNumber() {
        return this.addressNumber;
    }

    public Class<? extends InetAddress> addressType() {
        return this.addressType;
    }

    public InetAddress localhost() {
        int i = AnonymousClass1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[ordinal()];
        if (i == 1) {
            return NetUtil.LOCALHOST4;
        }
        if (i == 2) {
            return NetUtil.LOCALHOST6;
        }
        s53.j(this, "Unsupported family ");
        return null;
    }
}
