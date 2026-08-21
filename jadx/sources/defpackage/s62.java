package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s62 implements Serializable {
    public static final s62 f = new s62(0);
    public static final s62 z = new s62(1);
    public final /* synthetic */ int b;

    public /* synthetic */ s62(int i) {
        this.b = i;
    }

    public final mp a() {
        SoftReference softReference;
        switch (this.b) {
            case 0:
                return new mp();
            default:
                ThreadLocal threadLocal = np.b;
                SoftReference softReference2 = (SoftReference) threadLocal.get();
                mp mpVar = softReference2 == null ? null : (mp) softReference2.get();
                if (mpVar == null) {
                    mpVar = new mp();
                    e24 e24Var = np.a;
                    if (e24Var != null) {
                        ReferenceQueue referenceQueue = (ReferenceQueue) e24Var.z;
                        softReference = new SoftReference(mpVar, referenceQueue);
                        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) e24Var.f;
                        concurrentHashMap.put(softReference, Boolean.TRUE);
                        while (true) {
                            SoftReference softReference3 = (SoftReference) referenceQueue.poll();
                            if (softReference3 != null) {
                                concurrentHashMap.remove(softReference3);
                            }
                        }
                    } else {
                        softReference = new SoftReference(mpVar);
                    }
                    threadLocal.set(softReference);
                }
                return mpVar;
        }
    }
}
