package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class he0 implements sv, am1 {
    public final /* synthetic */ int b;
    public final Object f;
    public final Object z;

    public /* synthetic */ he0(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        switch (this.b) {
            case 0:
                try {
                    ((le3) this.f).c();
                    break;
                } catch (Throwable unused) {
                }
                break;
            case 1:
                String strN = ha0.n("cancelling fetch: ", (String) this.z);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "HttpClient", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("HttpClient", strN, null);
                }
                ((le3) this.f).c();
                break;
            default:
                Throwable th = (Throwable) obj;
                if (th instanceof nx4) {
                    ((tc2) this.f).c.compareAndSet(-256, ((nx4) th).b);
                }
                ((nc2) this.z).cancel(false);
                break;
        }
        return xl4.a;
    }

    @Override // defpackage.sv
    public void o(le3 le3Var, IOException iOException) {
        if (le3Var.G0) {
            return;
        }
        ((z00) this.z).d(new tk3(iOException));
    }

    @Override // defpackage.sv
    public void t(le3 le3Var, kk3 kk3Var) {
        ((z00) this.z).d(kk3Var);
    }
}
