package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class yu4 {
    public static final bv4 b;
    public final bv4 a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = (i >= 36 ? new ou4() : i >= 35 ? new nu4() : i >= 34 ? new mu4() : i >= 31 ? new lu4() : i >= 30 ? new ku4() : i >= 29 ? new ju4() : new iu4()).b().a.a().a.b().a.c();
    }

    public yu4(bv4 bv4Var) {
        this.a = bv4Var;
    }

    public bv4 a() {
        return this.a;
    }

    public bv4 b() {
        return this.a;
    }

    public bv4 c() {
        return this.a;
    }

    public List<Rect> e(int i) {
        return Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yu4)) {
            return false;
        }
        yu4 yu4Var = (yu4) obj;
        return s() == yu4Var.s() && r() == yu4Var.r() && Objects.equals(m(), yu4Var.m()) && Objects.equals(k(), yu4Var.k()) && Objects.equals(g(), yu4Var.g());
    }

    public List<Rect> f(int i) {
        return Collections.EMPTY_LIST;
    }

    public rv0 g() {
        return null;
    }

    public t02 h(int i) {
        return t02.e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(s()), Boolean.valueOf(r()), m(), k(), g());
    }

    public t02 i(int i) {
        if ((i & 8) == 0) {
            return t02.e;
        }
        xe.k("Unable to query the maximum insets for IME");
        return null;
    }

    public t02 j() {
        return m();
    }

    public t02 k() {
        return t02.e;
    }

    public t02 l() {
        return m();
    }

    public t02 m() {
        return t02.e;
    }

    public t02 n() {
        return m();
    }

    public bv4 q(int i, int i2, int i3, int i4) {
        return b;
    }

    public boolean r() {
        return false;
    }

    public boolean s() {
        return false;
    }

    public boolean t(int i) {
        return true;
    }

    public void p() {
    }

    public void A(Rect[][] rectArr) {
    }

    public void d(View view) {
    }

    public void o(View view) {
    }

    public void u(vv0 vv0Var) {
    }

    public void v(t02[] t02VarArr) {
    }

    public void w(bv4 bv4Var) {
    }

    public void x(t02 t02Var) {
    }

    public void y(int i) {
    }

    public void z(Rect[][] rectArr) {
    }
}
