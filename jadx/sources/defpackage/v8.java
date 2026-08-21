package defpackage;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v8 implements TypeEvaluator {
    public final /* synthetic */ int a;
    public Object b;

    public v8(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new FloatEvaluator();
                break;
        }
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                v03[] v03VarArr = (v03[]) obj;
                v03[] v03VarArr2 = (v03[]) obj2;
                if (!n12.f(v03VarArr, v03VarArr2)) {
                    xe.k("Can't interpolate between two incompatible pathData");
                    return null;
                }
                if (!n12.f((v03[]) this.b, v03VarArr)) {
                    this.b = n12.v(v03VarArr);
                }
                int i = 0;
                while (true) {
                    int length = v03VarArr.length;
                    v03[] v03VarArr3 = (v03[]) this.b;
                    if (i >= length) {
                        return v03VarArr3;
                    }
                    v03 v03Var = v03VarArr3[i];
                    v03 v03Var2 = v03VarArr[i];
                    v03 v03Var3 = v03VarArr2[i];
                    v03Var.getClass();
                    v03Var.a = v03Var2.a;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = v03Var2.b;
                        if (i2 < fArr.length) {
                            v03Var.b[i2] = (v03Var3.b[i2] * f) + ((1.0f - f) * fArr[i2]);
                            i2++;
                        }
                    }
                    i++;
                }
                break;
            default:
                float fFloatValue = ((FloatEvaluator) this.b).evaluate(f, (Number) obj, (Number) obj2).floatValue();
                if (fFloatValue < 0.1f) {
                    fFloatValue = 0.0f;
                }
                return Float.valueOf(fFloatValue);
        }
    }
}
