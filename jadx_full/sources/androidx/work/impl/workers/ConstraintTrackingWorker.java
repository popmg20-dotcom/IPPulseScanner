package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import defpackage.aj;
import defpackage.d70;
import defpackage.dc0;
import defpackage.ec0;
import defpackage.ef0;
import defpackage.fc0;
import defpackage.fs1;
import defpackage.ge0;
import defpackage.gx4;
import defpackage.hd;
import defpackage.ic0;
import defpackage.ie0;
import defpackage.ji0;
import defpackage.jx4;
import defpackage.m20;
import defpackage.mf0;
import defpackage.mt;
import defpackage.mw4;
import defpackage.n12;
import defpackage.nb0;
import defpackage.p95;
import defpackage.pc2;
import defpackage.q74;
import defpackage.qc2;
import defpackage.sc2;
import defpackage.tc2;
import defpackage.ue2;
import defpackage.v92;
import defpackage.xe;
import defpackage.xw4;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorker extends CoroutineWorker {
    public final WorkerParameters g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.g = workerParameters;
    }

    @Override // androidx.work.CoroutineWorker
    public final Object c(ge0 ge0Var) {
        ExecutorService executorService = this.b.c;
        executorService.getClass();
        return ji0.b0(n12.x(executorService), new mt(this, null, 1), ge0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(tc2 tc2Var, m20 m20Var, gx4 gx4Var, ie0 ie0Var) {
        ec0 ec0Var;
        if (ie0Var instanceof ec0) {
            ec0Var = (ec0) ie0Var;
            int i = ec0Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                ec0Var.Y = i - Integer.MIN_VALUE;
            } else {
                ec0Var = new ec0(this, ie0Var);
            }
        }
        Object objH = ec0Var.A;
        int i2 = ec0Var.Y;
        if (i2 == 0) {
            n12.S(objH);
            aj ajVar = new aj(tc2Var, m20Var, gx4Var, null);
            ec0Var.Y = 1;
            objH = p95.h(ajVar, ec0Var);
            mf0 mf0Var = mf0.b;
            if (objH == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objH);
        }
        objH.getClass();
        return objH;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(ie0 ie0Var) {
        fc0 fc0Var;
        Object obj;
        tc2 tc2Var;
        AtomicInteger atomicInteger;
        int i;
        WorkerParameters workerParameters = this.g;
        if (ie0Var instanceof fc0) {
            fc0Var = (fc0) ie0Var;
            int i2 = fc0Var.Z;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fc0Var.Z = i2 - Integer.MIN_VALUE;
            } else {
                fc0Var = new fc0(this, ie0Var);
            }
        }
        fc0 fc0Var2 = fc0Var;
        Object objB0 = fc0Var2.X;
        int i3 = fc0Var2.Z;
        if (i3 == 0) {
            n12.S(objB0);
            WorkerParameters workerParameters2 = this.b;
            Object obj2 = workerParameters2.b.a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            String str = obj2 instanceof String ? (String) obj2 : null;
            if (str == null || str.length() == 0) {
                ue2.g().e(ic0.a, "No worker to delegate to.");
                return new pc2();
            }
            Context context = this.a;
            xw4 xw4VarC = xw4.c(context);
            jx4 jx4VarX = xw4VarC.c.x();
            String string = workerParameters2.a.toString();
            string.getClass();
            gx4 gx4VarC = jx4VarX.c(string);
            if (gx4VarC == null) {
                return new pc2();
            }
            v92 v92Var = xw4VarC.j;
            v92Var.getClass();
            m20 m20Var = new m20(v92Var);
            ArrayList arrayList = m20Var.a;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                if (((nb0) obj3).a(gx4VarC)) {
                    arrayList2.add(obj3);
                }
            }
            if (arrayList2.isEmpty()) {
                obj = null;
            } else {
                obj = null;
                ue2.g().a(mw4.a, "Work " + gx4VarC.a + " constrained by " + d70.j0(arrayList2, null, null, null, new q74(8), 31));
            }
            if (!arrayList2.isEmpty()) {
                String str2 = ic0.a;
                ue2.g().a(str2, "Constraints not met for delegate " + str + ". Requesting retry.");
                return new qc2();
            }
            ue2.g().a(ic0.a, "Constraints met for delegate ".concat(str));
            try {
                tc2 tc2VarE = workerParameters2.f.e(context, str, workerParameters);
                fs1 fs1Var = (fs1) workerParameters.e.d;
                fs1Var.getClass();
                try {
                    ef0 ef0VarX = n12.x(fs1Var);
                    tc2Var = tc2VarE;
                    try {
                        hd hdVar = new hd(this, tc2Var, m20Var, gx4VarC, null, 4);
                        fc0Var2.A = tc2Var;
                        fc0Var2.Z = 1;
                        objB0 = ji0.b0(ef0VarX, hdVar, fc0Var2);
                        mf0 mf0Var = mf0.b;
                        if (objB0 == mf0Var) {
                            return mf0Var;
                        }
                        return (sc2) objB0;
                    } catch (CancellationException e) {
                        e = e;
                        atomicInteger = this.c;
                        if (atomicInteger.get() != -256 || (e instanceof dc0)) {
                            if (Build.VERSION.SDK_INT >= 31) {
                                i = -512;
                            } else if (atomicInteger.get() != -256) {
                                i = atomicInteger.get();
                            } else {
                                if (!(e instanceof dc0)) {
                                    xe.q("Unreachable");
                                    return obj;
                                }
                                i = ((dc0) e).b;
                            }
                            tc2Var.c.compareAndSet(-256, i);
                        }
                        if (e instanceof dc0) {
                            return new qc2();
                        }
                        throw e;
                    }
                } catch (CancellationException e2) {
                    e = e2;
                    tc2Var = tc2VarE;
                    atomicInteger = this.c;
                    if (atomicInteger.get() != -256) {
                        if (Build.VERSION.SDK_INT >= 31) {
                        }
                        tc2Var.c.compareAndSet(-256, i);
                    }
                    if (e instanceof dc0) {
                    }
                }
            } catch (Throwable unused) {
                ue2.g().a(ic0.a, "No worker to delegate to.");
                xw4VarC.b.getClass();
                return new pc2();
            }
        } else {
            if (i3 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            tc2Var = fc0Var2.A;
            try {
                n12.S(objB0);
                obj = null;
                return (sc2) objB0;
            } catch (CancellationException e3) {
                e = e3;
                obj = null;
                atomicInteger = this.c;
                if (atomicInteger.get() != -256) {
                }
                if (e instanceof dc0) {
                }
            }
        }
    }
}
