package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.android.core.a1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ek4 extends uf2 {
    public static Class A0 = null;
    public static Constructor B0 = null;
    public static Method C0 = null;
    public static Method D0 = null;
    public static boolean E0 = false;

    public static boolean U(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        V();
        try {
            return ((Boolean) C0.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            vp1.p(e);
            return false;
        }
    }

    public static void V() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (E0) {
            return;
        }
        E0 = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            a1.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        B0 = constructor;
        A0 = cls;
        C0 = method2;
        D0 = method;
    }

    @Override // defpackage.uf2
    public Typeface l(Context context, hi1 hi1Var, Resources resources, int i) throws NoSuchMethodException {
        V();
        try {
            Object objNewInstance = B0.newInstance(null);
            for (ii1 ii1Var : hi1Var.a) {
                File fileS = vf2.s(context);
                if (fileS == null) {
                    return null;
                }
                try {
                    if (!vf2.g(fileS, resources, ii1Var.f)) {
                        return null;
                    }
                    if (!U(objNewInstance, fileS.getPath(), ii1Var.b, ii1Var.c)) {
                        return null;
                    }
                    fileS.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileS.delete();
                }
            }
            V();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) A0, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) D0.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                vp1.p(e);
                return null;
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            vp1.p(e2);
            return null;
        }
    }

    @Override // defpackage.uf2
    public Typeface m(Context context, ki1[] ki1VarArr, int i) {
        Typeface typefaceCreateFromFile;
        String str;
        if (ki1VarArr.length >= 1) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uf2.p(ki1VarArr, i).a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        try {
                            str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    File file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                    if (file != null && file.canRead()) {
                        Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile2;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        File fileS = vf2.s(context);
                        if (fileS == null) {
                            typefaceCreateFromFile = null;
                        } else {
                            try {
                                if (vf2.h(fileS, fileInputStream)) {
                                    typefaceCreateFromFile = Typeface.createFromFile(fileS.getPath());
                                    fileS.delete();
                                }
                            } catch (RuntimeException unused2) {
                            } catch (Throwable th) {
                                fileS.delete();
                                throw th;
                            }
                            fileS.delete();
                            typefaceCreateFromFile = null;
                        }
                        fileInputStream.close();
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile;
                    } finally {
                    }
                }
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused3) {
            }
        }
        return null;
    }
}
