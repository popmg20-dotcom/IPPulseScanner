package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface z62 {
    Class as() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default ke0.class;

    Class contentUsing() default a72.class;

    Class converter() default ke0.class;

    x62 include() default x62.b;

    Class keyAs() default Void.class;

    Class keyUsing() default a72.class;

    Class nullsUsing() default a72.class;

    y62 typing() default y62.z;

    Class using() default a72.class;
}
