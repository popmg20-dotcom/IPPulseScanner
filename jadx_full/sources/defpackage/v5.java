package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import com.getsurfboard.ui.fragment.AddHostFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v5 implements TextWatcher {
    public final /* synthetic */ int b;
    public final /* synthetic */ AddHostFragment f;

    public /* synthetic */ v5(AddHostFragment addHostFragment, int i) {
        this.b = i;
        this.f = addHostFragment;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i = this.b;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
        AddHostFragment addHostFragment = this.f;
        switch (i4) {
            case 0:
                addHostFragment.p();
                break;
            case 1:
                addHostFragment.p();
                break;
            default:
                addHostFragment.p();
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(Editable editable) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void e(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void f(int i, int i2, int i3, CharSequence charSequence) {
    }
}
