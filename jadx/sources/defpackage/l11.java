package defpackage;

import android.widget.PopupWindow;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l11 {
    public final int[] A = new int[2];
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public final boolean X;
    public boolean Y;
    public final boolean Z;
    public final PopupWindow b;
    public final CodeEditor f;
    public final CodeEditor y0;
    public final int z;
    public int z0;

    public l11(CodeEditor codeEditor, int i) {
        this.f = codeEditor;
        this.z = i;
        this.y0 = codeEditor;
        PopupWindow popupWindow = new PopupWindow();
        this.b = popupWindow;
        popupWindow.setElevation(codeEditor.getDpUnit() * 8.0f);
        int i2 = 1;
        r10 r10Var = new r10(i2, this);
        g11 g11Var = new g11(i2, this);
        if (!this.Y) {
            codeEditor.n0(oq3.class, g11Var);
            this.Y = true;
        }
        if (c(8) && !this.Z) {
            codeEditor.addOnLayoutChangeListener(r10Var);
            this.Z = true;
        }
        this.X = true;
    }

    public final void a(boolean z) {
        PopupWindow popupWindow = this.b;
        if (z || popupWindow.isShowing()) {
            boolean zC = c(1);
            int i = this.B0;
            CodeEditor codeEditor = this.f;
            int offsetX = i - (zC ? codeEditor.getOffsetX() : this.z0);
            int offsetY = this.C0 - (zC ? codeEditor.getOffsetY() : this.A0);
            int iMax = this.D0 + offsetX;
            int iMax2 = this.E0 + offsetY;
            if (!c(2)) {
                offsetX = Math.max(0, Math.min(offsetX, codeEditor.getWidth()));
                iMax = Math.max(0, Math.min(iMax, codeEditor.getWidth()));
                offsetY = Math.max(0, Math.min(offsetY, codeEditor.getHeight()));
                iMax2 = Math.max(0, Math.min(iMax2, codeEditor.getHeight()));
                if (offsetY >= iMax2 || offsetX >= iMax) {
                    b();
                    return;
                }
            }
            if (c(8)) {
                try {
                    lg0 cursor = codeEditor.getCursor();
                    if (cursor != null) {
                        q30 q30Var = cursor.c;
                        int i2 = q30Var.b;
                        int i3 = q30Var.c;
                        float fT = (codeEditor.T() + codeEditor.D0.b(i2, i3)[1]) - codeEditor.getOffsetX();
                        float offsetY2 = codeEditor.D0.b(i2, i3)[0] - codeEditor.getOffsetY();
                        if (!Float.isNaN(fT) && !Float.isNaN(offsetY2)) {
                            float fMax = Math.max(1.0f, codeEditor.getInsertSelectionWidth()) + fT;
                            float rowHeight = codeEditor.getRowHeight() + offsetY2;
                            if (fT < iMax && fMax > offsetX && offsetY2 < iMax2 && rowHeight > offsetY) {
                                b();
                                return;
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            int[] iArr = this.A;
            codeEditor.getLocationInWindow(iArr);
            int i4 = iMax - offsetX;
            int i5 = iMax2 - offsetY;
            int i6 = offsetX + iArr[0];
            int i7 = offsetY + iArr[1];
            if (popupWindow.isShowing()) {
                popupWindow.update(i6, i7, i4, i5);
            } else if (z) {
                popupWindow.setHeight(i5);
                popupWindow.setWidth(i4);
                popupWindow.showAtLocation(this.y0, 8388659, i6, i7);
            }
        }
    }

    public void b() {
        PopupWindow popupWindow = this.b;
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    public final boolean c(int i) {
        if (Integer.bitCount(i) == 1) {
            return (this.z & i) != 0;
        }
        xe.k("Not a valid feature integer");
        return false;
    }
}
