package defpackage;

import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jo1 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ String Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jo1(String str, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((jo1) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        String str = this.Z;
        switch (i) {
            case 0:
                return new jo1(str, ge0Var, 0);
            case 1:
                return new jo1(str, ge0Var, 1);
            default:
                return new jo1(str, ge0Var, 2);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        String str;
        ge0 ge0Var = null;
        int i = 1;
        switch (this.X) {
            case 0:
                xl4 xl4Var = xl4.a;
                mf0 mf0Var = mf0.b;
                int i2 = this.Y;
                try {
                    if (i2 == 0) {
                        n12.S(obj);
                        ko1 ko1Var = ko1.a;
                        String str2 = this.Z;
                        this.Y = 1;
                        gm0 gm0Var = qv0.a;
                        Object objB0 = ji0.b0(pl0.z, new p81(str2, ge0Var, i), this);
                        if (objB0 != mf0Var) {
                            objB0 = xl4Var;
                        }
                        if (objB0 == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i2 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                    }
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "geoip database file auto update finished");
                        str = "geoip database file auto update finished";
                    } else {
                        str = "geoip database file auto update finished";
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("GeoIPConfig", str, null);
                    }
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 3, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "geoip database file auto update failed");
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.o("GeoIPConfig", "geoip database file auto update failed", null);
                    }
                }
                return xl4Var;
            case 1:
                mf0 mf0Var2 = mf0.b;
                int i3 = this.Y;
                if (i3 != 0) {
                    if (i3 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                String str3 = this.Z;
                boolean z = nj3.a;
                this.Y = 1;
                n84 n84Var = pu1.a;
                z00 z00Var = new z00(1, p95.u(this));
                z00Var.w();
                ku2 ku2VarA = (z ? nj3.d : nj3.c).a();
                if (!tj4.G()) {
                    ku2VarA.a(new vp1(3));
                }
                le3 le3Var = new le3(new lu2(ku2VarA), pu1.a(str3));
                z00Var.y(new he0(i, le3Var, str3));
                le3Var.d(new oj1(6, z00Var));
                Object objU = z00Var.u();
                return objU == mf0Var2 ? mf0Var2 : objU;
            default:
                mf0 mf0Var3 = mf0.b;
                int i4 = this.Y;
                if (i4 == 0) {
                    n12.S(obj);
                    e1 e1Var = d73.a;
                    String str4 = this.Z;
                    this.Y = 1;
                    if (d73.d(str4, this) == mf0Var3) {
                        return mf0Var3;
                    }
                } else {
                    if (i4 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
        }
    }
}
