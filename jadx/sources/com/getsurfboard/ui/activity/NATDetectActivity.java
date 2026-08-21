package com.getsurfboard.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.ca;
import defpackage.h4;
import defpackage.jd;
import defpackage.l72;
import defpackage.mp4;
import defpackage.n12;
import defpackage.nd;
import defpackage.tj4;
import defpackage.u41;
import defpackage.v9;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.xy0;
import defpackage.zo2;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NATDetectActivity extends ca {
    public static final /* synthetic */ int V0 = 0;
    public h4 S0;
    public final Handler T0 = new Handler(Looper.getMainLooper());
    public boolean U0;

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        final int i = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_nat_detect, (ViewGroup) null, false);
        int i2 = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i2 = R.id.bottom_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) vf2.l(viewInflate, R.id.bottom_container);
            if (constraintLayout != null) {
                i2 = R.id.container;
                if (((ConstraintLayout) vf2.l(viewInflate, R.id.container)) != null) {
                    i2 = android.R.id.edit;
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) vf2.l(viewInflate, android.R.id.edit);
                    if (autoCompleteTextView != null) {
                        i2 = R.id.edit_container;
                        TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.edit_container);
                        if (textInputLayout != null) {
                            i2 = R.id.loading;
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) vf2.l(viewInflate, R.id.loading);
                            if (linearProgressIndicator != null) {
                                i2 = R.id.result;
                                TextView textView = (TextView) vf2.l(viewInflate, R.id.result);
                                if (textView != null) {
                                    i2 = R.id.scrollView;
                                    NestedScrollView nestedScrollView = (NestedScrollView) vf2.l(viewInflate, R.id.scrollView);
                                    if (nestedScrollView != null) {
                                        i2 = R.id.start;
                                        AppCompatButton appCompatButton = (AppCompatButton) vf2.l(viewInflate, R.id.start);
                                        if (appCompatButton != null) {
                                            i2 = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                                            if (toolbar != null) {
                                                i2 = R.id.toolbar_divider;
                                                MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                                                if (materialDivider != null) {
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                                    this.S0 = new h4(coordinatorLayout, constraintLayout, autoCompleteTextView, textInputLayout, linearProgressIndicator, textView, nestedScrollView, appCompatButton, toolbar, materialDivider);
                                                    setContentView(coordinatorLayout);
                                                    h4 h4Var = this.S0;
                                                    if (h4Var == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) h4Var.b;
                                                    jd jdVar = new jd(24, this);
                                                    WeakHashMap weakHashMap = wp4.a;
                                                    mp4.c(coordinatorLayout2, jdVar);
                                                    h4 h4Var2 = this.S0;
                                                    if (h4Var2 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((Toolbar) h4Var2.i).setNavigationOnClickListener(new View.OnClickListener(this) { // from class: co2
                                                        public final /* synthetic */ NATDetectActivity f;

                                                        {
                                                            this.f = this;
                                                        }

                                                        @Override // android.view.View.OnClickListener
                                                        public final void onClick(View view) {
                                                            String str;
                                                            switch (i) {
                                                                case 0:
                                                                    int i3 = NATDetectActivity.V0;
                                                                    this.f.b().d();
                                                                    return;
                                                                default:
                                                                    NATDetectActivity nATDetectActivity = this.f;
                                                                    h4 h4Var3 = nATDetectActivity.S0;
                                                                    ge0 ge0Var = null;
                                                                    if (h4Var3 == null) {
                                                                        n12.T("binding");
                                                                        throw null;
                                                                    }
                                                                    ((TextInputLayout) h4Var3.a).setError(null);
                                                                    h4 h4Var4 = nATDetectActivity.S0;
                                                                    if (h4Var4 == null) {
                                                                        n12.T("binding");
                                                                        throw null;
                                                                    }
                                                                    String string = ((AutoCompleteTextView) h4Var4.d).getEditableText().toString();
                                                                    if (p44.x0(string)) {
                                                                        h4 h4Var5 = nATDetectActivity.S0;
                                                                        if (h4Var5 != null) {
                                                                            ((TextInputLayout) h4Var5.a).setError(nATDetectActivity.getString(R.string.unknown_error));
                                                                            return;
                                                                        } else {
                                                                            n12.T("binding");
                                                                            throw null;
                                                                        }
                                                                    }
                                                                    zg3 zg3Var = new zg3();
                                                                    zg3Var.b = 3478;
                                                                    if (p44.p0(string, ':')) {
                                                                        List listK0 = p44.K0(string, new char[]{':'}, 6);
                                                                        if (listK0.size() != 2) {
                                                                            h4 h4Var6 = nATDetectActivity.S0;
                                                                            if (h4Var6 != null) {
                                                                                ((TextInputLayout) h4Var6.a).setError(nATDetectActivity.getString(R.string.invalid_format));
                                                                                return;
                                                                            } else {
                                                                                n12.T("binding");
                                                                                throw null;
                                                                            }
                                                                        }
                                                                        try {
                                                                            zg3Var.b = Integer.parseInt((String) listK0.get(1));
                                                                            str = (String) listK0.get(0);
                                                                        } catch (NumberFormatException e) {
                                                                            e.printStackTrace();
                                                                            h4 h4Var7 = nATDetectActivity.S0;
                                                                            if (h4Var7 != null) {
                                                                                ((TextInputLayout) h4Var7.a).setError(nATDetectActivity.getString(R.string.invalid_port_format_template, listK0.get(1)));
                                                                                return;
                                                                            } else {
                                                                                n12.T("binding");
                                                                                throw null;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str = string;
                                                                    }
                                                                    ji0.B(uf2.t(nATDetectActivity), null, null, new uf(nATDetectActivity, str, zg3Var, ge0Var, 13), 3);
                                                                    return;
                                                            }
                                                        }
                                                    });
                                                    h4 h4Var3 = this.S0;
                                                    if (h4Var3 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    final int i3 = 1;
                                                    ((NestedScrollView) h4Var3.g).getViewTreeObserver().addOnScrollChangedListener(new nd(this, i3));
                                                    h4 h4Var4 = this.S0;
                                                    if (h4Var4 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((AutoCompleteTextView) h4Var4.d).setAdapter(new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, tj4.g));
                                                    h4 h4Var5 = this.S0;
                                                    if (h4Var5 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((AutoCompleteTextView) h4Var5.d).addTextChangedListener(new u41(2, this));
                                                    h4 h4Var6 = this.S0;
                                                    if (h4Var6 != null) {
                                                        ((AppCompatButton) h4Var6.h).setOnClickListener(new View.OnClickListener(this) { // from class: co2
                                                            public final /* synthetic */ NATDetectActivity f;

                                                            {
                                                                this.f = this;
                                                            }

                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                String str;
                                                                switch (i3) {
                                                                    case 0:
                                                                        int i32 = NATDetectActivity.V0;
                                                                        this.f.b().d();
                                                                        return;
                                                                    default:
                                                                        NATDetectActivity nATDetectActivity = this.f;
                                                                        h4 h4Var32 = nATDetectActivity.S0;
                                                                        ge0 ge0Var = null;
                                                                        if (h4Var32 == null) {
                                                                            n12.T("binding");
                                                                            throw null;
                                                                        }
                                                                        ((TextInputLayout) h4Var32.a).setError(null);
                                                                        h4 h4Var42 = nATDetectActivity.S0;
                                                                        if (h4Var42 == null) {
                                                                            n12.T("binding");
                                                                            throw null;
                                                                        }
                                                                        String string = ((AutoCompleteTextView) h4Var42.d).getEditableText().toString();
                                                                        if (p44.x0(string)) {
                                                                            h4 h4Var52 = nATDetectActivity.S0;
                                                                            if (h4Var52 != null) {
                                                                                ((TextInputLayout) h4Var52.a).setError(nATDetectActivity.getString(R.string.unknown_error));
                                                                                return;
                                                                            } else {
                                                                                n12.T("binding");
                                                                                throw null;
                                                                            }
                                                                        }
                                                                        zg3 zg3Var = new zg3();
                                                                        zg3Var.b = 3478;
                                                                        if (p44.p0(string, ':')) {
                                                                            List listK0 = p44.K0(string, new char[]{':'}, 6);
                                                                            if (listK0.size() != 2) {
                                                                                h4 h4Var62 = nATDetectActivity.S0;
                                                                                if (h4Var62 != null) {
                                                                                    ((TextInputLayout) h4Var62.a).setError(nATDetectActivity.getString(R.string.invalid_format));
                                                                                    return;
                                                                                } else {
                                                                                    n12.T("binding");
                                                                                    throw null;
                                                                                }
                                                                            }
                                                                            try {
                                                                                zg3Var.b = Integer.parseInt((String) listK0.get(1));
                                                                                str = (String) listK0.get(0);
                                                                            } catch (NumberFormatException e) {
                                                                                e.printStackTrace();
                                                                                h4 h4Var7 = nATDetectActivity.S0;
                                                                                if (h4Var7 != null) {
                                                                                    ((TextInputLayout) h4Var7.a).setError(nATDetectActivity.getString(R.string.invalid_port_format_template, listK0.get(1)));
                                                                                    return;
                                                                                } else {
                                                                                    n12.T("binding");
                                                                                    throw null;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str = string;
                                                                        }
                                                                        ji0.B(uf2.t(nATDetectActivity), null, null, new uf(nATDetectActivity, str, zg3Var, ge0Var, 13), 3);
                                                                        return;
                                                                }
                                                            }
                                                        });
                                                        return;
                                                    } else {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }

    public final void x(String str) {
        this.T0.post(new xy0(11, this, str));
    }
}
