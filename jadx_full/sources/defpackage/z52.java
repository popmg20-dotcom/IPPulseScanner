package defpackage;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z52 implements Serializable {
    public String A;
    public transient Object b;
    public final String f;
    public int z = -1;

    public z52(Object obj, String str) {
        this.b = obj;
        if (str != null) {
            this.f = str;
        } else {
            zo2.n("Cannot pass null fieldName");
            throw null;
        }
    }

    public final String toString() {
        String str = this.A;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Object obj = this.b;
        if (obj != null) {
            Class<?> componentType = obj instanceof Class ? (Class) obj : obj.getClass();
            int i = 0;
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
                i++;
            }
            sb.append(componentType.getName());
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                sb.append("[]");
            }
        } else {
            sb.append("UNKNOWN");
        }
        sb.append('[');
        String str2 = this.f;
        if (str2 != null) {
            sb.append(StringUtil.DOUBLE_QUOTE);
            sb.append(str2);
            sb.append(StringUtil.DOUBLE_QUOTE);
        } else {
            int i2 = this.z;
            if (i2 >= 0) {
                sb.append(i2);
            } else {
                sb.append('?');
            }
        }
        sb.append(']');
        String string = sb.toString();
        this.A = string;
        return string;
    }
}
