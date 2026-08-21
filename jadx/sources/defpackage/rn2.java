package defpackage;

import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rn2 {
    public final LinkedHashMap a;
    public final zf2 b;

    public rn2(LinkedHashMap linkedHashMap, boolean z) {
        this.a = linkedHashMap;
        this.b = new zf2(z);
    }

    public final Map a() {
        e03 e03Var;
        Set<Map.Entry> setEntrySet = this.a.entrySet();
        int iU = fh2.U(f70.Q(10, setEntrySet));
        if (iU < 16) {
            iU = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iU);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                e03Var = new e03(entry.getKey(), Arrays.copyOf(bArr, bArr.length));
            } else {
                e03Var = new e03(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(e03Var.b, e03Var.f);
        }
        Map mapUnmodifiableMap = DesugarCollections.unmodifiableMap(linkedHashMap);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (((AtomicBoolean) this.b.f).get()) {
            xe.q("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void c(u33 u33Var, Object obj) {
        u33Var.getClass();
        d(u33Var, obj);
    }

    public final void d(u33 u33Var, Object obj) {
        u33Var.getClass();
        b();
        LinkedHashMap linkedHashMap = this.a;
        if (obj == null) {
            b();
            linkedHashMap.remove(u33Var);
        } else if (obj instanceof Set) {
            Set setUnmodifiableSet = DesugarCollections.unmodifiableSet(d70.C0((Set) obj));
            setUnmodifiableSet.getClass();
            linkedHashMap.put(u33Var, setUnmodifiableSet);
        } else if (!(obj instanceof byte[])) {
            linkedHashMap.put(u33Var, obj);
        } else {
            byte[] bArr = (byte[]) obj;
            linkedHashMap.put(u33Var, Arrays.copyOf(bArr, bArr.length));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof defpackage.rn2
            r1 = 0
            if (r0 != 0) goto L6
            goto L60
        L6:
            rn2 r6 = (defpackage.rn2) r6
            java.util.LinkedHashMap r6 = r6.a
            java.util.LinkedHashMap r5 = r5.a
            r0 = 1
            if (r6 != r5) goto L10
            goto L61
        L10:
            int r2 = r6.size()
            int r3 = r5.size()
            if (r2 == r3) goto L1b
            goto L60
        L1b:
            boolean r2 = r6.isEmpty()
            if (r2 == 0) goto L22
            goto L61
        L22:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2a:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L61
            java.lang.Object r2 = r6.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r3 = r5.get(r3)
            if (r3 == 0) goto L5d
            java.lang.Object r2 = r2.getValue()
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L58
            boolean r4 = r3 instanceof byte[]
            if (r4 == 0) goto L5d
            byte[] r2 = (byte[]) r2
            byte[] r3 = (byte[]) r3
            boolean r2 = java.util.Arrays.equals(r2, r3)
            if (r2 == 0) goto L5d
            r2 = r0
            goto L5e
        L58:
            boolean r2 = defpackage.n12.c(r2, r3)
            goto L5e
        L5d:
            r2 = r1
        L5e:
            if (r2 != 0) goto L2a
        L60:
            return r1
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rn2.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return d70.j0(this.a.entrySet(), ",\n", "{\n", "\n}", x10.Z, 24);
    }

    public /* synthetic */ rn2(boolean z) {
        this(new LinkedHashMap(), z);
    }
}
