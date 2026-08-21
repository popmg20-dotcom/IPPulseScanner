package io.netty.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() { // from class: io.netty.util.AttributeKey.1
        @Override // io.netty.util.ConstantPool
        public AttributeKey<Object> newConstant(int i, String str) {
            return new AttributeKey<>(i, str);
        }
    };

    public static boolean exists(String str) {
        return pool.exists(str);
    }

    public static <T> AttributeKey<T> newInstance(String str) {
        return (AttributeKey) pool.newInstance(str);
    }

    public static <T> AttributeKey<T> valueOf(String str) {
        return (AttributeKey) pool.valueOf(str);
    }

    private AttributeKey(int i, String str) {
        super(i, str);
    }

    public static <T> AttributeKey<T> valueOf(Class<?> cls, String str) {
        return (AttributeKey) pool.valueOf(cls, str);
    }
}
