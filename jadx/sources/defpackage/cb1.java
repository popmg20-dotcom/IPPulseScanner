package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cb1 implements hm3 {
    public final gm3 a;

    public cb1(Throwable th) {
        this.a = new gm3(this, null, th, 2);
    }

    @Override // defpackage.hm3
    public final hm3 a() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // defpackage.hm3
    public final me3 b() {
        throw new IllegalStateException("unexpected call");
    }

    @Override // defpackage.hm3
    public final gm3 c() {
        return this.a;
    }

    @Override // defpackage.hm3
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // defpackage.hm3
    public final gm3 f() {
        return this.a;
    }

    @Override // defpackage.hm3
    public final boolean isReady() {
        return false;
    }
}
