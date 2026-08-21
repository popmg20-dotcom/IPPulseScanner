package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.Pair;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.o;
import androidx.fragment.app.p;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d83 extends o implements jv2, hf4, hv2 {
    public y3 b;
    public boolean f;
    public final jj z = new jj(this);
    public final bx0 A = new bx0(new wn1(13, this));
    public final gt1 X = new gt1(4, this);

    public static void l(d83 d83Var, String str) {
        d83Var.getClass();
        ji0.B(uf2.t(d83Var), null, null, new z73(null, str, d83Var, false, null), 3);
    }

    public static ArrayList n(List list) {
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String name = ((zk) obj).getName();
            String[] strArr = t23.a;
            name.getClass();
            if (t23.k().contains(name)) {
                arrayList2.add(obj);
            }
        }
        arrayList.removeAll(d70.C0(arrayList2));
        arrayList.addAll(0, arrayList2);
        return arrayList;
    }

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        int i = sk2Var.a;
        if (i == R.id.manual) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            vo.F(contextRequireContext, "https://getsurfboard.com/docs/profile-format/overview");
            return true;
        }
        if (i == R.id.explorer) {
            new q81().m(getChildFragmentManager(), null);
            return true;
        }
        int i2 = 0;
        if (i == R.id.update_all) {
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ProfilesFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "update profile due to update all clicked");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ProfilesFragment", "update profile due to update all clicked", null);
            }
            Context contextRequireContext2 = requireContext();
            contextRequireContext2.getClass();
            xw4 xw4VarC = xw4.c(contextRequireContext2);
            xw4VarC.a();
            List list = (List) d73.b.d();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    tj4.z((zk) it.next(), xw4VarC, true);
                }
            }
            this.A.g = null;
            y3 y3Var = this.b;
            y3Var.getClass();
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
            coordinatorLayout.getClass();
            r25.R(coordinatorLayout, R.string.start_update_all_profiles, new Object[0]);
            return true;
        }
        int i3 = 15;
        if (i != R.id.webdav) {
            if (i == R.id.push) {
                List list2 = (List) d73.b.d();
                if (list2 != null) {
                    Context contextRequireContext3 = requireContext();
                    contextRequireContext3.getClass();
                    gj gjVar = new gj(i3, this, list2);
                    ed4 ed4VarF = ed4.F(LayoutInflater.from(contextRequireContext3));
                    long j = t23.l().getLong("webdav_last_time_upload", -1L);
                    ((MaterialCheckBox) ed4VarF.z).setText(R.string.overwrite_remote);
                    wh2 wh2Var = new wh2(contextRequireContext3);
                    ((p6) wh2Var.z).c = R.drawable.ic_round_drive_folder_upload_24;
                    wh2Var.x(R.string.push_to_remote_confirm);
                    MaterialTextView materialTextView = (MaterialTextView) ed4VarF.A;
                    if (j != -1) {
                        materialTextView.setText(ContextUtilsKt.l(R.string.last_time_upload_template, DateUtils.getRelativeTimeSpanString(j)));
                    } else {
                        materialTextView.setVisibility(8);
                    }
                    wh2Var.y((ConstraintLayout) ed4VarF.f);
                    wh2Var.v(R.string.cancel, null);
                    wh2Var.w(R.string.push, new li(13, gjVar, ed4VarF));
                    wh2Var.r();
                }
                return true;
            }
            if (i != R.id.pull) {
                if (i != R.id.settings) {
                    return false;
                }
                Context contextRequireContext4 = requireContext();
                contextRequireContext4.getClass();
                fx3.I(contextRequireContext4, null, false);
                return true;
            }
            Context contextRequireContext5 = requireContext();
            contextRequireContext5.getClass();
            p73 p73Var = new p73(this, i2);
            ed4 ed4VarF2 = ed4.F(LayoutInflater.from(contextRequireContext5));
            long j2 = t23.l().getLong("webdav_last_time_download", -1L);
            ((MaterialCheckBox) ed4VarF2.z).setText(R.string.overwrite_local);
            wh2 wh2Var2 = new wh2(contextRequireContext5);
            ((p6) wh2Var2.z).c = R.drawable.ic_round_cloud_download_24;
            wh2Var2.x(R.string.pull_from_remote_confirm);
            MaterialTextView materialTextView2 = (MaterialTextView) ed4VarF2.A;
            if (j2 != -1) {
                materialTextView2.setText(ContextUtilsKt.l(R.string.last_time_download_template, DateUtils.getRelativeTimeSpanString(j2)));
            } else {
                materialTextView2.setVisibility(8);
            }
            wh2Var2.y((ConstraintLayout) ed4VarF2.f);
            wh2Var2.v(R.string.cancel, null);
            wh2Var2.w(R.string.pull, new li(12, p73Var, ed4VarF2));
            wh2Var2.r();
            return true;
        }
        Context contextRequireContext6 = requireContext();
        contextRequireContext6.getClass();
        final m31 m31Var = new m31(contextRequireContext6, 1);
        fn fnVar = new fn(16, this);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(contextRequireContext6);
        layoutInflaterFrom.getClass();
        View viewInflate = layoutInflaterFrom.inflate(R.layout.dialog_webdav_sync, (ViewGroup) null, false);
        int i4 = R.id.account;
        TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.account);
        if (textInputLayout != null) {
            i4 = R.id.password;
            TextInputLayout textInputLayout2 = (TextInputLayout) vf2.l(viewInflate, R.id.password);
            if (textInputLayout2 != null) {
                i4 = R.id.server_addr;
                TextInputLayout textInputLayout3 = (TextInputLayout) vf2.l(viewInflate, R.id.server_addr);
                if (textInputLayout3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                    ed4 ed4Var = new ed4(constraintLayout, textInputLayout, textInputLayout2, textInputLayout3);
                    wh2 wh2Var3 = new wh2(contextRequireContext6);
                    wh2Var3.x(R.string.webdav_config);
                    wh2Var3.y(constraintLayout);
                    wh2Var3.w(R.string.save, new li(14, ed4Var, fnVar));
                    wh2Var3.u(R.string.cancel, null);
                    if (t23.o("webdav_server", null) == null && t23.o("webdav_account", null) == null && t23.o("webdav_password", null) == null) {
                        wh2Var3.v(R.string.help, new li(i3, ed4Var, m31Var));
                    } else {
                        wh2Var3.v(R.string.remove, new y5(6, fnVar));
                    }
                    ((p6) wh2Var3.z).n = false;
                    u6 u6VarH = wh2Var3.h();
                    EditText editText = textInputLayout3.getEditText();
                    editText.getClass();
                    AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                    autoCompleteTextView.setAdapter(new ArrayAdapter(autoCompleteTextView.getContext(), android.R.layout.simple_dropdown_item_1line, new String[]{"https://dav.jianguoyun.com/dav/", "https://dav.box.com/dav"}));
                    autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ht4
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view, int i5, long j3) {
                            String str;
                            if (i5 == 0) {
                                if (t23.d("webdav_jianguoyun_help_showed", false)) {
                                    return;
                                } else {
                                    str = "https://help.jianguoyun.com/?p=2064";
                                }
                            } else if (t23.d("webdav_box_help_showed", false)) {
                                return;
                            } else {
                                str = "https://support.box.com/hc/en-us/articles/360043696414-WebDAV-with-Box";
                            }
                            m31Var.b(str);
                        }
                    });
                    EditText editText2 = textInputLayout3.getEditText();
                    editText2.getClass();
                    editText2.setText(t23.o("webdav_server", null));
                    EditText editText3 = textInputLayout.getEditText();
                    editText3.getClass();
                    editText3.setText(t23.o("webdav_account", null));
                    EditText editText4 = textInputLayout2.getEditText();
                    editText4.getClass();
                    editText4.setText(t23.o("webdav_password", null));
                    Set setT0 = qe.t0(new EditText[]{editText2, editText3, editText4});
                    Iterator it2 = setT0.iterator();
                    while (it2.hasNext()) {
                        ((EditText) it2.next()).addTextChangedListener(new ri(m31Var, u6VarH, setT0));
                    }
                    u6VarH.setOnShowListener(new mi(m31Var, u6VarH, setT0));
                    u6VarH.show();
                    return true;
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i4)));
        return false;
    }

    @Override // defpackage.jv2
    public final void c() {
        y3 y3Var = this.b;
        if (y3Var != null) {
            ((RecyclerView) y3Var.j).o0(0);
        }
    }

    @Override // defpackage.hv2
    public final td0 d(View view, td0 td0Var) {
        qd0 pd0Var;
        qd0 pd0Var2;
        Pair pairCreate;
        td0 td0Var2 = td0Var;
        view.getClass();
        td0Var2.getClass();
        sd0 sd0Var = td0Var2.a;
        ClipData clipDataC = sd0Var.c();
        if (clipDataC.getItemCount() == 1) {
            boolean z = clipDataC.getItemAt(0).getUri() != null;
            td0 td0Var3 = z ? td0Var2 : null;
            if (z) {
                td0Var2 = null;
            }
            pairCreate = Pair.create(td0Var3, td0Var2);
        } else {
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (int i = 0; i < clipDataC.getItemCount(); i++) {
                ClipData.Item itemAt = clipDataC.getItemAt(i);
                if (itemAt.getUri() != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(itemAt);
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(itemAt);
                }
            }
            Pair pairCreate2 = arrayList == null ? Pair.create(null, clipDataC) : arrayList2 == null ? Pair.create(clipDataC, null) : Pair.create(td0.a(clipDataC.getDescription(), arrayList), td0.a(clipDataC.getDescription(), arrayList2));
            if (pairCreate2.first == null) {
                pairCreate = Pair.create(null, td0Var2);
            } else if (pairCreate2.second == null) {
                pairCreate = Pair.create(td0Var2, null);
            } else {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 31) {
                    pd0Var = new pd0(td0Var2);
                } else {
                    rd0 rd0Var = new rd0();
                    rd0Var.b = sd0Var.c();
                    rd0Var.c = sd0Var.a();
                    rd0Var.d = sd0Var.g();
                    rd0Var.e = sd0Var.b();
                    rd0Var.f = sd0Var.getExtras();
                    pd0Var = rd0Var;
                }
                pd0Var.f((ClipData) pairCreate2.first);
                td0 td0VarBuild = pd0Var.build();
                if (i2 >= 31) {
                    pd0Var2 = new pd0(td0Var2);
                } else {
                    rd0 rd0Var2 = new rd0();
                    rd0Var2.b = sd0Var.c();
                    rd0Var2.c = sd0Var.a();
                    rd0Var2.d = sd0Var.g();
                    rd0Var2.e = sd0Var.b();
                    rd0Var2.f = sd0Var.getExtras();
                    pd0Var2 = rd0Var2;
                }
                pd0Var2.f((ClipData) pairCreate2.second);
                pairCreate = Pair.create(td0VarBuild, pd0Var2.build());
            }
        }
        pairCreate.getClass();
        td0 td0Var4 = (td0) pairCreate.first;
        td0 td0Var5 = (td0) pairCreate.second;
        if (td0Var4 != null) {
            ClipData clipDataC2 = td0Var4.a.c();
            clipDataC2.getClass();
            int itemCount = clipDataC2.getItemCount();
            for (int i3 = 0; i3 < itemCount; i3++) {
                ClipDescription description = clipDataC2.getDescription();
                String str = "Drag and drop triggered: " + description;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ProfilesFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ProfilesFragment", str, null);
                }
                String[] strArr = n12.c;
                for (int i4 = 0; i4 < 2; i4++) {
                    if (description.hasMimeType(strArr[i4])) {
                        String str2 = "Drag and drop match type: " + description;
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "ProfilesFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("ProfilesFragment", str2, null);
                        }
                        ji0.B(uf2.t(this), null, null, new b83(this, clipDataC2, i3, null), 3);
                        return td0Var5;
                    }
                }
            }
        }
        return td0Var5;
    }

    public final void j(Uri uri) {
        uri.getClass();
        ji0.B(uf2.t(this), null, null, new u73(this, uri, null), 3);
    }

    public final void k(List list) {
        if (list.size() == 1) {
            j((Uri) d70.d0(list));
        } else {
            ji0.B(uf2.t(this), null, null, new v73(this, list, null), 3);
        }
    }

    public final void m() {
        y3 y3Var = this.b;
        y3Var.getClass();
        Menu menu = ((Toolbar) y3Var.c).getMenu();
        if (menu instanceof nk2) {
            ((nk2) menu).s = true;
        }
        menu.clear();
        y3 y3Var2 = this.b;
        y3Var2.getClass();
        ((Toolbar) y3Var2.c).o(R.menu.profile_list);
        y3 y3Var3 = this.b;
        y3Var3.getClass();
        ((Toolbar) y3Var3.c).getMenu().findItem(R.id.push).setVisible(p95.t());
        y3 y3Var4 = this.b;
        y3Var4.getClass();
        ((Toolbar) y3Var4.c).getMenu().findItem(R.id.pull).setVisible(p95.t());
        y3 y3Var5 = this.b;
        y3Var5.getClass();
        ((Toolbar) y3Var5.c).setOnMenuItemClickListener(this);
    }

    public final void o(Throwable th, CharSequence charSequence, String str, String str2, pl1 pl1Var) {
        if (getContext() == null) {
            return;
        }
        CharSequence charSequenceU = ji0.u(th, charSequence);
        wh2 wh2Var = new wh2(requireContext());
        p6 p6Var = (p6) wh2Var.z;
        wh2Var.x(R.string.import_failed);
        p6Var.g = charSequenceU;
        int i = 4;
        wh2Var.w(R.string.i_got_it, new ph0(i));
        if (str != null && str2 != null && pl1Var != null) {
            wh2Var.u(R.string.continue_import, new y5(i, pl1Var));
        }
        wh2Var.v(R.string.copy_message, new li(8, charSequenceU, this));
        p6Var.p = new ja1(1);
        p6Var.o = new ka1(1);
        u6 u6VarH = wh2Var.h();
        u6VarH.setOnShowListener(new ai0(2));
        u6VarH.show();
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_profiles, viewGroup, false);
        int i = R.id.add;
        FloatingActionButton floatingActionButton = (FloatingActionButton) vf2.l(viewInflate, R.id.add);
        if (floatingActionButton != null) {
            i = R.id.add_methods;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) vf2.l(viewInflate, R.id.add_methods);
            if (fragmentContainerView != null) {
                i = R.id.appbar;
                if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
                    i = R.id.empty;
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) vf2.l(viewInflate, R.id.empty);
                    if (linearLayoutCompat != null) {
                        i = R.id.import_backup;
                        MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.import_backup);
                        if (materialButton != null) {
                            i = R.id.loading;
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) vf2.l(viewInflate, R.id.loading);
                            if (linearProgressIndicator != null) {
                                i = R.id.manual;
                                MaterialButton materialButton2 = (MaterialButton) vf2.l(viewInflate, R.id.manual);
                                if (materialButton2 != null) {
                                    i = R.id.mask;
                                    View viewL = vf2.l(viewInflate, R.id.mask);
                                    if (viewL != null) {
                                        i = R.id.recycler_view;
                                        RecyclerView recyclerView = (RecyclerView) vf2.l(viewInflate, R.id.recycler_view);
                                        if (recyclerView != null) {
                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                            i = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                                            if (toolbar != null) {
                                                i = R.id.toolbar_divider;
                                                MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                                                if (materialDivider != null) {
                                                    this.b = new y3(floatingActionButton, fragmentContainerView, linearLayoutCompat, materialButton, linearProgressIndicator, materialButton2, viewL, recyclerView, coordinatorLayout, toolbar, materialDivider);
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
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        boolean z = nj3.a;
        nj3.e.d(this);
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        y3 y3Var = this.b;
        y3Var.getClass();
        RecyclerView recyclerView = (RecyclerView) y3Var.j;
        int i = 0;
        while (true) {
            if (!(i < recyclerView.getChildCount())) {
                return;
            }
            int i2 = i + 1;
            View childAt = recyclerView.getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            y3 y3Var2 = this.b;
            y3Var2.getClass();
            rg3 rg3VarN = ((RecyclerView) y3Var2.j).N(childAt);
            if (rg3VarN instanceof z63) {
                z63 z63Var = (z63) rg3VarN;
                z63Var.u.c.setText(ContextUtilsKt.l(R.string.last_modified_template, DateUtils.getRelativeTimeSpanString(z63Var.v)));
            }
            i = i2;
        }
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        wu2 wu2VarB;
        view.getClass();
        m();
        y3 y3Var = this.b;
        y3Var.getClass();
        final int i = 0;
        ((RecyclerView) y3Var.j).setFocusable(false);
        y3 y3Var2 = this.b;
        y3Var2.getClass();
        ((RecyclerView) y3Var2.j).setAdapter(this.A);
        final int i2 = 1;
        final int i3 = 3;
        d73.d.e(getViewLifecycleOwner(), new yh0(3, new p73(this, i2)));
        final int i4 = 2;
        d73.b.e(getViewLifecycleOwner(), new yh0(3, new p73(this, i4)));
        ws4.a.e(getViewLifecycleOwner(), new yh0(3, new p73(this, i3)));
        d73.c.e(getViewLifecycleOwner(), new yh0(3, new p73(this, 4)));
        y3 y3Var3 = this.b;
        y3Var3.getClass();
        ((MaterialButton) y3Var3.h).setOnClickListener(new View.OnClickListener(this) { // from class: n73
            public final /* synthetic */ d83 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i5 = i2;
                d83 d83Var = this.f;
                switch (i5) {
                    case 0:
                        d83Var.q(false);
                        break;
                    case 1:
                        Context contextRequireContext = d83Var.requireContext();
                        contextRequireContext.getClass();
                        vo.F(contextRequireContext, "https://getsurfboard.com/docs/profile-format/overview");
                        break;
                    case 2:
                        d83Var.z.b.a(new String[]{"application/zip", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, "*/*"});
                        break;
                    default:
                        d83Var.q(true);
                        break;
                }
            }
        });
        y3 y3Var4 = this.b;
        y3Var4.getClass();
        ((MaterialButton) y3Var4.f).setOnClickListener(new View.OnClickListener(this) { // from class: n73
            public final /* synthetic */ d83 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i5 = i4;
                d83 d83Var = this.f;
                switch (i5) {
                    case 0:
                        d83Var.q(false);
                        break;
                    case 1:
                        Context contextRequireContext = d83Var.requireContext();
                        contextRequireContext.getClass();
                        vo.F(contextRequireContext, "https://getsurfboard.com/docs/profile-format/overview");
                        break;
                    case 2:
                        d83Var.z.b.a(new String[]{"application/zip", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, "*/*"});
                        break;
                    default:
                        d83Var.q(true);
                        break;
                }
            }
        });
        y3 y3Var5 = this.b;
        y3Var5.getClass();
        ((FloatingActionButton) y3Var5.d).setOnClickListener(new View.OnClickListener(this) { // from class: n73
            public final /* synthetic */ d83 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i5 = i3;
                d83 d83Var = this.f;
                switch (i5) {
                    case 0:
                        d83Var.q(false);
                        break;
                    case 1:
                        Context contextRequireContext = d83Var.requireContext();
                        contextRequireContext.getClass();
                        vo.F(contextRequireContext, "https://getsurfboard.com/docs/profile-format/overview");
                        break;
                    case 2:
                        d83Var.z.b.a(new String[]{"application/zip", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, "*/*"});
                        break;
                    default:
                        d83Var.q(true);
                        break;
                }
            }
        });
        y3 y3Var6 = this.b;
        y3Var6.getClass();
        ((View) y3Var6.i).setOnClickListener(new View.OnClickListener(this) { // from class: n73
            public final /* synthetic */ d83 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i5 = i;
                d83 d83Var = this.f;
                switch (i5) {
                    case 0:
                        d83Var.q(false);
                        break;
                    case 1:
                        Context contextRequireContext = d83Var.requireContext();
                        contextRequireContext.getClass();
                        vo.F(contextRequireContext, "https://getsurfboard.com/docs/profile-format/overview");
                        break;
                    case 2:
                        d83Var.z.b.a(new String[]{"application/zip", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, "*/*"});
                        break;
                    default:
                        d83Var.q(true);
                        break;
                }
            }
        });
        p activity = getActivity();
        if (activity != null && (wu2VarB = activity.b()) != null) {
            wu2VarB.b(this.X);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            final p pVarRequireActivity = requireActivity();
            y3 y3Var7 = this.b;
            y3Var7.getClass();
            RecyclerView recyclerView = (RecyclerView) y3Var7.j;
            String[] strArr = n12.c;
            ArrayList arrayList = new ArrayList();
            jd jdVar = new jd(9, strArr);
            int iB = dy0.b(recyclerView.getContext(), 16);
            TypedArray typedArrayObtainStyledAttributes = recyclerView.getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
            try {
                int color = typedArrayObtainStyledAttributes.getColor(0, -16738680);
                typedArrayObtainStyledAttributes.recycle();
                final dy0 dy0Var = new dy0(recyclerView, jdVar, color, iB);
                final List listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList);
                if (listUnmodifiableList.isEmpty()) {
                    ga5.C(recyclerView, strArr, dy0Var, this, pVarRequireActivity);
                } else {
                    Iterator it = listUnmodifiableList.iterator();
                    while (it.hasNext()) {
                        ga5.C((EditText) it.next(), strArr, dy0Var, this, pVarRequireActivity);
                    }
                    recyclerView.setOnDragListener(new View.OnDragListener() { // from class: ly0
                        @Override // android.view.View.OnDragListener
                        public final boolean onDrag(View view2, DragEvent dragEvent) {
                            qd0 pd0Var;
                            Activity activity2 = pVarRequireActivity;
                            if (dragEvent.getAction() != 3) {
                                return dy0Var.c(view2, dragEvent);
                            }
                            ClipData clipData = dragEvent.getClipData();
                            if (Build.VERSION.SDK_INT >= 31) {
                                pd0Var = new pd0(clipData, 3);
                            } else {
                                rd0 rd0Var = new rd0();
                                rd0Var.b = clipData;
                                rd0Var.c = 3;
                                pd0Var = rd0Var;
                            }
                            td0 td0VarBuild = pd0Var.build();
                            try {
                                ga5.A(activity2, dragEvent);
                                List<EditText> list = listUnmodifiableList;
                                for (EditText editText : list) {
                                    if (editText.hasFocus()) {
                                        wp4.j(editText, td0VarBuild);
                                        return true;
                                    }
                                }
                                wp4.j((View) list.get(0), td0VarBuild);
                                return true;
                            } catch (oy0 unused) {
                                return false;
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        y3 y3Var8 = this.b;
        y3Var8.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var8.a;
        o73 o73Var = new o73(i, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(coordinatorLayout, o73Var);
        y3 y3Var9 = this.b;
        y3Var9.getClass();
        ((RecyclerView) y3Var9.j).j(new z71(i4, this));
    }

    public final void q(boolean z) {
        View view;
        y3 y3Var = this.b;
        if (y3Var == null) {
            return;
        }
        View view2 = z ? (FloatingActionButton) y3Var.d : (FragmentContainerView) y3Var.e;
        if (z) {
            y3Var.getClass();
            view = (FragmentContainerView) y3Var.e;
        } else {
            y3Var.getClass();
            view = (FloatingActionButton) y3Var.d;
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        ti2 ti2Var = new ti2(contextRequireContext, z);
        ti2Var.c1 = 0;
        y3 y3Var2 = this.b;
        y3Var2.getClass();
        ti2Var.Z0 = ((CoordinatorLayout) y3Var2.a).getId();
        ti2Var.z = ContextUtilsKt.getContext().getResources().getInteger(android.R.integer.config_mediumAnimTime);
        ti2Var.A = new ub1();
        ti2Var.P(new yh2());
        ti2Var.d1 = view2;
        ti2Var.e1 = view;
        ti2Var.b(view);
        if (z) {
            ti2Var.g1 = 0.0f;
            ti2Var.h1 = ContextUtilsKt.c(8.0f);
        } else {
            ti2Var.g1 = ContextUtilsKt.c(8.0f);
            ti2Var.h1 = 0.0f;
        }
        ti2Var.a(new it1(2, this, z));
        y3 y3Var3 = this.b;
        y3Var3.getClass();
        ah4.a((CoordinatorLayout) y3Var3.a, ti2Var);
        view2.setVisibility(4);
        view.setVisibility(0);
        y3 y3Var4 = this.b;
        y3Var4.getClass();
        ((View) y3Var4.i).setVisibility(z ? 0 : 8);
        this.X.f(z);
    }
}
