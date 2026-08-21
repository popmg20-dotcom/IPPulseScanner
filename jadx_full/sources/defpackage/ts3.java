package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ts3 implements Iterator, ge0, z72 {
    public ge0 A;
    public int b;
    public Object f;
    public Iterator z;

    public final RuntimeException a() {
        int i = this.b;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.b);
    }

    public final void b(Object obj, sk3 sk3Var) {
        this.f = obj;
        this.b = 3;
        this.A = sk3Var;
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        n12.S(obj);
        this.b = 4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.z;
                it.getClass();
                if (it.hasNext()) {
                    this.b = 2;
                    return true;
                }
                this.z = null;
            }
            this.b = 5;
            ge0 ge0Var = this.A;
            ge0Var.getClass();
            this.A = null;
            ge0Var.d(xl4.a);
        }
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return c41.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            vp1.g();
            return null;
        }
        if (i == 2) {
            this.b = 1;
            Iterator it = this.z;
            it.getClass();
            return it.next();
        }
        if (i != 3) {
            throw a();
        }
        this.b = 0;
        Object obj = this.f;
        this.f = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
