package defpackage;

import android.widget.HorizontalScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k63 extends k70 {
    public final /* synthetic */ ProfileEditorActivity X;

    public k63(ProfileEditorActivity profileEditorActivity) {
        super((byte) 0, 8);
        this.X = profileEditorActivity;
    }

    @Override // defpackage.k70
    public final void P0(fu4 fu4Var) {
        if ((fu4Var.a.d() & 8) != 0) {
            cm2 cm2Var = this.X.S0;
            if (cm2Var != null) {
                ((ConstraintLayout) cm2Var.f).setTag(R.id.tag_ime_animating, Boolean.FALSE);
            } else {
                n12.T("binding");
                throw null;
            }
        }
    }

    @Override // defpackage.k70
    public final void Q0(fu4 fu4Var) {
        if ((fu4Var.a.d() & 8) != 0) {
            cm2 cm2Var = this.X.S0;
            if (cm2Var != null) {
                ((ConstraintLayout) cm2Var.f).setTag(R.id.tag_ime_animating, Boolean.TRUE);
            } else {
                n12.T("binding");
                throw null;
            }
        }
    }

    @Override // defpackage.k70
    public final bv4 R0(bv4 bv4Var, List list) {
        bv4Var.getClass();
        list.getClass();
        yu4 yu4Var = bv4Var.a;
        t02 t02VarH = yu4Var.h(519);
        t02VarH.getClass();
        t02 t02VarH2 = yu4Var.h(8);
        t02VarH2.getClass();
        int i = t02VarH2.d;
        ProfileEditorActivity profileEditorActivity = this.X;
        cm2 cm2Var = profileEditorActivity.S0;
        if (cm2Var == null) {
            n12.T("binding");
            throw null;
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) cm2Var.Y;
        horizontalScrollView.setPadding(horizontalScrollView.getPaddingLeft(), horizontalScrollView.getPaddingTop(), horizontalScrollView.getPaddingRight(), t02VarH.d);
        cm2 cm2Var2 = profileEditorActivity.S0;
        if (cm2Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) cm2Var2.f;
        constraintLayout.getClass();
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), i);
        if (i <= 0) {
            return bv4Var;
        }
        cm2 cm2Var3 = profileEditorActivity.S0;
        if (cm2Var3 == null) {
            n12.T("binding");
            throw null;
        }
        HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) cm2Var3.Y;
        horizontalScrollView2.setPadding(horizontalScrollView2.getPaddingLeft(), horizontalScrollView2.getPaddingTop(), horizontalScrollView2.getPaddingRight(), 0);
        return bv4Var;
    }
}
