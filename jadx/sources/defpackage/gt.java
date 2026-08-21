package defpackage;

import android.app.ApplicationExitInfo;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.tencent.mars.xlog.Xlog;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gt extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ Object Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gt(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Throwable {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                ((gt) n((ge0) obj2, (qc0) obj)).p(xl4Var);
                return xl4Var;
            case 2:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 6:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 7:
                ((gt) n((ge0) obj2, (ag1) obj)).p(xl4Var);
                return xl4Var;
            case 8:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
            case 10:
                return ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                ((gt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return xl4Var;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.Y;
        switch (i) {
            case 0:
                return new gt((BypassConfigActivity) obj2, ge0Var, 0);
            case 1:
                return new gt((gx4) obj2, ge0Var, 1);
            case 2:
                return new gt((jv0) obj2, ge0Var, 2);
            case 3:
                return new gt((ApplicationExitInfo) obj2, ge0Var, 3);
            case 4:
                return new gt((Uri) obj2, ge0Var, 4);
            case 5:
                return new gt((HostsListActivity) obj2, ge0Var, 5);
            case 6:
                return new gt((Context) obj2, ge0Var, 6);
            case 7:
                return new gt((gn2) obj2, ge0Var, 7);
            case 8:
                return new gt((String[]) obj2, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new gt((e03[]) obj2, ge0Var, 9);
            case 10:
                return new gt((Network) obj2, ge0Var, 10);
            default:
                return new gt((jr4) obj2, ge0Var, 11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01bd  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gt.p(java.lang.Object):java.lang.Object");
    }
}
