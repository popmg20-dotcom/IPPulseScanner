package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class lb3 {
    public static final tu0 a = new tu0("Direct", (tn) null, 6);
    public static final ii3 b = new ii3("Reject");
    public static final li3 c = new li3("RejectDrop", false, tn.z);

    public static final String a(ea3 ea3Var) {
        ea3Var.getClass();
        if (ea3Var instanceof ms4) {
            return ((ms4) ea3Var).f;
        }
        if (ea3Var instanceof mu3) {
            return ((mu3) ea3Var).f;
        }
        if (ea3Var instanceof jv1) {
            return ((jv1) ea3Var).f;
        }
        if (ea3Var instanceof sy3) {
            return ((sy3) ea3Var).f;
        }
        if (ea3Var instanceof s9) {
            return ((s9) ea3Var).f;
        }
        if (ea3Var instanceof xh4) {
            return ((xh4) ea3Var).f;
        }
        if (ea3Var instanceof ai4) {
            return ((ai4) ea3Var).f;
        }
        if (ea3Var instanceof ou1) {
            return ((ou1) ea3Var).f;
        }
        if (ea3Var instanceof gv1) {
            return ((gv1) ea3Var).f;
        }
        if (ea3Var instanceof zy3) {
            return ((zy3) ea3Var).f;
        }
        if (ea3Var instanceof az3) {
            return ((az3) ea3Var).f;
        }
        if (ea3Var instanceof fw4) {
            return (String) ((fw4) ea3Var).Z.A.b;
        }
        return null;
    }

    public static final Integer b(ea3 ea3Var) {
        if (ea3Var instanceof ms4) {
            return Integer.valueOf(((ms4) ea3Var).z);
        }
        if (ea3Var instanceof mu3) {
            return Integer.valueOf(((mu3) ea3Var).z);
        }
        if (ea3Var instanceof jv1) {
            return Integer.valueOf(((jv1) ea3Var).z);
        }
        if (ea3Var instanceof sy3) {
            return Integer.valueOf(((sy3) ea3Var).z);
        }
        if (ea3Var instanceof s9) {
            return Integer.valueOf(((s9) ea3Var).z);
        }
        if (ea3Var instanceof xh4) {
            return Integer.valueOf(((xh4) ea3Var).z);
        }
        if (ea3Var instanceof ai4) {
            return Integer.valueOf(((ai4) ea3Var).z);
        }
        if (ea3Var instanceof ou1) {
            return Integer.valueOf(((ou1) ea3Var).z);
        }
        if (ea3Var instanceof gv1) {
            return Integer.valueOf(((gv1) ea3Var).z);
        }
        if (ea3Var instanceof zy3) {
            return Integer.valueOf(((zy3) ea3Var).z);
        }
        if (ea3Var instanceof az3) {
            return Integer.valueOf(((az3) ea3Var).z);
        }
        if (ea3Var instanceof fw4) {
            return (Integer) ((fw4) ea3Var).Z.A.f;
        }
        return null;
    }

    public static final boolean c(int i) {
        return 1 <= i && i < 65536;
    }
}
