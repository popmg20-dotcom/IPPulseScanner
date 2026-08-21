package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.getsurfboard.R;
import defpackage.a71;
import defpackage.ak1;
import defpackage.bl1;
import defpackage.ca;
import defpackage.cg0;
import defpackage.cp1;
import defpackage.cp3;
import defpackage.d12;
import defpackage.da2;
import defpackage.dg0;
import defpackage.dh3;
import defpackage.dj1;
import defpackage.dv3;
import defpackage.ej1;
import defpackage.ek1;
import defpackage.er1;
import defpackage.f33;
import defpackage.fa2;
import defpackage.fj1;
import defpackage.fk1;
import defpackage.fn;
import defpackage.gj1;
import defpackage.ha0;
import defpackage.hj1;
import defpackage.hp3;
import defpackage.id2;
import defpackage.ih4;
import defpackage.ij1;
import defpackage.in2;
import defpackage.ip3;
import defpackage.j50;
import defpackage.jd2;
import defpackage.jm1;
import defpackage.jp3;
import defpackage.kd2;
import defpackage.kj1;
import defpackage.kp3;
import defpackage.l4;
import defpackage.lk1;
import defpackage.lp3;
import defpackage.lq4;
import defpackage.m4;
import defpackage.mj1;
import defpackage.mk1;
import defpackage.mq4;
import defpackage.on2;
import defpackage.oq4;
import defpackage.p92;
import defpackage.pj1;
import defpackage.pq4;
import defpackage.q54;
import defpackage.q92;
import defpackage.r4;
import defpackage.r92;
import defpackage.st4;
import defpackage.t80;
import defpackage.tj1;
import defpackage.tz3;
import defpackage.wj1;
import defpackage.x4;
import defpackage.xe;
import defpackage.xo1;
import defpackage.yc2;
import defpackage.zo1;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class o implements ComponentCallbacks, View.OnCreateContextMenuListener, da2, pq4, er1, kp3 {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    gj1 mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    mq4 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    u mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    pj1 mHost;
    boolean mInDynamicContainer;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    fa2 mLifecycleRegistry;
    o mParentFragment;
    boolean mPerformedCreateView;
    Handler mPostponedHandler;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    ip3 mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    o mTarget;
    int mTargetRequestCode;
    boolean mTransitioning;
    View mView;
    bl1 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    u mChildFragmentManager = new ak1();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new ej1(this, 0);
    q92 mMaxState = q92.X;
    on2 mViewLifecycleOwnerLiveData = new on2();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<hj1> mOnPreAttachedListeners = new ArrayList<>();
    private final hj1 mSavedStateAttachListener = new k(this);

    public o() {
        h();
    }

    @Deprecated
    public static o instantiate(Context context, String str, Bundle bundle) {
        try {
            o oVar = (o) tj1.c(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return oVar;
            }
            bundle.setClassLoader(oVar.getClass().getClassLoader());
            oVar.setArguments(bundle);
            return oVar;
        } catch (IllegalAccessException e) {
            throw new t80(ha0.o("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new t80(ha0.o("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new t80(ha0.o("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new t80(ha0.o("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        u uVar;
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var != null) {
            gj1Var.s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (uVar = this.mFragmentManager) == null) {
            return;
        }
        h hVarJ = h.j(viewGroup, uVar);
        hVarJ.l();
        if (z) {
            this.mHost.z.post(new f33(10, hVarJ));
        } else {
            hVarJ.e();
        }
        Handler handler = this.mPostponedHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mPostponedDurationRunnable);
            this.mPostponedHandler = null;
        }
    }

    public mj1 createFragmentContainer() {
        return new l(this);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        o oVarG = g(false);
        if (oVarG != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(oVarG);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            oq4 viewModelStore = getViewModelStore();
            viewModelStore.getClass();
            cg0 cg0Var = cg0.b;
            cg0Var.getClass();
            ih4 ih4Var = new ih4(viewModelStore, jd2.c, cg0Var);
            j50 j50VarA = dh3.a(jd2.class);
            String strB = j50VarA.b();
            if (strB == null) {
                xe.k("Local and anonymous classes can not be ViewModels");
                return;
            }
            tz3 tz3Var = ((jd2) ih4Var.a(j50VarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB))).b;
            if (tz3Var.z > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                if (tz3Var.z > 0) {
                    if (tz3Var.d(0) != null) {
                        st4.n();
                        return;
                    }
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(tz3Var.b[0]);
                    printWriter.print(": ");
                    throw null;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.v(ha0.x(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final gj1 e() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var != null) {
            return gj1Var;
        }
        gj1 gj1Var2 = new gj1();
        gj1Var2.i = null;
        Object obj = USE_DEFAULT_TRANSITION;
        gj1Var2.j = obj;
        gj1Var2.k = null;
        gj1Var2.l = obj;
        gj1Var2.m = null;
        gj1Var2.n = obj;
        gj1Var2.q = 1.0f;
        gj1Var2.r = null;
        this.mAnimationInfo = gj1Var2;
        return gj1Var2;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int f() {
        q92 q92Var = this.mMaxState;
        return (q92Var == q92.f || this.mParentFragment == null) ? q92Var.ordinal() : Math.min(q92Var.ordinal(), this.mParentFragment.f());
    }

    public o findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.c.c(str);
    }

    public final o g(boolean z) {
        String str;
        if (z) {
            lk1 lk1Var = mk1.a;
            mk1.b(new zo1(this, "Attempting to get target fragment from fragment " + this));
            mk1.a(this).getClass();
        }
        o oVar = this.mTarget;
        if (oVar != null) {
            return oVar;
        }
        u uVar = this.mFragmentManager;
        if (uVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return uVar.c.b(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final p getActivity() {
        pj1 pj1Var = this.mHost;
        if (pj1Var == null) {
            return null;
        }
        return pj1Var.b;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null || (bool = gj1Var.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null || (bool = gj1Var.o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        gj1Var.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final u getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        xe.q(ha0.l("Fragment ", this, " has not been attached yet."));
        return null;
    }

    public Context getContext() {
        pj1 pj1Var = this.mHost;
        if (pj1Var == null) {
            return null;
        }
        return pj1Var.f;
    }

    @Override // defpackage.er1
    public dg0 getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && u.M(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        in2 in2Var = new in2(0);
        LinkedHashMap linkedHashMap = in2Var.a;
        if (application != null) {
            linkedHashMap.put(lq4.e, application);
        }
        linkedHashMap.put(cp3.a, this);
        linkedHashMap.put(cp3.b, this);
        if (getArguments() != null) {
            linkedHashMap.put(cp3.c, getArguments());
        }
        return in2Var;
    }

    public mq4 getDefaultViewModelProviderFactory() {
        Application application = null;
        if (this.mFragmentManager == null) {
            xe.q("Can't access ViewModels from detached fragment");
            return null;
        }
        mq4 mq4Var = this.mDefaultFactory;
        if (mq4Var != null) {
            return mq4Var;
        }
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && u.M(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        lp3 lp3Var = new lp3(application, this, getArguments());
        this.mDefaultFactory = lp3Var;
        return lp3Var;
    }

    public int getEnterAnim() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return 0;
        }
        return gj1Var.b;
    }

    public Object getEnterTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        return gj1Var.i;
    }

    public dv3 getEnterTransitionCallback() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        gj1Var.getClass();
        return null;
    }

    public int getExitAnim() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return 0;
        }
        return gj1Var.c;
    }

    public Object getExitTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        return gj1Var.k;
    }

    public dv3 getExitTransitionCallback() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        gj1Var.getClass();
        return null;
    }

    public View getFocusedView() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        return gj1Var.r;
    }

    @Deprecated
    public final u getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        pj1 pj1Var = this.mHost;
        if (pj1Var == null) {
            return null;
        }
        return ((kj1) pj1Var).X;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        pj1 pj1Var = this.mHost;
        if (pj1Var == null) {
            xe.q("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
            return null;
        }
        ca caVar = ((kj1) pj1Var).X;
        LayoutInflater layoutInflaterCloneInContext = caVar.getLayoutInflater().cloneInContext(caVar);
        layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f);
        return layoutInflaterCloneInContext;
    }

    @Override // defpackage.da2
    public r92 getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public id2 getLoaderManager() {
        return new kd2(this, getViewModelStore());
    }

    public int getNextTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return 0;
        }
        return gj1Var.f;
    }

    public final o getParentFragment() {
        return this.mParentFragment;
    }

    public final u getParentFragmentManager() {
        u uVar = this.mFragmentManager;
        if (uVar != null) {
            return uVar;
        }
        xe.q(ha0.l("Fragment ", this, " not associated with a fragment manager."));
        return null;
    }

    public boolean getPopDirection() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return false;
        }
        return gj1Var.a;
    }

    public int getPopEnterAnim() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return 0;
        }
        return gj1Var.d;
    }

    public int getPopExitAnim() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return 0;
        }
        return gj1Var.e;
    }

    public float getPostOnViewCreatedAlpha() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return 1.0f;
        }
        return gj1Var.q;
    }

    public Object getReenterTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        Object obj = gj1Var.l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        lk1 lk1Var = mk1.a;
        mk1.b(new xo1(this, "Attempting to get retain instance for fragment " + this));
        mk1.a(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        Object obj = gj1Var.j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // defpackage.kp3
    public final hp3 getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    public Object getSharedElementEnterTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        return gj1Var.m;
    }

    public Object getSharedElementReturnTransition() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return null;
        }
        Object obj = gj1Var.n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        gj1 gj1Var = this.mAnimationInfo;
        return (gj1Var == null || (arrayList = gj1Var.g) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        gj1 gj1Var = this.mAnimationInfo;
        return (gj1Var == null || (arrayList = gj1Var.h) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final o getTargetFragment() {
        return g(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        lk1 lk1Var = mk1.a;
        mk1.b(new zo1(this, "Attempting to get target request code from fragment " + this));
        mk1.a(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public da2 getViewLifecycleOwner() {
        bl1 bl1Var = this.mViewLifecycleOwner;
        if (bl1Var != null) {
            return bl1Var;
        }
        xe.q(ha0.l("Can't access the Fragment View's LifecycleOwner for ", this, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
        return null;
    }

    public yc2 getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // defpackage.pq4
    public oq4 getViewModelStore() {
        if (this.mFragmentManager == null) {
            xe.q("Can't access ViewModels from detached fragment");
            return null;
        }
        if (f() == 1) {
            xe.q("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
            return null;
        }
        HashMap map = this.mFragmentManager.P.d;
        oq4 oq4Var = (oq4) map.get(this.mWho);
        if (oq4Var != null) {
            return oq4Var;
        }
        oq4 oq4Var2 = new oq4();
        map.put(this.mWho, oq4Var2);
        return oq4Var2;
    }

    public final void h() {
        this.mLifecycleRegistry = new fa2(this);
        this.mSavedStateRegistryController = new ip3(new jp3(this, new fn(22, this)));
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        hj1 hj1Var = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            hj1Var.a();
        } else {
            this.mOnPreAttachedListeners.add(hj1Var);
        }
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final dj1 i(m4 m4Var, jm1 jm1Var, l4 l4Var) {
        if (this.mState > 1) {
            xe.q(ha0.l("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
            return null;
        }
        AtomicReference atomicReference = new AtomicReference();
        fj1 fj1Var = new fj1(this, jm1Var, atomicReference, m4Var, l4Var);
        if (this.mState >= 0) {
            fj1Var.a();
        } else {
            this.mOnPreAttachedListeners.add(fj1Var);
        }
        return new dj1(atomicReference);
    }

    public void initState() {
        h();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new ak1();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        u uVar = this.mFragmentManager;
        if (uVar != null) {
            o oVar = this.mParentFragment;
            uVar.getClass();
            if (oVar == null ? false : oVar.isHidden()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            o oVar = this.mParentFragment;
            if (!(oVar == null ? true : oVar.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        gj1 gj1Var = this.mAnimationInfo;
        if (gj1Var == null) {
            return false;
        }
        return gj1Var.s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        u uVar = this.mFragmentManager;
        if (uVar == null) {
            return false;
        }
        return uVar.Q();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.S();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (u.M(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        pj1 pj1Var = this.mHost;
        ca caVar = pj1Var == null ? null : pj1Var.b;
        if (caVar != null) {
            this.mCalled = false;
            onAttach((Activity) caVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState();
        u uVar = this.mChildFragmentManager;
        if (uVar.w >= 1) {
            return;
        }
        uVar.I = false;
        uVar.J = false;
        uVar.P.g = false;
        uVar.u(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        pj1 pj1Var = this.mHost;
        ca caVar = pj1Var == null ? null : pj1Var.b;
        if (caVar != null) {
            this.mCalled = false;
            onInflate((Activity) caVar, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.S();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (u.M(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            Bundle bundle2 = this.mSavedFragmentState;
            restoreViewState(bundle2 != null ? bundle2.getBundle("savedInstanceState") : null);
        }
        this.mSavedFragmentState = null;
        u uVar = this.mChildFragmentManager;
        uVar.I = false;
        uVar.J = false;
        uVar.P.g = false;
        uVar.u(4);
    }

    public void performAttach() {
        Iterator<hj1> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.f);
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.q.iterator();
        while (it2.hasNext()) {
            ((ek1) it2.next()).a(this);
        }
        u uVar = this.mChildFragmentManager;
        uVar.I = false;
        uVar.J = false;
        uVar.P.g = false;
        uVar.u(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.j(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.S();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new m(this));
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.f(p92.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.k(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.S();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new bl1(this, getViewModelStore(), new j(this));
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        bl1 bl1Var = this.mViewLifecycleOwner;
        if (viewOnCreateView == null) {
            if (bl1Var.A == null) {
                this.mViewLifecycleOwner = null;
                return;
            } else {
                xe.q("Called getViewLifecycleOwner() but onCreateView() returned null");
                return;
            }
        }
        bl1Var.c();
        if (u.M(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.mView + " for Fragment " + this);
        }
        View view = this.mView;
        bl1 bl1Var2 = this.mViewLifecycleOwner;
        view.getClass();
        view.setTag(R.id.view_tree_lifecycle_owner, bl1Var2);
        View view2 = this.mView;
        bl1 bl1Var3 = this.mViewLifecycleOwner;
        view2.getClass();
        view2.setTag(R.id.view_tree_view_model_store_owner, bl1Var3);
        View view3 = this.mView;
        bl1 bl1Var4 = this.mViewLifecycleOwner;
        view3.getClass();
        view3.setTag(R.id.view_tree_saved_state_registry_owner, bl1Var4);
        this.mViewLifecycleOwnerLiveData.l(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.l();
        this.mLifecycleRegistry.f(p92.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.u(1);
        if (this.mView != null) {
            bl1 bl1Var = this.mViewLifecycleOwner;
            bl1Var.c();
            if (bl1Var.A.c.compareTo(q92.z) >= 0) {
                this.mViewLifecycleOwner.a(p92.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        oq4 viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        cg0 cg0Var = cg0.b;
        cg0Var.getClass();
        ih4 ih4Var = new ih4(viewModelStore, jd2.c, cg0Var);
        j50 j50VarA = dh3.a(jd2.class);
        String strB = j50VarA.b();
        if (strB == null) {
            xe.k("Local and anonymous classes can not be ViewModels");
            return;
        }
        tz3 tz3Var = ((jd2) ih4Var.a(j50VarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB))).b;
        if (tz3Var.z <= 0) {
            this.mPerformedCreateView = false;
        } else {
            tz3Var.d(0).getClass();
            st4.n();
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onDetach()"));
        }
        u uVar = this.mChildFragmentManager;
        if (uVar.K) {
            return;
        }
        uVar.l();
        this.mChildFragmentManager = new ak1();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.p(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.q(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.u(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(p92.ON_PAUSE);
        }
        this.mLifecycleRegistry.f(p92.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.t(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zP = u.P(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zP) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zP);
            onPrimaryNavigationFragmentChanged(zP);
            u uVar = this.mChildFragmentManager;
            uVar.k0();
            uVar.r(uVar.A);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.S();
        this.mChildFragmentManager.z(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onResume()"));
        }
        fa2 fa2Var = this.mLifecycleRegistry;
        p92 p92Var = p92.ON_RESUME;
        fa2Var.f(p92Var);
        if (this.mView != null) {
            this.mViewLifecycleOwner.A.f(p92Var);
        }
        u uVar = this.mChildFragmentManager;
        uVar.I = false;
        uVar.J = false;
        uVar.P.g = false;
        uVar.u(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
    }

    public void performStart() {
        this.mChildFragmentManager.S();
        this.mChildFragmentManager.z(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onStart()"));
        }
        fa2 fa2Var = this.mLifecycleRegistry;
        p92 p92Var = p92.ON_START;
        fa2Var.f(p92Var);
        if (this.mView != null) {
            this.mViewLifecycleOwner.A.f(p92Var);
        }
        u uVar = this.mChildFragmentManager;
        uVar.I = false;
        uVar.J = false;
        uVar.P.g = false;
        uVar.u(5);
    }

    public void performStop() {
        u uVar = this.mChildFragmentManager;
        uVar.J = true;
        uVar.P.g = true;
        uVar.u(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(p92.ON_STOP);
        }
        this.mLifecycleRegistry.f(p92.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        Bundle bundle = this.mSavedFragmentState;
        onViewCreated(this.mView, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.mChildFragmentManager.u(2);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        e().s = true;
        Handler handler2 = this.mPostponedHandler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.mPostponedDurationRunnable);
        }
        u uVar = this.mFragmentManager;
        if (uVar != null) {
            handler = uVar.x.z;
            this.mPostponedHandler = handler;
        } else {
            handler = new Handler(Looper.getMainLooper());
            this.mPostponedHandler = handler;
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        this.mPostponedHandler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public final <I, O> r4 registerForActivityResult(m4 m4Var, x4 x4Var, l4 l4Var) {
        return i(m4Var, new cp1(29, x4Var), l4Var);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            xe.q(ha0.l("Fragment ", this, " not attached to Activity"));
            return;
        }
        u parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.F == null) {
            parentFragmentManager.x.getClass();
            strArr.getClass();
        } else {
            parentFragmentManager.G.addLast(new wj1(this.mWho, i));
            parentFragmentManager.F.a(strArr);
        }
    }

    public final p requireActivity() {
        p activity = getActivity();
        if (activity != null) {
            return activity;
        }
        xe.q(ha0.l("Fragment ", this, " not attached to an activity."));
        return null;
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        xe.q(ha0.l("Fragment ", this, " does not have any arguments."));
        return null;
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        xe.q(ha0.l("Fragment ", this, " not attached to a context."));
        return null;
    }

    @Deprecated
    public final u requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        xe.q(ha0.l("Fragment ", this, " not attached to a host."));
        return null;
    }

    public final o requireParentFragment() {
        o parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            xe.q(ha0.l("Fragment ", this, " is not attached to any Fragment or host"));
            return null;
        }
        StringBuilder sb = new StringBuilder("Fragment ");
        sb.append(this);
        Context context = getContext();
        sb.append(" is not a child Fragment, it is directly attached to ");
        sb.append(context);
        throw new IllegalStateException(sb.toString());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        xe.q(ha0.l("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
        return null;
    }

    public void restoreChildFragmentState() {
        Bundle bundle;
        Bundle bundle2 = this.mSavedFragmentState;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.mChildFragmentManager.a0(bundle);
        u uVar = this.mChildFragmentManager;
        uVar.I = false;
        uVar.J = false;
        uVar.P.g = false;
        uVar.u(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new q54(ha0.l("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(p92.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        e().p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        e().o = Boolean.valueOf(z);
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        e().b = i;
        e().c = i2;
        e().d = i3;
        e().e = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
        } else {
            xe.q("Fragment already added and state has been saved");
        }
    }

    public void setEnterSharedElementCallback(dv3 dv3Var) {
        e().getClass();
    }

    public void setEnterTransition(Object obj) {
        e().i = obj;
    }

    public void setExitSharedElementCallback(dv3 dv3Var) {
        e().getClass();
    }

    public void setExitTransition(Object obj) {
        e().k = obj;
    }

    public void setFocusedView(View view) {
        e().r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((kj1) this.mHost).X.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(ij1 ij1Var) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            xe.q("Fragment already added");
            return;
        }
        if (ij1Var == null || (bundle = ij1Var.b) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((kj1) this.mHost).X.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        e();
        this.mAnimationInfo.f = i;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        e().a = z;
    }

    public void setPostOnViewCreatedAlpha(float f) {
        e().q = f;
    }

    public void setReenterTransition(Object obj) {
        e().l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        lk1 lk1Var = mk1.a;
        mk1.b(new xo1(this, "Attempting to set retain instance for fragment " + this));
        mk1.a(this).getClass();
        this.mRetainInstance = z;
        u uVar = this.mFragmentManager;
        if (uVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
            return;
        }
        v vVar = uVar.P;
        if (z) {
            vVar.e(this);
        } else {
            vVar.i(this);
        }
    }

    public void setReturnTransition(Object obj) {
        e().j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        e().m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        e();
        gj1 gj1Var = this.mAnimationInfo;
        gj1Var.g = arrayList;
        gj1Var.h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        e().n = obj;
    }

    @Deprecated
    public void setTargetFragment(o oVar, int i) {
        if (oVar != null) {
            lk1 lk1Var = mk1.a;
            mk1.b(new zo1(this, "Attempting to set target fragment " + oVar + " with request code " + i + " for fragment " + this));
            mk1.a(this).getClass();
        }
        u uVar = this.mFragmentManager;
        u uVar2 = oVar != null ? oVar.mFragmentManager : null;
        if (uVar != null && uVar2 != null && uVar != uVar2) {
            xe.k(ha0.l("Fragment ", oVar, " must share the same FragmentManager to be set as a target fragment"));
            return;
        }
        for (o oVarG = oVar; oVarG != null; oVarG = oVarG.g(false)) {
            if (oVarG.equals(this)) {
                a71.h("Setting ", oVar, " as the target of ", this, " would create a target cycle");
                return;
            }
        }
        if (oVar == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || oVar.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = oVar;
        } else {
            this.mTargetWho = oVar.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        lk1 lk1Var = mk1.a;
        mk1.b(new fk1(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        mk1.a(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            u uVar = this.mFragmentManager;
            x xVarG = uVar.g(this);
            o oVar = xVarG.c;
            if (oVar.mDeferStart) {
                if (uVar.b) {
                    uVar.L = true;
                } else {
                    oVar.mDeferStart = false;
                    xVarG.k();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        pj1 pj1Var = this.mHost;
        if (pj1Var != null) {
            ca caVar = ((kj1) pj1Var).X;
            int i = Build.VERSION.SDK_INT;
            if (i >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                if (i >= 32) {
                    return caVar.shouldShowRequestPermissionRationale(str);
                }
                if (i != 31) {
                    return caVar.shouldShowRequestPermissionRationale(str);
                }
                try {
                    return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(caVar.getApplication().getPackageManager(), str)).booleanValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    return caVar.shouldShowRequestPermissionRationale(str);
                }
            }
        }
        return false;
    }

    public void startActivity(Intent intent, Bundle bundle) {
        pj1 pj1Var = this.mHost;
        if (pj1Var == null) {
            xe.q(ha0.l("Fragment ", this, " not attached to Activity"));
        } else {
            intent.getClass();
            pj1Var.f.startActivity(intent, bundle);
        }
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            xe.q(ha0.l("Fragment ", this, " not attached to Activity"));
            return;
        }
        u parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.D != null) {
            parentFragmentManager.G.addLast(new wj1(this.mWho, i));
            if (bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.D.a(intent);
            return;
        }
        pj1 pj1Var = parentFragmentManager.x;
        pj1Var.getClass();
        intent.getClass();
        if (i == -1) {
            pj1Var.f.startActivity(intent, bundle);
        } else {
            xe.q("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (this.mHost == null) {
            xe.q(ha0.l("Fragment ", this, " not attached to Activity"));
            return;
        }
        if (u.M(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        u parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.E == null) {
            pj1 pj1Var = parentFragmentManager.x;
            pj1Var.getClass();
            intentSender.getClass();
            if (i == -1) {
                pj1Var.b.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
                return;
            } else {
                xe.q("Starting intent sender with a requestCode requires a FragmentActivity host");
                return;
            }
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (u.M(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + this);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        intentSender.getClass();
        d12 d12Var = new d12(intentSender, intent, i2, i3);
        parentFragmentManager.G.addLast(new wj1(this.mWho, i));
        if (u.M(2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.E.a(d12Var);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !e().s) {
            return;
        }
        if (this.mHost == null) {
            e().s = false;
        } else if (Looper.myLooper() != this.mHost.z.getLooper()) {
            this.mHost.z.postAtFrontOfQueue(new ej1(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final <I, O> r4 registerForActivityResult(m4 m4Var, l4 l4Var) {
        return i(m4Var, new n(this), l4Var);
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onAttachFragment(o oVar) {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void postponeEnterTransition() {
        e().s = true;
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public static o instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }
}
