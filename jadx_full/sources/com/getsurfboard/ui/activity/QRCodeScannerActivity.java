package com.getsurfboard.ui.activity;

import android.graphics.RectF;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.getsurfboard.ui.widget.ViewFinderOverlay;
import com.google.android.material.button.MaterialButton;
import defpackage.ca;
import defpackage.f0;
import defpackage.g90;
import defpackage.ha1;
import defpackage.j53;
import defpackage.j80;
import defpackage.jd;
import defpackage.ji;
import defpackage.lx1;
import defpackage.mk;
import defpackage.n00;
import defpackage.n02;
import defpackage.n12;
import defpackage.n4;
import defpackage.nc2;
import defpackage.nx1;
import defpackage.o73;
import defpackage.pm1;
import defpackage.r20;
import defpackage.r25;
import defpackage.tp3;
import defpackage.um1;
import defpackage.v9;
import defpackage.v92;
import defpackage.vf2;
import defpackage.w4;
import defpackage.yu0;
import defpackage.zo2;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeScannerActivity extends ca {
    public static final /* synthetic */ int Y0 = 0;
    public v92 S0;
    public r20 T0;
    public ExecutorService U0;
    public lx1 V0;
    public boolean W0;
    public w4 X0;

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        nc2 nc2VarK;
        int i;
        v9.e(getWindow());
        super.onCreate(bundle);
        final int i2 = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_qrcode_scanner, (ViewGroup) null, false);
        int i3 = R.id.cameraPreview;
        PreviewView previewView = (PreviewView) vf2.l(viewInflate, R.id.cameraPreview);
        if (previewView != null) {
            i3 = R.id.center_horizontal;
            if (((Guideline) vf2.l(viewInflate, R.id.center_horizontal)) != null) {
                i3 = R.id.flash_control;
                MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.flash_control);
                if (materialButton != null) {
                    i3 = R.id.gallery;
                    MaterialButton materialButton2 = (MaterialButton) vf2.l(viewInflate, R.id.gallery);
                    if (materialButton2 != null) {
                        i3 = R.id.overlay;
                        ViewFinderOverlay viewFinderOverlay = (ViewFinderOverlay) vf2.l(viewInflate, R.id.overlay);
                        if (viewFinderOverlay != null) {
                            i3 = R.id.title;
                            TextView textView = (TextView) vf2.l(viewInflate, R.id.title);
                            if (textView != null) {
                                v92 v92Var = new v92();
                                v92Var.b = previewView;
                                v92Var.f = materialButton;
                                v92Var.z = materialButton2;
                                v92Var.A = viewFinderOverlay;
                                v92Var.X = textView;
                                this.S0 = v92Var;
                                setContentView((ConstraintLayout) viewInflate);
                                tp3 tp3Var = (tp3) r25.A(getIntent(), "config", tp3.class);
                                if (tp3Var != null) {
                                    v92 v92Var2 = this.S0;
                                    if (v92Var2 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((TextView) v92Var2.X).setText(tp3Var.b);
                                    v92 v92Var3 = this.S0;
                                    if (v92Var3 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((TextView) v92Var3.X).setCompoundDrawablesWithIntrinsicBounds(0, tp3Var.f, 0, 0);
                                }
                                j80 j80Var = j53.b.a;
                                synchronized (j80Var.a) {
                                    nc2VarK = (pm1) j80Var.b;
                                    i = 3;
                                    if (nc2VarK == null) {
                                        n00 n00Var = new n00(this, null);
                                        r20 r20VarW = n12.W(pm1.b((nc2) j80Var.c), new jd(18, new f0(10, n00Var)), yu0.a());
                                        j80Var.b = r20VarW;
                                        r20VarW.a(new um1(0, r20VarW, new n02(3, j80Var, n00Var, this)), yu0.a());
                                        nc2VarK = n12.K(r20VarW);
                                    }
                                }
                                this.T0 = n12.W(nc2VarK, new ha1(7, new zo2(new ji(22))), yu0.a());
                                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                                executorServiceNewSingleThreadExecutor.getClass();
                                this.U0 = executorServiceNewSingleThreadExecutor;
                                r20 r20Var = this.T0;
                                if (r20Var == null) {
                                    n12.T("cameraProviderFuture");
                                    throw null;
                                }
                                r20Var.a(new Runnable(this) { // from class: ac3
                                    public final /* synthetic */ QRCodeScannerActivity f;

                                    {
                                        this.f = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        s92 s92VarA;
                                        kz kzVarB;
                                        int i4 = i2;
                                        QRCodeScannerActivity qRCodeScannerActivity = this.f;
                                        switch (i4) {
                                            case 0:
                                                r20 r20Var2 = qRCodeScannerActivity.T0;
                                                if (r20Var2 == null) {
                                                    n12.T("cameraProviderFuture");
                                                    throw null;
                                                }
                                                j53 j53Var = (j53) r20Var2.get();
                                                if (qRCodeScannerActivity.isDestroyed() || qRCodeScannerActivity.isFinishing()) {
                                                    return;
                                                }
                                                if (j53Var != null) {
                                                    j53Var.a.g();
                                                }
                                                k43 k43Var = new k43(sw2.a(new qx(4).b));
                                                gy1.e(k43Var);
                                                j43 j43Var = new j43(k43Var);
                                                j43Var.q = j43.x;
                                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                linkedHashSet.add(new k92(1));
                                                b00 b00Var = new b00(linkedHashSet);
                                                qx qxVar = new qx(2);
                                                pr1 pr1Var = pr1.b;
                                                v92 v92Var4 = qRCodeScannerActivity.S0;
                                                if (v92Var4 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                int width = ((PreviewView) v92Var4.b).getWidth();
                                                v92 v92Var5 = qRCodeScannerActivity.S0;
                                                if (v92Var5 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                qxVar.b.g(hy1.F, new sj3(pr1Var, new tj3(new Size(width, ((PreviewView) v92Var5.b).getHeight())), null));
                                                qxVar.b.g(px1.f, 0);
                                                px1 px1Var = new px1(sw2.a(qxVar.b));
                                                gy1.e(px1Var);
                                                qRCodeScannerActivity.V0 = new lx1(px1Var);
                                                new dc3(qRCodeScannerActivity).enable();
                                                n02 n02Var = new n02(new bc3(qRCodeScannerActivity, 0));
                                                lx1 lx1Var = qRCodeScannerActivity.V0;
                                                if (lx1Var != null) {
                                                    ExecutorService executorService = qRCodeScannerActivity.U0;
                                                    if (executorService == null) {
                                                        n12.T("cameraExecutor");
                                                        throw null;
                                                    }
                                                    synchronized (lx1Var.p) {
                                                        try {
                                                            nx1 nx1Var = lx1Var.q;
                                                            if (nx1Var != null) {
                                                                nx1Var.h(executorService, new jd(16, n02Var));
                                                            }
                                                            if (lx1Var.s == null) {
                                                                lx1Var.o();
                                                            }
                                                            lx1Var.r = executorService;
                                                            lx1Var.s = n02Var;
                                                        } finally {
                                                        }
                                                        break;
                                                    }
                                                }
                                                v92 v92Var6 = qRCodeScannerActivity.S0;
                                                if (v92Var6 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                j43Var.E(((PreviewView) v92Var6.b).getSurfaceProvider());
                                                if (j53Var != null) {
                                                    try {
                                                        s92VarA = j53Var.a(qRCodeScannerActivity, b00Var, qRCodeScannerActivity.V0, j43Var);
                                                    } catch (IllegalArgumentException e) {
                                                        e.printStackTrace();
                                                        String message = e.getMessage();
                                                        if (message == null) {
                                                            message = qRCodeScannerActivity.getString(R.string.unknown_error);
                                                            message.getClass();
                                                        }
                                                        p95.D(message);
                                                        qRCodeScannerActivity.finish();
                                                        return;
                                                    }
                                                } else {
                                                    s92VarA = null;
                                                }
                                                if (s92VarA == null || (kzVarB = s92VarA.b()) == null || !((h5) kzVarB).b.m()) {
                                                    return;
                                                }
                                                v92 v92Var7 = qRCodeScannerActivity.S0;
                                                if (v92Var7 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                ((MaterialButton) v92Var7.f).setEnabled(true);
                                                v92 v92Var8 = qRCodeScannerActivity.S0;
                                                if (v92Var8 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                ((MaterialButton) v92Var8.f).setOnClickListener(new kd(6, s92VarA, qRCodeScannerActivity));
                                                ((h5) s92VarA.b()).b.e().e(qRCodeScannerActivity, new x3(9, new bc3(qRCodeScannerActivity, 1)));
                                                return;
                                            default:
                                                v92 v92Var9 = qRCodeScannerActivity.S0;
                                                if (v92Var9 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                ViewFinderOverlay viewFinderOverlay2 = (ViewFinderOverlay) v92Var9.A;
                                                float width2 = viewFinderOverlay2.getWidth();
                                                float height = viewFinderOverlay2.getHeight();
                                                float f = (80.0f * width2) / 100.0f;
                                                float f2 = (36.0f * height) / 100.0f;
                                                if (f > f2) {
                                                    f = f2;
                                                }
                                                float f3 = width2 / 2.0f;
                                                float f4 = height / 2.0f;
                                                float f5 = f / 2.0f;
                                                viewFinderOverlay2.y0 = new RectF(f3 - f5, f4 - f5, f3 + f5, f4 + f5);
                                                viewFinderOverlay2.invalidate();
                                                return;
                                        }
                                    }
                                }, v9.i(this));
                                v92 v92Var4 = this.S0;
                                if (v92Var4 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                final int i4 = 1;
                                ((ViewFinderOverlay) v92Var4.A).post(new Runnable(this) { // from class: ac3
                                    public final /* synthetic */ QRCodeScannerActivity f;

                                    {
                                        this.f = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        s92 s92VarA;
                                        kz kzVarB;
                                        int i42 = i4;
                                        QRCodeScannerActivity qRCodeScannerActivity = this.f;
                                        switch (i42) {
                                            case 0:
                                                r20 r20Var2 = qRCodeScannerActivity.T0;
                                                if (r20Var2 == null) {
                                                    n12.T("cameraProviderFuture");
                                                    throw null;
                                                }
                                                j53 j53Var = (j53) r20Var2.get();
                                                if (qRCodeScannerActivity.isDestroyed() || qRCodeScannerActivity.isFinishing()) {
                                                    return;
                                                }
                                                if (j53Var != null) {
                                                    j53Var.a.g();
                                                }
                                                k43 k43Var = new k43(sw2.a(new qx(4).b));
                                                gy1.e(k43Var);
                                                j43 j43Var = new j43(k43Var);
                                                j43Var.q = j43.x;
                                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                                linkedHashSet.add(new k92(1));
                                                b00 b00Var = new b00(linkedHashSet);
                                                qx qxVar = new qx(2);
                                                pr1 pr1Var = pr1.b;
                                                v92 v92Var42 = qRCodeScannerActivity.S0;
                                                if (v92Var42 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                int width = ((PreviewView) v92Var42.b).getWidth();
                                                v92 v92Var5 = qRCodeScannerActivity.S0;
                                                if (v92Var5 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                qxVar.b.g(hy1.F, new sj3(pr1Var, new tj3(new Size(width, ((PreviewView) v92Var5.b).getHeight())), null));
                                                qxVar.b.g(px1.f, 0);
                                                px1 px1Var = new px1(sw2.a(qxVar.b));
                                                gy1.e(px1Var);
                                                qRCodeScannerActivity.V0 = new lx1(px1Var);
                                                new dc3(qRCodeScannerActivity).enable();
                                                n02 n02Var = new n02(new bc3(qRCodeScannerActivity, 0));
                                                lx1 lx1Var = qRCodeScannerActivity.V0;
                                                if (lx1Var != null) {
                                                    ExecutorService executorService = qRCodeScannerActivity.U0;
                                                    if (executorService == null) {
                                                        n12.T("cameraExecutor");
                                                        throw null;
                                                    }
                                                    synchronized (lx1Var.p) {
                                                        try {
                                                            nx1 nx1Var = lx1Var.q;
                                                            if (nx1Var != null) {
                                                                nx1Var.h(executorService, new jd(16, n02Var));
                                                            }
                                                            if (lx1Var.s == null) {
                                                                lx1Var.o();
                                                            }
                                                            lx1Var.r = executorService;
                                                            lx1Var.s = n02Var;
                                                        } finally {
                                                        }
                                                        break;
                                                    }
                                                }
                                                v92 v92Var6 = qRCodeScannerActivity.S0;
                                                if (v92Var6 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                j43Var.E(((PreviewView) v92Var6.b).getSurfaceProvider());
                                                if (j53Var != null) {
                                                    try {
                                                        s92VarA = j53Var.a(qRCodeScannerActivity, b00Var, qRCodeScannerActivity.V0, j43Var);
                                                    } catch (IllegalArgumentException e) {
                                                        e.printStackTrace();
                                                        String message = e.getMessage();
                                                        if (message == null) {
                                                            message = qRCodeScannerActivity.getString(R.string.unknown_error);
                                                            message.getClass();
                                                        }
                                                        p95.D(message);
                                                        qRCodeScannerActivity.finish();
                                                        return;
                                                    }
                                                } else {
                                                    s92VarA = null;
                                                }
                                                if (s92VarA == null || (kzVarB = s92VarA.b()) == null || !((h5) kzVarB).b.m()) {
                                                    return;
                                                }
                                                v92 v92Var7 = qRCodeScannerActivity.S0;
                                                if (v92Var7 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                ((MaterialButton) v92Var7.f).setEnabled(true);
                                                v92 v92Var8 = qRCodeScannerActivity.S0;
                                                if (v92Var8 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                ((MaterialButton) v92Var8.f).setOnClickListener(new kd(6, s92VarA, qRCodeScannerActivity));
                                                ((h5) s92VarA.b()).b.e().e(qRCodeScannerActivity, new x3(9, new bc3(qRCodeScannerActivity, 1)));
                                                return;
                                            default:
                                                v92 v92Var9 = qRCodeScannerActivity.S0;
                                                if (v92Var9 == null) {
                                                    n12.T("binding");
                                                    throw null;
                                                }
                                                ViewFinderOverlay viewFinderOverlay2 = (ViewFinderOverlay) v92Var9.A;
                                                float width2 = viewFinderOverlay2.getWidth();
                                                float height = viewFinderOverlay2.getHeight();
                                                float f = (80.0f * width2) / 100.0f;
                                                float f2 = (36.0f * height) / 100.0f;
                                                if (f > f2) {
                                                    f = f2;
                                                }
                                                float f3 = width2 / 2.0f;
                                                float f4 = height / 2.0f;
                                                float f5 = f / 2.0f;
                                                viewFinderOverlay2.y0 = new RectF(f3 - f5, f4 - f5, f3 + f5, f4 + f5);
                                                viewFinderOverlay2.invalidate();
                                                return;
                                        }
                                    }
                                });
                                n4 n4Var = new n4(i);
                                o73 o73Var = new o73(6, this);
                                g90 g90Var = this.z0;
                                g90Var.getClass();
                                this.X0 = g90Var.d("activity_rq#" + this.y0.getAndIncrement(), this, n4Var, o73Var);
                                v92 v92Var5 = this.S0;
                                if (v92Var5 != null) {
                                    ((MaterialButton) v92Var5.z).setOnClickListener(new mk(22, this));
                                    return;
                                } else {
                                    n12.T("binding");
                                    throw null;
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i3)));
    }

    @Override // defpackage.ca, androidx.fragment.app.p, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        ExecutorService executorService = this.U0;
        if (executorService == null) {
            n12.T("cameraExecutor");
            throw null;
        }
        executorService.shutdown();
        lx1 lx1Var = this.V0;
        if (lx1Var != null) {
            synchronized (lx1Var.p) {
                try {
                    nx1 nx1Var = lx1Var.q;
                    if (nx1Var != null) {
                        nx1Var.h(null, null);
                    }
                    if (lx1Var.s != null) {
                        lx1Var.c = 2;
                        lx1Var.q();
                    }
                    lx1Var.r = null;
                    lx1Var.s = null;
                } finally {
                }
            }
        }
        r20 r20Var = this.T0;
        if (r20Var == null) {
            n12.T("cameraProviderFuture");
            throw null;
        }
        if (r20Var.b.isDone()) {
            r20 r20Var2 = this.T0;
            if (r20Var2 != null) {
                ((j53) r20Var2.get()).a.g();
            } else {
                n12.T("cameraProviderFuture");
                throw null;
            }
        }
    }
}
