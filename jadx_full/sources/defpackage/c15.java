package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c15 implements Iterator {
    public final /* synthetic */ Iterator b;
    public final /* synthetic */ Iterator f;

    public c15(h15 h15Var, Iterator it, Iterator it2) {
        this.b = it;
        this.f = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b.hasNext()) {
            return true;
        }
        return this.f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.b;
        if (it.hasNext()) {
            return new i25(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f;
        if (it2.hasNext()) {
            return new i25((String) it2.next());
        }
        vp1.g();
        return null;
    }
}
