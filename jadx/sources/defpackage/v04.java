package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.content.Context r10, android.view.WindowMetrics r11) {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            r2 = 0
            if (r0 > r1) goto L9
            goto L98
        L9:
            android.graphics.Rect r1 = defpackage.j2.e(r11)
            r3 = 33
            if (r0 > r3) goto L1c
            android.content.res.Resources r10 = r10.getResources()
            android.util.DisplayMetrics r10 = r10.getDisplayMetrics()
            float r10 = r10.density
            goto L20
        L1c:
            float r10 = defpackage.l2.g(r10, r11)
        L20:
            int r11 = r1.width()
            int r0 = r1.height()
            if (r11 == 0) goto L98
            if (r0 != 0) goto L2e
            goto L98
        L2e:
            int r1 = r9.b
            float r3 = (float) r1
            float r3 = r3 * r10
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            int r5 = r9.c
            float r6 = (float) r5
            float r6 = r6 * r10
            float r6 = r6 + r4
            int r6 = (int) r6
            int r7 = r9.d
            float r8 = (float) r7
            float r8 = r8 * r10
            float r8 = r8 + r4
            int r10 = (int) r8
            r4 = 1
            if (r1 == 0) goto L4a
            if (r11 < r3) goto L48
            goto L4a
        L48:
            r1 = r2
            goto L4b
        L4a:
            r1 = r4
        L4b:
            if (r5 == 0) goto L52
            if (r0 < r6) goto L50
            goto L52
        L50:
            r3 = r2
            goto L53
        L52:
            r3 = r4
        L53:
            if (r7 == 0) goto L5e
            int r5 = java.lang.Math.min(r11, r0)
            if (r5 < r10) goto L5c
            goto L5e
        L5c:
            r10 = r2
            goto L5f
        L5e:
            r10 = r4
        L5f:
            r5 = 1065353216(0x3f800000, float:1.0)
            x21 r6 = defpackage.x21.c
            if (r0 < r11) goto L7c
            x21 r9 = r9.e
            boolean r6 = r9.equals(r6)
            if (r6 != 0) goto L7a
            float r0 = (float) r0
            float r0 = r0 * r5
            float r11 = (float) r11
            float r0 = r0 / r11
            float r9 = r9.b
            int r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r9 > 0) goto L78
            goto L7a
        L78:
            r9 = r2
            goto L8f
        L7a:
            r9 = r4
            goto L8f
        L7c:
            x21 r9 = r9.f
            boolean r6 = r9.equals(r6)
            if (r6 != 0) goto L7a
            float r11 = (float) r11
            float r11 = r11 * r5
            float r0 = (float) r0
            float r11 = r11 / r0
            float r9 = r9.b
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 > 0) goto L78
            goto L7a
        L8f:
            if (r1 == 0) goto L98
            if (r3 == 0) goto L98
            if (r10 == 0) goto L98
            if (r9 == 0) goto L98
            return r4
        L98:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v04.b(android.content.Context, android.view.WindowMetrics):boolean");
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
