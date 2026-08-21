package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xk0 extends BaseAdapter implements Adapter {
    public t01 b;
    public ArrayList f;

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayList = this.f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return (ax3) this.f.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return ((ax3) this.f.get(i)).hashCode();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        t01 t01Var = this.b;
        boolean z = i == t01Var.M0;
        if (view == null) {
            view = LayoutInflater.from(t01Var.F0.getContext()).inflate(R.layout.default_completion_result_item, viewGroup, false);
        }
        ax3 ax3Var = (ax3) this.f.get(i);
        TextView textView = (TextView) view.findViewById(R.id.result_item_label);
        textView.setText(ax3Var.b);
        textView.setTextColor(this.b.f.getColorScheme().e(42));
        TextView textView2 = (TextView) view.findViewById(R.id.result_item_desc);
        textView2.setText("Identifier");
        textView2.setTextColor(this.b.f.getColorScheme().e(43));
        view.setTag(Integer.valueOf(i));
        if (z) {
            view.setBackgroundColor(this.b.f.getColorScheme().e(44));
        } else {
            view.setBackgroundColor(0);
        }
        ((ImageView) view.findViewById(R.id.result_item_image)).setImageDrawable(ax3Var.a);
        return view;
    }
}
