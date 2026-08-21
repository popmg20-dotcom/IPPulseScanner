package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.getsurfboard.ui.fragment.ToolsFragment;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kt implements pl1 {
    public final /* synthetic */ int b;
    public final Object f;
    public final /* synthetic */ Object z;

    public kt(fu1 fu1Var, iu1 iu1Var) {
        this.b = 3;
        this.z = fu1Var;
        this.f = iu1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r10v59 */
    @Override // defpackage.pl1
    public final Object a() throws Throwable {
        int i = this.b;
        IOException iOException = null;
        xl4 xl4Var = xl4.a;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                e03 e03Var = (e03) obj2;
                boolean zBooleanValue = ((Boolean) e03Var.b).booleanValue();
                HashSet hashSet = (HashSet) e03Var.f;
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) obj;
                y3 y3Var = bypassConfigActivity.S0;
                if (zBooleanValue) {
                    if (y3Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    MenuItem menuItemFindItem = ((Toolbar) y3Var.c).getMenu().findItem(R.id.white_list_mode);
                    if (menuItemFindItem != null) {
                        menuItemFindItem.setChecked(true);
                    }
                } else {
                    if (y3Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    MenuItem menuItemFindItem2 = ((Toolbar) y3Var.c).getMenu().findItem(R.id.black_list_mode);
                    if (menuItemFindItem2 != null) {
                        menuItemFindItem2.setChecked(true);
                    }
                }
                t23.D(zBooleanValue);
                t23.w(t23.H(), hashSet);
                f33 f33Var = new f33(3, bypassConfigActivity);
                int i2 = BypassConfigActivity.Y0;
                bypassConfigActivity.C(f33Var);
                return xl4Var;
            case 1:
                xh0 xh0Var = (xh0) obj;
                if (n12.c(ws4.a.d(), Boolean.TRUE)) {
                    zw1.d((Context) obj2);
                } else {
                    try {
                        r4 r4Var = xh0Var.f;
                        if (r4Var == null) {
                            n12.T("vpnPermissionLauncher");
                            throw null;
                        }
                        r4Var.a(xl4Var);
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        j80 j80Var = xh0Var.b;
                        j80Var.getClass();
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var.a;
                        coordinatorLayout.getClass();
                        r25.R(coordinatorLayout, R.string.vpn_module_missing, new Object[0]);
                    }
                }
                return xl4Var;
            case 2:
                ((fa1) obj2).g((ArrayList) obj);
                return xl4Var;
            case 3:
                fu1 fu1Var = (fu1) obj;
                iu1 iu1Var = (iu1) obj2;
                t51 t51Var = t51.INTERNAL_ERROR;
                try {
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e2) {
                        iOException = e2;
                    }
                    if (!iu1Var.g(true, this)) {
                        throw new IOException("Required SETTINGS preface not received");
                    }
                    do {
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } while (iu1Var.g(false, this));
                    t51 t51Var2 = t51.NO_ERROR;
                    try {
                        t51Var = t51.CANCEL;
                        fu1Var.g(t51Var2, t51Var, null);
                        this = t51Var2;
                    } catch (IOException e3) {
                        iOException = e3;
                        t51 t51Var3 = t51.PROTOCOL_ERROR;
                        fu1Var.g(t51Var3, t51Var3, iOException);
                        this = t51Var3;
                    }
                    hz4.b(iu1Var);
                    return xl4Var;
                    this = t51Var;
                } catch (Throwable th3) {
                    th = th3;
                }
                fu1Var.g(this, t51Var, iOException);
                hz4.b(iu1Var);
                throw th;
            case 4:
                tf2 tf2Var = (tf2) obj2;
                tf2Var.l(R.id.navigation_profiles);
                d83 d83Var = tf2Var.A;
                if (d83Var != null) {
                    String string = ((Uri) obj).toString();
                    string.getClass();
                    d83.l(d83Var, string);
                }
                return xl4Var;
            case 5:
                tf2 tf2Var2 = (tf2) obj2;
                tf2Var2.l(R.id.navigation_profiles);
                d83 d83Var2 = tf2Var2.A;
                if (d83Var2 != null) {
                    d83.l(d83Var2, (String) obj);
                }
                return xl4Var;
            case 6:
                d83 d83Var3 = (d83) ((ProfileAddMethodsFragment) obj2).getParentFragment();
                if (d83Var3 != null) {
                    d83.l(d83Var3, (String) obj);
                }
                return xl4Var;
            case 7:
                List list = (List) obj;
                d83 d83Var4 = (d83) ((ProfileAddMethodsFragment) obj2).getParentFragment();
                if (d83Var4 != null) {
                    d83Var4.k(list);
                }
                return xl4Var;
            case 8:
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj2;
                if (profileEditorActivity.T0 != null) {
                    cm2 cm2Var = profileEditorActivity.S0;
                    if (cm2Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((CodeEditor) cm2Var.z).setText((CharSequence) obj);
                    cm2 cm2Var2 = profileEditorActivity.S0;
                    if (cm2Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((CodeEditor) cm2Var2.z).n0(nd0.class, new j63(profileEditorActivity));
                }
                cm2 cm2Var3 = profileEditorActivity.S0;
                if (cm2Var3 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((LinearProgressIndicator) cm2Var3.A).b();
                profileEditorActivity.z();
                return xl4Var;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                Throwable th4 = (Throwable) obj2;
                th4.printStackTrace();
                ProfileEditorActivity profileEditorActivity2 = (ProfileEditorActivity) obj;
                cm2 cm2Var4 = profileEditorActivity2.S0;
                if (cm2Var4 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((LinearProgressIndicator) cm2Var4.A).b();
                InputMethodManager inputMethodManagerM = ContextUtilsKt.m();
                cm2 cm2Var5 = profileEditorActivity2.S0;
                if (cm2Var5 == null) {
                    n12.T("binding");
                    throw null;
                }
                inputMethodManagerM.hideSoftInputFromWindow(((CodeEditor) cm2Var5.z).getWindowToken(), 0);
                String message = th4.getMessage();
                if (message == null) {
                    message = profileEditorActivity2.getString(R.string.unknown_error);
                    message.getClass();
                }
                profileEditorActivity2.B(message);
                return xl4Var;
            case 10:
                wh2 wh2Var = new wh2((ProfileEditorActivity) obj2);
                wh2Var.x(R.string.unknown_error);
                String str = (String) obj;
                ((p6) wh2Var.z).g = str;
                wh2Var.w(R.string.i_got_it, null);
                wh2Var.v(R.string.copy_message, new uh0(2, str));
                wh2Var.r();
                return xl4Var;
            case 11:
                zf2 zf2Var = ((zb3) obj2).H0;
                zf2Var.getClass();
                ((ImageView) zf2Var.f).setImageBitmap((Bitmap) obj);
                return xl4Var;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                b84 b84Var = (b84) obj2;
                b84Var.j(false, false);
                String message2 = ((Exception) obj).getMessage();
                if (message2 == null) {
                    message2 = b84Var.getString(R.string.unknown_error);
                    message2.getClass();
                }
                p95.D(message2);
                return xl4Var;
            default:
                ToolsFragment toolsFragment = (ToolsFragment) obj2;
                toolsFragment.startActivity(Intent.createChooser((Intent) obj, toolsFragment.getString(R.string.send_log)));
                return xl4Var;
        }
    }

    public /* synthetic */ kt(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }
}
