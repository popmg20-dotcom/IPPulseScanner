package defpackage;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.MainActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.activity.SettingsActivity;
import com.getsurfboard.ui.fragment.FdCountFragment;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mt extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mt(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws Throwable {
        int i = this.X;
        mf0 mf0Var = mf0.b;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 6:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 7:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 8:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return mf0Var;
            case 11:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 13:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 14:
                return ((mt) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 16:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 17:
                ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
                return mf0Var;
            case 18:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 19:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((mt) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = 2;
        switch (this.X) {
            case 0:
                return new mt((BypassConfigActivity) this.Z, ge0Var, 0);
            case 1:
                return new mt((ConstraintTrackingWorker) this.Z, ge0Var, 1);
            case 2:
                return new mt((a81) this.Z, ge0Var, i);
            case 3:
                return new mt((String[]) this.Z, ge0Var, 3);
            case 4:
                return new mt((FdCountFragment) this.Z, ge0Var, 4);
            case 5:
                return new mt((pg1) this.Z, ge0Var, 5);
            case 6:
                return new mt((qp1) this.Z, ge0Var, 6);
            case 7:
                return new mt((HostsListActivity) this.Z, ge0Var, 7);
            case 8:
                return new mt((b32) this.Z, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new mt((se2) this.Z, ge0Var, 9);
            case 10:
                return new mt((MainActivity) this.Z, ge0Var, 10);
            case 11:
                return new mt((tf2) this.Z, ge0Var, 11);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new mt((nj2) this.Z, ge0Var, 12);
            case 13:
                return new mt((MemoryUsageFragment) this.Z, ge0Var, 13);
            case 14:
                mt mtVar = new mt(i, ge0Var);
                mtVar.Z = obj;
                return mtVar;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new mt((RecentRequestsActivity) this.Z, ge0Var, 15);
            case 16:
                return new mt((o80) this.Z, ge0Var, 16);
            case 17:
                return new mt((SettingsActivity) this.Z, ge0Var, 17);
            case 18:
                return new mt((zz3) this.Z, ge0Var, 18);
            case 19:
                return new mt((b84) this.Z, ge0Var, 19);
            default:
                return new mt((vh4) this.Z, ge0Var, 20);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0266, code lost:
    
        if (defpackage.ji0.V(r2, r3, r8, r4, r4, r23) == r10) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0608, code lost:
    
        if (defpackage.ji0.V(r2, r3, r8, r4, r4, r23) == r7) goto L297;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x07cc, code lost:
    
        if (defpackage.ji0.V(r1, r3, r13, r4, r4, r23) == r12) goto L383;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mt.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mt(int i, ge0 ge0Var) {
        super(i, ge0Var);
        this.X = 14;
    }
}
