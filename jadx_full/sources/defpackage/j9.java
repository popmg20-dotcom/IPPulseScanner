package defpackage;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j9 extends ke0 {
    public static final j9 e = new j9();

    @Override // defpackage.ke0
    public final ke0 a(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        m9 m9Var = new m9();
        m9Var.e = clsAnnotationType;
        m9Var.f = annotation;
        return m9Var;
    }

    @Override // defpackage.ke0
    public final cp1 c() {
        return new cp1(5, false);
    }

    @Override // defpackage.ke0
    public final o9 d() {
        return ke0.a;
    }

    @Override // defpackage.ke0
    public final boolean k(Annotation annotation) {
        return false;
    }
}
