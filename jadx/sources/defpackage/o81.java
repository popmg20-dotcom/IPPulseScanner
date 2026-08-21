package defpackage;

import android.content.Context;
import android.content.Intent;
import com.getsurfboard.ui.service.ExplorerService;
import java.net.InetSocketAddress;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o81 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public int Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ q81 y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o81(q81 q81Var, String str, int i, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = q81Var;
        this.Z = str;
        this.Y = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((o81) n(ge0Var, lf0Var)).p(xl4Var);
                return xl4Var;
            default:
                return ((o81) n(ge0Var, lf0Var)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        q81 q81Var = this.y0;
        String str = this.Z;
        switch (i) {
            case 0:
                return new o81(q81Var, str, this.Y, ge0Var);
            default:
                return new o81(str, q81Var, ge0Var);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        q81 q81Var = this.y0;
        String str = this.Z;
        switch (i) {
            case 0:
                n12.S(obj);
                int i2 = ExplorerService.y0;
                Context contextRequireContext = q81Var.requireContext();
                contextRequireContext.getClass();
                n81 n81Var = q81Var.H0;
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, this.Y);
                n81Var.getClass();
                Intent intentPutExtra = new Intent(contextRequireContext, (Class<?>) ExplorerService.class).putExtra("address", inetSocketAddress);
                intentPutExtra.getClass();
                contextRequireContext.bindService(intentPutExtra, n81Var, 1);
                return xl4Var;
            default:
                int i3 = this.Y;
                ge0 ge0Var = null;
                mf0 mf0Var = mf0.b;
                if (i3 == 0) {
                    n12.S(obj);
                    gm0 gm0Var = qv0.a;
                    pl0 pl0Var = pl0.z;
                    p81 p81Var = new p81(str, ge0Var, 0);
                    this.Y = 1;
                    obj = ji0.b0(pl0Var, p81Var, this);
                    if (obj != mf0Var) {
                    }
                    return mf0Var;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                int iIntValue = ((Number) obj).intValue();
                gm0 gm0Var2 = qv0.a;
                tq1 tq1Var = qf2.a;
                o81 o81Var = new o81(q81Var, str, iIntValue, null);
                this.Y = 2;
                if (ji0.b0(tq1Var, o81Var, this) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o81(String str, q81 q81Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = str;
        this.y0 = q81Var;
    }
}
