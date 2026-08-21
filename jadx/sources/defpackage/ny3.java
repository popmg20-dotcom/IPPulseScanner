package defpackage;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ny3 implements Iterator {
    public Iterator A;
    public final /* synthetic */ AbstractMap X;
    public final /* synthetic */ int b;
    public int f = -1;
    public boolean z;

    public /* synthetic */ ny3(AbstractMap abstractMap, int i) {
        this.b = i;
        this.X = abstractMap;
    }

    public Iterator a() {
        int i = this.b;
        AbstractMap abstractMap = this.X;
        switch (i) {
            case 0:
                Iterator it = this.A;
                if (it != null) {
                    return it;
                }
                Iterator it2 = ((jy3) abstractMap).z.entrySet().iterator();
                this.A = it2;
                return it2;
            default:
                Iterator it3 = this.A;
                if (it3 != null) {
                    return it3;
                }
                Iterator it4 = ((ky3) abstractMap).f.entrySet().iterator();
                this.A = it4;
                return it4;
        }
    }

    public Iterator b() {
        Iterator it = this.A;
        if (it != null) {
            return it;
        }
        Iterator it2 = ((xd5) this.X).z.entrySet().iterator();
        this.A = it2;
        return it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        AbstractMap abstractMap = this.X;
        switch (i) {
            case 0:
                jy3 jy3Var = (jy3) abstractMap;
                if (this.f + 1 >= jy3Var.f) {
                    if (jy3Var.z.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
            case 1:
                ky3 ky3Var = (ky3) abstractMap;
                if (this.f + 1 >= ky3Var.b.size()) {
                    if (ky3Var.f.isEmpty() || !a().hasNext()) {
                    }
                }
                break;
            default:
                xd5 xd5Var = (xd5) abstractMap;
                if (this.f + 1 >= xd5Var.f) {
                    if (xd5Var.z.isEmpty() || !b().hasNext()) {
                    }
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        AbstractMap abstractMap = this.X;
        switch (i) {
            case 0:
                this.z = true;
                int i2 = this.f + 1;
                this.f = i2;
                jy3 jy3Var = (jy3) abstractMap;
                return i2 < jy3Var.f ? (ly3) jy3Var.b[i2] : (Map.Entry) a().next();
            case 1:
                this.z = true;
                int i3 = this.f + 1;
                this.f = i3;
                ky3 ky3Var = (ky3) abstractMap;
                return i3 < ky3Var.b.size() ? (Map.Entry) ky3Var.b.get(this.f) : (Map.Entry) a().next();
            default:
                this.z = true;
                int i4 = this.f + 1;
                this.f = i4;
                xd5 xd5Var = (xd5) abstractMap;
                return i4 < xd5Var.f ? (yd5) xd5Var.b[i4] : (Map.Entry) b().next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.b;
        AbstractMap abstractMap = this.X;
        switch (i) {
            case 0:
                jy3 jy3Var = (jy3) abstractMap;
                if (!this.z) {
                    xe.q("remove() was called before next()");
                } else {
                    this.z = false;
                    int i2 = jy3.Z;
                    jy3Var.b();
                    int i3 = this.f;
                    if (i3 >= jy3Var.f) {
                        a().remove();
                    } else {
                        this.f = i3 - 1;
                        jy3Var.i(i3);
                    }
                }
                break;
            case 1:
                ky3 ky3Var = (ky3) abstractMap;
                if (!this.z) {
                    xe.q("remove() was called before next()");
                } else {
                    this.z = false;
                    int i4 = ky3.Y;
                    ky3Var.b();
                    if (this.f >= ky3Var.b.size()) {
                        a().remove();
                    } else {
                        int i5 = this.f;
                        this.f = i5 - 1;
                        ky3Var.h(i5);
                    }
                }
                break;
            default:
                if (!this.z) {
                    xe.q("remove() was called before next()");
                } else {
                    this.z = false;
                    xd5 xd5Var = (xd5) abstractMap;
                    xd5Var.f();
                    int i6 = this.f;
                    if (i6 >= xd5Var.f) {
                        b().remove();
                    } else {
                        this.f = i6 - 1;
                        xd5Var.d(i6);
                    }
                }
                break;
        }
    }
}
