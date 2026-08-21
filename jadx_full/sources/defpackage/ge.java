package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ge implements Iterator, Map.Entry {
    public final /* synthetic */ ie A;
    public int b;
    public int f = -1;
    public boolean z;

    public ge(ie ieVar) {
        this.A = ieVar;
        this.b = ieVar.z - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.z) {
            xe.q("This container does not support retaining Map.Entry objects");
            return false;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i = this.f;
            ie ieVar = this.A;
            if (n12.c(key, ieVar.f(i)) && n12.c(entry.getValue(), ieVar.i(this.f))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.z) {
            return this.A.f(this.f);
        }
        xe.q("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.z) {
            return this.A.i(this.f);
        }
        xe.q("This container does not support retaining Map.Entry objects");
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f < this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.z) {
            xe.q("This container does not support retaining Map.Entry objects");
            return 0;
        }
        int i = this.f;
        ie ieVar = this.A;
        Object objF = ieVar.f(i);
        Object objI = ieVar.i(this.f);
        return (objF == null ? 0 : objF.hashCode()) ^ (objI != null ? objI.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        this.f++;
        this.z = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.z) {
            st4.g();
            return;
        }
        this.A.g(this.f);
        this.f--;
        this.b--;
        this.z = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.z) {
            return this.A.h(this.f, obj);
        }
        xe.q("This container does not support retaining Map.Entry objects");
        return null;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
