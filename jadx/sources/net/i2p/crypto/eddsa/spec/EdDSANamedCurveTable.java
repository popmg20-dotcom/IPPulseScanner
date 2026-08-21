package net.i2p.crypto.eddsa.spec;

import java.util.HashMap;
import java.util.Locale;
import net.i2p.crypto.eddsa.Utils;
import net.i2p.crypto.eddsa.math.Curve;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519LittleEndianEncoding;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519ScalarOps;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSANamedCurveTable {
    public static final EdDSANamedCurveSpec a;
    public static volatile HashMap b;

    static {
        byte[] bArrB = Utils.b("edffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff7f");
        Ed25519LittleEndianEncoding ed25519LittleEndianEncoding = new Ed25519LittleEndianEncoding();
        Curve curve = new Curve(new Field(bArrB, ed25519LittleEndianEncoding), Utils.b("a3785913ca4deb75abd841414d0a700098e879777940c78c73fe6f2bee6c0352"), ed25519LittleEndianEncoding.b(Utils.b("b0a00e4a271beec478e42fad0618432fa7d7fb3d99004d2b0bdfc14f8024832b")));
        EdDSANamedCurveSpec edDSANamedCurveSpec = new EdDSANamedCurveSpec(curve, new Ed25519ScalarOps(), new GroupElement(curve, Utils.b("5866666666666666666666666666666666666666666666666666666666666666"), true));
        a = edDSANamedCurveSpec;
        b = new HashMap();
        String lowerCase = edDSANamedCurveSpec.X.toLowerCase(Locale.ENGLISH);
        synchronized (EdDSANamedCurveTable.class) {
            HashMap map = new HashMap(b);
            map.put(lowerCase, edDSANamedCurveSpec);
            b = map;
        }
    }
}
