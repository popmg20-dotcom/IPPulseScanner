package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zl4 {
    public am4 a = new am4();

    public final am4 a() {
        am4 am4Var = new am4();
        if (this.a.a == null) {
            am4Var.a = ze2.X;
        } else {
            am4Var.a = new ze2(this.a.a, false);
        }
        if (this.a.b == null) {
            am4Var.b = x02.X;
        } else {
            am4Var.b = new x02(this.a.b, false);
        }
        if (this.a.c == null) {
            am4Var.c = ze2.X;
        } else {
            am4Var.c = new ze2(this.a.c, false);
        }
        if (this.a.d == null) {
            am4Var.d = Collections.EMPTY_LIST;
        } else {
            am4Var.d = DesugarCollections.unmodifiableList(new ArrayList(this.a.d));
        }
        if (this.a.e == null) {
            am4Var.e = Collections.EMPTY_LIST;
            return am4Var;
        }
        am4Var.e = DesugarCollections.unmodifiableList(new ArrayList(this.a.e));
        return am4Var;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final zl4 clone() {
        am4 am4Var = new am4();
        if (this.a.a == null) {
            am4Var.a = null;
        } else {
            am4Var.a = new ze2(this.a.a, true);
        }
        if (this.a.b == null) {
            am4Var.b = null;
        } else {
            am4Var.b = new x02(this.a.b, true);
        }
        if (this.a.c == null) {
            am4Var.c = null;
        } else {
            am4Var.c = new ze2(this.a.c, true);
        }
        if (this.a.d == null) {
            am4Var.d = null;
        } else {
            am4Var.d = new ArrayList(this.a.d);
        }
        if (this.a.e == null) {
            am4Var.e = null;
        } else {
            am4Var.e = new ArrayList(this.a.e);
        }
        zl4 zl4Var = new zl4();
        zl4Var.a = am4Var;
        return zl4Var;
    }

    public final void c(am4 am4Var) {
        if (!am4Var.a.isEmpty()) {
            am4 am4Var2 = this.a;
            if (am4Var2.a == null) {
                am4Var2.a = new ze2();
            }
            this.a.a.addAll(am4Var.a);
        }
        if (!am4Var.b.isEmpty()) {
            am4 am4Var3 = this.a;
            if (am4Var3.b == null) {
                am4Var3.b = new x02();
            }
            this.a.b.addAll(am4Var.b);
        }
        if (!am4Var.c.isEmpty()) {
            am4 am4Var4 = this.a;
            if (am4Var4.c == null) {
                am4Var4.c = new ze2();
            }
            this.a.c.addAll(am4Var.c);
        }
        if (!am4Var.d.isEmpty()) {
            am4 am4Var5 = this.a;
            if (am4Var5.d == null) {
                am4Var5.d = new ArrayList();
            }
            this.a.d.addAll(am4Var.d);
        }
        if (am4Var.e.isEmpty()) {
            return;
        }
        am4 am4Var6 = this.a;
        if (am4Var6.e == null) {
            am4Var6.e = new ArrayList();
        }
        this.a.e.addAll(am4Var.e);
    }
}
