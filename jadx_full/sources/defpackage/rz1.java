package defpackage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rz1 extends vx0 {
    public final ay0 E0;
    public m0 F0;
    public qo4 G0;

    public rz1(Context context, el elVar, ay0 ay0Var, m0 m0Var) {
        super(context, elVar);
        this.E0 = ay0Var;
        this.F0 = m0Var;
        m0Var.a = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0112  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void draw(Canvas canvas) {
        int i;
        qo4 qo4Var;
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.C0)) {
            u8 u8Var = this.z;
            el elVar = this.f;
            if (u8Var != null && u8.a(this.b.getContentResolver()) == 0.0f && (qo4Var = this.G0) != null) {
                qo4Var.setBounds(getBounds());
                this.G0.setTint(elVar.e[0]);
                this.G0.draw(canvas);
                return;
            }
            canvas.save();
            Rect bounds = getBounds();
            float fB = b();
            ObjectAnimator objectAnimator = this.A;
            boolean z = objectAnimator != null && objectAnimator.isRunning();
            ObjectAnimator objectAnimator2 = this.X;
            boolean z2 = objectAnimator2 != null && objectAnimator2.isRunning();
            ay0 ay0Var = this.E0;
            ay0Var.a.d();
            ay0Var.a(canvas, bounds, fB, z, z2);
            int i2 = elVar.i;
            int i3 = this.B0;
            boolean z3 = (elVar instanceof eb2) || ((elVar instanceof d50) && ((d50) elVar).u);
            boolean z4 = z3 && i2 == 0 && !elVar.b(false);
            Paint paint = this.A0;
            if (!z4) {
                if (z3) {
                    yx0 yx0Var = (yx0) ((ArrayList) this.F0.b).get(0);
                    yx0 yx0Var2 = (yx0) fw.r((ArrayList) this.F0.b, 1);
                    ay0 ay0Var2 = this.E0;
                    if (ay0Var2 instanceof va2) {
                        i = i2;
                        ay0Var2.d(canvas, paint, 0.0f, yx0Var.a, elVar.f, i3, i);
                        this.E0.d(canvas, paint, yx0Var2.b, 1.0f, elVar.f, i3, i);
                    } else {
                        i = i2;
                        canvas.save();
                        canvas.rotate(yx0Var2.g);
                        this.E0.d(canvas, paint, yx0Var2.b, 1.0f + yx0Var.a, elVar.f, i3, i);
                        canvas.restore();
                    }
                }
                for (int i4 = 0; i4 < ((ArrayList) this.F0.b).size(); i4++) {
                    yx0 yx0Var3 = (yx0) ((ArrayList) this.F0.b).get(i4);
                    yx0Var3.f = c();
                    this.E0.c(canvas, paint, yx0Var3, this.B0);
                    if (i4 > 0 && !z4 && z3) {
                        this.E0.d(canvas, paint, ((yx0) ((ArrayList) this.F0.b).get(i4 - 1)).b, yx0Var3.a, elVar.f, i3, i);
                    }
                }
                canvas.restore();
            }
            this.E0.d(canvas, paint, 0.0f, 1.0f, elVar.f, i3, 0);
            i = i2;
            while (i4 < ((ArrayList) this.F0.b).size()) {
            }
            canvas.restore();
        }
    }

    @Override // defpackage.vx0
    public final boolean e(boolean z, boolean z2, boolean z3) {
        qo4 qo4Var;
        boolean zE = super.e(z, z2, z3);
        if (this.z != null && u8.a(this.b.getContentResolver()) == 0.0f && (qo4Var = this.G0) != null) {
            return qo4Var.setVisible(z, z2);
        }
        if (!isRunning()) {
            this.F0.e();
        }
        if (z && z3) {
            this.F0.x();
        }
        return zE;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.E0.e();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.E0.f();
    }
}
