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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.a62 d(java.lang.Throwable r3, defpackage.z52 r4) {
        /*
            boolean r0 = r3 instanceof defpackage.a62
            if (r0 == 0) goto L7
            a62 r3 = (defpackage.a62) r3
            goto L49
        L7:
            java.lang.String r0 = defpackage.n50.g(r3)
            if (r0 == 0) goto L13
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L2e
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "(was "
            r0.<init>(r1)
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L2e:
            boolean r1 = r3 instanceof defpackage.l62
            if (r1 == 0) goto L42
            r1 = r3
            l62 r1 = (defpackage.l62) r1
            java.lang.Object r1 = r1.b()
            boolean r2 = defpackage.ha0.w(r1)
            if (r2 == 0) goto L42
            java.io.Closeable r1 = (java.io.Closeable) r1
            goto L43
        L42:
            r1 = 0
        L43:
            a62 r2 = new a62
            r2.<init>(r1, r0, r3)
            r3 = r2
        L49:
            java.util.LinkedList r0 = r3.b
            if (r0 != 0) goto L54
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r3.b = r0
        L54:
            int r0 = r0.size()
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 >= r1) goto L61
            java.util.LinkedList r0 = r3.b
            r0.addFirst(r4)
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a62.d(java.lang.Throwable, z52):a62");
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
