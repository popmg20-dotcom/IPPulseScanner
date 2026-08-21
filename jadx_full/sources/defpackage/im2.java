package defpackage;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class im2 extends i50 {
    public final String A;

    public im2(nj4 nj4Var, rj4 rj4Var, Collection collection) {
        super(nj4Var, rj4Var, collection);
        String name = nj4Var.L0.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.A = ".";
        } else {
            this.A = name.substring(0, iLastIndexOf + 1);
            name.substring(0, iLastIndexOf);
        }
    }

    @Override // defpackage.i50, defpackage.sj4
    public final String b(Object obj) {
        return c(obj, obj.getClass());
    }

    @Override // defpackage.i50, defpackage.sj4
    public final String c(Object obj, Class cls) {
        String name = sj4.a(cls).getName();
        return name.startsWith(this.A) ? name.substring(r0.length() - 1) : name;
    }
}
