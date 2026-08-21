package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends z4 {
    public static i2 Q(a aVar, Spliterator spliterator) {
        j$.time.z zVar = new j$.time.z(26);
        j$.time.z zVar2 = new j$.time.z(27);
        j$.time.z zVar3 = new j$.time.z(28);
        Objects.requireNonNull(zVar);
        Objects.requireNonNull(zVar2);
        Objects.requireNonNull(zVar3);
        return new i2((Collection) new y3(x6.REFERENCE, zVar3, zVar2, zVar, 3).b(aVar, spliterator));
    }

    @Override // j$.util.stream.a
    public final e2 G(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (w6.DISTINCT.k(aVar.f)) {
            return aVar.y(spliterator, false, intFunction);
        }
        if (w6.ORDERED.k(aVar.f)) {
            return Q(aVar, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        j$.time.format.t tVar = new j$.time.format.t(5, atomicBoolean, concurrentHashMap);
        Objects.requireNonNull(tVar);
        new o0(tVar, false).g(aVar, spliterator);
        Collection collectionKeySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(collectionKeySet);
            hashSet.add(null);
            collectionKeySet = hashSet;
        }
        return new i2(collectionKeySet);
    }

    @Override // j$.util.stream.a
    public final Spliterator H(a aVar, Spliterator spliterator) {
        return w6.DISTINCT.k(aVar.f) ? aVar.P(spliterator) : w6.ORDERED.k(aVar.f) ? Q(aVar, spliterator).spliterator() : new f7(aVar.P(spliterator), new ConcurrentHashMap());
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        Objects.requireNonNull(j5Var);
        return w6.DISTINCT.k(i) ? j5Var : w6.SORTED.k(i) ? new k(j5Var) : new l(j5Var);
    }
}
