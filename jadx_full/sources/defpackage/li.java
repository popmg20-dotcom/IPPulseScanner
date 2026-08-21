package defpackage;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;
import com.getsurfboard.ui.service.SurfboardTile;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class li implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ li(gj gjVar, zf2 zf2Var, r90 r90Var) {
        this.b = 1;
        this.z = gjVar;
        this.f = r90Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [ge0] */
    /* JADX WARN: Type inference failed for: r3v2, types: [char[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) throws Exception {
        String string;
        d83 d83Var;
        int i2 = this.b;
        Object charArray = 0;
        charArray = 0;
        charArray = 0;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i2) {
            case 0:
                r90 r90Var = (r90) obj2;
                cd cdVar = (cd) obj;
                Editable text = ((TextInputEditText) r90Var.b).getText();
                if (text != null && (string = text.toString()) != null) {
                    if (string.length() <= 0) {
                        string = null;
                    }
                    if (string != null) {
                        charArray = string.toCharArray();
                        charArray.getClass();
                    }
                }
                cdVar.k(zf2.j0(r90Var), charArray);
                break;
            case 1:
                ((gj) obj).g(zf2.j0((r90) obj2));
                break;
            case 2:
                t23.z(((ek) obj2).b, false);
                ViewParent parent = ((View) obj).getParent();
                parent.getClass();
                ((View) parent).setVisibility(8);
                break;
            case 3:
                try {
                    ((xh0) obj2).startActivity((Intent) obj);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case 4:
                Bundle bundle = new Bundle();
                bundle.putString("action", "neutral");
                e7.a(bundle, "external_resource_update_failed_dialog");
                co4.k(((CharSequence) obj2).toString());
                cm2 cm2Var = ((ma1) obj).b;
                cm2Var.getClass();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) cm2Var.f;
                coordinatorLayout.getClass();
                r25.R(coordinatorLayout, R.string.message_copied, new Object[0]);
                break;
            case 5:
                iz1 iz1Var = (iz1) obj;
                xb5.c("import profile url dialog import clicked");
                EditText editText = ((TextInputLayout) ((cp1) obj2).f).getEditText();
                if (editText != null) {
                    String string2 = p44.U0(editText.getText().toString()).toString();
                    if (p44.x0(string2)) {
                        p95.C(R.string.invalid_url_format, new Object[0]);
                        break;
                    } else {
                        ProfileAddMethodsFragment profileAddMethodsFragment = (ProfileAddMethodsFragment) iz1Var.getParentFragment();
                        if (profileAddMethodsFragment != null && (d83Var = (d83) profileAddMethodsFragment.getParentFragment()) != null) {
                            d83.l(d83Var, string2);
                            break;
                        }
                    }
                }
                break;
            case 6:
                int i3 = ProfileEditorActivity.Y0;
                ((ru2) obj2).e();
                ((ProfileEditorActivity) obj).b().d();
                break;
            case 7:
                h73 h73Var = (h73) obj;
                xb5.c("naming profile dialog positive clicked");
                EditText editText2 = ((TextInputLayout) ((w7) obj2).f).getEditText();
                if (editText2 != null) {
                    Editable text2 = editText2.getText();
                    text2.getClass();
                    if (!p44.x0(text2)) {
                        h73Var.d(editText2.getText().toString());
                    }
                }
                break;
            case 8:
                Bundle bundle2 = new Bundle();
                bundle2.putString("action", "neutral");
                e7.a(bundle2, "import_profile_failed_dialog");
                co4.k(((CharSequence) obj2).toString());
                y3 y3Var = ((d83) obj).b;
                y3Var.getClass();
                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var.a;
                coordinatorLayout2.getClass();
                r25.R(coordinatorLayout2, R.string.message_copied, new Object[0]);
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                Bundle bundle3 = new Bundle();
                bundle3.putString("action", "positive");
                e7.a(bundle3, "delete_profile_dialog");
                ji0.B(uf2.t((d83) obj2), null, null, new jo1((String) obj, charArray, 2), 3);
                break;
            case 10:
                int i4 = SurfboardTile.X;
                ((SurfboardTile) obj2).a((de0) obj, false);
                Bundle bundle4 = new Bundle();
                bundle4.putString("action", "positive");
                e7.a(bundle4, "tile_no_valid_profiles_dialog");
                break;
            case 11:
                VpnSettingsFragment.onViewCreated$lambda$5$0$0((hu0) obj2, (VpnSettingsFragment) obj, dialogInterface, i);
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((p73) obj2).g(Boolean.valueOf(((MaterialCheckBox) ((ed4) obj).z).isChecked()));
                break;
            case 13:
                ((gj) obj2).g(Boolean.valueOf(((MaterialCheckBox) ((ed4) obj).z).isChecked()));
                break;
            case 14:
                ed4 ed4Var = (ed4) obj2;
                EditText editText3 = ((TextInputLayout) ed4Var.A).getEditText();
                editText3.getClass();
                String string3 = editText3.getText().toString();
                EditText editText4 = ((TextInputLayout) ed4Var.f).getEditText();
                editText4.getClass();
                String string4 = editText4.getText().toString();
                EditText editText5 = ((TextInputLayout) ed4Var.z).getEditText();
                editText5.getClass();
                String string5 = editText5.getText().toString();
                String[] strArr = t23.a;
                string3.getClass();
                string4.getClass();
                string5.getClass();
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putString("webdav_server", string3);
                editorEdit.putString("webdav_account", string4);
                editorEdit.putString("webdav_password", string5);
                editorEdit.commit();
                p95.C(R.string.webdav_config_saved_hint, new Object[0]);
                ((fn) obj).a();
                break;
            default:
                m31 m31Var = (m31) obj;
                EditText editText6 = ((TextInputLayout) ((ed4) obj2).A).getEditText();
                editText6.getClass();
                m31Var.b(n12.c(editText6.getText().toString(), "https://dav.box.com/dav") ? "https://support.box.com/hc/en-us/articles/360043696414-WebDAV-with-Box" : "https://help.jianguoyun.com/?p=2064");
                break;
        }
    }

    public /* synthetic */ li(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public /* synthetic */ li(r90 r90Var, cd cdVar, zf2 zf2Var) {
        this.b = 0;
        this.f = r90Var;
        this.z = cdVar;
    }
}
