package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k60 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ CodeEditor f;
    public final /* synthetic */ Runnable z;

    public /* synthetic */ k60(CodeEditor codeEditor, Runnable runnable, int i) {
        this.b = i;
        this.f = codeEditor;
        this.z = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Runnable runnable = this.z;
        CodeEditor codeEditor = this.f;
        switch (i) {
            case 0:
                int i2 = CodeEditor.r2;
                if (!codeEditor.j1) {
                    runnable.run();
                    break;
                }
                break;
            default:
                int i3 = CodeEditor.r2;
                if (!codeEditor.j1) {
                    runnable.run();
                    break;
                }
                break;
        }
    }
}
