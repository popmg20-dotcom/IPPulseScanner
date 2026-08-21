package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sn3 {
    public final wn3 a;
    public final String b;
    public final boolean c;
    public final String d;
    public final boolean e;

    public sn3(wn3 wn3Var, String str, String str2) {
        boolean zFind;
        this.a = wn3Var;
        this.b = str;
        if (str == null) {
            Pattern pattern = vh3.a;
            zFind = false;
        } else {
            zFind = vh3.a.matcher(str).find();
        }
        this.c = zFind;
        this.d = str2;
        this.e = str2 != null ? vh3.a.matcher(str2).find() : false;
    }

    public abstract void a(xp1 xp1Var, qh3 qh3Var);

    public abstract n80 b(xp1 xp1Var, String str, boolean z, boolean z2);

    public final String c(CharSequence charSequence, sv2[] sv2VarArr) {
        boolean z = this.c;
        String str = this.b;
        return (!z || str == null || charSequence == null || sv2VarArr == null) ? str : vh3.b(str, charSequence, sv2VarArr);
    }

    public final String toString() {
        return m44.e(this, new dg(12, this));
    }
}
