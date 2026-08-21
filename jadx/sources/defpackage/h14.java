package defpackage;

import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class h14 extends b22 implements jt3, v83 {
    public static final f14 X0 = new f14();
    public static final List Y0 = DesugarCollections.unmodifiableList(Arrays.asList(nt3.Y, lt3.X));
    public List A0;
    public List B0;
    public rl0 C0;
    public ux3 D0;
    public List E0;
    public ScheduledThreadPoolExecutor F0;
    public boolean G0;
    public xo2 H0;
    public List I0;
    public final AtomicReference J0;
    public final AtomicReference K0;
    public final CopyOnWriteArraySet L0;
    public final ConcurrentHashMap M0;
    public final ConcurrentHashMap N0;
    public final u83 O0;
    public int P0;
    public yt3 Q0;
    public List R0;
    public yt3 S0;
    public d2 T0;
    public tb3 U0;
    public zl0 V0;
    public final AtomicBoolean W0;
    public final Object X;
    public final AtomicReference Y;
    public final wk0 Z;
    public List y0;
    public List z0;

    public h14() {
        super(0);
        Object obj = new Object();
        this.X = obj;
        this.Y = new AtomicReference(e0.b);
        this.Z = new wk0("", obj);
        this.J0 = new AtomicReference();
        this.K0 = new AtomicReference();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.L0 = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        this.M0 = new ConcurrentHashMap();
        this.N0 = new ConcurrentHashMap();
        this.O0 = t84.z;
        if (ke0.t(i30.class, copyOnWriteArraySet2) != null) {
            st4.n();
            throw null;
        }
        if (ke0.t(h23.class, copyOnWriteArraySet3) == null) {
            this.W0 = new AtomicBoolean(false);
        } else {
            st4.n();
            throw null;
        }
    }

    @Override // defpackage.v83
    public final Map F() {
        return this.M0;
    }

    @Override // defpackage.b22
    public final wk0 W0(boolean z) {
        we2 we2Var = (we2) this.f;
        final boolean zIsDebugEnabled = we2Var.isDebugEnabled();
        e0 e0Var = e0.b;
        e0 e0Var2 = e0.f;
        e0 e0Var3 = e0.z;
        AtomicReference atomicReference = this.Y;
        if (z) {
            while (true) {
                if (atomicReference.compareAndSet(e0Var, e0Var3)) {
                    break;
                }
                if (atomicReference.get() != e0Var) {
                    while (!atomicReference.compareAndSet(e0Var2, e0Var3)) {
                        if (atomicReference.get() != e0Var2) {
                            if (zIsDebugEnabled) {
                                we2Var.debug("close({})[Immediately] state already {}", this, atomicReference);
                            }
                        }
                    }
                }
            }
            if (zIsDebugEnabled) {
                we2Var.debug("close({}) Closing immediately", this);
            }
            Y0().W0(true).W0(new q0(this));
            if (zIsDebugEnabled) {
                we2Var.debug("close({})[Immediately] closed", this);
            }
        } else {
            while (true) {
                if (atomicReference.compareAndSet(e0Var, e0Var2)) {
                    if (zIsDebugEnabled) {
                        we2Var.debug("close({}) Closing gracefully", this);
                    }
                    wk0 wk0VarW0 = Y0().W0(false);
                    if (wk0VarW0 != null) {
                        wk0VarW0.W0(new e14() { // from class: d0
                            @Override // defpackage.e14
                            public final void s(wk0 wk0Var) {
                                e0 e0Var4;
                                h14 h14Var = this.b;
                                AtomicReference atomicReference2 = h14Var.Y;
                                do {
                                    e0Var4 = e0.f;
                                    if (atomicReference2.compareAndSet(e0Var4, e0.z)) {
                                        h14Var.Y0().W0(true).W0(new q0(h14Var));
                                        if (zIsDebugEnabled) {
                                            ((we2) h14Var.f).debug("close({}][Graceful] - operationComplete() closed", h14Var);
                                            return;
                                        }
                                        return;
                                    }
                                } while (atomicReference2.get() == e0Var4);
                            }
                        });
                    } else {
                        while (true) {
                            if (atomicReference.compareAndSet(e0Var2, e0Var3)) {
                                Y0().W0(true).W0(new q0(this));
                                if (zIsDebugEnabled) {
                                    we2Var.debug("close({})[Graceful] closed", this);
                                }
                            } else if (atomicReference.get() != e0Var2) {
                                break;
                            }
                        }
                    }
                } else if (atomicReference.get() != e0Var) {
                    if (zIsDebugEnabled) {
                        we2Var.debug("close({})[Graceful] state already {}", this, atomicReference);
                    }
                }
            }
        }
        return this.Z;
    }

    @Override // defpackage.b22
    public final boolean X0() {
        return this.Y.get() != e0.b;
    }

    public final b22 Y0() {
        String string = toString();
        ArrayList arrayList = new ArrayList();
        Object obj = this.X;
        Objects.requireNonNull(obj, "No lock");
        final int i = 0;
        arrayList.add(new hq(string, obj, new Runnable(this) { // from class: g14
            public final /* synthetic */ h14 f;

            {
                this.f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
                int i2 = i;
                h14 h14Var = this.f;
                switch (i2) {
                    case 0:
                        ScheduledFuture scheduledFuture = (ScheduledFuture) h14Var.K0.getAndSet(null);
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(true);
                        }
                        return;
                    default:
                        if (!h14Var.G0 || (scheduledThreadPoolExecutor = h14Var.F0) == null || scheduledThreadPoolExecutor.isShutdown()) {
                            return;
                        }
                        try {
                            h14Var.F0.shutdownNow();
                            return;
                        } finally {
                            h14Var.F0 = null;
                        }
                }
            }
        }));
        final int i2 = 1;
        b22[] b22VarArr = {null, null};
        for (int i3 = 0; i3 < 2; i3++) {
            b22 b22Var = b22VarArr[i3];
            if (b22Var != null) {
                arrayList.add(b22Var);
            }
        }
        arrayList.add(new hq(string, obj, new Runnable(this) { // from class: g14
            public final /* synthetic */ h14 f;

            {
                this.f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
                int i22 = i2;
                h14 h14Var = this.f;
                switch (i22) {
                    case 0:
                        ScheduledFuture scheduledFuture = (ScheduledFuture) h14Var.K0.getAndSet(null);
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(true);
                        }
                        return;
                    default:
                        if (!h14Var.G0 || (scheduledThreadPoolExecutor = h14Var.F0) == null || scheduledThreadPoolExecutor.isShutdown()) {
                            return;
                        }
                        try {
                            h14Var.F0.shutdownNow();
                            return;
                        } finally {
                            h14Var.F0 = null;
                        }
                }
            }
        }));
        return arrayList.isEmpty() ? new zw3(iq.class.getSimpleName(), obj) : arrayList.size() == 1 ? (b22) arrayList.get(0) : new hq(iq.class.getSimpleName(), obj, arrayList);
    }

    @Override // defpackage.b22
    public final boolean isClosed() {
        return this.Y.get() == e0.A;
    }

    @Override // defpackage.v83
    public final v83 q0() {
        return this.O0;
    }

    @Override // defpackage.k70
    public final String toString() {
        StringBuilder sb = new StringBuilder(h14.class.getSimpleName());
        sb.append("[");
        sb.append(Integer.toHexString(hashCode()));
        sb.append("](port=");
        return fw.w(")", sb, this.P0);
    }
}
