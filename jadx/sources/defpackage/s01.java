package defpackage;

import android.util.Log;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s01 extends Thread {
    public final v80 A;
    public long X;
    public boolean Y;
    public final /* synthetic */ t01 Z;
    public final q30 b;
    public final s82 f;
    public final wd0 z;

    public s01(t01 t01Var, long j, v80 v80Var) {
        this.Z = t01Var;
        this.X = j;
        CodeEditor codeEditor = t01Var.F0;
        this.b = codeEditor.getCursor().c.a();
        this.f = codeEditor.getEditorLanguage();
        wd0 wd0Var = new wd0(codeEditor.getText());
        this.z = wd0Var;
        wd0Var.A = this;
        this.A = v80Var;
        codeEditor.getExtraArguments();
        this.Y = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        t01 t01Var = this.Z;
        CodeEditor codeEditor = t01Var.F0;
        v80 v80Var = this.A;
        try {
            this.f.a(this.z, this.b, v80Var);
            if (v80Var.b.size() + v80Var.a.size() <= 0) {
                codeEditor.b0(new r01(t01Var, 3));
            } else if (t01Var.J0 == Thread.currentThread() && !v80Var.g) {
                v80Var.d.post(new cw(2, v80Var, true));
            }
            codeEditor.b0(new d4(25, this));
        } catch (Exception e) {
            if (e instanceof s80) {
                Log.v("CompletionThread", "Completion is cancelled");
            } else {
                a1.e("CompletionThread", "Completion failed", e);
            }
        }
    }
}
