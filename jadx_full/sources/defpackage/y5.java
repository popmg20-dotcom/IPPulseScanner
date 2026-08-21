package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y5 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ y5(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        Object obj = this.f;
        switch (i2) {
            case 0:
                z5.n((z5) obj, i);
                return;
            case 1:
                ((cj) obj).a();
                return;
            case 2:
                Context contextRequireContext = ((qp1) obj).requireContext();
                contextRequireContext.getClass();
                vo.F(contextRequireContext, "https://support.google.com/websearch/workflow/9308722");
                return;
            case 3:
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj;
                cm2 cm2Var = profileEditorActivity.S0;
                if (cm2Var != null) {
                    profileEditorActivity.A(((CodeEditor) cm2Var.z).getText().toString(), true);
                    return;
                } else {
                    n12.T("binding");
                    throw null;
                }
            case 4:
                Bundle bundle = new Bundle();
                bundle.putString("action", "continue_import");
                e7.a(bundle, "import_profile_failed_dialog");
                ((pl1) obj).a();
                return;
            case 5:
                Bundle bundle2 = new Bundle();
                bundle2.putString("action", "neutral");
                e7.a(bundle2, "local_managed_config_warning_dialog");
                Context contextRequireContext2 = ((d83) obj).requireContext();
                contextRequireContext2.getClass();
                vo.F(contextRequireContext2, "https://getsurfboard.com/docs/faq#why-app-prompt-the-imported-profile-contains-an-invalid-update-url-when-adding-a-new-profile");
                return;
            default:
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.remove("webdav_server");
                editorEdit.remove("webdav_account");
                editorEdit.remove("webdav_password");
                editorEdit.commit();
                ((fn) obj).a();
                return;
        }
    }
}
