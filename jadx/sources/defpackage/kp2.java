package defpackage;

import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kp2 {
    public final nk2 a;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public final ArrayList b = new ArrayList();

    public kp2(nk2 nk2Var) {
        this.a = nk2Var;
        b();
    }

    public final MenuItem a(int i) {
        return (MenuItem) this.b.get(i);
    }

    public final void b() {
        ArrayList arrayList = this.b;
        arrayList.clear();
        this.c = 0;
        this.d = 0;
        this.e = 0;
        int i = 0;
        while (true) {
            nk2 nk2Var = this.a;
            if (i >= nk2Var.f.size()) {
                break;
            }
            MenuItem item = nk2Var.getItem(i);
            if (item.hasSubMenu()) {
                if (!arrayList.isEmpty() && !(fw.r(arrayList, 1) instanceof mw0) && item.isVisible()) {
                    arrayList.add(new mw0());
                }
                arrayList.add(item);
                SubMenu subMenu = item.getSubMenu();
                for (int i2 = 0; i2 < subMenu.size(); i2++) {
                    MenuItem item2 = subMenu.getItem(i2);
                    if (!item.isVisible()) {
                        item2.setVisible(false);
                    }
                    arrayList.add(item2);
                    this.c++;
                    if (item2.isVisible()) {
                        this.d++;
                    }
                }
                arrayList.add(new mw0());
            } else {
                arrayList.add(item);
                this.c++;
                if (item.isVisible()) {
                    this.d++;
                    this.e++;
                }
            }
            i++;
        }
        if (arrayList.isEmpty() || !(fw.r(arrayList, 1) instanceof mw0)) {
            return;
        }
        arrayList.remove(arrayList.size() - 1);
    }
}
