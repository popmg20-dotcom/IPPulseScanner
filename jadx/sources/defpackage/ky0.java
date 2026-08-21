package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import androidx.preference.DropDownPreference;
import com.getsurfboard.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ky0 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ ky0(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        jy0 jy0Var;
        List listU;
        switch (this.b) {
            case 0:
                DropDownPreference dropDownPreference = (DropDownPreference) this.f;
                if (i >= 0) {
                    String string = dropDownPreference.l1[i].toString();
                    if (string.equals(dropDownPreference.m1) || !dropDownPreference.a(string)) {
                        return;
                    }
                    dropDownPreference.setValue(string);
                    return;
                }
                return;
            case 1:
                if (i == -1 || (jy0Var = ((hc2) this.f).z) == null) {
                    return;
                }
                jy0Var.setListSelectionHidden(false);
                return;
            case 2:
                String str = ((se2) this.f).getResources().getStringArray(R.array.logcat_viewer_logcat_spinner)[i];
                oe2 oe2Var = ((se2) this.f).z;
                str.getClass();
                String strSubstring = str.substring(0, 1);
                synchronized (oe2Var.f) {
                    oe2Var.g = strSubstring;
                    listU = oe2Var.u();
                }
                oe2Var.r(listU);
                return;
            default:
                ((SearchView) this.f).o(i);
                return;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.b;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    private final void c(AdapterView adapterView) {
    }

    private final void d(AdapterView adapterView) {
    }
}
