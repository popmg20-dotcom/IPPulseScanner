package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xu3 {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public final ArrayList f = new ArrayList();
    public final ArrayList g = new ArrayList();

    public xu3() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f) {
        float f2 = this.d;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.b;
        float f5 = this.c;
        tu3 tu3Var = new tu3(f4, f5, f4, f5);
        tu3Var.f = this.d;
        tu3Var.g = f3;
        this.g.add(new ru3(tu3Var));
        this.d = f;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((vu3) arrayList.get(i)).a(matrix, path);
        }
    }

    public final void c(float f, float f2) {
        uu3 uu3Var = new uu3();
        uu3Var.b = f;
        uu3Var.c = f2;
        this.f.add(uu3Var);
        su3 su3Var = new su3(uu3Var, this.b, this.c);
        float fB = su3Var.b() + 270.0f;
        float fB2 = su3Var.b() + 270.0f;
        a(fB);
        this.g.add(su3Var);
        this.d = fB2;
        this.b = f;
        this.c = f2;
    }

    public final void d(float f, float f2, float f3) {
        this.a = f;
        this.b = 0.0f;
        this.c = f;
        this.d = f2;
        this.e = (f2 + f3) % 360.0f;
        this.f.clear();
        this.g.clear();
    }
}
