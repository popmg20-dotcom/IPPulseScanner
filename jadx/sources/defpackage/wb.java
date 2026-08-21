package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wb implements AdapterView.OnItemClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ wb(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.b;
        Object obj = this.f;
        switch (i2) {
            case 0:
                yb ybVar = (yb) obj;
                bc bcVar = ybVar.Y0;
                bcVar.setSelection(i);
                if (bcVar.getOnItemClickListener() != null) {
                    bcVar.performItemClick(view, i, ybVar.V0.getItemId(i));
                }
                ybVar.dismiss();
                break;
            case 1:
                MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) obj;
                hc2 hc2Var = materialAutoCompleteTextView.y0;
                materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(i < 0 ? !hc2Var.Q0.isShowing() ? null : hc2Var.z.getSelectedItem() : materialAutoCompleteTextView.getAdapter().getItem(i)), false);
                AdapterView.OnItemClickListener onItemClickListener = materialAutoCompleteTextView.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !hc2Var.Q0.isShowing() ? null : hc2Var.z.getSelectedView();
                        i = !hc2Var.Q0.isShowing() ? -1 : hc2Var.z.getSelectedItemPosition();
                        j = !hc2Var.Q0.isShowing() ? Long.MIN_VALUE : hc2Var.z.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(hc2Var.z, view, i, j);
                }
                hc2Var.dismiss();
                break;
            default:
                ((SearchView) obj).n(i);
                break;
        }
    }
}
