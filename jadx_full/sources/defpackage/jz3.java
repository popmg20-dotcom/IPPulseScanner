package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jz3 implements Comparable {
    public int C0;
    public float X;
    public boolean b;
    public int f = -1;
    public int z = -1;
    public int A = 0;
    public boolean Y = false;
    public final float[] Z = new float[9];
    public final float[] y0 = new float[9];
    public ke[] z0 = new ke[16];
    public int A0 = 0;
    public int B0 = 0;

    public jz3(int i) {
        this.C0 = i;
    }

    public final void a(ke keVar) {
        int i = 0;
        while (true) {
            int i2 = this.A0;
            ke[] keVarArr = this.z0;
            if (i >= i2) {
                if (i2 >= keVarArr.length) {
                    keVarArr = (ke[]) Arrays.copyOf(keVarArr, keVarArr.length * 2);
                    this.z0 = keVarArr;
                }
                int i3 = this.A0;
                keVarArr[i3] = keVar;
                this.A0 = i3 + 1;
                return;
            }
            if (keVarArr[i] == keVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(ke keVar) {
        int i = this.A0;
        int i2 = 0;
        while (i2 < i) {
            if (this.z0[i2] == keVar) {
                while (i2 < i - 1) {
                    ke[] keVarArr = this.z0;
                    int i3 = i2 + 1;
                    keVarArr[i2] = keVarArr[i3];
                    i2 = i3;
                }
                this.A0--;
                return;
            }
            i2++;
        }
    }

    public final void c() {
        this.C0 = 5;
        this.A = 0;
        this.f = -1;
        this.z = -1;
        this.X = 0.0f;
        this.Y = false;
        int i = this.A0;
        for (int i2 = 0; i2 < i; i2++) {
            this.z0[i2] = null;
        }
        this.A0 = 0;
        this.B0 = 0;
        this.b = false;
        Arrays.fill(this.y0, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f - ((jz3) obj).f;
    }

    public final void d(gb2 gb2Var, float f) {
        this.X = f;
        this.Y = true;
        int i = this.A0;
        this.z = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.z0[i2].h(gb2Var, this, false);
        }
        this.A0 = 0;
    }

    public final void e(gb2 gb2Var, ke keVar) {
        int i = this.A0;
        for (int i2 = 0; i2 < i; i2++) {
            this.z0[i2].i(gb2Var, keVar, false);
        }
        this.A0 = 0;
    }

    public final String toString() {
        return "" + this.f;
    }
}
