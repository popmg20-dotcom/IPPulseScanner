package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.getsurfboard.R;
import defpackage.ky0;
import defpackage.t33;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    public final ArrayAdapter p1;
    public Spinner q1;
    public final ky0 r1;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.dropdownPreferenceStyle);
        this.r1 = new ky0(0, this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item);
        this.p1 = arrayAdapter;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr = this.k1;
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.ListPreference
    public final void B(CharSequence[] charSequenceArr) {
        this.k1 = charSequenceArr;
        ArrayAdapter arrayAdapter = this.p1;
        arrayAdapter.clear();
        CharSequence[] charSequenceArr2 = this.k1;
        if (charSequenceArr2 != null) {
            for (CharSequence charSequence : charSequenceArr2) {
                arrayAdapter.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void i() {
        super.i();
        ArrayAdapter arrayAdapter = this.p1;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public final void m(t33 t33Var) {
        int length;
        Spinner spinner = (Spinner) t33Var.a.findViewById(R.id.spinner);
        this.q1 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.p1);
        this.q1.setOnItemSelectedListener(this.r1);
        Spinner spinner2 = this.q1;
        String str = this.m1;
        CharSequence[] charSequenceArr = this.l1;
        if (str == null || charSequenceArr == null) {
            length = -1;
        } else {
            length = charSequenceArr.length - 1;
            while (length >= 0) {
                if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                    break;
                } else {
                    length--;
                }
            }
            length = -1;
        }
        spinner2.setSelection(length);
        super.m(t33Var);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void n() {
        this.q1.performClick();
    }
}
