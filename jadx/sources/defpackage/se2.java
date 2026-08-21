package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.fragment.app.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class se2 extends o implements hf4 {
    public boolean A;
    public ik1 B0;
    public Date X;
    public volatile Process Y;
    public volatile Scanner Z;
    public te2 b;
    public final ArrayList f = new ArrayList();
    public final oe2 z = new oe2();
    public final ArrayList y0 = new ArrayList();
    public final Handler z0 = new Handler(Looper.getMainLooper());
    public final ga1 A0 = new ga1(11, this);

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        List listU;
        int i = sk2Var.a;
        if (i != R.id.clear) {
            if (i != R.id.export) {
                return false;
            }
            ji0.B(uf2.t(this), null, null, new mt(this, null, 9), 3);
            return true;
        }
        oe2 oe2Var = this.z;
        synchronized (oe2Var.f) {
            oe2Var.e.clear();
            listU = oe2Var.u();
        }
        oe2Var.r(listU);
        return true;
    }

    public final void j() {
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        InputMethodManager inputMethodManager = (InputMethodManager) contextRequireContext.getSystemService(InputMethodManager.class);
        if (inputMethodManager != null) {
            te2 te2Var = this.b;
            if (te2Var != null) {
                inputMethodManager.hideSoftInputFromWindow(te2Var.d.getWindowToken(), 0);
            } else {
                n12.T("binding");
                throw null;
            }
        }
    }

    public final void k() {
        boolean z = this.z.b() == 0;
        te2 te2Var = this.b;
        if (te2Var == null) {
            n12.T("binding");
            throw null;
        }
        te2Var.c.setVisibility(z ? 0 : 8);
        te2 te2Var2 = this.b;
        if (te2Var2 != null) {
            te2Var2.f.setVisibility(z ? 8 : 0);
        } else {
            n12.T("binding");
            throw null;
        }
    }

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        ArrayList<String> stringArrayList;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (stringArrayList = arguments.getStringArrayList("exclude_list")) == null) {
            return;
        }
        Iterator<String> it = stringArrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Pattern patternCompile = Pattern.compile(it.next());
            patternCompile.getClass();
            this.f.add(patternCompile);
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.logcat_viewer_fragment_logcat, viewGroup, false);
        int i = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) vf2.l(viewInflate, R.id.appbar);
        if (appBarLayout != null) {
            i = R.id.content;
            ConstraintLayout constraintLayout = (ConstraintLayout) vf2.l(viewInflate, R.id.content);
            if (constraintLayout != null) {
                i = R.id.empty_view;
                TextView textView = (TextView) vf2.l(viewInflate, R.id.empty_view);
                if (textView != null) {
                    i = R.id.filter_input;
                    TextInputEditText textInputEditText = (TextInputEditText) vf2.l(viewInflate, R.id.filter_input);
                    if (textInputEditText != null) {
                        i = R.id.filter_input_layout;
                        TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.filter_input_layout);
                        if (textInputLayout != null) {
                            i = R.id.list;
                            RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.list);
                            if (recyclerView != null) {
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                i = R.id.spinner;
                                Spinner spinner = (Spinner) vf2.l(viewInflate, R.id.spinner);
                                if (spinner != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                                    if (toolbar != null) {
                                        this.b = new te2(appBarLayout, constraintLayout, textView, textInputEditText, textInputLayout, recyclerView, coordinatorLayout, spinner, toolbar);
                                        coordinatorLayout.getClass();
                                        return coordinatorLayout;
                                    }
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

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        ik1 ik1Var = this.B0;
        if (ik1Var != null) {
            this.z.p(ik1Var);
        }
    }

    @Override // androidx.fragment.app.o
    public final void onPause() {
        super.onPause();
        this.A = false;
        Process process = this.Y;
        if (process != null) {
            process.destroy();
        }
        Scanner scanner = this.Z;
        if (scanner != null) {
            scanner.close();
        }
        this.z0.removeCallbacks(this.A0);
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        new re2(this).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        te2 te2Var = this.b;
        ge0 ge0Var = null;
        if (te2Var == null) {
            n12.T("binding");
            throw null;
        }
        ConstraintLayout constraintLayout = te2Var.b;
        vp1 vp1Var = new vp1(20);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(constraintLayout, vp1Var);
        te2 te2Var2 = this.b;
        if (te2Var2 == null) {
            n12.T("binding");
            throw null;
        }
        mp4.c(te2Var2.a, new vp1(21));
        te2 te2Var3 = this.b;
        if (te2Var3 == null) {
            n12.T("binding");
            throw null;
        }
        mp4.c(te2Var3.e, new jd(19, this));
        te2 te2Var4 = this.b;
        if (te2Var4 == null) {
            n12.T("binding");
            throw null;
        }
        final int i = 0;
        Object[] objArr = 0;
        te2Var4.i.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: pe2
            public final /* synthetic */ se2 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                wu2 wu2VarB;
                int i2 = i;
                se2 se2Var = this.f;
                switch (i2) {
                    case 0:
                        p activity = se2Var.getActivity();
                        if (activity == null || (wu2VarB = activity.b()) == null) {
                            return;
                        }
                        wu2VarB.d();
                        return;
                    default:
                        te2 te2Var5 = se2Var.b;
                        if (te2Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        Editable text = te2Var5.d.getText();
                        if (text != null) {
                            text.clear();
                        }
                        se2Var.j();
                        return;
                }
            }
        });
        te2 te2Var5 = this.b;
        if (te2Var5 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var5.i.setOnMenuItemClickListener(this);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(requireContext(), R.array.logcat_viewer_logcat_spinner, R.layout.logcat_viewer_item_logcat_dropdown);
        arrayAdapterCreateFromResource.getClass();
        arrayAdapterCreateFromResource.setDropDownViewResource(R.layout.logcat_viewer_item_logcat_dropdown);
        te2 te2Var6 = this.b;
        if (te2Var6 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var6.h.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        te2 te2Var7 = this.b;
        if (te2Var7 == null) {
            n12.T("binding");
            throw null;
        }
        int i2 = 2;
        te2Var7.h.setOnItemSelectedListener(new ky0(i2, this));
        te2 te2Var8 = this.b;
        if (te2Var8 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var8.f.setLayoutManager(new LinearLayoutManager(requireContext()));
        te2 te2Var9 = this.b;
        if (te2Var9 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var9.f.setItemAnimator(null);
        te2 te2Var10 = this.b;
        if (te2Var10 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var10.f.i(new lw0(requireContext()));
        te2 te2Var11 = this.b;
        if (te2Var11 == null) {
            n12.T("binding");
            throw null;
        }
        RecyclerView recyclerView = te2Var11.f;
        oe2 oe2Var = this.z;
        recyclerView.setAdapter(oe2Var);
        te2 te2Var12 = this.b;
        if (te2Var12 == null) {
            n12.T("binding");
            throw null;
        }
        RecyclerView recyclerView2 = te2Var12.f;
        uk0 uk0Var = new uk0(recyclerView2);
        uk0Var.f = false;
        cm2 cm2Var = new cm2(recyclerView2);
        cm2Var.C();
        cm2Var.Z = uk0Var;
        cm2Var.d();
        final int i3 = 1;
        ik1 ik1Var = new ik1(i3, this);
        this.B0 = ik1Var;
        oe2Var.n(ik1Var);
        k();
        wu2 wu2VarB = requireActivity().b();
        da2 viewLifecycleOwner = getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        wu2VarB.a(viewLifecycleOwner, new gt1(i3, this, objArr == true ? 1 : 0));
        m24 m24VarA = n24.a("");
        pg1 pg1Var = new pg1(new av(4, new kg1(new ji(9), m24VarA, null)), new gd(this, ge0Var, 10), i2);
        da2 viewLifecycleOwner2 = getViewLifecycleOwner();
        viewLifecycleOwner2.getClass();
        ji0.B(uf2.t(viewLifecycleOwner2), null, null, new mt(pg1Var, ge0Var, 5), 3);
        te2 te2Var13 = this.b;
        if (te2Var13 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var13.d.addTextChangedListener(new u41(i3, m24VarA));
        te2 te2Var14 = this.b;
        if (te2Var14 == null) {
            n12.T("binding");
            throw null;
        }
        te2Var14.d.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: qe2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                if (i4 != 3) {
                    return false;
                }
                this.a.j();
                return true;
            }
        });
        te2 te2Var15 = this.b;
        if (te2Var15 != null) {
            te2Var15.e.setEndIconOnClickListener(new View.OnClickListener(this) { // from class: pe2
                public final /* synthetic */ se2 f;

                {
                    this.f = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    wu2 wu2VarB2;
                    int i22 = i3;
                    se2 se2Var = this.f;
                    switch (i22) {
                        case 0:
                            p activity = se2Var.getActivity();
                            if (activity == null || (wu2VarB2 = activity.b()) == null) {
                                return;
                            }
                            wu2VarB2.d();
                            return;
                        default:
                            te2 te2Var52 = se2Var.b;
                            if (te2Var52 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            Editable text = te2Var52.d.getText();
                            if (text != null) {
                                text.clear();
                            }
                            se2Var.j();
                            return;
                    }
                }
            });
        } else {
            n12.T("binding");
            throw null;
        }
    }
}
