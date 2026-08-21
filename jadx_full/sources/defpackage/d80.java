package defpackage;

import java.util.AbstractQueue;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d80 extends AbstractQueue {
    public final /* synthetic */ s03 b;

    public d80(s03 s03Var) {
        this.b = s03Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public final Object peek() {
        return this.b.e();
    }

    @Override // java.util.Queue
    public final Object poll() {
        return this.b.next();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        throw new UnsupportedOperationException();
    }
}
