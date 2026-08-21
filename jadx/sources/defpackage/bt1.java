package defpackage;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.button.MaterialButton;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bt1 extends rb2 {
    public final k22 e;
    public final cd f;
    public final dt1 g;

    public bt1(k22 k22Var, cd cdVar, dt1 dt1Var) {
        super(ct1.a);
        this.e = k22Var;
        this.f = cdVar;
        this.g = dt1Var;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        final at1 at1Var = (at1) rg3Var;
        ls1 ls1Var = (ls1) q(i);
        v92 v92Var = at1Var.u;
        ((TextView) v92Var.z).setText(ls1Var.f);
        ((TextView) v92Var.X).setText(ls1Var.z);
        ((MaterialButton) v92Var.A).setOnClickListener(new d81(2, this, ls1Var, at1Var));
        ((ConstraintLayout) v92Var.b).setOnClickListener(new kd(4, this, ls1Var));
        ((ImageView) v92Var.f).setOnTouchListener(new View.OnTouchListener() { // from class: zs1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                k22 k22Var = this.b.e;
                i22 i22Var = k22Var.m;
                RecyclerView recyclerView = k22Var.r;
                at1 at1Var2 = at1Var;
                if ((i22.b(i22Var.d(recyclerView, at1Var2), recyclerView.getLayoutDirection()) & 16711680) == 0) {
                    a1.d("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
                    return true;
                }
                if (at1Var2.a.getParent() != k22Var.r) {
                    a1.d("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
                    return true;
                }
                VelocityTracker velocityTracker = k22Var.t;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                }
                k22Var.t = VelocityTracker.obtain();
                k22Var.i = 0.0f;
                k22Var.h = 0.0f;
                k22Var.r(at1Var2, 2);
                return true;
            }
        });
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_host, viewGroup, false);
        int i2 = R.id.handle;
        ImageView imageView = (ImageView) vf2.l(viewInflate, R.id.handle);
        if (imageView != null) {
            i2 = R.id.key;
            TextView textView = (TextView) vf2.l(viewInflate, R.id.key);
            if (textView != null) {
                i2 = R.id.more;
                MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.more);
                if (materialButton != null) {
                    i2 = R.id.value;
                    TextView textView2 = (TextView) vf2.l(viewInflate, R.id.value);
                    if (textView2 != null) {
                        return new at1(new v92((ConstraintLayout) viewInflate, imageView, textView, materialButton, textView2));
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
