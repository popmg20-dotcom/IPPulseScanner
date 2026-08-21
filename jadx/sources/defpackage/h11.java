package defpackage;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.SurroundingText;
import android.view.inputmethod.TextAttribute;
import android.view.inputmethod.TextSnapshot;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h11 extends BaseInputConnection {
    public static final ve2 d = ve2.a("EditorInputConnection");
    public final CodeEditor a;
    public final w90 b;
    public boolean c;

    public h11(CodeEditor codeEditor) {
        super(codeEditor, true);
        this.b = new w90();
        this.c = false;
        this.a = codeEditor;
        codeEditor.n0(nd0.class, new g11(0, this));
    }

    public final void a(CharSequence charSequence) {
        w90 w90Var = this.b;
        boolean zA = w90Var.a();
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        if (w90Var.a()) {
            String string = ((ld0) codeEditor.getText().subSequence(w90Var.a, w90Var.b)).toString();
            String string2 = charSequence.toString();
            if (w90Var.b == codeEditor.getCursor().c.a && !codeEditor.getCursor().a() && string2.startsWith(string) && string2.length() > string.length()) {
                charSequence = string2.substring(string.length());
                w90Var.b = -1;
                w90Var.a = -1;
                w90Var.c = false;
            } else if (w90Var.a()) {
                try {
                    codeEditor.getText().g(w90Var.a, w90Var.b);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                w90Var.b = -1;
                w90Var.a = -1;
                w90Var.c = false;
            }
        }
        codeEditor.e(charSequence, true);
        if (zA) {
            endBatchEdit();
        }
    }

    public final CharSequence b(int i, int i2, int i3) {
        try {
            return c(i, i2, i3, false);
        } catch (IndexOutOfBoundsException e) {
            a1.o(d.a, "Failed to get text region for IME", e);
            return "";
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final synchronized boolean beginBatchEdit() {
        this.a.getProps().getClass();
        return this.a.getText().b();
    }

    public final CharSequence c(int i, int i2, int i3, boolean z) {
        CodeEditor codeEditor = this.a;
        ld0 text = codeEditor.getText();
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        int i4 = 0;
        if (i < 0) {
            i = 0;
        }
        int i5 = text.A;
        if (i2 > i5) {
            i2 = i5;
        }
        if (i2 < i) {
            i = 0;
            i2 = 0;
        }
        if (!z) {
            int i6 = i2 - i;
            codeEditor.getProps().getClass();
            if (i6 > 32768) {
                codeEditor.getProps().getClass();
                i2 = Math.max(0, 32768) + i;
            }
        }
        String string = ((ld0) text.subSequence(i, i2)).toString();
        if (i3 != 1) {
            return string;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        w90 w90Var = this.b;
        if (w90Var.a()) {
            try {
                int i7 = w90Var.a;
                int i8 = w90Var.b;
                int i9 = i7 - i;
                if (i9 < spannableStringBuilder.length()) {
                    if (i9 >= 0) {
                        i4 = i9;
                    }
                    int length = i8 - i;
                    if (length > 0) {
                        if (length >= spannableStringBuilder.length()) {
                            length = spannableStringBuilder.length();
                        }
                        spannableStringBuilder.setSpan(256, i4, length, 33);
                    }
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        return spannableStringBuilder;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int i) {
        j82 keyMetaStates = this.a.getKeyMetaStates();
        keyMetaStates.clearMetaKeyState(keyMetaStates.a, keyMetaStates.b, i);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final synchronized void closeConnection() {
        super.closeConnection();
        ld0 text = this.a.getText();
        while (text.X > 0) {
            text.k();
        }
        w90 w90Var = this.b;
        w90Var.b = -1;
        w90Var.a = -1;
        w90Var.c = false;
        CodeEditor codeEditor = this.a;
        codeEditor.setExtracting(null);
        codeEditor.invalidate();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        if (!this.a.H() || charSequence == null) {
            return false;
        }
        if (!"\n".equals(charSequence.toString())) {
            a(charSequence);
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, 66, 0, 0, -1, 0, 6));
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), jUptimeMillis, 1, 66, 0, 0, -1, 0, 6));
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        CodeEditor codeEditor = this.a;
        if (!codeEditor.H() || i < 0 || i2 < 0) {
            return false;
        }
        w90 w90Var = this.b;
        if (i == 1 && i2 == 0 && !w90Var.a()) {
            codeEditor.j();
            return true;
        }
        if (i > 0 && i2 > 0) {
            beginBatchEdit();
        }
        boolean zA = w90Var.a();
        int i3 = zA ? w90Var.a : 0;
        int i4 = zA ? w90Var.b : 0;
        int i5 = codeEditor.getCursor().c.a;
        int i6 = i5 - i;
        if (i6 < 0) {
            i6 = 0;
        }
        codeEditor.getText().g(i6, i5);
        if (zA) {
            int iMax = Math.max(i6, i3);
            int iMax2 = i4 - Math.max(0, Math.min(i5, i4) - iMax);
            int iMax3 = Math.max(0, iMax - i6);
            i4 = iMax2 - iMax3;
            i3 -= iMax3;
        }
        int i7 = codeEditor.getCursor().d.a;
        int i8 = i7 + i2;
        if (i8 > codeEditor.getText().A) {
            i8 = codeEditor.getText().A;
        }
        codeEditor.getText().g(i7, i8);
        if (zA) {
            int iMax4 = Math.max(i7, i3);
            Math.max(0, Math.min(i8, i4) - iMax4);
            Math.max(0, iMax4 - i7);
        }
        if (i > 0 && i2 > 0) {
            endBatchEdit();
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final synchronized boolean endBatchEdit() {
        boolean zK;
        zK = this.a.getText().k();
        if (!zK) {
            this.a.r0();
        }
        return zK;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        CodeEditor codeEditor = this.a;
        if (!codeEditor.H()) {
            return false;
        }
        codeEditor.getProps().getClass();
        w90 w90Var = this.b;
        w90Var.b = -1;
        w90Var.a = -1;
        w90Var.c = false;
        endBatchEdit();
        codeEditor.p0();
        codeEditor.invalidate();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        CodeEditor codeEditor = this.a;
        return TextUtils.getCapsMode(codeEditor.getText(), codeEditor.getCursor().c.a, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        codeEditor.getProps().getClass();
        if ((i & 1) != 0) {
            codeEditor.setExtracting(extractedTextRequest);
        } else {
            codeEditor.setExtracting(null);
        }
        return codeEditor.w(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return this.a.getHandler();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        int i2 = codeEditor.getCursor().c.a;
        int i3 = codeEditor.getCursor().d.a;
        if (i2 == i3) {
            return null;
        }
        return b(i2, i3, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final SurroundingText getSurroundingText(int i, int i2, int i3) {
        CharSequence charSequenceC;
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        if ((i | i2) < 0) {
            xe.k("length < 0");
            return null;
        }
        int iMin = Math.min(Math.max(0, codeEditor.getCursor().c.a - i), codeEditor.getCursor().c.a);
        try {
            charSequenceC = c(iMin, Math.min(codeEditor.getText().A, codeEditor.getCursor().d.a + i2), i3, true);
        } catch (IndexOutOfBoundsException e) {
            a1.o(d.a, "Failed to get text region for IME", e);
            charSequenceC = "";
        }
        k10.g();
        return k10.d(codeEditor.getCursor().c.a - iMin, codeEditor.getCursor().d.a - iMin, iMin, charSequenceC);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        int i3 = codeEditor.getCursor().d.a;
        return b(i3, i + i3, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        CodeEditor codeEditor = this.a;
        codeEditor.getProps().getClass();
        int i3 = codeEditor.getCursor().c.a;
        codeEditor.getProps().getClass();
        return b(Math.max(i3 - i, i3 - 32768), i3, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        CodeEditor codeEditor = this.a;
        switch (i) {
            case R.id.selectAll:
                codeEditor.f0();
                return true;
            case R.id.cut:
                codeEditor.f(true);
                if (codeEditor.getCursor().a()) {
                    codeEditor.j();
                }
                return true;
            case R.id.copy:
                codeEditor.f(true);
                return true;
            case R.id.paste:
                break;
            default:
                switch (i) {
                    case R.id.undo:
                        codeEditor.o0();
                        break;
                    case R.id.redo:
                        codeEditor.c0();
                        break;
                }
                return true;
        }
        codeEditor.Y();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        CodeEditor codeEditor = this.a;
        codeEditor.getClass();
        str.getClass();
        codeEditor.C0.a(new fq(codeEditor));
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean replaceText(int i, int i2, CharSequence charSequence, int i3, TextAttribute textAttribute) {
        int i4 = this.a.getText().A;
        if (i < 0 || i2 < 0 || i > i2 || i > i4 || i2 > i4) {
            return false;
        }
        beginBatchEdit();
        finishComposingText();
        setSelection(i, i2);
        commitText(charSequence, i3);
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        this.a.q0();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        CodeEditor codeEditor = this.a;
        if (codeEditor.H() && codeEditor.i1 == 0) {
            codeEditor.getProps().getClass();
            if (i == i2) {
                finishComposingText();
                return true;
            }
            if (i > i2) {
                i2 = i;
                i = i2;
            }
            if (i < 0) {
                i = 0;
            }
            try {
                int i3 = codeEditor.getText().A;
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i < i2) {
                    w90 w90Var = this.b;
                    w90Var.a = i;
                    w90Var.b = i2;
                    codeEditor.invalidate();
                    beginBatchEdit();
                    return true;
                }
            } catch (IndexOutOfBoundsException e) {
                a1.o(d.a, "set composing region for IME failed", e);
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) throws Throwable {
        CodeEditor codeEditor = this.a;
        if (codeEditor.H() && codeEditor.i1 == 0) {
            codeEditor.getProps().getClass();
            if (TextUtils.indexOf(charSequence, '\n') == -1) {
                w90 w90Var = this.b;
                if (!w90Var.a()) {
                    w90Var.c = true;
                    if (codeEditor.getCursor().a()) {
                        codeEditor.j();
                    }
                    beginBatchEdit();
                    codeEditor.e(charSequence, true);
                    w90Var.c = false;
                    int length = codeEditor.getCursor().c.a - charSequence.length();
                    int i2 = codeEditor.getCursor().c.a;
                    w90Var.a = length;
                    w90Var.b = i2;
                    codeEditor.p0();
                } else if (w90Var.a()) {
                    codeEditor.getProps().getClass();
                    String string = charSequence.toString();
                    ld0 text = codeEditor.getText();
                    String strD = text.D(w90Var.a, w90Var.b);
                    if (!strD.equals(string)) {
                        if (strD.length() < string.length() && string.startsWith(strD)) {
                            q30 q30VarJ = text.n().j(w90Var.b);
                            text.r(q30VarJ.b, q30VarJ.c, string.substring(strD.length()));
                        } else if (strD.length() <= string.length() || !strD.startsWith(string)) {
                            text.w(w90Var.a, w90Var.b, string);
                        } else {
                            text.g(w90Var.b - (strD.length() - string.length()), w90Var.b);
                        }
                    }
                    w90Var.b = w90Var.a + charSequence.length();
                }
                if (charSequence.length() == 0) {
                    finishComposingText();
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setImeConsumesInput(boolean z) {
        this.c = z;
        this.a.invalidate();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        CodeEditor codeEditor = this.a;
        boolean z = false;
        if (codeEditor.H()) {
            codeEditor.getProps().getClass();
            if (i < 0) {
                i = 0;
            } else if (i > codeEditor.getText().A) {
                i = codeEditor.getText().A;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > codeEditor.getText().A) {
                i2 = codeEditor.getText().A;
            }
            if (i > i2) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            z = true;
            if (i == codeEditor.getCursor().c.a && i2 == codeEditor.getCursor().d.a) {
                return true;
            }
            ld0 text = codeEditor.getText();
            q30 q30VarJ = text.n().j(i);
            q30 q30VarJ2 = text.n().j(i2);
            this.a.l0(q30VarJ.b, q30VarJ.c, q30VarJ2.b, q30VarJ2.c, 4, false);
        }
        return z;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final TextSnapshot takeSnapshot() {
        int i;
        int i2;
        w90 w90Var = this.b;
        if (w90Var.a()) {
            i = w90Var.a;
            i2 = w90Var.b;
        } else {
            i = -1;
            i2 = -1;
        }
        return f11.b(getSurroundingText(1024, 1024, 1), i, i2, getCursorCapsMode(28672));
    }
}
