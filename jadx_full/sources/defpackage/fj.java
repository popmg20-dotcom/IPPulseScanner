package defpackage;

import android.os.Process;
import android.util.Log;
import com.getsurfboard.backup.model.BackupSection;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fj extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ int X = 0;
    public /* synthetic */ Object Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(xw0 xw0Var, String str, String str2, byte[] bArr, xp xpVar, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = xw0Var;
        this.Z = str;
        this.y0 = str2;
        this.z0 = bArr;
        this.A0 = xpVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                return ((fj) n(ge0Var, lf0Var)).p(xl4Var);
            default:
                ((fj) n(ge0Var, lf0Var)).p(xl4Var);
                return xl4Var;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.A0;
        Object obj3 = this.z0;
        Object obj4 = this.y0;
        Object obj5 = this.Z;
        switch (i) {
            case 0:
                fj fjVar = new fj((u6) obj3, (jj) obj2, ge0Var, (k03) obj5, (Set) obj4);
                fjVar.Y = obj;
                return fjVar;
            default:
                return new fj((xw0) this.Y, (String) obj5, (String) obj4, (byte[]) obj3, (xp) obj2, ge0Var);
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // defpackage.kk
    public final Object p(Object obj) {
        switch (this.X) {
            case 0:
                lf0 lf0Var = (lf0) this.Y;
                n12.S(obj);
                k03 k03Var = (k03) this.Z;
                Set set = (Set) this.y0;
                u6 u6Var = (u6) this.z0;
                jj jjVar = (jj) this.A0;
                set.getClass();
                jz1 jz1Var = new jz1();
                List<gr3> list = jz1Var.a;
                d73.k(true);
                try {
                    for (BackupSection backupSection : d70.u0(d70.g0(set, k03Var.a()), new e1(2))) {
                        gm0 gm0Var = qv0.a;
                        ji0.B(lf0Var, qf2.a, null, new ej(u6Var, jjVar, backupSection, null, 0), 2);
                        iq1 iq1Var = lj.a;
                        list.addAll(lj.a(k03Var, yr2.k0(backupSection), fx3.K()).a);
                        break;
                    }
                    d73.k(false);
                    for (gr3 gr3Var : list) {
                        Exception exc = gr3Var.e;
                        if (exc != null) {
                            xb5.c("backup import failed section=" + gr3Var.a + " minAppVersionCode=" + k03Var.a.getMinAppVersionCode());
                            xb5.L(exc);
                        }
                    }
                    return jz1Var;
                } catch (Throwable th) {
                    d73.k(false);
                    throw th;
                }
            default:
                n12.S(obj);
                try {
                    String str = (String) this.Z;
                    String str2 = (String) this.y0;
                    String str3 = "DoH start query " + ke0.J(str) + " using " + str2;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "DoHResolver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("DoHResolver", str3, null);
                    }
                    xw0 xw0Var = (xw0) this.Y;
                    String str4 = (String) this.Z;
                    String str5 = (String) this.y0;
                    byte[] bArr = (byte[]) this.z0;
                    pj2 pj2Var = xw0.e;
                    byte[] bArrB = xw0Var.b(str4, str5, bArr);
                    DefaultDnsResponse defaultDnsResponseS = je.S(bArrB);
                    if (defaultDnsResponseS != null && (((xp) this.A0).e(new e03(defaultDnsResponseS, bArrB)) instanceof k30)) {
                        defaultDnsResponseS.release();
                    }
                    break;
                } catch (Exception unused) {
                    pj2 pj2Var2 = xw0.e;
                }
                return xl4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(u6 u6Var, jj jjVar, ge0 ge0Var, k03 k03Var, Set set) {
        super(2, ge0Var);
        this.Z = k03Var;
        this.y0 = set;
        this.z0 = u6Var;
        this.A0 = jjVar;
    }
}
