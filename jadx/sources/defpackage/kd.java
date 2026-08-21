package defpackage;

import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kd implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ kd(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Editable text;
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                AppThemeConfigActivity appThemeConfigActivity = (AppThemeConfigActivity) obj;
                int i2 = AppThemeConfigActivity.T0;
                cd4 cd4Var = (cd4) ((Map.Entry) obj2).getKey();
                String[] strArr = t23.a;
                cd4Var.getClass();
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putString("color_palette_theme_key", cd4Var.name());
                editorEdit.apply();
                ji0.B(uf2.t(appThemeConfigActivity), null, null, new od(2, null, 0), 3);
                e4.A(appThemeConfigActivity);
                return;
            case 1:
                y10 y10Var = ((u10) obj2).g;
                l5 l5Var = ((pk2) obj).w;
                if (l5Var != null) {
                    y10Var.g(l5Var.a);
                    return;
                } else {
                    n12.T("model");
                    throw null;
                }
            case 2:
                y10 y10Var2 = ((u10) obj2).h;
                m5 m5Var = ((tk2) obj).z;
                if (m5Var != null) {
                    y10Var2.g(m5Var.a);
                    return;
                } else {
                    n12.T("model");
                    throw null;
                }
            case 3:
                iv1 iv1Var = (iv1) obj2;
                po1 po1Var = (po1) obj;
                EditText editText = ((TextInputLayout) iv1Var.f).getEditText();
                ji0.B(uf2.t(po1Var), null, null, new hd(po1Var.J0, (editText == null || (text = editText.getText()) == null) ? null : text.toString(), po1Var, iv1Var, null, 9), 3);
                return;
            case 4:
                view.getClass();
                ((bt1) obj2).f.k(view, (ls1) obj);
                return;
            case 5:
                zk zkVar = (zk) obj;
                wn1 wn1Var = (wn1) ((bx0) obj2).f;
                if (wn1Var != null) {
                    String name = zkVar.getName();
                    xf2 xf2VarJ = zkVar.j();
                    xf2VarJ.getClass();
                    wn1Var.C(name, xf2VarJ);
                    return;
                }
                return;
            case 6:
                int i3 = QRCodeScannerActivity.Y0;
                ((wx) obj2).d().X(!((QRCodeScannerActivity) obj).W0);
                return;
            default:
                ((View.OnClickListener) obj).onClick(view);
                ((oy3) obj2).a(1);
                return;
        }
    }
}
