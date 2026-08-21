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
    */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof to3)) {
            return false;
        }
        to3 to3Var = (to3) obj;
        if (this.A != to3Var.A) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = to3Var.iterator();
        while (true) {
            po3 po3Var = (po3) it;
            if (!po3Var.hasNext()) {
                break;
            }
            po3 po3Var2 = (po3) it2;
            if (!po3Var2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) po3Var.next();
            Object next = po3Var2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                break;
            }
        }
        return false;
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
