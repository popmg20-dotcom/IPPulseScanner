package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jd2 extends iq4 {
    public static final ck1 c = new ck1(1);
    public final tz3 b = new tz3();

    @Override // defpackage.iq4
    public final void d() {
        tz3 tz3Var = this.b;
        int i = tz3Var.z;
        if (i > 0) {
            tz3Var.d(0).getClass();
            st4.n();
            return;
        }
        Object[] objArr = tz3Var.f;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        tz3Var.z = 0;
    }
}
