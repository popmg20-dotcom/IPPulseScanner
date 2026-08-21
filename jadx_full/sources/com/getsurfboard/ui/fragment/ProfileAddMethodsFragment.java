package com.getsurfboard.ui.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import defpackage.iv1;
import defpackage.je;
import defpackage.l4;
import defpackage.n4;
import defpackage.r4;
import defpackage.vf2;
import defpackage.zo2;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileAddMethodsFragment extends o {
    public r4 A;
    public iv1 b;
    public r4 f;
    public r4 z;

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final int i = 1;
        final int i2 = 0;
        r4 r4VarRegisterForActivityResult = registerForActivityResult(new n4(i), new l4(this) { // from class: u53
            public final /* synthetic */ ProfileAddMethodsFragment f;

            {
                this.f = this;
            }

            @Override // defpackage.l4
            public final void h(Object obj) {
                int i3 = i2;
                ge0 ge0Var = null;
                int i4 = 0;
                ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                switch (i3) {
                    case 0:
                        List list = (List) obj;
                        list.getClass();
                        if (list.isEmpty()) {
                            return;
                        }
                        ji0.B(uf2.t(profileAddMethodsFragment), null, null, new w53(profileAddMethodsFragment, list, ge0Var, i4), 3);
                        return;
                    case 1:
                        if (((Boolean) obj).booleanValue()) {
                            r4 r4Var = profileAddMethodsFragment.A;
                            if (r4Var != null) {
                                r4Var.a(new tp3(R.string.import_from_qrcode, R.drawable.ic_round_qr_code_24));
                                return;
                            } else {
                                n12.T("scanQRCodeLauncher");
                                throw null;
                            }
                        }
                        d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var != null) {
                            y3 y3Var = d83Var.b;
                            y3Var.getClass();
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                            coordinatorLayout.getClass();
                            r25.R(coordinatorLayout, R.string.get_camera_permission_failed, new Object[0]);
                            return;
                        }
                        return;
                    default:
                        yp3 yp3Var = (yp3) obj;
                        if (!(yp3Var instanceof wp3)) {
                            if (!(yp3Var instanceof vp3)) {
                                if (yp3Var instanceof xp3) {
                                    return;
                                }
                                g.d();
                                return;
                            }
                            d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var2 != null) {
                                y3 y3Var2 = d83Var2.b;
                                y3Var2.getClass();
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                coordinatorLayout2.getClass();
                                r25.R(coordinatorLayout2, R.string.unknown_error, new Object[0]);
                                return;
                            }
                            return;
                        }
                        String str = ((wp3) yp3Var).a;
                        String strConcat = "barcode scan result: ".concat(str);
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ProfileAddMethodsFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("ProfileAddMethodsFragment", strConcat, null);
                        }
                        if (s63.f(str) || s63.g(str)) {
                            ji0.B(uf2.t(profileAddMethodsFragment), null, null, new hj(profileAddMethodsFragment, str, null, 29), 3);
                            return;
                        }
                        d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var3 != null) {
                            y3 y3Var3 = d83Var3.b;
                            y3Var3.getClass();
                            CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) y3Var3.a;
                            coordinatorLayout3.getClass();
                            String string = ContextUtilsKt.getContext().getString(R.string.invalid_url_format, Arrays.copyOf(new Object[0], 0));
                            string.getClass();
                            oy3.h(coordinatorLayout3, string, 0).j();
                            return;
                        }
                        return;
                }
            }
        });
        r4VarRegisterForActivityResult.getClass();
        this.f = r4VarRegisterForActivityResult;
        r4 r4VarRegisterForActivityResult2 = registerForActivityResult(new n4(5), new l4(this) { // from class: u53
            public final /* synthetic */ ProfileAddMethodsFragment f;

            {
                this.f = this;
            }

            @Override // defpackage.l4
            public final void h(Object obj) {
                int i3 = i;
                ge0 ge0Var = null;
                int i4 = 0;
                ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                switch (i3) {
                    case 0:
                        List list = (List) obj;
                        list.getClass();
                        if (list.isEmpty()) {
                            return;
                        }
                        ji0.B(uf2.t(profileAddMethodsFragment), null, null, new w53(profileAddMethodsFragment, list, ge0Var, i4), 3);
                        return;
                    case 1:
                        if (((Boolean) obj).booleanValue()) {
                            r4 r4Var = profileAddMethodsFragment.A;
                            if (r4Var != null) {
                                r4Var.a(new tp3(R.string.import_from_qrcode, R.drawable.ic_round_qr_code_24));
                                return;
                            } else {
                                n12.T("scanQRCodeLauncher");
                                throw null;
                            }
                        }
                        d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var != null) {
                            y3 y3Var = d83Var.b;
                            y3Var.getClass();
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                            coordinatorLayout.getClass();
                            r25.R(coordinatorLayout, R.string.get_camera_permission_failed, new Object[0]);
                            return;
                        }
                        return;
                    default:
                        yp3 yp3Var = (yp3) obj;
                        if (!(yp3Var instanceof wp3)) {
                            if (!(yp3Var instanceof vp3)) {
                                if (yp3Var instanceof xp3) {
                                    return;
                                }
                                g.d();
                                return;
                            }
                            d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var2 != null) {
                                y3 y3Var2 = d83Var2.b;
                                y3Var2.getClass();
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                coordinatorLayout2.getClass();
                                r25.R(coordinatorLayout2, R.string.unknown_error, new Object[0]);
                                return;
                            }
                            return;
                        }
                        String str = ((wp3) yp3Var).a;
                        String strConcat = "barcode scan result: ".concat(str);
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ProfileAddMethodsFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("ProfileAddMethodsFragment", strConcat, null);
                        }
                        if (s63.f(str) || s63.g(str)) {
                            ji0.B(uf2.t(profileAddMethodsFragment), null, null, new hj(profileAddMethodsFragment, str, null, 29), 3);
                            return;
                        }
                        d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var3 != null) {
                            y3 y3Var3 = d83Var3.b;
                            y3Var3.getClass();
                            CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) y3Var3.a;
                            coordinatorLayout3.getClass();
                            String string = ContextUtilsKt.getContext().getString(R.string.invalid_url_format, Arrays.copyOf(new Object[0], 0));
                            string.getClass();
                            oy3.h(coordinatorLayout3, string, 0).j();
                            return;
                        }
                        return;
                }
            }
        });
        r4VarRegisterForActivityResult2.getClass();
        this.z = r4VarRegisterForActivityResult2;
        final int i3 = 2;
        r4 r4VarRegisterForActivityResult3 = registerForActivityResult(new n4(8), new l4(this) { // from class: u53
            public final /* synthetic */ ProfileAddMethodsFragment f;

            {
                this.f = this;
            }

            @Override // defpackage.l4
            public final void h(Object obj) {
                int i32 = i3;
                ge0 ge0Var = null;
                int i4 = 0;
                ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                switch (i32) {
                    case 0:
                        List list = (List) obj;
                        list.getClass();
                        if (list.isEmpty()) {
                            return;
                        }
                        ji0.B(uf2.t(profileAddMethodsFragment), null, null, new w53(profileAddMethodsFragment, list, ge0Var, i4), 3);
                        return;
                    case 1:
                        if (((Boolean) obj).booleanValue()) {
                            r4 r4Var = profileAddMethodsFragment.A;
                            if (r4Var != null) {
                                r4Var.a(new tp3(R.string.import_from_qrcode, R.drawable.ic_round_qr_code_24));
                                return;
                            } else {
                                n12.T("scanQRCodeLauncher");
                                throw null;
                            }
                        }
                        d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var != null) {
                            y3 y3Var = d83Var.b;
                            y3Var.getClass();
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                            coordinatorLayout.getClass();
                            r25.R(coordinatorLayout, R.string.get_camera_permission_failed, new Object[0]);
                            return;
                        }
                        return;
                    default:
                        yp3 yp3Var = (yp3) obj;
                        if (!(yp3Var instanceof wp3)) {
                            if (!(yp3Var instanceof vp3)) {
                                if (yp3Var instanceof xp3) {
                                    return;
                                }
                                g.d();
                                return;
                            }
                            d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var2 != null) {
                                y3 y3Var2 = d83Var2.b;
                                y3Var2.getClass();
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                coordinatorLayout2.getClass();
                                r25.R(coordinatorLayout2, R.string.unknown_error, new Object[0]);
                                return;
                            }
                            return;
                        }
                        String str = ((wp3) yp3Var).a;
                        String strConcat = "barcode scan result: ".concat(str);
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ProfileAddMethodsFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("ProfileAddMethodsFragment", strConcat, null);
                        }
                        if (s63.f(str) || s63.g(str)) {
                            ji0.B(uf2.t(profileAddMethodsFragment), null, null, new hj(profileAddMethodsFragment, str, null, 29), 3);
                            return;
                        }
                        d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var3 != null) {
                            y3 y3Var3 = d83Var3.b;
                            y3Var3.getClass();
                            CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) y3Var3.a;
                            coordinatorLayout3.getClass();
                            String string = ContextUtilsKt.getContext().getString(R.string.invalid_url_format, Arrays.copyOf(new Object[0], 0));
                            string.getClass();
                            oy3.h(coordinatorLayout3, string, 0).j();
                            return;
                        }
                        return;
                }
            }
        });
        r4VarRegisterForActivityResult3.getClass();
        this.A = r4VarRegisterForActivityResult3;
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_profile_add_methods, viewGroup, false);
        int i = R.id.local_file;
        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.local_file);
        if (materialTextView != null) {
            i = R.id.qrcode;
            MaterialTextView materialTextView2 = (MaterialTextView) vf2.l(viewInflate, R.id.qrcode);
            if (materialTextView2 != null) {
                i = R.id.start_from_scratch;
                MaterialTextView materialTextView3 = (MaterialTextView) vf2.l(viewInflate, R.id.start_from_scratch);
                if (materialTextView3 != null) {
                    i = R.id.url;
                    MaterialTextView materialTextView4 = (MaterialTextView) vf2.l(viewInflate, R.id.url);
                    if (materialTextView4 != null) {
                        MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                        this.b = new iv1(materialCardView, materialTextView, materialTextView2, materialTextView3, materialTextView4, 17);
                        materialCardView.getClass();
                        return materialCardView;
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        iv1 iv1Var = this.b;
        iv1Var.getClass();
        final int i = 0;
        ((MaterialTextView) iv1Var.X).setOnClickListener(new View.OnClickListener(this) { // from class: v53
            public final /* synthetic */ ProfileAddMethodsFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                r4 r4Var;
                int i2 = i;
                ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                switch (i2) {
                    case 0:
                        xb5.c("profiles url clicked");
                        new iz1().m(profileAddMethodsFragment.getChildFragmentManager(), null);
                        d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var != null) {
                            d83Var.q(false);
                            return;
                        }
                        return;
                    case 1:
                        xb5.c("profiles file clicked");
                        try {
                            r4 r4Var2 = profileAddMethodsFragment.f;
                            if (r4Var2 == null) {
                                n12.T("pickFileLauncher");
                                throw null;
                            }
                            r4Var2.a("*/*");
                            d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var2 != null) {
                                d83Var2.q(false);
                                return;
                            }
                            return;
                        } catch (ActivityNotFoundException e) {
                            e.printStackTrace();
                            d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var3 != null) {
                                String strValueOf = String.valueOf(e.getMessage());
                                y3 y3Var = d83Var3.b;
                                y3Var.getClass();
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                                coordinatorLayout.getClass();
                                oy3.h(coordinatorLayout, strValueOf, 0).j();
                                return;
                            }
                            return;
                        } catch (SecurityException e2) {
                            e2.printStackTrace();
                            d83 d83Var4 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var4 != null) {
                                String strValueOf2 = String.valueOf(e2.getMessage());
                                y3 y3Var2 = d83Var4.b;
                                y3Var2.getClass();
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                coordinatorLayout2.getClass();
                                oy3.h(coordinatorLayout2, strValueOf2, 0).j();
                                return;
                            }
                            return;
                        }
                    case 2:
                        xb5.c("profiles qrcode clicked");
                        try {
                            r4Var = profileAddMethodsFragment.z;
                        } catch (ActivityNotFoundException e3) {
                            e3.printStackTrace();
                            p95.C(R.string.unknown_error, new Object[0]);
                        }
                        if (r4Var == null) {
                            n12.T("requestCameraPermission");
                            throw null;
                        }
                        r4Var.a("android.permission.CAMERA");
                        d83 d83Var5 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var5 != null) {
                            d83Var5.q(false);
                            return;
                        }
                        return;
                    default:
                        xb5.c("profiles startFromScratch clicked");
                        int i3 = ProfileEditorActivity.Y0;
                        Context context = view2.getContext();
                        context.getClass();
                        Intent intent = new Intent(context, (Class<?>) ProfileEditorActivity.class);
                        intent.addFlags(2);
                        context.startActivity(intent);
                        d83 d83Var6 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var6 != null) {
                            d83Var6.q(false);
                            return;
                        }
                        return;
                }
            }
        });
        iv1 iv1Var2 = this.b;
        iv1Var2.getClass();
        final int i2 = 1;
        ((MaterialTextView) iv1Var2.f).setOnClickListener(new View.OnClickListener(this) { // from class: v53
            public final /* synthetic */ ProfileAddMethodsFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                r4 r4Var;
                int i22 = i2;
                ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                switch (i22) {
                    case 0:
                        xb5.c("profiles url clicked");
                        new iz1().m(profileAddMethodsFragment.getChildFragmentManager(), null);
                        d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var != null) {
                            d83Var.q(false);
                            return;
                        }
                        return;
                    case 1:
                        xb5.c("profiles file clicked");
                        try {
                            r4 r4Var2 = profileAddMethodsFragment.f;
                            if (r4Var2 == null) {
                                n12.T("pickFileLauncher");
                                throw null;
                            }
                            r4Var2.a("*/*");
                            d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var2 != null) {
                                d83Var2.q(false);
                                return;
                            }
                            return;
                        } catch (ActivityNotFoundException e) {
                            e.printStackTrace();
                            d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var3 != null) {
                                String strValueOf = String.valueOf(e.getMessage());
                                y3 y3Var = d83Var3.b;
                                y3Var.getClass();
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                                coordinatorLayout.getClass();
                                oy3.h(coordinatorLayout, strValueOf, 0).j();
                                return;
                            }
                            return;
                        } catch (SecurityException e2) {
                            e2.printStackTrace();
                            d83 d83Var4 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var4 != null) {
                                String strValueOf2 = String.valueOf(e2.getMessage());
                                y3 y3Var2 = d83Var4.b;
                                y3Var2.getClass();
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                coordinatorLayout2.getClass();
                                oy3.h(coordinatorLayout2, strValueOf2, 0).j();
                                return;
                            }
                            return;
                        }
                    case 2:
                        xb5.c("profiles qrcode clicked");
                        try {
                            r4Var = profileAddMethodsFragment.z;
                        } catch (ActivityNotFoundException e3) {
                            e3.printStackTrace();
                            p95.C(R.string.unknown_error, new Object[0]);
                        }
                        if (r4Var == null) {
                            n12.T("requestCameraPermission");
                            throw null;
                        }
                        r4Var.a("android.permission.CAMERA");
                        d83 d83Var5 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var5 != null) {
                            d83Var5.q(false);
                            return;
                        }
                        return;
                    default:
                        xb5.c("profiles startFromScratch clicked");
                        int i3 = ProfileEditorActivity.Y0;
                        Context context = view2.getContext();
                        context.getClass();
                        Intent intent = new Intent(context, (Class<?>) ProfileEditorActivity.class);
                        intent.addFlags(2);
                        context.startActivity(intent);
                        d83 d83Var6 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var6 != null) {
                            d83Var6.q(false);
                            return;
                        }
                        return;
                }
            }
        });
        boolean zI = je.I();
        iv1 iv1Var3 = this.b;
        if (zI) {
            iv1Var3.getClass();
            final int i3 = 2;
            ((MaterialTextView) iv1Var3.z).setOnClickListener(new View.OnClickListener(this) { // from class: v53
                public final /* synthetic */ ProfileAddMethodsFragment f;

                {
                    this.f = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    r4 r4Var;
                    int i22 = i3;
                    ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                    switch (i22) {
                        case 0:
                            xb5.c("profiles url clicked");
                            new iz1().m(profileAddMethodsFragment.getChildFragmentManager(), null);
                            d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var != null) {
                                d83Var.q(false);
                                return;
                            }
                            return;
                        case 1:
                            xb5.c("profiles file clicked");
                            try {
                                r4 r4Var2 = profileAddMethodsFragment.f;
                                if (r4Var2 == null) {
                                    n12.T("pickFileLauncher");
                                    throw null;
                                }
                                r4Var2.a("*/*");
                                d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                                if (d83Var2 != null) {
                                    d83Var2.q(false);
                                    return;
                                }
                                return;
                            } catch (ActivityNotFoundException e) {
                                e.printStackTrace();
                                d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                                if (d83Var3 != null) {
                                    String strValueOf = String.valueOf(e.getMessage());
                                    y3 y3Var = d83Var3.b;
                                    y3Var.getClass();
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                                    coordinatorLayout.getClass();
                                    oy3.h(coordinatorLayout, strValueOf, 0).j();
                                    return;
                                }
                                return;
                            } catch (SecurityException e2) {
                                e2.printStackTrace();
                                d83 d83Var4 = (d83) profileAddMethodsFragment.getParentFragment();
                                if (d83Var4 != null) {
                                    String strValueOf2 = String.valueOf(e2.getMessage());
                                    y3 y3Var2 = d83Var4.b;
                                    y3Var2.getClass();
                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                    coordinatorLayout2.getClass();
                                    oy3.h(coordinatorLayout2, strValueOf2, 0).j();
                                    return;
                                }
                                return;
                            }
                        case 2:
                            xb5.c("profiles qrcode clicked");
                            try {
                                r4Var = profileAddMethodsFragment.z;
                            } catch (ActivityNotFoundException e3) {
                                e3.printStackTrace();
                                p95.C(R.string.unknown_error, new Object[0]);
                            }
                            if (r4Var == null) {
                                n12.T("requestCameraPermission");
                                throw null;
                            }
                            r4Var.a("android.permission.CAMERA");
                            d83 d83Var5 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var5 != null) {
                                d83Var5.q(false);
                                return;
                            }
                            return;
                        default:
                            xb5.c("profiles startFromScratch clicked");
                            int i32 = ProfileEditorActivity.Y0;
                            Context context = view2.getContext();
                            context.getClass();
                            Intent intent = new Intent(context, (Class<?>) ProfileEditorActivity.class);
                            intent.addFlags(2);
                            context.startActivity(intent);
                            d83 d83Var6 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var6 != null) {
                                d83Var6.q(false);
                                return;
                            }
                            return;
                    }
                }
            });
        } else {
            iv1Var3.getClass();
            ((MaterialTextView) iv1Var3.z).setVisibility(8);
        }
        iv1 iv1Var4 = this.b;
        iv1Var4.getClass();
        final int i4 = 3;
        ((MaterialTextView) iv1Var4.A).setOnClickListener(new View.OnClickListener(this) { // from class: v53
            public final /* synthetic */ ProfileAddMethodsFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                r4 r4Var;
                int i22 = i4;
                ProfileAddMethodsFragment profileAddMethodsFragment = this.f;
                switch (i22) {
                    case 0:
                        xb5.c("profiles url clicked");
                        new iz1().m(profileAddMethodsFragment.getChildFragmentManager(), null);
                        d83 d83Var = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var != null) {
                            d83Var.q(false);
                            return;
                        }
                        return;
                    case 1:
                        xb5.c("profiles file clicked");
                        try {
                            r4 r4Var2 = profileAddMethodsFragment.f;
                            if (r4Var2 == null) {
                                n12.T("pickFileLauncher");
                                throw null;
                            }
                            r4Var2.a("*/*");
                            d83 d83Var2 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var2 != null) {
                                d83Var2.q(false);
                                return;
                            }
                            return;
                        } catch (ActivityNotFoundException e) {
                            e.printStackTrace();
                            d83 d83Var3 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var3 != null) {
                                String strValueOf = String.valueOf(e.getMessage());
                                y3 y3Var = d83Var3.b;
                                y3Var.getClass();
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                                coordinatorLayout.getClass();
                                oy3.h(coordinatorLayout, strValueOf, 0).j();
                                return;
                            }
                            return;
                        } catch (SecurityException e2) {
                            e2.printStackTrace();
                            d83 d83Var4 = (d83) profileAddMethodsFragment.getParentFragment();
                            if (d83Var4 != null) {
                                String strValueOf2 = String.valueOf(e2.getMessage());
                                y3 y3Var2 = d83Var4.b;
                                y3Var2.getClass();
                                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                coordinatorLayout2.getClass();
                                oy3.h(coordinatorLayout2, strValueOf2, 0).j();
                                return;
                            }
                            return;
                        }
                    case 2:
                        xb5.c("profiles qrcode clicked");
                        try {
                            r4Var = profileAddMethodsFragment.z;
                        } catch (ActivityNotFoundException e3) {
                            e3.printStackTrace();
                            p95.C(R.string.unknown_error, new Object[0]);
                        }
                        if (r4Var == null) {
                            n12.T("requestCameraPermission");
                            throw null;
                        }
                        r4Var.a("android.permission.CAMERA");
                        d83 d83Var5 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var5 != null) {
                            d83Var5.q(false);
                            return;
                        }
                        return;
                    default:
                        xb5.c("profiles startFromScratch clicked");
                        int i32 = ProfileEditorActivity.Y0;
                        Context context = view2.getContext();
                        context.getClass();
                        Intent intent = new Intent(context, (Class<?>) ProfileEditorActivity.class);
                        intent.addFlags(2);
                        context.startActivity(intent);
                        d83 d83Var6 = (d83) profileAddMethodsFragment.getParentFragment();
                        if (d83Var6 != null) {
                            d83Var6.q(false);
                            return;
                        }
                        return;
                }
            }
        });
    }
}
