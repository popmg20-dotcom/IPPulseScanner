package defpackage;

import j$.util.Collection;
import j$.util.Objects;
import j$.util.function.Function$CC;
import j$.util.stream.Collectors;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qh3 {
    public boolean b;
    public n80 c;
    public final ArrayList a = new ArrayList();
    public final n80[][] d = (n80[][]) Array.newInstance((Class<?>) n80.class, 2, 2);

    public final void a(oh3 oh3Var) {
        this.a.add(oh3Var);
        if (this.b) {
            return;
        }
        this.b = oh3Var.d != null;
    }

    public final n80 b(final boolean z, final boolean z2) {
        boolean z3 = this.b;
        ArrayList arrayList = this.a;
        if (!z3) {
            n80 n80Var = this.c;
            if (n80Var != null) {
                return n80Var;
            }
            n80 n80Var2 = new n80((List) Collection.EL.stream(arrayList).map(new hl(12)).collect(Collectors.toList()), (wn3[]) Collection.EL.stream(arrayList).map(new hl(13)).toArray(new cm(1)));
            this.c = n80Var2;
            return n80Var2;
        }
        n80[] n80VarArr = this.d[z ? 1 : 0];
        n80 n80Var3 = n80VarArr[z2 ? 1 : 0];
        if (n80Var3 != null) {
            return n80Var3;
        }
        n80 n80Var4 = new n80((List) Collection.EL.stream(arrayList).map(new Function() { // from class: ph3
            public /* synthetic */ Function andThen(Function function) {
                return Function$CC.$default$andThen(this, function);
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                oh3 oh3Var = (oh3) obj;
                String[][] strArr = oh3Var.d;
                return strArr == null ? oh3Var.a : strArr[z ? 1 : 0][z2 ? 1 : 0];
            }

            public /* synthetic */ Function compose(Function function) {
                return Function$CC.$default$compose(this, function);
            }
        }).collect(Collectors.toList()), (wn3[]) Collection.EL.stream(arrayList).map(new hl(14)).toArray(new cm(2)));
        n80VarArr[z2 ? 1 : 0] = n80Var4;
        return n80Var4;
    }

    public final void c(int i, String str) {
        oh3 oh3Var = (oh3) this.a.get(i);
        if (Objects.equals(oh3Var.a, str)) {
            return;
        }
        this.c = null;
        n80[][] n80VarArr = this.d;
        n80VarArr[0][0] = null;
        n80VarArr[0][1] = null;
        n80[] n80VarArr2 = n80VarArr[1];
        n80VarArr2[0] = null;
        n80VarArr2[1] = null;
        if (Objects.equals(oh3Var.a, str)) {
            return;
        }
        oh3Var.a = str;
        if (oh3Var.d != null) {
            oh3Var.d = oh3Var.a();
        }
    }
}
