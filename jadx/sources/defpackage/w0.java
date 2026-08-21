package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class w0 implements Iterator, z72 {
    public final /* synthetic */ int b;
    public int f;
    public final Object z;

    public w0(py0 py0Var) {
        this.b = 2;
        this.z = py0Var.a.iterator();
        this.f = py0Var.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                return this.f < ((z0) obj).a();
            case 1:
                return this.f < ((Object[]) obj).length;
            case 2:
                Iterator it = (Iterator) obj;
                while (this.f > 0 && it.hasNext()) {
                    it.next();
                    this.f--;
                }
                return it.hasNext();
            default:
                return this.f < ((ViewGroup) obj).getChildCount();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                if (!hasNext()) {
                    vp1.g();
                    return null;
                }
                int i2 = this.f;
                this.f = i2 + 1;
                return ((z0) obj).get(i2);
            case 1:
                try {
                    int i3 = this.f;
                    this.f = i3 + 1;
                    return ((Object[]) obj)[i3];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f--;
                    e04.h(e.getMessage());
                    return null;
                }
            case 2:
                Iterator it = (Iterator) obj;
                while (this.f > 0 && it.hasNext()) {
                    it.next();
                    this.f--;
                }
                return it.next();
            default:
                int i4 = this.f;
                this.f = i4 + 1;
                View childAt = ((ViewGroup) obj).getChildAt(i4);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ViewGroup viewGroup = (ViewGroup) this.z;
                int i = this.f - 1;
                this.f = i;
                viewGroup.removeViewAt(i);
                return;
        }
    }

    public w0(Object[] objArr) {
        this.b = 1;
        objArr.getClass();
        this.z = objArr;
    }

    public /* synthetic */ w0(int i, Object obj) {
        this.b = i;
        this.z = obj;
    }
}
