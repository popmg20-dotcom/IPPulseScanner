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
    */
    public final boolean equals(Object obj) {
        if (obj instanceof rn2) {
            LinkedHashMap linkedHashMap = ((rn2) obj).a;
            LinkedHashMap linkedHashMap2 = this.a;
            if (linkedHashMap != linkedHashMap2) {
                if (linkedHashMap.size() == linkedHashMap2.size()) {
                    if (!linkedHashMap.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            Object obj2 = linkedHashMap2.get(entry.getKey());
                            if (obj2 != null) {
                                Object value = entry.getValue();
                                boolean zC = value instanceof byte[] ? (obj2 instanceof byte[]) && Arrays.equals((byte[]) value, (byte[]) obj2) : n12.c(value, obj2);
                                if (!zC) {
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
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
