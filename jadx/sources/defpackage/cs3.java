package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cs3 extends rb2 {
    public final f0 e;
    public int f;

    public cs3(f0 f0Var) {
        super(ds3.a);
        this.e = f0Var;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, final int i) {
        n02 n02Var = ((bs3) rg3Var).u;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n02Var.A;
        appCompatTextView.setText((CharSequence) q(i));
        MaterialCardView materialCardView = (MaterialCardView) n02Var.z;
        materialCardView.setChecked(i == this.f);
        ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
        if (layoutParams == null) {
            zo2.n("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginEnd(i == this.f ? ContextUtilsKt.c(16.0f) : 0);
        appCompatTextView.setLayoutParams(layoutParams2);
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: as3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.b.e.g(Integer.valueOf(i));
            }
        });
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_proxy_group, viewGroup, false);
        int i2 = R.id.card;
        MaterialCardView materialCardView = (MaterialCardView) vf2.l(viewInflate, R.id.card);
        if (materialCardView != null) {
            i2 = R.id.title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) vf2.l(viewInflate, R.id.title);
            if (appCompatTextView != null) {
                return new bs3(new n02(2, (FrameLayout) viewInflate, materialCardView, appCompatTextView));
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
