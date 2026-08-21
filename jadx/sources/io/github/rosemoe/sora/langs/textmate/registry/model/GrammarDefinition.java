package io.github.rosemoe.sora.langs.textmate.registry.model;

import defpackage.pv1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface GrammarDefinition {
    Map<String, String> getEmbeddedLanguages();

    pv1 getGrammar();

    String getLanguageConfiguration();

    String getName();

    String getScopeName();
}
