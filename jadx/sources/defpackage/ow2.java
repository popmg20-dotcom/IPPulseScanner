package defpackage;

import java.io.Serializable;
import java.util.HashMap;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ow2 implements Serializable {
    public static final ow2 A;
    public static final Class f = Node.class;
    public static final y22 z;
    public final HashMap b;

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    static {
        y22 y22Var = null;
        try {
            y22Var = x22.a;
        } catch (Throwable th) {
            v02.A(th);
        }
        z = y22Var;
        A = new ow2();
    }

    public ow2() {
        HashMap map = new HashMap();
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this.b = map2;
        map2.put("java.sql.Timestamp", wj0.Z);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public static Object a(nj4 nj4Var, Class cls) {
        try {
            return n50.f(cls, false);
        } catch (Throwable th) {
            v02.A(th);
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + n50.m(nj4Var) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    public static Object b(nj4 nj4Var, String str) {
        try {
            return a(nj4Var, Class.forName(str));
        } catch (Throwable th) {
            v02.A(th);
            StringBuilder sbD = fw.D("Failed to find class `", str, "` for handling values of type ");
            sbD.append(n50.m(nj4Var));
            sbD.append(", problem: (");
            sbD.append(th.getClass().getName());
            sbD.append(") ");
            st4.m(sbD, th.getMessage());
            return null;
        }
    }
}
