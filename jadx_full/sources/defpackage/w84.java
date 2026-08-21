package defpackage;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w84 {
    public final u84 a;
    public final ArrayList b = new ArrayList();
    public t02 c;
    public t02 d;
    public int e;

    public w84(ViewGroup viewGroup) {
        View childAt;
        t02 t02Var = t02.e;
        this.c = t02Var;
        this.d = t02Var;
        Drawable background = viewGroup.getBackground();
        this.e = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        u84 u84Var = new u84(this, viewGroup.getContext(), viewGroup);
        this.a = u84Var;
        u84Var.setVisibility(8);
        u84Var.setWillNotDraw(true);
        o73 o73Var = new o73(9, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(u84Var, o73Var);
        fu4.a(u84Var, new v84(this));
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                childAt = null;
                break;
            }
            childAt = viewGroup.getChildAt(childCount);
            if (childAt.isAttachedToWindow() != viewGroup.isAttachedToWindow()) {
                break;
            } else {
                childCount--;
            }
        }
        if (childAt == null) {
            viewGroup.addView(u84Var, 0);
        } else {
            childAt.addOnAttachStateChangeListener(new gw3(viewGroup, u84Var));
        }
    }
}
