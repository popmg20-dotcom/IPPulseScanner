package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p60 {
    public int a;
    public Object b;

    public p60(CodeEditor codeEditor) {
        System.currentTimeMillis();
        Objects.requireNonNull(codeEditor);
        this.b = codeEditor;
        this.a = 0;
    }

    public abstract void a(int i);

    public abstract int b();

    public abstract boolean c();

    public abstract void d(int i);

    public abstract int e(int i);

    public abstract boolean f();

    public abstract au g();

    public abstract double h();

    public abstract int i();

    public abstract int j();

    public abstract long k();

    public abstract float l();

    public abstract int m();

    public abstract long n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    public abstract String s();

    public abstract String t();

    public abstract int u();

    public abstract int v();

    public abstract long w();

    public abstract boolean x(int i);

    public void y() throws t12 {
        int iU;
        do {
            iU = u();
            if (iU == 0) {
                return;
            }
            int i = this.a;
            if (i >= 100) {
                throw new t12("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.a = i + 1;
            this.a--;
        } while (x(iU));
    }
}
