package defpackage;

import com.getsurfboard.vpn.Jni;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o32 implements Function2 {
    public final /* synthetic */ Jni b;
    public final /* synthetic */ k93 f;
    public final /* synthetic */ String z;

    public /* synthetic */ o32(Jni jni, k93 k93Var, String str) {
        this.b = jni;
        this.f = k93Var;
        this.z = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        Jni.k(this.b, this.f, this.z, (DefaultDnsResponse) obj, (byte[]) obj2);
        return xl4.a;
    }
}
