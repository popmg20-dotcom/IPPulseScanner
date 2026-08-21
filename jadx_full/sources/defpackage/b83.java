package defpackage;

import android.content.ClipData;
import android.net.Uri;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b83 extends v74 implements Function2 {
    public int X;
    public final /* synthetic */ d83 Y;
    public final /* synthetic */ ClipData Z;
    public final /* synthetic */ int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b83(d83 d83Var, ClipData clipData, int i, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = d83Var;
        this.Z = clipData;
        this.y0 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((b83) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new b83(this.Y, this.Z, this.y0, ge0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        int i = this.X;
        if (i == 0) {
            n12.S(obj);
            d83 d83Var = this.Y;
            r92 lifecycle = d83Var.getLifecycle();
            gm0 gm0Var = qv0.a;
            tq1 tq1Var = qf2.a.X;
            cf0 cf0Var = this.f;
            cf0Var.getClass();
            boolean zQ0 = tq1Var.q0(cf0Var);
            ClipData clipData = this.Z;
            int i2 = this.y0;
            q92 q92Var = q92.X;
            if (zQ0) {
                a83 a83Var = new a83(d83Var, clipData, i2);
                this.X = 1;
                Object objV = ji0.V(lifecycle, q92Var, zQ0, tq1Var, a83Var, this);
                mf0 mf0Var = mf0.b;
                if (objV == mf0Var) {
                    return mf0Var;
                }
            } else {
                if (lifecycle.b() == q92.b) {
                    vp1.m();
                    return null;
                }
                if (lifecycle.b().compareTo(q92Var) >= 0) {
                    Uri uri = clipData.getItemAt(i2).getUri();
                    uri.getClass();
                    d83Var.j(uri);
                }
            }
        } else {
            if (i != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
        }
        return xl4.a;
    }
}
