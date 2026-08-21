package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zh2 extends ArrayAdapter {
    public ColorStateList b;
    public ColorStateList f;
    public final /* synthetic */ MaterialAutoCompleteTextView z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zh2(MaterialAutoCompleteTextView materialAutoCompleteTextView, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.z = materialAutoCompleteTextView;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        MaterialAutoCompleteTextView materialAutoCompleteTextView = this.z;
        ColorStateList colorStateList2 = materialAutoCompleteTextView.F0;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f = colorStateList;
        if (materialAutoCompleteTextView.E0 != 0 && materialAutoCompleteTextView.F0 != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{u70.c(materialAutoCompleteTextView.F0.getColorForState(iArr3, 0), materialAutoCompleteTextView.E0), u70.c(materialAutoCompleteTextView.F0.getColorForState(iArr2, 0), materialAutoCompleteTextView.E0), materialAutoCompleteTextView.E0});
        }
        this.b = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = this.z;
            Drawable rippleDrawable = null;
            if (materialAutoCompleteTextView.getText().toString().contentEquals(textView.getText()) && materialAutoCompleteTextView.E0 != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(materialAutoCompleteTextView.E0);
                if (this.f != null) {
                    colorDrawable.setTintList(this.b);
                    rippleDrawable = new RippleDrawable(this.f, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
