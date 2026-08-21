package defpackage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.getsurfboard.R;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a11 extends l11 {
    public final k61 F0;
    public final View G0;
    public final ul H0;
    public final int I0;
    public q30 J0;
    public e03 K0;

    public a11(CodeEditor codeEditor) {
        super(codeEditor, 6);
        k61 k61Var = new k61(codeEditor.C0);
        this.F0 = k61Var;
        this.H0 = new ul();
        this.I0 = (int) (codeEditor.getDpUnit() * 175.0f);
        new ArrayList();
        Float fValueOf = Float.valueOf(0.0f);
        this.K0 = new e03(fValueOf, fValueOf);
        final ul ulVar = this.H0;
        ulVar.getClass();
        final int i = 1;
        if (this.G0 == null || this.H0 != ulVar) {
            this.H0 = ulVar;
            ulVar.b = this;
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f.getContext());
            layoutInflaterFrom.getClass();
            a11 a11Var = (a11) ulVar.b;
            if (a11Var == null) {
                n12.T("window");
                throw null;
            }
            Context context = a11Var.f.getContext();
            View viewInflate = layoutInflaterFrom.inflate(R.layout.diagnostic_tooltip_window, (ViewGroup) null);
            viewInflate.getClass();
            ulVar.c = viewInflate;
            viewInflate.setClipToOutline(true);
            View view = (View) ulVar.c;
            if (view == null) {
                n12.T("root");
                throw null;
            }
            view.setOnGenericMotionListener(new View.OnGenericMotionListener() { // from class: fl0
                @Override // android.view.View.OnGenericMotionListener
                public final boolean onGenericMotion(View view2, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    ul ulVar2 = ulVar;
                    if (actionMasked == 9) {
                        ulVar2.a = true;
                    } else if (actionMasked == 10) {
                        ulVar2.a = false;
                    }
                    return false;
                }
            });
            View view2 = (View) ulVar.c;
            if (view2 == null) {
                n12.T("root");
                throw null;
            }
            View viewFindViewById = view2.findViewById(R.id.diagnostic_tooltip_brief_message);
            viewFindViewById.getClass();
            ulVar.d = (TextView) viewFindViewById;
            View view3 = (View) ulVar.c;
            if (view3 == null) {
                n12.T("root");
                throw null;
            }
            View viewFindViewById2 = view3.findViewById(R.id.diagnostic_tooltip_detailed_message);
            viewFindViewById2.getClass();
            ulVar.e = (TextView) viewFindViewById2;
            View view4 = (View) ulVar.c;
            if (view4 == null) {
                n12.T("root");
                throw null;
            }
            View viewFindViewById3 = view4.findViewById(R.id.diagnostic_tooltip_preferred_action);
            viewFindViewById3.getClass();
            ulVar.f = (TextView) viewFindViewById3;
            View view5 = (View) ulVar.c;
            if (view5 == null) {
                n12.T("root");
                throw null;
            }
            View viewFindViewById4 = view5.findViewById(R.id.diagnostic_tooltip_more_actions);
            viewFindViewById4.getClass();
            ulVar.g = (TextView) viewFindViewById4;
            View view6 = (View) ulVar.c;
            if (view6 == null) {
                n12.T("root");
                throw null;
            }
            View viewFindViewById5 = view6.findViewById(R.id.diagnostic_container_message);
            viewFindViewById5.getClass();
            ulVar.h = (ViewGroup) viewFindViewById5;
            View view7 = (View) ulVar.c;
            if (view7 == null) {
                n12.T("root");
                throw null;
            }
            View viewFindViewById6 = view7.findViewById(R.id.diagnostic_container_quickfix);
            viewFindViewById6.getClass();
            ulVar.i = (ViewGroup) viewFindViewById6;
            TextView textView = (TextView) ulVar.f;
            if (textView == null) {
                n12.T("quickfixText");
                throw null;
            }
            textView.setOnClickListener(new gl0(ulVar));
            TextView textView2 = (TextView) ulVar.g;
            if (textView2 == null) {
                n12.T("moreActionText");
                throw null;
            }
            SparseIntArray sparseIntArray = kv1.a;
            int i2 = R.string.sora_editor_diagnostics_more_actions;
            int i3 = sparseIntArray.get(R.string.sora_editor_diagnostics_more_actions);
            textView2.setText(i3 != 0 ? i3 : i2);
            TextView textView3 = (TextView) ulVar.g;
            if (textView3 == null) {
                n12.T("moreActionText");
                throw null;
            }
            textView3.setOnClickListener(new gl0(ulVar, context));
            View view8 = (View) ulVar.c;
            if (view8 == null) {
                n12.T("root");
                throw null;
            }
            this.G0 = view8;
            this.b.setContentView(view8);
            d();
        }
        this.b.setAnimationStyle(R.style.diagnostic_popup_animation);
        final int i4 = 0;
        k61Var.f(fs3.class, new l61(this) { // from class: z01
            public final /* synthetic */ a11 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i5;
                int measuredHeight;
                int measuredWidth;
                int i6 = i4;
                a11 a11Var2 = this.f;
                switch (i6) {
                    case 0:
                        CodeEditor codeEditor2 = a11Var2.f;
                        fs3 fs3Var = (fs3) p60Var;
                        fs3Var.getClass();
                        if (!a11Var2.F0.f || codeEditor2.O()) {
                            return;
                        }
                        if (fs3Var.z() || !((i5 = fs3Var.e) == 3 || i5 == 1)) {
                            a11Var2.g();
                            return;
                        } else {
                            codeEditor2.getDiagnostics();
                            a11Var2.g();
                            return;
                        }
                    case 1:
                        ((oq3) p60Var).getClass();
                        a11Var2.f.O();
                        return;
                    case 2:
                        ((s70) p60Var).getClass();
                        a11Var2.d();
                        return;
                    case 3:
                        ((wc4) p60Var).getClass();
                        a11Var2.H0.getClass();
                        if (a11Var2.b.isShowing()) {
                            int width = (int) (((double) a11Var2.f.getWidth()) * 0.9d);
                            ul ulVar2 = a11Var2.H0;
                            int i7 = a11Var2.I0;
                            ulVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) ulVar2.i;
                            if (viewGroup == null) {
                                n12.T("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) ulVar2.i;
                                if (viewGroup2 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) ulVar2.i;
                                if (viewGroup3 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) ulVar2.i;
                                if (viewGroup4 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i8 = i7 - measuredHeight;
                            int i9 = i8 >= 1 ? i8 : 1;
                            ViewGroup viewGroup5 = (ViewGroup) ulVar2.h;
                            if (viewGroup5 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) ulVar2.h;
                            if (viewGroup6 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) ulVar2.h;
                            if (viewGroup7 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) ulVar2.h;
                            if (viewGroup8 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i9) {
                                i9 = measuredHeight2;
                            }
                            layoutParams.height = i9;
                            ViewGroup viewGroup9 = (ViewGroup) ulVar2.h;
                            if (viewGroup9 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) ulVar2.h;
                            if (viewGroup10 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            a11Var2.D0 = Math.max(measuredWidth, width);
                            a11Var2.E0 = measuredHeight + i9;
                            a11Var2.a(false);
                            return;
                        }
                        return;
                    case 4:
                        b11 b11Var = (b11) p60Var;
                        b11Var.getClass();
                        if (b11Var.c) {
                            return;
                        }
                        a11Var2.b();
                        return;
                    default:
                        ((m11) p60Var).getClass();
                        a11Var2.F0.d(false);
                        a11Var2.b();
                        return;
                }
            }
        });
        k61Var.f(oq3.class, new l61(this) { // from class: z01
            public final /* synthetic */ a11 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i5;
                int measuredHeight;
                int measuredWidth;
                int i6 = i;
                a11 a11Var2 = this.f;
                switch (i6) {
                    case 0:
                        CodeEditor codeEditor2 = a11Var2.f;
                        fs3 fs3Var = (fs3) p60Var;
                        fs3Var.getClass();
                        if (!a11Var2.F0.f || codeEditor2.O()) {
                            return;
                        }
                        if (fs3Var.z() || !((i5 = fs3Var.e) == 3 || i5 == 1)) {
                            a11Var2.g();
                            return;
                        } else {
                            codeEditor2.getDiagnostics();
                            a11Var2.g();
                            return;
                        }
                    case 1:
                        ((oq3) p60Var).getClass();
                        a11Var2.f.O();
                        return;
                    case 2:
                        ((s70) p60Var).getClass();
                        a11Var2.d();
                        return;
                    case 3:
                        ((wc4) p60Var).getClass();
                        a11Var2.H0.getClass();
                        if (a11Var2.b.isShowing()) {
                            int width = (int) (((double) a11Var2.f.getWidth()) * 0.9d);
                            ul ulVar2 = a11Var2.H0;
                            int i7 = a11Var2.I0;
                            ulVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) ulVar2.i;
                            if (viewGroup == null) {
                                n12.T("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) ulVar2.i;
                                if (viewGroup2 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) ulVar2.i;
                                if (viewGroup3 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) ulVar2.i;
                                if (viewGroup4 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i8 = i7 - measuredHeight;
                            int i9 = i8 >= 1 ? i8 : 1;
                            ViewGroup viewGroup5 = (ViewGroup) ulVar2.h;
                            if (viewGroup5 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) ulVar2.h;
                            if (viewGroup6 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) ulVar2.h;
                            if (viewGroup7 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) ulVar2.h;
                            if (viewGroup8 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i9) {
                                i9 = measuredHeight2;
                            }
                            layoutParams.height = i9;
                            ViewGroup viewGroup9 = (ViewGroup) ulVar2.h;
                            if (viewGroup9 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) ulVar2.h;
                            if (viewGroup10 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            a11Var2.D0 = Math.max(measuredWidth, width);
                            a11Var2.E0 = measuredHeight + i9;
                            a11Var2.a(false);
                            return;
                        }
                        return;
                    case 4:
                        b11 b11Var = (b11) p60Var;
                        b11Var.getClass();
                        if (b11Var.c) {
                            return;
                        }
                        a11Var2.b();
                        return;
                    default:
                        ((m11) p60Var).getClass();
                        a11Var2.F0.d(false);
                        a11Var2.b();
                        return;
                }
            }
        });
        k61Var.e(kt1.class, new ed(7, this, new d4(26, this)));
        final int i5 = 2;
        k61Var.f(s70.class, new l61(this) { // from class: z01
            public final /* synthetic */ a11 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i52;
                int measuredHeight;
                int measuredWidth;
                int i6 = i5;
                a11 a11Var2 = this.f;
                switch (i6) {
                    case 0:
                        CodeEditor codeEditor2 = a11Var2.f;
                        fs3 fs3Var = (fs3) p60Var;
                        fs3Var.getClass();
                        if (!a11Var2.F0.f || codeEditor2.O()) {
                            return;
                        }
                        if (fs3Var.z() || !((i52 = fs3Var.e) == 3 || i52 == 1)) {
                            a11Var2.g();
                            return;
                        } else {
                            codeEditor2.getDiagnostics();
                            a11Var2.g();
                            return;
                        }
                    case 1:
                        ((oq3) p60Var).getClass();
                        a11Var2.f.O();
                        return;
                    case 2:
                        ((s70) p60Var).getClass();
                        a11Var2.d();
                        return;
                    case 3:
                        ((wc4) p60Var).getClass();
                        a11Var2.H0.getClass();
                        if (a11Var2.b.isShowing()) {
                            int width = (int) (((double) a11Var2.f.getWidth()) * 0.9d);
                            ul ulVar2 = a11Var2.H0;
                            int i7 = a11Var2.I0;
                            ulVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) ulVar2.i;
                            if (viewGroup == null) {
                                n12.T("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) ulVar2.i;
                                if (viewGroup2 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) ulVar2.i;
                                if (viewGroup3 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) ulVar2.i;
                                if (viewGroup4 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i8 = i7 - measuredHeight;
                            int i9 = i8 >= 1 ? i8 : 1;
                            ViewGroup viewGroup5 = (ViewGroup) ulVar2.h;
                            if (viewGroup5 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) ulVar2.h;
                            if (viewGroup6 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) ulVar2.h;
                            if (viewGroup7 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) ulVar2.h;
                            if (viewGroup8 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i9) {
                                i9 = measuredHeight2;
                            }
                            layoutParams.height = i9;
                            ViewGroup viewGroup9 = (ViewGroup) ulVar2.h;
                            if (viewGroup9 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) ulVar2.h;
                            if (viewGroup10 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            a11Var2.D0 = Math.max(measuredWidth, width);
                            a11Var2.E0 = measuredHeight + i9;
                            a11Var2.a(false);
                            return;
                        }
                        return;
                    case 4:
                        b11 b11Var = (b11) p60Var;
                        b11Var.getClass();
                        if (b11Var.c) {
                            return;
                        }
                        a11Var2.b();
                        return;
                    default:
                        ((m11) p60Var).getClass();
                        a11Var2.F0.d(false);
                        a11Var2.b();
                        return;
                }
            }
        });
        final int i6 = 3;
        k61Var.f(wc4.class, new l61(this) { // from class: z01
            public final /* synthetic */ a11 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i52;
                int measuredHeight;
                int measuredWidth;
                int i62 = i6;
                a11 a11Var2 = this.f;
                switch (i62) {
                    case 0:
                        CodeEditor codeEditor2 = a11Var2.f;
                        fs3 fs3Var = (fs3) p60Var;
                        fs3Var.getClass();
                        if (!a11Var2.F0.f || codeEditor2.O()) {
                            return;
                        }
                        if (fs3Var.z() || !((i52 = fs3Var.e) == 3 || i52 == 1)) {
                            a11Var2.g();
                            return;
                        } else {
                            codeEditor2.getDiagnostics();
                            a11Var2.g();
                            return;
                        }
                    case 1:
                        ((oq3) p60Var).getClass();
                        a11Var2.f.O();
                        return;
                    case 2:
                        ((s70) p60Var).getClass();
                        a11Var2.d();
                        return;
                    case 3:
                        ((wc4) p60Var).getClass();
                        a11Var2.H0.getClass();
                        if (a11Var2.b.isShowing()) {
                            int width = (int) (((double) a11Var2.f.getWidth()) * 0.9d);
                            ul ulVar2 = a11Var2.H0;
                            int i7 = a11Var2.I0;
                            ulVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) ulVar2.i;
                            if (viewGroup == null) {
                                n12.T("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) ulVar2.i;
                                if (viewGroup2 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) ulVar2.i;
                                if (viewGroup3 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) ulVar2.i;
                                if (viewGroup4 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i8 = i7 - measuredHeight;
                            int i9 = i8 >= 1 ? i8 : 1;
                            ViewGroup viewGroup5 = (ViewGroup) ulVar2.h;
                            if (viewGroup5 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) ulVar2.h;
                            if (viewGroup6 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) ulVar2.h;
                            if (viewGroup7 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) ulVar2.h;
                            if (viewGroup8 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i9) {
                                i9 = measuredHeight2;
                            }
                            layoutParams.height = i9;
                            ViewGroup viewGroup9 = (ViewGroup) ulVar2.h;
                            if (viewGroup9 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) ulVar2.h;
                            if (viewGroup10 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            a11Var2.D0 = Math.max(measuredWidth, width);
                            a11Var2.E0 = measuredHeight + i9;
                            a11Var2.a(false);
                            return;
                        }
                        return;
                    case 4:
                        b11 b11Var = (b11) p60Var;
                        b11Var.getClass();
                        if (b11Var.c) {
                            return;
                        }
                        a11Var2.b();
                        return;
                    default:
                        ((m11) p60Var).getClass();
                        a11Var2.F0.d(false);
                        a11Var2.b();
                        return;
                }
            }
        });
        final int i7 = 4;
        k61Var.f(b11.class, new l61(this) { // from class: z01
            public final /* synthetic */ a11 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i52;
                int measuredHeight;
                int measuredWidth;
                int i62 = i7;
                a11 a11Var2 = this.f;
                switch (i62) {
                    case 0:
                        CodeEditor codeEditor2 = a11Var2.f;
                        fs3 fs3Var = (fs3) p60Var;
                        fs3Var.getClass();
                        if (!a11Var2.F0.f || codeEditor2.O()) {
                            return;
                        }
                        if (fs3Var.z() || !((i52 = fs3Var.e) == 3 || i52 == 1)) {
                            a11Var2.g();
                            return;
                        } else {
                            codeEditor2.getDiagnostics();
                            a11Var2.g();
                            return;
                        }
                    case 1:
                        ((oq3) p60Var).getClass();
                        a11Var2.f.O();
                        return;
                    case 2:
                        ((s70) p60Var).getClass();
                        a11Var2.d();
                        return;
                    case 3:
                        ((wc4) p60Var).getClass();
                        a11Var2.H0.getClass();
                        if (a11Var2.b.isShowing()) {
                            int width = (int) (((double) a11Var2.f.getWidth()) * 0.9d);
                            ul ulVar2 = a11Var2.H0;
                            int i72 = a11Var2.I0;
                            ulVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) ulVar2.i;
                            if (viewGroup == null) {
                                n12.T("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) ulVar2.i;
                                if (viewGroup2 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i72, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) ulVar2.i;
                                if (viewGroup3 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) ulVar2.i;
                                if (viewGroup4 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i8 = i72 - measuredHeight;
                            int i9 = i8 >= 1 ? i8 : 1;
                            ViewGroup viewGroup5 = (ViewGroup) ulVar2.h;
                            if (viewGroup5 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) ulVar2.h;
                            if (viewGroup6 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) ulVar2.h;
                            if (viewGroup7 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) ulVar2.h;
                            if (viewGroup8 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i9) {
                                i9 = measuredHeight2;
                            }
                            layoutParams.height = i9;
                            ViewGroup viewGroup9 = (ViewGroup) ulVar2.h;
                            if (viewGroup9 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) ulVar2.h;
                            if (viewGroup10 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            a11Var2.D0 = Math.max(measuredWidth, width);
                            a11Var2.E0 = measuredHeight + i9;
                            a11Var2.a(false);
                            return;
                        }
                        return;
                    case 4:
                        b11 b11Var = (b11) p60Var;
                        b11Var.getClass();
                        if (b11Var.c) {
                            return;
                        }
                        a11Var2.b();
                        return;
                    default:
                        ((m11) p60Var).getClass();
                        a11Var2.F0.d(false);
                        a11Var2.b();
                        return;
                }
            }
        });
        final int i8 = 5;
        k61Var.f(m11.class, new l61(this) { // from class: z01
            public final /* synthetic */ a11 f;

            {
                this.f = this;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                int i52;
                int measuredHeight;
                int measuredWidth;
                int i62 = i8;
                a11 a11Var2 = this.f;
                switch (i62) {
                    case 0:
                        CodeEditor codeEditor2 = a11Var2.f;
                        fs3 fs3Var = (fs3) p60Var;
                        fs3Var.getClass();
                        if (!a11Var2.F0.f || codeEditor2.O()) {
                            return;
                        }
                        if (fs3Var.z() || !((i52 = fs3Var.e) == 3 || i52 == 1)) {
                            a11Var2.g();
                            return;
                        } else {
                            codeEditor2.getDiagnostics();
                            a11Var2.g();
                            return;
                        }
                    case 1:
                        ((oq3) p60Var).getClass();
                        a11Var2.f.O();
                        return;
                    case 2:
                        ((s70) p60Var).getClass();
                        a11Var2.d();
                        return;
                    case 3:
                        ((wc4) p60Var).getClass();
                        a11Var2.H0.getClass();
                        if (a11Var2.b.isShowing()) {
                            int width = (int) (((double) a11Var2.f.getWidth()) * 0.9d);
                            ul ulVar2 = a11Var2.H0;
                            int i72 = a11Var2.I0;
                            ulVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) ulVar2.i;
                            if (viewGroup == null) {
                                n12.T("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) ulVar2.i;
                                if (viewGroup2 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i72, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) ulVar2.i;
                                if (viewGroup3 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) ulVar2.i;
                                if (viewGroup4 == null) {
                                    n12.T("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i82 = i72 - measuredHeight;
                            int i9 = i82 >= 1 ? i82 : 1;
                            ViewGroup viewGroup5 = (ViewGroup) ulVar2.h;
                            if (viewGroup5 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) ulVar2.h;
                            if (viewGroup6 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) ulVar2.h;
                            if (viewGroup7 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) ulVar2.h;
                            if (viewGroup8 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i9) {
                                i9 = measuredHeight2;
                            }
                            layoutParams.height = i9;
                            ViewGroup viewGroup9 = (ViewGroup) ulVar2.h;
                            if (viewGroup9 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) ulVar2.h;
                            if (viewGroup10 == null) {
                                n12.T("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            a11Var2.D0 = Math.max(measuredWidth, width);
                            a11Var2.E0 = measuredHeight + i9;
                            a11Var2.a(false);
                            return;
                        }
                        return;
                    case 4:
                        b11 b11Var = (b11) p60Var;
                        b11Var.getClass();
                        if (b11Var.c) {
                            return;
                        }
                        a11Var2.b();
                        return;
                    default:
                        ((m11) p60Var).getClass();
                        a11Var2.F0.d(false);
                        a11Var2.b();
                        return;
                }
            }
        });
        this.b.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: y01
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.b.H0.a = false;
            }
        });
        d();
    }

    public static final void e(a11 a11Var, kt1 kt1Var) {
        MotionEvent motionEvent = kt1Var.d;
        a11Var.K0 = new e03(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
    }

    public static void f(a11 a11Var, d4 d4Var) {
        CodeEditor codeEditor = a11Var.f;
        codeEditor.removeCallbacks(d4Var);
        codeEditor.a0(d4Var, 1000L);
    }

    @Override // defpackage.l11
    public final void b() {
        if (this.b.isShowing()) {
            super.b();
        }
    }

    public final void d() {
        u01 colorScheme = this.f.getColorScheme();
        colorScheme.getClass();
        ul ulVar = this.H0;
        ulVar.getClass();
        a11 a11Var = (a11) ulVar.b;
        if (a11Var == null) {
            n12.T("window");
            throw null;
        }
        CodeEditor codeEditor = a11Var.f;
        codeEditor.getClass();
        TextView textView = (TextView) ulVar.d;
        if (textView == null) {
            n12.T("briefMessageText");
            throw null;
        }
        textView.setTextColor(colorScheme.e(54));
        TextView textView2 = (TextView) ulVar.e;
        if (textView2 == null) {
            n12.T("detailMessageText");
            throw null;
        }
        textView2.setTextColor(colorScheme.e(55));
        TextView textView3 = (TextView) ulVar.f;
        if (textView3 == null) {
            n12.T("quickfixText");
            throw null;
        }
        textView3.setTextColor(colorScheme.e(56));
        TextView textView4 = (TextView) ulVar.g;
        if (textView4 == null) {
            n12.T("moreActionText");
            throw null;
        }
        textView4.setTextColor(colorScheme.e(56));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(codeEditor.getDpUnit() * 5.0f);
        gradientDrawable.setColor(colorScheme.e(53));
        View view = (View) ulVar.c;
        if (view != null) {
            view.setBackground(gradientDrawable);
        } else {
            n12.T("root");
            throw null;
        }
    }

    public final void g() {
        if (this.F0.f) {
            CodeEditor codeEditor = this.f;
            codeEditor.getClass();
            t01 t01Var = codeEditor.R1;
            t01Var.getClass();
            if (t01Var.b.isShowing()) {
                b();
            }
        }
    }
}
