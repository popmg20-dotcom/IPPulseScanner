package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y85 extends dc5 {
    private static final y85 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        y85 y85Var = new y85();
        zzg = y85Var;
        dc5.k(y85.class, y85Var);
    }

    public static x85 o() {
        return (x85) zzg.f();
    }

    public static y85 p() {
        return zzg;
    }

    @Override // defpackage.dc5
    public final Object m(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new qd5(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", j55.n, "zze", j55.l, "zzf", j55.m});
        }
        if (i2 == 3) {
            return new y85();
        }
        if (i2 == 4) {
            return new x85(zzg);
        }
        if (i2 == 5) {
            return zzg;
        }
        throw null;
    }

    public final int n() {
        int iM = qe4.m(this.zze);
        if (iM == 0) {
            return 1;
        }
        return iM;
    }

    public final void q(int i) {
        this.zze = qe4.n(i);
        this.zzb |= 2;
    }

    public final int r() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = 4;
                    if (i2 != 3) {
                        i = i2 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[PHI: r2
      0x0017: PHI (r2v1 int) = (r2v0 int), (r2v2 int) binds: [B:7:0x0009, B:11:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s() {
        /*
            r3 = this;
            int r3 = r3.zzf
            r0 = 1
            if (r3 == 0) goto L19
            r1 = 2
            if (r3 == r0) goto L1a
            r2 = 3
            if (r3 == r1) goto L17
            r1 = 4
            if (r3 == r2) goto L1a
            r2 = 5
            if (r3 == r1) goto L17
            if (r3 == r2) goto L15
            r1 = 0
            goto L1a
        L15:
            r1 = 6
            goto L1a
        L17:
            r1 = r2
            goto L1a
        L19:
            r1 = r0
        L1a:
            if (r1 != 0) goto L1d
            return r0
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y85.s():int");
    }

    public final /* synthetic */ void t(int i) {
        this.zzd = i - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void u(int i) {
        this.zzf = i - 1;
        this.zzb |= 4;
    }
}
