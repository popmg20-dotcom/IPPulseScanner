package defpackage;

import android.graphics.Canvas;
import android.graphics.RenderNode;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ti3 {
    public final CodeEditor a;
    public final ArrayList b = new ArrayList(64);
    public final Stack c = new Stack();

    public ti3(CodeEditor codeEditor) {
        this.a = codeEditor;
    }

    public final void a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        ArrayList<si3> arrayList2 = this.b;
        for (si3 si3Var : arrayList2) {
            int i3 = si3Var.a;
            if (i3 == i) {
                si3Var.c = true;
            } else if (i + 1 <= i3 && i3 <= i2) {
                arrayList.add(si3Var);
                si3Var.b.discardDisplayList();
            } else if (i3 > i2) {
                si3Var.a = i3 - (i2 - i);
            }
        }
        arrayList2.removeAll(d70.C0(arrayList));
        this.c.addAll(arrayList);
    }

    public final int b(float f, float f2, int i, Canvas canvas) {
        si3 si3Var;
        si3 si3Var2;
        boolean z = false;
        if (!canvas.isHardwareAccelerated()) {
            vp1.n("Only hardware-accelerated canvas can be used");
            return 0;
        }
        CodeEditor codeEditor = this.a;
        a54 styles = codeEditor.getStyles();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Object obj = arrayList.get(i2);
                obj.getClass();
                si3Var2 = (si3) obj;
                if (si3Var2.a == i) {
                    Collections.swap(arrayList, 0, i2);
                    break;
                }
                i2++;
            } else {
                Stack stack = this.c;
                if (stack.isEmpty()) {
                    si3Var = new si3();
                    si3Var.a = i;
                    si3Var.b = new RenderNode("editorRenderNode");
                    si3Var.c = true;
                } else {
                    si3Var = (si3) stack.pop();
                }
                si3Var2 = si3Var;
                si3Var2.a = i;
                si3Var2.c = true;
                arrayList.add(0, si3Var2);
            }
        }
        if (si3Var2.c || !si3Var2.b.hasDisplayList()) {
            lb lbVar = styles != null ? styles.a : null;
            sz3 lbVar2 = lbVar == null ? i41.f : new lb(11, lbVar, z);
            try {
                lbVar2.d(i);
            } catch (Exception unused) {
                lbVar2 = i41.f;
            }
            sz3 sz3Var = lbVar2;
            u11 renderer = codeEditor.getRenderer();
            RenderNode renderNode = si3Var2.b;
            renderNode.setPosition(0, 0, (int) (renderer.r(null, i, 0.0f, 0.0f, sz3Var, false) + 0.5f), renderer.p.getRowHeight());
            try {
                renderer.r(renderNode.beginRecording(), i, 0.0f, 0.0f, sz3Var, false);
                renderNode.endRecording();
                try {
                    sz3Var.d(-1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                si3Var2.c = false;
            } catch (Throwable th) {
                renderNode.endRecording();
                throw th;
            }
        }
        canvas.save();
        canvas.translate(f, f2);
        canvas.drawRenderNode(si3Var2.b);
        canvas.restore();
        return si3Var2.b.getWidth();
    }

    public final void c(hm2 hm2Var) {
        Iterator it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            si3 si3Var = (si3) next;
            int i = si3Var.a;
            int i2 = hm2Var.b;
            if (i <= hm2Var.c && i2 <= i) {
                it.remove();
                si3Var.b.discardDisplayList();
                this.c.push(si3Var);
            }
        }
    }

    public final void d(int i, int i2) {
        Iterator it = this.b.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            si3 si3Var = (si3) next;
            int i3 = si3Var.a;
            if (i3 < i || i3 > i2) {
                it.remove();
                si3Var.b.discardDisplayList();
            }
        }
    }
}
