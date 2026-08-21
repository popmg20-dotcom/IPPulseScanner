package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m63 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ yg3 a;
    public final /* synthetic */ bh3 b;
    public final /* synthetic */ ProfileEditorActivity c;
    public final /* synthetic */ ub4 d;

    public m63(yg3 yg3Var, bh3 bh3Var, ProfileEditorActivity profileEditorActivity, ub4 ub4Var) {
        this.a = yg3Var;
        this.b = bh3Var;
        this.c = profileEditorActivity;
        this.d = ub4Var;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        motionEvent.getClass();
        this.a.b = 0.0f;
        return super.onDown(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        t02 t02VarH;
        motionEvent2.getClass();
        this.a.b = f2;
        ProfileEditorActivity profileEditorActivity = this.c;
        bh3 bh3Var = this.b;
        if (f2 < 0.0f && bh3Var.b == null) {
            cm2 cm2Var = profileEditorActivity.S0;
            if (cm2Var == null) {
                n12.T("binding");
                throw null;
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) cm2Var.f;
            WeakHashMap weakHashMap = wp4.a;
            bv4 bv4VarA = np4.a(constraintLayout);
            if (bv4VarA != null && bv4VarA.a.t(8)) {
                ((vo) this.d.b).i(new wn1(12, bh3Var));
                return true;
            }
        }
        hu4 hu4Var = (hu4) bh3Var.b;
        if (hu4Var == null) {
            return false;
        }
        gu4 gu4Var = hu4Var.a;
        t02 t02VarX0 = gu4Var.x0();
        int i = gu4Var.z0().d;
        int iU = gb4.u((int) (t02VarX0.d + f2), gu4Var.y0().d, i);
        float f3 = (iU - r4) / (i - r4);
        gu4Var.A0(t02.c(0, 0, 0, iU), f3);
        cm2 cm2Var2 = profileEditorActivity.S0;
        if (cm2Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) cm2Var2.f;
        WeakHashMap weakHashMap2 = wp4.a;
        bv4 bv4VarA2 = np4.a(constraintLayout2);
        if (bv4VarA2 == null || (t02VarH = bv4VarA2.a.h(519)) == null) {
            t02VarH = t02.e;
        }
        cm2 cm2Var3 = profileEditorActivity.S0;
        if (cm2Var3 == null) {
            n12.T("binding");
            throw null;
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) cm2Var3.Y;
        horizontalScrollView.setPadding(horizontalScrollView.getPaddingLeft(), horizontalScrollView.getPaddingTop(), horizontalScrollView.getPaddingRight(), (int) ((1.0f - f3) * t02VarH.d));
        return true;
    }
}
