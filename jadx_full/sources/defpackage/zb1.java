package defpackage;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zb1 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ bc1 f;

    public /* synthetic */ zb1(bc1 bc1Var, int i) {
        this.b = i;
        this.f = bc1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int iK;
        String strA;
        int paddingBottom;
        int i = this.b;
        bc1 bc1Var = this.f;
        switch (i) {
            case 0:
                if (!bc1Var.s) {
                    bc1Var.e.b(bc1Var.i, bc1Var.j);
                    break;
                }
                break;
            case 1:
                bc1 bc1Var2 = this.f;
                int i2 = bc1Var2.f;
                int i3 = bc1Var2.h;
                ViewGroup viewGroup = bc1Var2.c;
                int i4 = bc1Var2.g;
                View view = bc1Var2.j;
                AppCompatTextView appCompatTextView = bc1Var2.k;
                bc1Var2.i();
                View view2 = bc1Var2.i;
                int i5 = 0;
                view2.setVisibility(bc1Var2.l ? 0 : 4);
                view.setVisibility(bc1Var2.l ? 0 : 4);
                if (!bc1Var2.l) {
                    appCompatTextView.setVisibility(4);
                } else {
                    int layoutDirection = viewGroup.getLayoutDirection();
                    view2.setLayoutDirection(layoutDirection);
                    view.setLayoutDirection(layoutDirection);
                    appCompatTextView.setLayoutDirection(layoutDirection);
                    boolean z = layoutDirection == 1;
                    int width = viewGroup.getWidth();
                    int height = viewGroup.getHeight();
                    Rect rectA = bc1Var2.a();
                    int i6 = z ? rectA.left : (width - rectA.right) - i2;
                    int i7 = rectA.top;
                    bc1Var2.e(view2, i6, i7, i2 + i6, Math.max(height - rectA.bottom, i7));
                    int i8 = z ? rectA.left : (width - rectA.right) - i4;
                    int i9 = bc1Var2.m + rectA.top;
                    bc1Var2.e(view, i8, i9, i8 + i4, i9 + i3);
                    n02 n02Var = bc1Var2.d;
                    RecyclerView recyclerView = (RecyclerView) n02Var.f;
                    g23 g23Var = (g23) n02Var.z;
                    if (g23Var == null) {
                        Object adapter = recyclerView.getAdapter();
                        if (adapter instanceof g23) {
                            g23Var = (g23) adapter;
                        }
                    }
                    if (g23Var == null) {
                        strA = null;
                    } else {
                        RecyclerView recyclerView2 = (RecyclerView) n02Var.f;
                        if (recyclerView2.getChildCount() == 0) {
                            iK = -1;
                            if (iK == -1) {
                                strA = g23Var.a(recyclerView, iK);
                            }
                        } else {
                            View childAt = recyclerView2.getChildAt(0);
                            if (n02Var.u() != null) {
                                iK = ag3.K(childAt);
                            }
                            if (iK == -1) {
                            }
                        }
                    }
                    boolean zIsEmpty = TextUtils.isEmpty(strA);
                    appCompatTextView.setVisibility(!zIsEmpty ? 0 : 4);
                    if (!zIsEmpty) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) appCompatTextView.getLayoutParams();
                        if (!Objects.equals(appCompatTextView.getText(), strA)) {
                            appCompatTextView.setText(strA);
                            appCompatTextView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(width, Pow2.MAX_POW2), rectA.left + rectA.right + i4 + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(height, Pow2.MAX_POW2), rectA.top + rectA.bottom + layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        }
                        int measuredWidth = appCompatTextView.getMeasuredWidth();
                        int measuredHeight = appCompatTextView.getMeasuredHeight();
                        int i10 = z ? rectA.left + i4 + layoutParams.leftMargin : (((width - rectA.right) - i4) - layoutParams.rightMargin) - measuredWidth;
                        int i11 = layoutParams.gravity;
                        int i12 = i11 & 7;
                        if (i12 == 1) {
                            i5 = measuredHeight / 2;
                        } else if (i12 == 5) {
                            i5 = measuredHeight;
                        }
                        int i13 = i11 & 112;
                        if (i13 != 16) {
                            paddingBottom = i13 != 80 ? view.getPaddingTop() : i3 - view.getPaddingBottom();
                        } else {
                            int paddingTop = view.getPaddingTop();
                            paddingBottom = (((i3 - paddingTop) - view.getPaddingBottom()) / 2) + paddingTop;
                        }
                        int iM = tj4.m((i9 + paddingBottom) - i5, rectA.top + layoutParams.topMargin, ((height - rectA.bottom) - layoutParams.bottomMargin) - measuredHeight);
                        bc1Var2.e(appCompatTextView, i10, iM, measuredWidth + i10, measuredHeight + iM);
                    }
                }
                break;
            default:
                bc1Var.i();
                if (bc1Var.l) {
                    bc1Var.e.l(bc1Var.i, bc1Var.j);
                    bc1Var.f();
                    break;
                }
                break;
        }
    }
}
