package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.i;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zb3 extends i {
    public zf2 H0;

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("title")) == null) {
            xe.k("title missing");
            return null;
        }
        wh2 wh2Var = new wh2(requireContext());
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_qrcode_image, (ViewGroup) null, false);
        ImageView imageView = (ImageView) vf2.l(viewInflate, R.id.image);
        if (imageView == null) {
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.image)));
            return null;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        this.H0 = new zf2(constraintLayout, imageView);
        ((p6) wh2Var.z).e = string;
        wh2Var.y(constraintLayout);
        wh2Var.w(android.R.string.ok, null);
        return wh2Var.h();
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.H0 = null;
    }

    @Override // androidx.fragment.app.i, androidx.fragment.app.o
    public final void onStart() {
        String string;
        super.onStart();
        try {
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("content")) == null) {
                throw new IllegalArgumentException("content missing");
            }
            ji0.B(uf2.t(this), null, null, new w53(this, string, null, 4), 3);
        } catch (ey4 e) {
            e.printStackTrace();
            j(false, false);
            p95.C(R.string.generate_qrcode_failed, new Object[0]);
        }
    }
}
