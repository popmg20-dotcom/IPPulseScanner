package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w10 extends r82 implements pl1 {
    public static final w10 A;
    public static final w10 z;
    public final /* synthetic */ int f;

    static {
        int i = 0;
        z = new w10(i, 0);
        A = new w10(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w10(int i, int i2) {
        super(i);
        this.f = i2;
    }

    @Override // defpackage.pl1
    public final Object a() {
        switch (this.f) {
            case 0:
                return null;
            default:
                return xl4.a;
        }
    }
}
