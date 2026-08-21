package io.netty.util;

import defpackage.ha0;
import defpackage.vp1;
import defpackage.xe;
import defpackage.zo2;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.NetUtilInitializations;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NetUtil {
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class SoMaxConnAction implements PrivilegedAction<Integer> {
        private SoMaxConnAction() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.security.PrivilegedAction
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Integer run() throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.String r9 = "Failed to get SOMAXCONN from sysctl and file {}. Default: {}"
                boolean r0 = io.netty.util.internal.PlatformDependent.isWindows()
                if (r0 == 0) goto Lb
                r0 = 200(0xc8, float:2.8E-43)
                goto Ld
            Lb:
                r0 = 128(0x80, float:1.8E-43)
            Ld:
                java.io.File r1 = new java.io.File
                java.lang.String r2 = "/proc/sys/net/core/somaxconn"
                r1.<init>(r2)
                r2 = 0
                r3 = 0
                boolean r4 = r1.exists()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                if (r4 == 0) goto L55
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                r5.<init>(r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                r4.<init>(r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                int r0 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                io.netty.util.internal.logging.InternalLogger r3 = io.netty.util.NetUtil.access$100()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                boolean r3 = r3.isDebugEnabled()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                if (r3 == 0) goto L4c
                io.netty.util.internal.logging.InternalLogger r3 = io.netty.util.NetUtil.access$100()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                java.lang.String r5 = "{}: {}"
                java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                r3.debug(r5, r1, r6)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L4a
                goto L4c
            L46:
                r9 = move-exception
                r3 = r4
                goto Lb5
            L4a:
                r3 = move-exception
                goto L8b
            L4c:
                r3 = r4
                goto L85
            L4e:
                r9 = move-exception
                goto Lb5
            L50:
                r4 = move-exception
                r8 = r4
                r4 = r3
                r3 = r8
                goto L8b
            L55:
                java.lang.String r4 = "io.netty.net.somaxconn.trySysctl"
                boolean r4 = io.netty.util.internal.SystemPropertyUtil.getBoolean(r4, r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                if (r4 == 0) goto L77
                java.lang.String r4 = "kern.ipc.somaxconn"
                java.lang.Integer r4 = io.netty.util.NetUtil.access$200(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                if (r4 != 0) goto L72
                java.lang.String r4 = "kern.ipc.soacceptqueue"
                java.lang.Integer r4 = io.netty.util.NetUtil.access$200(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                if (r4 == 0) goto L78
                int r0 = r4.intValue()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                goto L78
            L72:
                int r0 = r4.intValue()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                goto L78
            L77:
                r4 = r3
            L78:
                if (r4 != 0) goto L85
                io.netty.util.internal.logging.InternalLogger r4 = io.netty.util.NetUtil.access$100()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
                r4.debug(r9, r1, r5)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50
            L85:
                if (r3 == 0) goto Lb0
                r3.close()     // Catch: java.lang.Exception -> Lb0
                goto Lb0
            L8b:
                io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.NetUtil.access$100()     // Catch: java.lang.Throwable -> L46
                boolean r5 = r5.isDebugEnabled()     // Catch: java.lang.Throwable -> L46
                if (r5 == 0) goto Lab
                io.netty.util.internal.logging.InternalLogger r5 = io.netty.util.NetUtil.access$100()     // Catch: java.lang.Throwable -> L46
                java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L46
                r7 = 3
                java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L46
                r7[r2] = r1     // Catch: java.lang.Throwable -> L46
                r1 = 1
                r7[r1] = r6     // Catch: java.lang.Throwable -> L46
                r1 = 2
                r7[r1] = r3     // Catch: java.lang.Throwable -> L46
                r5.debug(r9, r7)     // Catch: java.lang.Throwable -> L46
            Lab:
                if (r4 == 0) goto Lb0
                r4.close()     // Catch: java.lang.Exception -> Lb0
            Lb0:
                java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
                return r9
            Lb5:
                if (r3 == 0) goto Lba
                r3.close()     // Catch: java.lang.Exception -> Lba
            Lba:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.SoMaxConnAction.run():java.lang.Integer");
        }
    }

    static {
        boolean z = SystemPropertyUtil.getBoolean("java.net.preferIPv4Stack", false);
        IPV4_PREFERRED = z;
        boolean z2 = SystemPropertyUtil.getBoolean("java.net.preferIPv6Addresses", false);
        IPV6_ADDRESSES_PREFERRED = z2;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) NetUtil.class);
        logger = internalLoggerFactory;
        internalLoggerFactory.debug("-Djava.net.preferIPv4Stack: {}", Boolean.valueOf(z));
        internalLoggerFactory.debug("-Djava.net.preferIPv6Addresses: {}", Boolean.valueOf(z2));
        Inet4Address inet4AddressCreateLocalhost4 = NetUtilInitializations.createLocalhost4();
        LOCALHOST4 = inet4AddressCreateLocalhost4;
        Inet6Address inet6AddressCreateLocalhost6 = NetUtilInitializations.createLocalhost6();
        LOCALHOST6 = inet6AddressCreateLocalhost6;
        NetUtilInitializations.NetworkIfaceAndInetAddress networkIfaceAndInetAddressDetermineLoopback = NetUtilInitializations.determineLoopback(inet4AddressCreateLocalhost4, inet6AddressCreateLocalhost6);
        LOOPBACK_IF = networkIfaceAndInetAddressDetermineLoopback.iface();
        LOCALHOST = networkIfaceAndInetAddressDetermineLoopback.address();
        SOMAXCONN = ((Integer) AccessController.doPrivileged(new SoMaxConnAction())).intValue();
    }

    private NetUtil() {
    }

    public static String bytesToIpAddress(byte[] bArr, int i, int i2) {
        if (i2 != 4) {
            if (i2 == 16) {
                return toAddressString(bArr, i, false);
            }
            xe.k(ha0.k("length: ", i2, " (expected: 4 or 16)"));
            return null;
        }
        StringBuilder sb = new StringBuilder(15);
        sb.append(bArr[i] & 255);
        sb.append('.');
        sb.append(bArr[i + 1] & 255);
        sb.append('.');
        sb.append(bArr[i + 2] & 255);
        sb.append('.');
        sb.append(bArr[i + 3] & 255);
        return sb.toString();
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            return validIpV4ToBytes(str);
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = str.substring(1, str.length() - 1);
        }
        int iIndexOf = str.indexOf(37);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return getIPv6ByName(str, true);
    }

    public static InetAddress createInetAddressFromIpAddressString(String str) {
        if (isValidIpV4Address(str)) {
            try {
                return InetAddress.getByAddress(validIpV4ToBytes(str));
            } catch (UnknownHostException e) {
                zo2.q(e);
                return null;
            }
        }
        if (isValidIpV6Address(str)) {
            if (str.charAt(0) == '[') {
                str = str.substring(1, str.length() - 1);
            }
            int iIndexOf = str.indexOf(37);
            if (iIndexOf >= 0) {
                try {
                    int i = Integer.parseInt(str.substring(iIndexOf + 1));
                    byte[] iPv6ByName = getIPv6ByName(str.substring(0, iIndexOf), true);
                    if (iPv6ByName == null) {
                        return null;
                    }
                    try {
                        return Inet6Address.getByAddress((String) null, iPv6ByName, i);
                    } catch (UnknownHostException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            byte[] iPv6ByName2 = getIPv6ByName(str, true);
            if (iPv6ByName2 == null) {
                return null;
            }
            try {
                return InetAddress.getByAddress(iPv6ByName2);
            } catch (UnknownHostException e3) {
                zo2.q(e3);
            }
        }
        return null;
    }

    private static int decimalDigit(String str, int i) {
        return str.charAt(i) - '0';
    }

    public static Inet6Address getByName(CharSequence charSequence, boolean z) {
        byte[] iPv6ByName = getIPv6ByName(charSequence, z);
        if (iPv6ByName == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, iPv6ByName, -1);
        } catch (UnknownHostException e) {
            vp1.p(e);
            return null;
        }
    }

    public static String getHostname(InetSocketAddress inetSocketAddress) {
        return PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x018f, code lost:
    
        if (r7 > 2) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] getIPv6ByName(java.lang.CharSequence r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getIPv6ByName(java.lang.CharSequence, boolean):byte[]");
    }

    private static boolean inRangeEndExclusive(int i, int i2, int i3) {
        return i >= i2 && i < i3;
    }

    public static String intToIpAddress(int i) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i >> 24) & DnsRecord.CLASS_ANY);
        sb.append('.');
        sb.append((i >> 16) & DnsRecord.CLASS_ANY);
        sb.append('.');
        sb.append((i >> 8) & DnsRecord.CLASS_ANY);
        sb.append('.');
        sb.append(i & DnsRecord.CLASS_ANY);
        return sb.toString();
    }

    public static int ipv4AddressToInt(Inet4Address inet4Address) {
        byte[] address = inet4Address.getAddress();
        return (address[3] & 255) | ((address[0] & 255) << 24) | ((address[1] & 255) << 16) | ((address[2] & 255) << 8);
    }

    private static byte ipv4WordToByte(String str, int i, int i2) {
        int iDecimalDigit = decimalDigit(str, i);
        int i3 = i + 1;
        if (i3 == i2) {
            return (byte) iDecimalDigit;
        }
        int iDecimalDigit2 = (iDecimalDigit * 10) + decimalDigit(str, i3);
        int i4 = i + 2;
        return i4 == i2 ? (byte) iDecimalDigit2 : (byte) ((iDecimalDigit2 * 10) + decimalDigit(str, i4));
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    private static boolean isValidHexChar(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'F') {
            return c >= 'a' && c <= 'f';
        }
        return true;
    }

    private static boolean isValidIPv4Mapped(byte[] bArr, int i, int i2, int i3) {
        boolean z = i3 + i2 >= 14;
        return i <= 12 && i >= 2 && (!z || i2 < 12) && isValidIPv4MappedSeparators(bArr[i + (-1)], bArr[i + (-2)], z) && PlatformDependent.isZero(bArr, 0, i + (-3));
    }

    private static boolean isValidIPv4MappedChar(char c) {
        return c == 'f' || c == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b, byte b2, boolean z) {
        if (b != b2) {
            return false;
        }
        if (b != 0) {
            return !z && b2 == -1;
        }
        return true;
    }

    private static boolean isValidIpV4Address(String str, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i3 = i2 - i;
        return i3 <= 15 && i3 >= 7 && (iIndexOf = str.indexOf(46, i + 1)) > 0 && isValidIpV4Word(str, i, iIndexOf) && (iIndexOf2 = str.indexOf(46, iIndexOf + 2)) > 0 && isValidIpV4Word(str, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = str.indexOf(46, iIndexOf2 + 2)) > 0 && isValidIpV4Word(str, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(str, iIndexOf3 + 1, i2);
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i3 = i2 - i;
        return i3 <= 15 && i3 >= 7 && (iIndexOf = AsciiString.indexOf(charSequence, '.', i + 1)) > 0 && isValidIpV4Word(charSequence, i, iIndexOf) && (iIndexOf2 = AsciiString.indexOf(charSequence, '.', iIndexOf + 2)) > 0 && isValidIpV4Word(charSequence, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = AsciiString.indexOf(charSequence, '.', iIndexOf2 + 2)) > 0 && isValidIpV4Word(charSequence, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(charSequence, iIndexOf3 + 1, i2);
    }

    private static boolean isValidIpV4Word(CharSequence charSequence, int i, int i2) {
        char cCharAt;
        char cCharAt2;
        int i3 = i2 - i;
        if (i3 >= 1 && i3 <= 3 && (cCharAt = charSequence.charAt(i)) >= '0') {
            if (i3 == 3) {
                char cCharAt3 = charSequence.charAt(i + 1);
                return cCharAt3 >= '0' && (cCharAt2 = charSequence.charAt(i + 2)) >= '0' && ((cCharAt <= '1' && cCharAt3 <= '9' && cCharAt2 <= '9') || (cCharAt == '2' && cCharAt3 <= '5' && (cCharAt2 <= '5' || (cCharAt3 < '5' && cCharAt2 <= '9'))));
            }
            if (cCharAt <= '9' && (i3 == 1 || isValidNumericChar(charSequence.charAt(i + 1)))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d3, code lost:
    
        if (r3 >= 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00d5, code lost:
    
        if (r2 != 7) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00d7, code lost:
    
        if (r8 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00da, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00dd, code lost:
    
        if ((r3 + 2) == r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00df, code lost:
    
        if (r8 <= 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e3, code lost:
    
        if (r2 < 8) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00e5, code lost:
    
        if (r3 > r4) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e8, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00e9, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isValidIpV6Address(java.lang.CharSequence r14) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.isValidIpV6Address(java.lang.CharSequence):boolean");
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    private static StringBuilder newSocketAddressStringBuilder(String str, String str2, boolean z) {
        int length = str.length();
        if (z) {
            StringBuilder sb = new StringBuilder(str2.length() + length + 1);
            sb.append(str);
            return sb;
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + length + 3);
        if (length > 1 && str.charAt(0) == '[' && str.charAt(length - 1) == ']') {
            sb2.append(str);
            return sb2;
        }
        sb2.append('[');
        sb2.append(str);
        sb2.append(']');
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process processStart = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
            try {
                String line = bufferedReader.readLine();
                if (line != null && line.startsWith(str)) {
                    int length = line.length();
                    do {
                        length--;
                        if (length > str.length()) {
                        }
                    } while (Character.isDigit(line.charAt(length)));
                    return Integer.valueOf(line.substring(length + 1));
                }
                processStart.destroy();
                return null;
            } finally {
                bufferedReader.close();
            }
        } finally {
            processStart.destroy();
        }
    }

    private static String toAddressString(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        int[] iArr = new int[8];
        int i4 = i + 8;
        while (true) {
            i2 = 1;
            if (i >= i4) {
                break;
            }
            int i5 = i << 1;
            iArr[i] = (bArr[i5 + 1] & 255) | ((bArr[i5] & 255) << 8);
            i++;
        }
        int i6 = -1;
        boolean z2 = false;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < 8) {
            if (iArr[i9] == 0) {
                if (i7 < 0) {
                    i7 = i9;
                }
            } else if (i7 >= 0) {
                int i11 = i9 - i7;
                if (i11 > i10) {
                    i10 = i11;
                } else {
                    i7 = i8;
                }
                i8 = i7;
                i7 = -1;
            }
            i9++;
        }
        if (i7 < 0 || (i3 = i9 - i7) <= i10) {
            i7 = i8;
        } else {
            i10 = i3;
        }
        if (i10 == 1) {
            i10 = 0;
        } else {
            i6 = i7;
        }
        int i12 = i10 + i6;
        StringBuilder sb = new StringBuilder(IPV6_MAX_CHAR_COUNT);
        if (i12 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i2 < 8) {
                sb.append(':');
                sb.append(Integer.toHexString(iArr[i2]));
                i2++;
            }
        } else {
            if (inRangeEndExclusive(0, i6, i12)) {
                sb.append("::");
                if (z && i12 == 5 && iArr[5] == 65535) {
                    z2 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i2 < 8) {
                if (!inRangeEndExclusive(i2, i6, i12)) {
                    if (!inRangeEndExclusive(i2 - 1, i6, i12)) {
                        if (!z2 || i2 == 6) {
                            sb.append(':');
                        } else {
                            sb.append('.');
                        }
                    }
                    if (!z2 || i2 <= 5) {
                        sb.append(Integer.toHexString(iArr[i2]));
                    } else {
                        sb.append(iArr[i2] >> 8);
                        sb.append('.');
                        sb.append(iArr[i2] & DnsRecord.CLASS_ANY);
                    }
                } else if (!inRangeEndExclusive(i2 - 1, i6, i12)) {
                    sb.append("::");
                }
                i2++;
            }
        }
        return sb.toString();
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress) {
        StringBuilder sbNewSocketAddressStringBuilder;
        String strValueOf = String.valueOf(inetSocketAddress.getPort());
        if (inetSocketAddress.isUnresolved()) {
            sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(getHostname(inetSocketAddress), strValueOf, !isValidIpV6Address(r2));
        } else {
            InetAddress address = inetSocketAddress.getAddress();
            sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(toAddressString(address), strValueOf, address instanceof Inet4Address);
        }
        sbNewSocketAddressStringBuilder.append(':');
        sbNewSocketAddressStringBuilder.append(strValueOf);
        return sbNewSocketAddressStringBuilder.toString();
    }

    public static byte[] validIpV4ToBytes(String str) {
        int iIndexOf = str.indexOf(46, 1);
        byte bIpv4WordToByte = ipv4WordToByte(str, 0, iIndexOf);
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(46, iIndexOf + 2);
        byte bIpv4WordToByte2 = ipv4WordToByte(str, i, iIndexOf2);
        int iIndexOf3 = str.indexOf(46, iIndexOf2 + 2);
        return new byte[]{bIpv4WordToByte, bIpv4WordToByte2, ipv4WordToByte(str, iIndexOf2 + 1, iIndexOf3), ipv4WordToByte(str, iIndexOf3 + 1, str.length())};
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    public static String toSocketAddressString(String str, int i) {
        String strValueOf = String.valueOf(i);
        StringBuilder sbNewSocketAddressStringBuilder = newSocketAddressStringBuilder(str, strValueOf, !isValidIpV6Address(str));
        sbNewSocketAddressStringBuilder.append(':');
        sbNewSocketAddressStringBuilder.append(strValueOf);
        return sbNewSocketAddressStringBuilder.toString();
    }

    public static boolean isValidIpV4Address(String str) {
        return isValidIpV4Address(str, 0, str.length());
    }

    private static boolean isValidIpV4Address(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof String) {
            return isValidIpV4Address((String) charSequence, i, i2);
        }
        if (charSequence instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) charSequence, i, i2);
        }
        return isValidIpV4Address0(charSequence, i, i2);
    }

    public static boolean isValidIpV4Address(CharSequence charSequence) {
        return isValidIpV4Address(charSequence, 0, charSequence.length());
    }

    private static boolean isValidIpV4Address(AsciiString asciiString, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i3 = i2 - i;
        return i3 <= 15 && i3 >= 7 && (iIndexOf = asciiString.indexOf('.', i + 1)) > 0 && isValidIpV4Word(asciiString, i, iIndexOf) && (iIndexOf2 = asciiString.indexOf('.', iIndexOf + 2)) > 0 && isValidIpV4Word(asciiString, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = asciiString.indexOf('.', iIndexOf2 + 2)) > 0 && isValidIpV4Word(asciiString, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(asciiString, iIndexOf3 + 1, i2);
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    public static String toAddressString(InetAddress inetAddress, boolean z) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (inetAddress instanceof Inet6Address) {
            return toAddressString(inetAddress.getAddress(), 0, z);
        }
        vp1.h(inetAddress, "Unhandled type: ");
        return null;
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static boolean isValidIpV6Address(String str) {
        return isValidIpV6Address((CharSequence) str);
    }
}
