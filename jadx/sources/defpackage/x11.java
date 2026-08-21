package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x11 {
    public final CodeEditor a;
    public String b;
    public ue2 c;
    public Thread d;
    public t6 e;
    public boolean f = true;

    public x11(CodeEditor codeEditor) {
        this.a = codeEditor;
        codeEditor.n0(nd0.class, new g11(2, this));
    }

    public final void a() {
        Thread thread = this.d;
        if (thread != null && thread.isAlive()) {
            this.d.interrupt();
        }
        Thread thread2 = new Thread(new w11(this, this.a.getText(), this.c, this.b));
        this.d = thread2;
        thread2.start();
    }

    public final boolean b() {
        Thread thread = this.d;
        return thread == null || !thread.isAlive();
    }

    public final void c() {
        Thread thread = this.d;
        if (thread != null && thread.isAlive()) {
            this.d.interrupt();
        }
        this.d = null;
        this.e = null;
        this.b = null;
        this.c = null;
        CodeEditor codeEditor = this.a;
        codeEditor.C0.a(new ub3(codeEditor));
    }
}
