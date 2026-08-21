package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.ui.widget.SparklineView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dk1 {
    public final TextView a;
    public final Chip b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final Chip f;
    public final Chip g;
    public final View h;
    public final TextView i;
    public final View j;
    public final View k;
    public final View l;
    public final View m;

    public dk1(LinearLayoutCompat linearLayoutCompat, RadioButton radioButton, ConstraintLayout constraintLayout, TextView textView, Chip chip, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, ImageView imageView2, FrameLayout frameLayout, Chip chip2, Chip chip3) {
        this.h = linearLayoutCompat;
        this.i = radioButton;
        this.j = constraintLayout;
        this.a = textView;
        this.b = chip;
        this.c = textView2;
        this.k = imageView;
        this.d = textView3;
        this.e = textView4;
        this.l = imageView2;
        this.m = frameLayout;
        this.f = chip2;
        this.g = chip3;
    }

    public dk1(MaterialCardView materialCardView, TextView textView, Chip chip, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Chip chip2, Chip chip3, SparklineView sparklineView, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.a = textView;
        this.b = chip;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.h = textView5;
        this.f = chip2;
        this.g = chip3;
        this.m = sparklineView;
        this.i = textView6;
        this.j = textView7;
        this.k = textView8;
        this.l = textView9;
    }
}
