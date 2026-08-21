package defpackage;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w83 implements v83 {
    public final /* synthetic */ ConcurrentHashMap b;

    public w83(ConcurrentHashMap concurrentHashMap) {
        this.b = concurrentHashMap;
    }

    @Override // defpackage.v83
    public final Map F() {
        return this.b;
    }

    @Override // defpackage.v83
    public final v83 q0() {
        return null;
    }

    public final String toString() {
        return Objects.toString(this.b);
    }
}
