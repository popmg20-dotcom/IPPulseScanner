package defpackage;

import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class v0 implements w82 {
    public static final ThreadPoolExecutor z = new ThreadPoolExecutor(2, Math.max(2, Runtime.getRuntime().availableProcessors()), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(128));
    public CodeEditor b;
    public ld0 f;

    public v0(CodeEditor codeEditor, ld0 ld0Var) {
        this.b = codeEditor;
        this.f = ld0Var;
    }

    public final float[] b(int i, int i2) {
        return n(i, i2, new float[2]);
    }

    public final void c() {
        this.b.getInlayHints();
        List list = Collections.EMPTY_LIST;
    }

    @Override // defpackage.vd0
    public final void I(ld0 ld0Var) {
    }
}
