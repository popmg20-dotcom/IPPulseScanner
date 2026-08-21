package defpackage;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.i;
import androidx.fragment.app.p;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kb3 extends i {
    public iv1 H0;
    public final c4 I0 = new c4();
    public sa J0;

    public final void n(CharSequence charSequence, String str) {
        iv1 iv1Var = this.H0;
        if (iv1Var == null) {
            n12.T("binding");
            throw null;
        }
        for (e03 e03Var : e70.K(new e03((LinearLayout) iv1Var.A, str), new e03((LinearLayout) iv1Var.X, charSequence))) {
            Object obj = e03Var.b;
            obj.getClass();
            LinearLayout linearLayout = (LinearLayout) obj;
            CharSequence charSequence2 = (CharSequence) e03Var.f;
            View viewInflate = getLayoutInflater().inflate(R.layout.item_proxy_info_dialog_text, (ViewGroup) linearLayout, false);
            if (viewInflate == null) {
                zo2.n("rootView");
                return;
            } else {
                TextView textView = (TextView) viewInflate;
                textView.setText(charSequence2);
                linearLayout.addView(textView);
            }
        }
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (u.M(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to 2, " + R.style.Theme_Surfboard_Dialog_Transparent);
        }
        this.X = 2;
        this.Y = android.R.style.Theme.Panel;
        this.Y = R.style.Theme_Surfboard_Dialog_Transparent;
        this.Z = false;
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.setCancelable(false);
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.dialog_proxy_info, viewGroup, false);
        int i = R.id.action_container;
        if (((MaterialCardView) vf2.l(viewInflate, R.id.action_container)) != null) {
            i = R.id.close;
            MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.close);
            if (materialTextView != null) {
                i = R.id.copy;
                if (((MaterialTextView) vf2.l(viewInflate, R.id.copy)) != null) {
                    i = R.id.info_container;
                    if (((MaterialCardView) vf2.l(viewInflate, R.id.info_container)) != null) {
                        i = R.id.key_group;
                        LinearLayout linearLayout = (LinearLayout) vf2.l(viewInflate, R.id.key_group);
                        if (linearLayout != null) {
                            i = R.id.share;
                            if (((MaterialTextView) vf2.l(viewInflate, R.id.share)) != null) {
                                i = R.id.value_group;
                                LinearLayout linearLayout2 = (LinearLayout) vf2.l(viewInflate, R.id.value_group);
                                if (linearLayout2 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                    this.H0 = new iv1(constraintLayout, materialTextView, linearLayout, linearLayout2, 10);
                                    constraintLayout.getClass();
                                    return constraintLayout;
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onDestroyView() {
        Dialog dialog;
        Window window;
        View decorView;
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        Window window2;
        View decorView2;
        p activity = getActivity();
        c4 c4Var = this.I0;
        ValueAnimator valueAnimator = c4Var.a;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = c4Var.a;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        c4Var.a = null;
        if (activity != null && (window2 = activity.getWindow()) != null && (decorView2 = window2.getDecorView()) != null) {
            c4Var.b(decorView2);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            sa saVar = this.J0;
            if (saVar != null && (dialog = this.C0) != null && (window = dialog.getWindow()) != null && (decorView = window.getDecorView()) != null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = decorView.findOnBackInvokedDispatcher()) != null) {
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(saVar);
            }
            this.J0 = null;
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStart() {
        Window window;
        Window window2;
        View decorView;
        OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        Window window3;
        super.onStart();
        Dialog dialog = this.C0;
        if (dialog != null && (window3 = dialog.getWindow()) != null) {
            window3.addFlags(-2147417856);
            window3.setStatusBarColor(0);
            window3.setNavigationBarColor(0);
            window3.getDecorView().setSystemUiVisibility(window3.getDecorView().getSystemUiVisibility() | 1792);
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window3.getAttributes();
                attributes.layoutInDisplayCutoutMode = 3;
                window3.setAttributes(attributes);
            }
            window3.setLayout(-1, -1);
            v9.e(window3);
            if (i >= 29) {
                window3.setNavigationBarContrastEnforced(false);
            }
            boolean z = (window3.getContext().getResources().getConfiguration().uiMode & 48) == 32;
            window3.getDecorView();
            int i2 = Build.VERSION.SDK_INT;
            vo hv4Var = i2 >= 35 ? new hv4(window3) : i2 >= 30 ? new fv4(window3) : i2 >= 26 ? new dv4(window3) : new cv4(window3);
            boolean z2 = !z;
            hv4Var.K(z2);
            hv4Var.J(z2);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 33) {
            Dialog dialog2 = this.C0;
            if (dialog2 != null) {
                dialog2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: ib3
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                        if (i4 != 4 || keyEvent.getAction() != 1) {
                            return false;
                        }
                        kb3 kb3Var = this.b;
                        kb3Var.I0.a(kb3Var.getActivity(), kb3Var.getView(), new jb3(kb3Var, 2));
                        return true;
                    }
                });
            }
        } else if (this.J0 == null) {
            sa saVar = new sa(3, this);
            Dialog dialog3 = this.C0;
            if (dialog3 != null && (window2 = dialog3.getWindow()) != null && (decorView = window2.getDecorView()) != null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = decorView.findOnBackInvokedDispatcher()) != null) {
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(0, saVar);
            }
            this.J0 = saVar;
        }
        p activity = getActivity();
        View view = getView();
        c4 c4Var = this.I0;
        if (view != null) {
            c4Var.getClass();
            view.setAlpha(0.0f);
            view.setScaleX(0.95f);
            view.setScaleY(0.95f);
            view.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }
        c4Var.getClass();
        View decorView2 = (i3 < 31 || activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        if (decorView2 == null) {
            return;
        }
        c4Var.c(decorView2, 0.0f, 20.0f * decorView2.getResources().getDisplayMetrics().density, null);
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(final View view, Bundle bundle) {
        String string;
        t53 t53Var;
        ea3 ea3VarL;
        view.getClass();
        iv1 iv1Var = this.H0;
        String str = null;
        if (iv1Var == null) {
            n12.T("binding");
            throw null;
        }
        final int paddingLeft = ((ConstraintLayout) iv1Var.f).getPaddingLeft();
        iv1 iv1Var2 = this.H0;
        if (iv1Var2 == null) {
            n12.T("binding");
            throw null;
        }
        final int paddingTop = ((ConstraintLayout) iv1Var2.f).getPaddingTop();
        iv1 iv1Var3 = this.H0;
        if (iv1Var3 == null) {
            n12.T("binding");
            throw null;
        }
        final int paddingRight = ((ConstraintLayout) iv1Var3.f).getPaddingRight();
        iv1 iv1Var4 = this.H0;
        if (iv1Var4 == null) {
            n12.T("binding");
            throw null;
        }
        final int paddingBottom = ((ConstraintLayout) iv1Var4.f).getPaddingBottom();
        iv1 iv1Var5 = this.H0;
        if (iv1Var5 == null) {
            n12.T("binding");
            throw null;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) iv1Var5.f;
        mu2 mu2Var = new mu2() { // from class: gb3
            @Override // defpackage.mu2
            public final bv4 Z(View view2, bv4 bv4Var) {
                view2.getClass();
                t02 t02VarH = bv4Var.a.h(647);
                t02VarH.getClass();
                view2.setPadding(paddingLeft + t02VarH.a, paddingTop + t02VarH.b, paddingRight + t02VarH.c, paddingBottom + t02VarH.d);
                return bv4Var;
            }
        };
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(constraintLayout, mu2Var);
        iv1 iv1Var6 = this.H0;
        if (iv1Var6 == null) {
            n12.T("binding");
            throw null;
        }
        final int i = 0;
        ((ConstraintLayout) iv1Var6.f).setOnClickListener(new View.OnClickListener(this) { // from class: hb3
            public final /* synthetic */ kb3 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i2 = i;
                View view3 = view;
                kb3 kb3Var = this.f;
                switch (i2) {
                    case 0:
                        kb3Var.I0.a(kb3Var.getActivity(), view3, new jb3(kb3Var, 0));
                        break;
                    default:
                        kb3Var.I0.a(kb3Var.getActivity(), view3, new jb3(kb3Var, 3));
                        break;
                }
            }
        });
        iv1 iv1Var7 = this.H0;
        if (iv1Var7 == null) {
            n12.T("binding");
            throw null;
        }
        final int i2 = 1;
        ((MaterialTextView) iv1Var7.z).setOnClickListener(new View.OnClickListener(this) { // from class: hb3
            public final /* synthetic */ kb3 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i22 = i2;
                View view3 = view;
                kb3 kb3Var = this.f;
                switch (i22) {
                    case 0:
                        kb3Var.I0.a(kb3Var.getActivity(), view3, new jb3(kb3Var, 0));
                        break;
                    default:
                        kb3Var.I0.a(kb3Var.getActivity(), view3, new jb3(kb3Var, 3));
                        break;
                }
            }
        });
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("proxy_name")) == null || (t53Var = (t53) d73.c.d()) == null || (ea3VarL = t53Var.l(string, ji0.w(t53Var))) == null) {
            return;
        }
        n(ek0.q(ea3VarL, false), "Type");
        n(ea3VarL.getName(), "Name");
        String strA = lb3.a(ea3VarL);
        if (strA != null) {
            n(strA, "Host");
        }
        Integer numB = lb3.b(ea3VarL);
        if (numB != null) {
            n(String.valueOf(numB.intValue()), "Port");
        }
        boolean z = ea3VarL instanceof ms4;
        String str2 = z ? ((ms4) ea3VarL).A : ea3VarL instanceof ou1 ? ((ou1) ea3VarL).A : ea3VarL instanceof gv1 ? ((gv1) ea3VarL).A : ea3VarL instanceof zy3 ? ((zy3) ea3VarL).A : ea3VarL instanceof az3 ? ((az3) ea3VarL).A : null;
        if (str2 != null) {
            n(str2, "Username");
        }
        boolean z2 = ea3VarL instanceof mu3;
        if (z2) {
            str = ((mu3) ea3VarL).X;
        } else if (ea3VarL instanceof jv1) {
            str = ((jv1) ea3VarL).A;
        } else if (ea3VarL instanceof s9) {
            str = ((s9) ea3VarL).A;
        } else if (ea3VarL instanceof sy3) {
            str = ((sy3) ea3VarL).A;
        } else if (ea3VarL instanceof xh4) {
            str = ((xh4) ea3VarL).A;
        } else if (ea3VarL instanceof ai4) {
            str = ((ai4) ea3VarL).X;
        } else if (ea3VarL instanceof ou1) {
            str = ((ou1) ea3VarL).X;
        } else if (ea3VarL instanceof gv1) {
            str = ((gv1) ea3VarL).X;
        } else if (ea3VarL instanceof zy3) {
            str = ((zy3) ea3VarL).X;
        } else if (ea3VarL instanceof az3) {
            str = ((az3) ea3VarL).X;
        }
        if (str != null) {
            n(str, "Password");
        }
        n(ea3VarL.e() ? "Yes" : "No", "UDP Relay");
        if (ea3VarL instanceof q94) {
            if (z && ((ms4) ea3VarL).X) {
                n("Yes", "TLS");
            }
            q94 q94Var = (q94) ea3VarL;
            if (q94Var.g()) {
                n("No", "Verify Cert");
            }
            String strV = q94Var.V();
            if (strV != null) {
                n(strV, "SNI");
            }
        }
        if ((ea3VarL instanceof it4) && ((it4) ea3VarL).i()) {
            n("Yes", HttpHeaders.Values.WEBSOCKET);
        }
        if (z2) {
            mu3 mu3Var = (mu3) ea3VarL;
            n(mu3Var.A, "Method");
            lu3 lu3Var = mu3Var.Y;
            if (lu3Var == lu3.TLS) {
                n("TLS", "Obfuscate");
                return;
            } else {
                if (lu3Var == lu3.HTTP) {
                    n("HTTP", "Obfuscate");
                    return;
                }
                return;
            }
        }
        if (ea3VarL instanceof sy3) {
            sy3 sy3Var = (sy3) ea3VarL;
            n(String.valueOf(sy3Var.X), "Version");
            String str3 = sy3Var.Y;
            if (str3 != null) {
                n(str3, "Obfuscate");
            }
            String str4 = sy3Var.Z;
            if (str4 != null) {
                n(str4, "Obfs Host");
            }
            String str5 = sy3Var.y0;
            if (str5 != null) {
                n(str5, "Obfs URI");
                return;
            }
            return;
        }
        if (z) {
            if (((ms4) ea3VarL).D0) {
                n("Yes", "AEAD");
                return;
            }
            return;
        }
        if (ea3VarL instanceof ai4) {
            ai4 ai4Var = (ai4) ea3VarL;
            n(ai4Var.A, "UUID");
            String str6 = ai4Var.Y;
            if (str6 != null) {
                n(str6, "ALPN");
            }
            List list = ai4Var.Z;
            if (list != null) {
                n(d70.j0(list, ";", null, null, null, 62), "Port Hopping");
                return;
            }
            return;
        }
        if (ea3VarL instanceof jv1) {
            jv1 jv1Var = (jv1) ea3VarL;
            Integer num = jv1Var.X;
            if (num != null) {
                n(num.intValue() + " Mbps", "Download Bandwidth");
            }
            List list2 = jv1Var.Y;
            if (list2 != null) {
                n(d70.j0(list2, ";", null, null, null, 62), "Port Hopping");
            }
            Integer num2 = jv1Var.Z;
            if (num2 != null) {
                n(num2.intValue() + " s", "Port Hopping Interval");
            }
            String str7 = jv1Var.y0;
            if (str7 != null) {
                n(str7, "Salamander");
                return;
            }
            return;
        }
        if (ea3VarL instanceof s9) {
            n(((s9) ea3VarL).y0 ? "Yes" : "No", "Reuse");
            return;
        }
        if (ea3VarL instanceof fw4) {
            fw4 fw4Var = (fw4) ea3VarL;
            LinkedHashSet linkedHashSet = fw4Var.X;
            ew4 ew4Var = fw4Var.Z;
            if (!linkedHashSet.isEmpty()) {
                n(d70.j0(linkedHashSet, null, null, null, null, 63), "DNS");
            }
            n(fw4Var.f, "Private Key");
            String str8 = ew4Var.b;
            ArrayList arrayList = ew4Var.z;
            n(str8, "Public Key");
            String str9 = ew4Var.f;
            if (str9 != null) {
                n(str9, "Pre-shared Key");
            }
            n(fw4Var.z, "Self IP");
            n(String.valueOf(fw4Var.Y), "MTU");
            n(String.valueOf(ew4Var.X), "Keep Alive");
            if (arrayList.isEmpty()) {
                return;
            }
            n(d70.j0(arrayList, null, null, null, null, 63), "Allowed IPs");
        }
    }
}
