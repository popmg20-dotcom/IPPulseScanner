package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.getsurfboard.R;
import defpackage.du0;
import defpackage.eu0;
import defpackage.f33;
import defpackage.fu0;
import defpackage.gu0;
import defpackage.l90;
import defpackage.mj1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class i extends o implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public boolean A0;
    public Dialog C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;
    public Handler b;
    public final f33 f = new f33(5, this);
    public final du0 z = new du0(this);
    public final eu0 A = new eu0(this);
    public int X = 0;
    public int Y = 0;
    public boolean Z = true;
    public boolean y0 = true;
    public int z0 = -1;
    public final fu0 B0 = new fu0(this);
    public boolean G0 = false;

    @Override // androidx.fragment.app.o
    public final mj1 createFragmentContainer() {
        return new gu0(this, super.createFragmentContainer());
    }

    public final void j(boolean z, boolean z2) {
        if (this.E0) {
            return;
        }
        this.E0 = true;
        this.F0 = false;
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.C0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.b.getLooper()) {
                    onDismiss(this.C0);
                } else {
                    this.b.post(this.f);
                }
            }
        }
        this.D0 = true;
        if (this.z0 >= 0) {
            getParentFragmentManager().T(this.z0, z);
            this.z0 = -1;
            return;
        }
        u parentFragmentManager = getParentFragmentManager();
        parentFragmentManager.getClass();
        a aVar = new a(parentFragmentManager);
        aVar.p = true;
        aVar.j(this);
        if (z) {
            aVar.f(true, true);
        } else {
            aVar.e();
        }
    }

    public Dialog k() {
        if (u.M(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new l90(requireContext(), this.Y);
    }

    public void l(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void m(u uVar, String str) {
        this.E0 = false;
        this.F0 = true;
        uVar.getClass();
        a aVar = new a(uVar);
        aVar.p = true;
        aVar.g(0, this, str, 1);
        aVar.e();
    }

    @Override // androidx.fragment.app.o
    public final void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().f(this.B0);
        if (this.F0) {
            return;
        }
        this.E0 = false;
    }

    @Override // androidx.fragment.app.o
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new Handler();
        this.y0 = this.mContainerId == 0;
        if (bundle != null) {
            this.X = bundle.getInt("android:style", 0);
            this.Y = bundle.getInt("android:theme", 0);
            this.Z = bundle.getBoolean("android:cancelable", true);
            this.y0 = bundle.getBoolean("android:showsDialog", this.y0);
            this.z0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.o
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.C0;
        if (dialog != null) {
            this.D0 = true;
            dialog.setOnDismissListener(null);
            this.C0.dismiss();
            if (!this.E0) {
                onDismiss(this.C0);
            }
            this.C0 = null;
            this.G0 = false;
        }
    }

    @Override // androidx.fragment.app.o
    public final void onDetach() {
        super.onDetach();
        if (!this.F0 && !this.E0) {
            this.E0 = true;
        }
        getViewLifecycleOwnerLiveData().j(this.B0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.D0) {
            return;
        }
        if (u.M(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        j(true, true);
    }

    @Override // androidx.fragment.app.o
    public final LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.y0;
        if (z && !this.A0) {
            if (z && !this.G0) {
                try {
                    this.A0 = true;
                    Dialog dialogK = k();
                    this.C0 = dialogK;
                    if (this.y0) {
                        l(dialogK, this.X);
                        Context context = getContext();
                        if (context instanceof Activity) {
                            this.C0.setOwnerActivity((Activity) context);
                        }
                        this.C0.setCancelable(this.Z);
                        this.C0.setOnCancelListener(this.z);
                        this.C0.setOnDismissListener(this.A);
                        this.G0 = true;
                    } else {
                        this.C0 = null;
                    }
                    this.A0 = false;
                } catch (Throwable th) {
                    this.A0 = false;
                    throw th;
                }
            }
            if (u.M(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.C0;
            if (dialog != null) {
                return layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext());
            }
        } else if (u.M(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.y0) {
                Log.d("FragmentManager", "mShowsDialog = false: ".concat(str));
                return layoutInflaterOnGetLayoutInflater;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: ".concat(str));
        }
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.fragment.app.o
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.C0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.X;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.Y;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.Z;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.y0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.z0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.o
    public void onStart() {
        super.onStart();
        Dialog dialog = this.C0;
        if (dialog != null) {
            this.D0 = false;
            dialog.show();
            View decorView = this.C0.getWindow().getDecorView();
            decorView.getClass();
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.o
    public void onStop() {
        super.onStop();
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.o
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.C0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.C0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.o
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.C0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.C0.onRestoreInstanceState(bundle2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
