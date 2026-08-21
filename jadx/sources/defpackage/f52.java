package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface f52 {
    jw2 lenient() default jw2.f;

    String locale() default "##default";

    String pattern() default "";

    d52 shape() default d52.b;

    String timezone() default "##default";

    b52[] with() default {};

    b52[] without() default {};
}
