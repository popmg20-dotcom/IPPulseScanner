package defpackage;

import android.content.Intent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textview.MaterialTextView;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p71 implements mu2, hf4 {
    public final /* synthetic */ v71 b;

    public /* synthetic */ p71(v71 v71Var) {
        this.b = v71Var;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        view.getClass();
        t02 t02VarH = bv4Var.a.h(519);
        t02VarH.getClass();
        v71 v71Var = this.b;
        h4 h4Var = v71Var.b;
        h4Var.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) h4Var.b;
        coordinatorLayout.getClass();
        coordinatorLayout.setPadding(t02VarH.a, coordinatorLayout.getPaddingTop(), t02VarH.c, coordinatorLayout.getPaddingBottom());
        h4 h4Var2 = v71Var.b;
        h4Var2.getClass();
        NestedScrollView nestedScrollView = (NestedScrollView) h4Var2.g;
        nestedScrollView.setPadding(nestedScrollView.getPaddingLeft(), nestedScrollView.getPaddingTop(), nestedScrollView.getPaddingRight(), t02VarH.d);
        return bv4Var;
    }

    @Override // defpackage.hf4
    public boolean a(sk2 sk2Var) {
        if (sk2Var.a != R.id.share) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        v71 v71Var = this.b;
        h4 h4Var = v71Var.b;
        h4Var.getClass();
        sb.append(((MaterialTextView) h4Var.c).getText());
        h4 h4Var2 = v71Var.b;
        h4Var2.getClass();
        if (((CircularProgressIndicator) h4Var2.h).getVisibility() != 0) {
            h4 h4Var3 = v71Var.b;
            h4Var3.getClass();
            if (((MaterialTextView) h4Var3.e).getVisibility() == 0) {
                sb.append("\n\n");
                h4 h4Var4 = v71Var.b;
                h4Var4.getClass();
                sb.append(((MaterialTextView) h4Var4.e).getText());
            }
        }
        String string = sb.toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE);
        intent.putExtra("android.intent.extra.TEXT", string);
        v71Var.startActivity(Intent.createChooser(intent, null));
        return true;
    }
}
