package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bb3 implements View.OnClickListener {
    public final /* synthetic */ int b = 0;
    public final Object f;
    public final /* synthetic */ Object z;

    public bb3(mf4 mf4Var) {
        this.z = mf4Var;
        Context context = mf4Var.a.getContext();
        CharSequence charSequence = mf4Var.h;
        i3 i3Var = new i3();
        i3Var.e = 4096;
        i3Var.g = 4096;
        i3Var.l = null;
        i3Var.m = null;
        i3Var.n = false;
        i3Var.o = false;
        i3Var.p = 16;
        i3Var.i = context;
        i3Var.a = charSequence;
        this.f = i3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        Object obj = this.f;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                cb3 cb3Var = (cb3) obj;
                uf4 uf4Var = cb3Var.b;
                uf4Var.getClass();
                int currentItem = ((ViewPager2) uf4Var.a).getCurrentItem();
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList(f70.Q(10, list));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((na3) it.next()).getName());
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list", new ArrayList<>(arrayList));
                bundle.putInt("index", currentItem);
                es3 es3Var = new es3();
                es3Var.setArguments(bundle);
                es3Var.m(cb3Var.getChildFragmentManager(), null);
                break;
            default:
                mf4 mf4Var = (mf4) obj2;
                Window.Callback callback = mf4Var.k;
                if (callback != null && mf4Var.l) {
                    callback.onMenuItemSelected(0, (i3) obj);
                    break;
                }
                break;
        }
    }

    public bb3(cb3 cb3Var, List list) {
        this.f = cb3Var;
        this.z = list;
    }
}
