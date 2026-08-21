package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zb2 extends BaseAdapter {
    public int b = -1;
    public final /* synthetic */ ac2 f;

    public zb2(ac2 ac2Var) {
        this.f = ac2Var;
        a();
    }

    public final void a() {
        nk2 nk2Var = this.f.z;
        sk2 sk2Var = nk2Var.w;
        if (sk2Var != null) {
            nk2Var.k();
            ArrayList arrayList = nk2Var.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((sk2) arrayList.get(i)) == sk2Var) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final sk2 getItem(int i) {
        nk2 nk2Var = this.f.z;
        nk2Var.k();
        ArrayList arrayList = nk2Var.j;
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (sk2) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        nk2 nk2Var = this.f.z;
        nk2Var.k();
        int size = nk2Var.j.size();
        return this.b < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f.f.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((hl2) view).c(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
