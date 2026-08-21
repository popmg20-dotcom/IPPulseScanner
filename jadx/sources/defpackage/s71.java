package defpackage;

import android.app.ApplicationExitInfo;
import android.os.Build;
import android.os.Process;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s71 extends v74 implements Function2 {
    public final /* synthetic */ ApplicationExitInfo X;
    public final /* synthetic */ byte[] Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s71(ApplicationExitInfo applicationExitInfo, byte[] bArr, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = applicationExitInfo;
        this.Y = bArr;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((s71) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new s71(this.X, this.Y, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        String str;
        af4 af4Var;
        sd sdVar;
        n12.S(obj);
        if (this.X.getReason() != 5 || Build.VERSION.SDK_INT < 31) {
            str = new String(this.Y, y30.a);
        } else {
            byte[] bArr = this.Y;
            try {
                we4 we4Var = af4.V0;
                we4Var.getClass();
                af4Var = (af4) we4Var.c(bArr, 0, bArr.length, i1.a);
            } catch (Exception e) {
                String strN = ha0.n("trace is not a proto tombstone: ", e.getMessage());
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "TombstoneRenderer", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("TombstoneRenderer", strN, null);
                }
            }
            if (af4Var.B0 == 0) {
                if (af4Var.S().a0().size() <= 0) {
                    af4Var = null;
                }
            }
            if (af4Var != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Build fingerprint: ".concat(af4Var.J()));
                sb.append('\n');
                sb.append("Revision: ".concat(af4Var.K()));
                sb.append('\n');
                int i = af4Var.Y;
                if (i == 0) {
                    sdVar = sd.ARM32;
                } else if (i == 1) {
                    sdVar = sd.ARM64;
                } else if (i == 2) {
                    sdVar = sd.X86;
                } else if (i == 3) {
                    sdVar = sd.X86_64;
                } else if (i == 4) {
                    sdVar = sd.RISCV64;
                } else if (i != 5) {
                    sd sdVar2 = sd.ARM32;
                    sdVar = null;
                } else {
                    sdVar = sd.NONE;
                }
                if (sdVar == null) {
                    sdVar = sd.UNRECOGNIZED;
                }
                sb.append("ABI: " + sdVar);
                sb.append('\n');
                sb.append("Timestamp: ".concat(af4Var.P()));
                sb.append('\n');
                int i2 = af4Var.B0;
                int i3 = af4Var.C0;
                int i4 = af4Var.D0;
                StringBuilder sbA = fw.A(i2, i3, "pid: ", ", tid: ", ", uid: ");
                sbA.append(i4);
                sb.append(sbA.toString());
                sb.append('\n');
                if (af4Var.F0.f.size() > 0) {
                    g92 g92Var = af4Var.F0;
                    g92Var.getClass();
                    sb.append("Cmdline: ".concat(d70.j0(g92Var, " ", null, null, null, 62)));
                    sb.append('\n');
                }
                int i5 = af4Var.G0;
                if (i5 > 0) {
                    sb.append("Process uptime: " + i5 + "s");
                    sb.append('\n');
                }
                sb.append('\n');
                ow3 ow3VarN = af4Var.N();
                int i6 = ow3VarN.Y;
                if (i6 != 0) {
                    sb.append("signal " + i6 + " (" + ow3VarN.K() + ")");
                    sb.append(", code " + ow3VarN.y0 + " (" + ow3VarN.H() + ")");
                    if (ow3VarN.D0) {
                        long j = ow3VarN.E0;
                        yr2.g(16);
                        String string = Long.toString(j, 16);
                        string.getClass();
                        sb.append(", fault addr 0x".concat(string));
                    }
                    sb.append('\n');
                    if (ow3VarN.A0) {
                        sb.append("    sent from pid " + ow3VarN.C0 + ", uid " + ow3VarN.B0);
                        sb.append('\n');
                    }
                    sb.append('\n');
                }
                if (af4Var.H().length() > 0) {
                    sb.append("Abort message: ".concat(af4Var.H()));
                    sb.append("\n\n");
                }
                List<l20> list = af4Var.K0;
                list.getClass();
                for (l20 l20Var : list) {
                    if (l20Var.H().length() > 0) {
                        sb.append("Cause: ".concat(l20Var.H()));
                        sb.append('\n');
                    }
                }
                if (af4Var.K0.size() > 0) {
                    sb.append('\n');
                }
                ld4 ld4Var = (ld4) af4Var.S().a0().get(Integer.valueOf(af4Var.C0));
                if (ld4Var != null) {
                    je.a0(sb, ld4Var, "Crashed");
                } else {
                    sb.append("Crashed thread (tid=" + af4Var.C0 + ") not found in tombstone threads:");
                    sb.append('\n');
                    Iterator it = d70.u0(af4Var.S().a0().entrySet(), new e1(23)).iterator();
                    while (it.hasNext()) {
                        Object value = ((Map.Entry) it.next()).getValue();
                        value.getClass();
                        je.a0(sb, (ld4) value, null);
                    }
                }
                str = sb.toString();
            } else {
                str = new String(this.Y, y30.a);
            }
        }
        if (str.length() <= 65536) {
            return str;
        }
        return str.substring(0, 65536) + "\n... [trace truncated, " + (str.length() - 65536) + " chars omitted]";
    }
}
