package defpackage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jq1 {
    public final u61 a = u61.A;
    public final HashMap b = new HashMap();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final si1 e = iq1.j;
    public final int f = 0;
    public final int g = iq1.l;
    public final int h = iq1.m;
    public final ArrayDeque i = new ArrayDeque();

    public final iq1 a() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        ArrayList arrayList2 = this.d;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        boolean z = d14.a;
        HashMap map = new HashMap(this.b);
        new ArrayList(arrayList);
        new ArrayList(arrayList2);
        return new iq1(this.a, 1, map, this.e, this.f, arrayList3, this.g, this.h, new ArrayList(this.i));
    }

    public final void b(Class cls, t82 t82Var) {
        if (cls == Object.class) {
            xe.k(dw2.B(cls, "Cannot override built-in adapter for "));
        } else {
            bk4 bk4Var = new bk4(cls);
            this.c.add(new jh4(t82Var, bk4Var, bk4Var.b == bk4Var.a));
        }
    }
}
