package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qu3 extends wu3 {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Matrix d;

    public qu3(ArrayList arrayList, Matrix matrix) {
        this.c = arrayList;
        this.d = matrix;
    }

    @Override // defpackage.wu3
    public final void a(Matrix matrix, ju3 ju3Var, int i, Canvas canvas) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((wu3) it.next()).a(this.d, ju3Var, i, canvas);
        }
    }
}
