package io.sentry.android.replay.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import defpackage.am1;
import defpackage.e03;
import defpackage.p95;
import defpackage.r82;
import defpackage.z82;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f extends r82 implements am1 {
    public final /* synthetic */ Matrix A;
    public final /* synthetic */ ArrayList X;
    public final /* synthetic */ Canvas Y;
    public final /* synthetic */ g f;
    public final /* synthetic */ Bitmap z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Bitmap bitmap, Matrix matrix, ArrayList arrayList, Canvas canvas) {
        super(1);
        this.f = gVar;
        this.z = bitmap;
        this.A = matrix;
        this.X = arrayList;
        this.Y = canvas;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        e03 e03Var;
        e03 e03Var2;
        Integer numI;
        List listX;
        io.sentry.android.replay.viewhierarchy.h hVar = (io.sentry.android.replay.viewhierarchy.h) obj;
        g gVar = this.f;
        z82 z82Var = gVar.z;
        z82 z82Var2 = gVar.b;
        hVar.getClass();
        if (hVar.d && hVar.a > 0 && hVar.b > 0) {
            Rect rect = hVar.f;
            if (rect == null) {
                return Boolean.FALSE;
            }
            if (hVar instanceof io.sentry.android.replay.viewhierarchy.e) {
                List listX2 = p95.x(rect);
                Rect rect2 = hVar.f;
                Bitmap bitmap = this.z;
                if (!bitmap.isRecycled() && !((Bitmap) z82Var2.getValue()).isRecycled()) {
                    Rect rect3 = new Rect(rect2);
                    RectF rectF = new RectF(rect3);
                    Matrix matrix = this.A;
                    if (matrix != null) {
                        matrix.mapRect(rectF);
                    }
                    rectF.round(rect3);
                    ((Canvas) gVar.f.getValue()).drawBitmap(bitmap, rect3, new Rect(0, 0, 1, 1), (Paint) null);
                    iIntValue = ((Bitmap) z82Var2.getValue()).getPixel(0, 0);
                }
                e03Var2 = new e03(listX2, Integer.valueOf(iIntValue));
            } else {
                if (hVar instanceof io.sentry.android.replay.viewhierarchy.g) {
                    io.sentry.android.replay.viewhierarchy.g gVar2 = (io.sentry.android.replay.viewhierarchy.g) hVar;
                    n nVar = gVar2.h;
                    iIntValue = ((nVar == null || (numI = nVar.i()) == null) && (numI = gVar2.i) == null) ? -16777216 : numI.intValue();
                    Rect rect4 = hVar.f;
                    int i = gVar2.j;
                    int i2 = gVar2.k;
                    rect4.getClass();
                    if (nVar == null) {
                        listX = p95.x(rect4);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int iG = nVar.g();
                        for (int i3 = 0; i3 < iG; i3++) {
                            int iJ = (int) nVar.j(i3);
                            int iH = (int) nVar.h(i3);
                            int iB = nVar.b(i3);
                            int iE = nVar.e(i3);
                            Rect rect5 = new Rect();
                            rect5.left = rect4.left + i + iJ;
                            rect5.right = rect4.left + i + iH;
                            int i4 = rect4.top + i2 + iB;
                            rect5.top = i4;
                            rect5.bottom = (iE - iB) + i4;
                            arrayList.add(rect5);
                        }
                        listX = arrayList;
                    }
                    e03Var = new e03(listX, Integer.valueOf(iIntValue));
                } else {
                    e03Var = new e03(p95.x(rect), -16777216);
                }
                e03Var2 = e03Var;
            }
            List list = (List) e03Var2.b;
            ((Paint) z82Var.getValue()).setColor(((Number) e03Var2.f).intValue());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.Y.drawRoundRect(new RectF((Rect) it.next()), 10.0f, 10.0f, (Paint) z82Var.getValue());
            }
            this.X.addAll(list);
        }
        return Boolean.TRUE;
    }
}
