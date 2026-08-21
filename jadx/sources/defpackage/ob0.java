package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.sentry.android.core.a1;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ob0 extends View {
    public wj A;
    public HashMap A0;
    public int[] b;
    public int f;
    public String y0;
    public Context z;
    public String z0;

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.z
            int r1 = r6.length()
            if (r1 != 0) goto La
            goto L9a
        La:
            if (r0 != 0) goto Le
            goto L9a
        Le:
            java.lang.String r6 = r6.trim()
            android.view.ViewParent r1 = r5.getParent()
            boolean r1 = r1 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r2 = 0
            if (r1 == 0) goto L22
            android.view.ViewParent r1 = r5.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            goto L23
        L22:
            r1 = r2
        L23:
            boolean r3 = r5.isInEditMode()
            if (r3 == 0) goto L4e
            if (r1 == 0) goto L4e
            boolean r3 = defpackage.ha0.w(r6)
            if (r3 == 0) goto L42
            java.util.HashMap r3 = r1.G0
            if (r3 == 0) goto L42
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L42
            java.util.HashMap r3 = r1.G0
            java.lang.Object r3 = r3.get(r6)
            goto L43
        L42:
            r3 = r2
        L43:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L4e
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L4f
        L4e:
            r3 = 0
        L4f:
            if (r3 != 0) goto L57
            if (r1 == 0) goto L57
            int r3 = r5.d(r1, r6)
        L57:
            if (r3 != 0) goto L63
            java.lang.Class<nc3> r1 = defpackage.nc3.class
            java.lang.reflect.Field r1 = r1.getField(r6)     // Catch: java.lang.Exception -> L63
            int r3 = r1.getInt(r2)     // Catch: java.lang.Exception -> L63
        L63:
            if (r3 != 0) goto L73
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r3 = r1.getIdentifier(r6, r2, r0)
        L73:
            if (r3 == 0) goto L82
            java.util.HashMap r0 = r5.A0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r1, r6)
            r5.b(r3)
            goto L9a
        L82:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Could not find id of \""
            r5.<init>(r0)
            r5.append(r6)
            java.lang.String r6 = "\""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ConstraintHelper"
            io.sentry.android.core.a1.n(r6, r5)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ob0.a(java.lang.String):void");
    }

    public final void b(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.f + 1;
        int[] iArrCopyOf = this.b;
        if (i2 > iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, iArrCopyOf.length * 2);
            this.b = iArrCopyOf;
        }
        int i3 = this.f;
        iArrCopyOf[i3] = i;
        this.f = i3 + 1;
    }

    public final void c(String str) {
        if (str.length() == 0 || this.z == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            a1.n("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof qb0) && strTrim.equals(((qb0) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    a1.n("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.z.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                if (childAt.getId() != -1) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        resourceEntryName = null;
                    }
                    if (str.equals(resourceEntryName)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    public final void e() {
        if (this.A == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof qb0) {
            ((qb0) layoutParams).p0 = this.A;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.b, this.f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.y0;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.z0;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.y0 = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.z0 = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                c(str.substring(i));
                return;
            } else {
                c(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.y0 = null;
        this.f = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    @Override // android.view.View
    public final void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.y0 == null) {
            b(i);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }
}
