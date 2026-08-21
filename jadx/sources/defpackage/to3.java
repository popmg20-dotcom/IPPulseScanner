package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class to3 implements Iterable {
    public qo3 b;
    public qo3 f;
    public final WeakHashMap z = new WeakHashMap();
    public int A = 0;

    public qo3 a(Object obj) {
        qo3 qo3Var = this.b;
        while (qo3Var != null && !qo3Var.b.equals(obj)) {
            qo3Var = qo3Var.z;
        }
        return qo3Var;
    }

    public Object b(Object obj) {
        qo3 qo3VarA = a(obj);
        if (qo3VarA == null) {
            return null;
        }
        this.A--;
        WeakHashMap weakHashMap = this.z;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((so3) it.next()).a(qo3VarA);
            }
        }
        qo3 qo3Var = qo3VarA.A;
        qo3 qo3Var2 = qo3VarA.z;
        if (qo3Var != null) {
            qo3Var.z = qo3Var2;
        } else {
            this.b = qo3Var2;
        }
        qo3 qo3Var3 = qo3VarA.z;
        if (qo3Var3 != null) {
            qo3Var3.A = qo3Var;
        } else {
            this.f = qo3Var;
        }
        qo3VarA.z = null;
        qo3VarA.A = null;
        return qo3VarA.f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r1.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((defpackage.po3) r6).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof defpackage.to3
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            to3 r6 = (defpackage.to3) r6
            int r1 = r5.A
            int r3 = r6.A
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L1b:
            r1 = r5
            po3 r1 = (defpackage.po3) r1
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L44
            r3 = r6
            po3 r3 = (defpackage.po3) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            java.lang.Object r1 = r1.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r3.next()
            if (r1 != 0) goto L3b
            if (r3 != 0) goto L43
        L3b:
            if (r1 == 0) goto L1b
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r5 = r1.hasNext()
            if (r5 != 0) goto L53
            po3 r6 = (defpackage.po3) r6
            boolean r5 = r6.hasNext()
            if (r5 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.to3.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            po3 po3Var = (po3) it;
            if (!po3Var.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) po3Var.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        po3 po3Var = new po3(this.b, this.f, 0);
        this.z.put(po3Var, Boolean.FALSE);
        return po3Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            po3 po3Var = (po3) it;
            if (!po3Var.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) po3Var.next()).toString());
            if (po3Var.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
