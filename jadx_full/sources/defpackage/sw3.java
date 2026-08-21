package defpackage;

import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.Collections;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sw3 extends k70 {
    static {
        Collections.unmodifiableNavigableSet((NavigableSet) Stream.CC.of("ssh-rsa", "rsa-sha2-256", "rsa-sha2-512").collect(Collectors.toCollection(new v6(5))));
    }
}
