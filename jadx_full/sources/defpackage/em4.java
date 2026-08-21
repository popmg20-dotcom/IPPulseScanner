package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class em4 {
    public static dm4 a(Object obj) {
        co1 co1Var = (co1) obj;
        dm4 dm4Var = co1Var.unknownFields;
        if (dm4Var != dm4.f) {
            return dm4Var;
        }
        dm4 dm4Var2 = new dm4(0, new int[8], new Object[8], true);
        co1Var.unknownFields = dm4Var2;
        return dm4Var2;
    }

    public static boolean b(int i, r02 r02Var, Object obj) throws t12 {
        p60 p60Var = (p60) r02Var.d;
        int i2 = r02Var.a;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            r02Var.C(0);
            ((dm4) obj).c(i3 << 3, Long.valueOf(p60Var.n()));
            return true;
        }
        if (i4 == 1) {
            r02Var.C(1);
            ((dm4) obj).c((i3 << 3) | 1, Long.valueOf(p60Var.k()));
            return true;
        }
        if (i4 == 2) {
            ((dm4) obj).c((i3 << 3) | 2, r02Var.j());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw t12.b();
            }
            r02Var.C(5);
            ((dm4) obj).c(5 | (i3 << 3), Integer.valueOf(p60Var.j()));
            return true;
        }
        dm4 dm4Var = new dm4(0, new int[8], new Object[8], true);
        int i5 = i3 << 3;
        int i6 = i5 | 4;
        int i7 = i + 1;
        if (i7 >= 100) {
            throw new t12("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (r02Var.f() != Integer.MAX_VALUE && b(i7, r02Var, dm4Var)) {
        }
        if (i6 != r02Var.a) {
            throw new t12("Protocol message end-group tag did not match expected tag.");
        }
        if (dm4Var.e) {
            dm4Var.e = false;
        }
        ((dm4) obj).c(i5 | 3, dm4Var);
        return true;
    }
}
