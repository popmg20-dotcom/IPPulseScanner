package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g11 implements l61 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ g11(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.l61
    public final void a(p60 p60Var, id0 id0Var) {
        int i;
        int i2 = this.b;
        Object obj = this.f;
        switch (i2) {
            case 0:
                nd0 nd0Var = (nd0) p60Var;
                w90 w90Var = ((h11) obj).b;
                int i3 = nd0Var.c;
                q30 q30Var = nd0Var.e;
                q30 q30Var2 = nd0Var.d;
                if (i3 == 2) {
                    int i4 = q30Var2.a;
                    int i5 = q30Var.a - i4;
                    int i6 = w90Var.a;
                    if (i6 <= i4 && (i = w90Var.b) >= i4) {
                        w90Var.b = i + i5;
                    }
                    if (i6 > i4) {
                        w90Var.a = i6 + i5;
                        w90Var.b += i5;
                    }
                } else if (i3 == 3) {
                    int i7 = q30Var2.a;
                    int i8 = q30Var.a;
                    int i9 = i8 - i7;
                    int iMax = Math.max(i7, w90Var.a);
                    int iMin = Math.min(i8, w90Var.b);
                    if (iMin > iMax) {
                        int i10 = w90Var.b - (iMin - iMax);
                        w90Var.b = i10;
                        int i11 = w90Var.a;
                        if (i11 > i7) {
                            int i12 = i11 - i7;
                            w90Var.a = i11 - i12;
                            w90Var.b = i10 - i12;
                        }
                    } else {
                        int i13 = w90Var.a;
                        if (i13 >= i8) {
                            w90Var.a = i13 - i9;
                            w90Var.b -= i9;
                        }
                    }
                }
                break;
            case 1:
                l11 l11Var = (l11) obj;
                oq3 oq3Var = (oq3) p60Var;
                if (!l11Var.X) {
                    id0Var.b = true;
                    l11Var.Y = false;
                } else {
                    int i14 = oq3Var.g;
                    if ((i14 == 2 || i14 == 3 || i14 == 4 || i14 == 5) && l11Var.c(4) && ((Math.abs(oq3Var.e - oq3Var.c) > 80 || Math.abs(oq3Var.f - oq3Var.d) > 80) && l11Var.b.isShowing())) {
                        l11Var.b();
                    } else if (l11Var.c(1)) {
                        l11Var.a(false);
                    }
                }
                break;
            case 2:
                x11 x11Var = (x11) obj;
                if (x11Var.b != null) {
                    x11Var.a();
                }
                break;
            case 3:
                ed4 ed4Var = (ed4) obj;
                if (!((fs3) p60Var).z()) {
                    ed4Var.V(new d4(28, ed4Var));
                }
                break;
            default:
                ((i61) obj).j(p60Var);
                break;
        }
    }
}
