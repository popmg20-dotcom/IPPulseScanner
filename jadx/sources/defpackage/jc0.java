package defpackage;

import android.view.View;
import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jc0 {
    public int A;
    public float B;
    public final int[] C;
    public float D;
    public boolean E;
    public int F;
    public int G;
    public final lb0 H;
    public final lb0 I;
    public final lb0 J;
    public final lb0 K;
    public final lb0 L;
    public final lb0 M;
    public final lb0 N;
    public final lb0 O;
    public final lb0[] P;
    public final ArrayList Q;
    public final boolean[] R;
    public kc0 S;
    public int T;
    public int U;
    public float V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int a0;
    public q20 b;
    public int b0;
    public q20 c;
    public float c0;
    public float d0;
    public View e0;
    public int f0;
    public String g0;
    public int h0;
    public int i0;
    public String j;
    public final float[] j0;
    public boolean k;
    public final jc0[] k0;
    public boolean l;
    public final jc0[] l0;
    public boolean m;
    public int m0;
    public boolean n;
    public int n0;
    public int o;
    public final int[] o0;
    public int p;
    public int q;
    public int r;
    public int s;
    public final int[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public float z;
    public boolean a = false;
    public ks1 d = null;
    public dp4 e = null;
    public final boolean[] f = {true, true};
    public boolean g = true;
    public int h = -1;
    public int i = -1;

    public jc0() {
        new HashMap();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = new int[2];
        this.u = 0;
        this.v = 0;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{ChannelUtils.WRITE_STATUS_SNDBUF_FULL, ChannelUtils.WRITE_STATUS_SNDBUF_FULL};
        this.D = Float.NaN;
        this.E = false;
        this.F = 0;
        this.G = 0;
        lb0 lb0Var = new lb0(this, 2);
        this.H = lb0Var;
        lb0 lb0Var2 = new lb0(this, 3);
        this.I = lb0Var2;
        lb0 lb0Var3 = new lb0(this, 4);
        this.J = lb0Var3;
        lb0 lb0Var4 = new lb0(this, 5);
        this.K = lb0Var4;
        lb0 lb0Var5 = new lb0(this, 6);
        this.L = lb0Var5;
        lb0 lb0Var6 = new lb0(this, 8);
        this.M = lb0Var6;
        lb0 lb0Var7 = new lb0(this, 9);
        this.N = lb0Var7;
        lb0 lb0Var8 = new lb0(this, 7);
        this.O = lb0Var8;
        this.P = new lb0[]{lb0Var, lb0Var3, lb0Var2, lb0Var4, lb0Var5, lb0Var8};
        ArrayList arrayList = new ArrayList();
        this.Q = arrayList;
        this.R = new boolean[2];
        this.o0 = new int[]{1, 1};
        this.S = null;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.c0 = 0.5f;
        this.d0 = 0.5f;
        this.f0 = 0;
        this.g0 = null;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = new float[]{-1.0f, -1.0f};
        this.k0 = new jc0[]{null, null};
        this.l0 = new jc0[]{null, null};
        this.m0 = -1;
        this.n0 = -1;
        arrayList.add(lb0Var);
        arrayList.add(lb0Var2);
        arrayList.add(lb0Var3);
        arrayList.add(lb0Var4);
        arrayList.add(lb0Var6);
        arrayList.add(lb0Var7);
        arrayList.add(lb0Var8);
        arrayList.add(lb0Var5);
    }

    public static void D(int i, int i2, String str, StringBuilder sb) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public static void E(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    public static void m(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f, int i6) {
        String str2;
        sb.append(str);
        sb.append(" :  {\n");
        if (i6 == 1) {
            str2 = "FIXED";
        } else if (i6 == 2) {
            str2 = "WRAP_CONTENT";
        } else if (i6 == 3) {
            str2 = "MATCH_CONSTRAINT";
        } else {
            if (i6 != 4) {
                throw null;
            }
            str2 = "MATCH_PARENT";
        }
        if (!"FIXED".equals(str2)) {
            ha0.v(sb, "      behavior", " :   ", str2, ",\n");
        }
        D(i, 0, "      size", sb);
        D(i2, 0, "      min", sb);
        D(i3, ChannelUtils.WRITE_STATUS_SNDBUF_FULL, "      max", sb);
        D(i4, 0, "      matchMin", sb);
        D(i5, 0, "      matchDef", sb);
        E(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    public static void n(StringBuilder sb, String str, lb0 lb0Var) {
        if (lb0Var.f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(lb0Var.f);
        sb.append("'");
        if (lb0Var.h != Integer.MIN_VALUE || lb0Var.g != 0) {
            sb.append(",");
            sb.append(lb0Var.g);
            if (lb0Var.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(lb0Var.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public void A() {
        this.H.g();
        this.I.g();
        this.J.g();
        this.K.g();
        this.L.g();
        this.M.g();
        this.N.g();
        this.O.g();
        this.S = null;
        this.D = Float.NaN;
        this.T = 0;
        this.U = 0;
        this.V = 0.0f;
        this.W = -1;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0.5f;
        this.d0 = 0.5f;
        int[] iArr = this.o0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.e0 = null;
        this.f0 = 0;
        this.h0 = 0;
        this.i0 = 0;
        float[] fArr = this.j0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr2 = this.C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.r = 0;
        this.s = 0;
        this.w = 1.0f;
        this.z = 1.0f;
        this.v = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.y = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.u = 0;
        this.x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        boolean[] zArr2 = this.R;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr3 = this.t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.h = -1;
        this.i = -1;
    }

    public final void B() {
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        ArrayList arrayList = this.Q;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            lb0 lb0Var = (lb0) arrayList.get(i);
            lb0Var.c = false;
            lb0Var.b = 0;
        }
    }

    public void C(ed4 ed4Var) {
        this.H.h();
        this.I.h();
        this.J.h();
        this.K.h();
        this.L.h();
        this.O.h();
        this.M.h();
        this.N.h();
    }

    public final void F(int i, int i2) {
        if (this.k) {
            return;
        }
        this.H.i(i);
        this.J.i(i2);
        this.X = i;
        this.T = i2 - i;
        this.k = true;
    }

    public final void G(int i, int i2) {
        if (this.l) {
            return;
        }
        this.I.i(i);
        this.K.i(i2);
        this.Y = i;
        this.U = i2 - i;
        if (this.E) {
            this.L.i(i + this.Z);
        }
        this.l = true;
    }

    public final void H(int i) {
        this.U = i;
        int i2 = this.b0;
        if (i < i2) {
            this.U = i2;
        }
    }

    public final void I(int i) {
        this.o0[0] = i;
    }

    public final void J(int i) {
        this.o0[1] = i;
    }

    public final void K(int i) {
        this.T = i;
        int i2 = this.a0;
        if (i < i2) {
            this.T = i2;
        }
    }

    public void L(boolean z, boolean z2) {
        int i;
        int i2;
        ks1 ks1Var = this.d;
        boolean z3 = z & ks1Var.g;
        dp4 dp4Var = this.e;
        boolean z4 = z2 & dp4Var.g;
        int i3 = ks1Var.h.g;
        int i4 = dp4Var.h.g;
        int i5 = ks1Var.i.g;
        int i6 = dp4Var.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.X = i3;
        }
        if (z4) {
            this.Y = i4;
        }
        if (this.f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.o0;
        if (z3) {
            if (iArr[0] == 1 && i8 < (i2 = this.T)) {
                i8 = i2;
            }
            this.T = i8;
            int i10 = this.a0;
            if (i8 < i10) {
                this.T = i10;
            }
        }
        if (z4) {
            if (iArr[1] == 1 && i9 < (i = this.U)) {
                i9 = i;
            }
            this.U = i9;
            int i11 = this.b0;
            if (i9 < i11) {
                this.U = i11;
            }
        }
    }

    public void M(gb2 gb2Var, boolean z) {
        int i;
        int i2;
        dp4 dp4Var;
        ks1 ks1Var;
        gb2Var.getClass();
        int iN = gb2.n(this.H);
        int iN2 = gb2.n(this.I);
        int iN3 = gb2.n(this.J);
        int iN4 = gb2.n(this.K);
        if (z && (ks1Var = this.d) != null) {
            oo0 oo0Var = ks1Var.h;
            if (oo0Var.j) {
                oo0 oo0Var2 = ks1Var.i;
                if (oo0Var2.j) {
                    iN = oo0Var.g;
                    iN3 = oo0Var2.g;
                }
            }
        }
        if (z && (dp4Var = this.e) != null) {
            oo0 oo0Var3 = dp4Var.h;
            if (oo0Var3.j) {
                oo0 oo0Var4 = dp4Var.i;
                if (oo0Var4.j) {
                    iN2 = oo0Var3.g;
                    iN4 = oo0Var4.g;
                }
            }
        }
        int i3 = iN4 - iN2;
        if (iN3 - iN < 0 || i3 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i4 = iN3 - iN;
        int i5 = iN4 - iN2;
        this.X = iN;
        this.Y = iN2;
        if (this.f0 == 8) {
            this.T = 0;
            this.U = 0;
            return;
        }
        int[] iArr = this.o0;
        int i6 = iArr[0];
        if (i6 == 1 && i4 < (i2 = this.T)) {
            i4 = i2;
        }
        if (iArr[1] == 1 && i5 < (i = this.U)) {
            i5 = i;
        }
        this.T = i4;
        this.U = i5;
        int i7 = this.b0;
        if (i5 < i7) {
            this.U = i7;
        }
        int i8 = this.a0;
        if (i4 < i8) {
            this.T = i8;
        } else {
            i8 = i4;
        }
        int i9 = this.v;
        if (i9 > 0 && i6 == 3) {
            this.T = Math.min(i8, i9);
        }
        int i10 = this.y;
        if (i10 > 0 && iArr[1] == 3) {
            this.U = Math.min(this.U, i10);
        }
        int i11 = this.T;
        if (i4 != i11) {
            this.h = i11;
        }
        int i12 = this.U;
        if (i5 != i12) {
            this.i = i12;
        }
    }

    public final void a(kc0 kc0Var, gb2 gb2Var, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            ye.e(kc0Var, gb2Var, this);
            hashSet.remove(this);
            b(gb2Var, kc0Var.S(64));
        }
        if (i == 0) {
            HashSet hashSet2 = this.H.a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((lb0) it.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
                }
            }
            HashSet hashSet3 = this.J.a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((lb0) it2.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.I.a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((lb0) it3.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
            }
        }
        HashSet hashSet5 = this.K.a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((lb0) it4.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
            }
        }
        HashSet hashSet6 = this.L.a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((lb0) it5.next()).d.a(kc0Var, gb2Var, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0413 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x041c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fb  */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r17v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v6 */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v27, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r58v0, types: [jc0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(defpackage.gb2 r59, boolean r60) {
        /*
            Method dump skipped, instruction units count: 1919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jc0.b(gb2, boolean):void");
    }

    public boolean c() {
        return this.f0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x03bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0493 A[PHI: r0
      0x0493: PHI (r0v15 int) = (r0v14 int), (r0v19 int), (r0v19 int), (r0v19 int) binds: [B:280:0x0483, B:282:0x0489, B:283:0x048b, B:285:0x048f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(defpackage.gb2 r30, boolean r31, boolean r32, boolean r33, boolean r34, defpackage.jz3 r35, defpackage.jz3 r36, int r37, boolean r38, defpackage.lb0 r39, defpackage.lb0 r40, int r41, int r42, int r43, int r44, float r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, int r51, int r52, int r53, int r54, float r55, boolean r56) {
        /*
            Method dump skipped, instruction units count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jc0.d(gb2, boolean, boolean, boolean, boolean, jz3, jz3, int, boolean, lb0, lb0, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(gb2 gb2Var) {
        gb2Var.k(this.H);
        gb2Var.k(this.I);
        gb2Var.k(this.J);
        gb2Var.k(this.K);
        if (this.Z > 0) {
            gb2Var.k(this.L);
        }
    }

    public final void f() {
        if (this.d == null) {
            ks1 ks1Var = new ks1(this);
            ks1Var.h.e = 4;
            ks1Var.i.e = 5;
            ks1Var.f = 0;
            this.d = ks1Var;
        }
        if (this.e == null) {
            dp4 dp4Var = new dp4(this);
            oo0 oo0Var = new oo0(dp4Var);
            dp4Var.k = oo0Var;
            dp4Var.l = null;
            dp4Var.h.e = 6;
            dp4Var.i.e = 7;
            oo0Var.e = 8;
            dp4Var.f = 1;
            this.e = dp4Var;
        }
    }

    public lb0 g(int i) {
        switch (fw.G(i)) {
            case 0:
                return null;
            case 1:
                return this.H;
            case 2:
                return this.I;
            case 3:
                return this.J;
            case 4:
                return this.K;
            case 5:
                return this.L;
            case 6:
                return this.O;
            case 7:
                return this.M;
            case 8:
                return this.N;
            default:
                xe.i(ha0.A(i));
                return null;
        }
    }

    public final int h(int i) {
        int[] iArr = this.o0;
        if (i == 0) {
            return iArr[0];
        }
        if (i == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int i() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.U;
    }

    public final jc0 j(int i) {
        lb0 lb0Var;
        lb0 lb0Var2;
        if (i != 0) {
            if (i == 1 && (lb0Var2 = (lb0Var = this.K).f) != null && lb0Var2.f == lb0Var) {
                return lb0Var2.d;
            }
            return null;
        }
        lb0 lb0Var3 = this.J;
        lb0 lb0Var4 = lb0Var3.f;
        if (lb0Var4 == null || lb0Var4.f != lb0Var3) {
            return null;
        }
        return lb0Var4.d;
    }

    public final jc0 k(int i) {
        lb0 lb0Var;
        lb0 lb0Var2;
        if (i != 0) {
            if (i == 1 && (lb0Var2 = (lb0Var = this.I).f) != null && lb0Var2.f == lb0Var) {
                return lb0Var2.d;
            }
            return null;
        }
        lb0 lb0Var3 = this.H;
        lb0 lb0Var4 = lb0Var3.f;
        if (lb0Var4 == null || lb0Var4.f != lb0Var3) {
            return null;
        }
        return lb0Var4.d;
    }

    public void l(StringBuilder sb) {
        sb.append("  " + this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.T);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.U);
        sb.append("\n");
        sb.append("    actualLeft:" + this.X);
        sb.append("\n");
        sb.append("    actualTop:" + this.Y);
        sb.append("\n");
        n(sb, "left", this.H);
        n(sb, "top", this.I);
        n(sb, "right", this.J);
        n(sb, "bottom", this.K);
        n(sb, "baseline", this.L);
        n(sb, "centerX", this.M);
        n(sb, "centerY", this.N);
        int i = this.T;
        int i2 = this.a0;
        int[] iArr = this.C;
        int i3 = iArr[0];
        int i4 = this.u;
        int i5 = this.r;
        float f = this.w;
        int[] iArr2 = this.o0;
        int i6 = iArr2[0];
        float[] fArr = this.j0;
        float f2 = fArr[0];
        m(sb, "    width", i, i2, i3, i4, i5, f, i6);
        int i7 = this.U;
        int i8 = this.b0;
        int i9 = iArr[1];
        int i10 = this.x;
        int i11 = this.s;
        float f3 = this.z;
        int i12 = iArr2[1];
        float f4 = fArr[1];
        m(sb, "    height", i7, i8, i9, i10, i11, f3, i12);
        float f5 = this.V;
        int i13 = this.W;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i13);
            sb.append("");
            sb.append("],\n");
        }
        E(sb, "    horizontalBias", this.c0, 0.5f);
        E(sb, "    verticalBias", this.d0, 0.5f);
        D(this.h0, 0, "    horizontalChainStyle", sb);
        D(this.i0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int o() {
        if (this.f0 == 8) {
            return 0;
        }
        return this.T;
    }

    public final int p() {
        kc0 kc0Var = this.S;
        return kc0Var != null ? kc0Var.w0 + this.X : this.X;
    }

    public final int q() {
        kc0 kc0Var = this.S;
        return kc0Var != null ? kc0Var.x0 + this.Y : this.Y;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            lb0 r5 = r4.H
            lb0 r5 = r5.f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            lb0 r4 = r4.J
            lb0 r4 = r4.f
            if (r4 == 0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = r1
        L17:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            lb0 r5 = r4.I
            lb0 r5 = r5.f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            lb0 r3 = r4.K
            lb0 r3 = r3.f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            lb0 r4 = r4.L
            lb0 r4 = r4.f
            if (r4 == 0) goto L36
            r4 = r2
            goto L37
        L36:
            r4 = r1
        L37:
            int r5 = r5 + r4
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jc0.r(int):boolean");
    }

    public final boolean s(int i, int i2) {
        lb0 lb0Var;
        lb0 lb0Var2;
        lb0 lb0Var3;
        lb0 lb0Var4;
        if (i == 0) {
            lb0 lb0Var5 = this.H;
            lb0 lb0Var6 = lb0Var5.f;
            if (lb0Var6 == null || !lb0Var6.c || (lb0Var4 = (lb0Var3 = this.J).f) == null || !lb0Var4.c) {
                return false;
            }
            return (lb0Var4.c() - lb0Var3.d()) - (lb0Var5.d() + lb0Var5.f.c()) >= i2;
        }
        lb0 lb0Var7 = this.I;
        lb0 lb0Var8 = lb0Var7.f;
        if (lb0Var8 == null || !lb0Var8.c || (lb0Var2 = (lb0Var = this.K).f) == null || !lb0Var2.c) {
            return false;
        }
        return (lb0Var2.c() - lb0Var.d()) - (lb0Var7.d() + lb0Var7.f.c()) >= i2;
    }

    public final void t(int i, int i2, int i3, int i4, jc0 jc0Var) {
        g(i).a(jc0Var.g(i2), i3, i4);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.g0 != null ? fw.y(new StringBuilder("id: "), this.g0, " ") : "");
        sb.append("(");
        sb.append(this.X);
        sb.append(", ");
        sb.append(this.Y);
        sb.append(") - (");
        sb.append(this.T);
        sb.append(" x ");
        return fw.w(")", sb, this.U);
    }

    public final boolean u(int i) {
        lb0 lb0Var;
        lb0 lb0Var2;
        int i2 = i * 2;
        lb0[] lb0VarArr = this.P;
        lb0 lb0Var3 = lb0VarArr[i2];
        lb0 lb0Var4 = lb0Var3.f;
        return (lb0Var4 == null || lb0Var4.f == lb0Var3 || (lb0Var2 = (lb0Var = lb0VarArr[i2 + 1]).f) == null || lb0Var2.f != lb0Var) ? false : true;
    }

    public final boolean v() {
        lb0 lb0Var = this.H;
        lb0 lb0Var2 = lb0Var.f;
        if (lb0Var2 != null && lb0Var2.f == lb0Var) {
            return true;
        }
        lb0 lb0Var3 = this.J;
        lb0 lb0Var4 = lb0Var3.f;
        return lb0Var4 != null && lb0Var4.f == lb0Var3;
    }

    public final boolean w() {
        lb0 lb0Var = this.I;
        lb0 lb0Var2 = lb0Var.f;
        if (lb0Var2 != null && lb0Var2.f == lb0Var) {
            return true;
        }
        lb0 lb0Var3 = this.K;
        lb0 lb0Var4 = lb0Var3.f;
        return lb0Var4 != null && lb0Var4.f == lb0Var3;
    }

    public final boolean x() {
        return this.g && this.f0 != 8;
    }

    public boolean y() {
        if (this.k) {
            return true;
        }
        return this.H.c && this.J.c;
    }

    public boolean z() {
        if (this.l) {
            return true;
        }
        return this.I.c && this.K.c;
    }
}
