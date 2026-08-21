package defpackage;

import android.util.ArrayMap;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.EmbeddedActivityWindowInfo;
import androidx.window.reflection.Consumer2;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d5 {
    public final ReentrantLock a = new ReentrantLock();
    public final ArrayMap b = new ArrayMap();

    public d5(ActivityEmbeddingComponent activityEmbeddingComponent) {
        int iA = y91.a();
        if (iA >= 6) {
            new Consumer2() { // from class: c5
                @Override // androidx.window.reflection.Consumer2
                public final void accept(Object obj) {
                    d5 d5Var = this.a;
                    ((EmbeddedActivityWindowInfo) obj).getClass();
                    ReentrantLock reentrantLock = d5Var.a;
                    reentrantLock.lock();
                    try {
                        Iterator it = d5Var.b.values().iterator();
                        if (!it.hasNext()) {
                            reentrantLock.unlock();
                        } else {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
            };
        } else {
            vp1.n(fw.s(6, iA, "This API requires extension version ", ", but the device is on "));
            throw null;
        }
    }
}
