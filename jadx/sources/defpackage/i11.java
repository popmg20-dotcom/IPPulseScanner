package defpackage;

import android.view.KeyEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class i11 extends p60 {
    public Boolean c;
    public final KeyEvent d;
    public final int e;
    public final boolean f;
    public final boolean g;

    public i11(CodeEditor codeEditor, KeyEvent keyEvent, int i) {
        super(codeEditor);
        this.d = keyEvent;
        this.e = i;
        this.f = ((CodeEditor) this.b).getKeyMetaStates().b();
        this.g = ((CodeEditor) this.b).getKeyMetaStates().a();
    }

    public final boolean A(boolean z) {
        Boolean bool = this.c;
        boolean z2 = bool != null && bool.booleanValue();
        return this.a != 0 ? z2 : z2 || z;
    }

    public final void z() {
        this.c = Boolean.TRUE;
        this.a = 3;
    }
}
