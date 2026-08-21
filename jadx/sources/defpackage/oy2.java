package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oy2 {
    public final gz2 a;
    public final ue2 b;
    public final lb c = new lb(27);
    public final lb d = new lb(27);
    public final zf1 e = ez4.U(new hj(this, null, 25));

    public oy2(gz2 gz2Var, ue2 ue2Var) {
        this.a = gz2Var;
        this.b = ue2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.hj3 r14, defpackage.ie0 r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof defpackage.ny2
            if (r0 == 0) goto L13
            r0 = r15
            ny2 r0 = (defpackage.ny2) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            ny2 r0 = new ny2
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.X
            mf0 r1 = defpackage.mf0.b
            int r2 = r0.Z
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L30
            if (r2 != r4) goto L2a
            hj3 r14 = r0.A
            defpackage.n12.S(r15)
            goto L40
        L2a:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r13)
            return r3
        L30:
            defpackage.n12.S(r15)
            gz2 r15 = r13.a
            r0.A = r14
            r0.Z = r4
            java.lang.Object r15 = r15.g(r0)
            if (r15 != r1) goto L40
            return r1
        L40:
            hj3 r15 = (defpackage.hj3) r15
            if (r15 == r14) goto La1
            ly2 r4 = new ly2
            java.lang.Class<oy2> r7 = defpackage.oy2.class
            java.lang.String r8 = "invalidate"
            java.lang.String r9 = "invalidate()V"
            r10 = 0
            r11 = 1
            r5 = 0
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r15.b(r4)
            if (r14 == 0) goto L7b
            ly2 r5 = new ly2
            java.lang.String r9 = "invalidate"
            java.lang.String r10 = "invalidate()V"
            r11 = 0
            r12 = 2
            r8 = r7
            r7 = r6
            r6 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            ue1 r13 = r14.a
            java.lang.Object r0 = r13.A
            r1 = r0
            o84 r1 = (defpackage.o84) r1
            monitor-enter(r1)
            java.lang.Object r13 = r13.z     // Catch: java.lang.Throwable -> L77
            java.util.ArrayList r13 = (java.util.ArrayList) r13     // Catch: java.lang.Throwable -> L77
            r13.remove(r5)     // Catch: java.lang.Throwable -> L77
            monitor-exit(r1)
            goto L7b
        L77:
            r0 = move-exception
            r13 = r0
            monitor-exit(r1)
            throw r13
        L7b:
            if (r14 == 0) goto L80
            r14.a()
        L80:
            java.lang.String r13 = android.os.Build.ID
            if (r13 == 0) goto La0
            java.lang.String r13 = "Paging"
            r14 = 3
            boolean r13 = android.util.Log.isLoggable(r13, r14)
            if (r13 == 0) goto La0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Generated new PagingSource "
            r13.<init>(r14)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "Paging"
            android.util.Log.d(r14, r13, r3)
        La0:
            return r15
        La1:
            java.lang.String r13 = "An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource."
            defpackage.xe.q(r13)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oy2.a(hj3, ie0):java.lang.Object");
    }
}
