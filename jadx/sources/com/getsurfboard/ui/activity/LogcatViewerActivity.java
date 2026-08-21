package com.getsurfboard.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.a;
import com.getsurfboard.R;
import defpackage.ca;
import defpackage.f70;
import defpackage.l72;
import defpackage.se2;
import defpackage.v9;
import defpackage.zo2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatViewerActivity extends ca {
    public static final /* synthetic */ int S0 = 0;

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_logcat_viewer, (ViewGroup) null, false);
        if (viewInflate == null) {
            zo2.n("rootView");
            return;
        }
        setContentView((ConstraintLayout) viewInflate);
        ArrayList arrayList = new ArrayList();
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("exclude_list");
        if (stringArrayListExtra != null) {
            Iterator<String> it = stringArrayListExtra.iterator();
            it.getClass();
            while (it.hasNext()) {
                Pattern patternCompile = Pattern.compile(it.next());
                patternCompile.getClass();
                arrayList.add(patternCompile);
            }
        }
        if (bundle == null) {
            a aVar = new a(u());
            Bundle bundle2 = new Bundle();
            ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Pattern) it2.next()).pattern());
            }
            bundle2.putStringArrayList("exclude_list", new ArrayList<>(arrayList2));
            se2 se2Var = new se2();
            se2Var.setArguments(bundle2);
            aVar.k(se2Var, R.id.container);
            aVar.e();
        }
    }
}
