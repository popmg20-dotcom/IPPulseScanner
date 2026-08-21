package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(defpackage.rg3 r11, int r12) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u10.g(rg3, int):void");
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
