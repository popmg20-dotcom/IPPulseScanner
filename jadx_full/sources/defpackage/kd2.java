package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kd2 extends id2 {
    public final da2 a;

    public kd2(da2 da2Var, oq4 oq4Var) {
        this.a = da2Var;
        oq4Var.getClass();
        cg0 cg0Var = cg0.b;
        cg0Var.getClass();
        ih4 ih4Var = new ih4(oq4Var, jd2.c, cg0Var);
        j50 j50VarA = dh3.a(jd2.class);
        String strB = j50VarA.b();
        if (strB != null) {
        } else {
            xe.k("Local and anonymous classes can not be ViewModels");
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sbB = fw.B(128, "LoaderManager{");
        sbB.append(Integer.toHexString(System.identityHashCode(this)));
        sbB.append(" in ");
        da2 da2Var = this.a;
        String simpleName = da2Var.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = da2Var.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sbB.append(simpleName);
        sbB.append('{');
        sbB.append(Integer.toHexString(System.identityHashCode(da2Var)));
        sbB.append("}}");
        return sbB.toString();
    }
}
