package defpackage;

import android.widget.OverScroller;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v11 {
    public final CodeEditor a;
    public final OverScroller b;

    public v11(CodeEditor codeEditor) {
        this.b = new OverScroller(codeEditor.getContext());
        this.a = codeEditor;
    }

    public final void a() {
        OverScroller overScroller = this.b;
        int currX = overScroller.getCurrX();
        CodeEditor codeEditor = this.a;
        codeEditor.setScrollX(currX);
        codeEditor.setScrollY(overScroller.getCurrY());
    }

    public final void b(int i, int i2, int i3, int i4, int i5) {
        this.b.startScroll(i, i2, i3, i4, i5);
        a();
    }
}
