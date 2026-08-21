package defpackage;

import android.net.Uri;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.ProfileEditorActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ca1 extends rb2 {
    public final ha1 e;

    public ca1(ha1 ha1Var) {
        super(da1.a);
        this.e = ha1Var;
    }

    public static void t(View view, aa1 aa1Var) {
        String strK;
        Uri uri;
        ea1 ea1Var = aa1Var.e;
        if (ea1Var instanceof gx3) {
            strK = ContextUtilsKt.k(R.string.policy_path);
        } else if (ea1Var instanceof bx3) {
            strK = ContextUtilsKt.k(R.string.domain_set);
        } else {
            if (!(ea1Var instanceof ix3)) {
                g.d();
                return;
            }
            strK = ContextUtilsKt.k(R.string.rule_set);
        }
        if (ea1Var instanceof gx3) {
            uri = ((gx3) ea1Var).b;
        } else if (ea1Var instanceof bx3) {
            uri = ((bx3) ea1Var).b;
        } else {
            if (!(ea1Var instanceof ix3)) {
                g.d();
                return;
            }
            uri = ((ix3) ea1Var).b;
        }
        int i = ProfileEditorActivity.Y0;
        k01.v(view, strK, uri, false, true);
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        ba1 ba1Var = (ba1) rg3Var;
        aa1 aa1Var = (aa1) q(i);
        e22 e22Var = ba1Var.u;
        e22Var.e.setText(aa1Var.b);
        long j = aa1Var.c;
        ba1Var.v = j;
        e22Var.d.setText(ContextUtilsKt.l(R.string.last_modified_template, DateUtils.getRelativeTimeSpanString(j)));
        e22Var.b.setOnClickListener(new d81(1, this, e22Var, aa1Var));
        e22Var.c.setText(ContextUtilsKt.i(R.plurals.reference_count, aa1Var.d));
        e22Var.a.setOnClickListener(new mk(8, this, aa1Var));
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = ContextUtilsKt.f(viewGroup).inflate(R.layout.item_external_resource, viewGroup, false);
        int i2 = R.id.desc;
        TextView textView = (TextView) vf2.l(viewInflate, R.id.desc);
        if (textView != null) {
            i2 = R.id.last_update;
            TextView textView2 = (TextView) vf2.l(viewInflate, R.id.last_update);
            if (textView2 != null) {
                i2 = R.id.more;
                ImageView imageView = (ImageView) vf2.l(viewInflate, R.id.more);
                if (imageView != null) {
                    i2 = R.id.url;
                    TextView textView3 = (TextView) vf2.l(viewInflate, R.id.url);
                    if (textView3 != null) {
                        return new ba1(new e22((ConstraintLayout) viewInflate, textView, textView2, imageView, textView3));
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
