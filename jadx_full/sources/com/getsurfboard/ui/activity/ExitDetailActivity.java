package com.getsurfboard.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.a;
import com.getsurfboard.R;
import defpackage.ca;
import defpackage.e03;
import defpackage.l72;
import defpackage.n12;
import defpackage.v71;
import defpackage.v9;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ExitDetailActivity extends ca {
    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_exit_detail_container, (ViewGroup) null, false);
        if (viewInflate == null) {
            zo2.n("rootView");
            return;
        }
        setContentView((FrameLayout) viewInflate);
        if (bundle == null) {
            a aVar = new a(u());
            long longExtra = getIntent().getLongExtra("timestamp", 0L);
            int intExtra = getIntent().getIntExtra("pid", 0);
            v71 v71Var = new v71();
            v71Var.setArguments(n12.e(new e03("timestamp", Long.valueOf(longExtra)), new e03("pid", Integer.valueOf(intExtra)), new e03("show_nav_icon", Boolean.TRUE)));
            aVar.k(v71Var, R.id.container);
            aVar.e();
        }
    }
}
