package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rw2 {
    public final Context a;
    public final Bitmap.Config b;
    public final ColorSpace c;
    public final wx3 d;
    public final sp3 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final lr1 j;
    public final ra4 k;
    public final i03 l;
    public final mu m;
    public final mu n;
    public final mu o;

    public rw2(Context context, Bitmap.Config config, ColorSpace colorSpace, wx3 wx3Var, sp3 sp3Var, boolean z, boolean z2, boolean z3, String str, lr1 lr1Var, ra4 ra4Var, i03 i03Var, mu muVar, mu muVar2, mu muVar3) {
        this.a = context;
        this.b = config;
        this.c = colorSpace;
        this.d = wx3Var;
        this.e = sp3Var;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = str;
        this.j = lr1Var;
        this.k = ra4Var;
        this.l = i03Var;
        this.m = muVar;
        this.n = muVar2;
        this.o = muVar3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rw2)) {
            return false;
        }
        rw2 rw2Var = (rw2) obj;
        if (n12.c(this.a, rw2Var.a) && this.b == rw2Var.b) {
            return (Build.VERSION.SDK_INT < 26 || n12.c(this.c, rw2Var.c)) && n12.c(this.d, rw2Var.d) && this.e == rw2Var.e && this.f == rw2Var.f && this.g == rw2Var.g && this.h == rw2Var.h && n12.c(this.i, rw2Var.i) && n12.c(this.j, rw2Var.j) && n12.c(this.k, rw2Var.k) && n12.c(this.l, rw2Var.l) && this.m == rw2Var.m && this.n == rw2Var.n && this.o == rw2Var.o;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        ColorSpace colorSpace = this.c;
        int iHashCode2 = (((((((this.e.hashCode() + ((this.d.hashCode() + ((iHashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31)) * 31) + (this.f ? 1231 : 1237)) * 31) + (this.g ? 1231 : 1237)) * 31) + (this.h ? 1231 : 1237)) * 31;
        String str = this.i;
        return this.o.hashCode() + ((this.n.hashCode() + ((this.m.hashCode() + ((this.l.b.hashCode() + ((this.k.a.hashCode() + ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.j.b)) * 31)) * 31)) * 31)) * 31)) * 31);
    }
}
