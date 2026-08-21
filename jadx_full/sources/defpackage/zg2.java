package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zg2 extends yg2 {
    public static final long A0;
    public static final long z0;
    public final m34 A;
    public final uf2 X;
    public final o82 Y;
    public final ma0 Z;
    public final tj0 y0;
    public final dx3 z;

    static {
        long j = 0;
        for (ah2 ah2Var : ah2.values()) {
            if (ah2Var.b) {
                j |= ah2Var.f;
            }
        }
        z0 = j;
        A0 = ah2.AUTO_DETECT_FIELDS.f | ah2.AUTO_DETECT_GETTERS.f | ah2.AUTO_DETECT_IS_GETTERS.f | ah2.AUTO_DETECT_SETTERS.f | ah2.AUTO_DETECT_CREATORS.f;
    }

    public zg2(zg2 zg2Var, long j) {
        super(zg2Var, j);
        this.z = zg2Var.z;
        this.A = zg2Var.A;
        this.Y = zg2Var.Y;
        this.X = zg2Var.X;
        this.Z = zg2Var.Z;
        this.y0 = zg2Var.y0;
    }

    @Override // defpackage.g50
    public final Class a(Class cls) {
        return null;
    }

    public zg2(jl jlVar, m34 m34Var, dx3 dx3Var, o82 o82Var, ma0 ma0Var, tj0 tj0Var) {
        super(jlVar, z0);
        this.z = dx3Var;
        this.A = m34Var;
        this.Y = o82Var;
        this.X = zd0.C0;
        this.Z = ma0Var;
        this.y0 = tj0Var;
    }
}
