package defpackage;

import android.content.Context;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rz1.draw(android.graphics.Canvas):void");
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
