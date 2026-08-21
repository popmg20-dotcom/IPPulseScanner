package j$.util.concurrent;

import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, Serializable, ConcurrentMap<K, V> {
    public static final int g = Runtime.getRuntime().availableProcessors();
    public static final j$.sun.misc.a h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final int n;
    public static final int o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;
    public volatile transient l[] a;
    public volatile transient l[] b;
    private volatile transient long baseCount;
    public volatile transient c[] c;
    private volatile transient int cellsBusy;
    public transient i d;
    public transient s e;
    public transient e f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        j$.sun.misc.a aVar = j$.sun.misc.a.b;
        h = aVar;
        i = aVar.a(ConcurrentHashMap.class, "sizeCtl");
        j = aVar.a(ConcurrentHashMap.class, "transferIndex");
        k = aVar.a(ConcurrentHashMap.class, "baseCount");
        l = aVar.a(ConcurrentHashMap.class, "cellsBusy");
        m = aVar.a(c.class, "value");
        n = aVar.a.arrayBaseOffset(l[].class);
        int iArrayIndexScale = aVar.a.arrayIndexScale(l[].class);
        if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        o = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
    }

    public ConcurrentHashMap(int i2, float f, int i3) {
        if (f <= 0.0f || i2 < 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        long j2 = (long) (((double) ((i2 < i3 ? i3 : i2) / f)) + 1.0d);
        this.sizeCtl = j2 >= 1073741824 ? Pow2.MAX_POW2 : l((int) j2);
    }

    public static final boolean b(l[] lVarArr, int i2, l lVar) {
        j$.sun.misc.a aVar = h;
        long j2 = (((long) i2) << o) + ((long) n);
        Unsafe unsafe = aVar.a;
        while (true) {
            l[] lVarArr2 = lVarArr;
            l lVar2 = lVar;
            if (unsafe.compareAndSwapObject(lVarArr2, j2, (Object) null, lVar2)) {
                return true;
            }
            if (unsafe.getObject(lVarArr2, j2) != null) {
                return false;
            }
            lVarArr = lVarArr2;
            lVar = lVar2;
        }
    }

    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() != Comparable.class || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null || actualTypeArguments.length != 1 || actualTypeArguments[0] != cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    public static final void h(l[] lVarArr, int i2, l lVar) {
        j$.sun.misc.a aVar = h;
        aVar.a.putObjectVolatile(lVarArr, (((long) i2) << o) + ((long) n), lVar);
    }

    public static final int i(int i2) {
        return (i2 ^ (i2 >>> 16)) & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public static final l k(l[] lVarArr, int i2) {
        j$.sun.misc.a aVar = h;
        return (l) aVar.a.getObjectVolatile(lVarArr, (((long) i2) << o) + ((long) n));
    }

    public static final int l(int i2) {
        int iNumberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i2 - 1);
        if (iNumberOfLeadingZeros < 0) {
            return 1;
        }
        return iNumberOfLeadingZeros >= 1073741824 ? Pow2.MAX_POW2 : iNumberOfLeadingZeros + 1;
    }

    public static l p(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (l lVar3 = rVar; lVar3 != null; lVar3 = lVar3.d) {
            l lVar4 = new l(lVar3.a, lVar3.b, lVar3.c);
            if (lVar2 == null) {
                lVar = lVar4;
            } else {
                lVar2.d = lVar4;
            }
            lVar2 = lVar4;
        }
        return lVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j2;
        long j3;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j4 = 0;
        long j5 = 0;
        l lVar = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j2 = 1;
            if (object == null || object2 == null) {
                break;
            }
            j5++;
            lVar = new l(i(object.hashCode()), object, object2, lVar);
        }
        if (j5 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j6 = (long) (((double) (j5 / 0.75f)) + 1.0d);
        int iL = j6 >= 1073741824 ? Pow2.MAX_POW2 : l((int) j6);
        l[] lVarArr = new l[iL];
        int i2 = iL - 1;
        while (lVar != null) {
            l lVar2 = lVar.d;
            int i3 = lVar.a;
            int i4 = i3 & i2;
            l lVarK = k(lVarArr, i4);
            boolean z = true;
            if (lVarK == null) {
                j3 = j2;
            } else {
                Object obj2 = lVar.b;
                if (lVarK.a < 0) {
                    if (((q) lVarK).e(i3, obj2, lVar.c) == null) {
                        j4 += j2;
                    }
                    j3 = j2;
                } else {
                    j3 = j2;
                    int i5 = 0;
                    for (l lVar3 = lVarK; lVar3 != null; lVar3 = lVar3.d) {
                        if (lVar3.a == i3 && ((obj = lVar3.b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z = false;
                            break;
                        }
                        i5++;
                    }
                    if (z && i5 >= 8) {
                        j4 += j3;
                        lVar.d = lVarK;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.a, lVar4.b, lVar4.c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.d = rVar3;
                            }
                            lVar4 = lVar4.d;
                            rVar2 = rVar3;
                        }
                        h(lVarArr, i4, new q(rVar));
                    }
                }
                z = false;
            }
            if (z) {
                j4 += j3;
                lVar.d = lVarK;
                h(lVarArr, i4, lVar);
            }
            lVar = lVar2;
            j2 = j3;
        }
        this.a = lVarArr;
        this.sizeCtl = iL - (iL >>> 2);
        this.baseCount = j4;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i2 = 0;
        int i3 = 1;
        while (i3 < 16) {
            i2++;
            i3 <<= 1;
        }
        int i4 = 32 - i2;
        int i5 = i3 - 1;
        n[] nVarArr = new n[16];
        for (int i6 = 0; i6 < 16; i6++) {
            nVarArr[i6] = new n();
        }
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("segments", nVarArr);
        putFieldPutFields.put("segmentShift", i4);
        putFieldPutFields.put("segmentMask", i5);
        objectOutputStream.writeFields();
        l[] lVarArr = this.a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                objectOutputStream.writeObject(lVarA.b);
                objectOutputStream.writeObject(lVarA.c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x014f, code lost:
    
        if (r1.c != r6) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0151, code lost:
    
        r1.c = (j$.util.concurrent.c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(long j2, int i2) {
        boolean zCompareAndSwapLong;
        boolean z;
        int length;
        boolean z2;
        int length2;
        int length3;
        c cVar;
        long j3;
        l[] lVarArr;
        int length4;
        l[] lVarArr2;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        c[] cVarArr = concurrentHashMap.c;
        if (cVarArr == null) {
            j$.sun.misc.a aVar = h;
            long j4 = k;
            long j5 = concurrentHashMap.baseCount;
            j3 = j5 + j2;
            if (!aVar.a.compareAndSwapLong(concurrentHashMap, j4, j5, j3)) {
                if (cVarArr == null || (length3 = cVarArr.length - 1) < 0 || (cVar = cVarArr[length3 & ((ThreadLocalRandom) ThreadLocalRandom.f.get()).b]) == null) {
                    zCompareAndSwapLong = true;
                } else {
                    j$.sun.misc.a aVar2 = h;
                    long j6 = m;
                    long j7 = cVar.value;
                    zCompareAndSwapLong = aVar2.a.compareAndSwapLong(cVar, j6, j7, j7 + j2);
                    if (zCompareAndSwapLong) {
                        if (i2 <= 1) {
                            return;
                        } else {
                            j3 = concurrentHashMap.j();
                        }
                    }
                }
                t tVar = ThreadLocalRandom.f;
                int i3 = ((ThreadLocalRandom) tVar.get()).b;
                if (i3 == 0) {
                    ThreadLocalRandom.d();
                    i3 = ((ThreadLocalRandom) tVar.get()).b;
                    zCompareAndSwapLong = true;
                }
                boolean z3 = zCompareAndSwapLong;
                int i4 = i3;
                while (true) {
                    boolean z4 = false;
                    while (true) {
                        c[] cVarArr2 = concurrentHashMap.c;
                        if (cVarArr2 != null && (length = cVarArr2.length) > 0) {
                            c cVar2 = cVarArr2[(length - 1) & i4];
                            if (cVar2 != null) {
                                if (z3) {
                                    j$.sun.misc.a aVar3 = h;
                                    long j8 = m;
                                    long j9 = cVar2.value;
                                    if (aVar3.a.compareAndSwapLong(cVar2, j8, j9, j9 + j2)) {
                                        return;
                                    }
                                    if (concurrentHashMap.c == cVarArr2 && length < g) {
                                        if (!z4) {
                                            z4 = true;
                                        } else if (concurrentHashMap.cellsBusy == 0) {
                                            if (aVar3.a.compareAndSwapInt(concurrentHashMap, l, 0, 1)) {
                                                try {
                                                    break;
                                                } finally {
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    z3 = true;
                                }
                                int i5 = (i4 << 13) ^ i4;
                                int i6 = i5 ^ (i5 >>> 17);
                                int i7 = i6 ^ (i6 << 5);
                                ((ThreadLocalRandom) ThreadLocalRandom.f.get()).b = i7;
                                i4 = i7;
                                concurrentHashMap = this;
                            } else if (concurrentHashMap.cellsBusy == 0) {
                                c cVar3 = new c(j2);
                                if (concurrentHashMap.cellsBusy == 0) {
                                    if (h.a.compareAndSwapInt(concurrentHashMap, l, 0, 1)) {
                                        try {
                                            c[] cVarArr3 = concurrentHashMap.c;
                                            if (cVarArr3 == null || (length2 = cVarArr3.length) <= 0) {
                                                z2 = false;
                                                if (!z2) {
                                                    return;
                                                }
                                            } else {
                                                int i8 = (length2 - 1) & i4;
                                                if (cVarArr3[i8] == null) {
                                                    cVarArr3[i8] = cVar3;
                                                    z2 = true;
                                                }
                                                if (!z2) {
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            }
                            z4 = false;
                            int i52 = (i4 << 13) ^ i4;
                            int i62 = i52 ^ (i52 >>> 17);
                            int i72 = i62 ^ (i62 << 5);
                            ((ThreadLocalRandom) ThreadLocalRandom.f.get()).b = i72;
                            i4 = i72;
                            concurrentHashMap = this;
                        } else if (concurrentHashMap.cellsBusy == 0 && concurrentHashMap.c == cVarArr2) {
                            if (h.a.compareAndSwapInt(concurrentHashMap, l, 0, 1)) {
                                try {
                                    if (concurrentHashMap.c == cVarArr2) {
                                        c[] cVarArr4 = new c[2];
                                        cVarArr4[i4 & 1] = new c(j2);
                                        concurrentHashMap.c = cVarArr4;
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        return;
                                    }
                                } finally {
                                }
                            }
                            concurrentHashMap = this;
                        } else {
                            j$.sun.misc.a aVar4 = h;
                            long j10 = k;
                            long j11 = concurrentHashMap.baseCount;
                            if (aVar4.a.compareAndSwapLong(concurrentHashMap, j10, j11, j11 + j2)) {
                                return;
                            }
                            concurrentHashMap = this;
                        }
                    }
                }
            }
        }
        if (i2 < 0) {
            return;
        }
        while (true) {
            int i9 = concurrentHashMap.sizeCtl;
            if (j3 < i9 || (lVarArr = concurrentHashMap.a) == null || (length4 = lVarArr.length) >= 1073741824) {
                return;
            }
            int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(length4) | 32768;
            if (i9 >= 0) {
                if (h.a.compareAndSwapInt(concurrentHashMap, i, i9, (iNumberOfLeadingZeros << 16) + 2)) {
                    concurrentHashMap.m(lVarArr, null);
                }
            } else {
                if ((i9 >>> 16) != iNumberOfLeadingZeros || i9 == iNumberOfLeadingZeros + 1 || i9 == iNumberOfLeadingZeros + 65535 || (lVarArr2 = concurrentHashMap.b) == null || concurrentHashMap.transferIndex <= 0) {
                    return;
                }
                if (h.a.compareAndSwapInt(concurrentHashMap, i, i9, i9 + 1)) {
                    concurrentHashMap.m(lVarArr, lVarArr2);
                }
            }
            j3 = concurrentHashMap.j();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        l lVarK;
        l[] lVarArrD = this.a;
        long j2 = 0;
        loop0: while (true) {
            int i2 = 0;
            while (lVarArrD != null && i2 < lVarArrD.length) {
                lVarK = k(lVarArrD, i2);
                if (lVarK == null) {
                    i2++;
                } else {
                    int i3 = lVarK.a;
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (lVarK) {
                        try {
                            if (k(lVarArrD, i2) == lVarK) {
                                for (l lVar = i3 >= 0 ? lVarK : lVarK instanceof q ? ((q) lVarK).f : null; lVar != null; lVar = lVar.d) {
                                    j2--;
                                }
                                h(lVarArrD, i2, null);
                                i2++;
                            }
                        } finally {
                        }
                    }
                }
            }
            lVarArrD = d(lVarArrD, lVarK);
        }
        if (j2 != 0) {
            a(j2, -1);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        l lVar;
        Object objApply;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i2 = i(obj.hashCode());
        l[] lVarArrE = this.a;
        int i3 = 0;
        Object objApply2 = null;
        int i4 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i5 = (length - 1) & i2;
                    l lVarK = k(lVarArrE, i5);
                    if (lVarK == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArrE, i5, mVar)) {
                                    try {
                                        objApply2 = biFunction.apply(obj, null);
                                        if (objApply2 != null) {
                                            lVar = new l(i2, obj, objApply2);
                                            i4 = 1;
                                        } else {
                                            lVar = null;
                                        }
                                        h(lVarArrE, i5, lVar);
                                        i3 = 1;
                                    } catch (Throwable th) {
                                        h(lVarArrE, i5, null);
                                        throw th;
                                    }
                                }
                            } finally {
                            }
                        }
                        if (i3 != 0) {
                        }
                    } else {
                        int i6 = lVarK.a;
                        if (i6 == -1) {
                            lVarArrE = d(lVarArrE, lVarK);
                        } else {
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArrE, i5) == lVarK) {
                                        if (i6 >= 0) {
                                            l lVar2 = null;
                                            l lVar3 = lVarK;
                                            i3 = 1;
                                            while (true) {
                                                if (lVar3.a == i2 && ((obj2 = lVar3.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                    break;
                                                }
                                                l lVar4 = lVar3.d;
                                                if (lVar4 == null) {
                                                    objApply = biFunction.apply(obj, null);
                                                    if (objApply != null) {
                                                        if (lVar3.d != null) {
                                                            throw new IllegalStateException("Recursive update");
                                                        }
                                                        lVar3.d = new l(i2, obj, objApply);
                                                        i4 = 1;
                                                    }
                                                } else {
                                                    i3++;
                                                    lVar2 = lVar3;
                                                    lVar3 = lVar4;
                                                }
                                            }
                                            Object objApply3 = biFunction.apply(obj, lVar3.c);
                                            if (objApply3 != null) {
                                                lVar3.c = objApply3;
                                                objApply2 = objApply3;
                                            } else {
                                                l lVar5 = lVar3.d;
                                                if (lVar2 != null) {
                                                    lVar2.d = lVar5;
                                                } else {
                                                    h(lVarArrE, i5, lVar5);
                                                }
                                                objApply2 = objApply3;
                                                i4 = -1;
                                            }
                                        } else if (lVarK instanceof q) {
                                            q qVar = (q) lVarK;
                                            r rVar = qVar.e;
                                            r rVarB = rVar != null ? rVar.b(i2, obj, null) : null;
                                            objApply = biFunction.apply(obj, rVarB == null ? null : rVarB.c);
                                            if (objApply != null) {
                                                if (rVarB != null) {
                                                    rVarB.c = objApply;
                                                } else {
                                                    qVar.e(i2, obj, objApply);
                                                    i4 = 1;
                                                }
                                            } else if (rVarB != null) {
                                                if (qVar.f(rVarB)) {
                                                    h(lVarArrE, i5, p(qVar.f));
                                                }
                                                i4 = -1;
                                            }
                                            i3 = 1;
                                            objApply2 = objApply;
                                        } else if (lVarK instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    n(lVarArrE, i5);
                                }
                            }
                        }
                    }
                }
            }
            lVarArrE = e();
        }
        if (i4 != 0) {
            a(i4, i3);
        }
        return objApply2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r5 = r5.c;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeIfAbsent(Object obj, Function function) {
        r rVarB;
        Object obj2;
        Object obj3;
        Object obj4;
        if (obj == null || function == null) {
            throw null;
        }
        int i2 = i(obj.hashCode());
        l[] lVarArrE = this.a;
        Object objApply = null;
        int i3 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i4 = (length - 1) & i2;
                    l lVarK = k(lVarArrE, i4);
                    boolean z = true;
                    if (lVarK == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArrE, i4, mVar)) {
                                    try {
                                        objApply = function.apply(obj);
                                        h(lVarArrE, i4, objApply != null ? new l(i2, obj, objApply) : null);
                                        i3 = 1;
                                    } catch (Throwable th) {
                                        h(lVarArrE, i4, null);
                                        throw th;
                                    }
                                }
                            } finally {
                            }
                        }
                        if (i3 != 0) {
                        }
                    } else {
                        int i5 = lVarK.a;
                        if (i5 == -1) {
                            lVarArrE = d(lVarArrE, lVarK);
                        } else {
                            if (i5 == i2 && (((obj3 = lVarK.b) == obj || (obj3 != null && obj.equals(obj3))) && (obj4 = lVarK.c) != null)) {
                                return obj4;
                            }
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArrE, i4) == lVarK) {
                                        if (i5 >= 0) {
                                            l lVar = lVarK;
                                            i3 = 1;
                                            while (true) {
                                                if (lVar.a == i2 && ((obj2 = lVar.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                    break;
                                                }
                                                l lVar2 = lVar.d;
                                                if (lVar2 == null) {
                                                    Object objApply2 = function.apply(obj);
                                                    if (objApply2 == null) {
                                                        z = false;
                                                    } else {
                                                        if (lVar.d != null) {
                                                            throw new IllegalStateException("Recursive update");
                                                        }
                                                        lVar.d = new l(i2, obj, objApply2);
                                                    }
                                                    objApply = objApply2;
                                                } else {
                                                    i3++;
                                                    lVar = lVar2;
                                                }
                                            }
                                        } else if (lVarK instanceof q) {
                                            q qVar = (q) lVarK;
                                            r rVar = qVar.e;
                                            if (rVar == null || (rVarB = rVar.b(i2, obj, null)) == null) {
                                                objApply = function.apply(obj);
                                                if (objApply != null) {
                                                    qVar.e(i2, obj, objApply);
                                                } else {
                                                    z = false;
                                                }
                                            } else {
                                                z = false;
                                                objApply = rVarB.c;
                                            }
                                            i3 = 2;
                                        } else if (lVarK instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                    z = false;
                                } finally {
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    n(lVarArrE, i4);
                                }
                                if (!z) {
                                    return objApply;
                                }
                            }
                        }
                    }
                }
            }
            lVarArrE = e();
        }
        if (objApply != null) {
            a(1L, i3);
        }
        return objApply;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00aa, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        r rVarB;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i2 = i(obj.hashCode());
        l[] lVarArrE = this.a;
        int i3 = 0;
        Object objApply = null;
        int i4 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i5 = (length - 1) & i2;
                    l lVarK = k(lVarArrE, i5);
                    if (lVarK == null) {
                        break;
                    }
                    int i6 = lVarK.a;
                    if (i6 == -1) {
                        lVarArrE = d(lVarArrE, lVarK);
                    } else {
                        synchronized (lVarK) {
                            try {
                                if (k(lVarArrE, i5) == lVarK) {
                                    if (i6 < 0) {
                                        if (!(lVarK instanceof q)) {
                                            if (lVarK instanceof m) {
                                                break;
                                            }
                                        } else {
                                            q qVar = (q) lVarK;
                                            r rVar = qVar.e;
                                            if (rVar != null && (rVarB = rVar.b(i2, obj, null)) != null) {
                                                objApply = biFunction.apply(obj, rVarB.c);
                                                if (objApply != null) {
                                                    rVarB.c = objApply;
                                                } else {
                                                    if (qVar.f(rVarB)) {
                                                        h(lVarArrE, i5, p(qVar.f));
                                                    }
                                                    i3 = -1;
                                                }
                                            }
                                            i4 = 2;
                                        }
                                    } else {
                                        i4 = 1;
                                        l lVar = null;
                                        l lVar2 = lVarK;
                                        while (true) {
                                            if (lVar2.a != i2 || ((obj2 = lVar2.b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                                                l lVar3 = lVar2.d;
                                                if (lVar3 == null) {
                                                    break;
                                                }
                                                i4++;
                                                lVar = lVar2;
                                                lVar2 = lVar3;
                                            }
                                        }
                                        objApply = biFunction.apply(obj, lVar2.c);
                                        if (objApply != null) {
                                            lVar2.c = objApply;
                                        } else {
                                            l lVar4 = lVar2.d;
                                            if (lVar != null) {
                                                lVar.d = lVar4;
                                            } else {
                                                h(lVarArrE, i5, lVar4);
                                            }
                                            i3 = -1;
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (i4 != 0) {
                            break;
                        }
                    }
                }
            }
            lVarArrE = e();
        }
        if (i3 != 0) {
            a(i3, i4);
        }
        return objApply;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                Object obj2 = lVarA.c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final l[] d(l[] lVarArr, l lVar) {
        int i2;
        if (!(lVar instanceof g)) {
            return this.a;
        }
        l[] lVarArr2 = ((g) lVar).e;
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
        while (lVarArr2 == this.b && this.a == lVarArr && (i2 = this.sizeCtl) < 0 && (i2 >>> 16) == iNumberOfLeadingZeros && i2 != iNumberOfLeadingZeros + 1 && i2 != 65535 + iNumberOfLeadingZeros && this.transferIndex > 0) {
            ConcurrentHashMap<K, V> concurrentHashMap = this;
            if (h.a.compareAndSwapInt(concurrentHashMap, i, i2, i2 + 1)) {
                concurrentHashMap.m(lVarArr, lVarArr2);
                return lVarArr2;
            }
            this = concurrentHashMap;
        }
        return lVarArr2;
    }

    public final l[] e() {
        while (true) {
            l[] lVarArr = this.a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i2 = this.sizeCtl;
            if (i2 < 0) {
                Thread.yield();
            } else {
                ConcurrentHashMap<K, V> concurrentHashMap = this;
                if (h.a.compareAndSwapInt(concurrentHashMap, i, i2, -1)) {
                    try {
                        l[] lVarArr2 = concurrentHashMap.a;
                        if (lVarArr2 == null || lVarArr2.length == 0) {
                            int i3 = i2 > 0 ? i2 : 16;
                            l[] lVarArr3 = new l[i3];
                            concurrentHashMap.a = lVarArr3;
                            i2 = i3 - (i3 >>> 2);
                            lVarArr2 = lVarArr3;
                        }
                        concurrentHashMap.sizeCtl = i2;
                        return lVarArr2;
                    } catch (Throwable th) {
                        concurrentHashMap.sizeCtl = i2;
                        throw th;
                    }
                }
                this = concurrentHashMap;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                        return false;
                    }
                }
                return true;
            }
            Object obj2 = lVarA.c;
            Object obj3 = map.get(lVarA.b);
            if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                break;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006a, code lost:
    
        r7 = r6.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006c, code lost:
    
        if (r11 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006e, code lost:
    
        r6.c = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a5, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(Object obj, Object obj2, boolean z) {
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        if (obj == null || obj2 == null) {
            throw null;
        }
        int i2 = i(obj.hashCode());
        l[] lVarArrE = this.a;
        int i3 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i4 = (length - 1) & i2;
                    l lVarK = k(lVarArrE, i4);
                    if (lVarK != null) {
                        int i5 = lVarK.a;
                        if (i5 == -1) {
                            lVarArrE = d(lVarArrE, lVarK);
                        } else {
                            if (z && i5 == i2 && (((obj5 = lVarK.b) == obj || (obj5 != null && obj.equals(obj5))) && (obj6 = lVarK.c) != null)) {
                                return obj6;
                            }
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArrE, i4) == lVarK) {
                                        if (i5 < 0) {
                                            if (!(lVarK instanceof q)) {
                                                if (lVarK instanceof m) {
                                                    break;
                                                }
                                            } else {
                                                r rVarE = ((q) lVarK).e(i2, obj, obj2);
                                                if (rVarE != null) {
                                                    Object obj7 = rVarE.c;
                                                    if (!z) {
                                                        rVarE.c = obj2;
                                                    }
                                                    obj3 = obj7;
                                                } else {
                                                    obj3 = null;
                                                }
                                                i3 = 2;
                                            }
                                        } else {
                                            i3 = 1;
                                            l lVar = lVarK;
                                            while (true) {
                                                if (lVar.a == i2 && ((obj4 = lVar.b) == obj || (obj4 != null && obj.equals(obj4)))) {
                                                    break;
                                                }
                                                l lVar2 = lVar.d;
                                                if (lVar2 == null) {
                                                    lVar.d = new l(i2, obj, obj2);
                                                    break;
                                                }
                                                i3++;
                                                lVar = lVar2;
                                            }
                                        }
                                    }
                                    obj3 = null;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (i3 != 0) {
                                if (i3 >= 8) {
                                    n(lVarArrE, i4);
                                }
                                if (obj3 != null) {
                                    return obj3;
                                }
                            }
                        }
                    } else if (b(lVarArrE, i4, new l(i2, obj, obj2))) {
                        break;
                    }
                }
            }
            lVarArrE = e();
        }
        a(1L, i3);
        return null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            } else {
                biConsumer.accept(lVarA.b, lVarA.c);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r9 = r5.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r15 == r9) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (r9 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
    
        if (r15.equals(r9) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        if (r14 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0055, code lost:
    
        r5.c = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
    
        r5 = r5.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005a, code lost:
    
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
    
        r8.d = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:
    
        h(r1, r3, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Object obj, Object obj2, Object obj3) {
        int length;
        int i2;
        l lVarK;
        boolean z;
        Object obj4;
        r rVarB;
        Object obj5;
        int i3 = i(obj.hashCode());
        l[] lVarArrD = this.a;
        while (true) {
            if (lVarArrD == null || (length = lVarArrD.length) == 0 || (lVarK = k(lVarArrD, (i2 = (length - 1) & i3))) == null) {
                break;
            }
            int i4 = lVarK.a;
            if (i4 == -1) {
                lVarArrD = d(lVarArrD, lVarK);
            } else {
                synchronized (lVarK) {
                    try {
                        if (k(lVarArrD, i2) == lVarK) {
                            z = true;
                            if (i4 >= 0) {
                                l lVar = null;
                                l lVar2 = lVarK;
                                while (true) {
                                    if (lVar2.a != i3 || ((obj5 = lVar2.b) != obj && (obj5 == null || !obj.equals(obj5)))) {
                                        l lVar3 = lVar2.d;
                                        if (lVar3 == null) {
                                            break;
                                        }
                                        lVar = lVar2;
                                        lVar2 = lVar3;
                                    }
                                }
                                obj4 = null;
                            } else if (lVarK instanceof q) {
                                q qVar = (q) lVarK;
                                r rVar = qVar.e;
                                if (rVar != null && (rVarB = rVar.b(i3, obj, null)) != null) {
                                    obj4 = rVarB.c;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            rVarB.c = obj2;
                                        } else if (qVar.f(rVarB)) {
                                            h(lVarArrD, i2, p(qVar.f));
                                        }
                                    }
                                }
                                obj4 = null;
                            } else if (lVarK instanceof m) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                        z = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int length;
        l lVarK;
        Object obj2;
        int i2 = i(obj.hashCode());
        l[] lVarArr = this.a;
        if (lVarArr == null || (length = lVarArr.length) <= 0 || (lVarK = k(lVarArr, (length - 1) & i2)) == null) {
            return null;
        }
        int i3 = lVarK.a;
        if (i3 == i2) {
            Object obj3 = lVarK.b;
            if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                return (V) lVarK.c;
            }
        } else if (i3 < 0) {
            l lVarA = lVarK.a(i2, obj);
            if (lVarA != null) {
                return (V) lVarA.c;
            }
            return null;
        }
        while (true) {
            lVarK = lVarK.d;
            if (lVarK == null) {
                return null;
            }
            if (lVarK.a == i2 && ((obj2 = lVarK.b) == obj || (obj2 != null && obj.equals(obj2)))) {
                break;
            }
        }
        return (V) lVarK.c;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        V v = get(obj);
        return v == null ? obj2 : v;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        l[] lVarArr = this.a;
        int iHashCode = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                iHashCode += lVarA.c.hashCode() ^ lVarA.b.hashCode();
            }
        }
        return iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return j() <= 0;
    }

    public final long j() {
        c[] cVarArr = this.c;
        long j2 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.value;
                }
            }
        }
        return j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i iVar = this.d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.d = iVar2;
        return iVar2;
    }

    public Enumeration<K> keys() {
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, this, 0);
    }

    public final void m(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        int i2;
        boolean z;
        char c;
        int i3;
        int i4;
        l lVar;
        int i5;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int length = lVarArr.length;
        int i6 = g;
        boolean z2 = true;
        int i7 = i6 > 1 ? (length >>> 3) / i6 : length;
        char c2 = 16;
        int i8 = i7 < 16 ? 16 : i7;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr4 = new l[length << 1];
                concurrentHashMap.b = lVarArr4;
                concurrentHashMap.transferIndex = length;
                lVarArr3 = lVarArr4;
            } catch (Throwable unused) {
                concurrentHashMap.sizeCtl = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar = new g(lVarArr3);
        boolean zB = true;
        int i9 = 0;
        int i10 = 0;
        boolean z3 = false;
        while (true) {
            if (zB) {
                int i11 = i9 - 1;
                if (i11 >= i10 || z3) {
                    i10 = i10;
                    i9 = i11;
                    zB = false;
                } else {
                    int i12 = concurrentHashMap.transferIndex;
                    if (i12 <= 0) {
                        i9 = -1;
                    } else {
                        j$.sun.misc.a aVar = h;
                        long j2 = j;
                        int i13 = i12 > i8 ? i12 - i8 : 0;
                        int i14 = i10;
                        if (aVar.a.compareAndSwapInt(concurrentHashMap, j2, i12, i13)) {
                            i9 = i12 - 1;
                            i10 = i13;
                        } else {
                            i10 = i14;
                            i9 = i11;
                        }
                    }
                    zB = false;
                }
            } else {
                int i15 = i10;
                r rVar = null;
                l lVar2 = null;
                if (i9 < 0 || i9 >= length || (i4 = i9 + length) >= length2) {
                    i2 = length;
                    z = z2;
                    c = c2;
                    i3 = i8;
                    if (z3) {
                        concurrentHashMap.b = null;
                        concurrentHashMap.a = lVarArr3;
                        concurrentHashMap.sizeCtl = (i2 << 1) - (i2 >>> 1);
                        return;
                    }
                    j$.sun.misc.a aVar2 = h;
                    long j3 = i;
                    int i16 = concurrentHashMap.sizeCtl;
                    int i17 = i9;
                    if (!aVar2.a.compareAndSwapInt(concurrentHashMap, j3, i16, i16 - 1)) {
                        i9 = i17;
                    } else {
                        if (i16 - 2 != ((Integer.numberOfLeadingZeros(i2) | 32768) << 16)) {
                            return;
                        }
                        zB = z;
                        z3 = zB;
                        i9 = i2;
                    }
                } else {
                    l lVarK = k(lVarArr, i9);
                    if (lVarK == null) {
                        zB = b(lVarArr, i9, gVar);
                        i2 = length;
                        z = z2;
                        c = c2;
                        i3 = i8;
                    } else {
                        z = z2;
                        int i18 = lVarK.a;
                        if (i18 == -1) {
                            i2 = length;
                            c = c2;
                            i3 = i8;
                            zB = z;
                        } else {
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArr, i9) == lVarK) {
                                        if (i18 >= 0) {
                                            int i19 = i18 & length;
                                            l lVar3 = lVarK.d;
                                            l lVar4 = lVarK;
                                            while (lVar3 != null) {
                                                char c3 = c2;
                                                int i20 = lVar3.a & length;
                                                if (i20 != i19) {
                                                    lVar4 = lVar3;
                                                    i19 = i20;
                                                }
                                                lVar3 = lVar3.d;
                                                c2 = c3;
                                            }
                                            c = c2;
                                            if (i19 == 0) {
                                                lVar = null;
                                                lVar2 = lVar4;
                                            } else {
                                                lVar = lVar4;
                                            }
                                            l lVar5 = lVarK;
                                            while (lVar5 != lVar4) {
                                                int i21 = lVar5.a;
                                                Object obj = lVar5.b;
                                                int i22 = length;
                                                Object obj2 = lVar5.c;
                                                if ((i21 & i22) == 0) {
                                                    i5 = i8;
                                                    lVar2 = new l(i21, obj, obj2, lVar2);
                                                } else {
                                                    i5 = i8;
                                                    lVar = new l(i21, obj, obj2, lVar);
                                                }
                                                lVar5 = lVar5.d;
                                                length = i22;
                                                i8 = i5;
                                            }
                                            i2 = length;
                                            i3 = i8;
                                            h(lVarArr3, i9, lVar2);
                                            h(lVarArr3, i4, lVar);
                                            h(lVarArr, i9, gVar);
                                        } else {
                                            i2 = length;
                                            c = c2;
                                            i3 = i8;
                                            if (lVarK instanceof q) {
                                                q qVar = (q) lVarK;
                                                r rVar2 = null;
                                                r rVar3 = null;
                                                l lVar6 = qVar.f;
                                                int i23 = 0;
                                                int i24 = 0;
                                                r rVar4 = null;
                                                while (lVar6 != null) {
                                                    q qVar2 = qVar;
                                                    int i25 = lVar6.a;
                                                    r rVar5 = new r(i25, lVar6.b, lVar6.c, null, null);
                                                    if ((i25 & i2) == 0) {
                                                        rVar5.h = rVar3;
                                                        if (rVar3 == null) {
                                                            rVar = rVar5;
                                                        } else {
                                                            rVar3.d = rVar5;
                                                        }
                                                        i23++;
                                                        rVar3 = rVar5;
                                                    } else {
                                                        rVar5.h = rVar2;
                                                        if (rVar2 == null) {
                                                            rVar4 = rVar5;
                                                        } else {
                                                            rVar2.d = rVar5;
                                                        }
                                                        i24++;
                                                        rVar2 = rVar5;
                                                    }
                                                    lVar6 = lVar6.d;
                                                    qVar = qVar2;
                                                }
                                                q qVar3 = qVar;
                                                l lVarP = i23 <= 6 ? p(rVar) : i24 != 0 ? new q(rVar) : qVar3;
                                                l lVarP2 = i24 <= 6 ? p(rVar4) : i23 != 0 ? new q(rVar4) : qVar3;
                                                h(lVarArr3, i9, lVarP);
                                                h(lVarArr3, i4, lVarP2);
                                                h(lVarArr, i9, gVar);
                                            }
                                        }
                                        zB = z;
                                    } else {
                                        i2 = length;
                                        c = c2;
                                        i3 = i8;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                concurrentHashMap = this;
                i10 = i15;
                z2 = z;
                c2 = c;
                length = i2;
                i8 = i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        int i2;
        Object obj3;
        Object obj4 = obj2;
        if (obj == null || obj4 == null || biFunction == null) {
            throw null;
        }
        int i3 = i(obj.hashCode());
        l[] lVarArrE = this.a;
        int i4 = 0;
        Object obj5 = null;
        int i5 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i6 = (length - 1) & i3;
                    l lVarK = k(lVarArrE, i6);
                    i2 = 1;
                    if (lVarK != null) {
                        int i7 = lVarK.a;
                        if (i7 == -1) {
                            lVarArrE = d(lVarArrE, lVarK);
                        } else {
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArrE, i6) == lVarK) {
                                        if (i7 < 0) {
                                            if (!(lVarK instanceof q)) {
                                                if (lVarK instanceof m) {
                                                    break;
                                                }
                                            } else {
                                                q qVar = (q) lVarK;
                                                r rVar = qVar.e;
                                                r rVarB = rVar == null ? null : rVar.b(i3, obj, null);
                                                Object objApply = rVarB == null ? obj4 : biFunction.apply(rVarB.c, obj4);
                                                if (objApply != null) {
                                                    if (rVarB != null) {
                                                        rVarB.c = objApply;
                                                    } else {
                                                        qVar.e(i3, obj, objApply);
                                                        i5 = 1;
                                                    }
                                                } else if (rVarB != null) {
                                                    if (qVar.f(rVarB)) {
                                                        h(lVarArrE, i6, p(qVar.f));
                                                    }
                                                    i5 = -1;
                                                }
                                                i4 = 2;
                                                obj5 = objApply;
                                            }
                                        } else {
                                            l lVar = null;
                                            l lVar2 = lVarK;
                                            i4 = 1;
                                            while (true) {
                                                if (lVar2.a != i3 || ((obj3 = lVar2.b) != obj && (obj3 == null || !obj.equals(obj3)))) {
                                                    l lVar3 = lVar2.d;
                                                    if (lVar3 == null) {
                                                        lVar2.d = new l(i3, obj, obj4);
                                                        obj5 = obj4;
                                                        i5 = 1;
                                                        break;
                                                    }
                                                    i4++;
                                                    lVar = lVar2;
                                                    lVar2 = lVar3;
                                                }
                                            }
                                            Object objApply2 = biFunction.apply(lVar2.c, obj4);
                                            if (objApply2 != null) {
                                                lVar2.c = objApply2;
                                                obj5 = objApply2;
                                            } else {
                                                l lVar4 = lVar2.d;
                                                if (lVar != null) {
                                                    lVar.d = lVar4;
                                                } else {
                                                    h(lVarArrE, i6, lVar4);
                                                }
                                                obj5 = objApply2;
                                                i5 = -1;
                                            }
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (i4 != 0) {
                                if (i4 >= 8) {
                                    n(lVarArrE, i6);
                                }
                                i2 = i5;
                                obj4 = obj5;
                            }
                        }
                    } else if (b(lVarArrE, i6, new l(i3, obj, obj4))) {
                        break;
                    }
                }
            }
            lVarArrE = e();
        }
        if (i2 != 0) {
            a(i2, i4);
        }
        return obj4;
    }

    public final void n(l[] lVarArr, int i2) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l lVarK = k(lVarArr, i2);
        if (lVarK == null || lVarK.a < 0) {
            return;
        }
        synchronized (lVarK) {
            try {
                if (k(lVarArr, i2) == lVarK) {
                    r rVar = null;
                    l lVar = lVarK;
                    r rVar2 = null;
                    while (lVar != null) {
                        r rVar3 = new r(lVar.a, lVar.b, lVar.c, null, null);
                        rVar3.h = rVar2;
                        if (rVar2 == null) {
                            rVar = rVar3;
                        } else {
                            rVar2.d = rVar3;
                        }
                        lVar = lVar.d;
                        rVar2 = rVar3;
                    }
                    h(lVarArr, i2, new q(rVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(int i2) {
        ConcurrentHashMap<K, V> concurrentHashMap;
        int length;
        int iL = i2 >= 536870912 ? 1073741824 : l(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.sizeCtl;
            if (i3 < 0) {
                return;
            }
            l[] lVarArr = this.a;
            if (lVarArr == null || (length = lVarArr.length) == 0) {
                concurrentHashMap = this;
                int i4 = i3 > iL ? i3 : iL;
                if (h.a.compareAndSwapInt(concurrentHashMap, i, i3, -1)) {
                    try {
                        if (concurrentHashMap.a == lVarArr) {
                            concurrentHashMap.a = new l[i4];
                            i3 = i4 - (i4 >>> 2);
                        }
                    } finally {
                        concurrentHashMap.sizeCtl = i3;
                    }
                } else {
                    continue;
                }
            } else {
                if (iL <= i3 || length >= 1073741824) {
                    return;
                }
                if (lVarArr == this.a) {
                    int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(length) | 32768;
                    j$.sun.misc.a aVar = h;
                    long j2 = i;
                    int i5 = (iNumberOfLeadingZeros << 16) + 2;
                    Unsafe unsafe = aVar.a;
                    concurrentHashMap = this;
                    if (unsafe.compareAndSwapInt(concurrentHashMap, j2, i3, i5)) {
                        concurrentHashMap.m(lVarArr, null);
                    }
                } else {
                    concurrentHashMap = this;
                }
            }
            this = concurrentHashMap;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        return (V) f(k2, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        o(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k2, V v) {
        return (V) f(k2, v, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return g(obj, obj3, obj2) != null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            }
            Object obj = lVarA.c;
            Object obj2 = lVarA.b;
            do {
                Object objApply = biFunction.apply(obj2, obj);
                objApply.getClass();
                if (g(obj2, objApply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = j();
        if (j2 < 0) {
            return 0;
        }
        return j2 > 2147483647L ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : (int) j2;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        l[] lVarArr = this.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l lVarA = pVar.a();
        if (lVarA != null) {
            while (true) {
                Object obj = lVarA.b;
                Object obj2 = lVarA.c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        s sVar = this.e;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.e = sVar2;
        return sVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) g(obj, null, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return g(obj, obj2, null);
        }
        throw null;
    }

    public ConcurrentHashMap(int i2) {
        this(i2, 0.75f, 1);
    }

    public ConcurrentHashMap(Map<? extends K, ? extends V> map) {
        this.sizeCtl = 16;
        putAll(map);
    }

    public ConcurrentHashMap(int i2, float f) {
        this(i2, f, 1);
    }

    public ConcurrentHashMap() {
    }
}
