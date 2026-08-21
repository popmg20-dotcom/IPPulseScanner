package io.github.rosemoe.sora.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.TransactionTooLargeException;
import android.text.Editable;
import android.text.method.MetaKeyKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.Toast;
import com.getsurfboard.R;
import defpackage.a11;
import defpackage.a12;
import defpackage.a21;
import defpackage.a54;
import defpackage.ac4;
import defpackage.ag0;
import defpackage.am1;
import defpackage.as2;
import defpackage.au0;
import defpackage.b11;
import defpackage.bu0;
import defpackage.c03;
import defpackage.cv2;
import defpackage.d11;
import defpackage.d21;
import defpackage.d4;
import defpackage.d70;
import defpackage.dl4;
import defpackage.e84;
import defpackage.ed4;
import defpackage.eg0;
import defpackage.ez4;
import defpackage.f02;
import defpackage.f41;
import defpackage.f84;
import defpackage.fc4;
import defpackage.fq;
import defpackage.fs3;
import defpackage.fw;
import defpackage.g02;
import defpackage.g82;
import defpackage.g84;
import defpackage.ga5;
import defpackage.gb4;
import defpackage.gc4;
import defpackage.gs3;
import defpackage.h11;
import defpackage.ha1;
import defpackage.hb4;
import defpackage.hs3;
import defpackage.i11;
import defpackage.ic4;
import defpackage.is1;
import defpackage.j60;
import defpackage.j82;
import defpackage.je;
import defpackage.jj2;
import defpackage.jl4;
import defpackage.jr2;
import defpackage.js3;
import defpackage.k01;
import defpackage.k60;
import defpackage.k61;
import defpackage.kd0;
import defpackage.kv1;
import defpackage.l60;
import defpackage.l61;
import defpackage.l74;
import defpackage.l84;
import defpackage.lb;
import defpackage.ld0;
import defpackage.lg0;
import defpackage.ln2;
import defpackage.lw4;
import defpackage.m0;
import defpackage.m10;
import defpackage.mn2;
import defpackage.n02;
import defpackage.na2;
import defpackage.nd0;
import defpackage.nf2;
import defpackage.nn2;
import defpackage.oa2;
import defpackage.oj1;
import defpackage.on;
import defpackage.oq3;
import defpackage.p60;
import defpackage.pa2;
import defpackage.pc4;
import defpackage.pg0;
import defpackage.pr1;
import defpackage.q30;
import defpackage.qc4;
import defpackage.qe;
import defpackage.qg0;
import defpackage.qn;
import defpackage.ri3;
import defpackage.rq1;
import defpackage.s53;
import defpackage.s82;
import defpackage.sc3;
import defpackage.si3;
import defpackage.sr2;
import defpackage.t01;
import defpackage.t60;
import defpackage.ti3;
import defpackage.tj4;
import defpackage.tm2;
import defpackage.u01;
import defpackage.u04;
import defpackage.u11;
import defpackage.uc4;
import defpackage.ud0;
import defpackage.uu0;
import defpackage.uy3;
import defpackage.v0;
import defpackage.v11;
import defpackage.v62;
import defpackage.vd0;
import defpackage.ve2;
import defpackage.vf2;
import defpackage.w44;
import defpackage.w82;
import defpackage.w90;
import defpackage.wc4;
import defpackage.wd0;
import defpackage.x11;
import defpackage.xb5;
import defpackage.xe;
import defpackage.y90;
import defpackage.yr2;
import defpackage.zf2;
import defpackage.zo2;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.tm4e.languageconfiguration.internal.model.CompleteEnterAction;
import org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction;
import org.eclipse.tm4e.languageconfiguration.internal.model.IndentationRules;
import org.eclipse.tm4e.languageconfiguration.internal.model.RegExPattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CodeEditor extends View implements vd0, f02 {
    public static final /* synthetic */ int r2 = 0;
    public final a11 A;
    public q30 A0;
    public boolean A1;
    public final h11 B0;
    public boolean B1;
    public final k61 C0;
    public boolean C1;
    public v0 D0;
    public final gs3 D1;
    public int E0;
    public final gs3 E1;
    public int F0;
    public final gs3 F1;
    public int G0;
    public final ClipboardManager G1;
    public int H0;
    public final InputMethodManager H1;
    public int I0;
    public lg0 I1;
    public final float J0;
    public ld0 J1;
    public float K0;
    public final Matrix K1;
    public float L0;
    public u01 L1;
    public float M0;
    public oa2 M1;
    public float N0;
    public String N1;
    public float O0;
    public s82 O1;
    public float P0;
    public au0 P1;
    public final float Q0;
    public long Q1;
    public float R0;
    public final t01 R1;
    public float S0;
    public final d21 S1;
    public float T0;
    public Paint.Align T1;
    public float U0;
    public final GestureDetector U1;
    public float V0;
    public final ScaleGestureDetector V1;
    public boolean W0;
    public final CursorAnchorInfo.Builder W1;
    public boolean X0;
    public final EdgeEffect X1;
    public boolean Y0;
    public final EdgeEffect Y1;
    public boolean Z0;
    public ExtractedTextRequest Z1;
    public boolean a1;
    public final x11 a2;
    public final eg0 b;
    public boolean b1;
    public pg0 b2;
    public boolean c1;
    public hs3 c2;
    public boolean d1;
    public qg0 d2;
    public volatile boolean e1;
    public final uu0 e2;
    public n02 f;
    public boolean f1;
    public Bundle f2;
    public int g1;
    public a54 g2;
    public int h1;
    public final ri3 h2;
    public int i1;
    public final u11 i2;
    public boolean j1;
    public boolean j2;
    public boolean k1;
    public float k2;
    public boolean l1;
    public float l2;
    public boolean m1;
    public boolean m2;
    public boolean n1;
    public boolean n2;
    public boolean o1;
    public pa2 o2;
    public boolean p1;
    public final uy3 p2;
    public boolean q1;
    public final HashMap q2;
    public boolean r1;
    public boolean s1;
    public boolean t1;
    public boolean u1;
    public boolean v1;
    public boolean w1;
    public boolean x1;
    public final ArrayList y0;
    public boolean y1;
    public final a21 z;
    public final ed4 z0;
    public boolean z1;

    static {
        ve2.a("CodeEditor");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0392  */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [float] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v50, types: [float] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CodeEditor(Context context, AttributeSet attributeSet) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, R.attr.codeEditorStyle, 0);
        ?? r1 = 0;
        this.b = new eg0(this);
        int i = 2;
        this.y0 = new ArrayList(2);
        this.G0 = 0;
        this.S0 = 1.0f;
        this.T0 = 0.0f;
        this.V0 = 0.5f;
        this.P1 = au0.b;
        this.Q1 = 0L;
        this.q2 = new HashMap();
        Log.v("CodeEditor", "sora-editor\nCopyright (C) Rosemoe roses2020@qq.com\nThis project is distributed under the LGPL v2.1 license");
        ?? r4 = 0;
        this.C0 = new k61(null);
        final int i2 = 1;
        this.A1 = true;
        this.h2 = new ri3(this);
        this.i2 = new u11(this);
        this.z0 = new ed4(this);
        ?? context2 = getContext();
        if (Build.VERSION.SDK_INT >= 26) {
            context2 = ViewConfiguration.get(context2).getScaledVerticalScrollFactor();
        } else {
            try {
                try {
                    typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(new int[]{android.R.attr.listPreferredItemHeight});
                    try {
                        float dimension = typedArrayObtainStyledAttributes.getDimension(0, 32.0f);
                        typedArrayObtainStyledAttributes.recycle();
                        context2 = dimension;
                    } catch (Exception e) {
                        e = e;
                        a1.e("ViewUtils", "Failed to get vertical scroll factor, using default.", e);
                        if (typedArrayObtainStyledAttributes != null) {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                        context2 = 1107296256;
                    }
                } catch (Throwable th) {
                    th = th;
                    r4 = context2;
                    if (r4 != 0) {
                        r4.recycle();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                typedArrayObtainStyledAttributes = null;
            } catch (Throwable th2) {
                th = th2;
                if (r4 != 0) {
                }
                throw th;
            }
        }
        this.Q0 = context2;
        this.o2 = pa2.LF;
        this.M1 = t60.X;
        Context context3 = getContext();
        SparseIntArray sparseIntArray = kv1.a;
        int i3 = R.string.sora_editor_editor_formatting;
        int i4 = sparseIntArray.get(R.string.sora_editor_editor_formatting);
        this.N1 = context3.getString(i4 != 0 ? i4 : i3);
        this.e2 = new uu0();
        float fApplyDimension = TypedValue.applyDimension(1, 10.0f, Resources.getSystem().getDisplayMetrics()) / 10.0f;
        this.J0 = fApplyDimension;
        this.K0 = fApplyDimension;
        this.N0 = 1.5f * fApplyDimension;
        this.P0 = fApplyDimension;
        float f = fApplyDimension * 2.0f;
        this.M0 = f;
        this.L0 = f;
        this.K1 = new Matrix();
        this.c2 = new rq1(getContext());
        this.a2 = new x11(this);
        this.b2 = new tm2(this);
        setCursorBlinkPeriod(500);
        this.W1 = new CursorAnchorInfo.Builder();
        setTextSize(18.0f);
        setLineInfoTextSize(TypedValue.applyDimension(2, 21.0f, Resources.getSystem().getDisplayMetrics()));
        u01 u01Var = u01.c;
        this.L1 = u01Var;
        u01Var.c(this);
        this.S1 = new d21(this);
        GestureDetector gestureDetector = new GestureDetector(getContext(), this.S1);
        this.U1 = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this.S1);
        this.V1 = new ScaleGestureDetector(getContext(), this.S1);
        this.F1 = new gs3();
        this.D1 = new gs3();
        this.E1 = new gs3();
        this.T1 = Paint.Align.RIGHT;
        this.W0 = false;
        this.l1 = true;
        this.O0 = 1.0f;
        this.H1 = (InputMethodManager) getContext().getSystemService("input_method");
        this.G1 = (ClipboardManager) getContext().getSystemService("clipboard");
        setUndoEnabled(true);
        this.F0 = -1;
        setScalable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.x1 = true;
        this.B0 = new h11(this);
        this.R1 = new t01(this);
        this.X1 = new EdgeEffect(getContext());
        this.Y1 = new EdgeEffect(getContext());
        this.z = new a21(this);
        this.A = new a11(this);
        new zf2(this);
        setEditorLanguage(null);
        setText(null);
        setTabWidth(4);
        setHighlightCurrentLine(true);
        setVerticalScrollBarEnabled(true);
        setHighlightCurrentBlock(true);
        setDisplayLnPanel(true);
        setHorizontalScrollBarEnabled(true);
        setFirstLineNumberAlwaysVisible(true);
        setCursorAnimationEnabled(true);
        setEditable(true);
        setLineNumberEnabled(true);
        setHardwareAcceleratedDrawAllowed(true);
        setInterceptParentHorizontalScrollIfNeeded(false);
        setTypefaceText(Typeface.DEFAULT);
        setSoftKeyboardEnabled(true);
        setDisableSoftKbdIfHardKbdAvailable(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(false);
        }
        if (getContext() instanceof ContextThemeWrapper) {
            ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) getContext();
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
            setEdgeEffectColor(typedValue.data);
        }
        this.V1.setQuickScaleEnabled(false);
        final uy3 uy3Var = new uy3();
        pr1 pr1Var = new pr1();
        y90 y90Var = new y90();
        getClipboardManager();
        y90Var.a(new k01(13));
        y90Var.a(new t60());
        y90Var.a(new k01(27));
        y90Var.a(new l74(i));
        y90Var.a(pr1Var);
        final ?? r12 = r1 == true ? 1 : 0;
        this.C0.f(fs3.class, new l61(uy3Var, r12) { // from class: ty3
            public final /* synthetic */ int b;

            {
                this.b = r12;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                switch (this.b) {
                    case 0:
                        ((fs3) p60Var).getClass();
                        break;
                    default:
                        ((nd0) p60Var).getClass();
                        break;
                }
            }
        });
        this.C0.f(nd0.class, new l61(uy3Var, i2) { // from class: ty3
            public final /* synthetic */ int b;

            {
                this.b = i2;
            }

            @Override // defpackage.l61
            public final void a(p60 p60Var, id0 id0Var) {
                switch (this.b) {
                    case 0:
                        ((fs3) p60Var).getClass();
                        break;
                    default:
                        ((nd0) p60Var).getClass();
                        break;
                }
            }
        });
        this.p2 = uy3Var;
        TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, sc3.a, R.attr.codeEditorStyle, 0);
        setHorizontalScrollbarThumbDrawable(typedArrayObtainStyledAttributes2.getDrawable(15));
        setHorizontalScrollbarTrackDrawable(typedArrayObtainStyledAttributes2.getDrawable(17));
        setVerticalScrollbarThumbDrawable(typedArrayObtainStyledAttributes2.getDrawable(16));
        setVerticalScrollbarTrackDrawable(typedArrayObtainStyledAttributes2.getDrawable(18));
        setLnPanelPositionMode(typedArrayObtainStyledAttributes2.getInt(11, 1));
        setLnPanelPosition(typedArrayObtainStyledAttributes2.getInt(10, 15));
        setDividerWidth(typedArrayObtainStyledAttributes2.getDimension(3, getDividerWidth()));
        h0(typedArrayObtainStyledAttributes2.getDimension(2, this.L0), typedArrayObtainStyledAttributes2.getDimension(2, this.M0));
        setPinLineNumber(typedArrayObtainStyledAttributes2.getBoolean(12, false));
        setHighlightCurrentBlock(typedArrayObtainStyledAttributes2.getBoolean(5, true));
        setHighlightCurrentLine(typedArrayObtainStyledAttributes2.getBoolean(6, true));
        setHighlightBracketPair(typedArrayObtainStyledAttributes2.getBoolean(4, true));
        setLigatureEnabled(typedArrayObtainStyledAttributes2.getBoolean(8, true));
        setLineNumberEnabled(typedArrayObtainStyledAttributes2.getBoolean(9, this.k1));
        t01 t01Var = this.R1;
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        t01Var.T0 = z;
        t01Var.P0.d(z);
        if (!z) {
            t01Var.e();
            t01Var.f();
        }
        this.e2.f = typedArrayObtainStyledAttributes2.getBoolean(19, true);
        setRenderFunctionCharacters(typedArrayObtainStyledAttributes2.getBoolean(13, this.A1));
        setScalable(typedArrayObtainStyledAttributes2.getBoolean(14, this.X0));
        setTextSizePx(typedArrayObtainStyledAttributes2.getDimension(22, getTextSizePx()));
        setCursorBlinkPeriod(typedArrayObtainStyledAttributes2.getInt(1, getCursorBlink().X));
        setTabWidth(typedArrayObtainStyledAttributes2.getInt(20, getTabWidth()));
        int i5 = typedArrayObtainStyledAttributes2.getInt(24, 0);
        if (i5 != 0) {
            m0(true, i5 > 1);
        }
        setText(typedArrayObtainStyledAttributes2.getString(21));
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final int A(int i) {
        return (i + 1) * getRowHeight();
    }

    public final int B(int i) {
        return (getLineSpacingPixels() / 2) + (getRowHeight() * i);
    }

    public final List C(int i) {
        a54 a54Var = this.g2;
        lb lbVar = a54Var == null ? null : a54Var.a;
        ArrayList arrayList = this.y0;
        boolean z = false;
        if (arrayList.isEmpty()) {
            arrayList.add(as2.a(0, 5L));
        }
        if (lbVar == null) {
            return arrayList;
        }
        try {
            return new lb(11, lbVar, z).g(i);
        } catch (Exception unused) {
            return arrayList;
        }
    }

    public final void E(boolean z) {
        lg0 cursor = getCursor();
        if (!z || cursor.a()) {
            s82 editorLanguage = getEditorLanguage();
            int tabWidth = getTabWidth();
            int tabWidth2 = getTabWidth();
            editorLanguage.getClass();
            String strO = yr2.o(tabWidth, tabWidth2, false);
            ld0 text = getText();
            int tabWidth3 = getTabWidth();
            text.b();
            for (int i = cursor.c.b; i <= cursor.d.b; i++) {
                long jM = yr2.m(text.o(i));
                int i2 = (int) (jM >> 32);
                int i3 = (int) (jM & 4294967295L);
                int i4 = (i3 * tabWidth3) + i2;
                int i5 = i2 + i3;
                int i6 = tabWidth3 - (i4 % tabWidth3);
                if (i2 > 0 && i3 > 0) {
                    if (i6 == 0) {
                        i6 = tabWidth3;
                    }
                    text.x(i, 0, w44.h0((i6 + i4) / tabWidth3, strO), i, i5);
                } else if (i6 == tabWidth3) {
                    text.r(i, i5, strO);
                } else {
                    text.r(i, i5, w44.h0(i6, " "));
                }
            }
            text.k();
        }
    }

    @Override // defpackage.vd0
    public final void F(ld0 ld0Var, int i, int i2, int i3, int i4, CharSequence charSequence) {
        ArrayList arrayList;
        ti3 ti3Var;
        int i5;
        int i6;
        ri3 ri3Var = this.h2;
        v62 v62Var = ri3Var.a;
        if (i != i3) {
            int i7 = i3 - i;
            mn2 mn2Var = (mn2) v62Var.f;
            if (i7 != 1) {
                int[] iArr = new int[i7];
                if (i < 0 || i > (i5 = mn2Var.b)) {
                    s53.k("");
                    return;
                }
                if (i7 != 0) {
                    mn2Var.a(i5 + i7);
                    int[] iArr2 = mn2Var.a;
                    int i8 = mn2Var.b;
                    if (i != i8) {
                        qe.e0(iArr2, i + i7, iArr2, i, i8);
                    }
                    qe.g0(iArr, i, iArr2, 0, 12);
                    mn2Var.b += i7;
                }
            } else {
                if (i < 0 || i > (i6 = mn2Var.b)) {
                    s53.k("Index must be between 0 and size");
                    return;
                }
                mn2Var.a(i6 + 1);
                int[] iArr3 = mn2Var.a;
                int i9 = mn2Var.b;
                if (i != i9) {
                    qe.e0(iArr3, i + 1, iArr3, i, i9);
                }
                iArr3[i] = 0;
                mn2Var.b++;
            }
            for (jj2 jj2Var : (ArrayList) v62Var.z) {
                int i10 = jj2Var.a;
                if (i10 > i) {
                    jj2Var.a = i10 + i7;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && (ti3Var = ri3Var.b) != null) {
            for (si3 si3Var : ti3Var.b) {
                int i11 = si3Var.a;
                if (i11 == i) {
                    si3Var.c = true;
                } else if (i11 > i) {
                    si3Var.a = (i3 - i) + i11;
                }
            }
        }
        this.i2.G();
        this.z0.getClass();
        q30 q30VarM = this.J1.n().m(i, i2);
        q30 q30VarM2 = this.J1.n().m(i3, i4);
        try {
            a54 a54Var = this.g2;
            if (a54Var != null) {
                int i12 = q30VarM2.b;
                int i13 = q30VarM.b;
                int i14 = i12 - i13;
                if (i14 != 0 && (arrayList = a54Var.b) != null) {
                    je.g0(arrayList, i13, i14);
                }
            }
        } catch (Exception e) {
            a1.o("CodeEditor", "Update failure", e);
        }
        this.D0.F(ld0Var, i, i2, i3, i4, charSequence);
        u11 u11Var = this.i2;
        u11Var.c(i, i3, u11Var.z, false);
        b();
        this.O1.c().m(q30VarM, q30VarM2, charSequence);
        d21 d21Var = this.S1;
        if (d21Var.n()) {
            d21Var.p = 0L;
            d21Var.a.invalidate();
        }
        if (this.Y0 && !this.I1.a() && !this.B0.b.a() && this.i1 == 0) {
            ((tm2) this.b2).c();
            ((tm2) this.b2).e();
        }
        boolean z = this.d1;
        lg0 lg0Var = this.I1;
        this.A0 = z ? lg0Var.c.a() : lg0Var.d.a();
        m(new nd0(this, 2, q30VarM, q30VarM2, charSequence, this.J1.z0.Z));
        X(1);
        q30VarM.a();
        q30VarM2.a();
        this.W0 = false;
        r();
        p0();
    }

    public final void G() {
        lg0 cursor = getCursor();
        if (cursor.a()) {
            E(true);
            return;
        }
        q30 q30VarA = cursor.c.a();
        long jM = yr2.m(getText().o(q30VarA.b));
        if (q30VarA.c <= ((int) (jM >> 32)) + ((int) (jM & 4294967295L))) {
            E(false);
            return;
        }
        h11 h11Var = this.B0;
        if (h11Var == null || !H()) {
            return;
        }
        if (h11Var.b.a()) {
            e0();
        }
        s82 editorLanguage = getEditorLanguage();
        int tabWidth = getTabWidth();
        int tabWidth2 = getTabWidth();
        editorLanguage.getClass();
        h11Var.a(yr2.o(tabWidth, tabWidth2, false));
    }

    public final boolean H() {
        if (!this.Y0 || this.e1) {
            return false;
        }
        K();
        return true;
    }

    @Override // defpackage.vd0
    public final void I(ld0 ld0Var) {
        this.e2.getClass();
        ((tm2) this.b2).d();
        this.d1 = this.I1.c.a().equals(this.A0);
    }

    public final void K() {
        this.O1.getClass();
    }

    public final boolean O() {
        this.e2.getClass();
        return this.b1 || this.c1;
    }

    public final boolean P(float f, float f2) {
        long jY = y(f, f2);
        uc4 uc4VarD = this.i2.d(this.D0.D(this.J1.l((int) (jY >> 32), (int) (jY & 4294967295L))));
        qc4 qc4Var = new qc4(uc4VarD, new pc4());
        uc4VarD.l(qc4Var, true);
        float f3 = qc4Var.a;
        float fT = T();
        float offsetX = getOffsetX() + f;
        return offsetX >= fT && offsetX <= f3 + fT;
    }

    @Override // defpackage.vd0
    public final void Q(ld0 ld0Var, final int i, int i2, final int i3, int i4, StringBuilder sb) {
        int i5;
        int i6;
        ArrayList arrayList;
        ti3 ti3Var;
        ri3 ri3Var = this.h2;
        v62 v62Var = ri3Var.a;
        ArrayList<jj2> arrayList2 = (ArrayList) v62Var.z;
        if (i != i3) {
            ((mn2) v62Var.f).c(i, i3);
            d70.o0(arrayList2, new am1() { // from class: qi3
                @Override // defpackage.am1
                public final Object g(Object obj) {
                    jj2 jj2Var = (jj2) obj;
                    jj2Var.getClass();
                    int i7 = jj2Var.a;
                    boolean z = false;
                    if (i <= i7 && i7 <= i3) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            });
            for (jj2 jj2Var : arrayList2) {
                int i7 = jj2Var.a;
                if (i7 > i3) {
                    jj2Var.a = i7 - (i3 - i);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && (ti3Var = ri3Var.b) != null) {
            ti3Var.a(i, i3);
        }
        this.i2.G();
        this.z0.getClass();
        q30 q30VarM = this.J1.n().m(i, i2);
        q30 q30VarA = q30VarM.a();
        q30VarA.c = i4;
        q30VarA.b = i3;
        q30VarA.a = sb.length() + q30VarM.a;
        try {
            a54 a54Var = this.g2;
            if (a54Var != null && (i6 = (i5 = q30VarM.b) - q30VarA.b) != 0 && (arrayList = a54Var.b) != null) {
                je.g0(arrayList, i5, i6);
            }
        } catch (Exception e) {
            a1.o("CodeEditor", "Update failure", e);
        }
        this.D0.Q(ld0Var, i, i2, i3, i4, sb);
        u11 u11Var = this.i2;
        u11Var.c(i, i + 1, u11Var.z, false);
        b();
        if (this.Y0 && !this.I1.a() && !this.W0 && !this.B0.b.a() && this.i1 == 0) {
            ((tm2) this.b2).c();
            ((tm2) this.b2).e();
        }
        this.O1.c().h(q30VarM, q30VarA);
        boolean z = this.d1;
        lg0 lg0Var = this.I1;
        this.A0 = z ? lg0Var.c.a() : lg0Var.d.a();
        this.C0.a(new nd0(this, 3, q30VarM, q30VarA, sb, this.J1.z0.Z));
        X(1);
        if (this.W0) {
            return;
        }
        p0();
        r();
        d21 d21Var = this.S1;
        if (d21Var.n()) {
            d21Var.p = 0L;
            d21Var.a.invalidate();
        }
    }

    public final float S() {
        float fMax = 0.0f;
        if (!this.k1) {
            return 0.0f;
        }
        int i = 0;
        for (int lineCount = getLineCount(); lineCount > 0; lineCount /= 10) {
            i++;
        }
        float[] fArrA = hb4.a(19);
        this.i2.c.getTextWidths("0 1 2 3 4 5 6 7 8 9", fArrA);
        hb4.b(fArrA);
        for (int i2 = 0; i2 < 19; i2 += 2) {
            fMax = Math.max(fMax, fArrA[i2]);
        }
        return (fMax * i) + this.U0;
    }

    public final float T() {
        if (!this.k1) {
            return this.J0 * 5.0f;
        }
        float fS = S() + this.L0 + this.M0 + this.K0;
        this.i2.A();
        return fS + 0.0f;
    }

    public final void U(js3 js3Var, boolean z) {
        if (z) {
            v(js3Var);
        } else {
            V(js3Var);
        }
    }

    public final void V(js3 js3Var) {
        q30 q30VarA;
        if (this.I1.a()) {
            if (js3Var == js3.X) {
                q30 q30Var = this.I1.c;
                j0(q30Var.b, q30Var.c, 7, true);
                return;
            } else if (js3Var == js3.Y) {
                q30 q30Var2 = this.I1.d;
                j0(q30Var2.b, q30Var2.c, 7, true);
                return;
            }
        }
        int iOrdinal = js3Var.f.ordinal();
        if (iOrdinal == 0) {
            q30VarA = this.I1.c.a();
        } else if (iOrdinal != 1) {
            q();
            q30VarA = this.A0;
        } else {
            q30VarA = this.I1.d.a();
        }
        q30VarA.getClass();
        q30 q30Var3 = (q30) js3Var.b.k(this, q30VarA);
        js3 js3Var2 = js3.z0;
        d21 d21Var = this.S1;
        if (js3Var == js3Var2) {
            d21Var.k(0.0f, -getHeight(), true);
        } else if (js3Var == js3.A0) {
            d21Var.k(0.0f, getHeight(), true);
        }
        j0(q30Var3.b, q30Var3.c, 7, true);
    }

    public final void W() {
        ExtractedTextRequest extractedTextRequest = this.Z1;
        if (extractedTextRequest != null) {
            ExtractedText extractedTextW = w(extractedTextRequest);
            this.H1.updateExtractedText(this, this.Z1.token, extractedTextW);
        }
        r0();
        q0();
        if (this.B0.b.a()) {
            e0();
        }
    }

    public final void X(int i) {
        m(new fs3(this, i));
        getCursorRange();
    }

    public final void Y() {
        ClipData primaryClip;
        ClipboardManager clipboardManager = this.G1;
        try {
            if (clipboardManager.hasPrimaryClip() && (primaryClip = clipboardManager.getPrimaryClip()) != null) {
                String strO = tj4.o(primaryClip);
                h11 h11Var = this.B0;
                if (h11Var != null) {
                    h11Var.commitText(strO, 1);
                    this.e2.getClass();
                    W();
                }
            }
        } catch (Exception e) {
            a1.o("CodeEditor", "Error pasting text to editor", e);
            Toast.makeText(getContext(), e.toString(), 0).show();
        }
    }

    @Override // defpackage.vd0
    public final void a(ld0 ld0Var) {
        this.W0 = true;
        this.D0.a(ld0Var);
    }

    public final void a0(Runnable runnable, long j) {
        d11.a.postDelayed(new k60(this, runnable, 1), j);
    }

    public final void b() {
        ViewGroup.LayoutParams layoutParams;
        if (!this.z1 || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        if (layoutParams.width == -2) {
            requestLayout();
        } else {
            if (layoutParams.height != -2 || getHeight() == this.D0.l()) {
                return;
            }
            requestLayout();
        }
    }

    public final void b0(Runnable runnable) {
        d11.a.post(new k60(this, runnable, 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        boolean z;
        if (this.C1) {
            Context context = getContext();
            if (context == null) {
                z = false;
                if (z) {
                    return false;
                }
            } else {
                Configuration configuration = context.getResources().getConfiguration();
                z = true;
                if (configuration.keyboard == 1 && configuration.hardKeyboardHidden != 1) {
                }
                if (z) {
                }
            }
        }
        return this.B1;
    }

    public final void c0() {
        ld0 ld0Var = this.J1;
        jl4 jl4Var = ld0Var.z0;
        boolean z = jl4Var.f;
        ArrayList arrayList = jl4Var.b;
        if (z && jl4Var.Y < arrayList.size() && !jl4Var.Z) {
            jl4Var.Z = true;
            ((dl4) arrayList.get(jl4Var.Y)).k(ld0Var);
            jl4Var.Y++;
            jl4Var.Z = false;
        }
        W();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return Math.max(0, Math.min(getScrollMaxX(), getOffsetX()));
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return getScrollMaxX();
    }

    @Override // android.view.View
    public final void computeScroll() {
        d21 d21Var = this.S1;
        v11 v11Var = d21Var.b;
        OverScroller overScroller = v11Var.b;
        boolean zComputeScrollOffset = overScroller.computeScrollOffset();
        if (zComputeScrollOffset) {
            v11Var.a();
        }
        if (zComputeScrollOffset) {
            if (!overScroller.isFinished() && (overScroller.getStartX() != overScroller.getFinalX() || overScroller.getStartY() != overScroller.getFinalY())) {
                this.k2 = overScroller.getFinalX();
                this.l2 = overScroller.getFinalY();
                this.n2 = ((float) Math.abs(overScroller.getStartX() - overScroller.getFinalX())) > getDpUnit() * 5.0f;
                this.m2 = ((float) Math.abs(overScroller.getStartY() - overScroller.getFinalY())) > getDpUnit() * 5.0f;
            }
            int currX = overScroller.getCurrX();
            EdgeEffect edgeEffect = this.Y1;
            if (currX > 0 || this.k2 > 0.0f || !edgeEffect.isFinished() || !this.n2) {
                int scrollMaxX = getScrollMaxX();
                if (overScroller.getCurrX() >= scrollMaxX && this.k2 >= scrollMaxX && edgeEffect.isFinished() && this.n2) {
                    edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                    d21Var.j = true;
                }
            } else {
                edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                d21Var.j = false;
            }
            int currY = overScroller.getCurrY();
            EdgeEffect edgeEffect2 = this.X1;
            if (currY > 0 || this.l2 > 0.0f || !edgeEffect2.isFinished() || !this.m2) {
                int scrollMaxY = getScrollMaxY();
                if (overScroller.getCurrY() >= scrollMaxY && this.l2 >= scrollMaxY && edgeEffect2.isFinished() && this.m2) {
                    edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                    d21Var.i = true;
                }
            } else {
                edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                d21Var.i = false;
            }
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, Math.min(getScrollMaxY(), getOffsetY()));
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        return getScrollMaxY();
    }

    @Override // android.view.View
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = super.createAccessibilityNodeInfo();
        if (isEnabled()) {
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setEditable(H());
            lg0 lg0Var = this.I1;
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setTextSelection(lg0Var.c.a, lg0Var.d.a);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setInputType(1);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setMultiLine(true);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setText(getText().E());
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setLongClickable(true);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_COPY);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CUT);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_PASTE);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_TEXT);
            int scrollMaxY = getScrollMaxY();
            if (scrollMaxY > 0) {
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setScrollable(true);
                int offsetY = getOffsetY();
                if (offsetY > 0) {
                    accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP);
                }
                if (offsetY < scrollMaxY) {
                    accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCreateAccessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN);
                }
            }
        }
        return accessibilityNodeInfoCreateAccessibilityNodeInfo;
    }

    public final void d0() {
        if (this.z1) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.G0 = x;
            if (this.m1) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 2) {
            int i = x - this.G0;
            if (this.m1 && !this.S1.f() && ((i > 0 && getScroller().b.getCurrX() == 0) || (i < 0 && getScroller().b.getCurrX() == getScrollMaxX()))) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0216  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(CharSequence charSequence, boolean z) {
        g84 g84Var;
        CharSequence charSequence2;
        char cCharAt;
        char cCharAt2;
        boolean zD;
        boolean z2;
        int i = 2;
        if (!getProps().f || charSequence.length() <= 0) {
            g84Var = null;
        } else {
            char cCharAt3 = charSequence.charAt(charSequence.length() - 1);
            char[] charArray = charSequence.length() > 1 ? charSequence.toString().toCharArray() : null;
            n02 n02Var = this.f;
            q30 q30VarA = this.I1.c.a();
            n02Var.getClass();
            ld0 text = getText();
            g84 g84VarW = charArray == null ? n02Var.w(cCharAt3) : null;
            if (g84VarW != null) {
                int i2 = q30VarA.a;
                g84VarW.d = g84VarW.a.length() + i2;
                g84VarW.e = i2;
                g84Var = g84VarW;
            } else {
                for (g84 g84Var2 : n02Var.x(cCharAt3)) {
                    f84 f84Var = g84Var2.c;
                    String str = g84Var2.a;
                    if (f84Var == null) {
                        zD = false;
                    } else {
                        ld0 text2 = getText();
                        text2.o(text2.m().c.b);
                        text2.m();
                        zD = f84Var.d(this);
                    }
                    if (zD) {
                        char[] charArray2 = str.toCharArray();
                        int i3 = q30VarA.a;
                        if (charArray == null) {
                            z2 = true;
                            for (int length = charArray2.length - i; length >= 0; length--) {
                                if (i3 > 0) {
                                    i3--;
                                }
                                z2 &= text.charAt(i3) == charArray2[length];
                            }
                        } else {
                            if (charArray.length <= charArray2.length) {
                                int length2 = charArray2.length - 1;
                                int length3 = charArray.length - 1;
                                z2 = true;
                                while (length3 > 0) {
                                    z2 &= charArray[length3] == charArray2[length2];
                                    length3--;
                                    length2--;
                                }
                                if (z2 && length2 > 0) {
                                    i3--;
                                    while (length2 >= 0) {
                                        z2 &= text.charAt(i3) == charArray2[length2];
                                        i3--;
                                        length2--;
                                    }
                                }
                            }
                            i = 2;
                        }
                        if (z2) {
                            g84Var2.d = str.length() + i3;
                            g84Var2.e = i3;
                            g84Var = g84Var2;
                            break;
                        }
                        i = 2;
                    }
                }
                g84Var = null;
            }
        }
        lg0 lg0Var = this.I1;
        ld0 ld0Var = this.J1;
        try {
            this.O1.getClass();
        } catch (AbstractMethodError unused) {
        }
        if (g84Var != null) {
            String str2 = g84Var.a;
            String str3 = g84Var.b;
            if (g84Var != g84.f) {
                f84 f84Var2 = g84Var.c;
                if (f84Var2 == null ? false : f84Var2.c(ld0Var)) {
                    ld0Var.b();
                    q30 q30Var = lg0Var.c;
                    ld0Var.r(q30Var.b, q30Var.c, str2);
                    q30 q30Var2 = lg0Var.d;
                    ld0Var.r(q30Var2.b, q30Var2.c, str3);
                    ld0Var.k();
                    q30 q30Var3 = lg0Var.c;
                    int i4 = q30Var3.b;
                    int i5 = q30Var3.c;
                    q30 q30Var4 = lg0Var.d;
                    k0(i4, i5, q30Var4.b, q30Var4.c - str3.length());
                    return;
                }
                lg0Var.getClass();
                ld0Var.b();
                q30 q30VarJ = ld0Var.n().j(g84Var.e);
                int i6 = q30VarJ.b;
                int i7 = q30VarJ.c;
                q30 q30Var5 = lg0Var.d;
                ld0Var.x(i6, i7, g84Var.a, q30Var5.b, q30Var5.c);
                ld0Var.r(q30VarJ.b, str2.length() + q30VarJ.c, str3);
                ld0Var.k();
                q30 q30VarJ2 = ld0Var.n().j(g84Var.d);
                i0(q30VarJ2.b, q30VarJ2.c);
                return;
            }
        }
        if (lg0Var.a()) {
            q30 q30Var6 = lg0Var.c;
            int i8 = q30Var6.b;
            int i9 = q30Var6.c;
            q30 q30Var7 = lg0Var.d;
            ld0Var.x(i8, i9, charSequence, q30Var7.b, q30Var7.c);
            return;
        }
        this.e2.getClass();
        if (charSequence.length() != 0 && z && ((cCharAt = charSequence.charAt(0)) == '\n' || cCharAt == '\r')) {
            String strQ = this.J1.q(lg0Var.c.b);
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < lg0Var.c.c && ((cCharAt2 = strQ.charAt(i12)) == '\t' || cCharAt2 == ' '); i12++) {
                if (strQ.charAt(i12) == '\t') {
                    i11++;
                } else {
                    i10++;
                }
            }
            int i13 = (i11 * this.E0) + i10;
            try {
                s82 s82Var = this.O1;
                if (this.J1.A < 0) {
                    throw new IllegalArgumentException("start > end");
                }
                try {
                    s82Var.getClass();
                } catch (AbstractMethodError unused2) {
                    s82Var.getClass();
                }
            } catch (Exception e) {
                a1.o("CodeEditor", "Language object error", e);
            }
            if (cCharAt == '\r') {
                int i14 = (charSequence.length() < 2 || charSequence.charAt(1) != '\n') ? 1 : 2;
                StringBuilder sb = new StringBuilder(charSequence);
                int i15 = this.E0;
                this.O1.getClass();
                sb.insert(i14, yr2.o(i13, i15, false));
                charSequence2 = sb;
            }
        } else {
            charSequence2 = charSequence;
        }
        q30 q30Var8 = lg0Var.c;
        ld0Var.r(q30Var8.b, q30Var8.c, charSequence2);
    }

    public final void e0() {
        h11 h11Var = this.B0;
        if (h11Var != null) {
            ld0 text = h11Var.a.getText();
            while (text.X > 0) {
                text.k();
            }
            w90 w90Var = h11Var.b;
            w90Var.b = -1;
            w90Var.a = -1;
            w90Var.c = false;
            h11Var.c = false;
        }
        InputMethodManager inputMethodManager = this.H1;
        if (inputMethodManager != null) {
            inputMethodManager.restartInput(this);
        }
    }

    public final void f(boolean z) {
        if (this.I1.a()) {
            ld0 text = getText();
            lg0 lg0Var = this.I1;
            g(lg0Var.c.a, lg0Var.d.a, text);
        } else {
            if (!z) {
                String str = getLineSeparator().b;
                g(0, str.length(), str);
                return;
            }
            lg0 cursor = getCursor();
            if (cursor.a()) {
                f(true);
                return;
            }
            int i = cursor.c.a().b;
            k0(i, 0, i, getText().o(i).f);
            f(false);
        }
    }

    public final void f0() {
        k0(0, 0, getLineCount() - 1, getText().o(getLineCount() - 1).f);
    }

    public final void g(int i, int i2, CharSequence charSequence) {
        if (i2 < i) {
            return;
        }
        int i3 = i2 - i;
        this.e2.getClass();
        int i4 = R.string.sora_editor_clip_text_length_too_large;
        if (i3 > 524288) {
            Context context = getContext();
            int i5 = kv1.a.get(R.string.sora_editor_clip_text_length_too_large);
            if (i5 != 0) {
                i4 = i5;
            }
            Toast.makeText(context, i4, 0).show();
            return;
        }
        try {
            String strD = charSequence instanceof ld0 ? ((ld0) charSequence).D(i, i2) : charSequence.subSequence(i, i2).toString();
            this.G1.setPrimaryClip(ClipData.newPlainText(strD, strD));
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof TransactionTooLargeException)) {
                a1.m("CodeEditor", e);
                Toast.makeText(getContext(), e.getClass().toString(), 0).show();
                return;
            }
            Context context2 = getContext();
            int i6 = kv1.a.get(R.string.sora_editor_clip_text_length_too_large);
            if (i6 != 0) {
                i4 = i6;
            }
            Toast.makeText(context2, i4, 0).show();
        }
    }

    public final void g0(int i, int i2) {
        this.e2.getClass();
        ic4 ic4VarT = vf2.t(getText(), i, i2, true);
        q30 q30Var = ic4VarT.a;
        q30 q30Var2 = ic4VarT.b;
        l0(q30Var.b, q30Var.c, q30Var2.b, q30Var2.c, 5, true);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return CodeEditor.class.getName();
    }

    public int getBlockIndex() {
        return this.F0;
    }

    public float getBlockLineWidth() {
        return this.O0;
    }

    public ClipboardManager getClipboardManager() {
        return this.G1;
    }

    public u01 getColorScheme() {
        return this.L1;
    }

    public int getCurrentCursorBlock() {
        return this.F0;
    }

    public lg0 getCursor() {
        return this.I1;
    }

    public pg0 getCursorAnimator() {
        return this.b2;
    }

    public qg0 getCursorBlink() {
        return this.d2;
    }

    public ic4 getCursorRange() {
        lg0 lg0Var = this.I1;
        return new ic4(lg0Var.c.a(), lg0Var.d.a());
    }

    public au0 getDiagnosticIndicatorStyle() {
        return this.P1;
    }

    public bu0 getDiagnostics() {
        return null;
    }

    public float getDividerMarginLeft() {
        return this.L0;
    }

    public float getDividerMarginRight() {
        return this.M0;
    }

    public float getDividerWidth() {
        return this.K0;
    }

    public float getDpUnit() {
        return this.J0;
    }

    public int getEdgeEffectColor() {
        return this.X1.getColor();
    }

    public boolean getEditable() {
        return this.Y0;
    }

    public s82 getEditorLanguage() {
        return this.O1;
    }

    public d21 getEventHandler() {
        return this.S1;
    }

    public Bundle getExtraArguments() {
        return this.f2;
    }

    public int getFirstVisibleLine() {
        try {
            return this.D0.M(getFirstVisibleRow());
        } catch (IndexOutOfBoundsException unused) {
            return 0;
        }
    }

    public int getFirstVisibleRow() {
        return Math.max(0, getOffsetY() / getRowHeight());
    }

    public String getFormatTip() {
        return this.N1;
    }

    public c03 getGraphPaint() {
        return this.i2.g;
    }

    public hs3 getHandleStyle() {
        return this.c2;
    }

    public is1 getHighlightTexts() {
        return null;
    }

    public EdgeEffect getHorizontalEdgeEffect() {
        return this.Y1;
    }

    @Override // android.view.View
    public Drawable getHorizontalScrollbarThumbDrawable() {
        return this.i2.s;
    }

    @Override // android.view.View
    public Drawable getHorizontalScrollbarTrackDrawable() {
        return this.i2.t;
    }

    public List<Object> getInlayHintRenderers() {
        return new ArrayList(this.q2.values());
    }

    public g02 getInlayHints() {
        return null;
    }

    public InputMethodManager getInputMethodManager() {
        return this.H1;
    }

    public int getInputType() {
        return this.H0;
    }

    public gs3 getInsertHandleDescriptor() {
        return this.F1;
    }

    public float getInsertSelectionWidth() {
        return this.N0;
    }

    public j82 getKeyMetaStates() {
        return (j82) this.b.z;
    }

    public int getLastVisibleLine() {
        try {
            return this.D0.M(getLastVisibleRow());
        } catch (IndexOutOfBoundsException unused) {
            return this.getLineCount() - 1;
        }
    }

    public int getLastVisibleRow() {
        return Math.max(0, Math.min(this.D0.d() - 1, (getHeight() + getOffsetY()) / getRowHeight()));
    }

    public w82 getLayout() {
        return this.D0;
    }

    public gs3 getLeftHandleDescriptor() {
        return this.D1;
    }

    public int getLineCount() {
        return this.J1.b.size();
    }

    public float getLineInfoTextSize() {
        return this.R0;
    }

    public Paint.Align getLineNumberAlign() {
        return this.T1;
    }

    public float getLineNumberMarginLeft() {
        return this.U0;
    }

    public Paint.FontMetricsInt getLineNumberMetrics() {
        return this.i2.A;
    }

    public oa2 getLineNumberTipTextProvider() {
        return this.M1;
    }

    public pa2 getLineSeparator() {
        return this.o2;
    }

    public float getLineSpacingExtra() {
        return this.T0;
    }

    public float getLineSpacingMultiplier() {
        return this.S0;
    }

    public int getLineSpacingPixels() {
        Paint.FontMetricsInt fontMetricsInt = this.i2.r;
        return (((int) (((this.S0 - 1.0f) * (fontMetricsInt.descent - fontMetricsInt.ascent)) + this.T0)) / 2) * 2;
    }

    public int getLnPanelPosition() {
        return this.g1;
    }

    public int getLnPanelPositionMode() {
        return this.h1;
    }

    public int getNonPrintablePaintingFlags() {
        return this.I0;
    }

    public int getOffsetX() {
        return this.S1.b.b.getCurrX();
    }

    public int getOffsetY() {
        return this.S1.b.b.getCurrY();
    }

    public c03 getOtherPaint() {
        return this.i2.c;
    }

    public uu0 getProps() {
        return this.e2;
    }

    public ri3 getRenderContext() {
        return this.h2;
    }

    public u11 getRenderer() {
        return this.i2;
    }

    public gs3 getRightHandleDescriptor() {
        return this.E1;
    }

    public int getRowHeight() {
        Paint.FontMetricsInt fontMetricsInt = this.i2.r;
        return Math.max(1, getLineSpacingPixels() + (fontMetricsInt.descent - fontMetricsInt.ascent));
    }

    public int getRowHeightOfText() {
        Paint.FontMetricsInt fontMetricsInt = this.i2.r;
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }

    public int getScrollMaxX() {
        return (int) Math.max(0.0f, (T() + this.D0.Z()) - (getWidth() / 2.0f));
    }

    public int getScrollMaxY() {
        float height;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iL = this.D0.l();
        if (layoutParams == null || layoutParams.height == -2) {
            height = getHeight();
        } else {
            height = (1.0f - this.V0) * getHeight();
        }
        return Math.max(0, iL - ((int) height));
    }

    public v11 getScroller() {
        return this.S1.b;
    }

    public x11 getSearcher() {
        return this.a2;
    }

    public q30 getSelectingTarget() {
        boolean zEquals = this.I1.c.a().equals(this.A0);
        lg0 lg0Var = this.I1;
        return zEquals ? lg0Var.d.a() : lg0Var.c.a();
    }

    public uy3 getSnippetController() {
        return this.p2;
    }

    public a54 getStyles() {
        return this.g2;
    }

    public int getTabWidth() {
        return this.E0;
    }

    public ld0 getText() {
        return this.J1;
    }

    public float getTextBorderWidth() {
        return this.P0;
    }

    public float getTextLetterSpacing() {
        return this.i2.b.getLetterSpacing();
    }

    public c03 getTextPaint() {
        return this.i2.b;
    }

    public float getTextScaleX() {
        return this.i2.b.getTextScaleX();
    }

    public float getTextSizePx() {
        return this.i2.b.getTextSize();
    }

    public Typeface getTypefaceLineNumber() {
        return this.i2.c.getTypeface();
    }

    public Typeface getTypefaceText() {
        return this.i2.b.getTypeface();
    }

    public EdgeEffect getVerticalEdgeEffect() {
        return this.X1;
    }

    public float getVerticalExtraSpaceFactor() {
        return this.V0;
    }

    @Override // android.view.View
    public Drawable getVerticalScrollbarThumbDrawable() {
        return this.i2.u;
    }

    @Override // android.view.View
    public Drawable getVerticalScrollbarTrackDrawable() {
        return this.i2.v;
    }

    public final void h(boolean z) {
        CodeEditor codeEditor;
        v0 v0Var = this.D0;
        if (v0Var == null) {
            codeEditor = this;
        } else {
            if ((v0Var instanceof na2) && !this.Z0) {
                na2 na2Var = (na2) v0Var;
                na2Var.f = this.J1;
                na2Var.A.getAndIncrement();
                jr2 jr2Var = new jr2(na2Var.b.getTabWidth());
                na2Var.Z = jr2Var;
                jr2Var.b = na2Var.b.A1;
                try {
                    if (!na2Var.X.a.tryLock(5L, TimeUnit.MILLISECONDS)) {
                        qn qnVar = new qn();
                        na2Var.X = qnVar;
                        qn qnVar2 = new qn();
                        na2Var.Y = qnVar2;
                        na2Var.e(qnVar, qnVar2);
                        return;
                    }
                    na2Var.X.a.unlock();
                    qn qnVar3 = na2Var.X;
                    qnVar3.getClass();
                    qnVar3.g = new on(qnVar3);
                    qnVar3.e = 0;
                    qnVar3.d.clear();
                    qnVar3.i = null;
                    qnVar3.h = 0;
                    qn qnVar4 = na2Var.Y;
                    qnVar4.getClass();
                    qnVar4.g = new on(qnVar4);
                    qnVar4.e = 0;
                    qnVar4.d.clear();
                    qnVar4.i = null;
                    qnVar4.h = 0;
                    na2Var.e(na2Var.X, na2Var.Y);
                    return;
                } catch (InterruptedException e) {
                    zo2.o("Unable to wait for lock", e);
                    return;
                }
            }
            if ((v0Var instanceof lw4) && this.Z0) {
                lw4 lw4Var = new lw4(this, this.J1, this.t1, (lw4) this.D0, z);
                this.D0.J();
                this.D0 = lw4Var;
                return;
            }
            codeEditor = this;
            v0Var.J();
        }
        if (codeEditor.Z0) {
            codeEditor.i2.C = (int) codeEditor.S();
            codeEditor.D0 = new lw4(codeEditor, codeEditor.J1, codeEditor.t1, null, false);
        } else {
            codeEditor.D0 = new na2(codeEditor, codeEditor.J1);
        }
        d21 d21Var = codeEditor.S1;
        if (d21Var != null) {
            d21Var.k(0.0f, 0.0f, false);
        }
    }

    public final void h0(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            xe.k("margin can not be under zero");
            return;
        }
        this.L0 = f;
        this.M0 = f2;
        d0();
        invalidate();
    }

    public final void i() {
        if (this.I1.a()) {
            f(true);
            j();
            W();
            return;
        }
        lg0 cursor = getCursor();
        if (cursor.a()) {
            i();
            return;
        }
        q30 q30VarA = cursor.c.a();
        int i = q30VarA.b;
        int i2 = getText().o(q30VarA.b).f;
        int i3 = i + 1;
        if (i3 != getLineCount()) {
            k0(i, 0, i3, 0);
        } else {
            if (getText().o(i).f == 0) {
                f(false);
                return;
            }
            k0(i, 0, i, getText().o(i).f);
        }
        i();
        this.e2.getClass();
    }

    public final void i0(int i, int i2) {
        j0(i, i2, 0, true);
    }

    @Override // android.view.View
    public final boolean isHorizontalScrollBarEnabled() {
        return this.q1;
    }

    @Override // android.view.View
    public final boolean isVerticalScrollBarEnabled() {
        return this.p1;
    }

    public final void j() {
        boolean z;
        lg0 lg0Var = this.I1;
        if (lg0Var.a()) {
            ld0 ld0Var = this.J1;
            q30 q30Var = lg0Var.c;
            int i = q30Var.b;
            int i2 = q30Var.c;
            q30 q30Var2 = lg0Var.d;
            ld0Var.h(i, i2, q30Var2.b, q30Var2.c);
            return;
        }
        q30 q30Var3 = lg0Var.c;
        int i3 = q30Var3.c;
        int i4 = q30Var3.b;
        uu0 uu0Var = this.e2;
        uu0Var.getClass();
        char[] cArr = this.J1.o(lg0Var.c.b).b;
        int i5 = i3 - 1;
        while (true) {
            if (i5 >= 0) {
                char c = cArr[i5];
                if (c != ' ' && c != '\t') {
                    break;
                } else {
                    i5--;
                }
            } else {
                int i6 = this.J1.o(i4).f;
                int i7 = i3;
                while (true) {
                    if (i7 < i6) {
                        char c2 = cArr[i7];
                        if (c2 != ' ' && c2 != '\t') {
                            z = false;
                            break;
                        }
                        i7++;
                    } else {
                        z = true;
                        break;
                    }
                }
                uu0Var.getClass();
                if (z) {
                    ld0 ld0Var2 = this.J1;
                    if (i4 == 0) {
                        ld0Var2.h(i4, 0, i4, i3);
                        return;
                    } else {
                        int i8 = i4 - 1;
                        ld0Var2.h(i8, ld0Var2.o(i8).f, i4, i6);
                        return;
                    }
                }
            }
        }
        int iL = Build.VERSION.SDK_INT >= 28 ? ga5.l(i3, this.J1.o(lg0Var.c.b)) : ac4.a().b(i3, this.J1.o(lg0Var.c.b));
        q30 q30Var4 = lg0Var.c;
        int i9 = q30Var4.c;
        if (iL > i9) {
            i9 = iL;
            iL = i9;
        }
        if (iL != i9) {
            ld0 ld0Var3 = this.J1;
            int i10 = q30Var4.b;
            ld0Var3.h(i10, iL, i10, i9);
            return;
        }
        int i11 = q30Var4.b;
        if (i11 <= 0 || iL != 0) {
            return;
        }
        ld0 ld0Var4 = this.J1;
        int i12 = i11 - 1;
        ld0Var4.h(i12, ld0Var4.o(i12).f, lg0Var.c.b, 0);
    }

    public final void j0(int i, int i2, int i3, boolean z) {
        int i4;
        ((tm2) this.b2).d();
        if (i2 > 0 && Character.isHighSurrogate(this.J1.c(i, i2 - 1)) && (i4 = i2 + 1) <= this.J1.o(i).f) {
            i2 = i4;
        }
        lg0 lg0Var = this.I1;
        lg0Var.c = lg0Var.b.m(i, i2).a();
        lg0Var.d = lg0Var.b.m(i, i2).a();
        if (this.n1) {
            this.F0 = x();
        }
        p0();
        r0();
        if (this.Y0 && !this.S1.f() && this.i1 == 0) {
            ((tm2) this.b2).c();
            ((tm2) this.b2).e();
        }
        this.A0 = this.I1.d.a();
        this.h2.a();
        if (z) {
            p(i, i2);
        } else {
            invalidate();
        }
        X(i3);
    }

    public final void k0(int i, int i2, int i3, int i4) {
        l0(i, i2, i3, i4, 0, true);
    }

    public final void l0(int i, int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        requestFocus();
        int iL = getText().l(i, i2);
        int iL2 = getText().l(i3, i4);
        if (iL == iL2) {
            j0(i, i2, i5, z);
            return;
        }
        if (iL > iL2) {
            l0(i3, i4, i, i2, i5, z);
            StringBuilder sbA = fw.A(iL, iL2, "setSelectionRegion() error: start > end:start = ", " end = ", " lineLeft = ");
            sbA.append(i);
            sbA.append(" columnLeft = ");
            sbA.append(i2);
            sbA.append(" lineRight = ");
            sbA.append(i3);
            sbA.append(" columnRight = ");
            sbA.append(i4);
            a1.n("CodeEditor", sbA.toString());
            return;
        }
        int i8 = i2;
        int i9 = i4;
        ((tm2) this.b2).a();
        this.I1.getClass();
        if (i8 > 0) {
            if (Character.isHighSurrogate(this.J1.c(i, i8 - 1)) && (i7 = i8 + 1) <= this.J1.o(i).f) {
                i8 = i7;
            }
        }
        if (i9 > 0) {
            if (Character.isHighSurrogate(this.J1.c(i3, i9 - 1)) && (i6 = i9 + 1) <= this.J1.o(i3).f) {
                i9 = i6;
            }
        }
        lg0 lg0Var = this.I1;
        lg0Var.c = lg0Var.b.m(i, i8).a();
        lg0 lg0Var2 = this.I1;
        lg0Var2.d = lg0Var2.b.m(i3, i9).a();
        p0();
        r0();
        this.h2.a();
        if (!this.I1.c.a().equals(this.A0) && !this.I1.d.a().equals(this.A0)) {
            this.A0 = this.I1.d.a();
        }
        if (!z) {
            invalidate();
        } else if (i5 == 6) {
            p(i, i8);
            this.Q1 = 0L;
            p(i3, i9);
        } else {
            p(i3, i9);
        }
        X(i5);
    }

    public final void m(p60 p60Var) {
        this.C0.a(p60Var);
    }

    public final void m0(boolean z, boolean z2) {
        if (this.Z0 == z && this.t1 == z2) {
            return;
        }
        this.Z0 = z;
        this.t1 = z2;
        d0();
        h(true);
        if (!z) {
            this.h2.a();
        }
        invalidate();
    }

    public final void n0(Class cls, l61 l61Var) {
        this.C0.f(cls, l61Var);
    }

    public final void o(String str, boolean z) {
        lg0 cursor = getCursor();
        if (cursor.a()) {
            q30 q30VarA = cursor.c.a();
            q30 q30VarA2 = cursor.d.a().a();
            ld0 text = getText();
            int i = q30VarA.b;
            int i2 = q30VarA.c;
            int i3 = q30VarA2.b;
            int i4 = q30VarA2.c;
            text.u(false);
            try {
                ld0 ld0VarB = text.B(i, i2, i3, i4);
                text.F(false);
                i0(q30VarA2.b, q30VarA2.c);
                e(str + ((Object) ld0VarB), false);
                if (z) {
                    q30 q30VarA3 = cursor.d.a();
                    k0(q30VarA2.b, q30VarA2.c, q30VarA3.b, q30VarA3.c);
                }
            } catch (Throwable th) {
                text.F(false);
                throw th;
            }
        }
    }

    public final void o0() {
        ic4 ic4Var;
        CodeEditor codeEditor;
        int i;
        ld0 ld0Var = this.J1;
        jl4 jl4Var = ld0Var.z0;
        if (!jl4Var.f || (i = jl4Var.Y) <= 0 || jl4Var.Z) {
            ic4Var = null;
        } else {
            jl4Var.Z = true;
            dl4 dl4Var = (dl4) jl4Var.b.get(i - 1);
            dl4Var.l(ld0Var);
            jl4Var.Y--;
            jl4Var.Z = false;
            ic4Var = dl4Var.b;
        }
        if (ic4Var != null) {
            try {
                q30 q30Var = ic4Var.a;
                int i2 = q30Var.b;
                int i3 = q30Var.c;
                q30 q30Var2 = ic4Var.b;
                codeEditor = this;
                try {
                    codeEditor.l0(i2, i3, q30Var2.b, q30Var2.c, 1, true);
                } catch (IndexOutOfBoundsException unused) {
                }
            } catch (IndexOutOfBoundsException unused2) {
                codeEditor = this;
            }
        } else {
            codeEditor = this;
        }
        codeEditor.W();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.C0.a(new fq(this));
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        return isEnabled() && H();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.S1.j();
        this.c1 = false;
        this.b1 = false;
    }

    @Override // android.view.View
    public final void onCreateContextMenu(ContextMenu contextMenu) {
        super.onCreateContextMenu(contextMenu);
        PointF pointF = this.S1.F;
        if (pointF == null) {
            return;
        }
        long jY = y(pointF.x, pointF.y);
        this.C0.a(new ag0(this, contextMenu, this.J1.n().m((int) (jY >> 32), (int) (jY & 4294967295L))));
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!H() || !isEnabled()) {
            return null;
        }
        if (c()) {
            int i = this.H0;
            if (i == 0) {
                i = 131073;
            }
            editorInfo.inputType = i;
        } else {
            editorInfo.inputType = 0;
        }
        editorInfo.initialSelStart = getCursor() != null ? getCursor().c.a : 0;
        editorInfo.initialSelEnd = getCursor() != null ? getCursor().d.a : 0;
        h11 h11Var = this.B0;
        editorInfo.initialCapsMode = h11Var.getCursorCapsMode(0);
        this.e2.getClass();
        editorInfo.imeOptions = 301989888;
        this.C0.a(new fq(this));
        ld0 text = h11Var.a.getText();
        while (text.X > 0) {
            text.k();
        }
        w90 w90Var = h11Var.b;
        w90Var.b = -1;
        w90Var.a = -1;
        w90Var.c = false;
        h11Var.c = false;
        this.J1.X = 0;
        setExtracting(null);
        return h11Var;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.C0.a(new fq(this));
        qg0 qg0Var = this.d2;
        qg0Var.z = false;
        removeCallbacks(qg0Var);
    }

    @Override // android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        int action = dragEvent.getAction();
        if (action != 1) {
            d21 d21Var = this.S1;
            if (action != 2) {
                if (action != 3) {
                    if (action != 6) {
                        return super.onDragEvent(dragEvent);
                    }
                    d21Var.I = null;
                    postInvalidate();
                    return true;
                }
                q30 q30Var = d21Var.I;
                if (q30Var == null) {
                    return false;
                }
                d21Var.I = null;
                i0(q30Var.b, q30Var.c);
                String strO = tj4.o(dragEvent.getClipData());
                h11 h11Var = this.B0;
                if (h11Var != null) {
                    h11Var.commitText(strO, 1);
                    this.e2.getClass();
                    W();
                }
                requestFocus();
                postInvalidate();
                super.onDragEvent(dragEvent);
                return true;
            }
            long jY = y(dragEvent.getX(), dragEvent.getY());
            d21Var.I = getText().n().m((int) (jY >> 32), (int) (jY & 4294967295L));
            postInvalidate();
            d21Var.l(null, dragEvent.getX(), dragEvent.getY());
        }
        return true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        u11 u11Var = this.i2;
        u11Var.getClass();
        int iSave = canvas.save();
        canvas.translate(u11Var.p.getOffsetX(), u11Var.p.getOffsetY());
        u11Var.G = true;
        try {
            u11Var.s(canvas);
            u11Var.G = false;
            canvas.restoreToCount(iSave);
            if (!(this.v1 == this.d2.f && this.S1.b.b.isFinished()) && this.S1.d.b.isShowing()) {
                this.v1 = this.d2.f;
                nf2 nf2Var = this.S1.d;
                Objects.requireNonNull(nf2Var);
                b0(new d4(13, nf2Var));
            }
        } catch (Throwable th) {
            u11Var.G = false;
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        qg0 qg0Var = this.d2;
        if (z) {
            boolean z2 = qg0Var.X > 0;
            qg0Var.z = z2;
            if (z2) {
                b0(qg0Var);
            }
        } else {
            qg0Var.z = false;
            qg0Var.f = false;
            d21 d21Var = this.S1;
            if (d21Var.n()) {
                d21Var.p = 0L;
                d21Var.a.invalidate();
            }
            removeCallbacks(this.d2);
        }
        this.C0.a(new b11(this, z));
        invalidate();
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean zIsFromSource = motionEvent.isFromSource(8194);
        d21 d21Var = this.S1;
        if (zIsFromSource) {
            if (motionEvent.getAction() == 9) {
                this.b1 = true;
            } else if (motionEvent.getAction() == 10) {
                this.b1 = false;
            }
            if (motionEvent.getActionMasked() == 11 || motionEvent.getActionMasked() == 12) {
                this.c1 = motionEvent.getButtonState() != 0;
            }
            int action = motionEvent.getAction();
            if (action == 7 || action == 9 || action == 10) {
                d21Var.a(new l60(0), null, motionEvent);
                return true;
            }
        }
        if (motionEvent.getAction() == 8 && motionEvent.isFromSource(2)) {
            eg0 eg0Var = this.b;
            j82 j82Var = (j82) eg0Var.z;
            j82 j82Var2 = (j82) eg0Var.z;
            if (!j82Var.c) {
                float f = -motionEvent.getAxisValue(9);
                float f2 = -motionEvent.getAxisValue(10);
                float f3 = this.Q0;
                uu0 uu0Var = this.e2;
                uu0Var.getClass();
                float f4 = f2 * f3 * 1.2f;
                float f5 = f * f3 * 1.2f;
                if (j82Var2.a()) {
                    uu0Var.getClass();
                    f4 *= 5.0f;
                    f5 *= 5.0f;
                }
                if (j82Var2.b()) {
                    float f6 = f5;
                    f5 = f4;
                    f4 = f6;
                }
                d21Var.onScroll(motionEvent, motionEvent, f4, f5);
                return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        int scrollMaxY = getScrollMaxY();
        accessibilityEvent.setScrollable(scrollMaxY > 0);
        accessibilityEvent.setMaxScrollX(getScrollMaxX());
        accessibilityEvent.setMaxScrollY(scrollMaxY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x085f  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0885 A[Catch: Exception -> 0x089c, TRY_LEAVE, TryCatch #0 {Exception -> 0x089c, blocks: (B:414:0x086a, B:416:0x0885), top: B:474:0x086a }] */
    /* JADX WARN: Type inference failed for: r15v22, types: [boolean, int] */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Boolean boolValueOf;
        boolean z;
        String str;
        sr2[] sr2VarArr;
        int i2;
        int i3;
        EnterAction enterActionA;
        CompleteEnterAction completeEnterAction;
        int i4;
        String str2;
        int i5;
        fc4 fc4Var;
        RegExPattern regExPattern;
        Object obj;
        String strQ;
        Pair pair;
        boolean zOnKeyDown;
        boolean z2;
        char cCharAt;
        int deadChar;
        boolean z3;
        boolean z4;
        boolean z5;
        eg0 eg0Var = this.b;
        j82 j82Var = (j82) eg0Var.z;
        CodeEditor codeEditor = j82Var.a;
        Editable editable = j82Var.b;
        j82Var.onKeyDown(codeEditor, editable, keyEvent.getKeyCode(), keyEvent);
        j82Var.c = keyEvent.isCtrlPressed();
        CodeEditor codeEditor2 = (CodeEditor) eg0Var.f;
        k61 k61Var = codeEditor2.C0;
        i11 i11Var = new i11(codeEditor2, keyEvent, 2);
        keyEvent.isCtrlPressed();
        j82Var.b();
        j82Var.a();
        g82 g82Var = new g82(codeEditor2, keyEvent, 2);
        if ((k61Var.a(i11Var) & 2) != 0) {
            return i11Var.A(false);
        }
        boolean zB = j82Var.b();
        boolean zA = j82Var.a();
        boolean zIsCtrlPressed = keyEvent.isCtrlPressed();
        if (eg0Var.M(i, keyEvent) && (k61Var.a(g82Var) & 2) != 0) {
            return g82Var.A(false) || i11Var.A(false);
        }
        if (i == 122 || i == 123) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        } else {
            switch (i) {
            }
        }
        h11 h11Var = codeEditor2.B0;
        lg0 cursor = codeEditor2.getCursor();
        ld0 text = codeEditor2.getText();
        if (i != 4) {
            if (i == 61) {
                if (codeEditor2.H() && !zA && !zIsCtrlPressed) {
                    codeEditor2.getSnippetController().getClass();
                    if (zB) {
                        lg0 cursor2 = codeEditor2.getCursor();
                        ld0 text2 = codeEditor2.getText();
                        int tabWidth = codeEditor2.getTabWidth();
                        s82 editorLanguage = codeEditor2.getEditorLanguage();
                        int tabWidth2 = codeEditor2.getTabWidth();
                        int tabWidth3 = codeEditor2.getTabWidth();
                        editorLanguage.getClass();
                        String strO = yr2.o(tabWidth2, tabWidth3, false);
                        text2.b();
                        for (int i6 = cursor2.c.b; i6 <= cursor2.d.b; i6++) {
                            long jM = yr2.m(text2.q(i6));
                            int i7 = (int) (jM >> 32);
                            int i8 = (int) (jM & 4294967295L);
                            int i9 = (i8 * tabWidth) + i7;
                            if (i9 != 0) {
                                int i10 = i7 + i8;
                                int i11 = i9 % tabWidth;
                                if (i7 > 0 && i8 > 0) {
                                    if (i11 == 0) {
                                        i11 = tabWidth;
                                    }
                                    text2.x(i6, 0, w44.h0(Math.abs(i9 - i11) / tabWidth, strO), i6, i10);
                                } else if (i11 == 0) {
                                    text2.h(i6, i10 - (i8 > 0 ? 1 : tabWidth), i6, i10);
                                } else {
                                    text2.h(i6, i10 - i11, i6, i10);
                                }
                            }
                        }
                        text2.k();
                    } else {
                        codeEditor2.G();
                    }
                }
                boolValueOf = Boolean.valueOf(i11Var.A(true));
            } else if (i != 62) {
                String str3 = "";
                if (i == 66) {
                    boolean z6 = true;
                    lg0 cursor3 = codeEditor2.getCursor();
                    ld0 text3 = codeEditor2.getText();
                    if (codeEditor2.H()) {
                        String str4 = codeEditor2.getLineSeparator().b;
                        s82 editorLanguage2 = codeEditor2.getEditorLanguage();
                        if (zB && !zA && !zIsCtrlPressed) {
                            boolValueOf = Boolean.valueOf(eg0.W(codeEditor2, cursor3, text3, i11Var, g82Var));
                        } else if (!zIsCtrlPressed || zB) {
                            sr2[] sr2VarArrB = editorLanguage2.b();
                            if (sr2VarArrB == null || cursor3.a()) {
                                z = true;
                                codeEditor2.e(str4, true);
                            } else {
                                int length = sr2VarArrB.length;
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= length) {
                                        z = z6;
                                    } else {
                                        sr2 sr2Var = sr2VarArrB[i12];
                                        if (sr2Var != null) {
                                            q30 q30VarA = cursor3.c.a();
                                            codeEditor2.getStyles();
                                            gc4 gc4Var = (gc4) sr2Var;
                                            ud0 ud0VarO = text3.o(q30VarA.b);
                                            sr2VarArr = sr2VarArrB;
                                            i3 = i12;
                                            String string = ud0VarO.subSequence(0, (int) (yr2.B(ud0VarO, 0, ud0VarO.f) >> 32)).toString();
                                            cv2 cv2Var = gc4Var.a;
                                            try {
                                                if (cv2Var == null) {
                                                    i2 = length;
                                                } else {
                                                    String strQ2 = text3.q(q30VarA.b);
                                                    i2 = length;
                                                    String strSubstring = strQ2.substring(0, q30VarA.c);
                                                    String strSubstring2 = strQ2.substring(q30VarA.c);
                                                    int i13 = q30VarA.b;
                                                    try {
                                                        enterActionA = cv2Var.a(i13 > 1 ? text3.q(i13 - 1) : str3, strSubstring, strSubstring2);
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                        enterActionA = null;
                                                    }
                                                    if (enterActionA != null) {
                                                        EnterAction.IndentAction indentAction = enterActionA.indentAction;
                                                        String strConcat = enterActionA.appendText;
                                                        Integer num = enterActionA.removeText;
                                                        if (strConcat == null) {
                                                            strConcat = (indentAction == EnterAction.IndentAction.Indent || indentAction == EnterAction.IndentAction.IndentOutdent) ? "\t" : str3;
                                                        } else if (indentAction == EnterAction.IndentAction.Indent) {
                                                            strConcat = "\t".concat(strConcat);
                                                        }
                                                        if (num != null) {
                                                            string = string.substring(0, string.length() - num.intValue());
                                                        }
                                                        completeEnterAction = new CompleteEnterAction(indentAction, strConcat, num, string);
                                                    }
                                                    gc4Var.c = completeEnterAction;
                                                    gc4Var.d = null;
                                                    if (completeEnterAction != null) {
                                                        String strQ3 = text3.q(q30VarA.b);
                                                        String strSubstring3 = strQ3.substring(0, q30VarA.c);
                                                        String strSubstring4 = strQ3.substring(q30VarA.c);
                                                        ha1 ha1Var = gc4Var.b;
                                                        if (ha1Var == null) {
                                                            str = str3;
                                                            pair = null;
                                                        } else {
                                                            IndentationRules indentationRules = (IndentationRules) ha1Var.f;
                                                            String strR = vf2.r(strSubstring3.length(), strSubstring3);
                                                            int i14 = q30VarA.b;
                                                            int i15 = i14 + 1;
                                                            if (i15 <= 0) {
                                                                fc4Var = new fc4();
                                                                fc4Var.a = str3;
                                                                fc4Var.b = null;
                                                                str = str3;
                                                            } else if (i15 > 0) {
                                                                i5 = i14;
                                                                while (i5 >= 0) {
                                                                    if (i5 == i14) {
                                                                        strQ = strSubstring3;
                                                                        str2 = strQ;
                                                                    } else {
                                                                        strQ = text3.q(i5);
                                                                        str2 = strSubstring3;
                                                                    }
                                                                    RegExPattern regExPattern2 = indentationRules.unIndentedLinePattern;
                                                                    if ((regExPattern2 != null && regExPattern2.matchesFully(strQ)) || strQ.isEmpty()) {
                                                                        i5--;
                                                                        strSubstring3 = str2;
                                                                    } else if (i5 <= -1) {
                                                                        str = str3;
                                                                        fc4Var = null;
                                                                    } else {
                                                                        String strQ4 = i5 == i14 ? str2 : text3.q(i5);
                                                                        if (indentationRules.increaseIndentPattern.matchesFully(strQ4) || ((regExPattern = indentationRules.indentNextLinePattern) != null && regExPattern.matchesFully(strQ4))) {
                                                                            str = str3;
                                                                            fc4Var = new fc4(vf2.r(strQ4.length(), strQ4), EnterAction.IndentAction.Indent);
                                                                        } else {
                                                                            if (indentationRules.decreaseIndentPattern.matchesFully(strQ4)) {
                                                                                String strR2 = vf2.r(strQ4.length(), strQ4);
                                                                                obj = null;
                                                                                fc4Var = new fc4(strR2, null);
                                                                            } else {
                                                                                obj = null;
                                                                                if (i5 == 0) {
                                                                                    String strQ5 = i5 == i14 ? str2 : text3.q(i5);
                                                                                    fc4Var = new fc4(vf2.r(strQ5.length(), strQ5), null);
                                                                                } else {
                                                                                    int i16 = i5 - 1;
                                                                                    String strQ6 = i16 == i14 ? str2 : text3.q(i16);
                                                                                    ?? MatchesFully = indentationRules.increaseIndentPattern.matchesFully(strQ6);
                                                                                    str = str3;
                                                                                    int i17 = MatchesFully;
                                                                                    if (indentationRules.decreaseIndentPattern.matchesFully(strQ6)) {
                                                                                        i17 = MatchesFully + 2;
                                                                                    }
                                                                                    RegExPattern regExPattern3 = indentationRules.indentNextLinePattern;
                                                                                    int i18 = i17;
                                                                                    if (regExPattern3 != null) {
                                                                                        i18 = i17;
                                                                                        if (regExPattern3.matchesFully(strQ6)) {
                                                                                            i18 = i17 + 4;
                                                                                        }
                                                                                    }
                                                                                    RegExPattern regExPattern4 = indentationRules.unIndentedLinePattern;
                                                                                    int i19 = i18;
                                                                                    if (regExPattern4 != null) {
                                                                                        i19 = i18;
                                                                                        if (regExPattern4.matchesFully(strQ6)) {
                                                                                            i19 = i18 + 8;
                                                                                        }
                                                                                    }
                                                                                    if ((i19 & 3) == 0 && (i19 & 4) == 0 && i19 > 0) {
                                                                                        int i20 = i5 - 2;
                                                                                        while (true) {
                                                                                            if (i20 > 0) {
                                                                                                String strQ7 = i20 == i14 ? str2 : text3.q(i20);
                                                                                                RegExPattern regExPattern5 = indentationRules.indentNextLinePattern;
                                                                                                if (regExPattern5 != null && regExPattern5.matchesFully(strQ7)) {
                                                                                                    i20--;
                                                                                                }
                                                                                            } else {
                                                                                                i20 = 0;
                                                                                            }
                                                                                        }
                                                                                        int i21 = i20 + 1;
                                                                                        String strQ8 = i21 == i14 ? str2 : text3.q(i21);
                                                                                        obj = null;
                                                                                        fc4Var = new fc4(vf2.r(strQ8.length(), strQ8), null);
                                                                                    } else {
                                                                                        String strQ9 = i5 == i14 ? str2 : text3.q(i5);
                                                                                        fc4Var = new fc4(vf2.r(strQ9.length(), strQ9), null);
                                                                                    }
                                                                                }
                                                                            }
                                                                            str = str3;
                                                                        }
                                                                    }
                                                                }
                                                                str2 = strSubstring3;
                                                                i5 = -1;
                                                                if (i5 <= -1) {
                                                                }
                                                            } else {
                                                                str2 = strSubstring3;
                                                                i5 = -1;
                                                                if (i5 <= -1) {
                                                                }
                                                            }
                                                            if (fc4Var == null) {
                                                                pair = new Pair(strR, strR);
                                                            } else {
                                                                String strSubstring5 = fc4Var.a;
                                                                StringBuilder sb = new StringBuilder(4);
                                                                for (int i22 = 0; i22 < 4; i22++) {
                                                                    sb.append(" ");
                                                                }
                                                                String string2 = sb.toString();
                                                                if (fc4Var.b == EnterAction.IndentAction.Indent) {
                                                                    strSubstring5 = strR.concat(string2);
                                                                }
                                                                if (indentationRules.decreaseIndentPattern.matchesFully(strSubstring4)) {
                                                                    strSubstring5 = strR.substring(0, Math.max(Math.max(0, strR.length() - 1), strR.length() - string2.length()));
                                                                }
                                                                pair = new Pair(strR, strSubstring5);
                                                                gc4Var.d = pair;
                                                            }
                                                        }
                                                        gc4Var.d = pair;
                                                    } else {
                                                        str = str3;
                                                    }
                                                    if (gc4Var.c == null || gc4Var.d != null) {
                                                        cursor3.c.a();
                                                        codeEditor2.getStyles();
                                                        codeEditor2.getTabWidth();
                                                        u04 u04VarA = ((gc4) sr2Var).a();
                                                        codeEditor2.e(u04VarA.b, false);
                                                        i4 = u04VarA.c;
                                                        if (i4 != 0) {
                                                            q30 q30VarJ = cursor3.b.j(Math.max(cursor3.c.a - i4, 0));
                                                            codeEditor2.i0(q30VarJ.b, q30VarJ.c);
                                                        }
                                                        z = true;
                                                    }
                                                }
                                                cursor3.c.a();
                                                codeEditor2.getStyles();
                                                codeEditor2.getTabWidth();
                                                u04 u04VarA2 = ((gc4) sr2Var).a();
                                                codeEditor2.e(u04VarA2.b, false);
                                                i4 = u04VarA2.c;
                                                if (i4 != 0) {
                                                }
                                                z = true;
                                            } catch (Exception e2) {
                                                a1.o("EditorKeyEventHandler", "Error occurred while calling Language's NewlineHandler", e2);
                                                z = true;
                                                codeEditor2.e(str4, z);
                                            }
                                            completeEnterAction = null;
                                            gc4Var.c = completeEnterAction;
                                            gc4Var.d = null;
                                            if (completeEnterAction != null) {
                                            }
                                            if (gc4Var.c == null) {
                                            }
                                        } else {
                                            str = str3;
                                            sr2VarArr = sr2VarArrB;
                                            i2 = length;
                                            i3 = i12;
                                        }
                                        i12 = i3 + 1;
                                        sr2VarArrB = sr2VarArr;
                                        length = i2;
                                        str3 = str;
                                        z6 = true;
                                    }
                                }
                            }
                            codeEditor2.W();
                        } else if (zA) {
                            int i23 = cursor3.c.a().b;
                            if (i23 == 0) {
                                text3.r(0, 0, str4);
                                codeEditor2.i0(0, 0);
                                codeEditor2.r();
                                if (!g82Var.A(true) && !i11Var.A(true)) {
                                    z6 = false;
                                }
                                boolValueOf = Boolean.valueOf(z6);
                            } else {
                                int i24 = i23 - 1;
                                codeEditor2.i0(i24, text3.o(i24).f);
                                boolValueOf = Boolean.valueOf(eg0.W(codeEditor2, cursor3, text3, i11Var, g82Var));
                            }
                        } else {
                            q30 q30VarA2 = cursor3.c.a().a();
                            codeEditor2.e(str4, true);
                            codeEditor2.i0(q30VarA2.b, q30VarA2.c);
                            codeEditor2.r();
                            if (!g82Var.A(true) && !i11Var.A(true)) {
                                z6 = false;
                            }
                            boolValueOf = Boolean.valueOf(z6);
                        }
                    } else {
                        z = true;
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(z));
                } else if (i == 67) {
                    if (codeEditor2.H()) {
                        if (!codeEditor2.I1.a() && zIsCtrlPressed) {
                            codeEditor2.v(js3.Z);
                            if (codeEditor2.I1.a()) {
                                codeEditor2.j();
                            }
                        } else {
                            codeEditor2.j();
                        }
                        codeEditor2.W();
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 92) {
                    if (zIsCtrlPressed) {
                        codeEditor2.U(js3.B0, zB);
                    } else {
                        codeEditor2.U(js3.z0, zB);
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 93) {
                    if (zIsCtrlPressed) {
                        codeEditor2.U(js3.C0, zB);
                    } else {
                        codeEditor2.U(js3.A0, zB);
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 111) {
                    if (cursor.a()) {
                        codeEditor2.getProps().getClass();
                        q30 q30VarA3 = cursor.d.a();
                        codeEditor2.j0(q30VarA3.b, q30VarA3.c, 0, true);
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 112) {
                    if (codeEditor2.H()) {
                        if (codeEditor2.I1.a()) {
                            codeEditor2.j();
                        } else if (zIsCtrlPressed) {
                            codeEditor2.v(js3.y0);
                            if (codeEditor2.I1.a()) {
                                codeEditor2.j();
                            }
                        } else {
                            h11Var.deleteSurroundingText(0, 1);
                        }
                        codeEditor2.W();
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 122) {
                    if (zIsCtrlPressed) {
                        codeEditor2.U(js3.F0, zB);
                    } else {
                        codeEditor2.getProps().getClass();
                        codeEditor2.U(js3.H0, zB);
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 123) {
                    if (zIsCtrlPressed) {
                        codeEditor2.U(js3.G0, zB);
                    } else {
                        codeEditor2.getProps().getClass();
                        codeEditor2.U(js3.I0, zB);
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i == 278) {
                    codeEditor2.f(true);
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                } else if (i != 279) {
                    switch (i) {
                        case 19:
                            if (!zIsCtrlPressed) {
                                codeEditor2.U(js3.z, zB);
                                boolValueOf = Boolean.valueOf(i11Var.A(true));
                            } else if (zB) {
                                q30 q30VarA4 = cursor.c.a();
                                q30 q30VarA5 = cursor.d.a();
                                int i25 = q30VarA4.b;
                                if (i25 == 0) {
                                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                                } else {
                                    String string3 = text.o(i25 - 1).toString();
                                    text.b();
                                    int i26 = q30VarA4.b;
                                    text.h(i26 - 1, 0, i26, 0);
                                    int i27 = q30VarA5.b - 1;
                                    text.r(i27, text.o(i27).f, codeEditor2.getLineSeparator().b.concat(string3));
                                    text.k();
                                    q30 q30VarM = text.n().m(q30VarA4.b - 1, q30VarA4.c);
                                    q30 q30VarM2 = text.n().m(q30VarA5.b - 1, q30VarA5.c);
                                    if (q30VarA4.a != q30VarA5.a) {
                                        q30 q30Var = codeEditor2.A0;
                                        codeEditor2.k0(q30VarM.b, q30VarM.c, q30VarM2.b, q30VarM2.c);
                                        if (q30Var != null) {
                                            if (q30Var.equals(q30VarA4)) {
                                                codeEditor2.A0 = q30VarM;
                                            } else {
                                                codeEditor2.A0 = q30VarM2;
                                            }
                                        }
                                    } else {
                                        codeEditor2.i0(q30VarM.b, q30VarM.c);
                                    }
                                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                                }
                            } else {
                                codeEditor2.getEventHandler().k(0.0f, -codeEditor2.getRowHeight(), false);
                                boolValueOf = Boolean.valueOf(i11Var.A(true));
                            }
                            break;
                        case 20:
                            if (!zIsCtrlPressed) {
                                codeEditor2.U(js3.A, zB);
                                boolValueOf = Boolean.valueOf(i11Var.A(true));
                            } else if (zB) {
                                q30 q30VarA6 = cursor.c.a();
                                q30 q30VarA7 = cursor.d.a();
                                int size = text.b.size();
                                int i28 = q30VarA7.b;
                                if (i28 == size - 1) {
                                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                                } else {
                                    String string4 = text.o(i28 + 1).toString();
                                    text.b();
                                    int i29 = q30VarA7.b;
                                    text.h(i29, text.o(i29).f, q30VarA7.b + 1, string4.length());
                                    text.r(q30VarA6.b, 0, string4.concat(codeEditor2.getLineSeparator().b));
                                    text.k();
                                    q30 q30VarM3 = text.n().m(q30VarA6.b + 1, q30VarA6.c);
                                    q30 q30VarM4 = text.n().m(q30VarA7.b + 1, q30VarA7.c);
                                    if (q30VarA6.a != q30VarA7.a) {
                                        q30 q30Var2 = codeEditor2.A0;
                                        codeEditor2.k0(q30VarM3.b, q30VarM3.c, q30VarM4.b, q30VarM4.c);
                                        if (q30Var2 != null) {
                                            if (q30Var2.equals(q30VarA6)) {
                                                codeEditor2.A0 = q30VarM3;
                                            } else {
                                                codeEditor2.A0 = q30VarM4;
                                            }
                                        }
                                    } else {
                                        codeEditor2.i0(q30VarM3.b, q30VarM3.c);
                                    }
                                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                                }
                            } else {
                                codeEditor2.getEventHandler().k(0.0f, codeEditor2.getRowHeight(), false);
                                boolValueOf = Boolean.valueOf(i11Var.A(true));
                            }
                            break;
                        case 21:
                            if (zIsCtrlPressed) {
                                codeEditor2.U(js3.Z, zB);
                            } else {
                                codeEditor2.U(js3.X, zB);
                            }
                            boolValueOf = Boolean.valueOf(i11Var.A(true));
                            break;
                        case 22:
                            if (zIsCtrlPressed) {
                                codeEditor2.U(js3.y0, zB);
                            } else {
                                codeEditor2.U(js3.Y, zB);
                            }
                            boolValueOf = Boolean.valueOf(i11Var.A(true));
                            break;
                        default:
                            if (!keyEvent.isCtrlPressed() || keyEvent.isAltPressed()) {
                                ld0 text4 = codeEditor2.getText();
                                lg0 cursor4 = codeEditor2.getCursor();
                                int unicodeChar = keyEvent.getUnicodeChar(MetaKeyKeyListener.getMetaState(editable, keyEvent));
                                if (unicodeChar == 0 || !codeEditor2.H() || unicodeChar == 61184 || unicodeChar == 61185) {
                                    zOnKeyDown = super.onKeyDown(i, keyEvent);
                                } else {
                                    if ((Integer.MIN_VALUE & unicodeChar) != 0) {
                                        unicodeChar &= ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    int i30 = cursor4.c.a;
                                    if (i30 + 1 == cursor4.d.a && (deadChar = KeyCharacterMap.getDeadChar((cCharAt = text4.charAt(i30)), unicodeChar)) != cCharAt && keyEvent.getRepeatCount() == 0) {
                                        unicodeChar = deadChar;
                                        z2 = false;
                                    }
                                    if (z2) {
                                        lg0 cursor5 = codeEditor2.getCursor();
                                        if (codeEditor2.I1.a()) {
                                            int i31 = cursor4.c.a;
                                            if (i31 + 1 == cursor4.d.a && text4.charAt(i31) == unicodeChar) {
                                                q30 q30Var3 = cursor4.d;
                                                codeEditor2.j0(q30Var3.b, q30Var3.c, 9, true);
                                                codeEditor2.e(String.valueOf(Character.toChars(unicodeChar)), true);
                                                int iCharCount = Character.charCount(Character.codePointBefore(codeEditor2.getText().o(cursor5.d.b), cursor5.d.c));
                                                q30 q30Var4 = cursor5.d;
                                                int i32 = q30Var4.b;
                                                int i33 = q30Var4.c;
                                                codeEditor2.l0(i32, i33 - iCharCount, i32, i33, 9, true);
                                            }
                                        }
                                    } else {
                                        codeEditor2.e(new String(Character.toChars(unicodeChar)), true);
                                        codeEditor2.W();
                                    }
                                    zOnKeyDown = true;
                                }
                                if (zOnKeyDown) {
                                    MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
                                }
                                boolValueOf = Boolean.valueOf(i11Var.A(zOnKeyDown));
                            } else {
                                h11 h11Var2 = codeEditor2.B0;
                                ld0 text5 = codeEditor2.getText();
                                lg0 cursor6 = codeEditor2.getCursor();
                                if (i == 29) {
                                    z3 = true;
                                    codeEditor2.f0();
                                } else if (i == 38) {
                                    z3 = true;
                                    if (!zB || cursor6.a()) {
                                        z4 = false;
                                        if (!g82Var.A(z4) && !i11Var.A(z4)) {
                                            z3 = false;
                                        }
                                        boolValueOf = Boolean.valueOf(z3);
                                    } else {
                                        int i34 = cursor6.c.b;
                                        codeEditor2.i0(i34, text5.o(i34).f);
                                        h11Var2.deleteSurroundingText(0, 1);
                                        codeEditor2.r();
                                    }
                                    break;
                                } else if (i == 31) {
                                    z3 = true;
                                    codeEditor2.f(true);
                                } else if (i != 32) {
                                    switch (i) {
                                        case 50:
                                            if (codeEditor2.H()) {
                                                codeEditor2.Y();
                                            }
                                            z3 = true;
                                            break;
                                        case 51:
                                            q30 q30VarA8 = codeEditor2.getCursor().c.a();
                                            codeEditor2.g0(q30VarA8.b, q30VarA8.c);
                                            z3 = true;
                                            break;
                                        case 52:
                                            if (codeEditor2.H()) {
                                                codeEditor2.i();
                                                z3 = true;
                                            } else {
                                                z5 = true;
                                                codeEditor2.f(true);
                                                z3 = z5;
                                            }
                                            break;
                                        case 53:
                                            if (codeEditor2.H()) {
                                                codeEditor2.c0();
                                            }
                                            z3 = true;
                                            break;
                                        case 54:
                                            if (codeEditor2.H()) {
                                                codeEditor2.o0();
                                            }
                                            z3 = true;
                                            break;
                                        default:
                                            boolValueOf = null;
                                            break;
                                    }
                                } else if (codeEditor2.H()) {
                                    lg0 cursor7 = codeEditor2.getCursor();
                                    if (cursor7.a()) {
                                        z5 = true;
                                        codeEditor2.o("", true);
                                        z3 = z5;
                                    } else {
                                        q30 q30VarA9 = cursor7.c.a();
                                        int i35 = q30VarA9.b;
                                        z3 = true;
                                        codeEditor2.l0(i35, 0, i35, codeEditor2.getText().o(q30VarA9.b).f, 0, true);
                                        codeEditor2.o("\n", false);
                                    }
                                } else {
                                    z3 = true;
                                }
                                z4 = z3;
                                if (!g82Var.A(z4)) {
                                    z3 = false;
                                }
                                boolValueOf = Boolean.valueOf(z3);
                            }
                            break;
                    }
                } else {
                    if (codeEditor2.H()) {
                        codeEditor2.Y();
                    }
                    boolValueOf = Boolean.valueOf(i11Var.A(true));
                }
            } else {
                if (codeEditor2.H()) {
                    codeEditor2.e(" ", true);
                    codeEditor2.W();
                }
                boolValueOf = Boolean.valueOf(i11Var.A(true));
            }
        } else if (cursor.a()) {
            q30 q30Var5 = cursor.c;
            codeEditor2.i0(q30Var5.b, q30Var5.c);
            boolValueOf = Boolean.valueOf(i11Var.A(true));
        } else if (codeEditor2.y1) {
            codeEditor2.y1 = false;
            boolValueOf = Boolean.valueOf(i11Var.A(true));
        } else {
            boolValueOf = Boolean.valueOf(i11Var.A(false));
        }
        return boolValueOf != null ? i11Var.A(boolValueOf.booleanValue()) : i11Var.A(super.onKeyDown(i, keyEvent));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        CodeEditor codeEditor = (CodeEditor) this.b.f;
        i11 i11Var = new i11(codeEditor, keyEvent, 3);
        return (codeEditor.C0.a(i11Var) & 2) != 0 ? i11Var.A(false) : i11Var.A(super.onKeyMultiple(i, i2, keyEvent));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        eg0 eg0Var = this.b;
        j82 j82Var = (j82) eg0Var.z;
        j82Var.onKeyUp(j82Var.a, j82Var.b, keyEvent.getKeyCode(), keyEvent);
        j82Var.c = keyEvent.isCtrlPressed();
        CodeEditor codeEditor = (CodeEditor) eg0Var.f;
        k61 k61Var = codeEditor.C0;
        codeEditor.getCursor();
        i11 i11Var = new i11(codeEditor, keyEvent, 1);
        if ((k61Var.a(i11Var) & 2) != 0) {
            return i11Var.A(false);
        }
        if (eg0Var.M(i, keyEvent)) {
            keyEvent.isCtrlPressed();
            j82Var.b();
            j82Var.a();
            g82 g82Var = new g82(codeEditor, keyEvent, 1);
            if ((k61Var.a(g82Var) & 2) != 0) {
                return g82Var.A(false) || i11Var.A(false);
            }
        }
        return i11Var.A(super.onKeyUp(i, keyEvent));
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        boolean z;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int i3;
        int i4;
        int iMakeMeasureSpec3;
        int i5;
        int i6 = 0;
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            this.z1 = false;
            i3 = i;
            i4 = i2;
        } else {
            a1.n("CodeEditor", "use wrap_content in editor may cause layout lags");
            float fT = T();
            float rowHeight = getRowHeight();
            boolean z2 = this.Z0;
            int i7 = this.E0;
            ld0 ld0Var = this.J1;
            final c03 c03Var = this.i2.b;
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = mode == 0 ? 1073741823 : View.MeasureSpec.getSize(i);
            int size2 = mode2 != 0 ? View.MeasureSpec.getSize(i2) : 1073741823;
            final jr2 jr2Var = new jr2(i7);
            boolean z3 = true;
            if (z2) {
                if (mode != 1073741824) {
                    int[] iArr = mode2 != 1073741824 ? new int[ld0Var.b.size()] : null;
                    ld0Var.z(ld0Var.b.size() - 1, new l84(jr2Var, c03Var, new ln2(0), iArr));
                    int iMin = (int) Math.min(size, r9.a + fT);
                    int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(iMin, Pow2.MAX_POW2);
                    if (iArr != null) {
                        int i8 = (int) (iMin - fT);
                        if (i8 <= 0) {
                            i5 = ld0Var.A;
                        } else {
                            int iMax = 0;
                            while (i6 < iArr.length) {
                                iMax = (int) (Math.max(1.0d, Math.ceil((((double) iArr[i6]) * 1.0d) / ((double) i8))) + ((double) iMax));
                                i6++;
                                z3 = z3;
                            }
                            i5 = iMax;
                        }
                        z = z3;
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(Math.min((int) (rowHeight * i5), size2), Pow2.MAX_POW2);
                    } else {
                        z = true;
                        iMakeMeasureSpec3 = i2;
                    }
                    iMakeMeasureSpec2 = iMakeMeasureSpec3;
                    iMakeMeasureSpec = iMakeMeasureSpec4;
                } else {
                    z = true;
                    if (mode2 != 1073741824) {
                        final ln2 ln2Var = new ln2(0);
                        final int i9 = (int) (size - fT);
                        if (i9 <= 0) {
                            ln2Var.a = ld0Var.A;
                        } else {
                            ld0Var.z(ld0Var.b.size() - 1, new kd0() { // from class: hq4
                                @Override // defpackage.kd0
                                public final void c(int i10, ud0 ud0Var, bv0 bv0Var) {
                                    char[] cArr = ud0Var.b;
                                    int i11 = ud0Var.f;
                                    int iCeil = (int) Math.ceil(jr2Var.b(new o30(cArr, cArr.length), 0, i11, c03Var));
                                    ln2 ln2Var2 = ln2Var;
                                    ln2Var2.a = (int) (Math.max(1.0d, Math.ceil((((double) iCeil) * 1.0d) / ((double) i9))) + ((double) ln2Var2.a));
                                }
                            });
                        }
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min((int) (rowHeight * ln2Var.a), size2), Pow2.MAX_POW2);
                        iMakeMeasureSpec = i;
                    } else {
                        iMakeMeasureSpec = i;
                    }
                }
                long jM = ez4.M(iMakeMeasureSpec, iMakeMeasureSpec2);
                i3 = (int) (jM >> 32);
                i4 = (int) (jM & 4294967295L);
                this.z1 = z;
            } else {
                z = true;
                if (mode != 1073741824) {
                    ld0Var.z(ld0Var.b.size() - 1, new m10(8, jr2Var, c03Var, new ln2(0)));
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) Math.min(r5.a + fT, size), Pow2.MAX_POW2);
                } else {
                    iMakeMeasureSpec = i;
                }
                iMakeMeasureSpec2 = mode2 != 1073741824 ? View.MeasureSpec.makeMeasureSpec(Math.min(size2, (int) (rowHeight * ld0Var.b.size())), Pow2.MAX_POW2) : i2;
                long jM2 = ez4.M(iMakeMeasureSpec, iMakeMeasureSpec2);
                i3 = (int) (jM2 >> 32);
                i4 = (int) (jM2 & 4294967295L);
                this.z1 = z;
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (Build.VERSION.SDK_INT < 24 || !motionEvent.isFromSource(8194)) {
            return super.onResolvePointerIcon(motionEvent, i);
        }
        K();
        if (this.e1) {
            return PointerIcon.getSystemIcon(getContext(), 1004);
        }
        if (this.S1.f()) {
            return PointerIcon.getSystemIcon(getContext(), 1021);
        }
        if (getLeftHandleDescriptor().a.contains(motionEvent.getX(), motionEvent.getY()) || getRightHandleDescriptor().a.contains(motionEvent.getX(), motionEvent.getY()) || getInsertHandleDescriptor().a.contains(motionEvent.getX(), motionEvent.getY())) {
            return PointerIcon.getSystemIcon(getContext(), 1020);
        }
        long J = xb5.J(this, motionEvent, i);
        int i2 = (int) (J >> 32);
        boolean z = ((int) (J & 4294967295L)) == 0;
        if (i2 != 5 || !z) {
            if (i2 != 1) {
                return super.onResolvePointerIcon(motionEvent, i);
            }
            this.e2.getClass();
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        d21 d21Var = this.S1;
        if (d21Var.H && !d21Var.G) {
            return PointerIcon.getSystemIcon(getContext(), 1021);
        }
        this.i2.getClass();
        return PointerIcon.getSystemIcon(getContext(), 1008);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = this.i2.d;
        rect.right = i;
        rect.bottom = i2;
        getVerticalEdgeEffect().setSize(i, i2);
        getHorizontalEdgeEffect().setSize(i2, i);
        getVerticalEdgeEffect().finish();
        getHorizontalEdgeEffect().finish();
        if (this.D0 == null || (this.Z0 && i != i3)) {
            h(true);
        } else {
            this.S1.k(getOffsetX() > getScrollMaxX() ? getScrollMaxX() - getOffsetX() : 0.0f, getOffsetY() > getScrollMaxY() ? getScrollMaxY() - getOffsetY() : 0.0f, false);
        }
        this.m2 = false;
        this.n2 = false;
        if (i4 > i2) {
            this.e2.getClass();
            r();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            boolean zIsFromSource = motionEvent.isFromSource(8194);
            d21 d21Var = this.S1;
            if (zIsFromSource) {
                this.e2.getClass();
                return d21Var.h(motionEvent);
            }
            K();
            boolean z = d21Var.r || d21Var.q || d21Var.f();
            boolean zI = d21Var.i(motionEvent);
            boolean z2 = d21Var.r || d21Var.q || d21Var.f();
            boolean zOnTouchEvent = this.V1.onTouchEvent(motionEvent);
            boolean zOnTouchEvent2 = (z2 || z) ? false : this.U1.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1) {
                this.X1.onRelease();
                this.Y1.onRelease();
            }
            if (zOnTouchEvent || zOnTouchEvent2 || zI) {
                return true;
            }
        }
        return false;
    }

    public final void p(int i, int i2) {
        float width;
        v11 scroller = getScroller();
        float[] fArrB = this.D0.b(i, i2);
        float fT = T() + fArrB[1];
        float f = fArrB[0];
        OverScroller overScroller = scroller.b;
        OverScroller overScroller2 = scroller.b;
        float offsetY = overScroller.isFinished() ? getOffsetY() : overScroller.getFinalY();
        float offsetX = overScroller.isFinished() ? getOffsetX() : overScroller.getFinalX();
        uu0 uu0Var = this.e2;
        uu0Var.getClass();
        float rowHeight = f - ((float) (getRowHeight() * 2)) < offsetY ? f - (getRowHeight() * 2) : offsetY;
        if (f > getHeight() + offsetY) {
            rowHeight = (getRowHeight() * 1.0f) + (f - getHeight());
        }
        float fMeasureText = i2 == 0 ? 0.0f : getTextPaint().measureText("a");
        if (fT < (this.s1 ? T() : 0.0f) + offsetX) {
            int width2 = getWidth() / 2;
            width = ((this.s1 ? -T() : 0.0f) + fT) - fMeasureText;
            float f2 = width2;
            if (Math.abs(width - offsetX) < f2) {
                width = Math.max(1.0f, offsetX - f2);
            }
        } else {
            width = offsetX;
        }
        if (fT + fMeasureText > offsetX + getWidth()) {
            width = ((fMeasureText * 0.8f) + fT) - getWidth();
        }
        float fMax = Math.max(0.0f, Math.min(getScrollMaxX(), width));
        float fMax2 = Math.max(0.0f, Math.min(getScrollMaxY(), rowHeight));
        if (Math.abs(fMax - getOffsetX()) < Math.abs(1.0f) && Math.abs(fMax2 - getOffsetY()) < Math.abs(1.0f)) {
            invalidate();
            return;
        }
        boolean z = System.currentTimeMillis() - this.Q1 >= 100;
        this.Q1 = System.currentTimeMillis();
        if (z) {
            overScroller2.forceFinished(true);
            scroller.a();
            scroller.a.getProps().getClass();
            scroller.b(getOffsetX(), getOffsetY(), (int) (fMax - getOffsetX()), (int) (fMax2 - getOffsetY()), 250);
            uu0Var.getClass();
        } else {
            scroller.b(getOffsetX(), getOffsetY(), (int) (fMax - getOffsetX()), (int) (fMax2 - getOffsetY()), 0);
            overScroller2.abortAnimation();
            scroller.a();
        }
        m(new oq3(this, getOffsetX(), getOffsetY(), (int) fMax, (int) fMax2, 3));
        invalidate();
    }

    public final void p0() {
        q0();
        ExtractedTextRequest extractedTextRequest = this.Z1;
        if (extractedTextRequest != null) {
            ExtractedText extractedTextW = w(extractedTextRequest);
            this.H1.updateExtractedText(this, this.Z1.token, extractedTextW);
        }
        if (this.J1.X > 1 || this.B0.b.a()) {
            return;
        }
        r0();
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i == 4096) {
            V(js3.z0);
            return true;
        }
        if (i == 8192) {
            V(js3.A0);
            return true;
        }
        if (i == 16384) {
            f(true);
            return true;
        }
        if (i == 32768) {
            Y();
            return true;
        }
        if (i == 65536) {
            i();
            return true;
        }
        if (i == 2097152) {
            setText(bundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"));
            return true;
        }
        if (i == 16908344) {
            V(js3.A0);
            return true;
        }
        if (i != 16908346) {
            return super.performAccessibilityAction(i, bundle);
        }
        V(js3.z0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() {
        q30 q30Var = this.A0;
        if (q30Var != null) {
            ld0 ld0Var = this.J1;
            int i = q30Var.b;
            int i2 = q30Var.c;
            int i3 = q30Var.a;
            boolean z = false;
            ld0Var.u(false);
            if (i >= 0) {
                try {
                    if (i < ld0Var.b.size()) {
                        ud0 ud0VarO = ld0Var.o(i);
                        if (i2 <= ud0VarO.f + ud0VarO.d().f && i2 >= 0) {
                            boolean z2 = ld0Var.n().m(i, i2).a == i3;
                            ld0Var.F(false);
                            z = z2;
                        }
                        if (z) {
                            return;
                        }
                    }
                    if (z) {
                    }
                } finally {
                    ld0Var.F(false);
                }
            } else if (z) {
            }
        }
        this.A0 = this.I1.d.a();
    }

    public final float q0() {
        float f;
        boolean z;
        q30 q30Var = this.I1.d;
        float fT = (T() + this.D0.b(q30Var.b, q30Var.c)[1]) - getOffsetX();
        if (fT < 0.0f) {
            f = 0.0f;
            z = false;
        } else {
            f = fT;
            z = true;
        }
        w90 w90Var = this.B0.b;
        if (w90Var.c) {
            return f;
        }
        this.e2.getClass();
        CursorAnchorInfo.Builder builder = this.W1;
        builder.reset();
        Matrix matrix = getMatrix();
        Matrix matrix2 = this.K1;
        matrix2.set(matrix);
        getLocationOnScreen(new int[2]);
        matrix2.postTranslate(r9[0], r9[1]);
        builder.setMatrix(matrix2);
        lg0 lg0Var = this.I1;
        builder.setSelectionRange(lg0Var.c.a, lg0Var.d.a);
        if (w90Var.a()) {
            int i = w90Var.a;
            builder.setComposingText(i, this.J1.D(i, w90Var.b));
        }
        builder.setInsertionMarkerLocation(f, (getRowHeight() * r1) - getOffsetY(), z(r1) - getOffsetY(), A(r1) - getOffsetY(), z ? 1 : 2);
        this.H1.updateCursorAnchorInfo(this, builder.build());
        return f;
    }

    public final void r() {
        p(getCursor().d.b, getCursor().d.c);
    }

    public final void r0() {
        int i;
        int i2;
        int i3;
        this.e2.getClass();
        h11 h11Var = this.B0;
        w90 w90Var = h11Var.b;
        if (w90Var.c) {
            return;
        }
        int i4 = -1;
        if (w90Var.a()) {
            try {
                w90 w90Var2 = h11Var.b;
                i = w90Var2.a;
                try {
                    i4 = w90Var2.b;
                } catch (IndexOutOfBoundsException unused) {
                }
            } catch (IndexOutOfBoundsException unused2) {
                i = -1;
            }
            i2 = i;
            i3 = i4;
        } else {
            i2 = -1;
            i3 = -1;
        }
        lg0 lg0Var = this.I1;
        this.H1.updateSelection(this, lg0Var.c.a, lg0Var.d.a, i2, i3);
    }

    @Override // android.view.View
    public final boolean removeCallbacks(Runnable runnable) {
        d11.a.removeCallbacks(runnable);
        return super.removeCallbacks(runnable);
    }

    public void setBlockLineEnabled(boolean z) {
        this.l1 = z;
        invalidate();
    }

    public void setBlockLineWidth(float f) {
        this.O0 = f;
        invalidate();
    }

    public void setColorScheme(u01 u01Var) {
        u01 u01Var2 = this.L1;
        if (u01Var2 != null) {
            u01Var2.d(this);
        }
        this.L1 = u01Var;
        u01Var.c(this);
        invalidate();
    }

    public void setCursorAnimationEnabled(boolean z) {
        if (!z) {
            ((tm2) this.b2).a();
        }
        this.r1 = z;
    }

    public void setCursorAnimator(pg0 pg0Var) {
        this.b2 = pg0Var;
    }

    public void setCursorBlinkPeriod(int i) {
        qg0 qg0Var = this.d2;
        if (qg0Var == null) {
            this.d2 = new qg0(this, i);
            return;
        }
        int i2 = qg0Var.X;
        qg0Var.X = i;
        boolean z = true;
        if (i <= 0) {
            qg0Var.f = true;
            z = false;
            qg0Var.z = false;
        } else {
            qg0Var.z = true;
        }
        if (i2 <= 0 && z && isAttachedToWindow()) {
            b0(this.d2);
        }
    }

    public void setCursorWidth(float f) {
        if (f < 0.0f) {
            xe.k("width can not be under zero");
        } else {
            this.N0 = f;
            invalidate();
        }
    }

    public void setDiagnosticIndicatorStyle(au0 au0Var) {
        this.P1 = au0Var;
        invalidate();
    }

    public void setDiagnostics(bu0 bu0Var) {
        invalidate();
    }

    public void setDisableSoftKbdIfHardKbdAvailable(boolean z) {
        if (this.C1 == z) {
            return;
        }
        this.C1 = z;
        this.H1.hideSoftInputFromWindow(getWindowToken(), 0);
        e0();
    }

    public void setDisplayLnPanel(boolean z) {
        this.f1 = z;
        invalidate();
    }

    public void setDividerMargin(float f) {
        h0(f, f);
    }

    public void setDividerWidth(float f) {
        if (f < 0.0f) {
            xe.k("width can not be under zero");
            return;
        }
        this.K0 = f;
        d0();
        invalidate();
    }

    public void setEdgeEffectColor(int i) {
        this.X1.setColor(i);
        this.Y1.setColor(i);
    }

    public void setEditable(boolean z) {
        this.Y0 = z;
        if (z) {
            return;
        }
        this.H1.hideSoftInputFromWindow(getWindowToken(), 0);
        this.p2.getClass();
    }

    public void setEditorLanguage(s82 s82Var) {
        if (s82Var == null) {
            s82Var = new f41();
        }
        s82 s82Var2 = this.O1;
        if (s82Var2 != null) {
            s82Var2.c().a = null;
            s82Var2.c().i();
        }
        ed4 ed4Var = this.z0;
        ed4Var.z = null;
        ed4Var.A = null;
        this.O1 = s82Var;
        this.g2 = null;
        m0 m0VarC = s82Var.c();
        m0VarC.a = ed4Var;
        ld0 ld0Var = this.J1;
        if (ld0Var != null) {
            m0VarC.t(new wd0(ld0Var), this.f2);
        }
        n02 n02Var = this.f;
        if (n02Var != null) {
            n02Var.A = null;
        }
        n02 n02VarD = this.O1.d();
        this.f = n02VarD;
        if (n02VarD == null) {
            a1.n("CodeEditor", "Language(" + this.O1.toString() + ") returned null for symbol pairs. It is a mistake.");
            n02VarD = new n02((e84) null);
            this.f = n02VarD;
        }
        n02VarD.A = this.e2.b;
        this.h2.a();
        invalidate();
    }

    public void setExtracting(ExtractedTextRequest extractedTextRequest) {
        getProps().getClass();
        this.Z1 = extractedTextRequest;
    }

    public void setFirstLineNumberAlwaysVisible(boolean z) {
        this.u1 = z;
        if (this.Z0) {
            invalidate();
        }
    }

    public void setFontFeatureSettings(String str) {
        u11 u11Var = this.i2;
        c03 c03Var = u11Var.b;
        c03Var.setFontFeatureSettings(str);
        c03Var.b();
        u11Var.c.setFontFeatureSettings(str);
        u11Var.g.setFontFeatureSettings(str);
        u11Var.G();
        invalidate();
    }

    public void setFormatTip(String str) {
        Objects.requireNonNull(str);
        this.N1 = str;
    }

    public void setHardwareAcceleratedDrawAllowed(boolean z) {
        this.j2 = z;
        if (!z || this.Z0) {
            return;
        }
        this.h2.a();
    }

    public void setHighlightBracketPair(boolean z) {
        this.x1 = z;
        ed4 ed4Var = this.z0;
        if (z) {
            ed4Var.getClass();
            ed4Var.V(new d4(28, ed4Var));
        } else {
            ed4Var.z = null;
        }
        invalidate();
    }

    public void setHighlightCurrentBlock(boolean z) {
        this.n1 = z;
        if (z) {
            this.F0 = x();
        } else {
            this.F0 = -1;
        }
        invalidate();
    }

    public void setHighlightCurrentLine(boolean z) {
        this.o1 = z;
        invalidate();
    }

    public void setHighlightTexts(is1 is1Var) {
        new nn2();
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        this.q1 = z;
    }

    @Override // android.view.View
    public void setHorizontalScrollbarThumbDrawable(Drawable drawable) {
        this.i2.s = drawable;
    }

    @Override // android.view.View
    public void setHorizontalScrollbarTrackDrawable(Drawable drawable) {
        this.i2.t = drawable;
    }

    public void setInlayHints(g02 g02Var) {
        oj1 oj1Var = new oj1(new nn2());
        if (this.e1) {
            h(true);
        } else {
            this.D0.R(oj1Var);
        }
        this.h2.a();
    }

    public void setInputType(int i) {
        this.H0 = i;
        e0();
    }

    public void setInterceptParentHorizontalScrollIfNeeded(boolean z) {
        ViewParent parent;
        this.m1 = z;
        if (z || (parent = getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(false);
    }

    public void setLayoutBusy(boolean z) {
        if (!this.e1 || z) {
            if (this.e1 == z) {
                return;
            }
            this.e1 = z;
            this.C0.a(new fq(this));
            return;
        }
        if (this.Z0) {
            d21 d21Var = this.S1;
            if (d21Var.Q) {
                d21Var.Q = false;
                long j = d21Var.P;
                float rowHeight = getRowHeight() * ((lw4) this.D0).h((int) (j >> 32), (int) (j & 4294967295L));
                d21 d21Var2 = this.S1;
                float f = rowHeight - d21Var2.R;
                v11 v11Var = d21Var2.b;
                int i = (int) f;
                this.C0.a(new oq3(this, v11Var.b.getCurrX(), v11Var.b.getCurrY(), 0, i, 5));
                v11Var.b(0, i, 0, 0, 0);
                v11Var.b.abortAnimation();
                v11Var.a();
            }
        }
        this.e1 = false;
        e0();
        postInvalidate();
        this.C0.a(new fq(this));
    }

    public void setLigatureEnabled(boolean z) {
        setFontFeatureSettings(z ? null : "'liga' 0,'calt' 0,'hlig' 0,'dlig' 0,'clig' 0");
    }

    public void setLineInfoTextSize(float f) {
        if (f > 0.0f) {
            this.R0 = f;
        } else {
            s53.d();
        }
    }

    public void setLineNumberAlign(Paint.Align align) {
        if (align == null) {
            align = Paint.Align.LEFT;
        }
        this.T1 = align;
        invalidate();
    }

    public void setLineNumberEnabled(boolean z) {
        if (z != this.k1 && this.Z0) {
            h(true);
        }
        this.k1 = z;
        invalidate();
    }

    public void setLineNumberMarginLeft(float f) {
        this.U0 = f;
        d0();
        invalidate();
    }

    public void setLineNumberTipTextProvider(oa2 oa2Var) {
        Objects.requireNonNull(oa2Var, "Provider can not be null");
        this.M1 = oa2Var;
        invalidate();
    }

    public void setLineSeparator(pa2 pa2Var) {
        Objects.requireNonNull(pa2Var);
        if (pa2Var != pa2.NONE) {
            this.o2 = pa2Var;
        } else {
            s53.d();
        }
    }

    public void setLineSpacingExtra(float f) {
        this.T0 = f;
        invalidate();
    }

    public void setLineSpacingMultiplier(float f) {
        this.S0 = f;
        invalidate();
    }

    public void setLnPanelPosition(int i) {
        this.g1 = i;
        invalidate();
    }

    public void setLnPanelPositionMode(int i) {
        this.h1 = i;
        invalidate();
    }

    public void setNonPrintablePaintingFlags(int i) {
        int i2 = this.I0;
        this.I0 = i;
        if ((i2 & 128) != (i & 128)) {
            h(true);
        }
        invalidate();
    }

    public void setPinLineNumber(boolean z) {
        this.s1 = z;
        if (this.k1) {
            invalidate();
        }
    }

    public void setRenderFunctionCharacters(boolean z) {
        if (this.A1 != z) {
            this.A1 = z;
            this.i2.C();
            d0();
            h(true);
            invalidate();
        }
    }

    public void setScalable(boolean z) {
        this.X0 = z;
    }

    public void setScrollBarEnabled(boolean z) {
        this.q1 = z;
        this.p1 = z;
        invalidate();
    }

    public void setSelectionHandleStyle(hs3 hs3Var) {
        Objects.requireNonNull(hs3Var);
        this.c2 = hs3Var;
        invalidate();
    }

    public void setSoftKeyboardEnabled(boolean z) {
        if (this.B1 == z) {
            return;
        }
        this.B1 = z;
        this.H1.hideSoftInputFromWindow(getWindowToken(), 0);
        e0();
    }

    public void setStickyTextSelection(boolean z) {
        this.w1 = z;
    }

    public void setStyles(a54 a54Var) {
        this.g2 = a54Var;
        if (this.n1) {
            this.F0 = x();
        }
        this.h2.a();
        this.i2.G();
        invalidate();
    }

    public void setTabWidth(int i) {
        if (i < 1) {
            xe.k("width can not be under 1");
            return;
        }
        this.E0 = i;
        this.h2.a();
        this.i2.G();
        d0();
        invalidate();
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        ld0 ld0Var = this.J1;
        if (ld0Var != null) {
            ld0Var.f.remove(this);
            this.J1.X = 0;
        }
        this.f2 = new Bundle();
        boolean z = charSequence instanceof ld0;
        u11 u11Var = this.i2;
        if (z) {
            ld0 ld0Var2 = (ld0) charSequence;
            this.J1 = ld0Var2;
            ld0Var2.X = 0;
            u11Var.G();
        } else {
            this.J1 = new ld0(charSequence, true);
        }
        ed4 ed4Var = this.z0;
        ed4Var.z = null;
        ed4Var.A = null;
        this.g2 = null;
        lg0 lg0VarM = this.J1.m();
        this.I1 = lg0VarM;
        this.A0 = lg0VarM.d.a();
        d21 d21Var = this.S1;
        d21Var.b.b(0, 0, 0, 0, 0);
        d21Var.q = false;
        d21Var.r = false;
        d21Var.e = -1;
        d21Var.d();
        d21Var.d.a();
        this.J1.a(this);
        this.J1.A(this.a1);
        ld0 ld0Var3 = this.J1;
        ld0Var3.y0.f = true;
        int size = ld0Var3.b.size();
        ri3 ri3Var = this.h2;
        v62 v62Var = ri3Var.a;
        mn2 mn2Var = (mn2) v62Var.f;
        int i = mn2Var.b;
        if (i > size) {
            mn2Var.c(size, i);
        } else if (i < size) {
            int i2 = size - i;
            for (int i3 = 0; i3 < i2; i3++) {
                mn2Var.a(mn2Var.b + 1);
                int[] iArr = mn2Var.a;
                int i4 = mn2Var.b;
                iArr[i4] = 0;
                mn2Var.b = i4 + 1;
            }
        }
        Iterator it = gb4.d0(0, mn2Var.b).iterator();
        while (((a12) it).z) {
            int iNextInt = ((a12) it).nextInt();
            if (iNextInt < 0 || iNextInt >= mn2Var.b) {
                s53.k("Index must be between 0 and size");
                return;
            } else {
                int[] iArr2 = mn2Var.a;
                int i5 = iArr2[iNextInt];
                iArr2[iNextInt] = 0;
            }
        }
        ((ArrayList) v62Var.z).clear();
        CodeEditor codeEditor = u11Var.p;
        u11Var.D = codeEditor.getCursor();
        u11Var.F = codeEditor.getText();
        s82 s82Var = this.O1;
        if (s82Var != null) {
            s82Var.c().t(new wd0(this.J1), this.f2);
            this.O1.getClass();
        }
        this.C0.a(new nd0(this, 1, new q30(), this.J1.n().m(getLineCount() - 1, this.J1.o(getLineCount() - 1).f), this.J1, false));
        h(true);
        InputMethodManager inputMethodManager = this.H1;
        if (inputMethodManager != null) {
            inputMethodManager.restartInput(this);
        }
        requestLayout();
        ri3Var.a();
        invalidate();
    }

    public void setTextBorderWidth(float f) {
        if (f < 0.0f) {
            xe.k("width can not be under zero");
        } else {
            this.P0 = f;
            invalidate();
        }
    }

    public void setTextLetterSpacing(float f) {
        u11 u11Var = this.i2;
        u11Var.b.setLetterSpacing(f);
        u11Var.c.setLetterSpacing(f);
        u11Var.C();
        d0();
    }

    public void setTextScaleX(float f) {
        u11 u11Var = this.i2;
        u11Var.b.setTextScaleX(f);
        u11Var.c.setTextScaleX(f);
        u11Var.C();
    }

    public void setTextSize(float f) {
        Context context = getContext();
        setTextSizePx(TypedValue.applyDimension(2, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setTextSizePx(float f) {
        setTextSizePxDirect(f);
        d0();
        h(true);
        invalidate();
    }

    public void setTextSizePxDirect(float f) {
        getTextSizePx();
        u11 u11Var = this.i2;
        c03 c03Var = u11Var.b;
        c03Var.setTextSize(f);
        c03Var.b();
        c03 c03Var2 = u11Var.c;
        c03Var2.setTextSize(f);
        c03 c03Var3 = u11Var.g;
        CodeEditor codeEditor = u11Var.p;
        Objects.requireNonNull(codeEditor.getProps());
        c03Var3.setTextSize(f * 0.85f);
        u11Var.r = c03Var.getFontMetricsInt();
        u11Var.A = c03Var2.getFontMetricsInt();
        u11Var.B = c03Var3.getFontMetricsInt();
        codeEditor.getRenderContext().a();
        u11Var.G();
        this.C0.a(new wc4(this));
    }

    public void setTypefaceLineNumber(Typeface typeface) {
        u11 u11Var = this.i2;
        c03 c03Var = u11Var.c;
        if (typeface == null) {
            typeface = Typeface.MONOSPACE;
        }
        c03Var.setTypeface(typeface);
        u11Var.A = c03Var.getFontMetricsInt();
        u11Var.p.invalidate();
        d0();
    }

    public void setTypefaceText(Typeface typeface) {
        u11 u11Var = this.i2;
        c03 c03Var = u11Var.b;
        CodeEditor codeEditor = u11Var.p;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        c03Var.setTypeface(typeface);
        c03Var.b();
        u11Var.r = c03Var.getFontMetricsInt();
        codeEditor.getRenderContext().a();
        u11Var.G();
        codeEditor.h(true);
        codeEditor.invalidate();
        d0();
    }

    public void setUndoEnabled(boolean z) {
        this.a1 = z;
        ld0 ld0Var = this.J1;
        if (ld0Var != null) {
            ld0Var.A(z);
        }
    }

    public void setVerticalExtraSpaceFactor(float f) {
        if (f < 0.0f || f > 1.0f) {
            xe.k("the factor should be in range [0.0, 1.0]");
        } else {
            this.V0 = f;
            this.S1.k(0.0f, 0.0f, false);
        }
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        this.p1 = z;
    }

    @Override // android.view.View
    public void setVerticalScrollbarThumbDrawable(Drawable drawable) {
        this.i2.u = drawable;
    }

    @Override // android.view.View
    public void setVerticalScrollbarTrackDrawable(Drawable drawable) {
        this.i2.v = drawable;
    }

    public void setWordwrap(boolean z) {
        m0(z, true);
    }

    public final void v(js3 js3Var) {
        q();
        q30 selectingTarget = getSelectingTarget();
        js3Var.getClass();
        selectingTarget.getClass();
        q30 q30Var = (q30) js3Var.b.k(this, selectingTarget);
        q30 q30Var2 = this.A0;
        l0(q30Var2.b, q30Var2.c, q30Var.b, q30Var.c, 7, false);
        js3 js3Var2 = js3.z0;
        d21 d21Var = this.S1;
        if (js3Var == js3Var2) {
            d21Var.k(0.0f, -getHeight(), true);
        } else if (js3Var == js3.A0) {
            d21Var.k(0.0f, getHeight(), true);
        }
        if (this.I1.c.a().equals(this.A0)) {
            r();
        } else {
            q30 q30Var3 = this.I1.c;
            p(q30Var3.b, q30Var3.c);
        }
    }

    public final ExtractedText w(ExtractedTextRequest extractedTextRequest) {
        getProps().getClass();
        getProps().getClass();
        lg0 cursor = getCursor();
        ExtractedText extractedText = new ExtractedText();
        int i = cursor.c.a;
        int i2 = cursor.d.a;
        int i3 = extractedTextRequest.hintMaxChars;
        if (i3 == 0) {
            this.e2.getClass();
            i3 = 32768;
            extractedTextRequest.hintMaxChars = 32768;
        }
        int iMin = i3 < i ? Math.min(i - (i3 / 2), i) : 0;
        extractedText.text = this.B0.b(iMin, extractedTextRequest.hintMaxChars + iMin, extractedTextRequest.flags);
        extractedText.startOffset = iMin;
        extractedText.selectionStart = i - iMin;
        extractedText.selectionEnd = i2 - iMin;
        j82 keyMetaStates = getKeyMetaStates();
        if (keyMetaStates.b() && !keyMetaStates.a()) {
            extractedText.flags |= 2;
        }
        return extractedText;
    }

    public final int x() {
        int i;
        a54 a54Var = this.g2;
        ArrayList arrayList = a54Var == null ? null : a54Var.b;
        int i2 = -1;
        if (arrayList != null && !arrayList.isEmpty()) {
            int i3 = this.I1.c.b;
            int iA = j60.a(i3, arrayList);
            int i4 = 0;
            if (iA == -1) {
                iA = 0;
            }
            int size = arrayList.size() - 1;
            a54 a54Var2 = this.g2;
            int i5 = a54Var2 != null ? a54Var2.c : Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            while (iA <= size) {
                j60 j60Var = (j60) arrayList.get(iA);
                if (j60Var != null) {
                    int i7 = j60Var.c;
                    if (i7 >= i3 && (i = j60Var.a) <= i3) {
                        int i8 = i7 - i;
                        if (i8 < i6) {
                            i2 = iA;
                            i6 = i8;
                        }
                    } else if (i6 != Integer.MAX_VALUE && (i4 = i4 + 1) >= i5) {
                        break;
                    }
                }
                iA++;
            }
        }
        return i2;
    }

    public final long y(float f, float f2) {
        float fMax = Math.max(0.0f, f2);
        this.i2.getClass();
        return this.D0.k((f + getOffsetX()) - T(), fMax + getOffsetY());
    }

    public final int z(int i) {
        int lineSpacingPixels = getLineSpacingPixels();
        Paint.FontMetricsInt fontMetricsInt = this.i2.r;
        return (((i + 1) * Math.max(1, (fontMetricsInt.descent - fontMetricsInt.ascent) + lineSpacingPixels)) - fontMetricsInt.descent) - (lineSpacingPixels / 2);
    }

    public CodeEditor(Context context) {
        this(context, null);
    }
}
