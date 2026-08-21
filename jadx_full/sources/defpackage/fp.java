package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fp {
    public static final Matrix a = new Matrix();

    public static void a(Path path, float f, float f2, float f3, float f4, float f5) {
        path.arcTo(f - f3, f2 - f3, f + f3, f2 + f3, f4, f5, false);
    }
}
