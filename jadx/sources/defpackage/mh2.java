package defpackage;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mh2 extends ue2 {
    public final th3 A;
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public byte[] G0;
    public final k0 X;
    public final byte[] Y;
    public final int Z;
    public final k70 y0;
    public int z0;

    static {
        new InterruptedException();
        new he4();
    }

    public mh2(th3 th3Var, k70 k70Var, byte[] bArr, int i) {
        this.A = th3Var;
        this.X = th3Var.p;
        this.Y = bArr;
        this.Z = i;
        this.y0 = k70Var;
    }

    public static void l(int i, int i2, int i3) {
        if (ja0.M) {
            PrintStream printStream = ja0.G;
            StringBuilder sbA = fw.A(i, i2, "onig_search (entry point): str: 0, end: ", ", start: ", ", range ");
            sbA.append(i3);
            printStream.println(sbA.toString());
        }
    }

    public static boolean o(int i, int i2, k0 k0Var, byte[] bArr) {
        return t.z0.j(k0Var.u(i, i2, bArr), 12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a7, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(int r12, int r13, int r14, int r15, byte[] r16) {
        /*
            r11 = this;
            th3 r9 = r11.A
            int r0 = r9.E
            int r3 = r14 + r0
            r6 = r13
        L7:
            ek0 r0 = r9.u
            r8 = r3
            r1 = r11
            r5 = r12
            r7 = r13
            r4 = r15
            r2 = r16
            int r14 = r0.D(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r6 = -1
            if (r14 == r6) goto L9c
            int r7 = r9.z
            k0 r8 = r11.X
            if (r7 == 0) goto L58
            r10 = 2
            if (r7 == r10) goto L4b
            r10 = 32
            if (r7 == r10) goto L26
            goto L58
        L26:
            if (r14 != r12) goto L3c
            boolean r7 = defpackage.ja0.j
            if (r7 != 0) goto L58
            int r7 = r8.v(r15, r14, r12, r2)
            if (r7 != r6) goto L34
            goto La7
        L34:
            boolean r0 = r8.m(r7, r12, r2)
            if (r0 == 0) goto L58
            r6 = r7
            goto L7
        L3c:
            boolean r7 = r8.m(r14, r12, r2)
            if (r7 != 0) goto L58
            int r14 = r8.v(r15, r14, r12, r2)
            if (r14 != r6) goto L49
            goto La7
        L49:
            r6 = r14
            goto L7
        L4b:
            if (r14 == 0) goto L58
            int r6 = r8.v(r0, r14, r12, r2)
            boolean r0 = r8.m(r6, r12, r2)
            if (r0 != 0) goto L58
            goto L7
        L58:
            int r13 = r9.F
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r0) goto L75
            int r13 = r14 - r13
            r11.E0 = r13
            int r13 = r9.E
            int r14 = r14 - r13
            r11.F0 = r14
            int r13 = r8.q(r15, r14, r12, r2)
            if (r13 >= r14) goto L73
            int r12 = r8.r(r13, r12, r2)
            int r13 = r13 + r12
        L73:
            r11.F0 = r13
        L75:
            boolean r12 = defpackage.ja0.M
            if (r12 == 0) goto L9a
            int r13 = r11.E0
            int r11 = r11.F0
            if (r12 == 0) goto L9a
            java.io.PrintStream r12 = defpackage.ja0.G
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "backward_search_range: low: "
            r14.<init>(r0)
            r14.append(r13)
            java.lang.String r13 = ", high: "
            r14.append(r13)
            r14.append(r11)
            java.lang.String r11 = r14.toString()
            r12.println(r11)
        L9a:
            r11 = 1
            return r11
        L9c:
            boolean r11 = defpackage.ja0.M
            if (r11 == 0) goto La7
            java.io.PrintStream r11 = defpackage.ja0.G
            java.lang.String r12 = "backward_search_range: fail."
            r11.println(r12)
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh2.k(int, int, int, int, byte[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            th3 r0 = r7.A
            int r1 = r0.x
            r2 = 1
            if (r11 >= r1) goto L8
            goto L4a
        L8:
            int r3 = r0.y
            k0 r4 = r7.X
            int r5 = r7.Z
            byte[] r7 = r7.Y
            r6 = 0
            if (r9 <= r8) goto L39
            int r1 = r10 - r8
            if (r1 <= r3) goto L2b
            int r10 = r10 - r3
            if (r10 >= r5) goto L27
            int r8 = r4.q(r6, r10, r5, r7)
            if (r8 >= r10) goto L2b
            int r7 = r4.r(r8, r5, r7)
            int r7 = r7 + r8
            r8 = r7
            goto L2b
        L27:
            int r8 = r4.v(r6, r5, r5, r7)
        L2b:
            int r7 = r9 + (-1)
            int r7 = r11 - r7
            int r10 = r0.x
            if (r7 >= r10) goto L36
            int r11 = r11 - r10
            int r9 = r11 + 1
        L36:
            if (r8 < r9) goto L4b
            goto L4a
        L39:
            int r0 = r10 - r9
            if (r0 <= r3) goto L3f
            int r9 = r10 - r3
        L3f:
            int r10 = r11 - r8
            if (r10 >= r1) goto L48
            int r11 = r11 - r1
            int r8 = r4.q(r6, r11, r5, r7)
        L48:
            if (r9 <= r8) goto L4b
        L4a:
            return r2
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh2.m(int, int, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x0160, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(int r16, int r17, int r18, defpackage.mh2 r19, byte[] r20) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh2.n(int, int, int, mh2, byte[]):boolean");
    }

    public abstract int p(int i, int i2, int i3);

    public final boolean q(int i, int i2, int i3) {
        boolean z = ja0.m;
        th3 th3Var = this.A;
        if (!z) {
            boolean z2 = ja0.q;
            int i4 = this.Z;
            if (z2) {
                return p(i4, i2, i3) != -1 && (th3Var.q & 16) == 0;
            }
            if (p(i4, i2, i3) == -1) {
                return false;
            }
        } else {
            if (ja0.q) {
                return p(i, i2, i3) != -1 && (th3Var.q & 16) == 0;
            }
            if (p(i, i2, i3) == -1) {
                return false;
            }
        }
        return true;
    }

    public final int r() {
        if (!ja0.q || this.z0 < 0) {
            return -1;
        }
        return this.A0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r18 < r20) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r4 = r18 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        if (r2 != 0) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (m(r2, r20, r7, r7) != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
    
        if (r18 < r20) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s(int r18, int r19, int r20) {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mh2.s(int, int, int):int");
    }
}
