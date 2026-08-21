package defpackage;

import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class th2 extends g0 {
    public final /* synthetic */ uh2 b;

    public th2(uh2 uh2Var) {
        this.b = uh2Var;
    }

    @Override // defpackage.g0
    public final int a() {
        return this.b.a.groupCount() + 1;
    }

    public final kh2 b(int i) {
        Matcher matcher = this.b.a;
        b12 b12VarD0 = gb4.d0(matcher.start(i), matcher.end(i));
        if (b12VarD0.b < 0) {
            return null;
        }
        String strGroup = matcher.group(i);
        strGroup.getClass();
        return new kh2(strGroup, b12VarD0);
    }

    @Override // defpackage.g0, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof kh2) {
            return super.contains((kh2) obj);
        }
        return false;
    }

    @Override // defpackage.g0, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new mg4(new go1(new j70(0, e70.I(this)), new f0(12, this), 1));
    }
}
