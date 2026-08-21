package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class PlatformDependent0 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long ADDRESS_FIELD_OFFSET;
    private static final Method ALIGN_SLICE;
    private static final Method ALLOCATE_ARRAY_METHOD;
    private static final long BYTE_ARRAY_BASE_OFFSET;
    private static final Constructor<?> DIRECT_BUFFER_CONSTRUCTOR;
    private static final Throwable EXPLICIT_NO_UNSAFE_CAUSE;
    static final int HASH_CODE_ASCII_SEED = -1028477387;
    static final int HASH_CODE_C1 = -862048943;
    static final int HASH_CODE_C2 = 461845907;
    private static final Object INTERNAL_UNSAFE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID;
    private static final boolean IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    private static final int JAVA_VERSION;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final boolean RUNNING_IN_NATIVE_IMAGE;
    private static final boolean STORE_FENCE_AVAILABLE;
    private static final boolean UNALIGNED;
    static final Unsafe UNSAFE;
    private static final long UNSAFE_COPY_THRESHOLD = 1048576;
    private static final Throwable UNSAFE_UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    static {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.PlatformDependent0.<clinit>():void");
    }

    private PlatformDependent0() {
    }

    public static int addressSize() {
        return UNSAFE.addressSize();
    }

    public static ByteBuffer alignSlice(ByteBuffer byteBuffer, int i) {
        try {
            return (ByteBuffer) ALIGN_SLICE.invoke(byteBuffer, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    public static ByteBuffer allocateDirectNoCleaner(int i) {
        return newDirectBuffer(UNSAFE.allocateMemory(Math.max(1, i)), i);
    }

    public static long allocateMemory(long j) {
        return UNSAFE.allocateMemory(j);
    }

    public static byte[] allocateUninitializedArray(int i) {
        try {
            return (byte[]) ALLOCATE_ARRAY_METHOD.invoke(INTERNAL_UNSAFE, Byte.TYPE, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            throw new Error(e);
        } catch (InvocationTargetException e2) {
            throw new Error(e2);
        }
    }

    public static long byteArrayBaseOffset() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    public static void copyMemory(Object obj, long j, Object obj2, long j2, long j3) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(obj, j, obj2, j2, j3);
        } else {
            UNSAFE.copyMemory(obj, j, obj2, j2, j3);
        }
    }

    private static void copyMemoryWithSafePointPolling(Object obj, long j, Object obj2, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        while (j6 > 0) {
            long jMin = Math.min(j6, 1048576L);
            UNSAFE.copyMemory(obj, j4, obj2, j5, jMin);
            j6 -= jMin;
            j4 += jMin;
            j5 += jMin;
        }
    }

    public static long directBufferAddress(ByteBuffer byteBuffer) {
        return getLong(byteBuffer, ADDRESS_FIELD_OFFSET);
    }

    public static boolean equals(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        boolean z;
        int i4 = i3 & 7;
        long j = BYTE_ARRAY_BASE_OFFSET + ((long) i);
        long j2 = i2 - i;
        if (i3 >= 8) {
            long j3 = ((long) i4) + j;
            long j4 = 8;
            z = false;
            long j5 = (j - 8) + ((long) i3);
            while (j5 >= j3) {
                Unsafe unsafe = UNSAFE;
                long j6 = j4;
                if (unsafe.getLong(bArr, j5) != unsafe.getLong(bArr2, j5 + j2)) {
                    return false;
                }
                j5 -= j6;
                j4 = j6;
            }
        } else {
            z = false;
        }
        if (i4 >= 4) {
            i4 -= 4;
            long j7 = ((long) i4) + j;
            Unsafe unsafe2 = UNSAFE;
            if (unsafe2.getInt(bArr, j7) != unsafe2.getInt(bArr2, j7 + j2)) {
                return z;
            }
        }
        long j8 = j2 + j;
        if (i4 < 2) {
            if (i4 != 0) {
                Unsafe unsafe3 = UNSAFE;
                if (unsafe3.getByte(bArr, j) != unsafe3.getByte(bArr2, j8)) {
                    return z;
                }
            }
            return true;
        }
        Unsafe unsafe4 = UNSAFE;
        if (unsafe4.getChar(bArr, j) == unsafe4.getChar(bArr2, j8) && (i4 == 2 || unsafe4.getByte(bArr, j + 2) == unsafe4.getByte(bArr2, j8 + 2))) {
            return true;
        }
        return z;
    }

    public static int equalsConstantTime(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        long j = i3 & 7;
        long j2 = BYTE_ARRAY_BASE_OFFSET + ((long) i);
        long j3 = j2 + j;
        long j4 = i2 - i;
        long j5 = 0;
        for (long j6 = (j2 - 8) + ((long) i3); j6 >= j3; j6 -= 8) {
            Unsafe unsafe = UNSAFE;
            j5 |= unsafe.getLong(bArr, j6) ^ unsafe.getLong(bArr2, j6 + j4);
        }
        if (j >= 4) {
            Unsafe unsafe2 = UNSAFE;
            j5 |= (long) (unsafe2.getInt(bArr2, j2 + j4) ^ unsafe2.getInt(bArr, j2));
            j -= 4;
        }
        if (j >= 2) {
            long j7 = j3 - j;
            Unsafe unsafe3 = UNSAFE;
            j5 |= (long) (unsafe3.getChar(bArr2, j7 + j4) ^ unsafe3.getChar(bArr, j7));
            j -= 2;
        }
        if (j == 1) {
            long j8 = j3 - 1;
            Unsafe unsafe4 = UNSAFE;
            j5 |= (long) (unsafe4.getByte(bArr, j8) ^ unsafe4.getByte(bArr2, j8 + j4));
        }
        return ConstantTimeUtils.equalsConstantTime(j5, 0L);
    }

    private static Throwable explicitNoUnsafeCause0() {
        boolean z = SystemPropertyUtil.getBoolean("io.netty.noUnsafe", false);
        InternalLogger internalLogger = logger;
        internalLogger.debug("-Dio.netty.noUnsafe: {}", Boolean.valueOf(z));
        if (z) {
            internalLogger.debug("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
            return new UnsupportedOperationException("sun.misc.Unsafe: unavailable (io.netty.noUnsafe)");
        }
        String str = SystemPropertyUtil.contains("io.netty.tryUnsafe") ? "io.netty.tryUnsafe" : "org.jboss.netty.tryUnsafe";
        if (SystemPropertyUtil.getBoolean(str, true)) {
            return null;
        }
        String str2 = "sun.misc.Unsafe: unavailable (" + str + ")";
        internalLogger.debug(str2);
        return new UnsupportedOperationException(str2);
    }

    private static boolean explicitTryReflectionSetAccessible0() {
        return SystemPropertyUtil.getBoolean("io.netty.tryReflectionSetAccessible", javaVersion() < 9 || RUNNING_IN_NATIVE_IMAGE);
    }

    public static void freeMemory(long j) {
        UNSAFE.freeMemory(j);
    }

    public static byte getByte(byte[] bArr, int i) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static ClassLoader getClassLoader(final Class<?> cls) {
        return System.getSecurityManager() == null ? cls.getClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    public static ClassLoader getContextClassLoader() {
        return System.getSecurityManager() == null ? Thread.currentThread().getContextClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    public static int getInt(int[] iArr, long j) {
        return UNSAFE.getInt(iArr, (INT_ARRAY_INDEX_SCALE * j) + INT_ARRAY_BASE_OFFSET);
    }

    public static int getIntVolatile(long j) {
        return UNSAFE.getIntVolatile((Object) null, j);
    }

    public static long getLong(long[] jArr, long j) {
        return UNSAFE.getLong(jArr, (LONG_ARRAY_INDEX_SCALE * j) + LONG_ARRAY_BASE_OFFSET);
    }

    public static Object getObject(Object obj, long j) {
        return UNSAFE.getObject(obj, j);
    }

    public static short getShort(byte[] bArr, int i) {
        return UNSAFE.getShort(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static ClassLoader getSystemClassLoader() {
        return System.getSecurityManager() == null ? ClassLoader.getSystemClassLoader() : (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: io.netty.util.internal.PlatformDependent0.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    public static Throwable getUnsafeUnavailabilityCause() {
        return UNSAFE_UNAVAILABILITY_CAUSE;
    }

    public static boolean hasAlignSliceMethod() {
        return ALIGN_SLICE != null;
    }

    public static boolean hasAllocateArrayMethod() {
        return ALLOCATE_ARRAY_METHOD != null;
    }

    public static boolean hasDirectBufferNoCleanerConstructor() {
        return DIRECT_BUFFER_CONSTRUCTOR != null;
    }

    public static boolean hasUnsafe() {
        return UNSAFE != null;
    }

    public static int hashCodeAscii(byte[] bArr, int i, int i2) {
        int i3;
        long j = BYTE_ARRAY_BASE_OFFSET + ((long) i);
        int i4 = i2 & 7;
        long j2 = ((long) i4) + j;
        int iHashCodeAsciiSanitize = HASH_CODE_ASCII_SEED;
        for (long j3 = (j - 8) + ((long) i2); j3 >= j2; j3 -= 8) {
            iHashCodeAsciiSanitize = hashCodeAsciiCompute(UNSAFE.getLong(bArr, j3), iHashCodeAsciiSanitize);
        }
        if (i4 == 0) {
            return iHashCodeAsciiSanitize;
        }
        boolean z = (i4 != 2) & (i4 != 4) & (i4 != 6);
        int i5 = HASH_CODE_C2;
        if (z) {
            iHashCodeAsciiSanitize = (iHashCodeAsciiSanitize * HASH_CODE_C1) + hashCodeAsciiSanitize(UNSAFE.getByte(bArr, j));
            j++;
            i3 = HASH_CODE_C2;
        } else {
            i3 = HASH_CODE_C1;
        }
        if ((i4 != 5) & (i4 != 1) & (i4 != 4)) {
            iHashCodeAsciiSanitize = (iHashCodeAsciiSanitize * i3) + hashCodeAsciiSanitize(UNSAFE.getShort(bArr, j));
            if (i3 != HASH_CODE_C1) {
                i5 = HASH_CODE_C1;
            }
            j += 2;
            i3 = i5;
        }
        return i4 >= 4 ? (iHashCodeAsciiSanitize * i3) + hashCodeAsciiSanitize(UNSAFE.getInt(bArr, j)) : iHashCodeAsciiSanitize;
    }

    public static int hashCodeAsciiCompute(long j, int i) {
        return (hashCodeAsciiSanitize((int) j) * HASH_CODE_C2) + (i * HASH_CODE_C1) + ((int) ((j & 2242545357458243584L) >>> 32));
    }

    public static int hashCodeAsciiSanitize(int i) {
        return i & 522133279;
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static boolean isAndroid0() {
        boolean zEquals = "Dalvik".equals(SystemPropertyUtil.get("java.vm.name"));
        if (zEquals) {
            logger.debug("Platform: Android");
        }
        return zEquals;
    }

    public static boolean isExplicitNoUnsafe() {
        return EXPLICIT_NO_UNSAFE_CAUSE != null;
    }

    public static boolean isExplicitTryReflectionSetAccessible() {
        return IS_EXPLICIT_TRY_REFLECTION_SET_ACCESSIBLE;
    }

    public static boolean isUnaligned() {
        return UNALIGNED;
    }

    public static boolean isZero(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return true;
        }
        long j = BYTE_ARRAY_BASE_OFFSET + ((long) i);
        int i3 = i2 & 7;
        long j2 = ((long) i3) + j;
        for (long j3 = (j - 8) + ((long) i2); j3 >= j2; j3 -= 8) {
            if (UNSAFE.getLong(bArr, j3) != 0) {
                return false;
            }
        }
        if (i3 >= 4) {
            i3 -= 4;
            if (UNSAFE.getInt(bArr, ((long) i3) + j) != 0) {
                return false;
            }
        }
        return i3 >= 2 ? UNSAFE.getChar(bArr, j) == 0 && (i3 == 2 || bArr[i + 2] == 0) : bArr[i] == 0;
    }

    public static int javaVersion() {
        return JAVA_VERSION;
    }

    private static int javaVersion0() {
        int iMajorVersionFromJavaSpecificationVersion = isAndroid0() ? 6 : majorVersionFromJavaSpecificationVersion();
        logger.debug("Java version: {}", Integer.valueOf(iMajorVersionFromJavaSpecificationVersion));
        return iMajorVersionFromJavaSpecificationVersion;
    }

    public static int majorVersion(String str) {
        String[] strArrSplit = str.split("\\.");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            iArr[i] = Integer.parseInt(strArrSplit[i]);
        }
        int i2 = iArr[0];
        return i2 == 1 ? iArr[1] : i2;
    }

    public static int majorVersionFromJavaSpecificationVersion() {
        return majorVersion(SystemPropertyUtil.get("java.specification.version", "1.6"));
    }

    public static ByteBuffer newDirectBuffer(long j, int i) {
        ObjectUtil.checkPositiveOrZero(i, "capacity");
        try {
            return (ByteBuffer) DIRECT_BUFFER_CONSTRUCTOR.newInstance(Long.valueOf(j), Integer.valueOf(i));
        } catch (Throwable th) {
            if (th instanceof Error) {
                throw th;
            }
            throw new Error(th);
        }
    }

    public static long objectFieldOffset(Field field) {
        return UNSAFE.objectFieldOffset(field);
    }

    public static void putByte(byte[] bArr, int i, byte b) {
        UNSAFE.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), b);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        UNSAFE.putInt(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), i2);
    }

    public static void putIntOrdered(long j, int i) {
        UNSAFE.putOrderedInt((Object) null, j, i);
    }

    public static void putLong(byte[] bArr, int i, long j) {
        UNSAFE.putLong(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), j);
    }

    public static void putObject(Object obj, long j, Object obj2) {
        UNSAFE.putObject(obj, j, obj2);
    }

    public static void putShort(byte[] bArr, int i, short s) {
        UNSAFE.putShort(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i), s);
    }

    public static ByteBuffer reallocateDirectNoCleaner(ByteBuffer byteBuffer, int i) {
        return newDirectBuffer(UNSAFE.reallocateMemory(directBufferAddress(byteBuffer), i), i);
    }

    public static long reallocateMemory(long j, long j2) {
        return UNSAFE.reallocateMemory(j, j2);
    }

    public static void safeConstructPutInt(Object obj, long j, int i) {
        if (!STORE_FENCE_AVAILABLE) {
            UNSAFE.putIntVolatile(obj, j, i);
            return;
        }
        Unsafe unsafe = UNSAFE;
        unsafe.putInt(obj, j, i);
        unsafe.storeFence();
    }

    public static void setMemory(Object obj, long j, long j2, byte b) {
        UNSAFE.setMemory(obj, j, j2, b);
    }

    public static void throwException(Throwable th) {
        UNSAFE.throwException((Throwable) ObjectUtil.checkNotNull(th, "cause"));
    }

    public static boolean unalignedAccess() {
        return UNALIGNED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean unsafeStaticFieldOffsetSupported() {
        return !RUNNING_IN_NATIVE_IMAGE;
    }

    public static int hashCodeAsciiSanitize(byte b) {
        return b & 31;
    }

    public static int hashCodeAsciiSanitize(short s) {
        return s & 7967;
    }

    public static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    public static void putInt(long j, int i) {
        UNSAFE.putInt(j, i);
    }

    public static void putShort(long j, short s) {
        UNSAFE.putShort(j, s);
    }

    public static void setMemory(long j, long j2, byte b) {
        UNSAFE.setMemory(j, j2, b);
    }

    public static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    public static short getShort(long j) {
        return UNSAFE.getShort(j);
    }

    public static void putByte(Object obj, long j, byte b) {
        UNSAFE.putByte(obj, j, b);
    }

    public static byte getByte(byte[] bArr, long j) {
        return UNSAFE.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j);
    }

    public static int getInt(long j) {
        return UNSAFE.getInt(j);
    }

    public static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    public static void putLong(long j, long j2) {
        UNSAFE.putLong(j, j2);
    }

    public static int getInt(byte[] bArr, int i) {
        return UNSAFE.getInt(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static long getLong(byte[] bArr, int i) {
        return UNSAFE.getLong(bArr, BYTE_ARRAY_BASE_OFFSET + ((long) i));
    }

    public static int getInt(Object obj, long j) {
        return UNSAFE.getInt(obj, j);
    }

    private static long getLong(Object obj, long j) {
        return UNSAFE.getLong(obj, j);
    }

    public static void copyMemory(long j, long j2, long j3) {
        if (javaVersion() <= 8) {
            copyMemoryWithSafePointPolling(j, j2, j3);
        } else {
            UNSAFE.copyMemory(j, j2, j3);
        }
    }

    private static void copyMemoryWithSafePointPolling(long j, long j2, long j3) {
        long j4 = j;
        long j5 = j2;
        while (j3 > 0) {
            long jMin = Math.min(j3, 1048576L);
            UNSAFE.copyMemory(j4, j5, jMin);
            j3 -= jMin;
            j4 += jMin;
            j5 += jMin;
        }
    }
}
