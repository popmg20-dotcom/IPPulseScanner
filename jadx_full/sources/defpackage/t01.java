package defpackage;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t01 extends l11 {
    public final CodeEditor F0;
    public boolean G0;
    public long H0;
    public int I0;
    public s01 J0;
    public v80 K0;
    public WeakReference L0;
    public int M0;
    public final xk0 N0;
    public final iv1 O0;
    public final k61 P0;
    public q30 Q0;
    public long R0;
    public long S0;
    public boolean T0;
    public boolean U0;
    public final boolean V0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public t01(CodeEditor codeEditor) {
        super(codeEditor, 4);
        final int i = 4;
        this.G0 = false;
        this.M0 = -1;
        this.R0 = 0L;
        this.S0 = -1L;
        final int i2 = 1;
        this.T0 = true;
        this.U0 = false;
        this.V0 = true;
        this.F0 = codeEditor;
        xk0 xk0Var = new xk0();
        this.N0 = xk0Var;
        int i3 = 7;
        iv1 iv1Var = new iv1(i3, false);
        this.O0 = iv1Var;
        iv1Var.X = this;
        Context context = codeEditor.getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        iv1Var.A = linearLayout;
        iv1Var.f = new ListView(context);
        iv1Var.z = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        linearLayout.setOrientation(1);
        ((LinearLayout) iv1Var.A).setLayoutTransition(null);
        ((ListView) iv1Var.f).setLayoutTransition(null);
        linearLayout.addView((ProgressBar) iv1Var.z, new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics())));
        linearLayout.addView((ListView) iv1Var.f, new LinearLayout.LayoutParams(-1, -1));
        ((ProgressBar) iv1Var.z).setIndeterminate(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ((ProgressBar) iv1Var.z).getLayoutParams();
        layoutParams.topMargin = (int) TypedValue.applyDimension(1, -8.0f, context.getResources().getDisplayMetrics());
        layoutParams.bottomMargin = (int) TypedValue.applyDimension(1, -8.0f, context.getResources().getDisplayMetrics());
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
        layoutParams.rightMargin = (int) TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        LinearLayout linearLayout2 = (LinearLayout) iv1Var.A;
        linearLayout2.setOutlineProvider(new zk0());
        linearLayout2.setClipToOutline(true);
        ((ListView) iv1Var.f).setDividerHeight(0);
        ((ProgressBar) iv1Var.z).setVisibility(0);
        ((ListView) iv1Var.f).setOnItemClickListener(new t5(i2, iv1Var, context));
        this.b.setContentView(linearLayout);
        d();
        ((ListView) this.O0.f).setAdapter(xk0Var);
        k61 k61Var = new k61(codeEditor.C0);
        this.P0 = k61Var;
        final Object[] objArr = 0 == true ? 1 : 0;
        k61Var.f(s70.class, new l61(this) { // from class: o01
            public final /* synthetic */ t01 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i4;
                int i5;
                int i6 = objArr;
                boolean z = true;
                t01 t01Var = this.f;
                switch (i6) {
                    case 0:
                        t01Var.d();
                        break;
                    case 1:
                        nd0 nd0Var = (nd0) p60Var;
                        PopupWindow popupWindow = t01Var.b;
                        CodeEditor codeEditor2 = t01Var.F0;
                        if (nd0Var.f || !t01Var.T0 || (i4 = nd0Var.c) == 1) {
                            t01Var.f();
                        } else {
                            q30 q30Var = nd0Var.d;
                            q30 q30Var2 = nd0Var.e;
                            if (i4 == 2) {
                                if (codeEditor2.B0.b.a()) {
                                    codeEditor2.getProps().getClass();
                                }
                                if (q30Var2.c == 0 || q30Var.b != q30Var2.b) {
                                    t01Var.f();
                                    z = false;
                                }
                                t01Var.k(popupWindow.isShowing());
                            } else if (i4 != 3 || codeEditor2.B0.b.a() || !popupWindow.isShowing()) {
                                z = false;
                            } else if (q30Var.b == q30Var2.b && q30Var.c == q30Var2.c - 1) {
                                t01Var.k(true);
                            } else {
                                t01Var.f();
                                z = false;
                            }
                            if (z) {
                                t01Var.h();
                            }
                        }
                        break;
                    case 2:
                        int i7 = ((oq3) p60Var).g;
                        if (i7 == 1) {
                            t01Var.k(false);
                        } else if (i7 == 2) {
                            float dpUnit = t01Var.F0.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                t01Var.f();
                            }
                        }
                        break;
                    case 3:
                        i11 i11Var = (i11) p60Var;
                        int i8 = i11Var.e;
                        KeyEvent keyEvent = i11Var.d;
                        if (i8 == 2 && !i11Var.g && (keyEvent.getMetaState() & 4096) == 0 && !i11Var.f && t01Var.b.isShowing()) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 19) {
                                ListView listView = (ListView) t01Var.O0.f;
                                int i9 = t01Var.M0 - 1;
                                if (i9 >= 0) {
                                    t01Var.M0 = i9;
                                    ((xk0) listView.getAdapter()).notifyDataSetChanged();
                                    int i10 = t01Var.M0;
                                    if (i10 != -1) {
                                        iv1 iv1Var2 = t01Var.O0;
                                        ((ListView) iv1Var2.f).post(new yk0(iv1Var2, i10, (int) TypedValue.applyDimension(1, 45.0f, t01Var.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
                                    }
                                }
                                i11Var.z();
                            } else if (keyCode == 20) {
                                t01Var.g();
                                i11Var.z();
                            } else if (keyCode == 61) {
                                if (t01Var.M0 == -1) {
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 66) {
                                if (t01Var.M0 == -1) {
                                    t01Var.F0.getProps().getClass();
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 92 || keyCode == 93) {
                                t01Var.f();
                            }
                            break;
                        }
                        break;
                    case 4:
                        fs3 fs3Var = (fs3) p60Var;
                        boolean z2 = fs3Var.z();
                        q30 q30Var3 = fs3Var.c;
                        if (!z2 && (i5 = fs3Var.e) != 4 && i5 != 2 && i5 != 3 && i5 != 6 && i5 != 0) {
                            q30 q30Var4 = t01Var.Q0;
                            if (q30Var4 == null) {
                                t01Var.Q0 = q30Var3.a();
                                break;
                            } else if (i5 == 7) {
                                if (q30Var4.b != q30Var3.b) {
                                    t01Var.f();
                                    break;
                                } else if (t01Var.b.isShowing() && Math.abs(t01Var.Q0.c - q30Var3.c) <= 1) {
                                    if (q30Var3.c <= 0) {
                                        t01Var.f();
                                    } else {
                                        t01Var.h();
                                    }
                                    break;
                                }
                            }
                        } else {
                            t01Var.f();
                            break;
                        }
                        break;
                    default:
                        t01Var.T0 = false;
                        t01Var.P0.d(false);
                        t01Var.e();
                        t01Var.f();
                        break;
                }
            }
        });
        k61Var.f(nd0.class, new l61(this) { // from class: o01
            public final /* synthetic */ t01 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i4;
                int i5;
                int i6 = i2;
                boolean z = true;
                t01 t01Var = this.f;
                switch (i6) {
                    case 0:
                        t01Var.d();
                        break;
                    case 1:
                        nd0 nd0Var = (nd0) p60Var;
                        PopupWindow popupWindow = t01Var.b;
                        CodeEditor codeEditor2 = t01Var.F0;
                        if (nd0Var.f || !t01Var.T0 || (i4 = nd0Var.c) == 1) {
                            t01Var.f();
                        } else {
                            q30 q30Var = nd0Var.d;
                            q30 q30Var2 = nd0Var.e;
                            if (i4 == 2) {
                                if (codeEditor2.B0.b.a()) {
                                    codeEditor2.getProps().getClass();
                                }
                                if (q30Var2.c == 0 || q30Var.b != q30Var2.b) {
                                    t01Var.f();
                                    z = false;
                                }
                                t01Var.k(popupWindow.isShowing());
                            } else if (i4 != 3 || codeEditor2.B0.b.a() || !popupWindow.isShowing()) {
                                z = false;
                            } else if (q30Var.b == q30Var2.b && q30Var.c == q30Var2.c - 1) {
                                t01Var.k(true);
                            } else {
                                t01Var.f();
                                z = false;
                            }
                            if (z) {
                                t01Var.h();
                            }
                        }
                        break;
                    case 2:
                        int i7 = ((oq3) p60Var).g;
                        if (i7 == 1) {
                            t01Var.k(false);
                        } else if (i7 == 2) {
                            float dpUnit = t01Var.F0.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                t01Var.f();
                            }
                        }
                        break;
                    case 3:
                        i11 i11Var = (i11) p60Var;
                        int i8 = i11Var.e;
                        KeyEvent keyEvent = i11Var.d;
                        if (i8 == 2 && !i11Var.g && (keyEvent.getMetaState() & 4096) == 0 && !i11Var.f && t01Var.b.isShowing()) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 19) {
                                ListView listView = (ListView) t01Var.O0.f;
                                int i9 = t01Var.M0 - 1;
                                if (i9 >= 0) {
                                    t01Var.M0 = i9;
                                    ((xk0) listView.getAdapter()).notifyDataSetChanged();
                                    int i10 = t01Var.M0;
                                    if (i10 != -1) {
                                        iv1 iv1Var2 = t01Var.O0;
                                        ((ListView) iv1Var2.f).post(new yk0(iv1Var2, i10, (int) TypedValue.applyDimension(1, 45.0f, t01Var.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
                                    }
                                }
                                i11Var.z();
                            } else if (keyCode == 20) {
                                t01Var.g();
                                i11Var.z();
                            } else if (keyCode == 61) {
                                if (t01Var.M0 == -1) {
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 66) {
                                if (t01Var.M0 == -1) {
                                    t01Var.F0.getProps().getClass();
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 92 || keyCode == 93) {
                                t01Var.f();
                            }
                            break;
                        }
                        break;
                    case 4:
                        fs3 fs3Var = (fs3) p60Var;
                        boolean z2 = fs3Var.z();
                        q30 q30Var3 = fs3Var.c;
                        if (!z2 && (i5 = fs3Var.e) != 4 && i5 != 2 && i5 != 3 && i5 != 6 && i5 != 0) {
                            q30 q30Var4 = t01Var.Q0;
                            if (q30Var4 == null) {
                                t01Var.Q0 = q30Var3.a();
                                break;
                            } else if (i5 == 7) {
                                if (q30Var4.b != q30Var3.b) {
                                    t01Var.f();
                                    break;
                                } else if (t01Var.b.isShowing() && Math.abs(t01Var.Q0.c - q30Var3.c) <= 1) {
                                    if (q30Var3.c <= 0) {
                                        t01Var.f();
                                    } else {
                                        t01Var.h();
                                    }
                                    break;
                                }
                            }
                        } else {
                            t01Var.f();
                            break;
                        }
                        break;
                    default:
                        t01Var.T0 = false;
                        t01Var.P0.d(false);
                        t01Var.e();
                        t01Var.f();
                        break;
                }
            }
        });
        final int i4 = 2;
        k61Var.f(oq3.class, new l61(this) { // from class: o01
            public final /* synthetic */ t01 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i42;
                int i5;
                int i6 = i4;
                boolean z = true;
                t01 t01Var = this.f;
                switch (i6) {
                    case 0:
                        t01Var.d();
                        break;
                    case 1:
                        nd0 nd0Var = (nd0) p60Var;
                        PopupWindow popupWindow = t01Var.b;
                        CodeEditor codeEditor2 = t01Var.F0;
                        if (nd0Var.f || !t01Var.T0 || (i42 = nd0Var.c) == 1) {
                            t01Var.f();
                        } else {
                            q30 q30Var = nd0Var.d;
                            q30 q30Var2 = nd0Var.e;
                            if (i42 == 2) {
                                if (codeEditor2.B0.b.a()) {
                                    codeEditor2.getProps().getClass();
                                }
                                if (q30Var2.c == 0 || q30Var.b != q30Var2.b) {
                                    t01Var.f();
                                    z = false;
                                }
                                t01Var.k(popupWindow.isShowing());
                            } else if (i42 != 3 || codeEditor2.B0.b.a() || !popupWindow.isShowing()) {
                                z = false;
                            } else if (q30Var.b == q30Var2.b && q30Var.c == q30Var2.c - 1) {
                                t01Var.k(true);
                            } else {
                                t01Var.f();
                                z = false;
                            }
                            if (z) {
                                t01Var.h();
                            }
                        }
                        break;
                    case 2:
                        int i7 = ((oq3) p60Var).g;
                        if (i7 == 1) {
                            t01Var.k(false);
                        } else if (i7 == 2) {
                            float dpUnit = t01Var.F0.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                t01Var.f();
                            }
                        }
                        break;
                    case 3:
                        i11 i11Var = (i11) p60Var;
                        int i8 = i11Var.e;
                        KeyEvent keyEvent = i11Var.d;
                        if (i8 == 2 && !i11Var.g && (keyEvent.getMetaState() & 4096) == 0 && !i11Var.f && t01Var.b.isShowing()) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 19) {
                                ListView listView = (ListView) t01Var.O0.f;
                                int i9 = t01Var.M0 - 1;
                                if (i9 >= 0) {
                                    t01Var.M0 = i9;
                                    ((xk0) listView.getAdapter()).notifyDataSetChanged();
                                    int i10 = t01Var.M0;
                                    if (i10 != -1) {
                                        iv1 iv1Var2 = t01Var.O0;
                                        ((ListView) iv1Var2.f).post(new yk0(iv1Var2, i10, (int) TypedValue.applyDimension(1, 45.0f, t01Var.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
                                    }
                                }
                                i11Var.z();
                            } else if (keyCode == 20) {
                                t01Var.g();
                                i11Var.z();
                            } else if (keyCode == 61) {
                                if (t01Var.M0 == -1) {
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 66) {
                                if (t01Var.M0 == -1) {
                                    t01Var.F0.getProps().getClass();
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 92 || keyCode == 93) {
                                t01Var.f();
                            }
                            break;
                        }
                        break;
                    case 4:
                        fs3 fs3Var = (fs3) p60Var;
                        boolean z2 = fs3Var.z();
                        q30 q30Var3 = fs3Var.c;
                        if (!z2 && (i5 = fs3Var.e) != 4 && i5 != 2 && i5 != 3 && i5 != 6 && i5 != 0) {
                            q30 q30Var4 = t01Var.Q0;
                            if (q30Var4 == null) {
                                t01Var.Q0 = q30Var3.a();
                                break;
                            } else if (i5 == 7) {
                                if (q30Var4.b != q30Var3.b) {
                                    t01Var.f();
                                    break;
                                } else if (t01Var.b.isShowing() && Math.abs(t01Var.Q0.c - q30Var3.c) <= 1) {
                                    if (q30Var3.c <= 0) {
                                        t01Var.f();
                                    } else {
                                        t01Var.h();
                                    }
                                    break;
                                }
                            }
                        } else {
                            t01Var.f();
                            break;
                        }
                        break;
                    default:
                        t01Var.T0 = false;
                        t01Var.P0.d(false);
                        t01Var.e();
                        t01Var.f();
                        break;
                }
            }
        });
        final int i5 = 3;
        k61Var.f(i11.class, new l61(this) { // from class: o01
            public final /* synthetic */ t01 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i42;
                int i52;
                int i6 = i5;
                boolean z = true;
                t01 t01Var = this.f;
                switch (i6) {
                    case 0:
                        t01Var.d();
                        break;
                    case 1:
                        nd0 nd0Var = (nd0) p60Var;
                        PopupWindow popupWindow = t01Var.b;
                        CodeEditor codeEditor2 = t01Var.F0;
                        if (nd0Var.f || !t01Var.T0 || (i42 = nd0Var.c) == 1) {
                            t01Var.f();
                        } else {
                            q30 q30Var = nd0Var.d;
                            q30 q30Var2 = nd0Var.e;
                            if (i42 == 2) {
                                if (codeEditor2.B0.b.a()) {
                                    codeEditor2.getProps().getClass();
                                }
                                if (q30Var2.c == 0 || q30Var.b != q30Var2.b) {
                                    t01Var.f();
                                    z = false;
                                }
                                t01Var.k(popupWindow.isShowing());
                            } else if (i42 != 3 || codeEditor2.B0.b.a() || !popupWindow.isShowing()) {
                                z = false;
                            } else if (q30Var.b == q30Var2.b && q30Var.c == q30Var2.c - 1) {
                                t01Var.k(true);
                            } else {
                                t01Var.f();
                                z = false;
                            }
                            if (z) {
                                t01Var.h();
                            }
                        }
                        break;
                    case 2:
                        int i7 = ((oq3) p60Var).g;
                        if (i7 == 1) {
                            t01Var.k(false);
                        } else if (i7 == 2) {
                            float dpUnit = t01Var.F0.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                t01Var.f();
                            }
                        }
                        break;
                    case 3:
                        i11 i11Var = (i11) p60Var;
                        int i8 = i11Var.e;
                        KeyEvent keyEvent = i11Var.d;
                        if (i8 == 2 && !i11Var.g && (keyEvent.getMetaState() & 4096) == 0 && !i11Var.f && t01Var.b.isShowing()) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 19) {
                                ListView listView = (ListView) t01Var.O0.f;
                                int i9 = t01Var.M0 - 1;
                                if (i9 >= 0) {
                                    t01Var.M0 = i9;
                                    ((xk0) listView.getAdapter()).notifyDataSetChanged();
                                    int i10 = t01Var.M0;
                                    if (i10 != -1) {
                                        iv1 iv1Var2 = t01Var.O0;
                                        ((ListView) iv1Var2.f).post(new yk0(iv1Var2, i10, (int) TypedValue.applyDimension(1, 45.0f, t01Var.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
                                    }
                                }
                                i11Var.z();
                            } else if (keyCode == 20) {
                                t01Var.g();
                                i11Var.z();
                            } else if (keyCode == 61) {
                                if (t01Var.M0 == -1) {
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 66) {
                                if (t01Var.M0 == -1) {
                                    t01Var.F0.getProps().getClass();
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 92 || keyCode == 93) {
                                t01Var.f();
                            }
                            break;
                        }
                        break;
                    case 4:
                        fs3 fs3Var = (fs3) p60Var;
                        boolean z2 = fs3Var.z();
                        q30 q30Var3 = fs3Var.c;
                        if (!z2 && (i52 = fs3Var.e) != 4 && i52 != 2 && i52 != 3 && i52 != 6 && i52 != 0) {
                            q30 q30Var4 = t01Var.Q0;
                            if (q30Var4 == null) {
                                t01Var.Q0 = q30Var3.a();
                                break;
                            } else if (i52 == 7) {
                                if (q30Var4.b != q30Var3.b) {
                                    t01Var.f();
                                    break;
                                } else if (t01Var.b.isShowing() && Math.abs(t01Var.Q0.c - q30Var3.c) <= 1) {
                                    if (q30Var3.c <= 0) {
                                        t01Var.f();
                                    } else {
                                        t01Var.h();
                                    }
                                    break;
                                }
                            }
                        } else {
                            t01Var.f();
                            break;
                        }
                        break;
                    default:
                        t01Var.T0 = false;
                        t01Var.P0.d(false);
                        t01Var.e();
                        t01Var.f();
                        break;
                }
            }
        });
        k61Var.f(fs3.class, new l61(this) { // from class: o01
            public final /* synthetic */ t01 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i42;
                int i52;
                int i6 = i;
                boolean z = true;
                t01 t01Var = this.f;
                switch (i6) {
                    case 0:
                        t01Var.d();
                        break;
                    case 1:
                        nd0 nd0Var = (nd0) p60Var;
                        PopupWindow popupWindow = t01Var.b;
                        CodeEditor codeEditor2 = t01Var.F0;
                        if (nd0Var.f || !t01Var.T0 || (i42 = nd0Var.c) == 1) {
                            t01Var.f();
                        } else {
                            q30 q30Var = nd0Var.d;
                            q30 q30Var2 = nd0Var.e;
                            if (i42 == 2) {
                                if (codeEditor2.B0.b.a()) {
                                    codeEditor2.getProps().getClass();
                                }
                                if (q30Var2.c == 0 || q30Var.b != q30Var2.b) {
                                    t01Var.f();
                                    z = false;
                                }
                                t01Var.k(popupWindow.isShowing());
                            } else if (i42 != 3 || codeEditor2.B0.b.a() || !popupWindow.isShowing()) {
                                z = false;
                            } else if (q30Var.b == q30Var2.b && q30Var.c == q30Var2.c - 1) {
                                t01Var.k(true);
                            } else {
                                t01Var.f();
                                z = false;
                            }
                            if (z) {
                                t01Var.h();
                            }
                        }
                        break;
                    case 2:
                        int i7 = ((oq3) p60Var).g;
                        if (i7 == 1) {
                            t01Var.k(false);
                        } else if (i7 == 2) {
                            float dpUnit = t01Var.F0.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                t01Var.f();
                            }
                        }
                        break;
                    case 3:
                        i11 i11Var = (i11) p60Var;
                        int i8 = i11Var.e;
                        KeyEvent keyEvent = i11Var.d;
                        if (i8 == 2 && !i11Var.g && (keyEvent.getMetaState() & 4096) == 0 && !i11Var.f && t01Var.b.isShowing()) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 19) {
                                ListView listView = (ListView) t01Var.O0.f;
                                int i9 = t01Var.M0 - 1;
                                if (i9 >= 0) {
                                    t01Var.M0 = i9;
                                    ((xk0) listView.getAdapter()).notifyDataSetChanged();
                                    int i10 = t01Var.M0;
                                    if (i10 != -1) {
                                        iv1 iv1Var2 = t01Var.O0;
                                        ((ListView) iv1Var2.f).post(new yk0(iv1Var2, i10, (int) TypedValue.applyDimension(1, 45.0f, t01Var.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
                                    }
                                }
                                i11Var.z();
                            } else if (keyCode == 20) {
                                t01Var.g();
                                i11Var.z();
                            } else if (keyCode == 61) {
                                if (t01Var.M0 == -1) {
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 66) {
                                if (t01Var.M0 == -1) {
                                    t01Var.F0.getProps().getClass();
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 92 || keyCode == 93) {
                                t01Var.f();
                            }
                            break;
                        }
                        break;
                    case 4:
                        fs3 fs3Var = (fs3) p60Var;
                        boolean z2 = fs3Var.z();
                        q30 q30Var3 = fs3Var.c;
                        if (!z2 && (i52 = fs3Var.e) != 4 && i52 != 2 && i52 != 3 && i52 != 6 && i52 != 0) {
                            q30 q30Var4 = t01Var.Q0;
                            if (q30Var4 == null) {
                                t01Var.Q0 = q30Var3.a();
                                break;
                            } else if (i52 == 7) {
                                if (q30Var4.b != q30Var3.b) {
                                    t01Var.f();
                                    break;
                                } else if (t01Var.b.isShowing() && Math.abs(t01Var.Q0.c - q30Var3.c) <= 1) {
                                    if (q30Var3.c <= 0) {
                                        t01Var.f();
                                    } else {
                                        t01Var.h();
                                    }
                                    break;
                                }
                            }
                        } else {
                            t01Var.f();
                            break;
                        }
                        break;
                    default:
                        t01Var.T0 = false;
                        t01Var.P0.d(false);
                        t01Var.e();
                        t01Var.f();
                        break;
                }
            }
        });
        final int i6 = 5;
        k61Var.f(m11.class, new l61(this) { // from class: o01
            public final /* synthetic */ t01 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i42;
                int i52;
                int i62 = i6;
                boolean z = true;
                t01 t01Var = this.f;
                switch (i62) {
                    case 0:
                        t01Var.d();
                        break;
                    case 1:
                        nd0 nd0Var = (nd0) p60Var;
                        PopupWindow popupWindow = t01Var.b;
                        CodeEditor codeEditor2 = t01Var.F0;
                        if (nd0Var.f || !t01Var.T0 || (i42 = nd0Var.c) == 1) {
                            t01Var.f();
                        } else {
                            q30 q30Var = nd0Var.d;
                            q30 q30Var2 = nd0Var.e;
                            if (i42 == 2) {
                                if (codeEditor2.B0.b.a()) {
                                    codeEditor2.getProps().getClass();
                                }
                                if (q30Var2.c == 0 || q30Var.b != q30Var2.b) {
                                    t01Var.f();
                                    z = false;
                                }
                                t01Var.k(popupWindow.isShowing());
                            } else if (i42 != 3 || codeEditor2.B0.b.a() || !popupWindow.isShowing()) {
                                z = false;
                            } else if (q30Var.b == q30Var2.b && q30Var.c == q30Var2.c - 1) {
                                t01Var.k(true);
                            } else {
                                t01Var.f();
                                z = false;
                            }
                            if (z) {
                                t01Var.h();
                            }
                        }
                        break;
                    case 2:
                        int i7 = ((oq3) p60Var).g;
                        if (i7 == 1) {
                            t01Var.k(false);
                        } else if (i7 == 2) {
                            float dpUnit = t01Var.F0.getDpUnit() * 2000.0f;
                            if (Math.abs(0.0f) >= dpUnit || Math.abs(0.0f) >= dpUnit) {
                                t01Var.f();
                            }
                        }
                        break;
                    case 3:
                        i11 i11Var = (i11) p60Var;
                        int i8 = i11Var.e;
                        KeyEvent keyEvent = i11Var.d;
                        if (i8 == 2 && !i11Var.g && (keyEvent.getMetaState() & 4096) == 0 && !i11Var.f && t01Var.b.isShowing()) {
                            int keyCode = keyEvent.getKeyCode();
                            if (keyCode == 19) {
                                ListView listView = (ListView) t01Var.O0.f;
                                int i9 = t01Var.M0 - 1;
                                if (i9 >= 0) {
                                    t01Var.M0 = i9;
                                    ((xk0) listView.getAdapter()).notifyDataSetChanged();
                                    int i10 = t01Var.M0;
                                    if (i10 != -1) {
                                        iv1 iv1Var2 = t01Var.O0;
                                        ((ListView) iv1Var2.f).post(new yk0(iv1Var2, i10, (int) TypedValue.applyDimension(1, 45.0f, t01Var.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
                                    }
                                }
                                i11Var.z();
                            } else if (keyCode == 20) {
                                t01Var.g();
                                i11Var.z();
                            } else if (keyCode == 61) {
                                if (t01Var.M0 == -1) {
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 66) {
                                if (t01Var.M0 == -1) {
                                    t01Var.F0.getProps().getClass();
                                    t01Var.g();
                                }
                                if (t01Var.i(t01Var.M0)) {
                                    i11Var.z();
                                }
                            } else if (keyCode == 92 || keyCode == 93) {
                                t01Var.f();
                            }
                            break;
                        }
                        break;
                    case 4:
                        fs3 fs3Var = (fs3) p60Var;
                        boolean z2 = fs3Var.z();
                        q30 q30Var3 = fs3Var.c;
                        if (!z2 && (i52 = fs3Var.e) != 4 && i52 != 2 && i52 != 3 && i52 != 6 && i52 != 0) {
                            q30 q30Var4 = t01Var.Q0;
                            if (q30Var4 == null) {
                                t01Var.Q0 = q30Var3.a();
                                break;
                            } else if (i52 == 7) {
                                if (q30Var4.b != q30Var3.b) {
                                    t01Var.f();
                                    break;
                                } else if (t01Var.b.isShowing() && Math.abs(t01Var.Q0.c - q30Var3.c) <= 1) {
                                    if (q30Var3.c <= 0) {
                                        t01Var.f();
                                    } else {
                                        t01Var.h();
                                    }
                                    break;
                                }
                            }
                        } else {
                            t01Var.f();
                            break;
                        }
                        break;
                    default:
                        t01Var.T0 = false;
                        t01Var.P0.d(false);
                        t01Var.e();
                        t01Var.f();
                        break;
                }
            }
        });
        j(c11.class, new ji(6));
        j(w50.class, null);
        j(j11.class, null);
        j(b11.class, new ji(i3));
        j(vy3.class, new ji(8));
    }

    public final void d() {
        u01 colorScheme = this.F0.getColorScheme();
        iv1 iv1Var = this.O0;
        iv1Var.getClass();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 8.0f, ((t01) iv1Var.X).F0.getContext().getResources().getDisplayMetrics()));
        gradientDrawable.setStroke((int) TypedValue.applyDimension(1, 1.0f, ((t01) iv1Var.X).F0.getContext().getResources().getDisplayMetrics()), colorScheme.e(20));
        gradientDrawable.setColor(colorScheme.e(19));
        ((LinearLayout) iv1Var.A).setBackground(gradientDrawable);
        LinearLayout linearLayout = (LinearLayout) iv1Var.A;
        linearLayout.setOutlineProvider(new zk0());
        linearLayout.setClipToOutline(true);
    }

    public final void e() {
        s01 s01Var = this.J0;
        if (s01Var != null && s01Var.isAlive()) {
            s01Var.Y = true;
            s01Var.f.getClass();
            s01Var.interrupt();
            s01Var.A.g = true;
            s01Var.X = -1L;
        }
        this.J0 = null;
    }

    public final void f() {
        b();
        e();
        this.S0 = System.currentTimeMillis();
    }

    public final void g() {
        iv1 iv1Var = this.O0;
        ListView listView = (ListView) iv1Var.f;
        if (this.M0 + 1 >= listView.getAdapter().getCount()) {
            return;
        }
        this.M0++;
        ((xk0) listView.getAdapter()).notifyDataSetChanged();
        int i = this.M0;
        if (i != -1) {
            ((ListView) iv1Var.f).post(new yk0(iv1Var, i, (int) TypedValue.applyDimension(1, 45.0f, this.N0.b.F0.getContext().getResources().getDisplayMetrics()), 0));
        }
    }

    public final void h() {
        if (this.G0 || !this.T0) {
            return;
        }
        CodeEditor codeEditor = this.F0;
        if (!codeEditor.getText().m().a()) {
            as2 as2VarX = uf2.x(codeEditor.getStyles(), codeEditor.getCursor().c.a(), 0);
            if (as2VarX != null && (as2VarX.b & 2199023255552L) == 0) {
                long jNanoTime = System.nanoTime() - this.H0;
                codeEditor.getProps().getClass();
                if (jNanoTime < 70000000) {
                    f();
                    this.H0 = System.nanoTime();
                    return;
                }
                e();
                this.H0 = System.nanoTime();
                this.M0 = -1;
                Handler handler = codeEditor.getHandler();
                r01 r01Var = new r01(this, 2);
                codeEditor.getEditorLanguage().getClass();
                this.K0 = new v80(handler, r01Var);
                this.J0 = new s01(this, this.H0, this.K0);
                this.U0 = true;
                codeEditor.a0(new r01(this, 1), 50L);
                this.J0.start();
                return;
            }
        }
        f();
    }

    /* JADX WARN: Finally extract failed */
    public final boolean i(int i) {
        if (i == -1) {
            return false;
        }
        ax3 ax3Var = (ax3) ((xk0) ((ListView) this.O0.f).getAdapter()).f.get(i);
        CodeEditor codeEditor = this.F0;
        lg0 cursor = codeEditor.getCursor();
        s01 s01Var = this.J0;
        if (!cursor.a() && s01Var != null) {
            this.G0 = true;
            codeEditor.i1++;
            codeEditor.getText().b();
            codeEditor.e0();
            try {
                ld0 text = codeEditor.getText();
                q30 q30Var = s01Var.b;
                ax3Var.getClass();
                int i2 = q30Var.b;
                int i3 = q30Var.c;
                String str = ax3Var.f;
                if (str != null) {
                    int i4 = ax3Var.d;
                    if (i4 == 0) {
                        text.r(i2, i3, str);
                    } else {
                        text.x(i2, i3 - i4, str, i2, i3);
                    }
                }
                codeEditor.p0();
                codeEditor.getText().k();
                int i5 = codeEditor.i1 - 1;
                codeEditor.i1 = i5;
                if (i5 < 0) {
                    codeEditor.i1 = 0;
                }
                this.G0 = false;
                codeEditor.e0();
            } catch (Throwable th) {
                codeEditor.getText().k();
                int i6 = codeEditor.i1 - 1;
                codeEditor.i1 = i6;
                if (i6 < 0) {
                    codeEditor.i1 = 0;
                }
                this.G0 = false;
                throw th;
            }
        }
        f();
        return true;
    }

    public final void j(Class cls, final am1 am1Var) {
        this.P0.f(cls, new l61() { // from class: p01
            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                am1 am1Var2 = am1Var;
                if (am1Var2 == null || ((Boolean) am1Var2.g(p60Var)).booleanValue()) {
                    this.b.f();
                }
            }
        });
    }

    public final void k(boolean z) {
        int iMin;
        CodeEditor codeEditor = this.F0;
        float dpUnit = codeEditor.getDpUnit();
        lg0 cursor = codeEditor.getCursor();
        float fQ0 = (20.0f * dpUnit) + codeEditor.q0();
        int rowHeight = codeEditor.getRowHeight();
        w82 layout = codeEditor.getLayout();
        q30 q30Var = cursor.d;
        float f = rowHeight;
        float offsetY = (f / 2.0f) + (((v0) layout).b(q30Var.b, q30Var.c)[0] - codeEditor.getOffsetY());
        float height = codeEditor.getHeight() - offsetY;
        float f2 = 200.0f * dpUnit;
        if (height > f2) {
            height = f2;
        } else {
            float f3 = 100.0f * dpUnit;
            if (height < f3 && z) {
                float f4 = 0.0f;
                while (height < f3 && codeEditor.getOffsetY() + f4 + f <= codeEditor.getScrollMaxY()) {
                    height += f;
                    offsetY -= f;
                    f4 += f;
                }
                codeEditor.getScroller().b(codeEditor.getOffsetX(), codeEditor.getOffsetY(), 0, (int) f4, 0);
            }
        }
        if (codeEditor.getWidth() < 500.0f * dpUnit) {
            iMin = (codeEditor.getWidth() * 7) / 8;
            fQ0 = (codeEditor.getWidth() / 8.0f) / 2.0f;
        } else {
            iMin = (int) Math.min(dpUnit * 300.0f, codeEditor.getWidth() / 2.0f);
        }
        int i = this.E0;
        this.I0 = (int) height;
        int offsetX = codeEditor.getOffsetX() + ((int) fQ0);
        int offsetY2 = codeEditor.getOffsetY();
        this.B0 = offsetX;
        this.C0 = offsetY2 + ((int) offsetY);
        CodeEditor codeEditor2 = this.f;
        this.A0 = codeEditor2.getOffsetY();
        this.z0 = codeEditor2.getOffsetX();
        a(false);
        this.D0 = iMin;
        this.E0 = i;
        a(false);
    }
}
