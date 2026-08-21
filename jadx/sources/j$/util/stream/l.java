package j$.util.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends f5 {
    public final /* synthetic */ int b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(a aVar, j5 j5Var, int i) {
        super(j5Var);
        this.b = i;
        this.c = aVar;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.b;
        j5 j5Var = this.a;
        switch (i) {
            case 0:
                if (!((Set) this.c).contains(obj)) {
                    ((Set) this.c).add(obj);
                    j5Var.accept(obj);
                }
                break;
            case 1:
                ((Consumer) ((q) this.c).m).accept(obj);
                j5Var.accept(obj);
                break;
            case 2:
                if (((Predicate) ((q) this.c).m).test(obj)) {
                    j5Var.accept(obj);
                }
                break;
            case 3:
                j5Var.accept(((Function) ((q) this.c).m).apply(obj));
                break;
            case 4:
                j5Var.accept(((ToIntFunction) ((t0) this.c).m).applyAsInt(obj));
                break;
            case 5:
                j5Var.accept(((ToLongFunction) ((e1) this.c).m).applyAsLong(obj));
                break;
            default:
                j5Var.accept(((ToDoubleFunction) ((w) this.c).m).applyAsDouble(obj));
                break;
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public void c(long j) {
        switch (this.b) {
            case 0:
                this.c = new HashSet();
                this.a.c(-1L);
                break;
            case 1:
            default:
                super.c(j);
                break;
            case 2:
                this.a.c(-1L);
                break;
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public void end() {
        switch (this.b) {
            case 0:
                this.c = null;
                this.a.end();
                break;
            default:
                super.end();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(j5 j5Var) {
        super(j5Var);
        this.b = 0;
    }
}
