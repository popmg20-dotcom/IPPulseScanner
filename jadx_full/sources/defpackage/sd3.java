package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class sd3 extends d93 {
    /* JADX WARN: Multi-variable type inference failed */
    public final kd3 b() {
        j("captures");
        return (kd3) get("captures");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String c() {
        return (String) get("name");
    }

    public Collection d() {
        return (Collection) get("patterns");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public rd3 e() {
        return (rd3) get("repository");
    }

    public final void f(wn3 wn3Var) {
        super.put("id", wn3Var);
    }

    public final void g(String str) {
        super.put("include", str);
    }

    public final void h(String str) {
        super.put("name", str);
    }

    public final void i(Collection collection) {
        super.put("patterns", collection);
    }

    public final void j(String str) {
        V v = get(str);
        if (v instanceof List) {
            sd3 sd3Var = new sd3();
            Iterator it = ((List) v).iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                sd3Var.put(Integer.toString(i), it.next());
            }
            super.put(str, sd3Var);
        }
    }
}
