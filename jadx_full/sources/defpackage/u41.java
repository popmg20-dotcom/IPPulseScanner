package defpackage;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;
import com.getsurfboard.ui.activity.NATDetectActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u41 implements TextWatcher {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ u41(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        String string;
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                ((x41) obj).a().a();
                break;
            case 1:
                m24 m24Var = (m24) obj;
                if (editable == null || (string = editable.toString()) == null) {
                    string = "";
                }
                m24Var.j(null, string);
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        switch (this.b) {
            case 0:
                ((x41) this.f).a().b();
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
        Object obj = this.f;
        switch (i4) {
            case 0:
            case 1:
                break;
            case 2:
                NATDetectActivity nATDetectActivity = (NATDetectActivity) obj;
                int i5 = NATDetectActivity.V0;
                ji0.B(uf2.t(nATDetectActivity), null, null, new eo2(nATDetectActivity, null, 1), 3);
                break;
            default:
                SearchView searchView = (SearchView) obj;
                Editable text = searchView.J0.getText();
                searchView.s1 = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.w(!zIsEmpty);
                int i6 = 8;
                if (searchView.q1 && !searchView.j1 && zIsEmpty) {
                    searchView.O0.setVisibility(8);
                    i6 = 0;
                }
                searchView.Q0.setVisibility(i6);
                searchView.s();
                searchView.v();
                if (searchView.e1 != null && !TextUtils.equals(charSequence, searchView.r1)) {
                    searchView.e1.e(charSequence.toString());
                }
                searchView.r1 = charSequence.toString();
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void e(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void f(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void g(int i, int i2, int i3, CharSequence charSequence) {
    }
}
