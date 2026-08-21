package defpackage;

import android.animation.ValueAnimator;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tm2 implements pg0, ValueAnimator.AnimatorUpdateListener {
    public final CodeEditor a;
    public float f;
    public float g;
    public float h;
    public float i;
    public long j;
    public ValueAnimator b = new ValueAnimator();
    public ValueAnimator c = new ValueAnimator();
    public ValueAnimator e = new ValueAnimator();
    public ValueAnimator d = new ValueAnimator();

    public tm2(CodeEditor codeEditor) {
        this.a = codeEditor;
    }

    public final void a() {
        this.b.cancel();
        this.c.cancel();
        this.e.cancel();
        this.d.cancel();
    }

    public final boolean b() {
        return this.b.isRunning() || this.c.isRunning() || this.e.isRunning() || this.d.isRunning();
    }

    public final void c() {
        CodeEditor codeEditor = this.a;
        if (codeEditor.r1) {
            if (b()) {
                this.f = ((Float) this.b.getAnimatedValue()).floatValue();
                this.g = ((Float) this.c.getAnimatedValue()).floatValue();
                this.h = ((Float) this.e.getAnimatedValue()).floatValue();
                this.i = ((Float) this.d.getAnimatedValue()).floatValue();
                a();
            }
            if (System.currentTimeMillis() - this.j < 100) {
                return;
            }
            int i = codeEditor.getCursor().c.b;
            this.b.removeAllUpdateListeners();
            float[] fArrB = ((v0) codeEditor.getLayout()).b(codeEditor.getCursor().c.b, codeEditor.getCursor().c.c);
            this.b = ValueAnimator.ofFloat(this.f, codeEditor.T() + fArrB[1]);
            float f = this.g;
            float f2 = fArrB[0];
            codeEditor.getProps().getClass();
            this.c = ValueAnimator.ofFloat(f, f2 - 0.0f);
            this.e = ValueAnimator.ofFloat(this.h, codeEditor.getRowHeight() * codeEditor.getLayout().u(codeEditor.getCursor().c.b));
            this.d = ValueAnimator.ofFloat(this.i, ((v0) codeEditor.getLayout()).b(i, codeEditor.getText().o(i).f)[0]);
            this.b.addUpdateListener(this);
            this.b.setDuration(120L);
            this.c.setDuration(120L);
            this.e.setDuration(120L);
            this.d.setDuration(120L);
        }
    }

    public final void d() {
        CodeEditor codeEditor = this.a;
        int i = codeEditor.getCursor().c.b;
        float[] fArrB = ((v0) codeEditor.getLayout()).b(i, codeEditor.getCursor().c.c);
        this.f = codeEditor.T() + fArrB[1];
        float f = fArrB[0];
        codeEditor.getProps().getClass();
        this.g = f - 0.0f;
        this.h = codeEditor.getRowHeight() * codeEditor.getLayout().u(i);
        this.i = ((v0) codeEditor.getLayout()).b(i, codeEditor.getText().o(i).f)[0];
    }

    public final void e() {
        if (!this.a.r1 || System.currentTimeMillis() - this.j < 100) {
            this.j = System.currentTimeMillis();
            return;
        }
        this.b.start();
        this.c.start();
        this.e.start();
        this.d.start();
        this.j = System.currentTimeMillis();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.postInvalidateOnAnimation();
    }
}
