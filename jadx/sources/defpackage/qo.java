package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class qo extends cb {
    @Override // defpackage.cb, androidx.fragment.app.i
    public final Dialog k() {
        Context context = getContext();
        int i = this.Y;
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            i = context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
        }
        po poVar = new po(context, i);
        poVar.B0 = true;
        poVar.C0 = true;
        poVar.H0 = new no(poVar, 0);
        poVar.d().i(1);
        TypedArray typedArrayObtainStyledAttributes = poVar.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge});
        poVar.F0 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return poVar;
    }
}
