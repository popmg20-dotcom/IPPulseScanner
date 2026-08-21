package defpackage;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rh1 implements Comparator {
    public final d7 A;
    public final Rect b = new Rect();
    public final Rect f = new Rect();
    public final boolean z;

    public rh1(boolean z, d7 d7Var) {
        this.z = z;
        this.A = d7Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.A.getClass();
        Rect rect = this.b;
        ((p2) obj).f(rect);
        Rect rect2 = this.f;
        ((p2) obj2).f(rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        boolean z = this.z;
        if (i3 < i4) {
            return z ? 1 : -1;
        }
        if (i3 > i4) {
            return z ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return z ? 1 : -1;
        }
        if (i7 > i8) {
            return z ? -1 : 1;
        }
        return 0;
    }
}
