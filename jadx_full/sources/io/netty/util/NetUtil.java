package io.netty.util;

import defpackage.ha0;
import defpackage.vp1;
import defpackage.xe;
import defpackage.zo2;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.NetUtilInitializations;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import java.util.Arrays;

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
        */
        public Integer run() throws Throwable {
            BufferedReader bufferedReader;
            Exception e;
            Integer numSysctlGetInt;
            int iIntValue = PlatformDependent.isWindows() ? 200 : 128;
            File file = new File("/proc/sys/net/core/somaxconn");
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    if (file.exists()) {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            try {
                                iIntValue = Integer.parseInt(bufferedReader.readLine());
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("{}: {}", file, Integer.valueOf(iIntValue));
                                }
                                bufferedReader2 = bufferedReader;
                            } catch (Exception e2) {
                                e = e2;
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue), e);
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return Integer.valueOf(iIntValue);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        if (SystemPropertyUtil.getBoolean("io.netty.net.somaxconn.trySysctl", false)) {
                            numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.somaxconn");
                            if (numSysctlGetInt == null) {
                                numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.soacceptqueue");
                                if (numSysctlGetInt != null) {
                                    iIntValue = numSysctlGetInt.intValue();
                                }
                            } else {
                                iIntValue = numSysctlGetInt.intValue();
                            }
                        } else {
                            numSysctlGetInt = null;
                        }
                        if (numSysctlGetInt == null) {
                            NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue));
                        }
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception e3) {
                bufferedReader = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                }
                throw th;
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return Integer.valueOf(iIntValue);
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
    */
    public static byte[] getIPv6ByName(CharSequence charSequence, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bArr = new byte[16];
        int length = charSequence.length();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int iDecodeHexNibble = 0;
        while (i8 < length) {
            char cCharAt = charSequence.charAt(i8);
            if (cCharAt == '.') {
                i10++;
                int i15 = i8 - i11;
                if (i15 > 3 || i11 < 0 || i10 > 3 || ((i12 > 0 && i13 + i14 < 12) || i8 + 1 >= length || i13 >= 16 || (i10 == 1 && (!z || (!(i13 == 0 || isValidIPv4Mapped(bArr, i13, i9, i14)) || ((i15 == 3 && !(isValidNumericChar(charSequence.charAt(i8 - 1)) && isValidNumericChar(charSequence.charAt(i8 - 2)) && isValidNumericChar(charSequence.charAt(i8 - 3)))) || ((i15 == 2 && !(isValidNumericChar(charSequence.charAt(i8 - 1)) && isValidNumericChar(charSequence.charAt(i8 - 2)))) || (i15 == 1 && !isValidNumericChar(charSequence.charAt(i8 - 1)))))))))) {
                    return null;
                }
                int i16 = iDecodeHexNibble << ((3 - i15) << 2);
                int i17 = (((i16 >> 4) & 15) * 10) + ((i16 & 15) * 100) + ((i16 >> 8) & 15);
                if (i17 > 255) {
                    return null;
                }
                bArr[i13] = (byte) i17;
                i13++;
            } else if (cCharAt == ':') {
                int i18 = i12 + 1;
                int i19 = i8 - i11;
                if (i19 > 4 || i10 > 0 || i18 > 8 || (i7 = i13 + 1) >= 16) {
                    return null;
                }
                int i20 = iDecodeHexNibble << ((4 - i19) << 2);
                if (i14 > 0) {
                    i14 -= 2;
                }
                bArr[i13] = (byte) (((i20 & 15) << 4) | ((i20 >> 4) & 15));
                i13 += 2;
                bArr[i7] = (byte) ((((i20 >> 8) & 15) << 4) | ((i20 >> 12) & 15));
                int i21 = i8 + 1;
                if (i21 >= length || charSequence.charAt(i21) != ':') {
                    i12 = i18;
                } else {
                    int i22 = i8 + 2;
                    if (i9 != 0 || (i22 < length && charSequence.charAt(i22) == ':')) {
                        return null;
                    }
                    i12 += 2;
                    i14 = 14 - i13;
                    i8 = i21;
                    i9 = i13;
                }
            } else {
                if (!isValidHexChar(cCharAt) || (i10 > 0 && !isValidNumericChar(cCharAt))) {
                    return null;
                }
                if (i11 < 0) {
                    i11 = i8;
                } else if (i8 - i11 > 4) {
                    return null;
                }
                iDecodeHexNibble += StringUtil.decodeHexNibble(cCharAt) << ((i8 - i11) << 2);
                i8++;
            }
            i11 = -1;
            iDecodeHexNibble = 0;
            i8++;
        }
        boolean z2 = i9 > 0;
        if (i10 > 0) {
            if (i11 > 0) {
                i4 = 3;
                if (i8 - i11 <= 3) {
                }
                return null;
            }
            i4 = 3;
            if (i10 == i4 && i13 < 16) {
                if (i12 != 0) {
                    if (i12 >= 2) {
                        if (z2 || i12 != 6) {
                            i6 = 0;
                        } else {
                            i6 = 0;
                            if (charSequence.charAt(0) == ':') {
                            }
                        }
                        if (z2 && i12 < 8) {
                            if (charSequence.charAt(i6) == ':') {
                            }
                            int i23 = iDecodeHexNibble << ((3 - (i8 - i11)) << 2);
                            i5 = (((i23 >> 4) & 15) * 10) + ((i23 & 15) * 100) + ((i23 >> 8) & 15);
                            if (i5 <= 255) {
                            }
                        }
                    }
                    return null;
                }
                int i232 = iDecodeHexNibble << ((3 - (i8 - i11)) << 2);
                i5 = (((i232 >> 4) & 15) * 10) + ((i232 & 15) * 100) + ((i232 >> 8) & 15);
                if (i5 <= 255) {
                    return null;
                }
                i2 = i13 + 1;
                bArr[i13] = (byte) i5;
            }
            return null;
        }
        int i24 = length - 1;
        if ((i11 > 0 && i8 - i11 > 4) || i12 < 2 || ((!z2 && (i12 + 1 != 8 || charSequence.charAt(0) == ':' || charSequence.charAt(i24) == ':')) || ((z2 && (i12 > 8 || (i12 == 8 && ((i9 <= 2 && charSequence.charAt(0) != ':') || (i9 >= 14 && charSequence.charAt(i24) != ':'))))) || (i = i13 + 1) >= 16 || ((i11 < 0 && charSequence.charAt(length - 2) != ':') || (i9 > 2 && charSequence.charAt(0) == ':'))))) {
            return null;
        }
        if (i11 >= 0 && (i3 = i8 - i11) <= 4) {
            iDecodeHexNibble <<= (4 - i3) << 2;
        }
        bArr[i13] = (byte) (((iDecodeHexNibble & 15) << 4) | ((iDecodeHexNibble >> 4) & 15));
        i2 = i13 + 2;
        bArr[i] = (byte) ((((iDecodeHexNibble >> 8) & 15) << 4) | ((iDecodeHexNibble >> 12) & 15));
        if (i2 < 16) {
            int i25 = i2 - i9;
            int i26 = 16 - i25;
            System.arraycopy(bArr, i9, bArr, i26, i25);
            Arrays.fill(bArr, i9, i26, (byte) 0);
        }
        if (i10 > 0) {
            bArr[11] = -1;
            bArr[10] = -1;
        }
        return bArr;
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
    */
    public static boolean isValidIpV6Address(CharSequence charSequence) {
        int i;
        int i2;
        int length = charSequence.length();
        int i3 = 2;
        if (length >= 2) {
            char cCharAt = charSequence.charAt(0);
            if (cCharAt == '[') {
                length--;
                if (charSequence.charAt(length) != ']') {
                    return false;
                }
                cCharAt = charSequence.charAt(1);
                i = 1;
            } else {
                i = 0;
            }
            if (cCharAt != ':') {
                i2 = -1;
                i3 = 0;
            } else {
                if (charSequence.charAt(i + 1) != ':') {
                    return false;
                }
                int i4 = i;
                i += 2;
                i2 = i4;
            }
            int i5 = 0;
            int i6 = i;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                char cCharAt2 = charSequence.charAt(i6);
                if (!isValidHexChar(cCharAt2)) {
                    if (cCharAt2 == '%') {
                        length = i6;
                        break;
                    }
                    if (cCharAt2 == '.') {
                        if ((i2 < 0 && i3 != 6) || ((i3 == 7 && i2 >= i) || i3 > 7)) {
                            return false;
                        }
                        int i7 = i6 - i5;
                        int i8 = i7 - 2;
                        if (isValidIPv4MappedChar(charSequence.charAt(i8))) {
                            if (!isValidIPv4MappedChar(charSequence.charAt(i7 - 3)) || !isValidIPv4MappedChar(charSequence.charAt(i7 - 4)) || !isValidIPv4MappedChar(charSequence.charAt(i7 - 5))) {
                                return false;
                            }
                            i8 = i7 - 7;
                        }
                        while (i8 >= i) {
                            char cCharAt3 = charSequence.charAt(i8);
                            if (cCharAt3 != '0' && cCharAt3 != ':') {
                                return false;
                            }
                            i8--;
                        }
                        int iIndexOf = AsciiString.indexOf(charSequence, '%', i7 + 7);
                        if (iIndexOf >= 0) {
                            length = iIndexOf;
                        }
                        return isValidIpV4Address(charSequence, i7, length);
                    }
                    if (cCharAt2 != ':' || i3 > 7) {
                        return false;
                    }
                    int i9 = i6 - 1;
                    if (charSequence.charAt(i9) != ':') {
                        i5 = 0;
                    } else {
                        if (i2 >= 0) {
                            return false;
                        }
                        i2 = i9;
                    }
                    i3++;
                } else {
                    if (i5 >= 4) {
                        return false;
                    }
                    i5++;
                }
                i6++;
            }
        } else {
            return false;
        }
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
