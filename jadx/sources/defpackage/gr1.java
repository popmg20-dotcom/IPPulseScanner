package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gr1 implements Iterator {
    public final /* synthetic */ int b = 0;
    public Object f;
    public final Object z;

    public gr1(du duVar) {
        this.z = duVar;
        this.f = duVar.z.d;
    }

    public boolean equals(Object obj) {
        switch (this.b) {
            case 1:
                return ((Iterator) this.z).equals(obj);
            default:
                return super.equals(obj);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                return ((fr1) this.f) != ((du) obj).z;
            default:
                return ((Iterator) obj).hasNext();
        }
    }

    public int hashCode() {
        switch (this.b) {
            case 1:
                return ((Iterator) this.z).hashCode();
            default:
                return super.hashCode();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.b) {
            case 0:
                fr1 fr1Var = (fr1) this.f;
                this.f = fr1Var.d;
                return fr1Var.e;
            default:
                return ((Iterator) this.z).next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.b) {
            case 0:
                throw new r41("not supported operation exception");
            default:
                ((og2) this.f).Z();
                ((Iterator) this.z).remove();
                return;
        }
    }

    public String toString() {
        switch (this.b) {
            case 1:
                return ((Iterator) this.z).toString();
            default:
                return super.toString();
        }
    }

    public gr1(og2 og2Var, Iterator it) {
        this.f = og2Var;
        this.z = it;
    }
}
