package defpackage;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ja2 implements t0, z2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ ja2(int i, Object obj) {
        this.f = obj;
        this.b = i;
    }

    @Override // defpackage.z2
    public boolean d(View view) {
        ((SideSheetBehavior) this.f).w(this.b);
        return true;
    }

    @Override // defpackage.t0
    public void f(int i, Object[] objArr) {
        na2 na2Var = (na2) this.f;
        CodeEditor codeEditor = na2Var.b;
        if (codeEditor == null || i > 0) {
            return;
        }
        codeEditor.b0(new iw(na2Var, codeEditor, this.b, 7));
    }
}
