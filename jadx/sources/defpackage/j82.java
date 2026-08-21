package defpackage;

import android.text.Editable;
import android.text.method.MetaKeyKeyListener;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j82 extends MetaKeyKeyListener {
    public final CodeEditor a;
    public final Editable b = Editable.Factory.getInstance().newEditable("");
    public boolean c = false;

    public j82(CodeEditor codeEditor) {
        this.a = codeEditor;
    }

    public final boolean a() {
        return MetaKeyKeyListener.getMetaState(this.b, 2) == 1;
    }

    public final boolean b() {
        return MetaKeyKeyListener.getMetaState(this.b, 1) == 1;
    }
}
