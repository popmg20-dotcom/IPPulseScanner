package io.github.rosemoe.sora.langs.textmate.registry.model;

import defpackage.aa4;
import defpackage.bd4;
import defpackage.fw;
import defpackage.l44;
import defpackage.ov1;
import defpackage.td3;
import defpackage.tw1;
import defpackage.u94;
import defpackage.ud3;
import defpackage.vd3;
import defpackage.y94;
import defpackage.yv1;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ThemeModel {
    public static final ThemeModel EMPTY = new ThemeModel("EMPTY");
    private boolean isDark;
    private String name;
    private yv1 rawTheme;
    private bd4 theme;
    private tw1 themeSource;

    public ThemeModel(tw1 tw1Var) {
        this.themeSource = tw1Var;
        this.name = l44.a.matcher(((ov1) tw1Var).b).replaceAll("");
    }

    public String getName() {
        return this.name;
    }

    public yv1 getRawTheme() {
        return this.rawTheme;
    }

    public bd4 getTheme() {
        return this.theme;
    }

    public tw1 getThemeSource() {
        return this.themeSource;
    }

    public boolean isDark() {
        return this.isDark;
    }

    public boolean isLoaded() {
        return this.theme != null;
    }

    public void load(List<String> list) throws IOException {
        td3 td3Var;
        tw1 tw1Var = this.themeSource;
        ov1 ov1Var = (ov1) tw1Var;
        ov1Var.getClass();
        StringReader stringReader = new StringReader(ov1Var.a.toString());
        try {
            int iG = fw.G(((ov1) tw1Var).c);
            vd3 vd3Var = ud3.a;
            if (iG == 0) {
                td3Var = (td3) u94.a.c(stringReader, vd3Var);
            } else if (iG != 1) {
                y94.b.getClass();
                td3Var = (td3) y94.a(stringReader, vd3Var);
            } else {
                td3Var = (td3) aa4.c.c(stringReader, vd3Var);
            }
            stringReader.close();
            this.rawTheme = td3Var;
            this.theme = bd4.a(td3Var, list);
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void setDark(boolean z) {
        this.isDark = z;
    }

    public ThemeModel(tw1 tw1Var, String str) {
        this.themeSource = tw1Var;
        this.name = str;
    }

    private ThemeModel(String str) {
        this.themeSource = null;
        this.rawTheme = null;
        this.name = str;
        this.theme = bd4.a(null, null);
    }

    public void load() {
        load(null);
    }
}
