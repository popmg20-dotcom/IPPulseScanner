package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class s30 implements Iterable, z72 {
    public final char b;
    public final char f;

    static {
        new s30((char) 1, (char) 0);
    }

    public s30(char c, char c2) {
        this.b = c;
        this.f = (char) ye.z(c, c2, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s30)) {
            return false;
        }
        if (isEmpty() && ((s30) obj).isEmpty()) {
            return true;
        }
        s30 s30Var = (s30) obj;
        return this.b == s30Var.b && this.f == s30Var.f;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.b * 31) + this.f;
    }

    public final boolean isEmpty() {
        return n12.l(this.b, this.f) > 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new r30(this.b, this.f);
    }

    public final String toString() {
        return this.b + ".." + this.f;
    }
}
