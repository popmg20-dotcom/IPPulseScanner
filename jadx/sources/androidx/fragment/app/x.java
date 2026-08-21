package androidx.fragment.app;

import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import defpackage.a71;
import defpackage.c20;
import defpackage.eg0;
import defpackage.fk1;
import defpackage.fw;
import defpackage.ha0;
import defpackage.lk1;
import defpackage.mk1;
import defpackage.pj1;
import defpackage.pq4;
import defpackage.q92;
import defpackage.tj1;
import defpackage.wp4;
import defpackage.wz3;
import defpackage.xe;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    public final eg0 a;
    public final y b;
    public final o c;
    public boolean d = false;
    public int e = -1;

    public x(eg0 eg0Var, y yVar, ClassLoader classLoader, tj1 tj1Var, Bundle bundle) {
        this.a = eg0Var;
        this.b = yVar;
        w wVar = (w) bundle.getParcelable("state");
        o oVarA = tj1Var.a(wVar.b);
        oVarA.mWho = wVar.f;
        oVarA.mFromLayout = wVar.z;
        oVarA.mInDynamicContainer = wVar.A;
        oVarA.mRestored = true;
        oVarA.mFragmentId = wVar.X;
        oVarA.mContainerId = wVar.Y;
        oVarA.mTag = wVar.Z;
        oVarA.mRetainInstance = wVar.y0;
        oVarA.mRemoving = wVar.z0;
        oVarA.mDetached = wVar.A0;
        oVarA.mHidden = wVar.B0;
        oVarA.mMaxState = q92.values()[wVar.C0];
        oVarA.mTargetWho = wVar.D0;
        oVarA.mTargetRequestCode = wVar.E0;
        oVarA.mUserVisibleHint = wVar.F0;
        this.c = oVarA;
        oVarA.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        oVarA.setArguments(bundle2);
        if (u.M(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + oVarA);
        }
    }

    public final void a() {
        boolean zM = u.M(3);
        o oVar = this.c;
        if (zM) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + oVar);
        }
        Bundle bundle = oVar.mSavedFragmentState;
        oVar.performActivityCreated(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.a.v(oVar, false);
    }

    public final void b() {
        o oVar;
        View view;
        View view2;
        o oVar2 = this.c;
        View view3 = oVar2.mContainer;
        while (true) {
            oVar = null;
            if (view3 == null) {
                break;
            }
            Object tag = view3.getTag(R.id.fragment_container_view_tag);
            o oVar3 = tag instanceof o ? (o) tag : null;
            if (oVar3 != null) {
                oVar = oVar3;
                break;
            } else {
                Object parent = view3.getParent();
                view3 = parent instanceof View ? (View) parent : null;
            }
        }
        o parentFragment = oVar2.getParentFragment();
        if (oVar != null && !oVar.equals(parentFragment)) {
            int i = oVar2.mContainerId;
            lk1 lk1Var = mk1.a;
            StringBuilder sb = new StringBuilder("Attempting to nest fragment ");
            sb.append(oVar2);
            sb.append(" within the view of parent fragment ");
            sb.append(oVar);
            sb.append(" via container with ID ");
            mk1.b(new fk1(oVar2, fw.w(" without using parent's childFragmentManager", sb, i)));
            mk1.a(oVar2).getClass();
        }
        ArrayList arrayList = this.b.a;
        ViewGroup viewGroup = oVar2.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(oVar2);
            int i2 = iIndexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        o oVar4 = (o) arrayList.get(iIndexOf);
                        if (oVar4.mContainer == viewGroup && (view = oVar4.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    o oVar5 = (o) arrayList.get(i2);
                    if (oVar5.mContainer == viewGroup && (view2 = oVar5.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        oVar2.mContainer.addView(oVar2.mView, iIndexOfChild);
    }

    public final void c() {
        boolean zM = u.M(3);
        o oVar = this.c;
        if (zM) {
            Log.d("FragmentManager", "moveto ATTACHED: " + oVar);
        }
        o oVar2 = oVar.mTarget;
        x xVar = null;
        y yVar = this.b;
        if (oVar2 != null) {
            x xVar2 = (x) yVar.b.get(oVar2.mWho);
            if (xVar2 == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(oVar);
                o oVar3 = oVar.mTarget;
                sb.append(" declared target fragment ");
                sb.append(oVar3);
                sb.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb.toString());
            }
            oVar.mTargetWho = oVar.mTarget.mWho;
            oVar.mTarget = null;
            xVar = xVar2;
        } else {
            String str = oVar.mTargetWho;
            if (str != null && (xVar = (x) yVar.b.get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(oVar);
                sb2.append(" declared target fragment ");
                xe.q(fw.y(sb2, oVar.mTargetWho, " that does not belong to this FragmentManager!"));
                return;
            }
        }
        if (xVar != null) {
            xVar.k();
        }
        u uVar = oVar.mFragmentManager;
        oVar.mHost = uVar.x;
        oVar.mParentFragment = uVar.z;
        eg0 eg0Var = this.a;
        eg0Var.B(oVar, false);
        oVar.performAttach();
        eg0Var.w(oVar, false);
    }

    public final int d() {
        o oVar = this.c;
        if (oVar.mFragmentManager == null) {
            return oVar.mState;
        }
        int iMin = this.e;
        int iOrdinal = oVar.mMaxState.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (oVar.mFromLayout) {
            boolean z = oVar.mInLayout;
            int i = this.e;
            if (z) {
                iMin = Math.max(i, 2);
                View view = oVar.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = i < 4 ? Math.min(iMin, oVar.mState) : Math.min(iMin, 1);
            }
        }
        if (oVar.mInDynamicContainer && oVar.mContainer == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!oVar.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = oVar.mContainer;
        if (viewGroup != null) {
            h hVarJ = h.j(viewGroup, oVar.getParentFragmentManager());
            a0 a0VarG = hVarJ.g(oVar);
            int i2 = a0VarG != null ? a0VarG.b : 0;
            a0 a0VarH = hVarJ.h(oVar);
            i = a0VarH != null ? a0VarH.b : 0;
            int i3 = i2 == 0 ? -1 : wz3.a[fw.G(i2)];
            if (i3 != -1 && i3 != 1) {
                i = i2;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (oVar.mRemoving) {
            iMin = oVar.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (oVar.mDeferStart && oVar.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (oVar.mTransitioning) {
            iMin = Math.max(iMin, 3);
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + oVar);
        }
        return iMin;
    }

    public final void e() {
        boolean zM = u.M(3);
        o oVar = this.c;
        if (zM) {
            Log.d("FragmentManager", "moveto CREATED: " + oVar);
        }
        Bundle bundle = oVar.mSavedFragmentState;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        if (oVar.mIsCreated) {
            oVar.mState = 1;
            oVar.restoreChildFragmentState();
        } else {
            eg0 eg0Var = this.a;
            eg0Var.C(oVar, false);
            oVar.performCreate(bundle2);
            eg0Var.x(oVar, bundle2, false);
        }
    }

    public final void f() {
        String resourceName;
        o oVar = this.c;
        if (oVar.mFromLayout) {
            return;
        }
        if (u.M(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + oVar);
        }
        Bundle bundle = oVar.mSavedFragmentState;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = oVar.performGetLayoutInflater(bundle2);
        ViewGroup viewGroup2 = oVar.mContainer;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = oVar.mContainerId;
            if (i != 0) {
                if (i == -1) {
                    xe.k(ha0.l("Cannot create fragment ", oVar, " for a container view with no id"));
                    return;
                }
                viewGroup = (ViewGroup) oVar.mFragmentManager.y.e(i);
                if (viewGroup == null) {
                    if (!oVar.mRestored && !oVar.mInDynamicContainer) {
                        try {
                            resourceName = oVar.getResources().getResourceName(oVar.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        a71.i("No view found for id 0x", Integer.toHexString(oVar.mContainerId), " (", resourceName, ") for fragment ", oVar);
                        return;
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    lk1 lk1Var = mk1.a;
                    mk1.b(new fk1(oVar, "Attempting to add fragment " + oVar + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    mk1.a(oVar).getClass();
                }
            }
        }
        oVar.mContainer = viewGroup;
        oVar.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, bundle2);
        int i2 = 2;
        if (oVar.mView != null) {
            if (u.M(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + oVar);
            }
            oVar.mView.setSaveFromParentEnabled(false);
            oVar.mView.setTag(R.id.fragment_container_view_tag, oVar);
            if (viewGroup != null) {
                b();
            }
            if (oVar.mHidden) {
                oVar.mView.setVisibility(8);
            }
            boolean zIsAttachedToWindow = oVar.mView.isAttachedToWindow();
            View view = oVar.mView;
            if (zIsAttachedToWindow) {
                WeakHashMap weakHashMap = wp4.a;
                view.requestApplyInsets();
            } else {
                view.addOnAttachStateChangeListener(new c20(i2, view));
            }
            oVar.performViewCreated();
            this.a.H(oVar, oVar.mView, bundle2, false);
            int visibility = oVar.mView.getVisibility();
            oVar.setPostOnViewCreatedAlpha(oVar.mView.getAlpha());
            if (oVar.mContainer != null && visibility == 0) {
                View viewFindFocus = oVar.mView.findFocus();
                if (viewFindFocus != null) {
                    oVar.setFocusedView(viewFindFocus);
                    if (u.M(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + oVar);
                    }
                }
                oVar.mView.setAlpha(0.0f);
            }
        }
        oVar.mState = 2;
    }

    public final void g() {
        o oVarB;
        boolean zM = u.M(3);
        o oVar = this.c;
        if (zM) {
            Log.d("FragmentManager", "movefrom CREATED: " + oVar);
        }
        boolean z = oVar.mRemoving && !oVar.isInBackStack();
        y yVar = this.b;
        if (z && !oVar.mBeingSaved) {
            yVar.i(null, oVar.mWho);
        }
        if (!z) {
            v vVar = yVar.d;
            if (!((vVar.b.containsKey(oVar.mWho) && vVar.e) ? vVar.f : true)) {
                String str = oVar.mTargetWho;
                if (str != null && (oVarB = yVar.b(str)) != null && oVarB.mRetainInstance) {
                    oVar.mTarget = oVarB;
                }
                oVar.mState = 0;
                return;
            }
        }
        pj1 pj1Var = oVar.mHost;
        boolean zIsChangingConfigurations = pj1Var instanceof pq4 ? yVar.d.f : true ^ pj1Var.f.isChangingConfigurations();
        if ((z && !oVar.mBeingSaved) || zIsChangingConfigurations) {
            yVar.d.f(oVar, false);
        }
        oVar.performDestroy();
        this.a.y(oVar, false);
        for (x xVar : yVar.d()) {
            if (xVar != null) {
                o oVar2 = xVar.c;
                if (oVar.mWho.equals(oVar2.mTargetWho)) {
                    oVar2.mTarget = oVar;
                    oVar2.mTargetWho = null;
                }
            }
        }
        String str2 = oVar.mTargetWho;
        if (str2 != null) {
            oVar.mTarget = yVar.b(str2);
        }
        yVar.h(this);
    }

    public final void h() {
        View view;
        boolean zM = u.M(3);
        o oVar = this.c;
        if (zM) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + oVar);
        }
        ViewGroup viewGroup = oVar.mContainer;
        if (viewGroup != null && (view = oVar.mView) != null) {
            viewGroup.removeView(view);
        }
        oVar.performDestroyView();
        this.a.J(oVar, false);
        oVar.mContainer = null;
        oVar.mView = null;
        oVar.mViewLifecycleOwner = null;
        oVar.mViewLifecycleOwnerLiveData.l(null);
        oVar.mInLayout = false;
    }

    public final void i() {
        boolean zM = u.M(3);
        o oVar = this.c;
        if (zM) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + oVar);
        }
        oVar.performDetach();
        this.a.z(oVar, false);
        oVar.mState = -1;
        oVar.mHost = null;
        oVar.mParentFragment = null;
        oVar.mFragmentManager = null;
        if (!oVar.mRemoving || oVar.isInBackStack()) {
            v vVar = this.b.d;
            if (!((vVar.b.containsKey(oVar.mWho) && vVar.e) ? vVar.f : true)) {
                return;
            }
        }
        if (u.M(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + oVar);
        }
        oVar.initState();
    }

    public final void j() {
        o oVar = this.c;
        if (oVar.mFromLayout && oVar.mInLayout && !oVar.mPerformedCreateView) {
            if (u.M(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + oVar);
            }
            Bundle bundle = oVar.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            oVar.performCreateView(oVar.performGetLayoutInflater(bundle2), null, bundle2);
            View view = oVar.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                oVar.mView.setTag(R.id.fragment_container_view_tag, oVar);
                if (oVar.mHidden) {
                    oVar.mView.setVisibility(8);
                }
                oVar.performViewCreated();
                this.a.H(oVar, oVar.mView, bundle2, false);
                oVar.mState = 2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x01a9, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.x.k():void");
    }

    public final void l(ClassLoader classLoader) {
        o oVar = this.c;
        Bundle bundle = oVar.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (oVar.mSavedFragmentState.getBundle("savedInstanceState") == null) {
            oVar.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
        }
        try {
            oVar.mSavedViewState = oVar.mSavedFragmentState.getSparseParcelableArray("viewState");
            oVar.mSavedViewRegistryState = oVar.mSavedFragmentState.getBundle("viewRegistryState");
            w wVar = (w) oVar.mSavedFragmentState.getParcelable("state");
            if (wVar != null) {
                oVar.mTargetWho = wVar.D0;
                oVar.mTargetRequestCode = wVar.E0;
                Boolean bool = oVar.mSavedUserVisibleHint;
                if (bool != null) {
                    oVar.mUserVisibleHint = bool.booleanValue();
                    oVar.mSavedUserVisibleHint = null;
                } else {
                    oVar.mUserVisibleHint = wVar.F0;
                }
            }
            if (oVar.mUserVisibleHint) {
                return;
            }
            oVar.mDeferStart = true;
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + oVar, e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r6 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.u.M(r0)
            java.lang.String r1 = "FragmentManager"
            androidx.fragment.app.o r2 = r6.c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            android.view.View r0 = r2.getFocusedView()
            if (r0 == 0) goto L78
            android.view.View r3 = r2.mView
            if (r0 != r3) goto L27
            goto L31
        L27:
            android.view.ViewParent r3 = r0.getParent()
        L2b:
            if (r3 == 0) goto L78
            android.view.View r4 = r2.mView
            if (r3 != r4) goto L73
        L31:
            boolean r3 = r0.requestFocus()
            r4 = 2
            boolean r4 = androidx.fragment.app.u.M(r4)
            if (r4 == 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "requestFocus: Restoring focused view "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            if (r3 == 0) goto L50
            java.lang.String r0 = "succeeded"
            goto L52
        L50:
            java.lang.String r0 = "failed"
        L52:
            r4.append(r0)
            java.lang.String r0 = " on Fragment "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r4.append(r0)
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.v(r1, r0)
            goto L78
        L73:
            android.view.ViewParent r3 = r3.getParent()
            goto L2b
        L78:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            eg0 r1 = r6.a
            r3 = 0
            r1.D(r2, r3)
            androidx.fragment.app.y r6 = r6.b
            java.lang.String r1 = r2.mWho
            r6.i(r0, r1)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.x.m():void");
    }

    public final Bundle n() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        o oVar = this.c;
        if (oVar.mState == -1 && (bundle = oVar.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new w(oVar));
        if (oVar.mState > 0) {
            Bundle bundle3 = new Bundle();
            oVar.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.E(oVar, bundle3, false);
            Bundle bundle4 = new Bundle();
            oVar.mSavedStateRegistryController.b(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleB0 = oVar.mChildFragmentManager.b0();
            if (!bundleB0.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleB0);
            }
            if (oVar.mView != null) {
                o();
            }
            SparseArray<Parcelable> sparseArray = oVar.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = oVar.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = oVar.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public final void o() {
        o oVar = this.c;
        if (oVar.mView == null) {
            return;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + oVar + " with view " + oVar.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        oVar.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            oVar.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        oVar.mViewLifecycleOwner.X.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        oVar.mSavedViewRegistryState = bundle;
    }

    public x(eg0 eg0Var, y yVar, o oVar) {
        this.a = eg0Var;
        this.b = yVar;
        this.c = oVar;
    }

    public x(eg0 eg0Var, y yVar, o oVar, Bundle bundle) {
        this.a = eg0Var;
        this.b = yVar;
        this.c = oVar;
        oVar.mSavedViewState = null;
        oVar.mSavedViewRegistryState = null;
        oVar.mBackStackNesting = 0;
        oVar.mInLayout = false;
        oVar.mAdded = false;
        o oVar2 = oVar.mTarget;
        oVar.mTargetWho = oVar2 != null ? oVar2.mWho : null;
        oVar.mTarget = null;
        oVar.mSavedFragmentState = bundle;
        oVar.mArguments = bundle.getBundle("arguments");
    }
}
