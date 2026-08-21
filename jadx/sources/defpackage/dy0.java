package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dy0 {
    public final View b;
    public final jd c;
    public final GradientDrawable d;
    public final GradientDrawable e;
    public Drawable g;
    public BlendMode i;
    public ColorStateList j;
    public PorterDuff.Mode k;
    public boolean a = false;
    public final HashSet f = new HashSet();
    public int h = 119;

    public dy0(View view, jd jdVar, int i, int i2) {
        this.b = view;
        this.c = jdVar;
        int iA = a(i, 0.2f);
        int iA2 = a(i, 0.65f);
        int iA3 = a(i, 0.4f);
        int iA4 = a(i, 1.0f);
        Context context = view.getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(iA);
        gradientDrawable.setStroke(b(context, 3), iA3);
        float f = i2;
        gradientDrawable.setCornerRadius(f);
        this.d = gradientDrawable;
        Context context2 = view.getContext();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(iA2);
        gradientDrawable2.setStroke(b(context2, 3), iA4);
        gradientDrawable2.setCornerRadius(f);
        this.e = gradientDrawable2;
    }

    public static int a(int i, float f) {
        return (i & 16777215) | (((int) (f * 255.0f)) << 24);
    }

    public static int b(Context context, int i) {
        return Math.round(Math.max(0, i) * context.getResources().getDisplayMetrics().density);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.View r9, android.view.DragEvent r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r10.getLocalState()
            r1 = 0
            if (r0 == 0) goto L9
            goto Lbe
        L9:
            int r0 = r10.getAction()
            r2 = 4
            if (r0 == r2) goto L2e
            android.content.ClipDescription r10 = r10.getClipDescription()
            jd r3 = r8.c
            java.lang.Object r3 = r3.f
            java.lang.String[] r3 = (java.lang.String[]) r3
            if (r10 != 0) goto L1e
            goto Lbe
        L1e:
            int r4 = r3.length
            r5 = r1
        L20:
            if (r5 >= r4) goto Lbe
            r6 = r3[r5]
            boolean r6 = r10.hasMimeType(r6)
            if (r6 == 0) goto L2b
            goto L2e
        L2b:
            int r5 = r5 + 1
            goto L20
        L2e:
            r10 = 1
            r3 = 29
            r4 = 119(0x77, float:1.67E-43)
            r5 = 0
            android.view.View r6 = r8.b
            java.util.HashSet r7 = r8.f
            if (r0 == r10) goto L78
            if (r0 == r2) goto L4b
            r2 = 5
            if (r0 == r2) goto L47
            r2 = 6
            if (r0 == r2) goto L43
            goto La6
        L43:
            r7.remove(r9)
            goto La6
        L47:
            r7.add(r9)
            goto La6
        L4b:
            boolean r9 = r8.a
            if (r9 == 0) goto La6
            r8.a = r1
            android.graphics.drawable.Drawable r9 = r8.g
            r6.setForeground(r9)
            int r9 = r8.h
            r6.setForegroundGravity(r9)
            android.content.res.ColorStateList r9 = r8.j
            r6.setForegroundTintList(r9)
            android.graphics.PorterDuff$Mode r9 = r8.k
            r6.setForegroundTintMode(r9)
            r8.g = r5
            r8.h = r4
            r8.j = r5
            r8.k = r5
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r3) goto L74
            defpackage.cy0.a(r8)
        L74:
            r7.clear()
            goto La6
        L78:
            boolean r9 = r8.a
            if (r9 != 0) goto La6
            r8.a = r10
            android.graphics.drawable.Drawable r9 = r6.getForeground()
            r8.g = r9
            int r9 = r6.getForegroundGravity()
            r8.h = r9
            android.content.res.ColorStateList r9 = r6.getForegroundTintList()
            r8.j = r9
            android.graphics.PorterDuff$Mode r9 = r6.getForegroundTintMode()
            r8.k = r9
            r6.setForegroundGravity(r4)
            r6.setForegroundTintList(r5)
            r6.setForegroundTintMode(r5)
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r3) goto La6
            defpackage.by0.a(r8)
        La6:
            boolean r9 = r8.a
            if (r9 == 0) goto Lbb
            boolean r9 = r7.isEmpty()
            if (r9 != 0) goto Lb6
            android.graphics.drawable.GradientDrawable r8 = r8.e
            r6.setForeground(r8)
            goto Lbb
        Lb6:
            android.graphics.drawable.GradientDrawable r8 = r8.d
            r6.setForeground(r8)
        Lbb:
            if (r0 != r10) goto Lbe
            return r10
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dy0.c(android.view.View, android.view.DragEvent):boolean");
    }
}
