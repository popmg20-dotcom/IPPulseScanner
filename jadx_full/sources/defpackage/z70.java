package defpackage;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class z70 extends v74 implements Function2 {
    public /* synthetic */ Object A0;
    public final /* synthetic */ zf1[] B0;
    public final /* synthetic */ cj C0;
    public final /* synthetic */ cv D0;
    public final /* synthetic */ ag1 E0;
    public y20 X;
    public byte[] Y;
    public int Z;
    public int y0;
    public int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z70(zf1[] zf1VarArr, cj cjVar, cv cvVar, ag1 ag1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.B0 = zf1VarArr;
        this.C0 = cjVar;
        this.D0 = cvVar;
        this.E0 = ag1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((z70) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        z70 z70Var = new z70(this.B0, this.C0, this.D0, this.E0, ge0Var);
        z70Var.A0 = obj;
        return z70Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0075, code lost:
    
        if (r8 != 0) goto L20;
     */
    /* JADX WARN: Path cross not found for [B:42:0x00b8, B:36:0x00a7], limit reached: 45 */
    /* JADX WARN: Path cross not found for [B:43:0x00ba, B:20:0x0075], limit reached: 45 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[LOOP:0: B:31:0x0097->B:48:?, LOOP_START, PHI: r8 r12
      0x0097: PHI (r8v3 int) = (r8v2 int), (r8v4 int) binds: [B:28:0x0092, B:48:?] A[DONT_GENERATE, DONT_INLINE]
      0x0097: PHI (r12v4 tz1) = (r12v3 tz1), (r12v10 tz1) binds: [B:28:0x0092, B:48:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00dc -> B:20:0x0075). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        int length;
        Object[] objArr;
        byte[] bArr;
        int i;
        y20 y20Var;
        Object objK;
        tz1 tz1Var;
        int i2 = this.z0;
        br1 br1Var = at2.b;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(obj);
            lf0 lf0Var = (lf0) this.A0;
            length = this.B0.length;
            if (length != 0) {
                objArr = new Object[length];
                Arrays.fill(objArr, 0, length, br1Var);
                xp xpVarA = uf2.a(length, null, null, 6);
                AtomicInteger atomicInteger = new AtomicInteger(length);
                for (int i3 = 0; i3 < length; i3++) {
                    ji0.B(lf0Var, null, null, new y70(this.B0, i3, atomicInteger, xpVarA, null), 3);
                }
                bArr = new byte[length];
                i = 0;
                y20Var = xpVarA;
            }
            return xl4.a;
        }
        if (i2 == 1) {
            i = this.y0;
            length = this.Z;
            bArr = this.Y;
            y20Var = this.X;
            objArr = (Object[]) this.A0;
            n12.S(obj);
            objK = ((l30) obj).a;
            if (objK instanceof k30) {
                objK = null;
            }
            tz1Var = (tz1) objK;
            if (tz1Var != null) {
                while (true) {
                    int i4 = tz1Var.a;
                    Object obj2 = objArr[i4];
                    objArr[i4] = tz1Var.b;
                    if (obj2 == br1Var) {
                        length--;
                    }
                    if (bArr[i4] != i) {
                        bArr[i4] = (byte) i;
                        Object objI = y20Var.i();
                        if (objI instanceof k30) {
                            objI = null;
                        }
                        tz1Var = (tz1) objI;
                        if (tz1Var != null) {
                        }
                    }
                    if (length == 0) {
                        qc0[] qc0VarArr = new qc0[((zf1[]) this.C0.f).length];
                        qe.f0(0, 0, 14, objArr, qc0VarArr);
                        this.A0 = objArr;
                        this.X = y20Var;
                        this.Y = bArr;
                        this.Z = length;
                        this.y0 = i;
                        this.z0 = 3;
                        if (this.D0.e(this.E0, qc0VarArr, this) != mf0Var) {
                            break;
                        }
                    }
                }
                return mf0Var;
            }
            return xl4.a;
        }
        if (i2 != 2 && i2 != 3) {
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = this.y0;
        length = this.Z;
        bArr = this.Y;
        y20Var = this.X;
        objArr = (Object[]) this.A0;
        n12.S(obj);
        i = (byte) (i + 1);
        this.A0 = objArr;
        this.X = y20Var;
        this.Y = bArr;
        this.Z = length;
        this.y0 = i;
        this.z0 = 1;
        objK = y20Var.k(this);
        if (objK != mf0Var) {
            if (objK instanceof k30) {
            }
            tz1Var = (tz1) objK;
            if (tz1Var != null) {
            }
            return xl4.a;
        }
        return mf0Var;
    }
}
