package defpackage;

import android.util.Range;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f10 {
    public static final pg h = new pg("camerax.core.captureConfig.rotation", Integer.TYPE, null);
    public static final pg i = new pg("camerax.core.captureConfig.jpegQuality", Integer.class, null);
    public static final pg j = new pg("camerax.core.captureConfig.resolvedFrameRate", Range.class, null);
    public final ArrayList a;
    public final sw2 b;
    public final int c;
    public final List d;
    public final boolean e;
    public final pa4 f;
    public final fy g;

    public f10(ArrayList arrayList, sw2 sw2Var, int i2, ArrayList arrayList2, boolean z, pa4 pa4Var, fy fyVar) {
        this.a = arrayList;
        this.b = sw2Var;
        this.c = i2;
        this.d = DesugarCollections.unmodifiableList(arrayList2);
        this.e = z;
        this.f = pa4Var;
        this.g = fyVar;
    }

    public final Range a() {
        Range range = (Range) this.b.p(j, ih.h);
        Objects.requireNonNull(range);
        return range;
    }

    public final int b() {
        Integer num = (Integer) this.b.p(mn4.l0, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public final int c() {
        Integer num = (Integer) this.b.p(mn4.m0, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
