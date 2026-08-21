package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class td4 {
    public static final /* synthetic */ long b = re.a.objectFieldOffset(td4.class.getDeclaredField("_size$volatile"));
    private volatile /* synthetic */ int _size$volatile;
    public e61[] a;

    public final void a(e61 e61Var) {
        e61Var.e((f61) this);
        e61[] e61VarArr = this.a;
        if (e61VarArr == null) {
            e61VarArr = new e61[4];
            this.a = e61VarArr;
        } else if (b() >= e61VarArr.length) {
            e61VarArr = (e61[]) Arrays.copyOf(e61VarArr, b() * 2);
            this.a = e61VarArr;
        }
        int iB = b();
        re.a.putIntVolatile(this, b, iB + 1);
        e61VarArr[iB] = e61Var;
        e61Var.f = iB;
        e(iB);
    }

    public final int b() {
        return re.a.getIntVolatile(this, b);
    }

    public final void c(e61 e61Var) {
        synchronized (this) {
            if (e61Var.b() != null) {
                d(e61Var.f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e61 d(int i) {
        Object[] objArr = this.a;
        objArr.getClass();
        re.a.putIntVolatile(this, b, b() - 1);
        if (i < b()) {
            f(i, b());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                e61 e61Var = objArr[i];
                e61Var.getClass();
                Object obj = objArr[i2];
                obj.getClass();
                if (e61Var.compareTo(obj) < 0) {
                    f(i, i2);
                    e(i2);
                } else {
                    while (true) {
                        int i3 = i * 2;
                        int i4 = i3 + 1;
                        if (i4 >= b()) {
                            break;
                        }
                        Object[] objArr2 = this.a;
                        objArr2.getClass();
                        int i5 = i3 + 2;
                        if (i5 < b()) {
                            Comparable comparable = objArr2[i5];
                            comparable.getClass();
                            Object obj2 = objArr2[i4];
                            obj2.getClass();
                            if (comparable.compareTo(obj2) >= 0) {
                                i5 = i4;
                            }
                            Comparable comparable2 = objArr2[i];
                            comparable2.getClass();
                            Comparable comparable3 = objArr2[i5];
                            comparable3.getClass();
                            if (comparable2.compareTo(comparable3) <= 0) {
                                break;
                            }
                            f(i, i5);
                            i = i5;
                        }
                    }
                }
            }
        }
        e61 e61Var2 = objArr[b()];
        e61Var2.getClass();
        e61Var2.e(null);
        e61Var2.f = -1;
        objArr[b()] = null;
        return e61Var2;
    }

    public final void e(int i) {
        while (i > 0) {
            e61[] e61VarArr = this.a;
            e61VarArr.getClass();
            int i2 = (i - 1) / 2;
            e61 e61Var = e61VarArr[i2];
            e61Var.getClass();
            e61 e61Var2 = e61VarArr[i];
            e61Var2.getClass();
            if (e61Var.compareTo(e61Var2) <= 0) {
                return;
            }
            f(i, i2);
            i = i2;
        }
    }

    public final void f(int i, int i2) {
        e61[] e61VarArr = this.a;
        e61VarArr.getClass();
        e61 e61Var = e61VarArr[i2];
        e61Var.getClass();
        e61 e61Var2 = e61VarArr[i];
        e61Var2.getClass();
        e61VarArr[i] = e61Var;
        e61VarArr[i2] = e61Var2;
        e61Var.f = i;
        e61Var2.f = i2;
    }
}
