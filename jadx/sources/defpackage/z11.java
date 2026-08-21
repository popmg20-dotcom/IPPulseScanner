package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z11 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ a21 f;

    public /* synthetic */ z11(a21 a21Var, int i) {
        this.b = i;
        this.f = a21Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        a21 a21Var = this.f;
        switch (i) {
            case 0:
                CodeEditor codeEditor = a21Var.F0;
                if (!codeEditor.getEventHandler().n() && !codeEditor.getCursor().a()) {
                    a21Var.b();
                } else if (!codeEditor.getCursor().a()) {
                    codeEditor.a0(this, 100L);
                }
                break;
            default:
                CodeEditor codeEditor2 = a21Var.F0;
                if (!a21Var.M0.f()) {
                    codeEditor2.getSnippetController().getClass();
                    if (System.currentTimeMillis() - a21Var.O0 > 200 && codeEditor2.getScroller().b.isFinished()) {
                        a21Var.f();
                    }
                }
                codeEditor2.a0(this, 200L);
                break;
        }
    }
}
