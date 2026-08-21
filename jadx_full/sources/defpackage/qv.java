package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qv implements Serializable, o9 {
    public static final qv b = new qv();
    public static final qv f = new qv();
    public static final ht3[] z = new ht3[0];
    public static final qv A = new qv();
    public static final qv X = new qv();

    public void a(int i) throws t34 {
        if (i > 1000) {
            throw new t34(String.format("Document nesting depth (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), 1000, "`StreamWriteConstraints.getMaxNestingDepth()`"));
        }
    }

    @Override // defpackage.o9
    public Annotation get(Class cls) {
        return null;
    }

    @Override // defpackage.o9
    public int size() {
        return 0;
    }
}
