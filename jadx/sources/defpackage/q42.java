package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q42 extends y42 implements Iterable {
    public final ArrayList b = new ArrayList();

    @Override // defpackage.y42
    public final boolean a() {
        return f().a();
    }

    @Override // defpackage.y42
    public final int b() {
        return f().b();
    }

    @Override // defpackage.y42
    public final String d() {
        return f().d();
    }

    public final y42 e(int i) {
        return (y42) this.b.get(i);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof q42) && ((q42) obj).b.equals(this.b);
        }
        return true;
    }

    public final y42 f() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        if (size == 1) {
            return (y42) arrayList.get(0);
        }
        xe.q(dw2.A(size, "Array must have size 1, but has size "));
        return null;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.iterator();
    }
}
