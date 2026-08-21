package defpackage;

import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.eclipse.tm4e.languageconfiguration.internal.model.AutoClosingPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.AutoClosingPairConditional;
import org.eclipse.tm4e.languageconfiguration.internal.model.LanguageConfiguration;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hc4 extends n02 {
    public static final List z0;
    public final dc4 Z;
    public final boolean y0;

    static {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{"surroundingPair"}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        z0 = DesugarCollections.unmodifiableList(arrayList);
    }

    public hc4(dc4 dc4Var) {
        e84 e84Var = new e84(null);
        e84Var.E('{', new g84("{", "}"));
        e84Var.E('(', new g84("(", ")"));
        e84Var.E('[', new g84("[", "]"));
        e84Var.E(StringUtil.DOUBLE_QUOTE, new g84("\"", "\"", new c84(0)));
        e84Var.E('\'', new g84("'", "'", new d84(0)));
        super(e84Var);
        this.y0 = true;
        this.Z = dc4Var;
        X();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c3 A[EDGE_INSN: B:53:0x00c3->B:42:0x00c3 BREAK  A[LOOP:2: B:32:0x0091->B:41:0x00ba], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X() {
        LanguageConfiguration languageConfiguration;
        int[] iArr;
        HashMap map = (HashMap) this.z;
        if (this.y0 && (languageConfiguration = this.Z.c) != null) {
            ((HashMap) this.f).clear();
            map.clear();
            List<AutoClosingPair> surroundingPairs = languageConfiguration.getSurroundingPairs();
            List<AutoClosingPairConditional> autoClosingPairs = languageConfiguration.getAutoClosingPairs();
            ArrayList<AutoClosingPairConditional> arrayList = new ArrayList();
            if (autoClosingPairs != null) {
                arrayList.addAll(autoClosingPairs);
            }
            List<String> list = z0;
            if (surroundingPairs != null) {
                for (AutoClosingPair autoClosingPair : surroundingPairs) {
                    arrayList.add(new AutoClosingPairConditional(autoClosingPair.open, autoClosingPair.close, list));
                }
            }
            for (AutoClosingPairConditional autoClosingPairConditional : arrayList) {
                String str = autoClosingPairConditional.open;
                String str2 = autoClosingPairConditional.close;
                sn snVar = new sn();
                int i = 0;
                snVar.b = false;
                List<String> list2 = autoClosingPairConditional.notIn;
                if (list2 == null || list2.isEmpty()) {
                    snVar.f = null;
                } else if (list2.contains("surroundingPair")) {
                    snVar.b = true;
                    if (list2 != list) {
                        list2.remove("surroundingPair");
                        snVar.f = new int[list2.size()];
                        while (true) {
                            iArr = (int[]) snVar.f;
                            if (i < iArr.length) {
                                break;
                            }
                            String lowerCase = list2.get(i).toLowerCase();
                            lowerCase.getClass();
                            ((int[]) snVar.f)[i] = !lowerCase.equals("regex") ? !lowerCase.equals("comment") ? 2 : 1 : 3;
                            i++;
                        }
                        Arrays.sort(iArr);
                    }
                } else {
                    snVar.f = new int[list2.size()];
                    while (true) {
                        iArr = (int[]) snVar.f;
                        if (i < iArr.length) {
                        }
                        ((int[]) snVar.f)[i] = !lowerCase.equals("regex") ? !lowerCase.equals("comment") ? 2 : 1 : 3;
                        i++;
                    }
                    Arrays.sort(iArr);
                }
                g84 g84Var = new g84(str, str2, snVar);
                char[] charArray = str.toCharArray();
                char c = charArray[charArray.length - 1];
                List arrayList2 = (List) map.get(Character.valueOf(c));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(g84Var);
                map.put(Character.valueOf(c), arrayList2);
            }
        }
    }
}
