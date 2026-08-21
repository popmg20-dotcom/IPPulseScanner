package defpackage;

import android.content.SharedPreferences;
import android.util.Base64;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.sentry.android.core.a1;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fx1 {
    public static final String[] c = {WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, "FCM", "GCM", ""};
    public final SharedPreferences a;
    public final String b;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public fx1(ze1 ze1Var) {
        ze1Var.a();
        this.a = ze1Var.a.getSharedPreferences("com.google.android.gms.appid", 0);
        ze1Var.a();
        ff1 ff1Var = ze1Var.c;
        String str = ff1Var.e;
        if (str == null) {
            ze1Var.a();
            str = ff1Var.b;
            if (str.startsWith("1:") || str.startsWith("2:")) {
                String[] strArrSplit = str.split(":");
                if (strArrSplit.length != 4) {
                    str = null;
                } else {
                    str = strArrSplit[1];
                    if (str.isEmpty()) {
                    }
                }
            }
        }
        this.b = str;
    }

    public final String a() {
        String string;
        synchronized (this.a) {
            string = this.a.getString("|S|id", null);
        }
        return string;
    }

    public final String b() {
        PublicKey publicKeyGeneratePublic;
        synchronized (this.a) {
            String strEncodeToString = null;
            String string = this.a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            try {
                publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                a1.n("ContentValues", "Invalid key stored " + e);
                publicKeyGeneratePublic = null;
            }
            if (publicKeyGeneratePublic == null) {
                return null;
            }
            try {
                byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKeyGeneratePublic.getEncoded());
                bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & DnsRecord.CLASS_ANY);
                strEncodeToString = Base64.encodeToString(bArrDigest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
                a1.n("ContentValues", "Unexpected error, device missing required algorithms");
            }
            return strEncodeToString;
        }
    }
}
