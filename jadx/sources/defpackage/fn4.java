package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.widget.NestedScrollWebView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fn4 extends qo {
    public ed4 H0;
    public String I0;

    @Override // androidx.fragment.app.i
    public final void m(u uVar, String str) {
        if (ContextUtilsKt.h().hasSystemFeature("android.software.webview")) {
            super.m(uVar, null);
        } else {
            p95.C(R.string.webview_core_not_exist_on_this_device, new Object[0]);
        }
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(RtspHeaders.Values.URL)) == null) {
            xe.k("can not find url");
        } else {
            this.I0 = string;
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        try {
            ed4 ed4VarG = ed4.G(layoutInflater, viewGroup);
            this.H0 = ed4VarG;
            return (RelativeLayout) ed4VarG.f;
        } catch (Exception e) {
            e.printStackTrace();
            Dialog dialog = this.C0;
            if (dialog instanceof po) {
                po poVar = (po) dialog;
                if (poVar.Z == null) {
                    poVar.f();
                }
                boolean z = poVar.Z.a1;
            }
            j(false, false);
            p95.C(R.string.webview_core_not_exist_on_this_device, new Object[0]);
            return null;
        }
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        ed4 ed4Var = this.H0;
        if (ed4Var != null) {
            ((NestedScrollWebView) ed4Var.A).destroy();
            this.H0 = null;
        }
    }

    @Override // androidx.fragment.app.o
    public final void onPause() {
        super.onPause();
        ed4 ed4Var = this.H0;
        if (ed4Var != null) {
            ((NestedScrollWebView) ed4Var.A).onPause();
        }
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        ed4 ed4Var = this.H0;
        if (ed4Var != null) {
            ((NestedScrollWebView) ed4Var.A).onResume();
        }
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        ed4 ed4Var = this.H0;
        ed4Var.getClass();
        ((NestedScrollWebView) ed4Var.A).saveState(bundle);
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Object parent = view.getParent();
            parent.getClass();
            BottomSheetBehavior bottomSheetBehaviorD = BottomSheetBehavior.D((View) parent);
            if ((bottomSheetBehaviorD.Z ? -1 : bottomSheetBehaviorD.Y) == -1 && ContextUtilsKt.getContext().getResources().getConfiguration().orientation == 2) {
                bottomSheetBehaviorD.M(getResources().getDimensionPixelOffset(R.dimen.bottom_sheet_landscape_peek_height));
            }
        }
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        ed4 ed4Var = this.H0;
        ed4Var.getClass();
        ((NestedScrollWebView) ed4Var.A).getSettings().setJavaScriptEnabled(true);
        ed4 ed4Var2 = this.H0;
        ed4Var2.getClass();
        ((NestedScrollWebView) ed4Var2.A).getSettings().setDomStorageEnabled(true);
        ed4 ed4Var3 = this.H0;
        ed4Var3.getClass();
        ((NestedScrollWebView) ed4Var3.A).setWebViewClient(new en4(this));
        ed4 ed4Var4 = this.H0;
        if (bundle != null) {
            ed4Var4.getClass();
            ((NestedScrollWebView) ed4Var4.A).restoreState(bundle);
            return;
        }
        ed4Var4.getClass();
        NestedScrollWebView nestedScrollWebView = (NestedScrollWebView) ed4Var4.A;
        String str = this.I0;
        if (str != null) {
            nestedScrollWebView.loadUrl(str);
        } else {
            n12.T(RtspHeaders.Values.URL);
            throw null;
        }
    }
}
