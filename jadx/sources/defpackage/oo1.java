package defpackage;

import android.net.Uri;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oo1 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ boolean Z;
    public Object y0;
    public /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(String str, boolean z, po1 po1Var, iv1 iv1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 0;
        this.y0 = str;
        this.Z = z;
        this.z0 = po1Var;
        this.A0 = iv1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((oo1) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.A0;
        switch (i) {
            case 0:
                return new oo1((String) this.y0, this.Z, (po1) this.z0, (iv1) obj2, ge0Var);
            case 1:
                return new oo1((ProfileEditorActivity) this.z0, (Uri) obj2, this.Z, ge0Var, 1);
            case 2:
                return new oo1((ProfileEditorActivity) this.z0, (String) this.y0, (String) obj2, this.Z, ge0Var);
            case 3:
                oo1 oo1Var = new oo1((d83) this.z0, (List) obj2, this.Z, ge0Var, 3);
                oo1Var.y0 = obj;
                return oo1Var;
            default:
                oo1 oo1Var2 = new oo1((e24) obj2, this.Z, ge0Var);
                oo1Var2.z0 = obj;
                return oo1Var2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x03f8, code lost:
    
        if (defpackage.ji0.V(r1, r3, r13, r12, r8, r22) != r10) goto L163;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0395 A[Catch: Exception -> 0x0323, OutOfMemoryError -> 0x0326, TryCatch #3 {Exception -> 0x0323, OutOfMemoryError -> 0x0326, blocks: (B:114:0x031e, B:121:0x032e, B:134:0x037e, B:136:0x0395, B:138:0x039b, B:140:0x03a1, B:142:0x03a5, B:144:0x03a9, B:146:0x03b4, B:147:0x03c3, B:148:0x03c6, B:149:0x03c7, B:150:0x03ca, B:151:0x03cb, B:153:0x03cf, B:154:0x03da, B:155:0x03dd, B:156:0x03de, B:157:0x03e3, B:158:0x03e4, B:124:0x0338, B:131:0x0360, B:127:0x0342), top: B:188:0x0310 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0258  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 1220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oo1.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(ProfileEditorActivity profileEditorActivity, String str, String str2, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 2;
        this.z0 = profileEditorActivity;
        this.y0 = str;
        this.A0 = str2;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ oo1(Object obj, Object obj2, boolean z, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.z0 = obj;
        this.A0 = obj2;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(e24 e24Var, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 4;
        this.A0 = e24Var;
        this.Z = z;
    }
}
