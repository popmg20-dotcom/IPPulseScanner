package defpackage;

import j$.util.Collection;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ua2 {
    public static final ArrayDeque d = new ArrayDeque(0);
    public final List c;
    public int b = 0;
    public final List a = new ArrayList();

    public ua2(ArrayList arrayList) {
        this.c = arrayList;
    }

    public final int[] a(t24 t24Var, int i) {
        List list = this.a;
        if (!list.isEmpty() && ((Integer) list.get(list.size() - 2)).intValue() == i - 1) {
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
        }
        if (list.isEmpty()) {
            this.b = -1;
            b(t24Var, i);
            list.set(list.size() - 2, 0);
        }
        return Collection.EL.stream(list).mapToInt(new at0(2)).toArray();
    }

    public final void b(t24 t24Var, int i) {
        c(t24Var.i, i);
    }

    public final void c(qt qtVar, int i) {
        if (this.b >= i) {
            return;
        }
        int i2 = qtVar != null ? qtVar.b : 0;
        List list = this.c;
        if (!list.isEmpty()) {
            if (qtVar != null) {
                ((v62) qtVar.d).B();
            } else {
                List list2 = Collections.EMPTY_LIST;
            }
            Iterator it = list.iterator();
            if (it.hasNext()) {
                ((ve4) it.next()).getClass();
                throw null;
            }
        }
        List list3 = this.a;
        if (!list3.isEmpty() && ((Integer) list3.get(list3.size() - 1)).intValue() == i2) {
            this.b = i;
            return;
        }
        list3.add(Integer.valueOf(this.b));
        list3.add(Integer.valueOf(i2));
        this.b = i;
    }
}
