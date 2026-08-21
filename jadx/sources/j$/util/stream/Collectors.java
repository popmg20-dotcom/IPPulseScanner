package j$.util.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class Collectors {
    public static final Set a;
    public static final Set b;
    public static final Set c;

    static {
        g gVar = g.CONCURRENT;
        g gVar2 = g.UNORDERED;
        g gVar3 = g.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(gVar, gVar2, gVar3));
        Collections.unmodifiableSet(EnumSet.of(gVar, gVar2));
        a = Collections.unmodifiableSet(EnumSet.of(gVar3));
        b = Collections.unmodifiableSet(EnumSet.of(gVar2, gVar3));
        c = Collections.EMPTY_SET;
        Collections.unmodifiableSet(EnumSet.of(gVar2));
    }

    public static void a(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence charSequence) {
        return new j(new j$.util.p(5, charSequence), new j$.time.z(22), new j$.time.z(23), new j$.time.z(24), c);
    }

    public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> supplier) {
        return new j(supplier, new j$.time.z(12), new j$.time.z(13), a);
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new j(new j$.time.z(14), new j$.time.z(15), new j$.time.z(20), a);
    }

    public static <T> Collector<T, ?, Set<T>> toSet() {
        return new j(new j$.time.z(17), new j$.time.z(18), new j$.time.z(25), b);
    }
}
