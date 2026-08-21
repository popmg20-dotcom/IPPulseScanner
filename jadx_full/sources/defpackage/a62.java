package defpackage;

import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class a62 extends l62 {
    public LinkedList b;
    public final transient Closeable f;

    public a62(dy4 dy4Var, String str) {
        super(str);
        this.f = dy4Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a62 d(Throwable th, z52 z52Var) {
        a62 a62Var;
        if (th instanceof a62) {
            a62Var = (a62) th;
        } else {
            String strG = n50.g(th);
            if (strG == null || strG.isEmpty()) {
                strG = "(was " + th.getClass().getName() + ")";
            }
            if (th instanceof l62) {
                Object objB = ((l62) th).b();
                Closeable closeable = ha0.w(objB) ? (Closeable) objB : null;
                a62Var = new a62(closeable, strG, th);
            }
        }
        LinkedList linkedList = a62Var.b;
        if (linkedList == null) {
            linkedList = new LinkedList();
            a62Var.b = linkedList;
        }
        if (linkedList.size() < 1000) {
            a62Var.b.addFirst(z52Var);
        }
        return a62Var;
    }

    @Override // defpackage.l62
    public final Object b() {
        return this.f;
    }

    public final String c() {
        String message = super.getMessage();
        if (this.b == null) {
            return message;
        }
        StringBuilder sbQ = ha0.q(message, " (through reference chain: ");
        LinkedList linkedList = this.b;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                sbQ.append(((z52) it.next()).toString());
                if (it.hasNext()) {
                    sbQ.append("->");
                }
            }
        }
        sbQ.append(')');
        return sbQ.toString();
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return c();
    }

    @Override // defpackage.l62, java.lang.Throwable
    public final String getMessage() {
        return c();
    }

    @Override // defpackage.l62, java.lang.Throwable
    public final String toString() {
        return getClass().getName() + ": " + c();
    }

    public a62(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.f = closeable;
    }
}
