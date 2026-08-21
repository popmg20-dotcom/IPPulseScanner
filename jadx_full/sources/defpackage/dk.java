package defpackage;

import android.view.View;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dk implements View.OnLongClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ dk(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                wh2 wh2Var = new wh2(view.getContext());
                wh2Var.x(R.string.toggle_cards);
                wh2Var.t(R.string.hide_card_prompt);
                wh2Var.w(R.string.hide_card_positive_text, new li(2, (ek) obj2, (View) obj));
                wh2Var.u(R.string.cancel, null);
                wh2Var.r();
                return true;
            default:
                pa3 pa3Var = (pa3) obj2;
                String name = pa3Var.f.getName();
                String str = ((f82) obj).z;
                xb5.c("proxy group " + name + " item " + str + " long pressed");
                cd cdVar = pa3Var.i;
                view.getClass();
                cdVar.k(view, str);
                return Boolean.TRUE.booleanValue();
        }
    }
}
