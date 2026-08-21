package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kk2 extends BaseAdapter {
    public final boolean A;
    public final LayoutInflater X;
    public final int Y;
    public final nk2 b;
    public int f = -1;
    public boolean z;

    public kk2(nk2 nk2Var, LayoutInflater layoutInflater, boolean z, int i) {
        this.A = z;
        this.X = layoutInflater;
        this.b = nk2Var;
        this.Y = i;
        a();
    }

    public final void a() {
        nk2 nk2Var = this.b;
        sk2 sk2Var = nk2Var.w;
        if (sk2Var != null) {
            nk2Var.k();
            ArrayList arrayList = nk2Var.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((sk2) arrayList.get(i)) == sk2Var) {
                    this.f = i;
                    return;
                }
            }
        }
        this.f = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final sk2 getItem(int i) {
        ArrayList arrayListN;
        boolean z = this.A;
        nk2 nk2Var = this.b;
        if (z) {
            nk2Var.k();
            arrayListN = nk2Var.j;
        } else {
            arrayListN = nk2Var.n();
        }
        int i2 = this.f;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (sk2) arrayListN.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListN;
        boolean z = this.A;
        nk2 nk2Var = this.b;
        if (z) {
            nk2Var.k();
            arrayListN = nk2Var.j;
        } else {
            arrayListN = nk2Var.n();
        }
        return this.f < 0 ? arrayListN.size() : arrayListN.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.X.inflate(this.Y, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        int i4 = i3 >= 0 ? getItem(i3).b : i2;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.b.o() && i2 != i4) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        hl2 hl2Var = (hl2) view;
        if (this.z) {
            listMenuItemView.setForceShowIcon(true);
        }
        hl2Var.c(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
