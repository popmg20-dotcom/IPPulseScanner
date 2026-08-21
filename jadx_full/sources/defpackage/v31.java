package defpackage;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v31 extends tj4 {
    public final TextView l;
    public final r31 m;
    public boolean n = true;

    public v31(TextView textView) {
        this.l = textView;
        this.m = new r31(textView);
    }

    @Override // defpackage.tj4
    public final InputFilter[] D(InputFilter[] inputFilterArr) {
        if (!this.n) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof r31) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            r31 r31Var = this.m;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = r31Var;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == r31Var) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // defpackage.tj4
    public final boolean J() {
        return this.n;
    }

    @Override // defpackage.tj4
    public final void Y(boolean z) {
        if (z) {
            TextView textView = this.l;
            textView.setTransformationMethod(m0(textView.getTransformationMethod()));
        }
    }

    @Override // defpackage.tj4
    public final void a0(boolean z) {
        this.n = z;
        TextView textView = this.l;
        textView.setTransformationMethod(m0(textView.getTransformationMethod()));
        textView.setFilters(D(textView.getFilters()));
    }

    @Override // defpackage.tj4
    public final TransformationMethod m0(TransformationMethod transformationMethod) {
        return this.n ? ((transformationMethod instanceof z31) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new z31(transformationMethod) : transformationMethod instanceof z31 ? ((z31) transformationMethod).b : transformationMethod;
    }
}
