package defpackage;

import android.os.Build;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ri3 {
    public final v62 a = new v62(21);
    public final ti3 b;

    public ri3(CodeEditor codeEditor) {
        this.b = Build.VERSION.SDK_INT >= 29 ? new ti3(codeEditor) : null;
    }

    public final void a() {
        ti3 ti3Var;
        if (Build.VERSION.SDK_INT < 29 || (ti3Var = this.b) == null) {
            return;
        }
        Iterator it = ti3Var.b.iterator();
        while (it.hasNext()) {
            ((si3) it.next()).c = true;
        }
    }
}
