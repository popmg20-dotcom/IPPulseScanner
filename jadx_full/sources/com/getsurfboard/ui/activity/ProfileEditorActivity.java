package com.getsurfboard.ui.activity;

import android.animation.ValueAnimator;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import defpackage.bh3;
import defpackage.ca;
import defpackage.cc4;
import defpackage.cm2;
import defpackage.cv4;
import defpackage.dc4;
import defpackage.dv4;
import defpackage.ed4;
import defpackage.f0;
import defpackage.f41;
import defpackage.ff;
import defpackage.fn;
import defpackage.fu4;
import defpackage.fv4;
import defpackage.g82;
import defpackage.ge0;
import defpackage.gt1;
import defpackage.h63;
import defpackage.ha0;
import defpackage.hf4;
import defpackage.hk3;
import defpackage.hv4;
import defpackage.i54;
import defpackage.j61;
import defpackage.ji0;
import defpackage.jl4;
import defpackage.k63;
import defpackage.l61;
import defpackage.l72;
import defpackage.ld0;
import defpackage.m11;
import defpackage.m63;
import defpackage.mk;
import defpackage.mp4;
import defpackage.n12;
import defpackage.nd0;
import defpackage.nv1;
import defpackage.oo1;
import defpackage.ov1;
import defpackage.q30;
import defpackage.s82;
import defpackage.sk2;
import defpackage.st4;
import defpackage.t6;
import defpackage.tk3;
import defpackage.ub3;
import defpackage.ub4;
import defpackage.uf2;
import defpackage.v62;
import defpackage.v9;
import defpackage.vd1;
import defpackage.vf2;
import defpackage.vp1;
import defpackage.w53;
import defpackage.wp4;
import defpackage.wu2;
import defpackage.x11;
import defpackage.xe;
import defpackage.xp1;
import defpackage.yg3;
import defpackage.yw0;
import defpackage.zd1;
import defpackage.zo2;
import defpackage.zp1;
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.SymbolInputView;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.sentry.util.q;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileEditorActivity extends ca implements hf4 {
    public static final /* synthetic */ int Y0 = 0;
    public cm2 S0;
    public String T0;
    public String U0;
    public boolean V0;
    public final ArrayList W0 = new ArrayList();
    public final fn X0 = new fn(14, this);

    public final void A(String str, boolean z) {
        ji0.B(uf2.t(this), null, null, new oo1(this, this.T0, str, z, (ge0) null), 3);
    }

    public final void B(String str) {
        ji0.B(uf2.t(this), null, null, new w53(this, str, null, 2), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        t6 t6Var;
        t6 t6Var2;
        int i = sk2Var.a;
        Object[] objArr = 0;
        if (i == R.id.search) {
            this.V0 = true;
            cm2 cm2Var = this.S0;
            if (cm2Var == null) {
                n12.T("binding");
                throw null;
            }
            ((Toolbar) cm2Var.Z).setTitle("");
            cm2 cm2Var2 = this.S0;
            if (cm2Var2 == null) {
                n12.T("binding");
                throw null;
            }
            ((Toolbar) cm2Var2.Z).getMenu().clear();
            cm2 cm2Var3 = this.S0;
            if (cm2Var3 == null) {
                n12.T("binding");
                throw null;
            }
            ((Toolbar) cm2Var3.Z).o(R.menu.editor_search);
            cm2 cm2Var4 = this.S0;
            if (cm2Var4 == null) {
                n12.T("binding");
                throw null;
            }
            MenuItem menuItemFindItem = ((Toolbar) cm2Var4.Z).getMenu().findItem(R.id.search_view);
            View actionView = menuItemFindItem.getActionView();
            actionView.getClass();
            SearchView searchView = (SearchView) actionView;
            searchView.setQueryHint(getString(R.string.search));
            searchView.setIconified(false);
            searchView.setOnQueryTextListener(new v62(16, searchView, this, objArr == true ? 1 : 0));
            menuItemFindItem.expandActionView();
            menuItemFindItem.setOnActionExpandListener(new h63(this));
            return true;
        }
        if (i == R.id.search_previous) {
            cm2 cm2Var5 = this.S0;
            if (cm2Var5 == null) {
                n12.T("binding");
                throw null;
            }
            x11 searcher = ((CodeEditor) cm2Var5.z).getSearcher();
            CodeEditor codeEditor = searcher.a;
            if (searcher.b == null) {
                xe.q("pattern not set");
                return false;
            }
            if (searcher.b() && (t6Var2 = searcher.e) != null && t6Var2.f != 0) {
                int iM = t6Var2.m(codeEditor.getCursor().c.a);
                if (iM == t6Var2.f || ((int) (t6Var2.j(iM) >> 32)) >= iM) {
                    iM--;
                }
                if (iM < 0 && searcher.f) {
                    iM = t6Var2.f - 1;
                }
                if (iM >= 0 && iM < t6Var2.f) {
                    long j = t6Var2.j(iM);
                    int i2 = (int) (j & 4294967295L);
                    q30 q30VarJ = codeEditor.getText().n().j((int) (j >> 32));
                    q30 q30VarJ2 = codeEditor.getText().n().j(i2);
                    searcher.a.l0(q30VarJ.b, q30VarJ.c, q30VarJ2.b, q30VarJ2.c, 6, true);
                    return true;
                }
            }
        } else if (i == R.id.search_next) {
            cm2 cm2Var6 = this.S0;
            if (cm2Var6 == null) {
                n12.T("binding");
                throw null;
            }
            x11 searcher2 = ((CodeEditor) cm2Var6.z).getSearcher();
            CodeEditor codeEditor2 = searcher2.a;
            if (searcher2.b == null) {
                xe.q("pattern not set");
                return false;
            }
            if (searcher2.b() && (t6Var = searcher2.e) != null) {
                int iM2 = t6Var.m(codeEditor2.getCursor().d.a);
                int i3 = t6Var.f;
                int i4 = (iM2 == i3 && searcher2.f) ? 0 : iM2;
                if (i4 < i3) {
                    long j2 = t6Var.j(i4);
                    q30 q30VarJ3 = codeEditor2.getText().n().j((int) (j2 >> 32));
                    q30 q30VarJ4 = codeEditor2.getText().n().j((int) (j2 & 4294967295L));
                    searcher2.a.l0(q30VarJ3.b, q30VarJ3.c, q30VarJ4.b, q30VarJ4.c, 6, true);
                    return true;
                }
            }
        } else {
            if (i == R.id.undo) {
                cm2 cm2Var7 = this.S0;
                if (cm2Var7 != null) {
                    ((CodeEditor) cm2Var7.z).o0();
                    return true;
                }
                n12.T("binding");
                throw null;
            }
            if (i == R.id.redo) {
                cm2 cm2Var8 = this.S0;
                if (cm2Var8 != null) {
                    ((CodeEditor) cm2Var8.z).c0();
                    return true;
                }
                n12.T("binding");
                throw null;
            }
            if (i == R.id.save) {
                cm2 cm2Var9 = this.S0;
                if (cm2Var9 == null) {
                    n12.T("binding");
                    throw null;
                }
                CodeEditor codeEditor3 = (CodeEditor) cm2Var9.z;
                jl4 jl4Var = codeEditor3.J1.z0;
                if ((jl4Var.f && jl4Var.Y > 0) == true) {
                    if (cm2Var9 != null) {
                        A(codeEditor3.getText().toString(), false);
                        return true;
                    }
                    n12.T("binding");
                    throw null;
                }
                if (cm2Var9 == null) {
                    n12.T("binding");
                    throw null;
                }
                Toolbar toolbar = (Toolbar) cm2Var9.Z;
                String str = this.T0;
                toolbar.setTitle(str != null ? str : "");
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i;
        int i2;
        l72.H(this);
        v9.e(getWindow());
        int i3 = 0;
        v9.v(getWindow(), false);
        super.onCreate(bundle);
        this.T0 = getIntent().getStringExtra("name");
        boolean booleanExtra = getIntent().getBooleanExtra("gzip", false);
        Uri data = getIntent().getData();
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_profile_editor, (ViewGroup) null, false);
        int i4 = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i4 = R.id.editor;
            CodeEditor codeEditor = (CodeEditor) vf2.l(viewInflate, R.id.editor);
            if (codeEditor != null) {
                i4 = R.id.loading;
                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) vf2.l(viewInflate, R.id.loading);
                if (linearProgressIndicator != null) {
                    i4 = R.id.symbol_input;
                    SymbolInputView symbolInputView = (SymbolInputView) vf2.l(viewInflate, R.id.symbol_input);
                    if (symbolInputView != null) {
                        i4 = R.id.symbol_input_container;
                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) vf2.l(viewInflate, R.id.symbol_input_container);
                        if (horizontalScrollView != null) {
                            i4 = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                            if (toolbar != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                this.S0 = new cm2(constraintLayout, codeEditor, linearProgressIndicator, symbolInputView, horizontalScrollView, toolbar, 1);
                                setContentView(constraintLayout);
                                cm2 cm2Var = this.S0;
                                if (cm2Var == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) cm2Var.f;
                                q qVar = new q(this);
                                WeakHashMap weakHashMap = wp4.a;
                                mp4.c(constraintLayout2, qVar);
                                cm2 cm2Var2 = this.S0;
                                if (cm2Var2 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                fu4.a((ConstraintLayout) cm2Var2.f, new k63(this));
                                Window window = getWindow();
                                if (this.S0 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ub4 ub4Var = new ub4();
                                int i5 = Build.VERSION.SDK_INT;
                                if (i5 >= 35) {
                                    ub4Var.b = new hv4(window);
                                } else if (i5 >= 30) {
                                    ub4Var.b = new fv4(window);
                                } else if (i5 >= 26) {
                                    ub4Var.b = new dv4(window);
                                } else {
                                    ub4Var.b = new cv4(window);
                                }
                                final bh3 bh3Var = new bh3();
                                final yg3 yg3Var = new yg3();
                                final GestureDetector gestureDetector = new GestureDetector(this, new m63(yg3Var, bh3Var, this, ub4Var));
                                cm2 cm2Var3 = this.S0;
                                if (cm2Var3 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var3.z).setOnTouchListener(new View.OnTouchListener() { // from class: e63
                                    @Override // android.view.View.OnTouchListener
                                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                                        int i6 = ProfileEditorActivity.Y0;
                                        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                                            final bh3 bh3Var2 = bh3Var;
                                            final hu4 hu4Var = (hu4) bh3Var2.b;
                                            if (hu4Var != null) {
                                                gu4 gu4Var = hu4Var.a;
                                                int i7 = gu4Var.x0().d;
                                                final int i8 = gu4Var.y0().d;
                                                final int i9 = gu4Var.z0().d;
                                                int i10 = yg3Var.b > 0.0f ? i9 : i8;
                                                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i7, i10);
                                                valueAnimatorOfInt.setDuration(200L);
                                                final ProfileEditorActivity profileEditorActivity = this;
                                                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: g63
                                                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                                        t02 t02VarH;
                                                        int i11 = ProfileEditorActivity.Y0;
                                                        valueAnimator.getClass();
                                                        Object obj = bh3Var2.b;
                                                        hu4 hu4Var2 = hu4Var;
                                                        if (n12.c(obj, hu4Var2)) {
                                                            Object animatedValue = valueAnimator.getAnimatedValue();
                                                            animatedValue.getClass();
                                                            int iIntValue = ((Integer) animatedValue).intValue();
                                                            int i12 = i8;
                                                            float f = (iIntValue - i12) / (i9 - i12);
                                                            hu4Var2.a.A0(t02.c(0, 0, 0, iIntValue), f);
                                                            ProfileEditorActivity profileEditorActivity2 = profileEditorActivity;
                                                            cm2 cm2Var4 = profileEditorActivity2.S0;
                                                            if (cm2Var4 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) cm2Var4.f;
                                                            WeakHashMap weakHashMap2 = wp4.a;
                                                            bv4 bv4VarA = np4.a(constraintLayout3);
                                                            if (bv4VarA == null || (t02VarH = bv4VarA.a.h(519)) == null) {
                                                                t02VarH = t02.e;
                                                            }
                                                            cm2 cm2Var5 = profileEditorActivity2.S0;
                                                            if (cm2Var5 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) cm2Var5.Y;
                                                            horizontalScrollView2.setPadding(horizontalScrollView2.getPaddingLeft(), horizontalScrollView2.getPaddingTop(), horizontalScrollView2.getPaddingRight(), (int) ((1.0f - f) * t02VarH.d));
                                                        }
                                                    }
                                                });
                                                valueAnimatorOfInt.addListener(new l63(bh3Var2, hu4Var, i10, i9));
                                                valueAnimatorOfInt.start();
                                            }
                                        }
                                        gestureDetector.onTouchEvent(motionEvent);
                                        return false;
                                    }
                                });
                                int i6 = 2;
                                int i7 = 1;
                                boolean z = (getIntent().getFlags() & 2) > 0;
                                cm2 cm2Var4 = this.S0;
                                if (cm2Var4 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var4.z).setEditable(z);
                                cm2 cm2Var5 = this.S0;
                                if (z) {
                                    if (cm2Var5 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((Toolbar) cm2Var5.Z).o(R.menu.editor);
                                } else {
                                    if (cm2Var5 == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    ((HorizontalScrollView) cm2Var5.Y).setVisibility(8);
                                }
                                ThreadLocal threadLocal = hk3.a;
                                Typeface typefaceB = isRestricted() ? null : hk3.b(this, R.font.fira, new TypedValue(), 0, null, false, false);
                                cm2 cm2Var6 = this.S0;
                                if (cm2Var6 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var6.z).setTypefaceText(typefaceB);
                                cm2 cm2Var7 = this.S0;
                                if (cm2Var7 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var7.z).setTypefaceLineNumber(typefaceB);
                                cm2 cm2Var8 = this.S0;
                                if (cm2Var8 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var8.z).setTextSize(11.0f);
                                cm2 cm2Var9 = this.S0;
                                if (cm2Var9 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                CodeEditor codeEditor2 = (CodeEditor) cm2Var9.z;
                                codeEditor2.T0 = 2.0f;
                                codeEditor2.S0 = 1.1f;
                                codeEditor2.m0(true, false);
                                cm2 cm2Var10 = this.S0;
                                if (cm2Var10 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var10.z).setNonPrintablePaintingFlags(16);
                                vd1 vd1VarA = vd1.a();
                                AssetManager assets = getApplicationContext().getAssets();
                                ff ffVar = new ff();
                                ffVar.b = assets;
                                synchronized (vd1VarA) {
                                    if (ffVar != zd1.a) {
                                        vd1VarA.a.add(ffVar);
                                    }
                                }
                                zp1.c().e();
                                int i8 = dc4.f;
                                zp1 zp1VarC = zp1.c();
                                ed4 ed4VarB = ed4.B();
                                nv1 nv1VarA = zp1VarC.a.a("source.surfboard", null, null);
                                if (nv1VarA == null) {
                                    nv1VarA = null;
                                }
                                if (nv1VarA == null) {
                                    st4.p("Language with ", zp1VarC, " scope name not found");
                                    return;
                                }
                                LanguageConfiguration languageConfiguration = (LanguageConfiguration) zp1VarC.b.get(((xp1) nv1VarA).a);
                                if (languageConfiguration == null) {
                                    languageConfiguration = null;
                                }
                                dc4 dc4Var = new dc4(nv1VarA, languageConfiguration, ed4VarB);
                                cm2 cm2Var11 = this.S0;
                                if (cm2Var11 == null) {
                                    n12.T("binding");
                                    throw null;
                                }
                                ((CodeEditor) cm2Var11.z).setEditorLanguage(dc4Var);
                                String[] strArr = {"darcula", "quietlight"};
                                int i9 = 0;
                                while (true) {
                                    int i10 = -1;
                                    if (i9 >= i6) {
                                        boolean z2 = i7;
                                        int i11 = getResources().getConfiguration().uiMode & 48;
                                        if (i11 == 0 || i11 == 16) {
                                            ed4.B().Y("quietlight");
                                        } else if (i11 == 32) {
                                            ed4.B().Y("darcula");
                                        }
                                        cm2 cm2Var12 = this.S0;
                                        if (cm2Var12 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        CodeEditor codeEditor3 = (CodeEditor) cm2Var12.z;
                                        ed4 ed4VarB2 = ed4.B();
                                        int i12 = cc4.h;
                                        codeEditor3.setColorScheme(new cc4(ed4.B(), (ThemeModel) ed4VarB2.A));
                                        cm2 cm2Var13 = this.S0;
                                        if (cm2Var13 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        SymbolInputView symbolInputView2 = (SymbolInputView) cm2Var13.X;
                                        symbolInputView2.f = (CodeEditor) cm2Var13.z;
                                        String[] strArr2 = {"[", "]", "#", "=", ",", ".", WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, ":", "/"};
                                        int iMax = Math.max(9, 9);
                                        for (int i13 = 0; i13 < iMax; i13++) {
                                            Button button = new Button(symbolInputView2.getContext(), null, android.R.attr.buttonStyleSmall);
                                            button.setText(strArr2[i13]);
                                            button.setBackground(new ColorDrawable(0));
                                            button.setTextColor(symbolInputView2.b);
                                            symbolInputView2.addView(button, new LinearLayout.LayoutParams(-2, -1));
                                            button.setOnClickListener(new yw0(symbolInputView2, strArr2, i13));
                                        }
                                        ge0 ge0Var = null;
                                        cm2 cm2Var14 = this.S0;
                                        if (cm2Var14 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        SymbolInputView symbolInputView3 = (SymbolInputView) cm2Var14.X;
                                        for (int i14 = 0; i14 < symbolInputView3.getChildCount(); i14++) {
                                            Button button2 = (Button) symbolInputView3.getChildAt(i14);
                                            button2.getClass();
                                            button2.setTypeface(typefaceB);
                                        }
                                        cm2 cm2Var15 = this.S0;
                                        if (cm2Var15 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        Toolbar toolbar2 = (Toolbar) cm2Var15.Z;
                                        String str = this.T0;
                                        if (str == null) {
                                            str = "";
                                        }
                                        toolbar2.setTitle(str);
                                        cm2 cm2Var16 = this.S0;
                                        if (cm2Var16 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((Toolbar) cm2Var16.Z).setNavigationOnClickListener(new mk(16, this));
                                        cm2 cm2Var17 = this.S0;
                                        if (cm2Var17 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((Toolbar) cm2Var17.Z).setOnMenuItemClickListener(this);
                                        cm2 cm2Var18 = this.S0;
                                        if (cm2Var18 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        final int i15 = 0;
                                        ((CodeEditor) cm2Var18.z).n0(ub3.class, new l61(this) { // from class: f63
                                            public final /* synthetic */ ProfileEditorActivity f;

                                            {
                                                this.f = this;
                                            }

                                            @Override // defpackage.l61
                                            public final void a(p60 p60Var, id0 id0Var) {
                                                int i16 = i15;
                                                ProfileEditorActivity profileEditorActivity = this.f;
                                                switch (i16) {
                                                    case 0:
                                                        int i17 = ProfileEditorActivity.Y0;
                                                        ((ub3) p60Var).getClass();
                                                        profileEditorActivity.y();
                                                        return;
                                                    case 1:
                                                        int i18 = ProfileEditorActivity.Y0;
                                                        ((nd0) p60Var).getClass();
                                                        profileEditorActivity.X0.a();
                                                        return;
                                                    default:
                                                        g82 g82Var = (g82) p60Var;
                                                        int i19 = ProfileEditorActivity.Y0;
                                                        g82Var.getClass();
                                                        boolean z3 = g82Var.f;
                                                        KeyEvent keyEvent = g82Var.d;
                                                        if ((keyEvent.getMetaState() & 4096) == 0 || profileEditorActivity.V0 || g82Var.e != 2) {
                                                            return;
                                                        }
                                                        int keyCode = keyEvent.getKeyCode();
                                                        if (keyCode == 29) {
                                                            cm2 cm2Var19 = profileEditorActivity.S0;
                                                            if (cm2Var19 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var19.z).V(js3.D0);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 30) {
                                                            cm2 cm2Var20 = profileEditorActivity.S0;
                                                            if (cm2Var20 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var20.z).U(js3.X, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 33) {
                                                            cm2 cm2Var21 = profileEditorActivity.S0;
                                                            if (cm2Var21 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var21.z).V(js3.E0);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 34) {
                                                            cm2 cm2Var22 = profileEditorActivity.S0;
                                                            if (cm2Var22 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var22.z).U(js3.Y, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 42) {
                                                            cm2 cm2Var23 = profileEditorActivity.S0;
                                                            if (cm2Var23 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var23.z).U(js3.A, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 44) {
                                                            cm2 cm2Var24 = profileEditorActivity.S0;
                                                            if (cm2Var24 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var24.z).U(js3.z, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode != 48) {
                                                            return;
                                                        }
                                                        cm2 cm2Var25 = profileEditorActivity.S0;
                                                        if (cm2Var25 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        if (((CodeEditor) cm2Var25.z).H()) {
                                                            cm2 cm2Var26 = profileEditorActivity.S0;
                                                            if (cm2Var26 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ld0 text = ((CodeEditor) cm2Var26.z).getText();
                                                            text.getClass();
                                                            int i20 = text.m().d.a;
                                                            int i21 = text.A;
                                                            int i22 = i20 == 0 ? 1 : i20 == i21 ? i21 - 1 : i20;
                                                            if (i22 >= 1 && i22 < i21) {
                                                                text.b();
                                                                int i23 = i22 - 1;
                                                                try {
                                                                    char cCharAt = text.charAt(i23);
                                                                    char cCharAt2 = text.charAt(i22);
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append(cCharAt2);
                                                                    sb.append(cCharAt);
                                                                    text.w(i23, i22 + 1, sb.toString());
                                                                    text.k();
                                                                    q30 q30VarJ = text.n().j(i20);
                                                                    cm2 cm2Var27 = profileEditorActivity.S0;
                                                                    if (cm2Var27 == null) {
                                                                        n12.T("binding");
                                                                        throw null;
                                                                    }
                                                                    ((CodeEditor) cm2Var27.z).i0(q30VarJ.b, q30VarJ.c);
                                                                } catch (Throwable th) {
                                                                    text.k();
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                        g82Var.z();
                                                        return;
                                                }
                                            }
                                        });
                                        cm2 cm2Var19 = this.S0;
                                        if (cm2Var19 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((CodeEditor) cm2Var19.z).getSearcher().f = false;
                                        ArrayList arrayList = this.W0;
                                        cm2 cm2Var20 = this.S0;
                                        if (cm2Var20 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        final int i16 = 2;
                                        arrayList.add(((CodeEditor) cm2Var20.z).C0.f(g82.class, new l61(this) { // from class: f63
                                            public final /* synthetic */ ProfileEditorActivity f;

                                            {
                                                this.f = this;
                                            }

                                            @Override // defpackage.l61
                                            public final void a(p60 p60Var, id0 id0Var) {
                                                int i162 = i16;
                                                ProfileEditorActivity profileEditorActivity = this.f;
                                                switch (i162) {
                                                    case 0:
                                                        int i17 = ProfileEditorActivity.Y0;
                                                        ((ub3) p60Var).getClass();
                                                        profileEditorActivity.y();
                                                        return;
                                                    case 1:
                                                        int i18 = ProfileEditorActivity.Y0;
                                                        ((nd0) p60Var).getClass();
                                                        profileEditorActivity.X0.a();
                                                        return;
                                                    default:
                                                        g82 g82Var = (g82) p60Var;
                                                        int i19 = ProfileEditorActivity.Y0;
                                                        g82Var.getClass();
                                                        boolean z3 = g82Var.f;
                                                        KeyEvent keyEvent = g82Var.d;
                                                        if ((keyEvent.getMetaState() & 4096) == 0 || profileEditorActivity.V0 || g82Var.e != 2) {
                                                            return;
                                                        }
                                                        int keyCode = keyEvent.getKeyCode();
                                                        if (keyCode == 29) {
                                                            cm2 cm2Var192 = profileEditorActivity.S0;
                                                            if (cm2Var192 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var192.z).V(js3.D0);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 30) {
                                                            cm2 cm2Var202 = profileEditorActivity.S0;
                                                            if (cm2Var202 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var202.z).U(js3.X, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 33) {
                                                            cm2 cm2Var21 = profileEditorActivity.S0;
                                                            if (cm2Var21 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var21.z).V(js3.E0);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 34) {
                                                            cm2 cm2Var22 = profileEditorActivity.S0;
                                                            if (cm2Var22 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var22.z).U(js3.Y, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 42) {
                                                            cm2 cm2Var23 = profileEditorActivity.S0;
                                                            if (cm2Var23 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var23.z).U(js3.A, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 44) {
                                                            cm2 cm2Var24 = profileEditorActivity.S0;
                                                            if (cm2Var24 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var24.z).U(js3.z, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode != 48) {
                                                            return;
                                                        }
                                                        cm2 cm2Var25 = profileEditorActivity.S0;
                                                        if (cm2Var25 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        if (((CodeEditor) cm2Var25.z).H()) {
                                                            cm2 cm2Var26 = profileEditorActivity.S0;
                                                            if (cm2Var26 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ld0 text = ((CodeEditor) cm2Var26.z).getText();
                                                            text.getClass();
                                                            int i20 = text.m().d.a;
                                                            int i21 = text.A;
                                                            int i22 = i20 == 0 ? 1 : i20 == i21 ? i21 - 1 : i20;
                                                            if (i22 >= 1 && i22 < i21) {
                                                                text.b();
                                                                int i23 = i22 - 1;
                                                                try {
                                                                    char cCharAt = text.charAt(i23);
                                                                    char cCharAt2 = text.charAt(i22);
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append(cCharAt2);
                                                                    sb.append(cCharAt);
                                                                    text.w(i23, i22 + 1, sb.toString());
                                                                    text.k();
                                                                    q30 q30VarJ = text.n().j(i20);
                                                                    cm2 cm2Var27 = profileEditorActivity.S0;
                                                                    if (cm2Var27 == null) {
                                                                        n12.T("binding");
                                                                        throw null;
                                                                    }
                                                                    ((CodeEditor) cm2Var27.z).i0(q30VarJ.b, q30VarJ.c);
                                                                } catch (Throwable th) {
                                                                    text.k();
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                        g82Var.z();
                                                        return;
                                                }
                                            }
                                        }));
                                        wu2 wu2VarB = b();
                                        wu2VarB.getClass();
                                        wu2VarB.b(new gt1(i16, new f0(17, this), false));
                                        cm2 cm2Var21 = this.S0;
                                        if (data != null) {
                                            if (cm2Var21 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((CodeEditor) cm2Var21.z).setSaveEnabled(false);
                                            cm2 cm2Var22 = this.S0;
                                            if (cm2Var22 == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            ((LinearProgressIndicator) cm2Var22.A).e();
                                            ji0.B(uf2.t(this), null, null, new oo1(this, data, booleanExtra, ge0Var, 1), 3);
                                            return;
                                        }
                                        if (cm2Var21 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((CodeEditor) cm2Var21.z).setText("");
                                        cm2 cm2Var23 = this.S0;
                                        if (cm2Var23 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        ((CodeEditor) cm2Var23.z).setSaveEnabled(z2);
                                        cm2 cm2Var24 = this.S0;
                                        if (cm2Var24 == null) {
                                            n12.T("binding");
                                            throw null;
                                        }
                                        CodeEditor codeEditor4 = (CodeEditor) cm2Var24.z;
                                        final int i17 = z2 ? 1 : 0;
                                        codeEditor4.n0(nd0.class, new l61(this) { // from class: f63
                                            public final /* synthetic */ ProfileEditorActivity f;

                                            {
                                                this.f = this;
                                            }

                                            @Override // defpackage.l61
                                            public final void a(p60 p60Var, id0 id0Var) {
                                                int i162 = i17;
                                                ProfileEditorActivity profileEditorActivity = this.f;
                                                switch (i162) {
                                                    case 0:
                                                        int i172 = ProfileEditorActivity.Y0;
                                                        ((ub3) p60Var).getClass();
                                                        profileEditorActivity.y();
                                                        return;
                                                    case 1:
                                                        int i18 = ProfileEditorActivity.Y0;
                                                        ((nd0) p60Var).getClass();
                                                        profileEditorActivity.X0.a();
                                                        return;
                                                    default:
                                                        g82 g82Var = (g82) p60Var;
                                                        int i19 = ProfileEditorActivity.Y0;
                                                        g82Var.getClass();
                                                        boolean z3 = g82Var.f;
                                                        KeyEvent keyEvent = g82Var.d;
                                                        if ((keyEvent.getMetaState() & 4096) == 0 || profileEditorActivity.V0 || g82Var.e != 2) {
                                                            return;
                                                        }
                                                        int keyCode = keyEvent.getKeyCode();
                                                        if (keyCode == 29) {
                                                            cm2 cm2Var192 = profileEditorActivity.S0;
                                                            if (cm2Var192 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var192.z).V(js3.D0);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 30) {
                                                            cm2 cm2Var202 = profileEditorActivity.S0;
                                                            if (cm2Var202 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var202.z).U(js3.X, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 33) {
                                                            cm2 cm2Var212 = profileEditorActivity.S0;
                                                            if (cm2Var212 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var212.z).V(js3.E0);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 34) {
                                                            cm2 cm2Var222 = profileEditorActivity.S0;
                                                            if (cm2Var222 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var222.z).U(js3.Y, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 42) {
                                                            cm2 cm2Var232 = profileEditorActivity.S0;
                                                            if (cm2Var232 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var232.z).U(js3.A, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode == 44) {
                                                            cm2 cm2Var242 = profileEditorActivity.S0;
                                                            if (cm2Var242 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((CodeEditor) cm2Var242.z).U(js3.z, z3);
                                                            g82Var.z();
                                                            return;
                                                        }
                                                        if (keyCode != 48) {
                                                            return;
                                                        }
                                                        cm2 cm2Var25 = profileEditorActivity.S0;
                                                        if (cm2Var25 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        if (((CodeEditor) cm2Var25.z).H()) {
                                                            cm2 cm2Var26 = profileEditorActivity.S0;
                                                            if (cm2Var26 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ld0 text = ((CodeEditor) cm2Var26.z).getText();
                                                            text.getClass();
                                                            int i20 = text.m().d.a;
                                                            int i21 = text.A;
                                                            int i22 = i20 == 0 ? 1 : i20 == i21 ? i21 - 1 : i20;
                                                            if (i22 >= 1 && i22 < i21) {
                                                                text.b();
                                                                int i23 = i22 - 1;
                                                                try {
                                                                    char cCharAt = text.charAt(i23);
                                                                    char cCharAt2 = text.charAt(i22);
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append(cCharAt2);
                                                                    sb.append(cCharAt);
                                                                    text.w(i23, i22 + 1, sb.toString());
                                                                    text.k();
                                                                    q30 q30VarJ = text.n().j(i20);
                                                                    cm2 cm2Var27 = profileEditorActivity.S0;
                                                                    if (cm2Var27 == null) {
                                                                        n12.T("binding");
                                                                        throw null;
                                                                    }
                                                                    ((CodeEditor) cm2Var27.z).i0(q30VarJ.b, q30VarJ.c);
                                                                } catch (Throwable th) {
                                                                    text.k();
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                        g82Var.z();
                                                        return;
                                                }
                                            }
                                        });
                                        z();
                                        return;
                                    }
                                    String str2 = strArr[i9];
                                    String strO = ha0.o("textmate/", str2, ".json");
                                    ed4 ed4VarB3 = ed4.B();
                                    int i18 = i7;
                                    InputStream inputStreamD = vd1.a().d(strO);
                                    String lowerCase = strO.substring(strO.lastIndexOf(46) + 1).trim().toLowerCase();
                                    lowerCase.getClass();
                                    switch (lowerCase.hashCode()) {
                                        case -1723969078:
                                            i = lowerCase.equals("yaml-tmtheme") ? i3 : -1;
                                            break;
                                        case -1192850704:
                                            i = lowerCase.equals("tmtheme") ? i18 : -1;
                                            break;
                                        case 118807:
                                            i = lowerCase.equals("xml") ? 2 : -1;
                                            break;
                                        case 119768:
                                            i = lowerCase.equals("yml") ? 3 : -1;
                                            break;
                                        case 3271912:
                                            i = lowerCase.equals("json") ? 4 : -1;
                                            break;
                                        case 3701415:
                                            i = lowerCase.equals("yaml") ? 5 : -1;
                                            break;
                                        case 106756366:
                                            i = lowerCase.equals("plist") ? 6 : -1;
                                            break;
                                        default:
                                            i = -1;
                                            break;
                                    }
                                    switch (i) {
                                        case 0:
                                        case 3:
                                        case 5:
                                            i2 = 2;
                                            break;
                                        case 1:
                                        case 2:
                                        case 6:
                                            i2 = 3;
                                            break;
                                        case 4:
                                            i2 = i18;
                                            break;
                                        default:
                                            xe.k("Unsupported file type: ".concat(strO));
                                            return;
                                    }
                                    try {
                                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamD, StandardCharsets.UTF_8));
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            char[] cArr = new char[16384];
                                            while (true) {
                                                int i19 = bufferedReader.read(cArr);
                                                if (i19 == i10) {
                                                    ov1 ov1Var = new ov1(sb, strO, i2);
                                                    bufferedReader.close();
                                                    ed4VarB3.J(new ThemeModel(ov1Var, str2));
                                                    i9++;
                                                    i7 = i18;
                                                    i3 = 0;
                                                    i6 = 2;
                                                } else if (i19 > 0) {
                                                    sb.append(cArr, 0, i19);
                                                    i10 = -1;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            try {
                                                bufferedReader.close();
                                                throw th;
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e) {
                                        vp1.p(e);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i4)));
    }

    @Override // defpackage.ca, androidx.fragment.app.p, android.app.Activity
    public final void onDestroy() {
        for (i54 i54Var : this.W0) {
            j61 j61VarB = i54Var.c.b(i54Var.a);
            ReentrantReadWriteLock reentrantReadWriteLock = j61VarB.a;
            reentrantReadWriteLock.writeLock().lock();
            try {
                l61 l61Var = (l61) i54Var.b.get();
                if (l61Var != null) {
                    j61VarB.b.remove(l61Var);
                }
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        }
        cm2 cm2Var = this.S0;
        if (cm2Var == null) {
            n12.T("binding");
            throw null;
        }
        CodeEditor codeEditor = (CodeEditor) cm2Var.z;
        codeEditor.R1.e();
        codeEditor.R1.f();
        codeEditor.z.b();
        codeEditor.S1.d.a();
        codeEditor.A.b();
        if (!codeEditor.j1) {
            codeEditor.C0.a(new m11(codeEditor));
            codeEditor.j1 = true;
            s82 s82Var = codeEditor.O1;
            if (s82Var != null) {
                s82Var.c().i();
                codeEditor.O1.getClass();
                codeEditor.O1.getClass();
                codeEditor.O1 = new f41();
            }
            codeEditor.g2 = null;
            ed4 ed4Var = codeEditor.z0;
            ed4Var.z = null;
            ed4Var.A = null;
            ld0 ld0Var = codeEditor.J1;
            if (ld0Var != null) {
                ld0Var.f.remove(codeEditor);
            }
            codeEditor.L1.d(codeEditor);
        }
        super.onDestroy();
    }

    public final void x() {
        this.V0 = false;
        cm2 cm2Var = this.S0;
        if (cm2Var == null) {
            n12.T("binding");
            throw null;
        }
        ((CodeEditor) cm2Var.z).getSearcher().c();
        cm2 cm2Var2 = this.S0;
        if (cm2Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ((Toolbar) cm2Var2.Z).getMenu().clear();
        cm2 cm2Var3 = this.S0;
        if (cm2Var3 == null) {
            n12.T("binding");
            throw null;
        }
        Toolbar toolbar = (Toolbar) cm2Var3.Z;
        String str = this.T0;
        if (str == null) {
            str = "";
        }
        toolbar.setTitle(str);
        boolean z = (getIntent().getFlags() & 2) > 0;
        cm2 cm2Var4 = this.S0;
        if (cm2Var4 == null) {
            n12.T("binding");
            throw null;
        }
        ((Toolbar) cm2Var4.Z).o(R.menu.editor);
        if (z) {
            z();
            return;
        }
        cm2 cm2Var5 = this.S0;
        if (cm2Var5 == null) {
            n12.T("binding");
            throw null;
        }
        MenuItem menuItemFindItem = ((Toolbar) cm2Var5.Z).getMenu().findItem(R.id.undo);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(false);
        }
        cm2 cm2Var6 = this.S0;
        if (cm2Var6 == null) {
            n12.T("binding");
            throw null;
        }
        MenuItem menuItemFindItem2 = ((Toolbar) cm2Var6.Z).getMenu().findItem(R.id.redo);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(false);
        }
        cm2 cm2Var7 = this.S0;
        if (cm2Var7 == null) {
            n12.T("binding");
            throw null;
        }
        MenuItem menuItemFindItem3 = ((Toolbar) cm2Var7.Z).getMenu().findItem(R.id.save);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setVisible(false);
        }
    }

    public final void y() {
        Object tk3Var;
        cm2 cm2Var;
        t6 t6Var;
        if (this.V0) {
            try {
                cm2Var = this.S0;
            } catch (Throwable th) {
                tk3Var = new tk3(th);
            }
            if (cm2Var == null) {
                n12.T("binding");
                throw null;
            }
            x11 searcher = ((CodeEditor) cm2Var.z).getSearcher();
            if (searcher.b == null) {
                throw new IllegalStateException("pattern not set");
            }
            tk3Var = Integer.valueOf((searcher.b() && (t6Var = searcher.e) != null) ? t6Var.f : 0);
            if (tk3Var instanceof tk3) {
                tk3Var = 0;
            }
            boolean z = ((Number) tk3Var).intValue() > 0;
            cm2 cm2Var2 = this.S0;
            if (cm2Var2 == null) {
                n12.T("binding");
                throw null;
            }
            MenuItem menuItemFindItem = ((Toolbar) cm2Var2.Z).getMenu().findItem(R.id.search_previous);
            if (menuItemFindItem != null) {
                menuItemFindItem.setEnabled(z);
            }
            cm2 cm2Var3 = this.S0;
            if (cm2Var3 == null) {
                n12.T("binding");
                throw null;
            }
            MenuItem menuItemFindItem2 = ((Toolbar) cm2Var3.Z).getMenu().findItem(R.id.search_next);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setEnabled(z);
            }
        }
    }

    public final void z() {
        cm2 cm2Var = this.S0;
        if (cm2Var == null) {
            n12.T("binding");
            throw null;
        }
        MenuItem menuItemFindItem = ((Toolbar) cm2Var.Z).getMenu().findItem(R.id.undo);
        boolean z = false;
        if (menuItemFindItem != null) {
            cm2 cm2Var2 = this.S0;
            if (cm2Var2 == null) {
                n12.T("binding");
                throw null;
            }
            jl4 jl4Var = ((CodeEditor) cm2Var2.z).J1.z0;
            menuItemFindItem.setEnabled(jl4Var.f && jl4Var.Y > 0);
        }
        cm2 cm2Var3 = this.S0;
        if (cm2Var3 == null) {
            n12.T("binding");
            throw null;
        }
        MenuItem menuItemFindItem2 = ((Toolbar) cm2Var3.Z).getMenu().findItem(R.id.redo);
        if (menuItemFindItem2 != null) {
            cm2 cm2Var4 = this.S0;
            if (cm2Var4 == null) {
                n12.T("binding");
                throw null;
            }
            jl4 jl4Var2 = ((CodeEditor) cm2Var4.z).J1.z0;
            if (jl4Var2.f && jl4Var2.Y < jl4Var2.b.size()) {
                z = true;
            }
            menuItemFindItem2.setEnabled(z);
        }
    }
}
