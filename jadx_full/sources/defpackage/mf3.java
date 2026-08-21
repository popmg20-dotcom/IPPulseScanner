package defpackage;

import android.R;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.google.android.material.chip.Chip;
import com.google.android.material.loadingindicator.LoadingIndicator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mf3 extends rf3 {
    public boolean d;
    public final vf e;
    public final RecentRequestsActivity f;

    public mf3(RecentRequestsActivity recentRequestsActivity) {
        gm0 gm0Var = qv0.a;
        tq1 tq1Var = qf2.a;
        gm0 gm0Var2 = qv0.a;
        tq1Var.getClass();
        gm0Var2.getClass();
        vf vfVar = new vf(new zf2(2, this), tq1Var, gm0Var2);
        this.e = vfVar;
        this.c = 3;
        this.a.g();
        n(new ik1(2, this));
        lz2 lz2Var = new lz2(this);
        AtomicReference atomicReference = vfVar.h;
        if (atomicReference.get() == null) {
            f0 f0Var = vfVar.j;
            f0Var.getClass();
            atomicReference.set(f0Var);
            rf rfVar = vfVar.f;
            rfVar.getClass();
            n02 n02Var = rfVar.e;
            n02Var.getClass();
            ((CopyOnWriteArrayList) ((we0) n02Var.f).f).add(f0Var);
            b80 b80Var = (b80) ((m24) n02Var.z).i();
            if (b80Var != null) {
                f0Var.g(b80Var);
            }
        }
        vfVar.i.add(lz2Var);
        this.f = recentRequestsActivity;
    }

    public static final void q(mf3 mf3Var) {
        if (mf3Var.c != 3 || mf3Var.d) {
            return;
        }
        mf3Var.d = true;
        mf3Var.c = 1;
        mf3Var.a.g();
    }

    @Override // defpackage.rf3
    public final int b() {
        vf vfVar = this.e;
        ez2 ez2Var = (ez2) vfVar.e.get();
        return ez2Var != null ? ez2Var.f() : vfVar.f.d.f();
    }

    @Override // defpackage.rf3
    public final long c(int i) {
        return -1L;
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        Object objI;
        Object objI2;
        Object objI3;
        lf3 lf3Var = (lf3) rg3Var;
        Integer numValueOf = Integer.valueOf(R.drawable.sym_def_app_icon);
        vf vfVar = this.e;
        m24 m24Var = vfVar.c;
        do {
            try {
                objI2 = m24Var.i();
                ((Boolean) objI2).getClass();
            } catch (Throwable th) {
                do {
                    objI = m24Var.i();
                    ((Boolean) objI).getClass();
                } while (!m24Var.g(objI, Boolean.FALSE));
                throw th;
            }
        } while (!m24Var.g(objI2, Boolean.TRUE));
        vfVar.d = i;
        ez2 ez2Var = (ez2) vfVar.e.get();
        Object objN = ez2Var != null ? l72.n(ez2Var, i) : vfVar.f.a(i);
        do {
            objI3 = m24Var.i();
            ((Boolean) objI3).getClass();
        } while (!m24Var.g(objI3, Boolean.FALSE));
        final zi3 zi3Var = (zi3) objN;
        uf4 uf4Var = lf3Var.u;
        ConstraintLayout constraintLayout = (ConstraintLayout) uf4Var.f;
        TextView textView = (TextView) uf4Var.c;
        TextView textView2 = (TextView) uf4Var.d;
        Chip chip = (Chip) uf4Var.e;
        Chip chip2 = (Chip) uf4Var.g;
        ImageView imageView = (ImageView) uf4Var.a;
        Context context = constraintLayout.getContext();
        ((HorizontalScrollView) uf4Var.b).scrollTo(0, 0);
        if (zi3Var == null) {
            te3 te3VarO = t60.o(imageView.getContext());
            qy1 qy1Var = new qy1(imageView.getContext());
            qy1Var.c = numValueOf;
            qy1Var.d(imageView);
            te3VarO.a(qy1Var.a());
            textView2.setText("");
            textView.setText(com.getsurfboard.R.string.loading);
            chip.setText(com.getsurfboard.R.string.loading);
            chip2.setVisibility(8);
            int i2 = 9;
            imageView.setOnClickListener(new w3(i2));
            chip.setOnClickListener(new w3(i2));
            chip2.setOnClickListener(new w3(i2));
            constraintLayout.setOnLongClickListener(new kf3());
            return;
        }
        String str = zi3Var.e;
        String str2 = zi3Var.c;
        PackageInfo packageInfoG = ContextUtilsKt.g(str2);
        CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(zi3Var.b);
        if (packageInfoG != null) {
            context.getClass();
            te3 te3VarO2 = t60.o(context);
            qy1 qy1Var2 = new qy1(context);
            qy1Var2.c = packageInfoG;
            qy1Var2.d(imageView);
            qy1Var2.i = numValueOf;
            qy1Var2.c();
            te3VarO2.a(qy1Var2.a());
            ApplicationInfo applicationInfo = packageInfoG.applicationInfo;
            CharSequence applicationLabel = applicationInfo != null ? ContextUtilsKt.h().getApplicationLabel(applicationInfo) : packageInfoG.packageName;
            applicationLabel.getClass();
            textView2.setText(((Object) applicationLabel) + " • " + ((Object) relativeTimeSpanString));
        } else {
            te3 te3VarO3 = t60.o(imageView.getContext());
            qy1 qy1Var3 = new qy1(imageView.getContext());
            qy1Var3.c = numValueOf;
            qy1Var3.d(imageView);
            te3VarO3.a(qy1Var3.a());
            textView2.setText(str2 + " • " + ((Object) relativeTimeSpanString));
        }
        textView.setText(zi3Var.f);
        chip.setText(p44.H0(p44.H0(zi3Var.d, "\""), "'"));
        chip2.setVisibility(p44.x0(str) ? 8 : 0);
        chip2.setText(str);
        final int i3 = 0;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: jf3
            public final /* synthetic */ mf3 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i4 = i3;
                zi3 zi3Var2 = zi3Var;
                mf3 mf3Var = this.f;
                switch (i4) {
                    case 0:
                        mf3Var.f.x(zi3Var2.c);
                        return;
                    case 1:
                        RecentRequestsActivity recentRequestsActivity = mf3Var.f;
                        String str3 = zi3Var2.d;
                        recentRequestsActivity.getClass();
                        str3.getClass();
                        j80 j80Var = recentRequestsActivity.S0;
                        if (j80Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        if (((Chip) j80Var.e).getVisibility() == 0) {
                            return;
                        }
                        j80 j80Var2 = recentRequestsActivity.S0;
                        if (j80Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var2.e).setVisibility(0);
                        j80 j80Var3 = recentRequestsActivity.S0;
                        if (j80Var3 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var3.e).setText(str3);
                        j80 j80Var4 = recentRequestsActivity.S0;
                        if (j80Var4 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) j80Var4.d).setVisibility(0);
                        m24 m24Var2 = recentRequestsActivity.y().b;
                        oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, str3, null, 11);
                        m24Var2.getClass();
                        m24Var2.j(null, oj3VarA);
                        return;
                    default:
                        RecentRequestsActivity recentRequestsActivity2 = mf3Var.f;
                        String str4 = zi3Var2.e;
                        recentRequestsActivity2.getClass();
                        str4.getClass();
                        j80 j80Var5 = recentRequestsActivity2.S0;
                        if (j80Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        if (((Chip) j80Var5.f).getVisibility() == 0) {
                            return;
                        }
                        j80 j80Var6 = recentRequestsActivity2.S0;
                        if (j80Var6 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var6.f).setVisibility(0);
                        j80 j80Var7 = recentRequestsActivity2.S0;
                        if (j80Var7 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var7.f).setText(str4);
                        j80 j80Var8 = recentRequestsActivity2.S0;
                        if (j80Var8 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) j80Var8.d).setVisibility(0);
                        m24 m24Var3 = recentRequestsActivity2.y().b;
                        oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity2.y().b.i(), null, null, null, str4, 7);
                        m24Var3.getClass();
                        m24Var3.j(null, oj3VarA2);
                        return;
                }
            }
        });
        final int i4 = 1;
        chip.setOnClickListener(new View.OnClickListener(this) { // from class: jf3
            public final /* synthetic */ mf3 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i42 = i4;
                zi3 zi3Var2 = zi3Var;
                mf3 mf3Var = this.f;
                switch (i42) {
                    case 0:
                        mf3Var.f.x(zi3Var2.c);
                        return;
                    case 1:
                        RecentRequestsActivity recentRequestsActivity = mf3Var.f;
                        String str3 = zi3Var2.d;
                        recentRequestsActivity.getClass();
                        str3.getClass();
                        j80 j80Var = recentRequestsActivity.S0;
                        if (j80Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        if (((Chip) j80Var.e).getVisibility() == 0) {
                            return;
                        }
                        j80 j80Var2 = recentRequestsActivity.S0;
                        if (j80Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var2.e).setVisibility(0);
                        j80 j80Var3 = recentRequestsActivity.S0;
                        if (j80Var3 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var3.e).setText(str3);
                        j80 j80Var4 = recentRequestsActivity.S0;
                        if (j80Var4 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) j80Var4.d).setVisibility(0);
                        m24 m24Var2 = recentRequestsActivity.y().b;
                        oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, str3, null, 11);
                        m24Var2.getClass();
                        m24Var2.j(null, oj3VarA);
                        return;
                    default:
                        RecentRequestsActivity recentRequestsActivity2 = mf3Var.f;
                        String str4 = zi3Var2.e;
                        recentRequestsActivity2.getClass();
                        str4.getClass();
                        j80 j80Var5 = recentRequestsActivity2.S0;
                        if (j80Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        if (((Chip) j80Var5.f).getVisibility() == 0) {
                            return;
                        }
                        j80 j80Var6 = recentRequestsActivity2.S0;
                        if (j80Var6 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var6.f).setVisibility(0);
                        j80 j80Var7 = recentRequestsActivity2.S0;
                        if (j80Var7 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var7.f).setText(str4);
                        j80 j80Var8 = recentRequestsActivity2.S0;
                        if (j80Var8 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) j80Var8.d).setVisibility(0);
                        m24 m24Var3 = recentRequestsActivity2.y().b;
                        oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity2.y().b.i(), null, null, null, str4, 7);
                        m24Var3.getClass();
                        m24Var3.j(null, oj3VarA2);
                        return;
                }
            }
        });
        final int i5 = 2;
        chip2.setOnClickListener(new View.OnClickListener(this) { // from class: jf3
            public final /* synthetic */ mf3 f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i42 = i5;
                zi3 zi3Var2 = zi3Var;
                mf3 mf3Var = this.f;
                switch (i42) {
                    case 0:
                        mf3Var.f.x(zi3Var2.c);
                        return;
                    case 1:
                        RecentRequestsActivity recentRequestsActivity = mf3Var.f;
                        String str3 = zi3Var2.d;
                        recentRequestsActivity.getClass();
                        str3.getClass();
                        j80 j80Var = recentRequestsActivity.S0;
                        if (j80Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        if (((Chip) j80Var.e).getVisibility() == 0) {
                            return;
                        }
                        j80 j80Var2 = recentRequestsActivity.S0;
                        if (j80Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var2.e).setVisibility(0);
                        j80 j80Var3 = recentRequestsActivity.S0;
                        if (j80Var3 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var3.e).setText(str3);
                        j80 j80Var4 = recentRequestsActivity.S0;
                        if (j80Var4 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) j80Var4.d).setVisibility(0);
                        m24 m24Var2 = recentRequestsActivity.y().b;
                        oj3 oj3VarA = oj3.a((oj3) recentRequestsActivity.y().b.i(), null, null, str3, null, 11);
                        m24Var2.getClass();
                        m24Var2.j(null, oj3VarA);
                        return;
                    default:
                        RecentRequestsActivity recentRequestsActivity2 = mf3Var.f;
                        String str4 = zi3Var2.e;
                        recentRequestsActivity2.getClass();
                        str4.getClass();
                        j80 j80Var5 = recentRequestsActivity2.S0;
                        if (j80Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        if (((Chip) j80Var5.f).getVisibility() == 0) {
                            return;
                        }
                        j80 j80Var6 = recentRequestsActivity2.S0;
                        if (j80Var6 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var6.f).setVisibility(0);
                        j80 j80Var7 = recentRequestsActivity2.S0;
                        if (j80Var7 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((Chip) j80Var7.f).setText(str4);
                        j80 j80Var8 = recentRequestsActivity2.S0;
                        if (j80Var8 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((LoadingIndicator) j80Var8.d).setVisibility(0);
                        m24 m24Var3 = recentRequestsActivity2.y().b;
                        oj3 oj3VarA2 = oj3.a((oj3) recentRequestsActivity2.y().b.i(), null, null, null, str4, 7);
                        m24Var3.getClass();
                        m24Var3.j(null, oj3VarA2);
                        return;
                }
            }
        });
        constraintLayout.setOnLongClickListener(new ow0(3, zi3Var));
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        View viewInflate = ContextUtilsKt.f(viewGroup).inflate(com.getsurfboard.R.layout.item_recent_requests, viewGroup, false);
        int i2 = com.getsurfboard.R.id.dest;
        TextView textView = (TextView) vf2.l(viewInflate, com.getsurfboard.R.id.dest);
        if (textView != null) {
            i2 = com.getsurfboard.R.id.group;
            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) vf2.l(viewInflate, com.getsurfboard.R.id.group);
            if (horizontalScrollView != null) {
                i2 = com.getsurfboard.R.id.icon;
                ImageView imageView = (ImageView) vf2.l(viewInflate, com.getsurfboard.R.id.icon);
                if (imageView != null) {
                    i2 = com.getsurfboard.R.id.info;
                    TextView textView2 = (TextView) vf2.l(viewInflate, com.getsurfboard.R.id.info);
                    if (textView2 != null) {
                        i2 = com.getsurfboard.R.id.proxy;
                        Chip chip = (Chip) vf2.l(viewInflate, com.getsurfboard.R.id.proxy);
                        if (chip != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                            i2 = com.getsurfboard.R.id.rule;
                            Chip chip2 = (Chip) vf2.l(viewInflate, com.getsurfboard.R.id.rule);
                            if (chip2 != null) {
                                return new lf3(new uf4(textView, horizontalScrollView, imageView, textView2, chip, constraintLayout, chip2));
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
