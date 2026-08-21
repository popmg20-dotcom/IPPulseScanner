package defpackage;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class su implements vd0 {
    public final ArrayList A;
    public final int X;
    public final int Y;
    public final ld0 b;
    public final q30 f;
    public final q30 z;

    public su(ld0 ld0Var) {
        q30 q30Var = new q30();
        q30Var.c = 0;
        q30Var.b = 0;
        q30Var.a = 0;
        this.f = q30Var;
        this.z = new q30();
        this.A = new ArrayList();
        this.X = 50;
        this.Y = 50;
        this.b = ld0Var;
        p();
    }

    public static void b(q30 q30Var, int i, int i2) {
        if (q30Var.b != i) {
            xe.k("can not find other lines with findInLine()");
        } else {
            q30Var.a = (q30Var.a - q30Var.c) + i2;
            q30Var.c = i2;
        }
    }

    @Override // defpackage.vd0
    public final synchronized void F(ld0 ld0Var, int i, int i2, int i3, int i4, CharSequence charSequence) {
        try {
            for (q30 q30Var : this.A) {
                int i5 = q30Var.b;
                if (i5 == i) {
                    if (q30Var.c >= i2) {
                        q30Var.a += charSequence.length();
                        q30Var.b = (i3 - i) + q30Var.b;
                        q30Var.c = (q30Var.c + i4) - i2;
                    }
                } else if (i5 > i) {
                    q30Var.a += charSequence.length();
                    q30Var.b = (i3 - i) + q30Var.b;
                }
            }
            p();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.vd0
    public final synchronized void Q(ld0 ld0Var, int i, int i2, int i3, int i4, StringBuilder sb) {
        try {
            ArrayList arrayList = new ArrayList();
            for (q30 q30Var : this.A) {
                int i5 = q30Var.b;
                if (i5 == i) {
                    if (q30Var.c >= i2) {
                        arrayList.add(q30Var);
                    }
                } else if (i5 > i) {
                    if (i5 < i3) {
                        arrayList.add(q30Var);
                    } else if (i5 == i3) {
                        arrayList.add(q30Var);
                    } else {
                        q30Var.a -= sb.length();
                        q30Var.b -= i3 - i;
                    }
                }
            }
            this.A.removeAll(arrayList);
            p();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(q30 q30Var, int i, q30 q30Var2) {
        int i2 = q30Var.a;
        if (i2 < i) {
            xe.k("Unable to find forward from method findIndexBackward()");
            return;
        }
        int i3 = q30Var.b;
        int iMax = q30Var.c;
        while (i2 > i) {
            i2 -= iMax + 1;
            i3--;
            if (i3 == -1) {
                e(this.f, i, q30Var2);
                return;
            } else {
                iMax = ((ud0) this.b.b.get(i3)).f + Math.max(r5.d().f - 1, 0);
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            i3++;
            iMax = i4 - 1;
        }
        q30Var2.c = iMax;
        q30Var2.b = i3;
        q30Var2.a = i;
    }

    public final void e(q30 q30Var, int i, q30 q30Var2) {
        int i2 = q30Var.a;
        if (i2 > i) {
            xe.k("Unable to find backward from method findIndexForward()");
            return;
        }
        int i3 = q30Var.b;
        int i4 = q30Var.c;
        ld0 ld0Var = this.b;
        ArrayList arrayList = ld0Var.b;
        ArrayList arrayList2 = ld0Var.b;
        int iMax = ((ud0) arrayList2.get(i3)).f + Math.max(((ud0) arrayList.get(i3)).d().f - 1, 0);
        int i5 = (iMax - i4) + i2;
        while (i5 < i) {
            i3++;
            iMax = ((ud0) arrayList2.get(i3)).f + Math.max(r0.d().f - 1, 0);
            i5 += iMax + 1;
        }
        if (i5 > i) {
            iMax -= i5 - i;
        }
        q30Var2.c = iMax;
        q30Var2.b = i3;
        q30Var2.a = i;
    }

    public final void f(q30 q30Var, int i, int i2, q30 q30Var2) {
        int i3 = q30Var.b;
        if (i3 < i) {
            xe.k("can not find forward from findLiCoBackward()");
            return;
        }
        int i4 = q30Var.a - q30Var.c;
        while (i3 > i) {
            ud0 ud0Var = (ud0) this.b.b.get(i3 - 1);
            i4 -= ud0Var.f + ud0Var.d().f;
            i3--;
        }
        q30Var2.c = 0;
        q30Var2.b = i3;
        q30Var2.a = i4;
        b(q30Var2, i, i2);
    }

    public final void g(q30 q30Var, int i, int i2, q30 q30Var2) {
        int i3 = q30Var.b;
        if (i3 > i) {
            xe.k("can not find backward from findLiCoForward()");
            return;
        }
        int i4 = q30Var.a - q30Var.c;
        while (i3 < i) {
            ud0 ud0Var = (ud0) this.b.b.get(i3);
            i4 += ud0Var.f + ud0Var.d().f;
            i3++;
        }
        q30Var2.c = 0;
        q30Var2.b = i3;
        q30Var2.a = i4;
        b(q30Var2, i, i2);
    }

    public final synchronized q30 h(int i) {
        q30 q30Var;
        try {
            q30Var = this.f;
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < this.A.size(); i4++) {
                q30 q30Var2 = (q30) this.A.get(i4);
                int iAbs = Math.abs(q30Var2.a - i);
                if (iAbs < i2) {
                    i3 = i4;
                    q30Var = q30Var2;
                    i2 = iAbs;
                }
                if (iAbs <= this.X) {
                    break;
                }
            }
            if (Math.abs(this.z.a - i) < i2) {
                q30Var = this.z;
            }
            if (q30Var != this.f && q30Var != this.z) {
                Collections.swap(this.A, i3, r7.size() - 1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return q30Var;
    }

    public final synchronized q30 i(int i) {
        q30 q30Var;
        try {
            q30Var = this.f;
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < this.A.size(); i4++) {
                q30 q30Var2 = (q30) this.A.get(i4);
                int iAbs = Math.abs(q30Var2.b - i);
                if (iAbs < i2) {
                    i3 = i4;
                    q30Var = q30Var2;
                    i2 = iAbs;
                }
                if (i2 <= 50) {
                    break;
                }
            }
            if (Math.abs(this.z.b - i) < i2) {
                q30Var = this.z;
            }
            if (q30Var != this.f && q30Var != this.z) {
                Collections.swap(this.A, i3, r7.size() - 1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return q30Var;
    }

    public final q30 j(int i) {
        q30 q30Var = new q30();
        ld0 ld0Var = this.b;
        ld0Var.d(i, 2);
        ld0Var.u(false);
        try {
            q30 q30VarH = h(i);
            int i2 = q30VarH.a;
            if (i2 == i) {
                q30Var.a = i2;
                q30Var.b = q30VarH.b;
                q30Var.c = q30VarH.c;
            } else if (i2 < i) {
                e(q30VarH, i, q30Var);
            } else {
                c(q30VarH, i, q30Var);
            }
            if (Math.abs(i - q30VarH.a) >= this.X) {
                o(q30Var.a());
            }
            ld0Var.F(false);
            return q30Var;
        } catch (Throwable th) {
            ld0Var.F(false);
            throw th;
        }
    }

    public final q30 m(int i, int i2) {
        q30 q30Var = new q30();
        ld0 ld0Var = this.b;
        ld0Var.f(i, i2, 2);
        ld0Var.u(false);
        try {
            q30 q30VarI = i(i);
            int i3 = q30VarI.b;
            if (i3 == i) {
                q30Var.a = q30VarI.a;
                q30Var.b = i3;
                q30Var.c = q30VarI.c;
                if (q30VarI.c == i2) {
                    ld0Var.F(false);
                    return q30Var;
                }
                b(q30Var, i, i2);
            } else if (i3 < i) {
                g(q30VarI, i, i2, q30Var);
            } else {
                f(q30VarI, i, i2, q30Var);
            }
            if (Math.abs(q30VarI.b - i) > 50) {
                o(q30Var.a());
            }
            ld0Var.F(false);
            return q30Var;
        } catch (Throwable th) {
            ld0Var.F(false);
            throw th;
        }
    }

    public final synchronized void o(q30 q30Var) {
        if (this.Y <= 0) {
            return;
        }
        this.A.add(q30Var);
        if (this.A.size() > this.Y) {
            this.A.remove(0);
        }
    }

    public final void p() {
        ld0 ld0Var = this.b;
        int i = ld0Var.A;
        q30 q30Var = this.z;
        q30Var.a = i;
        int size = ld0Var.b.size() - 1;
        q30Var.b = size;
        q30Var.c = ld0Var.o(size).f;
    }

    @Override // defpackage.vd0
    public final void I(ld0 ld0Var) {
    }

    @Override // defpackage.vd0
    public final void a(ld0 ld0Var) {
    }
}
