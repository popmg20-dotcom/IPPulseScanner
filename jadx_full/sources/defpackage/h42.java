package defpackage;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h42 {
    public final List a;

    public h42(List list) {
        this.a = (List) Collection.EL.stream(list).map(new hl(6)).collect(Collectors.toList());
    }
}
