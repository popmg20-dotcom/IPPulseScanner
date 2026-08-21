package io.github.rosemoe.sora.langs.textmate.registry.model;

import defpackage.l44;
import defpackage.ov1;
import defpackage.pv1;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class DefaultGrammarDefinition implements GrammarDefinition {
    private Map<String, String> embeddedLanguages;
    private pv1 grammarSource;
    private String languageConfigurationPath;
    private String name;
    private String scopeName;

    private DefaultGrammarDefinition(String str, String str2, pv1 pv1Var, String str3) {
        this.embeddedLanguages = null;
        this.name = str;
        this.scopeName = str2;
        this.grammarSource = pv1Var;
        this.languageConfigurationPath = str3;
    }

    public static DefaultGrammarDefinition withGrammarSource(pv1 pv1Var) {
        String strReplaceAll = l44.a.matcher(((ov1) pv1Var).b).replaceAll("");
        return withGrammarSource(pv1Var, strReplaceAll, "source." + strReplaceAll);
    }

    public static DefaultGrammarDefinition withLanguageConfiguration(pv1 pv1Var, String str) {
        String strReplaceAll = l44.a.matcher(((ov1) pv1Var).b).replaceAll("");
        return withLanguageConfiguration(pv1Var, str, strReplaceAll, "source." + strReplaceAll);
    }

    @Override // io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition
    public Map<String, String> getEmbeddedLanguages() {
        Map<String, String> map = this.embeddedLanguages;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    @Override // io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition
    public pv1 getGrammar() {
        return this.grammarSource;
    }

    @Override // io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition
    public String getLanguageConfiguration() {
        return this.languageConfigurationPath;
    }

    @Override // io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition
    public String getName() {
        return this.name;
    }

    @Override // io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition
    public String getScopeName() {
        return this.scopeName;
    }

    public GrammarDefinition withEmbeddedLanguages(Map<String, String> map) {
        return map == null ? this : new DefaultGrammarDefinition(this.name, this.scopeName, this.grammarSource, this.languageConfigurationPath, map);
    }

    private DefaultGrammarDefinition(String str, String str2, pv1 pv1Var, String str3, Map<String, String> map) {
        this(str, str2, pv1Var, str3);
        this.embeddedLanguages = map;
    }

    public static DefaultGrammarDefinition withGrammarSource(pv1 pv1Var, String str, String str2) {
        return new DefaultGrammarDefinition(str, str2, pv1Var, null);
    }

    public static DefaultGrammarDefinition withLanguageConfiguration(pv1 pv1Var, String str, String str2, String str3) {
        return new DefaultGrammarDefinition(str2, str3, pv1Var, str);
    }
}
