package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bc2 extends es2 {
    public es2 a;
    public bc2 b;

    public bc2(es2 es2Var, bc2 bc2Var, int i) {
        super(i);
        this.a = es2Var;
        if (es2Var != null) {
            es2Var.parent = this;
        }
        this.b = bc2Var;
        if (bc2Var != null) {
            bc2Var.parent = this;
        }
    }

    public static void a(bc2 bc2Var, es2 es2Var) {
        bc2 bc2VarC = c(null, es2Var);
        while (true) {
            bc2 bc2Var2 = bc2Var.b;
            if (bc2Var2 == null) {
                bc2Var.b = bc2VarC;
                return;
            }
            bc2Var = bc2Var2;
        }
    }

    public static bc2 b(bc2 bc2Var, es2 es2Var) {
        return new bc2(es2Var, bc2Var, 9);
    }

    public static bc2 c(bc2 bc2Var, es2 es2Var) {
        return new bc2(es2Var, bc2Var, 8);
    }

    @Override // defpackage.es2
    public final String getName() {
        int i = this.type;
        if (i == 8) {
            return "List";
        }
        if (i == 9) {
            return "Alt";
        }
        throw new l12("internal parser error (bug)");
    }

    @Override // defpackage.es2
    public final void setChild(es2 es2Var) {
        this.a = es2Var;
    }

    @Override // defpackage.es2
    public final String toString(int i) {
        String str = "\n  value: " + es2.pad(this.a, 1);
        StringBuilder sb = new StringBuilder("\n  tail: ");
        bc2 bc2Var = this.b;
        sb.append(bc2Var == null ? "NULL" : bc2Var.toString());
        return str.concat(sb.toString());
    }
}
