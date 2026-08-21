package defpackage;

import android.net.Network;
import android.os.Process;
import android.os.SystemClock;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c04 extends v74 implements Function2 {
    public final /* synthetic */ d04 X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ String Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c04(d04 d04Var, long j, String str, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = d04Var;
        this.Y = j;
        this.Z = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((c04) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new c04(this.X, this.Y, this.Z, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        String str;
        ln0 ln0Var = ln0.a;
        n12.S(obj);
        try {
            d04 d04Var = this.X;
            ea3 ea3VarL = d04Var.a.l(d04Var.f.z, d04Var.b);
            Network networkC = je.C(ContextUtilsKt.b());
            if (networkC != null && ea3VarL != null) {
                boolean z = ea3VarL instanceof tu0;
                d04 d04Var2 = this.X;
                String str2 = z ? d04Var2.d : d04Var2.e;
                ku2 ku2VarA = d04.g.a();
                long j = this.Y;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                timeUnit.getClass();
                ku2VarA.x = jz4.b(j, timeUnit);
                if (z) {
                    SocketFactory socketFactory = networkC.getSocketFactory();
                    socketFactory.getClass();
                    ku2VarA.b(socketFactory);
                }
                lu2 lu2Var = new lu2(ku2VarA);
                cm2 cm2VarA = this.X.a(str2, z);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    kk3 kk3VarE = new le3(lu2Var, cm2VarA).e();
                    d04 d04Var3 = this.X;
                    try {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        String strG = kk3.g(kk3VarE, "X-Surfboard-Error");
                        f82 f82Var = d04Var3.f;
                        e03 e03Var = strG != null ? new e03(f82Var, ln0Var) : new e03(f82Var, new nn0(jElapsedRealtime2));
                        kk3VarE.close();
                        return e03Var;
                    } finally {
                    }
                } catch (Exception e) {
                    String str3 = "[" + this.Z + "] " + this.X.f.z + " execution failed: " + e.getMessage();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 3, "SpeedometerTask", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                        str = str3;
                    } else {
                        str = str3;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.o("SpeedometerTask", str, null);
                    }
                    return new e03(this.X.f, ln0Var);
                }
            }
            return new e03(this.X.f, ln0Var);
        } catch (Exception e2) {
            String str4 = this.Z;
            String str5 = this.X.f.z;
            String message = e2.getMessage();
            StringBuilder sbE = fw.E("[", str4, "] ", str5, " setup failed: ");
            sbE.append(message);
            String string = sbE.toString();
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "SpeedometerTask", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("SpeedometerTask", string, null);
            }
            return new e03(this.X.f, ln0Var);
        }
    }
}
