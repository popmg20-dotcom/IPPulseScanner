package defpackage;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class aj extends v74 implements Function2 {
    public /* synthetic */ Object A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ Object C0;
    public final /* synthetic */ int X = 2;
    public int Y;
    public Object Z;
    public Object y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(jj jjVar, Uri uri, char[] cArr, u6 u6Var, z00 z00Var, pl1 pl1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = jjVar;
        this.y0 = uri;
        this.z0 = cArr;
        this.A0 = u6Var;
        this.B0 = z00Var;
        this.C0 = pl1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((aj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((aj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 2:
                return ((aj) n((ge0) obj2, obj)).p(xl4Var);
            default:
                return ((aj) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.C0;
        Object obj3 = this.B0;
        switch (i) {
            case 0:
                return new aj((jj) this.Z, (Uri) this.y0, (char[]) this.z0, (u6) this.A0, (z00) obj3, (pl1) obj2, ge0Var);
            case 1:
                aj ajVar = new aj((tc2) this.A0, (m20) obj3, (gx4) obj2, ge0Var);
                ajVar.z0 = obj;
                return ajVar;
            case 2:
                aj ajVar2 = new aj((List) obj3, (ArrayList) obj2, ge0Var);
                ajVar2.A0 = obj;
                return ajVar2;
            default:
                aj ajVar3 = new aj((List) this.z0, (xw0) this.A0, (String) obj3, (byte[]) obj2, ge0Var);
                ajVar3.y0 = obj;
                return ajVar3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f8  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v3, types: [v32] */
    /* JADX WARN: Type inference failed for: r3v5, types: [v32] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0115 -> B:36:0x00f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x013e -> B:36:0x00f2). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aj.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(tc2 tc2Var, m20 m20Var, gx4 gx4Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.A0 = tc2Var;
        this.B0 = m20Var;
        this.C0 = gx4Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(List list, xw0 xw0Var, String str, byte[] bArr, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = list;
        this.A0 = xw0Var;
        this.B0 = str;
        this.C0 = bArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(List list, ArrayList arrayList, ge0 ge0Var) {
        super(2, ge0Var);
        this.B0 = list;
        this.C0 = arrayList;
    }
}
