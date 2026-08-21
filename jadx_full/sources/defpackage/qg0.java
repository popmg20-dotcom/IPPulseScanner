package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qg0 implements Runnable, l61 {
    public int X;
    public float[] Y;
    public final CodeEditor b;
    public boolean z;
    public long A = 0;
    public boolean f = true;

    public qg0(CodeEditor codeEditor, int i) {
        this.b = codeEditor;
        this.X = i;
        codeEditor.n0(fs3.class, this);
    }

    @Override // defpackage.l61
    public final void a(p60 p60Var, id0 id0Var) {
        this.A = System.currentTimeMillis();
        this.f = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.z || this.X <= 0) {
            this.f = true;
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.A;
        long j = ((long) this.X) * 2;
        CodeEditor codeEditor = this.b;
        if (jCurrentTimeMillis >= j) {
            this.f = !this.f;
            q30 q30VarA = codeEditor.getCursor().c.a();
            this.Y = codeEditor.getLayout().n(q30VarA.b, q30VarA.c, this.Y);
            if (!codeEditor.getCursor().a() && this.Y[0] >= codeEditor.getOffsetY()) {
                if (this.Y[0] - codeEditor.getRowHeight() <= codeEditor.getHeight() + codeEditor.getOffsetY() && this.Y[1] >= codeEditor.getOffsetX()) {
                    if (this.Y[1] - 100.0f <= codeEditor.getWidth() + codeEditor.getOffsetX()) {
                        codeEditor.postInvalidate();
                    }
                }
            }
        } else {
            this.f = true;
        }
        codeEditor.a0(this, this.X);
    }
}
