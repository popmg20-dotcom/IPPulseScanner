package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t3 implements c8 {
    public static final w2 a = new w2();
    public static final u2 b = new u2();
    public static final v2 c = new v2();
    public static final t2 d = new t2();
    public static final int[] e = new int[0];
    public static final long[] f = new long[0];
    public static final double[] g = new double[0];

    public static e2 A(a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        long jC = aVar.C(spliterator);
        if (jC < 0 || !spliterator.hasCharacteristics(16384)) {
            k0 k0Var = new k0();
            k0Var.a = intFunction;
            e2 e2Var = (e2) new j2(aVar, spliterator, k0Var, new v0(21), 3).invoke();
            return z ? I(e2Var, intFunction) : e2Var;
        }
        if (jC >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jC);
        new o3(spliterator, aVar, objArr).invoke();
        return new h2(objArr);
    }

    public static y1 B(a aVar, Spliterator spliterator, boolean z) {
        long jC = aVar.C(spliterator);
        if (jC < 0 || !spliterator.hasCharacteristics(16384)) {
            y1 y1Var = (y1) new j2(aVar, spliterator, new v0(15), new v0(16), 0).invoke();
            return z ? J(y1Var) : y1Var;
        }
        if (jC >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) jC];
        new l3(spliterator, aVar, dArr).invoke();
        return new q2(dArr);
    }

    public static a2 C(a aVar, Spliterator spliterator, boolean z) {
        long jC = aVar.C(spliterator);
        if (jC < 0 || !spliterator.hasCharacteristics(16384)) {
            a2 a2Var = (a2) new j2(aVar, spliterator, new v0(17), new v0(18), 1).invoke();
            return z ? K(a2Var) : a2Var;
        }
        if (jC >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) jC];
        new m3(spliterator, aVar, iArr).invoke();
        return new z2(iArr);
    }

    public static c2 D(a aVar, Spliterator spliterator, boolean z) {
        long jC = aVar.C(spliterator);
        if (jC < 0 || !spliterator.hasCharacteristics(16384)) {
            c2 c2Var = (c2) new j2(aVar, spliterator, new v0(19), new v0(20), 2).invoke();
            return z ? L(c2Var) : c2Var;
        }
        if (jC >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) jC];
        new n3(spliterator, aVar, jArr).invoke();
        return new i3(jArr);
    }

    public static g2 E(x6 x6Var, e2 e2Var, e2 e2Var2) {
        int i = f2.a[x6Var.ordinal()];
        if (i == 1) {
            return new p2(e2Var, e2Var2);
        }
        if (i == 2) {
            return new m2((a2) e2Var, (a2) e2Var2);
        }
        if (i == 3) {
            return new n2((c2) e2Var, (c2) e2Var2);
        }
        if (i == 4) {
            return new l2((y1) e2Var, (y1) e2Var2);
        }
        throw new IllegalStateException("Unknown shape " + x6Var);
    }

    public static t1 F(long j) {
        return (j < 0 || j >= 2147483639) ? new s2() : new r2(j);
    }

    public static x2 G(x6 x6Var) {
        int i = f2.a[x6Var.ordinal()];
        if (i == 1) {
            return a;
        }
        if (i == 2) {
            return b;
        }
        if (i == 3) {
            return c;
        }
        if (i == 4) {
            return d;
        }
        throw new IllegalStateException("Unknown shape " + x6Var);
    }

    public static int H(long j) {
        return (j != -1 ? w6.u : 0) | w6.t;
    }

    public static e2 I(e2 e2Var, IntFunction intFunction) {
        if (e2Var.o() <= 0) {
            return e2Var;
        }
        long jCount = e2Var.count();
        if (jCount >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) jCount);
        new s3(e2Var, objArr, 1).invoke();
        return new h2(objArr);
    }

    public static y1 J(y1 y1Var) {
        if (y1Var.o() <= 0) {
            return y1Var;
        }
        long jCount = y1Var.count();
        if (jCount >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        double[] dArr = new double[(int) jCount];
        new r3(y1Var, dArr, 0).invoke();
        return new q2(dArr);
    }

    public static a2 K(a2 a2Var) {
        if (a2Var.o() <= 0) {
            return a2Var;
        }
        long jCount = a2Var.count();
        if (jCount >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        int[] iArr = new int[(int) jCount];
        new r3(a2Var, iArr, 0).invoke();
        return new z2(iArr);
    }

    public static c2 L(c2 c2Var) {
        if (c2Var.o() <= 0) {
            return c2Var;
        }
        long jCount = c2Var.count();
        if (jCount >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        long[] jArr = new long[(int) jCount];
        new r3(c2Var, jArr, 0).invoke();
        return new i3(jArr);
    }

    public static Set M(Set set) {
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof g) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    g gVar = (g) it.next();
                    hashSet.add(gVar == null ? null : gVar == g.CONCURRENT ? Collector.Characteristics.CONCURRENT : gVar == g.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                } catch (ClassCastException e2) {
                    j$.util.f.a(e2, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        } else {
            if (!(next instanceof Collector.Characteristics)) {
                j$.util.f.a(next.getClass(), "java.util.stream.Collector.Characteristics");
                throw null;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    Collector.Characteristics characteristics = (Collector.Characteristics) it2.next();
                    hashSet.add(characteristics == null ? null : characteristics == Collector.Characteristics.CONCURRENT ? g.CONCURRENT : characteristics == Collector.Characteristics.UNORDERED ? g.UNORDERED : g.IDENTITY_FINISH);
                } catch (ClassCastException e3) {
                    j$.util.f.a(e3, "java.util.stream.Collector.Characteristics");
                    throw null;
                }
            }
        }
        return hashSet;
    }

    public static j$.util.p N(Function function) {
        j$.util.p pVar = new j$.util.p(7);
        pVar.b = function;
        return pVar;
    }

    public static u1 O(long j) {
        return (j < 0 || j >= 2147483639) ? new b3() : new a3(j);
    }

    public static v1 P(long j) {
        return (j < 0 || j >= 2147483639) ? new k3() : new j3(j);
    }

    public static j$.time.format.t Q(r1 r1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r1Var);
        return new j$.time.format.t(x6.DOUBLE_VALUE, r1Var, new l1(r1Var, 1));
    }

    public static r5 R(a0 a0Var, long j, long j2) {
        if (j >= 0) {
            return new r5(a0Var, H(j2), j, j2);
        }
        j$.time.h.a(j);
        return null;
    }

    public static j$.time.format.t S(r1 r1Var, IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate);
        Objects.requireNonNull(r1Var);
        return new j$.time.format.t(x6.INT_VALUE, r1Var, new j$.time.format.t(6, r1Var, intPredicate));
    }

    public static n5 T(a1 a1Var, long j, long j2) {
        if (j >= 0) {
            return new n5(a1Var, H(j2), j, j2);
        }
        j$.time.h.a(j);
        return null;
    }

    public static j$.time.format.t U(r1 r1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r1Var);
        return new j$.time.format.t(x6.LONG_VALUE, r1Var, new l1(r1Var, 0));
    }

    public static p5 V(i1 i1Var, long j, long j2) {
        if (j >= 0) {
            return new p5(i1Var, H(j2), j, j2);
        }
        j$.time.h.a(j);
        return null;
    }

    public static j$.time.format.t W(r1 r1Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(r1Var);
        return new j$.time.format.t(x6.REFERENCE, r1Var, new j$.time.format.t(7, r1Var, predicate));
    }

    public static l5 X(b5 b5Var, long j, long j2) {
        if (j >= 0) {
            return new l5(b5Var, H(j2), j, j2);
        }
        j$.time.h.a(j);
        return null;
    }

    public static Spliterator Z(x6 x6Var, Spliterator spliterator, long j, long j2) {
        long jZ = z(j, j2);
        int i = s5.a[x6Var.ordinal()];
        if (i == 1) {
            return new q7(spliterator, j, jZ);
        }
        if (i == 2) {
            return new n7((j$.util.w0) spliterator, j, jZ);
        }
        if (i == 3) {
            return new o7((j$.util.z0) spliterator, j, jZ);
        }
        if (i == 4) {
            return new m7((j$.util.t0) spliterator, j, jZ);
        }
        throw new IllegalStateException("Unknown shape " + x6Var);
    }

    public static void c() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void d(g5 g5Var, Double d2) {
        if (e8.a) {
            e8.a(g5Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
        g5Var.accept(d2.doubleValue());
    }

    public static void g(h5 h5Var, Integer num) {
        if (e8.a) {
            e8.a(h5Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
        h5Var.accept(num.intValue());
    }

    public static void i(i5 i5Var, Long l) {
        if (e8.a) {
            e8.a(i5Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
        i5Var.accept(l.longValue());
    }

    public static void k() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void l() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static Object[] m(d2 d2Var, IntFunction intFunction) {
        if (e8.a) {
            e8.a(d2Var.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        }
        if (d2Var.count() >= 2147483639) {
            j$.time.h.c("Stream size exceeds max array size");
            return null;
        }
        Object[] objArr = (Object[]) intFunction.apply((int) d2Var.count());
        d2Var.k(objArr, 0);
        return objArr;
    }

    public static void n(y1 y1Var, Double[] dArr, int i) {
        if (e8.a) {
            e8.a(y1Var.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
            throw null;
        }
        double[] dArr2 = (double[]) y1Var.b();
        for (int i2 = 0; i2 < dArr2.length; i2++) {
            dArr[i + i2] = Double.valueOf(dArr2[i2]);
        }
    }

    public static void o(a2 a2Var, Integer[] numArr, int i) {
        if (e8.a) {
            e8.a(a2Var.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
            throw null;
        }
        int[] iArr = (int[]) a2Var.b();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i + i2] = Integer.valueOf(iArr[i2]);
        }
    }

    public static void p(c2 c2Var, Long[] lArr, int i) {
        if (e8.a) {
            e8.a(c2Var.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
            throw null;
        }
        long[] jArr = (long[]) c2Var.b();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i + i2] = Long.valueOf(jArr[i2]);
        }
    }

    public static void q(y1 y1Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            y1Var.g((DoubleConsumer) consumer);
        } else {
            if (e8.a) {
                e8.a(y1Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.t0) y1Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void r(a2 a2Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            a2Var.g((IntConsumer) consumer);
        } else {
            if (e8.a) {
                e8.a(a2Var.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.w0) a2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static void s(c2 c2Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            c2Var.g((LongConsumer) consumer);
        } else {
            if (e8.a) {
                e8.a(c2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
                throw null;
            }
            ((j$.util.z0) c2Var.spliterator()).forEachRemaining(consumer);
        }
    }

    public static y1 t(y1 y1Var, long j, long j2) {
        if (j == 0 && j2 == y1Var.count()) {
            return y1Var;
        }
        long j3 = j2 - j;
        j$.util.t0 t0Var = (j$.util.t0) y1Var.spliterator();
        t1 t1VarF = F(j3);
        t1VarF.c(j3);
        int i = 0;
        for (int i2 = 0; i2 < j && t0Var.tryAdvance((DoubleConsumer) new x1(i)); i2++) {
        }
        if (j2 == y1Var.count()) {
            t0Var.forEachRemaining((DoubleConsumer) t1VarF);
        } else {
            while (i < j3 && t0Var.tryAdvance((DoubleConsumer) t1VarF)) {
                i++;
            }
        }
        t1VarF.end();
        return t1VarF.build();
    }

    public static a2 u(a2 a2Var, long j, long j2) {
        if (j == 0 && j2 == a2Var.count()) {
            return a2Var;
        }
        long j3 = j2 - j;
        j$.util.w0 w0Var = (j$.util.w0) a2Var.spliterator();
        u1 u1VarO = O(j3);
        u1VarO.c(j3);
        int i = 0;
        for (int i2 = 0; i2 < j && w0Var.tryAdvance((IntConsumer) new z1(i)); i2++) {
        }
        if (j2 == a2Var.count()) {
            w0Var.forEachRemaining((IntConsumer) u1VarO);
        } else {
            while (i < j3 && w0Var.tryAdvance((IntConsumer) u1VarO)) {
                i++;
            }
        }
        u1VarO.end();
        return u1VarO.build();
    }

    public static c2 v(c2 c2Var, long j, long j2) {
        if (j == 0 && j2 == c2Var.count()) {
            return c2Var;
        }
        long j3 = j2 - j;
        j$.util.z0 z0Var = (j$.util.z0) c2Var.spliterator();
        v1 v1VarP = P(j3);
        v1VarP.c(j3);
        int i = 0;
        for (int i2 = 0; i2 < j && z0Var.tryAdvance((LongConsumer) new b2(i)); i2++) {
        }
        if (j2 == c2Var.count()) {
            z0Var.forEachRemaining((LongConsumer) v1VarP);
        } else {
            while (i < j3 && z0Var.tryAdvance((LongConsumer) v1VarP)) {
                i++;
            }
        }
        v1VarP.end();
        return v1VarP.build();
    }

    public static e2 w(e2 e2Var, long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == e2Var.count()) {
            return e2Var;
        }
        Spliterator spliterator = e2Var.spliterator();
        long j3 = j2 - j;
        w1 w1VarX = x(j3, intFunction);
        w1VarX.c(j3);
        for (int i = 0; i < j && spliterator.tryAdvance(new v0(13)); i++) {
        }
        if (j2 == e2Var.count()) {
            spliterator.forEachRemaining(w1VarX);
        } else {
            for (int i2 = 0; i2 < j3 && spliterator.tryAdvance(w1VarX); i2++) {
            }
        }
        w1VarX.end();
        return w1VarX.build();
    }

    public static w1 x(long j, IntFunction intFunction) {
        return (j < 0 || j >= 2147483639) ? new q3() : new y2(j, intFunction);
    }

    public static long y(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1L;
    }

    public static long z(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    public abstract o4 Y();

    @Override // j$.util.stream.c8
    public Object a(a aVar, Spliterator spliterator) {
        o4 o4VarY = Y();
        aVar.N(spliterator, o4VarY);
        return o4VarY.get();
    }

    @Override // j$.util.stream.c8
    public Object b(a aVar, Spliterator spliterator) {
        return ((o4) new v4(this, aVar, spliterator).invoke()).get();
    }

    @Override // j$.util.stream.c8
    public int f() {
        return 0;
    }
}
