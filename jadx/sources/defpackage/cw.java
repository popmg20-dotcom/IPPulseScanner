package defpackage;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Object z;

    public /* synthetic */ cw(int i, Object obj, boolean z) {
        this.b = i;
        this.z = obj;
        this.f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zTryLock;
        int i = 4;
        switch (this.b) {
            case 0:
                ew ewVar = (ew) this.z;
                boolean z = this.f;
                if (ewVar.a == z) {
                    return;
                }
                ewVar.a = z;
                if (!z) {
                    w9 w9Var = new w9("The camera control has became inactive.");
                    vv vvVar = (vv) ewVar.g;
                    if (vvVar != null) {
                        vvVar.d(w9Var);
                        ewVar.g = null;
                        return;
                    }
                    return;
                }
                if (ewVar.b) {
                    nw nwVar = (nw) ewVar.c;
                    vv vvVar2 = new vv();
                    vvVar2.c = new wj3();
                    yv yvVar = new yv(vvVar2);
                    vvVar2.b = yvVar;
                    vvVar2.a = fw.class;
                    try {
                        nwVar.f.execute(new s7(i, nwVar, vvVar2));
                        vvVar2.a = "updateSessionConfigAsync";
                        break;
                    } catch (Exception e) {
                        yvVar.b(e);
                    }
                    n12.K(yvVar).a(new d4(2, ewVar), (at3) ewVar.d);
                    ewVar.b = false;
                    return;
                }
                return;
            case 1:
                ex exVar = (ex) this.z;
                boolean z2 = this.f;
                exVar.X0 = z2;
                if (z2) {
                    if (exVar.c1 == 4 || exVar.c1 == 5) {
                        exVar.K(false);
                        return;
                    }
                    return;
                }
                return;
            default:
                v80 v80Var = (v80) this.z;
                boolean z3 = this.f;
                r01 r01Var = v80Var.e;
                ArrayList arrayList = v80Var.a;
                ReentrantLock reentrantLock = v80Var.c;
                ArrayList arrayList2 = v80Var.b;
                if (v80Var.g) {
                    r01Var.run();
                    return;
                }
                if (z3) {
                    reentrantLock.lock();
                    zTryLock = true;
                } else {
                    zTryLock = reentrantLock.tryLock();
                }
                if (zTryLock) {
                    try {
                        if (arrayList2.isEmpty()) {
                            r01Var.run();
                        } else {
                            i60 i60Var = v80Var.f;
                            if (i60Var != null) {
                                while (!arrayList2.isEmpty()) {
                                    ax3 ax3Var = (ax3) arrayList2.remove(0);
                                    int size = arrayList.size();
                                    int i2 = 0;
                                    int i3 = size;
                                    while (i2 <= i3) {
                                        int i4 = (i2 + i3) / 2;
                                        if (i4 >= 0 && i4 < size) {
                                            int iCompare = i60Var.compare((ax3) arrayList.get(i4), ax3Var);
                                            if (iCompare < 0) {
                                                i2 = i4 + 1;
                                            } else if (iCompare > 0) {
                                                i3 = i4 - 1;
                                            }
                                        }
                                        i2 = i4;
                                        arrayList.add(Math.max(0, Math.min(size, i2)), ax3Var);
                                    }
                                    arrayList.add(Math.max(0, Math.min(size, i2)), ax3Var);
                                }
                            } else {
                                arrayList.addAll(arrayList2);
                                arrayList2.clear();
                            }
                            r01Var.run();
                        }
                        return;
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                return;
        }
    }
}
