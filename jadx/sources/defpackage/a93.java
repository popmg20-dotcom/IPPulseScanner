package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a93 extends ke0 {
    public final c93[] e;

    public a93(ke0 ke0Var, c93[] c93VarArr) {
        this.e = c93VarArr;
    }

    @Override // defpackage.ke0
    public final b72 A(Class cls) {
        c93[] c93VarArr = this.e;
        c93 c93Var = c93VarArr[0];
        if (c93Var.a == cls) {
            return c93Var.b;
        }
        c93 c93Var2 = c93VarArr[1];
        if (c93Var2.a == cls) {
            return c93Var2.b;
        }
        c93 c93Var3 = c93VarArr[2];
        if (c93Var3.a == cls) {
            return c93Var3.b;
        }
        switch (c93VarArr.length) {
            case 8:
                c93 c93Var4 = c93VarArr[7];
                if (c93Var4.a == cls) {
                    return c93Var4.b;
                }
            case 7:
                c93 c93Var5 = c93VarArr[6];
                if (c93Var5.a == cls) {
                    return c93Var5.b;
                }
            case 6:
                c93 c93Var6 = c93VarArr[5];
                if (c93Var6.a == cls) {
                    return c93Var6.b;
                }
            case 5:
                c93 c93Var7 = c93VarArr[4];
                if (c93Var7.a == cls) {
                    return c93Var7.b;
                }
            case 4:
                c93 c93Var8 = c93VarArr[3];
                if (c93Var8.a == cls) {
                    return c93Var8.b;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // defpackage.ke0
    public final ke0 n(Class cls, b72 b72Var) {
        c93[] c93VarArr = this.e;
        int length = c93VarArr.length;
        if (length == 8) {
            return this;
        }
        c93[] c93VarArr2 = (c93[]) Arrays.copyOf(c93VarArr, length + 1);
        c93VarArr2[length] = new c93(cls, b72Var);
        return new a93(this, c93VarArr2);
    }
}
