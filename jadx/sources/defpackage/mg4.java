package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class mg4 implements Iterator, z72 {
    public final /* synthetic */ int b;
    public Iterator f;
    public final Object z;

    public mg4(go1 go1Var) {
        this.b = 0;
        this.z = go1Var;
        this.f = ((ss3) go1Var.c).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.b) {
        }
        return this.f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.b;
        Object obj = this.z;
        switch (i) {
            case 0:
                return ((go1) obj).b.g(this.f.next());
            default:
                Object next = this.f.next();
                ArrayList arrayList = (ArrayList) obj;
                View view = (View) next;
                ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
                w0 w0Var = viewGroup != null ? new w0(3, viewGroup) : null;
                if (w0Var == null || !w0Var.hasNext()) {
                    while (!this.f.hasNext() && !arrayList.isEmpty()) {
                        this.f = (Iterator) d70.k0(arrayList);
                        d70.p0(arrayList);
                    }
                } else {
                    arrayList.add(this.f);
                    this.f = w0Var;
                }
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public mg4(w0 w0Var) {
        this.b = 1;
        this.z = new ArrayList();
        this.f = w0Var;
    }
}
