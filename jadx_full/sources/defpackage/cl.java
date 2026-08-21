package defpackage;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.checkbox.MaterialCheckBox;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cl {
    public e8 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;

    public /* synthetic */ cl(View view, int i) {
        this.b = i;
        this.c = view;
    }

    public final void a(Drawable drawable) {
        int i = this.b;
        View view = this.c;
        switch (i) {
            case 0:
                dl dlVar = (dl) view;
                dlVar.setIndeterminate(false);
                dlVar.d(dlVar.f);
                break;
            case 1:
                dl dlVar2 = (dl) view;
                if (!dlVar2.B0) {
                    dlVar2.setVisibility(dlVar2.C0);
                }
                break;
            default:
                ColorStateList colorStateList = ((MaterialCheckBox) view).I0;
                if (colorStateList != null) {
                    drawable.setTintList(colorStateList);
                }
                break;
        }
    }

    public void b(Drawable drawable) {
        switch (this.b) {
            case 2:
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) this.c;
                ColorStateList colorStateList = materialCheckBox.I0;
                if (colorStateList != null) {
                    drawable.setTint(colorStateList.getColorForState(materialCheckBox.M0, colorStateList.getDefaultColor()));
                }
                break;
        }
    }

    public final void c(Drawable drawable) {
    }
}
