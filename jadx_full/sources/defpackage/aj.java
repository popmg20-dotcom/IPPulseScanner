package defpackage;

import android.content.SharedPreferences;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
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
    */
    public final Object p(Object obj) throws Throwable {
        Object objC;
        nc2 nc2Var;
        AtomicInteger atomicInteger;
        Object objK;
        Object objE;
        List list;
        Iterator it;
        Object objA;
        ov3 ov3Var;
        Object objE2;
        xp xpVar;
        int i = this.X;
        ?? r3 = 3;
        Object obj2 = this.C0;
        Object obj3 = this.B0;
        mf0 mf0Var = mf0.b;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                u6 u6Var = (u6) this.A0;
                z00 z00Var = (z00) obj3;
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    jj jjVar = (jj) this.Z;
                    Uri uri = (Uri) this.y0;
                    char[] cArr = (char[]) this.z0;
                    this.Y = 1;
                    objC = jjVar.c(uri, cArr, this);
                    if (objC == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    objC = obj;
                }
                yi yiVar = (yi) objC;
                if (yiVar instanceof wi) {
                    u6Var.dismiss();
                    if (z00Var.v() instanceof ps2) {
                        z00Var.d(((wi) yiVar).a);
                    }
                } else if (n12.c(yiVar, xi.a)) {
                    ((pl1) obj2).a();
                } else {
                    if (!n12.c(yiVar, vi.a)) {
                        g.d();
                        return null;
                    }
                    u6Var.dismiss();
                    if (z00Var.v() instanceof ps2) {
                        z00Var.d(null);
                    }
                }
                return xl4.a;
            case 1:
                tc2 tc2Var = (tc2) this.A0;
                int i3 = this.Y;
                try {
                    try {
                        if (i3 == 0) {
                            n12.S(obj);
                            lf0 lf0Var = (lf0) this.z0;
                            AtomicInteger atomicInteger2 = new AtomicInteger(-256);
                            yv yvVarB = tc2Var.b();
                            z14 z14VarB = ji0.B(lf0Var, null, null, new hd((m20) obj3, (gx4) obj2, atomicInteger2, yvVarB, null, 3), 3);
                            try {
                                this.z0 = atomicInteger2;
                                this.Z = yvVarB;
                                this.y0 = z14VarB;
                                this.Y = 1;
                                objK = gb4.k(yvVarB, this);
                                if (objK == mf0Var) {
                                    return mf0Var;
                                }
                                nc2Var = yvVarB;
                                atomicInteger = atomicInteger2;
                                r3 = z14VarB;
                            } catch (CancellationException e) {
                                e = e;
                                nc2Var = yvVarB;
                                atomicInteger = atomicInteger2;
                                String str = ic0.a;
                                ue2.g().d(str, "Delegated worker " + tc2Var.getClass() + " was cancelled", e);
                                i = atomicInteger.get() != -256 ? 1 : 0;
                                if (nc2Var.isCancelled() || i == 0) {
                                    throw e;
                                }
                                throw new dc0(atomicInteger.get());
                            }
                        } else {
                            if (i3 != 1) {
                                xe.q("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            z14 z14Var = (z14) this.y0;
                            nc2Var = (nc2) this.Z;
                            atomicInteger = (AtomicInteger) this.z0;
                            try {
                                n12.S(obj);
                                objK = obj;
                                r3 = z14Var;
                            } catch (CancellationException e2) {
                                e = e2;
                                String str2 = ic0.a;
                                ue2.g().d(str2, "Delegated worker " + tc2Var.getClass() + " was cancelled", e);
                                if (atomicInteger.get() != -256) {
                                }
                                if (nc2Var.isCancelled()) {
                                }
                                throw e;
                            }
                        }
                        sc2 sc2Var = (sc2) objK;
                        r3.g(null);
                        return sc2Var;
                    } catch (Throwable th) {
                        String str3 = ic0.a;
                        ue2.g().d(str3, "Delegated worker " + tc2Var.getClass() + " threw exception in startWork.", th);
                        throw th;
                    }
                } catch (Throwable th2) {
                    r3.g(null);
                    throw th2;
                }
            case 2:
                int i4 = this.Y;
                if (i4 == 0) {
                    n12.S(obj);
                    objE = this.A0;
                    list = (ArrayList) obj2;
                    it = ((List) obj3).iterator();
                } else if (i4 == 1) {
                    objE = this.z0;
                    ov3 ov3Var2 = (ov3) this.y0;
                    Iterator it2 = (Iterator) this.Z;
                    List list2 = (List) this.A0;
                    n12.S(obj);
                    ov3Var = ov3Var2;
                    it = it2;
                    list = list2;
                    objA = obj;
                    if (((Boolean) objA).booleanValue()) {
                        list.add(new ni0(ov3Var, ge0Var, i));
                        this.A0 = list;
                        this.Z = it;
                        this.y0 = null;
                        this.z0 = null;
                        this.Y = 2;
                        objE = ov3Var.b.e(new tv3((SharedPreferences) ov3Var.e.getValue(), ov3Var.f), objE, this);
                        if (objE == mf0Var) {
                            return mf0Var;
                        }
                    }
                } else {
                    if (i4 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    Iterator it3 = (Iterator) this.Z;
                    List list3 = (List) this.A0;
                    n12.S(obj);
                    list = list3;
                    it = it3;
                    objE = obj;
                }
                if (!it.hasNext()) {
                    ov3Var = (ov3) it.next();
                    this.A0 = list;
                    this.Z = it;
                    this.y0 = ov3Var;
                    this.z0 = objE;
                    this.Y = 1;
                    objA = ov3Var.a(objE, this);
                    if (objA == mf0Var) {
                        return mf0Var;
                    }
                    if (((Boolean) objA).booleanValue()) {
                    }
                    if (!it.hasNext()) {
                        return objE;
                    }
                }
                break;
            default:
                lf0 lf0Var2 = (lf0) this.y0;
                int i5 = this.Y;
                if (i5 == 0) {
                    n12.S(obj);
                    xp xpVarA = uf2.a(1, null, new ji(4), 2);
                    List list4 = (List) this.z0;
                    xw0 xw0Var = (xw0) this.A0;
                    String str4 = (String) obj3;
                    byte[] bArr = (byte[]) obj2;
                    Iterator it4 = list4.iterator();
                    while (it4.hasNext()) {
                        ji0.B(lf0Var2, null, null, new fj(xw0Var, str4, (String) it4.next(), bArr, xpVarA, null), 3);
                    }
                    this.y0 = lf0Var2;
                    this.Z = xpVarA;
                    this.Y = 1;
                    objE2 = xp.E(xpVarA, this);
                    if (objE2 == mf0Var) {
                        return mf0Var;
                    }
                    xpVar = xpVarA;
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    xpVar = (xp) this.Z;
                    n12.S(obj);
                    objE2 = ((l30) obj).a;
                }
                if (objE2 instanceof k30) {
                    objE2 = null;
                }
                e03 e03Var = (e03) objE2;
                xpVar.b(null);
                v32 v32Var = (v32) lf0Var2.I().Z(pr1.X);
                if (v32Var == null) {
                    return e03Var;
                }
                Iterator it5 = v32Var.s().iterator();
                while (it5.hasNext()) {
                    ((v32) it5.next()).g(null);
                }
                return e03Var;
        }
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
