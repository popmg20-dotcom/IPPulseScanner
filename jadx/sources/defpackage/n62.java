package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface n62 {
    m62 access() default m62.b;

    String defaultValue() default "";

    int index() default -1;

    jw2 isRequired() default jw2.f;

    String namespace() default "";

    boolean required() default false;

    String value() default "";
}
