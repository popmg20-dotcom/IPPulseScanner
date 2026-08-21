package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class gk4 extends ek4 {
    public final Class F0;
    public final Constructor G0;
    public final Method H0;
    public final Method I0;
    public final Method J0;
    public final Method K0;
    public final Method L0;

    public gk4() throws NoSuchMethodException {
        Method methodA0;
        Constructor<?> constructor;
        Method methodZ;
        Method method;
        Method method2;
        Method method3;
        super(23);
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodZ = Z(cls2);
            Class<?> cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodA0 = a0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            a1.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodA0 = null;
            constructor = null;
            methodZ = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.F0 = cls;
        this.G0 = constructor;
        this.H0 = methodZ;
        this.I0 = method;
        this.J0 = method2;
        this.K0 = method3;
        this.L0 = methodA0;
    }

    public static Method Z(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean W(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.H0.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface X(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.F0, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.L0.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean Y(Object obj) {
        try {
            return ((Boolean) this.J0.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method a0(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // defpackage.ek4, defpackage.uf2
    public final Typeface l(Context context, hi1 hi1Var, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.H0;
        if (method == null) {
            a1.n("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.l(context, hi1Var, resources, i);
        }
        try {
            objNewInstance = this.G0.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            ii1[] ii1VarArr = hi1Var.a;
            int length = ii1VarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    ii1 ii1Var = ii1VarArr[i2];
                    String str = ii1Var.a;
                    int i3 = ii1Var.e;
                    int i4 = ii1Var.b;
                    boolean z = ii1Var.c;
                    FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(ii1Var.d);
                    gk4 gk4Var = this;
                    Context context2 = context;
                    if (gk4Var.W(context2, objNewInstance, str, i3, i4, z ? 1 : 0, fontVariationAxisArrFromFontVariationSettings)) {
                        i2++;
                        this = gk4Var;
                        context = context2;
                    } else {
                        try {
                            gk4Var.K0.invoke(objNewInstance, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else {
                    gk4 gk4Var2 = this;
                    if (gk4Var2.Y(objNewInstance)) {
                        return gk4Var2.X(objNewInstance);
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @Override // defpackage.ek4, defpackage.uf2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Typeface m(Context context, ki1[] ki1VarArr, int i) throws IOException {
        Object objNewInstance;
        Typeface typefaceX;
        boolean zBooleanValue;
        if (ki1VarArr.length >= 1) {
            Method method = this.H0;
            if (method == null) {
                a1.n("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap map = new HashMap();
                    for (ki1 ki1Var : ki1VarArr) {
                        if (ki1Var.f == 0) {
                            Uri uri = ki1Var.a;
                            if (!map.containsKey(uri)) {
                                map.put(uri, vf2.y(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = DesugarCollections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.G0.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = ki1VarArr.length;
                        int i2 = 0;
                        boolean z = false;
                        while (true) {
                            Method method2 = this.K0;
                            if (i2 < length) {
                                ki1 ki1Var2 = ki1VarArr[i2];
                                ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(ki1Var2.a);
                                if (byteBuffer != null) {
                                    try {
                                        zBooleanValue = ((Boolean) this.I0.invoke(objNewInstance, byteBuffer, Integer.valueOf(ki1Var2.b), null, Integer.valueOf(ki1Var2.c), Integer.valueOf(ki1Var2.d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        zBooleanValue = false;
                                    }
                                    if (!zBooleanValue) {
                                        method2.invoke(objNewInstance, null);
                                        break;
                                    }
                                    z = true;
                                }
                                i2++;
                                z = z;
                            } else if (!z) {
                                method2.invoke(objNewInstance, null);
                            } else if (Y(objNewInstance) && (typefaceX = X(objNewInstance)) != null) {
                                return Typeface.create(typefaceX, i);
                            }
                        }
                    }
                } else {
                    ki1 ki1VarP = uf2.p(ki1VarArr, i);
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(ki1VarP.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(ki1VarP.c).setItalic(ki1VarP.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } finally {
                        }
                    } else if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // defpackage.uf2
    public final Typeface o(Context context, Resources resources, int i, String str, int i2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.H0;
        if (method == null) {
            a1.n("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.o(context, resources, i, str, i2);
        }
        try {
            objNewInstance = this.G0.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!W(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.K0.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (Y(objNewInstance)) {
                return X(objNewInstance);
            }
        }
        return null;
    }
}
