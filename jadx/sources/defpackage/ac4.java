package defpackage;

import android.os.Build;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ac4 {
    public static final ThreadLocal c = new ThreadLocal();
    public final Editable a;
    public final DynamicLayout b;

    public ac4() {
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable("");
        this.a = editableNewEditable;
        if (Build.VERSION.SDK_INT > 28) {
            this.b = DynamicLayout.Builder.obtain(editableNewEditable, new TextPaint(), 1073741823).setIncludePad(true).setLineSpacing(0.0f, 0.0f).setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
            return;
        }
        DynamicLayout dynamicLayout = new DynamicLayout(editableNewEditable, new TextPaint(), 1073741823, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
        this.b = dynamicLayout;
        try {
            Field declaredField = Layout.class.getDeclaredField("mTextDir");
            declaredField.setAccessible(true);
            declaredField.set(dynamicLayout, TextDirectionHeuristics.FIRSTSTRONG_LTR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ac4 a() {
        ThreadLocal threadLocal = c;
        ac4 ac4Var = (ac4) threadLocal.get();
        if (ac4Var != null) {
            return ac4Var;
        }
        ac4 ac4Var2 = new ac4();
        threadLocal.set(ac4Var2);
        return ac4Var2;
    }

    public final int b(int i, ud0 ud0Var) {
        int iMax = Math.max(0, i - 64);
        int i2 = i - iMax;
        int iMin = Math.min(ud0Var.f, i + 65);
        Editable editable = this.a;
        editable.append((CharSequence) ud0Var, iMax, iMin);
        Selection.setSelection(editable, Math.min(i2, editable.length()));
        Selection.moveLeft(editable, this.b);
        int selectionStart = Selection.getSelectionStart(editable);
        editable.clear();
        Selection.removeSelection(editable);
        return selectionStart + iMax;
    }
}
