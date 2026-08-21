package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class el3 implements hm3 {
    public final me3 a;

    public el3(me3 me3Var) {
        me3Var.getClass();
        this.a = me3Var;
    }

    @Override // defpackage.hm3
    public final hm3 a() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // defpackage.hm3
    public final me3 b() {
        return this.a;
    }

    @Override // defpackage.hm3
    public final gm3 c() {
        throw new IllegalStateException("already connected");
    }

    @Override // defpackage.hm3
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // defpackage.hm3
    public final gm3 f() {
        throw new IllegalStateException("already connected");
    }

    @Override // defpackage.hm3
    public final boolean isReady() {
        return true;
    }
}
