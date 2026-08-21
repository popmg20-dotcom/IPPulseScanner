package com.getsurfboard.common;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.tencent.mars.xlog.Xlog;
import defpackage.bn4;
import defpackage.d73;
import defpackage.e03;
import defpackage.e1;
import defpackage.fw;
import defpackage.fy4;
import defpackage.ge0;
import defpackage.ha0;
import defpackage.ie0;
import defpackage.le2;
import defpackage.mf0;
import defpackage.n12;
import defpackage.pc2;
import defpackage.rc2;
import defpackage.t23;
import defpackage.tk3;
import defpackage.uk3;
import defpackage.vd3;
import defpackage.xe;
import defpackage.xf2;
import defpackage.zk;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class UpdateProfileWorker extends CoroutineWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateProfileWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(ge0 ge0Var) {
        bn4 bn4Var;
        Object objV;
        String str;
        String str2;
        String strN;
        if (ge0Var instanceof bn4) {
            bn4Var = (bn4) ge0Var;
            int i = bn4Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                bn4Var.Z = i - Integer.MIN_VALUE;
            } else {
                bn4Var = new bn4(this, (ie0) ge0Var);
            }
        }
        bn4 bn4Var2 = bn4Var;
        Object obj = bn4Var2.X;
        mf0 mf0Var = mf0.b;
        int i2 = bn4Var2.Z;
        if (i2 == 0) {
            n12.S(obj);
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "UpdateProfileWorker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "doWork() called");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("UpdateProfileWorker", "doWork() called", null);
            }
            Object obj2 = this.b.b.a.get("name");
            String str3 = obj2 instanceof String ? (String) obj2 : null;
            if (str3 == null) {
                return new pc2(this.b.b);
            }
            zk zkVarE = d73.e(str3);
            if (zkVarE == null) {
                String strConcat = "can not find profile by name: ".concat(str3);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "UpdateProfileWorker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("UpdateProfileWorker", strConcat, null);
                }
                return new pc2(this.b.b);
            }
            xf2 xf2VarJ = zkVarE.j();
            if (xf2VarJ == null) {
                String strO = ha0.o("profile ", str3, " doesn't have a valid managedConfig");
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "UpdateProfileWorker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strO);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("UpdateProfileWorker", strO, null);
                }
                return new pc2(this.b.b);
            }
            String str4 = xf2VarJ.b;
            vd3 vd3Var = vd3.Z;
            long jH = t23.h();
            bn4Var2.A = str4;
            bn4Var2.Z = 1;
            objV = vd3Var.v(str4, str3, true, jH, bn4Var2);
            if (objV != mf0Var) {
                str = str4;
            }
            return mf0Var;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str2 = bn4Var2.A;
            n12.S(obj);
            strN = ha0.n("update profile success at ", str2);
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "UpdateProfileWorker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("UpdateProfileWorker", strN, null);
            }
            return new rc2(this.b.b);
        }
        str = bn4Var2.A;
        n12.S(obj);
        objV = ((uk3) obj).b;
        if (objV instanceof tk3) {
            Throwable thA = uk3.a(objV);
            if (thA != null) {
                thA.printStackTrace();
            }
            String strU = fw.u("update failed at ", str, ": ", thA != null ? thA.getMessage() : null);
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "UpdateProfileWorker", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("UpdateProfileWorker", strU, null);
            }
            return new pc2(this.b.b);
        }
        e1 e1Var = d73.a;
        n12.S(objV);
        e03[] e03VarArr = {objV};
        bn4Var2.A = str;
        bn4Var2.Z = 2;
        if (d73.j(e03VarArr, bn4Var2) != mf0Var) {
            str2 = str;
            strN = ha0.n("update profile success at ", str2);
            if (fy4.b) {
            }
            if (((Boolean) le2.a.a()).booleanValue()) {
                Log.d("UpdateProfileWorker", strN, null);
            }
            return new rc2(this.b.b);
        }
        return mf0Var;
    }
}
