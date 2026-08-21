package defpackage;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class eo1 extends i52 {
    public static final int Z = (h52.WRITE_NUMBERS_AS_STRINGS.f | h52.ESCAPE_NON_ASCII.f) | h52.STRICT_DUPLICATE_DETECTION.f;
    public boolean A;
    public lb4 X;
    public boolean Y;
    public int f;
    public final vv1 z;

    public eo1(int i, vv1 vv1Var) {
        this.f = i;
        this.z = vv1Var;
        this.X = new lb4(0, null, h52.STRICT_DUPLICATE_DETECTION.a(i) ? new iv1(this) : null);
        this.A = h52.WRITE_NUMBERS_AS_STRINGS.a(i);
    }

    public final String K0(BigDecimal bigDecimal) throws g52 {
        if (!h52.WRITE_BIGDECIMAL_AS_PLAIN.a(this.f)) {
            return bigDecimal.toString();
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -9999 && iScale <= 9999) {
            return bigDecimal.toPlainString();
        }
        g(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(iScale), 9999, 9999));
        throw null;
    }

    public abstract void L0(String str);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.Y) {
            return;
        }
        this.z.close();
        this.Y = true;
    }

    @Override // defpackage.i52
    public final void s(Object obj) {
        lb4 lb4Var = this.X;
        if (lb4Var != null) {
            lb4Var.j = obj;
        }
    }

    @Override // defpackage.i52
    public final boolean x(h52 h52Var) {
        return (this.f & h52Var.f) != 0;
    }
}
