package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y51 implements g54, vb3 {
    public final HashMap a;
    public ArrayDeque b;

    public y51() {
        vk4 vk4Var = vk4.b;
        this.a = new HashMap();
        this.b = new ArrayDeque();
    }

    public final synchronized void a() {
        yu0 yu0Var = yu0.z;
        c84 c84Var = c84.z;
        synchronized (this) {
            try {
                if (!this.a.containsKey(ji0.class)) {
                    this.a.put(ji0.class, new ConcurrentHashMap());
                }
                ((ConcurrentHashMap) this.a.get(ji0.class)).put(c84Var, yu0Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
