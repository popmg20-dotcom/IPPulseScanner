package defpackage;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class an0 {
    public final String a;
    public final cp1 b;

    public an0(Set set, cp1 cp1Var) {
        this.a = a(set);
        this.b = cp1Var;
    }

    public static String a(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zg zgVar = (zg) it.next();
            sb.append(zgVar.a);
            sb.append('/');
            sb.append(zgVar.b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
