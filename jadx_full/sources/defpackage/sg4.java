package defpackage;

import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sg4 extends xg4 {
    public long a = -1;
    public boolean b;
    public boolean c;
    public w04 d;
    public final qt e;
    public s7 f;
    public final /* synthetic */ ch4 g;

    public sg4(ch4 ch4Var) {
        this.g = ch4Var;
        qt qtVar = new qt((char) 0, 16);
        long[] jArr = new long[20];
        qtVar.c = jArr;
        qtVar.d = new float[20];
        qtVar.b = 0;
        Arrays.fill(jArr, Long.MIN_VALUE);
        this.e = qtVar;
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void g(vg4 vg4Var) {
        this.c = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        float f;
        int i;
        char c;
        qt qtVar = this.e;
        float[] fArr = (float[]) qtVar.d;
        long[] jArr = (long[]) qtVar.c;
        if (this.d != null) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float f2 = this.a;
        char c2 = 20;
        int i2 = (qtVar.b + 1) % 20;
        qtVar.b = i2;
        jArr[i2] = jCurrentAnimationTimeMillis;
        fArr[i2] = f2;
        sf1 sf1Var = new sf1();
        float fSqrt = 0.0f;
        sf1Var.a = 0.0f;
        this.d = new w04(sf1Var);
        x04 x04Var = new x04();
        x04Var.a(1.0f);
        x04Var.b(200.0f);
        w04 w04Var = this.d;
        w04Var.m = x04Var;
        w04Var.b = this.a;
        w04Var.c = true;
        ArrayList arrayList = w04Var.l;
        if (w04Var.f) {
            vp1.n("Error: Update listeners must be added beforethe animation.");
            return;
        }
        if (!arrayList.contains(this)) {
            arrayList.add(this);
        }
        w04 w04Var2 = this.d;
        int i3 = qtVar.b;
        if (i3 != 0 || jArr[i3] != Long.MIN_VALUE) {
            long j = jArr[i3];
            int i4 = 0;
            long j2 = j;
            while (true) {
                long j3 = jArr[i3];
                if (j3 == Long.MIN_VALUE) {
                    f = fSqrt;
                    i = i4;
                    break;
                }
                f = fSqrt;
                i = i4;
                float f3 = j - j3;
                float fAbs = Math.abs(j3 - j2);
                if (f3 > 100.0f || fAbs > 40.0f) {
                    break;
                }
                if (i3 == 0) {
                    i3 = 20;
                }
                i3--;
                i4 = i + 1;
                if (i4 >= 20) {
                    break;
                }
                j2 = j3;
                fSqrt = f;
            }
            if (i4 < 2) {
                fSqrt = f;
            } else {
                int i5 = qtVar.b;
                float f4 = 1000.0f;
                if (i4 == 2) {
                    int i6 = i5 == 0 ? 19 : i5 - 1;
                    float f5 = jArr[i5] - jArr[i6];
                    if (f5 != f) {
                        fSqrt = 1000.0f * ((fArr[i5] - fArr[i6]) / f5);
                    }
                } else {
                    int i7 = ((i5 - i4) + 21) % 20;
                    int i8 = (i5 + 21) % 20;
                    long j4 = jArr[i7];
                    float f6 = fArr[i7];
                    int i9 = i7 + 1;
                    int i10 = i9 % 20;
                    float f7 = f;
                    while (i10 != i8) {
                        long j5 = jArr[i10];
                        float f8 = f4;
                        float f9 = f6;
                        float f10 = j5 - j4;
                        if (f10 == f) {
                            c = c2;
                            f6 = f9;
                        } else {
                            f6 = fArr[i10];
                            c = c2;
                            float f11 = (f6 - f9) / f10;
                            float fAbs2 = (Math.abs(f11) * (f11 - ((float) (Math.sqrt(2.0f * Math.abs(f7)) * ((double) Math.signum(f7)))))) + f7;
                            if (i10 == i9) {
                                fAbs2 *= 0.5f;
                            }
                            f7 = fAbs2;
                            j4 = j5;
                        }
                        i10 = (i10 + 1) % 20;
                        f4 = f8;
                        c2 = c;
                    }
                    fSqrt = ((float) (Math.sqrt(Math.abs(f7) * 2.0f) * ((double) Math.signum(f7)))) * f4;
                }
            }
        }
        w04Var2.a = fSqrt;
        w04 w04Var3 = this.d;
        w04Var3.g = this.g.Q0 + 1;
        w04Var3.h = -1.0f;
        w04Var3.b(4.0f);
        w04 w04Var4 = this.d;
        al alVar = new al(1, this);
        ArrayList arrayList2 = w04Var4.k;
        if (arrayList2.contains(alVar)) {
            return;
        }
        arrayList2.add(alVar);
    }
}
