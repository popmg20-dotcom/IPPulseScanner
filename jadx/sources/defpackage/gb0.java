package defpackage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gb0 implements go3, wn2 {
    public Throwable A;
    public final go3 b;
    public final wn2 f;
    public cf0 z;

    public gb0(go3 go3Var) {
        yn2 yn2Var = new yn2();
        go3Var.getClass();
        this.b = go3Var;
        this.f = yn2Var;
    }

    @Override // defpackage.go3
    public final io3 D0(String str) {
        str.getClass();
        return this.b.D0(str);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        this.b.close();
    }

    @Override // defpackage.wn2
    public final Object g(ie0 ie0Var) {
        return this.f.g(ie0Var);
    }

    @Override // defpackage.wn2
    public final void n(Object obj) {
        this.f.n(null);
    }

    public final void s(StringBuilder sb) {
        if (this.z == null && this.A == null) {
            sb.append("\t\tStatus: Free connection");
            sb.append('\n');
            return;
        }
        sb.append("\t\tStatus: Acquired connection");
        sb.append('\n');
        cf0 cf0Var = this.z;
        if (cf0Var != null) {
            sb.append("\t\tCoroutine: " + cf0Var);
            sb.append('\n');
        }
        Throwable th = this.A;
        if (th != null) {
            sb.append("\t\tAcquired:");
            sb.append('\n');
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String string = stringWriter.toString();
            string.getClass();
            Iterator it = d70.Y(p44.B0(string)).iterator();
            while (it.hasNext()) {
                sb.append("\t\t" + ((String) it.next()));
                sb.append('\n');
            }
        }
    }

    public final String toString() {
        return this.b.toString();
    }
}
