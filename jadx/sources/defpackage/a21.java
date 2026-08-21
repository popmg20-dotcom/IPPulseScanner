package defpackage;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.getsurfboard.R;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a21 extends l11 implements View.OnClickListener {
    public final CodeEditor F0;
    public final ImageButton G0;
    public final ImageButton H0;
    public final ImageButton I0;
    public final ImageButton J0;
    public final ImageButton K0;
    public final View L0;
    public final d21 M0;
    public final k61 N0;
    public long O0;
    public int P0;
    public int Q0;
    public boolean R0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a21(CodeEditor codeEditor) {
        super(codeEditor, 2);
        final int i = 2;
        final int i2 = 1;
        this.R0 = true;
        this.F0 = codeEditor;
        this.M0 = codeEditor.getEventHandler();
        k61 k61Var = new k61(codeEditor.C0);
        this.N0 = k61Var;
        View viewInflate = LayoutInflater.from(codeEditor.getContext()).inflate(R.layout.text_compose_panel, (ViewGroup) null);
        this.L0 = viewInflate;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.panel_btn_select_all);
        this.G0 = imageButton;
        ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_cut);
        this.J0 = imageButton2;
        ImageButton imageButton3 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_copy);
        this.I0 = imageButton3;
        ImageButton imageButton4 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_long_select);
        this.K0 = imageButton4;
        ImageButton imageButton5 = (ImageButton) viewInflate.findViewById(R.id.panel_btn_paste);
        this.H0 = imageButton5;
        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        e();
        this.b.setContentView(viewInflate);
        int dpUnit = (int) (codeEditor.getDpUnit() * 48.0f);
        final int i3 = 0;
        this.D0 = 0;
        this.E0 = dpUnit;
        a(false);
        this.b.setAnimationStyle(R.style.text_action_popup_animation);
        k61Var.e(fs3.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i4 = i3;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i4) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i5 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i5 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i5;
                                    if (fs3Var.z() || (i5 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i5 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i5 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i5 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i6 = af2Var.c.a;
                            if (i6 >= codeEditor3.getCursor().c.a && i6 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        k61Var.e(oq3.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i4 = i2;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i4) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i5 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i5 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i5;
                                    if (fs3Var.z() || (i5 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i5 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i5 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i5 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i6 = af2Var.c.a;
                            if (i6 >= codeEditor3.getCursor().c.a && i6 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        k61Var.e(qq1.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i4 = i;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i4) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i5 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i5 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i5;
                                    if (fs3Var.z() || (i5 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i5 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i5 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i5 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i6 = af2Var.c.a;
                            if (i6 >= codeEditor3.getCursor().c.a && i6 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        final int i4 = 3;
        k61Var.e(af2.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i42 = i4;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i42) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i5 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i5 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i5;
                                    if (fs3Var.z() || (i5 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i5 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i5 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i5 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i6 = af2Var.c.a;
                            if (i6 >= codeEditor3.getCursor().c.a && i6 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        final int i5 = 4;
        k61Var.e(b11.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i42 = i5;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i42) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i52 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i52 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i52;
                                    if (fs3Var.z() || (i52 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i52 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i52 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i52 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i6 = af2Var.c.a;
                            if (i6 >= codeEditor3.getCursor().c.a && i6 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        final int i6 = 5;
        k61Var.e(m11.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i42 = i6;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i42) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i52 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i52 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i52;
                                    if (fs3Var.z() || (i52 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i52 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i52 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i52 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i62 = af2Var.c.a;
                            if (i62 >= codeEditor3.getCursor().c.a && i62 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        final int i7 = 6;
        k61Var.e(s70.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i42 = i7;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i42) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i52 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i52 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i52;
                                    if (fs3Var.z() || (i52 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i52 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i52 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i52 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i62 = af2Var.c.a;
                            if (i62 >= codeEditor3.getCursor().c.a && i62 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
        final int i8 = 7;
        k61Var.e(nx0.class, new i61(this) { // from class: y11
            public final /* synthetic */ a21 f;

            {
                this.f = this;
            }

            @Override // defpackage.i61
            public final void j(p60 p60Var) {
                int i42 = i8;
                boolean z = false;
                a21 a21Var = this.f;
                switch (i42) {
                    case 0:
                        fs3 fs3Var = (fs3) p60Var;
                        CodeEditor codeEditor2 = a21Var.F0;
                        d21 d21Var = a21Var.M0;
                        if (!d21Var.f()) {
                            int i52 = fs3Var.e;
                            q30 q30Var = fs3Var.c;
                            if (i52 != 9) {
                                if (!d21Var.J) {
                                    a21Var.Q0 = i52;
                                    if (fs3Var.z() || (i52 == 5 && codeEditor2.getText().A == 0)) {
                                        if (i52 != 6) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                        } else {
                                            a21Var.b();
                                        }
                                        a21Var.P0 = -1;
                                    } else {
                                        if (i52 == 3 && q30Var.a == a21Var.P0 && !a21Var.b.isShowing() && codeEditor2.getText().X <= 0 && codeEditor2.H()) {
                                            codeEditor2.b0(new d4(29, a21Var));
                                            z = true;
                                        } else {
                                            a21Var.b();
                                        }
                                        if (i52 == 3 && !z) {
                                            a21Var.P0 = q30Var.a;
                                        } else {
                                            a21Var.P0 = -1;
                                        }
                                    }
                                } else {
                                    a21Var.b();
                                }
                                break;
                            }
                        }
                        break;
                    case 1:
                        long j = a21Var.O0;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        a21Var.O0 = jCurrentTimeMillis;
                        if (jCurrentTimeMillis - j < 200 && a21Var.Q0 != 6) {
                            a21Var.g();
                            break;
                        }
                        break;
                    case 2:
                        qq1 qq1Var = (qq1) p60Var;
                        if (qq1Var.d) {
                            a21Var.g();
                        }
                        if (!((CodeEditor) qq1Var.b).getCursor().a() && qq1Var.c == 0 && !qq1Var.d) {
                            a21Var.f();
                            a21Var.F0.a0(new z11(a21Var, 0), 100L);
                            break;
                        }
                        break;
                    case 3:
                        af2 af2Var = (af2) p60Var;
                        CodeEditor codeEditor3 = a21Var.F0;
                        if (codeEditor3.getCursor().a() && a21Var.Q0 == 6) {
                            int i62 = af2Var.c.a;
                            if (i62 >= codeEditor3.getCursor().c.a && i62 <= codeEditor3.getCursor().d.a) {
                                a21Var.Q0 = 0;
                                a21Var.f();
                            }
                            af2Var.a = 2;
                            break;
                        }
                        break;
                    case 4:
                        if (!((b11) p60Var).c) {
                            a21Var.b();
                        }
                        break;
                    case 5:
                        a21Var.R0 = false;
                        a21Var.N0.d(false);
                        a21Var.b();
                        break;
                    case 6:
                        a21Var.e();
                        break;
                    default:
                        a21Var.f();
                        break;
                }
            }
        });
    }

    public static void d(ImageButton imageButton, int i) {
        if (imageButton.getDrawable() == null) {
            return;
        }
        imageButton.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP));
    }

    public final void e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        CodeEditor codeEditor = this.F0;
        gradientDrawable.setCornerRadius(codeEditor.getDpUnit() * 5.0f);
        gradientDrawable.setColor(codeEditor.getColorScheme().e(65));
        this.L0.setBackground(gradientDrawable);
        int iE = codeEditor.getColorScheme().e(66);
        d(this.G0, iE);
        d(this.J0, iE);
        d(this.I0, iE);
        d(this.H0, iE);
        d(this.K0, iE);
    }

    public final void f() {
        CodeEditor codeEditor = this.F0;
        boolean zHasPrimaryClip = codeEditor.G1.hasPrimaryClip();
        ImageButton imageButton = this.H0;
        imageButton.setEnabled(zHasPrimaryClip);
        int i = 8;
        this.I0.setVisibility(codeEditor.getCursor().a() ? 0 : 8);
        imageButton.setVisibility(codeEditor.H() ? 0 : 8);
        this.J0.setVisibility((codeEditor.getCursor().a() && codeEditor.H()) ? 0 : 8);
        if (!codeEditor.getCursor().a() && codeEditor.H()) {
            i = 0;
        }
        this.K0.setVisibility(i);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(1000000, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(100000, Integer.MIN_VALUE);
        View view = this.L0;
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int iMin = Math.min(view.getMeasuredWidth(), (int) (codeEditor.getDpUnit() * 230.0f));
        int i2 = this.E0;
        this.D0 = iMin;
        this.E0 = i2;
        a(false);
        int iMax = Math.max(0, Math.min(codeEditor.getCursor().a() ? Math.min(h(codeEditor.getLeftHandleDescriptor().a), h(codeEditor.getRightHandleDescriptor().a)) : h(codeEditor.getInsertHandleDescriptor().a), (codeEditor.getHeight() - this.E0) - 5));
        int iT = (int) (((((codeEditor.T() + codeEditor.D0.b(codeEditor.getCursor().d.b, codeEditor.getCursor().d.c)[1]) - codeEditor.getOffsetX()) + ((codeEditor.T() + codeEditor.D0.b(codeEditor.getCursor().c.b, codeEditor.getCursor().c.c)[1]) - codeEditor.getOffsetX())) / 2.0f) - (view.getMeasuredWidth() / 2.0f));
        CodeEditor codeEditor2 = this.f;
        int offsetX = codeEditor2.getOffsetX() + iT;
        int offsetY = codeEditor2.getOffsetY() + iMax;
        this.B0 = offsetX;
        this.C0 = offsetY;
        this.A0 = codeEditor2.getOffsetY();
        this.z0 = codeEditor2.getOffsetX();
        a(false);
        if (this.R0) {
            codeEditor.getSnippetController().getClass();
            if (!codeEditor.hasFocus() || codeEditor.O() || this.b.isShowing()) {
                return;
            }
            a(true);
        }
    }

    public final void g() {
        if (this.b.isShowing()) {
            b();
            CodeEditor codeEditor = this.F0;
            if (codeEditor.getCursor().a()) {
                codeEditor.a0(new z11(this, 1), 200L);
            }
        }
    }

    public final int h(RectF rectF) {
        int rowHeight = this.F0.getRowHeight();
        float f = rectF.top;
        float f2 = f - ((rowHeight * 3) / 2.0f);
        float f3 = this.E0;
        return f2 > f3 ? (int) ((f - (r2 / 2)) - f3) : (int) (rectF.bottom + (rowHeight / 2));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        CodeEditor codeEditor = this.F0;
        if (id == R.id.panel_btn_select_all) {
            codeEditor.f0();
            return;
        }
        if (id == R.id.panel_btn_cut) {
            if (codeEditor.getCursor().a()) {
                codeEditor.i();
            }
        } else if (id == R.id.panel_btn_paste) {
            codeEditor.Y();
            codeEditor.i0(codeEditor.getCursor().d.b, codeEditor.getCursor().d.c);
        } else if (id == R.id.panel_btn_copy) {
            codeEditor.f(true);
            codeEditor.i0(codeEditor.getCursor().d.b, codeEditor.getCursor().d.c);
        } else if (id == R.id.panel_btn_long_select && codeEditor.H()) {
            if (codeEditor.I1.a()) {
                q30 q30Var = codeEditor.I1.c;
                codeEditor.i0(q30Var.b, q30Var.c);
            }
            codeEditor.y1 = true;
            codeEditor.invalidate();
        }
        b();
    }
}
