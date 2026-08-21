package defpackage;

import io.github.rosemoe.sora.langs.textmate.registry.model.GrammarDefinition;
import j$.util.function.Function$CC;
import java.io.InterruptedIOException;
import java.util.Properties;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class um0 implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ um0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                InterruptedIOException interruptedIOException = new InterruptedIOException((String) obj);
                interruptedIOException.initCause((InterruptedException) obj2);
                return interruptedIOException;
            case 1:
                zp1 zp1Var = (zp1) obj2;
                GrammarDefinition grammarDefinition = (GrammarDefinition) obj;
                synchronized (zp1Var) {
                    String name = grammarDefinition.getName();
                    if (zp1Var.d.containsKey(name) && grammarDefinition.getScopeName() != null) {
                        return zp1Var.a.a(grammarDefinition.getScopeName(), null, null);
                    }
                    nv1 nv1VarA = zp1Var.a(grammarDefinition);
                    if (grammarDefinition.getScopeName() != null) {
                        zp1Var.d.put(name, grammarDefinition.getScopeName());
                        zp1Var.e.put(((xp1) nv1VarA).a, grammarDefinition);
                    }
                    return nv1VarA;
                }
            case 2:
                return ((Properties) obj2).get((String) obj);
            default:
                return ((fd4) obj2).b((String) obj);
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.a;
        return Function$CC.$default$compose(this, function);
    }
}
