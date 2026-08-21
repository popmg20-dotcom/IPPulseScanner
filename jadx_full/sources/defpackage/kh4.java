package defpackage;

import io.github.rosemoe.sora.langs.textmate.registry.model.DefaultGrammarDefinition;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kh4 extends ct3 {
    public final t82 a;
    public final iq1 b;
    public final bk4 c;
    public final ii4 d;
    public final l74 e = new l74(3);
    public final boolean f;
    public volatile hi4 g;

    public kh4(t82 t82Var, iq1 iq1Var, bk4 bk4Var, ii4 ii4Var, boolean z) {
        this.a = t82Var;
        this.b = iq1Var;
        this.c = bk4Var;
        this.d = ii4Var;
        this.f = z;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        boolean z;
        y42 y42Var;
        BufferedReader bufferedReader;
        StringBuilder sb;
        char[] cArr;
        t82 t82Var = this.a;
        if (t82Var == null) {
            hi4 hi4VarE = this.g;
            if (hi4VarE == null) {
                hi4VarE = this.b.e(this.d, this.c);
                this.g = hi4VarE;
            }
            return hi4VarE.b(r62Var);
        }
        int i = 1;
        try {
            try {
                r62Var.X();
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                y42Var = (y42) mj4.z.b(r62Var);
            } catch (EOFException e2) {
                e = e2;
                z = false;
                if (!z) {
                    throw new l52(e);
                }
                y42Var = f62.b;
            }
            if (this.f) {
                y42Var.getClass();
                if (y42Var instanceof f62) {
                    return null;
                }
            }
            Type type = this.c.b;
            l74 l74Var = this.e;
            switch (t82Var.a) {
                case 0:
                    return LanguageConfiguration.lambda$load$0(y42Var, type, l74Var);
                case 1:
                    return LanguageConfiguration.lambda$load$7(y42Var, type, l74Var);
                case 2:
                    return LanguageConfiguration.lambda$load$1(y42Var, type, l74Var);
                case 3:
                    return LanguageConfiguration.lambda$load$2(y42Var, type, l74Var);
                case 4:
                    return LanguageConfiguration.lambda$load$3(y42Var, type, l74Var);
                case 5:
                    return LanguageConfiguration.lambda$load$4(y42Var, type, l74Var);
                case 6:
                    return LanguageConfiguration.lambda$load$5(y42Var, type, l74Var);
                case 7:
                    return LanguageConfiguration.lambda$load$6(y42Var, type, l74Var);
                default:
                    g62 g62VarC = y42Var.c();
                    String strD = g62VarC.h("grammar").d();
                    String strD2 = g62VarC.h("name").d();
                    String strD3 = g62VarC.h("scopeName").d();
                    y42 y42VarH = g62VarC.h("embeddedLanguages");
                    g62 g62VarC2 = (y42VarH == null || !(y42VarH instanceof g62)) ? null : y42VarH.c();
                    y42 y42VarH2 = g62VarC.h("languageConfiguration");
                    String strD4 = (y42VarH2 == null || (y42VarH2 instanceof f62)) ? null : y42VarH2.d();
                    InputStream inputStreamD = vd1.a().d(strD);
                    if (inputStreamD == null) {
                        xe.k("grammar file can not be opened");
                        return null;
                    }
                    Charset charsetDefaultCharset = Charset.defaultCharset();
                    String lowerCase = strD.substring(strD.lastIndexOf(46) + 1).trim().toLowerCase();
                    lowerCase.getClass();
                    switch (lowerCase) {
                        case "xml":
                        case "plist":
                        case "tmlanguage":
                            i = 3;
                            break;
                        case "yml":
                        case "yaml":
                        case "yaml-tmlanguage":
                            i = 2;
                            break;
                        case "json":
                            break;
                        default:
                            xe.k("Unsupported file type: ".concat(strD));
                            return null;
                    }
                    try {
                        if (charsetDefaultCharset == null) {
                            charsetDefaultCharset = StandardCharsets.UTF_8;
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStreamD, charsetDefaultCharset));
                        try {
                            sb = new StringBuilder();
                            cArr = new char[16384];
                        } finally {
                            try {
                                break;
                            } catch (Throwable th) {
                            }
                        }
                    } catch (Exception e3) {
                        vp1.p(e3);
                        return null;
                    }
                    while (true) {
                        int i2 = bufferedReader.read(cArr);
                        if (i2 == -1) {
                            ov1 ov1Var = new ov1(strD, sb, i);
                            bufferedReader.close();
                            DefaultGrammarDefinition defaultGrammarDefinitionWithLanguageConfiguration = DefaultGrammarDefinition.withLanguageConfiguration(ov1Var, strD4, strD2, strD3);
                            if (g62VarC2 == null) {
                                return defaultGrammarDefinitionWithLanguageConfiguration;
                            }
                            HashMap map = new HashMap();
                            Iterator it = ((nb2) g62VarC2.b.entrySet()).iterator();
                            while (((mb2) it).hasNext()) {
                                ob2 ob2VarB = ((mb2) it).b();
                                y42 y42Var2 = (y42) ob2VarB.getValue();
                                y42Var2.getClass();
                                if (!(y42Var2 instanceof f62)) {
                                    map.put((String) ob2VarB.getKey(), y42Var2.d());
                                }
                            }
                            return defaultGrammarDefinitionWithLanguageConfiguration.withEmbeddedLanguages(map);
                        }
                        if (i2 > 0) {
                            sb.append(cArr, 0, i2);
                        }
                        vp1.p(e3);
                        return null;
                    }
            }
        } catch (NumberFormatException e4) {
            throw new l52(e4);
        } catch (wf2 e5) {
            throw new l52(e5);
        } catch (IOException e6) {
            throw new l52(e6);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) {
        hi4 hi4VarE = this.g;
        if (hi4VarE == null) {
            hi4VarE = this.b.e(this.d, this.c);
            this.g = hi4VarE;
        }
        hi4VarE.c(v72Var, obj);
    }

    @Override // defpackage.ct3
    public final hi4 d() {
        hi4 hi4Var = this.g;
        if (hi4Var != null) {
            return hi4Var;
        }
        hi4 hi4VarE = this.b.e(this.d, this.c);
        this.g = hi4VarE;
        return hi4VarE;
    }
}
