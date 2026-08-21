package defpackage;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import com.getsurfboard.vpn.JniKt;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ux2 extends v74 implements Function2 {
    public final /* synthetic */ u6 A0;
    public final /* synthetic */ p5 B0;
    public final /* synthetic */ int C0;
    public final /* synthetic */ OverrideDoHActivity D0;
    public xw0 X;
    public Object Y;
    public int Z;
    public final /* synthetic */ String y0;
    public final /* synthetic */ long z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ux2(String str, long j, u6 u6Var, p5 p5Var, int i, OverrideDoHActivity overrideDoHActivity, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = str;
        this.z0 = j;
        this.A0 = u6Var;
        this.B0 = p5Var;
        this.C0 = i;
        this.D0 = overrideDoHActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((ux2) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new ux2(this.y0, this.z0, this.A0, this.B0, this.C0, this.D0, ge0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        xw0 xw0Var;
        Object objD;
        Object obj2;
        String message;
        int i = this.C0;
        String str = this.y0;
        OverrideDoHActivity overrideDoHActivity = this.D0;
        mf0 mf0Var = mf0.b;
        int i2 = this.Z;
        if (i2 == 0) {
            n12.S(obj);
            xw0Var = new xw0(JniKt.getDNSTimeout());
            xw0Var.c = je.C(ContextUtilsKt.b());
            List listX = p95.x(str);
            this.X = xw0Var;
            this.Z = 1;
            objD = xw0Var.d(listX, this);
            if (objD != mf0Var) {
            }
            return mf0Var;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            obj2 = this.Y;
            n12.S(obj);
            objD = obj2;
            this.A0.dismiss();
            if (objD instanceof tk3) {
                if (this.B0 == p5.f && i >= 0 && i < overrideDoHActivity.T0.size()) {
                    overrideDoHActivity.T0.set(i, str);
                } else if (!overrideDoHActivity.T0.contains(str)) {
                    overrideDoHActivity.T0.add(str);
                }
                overrideDoHActivity.V0.r(d70.y0(overrideDoHActivity.T0));
                t23.x(overrideDoHActivity.T0);
                uf4 uf4Var = overrideDoHActivity.S0;
                if (uf4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) uf4Var.f;
                coordinatorLayout.getClass();
                r25.R(coordinatorLayout, R.string.override_doh_server_saved, new Object[0]);
                overrideDoHActivity.A();
                overrideDoHActivity.z(null, false);
            } else {
                Throwable thA = uk3.a(objD);
                if (thA == null || (message = thA.getMessage()) == null) {
                    message = "";
                }
                uf4 uf4Var2 = overrideDoHActivity.S0;
                if (uf4Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) uf4Var2.f;
                coordinatorLayout2.getClass();
                String string = overrideDoHActivity.getString(R.string.doh_server_verify_failed_with_url, message);
                string.getClass();
                oy3.h(coordinatorLayout2, string, 0).j();
            }
            return xl4.a;
        }
        xw0Var = this.X;
        n12.S(obj);
        objD = ((uk3) obj).b;
        p95.e(xw0Var.b);
        synchronized (xw0Var.d) {
            xw0Var.d.clear();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.z0;
        if (jCurrentTimeMillis < 500) {
            this.X = null;
            this.Y = objD;
            this.Z = 2;
            if (gb4.E(500 - jCurrentTimeMillis, this) != mf0Var) {
                obj2 = objD;
                objD = obj2;
            }
            return mf0Var;
        }
        this.A0.dismiss();
        if (objD instanceof tk3) {
        }
        return xl4.a;
    }
}
