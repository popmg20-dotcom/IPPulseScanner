package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class cm implements IntFunction {
    public final /* synthetic */ int a;

    @Override // java.util.function.IntFunction
    public final Object apply(int i) {
        switch (this.a) {
            case 0:
                return new String[i];
            case 1:
                return new wn3[i];
            case 2:
                return new wn3[i];
            case 3:
                return p30.a(String.valueOf(Character.toChars(i)));
            case 4:
                return new ArrayList(i);
            case 5:
                return new HashMap(i);
            default:
                return new HashSet(i);
        }
    }
}
