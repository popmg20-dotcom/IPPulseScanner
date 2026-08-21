package defpackage;

import android.net.Uri;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.tencent.mars.xlog.Xlog;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w53 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w53(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 3:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 4:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 5:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 6:
                return ((w53) n((ge0) obj2, (kz2) obj)).p(xl4Var);
            case 7:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 8:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 10:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 11:
                return ((w53) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((w53) n((ge0) obj2, obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.y0;
        switch (i) {
            case 0:
                return new w53((ProfileAddMethodsFragment) this.Z, (List) obj2, ge0Var, 0);
            case 1:
                return new w53((ProfileEditorActivity) this.Z, (Throwable) obj2, ge0Var, 1);
            case 2:
                return new w53((ProfileEditorActivity) this.Z, (String) obj2, ge0Var, 2);
            case 3:
                w53 w53Var = new w53((Uri) obj2, ge0Var, 3);
                w53Var.Z = obj;
                return w53Var;
            case 4:
                return new w53((zb3) this.Z, (String) obj2, ge0Var, 4);
            case 5:
                return new w53((te3) this.Z, (ry1) obj2, ge0Var, 5);
            case 6:
                w53 w53Var2 = new w53((RecentRequestsActivity) obj2, ge0Var, 6);
                w53Var2.Z = obj;
                return w53Var2;
            case 7:
                return new w53((pl3) this.Z, (Function2) obj2, ge0Var, 7);
            case 8:
                return new w53((iv1) obj2, ge0Var, 8);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new w53((xp) this.Z, (Function2) obj2, ge0Var, 9);
            case 10:
                return new w53((zz3) this.Z, (String) obj2, ge0Var, 10);
            case 11:
                return new w53((vh4) this.Z, (pl1) obj2, ge0Var, 11);
            default:
                w53 w53Var3 = new w53((ag1) obj2, ge0Var, 12);
                w53Var3.Z = obj;
                return w53Var3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0278, code lost:
    
        if (r6.k(r0, r5) != r12) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0132  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:144:0x0278 -> B:146:0x027c). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w53.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w53(Object obj, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = obj;
    }
}
