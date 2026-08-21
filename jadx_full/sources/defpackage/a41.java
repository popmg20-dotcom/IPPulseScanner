package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class a41 implements oz1 {
    public final boolean b;

    public a41(boolean z) {
        this.b = z;
    }

    @Override // defpackage.oz1
    public final gs2 b() {
        return null;
    }

    @Override // defpackage.oz1
    public final boolean isActive() {
        return this.b;
    }

    public final String toString() {
        return fw.x(new StringBuilder("Empty{"), this.b ? "Active" : "New", '}');
    }
}
