package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class j52 extends eo1 {
    public static final int[] E0 = v30.f;
    public int A0;
    public ft3 B0;
    public boolean C0;
    public boolean D0;
    public final qv y0;
    public int[] z0;

    public j52(int i, vv1 vv1Var) {
        super(i, vv1Var);
        this.z0 = E0;
        this.B0 = ch2.B0;
        this.y0 = vv1Var.A;
        if (h52.ESCAPE_NON_ASCII.a(i)) {
            this.A0 = 127;
        }
        this.D0 = h52.WRITE_HEX_UPPER_CASE.a(i);
        this.C0 = !h52.QUOTE_FIELD_NAMES.a(i);
    }

    public final void M0(String str) throws g52 {
        g(fw.v("Can not ", str, ", expecting field name (context: ", this.X.h(), ")"));
        throw null;
    }

    public final j52 N0(h52 h52Var) {
        int i = h52Var.f;
        this.f &= ~i;
        if ((i & eo1.Z) != 0) {
            if (h52Var == h52.WRITE_NUMBERS_AS_STRINGS) {
                this.A = false;
            } else if (h52Var == h52.ESCAPE_NON_ASCII) {
                this.A0 = 0;
            } else if (h52Var == h52.STRICT_DUPLICATE_DETECTION) {
                lb4 lb4Var = this.X;
                lb4Var.h = null;
                this.X = lb4Var;
            }
        }
        if (h52Var == h52.QUOTE_FIELD_NAMES) {
            this.C0 = true;
            return this;
        }
        if (h52Var == h52.WRITE_HEX_UPPER_CASE) {
            this.D0 = false;
        }
        return this;
    }
}
