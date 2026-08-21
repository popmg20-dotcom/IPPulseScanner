package j$.util;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements Iterator, y {
    public final /* synthetic */ int a = 0;
    public final Iterator b;

    public l(m mVar) {
        this.b = mVar.a.iterator();
    }

    @Override // java.util.Iterator, j$.util.y
    public final void forEachRemaining(Consumer consumer) {
        switch (this.a) {
            case 0:
                j$.time.a.I(this.b, consumer);
                break;
            default:
                j$.time.a.I(this.b, new p(0, consumer));
                break;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.a) {
        }
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                return this.b.next();
            default:
                return new q((Map.Entry) this.b.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public l(s sVar) {
        this.b = sVar.a.iterator();
    }
}
