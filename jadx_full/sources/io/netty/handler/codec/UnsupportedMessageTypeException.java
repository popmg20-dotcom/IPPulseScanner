package io.netty.handler.codec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class UnsupportedMessageTypeException extends CodecException {
    private static final long serialVersionUID = 2799598826487038726L;

    public UnsupportedMessageTypeException(Object obj, Class<?>... clsArr) {
        super(message(obj == null ? "null" : obj.getClass().getName(), clsArr));
    }

    private static String message(String str, Class<?>... clsArr) {
        Class<?> cls;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr != null && clsArr.length > 0) {
            sb.append(" (expected: ");
            sb.append(clsArr[0].getName());
            for (int i = 1; i < clsArr.length && (cls = clsArr[i]) != null; i++) {
                sb.append(", ");
                sb.append(cls.getName());
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public UnsupportedMessageTypeException() {
    }

    public UnsupportedMessageTypeException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedMessageTypeException(String str) {
        super(str);
    }

    public UnsupportedMessageTypeException(Throwable th) {
        super(th);
    }
}
