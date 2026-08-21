package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fs3 extends p60 {
    public final q30 c;
    public final q30 d;
    public final int e;

    public fs3(CodeEditor codeEditor, int i) {
        super(codeEditor);
        lg0 lg0VarM = codeEditor.getText().m();
        this.c = lg0VarM.c.a();
        this.d = lg0VarM.d.a();
        this.e = i;
    }

    public final boolean z() {
        return this.c.a != this.d.a;
    }
}
