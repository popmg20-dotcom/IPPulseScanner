package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pa extends gb4 {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ pa(int i, Object obj) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.gb4, defpackage.er4
    public void b() {
        int i = this.g;
        Object obj = this.h;
        switch (i) {
            case 0:
                ((na) obj).f.L0.setVisibility(0);
                break;
            case 1:
                za zaVar = (za) obj;
                zaVar.L0.setVisibility(0);
                if (zaVar.L0.getParent() instanceof View) {
                    View view = (View) zaVar.L0.getParent();
                    WeakHashMap weakHashMap = wp4.a;
                    view.requestApplyInsets();
                }
                break;
        }
    }

    @Override // defpackage.er4
    public final void c() {
        int i = this.g;
        Object obj = this.h;
        switch (i) {
            case 0:
                za zaVar = ((na) obj).f;
                zaVar.L0.setAlpha(1.0f);
                zaVar.O0.d(null);
                zaVar.O0 = null;
                break;
            case 1:
                za zaVar2 = (za) obj;
                zaVar2.L0.setAlpha(1.0f);
                zaVar2.O0.d(null);
                zaVar2.O0 = null;
                break;
            default:
                za zaVar3 = (za) ((lb) obj).z;
                zaVar3.L0.setVisibility(8);
                PopupWindow popupWindow = zaVar3.M0;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (zaVar3.L0.getParent() instanceof View) {
                    View view = (View) zaVar3.L0.getParent();
                    WeakHashMap weakHashMap = wp4.a;
                    view.requestApplyInsets();
                }
                zaVar3.L0.e();
                zaVar3.O0.d(null);
                zaVar3.O0 = null;
                ViewGroup viewGroup = zaVar3.Q0;
                WeakHashMap weakHashMap2 = wp4.a;
                viewGroup.requestApplyInsets();
                break;
        }
    }
}
