package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ob {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        qd0 pd0Var;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                pd0Var = new pd0(clipData, 3);
            } else {
                rd0 rd0Var = new rd0();
                rd0Var.b = clipData;
                rd0Var.c = 3;
                pd0Var = rd0Var;
            }
            wp4.j(textView, pd0Var.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        qd0 pd0Var;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            pd0Var = new pd0(clipData, 3);
        } else {
            rd0 rd0Var = new rd0();
            rd0Var.b = clipData;
            rd0Var.c = 3;
            pd0Var = rd0Var;
        }
        wp4.j(view, pd0Var.build());
        return true;
    }
}
