package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class do0 implements ss3 {
    public final CharSequence a;
    public final int b;
    public final Function2 c;

    public do0(CharSequence charSequence, int i, Function2 function2) {
        charSequence.getClass();
        this.a = charSequence;
        this.b = i;
        this.c = function2;
    }

    @Override // defpackage.ss3
    public final Iterator iterator() {
        return new co0(this);
    }
}
