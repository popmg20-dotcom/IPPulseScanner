package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.ListMenuItemView;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u10 extends rf3 {
    public final ArrayList d;
    public final iv1 e;
    public final ue2 f;
    public final y10 g;
    public final y10 h;

    public u10(ArrayList arrayList, iv1 iv1Var, ue2 ue2Var, y10 y10Var, y10 y10Var2) {
        ue2Var.getClass();
        this.d = arrayList;
        this.e = iv1Var;
        this.f = ue2Var;
        this.g = y10Var;
        this.h = y10Var2;
    }

    @Override // defpackage.rf3
    public final int b() {
        return this.d.size();
    }

    @Override // defpackage.rf3
    public final int d(int i) {
        n5 n5Var = (n5) this.d.get(i);
        if (n5Var instanceof l5) {
            return 0;
        }
        if (n5Var instanceof m5) {
            return 1;
        }
        g.d();
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c2  */
    @Override // defpackage.rf3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(rg3 rg3Var, int i) {
        boolean z;
        boolean z2 = rg3Var instanceof pk2;
        iv1 iv1Var = this.e;
        ArrayList arrayList = this.d;
        if (z2) {
            pk2 pk2Var = (pk2) rg3Var;
            TextView textView = pk2Var.v;
            View view = pk2Var.a;
            Object obj = arrayList.get(i);
            obj.getClass();
            l5 l5Var = (l5) obj;
            View view2 = pk2Var.u;
            pk2Var.w = l5Var;
            textView.setText(((b54) l5Var.a).m);
            boolean z3 = l5Var.b;
            if (z3) {
                Drawable drawableR = vo.r(view.getContext(), R.drawable.cascade_ic_round_arrow_left_32);
                drawableR.getClass();
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableR, (Drawable) null, (Drawable) null, (Drawable) null);
                Context context = view.getContext();
                context.getClass();
                int iE = ek0.e(context, 6);
                Context context2 = view.getContext();
                context2.getClass();
                view2.setPaddingRelative(iE, view2.getPaddingTop(), ek0.e(context2, 16), view2.getPaddingBottom());
            } else {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                Context context3 = view.getContext();
                context3.getClass();
                int iE2 = ek0.e(context3, 16);
                Context context4 = view.getContext();
                context4.getClass();
                view2.setPaddingRelative(iE2, view2.getPaddingTop(), ek0.e(context4, 16), view2.getPaddingBottom());
            }
            view.setClickable(z3);
            ((am1) iv1Var.A).g(rg3Var);
            return;
        }
        if (rg3Var instanceof tk2) {
            tk2 tk2Var = (tk2) rg3Var;
            ImageView imageView = tk2Var.y;
            Object obj2 = arrayList.get(i);
            obj2.getClass();
            m5 m5Var = (m5) obj2;
            tk2Var.z = m5Var;
            ListMenuItemView listMenuItemView = tk2Var.u;
            listMenuItemView.setForceShowIcon(true);
            MenuItem menuItem = m5Var.a;
            sk2 sk2Var = (sk2) menuItem;
            listMenuItemView.c(sk2Var);
            Integer num = m5Var.c;
            if (num != null) {
                z = num.intValue() != menuItem.getGroupId();
            }
            listMenuItemView.setGroupDividerEnabled(z);
            if (menuItem.hasSubMenu()) {
                imageView.setImageResource(R.drawable.cascade_ic_round_arrow_right_24);
            }
            je.h0(imageView, tk2Var.s(0), 11);
            int iS = sk2Var.getIcon() != null ? tk2Var.s(12) : tk2Var.s(14);
            int iS2 = menuItem.hasSubMenu() ? tk2Var.s(4) : m5Var.b ? tk2Var.s(28) : tk2Var.s(14);
            int iS3 = tk2Var.s(14);
            m5 m5Var2 = tk2Var.z;
            if (m5Var2 == null) {
                n12.T("model");
                throw null;
            }
            boolean z4 = m5Var2.a.getIcon() != null;
            Object value = tk2Var.x.getValue();
            value.getClass();
            je.h0((ImageView) value, z4 ? iS : 0, 3);
            ViewGroup viewGroup = tk2Var.v;
            if (z4) {
                iS = iS3;
            }
            je.h0(viewGroup, iS, 11);
            View view3 = tk2Var.w;
            view3.setPaddingRelative(view3.getPaddingStart(), view3.getPaddingTop(), iS2, view3.getPaddingBottom());
            ((am1) iv1Var.X).g(rg3Var);
        }
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        ue2 ue2Var = this.f;
        if (i == 0) {
            int i2 = pk2.x;
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).cloneInContext(viewGroup.getContext()).inflate(R.layout.abc_popup_menu_header_item_layout, viewGroup, false);
            viewInflate.getClass();
            pk2 pk2Var = new pk2(viewInflate);
            viewInflate.setBackgroundResource(ue2Var.b);
            viewInflate.setOnClickListener(new kd(1, this, pk2Var));
            return pk2Var;
        }
        if (i != 1) {
            throw new ss2(0);
        }
        int i3 = tk2.A;
        View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).cloneInContext(viewGroup.getContext()).inflate(R.layout.abc_popup_menu_item_layout, viewGroup, false);
        viewInflate2.getClass();
        ListMenuItemView listMenuItemView = (ListMenuItemView) viewInflate2;
        tk2 tk2Var = new tk2(listMenuItemView);
        listMenuItemView.setBackgroundResource(ue2Var.b);
        listMenuItemView.setOnClickListener(new kd(2, this, tk2Var));
        return tk2Var;
    }
}
