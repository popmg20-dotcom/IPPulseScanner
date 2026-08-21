package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

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
    */
    public static NetworkIfaceAndInetAddress determineLoopback(Inet4Address inet4Address, Inet6Address inet6Address) {
        NetworkInterface networkInterface;
        InetAddress inetAddressNextElement;
        InetAddress inetAddress;
        InetAddress inetAddress2;
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    if (SocketUtils.addressesFromNetworkInterface(networkInterfaceNextElement).hasMoreElements()) {
                        arrayList.add(networkInterfaceNextElement);
                    }
                }
            }
        } catch (SocketException e) {
            logger.warn("Failed to retrieve the list of available network interfaces", (Throwable) e);
        }
        Iterator it = arrayList.iterator();
        loop1: while (true) {
            if (!it.hasNext()) {
                networkInterface = null;
                inetAddressNextElement = null;
                break;
            }
            networkInterface = (NetworkInterface) it.next();
            Enumeration<InetAddress> enumerationAddressesFromNetworkInterface = SocketUtils.addressesFromNetworkInterface(networkInterface);
            while (enumerationAddressesFromNetworkInterface.hasMoreElements()) {
                inetAddressNextElement = enumerationAddressesFromNetworkInterface.nextElement();
                if (inetAddressNextElement.isLoopbackAddress()) {
                    break loop1;
                }
            }
        }
        if (networkInterface == null) {
            try {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    NetworkInterface networkInterface2 = (NetworkInterface) it2.next();
                    if (networkInterface2.isLoopback()) {
                        Enumeration<InetAddress> enumerationAddressesFromNetworkInterface2 = SocketUtils.addressesFromNetworkInterface(networkInterface2);
                        if (enumerationAddressesFromNetworkInterface2.hasMoreElements()) {
                            try {
                                break;
                            } catch (SocketException e2) {
                                e = e2;
                                networkInterface = networkInterface2;
                                logger.warn("Failed to find the loopback interface", (Throwable) e);
                            }
                        }
                    }
                }
                if (networkInterface == null) {
                    logger.warn("Failed to find the loopback interface");
                }
            } catch (SocketException e3) {
                e = e3;
            }
        }
        if (networkInterface == null) {
            if (inetAddressNextElement == null) {
                try {
                    if (NetworkInterface.getByInetAddress(inet6Address) != null) {
                        logger.debug("Using hard-coded IPv6 localhost address: {}", inet6Address);
                        inetAddress = inet6Address;
                    } else {
                        inetAddress = inetAddressNextElement;
                    }
                } catch (Exception unused) {
                    if (inetAddressNextElement != null) {
                        inetAddress2 = inetAddressNextElement;
                    }
                    return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
                } catch (Throwable th) {
                    if (inetAddressNextElement == null) {
                        logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address);
                    }
                    throw th;
                }
                if (inetAddress == null) {
                    logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address);
                    inetAddress2 = inet4Address;
                } else {
                    inetAddress2 = inetAddress;
                }
            }
            return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
        }
        logger.debug("Loopback interface: {} ({}, {})", networkInterface.getName(), networkInterface.getDisplayName(), inetAddressNextElement.getHostAddress());
        inetAddress2 = inetAddressNextElement;
        return new NetworkIfaceAndInetAddress(networkInterface, inetAddress2);
    }
}
