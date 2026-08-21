package io.netty.channel;

import defpackage.s53;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultChannelId implements ChannelId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID;
    private static final int PROCESS_ID;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private static final InternalLogger logger;
    private static final AtomicInteger nextSequence;
    private static final long serialVersionUID = 3884076183504074063L;
    private final byte[] data;
    private final int hashCode;
    private transient String longValue;
    private transient String shortValue;

    static {
        int i;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelId.class);
        logger = internalLoggerFactory;
        nextSequence = new AtomicInteger();
        String str = SystemPropertyUtil.get("io.netty.processId");
        int iDefaultProcessId = -1;
        if (str != null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i < 0) {
                internalLoggerFactory = logger;
                internalLoggerFactory.warn("-Dio.netty.processId: {} (malformed)", str);
            } else {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("-Dio.netty.processId: {} (user-set)", Integer.valueOf(i));
                }
                iDefaultProcessId = i;
                internalLoggerFactory = internalLogger;
            }
        }
        if (iDefaultProcessId < 0) {
            iDefaultProcessId = defaultProcessId();
            if (internalLoggerFactory.isDebugEnabled()) {
                internalLoggerFactory.debug("-Dio.netty.processId: {} (auto-detected)", Integer.valueOf(iDefaultProcessId));
            }
        }
        PROCESS_ID = iDefaultProcessId;
        String str2 = SystemPropertyUtil.get("io.netty.machineId");
        byte[] mac = null;
        if (str2 != null) {
            try {
                mac = MacAddressUtil.parseMAC(str2);
            } catch (Exception e) {
                logger.warn("-Dio.netty.machineId: {} (malformed)", str2, e);
            }
            if (mac != null) {
                logger.debug("-Dio.netty.machineId: {} (user-set)", str2);
            }
        }
        if (mac == null) {
            mac = MacAddressUtil.defaultMachineId();
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(mac));
            }
        }
        MACHINE_ID = mac;
    }

    private DefaultChannelId() {
        byte[] bArr = MACHINE_ID;
        byte[] bArr2 = new byte[bArr.length + 20];
        this.data = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        writeInt(writeLong(writeInt(writeInt(bArr.length, PROCESS_ID), nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        this.hashCode = Arrays.hashCode(bArr2);
    }

    private int appendHexDumpField(StringBuilder sb, int i, int i2) {
        sb.append(ByteBufUtil.hexDump(this.data, i, i2));
        sb.append('-');
        return i + i2;
    }

    public static int defaultProcessId() {
        ClassLoader classLoader = PlatformDependent.getClassLoader(DefaultChannelId.class);
        int iProcessHandlePid = processHandlePid(classLoader);
        return iProcessHandlePid != -1 ? iProcessHandlePid : jmxPid(classLoader);
    }

    public static int jmxPid(ClassLoader classLoader) {
        String string;
        int i;
        try {
            Class<?> cls = Class.forName("java.lang.management.ManagementFactory", true, classLoader);
            Class<?> cls2 = Class.forName("java.lang.management.RuntimeMXBean", true, classLoader);
            Class<?>[] clsArr = EmptyArrays.EMPTY_CLASSES;
            Method method = cls.getMethod("getRuntimeMXBean", clsArr);
            Object[] objArr = EmptyArrays.EMPTY_OBJECTS;
            string = (String) cls2.getMethod("getName", clsArr).invoke(method.invoke(null, objArr), objArr);
        } catch (Throwable th) {
            logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", th);
            try {
                string = Class.forName("android.os.Process", true, classLoader).getMethod("myPid", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            } catch (Throwable th2) {
                logger.debug("Could not invoke Process.myPid(); not Android?", th2);
                string = "";
            }
        }
        int iIndexOf = string.indexOf(64);
        if (iIndexOf >= 0) {
            string = string.substring(0, iIndexOf);
        }
        try {
            i = Integer.parseInt(string);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i >= 0) {
            return i;
        }
        int iNextInt = PlatformDependent.threadLocalRandom().nextInt();
        logger.warn("Failed to find the current process ID from '{}'; using a random value: {}", string, Integer.valueOf(iNextInt));
        return iNextInt;
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    private String newLongValue() {
        StringBuilder sb = new StringBuilder((this.data.length * 2) + 5);
        appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, appendHexDumpField(sb, 0, MACHINE_ID.length), 4), 4), 8), 4);
        return sb.substring(0, sb.length() - 1);
    }

    public static int processHandlePid(ClassLoader classLoader) {
        if (PlatformDependent.javaVersion() >= 9) {
            try {
                Class<?> cls = Class.forName("java.lang.ProcessHandle", true, classLoader);
                Long l = (Long) cls.getMethod("pid", null).invoke(cls.getMethod("current", null).invoke(null, null), null);
                if (l.longValue() <= 2147483647L && l.longValue() >= -2147483648L) {
                    return l.intValue();
                }
                s53.j(l, "Current process ID exceeds int range: ");
                return 0;
            } catch (Exception e) {
                logger.debug("Could not invoke ProcessHandle.current().pid();", (Throwable) e);
            }
        }
        return -1;
    }

    private int writeInt(int i, int i2) {
        byte[] bArr = this.data;
        bArr[i] = (byte) (i2 >>> 24);
        bArr[i + 1] = (byte) (i2 >>> 16);
        int i3 = i + 3;
        bArr[i + 2] = (byte) (i2 >>> 8);
        int i4 = i + 4;
        bArr[i3] = (byte) i2;
        return i4;
    }

    private int writeLong(int i, long j) {
        byte[] bArr = this.data;
        bArr[i] = (byte) (j >>> 56);
        bArr[i + 1] = (byte) (j >>> 48);
        bArr[i + 2] = (byte) (j >>> 40);
        bArr[i + 3] = (byte) (j >>> 32);
        bArr[i + 4] = (byte) (j >>> 24);
        bArr[i + 5] = (byte) (j >>> 16);
        int i2 = i + 7;
        bArr[i + 6] = (byte) (j >>> 8);
        int i3 = i + 8;
        bArr[i2] = (byte) j;
        return i3;
    }

    @Override // io.netty.channel.ChannelId
    public String asLongText() {
        String str = this.longValue;
        if (str != null) {
            return str;
        }
        String strNewLongValue = newLongValue();
        this.longValue = strNewLongValue;
        return strNewLongValue;
    }

    @Override // io.netty.channel.ChannelId
    public String asShortText() {
        String str = this.shortValue;
        if (str != null) {
            return str;
        }
        byte[] bArr = this.data;
        String strHexDump = ByteBufUtil.hexDump(bArr, bArr.length - 4, 4);
        this.shortValue = strHexDump;
        return strHexDump;
    }

    @Override // java.lang.Comparable
    public int compareTo(ChannelId channelId) {
        if (this == channelId) {
            return 0;
        }
        if (!(channelId instanceof DefaultChannelId)) {
            return asLongText().compareTo(channelId.asLongText());
        }
        byte[] bArr = ((DefaultChannelId) channelId).data;
        int length = this.data.length;
        int length2 = bArr.length;
        int iMin = Math.min(length, length2);
        for (int i = 0; i < iMin; i++) {
            byte b = this.data[i];
            byte b2 = bArr[i];
            if (b != b2) {
                return (b & 255) - (b2 & 255);
            }
        }
        return length - length2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultChannelId)) {
            return false;
        }
        DefaultChannelId defaultChannelId = (DefaultChannelId) obj;
        return this.hashCode == defaultChannelId.hashCode && Arrays.equals(this.data, defaultChannelId.data);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return asShortText();
    }
}
