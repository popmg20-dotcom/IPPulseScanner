package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.HttpConstants;
import io.sentry.android.core.a1;
import io.sentry.android.core.cache.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ek0 {
    public static final short[] a = {16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16908, 16905, 16904, 16904, 16904, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 16392, 17028, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 30896, 16800, 16800, 16800, 16800, 16800, 16800, 16800, 31906, 31906, 31906, 31906, 31906, 31906, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 29858, 16800, 16800, 16800, 16800, 20896, 16800, 30946, 30946, 30946, 30946, 30946, 30946, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 28898, 16800, 16800, 16800, 16800, 16392, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static final byte[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HttpConstants.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, HttpConstants.SP, 33, HttpConstants.DOUBLE_QUOTE, 35, 36, 37, 38, 39, 40, 41, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, HttpConstants.EQUALS, 62, 63, 64, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, -128, -127, -126, -125, -124, -123, -122, -121, -120, -119, -118, -117, -116, -115, -114, -113, -112, -111, -110, -109, -108, -107, -106, -105, -104, -103, -102, -101, -100, -99, -98, -97, -96, -95, -94, -93, -92, -91, -90, -89, -88, -87, -86, -85, -84, -83, -82, -81, -80, -79, -78, -77, -76, -75, -74, -73, -72, -71, -70, -69, -68, -67, -66, -65, -64, -63, -62, -61, -60, -59, -58, -57, -56, -55, -54, -53, -52, -51, -50, -49, -48, -47, -46, -45, -44, -43, -42, -41, -40, -39, -38, -37, -36, -35, -34, -33, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
    public static final int[][] c = {new int[]{65, 97}, new int[]{66, 98}, new int[]{67, 99}, new int[]{68, 100}, new int[]{69, 101}, new int[]{70, 102}, new int[]{71, 103}, new int[]{72, 104}, new int[]{73, 105}, new int[]{74, 106}, new int[]{75, 107}, new int[]{76, 108}, new int[]{77, 109}, new int[]{78, 110}, new int[]{79, 111}, new int[]{80, 112}, new int[]{81, 113}, new int[]{82, 114}, new int[]{83, 115}, new int[]{84, 116}, new int[]{85, 117}, new int[]{86, 118}, new int[]{87, 119}, new int[]{88, 120}, new int[]{89, 121}, new int[]{90, 122}};
    public static final String[] d = {"NUL", "SOH", "STX", "ETX", "EOT", "ENQ", "ACK", "BEL", "BS", "HT", "LF", "VT", "FF", "CR", "SO", "SI", "DLE", "DC1", "DC2", "DC3", "DC4", "NAK", "SYN", "ETB", "CAN", "EM", "SUB", "ESC", "FS", "GS", "RS", "US", "SP"};
    public static final byte[] e = {48, 49, 53, 0};
    public static final byte[] f = {48, 49, 48, 0};
    public static final byte[] g = {48, 48, 57, 0};
    public static final byte[] h = {48, 48, 53, 0};
    public static final byte[] i = {48, 48, 49, 0};
    public static final byte[] j = {48, 48, 49, 0};
    public static final byte[] k = {48, 48, 50, 0};
    public static Field l;
    public static boolean m;
    public static Class n;
    public static boolean o;
    public static Field p;
    public static boolean q;
    public static Field r;
    public static boolean s;

    public static TypedValue A(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean B(Context context, int i2, boolean z) {
        TypedValue typedValueA = A(context, i2);
        return (typedValueA == null || typedValueA.type != 18) ? z : typedValueA.data != 0;
    }

    public static int C(Context context, int i2, int i3) {
        TypedValue typedValueA = A(context, i2);
        return (typedValueA == null || typedValueA.type != 16) ? i3 : typedValueA.data;
    }

    public static int E(Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static byte[] F(di0 di0Var) {
        di0Var.getClass();
        HashMap map = di0Var.a;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(-21521);
                dataOutputStream.writeShort(1);
                dataOutputStream.writeInt(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    G(dataOutputStream, (String) entry.getKey(), entry.getValue());
                }
                dataOutputStream.flush();
                if (dataOutputStream.size() > 10240) {
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                dataOutputStream.close();
                byteArray.getClass();
                return byteArray;
            } finally {
            }
        } catch (IOException e2) {
            ue2.g().f(mj0.a, "Error in Data#toByteArray: ", e2);
            return new byte[0];
        }
    }

    public static final void G(DataOutputStream dataOutputStream, String str, Object obj) throws IOException {
        int i2;
        if (obj == null) {
            dataOutputStream.writeByte(0);
        } else if (obj instanceof Boolean) {
            dataOutputStream.writeByte(1);
            dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            dataOutputStream.writeByte(2);
            dataOutputStream.writeByte(((Number) obj).byteValue());
        } else if (obj instanceof Integer) {
            dataOutputStream.writeByte(3);
            dataOutputStream.writeInt(((Number) obj).intValue());
        } else if (obj instanceof Long) {
            dataOutputStream.writeByte(4);
            dataOutputStream.writeLong(((Number) obj).longValue());
        } else if (obj instanceof Float) {
            dataOutputStream.writeByte(5);
            dataOutputStream.writeFloat(((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            dataOutputStream.writeByte(6);
            dataOutputStream.writeDouble(((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            dataOutputStream.writeByte(7);
            dataOutputStream.writeUTF((String) obj);
        } else {
            if (!(obj instanceof Object[])) {
                a.c(dh3.a(obj.getClass()).c(), "Unsupported value type ");
                return;
            }
            Object[] objArr = (Object[]) obj;
            j50 j50VarA = dh3.a(objArr.getClass());
            if (j50VarA.equals(dh3.a(Boolean[].class))) {
                i2 = 8;
            } else if (j50VarA.equals(dh3.a(Byte[].class))) {
                i2 = 9;
            } else if (j50VarA.equals(dh3.a(Integer[].class))) {
                i2 = 10;
            } else if (j50VarA.equals(dh3.a(Long[].class))) {
                i2 = 11;
            } else if (j50VarA.equals(dh3.a(Float[].class))) {
                i2 = 12;
            } else if (j50VarA.equals(dh3.a(Double[].class))) {
                i2 = 13;
            } else {
                if (!j50VarA.equals(dh3.a(String[].class))) {
                    a.c(dh3.a(objArr.getClass()).b(), "Unsupported value type ");
                    return;
                }
                i2 = 14;
            }
            dataOutputStream.writeByte(i2);
            dataOutputStream.writeInt(objArr.length);
            for (Object obj2 : objArr) {
                if (i2 == 8) {
                    Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                    dataOutputStream.writeBoolean(bool != null ? bool.booleanValue() : false);
                } else if (i2 == 9) {
                    Byte b2 = obj2 instanceof Byte ? (Byte) obj2 : null;
                    dataOutputStream.writeByte(b2 != null ? b2.byteValue() : (byte) 0);
                } else if (i2 == 10) {
                    Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                    dataOutputStream.writeInt(num != null ? num.intValue() : 0);
                } else if (i2 == 11) {
                    Long l2 = obj2 instanceof Long ? (Long) obj2 : null;
                    dataOutputStream.writeLong(l2 != null ? l2.longValue() : 0L);
                } else if (i2 == 12) {
                    Float f2 = obj2 instanceof Float ? (Float) obj2 : null;
                    dataOutputStream.writeFloat(f2 != null ? f2.floatValue() : 0.0f);
                } else if (i2 == 13) {
                    Double d2 = obj2 instanceof Double ? (Double) obj2 : null;
                    dataOutputStream.writeDouble(d2 != null ? d2.doubleValue() : 0.0d);
                } else if (i2 == 14) {
                    String str2 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 == null) {
                        str2 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
                    }
                    dataOutputStream.writeUTF(str2);
                }
            }
        }
        dataOutputStream.writeUTF(str);
    }

    public static final String H(ge0 ge0Var) {
        Object tk3Var;
        if (ge0Var instanceof lv0) {
            return ((lv0) ge0Var).toString();
        }
        try {
            tk3Var = ge0Var + '@' + l(ge0Var);
        } catch (Throwable th) {
            tk3Var = new tk3(th);
        }
        if (uk3.a(tk3Var) != null) {
            tk3Var = ge0Var.getClass().getName() + '@' + l(ge0Var);
        }
        return (String) tk3Var;
    }

    public static final long I(int i2) {
        ez0 ez0Var = ez0.SECONDS;
        if (ez0Var.compareTo(ez0Var) > 0) {
            return J(i2, ez0Var);
        }
        long jConvert = TimeUnit.NANOSECONDS.convert(i2, TimeUnit.SECONDS);
        vd3 vd3Var = cz0.b;
        long j2 = jConvert << 1;
        int i3 = dz0.a;
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[PHI: r4
      0x006d: PHI (r4v5 long) = (r4v3 long), (r4v4 long), (r4v4 long), (r4v4 long), (r4v4 long) binds: [B:31:0x006b, B:47:0x0099, B:50:0x009f, B:42:0x0085, B:36:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long J(long r8, defpackage.ez0 r10) {
        /*
            java.util.concurrent.TimeUnit r0 = r10.b
            r1 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r1 = r0.convert(r1, r3)
            long r4 = -r1
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 > 0) goto L21
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 > 0) goto L21
            long r8 = r3.convert(r8, r0)
            vd3 r10 = defpackage.cz0.b
            r10 = 1
            long r8 = r8 << r10
            int r10 = defpackage.dz0.a
            return r8
        L21:
            ez0 r1 = defpackage.ez0.MILLISECONDS
            int r1 = r10.compareTo(r1)
            if (r1 < 0) goto La8
            int r0 = java.lang.Long.signum(r8)
            long r0 = (long) r0
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 >= 0) goto L38
            r8 = r2
        L38:
            long r8 = java.lang.Math.abs(r8)
            int r2 = r10.ordinal()
            r3 = 2
            r4 = 0
            r6 = 1
            if (r2 == r3) goto L68
            r3 = 3
            if (r2 == r3) goto L65
            r3 = 4
            if (r2 == r3) goto L61
            r3 = 5
            if (r2 == r3) goto L5d
            r3 = 6
            if (r2 != r3) goto L57
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            goto L69
        L57:
            java.lang.String r8 = "Wrong unit for millisMultiplier: "
            defpackage.ad0.o(r10, r8)
            return r4
        L5d:
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            goto L69
        L61:
            r2 = 60000(0xea60, double:2.9644E-319)
            goto L69
        L65:
            r2 = 1000(0x3e8, double:4.94E-321)
            goto L69
        L68:
            r2 = r6
        L69:
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 != 0) goto L6f
        L6d:
            r8 = r4
            goto La2
        L6f:
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            r4 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            if (r10 != 0) goto L7f
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 <= 0) goto L7d
            goto La1
        L7d:
            r8 = r2
            goto La2
        L7f:
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 != 0) goto L88
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 <= 0) goto La2
            goto La1
        L88:
            int r10 = java.lang.Long.numberOfLeadingZeros(r8)
            int r10 = 128 - r10
            int r6 = java.lang.Long.numberOfLeadingZeros(r2)
            int r10 = r10 - r6
            r6 = 63
            if (r10 >= r6) goto L99
            long r8 = r8 * r2
            goto La2
        L99:
            if (r10 <= r6) goto L9c
            goto La1
        L9c:
            long r8 = r8 * r2
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 <= 0) goto La2
        La1:
            goto L6d
        La2:
            long r0 = r0 * r8
            long r8 = f(r0)
            return r8
        La8:
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r1 = r10.convert(r8, r0)
            r3 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            r5 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            long r8 = defpackage.gb4.w(r1, r3, r5)
            long r8 = f(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ek0.J(long, ez0):long");
    }

    public static int K(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long L(long j2) {
        return (j2 >>> 1) ^ (-(1 & j2));
    }

    public static final long a(long j2, long j3) {
        if (j2 != 4611686018427387903L && j2 != -4611686018427387903L) {
            return (j3 == 4611686018427387903L || j3 == -4611686018427387903L) ? j3 : gb4.w(j2 + j3, -4611686018427387903L, 4611686018427387903L);
        }
        if ((-4611686018427387903L >= j3 || j3 >= 4611686018427387903L) && (j3 ^ j2) < 0) {
            return 9223372036854759646L;
        }
        return j2;
    }

    public static void b(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = o22.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = l13.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(defpackage.r92 r5, defpackage.ie0 r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof defpackage.d
            if (r0 == 0) goto L13
            r0 = r6
            d r0 = (defpackage.d) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            d r0 = new d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.Y
            int r1 = r0.Z
            xl4 r2 = defpackage.xl4.a
            r3 = 1
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2d
            bh3 r5 = r0.X
            r92 r0 = r0.A
            defpackage.n12.S(r6)     // Catch: java.lang.Throwable -> L2b
            goto L70
        L2b:
            r6 = move-exception
            goto L7f
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            r5 = 0
            return r5
        L34:
            defpackage.n12.S(r6)
            q92 r6 = r5.b()
            q92 r1 = defpackage.q92.A
            int r6 = r6.compareTo(r1)
            if (r6 < 0) goto L44
            return r2
        L44:
            bh3 r6 = new bh3
            r6.<init>()
            r0.A = r5     // Catch: java.lang.Throwable -> L7a
            r0.X = r6     // Catch: java.lang.Throwable -> L7a
            r0.Z = r3     // Catch: java.lang.Throwable -> L7a
            z00 r1 = new z00     // Catch: java.lang.Throwable -> L7a
            ge0 r0 = defpackage.p95.u(r0)     // Catch: java.lang.Throwable -> L7a
            r1.<init>(r3, r0)     // Catch: java.lang.Throwable -> L7a
            r1.w()     // Catch: java.lang.Throwable -> L7a
            e r0 = new e     // Catch: java.lang.Throwable -> L7a
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L7a
            r6.b = r0     // Catch: java.lang.Throwable -> L7a
            r5.a(r0)     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r0 = r1.u()     // Catch: java.lang.Throwable -> L7a
            mf0 r1 = defpackage.mf0.b
            if (r0 != r1) goto L6e
            return r1
        L6e:
            r0 = r5
            r5 = r6
        L70:
            java.lang.Object r5 = r5.b
            ca2 r5 = (defpackage.ca2) r5
            if (r5 == 0) goto L79
            r0.c(r5)
        L79:
            return r2
        L7a:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r6
            r6 = r4
        L7f:
            java.lang.Object r5 = r5.b
            ca2 r5 = (defpackage.ca2) r5
            if (r5 == 0) goto L88
            r0.c(r5)
        L88:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ek0.c(r92, ie0):java.lang.Object");
    }

    public static final int e(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static final long f(long j2) {
        long j3 = (j2 << 1) + 1;
        cz0.b.getClass();
        int i2 = dz0.a;
        return j3;
    }

    public static String g(vb4 vb4Var) {
        StringBuilder sb = new StringBuilder(vb4Var.size());
        for (int i2 = 0; i2 < vb4Var.size(); i2++) {
            byte bP = vb4Var.p(i2);
            if (bP == 34) {
                sb.append("\\\"");
            } else if (bP == 39) {
                sb.append("\\'");
            } else if (bP != 92) {
                switch (bP) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bP < 32 || bP > 126) {
                            sb.append('\\');
                            sb.append((char) (((bP >>> 6) & 3) + 48));
                            sb.append((char) (((bP >>> 3) & 7) + 48));
                            sb.append((char) ((bP & 7) + 48));
                        } else {
                            sb.append((char) bP);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static void h(Object obj) {
        LongSparseArray longSparseArray;
        if (!o) {
            try {
                n = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                a1.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            o = true;
        }
        Class cls = n;
        if (cls == null) {
            return;
        }
        if (!q) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                p = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                a1.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            q = true;
        }
        Field field = p;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            a1.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static di0 i(byte[] bArr) {
        bArr.getClass();
        if (bArr.length > 10240) {
            xe.q("Data cannot occupy more than 10240 bytes when serialized");
            return null;
        }
        if (bArr.length == 0) {
            return di0.b;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArr2 = new byte[2];
            byteArrayInputStream.read(bArr2);
            int i2 = 0;
            boolean z = bArr2[0] == -84 && bArr2[1] == -19;
            byteArrayInputStream.reset();
            if (z) {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    int i3 = objectInputStream.readInt();
                    while (i2 < i3) {
                        linkedHashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                        i2++;
                    }
                    objectInputStream.close();
                } finally {
                }
            } else {
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                try {
                    short s2 = dataInputStream.readShort();
                    if (s2 == -21521) {
                        short s3 = dataInputStream.readShort();
                        if (s3 != 1) {
                            g.g(dw2.A(s3, "Unsupported version number: "));
                        }
                    } else {
                        g.g(dw2.A(s2, "Magic number doesn't match: "));
                    }
                    int i4 = dataInputStream.readInt();
                    while (i2 < i4) {
                        linkedHashMap.put(dataInputStream.readUTF(), j(dataInputStream, dataInputStream.readByte()));
                        i2++;
                    }
                    dataInputStream.close();
                } finally {
                }
            }
        } catch (IOException e2) {
            ue2.g().f(mj0.a, "Error in Data#fromByteArray: ", e2);
        } catch (ClassNotFoundException e3) {
            ue2.g().f(mj0.a, "Error in Data#fromByteArray: ", e3);
        }
        return new di0(linkedHashMap);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Serializable, java.lang.Double[]] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Serializable, java.lang.Float[]] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Serializable, java.lang.Long[]] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Serializable, java.lang.Integer[]] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Serializable, java.lang.Byte[]] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Serializable, java.lang.Boolean[]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Serializable, java.lang.String[]] */
    public static final Serializable j(DataInputStream dataInputStream, byte b2) throws IOException {
        if (b2 == 0) {
            return null;
        }
        if (b2 == 1) {
            return Boolean.valueOf(dataInputStream.readBoolean());
        }
        if (b2 == 2) {
            return Byte.valueOf(dataInputStream.readByte());
        }
        if (b2 == 3) {
            return Integer.valueOf(dataInputStream.readInt());
        }
        if (b2 == 4) {
            return Long.valueOf(dataInputStream.readLong());
        }
        if (b2 == 5) {
            return Float.valueOf(dataInputStream.readFloat());
        }
        if (b2 == 6) {
            return Double.valueOf(dataInputStream.readDouble());
        }
        if (b2 == 7) {
            return dataInputStream.readUTF();
        }
        int i2 = 0;
        if (b2 == 8) {
            int i3 = dataInputStream.readInt();
            ?? r0 = new Boolean[i3];
            while (i2 < i3) {
                r0[i2] = Boolean.valueOf(dataInputStream.readBoolean());
                i2++;
            }
            return r0;
        }
        if (b2 == 9) {
            int i4 = dataInputStream.readInt();
            ?? r02 = new Byte[i4];
            while (i2 < i4) {
                r02[i2] = Byte.valueOf(dataInputStream.readByte());
                i2++;
            }
            return r02;
        }
        if (b2 == 10) {
            int i5 = dataInputStream.readInt();
            ?? r03 = new Integer[i5];
            while (i2 < i5) {
                r03[i2] = Integer.valueOf(dataInputStream.readInt());
                i2++;
            }
            return r03;
        }
        if (b2 == 11) {
            int i6 = dataInputStream.readInt();
            ?? r04 = new Long[i6];
            while (i2 < i6) {
                r04[i2] = Long.valueOf(dataInputStream.readLong());
                i2++;
            }
            return r04;
        }
        if (b2 == 12) {
            int i7 = dataInputStream.readInt();
            ?? r05 = new Float[i7];
            while (i2 < i7) {
                r05[i2] = Float.valueOf(dataInputStream.readFloat());
                i2++;
            }
            return r05;
        }
        if (b2 == 13) {
            int i8 = dataInputStream.readInt();
            ?? r06 = new Double[i8];
            while (i2 < i8) {
                r06[i2] = Double.valueOf(dataInputStream.readDouble());
                i2++;
            }
            return r06;
        }
        if (b2 != 14) {
            xe.q(dw2.A(b2, "Unsupported type "));
            return null;
        }
        int i9 = dataInputStream.readInt();
        ?? r1 = new String[i9];
        while (i2 < i9) {
            String utf = dataInputStream.readUTF();
            if (n12.c(utf, "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d")) {
                utf = null;
            }
            r1[i2] = utf;
            i2++;
        }
        return r1;
    }

    public static boolean k(String str, boolean z) {
        return !System.getProperty(str, z ? "true" : "false").equals("false");
    }

    public static final String l(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static int m(String str, int i2) {
        String property = System.getProperty(str);
        return property != null ? Integer.parseInt(property) : i2;
    }

    public static String n(char c2) {
        return c2 < ' ' ? d[c2] : c2 == 127 ? "DEL" : "UNK";
    }

    public static Object o(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return k2.f(bundle, str, cls);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static final String q(ea3 ea3Var, boolean z) {
        if (ea3Var instanceof tu0) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_direct);
        }
        if (ea3Var instanceof ii3) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_reject);
        }
        if (ea3Var instanceof li3) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_reject_drop);
        }
        if (ea3Var instanceof mu3) {
            return z ? ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_ss) : ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_shadowsocks);
        }
        if (ea3Var instanceof ms4) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_vmess);
        }
        if (ea3Var instanceof gv1) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_https);
        }
        if (ea3Var instanceof ou1) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_http);
        }
        if (ea3Var instanceof zy3) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_socks5);
        }
        if (ea3Var instanceof az3) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_socks5_tls);
        }
        if (ea3Var instanceof xh4) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_trojan);
        }
        if (ea3Var instanceof fw4) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_wireguard);
        }
        if (ea3Var instanceof jv1) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_hysteria2);
        }
        if (ea3Var instanceof ai4) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_tuic);
        }
        if (ea3Var instanceof s9) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_anytls);
        }
        if (ea3Var instanceof sy3) {
            return ContextUtilsKt.k(com.getsurfboard.R.string.proxy_type_snell);
        }
        if (ea3Var == null) {
            return "";
        }
        g.d();
        return null;
    }

    public static final int r(me meVar, Object obj, int i2) {
        int i3 = meVar.z;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iB = co4.b(i3, i2, meVar.b);
            if (iB < 0 || n12.c(obj, meVar.f[iB])) {
                return iB;
            }
            int i4 = iB + 1;
            while (i4 < i3 && meVar.b[i4] == i2) {
                if (n12.c(obj, meVar.f[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = iB - 1; i5 >= 0 && meVar.b[i5] == i2; i5--) {
                if (n12.c(obj, meVar.f[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static boolean s(char c2) {
        if (c2 != '\t') {
            return c2 < ' ' || c2 == 127;
        }
        return false;
    }

    public static final boolean t(nj0 nj0Var, int i2, int i3) {
        nj0Var.getClass();
        if (i2 > i3 && nj0Var.k) {
            return false;
        }
        Set set = nj0Var.l;
        return nj0Var.j && (set == null || !set.contains(Integer.valueOf(i2)));
    }

    public static final boolean u(t53 t53Var, String str, Map map) {
        t53Var.getClass();
        str.getClass();
        map.getClass();
        LinkedHashMap linkedHashMap = t53Var.H0;
        na3 na3Var = (na3) linkedHashMap.get(str);
        if (na3Var == null && (na3Var = (na3) linkedHashMap.get(p44.H0(str, "\""))) == null) {
            na3Var = (na3) linkedHashMap.get(p44.H0(str, "'"));
        }
        if (!(na3Var instanceof ka3) && !(na3Var instanceof ma3) && !(na3Var instanceof ia3) && !(na3Var instanceof ja3) && !(na3Var instanceof la3)) {
            ea3 ea3VarU = t53Var.u(str);
            if (ea3VarU == null && (ea3VarU = t53Var.u(p44.H0(str, "\""))) == null) {
                ea3VarU = t53Var.u(p44.H0(str, "'"));
            }
            if (ea3VarU != null) {
                return ea3VarU.A(t53Var, map, t23.c(com.getsurfboard.R.string.setting_force_udp_relay_key, false));
            }
        }
        return false;
    }

    public static z82 v(pl1 pl1Var) {
        pl1Var.getClass();
        l9 l9Var = new l9();
        l9Var.f = pl1Var;
        l9Var.z = vd3.y0;
        return l9Var;
    }

    public static String w(String str, Object... objArr) {
        int iIndexOf;
        StringBuilder sb = new StringBuilder((objArr.length * 16) + str.length());
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length && (iIndexOf = str.indexOf("%s", i3)) != -1) {
            sb.append((CharSequence) str, i3, iIndexOf);
            sb.append(x(objArr[i2]));
            i3 = iIndexOf + 2;
            i2++;
        }
        sb.append((CharSequence) str, i3, str.length());
        if (i2 < objArr.length) {
            String str2 = " [";
            while (i2 < objArr.length) {
                sb.append(str2);
                sb.append(x(objArr[i2]));
                i2++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String x(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e2) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for ".concat(str), (Throwable) e2);
            StringBuilder sbD = fw.D("<", str, " threw ");
            sbD.append(e2.getClass().getName());
            sbD.append(">");
            return sbD.toString();
        }
    }

    public static final void y(Context context) {
        Map mapSingletonMap;
        context.getClass();
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        databasePath.getClass();
        if (databasePath.exists()) {
            ue2.g().a(ow4.a, "Migrating WorkDatabase to the no-backup directory");
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            databasePath2.getClass();
            File noBackupFilesDir = context.getNoBackupFilesDir();
            noBackupFilesDir.getClass();
            String[] strArr = ow4.b;
            int iU = fh2.U(strArr.length);
            if (iU < 16) {
                iU = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iU);
            for (String str : strArr) {
                linkedHashMap.put(new File(databasePath2.getPath() + str), new File(noBackupFilesDir.getPath() + str));
            }
            if (linkedHashMap.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(databasePath2, noBackupFilesDir);
                mapSingletonMap.getClass();
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
                linkedHashMap2.put(databasePath2, noBackupFilesDir);
                mapSingletonMap = linkedHashMap2;
            }
            for (Map.Entry entry : mapSingletonMap.entrySet()) {
                File file = (File) entry.getKey();
                File file2 = (File) entry.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        ue2.g().j(ow4.a, "Over-writing contents of " + file2);
                    }
                    ue2.g().a(ow4.a, file.renameTo(file2) ? "Migrated " + file + "to " + file2 : "Renaming " + file + " to " + file2 + " failed");
                }
            }
        }
    }

    public static final boolean z(String str) {
        str.getClass();
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public abstract int D(mh2 mh2Var, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7);

    public abstract List d(String str, List list);

    public abstract Path p(float f2, float f3, float f4, float f5);
}
