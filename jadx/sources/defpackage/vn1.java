package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vn1 {
    public final ws0 a;
    public final on1[] b;
    public String[] c;
    public final pn1[] d;
    public volatile boolean e = false;

    public vn1(ws0 ws0Var, String[] strArr) {
        this.a = ws0Var;
        this.c = strArr;
        this.b = new on1[ws0Var.y0.length];
        this.d = new pn1[ws0Var.B0.length];
    }

    public final void a(Class cls, Class cls2) {
        Class cls3;
        Class cls4;
        if (this.e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.e) {
                    return;
                }
                int length = this.b.length;
                int i = 0;
                int i2 = 0;
                while (true) {
                    String str = null;
                    if (i2 >= length) {
                        break;
                    }
                    ft0 ft0Var = this.a.y0[i2];
                    kt0 kt0Var = ft0Var.C0;
                    if (kt0Var != null) {
                        int i3 = kt0Var.f + length;
                        String[] strArr = this.c;
                        if (i3 < strArr.length) {
                            str = strArr[i3];
                        }
                    }
                    String str2 = str;
                    if (ft0Var.y()) {
                        if (ft0Var.r().b == ct0.MESSAGE) {
                            boolean zT = ft0Var.t();
                            on1[] on1VarArr = this.b;
                            if (zT) {
                                on1VarArr[i2] = new eg0(ft0Var, cls);
                            } else {
                                on1VarArr[i2] = new rn1(cls, cls2, this.c[i2]);
                            }
                        } else {
                            ct0 ct0Var = ft0Var.r().b;
                            ct0 ct0Var2 = ct0.ENUM;
                            on1[] on1VarArr2 = this.b;
                            if (ct0Var == ct0Var2) {
                                on1VarArr2[i2] = new qn1(ft0Var, this.c[i2], cls, cls2);
                            } else {
                                on1VarArr2[i2] = new eg0(cls, cls2, this.c[i2]);
                            }
                        }
                        cls3 = cls;
                        cls4 = cls2;
                    } else if (ft0Var.r().b == ct0.MESSAGE) {
                        cls3 = cls;
                        cls4 = cls2;
                        this.b[i2] = new tn1(ft0Var, this.c[i2], cls3, cls4, str2);
                    } else {
                        cls3 = cls;
                        cls4 = cls2;
                        if (ft0Var.r().b == ct0.ENUM) {
                            this.b[i2] = new sn1(ft0Var, this.c[i2], cls3, cls4, str2);
                        } else {
                            ct0 ct0Var3 = ft0Var.r().b;
                            ct0 ct0Var4 = ct0.STRING;
                            on1[] on1VarArr3 = this.b;
                            if (ct0Var3 == ct0Var4) {
                                on1VarArr3[i2] = new un1(ft0Var, this.c[i2], cls3, cls4, str2);
                            } else {
                                on1VarArr3[i2] = new a40(ft0Var, this.c[i2], cls3, cls4, str2);
                            }
                        }
                    }
                    i2++;
                    cls = cls3;
                    cls2 = cls4;
                }
                Class cls5 = cls;
                Class cls6 = cls2;
                while (true) {
                    ws0 ws0Var = this.a;
                    if (i >= ws0Var.B0.length) {
                        this.e = true;
                        this.c = null;
                        return;
                    }
                    int i4 = ws0Var.C0;
                    pn1[] pn1VarArr = this.d;
                    if (i < i4) {
                        pn1VarArr[i] = new ed4(ws0Var, this.c[i + length], cls5, cls6);
                    } else {
                        pn1VarArr[i] = new ha1(ws0Var, i);
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final on1 b(ft0 ft0Var) {
        if (ft0Var.B0 != this.a) {
            xe.k("FieldDescriptor does not match message type.");
            return null;
        }
        if (!ft0Var.z.Q()) {
            return this.b[ft0Var.f];
        }
        xe.k("This type does not have extensions.");
        return null;
    }

    public final pn1 c(kt0 kt0Var) {
        if (kt0Var.X == this.a) {
            return this.d[kt0Var.f];
        }
        xe.k("OneofDescriptor does not match message type.");
        return null;
    }
}
