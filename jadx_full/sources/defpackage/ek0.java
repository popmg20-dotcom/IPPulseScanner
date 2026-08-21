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
    */
    public static final long J(long j2, ez0 ez0Var) {
        long j3;
        TimeUnit timeUnit = ez0Var.b;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        long jConvert = timeUnit.convert(4611686018426999999L, timeUnit2);
        if ((-jConvert) <= j2 && j2 <= jConvert) {
            long jConvert2 = timeUnit2.convert(j2, timeUnit);
            vd3 vd3Var = cz0.b;
            long j4 = jConvert2 << 1;
            int i2 = dz0.a;
            return j4;
        }
        if (ez0Var.compareTo(ez0.MILLISECONDS) < 0) {
            return f(gb4.w(TimeUnit.MILLISECONDS.convert(j2, timeUnit), -4611686018427387903L, 4611686018427387903L));
        }
        long jSignum = Long.signum(j2);
        if (j2 < -9223372036854775807L) {
            j2 = -9223372036854775807L;
        }
        long jAbs = Math.abs(j2);
        int iOrdinal = ez0Var.ordinal();
        long j5 = 0;
        if (iOrdinal == 2) {
            j3 = 1;
        } else if (iOrdinal == 3) {
            j3 = 1000;
        } else if (iOrdinal == 4) {
            j3 = 60000;
        } else if (iOrdinal == 5) {
            j3 = 3600000;
        } else {
            if (iOrdinal != 6) {
                ad0.o(ez0Var, "Wrong unit for millisMultiplier: ");
                return 0L;
            }
            j3 = 86400000;
        }
        if (jAbs == 0) {
            jAbs = j5;
        } else {
            j5 = 4611686018427387903L;
            if (jAbs == 1) {
                if (j3 <= 4611686018427387903L) {
                    jAbs = j3;
                }
            } else if (j3 != 1) {
                int iNumberOfLeadingZeros = (128 - Long.numberOfLeadingZeros(jAbs)) - Long.numberOfLeadingZeros(j3);
                if (iNumberOfLeadingZeros < 63) {
                    jAbs *= j3;
                } else if (iNumberOfLeadingZeros <= 63) {
                    jAbs *= j3;
                    if (jAbs > 4611686018427387903L) {
                    }
                }
            } else if (jAbs > 4611686018427387903L) {
            }
        }
        return f(jSignum * jAbs);
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
    */
    public static final Object c(r92 r92Var, ie0 ie0Var) throws Throwable {
        d dVar;
        r92 r92Var2;
        bh3 bh3Var;
        Throwable th;
        ca2 ca2Var;
        ca2 ca2Var2;
        if (ie0Var instanceof d) {
            dVar = (d) ie0Var;
            int i2 = dVar.Z;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.Z = i2 - Integer.MIN_VALUE;
            } else {
                dVar = new d(ie0Var);
            }
        }
        Object obj = dVar.Y;
        int i3 = dVar.Z;
        xl4 xl4Var = xl4.a;
        if (i3 != 0) {
            if (i3 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bh3Var = dVar.X;
            r92Var2 = dVar.A;
            try {
                n12.S(obj);
                ca2Var2 = (ca2) bh3Var.b;
                if (ca2Var2 != null) {
                    r92Var2.c(ca2Var2);
                }
                return xl4Var;
            } catch (Throwable th2) {
                th = th2;
                ca2Var = (ca2) bh3Var.b;
                if (ca2Var != null) {
                }
                throw th;
            }
        }
        n12.S(obj);
        if (r92Var.b().compareTo(q92.A) >= 0) {
            return xl4Var;
        }
        bh3 bh3Var2 = new bh3();
        try {
            dVar.A = r92Var;
            dVar.X = bh3Var2;
            dVar.Z = 1;
            z00 z00Var = new z00(1, p95.u(dVar));
            z00Var.w();
            e eVar = new e(z00Var);
            bh3Var2.b = eVar;
            r92Var.a(eVar);
            Object objU = z00Var.u();
            mf0 mf0Var = mf0.b;
            if (objU == mf0Var) {
                return mf0Var;
            }
            r92Var2 = r92Var;
            bh3Var = bh3Var2;
            ca2Var2 = (ca2) bh3Var.b;
            if (ca2Var2 != null) {
            }
            return xl4Var;
        } catch (Throwable th3) {
            r92Var2 = r92Var;
            bh3Var = bh3Var2;
            th = th3;
            ca2Var = (ca2) bh3Var.b;
            if (ca2Var != null) {
                r92Var2.c(ca2Var);
            }
            throw th;
        }
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
