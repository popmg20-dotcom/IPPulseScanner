package defpackage;

import java.lang.annotation.Annotation;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m9 extends ke0 {
    public Class e;
    public Annotation f;

    @Override // defpackage.ke0
    public final ke0 a(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Class<? extends Annotation> cls = this.e;
        if (cls != clsAnnotationType) {
            return new k9(cls, this.f, clsAnnotationType, annotation);
        }
        this.f = annotation;
        return this;
    }

    @Override // defpackage.ke0
    public final cp1 c() {
        Class cls = this.e;
        Annotation annotation = this.f;
        HashMap map = new HashMap(4);
        map.put(cls, annotation);
        return new cp1(5, map);
    }

    @Override // defpackage.ke0
    public final o9 d() {
        return new l9(this.e, this.f);
    }

    @Override // defpackage.ke0
    public final boolean k(Annotation annotation) {
        return annotation.annotationType() == this.e;
    }
}
