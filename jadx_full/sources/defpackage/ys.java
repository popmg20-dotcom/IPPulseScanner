package defpackage;

import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ys extends rg3 {
    public final v92 u;

    /* JADX WARN: Illegal instructions before constructor call */
    public ys(v92 v92Var) {
        ConstraintLayout constraintLayout = (ConstraintLayout) v92Var.X;
        super(constraintLayout);
        this.u = v92Var;
        constraintLayout.setOnClickListener(new mk(1, this));
    }
}
