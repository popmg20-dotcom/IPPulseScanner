package defpackage;

import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zj {
    public static final yj a;

    static {
        yj yjVar = new yj("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        a = new yj(yjVar);
        byte[] bArr = yjVar.z;
        System.arraycopy(bArr, 0, new byte[64], 0, bArr.length);
        char[] cArr = yjVar.f;
        System.arraycopy(cArr, 0, new char[64], 0, cArr.length);
        int[] iArr = yjVar.b;
        System.arraycopy(iArr, 0, new int[128], 0, iArr.length);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf("+"), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        new yj("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
    }
}
