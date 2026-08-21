package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n9 implements o9, Serializable {
    public final Annotation A;
    public final Class b;
    public final Class f;
    public final Annotation z;

    public n9(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
        this.b = cls;
        this.z = annotation;
        this.f = cls2;
        this.A = annotation2;
    }

    @Override // defpackage.o9
    public final Annotation get(Class cls) {
        if (this.b == cls) {
            return this.z;
        }
        if (this.f == cls) {
            return this.A;
        }
        return null;
    }

    @Override // defpackage.o9
    public final int size() {
        return 2;
    }
}
