package defpackage;

import android.view.View;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.SymbolInputView;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yw0 implements View.OnClickListener {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ int f;
    public final /* synthetic */ Serializable z;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ yw0(SymbolInputView symbolInputView, String[] strArr, int i) {
        this.b = 2;
        this.A = symbolInputView;
        this.z = strArr;
        this.f = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        int i2 = this.f;
        Object obj = this.z;
        Object obj2 = this.A;
        switch (i) {
            case 0:
                String str = (String) obj;
                op opVar = (op) ((bx0) obj2).f;
                view.getClass();
                Integer numValueOf = Integer.valueOf(i2);
                str.getClass();
                opVar.e(view, numValueOf, str);
                break;
            case 1:
                OverrideDoHActivity overrideDoHActivity = (OverrideDoHActivity) obj2;
                overrideDoHActivity.T0.add(i2, (String) obj);
                bx0 bx0Var = overrideDoHActivity.V0;
                ArrayList arrayList = overrideDoHActivity.T0;
                bx0Var.r(d70.y0(arrayList));
                t23.x(arrayList);
                overrideDoHActivity.A();
                break;
            default:
                SymbolInputView symbolInputView = (SymbolInputView) obj2;
                String[] strArr = (String[]) obj;
                int i3 = SymbolInputView.z;
                CodeEditor codeEditor = symbolInputView.f;
                if (codeEditor != null && codeEditor.H()) {
                    boolean zEquals = "\t".equals(strArr[i2]);
                    CodeEditor codeEditor2 = symbolInputView.f;
                    if (!zEquals) {
                        String str2 = strArr[i2];
                        codeEditor2.getClass();
                        if (1 > str2.length()) {
                            xe.k("selectionOffset is invalid");
                        } else {
                            lg0 lg0VarM = codeEditor2.getText().m();
                            if (lg0VarM.a()) {
                                codeEditor2.j();
                                codeEditor2.W();
                            }
                            ld0 ld0Var = codeEditor2.J1;
                            q30 q30Var = lg0VarM.d;
                            ld0Var.r(q30Var.b, q30Var.c, str2);
                            codeEditor2.W();
                            if (1 != str2.length()) {
                                q30 q30VarJ = codeEditor2.J1.n().j(lg0VarM.d.a - (str2.length() - 1));
                                codeEditor2.i0(q30VarJ.b, q30VarJ.c);
                            }
                        }
                    } else {
                        codeEditor2.getSnippetController().getClass();
                        symbolInputView.f.G();
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ yw0(int i, int i2, Object obj, String str) {
        this.b = i2;
        this.A = obj;
        this.f = i;
        this.z = str;
    }
}
