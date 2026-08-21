package defpackage;

import android.util.SparseIntArray;
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cc4 extends u01 implements dd4 {
    public static final /* synthetic */ int h = 0;
    public bd4 d;
    public yv1 e;
    public ThemeModel f;
    public final ed4 g;

    public cc4(ed4 ed4Var, ThemeModel themeModel) {
        this.g = ed4Var;
        this.f = themeModel;
        h(themeModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.u01
    public final void a() {
        super.a();
        ed4 ed4Var = this.g;
        if (ed4Var != null && !((ArrayList) ed4Var.f).contains(this)) {
            ed4Var.h(this);
        }
        yv1 yv1Var = this.e;
        if (yv1Var == null) {
            return;
        }
        Collection collection = (Collection) ((td3) yv1Var).get("settings");
        if (collection != null) {
            td3 td3Var = (td3) ((List) collection).get(0);
            if (td3Var != null) {
                td3Var = (td3) td3Var.get("settings");
            }
            if (td3Var != null) {
                g(1, 0);
                String str = (String) td3Var.get("caret");
                if (str != null) {
                    g(7, xb5.F(str));
                }
                String str2 = (String) td3Var.get("selection");
                if (str2 != null) {
                    g(6, xb5.F(str2));
                }
                String str3 = (String) td3Var.get("invisibles");
                if (str3 != null) {
                    g(31, xb5.F(str3));
                }
                String str4 = (String) td3Var.get("lineHighlight");
                if (str4 != null) {
                    g(9, xb5.F(str4));
                }
                String str5 = (String) td3Var.get("background");
                if (str5 != null) {
                    g(4, xb5.F(str5));
                    g(3, xb5.F(str5));
                }
                String str6 = (String) td3Var.get("foreground");
                if (str6 != null) {
                    g(5, xb5.F(str6));
                }
                String str7 = (String) td3Var.get("highlightedDelimitersForeground");
                if (str7 != null) {
                    g(39, xb5.F(str7));
                }
                String str8 = (String) td3Var.get("completionWindowBackground");
                if (str8 != null) {
                    g(19, xb5.F(str8));
                }
                String str9 = (String) td3Var.get("completionWindowBackgroundCurrent");
                if (str9 != null) {
                    g(44, xb5.F(str9));
                }
                int iE = ((e(5) + e(4)) / 2) & 16777215;
                g(14, iE | (-2013265920));
                g(15, iE | (-16777216));
                return;
            }
            return;
        }
        td3 td3Var2 = (td3) ((td3) this.e).get("colors");
        if (td3Var2 != null) {
            g(1, 0);
            String str10 = (String) td3Var2.get("editorCursor.foreground");
            if (str10 != null) {
                g(7, xb5.F(str10));
            }
            String str11 = (String) td3Var2.get("editor.selectionBackground");
            if (str11 != null) {
                g(6, xb5.F(str11));
            }
            String str12 = (String) td3Var2.get("editorWhitespace.foreground");
            if (str12 != null) {
                g(31, xb5.F(str12));
            }
            String str13 = (String) td3Var2.get("editor.lineHighlightBackground");
            if (str13 != null) {
                g(9, xb5.F(str13));
            }
            String str14 = (String) td3Var2.get("editor.background");
            if (str14 != null) {
                g(4, xb5.F(str14));
                g(3, xb5.F(str14));
            }
            String str15 = (String) td3Var2.get("editorLineNumber.foreground");
            if (str15 != null) {
                g(2, xb5.F(str15));
            }
            String str16 = (String) td3Var2.get("editorLineNumber.activeForeground");
            if (str16 != null) {
                g(45, xb5.F(str16));
            }
            String str17 = (String) td3Var2.get("editor.foreground");
            if (str17 != null) {
                g(5, xb5.F(str17));
            }
            String str18 = (String) td3Var2.get("highlightedDelimitersForeground");
            if (str18 != null) {
                g(39, xb5.F(str18));
            }
            String str19 = (String) td3Var2.get("tooltipBackground");
            if (str19 != null) {
                g(53, xb5.F(str19));
            }
            String str20 = (String) td3Var2.get("tooltipBriefMessageColor");
            if (str20 != null) {
                g(54, xb5.F(str20));
            }
            String str21 = (String) td3Var2.get("tooltipDetailedMessageColor");
            if (str21 != null) {
                g(55, xb5.F(str21));
            }
            String str22 = (String) td3Var2.get("tooltipActionColor");
            if (str22 != null) {
                g(56, xb5.F(str22));
            }
            String str23 = (String) td3Var2.get("editorSuggestWidget.highlightForeground");
            if (str23 != null) {
                g(67, xb5.F(str23));
            }
            String str24 = (String) td3Var2.get("editorSuggestWidget.background");
            if (str24 != null) {
                g(19, xb5.F(str24));
            }
            String str25 = (String) td3Var2.get("editorSuggestWidget.foreground");
            if (str25 != null) {
                g(42, xb5.F(str25));
            }
            String str26 = (String) td3Var2.get("editorSuggestWidget.selectedBackground");
            if (str26 != null) {
                g(44, xb5.F(str26));
            }
            String str27 = (String) td3Var2.get("editorIndentGuide.background");
            int iE2 = ((e(5) + e(4)) / 2) & 16777215;
            int i = iE2 | (-2013265920);
            int i2 = iE2 | (-16777216);
            if (str27 != null) {
                g(14, xb5.F(str27));
            } else {
                g(14, i);
            }
            String str28 = (String) td3Var2.get("editorIndentGuide.activeBackground");
            if (str28 != null) {
                g(15, xb5.F(str28));
            } else {
                g(15, i2);
            }
            String str29 = (String) td3Var2.get("editor.wordHighlightStrongBackground");
            if (str29 != null) {
                g(73, xb5.F(str29));
            }
            String str30 = (String) td3Var2.get("editor.wordHighlightBackground");
            if (str30 != null) {
                g(74, xb5.F(str30));
            }
            String str31 = (String) td3Var2.get("editor.findMatchBackground");
            if (str31 != null) {
                g(29, xb5.F(str31));
            }
        }
    }

    @Override // defpackage.dd4
    public final void b(ThemeModel themeModel) {
        h(themeModel);
    }

    @Override // defpackage.u01
    public final void c(CodeEditor codeEditor) {
        super.c(codeEditor);
        try {
            this.g.J(this.f);
        } catch (Exception unused) {
        }
        h(this.f);
        s82 s82Var = codeEditor.O1;
        if (s82Var != null) {
            s82Var.c().s();
        }
    }

    @Override // defpackage.u01
    public final void d(CodeEditor codeEditor) {
        super.d(codeEditor);
        ed4 ed4Var = this.g;
        synchronized (ed4Var) {
            ((ArrayList) ed4Var.f).remove(this);
        }
    }

    @Override // defpackage.u01
    public final int e(int i) {
        SparseIntArray sparseIntArray = this.a;
        if (i < 255) {
            return sparseIntArray.get(i);
        }
        int i2 = sparseIntArray.get(i);
        if (i2 != 0) {
            return i2;
        }
        bd4 bd4Var = this.d;
        if (bd4Var == null) {
            return sparseIntArray.get(5);
        }
        try {
            String str = (String) bd4Var.b.c.get(i - 255);
            int iF = (str == null || "@default".equalsIgnoreCase(str)) ? sparseIntArray.get(5) : xb5.F(str);
            sparseIntArray.put(i, iF);
            return iF;
        } catch (IndexOutOfBoundsException unused) {
            return sparseIntArray.get(5);
        }
    }

    @Override // defpackage.u01
    public final boolean f() {
        ThemeModel themeModel = this.f;
        if (themeModel != null) {
            return themeModel.isDark();
        }
        return false;
    }

    public final void h(ThemeModel themeModel) {
        this.f = themeModel;
        this.a.clear();
        this.e = themeModel.getRawTheme();
        this.d = themeModel.getTheme();
        themeModel.getThemeSource();
        a();
    }
}
