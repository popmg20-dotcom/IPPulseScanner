package defpackage;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h31 {
    public int a;
    public final Object b;
    public final Object c;

    public h31(ag3 ag3Var) {
        this.a = Integer.MIN_VALUE;
        this.c = new Rect();
        this.b = ag3Var;
    }

    public static h31 b(ag3 ag3Var, int i) {
        if (i == 0) {
            return new tw2(ag3Var, 0);
        }
        int i2 = 1;
        if (i == 1) {
            return new tw2(ag3Var, i2);
        }
        xe.k("invalid orientation");
        return null;
    }

    public abstract void a(go3 go3Var);

    public abstract void c(go3 go3Var);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o(View view);

    public abstract int p(View view);

    public abstract void q(int i);

    public abstract void r(go3 go3Var);

    public abstract void s(go3 go3Var);

    public abstract void t(go3 go3Var);

    public abstract void u(go3 go3Var);

    public abstract h6 v(go3 go3Var);

    public h31(String str, int i, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public h31(j31 j31Var) {
        this.a = 0;
        this.c = new ll0();
        this.b = j31Var;
    }
}
