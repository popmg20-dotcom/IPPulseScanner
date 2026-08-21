package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ag2 extends cg2 implements Iterator, z72 {
    public final /* synthetic */ int X;

    public ag2(dg2 dg2Var, int i) {
        this.X = i;
        this.A = dg2Var;
        this.f = -1;
        this.z = dg2Var.y0;
        e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.X) {
            case 0:
                b();
                int i = this.b;
                dg2 dg2Var = (dg2) this.A;
                if (i >= dg2Var.Y) {
                    vp1.g();
                } else {
                    this.b = i + 1;
                    this.f = i;
                    bg2 bg2Var = new bg2(dg2Var, i);
                    e();
                }
                break;
            case 1:
                b();
                int i2 = this.b;
                dg2 dg2Var2 = (dg2) this.A;
                if (i2 >= dg2Var2.Y) {
                    vp1.g();
                } else {
                    this.b = i2 + 1;
                    this.f = i2;
                    Object obj = dg2Var2.b[i2];
                    e();
                }
                break;
            default:
                b();
                int i3 = this.b;
                dg2 dg2Var3 = (dg2) this.A;
                if (i3 >= dg2Var3.Y) {
                    vp1.g();
                } else {
                    this.b = i3 + 1;
                    this.f = i3;
                    Object[] objArr = dg2Var3.f;
                    objArr.getClass();
                    Object obj2 = objArr[this.f];
                    e();
                }
                break;
        }
        return null;
    }
}
