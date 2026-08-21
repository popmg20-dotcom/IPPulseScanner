package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k34 extends l34 {
    public final Serializable A;
    public final /* synthetic */ int z = 0;

    public k34(nj4 nj4Var, String str) {
        super(Object.class);
        this.A = str;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws o12 {
        int i = this.z;
        Serializable serializable = this.A;
        switch (i) {
            case 0:
                if (gt3Var.b.h(dt3.WRITE_ENUMS_USING_TO_STRING)) {
                    i52Var.Q(obj.toString());
                    return;
                }
                Enum r3 = (Enum) obj;
                if (gt3Var.b.h(dt3.WRITE_ENUM_KEYS_USING_INDEX)) {
                    i52Var.Q(String.valueOf(r3.ordinal()));
                    return;
                } else {
                    i52Var.N(((ft3[]) ((l9) serializable).z)[r3.ordinal()]);
                    return;
                }
            default:
                gt3Var.A((String) serializable);
                throw null;
        }
    }

    public k34(Class cls, l9 l9Var) {
        super(cls, 0);
        this.A = l9Var;
    }
}
