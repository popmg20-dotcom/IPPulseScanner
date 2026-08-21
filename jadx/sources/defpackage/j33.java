package defpackage;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a;
import androidx.fragment.app.i;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class j33 extends o {
    public static final String ARG_PREFERENCE_ROOT = "androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT";
    private static final String DIALOG_FRAGMENT_TAG = "androidx.preference.PreferenceFragment.DIALOG";
    private static final int MSG_BIND_PREFERENCES = 1;
    private static final String PREFERENCES_TAG = "android:preferences";
    private static final String TAG = "PreferenceFragment";
    private boolean mHavePrefs;
    private boolean mInitDone;
    RecyclerView mList;
    private r33 mPreferenceManager;
    private Runnable mSelectPreferenceRunnable;
    private final h33 mDividerDecoration = new h33(this);
    private int mLayoutResId = R.layout.preference_list_fragment;
    private final Handler mHandler = new q6(this, Looper.getMainLooper());
    private final Runnable mRequestFocus = new f33(0, this);

    public void addPreferencesFromResource(int i) {
        r33 r33Var = this.mPreferenceManager;
        if (r33Var != null) {
            setPreferenceScreen(r33Var.d(requireContext(), i, getPreferenceScreen()));
        } else {
            zo2.w("This should be called after super.onCreate.");
        }
    }

    public void bindPreferences() {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            getListView().setAdapter(onCreateAdapter(preferenceScreen));
            preferenceScreen.k();
        }
        onBindPreferences();
    }

    public <T extends Preference> T findPreference(CharSequence charSequence) {
        PreferenceScreen preferenceScreen;
        r33 r33Var = this.mPreferenceManager;
        if (r33Var == null || (preferenceScreen = r33Var.g) == null) {
            return null;
        }
        return (T) preferenceScreen.A(charSequence);
    }

    public o getCallbackFragment() {
        return null;
    }

    public final RecyclerView getListView() {
        return this.mList;
    }

    public r33 getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceManager.g;
    }

    @Override // androidx.fragment.app.o
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = R.style.PreferenceThemeOverlay;
        }
        requireContext().getTheme().applyStyle(i, false);
        r33 r33Var = new r33(requireContext());
        this.mPreferenceManager = r33Var;
        r33Var.j = this;
        onCreatePreferences(bundle, getArguments() != null ? getArguments().getString(ARG_PREFERENCE_ROOT) : null);
    }

    public rf3 onCreateAdapter(PreferenceScreen preferenceScreen) {
        return new m33(preferenceScreen);
    }

    public ag3 onCreateLayoutManager() {
        return new LinearLayoutManager(requireContext());
    }

    public abstract void onCreatePreferences(Bundle bundle, String str);

    public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(onCreateLayoutManager());
        recyclerView2.setAccessibilityDelegateCompat(new s33(recyclerView2));
        return recyclerView2;
    }

    @Override // androidx.fragment.app.o
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = requireContext().obtainStyledAttributes(null, ad3.h, R.attr.preferenceFragmentCompatStyle, 0);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(0, this.mLayoutResId);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(3, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(requireContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.mLayoutResId, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(android.R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            xe.q("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewOnCreateRecyclerView = onCreateRecyclerView(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewOnCreateRecyclerView == null) {
            zo2.w("Could not create RecyclerView");
            return null;
        }
        this.mList = recyclerViewOnCreateRecyclerView;
        recyclerViewOnCreateRecyclerView.i(this.mDividerDecoration);
        setDivider(drawable);
        if (dimensionPixelSize != -1) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mDividerDecoration.c = z;
        if (this.mList.getParent() == null) {
            viewGroup2.addView(this.mList);
        }
        this.mHandler.post(this.mRequestFocus);
        return viewInflate;
    }

    @Override // androidx.fragment.app.o
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.mRequestFocus);
        this.mHandler.removeMessages(1);
        if (this.mHavePrefs) {
            getListView().setAdapter(null);
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (preferenceScreen != null) {
                preferenceScreen.o();
            }
            onUnbindPreferences();
        }
        this.mList = null;
        super.onDestroyView();
    }

    public void onDisplayPreferenceDialog(Preference preference) {
        i cn2Var;
        getCallbackFragment();
        for (o parentFragment = this; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
        }
        getContext();
        getActivity();
        if (getParentFragmentManager().D(DIALOG_FRAGMENT_TAG) != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            String str = preference.C0;
            cn2Var = new n01();
            Bundle bundle = new Bundle(1);
            bundle.putString("key", str);
            cn2Var.setArguments(bundle);
        } else if (preference instanceof ListPreference) {
            String str2 = preference.C0;
            cn2Var = new kc2();
            Bundle bundle2 = new Bundle(1);
            bundle2.putString("key", str2);
            cn2Var.setArguments(bundle2);
        } else {
            if (!(preference instanceof MultiSelectListPreference)) {
                xe.r("Cannot display dialog for an unknown Preference type: ", preference.getClass().getSimpleName(), ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                return;
            }
            String str3 = preference.C0;
            cn2Var = new cn2();
            Bundle bundle3 = new Bundle(1);
            bundle3.putString("key", str3);
            cn2Var.setArguments(bundle3);
        }
        cn2Var.setTargetFragment(this, 0);
        cn2Var.m(getParentFragmentManager(), DIALOG_FRAGMENT_TAG);
    }

    public void onNavigateToScreen(PreferenceScreen preferenceScreen) {
        getCallbackFragment();
        for (o parentFragment = this; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
        }
        getContext();
        getActivity();
    }

    public boolean onPreferenceTreeClick(Preference preference) {
        if (preference.E0 == null) {
            return false;
        }
        boolean zK = getCallbackFragment() instanceof p33 ? ((p33) getCallbackFragment()).k(this, preference) : false;
        for (o parentFragment = this; !zK && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof p33) {
                zK = ((p33) parentFragment).k(this, preference);
            }
        }
        if (!zK) {
            getContext();
        }
        if (!zK) {
            getActivity();
        }
        if (!zK) {
            a1.n(TAG, "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
            u parentFragmentManager = getParentFragmentManager();
            Bundle bundleD = preference.d();
            tj1 tj1VarJ = parentFragmentManager.J();
            requireActivity().getClassLoader();
            o oVarA = tj1VarJ.a(preference.E0);
            oVarA.setArguments(bundleD);
            oVarA.setTargetFragment(this, 0);
            a aVar = new a(parentFragmentManager);
            aVar.k(oVarA, ((View) requireView().getParent()).getId());
            if (!aVar.h) {
                xe.q("This FragmentTransaction is not allowed to be added to the back stack.");
                return false;
            }
            aVar.g = true;
            aVar.i = null;
            aVar.e();
        }
        return true;
    }

    @Override // androidx.fragment.app.o
    public void onSaveInstanceState(Bundle bundle) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreen.c(bundle2);
            bundle.putBundle(PREFERENCES_TAG, bundle2);
        }
    }

    @Override // androidx.fragment.app.o
    public void onStart() {
        super.onStart();
        r33 r33Var = this.mPreferenceManager;
        r33Var.h = this;
        r33Var.i = this;
    }

    @Override // androidx.fragment.app.o
    public void onStop() {
        super.onStop();
        r33 r33Var = this.mPreferenceManager;
        r33Var.h = null;
        r33Var.i = null;
    }

    @Override // androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreen;
        if (bundle != null && (bundle2 = bundle.getBundle(PREFERENCES_TAG)) != null && (preferenceScreen = getPreferenceScreen()) != null) {
            preferenceScreen.b(bundle2);
        }
        if (this.mHavePrefs) {
            bindPreferences();
            Runnable runnable = this.mSelectPreferenceRunnable;
            if (runnable != null) {
                runnable.run();
                this.mSelectPreferenceRunnable = null;
            }
        }
        this.mInitDone = true;
    }

    public void scrollToPreference(Preference preference) {
        g33 g33Var = new g33(0, this, preference, null);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = g33Var;
        } else {
            g33Var.run();
        }
    }

    public void setDivider(Drawable drawable) {
        h33 h33Var = this.mDividerDecoration;
        if (drawable != null) {
            h33Var.getClass();
            h33Var.b = drawable.getIntrinsicHeight();
        } else {
            h33Var.b = 0;
        }
        h33Var.a = drawable;
        h33Var.d.mList.S();
    }

    public void setDividerHeight(int i) {
        h33 h33Var = this.mDividerDecoration;
        h33Var.b = i;
        h33Var.d.mList.S();
    }

    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        r33 r33Var = this.mPreferenceManager;
        PreferenceScreen preferenceScreen2 = r33Var.g;
        if (preferenceScreen != preferenceScreen2) {
            if (preferenceScreen2 != null) {
                preferenceScreen2.o();
            }
            r33Var.g = preferenceScreen;
            if (preferenceScreen != null) {
                onUnbindPreferences();
                this.mHavePrefs = true;
                if (!this.mInitDone || this.mHandler.hasMessages(1)) {
                    return;
                }
                this.mHandler.obtainMessage(1).sendToTarget();
            }
        }
    }

    public void setPreferencesFromResource(int i, String str) {
        r33 r33Var = this.mPreferenceManager;
        if (r33Var == null) {
            zo2.w("This should be called after super.onCreate.");
            return;
        }
        PreferenceScreen preferenceScreenD = r33Var.d(requireContext(), i, null);
        PreferenceScreen preferenceScreen = preferenceScreenD;
        if (str != null) {
            Preference preferenceA = preferenceScreenD.A(str);
            boolean z = preferenceA instanceof PreferenceScreen;
            preferenceScreen = preferenceA;
            if (!z) {
                xe.k(ha0.o("Preference object with key ", str, " is not a PreferenceScreen"));
                return;
            }
        }
        setPreferenceScreen(preferenceScreen);
    }

    public void scrollToPreference(String str) {
        g33 g33Var = new g33(0, this, null, str);
        if (this.mList == null) {
            this.mSelectPreferenceRunnable = g33Var;
        } else {
            g33Var.run();
        }
    }

    public void onBindPreferences() {
    }

    public void onUnbindPreferences() {
    }
}
