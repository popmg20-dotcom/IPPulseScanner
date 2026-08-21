package defpackage;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.viewpager2.widget.ViewPager2;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.DeveloperOptionsActivity;
import com.getsurfboard.ui.activity.ExternalResourcesManagerActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.getsurfboard.ui.activity.SettingsActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.getsurfboard.ui.fragment.card.OutboundModeFragment;
import com.getsurfboard.ui.fragment.card.PublicIPFragment;
import com.getsurfboard.ui.fragment.card.SSHDumpFragment;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a2;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mk implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ mk(int i, rb2 rb2Var, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ya3 ya3Var;
        int i = this.b;
        ge0 ge0Var = null;
        int i2 = 0;
        Object obj = this.f;
        switch (i) {
            case 0:
                nk.k((nk) obj, view);
                return;
            case 1:
                ((MaterialCheckBox) ((ys) obj).u.b).toggle();
                return;
            case 2:
                v50 v50Var = (v50) obj;
                EditText editText = v50Var.i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                v50Var.p();
                return;
            case 3:
                Context context = view.getContext();
                context.getClass();
                vo.F(context, ((yo4) obj).c);
                return;
            case 4:
                int i3 = DeveloperOptionsActivity.S0;
                ((DeveloperOptionsActivity) obj).b().d();
                return;
            case 5:
                ((uy0) obj).t();
                return;
            case 6:
                ((v71) obj).requireActivity().b().d();
                return;
            case 7:
                ((a81) obj).requireActivity().b().d();
                return;
            case 8:
                view.getClass();
                ca1.t(view, (aa1) obj);
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                Context context2 = view.getContext();
                context2.getClass();
                fi4 fi4Var = ((ma1) obj).A;
                if (fi4Var == null) {
                    n12.T("type");
                    throw null;
                }
                int iOrdinal = fi4Var.ordinal();
                if (iOrdinal == 0) {
                    vo.F(context2, "https://getsurfboard.com/docs/profile-format/proxygroup/auto#policy-path-sample");
                    return;
                }
                if (iOrdinal == 1) {
                    vo.F(context2, "https://getsurfboard.com/docs/profile-format/rule/ruleset");
                    return;
                } else if (iOrdinal == 2) {
                    vo.F(context2, "https://getsurfboard.com/docs/profile-format/rule/domainset");
                    return;
                } else {
                    g.d();
                    return;
                }
            case 10:
                int i4 = ExternalResourcesManagerActivity.T0;
                ((ExternalResourcesManagerActivity) obj).b().d();
                return;
            case 11:
                Dialog dialog = ((qo1) obj).C0;
                if (dialog != null) {
                    dialog.dismiss();
                    return;
                }
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                int i5 = HostsListActivity.a1;
                os1 os1VarS = oj0.a.s();
                ke0.r(os1VarS.a, false, true, new ms1(os1VarS, (ls1) obj, i2));
                return;
            case 13:
                MemoryUsageFragment memoryUsageFragment = (MemoryUsageFragment) obj;
                ji0.B(uf2.t(memoryUsageFragment), null, null, new hj(memoryUsageFragment, view, ge0Var, 23), 3);
                return;
            case 14:
                ha1 ha1Var = ((OutboundModeFragment) obj).f;
                ha1Var.getClass();
                ((RadioGroup) ha1Var.f).requestFocus();
                return;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                t03 t03Var = (t03) obj;
                EditText editText2 = t03Var.f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = t03Var.f;
                if (editText3 != null && (editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    i2 = 1;
                }
                EditText editText4 = t03Var.f;
                if (i2 != 0) {
                    editText4.setTransformationMethod(null);
                } else {
                    editText4.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    t03Var.f.setSelection(selectionEnd);
                }
                t03Var.p();
                return;
            case 16:
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj;
                if (profileEditorActivity.V0) {
                    profileEditorActivity.x();
                    return;
                } else {
                    profileEditorActivity.b().d();
                    return;
                }
            case 17:
                xb5.c("profile item root clicked");
                ((RadioButton) ((dk1) obj).i).setChecked(true);
                return;
            case 18:
                wn1 wn1Var = (wn1) ((bx0) obj).f;
                if (wn1Var != null) {
                    y3 y3Var = ((d83) wn1Var.f).b;
                    y3Var.getClass();
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                    coordinatorLayout.getClass();
                    r25.R(coordinatorLayout, R.string.invalid_profile_can_not_be_selected, new Object[0]);
                    return;
                }
                return;
            case 19:
                Context context3 = view.getContext();
                context3.getClass();
                bx0.v(context3, (h03) obj);
                return;
            case 20:
                cb3 cb3Var = (cb3) obj;
                xb5.c("proxygroups test clicked");
                uf4 uf4Var = cb3Var.b;
                uf4Var.getClass();
                ViewPager2 viewPager2 = (ViewPager2) uf4Var.a;
                u childFragmentManager = cb3Var.getChildFragmentManager();
                childFragmentManager.getClass();
                int currentItem = viewPager2.getCurrentItem();
                rf3 adapter = viewPager2.getAdapter();
                if (adapter == null || adapter.b() == 0) {
                    ya3Var = null;
                } else {
                    long jC = adapter.c(currentItem);
                    if (jC == -1) {
                        jC = currentItem;
                    }
                    o oVarD = childFragmentManager.D("f" + jC);
                    if (!(oVarD instanceof ya3)) {
                        oVarD = null;
                    }
                    ya3Var = (ya3) oVarD;
                }
                if (ya3Var != null) {
                    na3 na3Var = ya3Var.y0;
                    if (na3Var == null) {
                        n12.T("proxyGroup");
                        throw null;
                    }
                    if (!(na3Var instanceof ka3)) {
                        uf4 uf4Var2 = cb3Var.b;
                        uf4Var2.getClass();
                        CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) uf4Var2.b;
                        coordinatorLayout2.getClass();
                        r25.R(coordinatorLayout2, R.string.current_group_not_support_manually_test, new Object[0]);
                        return;
                    }
                    Context contextRequireContext = ya3Var.requireContext();
                    contextRequireContext.getClass();
                    String str = ya3Var.z0;
                    String str2 = ya3Var.Z;
                    if (str2 == null) {
                        n12.T("profileName");
                        throw null;
                    }
                    na3 na3Var2 = ya3Var.y0;
                    if (na3Var2 == null) {
                        n12.T("proxyGroup");
                        throw null;
                    }
                    String name = na3Var2.getName();
                    Map map = zw1.a;
                    str.getClass();
                    name.getClass();
                    Intent intentPutExtra = new Intent(contextRequireContext, (Class<?>) SurfboardVpn.class).putExtra("profile_name", str2).putExtra("start_speedometer", true).putExtra("group_name", name).putExtra("session_id", str);
                    intentPutExtra.getClass();
                    if (yw1.G0) {
                        v9.z(contextRequireContext, intentPutExtra);
                        return;
                    } else {
                        contextRequireContext.startService(intentPutExtra);
                        return;
                    }
                }
                return;
            case 21:
                PublicIPFragment publicIPFragment = (PublicIPFragment) obj;
                iv1 iv1Var = publicIPFragment.f;
                iv1Var.getClass();
                MaterialTextView materialTextView = (MaterialTextView) iv1Var.X;
                publicIPFragment.f.getClass();
                materialTextView.setActivated(!((MaterialTextView) r0.X).isActivated());
                iv1 iv1Var2 = publicIPFragment.f;
                iv1Var2.getClass();
                boolean zIsActivated = ((MaterialTextView) iv1Var2.X).isActivated();
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putBoolean("public_ip_visible", zIsActivated);
                editorEdit.apply();
                publicIPFragment.k(false);
                iv1 iv1Var3 = publicIPFragment.f;
                iv1Var3.getClass();
                Drawable drawable = ((MaterialTextView) iv1Var3.X).getCompoundDrawablesRelative()[0];
                if (drawable instanceof o8) {
                    ((o8) drawable).start();
                } else {
                    if (!(drawable instanceof AnimatedVectorDrawable)) {
                        ad0.o(drawable, "unknown drawable type: ");
                        return;
                    }
                    ((AnimatedVectorDrawable) drawable).start();
                }
                publicIPFragment.j();
                return;
            case 22:
                QRCodeScannerActivity qRCodeScannerActivity = (QRCodeScannerActivity) obj;
                int i6 = QRCodeScannerActivity.Y0;
                try {
                    w4 w4Var = qRCodeScannerActivity.X0;
                    if (w4Var == null) {
                        n12.T("pickFromGalleryLauncher");
                        throw null;
                    }
                    p4 p4Var = p4.a;
                    o4 o4Var = o4.a;
                    k2.c();
                    t60 t60Var = t60.z;
                    e13 e13Var = new e13();
                    e13Var.a = o4Var;
                    k2.c();
                    e13Var.a = p4Var;
                    e13Var.b = t60Var;
                    w4Var.a(e13Var);
                    return;
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    p95.C(R.string.unknown_error, new Object[0]);
                    return;
                }
            case 23:
                Context context4 = view.getContext();
                context4.getClass();
                fx3.I(context4, ((SSHDumpFragment) obj).getString(R.string.setting_sshdump_key), true);
                return;
            case 24:
                int i7 = SettingsActivity.S0;
                ((SettingsActivity) obj).b().d();
                return;
            case 25:
                int i8 = TrafficListActivity.V0;
                ((TrafficListActivity) obj).b().d();
                return;
            default:
                ((a2) obj).cancel();
                return;
        }
    }

    public /* synthetic */ mk(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
