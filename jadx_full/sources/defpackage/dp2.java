package defpackage;

import io.github.rosemoe.oniguruma.OnigNative;
import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dp2 {
    public final long[] a;

    public dp2(List list) {
        this.a = Collection.EL.stream((List) Collection.EL.stream(list).map(new hl(8)).collect(Collectors.toList())).mapToLong(new cp2()).toArray();
    }

    public final g20 a(zv2 zv2Var, int i) {
        int iA = zv2Var.a(i);
        int[] iArrRegexSearchBatch = OnigNative.regexSearchBatch(this.a, zv2Var.d, zv2Var.c, iA, zv2Var.b);
        if (iArrRegexSearchBatch == null) {
            return null;
        }
        return new g20(iArrRegexSearchBatch, true);
    }
}
