package defpackage;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k22 extends yf3 implements cg3 {
    public Rect A;
    public long B;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final i22 m;
    public int o;
    public int q;
    public RecyclerView r;
    public VelocityTracker t;
    public ArrayList u;
    public ArrayList v;
    public GestureDetector x;
    public j22 y;
    public final ArrayList a = new ArrayList();
    public final float[] b = new float[2];
    public rg3 c = null;
    public int l = -1;
    public int n = 0;
    public final ArrayList p = new ArrayList();
    public final f33 s = new f33(15, this);
    public View w = null;
    public final f22 z = new f22(0, this);

    public k22(i22 i22Var) {
        this.m = i22Var;
    }

    public static boolean p(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    @Override // defpackage.cg3
    public final void b(View view) {
        if (view == this.w) {
            this.w = null;
        }
        rg3 rg3VarN = this.r.N(view);
        if (rg3VarN == null) {
            return;
        }
        rg3 rg3Var = this.c;
        if (rg3Var != null && rg3VarN == rg3Var) {
            r(null, 0);
            return;
        }
        m(rg3VarN, false);
        if (this.a.remove(rg3VarN.a)) {
            i22.a(rg3VarN);
        }
    }

    @Override // defpackage.yf3
    public final void f(Rect rect, View view, RecyclerView recyclerView) {
        rect.setEmpty();
    }

    @Override // defpackage.yf3
    public final void g(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        i22 i22Var;
        k22 k22Var = this;
        if (k22Var.c != null) {
            float[] fArr = k22Var.b;
            k22Var.o(fArr);
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        rg3 rg3Var = k22Var.c;
        int i = k22Var.n;
        ArrayList arrayList = k22Var.p;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            i22Var = k22Var.m;
            if (i2 >= size) {
                break;
            }
            g22 g22Var = (g22) arrayList.get(i2);
            rg3 rg3Var2 = g22Var.e;
            float f4 = g22Var.a;
            float f5 = g22Var.c;
            if (f4 == f5) {
                g22Var.i = rg3Var2.a.getTranslationX();
            } else {
                g22Var.i = ha0.h(f5, f4, g22Var.m, f4);
            }
            float f6 = g22Var.b;
            float f7 = g22Var.d;
            if (f6 == f7) {
                g22Var.j = rg3Var2.a.getTranslationY();
            } else {
                g22Var.j = ha0.h(f7, f6, g22Var.m, f6);
            }
            int iSave = canvas.save();
            i22Var.k(canvas, recyclerView, g22Var.e, g22Var.i, g22Var.j, g22Var.f, false);
            canvas.restoreToCount(iSave);
            i2++;
            k22Var = this;
        }
        if (rg3Var != null) {
            int iSave2 = canvas.save();
            i22Var.k(canvas, recyclerView, rg3Var, f2, f, i, true);
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // defpackage.yf3
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        boolean z = false;
        if (this.c != null) {
            float[] fArr = this.b;
            o(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
        }
        rg3 rg3Var = this.c;
        ArrayList arrayList = this.p;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            g22 g22Var = (g22) arrayList.get(i);
            int iSave = canvas.save();
            View view = g22Var.e.a;
            canvas.restoreToCount(iSave);
        }
        if (rg3Var != null) {
            canvas.restoreToCount(canvas.save());
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            g22 g22Var2 = (g22) arrayList.get(i2);
            boolean z2 = g22Var2.l;
            if (z2 && !g22Var2.h) {
                arrayList.remove(i2);
            } else if (!z2) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    public final void i(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        f22 f22Var = this.z;
        if (recyclerView2 != null) {
            recyclerView2.h0(this);
            RecyclerView recyclerView3 = this.r;
            recyclerView3.K0.remove(f22Var);
            if (recyclerView3.L0 == f22Var) {
                recyclerView3.L0 = null;
            }
            ArrayList arrayList = this.r.W0;
            if (arrayList != null) {
                arrayList.remove(this);
            }
            ArrayList arrayList2 = this.p;
            int size = arrayList2.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                g22 g22Var = (g22) arrayList2.get(0);
                g22Var.g.cancel();
                i22.a(g22Var.e);
            }
            arrayList2.clear();
            this.w = null;
            VelocityTracker velocityTracker = this.t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.t = null;
            }
            j22 j22Var = this.y;
            if (j22Var != null) {
                j22Var.a = false;
                this.y = null;
            }
            if (this.x != null) {
                this.x = null;
            }
        }
        this.r = recyclerView;
        Resources resources = recyclerView.getResources();
        this.f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
        this.g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.i(this);
        this.r.K0.add(f22Var);
        RecyclerView recyclerView4 = this.r;
        ArrayList arrayList3 = recyclerView4.W0;
        if (arrayList3 == null) {
            arrayList3 = new ArrayList();
            recyclerView4.W0 = arrayList3;
        }
        arrayList3.add(this);
        this.y = new j22(this);
        this.x = new GestureDetector(this.r.getContext(), this.y);
    }

    public final int j(int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.g);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.f && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.r.getWidth() * 0.5f;
        if ((i & i2) == 0 || Math.abs(this.h) <= width) {
            return 0;
        }
        return i2;
    }

    public final void k(int i, int i2, MotionEvent motionEvent) {
        View viewN;
        if (this.c != null || i != 2 || this.n == 2 || this.r.getScrollState() == 1) {
            return;
        }
        ag3 layoutManager = this.r.getLayoutManager();
        int i3 = this.l;
        rg3 rg3VarN = null;
        if (i3 != -1) {
            int iFindPointerIndex = motionEvent.findPointerIndex(i3);
            float x = motionEvent.getX(iFindPointerIndex) - this.d;
            float y = motionEvent.getY(iFindPointerIndex) - this.e;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(y);
            float f = this.q;
            if ((fAbs >= f || fAbs2 >= f) && ((fAbs <= fAbs2 || !layoutManager.d()) && ((fAbs2 <= fAbs || !layoutManager.e()) && (viewN = n(motionEvent)) != null))) {
                rg3VarN = this.r.N(viewN);
            }
        }
        if (rg3VarN == null) {
            return;
        }
        RecyclerView recyclerView = this.r;
        int iB = (i22.b(this.m.d(recyclerView, rg3VarN), recyclerView.getLayoutDirection()) & 65280) >> 8;
        if (iB == 0) {
            return;
        }
        float x2 = motionEvent.getX(i2);
        float y2 = motionEvent.getY(i2);
        float f2 = x2 - this.d;
        float f3 = y2 - this.e;
        float fAbs3 = Math.abs(f2);
        float fAbs4 = Math.abs(f3);
        float f4 = this.q;
        if (fAbs3 >= f4 || fAbs4 >= f4) {
            if (fAbs3 > fAbs4) {
                if (f2 < 0.0f && (iB & 4) == 0) {
                    return;
                }
                if (f2 > 0.0f && (iB & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < 0.0f && (iB & 1) == 0) {
                    return;
                }
                if (f3 > 0.0f && (iB & 2) == 0) {
                    return;
                }
            }
            this.i = 0.0f;
            this.h = 0.0f;
            this.l = motionEvent.getPointerId(0);
            r(rg3VarN, 1);
        }
    }

    public final int l(int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.g);
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.f && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.r.getHeight() * 0.5f;
        if ((i & i2) == 0 || Math.abs(this.i) <= height) {
            return 0;
        }
        return i2;
    }

    public final void m(rg3 rg3Var, boolean z) {
        ArrayList arrayList = this.p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g22 g22Var = (g22) arrayList.get(size);
            if (g22Var.e == rg3Var) {
                g22Var.k |= z;
                if (!g22Var.l) {
                    g22Var.g.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    public final View n(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        rg3 rg3Var = this.c;
        if (rg3Var != null) {
            View view = rg3Var.a;
            if (p(view, x, y, this.j + this.h, this.k + this.i)) {
                return view;
            }
        }
        ArrayList arrayList = this.p;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g22 g22Var = (g22) arrayList.get(size);
            View view2 = g22Var.e.a;
            if (p(view2, x, y, g22Var.i, g22Var.j)) {
                return view2;
            }
        }
        return this.r.E(x, y);
    }

    public final void o(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.h) - this.c.a.getLeft();
        } else {
            fArr[0] = this.c.a.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.c.a.getTop();
        } else {
            fArr[1] = this.c.a.getTranslationY();
        }
    }

    public final void q(rg3 rg3Var) {
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int right;
        int iAbs4;
        int i;
        int i2;
        int i3;
        if (this.r.isLayoutRequested()) {
            return;
        }
        char c = 2;
        if (this.n != 2) {
            return;
        }
        int i4 = (int) (this.j + this.h);
        int i5 = (int) (this.k + this.i);
        View view = rg3Var.a;
        if (Math.abs(i5 - view.getTop()) >= view.getHeight() * 0.5f || Math.abs(i4 - view.getLeft()) >= view.getWidth() * 0.5f) {
            ArrayList arrayList = this.u;
            if (arrayList == null) {
                this.u = new ArrayList();
                this.v = new ArrayList();
            } else {
                arrayList.clear();
                this.v.clear();
            }
            int iRound = Math.round(this.j + this.h);
            int iRound2 = Math.round(this.k + this.i);
            int width = view.getWidth() + iRound;
            int height = view.getHeight() + iRound2;
            int i6 = (iRound + width) / 2;
            int i7 = (iRound2 + height) / 2;
            ag3 layoutManager = this.r.getLayoutManager();
            int iV = layoutManager.v();
            int i8 = 0;
            while (i8 < iV) {
                char c2 = c;
                View viewU = layoutManager.u(i8);
                if (viewU != view && viewU.getBottom() >= iRound2 && viewU.getTop() <= height && viewU.getRight() >= iRound && viewU.getLeft() <= width) {
                    rg3 rg3VarN = this.r.N(viewU);
                    int iAbs5 = Math.abs(i6 - ((viewU.getRight() + viewU.getLeft()) / 2));
                    int iAbs6 = Math.abs(i7 - ((viewU.getBottom() + viewU.getTop()) / 2));
                    int i9 = (iAbs6 * iAbs6) + (iAbs5 * iAbs5);
                    i = i4;
                    int size = this.u.size();
                    i2 = i5;
                    i3 = iRound;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < size) {
                        int i12 = size;
                        if (i9 <= ((Integer) this.v.get(i10)).intValue()) {
                            break;
                        }
                        i11++;
                        i10++;
                        size = i12;
                    }
                    this.u.add(i11, rg3VarN);
                    this.v.add(i11, Integer.valueOf(i9));
                } else {
                    i = i4;
                    i2 = i5;
                    i3 = iRound;
                }
                i8++;
                c = c2;
                i4 = i;
                i5 = i2;
                iRound = i3;
            }
            int i13 = i4;
            int i14 = i5;
            ArrayList arrayList2 = this.u;
            if (arrayList2.size() == 0) {
                return;
            }
            int width2 = view.getWidth() + i13;
            int height2 = view.getHeight() + i14;
            int left2 = i13 - view.getLeft();
            int top2 = i14 - view.getTop();
            int size2 = arrayList2.size();
            rg3 rg3Var2 = null;
            int i15 = -1;
            for (int i16 = 0; i16 < size2; i16++) {
                rg3 rg3Var3 = (rg3) arrayList2.get(i16);
                if (left2 > 0 && (right = rg3Var3.a.getRight() - width2) < 0 && rg3Var3.a.getRight() > view.getRight() && (iAbs4 = Math.abs(right)) > i15) {
                    i15 = iAbs4;
                    rg3Var2 = rg3Var3;
                }
                if (left2 < 0 && (left = rg3Var3.a.getLeft() - i13) > 0 && rg3Var3.a.getLeft() < view.getLeft() && (iAbs3 = Math.abs(left)) > i15) {
                    i15 = iAbs3;
                    rg3Var2 = rg3Var3;
                }
                if (top2 < 0 && (top = rg3Var3.a.getTop() - i14) > 0 && rg3Var3.a.getTop() < view.getTop() && (iAbs2 = Math.abs(top)) > i15) {
                    i15 = iAbs2;
                    rg3Var2 = rg3Var3;
                }
                if (top2 > 0 && (bottom = rg3Var3.a.getBottom() - height2) < 0 && rg3Var3.a.getBottom() > view.getBottom() && (iAbs = Math.abs(bottom)) > i15) {
                    i15 = iAbs;
                    rg3Var2 = rg3Var3;
                }
            }
            if (rg3Var2 == null) {
                this.u.clear();
                this.v.clear();
                return;
            }
            View view2 = rg3Var2.a;
            int iB = rg3Var2.b();
            rg3Var.b();
            if (this.m.l(this.r, rg3Var, rg3Var2)) {
                RecyclerView recyclerView = this.r;
                ag3 layoutManager2 = recyclerView.getLayoutManager();
                if (!(layoutManager2 instanceof LinearLayoutManager)) {
                    if (layoutManager2.d()) {
                        if (ag3.A(view2) <= recyclerView.getPaddingLeft()) {
                            recyclerView.l0(iB);
                        }
                        if (ag3.D(view2) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                            recyclerView.l0(iB);
                        }
                    }
                    if (layoutManager2.e()) {
                        if (ag3.E(view2) <= recyclerView.getPaddingTop()) {
                            recyclerView.l0(iB);
                        }
                        if (ag3.y(view2) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                            recyclerView.l0(iB);
                            return;
                        }
                        return;
                    }
                    return;
                }
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                linearLayoutManager.c("Cannot drop a view during a scroll or layout calculation");
                linearLayoutManager.P0();
                linearLayoutManager.f1();
                int iK = ag3.K(view);
                int iK2 = ag3.K(view2);
                byte b = iK < iK2 ? (byte) 1 : (byte) -1;
                boolean z = linearLayoutManager.u;
                h31 h31Var = linearLayoutManager.r;
                if (z) {
                    if (b == 1) {
                        linearLayoutManager.h1(iK2, h31Var.i() - (linearLayoutManager.r.e(view) + linearLayoutManager.r.g(view2)));
                        return;
                    } else {
                        linearLayoutManager.h1(iK2, h31Var.i() - linearLayoutManager.r.d(view2));
                        return;
                    }
                }
                if (b == -1) {
                    linearLayoutManager.h1(iK2, h31Var.g(view2));
                } else {
                    linearLayoutManager.h1(iK2, h31Var.d(view2) - linearLayoutManager.r.e(view));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0127  */
    /* JADX WARN: Type inference failed for: r0v4, types: [i22] */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r2v1, types: [rg3] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [i22] */
    /* JADX WARN: Type inference failed for: r3v3, types: [i22] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(rg3 rg3Var, int i) {
        ?? r20;
        ?? r12;
        boolean z;
        ?? r3;
        ?? r202;
        ?? r122;
        rg3 rg3Var2;
        boolean z2;
        int iL;
        VelocityTracker velocityTracker;
        char c;
        float fSignum;
        Object obj;
        if (rg3Var == this.c && i == this.n) {
            return;
        }
        this.B = Long.MIN_VALUE;
        int i2 = this.n;
        m(rg3Var, true);
        this.n = i;
        if (i == 2) {
            if (rg3Var == null) {
                xe.k("Must pass a ViewHolder when dragging");
                return;
            }
            this.w = rg3Var.a;
        }
        int i3 = (1 << ((i * 8) + 8)) - 1;
        ?? r2 = this.c;
        ?? r0 = this.m;
        if (r2 != 0) {
            View view = r2.a;
            if (view.getParent() == null) {
                r202 = r0;
                r122 = 0;
                if (view == this.w) {
                    rg3Var2 = null;
                    this.w = null;
                } else {
                    rg3Var2 = null;
                }
                i22.a(r2);
                z2 = false;
            } else if (i2 != 2 && this.n != 2) {
                int iD = r0.d(this.r, r2);
                int iB = (i22.b(iD, this.r.getLayoutDirection()) & 65280) >> 8;
                if (iB == 0) {
                    iL = 0;
                    velocityTracker = this.t;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.t = null;
                    }
                    char c2 = 4;
                    float fSignum2 = 0.0f;
                    if (iL == 1 || iL == 2) {
                        c = 0;
                        fSignum = Math.signum(this.i) * this.r.getHeight();
                        obj = null;
                    } else if (iL == 4 || iL == 8 || iL == 16 || iL == 32) {
                        c = 0;
                        obj = null;
                        fSignum = 0.0f;
                        fSignum2 = Math.signum(this.h) * this.r.getWidth();
                    } else {
                        obj = null;
                        c = 0;
                        fSignum = 0.0f;
                    }
                    if (i2 != 2) {
                        c2 = '\b';
                    } else if (iL > 0) {
                        c2 = 2;
                    }
                    float[] fArr = this.b;
                    o(fArr);
                    char c3 = c2;
                    ?? r123 = c;
                    r202 = r0;
                    g22 g22Var = new g22(this, r2, i2, fArr[c], fArr[1], fSignum2, fSignum, iL, r2);
                    xf3 itemAnimator = this.r.getItemAnimator();
                    long j = itemAnimator != null ? c3 == '\b' ? 200L : 250L : c3 == '\b' ? itemAnimator.e : itemAnimator.d;
                    ValueAnimator valueAnimator = g22Var.g;
                    valueAnimator.setDuration(j);
                    this.p.add(g22Var);
                    r2.p(r123);
                    valueAnimator.start();
                    z2 = true;
                    rg3Var2 = null;
                    r122 = r123;
                } else {
                    int i4 = (iD & 65280) >> 8;
                    if (Math.abs(this.h) > Math.abs(this.i)) {
                        iL = j(iB);
                        if (iL <= 0) {
                            iL = l(iB);
                            if (iL <= 0) {
                            }
                        } else if ((i4 & iL) == 0) {
                            iL = i22.c(iL, this.r.getLayoutDirection());
                        }
                        velocityTracker = this.t;
                        if (velocityTracker != null) {
                        }
                        char c22 = 4;
                        float fSignum22 = 0.0f;
                        if (iL == 1) {
                            c = 0;
                            fSignum = Math.signum(this.i) * this.r.getHeight();
                            obj = null;
                            if (i2 != 2) {
                            }
                            float[] fArr2 = this.b;
                            o(fArr2);
                            char c32 = c22;
                            ?? r1232 = c;
                            r202 = r0;
                            g22 g22Var2 = new g22(this, r2, i2, fArr2[c], fArr2[1], fSignum22, fSignum, iL, r2);
                            xf3 itemAnimator2 = this.r.getItemAnimator();
                            if (itemAnimator2 != null) {
                            }
                            ValueAnimator valueAnimator2 = g22Var2.g;
                            valueAnimator2.setDuration(j);
                            this.p.add(g22Var2);
                            r2.p(r1232);
                            valueAnimator2.start();
                            z2 = true;
                            rg3Var2 = null;
                            r122 = r1232;
                        }
                    } else {
                        iL = l(iB);
                        if (iL <= 0) {
                            iL = j(iB);
                            if (iL > 0) {
                                if ((i4 & iL) == 0) {
                                    iL = i22.c(iL, this.r.getLayoutDirection());
                                }
                            }
                        }
                        velocityTracker = this.t;
                        if (velocityTracker != null) {
                        }
                        char c222 = 4;
                        float fSignum222 = 0.0f;
                        if (iL == 1) {
                        }
                    }
                }
            }
            this.c = rg3Var2;
            z = z2;
            r12 = r122;
            r20 = r202;
        } else {
            r20 = r0;
            r12 = 0;
            z = false;
        }
        if (rg3Var != null) {
            View view2 = rg3Var.a;
            RecyclerView recyclerView = this.r;
            ?? r32 = r20;
            this.o = (i22.b(r32.d(recyclerView, rg3Var), recyclerView.getLayoutDirection()) & i3) >> (this.n * 8);
            this.j = view2.getLeft();
            this.k = view2.getTop();
            this.c = rg3Var;
            r3 = r32;
            if (i == 2) {
                view2.performHapticFeedback(r12 == true ? 1 : 0);
                r3 = r32;
            }
        } else {
            r3 = r20;
        }
        ?? parent = this.r.getParent();
        if (parent != 0) {
            ?? r124 = r12;
            if (this.c != null) {
                r124 = 1;
            }
            parent.requestDisallowInterceptTouchEvent(r124);
        }
        if (!z) {
            this.r.getLayoutManager().f = true;
        }
        r3.m(this.c, this.n);
        this.r.invalidate();
    }

    public final void s(int i, int i2, MotionEvent motionEvent) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float fMax = x - this.d;
        this.h = fMax;
        this.i = y - this.e;
        if ((i & 4) == 0) {
            fMax = Math.max(0.0f, fMax);
            this.h = fMax;
        }
        if ((i & 8) == 0) {
            this.h = Math.min(0.0f, fMax);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    @Override // defpackage.cg3
    public final void d(View view) {
    }
}
