package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class NetUtilInitializations {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NetUtilInitializations.class);

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class NetworkIfaceAndInetAddress {
        private final InetAddress address;
        private final NetworkInterface iface;

        public NetworkIfaceAndInetAddress(NetworkInterface networkInterface, InetAddress inetAddress) {
            this.iface = networkInterface;
            this.address = inetAddress;
        }

        public InetAddress address() {
            return this.address;
        }

        public NetworkInterface iface() {
            return this.iface;
        }
    }

    private NetUtilInitializations() {
    }

    public static Inet4Address createLocalhost4() {
        try {
            return (Inet4Address) InetAddress.getByAddress("localhost", new byte[]{127, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return null;
        }
    }

    public static Inet6Address createLocalhost6() {
        try {
            return (Inet6Address) InetAddress.getByAddress("localhost", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        r6 = r5.nextElement();
        r4 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.netty.util.NetUtilInitializations.NetworkIfaceAndInetAddress determineLoopback(java.net.Inet4Address r8, java.net.Inet6Address r9) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtilInitializations.determineLoopback(java.net.Inet4Address, java.net.Inet6Address):io.netty.util.NetUtilInitializations$NetworkIfaceAndInetAddress");
    }
}
