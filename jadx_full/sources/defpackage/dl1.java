package defpackage;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dl1 extends k01 {
    public static HandlerThread F0;
    public static Handler G0;
    public final int B0;
    public SparseIntArray[] C0;
    public final ArrayList D0;
    public final cl1 E0;

    public dl1(int i) {
        super(20);
        this.C0 = new SparseIntArray[9];
        this.D0 = new ArrayList();
        this.E0 = new cl1(this);
        this.B0 = i;
    }

    public static void y(SparseIntArray sparseIntArray, long j) {
        if (sparseIntArray != null) {
            int i = (int) ((500000 + j) / 1000000);
            if (j >= 0) {
                sparseIntArray.put(i, sparseIntArray.get(i) + 1);
            }
        }
    }

    @Override // defpackage.k01
    public final void i(Activity activity) {
        if (F0 == null) {
            HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
            F0 = handlerThread;
            handlerThread.start();
            G0 = new Handler(F0.getLooper());
        }
        for (int i = 0; i <= 8; i++) {
            SparseIntArray[] sparseIntArrayArr = this.C0;
            if (sparseIntArrayArr[i] == null && (this.B0 & (1 << i)) != 0) {
                sparseIntArrayArr[i] = new SparseIntArray();
            }
        }
        activity.getWindow().addOnFrameMetricsAvailableListener(this.E0, G0);
        this.D0.add(new WeakReference(activity));
    }

    @Override // defpackage.k01
    public final SparseIntArray[] q() {
        return this.C0;
    }

    @Override // defpackage.k01
    public final SparseIntArray[] t(Activity activity) {
        ArrayList arrayList = this.D0;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == activity) {
                arrayList.remove(weakReference);
                break;
            }
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(this.E0);
        return this.C0;
    }

    @Override // defpackage.k01
    public final SparseIntArray[] u() {
        SparseIntArray[] sparseIntArrayArr = this.C0;
        this.C0 = new SparseIntArray[9];
        return sparseIntArrayArr;
    }

    @Override // defpackage.k01
    public final SparseIntArray[] w() {
        ArrayList arrayList = this.D0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            WeakReference weakReference = (WeakReference) arrayList.get(size);
            Activity activity = (Activity) weakReference.get();
            if (weakReference.get() != null) {
                activity.getWindow().removeOnFrameMetricsAvailableListener(this.E0);
                arrayList.remove(size);
            }
        }
        return this.C0;
    }
}
