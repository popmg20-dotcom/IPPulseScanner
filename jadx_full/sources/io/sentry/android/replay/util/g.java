package io.sentry.android.replay.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import defpackage.ek0;
import defpackage.g41;
import defpackage.v10;
import defpackage.z82;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {
    public final z82 b = ek0.v(e.z);
    public final z82 f = ek0.v(new v10(9, this));
    public final z82 z = ek0.v(e.A);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        z82 z82Var = this.b;
        if (!z82Var.c() || ((Bitmap) z82Var.getValue()).isRecycled()) {
            return;
        }
        ((Bitmap) z82Var.getValue()).recycle();
    }

    public final List g(Bitmap bitmap, io.sentry.android.replay.viewhierarchy.h hVar, Matrix matrix) {
        bitmap.getClass();
        if (bitmap.isRecycled()) {
            return g41.b;
        }
        ArrayList arrayList = new ArrayList();
        Canvas canvas = new Canvas(bitmap);
        if (matrix != null) {
            canvas.setMatrix(matrix);
        }
        hVar.a(new f(this, bitmap, matrix, arrayList, canvas));
        return arrayList;
    }
}
