package com.getsurfboard.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.viewpager2.widget.ViewPager2;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.tabs.TabLayout;
import defpackage.aa1;
import defpackage.ak1;
import defpackage.ca;
import defpackage.cm2;
import defpackage.d73;
import defpackage.f70;
import defpackage.fi4;
import defpackage.g;
import defpackage.g41;
import defpackage.ha1;
import defpackage.hf4;
import defpackage.ia3;
import defpackage.iv1;
import defpackage.ja3;
import defpackage.ka3;
import defpackage.l72;
import defpackage.la3;
import defpackage.ma1;
import defpackage.ma3;
import defpackage.mk;
import defpackage.mp4;
import defpackage.n12;
import defpackage.na1;
import defpackage.na3;
import defpackage.oa1;
import defpackage.ps1;
import defpackage.r25;
import defpackage.rf3;
import defpackage.rs1;
import defpackage.sk2;
import defpackage.sm3;
import defpackage.ss1;
import defpackage.t53;
import defpackage.tn3;
import defpackage.v9;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.wt2;
import defpackage.zo2;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ExternalResourcesManagerActivity extends ca implements hf4 {
    public static final /* synthetic */ int T0 = 0;
    public iv1 S0;

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) throws NoSuchAlgorithmException {
        ma1 ma1Var;
        String strA;
        String strA2;
        iv1 iv1Var = this.S0;
        if (iv1Var == null) {
            n12.T("binding");
            throw null;
        }
        ViewPager2 viewPager2 = (ViewPager2) iv1Var.z;
        ak1 ak1VarU = u();
        int currentItem = viewPager2.getCurrentItem();
        rf3 adapter = viewPager2.getAdapter();
        if (adapter == null || adapter.b() == 0) {
            ma1Var = null;
        } else {
            long jC = adapter.c(currentItem);
            if (jC == -1) {
                jC = currentItem;
            }
            o oVarD = ak1VarU.D("f" + jC);
            if (!(oVarD instanceof ma1)) {
                oVarD = null;
            }
            ma1Var = (ma1) oVarD;
        }
        int i = sk2Var.a;
        int i2 = 0;
        if (i != R.id.update_all) {
            if (i != R.id.delete_all_unused) {
                return false;
            }
            if (ma1Var != null) {
                fi4 fi4Var = ma1Var.A;
                if (fi4Var == null) {
                    n12.T("type");
                    throw null;
                }
                int iOrdinal = fi4Var.ordinal();
                if (iOrdinal == 0) {
                    HashSet hashSet = new HashSet();
                    List list = (List) d73.b.d();
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (obj instanceof t53) {
                                arrayList.add(obj);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Collection<na3> collectionValues = ((t53) it.next()).H0.values();
                            collectionValues.getClass();
                            for (na3 na3Var : collectionValues) {
                                Collection collection = na3Var instanceof ka3 ? ((ka3) na3Var).z : na3Var instanceof ma3 ? ((ma3) na3Var).z : na3Var instanceof ia3 ? ((ia3) na3Var).z : na3Var instanceof ja3 ? ((ja3) na3Var).z : na3Var instanceof la3 ? ((la3) na3Var).X : null;
                                if (collection == null) {
                                    collection = g41.b;
                                }
                                hashSet.addAll(collection);
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(f70.Q(10, hashSet));
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(r25.K((String) it2.next()) + ".conf");
                    }
                    File[] fileArrListFiles = new File(ContextUtilsKt.getContext().getFilesDir(), "policy_path").listFiles();
                    if (fileArrListFiles != null) {
                        int length = fileArrListFiles.length;
                        int i3 = 0;
                        while (i2 < length) {
                            File file = fileArrListFiles[i2];
                            if (!arrayList2.contains(file.getName())) {
                                file.delete();
                                i3++;
                            }
                            i2++;
                        }
                        i2 = i3;
                    }
                    cm2 cm2Var = ma1Var.b;
                    cm2Var.getClass();
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) cm2Var.f;
                    coordinatorLayout.getClass();
                    r25.Q(coordinatorLayout, R.plurals.policy_path_deleted, i2);
                    return true;
                }
                if (iOrdinal == 1) {
                    HashSet hashSet2 = new HashSet();
                    List list2 = (List) d73.b.d();
                    if (list2 != null) {
                        ArrayList<t53> arrayList3 = new ArrayList();
                        for (Object obj2 : list2) {
                            if (obj2 instanceof t53) {
                                arrayList3.add(obj2);
                            }
                        }
                        for (t53 t53Var : arrayList3) {
                            for (tn3 tn3Var : t53Var.J0) {
                                if (tn3Var.getType().equals("RULE-SET")) {
                                    sm3 sm3Var = tn3Var instanceof sm3 ? (sm3) tn3Var : null;
                                    if (sm3Var != null && (strA = sm3Var.a()) != null) {
                                        hashSet2.add(strA);
                                    }
                                }
                            }
                            Set<ss1> setKeySet = t53Var.F0.keySet();
                            setKeySet.getClass();
                            for (ss1 ss1Var : setKeySet) {
                                if (ss1Var instanceof rs1) {
                                    hashSet2.add(((rs1) ss1Var).f);
                                }
                            }
                        }
                    }
                    ArrayList arrayList4 = new ArrayList(f70.Q(10, hashSet2));
                    Iterator it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        arrayList4.add(r25.K((String) it3.next()) + ".conf");
                    }
                    File[] fileArrListFiles2 = new File(ContextUtilsKt.getContext().getFilesDir(), "rule_set").listFiles();
                    if (fileArrListFiles2 != null) {
                        int length2 = fileArrListFiles2.length;
                        int i4 = 0;
                        while (i2 < length2) {
                            File file2 = fileArrListFiles2[i2];
                            if (!arrayList4.contains(file2.getName())) {
                                file2.delete();
                                i4++;
                            }
                            i2++;
                        }
                        i2 = i4;
                    }
                    cm2 cm2Var2 = ma1Var.b;
                    cm2Var2.getClass();
                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) cm2Var2.f;
                    coordinatorLayout2.getClass();
                    r25.Q(coordinatorLayout2, R.plurals.rule_set_deleted, i2);
                    return true;
                }
                if (iOrdinal != 2) {
                    g.d();
                    return false;
                }
                HashSet hashSet3 = new HashSet();
                List list3 = (List) d73.b.d();
                if (list3 != null) {
                    ArrayList<t53> arrayList5 = new ArrayList();
                    for (Object obj3 : list3) {
                        if (obj3 instanceof t53) {
                            arrayList5.add(obj3);
                        }
                    }
                    for (t53 t53Var2 : arrayList5) {
                        for (tn3 tn3Var2 : t53Var2.J0) {
                            if (tn3Var2.getType().equals("DOMAIN-SET")) {
                                sm3 sm3Var2 = tn3Var2 instanceof sm3 ? (sm3) tn3Var2 : null;
                                if (sm3Var2 != null && (strA2 = sm3Var2.a()) != null) {
                                    hashSet3.add(strA2);
                                }
                            }
                        }
                        Set<ss1> setKeySet2 = t53Var2.F0.keySet();
                        setKeySet2.getClass();
                        for (ss1 ss1Var2 : setKeySet2) {
                            if (ss1Var2 instanceof ps1) {
                                hashSet3.add(((ps1) ss1Var2).b.b);
                            }
                        }
                    }
                }
                ArrayList arrayList6 = new ArrayList(f70.Q(10, hashSet3));
                Iterator it4 = hashSet3.iterator();
                while (it4.hasNext()) {
                    arrayList6.add(r25.K((String) it4.next()) + ".conf");
                }
                File[] fileArrListFiles3 = new File(ContextUtilsKt.getContext().getFilesDir(), "domain_set").listFiles();
                if (fileArrListFiles3 != null) {
                    int length3 = fileArrListFiles3.length;
                    int i5 = 0;
                    while (i2 < length3) {
                        File file3 = fileArrListFiles3[i2];
                        if (!arrayList6.contains(file3.getName())) {
                            file3.delete();
                            i5++;
                        }
                        i2++;
                    }
                    i2 = i5;
                }
                cm2 cm2Var3 = ma1Var.b;
                cm2Var3.getClass();
                CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) cm2Var3.f;
                coordinatorLayout3.getClass();
                r25.Q(coordinatorLayout3, R.plurals.domain_set_deleted, i2);
                return true;
            }
        } else if (ma1Var != null) {
            cm2 cm2Var4 = ma1Var.b;
            cm2Var4.getClass();
            CoordinatorLayout coordinatorLayout4 = (CoordinatorLayout) cm2Var4.f;
            coordinatorLayout4.getClass();
            r25.R(coordinatorLayout4, R.string.fetching, new Object[0]);
            List<aa1> list4 = ma1Var.z.d.f;
            list4.getClass();
            for (aa1 aa1Var : list4) {
                ha1 ha1Var = ma1Var.f;
                aa1Var.getClass();
                ha1Var.C(aa1Var, true);
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_external_resources_manager, (ViewGroup) null, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.pager;
            ViewPager2 viewPager2 = (ViewPager2) vf2.l(viewInflate, R.id.pager);
            if (viewPager2 != null) {
                i = R.id.tabs;
                TabLayout tabLayout = (TabLayout) vf2.l(viewInflate, R.id.tabs);
                if (tabLayout != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                    if (toolbar != null) {
                        i = R.id.toolbar_divider;
                        if (((MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider)) != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                            this.S0 = new iv1(coordinatorLayout, viewPager2, tabLayout, toolbar, 1);
                            setContentView(coordinatorLayout);
                            iv1 iv1Var = this.S0;
                            if (iv1Var == null) {
                                n12.T("binding");
                                throw null;
                            }
                            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) iv1Var.f;
                            na1 na1Var = new na1(this);
                            WeakHashMap weakHashMap = wp4.a;
                            mp4.c(coordinatorLayout2, na1Var);
                            iv1 iv1Var2 = this.S0;
                            if (iv1Var2 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) iv1Var2.X).setNavigationOnClickListener(new mk(10, this));
                            iv1 iv1Var3 = this.S0;
                            if (iv1Var3 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) iv1Var3.X).getMenu().clear();
                            iv1 iv1Var4 = this.S0;
                            if (iv1Var4 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) iv1Var4.X).o(R.menu.external_resources);
                            iv1 iv1Var5 = this.S0;
                            if (iv1Var5 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((Toolbar) iv1Var5.X).setOnMenuItemClickListener(this);
                            iv1 iv1Var6 = this.S0;
                            if (iv1Var6 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            ((ViewPager2) iv1Var6.z).setAdapter(new oa1(u(), this.b));
                            iv1 iv1Var7 = this.S0;
                            if (iv1Var7 != null) {
                                new wt2((TabLayout) iv1Var7.A, (ViewPager2) iv1Var7.z, new na1(this)).a();
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
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
