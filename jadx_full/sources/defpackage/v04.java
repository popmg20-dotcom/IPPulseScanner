package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class v04 extends d31 {
    public static final x21 h;
    public static final x21 i;
    public final int b;
    public final int c;
    public final int d;
    public final x21 e;
    public final x21 f;
    public final n04 g;

    static {
        if (1.4f <= 1.0f) {
            xe.k("Ratio must be greater than 1.");
            return;
        }
        h = new x21(1.4f, "ratio:1.4");
        i = x21.c;
    }

    public v04(String str, int i2, int i3, int i4, x21 x21Var, x21 x21Var2, n04 n04Var) {
        super(str);
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = x21Var;
        this.f = x21Var2;
        this.g = n04Var;
        r25.h(i2, "minWidthDp must be non-negative");
        r25.h(i3, "minHeightDp must be non-negative");
        r25.h(i4, "minSmallestWidthDp must be non-negative");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(Context context, WindowMetrics windowMetrics) {
        boolean z;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30) {
            Rect rectE = j2.e(windowMetrics);
            float fG = i2 <= 33 ? context.getResources().getDisplayMetrics().density : l2.g(context, windowMetrics);
            int iWidth = rectE.width();
            int iHeight = rectE.height();
            if (iWidth != 0 && iHeight != 0) {
                int i3 = this.b;
                int i4 = (int) ((i3 * fG) + 0.5f);
                int i5 = this.c;
                int i6 = (int) ((i5 * fG) + 0.5f);
                int i7 = this.d;
                int i8 = (int) ((i7 * fG) + 0.5f);
                boolean z2 = i3 == 0 || iWidth >= i4;
                boolean z3 = i5 == 0 || iHeight >= i6;
                boolean z4 = i7 == 0 || Math.min(iWidth, iHeight) >= i8;
                x21 x21Var = x21.c;
                if (iHeight >= iWidth) {
                    x21 x21Var2 = this.e;
                    z = x21Var2.equals(x21Var) || (((float) iHeight) * 1.0f) / ((float) iWidth) <= x21Var2.b;
                } else {
                    x21 x21Var3 = this.f;
                    if (x21Var3.equals(x21Var) || (iWidth * 1.0f) / iHeight <= x21Var3.b) {
                    }
                }
                if (z2 && z3 && z4 && z) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.d31
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v04) || !super.equals(obj)) {
            return false;
        }
        v04 v04Var = (v04) obj;
        return this.b == v04Var.b && this.c == v04Var.c && this.d == v04Var.d && this.e.equals(v04Var.e) && this.f.equals(v04Var.f) && this.g.equals(v04Var.g);
    }

    @Override // defpackage.d31
    public int hashCode() {
        return this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + (((((((super.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31)) * 31)) * 31);
    }
}
