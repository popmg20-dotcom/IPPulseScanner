package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t11 {
    public static final gs3 h = new gs3();
    public float a;
    public float b;
    public final int c;
    public final gs3 d;
    public boolean e;
    public boolean f;
    public final /* synthetic */ u11 g;

    public t11(u11 u11Var, float f, float f2, int i, gs3 gs3Var) {
        this.g = u11Var;
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = gs3Var;
    }

    public final boolean a() {
        CodeEditor codeEditor = this.g.p;
        int i = this.c;
        if (i == 1 || i == 2) {
            return false;
        }
        return codeEditor.getCursorBlink().f || codeEditor.getEventHandler().e == 0 || codeEditor.y1;
    }
}
