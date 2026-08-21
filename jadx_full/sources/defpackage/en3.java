package defpackage;

import android.system.OsConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class en3 {
    public static final /* synthetic */ en3[] A;
    public final String b;
    public final int f;
    public final Integer z;

    /* JADX INFO: Fake field, exist only in values array */
    en3 EF0;

    static {
        int i = OsConstants.IPPROTO_TCP;
        en3 en3Var = new en3("HTTP", 0, "HTTP", i, 80);
        en3 en3Var2 = new en3("HTTPS", 1, "HTTPS", i, 443);
        en3 en3Var3 = new en3(RtspHeaders.Values.TCP, 2, RtspHeaders.Values.TCP, i, null);
        int i2 = OsConstants.IPPROTO_UDP;
        A = new en3[]{en3Var, en3Var2, en3Var3, new en3(RtspHeaders.Values.UDP, 3, RtspHeaders.Values.UDP, i2, null), new en3("QUIC", 4, "QUIC", i2, 443)};
    }

    public en3(String str, int i, String str2, int i2, Integer num) {
        this.b = str2;
        this.f = i2;
        this.z = num;
    }

    public static en3 valueOf(String str) {
        return (en3) Enum.valueOf(en3.class, str);
    }

    public static en3[] values() {
        return (en3[]) A.clone();
    }
}
