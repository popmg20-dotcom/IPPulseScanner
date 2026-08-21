package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class th1 implements t31, pk3 {
    public static final th1 A;
    public static final th1 z;
    public final /* synthetic */ int b;
    public final String f;

    static {
        int i = 0;
        z = new th1("FLAT", i);
        A = new th1("HALF_OPENED", i);
    }

    public /* synthetic */ th1(String str, int i) {
        this.b = i;
        this.f = str;
    }

    @Override // defpackage.pk3
    public void f(ns4 ns4Var) {
        ns4Var.getClass();
        ns4Var.printStackTrace();
    }

    @Override // defpackage.pk3
    public void p(Object obj) {
        String str = (String) obj;
        str.getClass();
        ez4.X("save_policy_path", new zc1(this.f, str, 3));
    }

    @Override // defpackage.t31
    public boolean r(CharSequence charSequence, int i, int i2, kk4 kk4Var) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.f)) {
            return true;
        }
        kk4Var.c = (kk4Var.c & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return this.f;
            default:
                return super.toString();
        }
    }

    @Override // defpackage.t31
    public Object n() {
        return this;
    }
}
