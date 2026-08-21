package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.util.Comparator;
import j$.util.DesugarTimeZone;
import j$.util.Objects;
import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.TimeZoneRetargetInterface;
import j$.util.b0;
import j$.util.c0;
import j$.util.d0;
import j$.util.h0;
import j$.util.i1;
import j$.util.l0;
import j$.util.t0;
import j$.util.t1;
import j$.util.w0;
import j$.util.z0;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.TimeZone;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static Optional A(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static j$.util.a0 B(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? new j$.util.a0(optionalDouble.getAsDouble()) : j$.util.a0.c;
    }

    public static b0 C(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? new b0(optionalInt.getAsInt()) : b0.c;
    }

    public static c0 D(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? new c0(optionalLong.getAsLong()) : c0.c;
    }

    public static java.util.Optional E(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? java.util.Optional.of(optional.get()) : java.util.Optional.empty();
    }

    public static OptionalDouble F(j$.util.a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        boolean z = a0Var.a;
        if (!z) {
            return OptionalDouble.empty();
        }
        if (z) {
            return OptionalDouble.of(a0Var.b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalInt G(b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        boolean z = b0Var.a;
        if (!z) {
            return OptionalInt.empty();
        }
        if (z) {
            return OptionalInt.of(b0Var.b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static OptionalLong H(c0 c0Var) {
        if (c0Var == null) {
            return null;
        }
        boolean z = c0Var.a;
        if (!z) {
            return OptionalLong.empty();
        }
        if (z) {
            return OptionalLong.of(c0Var.b);
        }
        throw new NoSuchElementException("No value present");
    }

    public static void I(Iterator it, Consumer consumer) {
        if (it instanceof j$.util.y) {
            ((j$.util.y) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static j$.time.chrono.a J(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        Object objRequireNonNull = (j$.time.chrono.a) temporalAccessor.m(j$.time.temporal.r.b);
        j$.time.chrono.s sVar = j$.time.chrono.s.c;
        if (objRequireNonNull == null) {
            objRequireNonNull = Objects.requireNonNull(sVar, "defaultObj");
        }
        return (j$.time.chrono.a) objRequireNonNull;
    }

    public static /* synthetic */ long K(long j, long j2) {
        long j3 = j + j2;
        if (((j2 ^ j) < 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ List L(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(Objects.requireNonNull(obj));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static /* synthetic */ Map.Entry M(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(obj), Objects.requireNonNull(obj2));
    }

    public static /* synthetic */ long N(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0L;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }

    public static /* synthetic */ long O(long j, long j2) {
        long j3 = j / j2;
        return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
    }

    public static /* synthetic */ long P(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (iNumberOfLeadingZeros >= 64) {
            if ((j2 != Long.MIN_VALUE) | (j >= 0)) {
                long j3 = j * j2;
                if (j == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long Q(long j, long j2) {
        long j3 = j - j2;
        if (((j2 ^ j) >= 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static String R(Object obj, Object obj2) {
        String string;
        String string2;
        String str = "null";
        if (obj == null || (string = obj.toString()) == null) {
            string = "null";
        }
        int length = string.length();
        if (obj2 != null && (string2 = obj2.toString()) != null) {
            str = string2;
        }
        int length2 = str.length();
        char[] cArr = new char[length + length2 + 1];
        string.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        str.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    public static i1 S(Object[] objArr, int i, int i2) {
        Spliterators.a(((Object[]) Objects.requireNonNull(objArr)).length, i, i2);
        return new i1(objArr, i, i2, 1040);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static b T() {
        TimeZone timeZone = TimeZone.getDefault();
        return new b(timeZone instanceof TimeZoneRetargetInterface ? ((TimeZoneRetargetInterface) timeZone).toZoneId() : DesugarTimeZone.toZoneId(timeZone));
    }

    public static /* synthetic */ Comparator U(Comparator comparator, Comparator comparator2) {
        return comparator instanceof j$.util.Comparator ? ((j$.util.Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public static j$.time.temporal.m a(j$.time.chrono.b bVar, j$.time.temporal.m mVar) {
        return mVar.c(bVar.t(), j$.time.temporal.a.EPOCH_DAY);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.b] */
    public static j$.util.function.b b(final DoubleConsumer doubleConsumer, final DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new DoubleConsumer() { // from class: j$.util.function.b
            @Override // java.util.function.DoubleConsumer
            public final void accept(double d) {
                doubleConsumer.accept(d);
                doubleConsumer2.accept(d);
            }

            public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer3) {
                return j$.time.a.b(this, doubleConsumer3);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.d] */
    public static j$.util.function.d c(final IntConsumer intConsumer, final IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new IntConsumer() { // from class: j$.util.function.d
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                intConsumer.accept(i);
                intConsumer2.accept(i);
            }

            public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer3) {
                return j$.time.a.c(this, intConsumer3);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.f] */
    public static j$.util.function.f d(final LongConsumer longConsumer, final LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new LongConsumer() { // from class: j$.util.function.f
            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                longConsumer.accept(j);
                longConsumer2.accept(j);
            }

            public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer3) {
                return j$.time.a.d(this, longConsumer3);
            }
        };
    }

    public static int e(j$.time.chrono.b bVar, j$.time.chrono.b bVar2) {
        int iCompare = Long.compare(bVar.t(), bVar2.t());
        if (iCompare != 0) {
            return iCompare;
        }
        return bVar.a().C().compareTo(bVar2.a().C());
    }

    public static int f(j$.time.chrono.e eVar, j$.time.chrono.e eVar2) {
        int iY = eVar.f().compareTo(eVar2.f());
        return (iY == 0 && (iY = eVar.b().compareTo(eVar2.b())) == 0) ? eVar.a().C().compareTo(eVar2.a().C()) : iY;
    }

    public static int g(j$.time.chrono.j jVar, j$.time.chrono.j jVar2) {
        int iCompare = Long.compare(jVar.z(), jVar2.z());
        return (iCompare == 0 && (iCompare = jVar.b().d - jVar2.b().d) == 0 && (iCompare = jVar.l().w(jVar2.l())) == 0 && (iCompare = jVar.r().B().compareTo(jVar2.r().B())) == 0) ? jVar.a().C().compareTo(jVar2.a().C()) : iCompare;
    }

    public static void h(t0 t0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            t0Var.forEachRemaining((DoubleConsumer) consumer);
        } else {
            if (t1.a) {
                t1.a(t0Var.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            t0Var.forEachRemaining((DoubleConsumer) new d0(consumer, 0));
        }
    }

    public static void i(w0 w0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            w0Var.forEachRemaining((IntConsumer) consumer);
        } else {
            if (t1.a) {
                t1.a(w0Var.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            w0Var.forEachRemaining((IntConsumer) new h0(consumer, 0));
        }
    }

    public static void j(z0 z0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            z0Var.forEachRemaining((LongConsumer) consumer);
        } else {
            if (t1.a) {
                t1.a(z0Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                throw null;
            }
            Objects.requireNonNull(consumer);
            z0Var.forEachRemaining((LongConsumer) new l0(consumer, 0));
        }
    }

    public static int k(j$.time.chrono.j jVar, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.r.a(jVar, qVar);
        }
        int i = j$.time.chrono.i.a[((j$.time.temporal.a) qVar).ordinal()];
        if (i != 1) {
            return i != 2 ? jVar.l().h(qVar) : jVar.g().b;
        }
        throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static int l(j$.time.chrono.m mVar, j$.time.temporal.q qVar) {
        return qVar == j$.time.temporal.a.ERA ? mVar.getValue() : j$.time.temporal.r.a(mVar, qVar);
    }

    public static long m(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    public static long n(j$.time.chrono.m mVar, j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ERA) {
            return mVar.getValue();
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        return qVar.m(mVar);
    }

    public static boolean o(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static boolean p(j$.time.chrono.b bVar, j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) qVar).isDateBased() : qVar != null && qVar.h(bVar);
    }

    public static boolean q(j$.time.chrono.m mVar, j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.ERA : qVar != null && qVar.h(mVar);
    }

    public static Object r(j$.time.chrono.b bVar, z zVar) {
        if (zVar == j$.time.temporal.r.a || zVar == j$.time.temporal.r.e || zVar == j$.time.temporal.r.d || zVar == j$.time.temporal.r.g) {
            return null;
        }
        return zVar == j$.time.temporal.r.b ? bVar.a() : zVar == j$.time.temporal.r.c ? j$.time.temporal.b.DAYS : zVar.g(bVar);
    }

    public static Object s(j$.time.chrono.e eVar, z zVar) {
        if (zVar == j$.time.temporal.r.a || zVar == j$.time.temporal.r.e || zVar == j$.time.temporal.r.d) {
            return null;
        }
        return zVar == j$.time.temporal.r.g ? eVar.b() : zVar == j$.time.temporal.r.b ? eVar.a() : zVar == j$.time.temporal.r.c ? j$.time.temporal.b.NANOS : zVar.g(eVar);
    }

    public static Object t(j$.time.chrono.j jVar, z zVar) {
        return (zVar == j$.time.temporal.r.e || zVar == j$.time.temporal.r.a) ? jVar.r() : zVar == j$.time.temporal.r.d ? jVar.g() : zVar == j$.time.temporal.r.g ? jVar.b() : zVar == j$.time.temporal.r.b ? jVar.a() : zVar == j$.time.temporal.r.c ? j$.time.temporal.b.NANOS : zVar.g(jVar);
    }

    public static Object u(j$.time.chrono.m mVar, z zVar) {
        return zVar == j$.time.temporal.r.c ? j$.time.temporal.b.ERAS : j$.time.temporal.r.c(mVar, zVar);
    }

    public static long v(j$.time.chrono.e eVar, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((eVar.f().t() * 86400) + ((long) eVar.b().N())) - ((long) zoneOffset.b);
    }

    public static long w(j$.time.chrono.j jVar) {
        return ((jVar.f().t() * 86400) + ((long) jVar.b().N())) - ((long) jVar.g().b);
    }

    public static boolean x(t0 t0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return t0Var.tryAdvance((DoubleConsumer) consumer);
        }
        if (t1.a) {
            t1.a(t0Var.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return t0Var.tryAdvance((DoubleConsumer) new d0(consumer, 0));
    }

    public static boolean y(w0 w0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return w0Var.tryAdvance((IntConsumer) consumer);
        }
        if (t1.a) {
            t1.a(w0Var.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return w0Var.tryAdvance((IntConsumer) new h0(consumer, 0));
    }

    public static boolean z(z0 z0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return z0Var.tryAdvance((LongConsumer) consumer);
        }
        if (t1.a) {
            t1.a(z0Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        return z0Var.tryAdvance((LongConsumer) new l0(consumer, 0));
    }

    public int characteristics() {
        return 16448;
    }

    public long estimateSize() {
        return 0L;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public Spliterator trySplit() {
        return null;
    }
}
