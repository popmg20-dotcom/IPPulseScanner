package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class j8 extends d5 implements o8 {
    public long b;
    public boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ i8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8(i8 i8Var, j5 j5Var, boolean z) {
        super(j5Var);
        this.e = i8Var;
        this.d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // j$.util.stream.h5, java.util.function.IntConsumer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void accept(int r7) {
        /*
            r6 = this;
            boolean r0 = r6.c
            if (r0 != 0) goto L15
            j$.util.stream.i8 r0 = r6.e
            java.util.function.IntPredicate r0 = r0.m
            boolean r0 = r0.test(r7)
            r1 = r0 ^ 1
            r6.c = r1
            if (r0 != 0) goto L13
            goto L15
        L13:
            r0 = 0
            goto L16
        L15:
            r0 = 1
        L16:
            boolean r1 = r6.d
            if (r1 == 0) goto L23
            if (r0 != 0) goto L23
            long r2 = r6.b
            r4 = 1
            long r2 = r2 + r4
            r6.b = r2
        L23:
            if (r1 != 0) goto L29
            if (r0 == 0) goto L28
            goto L29
        L28:
            return
        L29:
            j$.util.stream.j5 r6 = r6.a
            r6.accept(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.j8.accept(int):void");
    }

    @Override // j$.util.stream.o8
    public final long h() {
        return this.b;
    }
}
