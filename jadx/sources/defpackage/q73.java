package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q73 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q73(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
        this.z0 = obj3;
        this.A0 = obj4;
        this.B0 = obj5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((q73) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.B0;
        Object obj3 = this.A0;
        Object obj4 = this.z0;
        Object obj5 = this.y0;
        Object obj6 = this.Z;
        switch (i) {
            case 0:
                return new q73((d83) obj6, (String) obj5, (String) obj4, (Throwable) obj3, (Context) obj2, ge0Var, 0);
            default:
                return new q73((ry1) obj6, (te3) obj5, (wx3) obj4, (z51) obj3, (Bitmap) obj2, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        Object obj2 = this.B0;
        Object obj3 = this.A0;
        Object obj4 = this.z0;
        Object obj5 = this.y0;
        Object obj6 = this.Z;
        mf0 mf0Var = mf0.b;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                String str = (String) obj4;
                d83 d83Var = (d83) obj6;
                int i2 = this.Y;
                xl4 xl4Var = xl4.a;
                try {
                    try {
                        if (i2 == 0) {
                            n12.S(obj);
                            y3 y3Var = d83Var.b;
                            y3Var.getClass();
                            ((LinearProgressIndicator) y3Var.g).e();
                            e1 e1Var = d73.a;
                            p12 p12VarC = d73.c((String) obj5, str, ((Throwable) obj3).getMessage());
                            this.Y = 1;
                            gm0 gm0Var = qv0.a;
                            Object objB0 = ji0.b0(pl0.z, new gd(p12VarC, str, ge0Var, 14), this);
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
                        y3 y3Var2 = d83Var.b;
                        y3Var2.getClass();
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var2.a;
                        coordinatorLayout.getClass();
                        r25.R(coordinatorLayout, R.string.invalid_profile_imported, new Object[0]);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        CharSequence text = ((Context) obj2).getText(R.string.unknown_error);
                        text.getClass();
                        d83Var.o(e, text, null, null, null);
                    }
                    return xl4Var;
                } finally {
                    y3 y3Var3 = d83Var.b;
                    y3Var3.getClass();
                    ((LinearProgressIndicator) y3Var3.g).b();
                }
            default:
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
                ry1 ry1Var = (ry1) obj6;
                e10 e10Var = new e10(ry1Var, ((te3) obj5).g, 0, ry1Var, (wx3) obj4, (z51) obj3, ((Bitmap) obj2) != null);
                this.Y = 1;
                Object objK = e10Var.k(ry1Var, this);
                return objK == mf0Var ? mf0Var : objK;
        }
    }
}
