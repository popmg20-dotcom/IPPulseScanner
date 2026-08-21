package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ib2 implements Iterator, z72 {
    public String b;
    public boolean f;
    public final /* synthetic */ j70 z;

    public ib2(j70 j70Var) {
        this.z = j70Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        String line = this.b;
        if (line == null && !this.f) {
            line = ((BufferedReader) this.z.b).readLine();
            this.b = line;
            if (line == null) {
                this.f = true;
            }
        }
        return line != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            vp1.g();
            return null;
        }
        String str = this.b;
        this.b = null;
        str.getClass();
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
