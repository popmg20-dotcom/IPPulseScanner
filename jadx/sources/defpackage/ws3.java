package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ws3 extends uf2 {
    public static String U(ss3 ss3Var, String str) {
        ss3Var.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (Object obj : ss3Var) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) str);
            }
            n12.a(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static List V(ss3 ss3Var) {
        Iterator it = ss3Var.iterator();
        if (!it.hasNext()) {
            return g41.b;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return p95.x(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
