package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c92 implements Iterator {
    public final /* synthetic */ int b = 0;
    public Iterator f;

    public c92(y25 y25Var) {
        this.f = y25Var.b.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.b) {
        }
        return this.f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.b) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f.next();
                if (!(entry.getValue() instanceof d92)) {
                    return entry;
                }
                b92 b92Var = new b92();
                b92Var.b = entry;
                return b92Var;
            case 1:
                return this.f.next();
            default:
                return (String) this.f.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.b) {
            case 0:
                this.f.remove();
                return;
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException("Remove not supported");
        }
    }

    public /* synthetic */ c92() {
    }

    public c92(Iterator it) {
        this.f = it;
    }
}
