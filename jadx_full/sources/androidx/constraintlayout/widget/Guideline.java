package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import defpackage.qb0;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Guideline extends View {
    public boolean b;

    public Guideline(Context context) {
        super(context);
        this.b = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.b = z;
    }

    public void setGuidelineBegin(int i) {
        qb0 qb0Var = (qb0) getLayoutParams();
        if (this.b && qb0Var.a == i) {
            return;
        }
        qb0Var.a = i;
        setLayoutParams(qb0Var);
    }

    public void setGuidelineEnd(int i) {
        qb0 qb0Var = (qb0) getLayoutParams();
        if (this.b && qb0Var.b == i) {
            return;
        }
        qb0Var.b = i;
        setLayoutParams(qb0Var);
    }

    public void setGuidelinePercent(float f) {
        qb0 qb0Var = (qb0) getLayoutParams();
        if (this.b && qb0Var.c == f) {
            return;
        }
        qb0Var.c = f;
        setLayoutParams(qb0Var);
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
