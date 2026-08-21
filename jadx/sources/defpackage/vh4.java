package defpackage;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vh4 {
    public static final String[] l = {"INSERT", "UPDATE", "DELETE"};
    public final pl3 a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public final boolean d;
    public final x12 e;
    public final String[] g;
    public final ue1 h;
    public final oj1 i;
    public final AtomicBoolean j = new AtomicBoolean(false);
    public pl1 k = new t4(28);
    public final LinkedHashMap f = new LinkedHashMap();

    public vh4(pl3 pl3Var, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, String[] strArr, boolean z, x12 x12Var) {
        String lowerCase;
        this.a = pl3Var;
        this.b = linkedHashMap;
        this.c = linkedHashMap2;
        this.d = z;
        this.e = x12Var;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            this.f.put(lowerCase2, Integer.valueOf(i));
            String str2 = (String) this.b.get(strArr[i]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i] = lowerCase2;
        }
        this.g = strArr2;
        for (Map.Entry entry : this.b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (this.f.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                LinkedHashMap linkedHashMap3 = this.f;
                linkedHashMap3.put(lowerCase4, fh2.T(linkedHashMap3, lowerCase3));
            }
        }
        int length2 = this.g.length;
        ue1 ue1Var = new ue1();
        ue1Var.b = new ReentrantLock();
        ue1Var.z = new long[length2];
        ue1Var.A = new boolean[length2];
        this.h = ue1Var;
        this.i = new oj1(this.g.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.r13 r5, defpackage.ie0 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.lh4
            if (r0 == 0) goto L13
            r0 = r6
            lh4 r0 = (defpackage.lh4) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            lh4 r0 = new lh4
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.X
            int r6 = r0.Z
            r1 = 2
            r2 = 1
            mf0 r3 = defpackage.mf0.b
            if (r6 == 0) goto L3d
            if (r6 == r2) goto L35
            if (r6 != r1) goto L2e
            java.lang.Object r5 = r0.A
            java.util.Set r5 = (java.util.Set) r5
            defpackage.n12.S(r4)
            return r5
        L2e:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L35:
            java.lang.Object r5 = r0.A
            r13 r5 = (defpackage.r13) r5
            defpackage.n12.S(r4)
            goto L53
        L3d:
            defpackage.n12.S(r4)
            q74 r4 = new q74
            r6 = 7
            r4.<init>(r6)
            r0.A = r5
            r0.Z = r2
            java.lang.String r6 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r4 = r5.b(r6, r4, r0)
            if (r4 != r3) goto L53
            goto L67
        L53:
            java.util.Set r4 = (java.util.Set) r4
            boolean r6 = r4.isEmpty()
            if (r6 != 0) goto L68
            r0.A = r4
            r0.Z = r1
            java.lang.String r6 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r5 = defpackage.ji0.o(r5, r6, r0)
            if (r5 != r3) goto L68
        L67:
            return r3
        L68:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh4.a(r13, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.ie0 r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh4.b(ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String[] r5, defpackage.pl1 r6, defpackage.pl1 r7, defpackage.ie0 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof defpackage.qh4
            if (r0 == 0) goto L13
            r0 = r8
            qh4 r0 = (defpackage.qh4) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            qh4 r0 = new qh4
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.Y
            int r1 = r0.y0
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            int[] r4 = r0.X
            pl1 r7 = r0.A
            defpackage.n12.S(r8)     // Catch: java.lang.Throwable -> L29
            goto L50
        L29:
            r4 = move-exception
            goto L7c
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L32:
            defpackage.n12.S(r8)
            e03 r5 = r4.h(r5)
            java.lang.Object r5 = r5.f
            int[] r5 = (int[]) r5
            r6.a()
            r0.A = r7     // Catch: java.lang.Throwable -> L29
            r0.X = r5     // Catch: java.lang.Throwable -> L29
            r0.y0 = r2     // Catch: java.lang.Throwable -> L29
            java.lang.Object r8 = r4.b(r0)     // Catch: java.lang.Throwable -> L29
            mf0 r4 = defpackage.mf0.b
            if (r8 != r4) goto L4f
            return r4
        L4f:
            r4 = r5
        L50:
            java.util.Set r8 = (java.util.Set) r8     // Catch: java.lang.Throwable -> L29
            int r5 = r4.length     // Catch: java.lang.Throwable -> L29
            r6 = 0
            if (r5 != 0) goto L5f
            boolean r4 = r8.isEmpty()     // Catch: java.lang.Throwable -> L29
            if (r4 != 0) goto L5d
            goto L74
        L5d:
            r2 = r6
            goto L74
        L5f:
            int r5 = r4.length     // Catch: java.lang.Throwable -> L29
            r0 = r6
        L61:
            if (r0 >= r5) goto L5d
            r1 = r4[r0]     // Catch: java.lang.Throwable -> L29
            java.lang.Integer r3 = new java.lang.Integer     // Catch: java.lang.Throwable -> L29
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = r8.contains(r3)     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L71
            goto L74
        L71:
            int r0 = r0 + 1
            goto L61
        L74:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L29
            r7.a()
            return r4
        L7c:
            r7.a()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh4.c(java.lang.String[], pl1, pl1, ie0):java.lang.Object");
    }

    public final void d(pl1 pl1Var, pl1 pl1Var2) {
        pl1Var.getClass();
        pl1Var2.getClass();
        if (this.j.compareAndSet(false, true)) {
            pl1Var.a();
            ji0.B(this.a.f(), new hf0(hf0.f), null, new w53(this, pl1Var2, null, 11), 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
    
        if (defpackage.ji0.o(r1, r3, r4) == r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00db, code lost:
    
        if (defpackage.ji0.o(r10, r3, r4) == r8) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00dd, code lost:
    
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00db -> B:28:0x00de). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(defpackage.jg4 r18, int r19, defpackage.ie0 r20) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh4.e(jg4, int, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0089 -> B:19:0x008c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(defpackage.jg4 r8, int r9, defpackage.ie0 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof defpackage.sh4
            if (r0 == 0) goto L13
            r0 = r10
            sh4 r0 = (defpackage.sh4) r0
            int r1 = r0.B0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B0 = r1
            goto L18
        L13:
            sh4 r0 = new sh4
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.z0
            int r1 = r0.B0
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L31
            int r7 = r0.y0
            int r8 = r0.Z
            java.lang.String[] r9 = r0.Y
            java.lang.String r1 = r0.X
            r13 r3 = r0.A
            defpackage.n12.S(r10)
            r10 = r9
            r9 = r3
            goto L8c
        L31:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            r7 = 0
            return r7
        L38:
            defpackage.n12.S(r10)
            java.lang.String[] r7 = r7.g
            r7 = r7[r9]
            java.lang.String[] r9 = defpackage.vh4.l
            r10 = 0
            r1 = 3
            r6 = r1
            r1 = r7
            r7 = r6
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L4a:
            if (r8 >= r7) goto L8e
            r3 = r10[r8]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "room_table_modification_trigger_"
            r4.<init>(r5)
            r4.append(r1)
            r5 = 95
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "DROP TRIGGER IF EXISTS `"
            r4.<init>(r5)
            r4.append(r3)
            r3 = 96
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r0.A = r9
            r0.X = r1
            r0.Y = r10
            r0.Z = r8
            r0.y0 = r7
            r0.B0 = r2
            java.lang.Object r3 = defpackage.ji0.o(r9, r3, r0)
            mf0 r4 = defpackage.mf0.b
            if (r3 != r4) goto L8c
            return r4
        L8c:
            int r8 = r8 + r2
            goto L4a
        L8e:
            xl4 r7 = defpackage.xl4.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh4.f(jg4, int, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(defpackage.ie0 r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof defpackage.th4
            if (r0 == 0) goto L13
            r0 = r7
            th4 r0 = (defpackage.th4) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            th4 r0 = new th4
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.X
            int r1 = r0.Z
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 != r3) goto L2a
            lb r6 = r0.A
            defpackage.n12.S(r7)     // Catch: java.lang.Throwable -> L28
            goto L52
        L28:
            r7 = move-exception
            goto L58
        L2a:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r2
        L30:
            defpackage.n12.S(r7)
            pl3 r7 = r6.a
            lb r1 = r7.f
            boolean r4 = r1.m()
            if (r4 == 0) goto L5c
            ph4 r4 = new ph4     // Catch: java.lang.Throwable -> L56
            r5 = 2
            r4.<init>(r6, r2, r5)     // Catch: java.lang.Throwable -> L56
            r0.A = r1     // Catch: java.lang.Throwable -> L56
            r0.Z = r3     // Catch: java.lang.Throwable -> L56
            r6 = 0
            java.lang.Object r6 = r7.r(r6, r4, r0)     // Catch: java.lang.Throwable -> L56
            mf0 r7 = defpackage.mf0.b
            if (r6 != r7) goto L51
            return r7
        L51:
            r6 = r1
        L52:
            r6.P()
            goto L5c
        L56:
            r7 = move-exception
            r6 = r1
        L58:
            r6.P()
            throw r7
        L5c:
            xl4 r6 = defpackage.xl4.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh4.g(ie0):java.lang.Object");
    }

    public final e03 h(String[] strArr) {
        strArr.getClass();
        cu3 cu3Var = new cu3();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            Set set = (Set) this.c.get(lowerCase);
            if (set != null) {
                cu3Var.addAll(set);
            } else {
                cu3Var.add(str);
            }
        }
        String[] strArr2 = (String[]) yr2.b(cu3Var).toArray(new String[0]);
        int length = strArr2.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArr2[i];
            String lowerCase2 = str2.toLowerCase(Locale.ROOT);
            lowerCase2.getClass();
            Integer num = (Integer) this.f.get(lowerCase2);
            if (num == null) {
                xe.k("There is no table with name ".concat(str2));
                return null;
            }
            iArr[i] = num.intValue();
        }
        return new e03(strArr2, iArr);
    }
}
