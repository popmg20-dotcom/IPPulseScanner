package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h33 extends yf3 {
    public Drawable a;
    public int b;
    public boolean c = true;
    public final /* synthetic */ j33 d;

    public h33(j33 j33Var) {
        this.d = j33Var;
    }

    @Override // defpackage.yf3
    public final void f(Rect rect, View view, RecyclerView recyclerView) {
        if (i(view, recyclerView)) {
            rect.bottom = this.b;
        }
    }

    @Override // defpackage.yf3
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        if (this.a == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (i(childAt, recyclerView)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.a.setBounds(0, height, width, this.b + height);
                this.a.draw(canvas);
            }
        }
    }

    public final boolean i(View view, RecyclerView recyclerView) {
        rg3 rg3VarN = recyclerView.N(view);
        if (!(rg3VarN instanceof t33) || !((t33) rg3VarN).y) {
            return false;
        }
        boolean z = this.c;
        int iIndexOfChild = recyclerView.indexOfChild(view);
        if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
            return z;
        }
        rg3 rg3VarN2 = recyclerView.N(recyclerView.getChildAt(iIndexOfChild + 1));
        return (rg3VarN2 instanceof t33) && ((t33) rg3VarN2).x;
    }
}
