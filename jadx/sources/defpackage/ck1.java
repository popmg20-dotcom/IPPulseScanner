package defpackage;

import androidx.fragment.app.v;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ck1 implements mq4 {
    public static ck1 b;
    public final /* synthetic */ int a;

    public /* synthetic */ ck1(int i) {
        this.a = i;
    }

    @Override // defpackage.mq4
    public iq4 a(Class cls) {
        switch (this.a) {
            case 0:
                return new v(true);
            case 1:
                return new jd2();
            case 2:
                throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
            default:
                return vo.j(cls);
        }
    }

    @Override // defpackage.mq4
    public iq4 b(Class cls, in2 in2Var) {
        switch (this.a) {
            case 0:
                return a(cls);
            case 1:
                return a(cls);
            case 2:
                a(cls);
                throw null;
            default:
                return a(cls);
        }
    }

    @Override // defpackage.mq4
    public final iq4 c(j50 j50Var, in2 in2Var) {
        switch (this.a) {
            case 0:
                Class cls = j50Var.a;
                cls.getClass();
                return b(cls, in2Var);
            case 1:
                Class cls2 = j50Var.a;
                cls2.getClass();
                return b(cls2, in2Var);
            case 2:
                return new ep3();
            default:
                Class cls3 = j50Var.a;
                cls3.getClass();
                return b(cls3, in2Var);
        }
    }
}
