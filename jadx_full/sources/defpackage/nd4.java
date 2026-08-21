package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class nd4 {
    public static final br1 a = new br1("NO_THREAD_ELEMENTS", 3);
    public static final dt b = new dt(26);
    public static final dt c = new dt(27);
    public static final dt d = new dt(28);

    public static final void a(cf0 cf0Var, Object obj) {
        if (obj == a) {
            return;
        }
        if (!(obj instanceof ud4)) {
            Object objC0 = cf0Var.c0(null, c);
            objC0.getClass();
            ((pd4) objC0).f.set(obj);
            return;
        }
        ud4 ud4Var = (ud4) obj;
        pd4[] pd4VarArr = ud4Var.c;
        int length = pd4VarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            pd4 pd4Var = pd4VarArr[length];
            pd4Var.getClass();
            pd4Var.f.set(ud4Var.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    public static final Object b(cf0 cf0Var) {
        Object objC0 = cf0Var.c0(0, b);
        objC0.getClass();
        return objC0;
    }

    public static final Object c(cf0 cf0Var, Object obj) {
        if (obj == null) {
            obj = b(cf0Var);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return cf0Var.c0(new ud4(((Number) obj).intValue(), cf0Var), d);
        }
        pd4 pd4Var = (pd4) obj;
        ThreadLocal threadLocal = pd4Var.f;
        Object obj2 = threadLocal.get();
        threadLocal.set(pd4Var.b);
        return obj2;
    }
}
