package defpackage;

import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y10 extends r82 implements am1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ z10 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y10(z10 z10Var, int i) {
        super(1);
        this.f = i;
        this.z = z10Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        z10 z10Var = this.z;
        switch (i) {
            case 0:
                ((SubMenu) obj).getClass();
                v10 v10Var = (v10) z10Var.e.f;
                if (v10Var != null) {
                    v10Var.a();
                }
                break;
            default:
                MenuItem menuItem = (MenuItem) obj;
                menuItem.getClass();
                Stack stack = z10Var.h;
                if (!menuItem.hasSubMenu()) {
                    Menu menu = (Menu) stack.peek();
                    ((sk2) menuItem).f();
                    if (stack.peek() == menu) {
                        z10Var.f.dismiss();
                    }
                } else {
                    Menu subMenu = menuItem.getSubMenu();
                    subMenu.getClass();
                    z10Var.a((nk2) subMenu, true);
                }
                break;
        }
        return xl4Var;
    }
}
