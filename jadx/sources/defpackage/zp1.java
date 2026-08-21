package defpackage;

import io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition;
import io.github.rosemoe.sora.langs.textmate.registry.model.ThemeModel;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zp1 {
    public static zp1 f;
    public final ai3 a = new ai3();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final LinkedHashMap d = new LinkedHashMap();
    public final LinkedHashMap e = new LinkedHashMap();

    public static synchronized zp1 c() {
        try {
            if (f == null) {
                final zp1 zp1Var = new zp1();
                f = zp1Var;
                ed4 ed4VarB = ed4.B();
                dd4 dd4Var = new dd4() { // from class: yp1
                    @Override // defpackage.dd4
                    public final void b(ThemeModel themeModel) {
                        try {
                            this.a.f(themeModel);
                        } catch (Exception e) {
                            vp1.p(e);
                        }
                    }
                };
                if (!((ArrayList) ed4VarB.f).contains(dd4Var)) {
                    ed4VarB.h(dd4Var);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f;
    }

    public final synchronized nv1 a(GrammarDefinition grammarDefinition) {
        nv1 nv1VarB;
        InputStream inputStreamD;
        try {
            String languageConfiguration = grammarDefinition.getLanguageConfiguration();
            if (languageConfiguration != null && (inputStreamD = vd1.a().d(languageConfiguration)) != null) {
                this.b.put(grammarDefinition.getScopeName(), LanguageConfiguration.load(new InputStreamReader(inputStreamD)));
            }
            boolean zIsEmpty = grammarDefinition.getEmbeddedLanguages().isEmpty();
            ai3 ai3Var = this.a;
            nv1VarB = !zIsEmpty ? ai3Var.b(grammarDefinition.getGrammar(), null, null) : ai3Var.b(grammarDefinition.getGrammar(), Integer.valueOf(d(grammarDefinition.getScopeName())), b(grammarDefinition.getEmbeddedLanguages()));
            if (grammarDefinition.getScopeName() != null && !((xp1) nv1VarB).a.equals(grammarDefinition.getScopeName())) {
                throw new IllegalStateException("The scope name loaded by the grammar file does not match the declared scope name, it should be " + ((xp1) nv1VarB).a + " instead of " + grammarDefinition.getScopeName());
            }
        } finally {
        }
        return nv1VarB;
    }

    public final synchronized HashMap b(Map map) {
        HashMap map2;
        String str;
        map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (!this.e.containsKey(str3) && (str = (String) this.d.get(str3)) != null) {
                str3 = str;
            }
            map2.put(str2, Integer.valueOf(d(str3)));
        }
        return map2;
    }

    public final synchronized int d(String str) {
        Integer numValueOf;
        try {
            numValueOf = (Integer) this.c.get(str);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.c.size() + 2);
            }
            this.c.put(str, numValueOf);
        } catch (Throwable th) {
            throw th;
        }
        return numValueOf.intValue();
    }

    public final void e() {
        List listA = fx3.A();
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            d(((GrammarDefinition) it.next()).getScopeName());
        }
    }

    public final synchronized void f(ThemeModel themeModel) {
        try {
            if (!themeModel.isLoaded()) {
                themeModel.load(new ArrayList(((bd4) this.a.a.X).b.d.keySet()));
            }
            this.a.c(themeModel.getTheme());
        } catch (Throwable th) {
            throw th;
        }
    }
}
