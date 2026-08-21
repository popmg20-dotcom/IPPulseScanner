package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fk4 extends uf2 {
    public static final Class A0;
    public static final Constructor B0;
    public static final Method C0;
    public static final Method D0;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            a1.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        B0 = constructor;
        A0 = cls;
        C0 = method2;
        D0 = method;
    }

    public static boolean U(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) C0.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface V(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) A0, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) D0.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // defpackage.uf2
    public final Typeface l(Context context, hi1 hi1Var, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        FileInputStream fileInputStream;
        try {
            objNewInstance = B0.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            for (ii1 ii1Var : hi1Var.a) {
                int i2 = ii1Var.f;
                File fileS = vf2.s(context);
                if (fileS != null) {
                    try {
                        if (vf2.g(fileS, resources, i2)) {
                            try {
                                fileInputStream = new FileInputStream(fileS);
                            } catch (IOException unused2) {
                                map = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (map != null && U(objNewInstance, map, ii1Var.e, ii1Var.b, ii1Var.c)) {
                                }
                            } finally {
                            }
                        }
                    } finally {
                        fileS.delete();
                    }
                }
                map = null;
                if (map != null) {
                }
            }
            return V(objNewInstance);
        }
        return null;
    }

    @Override // defpackage.uf2
    public final Typeface m(Context context, ki1[] ki1VarArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = B0.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int i2 = 0;
            xw3 xw3Var = new xw3(0);
            int length = ki1VarArr.length;
            while (true) {
                if (i2 < length) {
                    ki1 ki1Var = ki1VarArr[i2];
                    Uri uri = ki1Var.a;
                    ByteBuffer byteBufferY = (ByteBuffer) xw3Var.get(uri);
                    if (byteBufferY == null) {
                        byteBufferY = vf2.y(context, uri);
                        xw3Var.put(uri, byteBufferY);
                    }
                    if (byteBufferY == null || !U(objNewInstance, byteBufferY, ki1Var.b, ki1Var.c, ki1Var.d)) {
                        break;
                    }
                    i2++;
                } else {
                    Typeface typefaceV = V(objNewInstance);
                    if (typefaceV != null) {
                        return Typeface.create(typefaceV, i);
                    }
                }
            }
        }
        return null;
    }
}
