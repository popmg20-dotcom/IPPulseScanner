package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class u83 implements v83 {
    public final /* synthetic */ int b;

    @Override // defpackage.v83
    public final Map F() {
        switch (this.b) {
            case 0:
                return Collections.EMPTY_MAP;
            default:
                return t84.f;
        }
    }

    @Override // defpackage.v83
    public final v83 q0() {
        switch (this.b) {
        }
        return null;
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return "EMPTY";
            default:
                return "SYSPROPS";
        }
    }
}
