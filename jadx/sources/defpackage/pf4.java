package defpackage;

import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.ToolsFragment;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pf4 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public int Y;
    public final /* synthetic */ Preference Z;
    public final /* synthetic */ ToolsFragment y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf4(Preference preference, ToolsFragment toolsFragment, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = preference;
        this.y0 = toolsFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((pf4) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        ToolsFragment toolsFragment = this.y0;
        Preference preference = this.Z;
        switch (i) {
            case 0:
                return new pf4(toolsFragment, preference, ge0Var);
            default:
                return new pf4(preference, toolsFragment, ge0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7 A[Catch: IOException -> 0x001e, IllegalArgumentException -> 0x0021, ActivityNotFoundException -> 0x0024, TRY_LEAVE, TryCatch #2 {ActivityNotFoundException -> 0x0024, IOException -> 0x001e, IllegalArgumentException -> 0x0021, blocks: (B:8:0x0019, B:17:0x002d, B:23:0x0048, B:25:0x0090, B:27:0x0098, B:29:0x00a2, B:30:0x00b1, B:31:0x00b6, B:32:0x00b7, B:20:0x0035), top: B:49:0x0013 }] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pf4.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pf4(ToolsFragment toolsFragment, Preference preference, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = toolsFragment;
        this.Z = preference;
    }
}
