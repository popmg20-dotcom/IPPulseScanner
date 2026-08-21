package defpackage;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class op2 implements gl2 {
    public mp2 b;
    public boolean f;
    public int z;

    @Override // defpackage.gl2
    public final void c(boolean z) {
        kp2 kp2Var;
        ig igVar;
        if (this.f) {
            return;
        }
        mp2 mp2Var = this.b;
        if (z) {
            mp2Var.a();
            return;
        }
        kp2 kp2Var2 = mp2Var.g1;
        if (kp2Var2 == null || mp2Var.A0 == null) {
            return;
        }
        mp2Var.f1.f = true;
        kp2Var2.b();
        mp2Var.f1.f = false;
        if (mp2Var.A0 != null && (kp2Var = mp2Var.g1) != null && kp2Var.b.size() == mp2Var.A0.length) {
            for (int i = 0; i < mp2Var.A0.length; i++) {
                if (!(mp2Var.g1.a(i) instanceof mw0) || (mp2Var.A0[i] instanceof fp2)) {
                    boolean z2 = mp2Var.g1.a(i).hasSubMenu() && !(mp2Var.A0[i] instanceof qp2);
                    boolean z3 = (mp2Var.g1.a(i).hasSubMenu() || (mp2Var.A0[i] instanceof ip2)) ? false : true;
                    if ((mp2Var.g1.a(i) instanceof mw0) || (!z2 && !z3)) {
                    }
                }
            }
            int i2 = mp2Var.B0;
            int size = mp2Var.g1.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem menuItemA = mp2Var.g1.a(i3);
                if (menuItemA.isChecked()) {
                    mp2Var.setCheckedItem(menuItemA);
                    mp2Var.B0 = menuItemA.getItemId();
                    mp2Var.C0 = i3;
                }
            }
            if (i2 != mp2Var.B0 && (igVar = mp2Var.b) != null) {
                ah4.a(mp2Var, igVar);
            }
            boolean zG = mp2.g(mp2Var.y0, mp2Var.getCurrentVisibleContentItemCount());
            for (int i4 = 0; i4 < size; i4++) {
                mp2Var.f1.f = true;
                mp2Var.A0[i4].setExpanded(mp2Var.l1);
                lp2 lp2Var = mp2Var.A0[i4];
                if (lp2Var instanceof ip2) {
                    ip2 ip2Var = (ip2) lp2Var;
                    ip2Var.setLabelVisibilityMode(mp2Var.y0);
                    ip2Var.setItemIconGravity(mp2Var.z0);
                    ip2Var.setItemGravity(mp2Var.b1);
                    ip2Var.setShifting(zG);
                }
                if (mp2Var.g1.a(i4) instanceof sk2) {
                    mp2Var.A0[i4].c((sk2) mp2Var.g1.a(i4));
                }
                mp2Var.f1.f = false;
            }
            return;
        }
        mp2Var.a();
    }

    @Override // defpackage.gl2
    public final boolean d(b54 b54Var) {
        return false;
    }

    @Override // defpackage.gl2
    public final boolean e() {
        return false;
    }

    @Override // defpackage.gl2
    public final boolean f(sk2 sk2Var) {
        return false;
    }

    @Override // defpackage.gl2
    public final int getId() {
        return this.z;
    }

    @Override // defpackage.gl2
    public final void h(Parcelable parcelable) {
        if (parcelable instanceof np2) {
            mp2 mp2Var = this.b;
            np2 np2Var = (np2) parcelable;
            int i = np2Var.b;
            int size = mp2Var.g1.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem menuItemA = mp2Var.g1.a(i2);
                if (i == menuItemA.getItemId()) {
                    mp2Var.B0 = i;
                    mp2Var.C0 = i2;
                    mp2Var.setCheckedItem(menuItemA);
                    break;
                }
                i2++;
            }
            Context context = this.b.getContext();
            j03 j03Var = np2Var.f;
            SparseArray sparseArray = new SparseArray(j03Var.size());
            for (int i3 = 0; i3 < j03Var.size(); i3++) {
                int iKeyAt = j03Var.keyAt(i3);
                qj qjVar = (qj) j03Var.valueAt(i3);
                sparseArray.put(iKeyAt, qjVar != null ? new pj(context, qjVar) : null);
            }
            mp2 mp2Var2 = this.b;
            SparseArray sparseArray2 = mp2Var2.P0;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                int iKeyAt2 = sparseArray.keyAt(i4);
                if (sparseArray2.indexOfKey(iKeyAt2) < 0) {
                    sparseArray2.append(iKeyAt2, (pj) sparseArray.get(iKeyAt2));
                }
            }
            lp2[] lp2VarArr = mp2Var2.A0;
            if (lp2VarArr != null) {
                for (lp2 lp2Var : lp2VarArr) {
                    if (lp2Var instanceof ip2) {
                        ip2 ip2Var = (ip2) lp2Var;
                        pj pjVar = (pj) sparseArray2.get(ip2Var.getId());
                        if (pjVar != null) {
                            ip2Var.setBadge(pjVar);
                        }
                    }
                }
            }
        }
    }

    @Override // defpackage.gl2
    public final boolean j(sk2 sk2Var) {
        return false;
    }

    @Override // defpackage.gl2
    public final void l(Context context, nk2 nk2Var) {
        this.b.b(nk2Var);
    }

    @Override // defpackage.gl2
    public final Parcelable m() {
        np2 np2Var = new np2();
        np2Var.b = this.b.getSelectedItemId();
        SparseArray<pj> badgeDrawables = this.b.getBadgeDrawables();
        j03 j03Var = new j03();
        for (int i = 0; i < badgeDrawables.size(); i++) {
            int iKeyAt = badgeDrawables.keyAt(i);
            pj pjVarValueAt = badgeDrawables.valueAt(i);
            j03Var.put(iKeyAt, pjVarValueAt != null ? pjVarValueAt.X.a : null);
        }
        np2Var.f = j03Var;
        return np2Var;
    }

    @Override // defpackage.gl2
    public final void a(nk2 nk2Var, boolean z) {
    }
}
