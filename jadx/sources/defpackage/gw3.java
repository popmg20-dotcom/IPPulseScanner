package defpackage;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gw3 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int b = 1;
    public final Object f;
    public final Object z;

    public gw3(hw3 hw3Var, Activity activity) {
        hw3Var.getClass();
        this.f = hw3Var;
        this.z = new WeakReference(activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                view.getClass();
                view.removeOnAttachStateChangeListener(this);
                Activity activity = (Activity) ((WeakReference) obj).get();
                IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                if (activity != null && iBinder != null) {
                    ((hw3) obj2).c(iBinder, activity);
                }
                break;
            default:
                ((ViewGroup) obj2).addView((u84) obj, 0);
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.b) {
            case 0:
                view.getClass();
                break;
            default:
                ((ViewGroup) this.f).addView((u84) this.z, 0);
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    public gw3(ViewGroup viewGroup, u84 u84Var) {
        this.f = viewGroup;
        this.z = u84Var;
    }
}
