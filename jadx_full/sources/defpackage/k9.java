package defpackage;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k9 extends ke0 {
    public final HashMap e;

    public k9(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
        HashMap map = new HashMap();
        this.e = map;
        map.put(cls, annotation);
        map.put(cls2, annotation2);
    }

    @Override // defpackage.ke0
    public final ke0 a(Annotation annotation) {
        this.e.put(annotation.annotationType(), annotation);
        return this;
    }

    @Override // defpackage.ke0
    public final cp1 c() {
        cp1 cp1Var = new cp1(5, false);
        for (Annotation annotation : this.e.values()) {
            HashMap map = (HashMap) cp1Var.f;
            if (map == null) {
                map = new HashMap();
                cp1Var.f = map;
            }
            Annotation annotation2 = (Annotation) map.put(annotation.annotationType(), annotation);
            if (annotation2 != null) {
                annotation2.equals(annotation);
            }
        }
        return cp1Var;
    }

    @Override // defpackage.ke0
    public final o9 d() {
        HashMap map = this.e;
        if (map.size() != 2) {
            return new cp1(5, map);
        }
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        Map.Entry entry2 = (Map.Entry) it.next();
        return new n9((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
    }

    @Override // defpackage.ke0
    public final boolean k(Annotation annotation) {
        return this.e.containsKey(annotation.annotationType());
    }
}
