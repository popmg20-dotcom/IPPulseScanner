package defpackage;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.i;
import androidx.fragment.app.o;
import androidx.preference.DialogPreference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class e33 extends i implements DialogInterface.OnClickListener {
    public DialogPreference H0;
    public CharSequence I0;
    public CharSequence J0;
    public CharSequence K0;
    public CharSequence L0;
    public int M0;
    public BitmapDrawable N0;
    public int O0;

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        this.O0 = -2;
        t6 t6Var = new t6(requireContext());
        CharSequence charSequence = this.I0;
        p6 p6Var = (p6) t6Var.z;
        p6Var.e = charSequence;
        p6Var.d = this.N0;
        t6Var.q(this.J0, this);
        p6Var.j = this.K0;
        p6Var.k = this;
        requireContext();
        int i = this.M0;
        View viewInflate = i != 0 ? getLayoutInflater().inflate(i, (ViewGroup) null) : null;
        if (viewInflate != null) {
            o(viewInflate);
            p6Var.v = viewInflate;
            p6Var.u = 0;
        } else {
            p6Var.g = this.L0;
        }
        q(t6Var);
        u6 u6VarH = t6Var.h();
        if (this instanceof n01) {
            Window window = u6VarH.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                d33.a(window);
                return u6VarH;
            }
            n01 n01Var = (n01) this;
            n01Var.S0 = SystemClock.currentThreadTimeMillis();
            n01Var.r();
        }
        return u6VarH;
    }

    public final DialogPreference n() {
        DialogPreference dialogPreference = this.H0;
        if (dialogPreference != null) {
            return dialogPreference;
        }
        DialogPreference dialogPreference2 = (DialogPreference) ((j33) getTargetFragment()).findPreference(requireArguments().getString("key"));
        this.H0 = dialogPreference2;
        return dialogPreference2;
    }

    public void o(View view) {
        int i;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.L0;
            if (TextUtils.isEmpty(charSequence)) {
                i = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.O0 = i;
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o targetFragment = getTargetFragment();
        if (!(targetFragment instanceof j33)) {
            xe.q("Target fragment must implement TargetFragment interface");
            return;
        }
        j33 j33Var = (j33) targetFragment;
        String string = requireArguments().getString("key");
        if (bundle != null) {
            this.I0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.J0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.K0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.L0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.M0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.N0 = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) j33Var.findPreference(string);
        this.H0 = dialogPreference;
        this.I0 = dialogPreference.e1;
        this.J0 = dialogPreference.h1;
        this.K0 = dialogPreference.i1;
        this.L0 = dialogPreference.f1;
        this.M0 = dialogPreference.j1;
        Drawable drawable = dialogPreference.g1;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            this.N0 = (BitmapDrawable) drawable;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.N0 = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.i, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        p(this.O0 == -1);
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.I0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.J0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.K0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.L0);
        bundle.putInt("PreferenceDialogFragment.layout", this.M0);
        BitmapDrawable bitmapDrawable = this.N0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public abstract void p(boolean z);

    public void q(t6 t6Var) {
    }
}
