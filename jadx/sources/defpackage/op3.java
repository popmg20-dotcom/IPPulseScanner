package defpackage;

import j$.util.Objects;
import j$.util.Optional;
import j$.util.stream.Collectors;
import j$.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class op3 extends fs2 {
    public final Optional d;
    public final qp3 e;
    public final String f;
    public final dt0 g;

    public op3(Optional optional, Optional optional2, dt0 dt0Var, String str, qp3 qp3Var, Optional optional3, Optional optional4) {
        super(optional, optional3, optional4);
        Objects.requireNonNull(optional2);
        this.d = optional2;
        this.g = dt0Var;
        this.f = str;
        Objects.requireNonNull(qp3Var);
        this.e = qp3Var;
    }

    @Override // defpackage.x51
    public final int a() {
        return 7;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("=VAL");
        this.c.ifPresent(new y60(2, sb));
        dt0 dt0Var = this.g;
        if (!dt0Var.b && !dt0Var.c) {
            this.d.ifPresent(new y60(3, sb));
        }
        sb.append(" ");
        sb.append(this.e.toString());
        sb.append((String) IntStream.VivifiedWrapper.convert(this.f.codePoints()).filter(new np3()).mapToObj(new cm(3)).collect(Collectors.joining("")));
        return sb.toString();
    }
}
