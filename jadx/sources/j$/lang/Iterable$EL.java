package j$.lang;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.p1;
import j$.util.q0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;

/* JADX INFO: renamed from: j$.lang.Iterable$-EL, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class Iterable$EL {
    public static void forEach(Iterable iterable, Consumer consumer) {
        if (iterable instanceof a) {
            ((a) iterable).forEach(consumer);
            return;
        }
        if (!(iterable instanceof Collection)) {
            Iterable$CC.$default$forEach(iterable, consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        Iterator it = ((Collection) iterable).iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public static Spliterator spliterator(Iterable iterable) {
        if (iterable instanceof a) {
            return ((a) iterable).spliterator();
        }
        if (iterable instanceof LinkedHashSet) {
            return Spliterators.spliterator((LinkedHashSet) iterable, 17);
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            return new q0(sortedSet, sortedSet);
        }
        if (iterable instanceof Set) {
            return Spliterators.spliterator((Set) iterable, 1);
        }
        if (!(iterable instanceof List)) {
            return iterable instanceof Collection ? Spliterators.spliterator((Collection) iterable, 0) : new p1((Iterator) Objects.requireNonNull(iterable.iterator()), 0);
        }
        List list = (List) iterable;
        return list instanceof RandomAccess ? new j$.util.a(list) : Spliterators.spliterator(list, 16);
    }
}
