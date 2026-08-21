package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h4 {
    public final View a;
    public final ViewGroup b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final ViewGroup g;
    public final View h;
    public final View i;
    public final View j;

    public h4(CoordinatorLayout coordinatorLayout, MaterialDivider materialDivider, MaterialTextView materialTextView, MaterialTextView materialTextView2, NestedScrollView nestedScrollView, Toolbar toolbar, MaterialDivider materialDivider2, MaterialTextView materialTextView3, MaterialTextView materialTextView4, CircularProgressIndicator circularProgressIndicator) {
        this.b = coordinatorLayout;
        this.j = materialDivider;
        this.c = materialTextView;
        this.d = materialTextView2;
        this.g = nestedScrollView;
        this.i = toolbar;
        this.a = materialDivider2;
        this.e = materialTextView3;
        this.f = materialTextView4;
        this.h = circularProgressIndicator;
    }

    public h4(MaterialCardView materialCardView, MaterialButton materialButton, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, MaterialAutoCompleteTextView materialAutoCompleteTextView, TextInputLayout textInputLayout3, TextInputLayout textInputLayout4, MaterialAutoCompleteTextView materialAutoCompleteTextView2, TextInputEditText textInputEditText, MaterialButton materialButton2) {
        this.b = materialCardView;
        this.c = materialButton;
        this.a = textInputLayout;
        this.d = textInputLayout2;
        this.e = materialAutoCompleteTextView;
        this.f = textInputLayout3;
        this.g = textInputLayout4;
        this.h = materialAutoCompleteTextView2;
        this.i = textInputEditText;
        this.j = materialButton2;
    }

    public h4(CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout, AutoCompleteTextView autoCompleteTextView, TextInputLayout textInputLayout, LinearProgressIndicator linearProgressIndicator, TextView textView, NestedScrollView nestedScrollView, AppCompatButton appCompatButton, Toolbar toolbar, MaterialDivider materialDivider) {
        this.b = coordinatorLayout;
        this.c = constraintLayout;
        this.d = autoCompleteTextView;
        this.a = textInputLayout;
        this.e = linearProgressIndicator;
        this.f = textView;
        this.g = nestedScrollView;
        this.h = appCompatButton;
        this.i = toolbar;
        this.j = materialDivider;
    }
}
