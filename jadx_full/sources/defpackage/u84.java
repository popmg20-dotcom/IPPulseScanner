package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u84 extends View {
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ w84 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u84(w84 w84Var, Context context, ViewGroup viewGroup) {
        super(context);
        this.f = w84Var;
        this.b = viewGroup;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        w84 w84Var = this.f;
        ArrayList arrayList = w84Var.b;
        Drawable background = this.b.getBackground();
        int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        if (w84Var.e != color) {
            w84Var.e = color;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ArrayList arrayList2 = ((h93) arrayList.get(size)).a;
                int size2 = arrayList2.size() - 1;
                if (size2 >= 0) {
                    throw qe4.r(arrayList2, size2);
                }
            }
        }
    }
}
