package defpackage;

import com.tencent.mars.xlog.Xlog;
import j$.util.Optional;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import org.eclipse.tm4e.languageconfiguration.internal.model.AutoClosingPairConditional;
import org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair;
import org.eclipse.tm4e.languageconfiguration.internal.model.CommentRule;
import org.eclipse.tm4e.languageconfiguration.internal.model.CompleteEnterAction;
import org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction;
import org.eclipse.tm4e.languageconfiguration.internal.model.FoldingRules;
import org.eclipse.tm4e.languageconfiguration.internal.model.IndentForEnter;
import org.eclipse.tm4e.languageconfiguration.internal.model.OnEnterRule;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class dg implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ dg(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((AutoClosingPairConditional) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 1:
                ((CharacterPair) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 2:
                ((CommentRule) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 3:
                ((CompleteEnterAction) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 4:
                ((EnterAction) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 5:
                ((FoldingRules) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 6:
                xp1 xp1Var = (xp1) obj2;
                StringBuilder sb = (StringBuilder) obj;
                sb.append("name=");
                sb.append((String) xp1Var.g.get("name"));
                sb.append(", ");
                sb.append("scopeName=");
                sb.append(xp1Var.a);
                break;
            case 7:
                ((IndentForEnter) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 8:
                StringBuilder sb2 = (StringBuilder) obj;
                sb2.append("pattern=");
                sb2.append(((g42) obj2).d);
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                StringBuilder sb3 = (StringBuilder) obj;
                sb3.append("pattern=");
                sb3.append(((bp2) obj2).a);
                break;
            case 10:
                ((OnEnterRule) obj2).lambda$toString$0((StringBuilder) obj);
                break;
            case 11:
                ((s03) obj2).X = Optional.of(((r53) obj).a());
                break;
            default:
                sn3 sn3Var = (sn3) obj2;
                StringBuilder sb4 = (StringBuilder) obj;
                sb4.append("id=");
                sb4.append(sn3Var.a);
                sb4.append(",name=");
                sb4.append(sn3Var.b);
                break;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
