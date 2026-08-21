package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface s42 {
    r42 creatorVisibility() default r42.A;

    r42 fieldVisibility() default r42.A;

    r42 getterVisibility() default r42.A;

    r42 isGetterVisibility() default r42.A;

    r42 setterVisibility() default r42.A;
}
