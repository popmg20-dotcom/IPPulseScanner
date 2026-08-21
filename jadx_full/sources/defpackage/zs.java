package defpackage;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.checkbox.MaterialCheckBox;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zs extends rb2 implements g23 {
    public ot e;
    public final w7 f;
    public final SimpleDateFormat g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zs(ot otVar, w7 w7Var) {
        super(at.a);
        otVar.getClass();
        this.e = otVar;
        this.f = w7Var;
        this.g = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    @Override // defpackage.g23
    public final String a(View view, int i) {
        xs xsVar = (xs) q(i);
        int iOrdinal = this.e.ordinal();
        if (iOrdinal == 0) {
            return xsVar.b.length() == 0 ? "" : String.valueOf(xsVar.b.charAt(0));
        }
        if (iOrdinal == 1) {
            return String.valueOf(Character.toUpperCase(xsVar.a.packageName.charAt(0)));
        }
        SimpleDateFormat simpleDateFormat = this.g;
        if (iOrdinal == 2) {
            String str = simpleDateFormat.format(new Date(xsVar.a.firstInstallTime));
            str.getClass();
            return str;
        }
        if (iOrdinal != 3) {
            g.d();
            return null;
        }
        String str2 = simpleDateFormat.format(new Date(xsVar.a.lastUpdateTime));
        str2.getClass();
        return str2;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        xs xsVar = (xs) q(i);
        v92 v92Var = ((ys) rg3Var).u;
        Context context = ((ConstraintLayout) v92Var.X).getContext();
        context.getClass();
        te3 te3VarO = t60.o(context);
        qy1 qy1Var = new qy1(context);
        qy1Var.c = xsVar.a;
        qy1Var.d((ImageView) v92Var.f);
        qy1Var.i = Integer.valueOf(R.drawable.sym_def_app_icon);
        qy1Var.c();
        te3VarO.a(qy1Var.a());
        ((TextView) v92Var.z).setText(xsVar.b);
        ((TextView) v92Var.A).setText(xsVar.a.packageName);
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) v92Var.b;
        materialCheckBox.setOnCheckedChangeListener(null);
        materialCheckBox.setChecked(xsVar.c);
        materialCheckBox.setOnCheckedChangeListener(new ni(1, this, xsVar));
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = ContextUtilsKt.f(viewGroup).inflate(com.getsurfboard.R.layout.item_bypass_app, viewGroup, false);
        int i2 = com.getsurfboard.R.id.check;
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) vf2.l(viewInflate, com.getsurfboard.R.id.check);
        if (materialCheckBox != null) {
            i2 = com.getsurfboard.R.id.icon;
            ImageView imageView = (ImageView) vf2.l(viewInflate, com.getsurfboard.R.id.icon);
            if (imageView != null) {
                i2 = com.getsurfboard.R.id.name;
                TextView textView = (TextView) vf2.l(viewInflate, com.getsurfboard.R.id.name);
                if (textView != null) {
                    i2 = com.getsurfboard.R.id.package_name;
                    TextView textView2 = (TextView) vf2.l(viewInflate, com.getsurfboard.R.id.package_name);
                    if (textView2 != null) {
                        return new ys(new v92(materialCheckBox, imageView, textView, textView2, (ConstraintLayout) viewInflate));
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
