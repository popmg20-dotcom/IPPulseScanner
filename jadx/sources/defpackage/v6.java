package defpackage;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v6 implements Supplier {
    public final /* synthetic */ int b;

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.b;
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        switch (i) {
            case 0:
                return new NullPointerException("Anchor is required in AliasEvent");
            case 1:
                return new TreeSet(comparator);
            case 2:
                return new HashSet();
            case 3:
                return new NoSuchElementException("No more Events found.");
            case 4:
                return z93.f;
            case 5:
                return new TreeSet(comparator);
            case 6:
                return Thread.currentThread().getContextClassLoader();
            default:
                return ClassLoader.getSystemClassLoader();
        }
    }
}
