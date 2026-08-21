package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface n72 {
    Class defaultImpl() default n72.class;

    j72 include() default j72.b;

    String property() default "";

    jw2 requireTypeIdForSubtypes() default jw2.f;

    k72 use();

    boolean visible() default false;
}
