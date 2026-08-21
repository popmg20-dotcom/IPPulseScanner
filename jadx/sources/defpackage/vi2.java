package defpackage;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.getsurfboard.R;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vi2 extends SharedElementCallback {
    public static WeakReference c;
    public boolean a = true;
    public Rect b;

    public static void a(Window window) {
        Drawable background = window.getDecorView().getBackground();
        if (background == null) {
            return;
        }
        Drawable drawableMutate = background.mutate();
        ColorFilter porterDuffColorFilter = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Object objM = v9.m();
            if (objM != null) {
                porterDuffColorFilter = v9.c(objM);
            }
        } else {
            PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
            if (mode != null) {
                porterDuffColorFilter = new PorterDuffColorFilter(0, mode);
            }
        }
        drawableMutate.setColorFilter(porterDuffColorFilter);
    }

    @Override // android.app.SharedElementCallback
    public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        c = new WeakReference(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
        WeakReference weakReference;
        KeyEvent.Callback callback;
        View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (viewOnCreateSnapshotView != null && (weakReference = c) != null && (callback = (View) weakReference.get()) != null) {
            ou3 shapeAppearanceModel = callback instanceof yu3 ? ((yu3) callback).getShapeAppearanceModel() : null;
            if (shapeAppearanceModel != null) {
                viewOnCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, shapeAppearanceModel);
            }
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public final void onMapSharedElements(List list, Map map) {
        View view;
        Activity activity;
        if (list.isEmpty() || map.isEmpty() || (view = (View) map.get(list.get(0))) == null) {
            return;
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity != null) {
            Window window = activity.getWindow();
            if (this.a) {
                Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
                if (sharedElementEnterTransition instanceof si2) {
                    si2 si2Var = (si2) sharedElementEnterTransition;
                    window.setSharedElementReenterTransition(null);
                    if (si2Var.getDuration() >= 0) {
                        window.setTransitionBackgroundFadeDuration(si2Var.getDuration());
                    }
                    si2Var.addListener(new ui2(0, window));
                    return;
                }
                return;
            }
            Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
            if (sharedElementReturnTransition instanceof si2) {
                si2 si2Var2 = (si2) sharedElementReturnTransition;
                si2Var2.b = true;
                si2Var2.addListener(new ui2(2, activity));
                if (si2Var2.getDuration() >= 0) {
                    window.setTransitionBackgroundFadeDuration(si2Var2.getDuration());
                }
                si2Var2.addListener(new ui2(1, window));
            }
        }
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementEnd(List list, List list2, List list3) {
        if (!list2.isEmpty() && (((View) list2.get(0)).getTag(R.id.mtrl_motion_snapshot_view) instanceof View)) {
            ((View) list2.get(0)).setTag(R.id.mtrl_motion_snapshot_view, null);
        }
        if (!this.a && !list2.isEmpty()) {
            View view = (View) list2.get(0);
            RectF rectF = fh4.a;
            this.b = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        this.a = false;
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementStart(List list, List list2, List list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            ((View) list2.get(0)).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.a || list2.isEmpty() || this.b == null) {
            return;
        }
        View view = (View) list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.b.width(), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(this.b.height(), Pow2.MAX_POW2));
        Rect rect = this.b;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
