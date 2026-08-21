package defpackage;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ou {
    public final z82 a;
    public final z82 b;
    public final long c;
    public final long d;
    public final boolean e;
    public final lr1 f;

    public ou(he3 he3Var) {
        final int i = 0;
        this.a = ek0.v(new pl1(this) { // from class: nu
            public final /* synthetic */ ou f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = i;
                ou ouVar = this.f;
                switch (i2) {
                    case 0:
                        ku kuVar = ku.n;
                        return uf2.I(ouVar.f);
                    default:
                        String strA = ouVar.f.a("Content-Type");
                        if (strA == null) {
                            return null;
                        }
                        uh3 uh3Var = pj2.e;
                        try {
                            return p95.n(strA);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        final char c = 1 == true ? 1 : 0;
        this.b = ek0.v(new pl1(this) { // from class: nu
            public final /* synthetic */ ou f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = c;
                ou ouVar = this.f;
                switch (i2) {
                    case 0:
                        ku kuVar = ku.n;
                        return uf2.I(ouVar.f);
                    default:
                        String strA = ouVar.f.a("Content-Type");
                        if (strA == null) {
                            return null;
                        }
                        uh3 uh3Var = pj2.e;
                        try {
                            return p95.n(strA);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        this.c = Long.parseLong(he3Var.U(Long.MAX_VALUE));
        this.d = Long.parseLong(he3Var.U(Long.MAX_VALUE));
        this.e = Integer.parseInt(he3Var.U(Long.MAX_VALUE)) > 0;
        int i2 = Integer.parseInt(he3Var.U(Long.MAX_VALUE));
        ArrayList arrayList = new ArrayList(20);
        for (int i3 = 0; i3 < i2; i3++) {
            String strU = he3Var.U(Long.MAX_VALUE);
            Bitmap.Config config = j.a;
            int iU0 = p44.u0(strU, ':', 0, 6);
            if (iU0 == -1) {
                e04.f("Unexpected header: ".concat(strU));
                throw null;
            }
            String string = p44.U0(strU.substring(0, iU0)).toString();
            String strSubstring = strU.substring(iU0 + 1);
            string.getClass();
            gb4.O(string);
            arrayList.add(string);
            arrayList.add(p44.U0(strSubstring).toString());
        }
        this.f = new lr1((String[]) arrayList.toArray(new String[0]));
    }

    public final void a(ge3 ge3Var) {
        ge3Var.n(this.c);
        ge3Var.writeByte(10);
        ge3Var.n(this.d);
        ge3Var.writeByte(10);
        ge3Var.n(this.e ? 1L : 0L);
        ge3Var.writeByte(10);
        lr1 lr1Var = this.f;
        ge3Var.n(lr1Var.size());
        ge3Var.writeByte(10);
        int size = lr1Var.size();
        for (int i = 0; i < size; i++) {
            ge3Var.S(gb4.z(lr1Var, i));
            ge3Var.S(": ");
            ge3Var.S(gb4.B(lr1Var, i));
            ge3Var.writeByte(10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ou(kk3 kk3Var) {
        final Object[] objArr = 0 == true ? 1 : 0;
        this.a = ek0.v(new pl1(this) { // from class: nu
            public final /* synthetic */ ou f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = objArr;
                ou ouVar = this.f;
                switch (i2) {
                    case 0:
                        ku kuVar = ku.n;
                        return uf2.I(ouVar.f);
                    default:
                        String strA = ouVar.f.a("Content-Type");
                        if (strA == null) {
                            return null;
                        }
                        uh3 uh3Var = pj2.e;
                        try {
                            return p95.n(strA);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        final int i = 1;
        this.b = ek0.v(new pl1(this) { // from class: nu
            public final /* synthetic */ ou f;

            {
                this.f = this;
            }

            @Override // defpackage.pl1
            public final Object a() {
                int i2 = i;
                ou ouVar = this.f;
                switch (i2) {
                    case 0:
                        ku kuVar = ku.n;
                        return uf2.I(ouVar.f);
                    default:
                        String strA = ouVar.f.a("Content-Type");
                        if (strA == null) {
                            return null;
                        }
                        uh3 uh3Var = pj2.e;
                        try {
                            return p95.n(strA);
                        } catch (IllegalArgumentException unused) {
                            return null;
                        }
                }
            }
        });
        this.c = kk3Var.C0;
        this.d = kk3Var.D0;
        this.e = kk3Var.X != null;
        this.f = kk3Var.Y;
    }
}
