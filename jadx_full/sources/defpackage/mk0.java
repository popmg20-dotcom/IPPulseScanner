package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mk0 {
    public static final Charset g = StandardCharsets.UTF_8;
    public static final int[] h = {0, 0, 2048, 526336, 0};
    public final t60 a;
    public final long b;
    public final ByteBuffer d;
    public final ConcurrentHashMap e;
    public final CharsetDecoder c = g.newDecoder();
    public final jd f = new jd(6, this);

    public mk0(t60 t60Var, ByteBuffer byteBuffer, long j, ConcurrentHashMap concurrentHashMap) {
        this.a = t60Var;
        this.b = j;
        this.d = byteBuffer;
        this.e = concurrentHashMap;
    }

    public static int c(ByteBuffer byteBuffer, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            i = (i << 8) | (byteBuffer.get() & 255);
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x020b, code lost:
    
        r8.put(((defpackage.gj2) r19).name(), java.lang.Integer.valueOf(r15));
        r15 = r15 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.math.BigInteger] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final o2 a(Class cls, Type type) throws a60 {
        Class cls2;
        Type type2;
        Map map;
        ?? ValueOf;
        int i;
        Constructor<?> constructor;
        Type[] genericParameterTypes;
        HashMap map2;
        Class<?>[] parameterTypes;
        ?? bigInteger;
        ByteBuffer byteBuffer = this.d;
        byte b = byteBuffer.get();
        int i2 = b & 255;
        int i3 = ((byte) ((b & 255) >>> 5)) & 255;
        ei4[] ei4VarArr = ei4.z;
        if (i3 >= ei4VarArr.length) {
            throw new a60("The MaxMind DB file's data section contains bad data");
        }
        ei4 ei4Var = ei4VarArr[i3];
        boolean z = false;
        if (ei4Var.equals(ei4.f)) {
            int i4 = ((i2 >>> 3) & 3) + 1;
            int iC = (int) (((long) c(byteBuffer, i4 != 4 ? (byte) (b & 7) : (byte) 0, i4)) + this.b + ((long) h[i4]));
            int iPosition = byteBuffer.position();
            this.a.getClass();
            mk0 mk0Var = (mk0) this.f.f;
            ByteBuffer byteBuffer2 = mk0Var.d;
            if (iC >= byteBuffer2.capacity()) {
                throw new a60("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
            }
            byteBuffer2.position(iC);
            o2 o2VarA = mk0Var.a(cls, type);
            byteBuffer.position(iPosition);
            return o2VarA;
        }
        if (ei4Var.equals(ei4.b)) {
            int i5 = byteBuffer.get() + 7;
            if (i5 < 8) {
                throw new a60(ha0.k("Something went horribly wrong in the decoder. An extended type resolved to a type number < 8 (", i5, ")"));
            }
            if (i5 >= ei4VarArr.length) {
                throw new a60("The MaxMind DB file's data section contains bad data");
            }
            ei4Var = ei4VarArr[i5];
        }
        int iB = b & 31;
        if (iB >= 29) {
            iB = iB != 29 ? iB != 30 ? 65821 + b(3) : b(2) + 285 : (byteBuffer.get() & 255) + 29;
        }
        int iOrdinal = ei4Var.ordinal();
        Class<?> cls3 = Integer.TYPE;
        switch (iOrdinal) {
            case 2:
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + iB);
                String string = this.c.decode(byteBuffer).toString();
                byteBuffer.limit(iLimit);
                ValueOf = string;
                return new o2(ValueOf);
            case 3:
                if (iB != 8) {
                    throw new a60("The MaxMind DB file's data section contains bad data: invalid size of double.");
                }
                ValueOf = Double.valueOf(byteBuffer.getDouble());
                return new o2(ValueOf);
            case 4:
                byte[] bArr = new byte[iB];
                byteBuffer.get(bArr);
                ValueOf = bArr;
                return new o2(ValueOf);
            case 5:
                ValueOf = Integer.valueOf(b(iB));
                return new o2(ValueOf);
            case 6:
                long j = 0;
                for (int i6 = 0; i6 < iB; i6++) {
                    j = (j << 8) | ((long) (byteBuffer.get() & 255));
                }
                ValueOf = Long.valueOf(j);
                return new o2(ValueOf);
            case 7:
                if (!Map.class.isAssignableFrom(cls) && !cls.equals(Object.class)) {
                    ConcurrentHashMap concurrentHashMap = this.e;
                    ru ruVar = (ru) concurrentHashMap.get(cls);
                    if (ruVar == null) {
                        Constructor<?>[] constructors = cls.getConstructors();
                        int length = constructors.length;
                        for (int i7 = 0; i7 < length; i7++) {
                            constructor = constructors[i7];
                            if (constructor.getAnnotation(fj2.class) != null) {
                                parameterTypes = constructor.getParameterTypes();
                                genericParameterTypes = constructor.getGenericParameterTypes();
                                map2 = new HashMap();
                                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                                int i8 = 0;
                                i = 0;
                                while (i8 < constructor.getParameterTypes().length) {
                                    Annotation[] annotationArr = parameterAnnotations[i8];
                                    int length2 = annotationArr.length;
                                    int i9 = 0;
                                    while (i9 < length2) {
                                        Annotation annotation = annotationArr[i9];
                                        Annotation[] annotationArr2 = annotationArr;
                                        int i10 = length2;
                                        if (!annotation.annotationType().equals(gj2.class)) {
                                            i9++;
                                            annotationArr = annotationArr2;
                                            length2 = i10;
                                        }
                                    }
                                    StringBuilder sbD = dw2.D("Constructor parameter ", i8, " on class ");
                                    sbD.append(cls.getName());
                                    sbD.append(" is not annotated with MaxMindDbParameter.");
                                    throw new t80(sbD.toString());
                                }
                                concurrentHashMap.put(cls, new ru(constructor, parameterTypes, genericParameterTypes, map2));
                            }
                        }
                        throw new t80("No constructor on class " + cls.getName() + " with the MaxMindDbConstructor annotation was found.");
                    }
                    i = 0;
                    constructor = ruVar.a;
                    Class<?>[] clsArr = ruVar.b;
                    genericParameterTypes = ruVar.c;
                    map2 = ruVar.d;
                    parameterTypes = clsArr;
                    Object[] objArr = new Object[parameterTypes.length];
                    for (int i11 = i; i11 < iB; i11++) {
                        Integer num = (Integer) map2.get((String) a(String.class, null).a);
                        if (num == null) {
                            byteBuffer.position(d(byteBuffer.position(), 1));
                        } else {
                            objArr[num.intValue()] = a(parameterTypes[num.intValue()], genericParameterTypes[num.intValue()]).a;
                        }
                    }
                    try {
                        ValueOf = constructor.newInstance(objArr);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        ad0.i(e, "Error creating object: ");
                        return null;
                    }
                    break;
                } else if (type instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    if (actualTypeArguments.length != 2) {
                        cls2 = Object.class;
                    } else {
                        if (!((Class) actualTypeArguments[0]).equals(String.class)) {
                            throw new t80("Map keys must be strings.");
                        }
                        cls2 = (Class) actualTypeArguments[1];
                    }
                    if (cls.equals(Map.class) || cls.equals(Object.class)) {
                        type2 = null;
                        map = new HashMap(iB);
                    } else {
                        try {
                            try {
                                map = (Map) cls.getConstructor(cls3).newInstance(Integer.valueOf(iB));
                                type2 = null;
                            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
                                ad0.i(e2, "Error creating map: ");
                                return null;
                            }
                        } catch (NoSuchMethodException e3) {
                            ad0.i(e3, "No constructor found for the Map: ");
                            return null;
                        }
                    }
                    for (int i12 = 0; i12 < iB; i12++) {
                        map.put((String) a(String.class, type2).a, cls2.cast(a(cls2, type2).a));
                    }
                    ValueOf = map;
                }
                return new o2(ValueOf);
            case 8:
                ValueOf = Integer.valueOf(b(iB));
                return new o2(ValueOf);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
            case 10:
                byte[] bArr2 = new byte[iB];
                byteBuffer.get(bArr2);
                bigInteger = new BigInteger(1, bArr2);
                ValueOf = bigInteger;
                return new o2(ValueOf);
            case 11:
                if (type instanceof ParameterizedType) {
                    Type[] actualTypeArguments2 = ((ParameterizedType) type).getActualTypeArguments();
                    Class cls4 = actualTypeArguments2.length == 1 ? (Class) actualTypeArguments2[0] : Object.class;
                    if (!List.class.isAssignableFrom(cls) && !cls.equals(Object.class)) {
                        throw new t80(dw2.B(cls, "Unable to deserialize an array into an "));
                    }
                    if (cls.equals(List.class) || cls.equals(Object.class)) {
                        bigInteger = new ArrayList(iB);
                    } else {
                        try {
                            try {
                                bigInteger = (List) cls.getConstructor(cls3).newInstance(Integer.valueOf(iB));
                            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e4) {
                                ad0.i(e4, "Error creating list: ");
                                return null;
                            }
                        } catch (NoSuchMethodException e5) {
                            ad0.i(e5, "No constructor found for the List: ");
                            return null;
                        }
                    }
                    for (int i13 = 0; i13 < iB; i13++) {
                        bigInteger.add(cls4.cast(a(cls4, null).a));
                    }
                    ValueOf = bigInteger;
                    break;
                }
                return new o2(ValueOf);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case 13:
            default:
                throw new a60("Unknown or unexpected type: " + ei4Var.name());
            case 14:
                if (iB != 0) {
                    if (iB != 1) {
                        throw new a60("The MaxMind DB file's data section contains bad data: invalid size of boolean.");
                    }
                    z = true;
                }
                ValueOf = Boolean.valueOf(z);
                return new o2(ValueOf);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                if (iB != 4) {
                    throw new a60("The MaxMind DB file's data section contains bad data: invalid size of float.");
                }
                ValueOf = Float.valueOf(byteBuffer.getFloat());
                return new o2(ValueOf);
        }
    }

    public final int b(int i) {
        return c(this.d, 0, i);
    }

    public final int d(int i, int i2) throws a60 {
        if (i2 == 0) {
            return i;
        }
        ByteBuffer byteBuffer = this.d;
        if (i >= byteBuffer.capacity()) {
            throw new a60("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
        }
        byteBuffer.position(i);
        byte b = byteBuffer.get();
        int i3 = b & 255;
        int i4 = i + 1;
        int i5 = ((byte) ((b & 255) >>> 5)) & 255;
        ei4[] ei4VarArr = ei4.z;
        if (i5 >= ei4VarArr.length) {
            throw new a60("The MaxMind DB file's data section contains bad data");
        }
        ei4 ei4Var = ei4VarArr[i5];
        if (ei4Var.equals(ei4.b)) {
            int i6 = byteBuffer.get() + 7;
            if (i6 < 8) {
                throw new a60(ha0.k("Something went horribly wrong in the decoder. An extended type resolved to a type number < 8 (", i6, ")"));
            }
            if (i6 >= ei4VarArr.length) {
                throw new a60("The MaxMind DB file's data section contains bad data");
            }
            ei4Var = ei4VarArr[i6];
            i4 = i + 2;
        }
        int iB = b & 31;
        if (iB >= 29) {
            i4 += iB - 28;
            iB = iB != 29 ? iB != 30 ? 65821 + b(3) : b(2) + 285 : (byteBuffer.get() & 255) + 29;
        }
        int iOrdinal = ei4Var.ordinal();
        if (iOrdinal == 1) {
            i4 += ((i3 >>> 3) & 3) + 1;
        } else if (iOrdinal == 7) {
            i2 += iB * 2;
        } else if (iOrdinal == 11) {
            i2 += iB;
        } else if (iOrdinal != 14) {
            i4 += iB;
        }
        return d(i4, i2 - 1);
    }
}
