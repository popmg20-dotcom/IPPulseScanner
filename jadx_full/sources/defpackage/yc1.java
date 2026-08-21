package defpackage;

import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yc1 extends k44 {
    public final /* synthetic */ int G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ yc1(String str, pk3 pk3Var, pk3 pk3Var2, int i) {
        super(str, pk3Var, pk3Var2);
        this.G0 = i;
    }

    @Override // defpackage.k44, defpackage.aj3
    public ue1 j(jr2 jr2Var) {
        switch (this.G0) {
            case 0:
                ue1 ue1VarJ = super.j(jr2Var);
                Object obj = ue1VarJ.b;
                String str = (String) obj;
                if (str != null) {
                    Pattern patternCompile = Pattern.compile("<iframe src='([^']+)'");
                    patternCompile.getClass();
                    Matcher matcher = patternCompile.matcher(str);
                    matcher.getClass();
                    uh2 uh2VarK = p95.k(matcher, 0, str);
                    if (uh2VarK != null) {
                        try {
                            return new ue1(((sh2) uh2VarK.a()).get(1), (ju) ue1VarJ.z);
                        } catch (Throwable th) {
                            return new ue1(new ns4(th));
                        }
                    }
                }
                return new ue1(new ns4("Decode failed: " + obj));
            case 1:
                ue1 ue1VarJ2 = super.j(jr2Var);
                Object obj2 = ue1VarJ2.b;
                String str2 = (String) obj2;
                if (str2 != null) {
                    Pattern patternCompile2 = Pattern.compile("您的DNS地址信息: " + Patterns.IP_ADDRESS.pattern());
                    patternCompile2.getClass();
                    Matcher matcher2 = patternCompile2.matcher(str2);
                    matcher2.getClass();
                    uh2 uh2VarK2 = p95.k(matcher2, 0, str2);
                    if (uh2VarK2 != null) {
                        return new ue1(((sh2) uh2VarK2.a()).get(1), (ju) ue1VarJ2.z);
                    }
                }
                return new ue1(new ns4("Decode failed: " + obj2));
            default:
                return super.j(jr2Var);
        }
    }
}
