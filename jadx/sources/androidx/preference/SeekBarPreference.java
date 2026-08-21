package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.widget.SeekBar;
import android.widget.TextView;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.or3;
import defpackage.pr3;
import defpackage.qr3;
import defpackage.t33;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    public int e1;
    public int f1;
    public int g1;
    public int h1;
    public boolean i1;
    public SeekBar j1;
    public TextView k1;
    public final boolean l1;
    public final boolean m1;
    public final boolean n1;
    public final or3 o1;
    public final pr3 p1;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        this.o1 = new or3(this);
        this.p1 = new pr3(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.k, R.attr.seekBarPreferenceStyle, 0);
        this.f1 = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i = typedArrayObtainStyledAttributes.getInt(1, 100);
        int i2 = this.f1;
        i = i < i2 ? i2 : i;
        if (i != this.g1) {
            this.g1 = i;
            i();
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i3 != this.h1) {
            this.h1 = Math.min(this.g1 - this.f1, Math.abs(i3));
            i();
        }
        this.l1 = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.m1 = typedArrayObtainStyledAttributes.getBoolean(5, false);
        this.n1 = typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(int i, boolean z) {
        int i2 = this.f1;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.g1;
        if (i > i3) {
            i = i3;
        }
        if (i != this.e1) {
            this.e1 = i;
            TextView textView = this.k1;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
            if (z()) {
                int i4 = ~i;
                boolean z2 = z();
                String str = this.C0;
                if (z2) {
                    i4 = this.f.c().getInt(str, i4);
                }
                if (i != i4) {
                    SharedPreferences.Editor editorA = this.f.a();
                    editorA.putInt(str, i);
                    if (!this.f.e) {
                        editorA.apply();
                    }
                }
            }
            if (z) {
                i();
            }
        }
    }

    public final void B(SeekBar seekBar) {
        int progress = seekBar.getProgress() + this.f1;
        if (progress != this.e1) {
            if (a(Integer.valueOf(progress))) {
                A(progress, false);
                return;
            }
            seekBar.setProgress(this.e1 - this.f1);
            int i = this.e1;
            TextView textView = this.k1;
            if (textView != null) {
                textView.setText(String.valueOf(i));
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void m(t33 t33Var) {
        super.m(t33Var);
        t33Var.a.setOnKeyListener(this.p1);
        this.j1 = (SeekBar) t33Var.s(R.id.seekbar);
        TextView textView = (TextView) t33Var.s(R.id.seekbar_value);
        this.k1 = textView;
        if (this.m1) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.k1 = null;
        }
        SeekBar seekBar = this.j1;
        if (seekBar == null) {
            a1.d("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.o1);
        this.j1.setMax(this.g1 - this.f1);
        int i = this.h1;
        SeekBar seekBar2 = this.j1;
        if (i != 0) {
            seekBar2.setKeyProgressIncrement(i);
        } else {
            this.h1 = seekBar2.getKeyProgressIncrement();
        }
        this.j1.setProgress(this.e1 - this.f1);
        int i2 = this.e1;
        TextView textView2 = this.k1;
        if (textView2 != null) {
            textView2.setText(String.valueOf(i2));
        }
        this.j1.setEnabled(h());
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(qr3.class)) {
            super.q(parcelable);
            return;
        }
        qr3 qr3Var = (qr3) parcelable;
        super.q(qr3Var.getSuperState());
        this.e1 = qr3Var.b;
        this.f1 = qr3Var.f;
        this.g1 = qr3Var.z;
        i();
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        super.r();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.I0) {
            return absSavedState;
        }
        qr3 qr3Var = new qr3();
        qr3Var.b = this.e1;
        qr3Var.f = this.f1;
        qr3Var.z = this.g1;
        return qr3Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (z()) {
            iIntValue = this.f.c().getInt(this.C0, iIntValue);
        }
        A(iIntValue, true);
    }
}
