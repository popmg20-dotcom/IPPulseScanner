package defpackage;

import android.view.MotionEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c21 implements Runnable {
    public float A;
    public float X;
    public float Y;
    public float Z;
    public final float b;
    public float f;
    public long y0 = 0;
    public float z;
    public final /* synthetic */ d21 z0;

    public c21(d21 d21Var, int i) {
        this.z0 = d21Var;
        float f = i;
        this.z = f;
        this.f = f;
        this.b = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f;
        float f2;
        d21 d21Var = this.z0;
        nf2 nf2Var = d21Var.d;
        CodeEditor codeEditor = d21Var.a;
        int i = d21Var.x;
        float f3 = ((i & 1) != 0 ? -this.f : 0.0f) + ((i & 2) != 0 ? this.f : 0.0f);
        float f4 = ((i & 4) != 0 ? -this.z : 0.0f) + ((i & 8) != 0 ? this.z : 0.0f);
        if (f3 > 0.0f) {
            int i2 = d21Var.e;
            int i3 = (i2 == 0 || i2 == 1) ? codeEditor.getCursor().c.b : codeEditor.getCursor().d.b;
            if (d21Var.b.b.getCurrX() > (codeEditor.T() + codeEditor.D0.b(i3, codeEditor.getText().o(i3).f)[1]) - (codeEditor.getWidth() * 0.85f)) {
                f3 = 0.0f;
            }
        }
        d21Var.k(f3, f4, false);
        if (nf2Var.b.isShowing()) {
            nf2Var.a();
        }
        boolean zG = d21.g(f3, this.A);
        float f5 = this.b;
        if (zG) {
            float f6 = this.Y;
            if (f6 < 32.0f) {
                f = 1.06f;
                f2 = 1.0f;
                if ((this.y0 & 1) == 0) {
                    this.Y = f6 + 1.0f;
                    this.f *= 1.06f;
                }
            } else {
                f = 1.06f;
                f2 = 1.0f;
            }
        } else {
            f = 1.06f;
            f2 = 1.0f;
            this.f = f5;
            this.Y = 0.0f;
        }
        if (d21.g(f4, this.X)) {
            float f7 = this.Z;
            if (f7 < 32.0f && (this.y0 & 1) == 0) {
                this.Z = f7 + f2;
                this.z *= f;
            }
        } else {
            this.z = f5;
            this.Z = 0.0f;
        }
        this.A = f3;
        this.X = f4;
        MotionEvent motionEvent = d21Var.z;
        if (motionEvent != null && !d21Var.e(motionEvent, true)) {
            MotionEvent motionEvent2 = d21Var.z;
            int i4 = d21Var.e;
            if (i4 == 0) {
                d21Var.c.f(motionEvent2);
            } else if (i4 == 1) {
                d21Var.u.f(motionEvent2);
            } else if (i4 == 2) {
                d21Var.v.f(motionEvent2);
            }
        }
        this.y0++;
        if (d21Var.x != 0) {
            codeEditor.a0(this, 10L);
        }
    }
}
