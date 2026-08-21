package defpackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader;
import io.sentry.android.core.a1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yz0 {
    public static Boolean e = null;
    public static String f = null;
    public static boolean g = false;
    public static int h = -1;
    public static Boolean i;
    public static ye5 m;
    public static yf5 n;
    public final Context a;
    public static final ThreadLocal j = new ThreadLocal();
    public static final uj0 k = new uj0(9);
    public static final p84 l = new p84(21);
    public static final d84 b = new d84(25);
    public static final p84 c = new p84(25);
    public static final q84 d = new q84(25);

    public yz0(Context context) {
        this.a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(str.length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (gb4.I(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 50 + str.length() + 1);
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            a1.d("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(str.length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            a1.n("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            a1.d("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f9 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ff A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0308 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3 A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #9 {all -> 0x00b8, blocks: (B:5:0x0042, B:9:0x00b1, B:16:0x00bd, B:19:0x00c3, B:32:0x00ed, B:120:0x0297, B:121:0x029e, B:129:0x02ad, B:131:0x02d5, B:133:0x02e5, B:143:0x0311, B:144:0x0318, B:124:0x02a1, B:125:0x02a2, B:126:0x02a9, B:145:0x0319, B:146:0x0339, B:147:0x033a, B:148:0x0387), top: B:167:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e9  */
    /* JADX WARN: Type inference failed for: r30v0, types: [xz0] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static yz0 c(Context context, xz0 xz0Var, String str) throws vz0 {
        ?? r7;
        int i2;
        yz0 yz0Var;
        int i3;
        wv1 wv1VarG;
        yf5 yf5Var;
        boolean z;
        wv1 wv1VarG2;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new vz0("null application Context");
        }
        ThreadLocal threadLocal = j;
        tc5 tc5Var = (tc5) threadLocal.get();
        tc5 tc5Var2 = new tc5();
        threadLocal.set(tc5Var2);
        uj0 uj0Var = k;
        Long l2 = (Long) uj0Var.get();
        long jLongValue = l2.longValue();
        try {
            uj0Var.set(Long.valueOf(SystemClock.uptimeMillis()));
            fm0 fm0VarE = xz0Var.e(context, str, l);
            int i4 = fm0VarE.a;
            int i5 = fm0VarE.b;
            StringBuilder sb = new StringBuilder(str.length() + 26 + String.valueOf(i4).length() + 19 + str.length() + 1 + String.valueOf(i5).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i4);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i5);
            Log.i("DynamiteModule", sb.toString());
            int i6 = fm0VarE.c;
            if (i6 != 0) {
                if (i6 != -1) {
                    if (i6 == 1 || fm0VarE.b != 0) {
                        if (i6 != -1) {
                            Log.i("DynamiteModule", "Selected local version of ".concat(str));
                            yz0 yz0Var2 = new yz0(applicationContext);
                            if (jLongValue == 0) {
                                uj0Var.remove();
                            } else {
                                uj0Var.set(l2);
                            }
                            Cursor cursor = tc5Var2.a;
                            if (cursor != null) {
                                cursor.close();
                            }
                            threadLocal.set(tc5Var);
                            return yz0Var2;
                        }
                        if (i6 != 1) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(i6).length() + 36);
                            sb2.append("VersionPolicy returned invalid code:");
                            sb2.append(i6);
                            throw new vz0(sb2.toString());
                        }
                        try {
                            try {
                                i3 = fm0VarE.b;
                            } catch (vz0 e2) {
                                e = e2;
                                r7 = uj0Var;
                                String message = e.getMessage();
                                StringBuilder sb3 = new StringBuilder(String.valueOf(message).length() + 30);
                                sb3.append("Failed to load remote module: ");
                                sb3.append(message);
                                a1.n("DynamiteModule", sb3.toString());
                                i2 = fm0VarE.a;
                                if (i2 != 0 || xz0Var.e(r7, str, new ue2(i2, false)).c != -1) {
                                    throw new vz0("Remote load failed. No local fallback found.", e);
                                }
                                Log.i("DynamiteModule", "Selected local version of ".concat(str));
                                yz0Var = new yz0(applicationContext);
                                return yz0Var;
                            }
                        } catch (vz0 e3) {
                            e = e3;
                            r7 = context;
                            String message2 = e.getMessage();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(message2).length() + 30);
                            sb32.append("Failed to load remote module: ");
                            sb32.append(message2);
                            a1.n("DynamiteModule", sb32.toString());
                            i2 = fm0VarE.a;
                            if (i2 != 0) {
                            }
                            throw new vz0("Remote load failed. No local fallback found.", e);
                        }
                        try {
                            try {
                                try {
                                    synchronized (yz0.class) {
                                        try {
                                            if (!e(context)) {
                                                throw new vz0("Remote loading disabled");
                                            }
                                            Boolean bool = e;
                                            if (bool == null) {
                                                throw new vz0("Failed to determine which loading route to use.");
                                            }
                                            if (bool.booleanValue()) {
                                                StringBuilder sb4 = new StringBuilder(str.length() + 40 + String.valueOf(i3).length());
                                                sb4.append("Selected remote version of ");
                                                sb4.append(str);
                                                sb4.append(", version >= ");
                                                sb4.append(i3);
                                                Log.i("DynamiteModule", sb4.toString());
                                                synchronized (yz0.class) {
                                                    yf5Var = n;
                                                }
                                                if (yf5Var == null) {
                                                    throw new vz0("DynamiteLoaderV2 was not cached.");
                                                }
                                                tc5 tc5Var3 = (tc5) threadLocal.get();
                                                if (tc5Var3 == null || tc5Var3.a == null) {
                                                    throw new vz0("No result cursor");
                                                }
                                                Context applicationContext2 = context.getApplicationContext();
                                                Cursor cursor2 = tc5Var3.a;
                                                new bu2(null);
                                                synchronized (yz0.class) {
                                                    z = h >= 2;
                                                }
                                                if (z) {
                                                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                    wv1VarG2 = yf5Var.H(new bu2(applicationContext2), str, i3, new bu2(cursor2));
                                                } else {
                                                    a1.n("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                    wv1VarG2 = yf5Var.G(new bu2(applicationContext2), str, i3, new bu2(cursor2));
                                                }
                                                Context context2 = (Context) bu2.G(wv1VarG2);
                                                if (context2 == null) {
                                                    throw new vz0("Failed to get module context");
                                                }
                                                yz0Var = new yz0(context2);
                                            } else {
                                                StringBuilder sb5 = new StringBuilder(str.length() + 40 + String.valueOf(i3).length());
                                                sb5.append("Selected remote version of ");
                                                sb5.append(str);
                                                sb5.append(", version >= ");
                                                sb5.append(i3);
                                                Log.i("DynamiteModule", sb5.toString());
                                                ye5 ye5VarH = h(context);
                                                if (ye5VarH == null) {
                                                    throw new vz0("Failed to create IDynamiteLoader.");
                                                }
                                                Parcel parcelA = ye5VarH.a(ye5VarH.c(), 6);
                                                int i7 = parcelA.readInt();
                                                parcelA.recycle();
                                                if (i7 >= 3) {
                                                    tc5 tc5Var4 = (tc5) threadLocal.get();
                                                    if (tc5Var4 == null) {
                                                        throw new vz0("No cached result cursor holder");
                                                    }
                                                    wv1VarG = ye5VarH.J(new bu2(context), str, i3, new bu2(tc5Var4.a));
                                                } else if (i7 == 2) {
                                                    a1.n("DynamiteModule", "IDynamite loader version = 2");
                                                    wv1VarG = ye5VarH.H(new bu2(context), str, i3);
                                                } else {
                                                    a1.n("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                    wv1VarG = ye5VarH.G(new bu2(context), str, i3);
                                                }
                                                Object objG = bu2.G(wv1VarG);
                                                if (objG == null) {
                                                    throw new vz0("Failed to load remote module.");
                                                }
                                                yz0Var = new yz0((Context) objG);
                                            }
                                            return yz0Var;
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (RemoteException e4) {
                                e = e4;
                                throw new vz0("Failed to load remote module.", e);
                            } catch (vz0 e5) {
                                throw e5;
                            } catch (Throwable th3) {
                                th = th3;
                                throw new vz0("Failed to load remote module.", th);
                            }
                        } catch (RemoteException e6) {
                            e = e6;
                            throw new vz0("Failed to load remote module.", e);
                        } catch (vz0 e7) {
                            throw e7;
                        } catch (Throwable th4) {
                            th = th4;
                            throw new vz0("Failed to load remote module.", th);
                        }
                    }
                } else if (fm0VarE.a != 0) {
                    i6 = -1;
                    if (i6 == 1) {
                    }
                    if (i6 != -1) {
                    }
                }
            }
            int i8 = fm0VarE.a;
            int i9 = fm0VarE.b;
            StringBuilder sb6 = new StringBuilder(str.length() + 46 + String.valueOf(i8).length() + 23 + String.valueOf(i9).length() + 1);
            sb6.append("No acceptable module ");
            sb6.append(str);
            sb6.append(" found. Local version is ");
            sb6.append(i8);
            sb6.append(" and remote version is ");
            sb6.append(i9);
            sb6.append(".");
            throw new vz0(sb6.toString());
        } finally {
            if (jLongValue == 0) {
                k.remove();
            } else {
                k.set(l2);
            }
            Cursor cursor3 = tc5Var2.a;
            if (cursor3 != null) {
                cursor3.close();
            }
            j.set(tc5Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0194 A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00f4, blocks: (B:4:0x0006, B:64:0x00e9, B:66:0x00ef, B:74:0x011d, B:104:0x0194, B:112:0x01a9, B:130:0x0233, B:131:0x0236, B:125:0x022a, B:72:0x00fa, B:133:0x0238, B:5:0x0007, B:8:0x000e, B:9:0x002a, B:62:0x00e6, B:22:0x004e, B:45:0x00a5, B:48:0x00a8, B:55:0x00c0, B:63:0x00e8, B:61:0x00c6), top: B:146:0x0006, inners: #6, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[Catch: all -> 0x003b, TryCatch #13 {, blocks: (B:10:0x002b, B:12:0x0037, B:52:0x00bd, B:17:0x0040, B:19:0x0047, B:21:0x004d, B:26:0x0054, B:28:0x0058, B:31:0x0061, B:33:0x0069, B:36:0x0070, B:43:0x009c, B:44:0x00a4, B:39:0x0077, B:41:0x007d, B:42:0x008e, B:47:0x00a7, B:50:0x00aa, B:51:0x00b4, B:18:0x0043), top: B:152:0x002b, inners: #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException remoteException;
        int i2;
        Cursor cursor;
        try {
            synchronized (yz0.class) {
                Boolean bool = e;
                boolean z2 = true;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule$DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String string = e2.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(string);
                        a1.n("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                g(classLoader);
                            } catch (vz0 unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!e(context)) {
                                return 0;
                            }
                            if (!g) {
                                Boolean bool2 = Boolean.TRUE;
                                if (bool2.equals(null)) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iF = f(context, str, z, true);
                                        String str2 = f;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader classLoaderA0 = r25.a0();
                                            if (classLoaderA0 == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    uz0.b();
                                                    String str3 = f;
                                                    tj4.i(str3);
                                                    classLoaderA0 = uz0.a(ClassLoader.getSystemClassLoader(), str3);
                                                } else {
                                                    String str4 = f;
                                                    tj4.i(str4);
                                                    classLoaderA0 = new a45(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            g(classLoaderA0);
                                            declaredField.set(null, classLoaderA0);
                                            e = bool2;
                                            return iF;
                                        }
                                        return iF;
                                    } catch (vz0 unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        }
                        e = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return f(context, str, z, false);
                    } catch (vz0 e3) {
                        String message = e3.getMessage();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 42);
                        sb2.append("Failed to retrieve remote module version: ");
                        sb2.append(message);
                        a1.n("DynamiteModule", sb2.toString());
                        return 0;
                    }
                }
                ye5 ye5VarH = h(context);
                try {
                    if (ye5VarH == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelA = ye5VarH.a(ye5VarH.c(), 6);
                        int i3 = parcelA.readInt();
                        parcelA.recycle();
                        if (i3 >= 3) {
                            ThreadLocal threadLocal = j;
                            tc5 tc5Var = (tc5) threadLocal.get();
                            if (tc5Var != null && (cursor = tc5Var.a) != null) {
                                return cursor.getInt(0);
                            }
                            Cursor cursor3 = (Cursor) bu2.G(ye5VarH.I(new bu2(context), str, z, ((Long) k.get()).longValue()));
                            if (cursor3 != null) {
                                try {
                                    if (cursor3.moveToFirst()) {
                                        i2 = cursor3.getInt(0);
                                        if (i2 <= 0) {
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                        } else {
                                            tc5 tc5Var2 = (tc5) threadLocal.get();
                                            if (tc5Var2 == null || tc5Var2.a != null) {
                                                z2 = false;
                                            } else {
                                                tc5Var2.a = cursor3;
                                            }
                                            if (!z2) {
                                            }
                                            if (cursor2 != null) {
                                            }
                                        }
                                    }
                                } catch (RemoteException e4) {
                                    remoteException = e4;
                                    cursor2 = cursor3;
                                    String message2 = remoteException.getMessage();
                                    StringBuilder sb3 = new StringBuilder(String.valueOf(message2).length() + 42);
                                    sb3.append("Failed to retrieve remote module version: ");
                                    sb3.append(message2);
                                    a1.n("DynamiteModule", sb3.toString());
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor3;
                                    if (cursor2 == null) {
                                        throw th;
                                    }
                                    cursor2.close();
                                    throw th;
                                }
                            }
                            a1.n("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor3 == null) {
                                return 0;
                            }
                            cursor3.close();
                            return 0;
                        }
                        if (i3 == 2) {
                            a1.n("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            bu2 bu2Var = new bu2(context);
                            Parcel parcelC = ye5VarH.c();
                            k35.b(parcelC, bu2Var);
                            parcelC.writeString(str);
                            parcelC.writeInt(z ? 1 : 0);
                            Parcel parcelA2 = ye5VarH.a(parcelC, 5);
                            i2 = parcelA2.readInt();
                            parcelA2.recycle();
                        } else {
                            a1.n("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            bu2 bu2Var2 = new bu2(context);
                            Parcel parcelC2 = ye5VarH.c();
                            k35.b(parcelC2, bu2Var2);
                            parcelC2.writeString(str);
                            parcelC2.writeInt(z ? 1 : 0);
                            Parcel parcelA3 = ye5VarH.a(parcelC2, 3);
                            i2 = parcelA3.readInt();
                            parcelA3.recycle();
                        }
                        return i2;
                    } catch (RemoteException e5) {
                        remoteException = e5;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } finally {
        }
    }

    public static boolean e(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(i)) {
            return true;
        }
        boolean z = false;
        if (i == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", Build.VERSION.SDK_INT >= 29 ? 268435456 : 0);
            if (mp1.b.b(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            i = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                g = true;
            }
        }
        if (!z) {
            a1.d("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a A[PHI: r3
      0x013a: PHI (r3v4 boolean) = (r3v3 boolean), (r3v6 boolean) binds: [B:58:0x00f1, B:83:0x0137] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(Context context, String str, boolean z, boolean z2) throws Throwable {
        Exception exc;
        Throwable th;
        Cursor cursorQuery;
        MatrixCursor matrixCursor;
        boolean z3;
        try {
            try {
                boolean z4 = true;
                Uri uriBuild = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(((Long) k.get()).longValue())).build();
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uriBuild);
                boolean z5 = false;
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uriBuild, null, null, null, null);
                    } catch (RemoteException unused) {
                    } catch (Throwable th2) {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        throw th2;
                    }
                    if (cursorQuery != null) {
                        try {
                            int count = cursorQuery.getCount();
                            int columnCount = cursorQuery.getColumnCount();
                            matrixCursor = new MatrixCursor(cursorQuery.getColumnNames(), count);
                            for (int i2 = 0; i2 < count; i2++) {
                                if (!cursorQuery.moveToPosition(i2)) {
                                    throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                }
                                Object[] objArr = new Object[columnCount];
                                for (int i3 = 0; i3 < columnCount; i3++) {
                                    int type = cursorQuery.getType(i3);
                                    if (type == 0) {
                                        objArr[i3] = null;
                                    } else if (type == 1) {
                                        objArr[i3] = Long.valueOf(cursorQuery.getLong(i3));
                                    } else if (type == 2) {
                                        objArr[i3] = Double.valueOf(cursorQuery.getDouble(i3));
                                    } else if (type == 3) {
                                        objArr[i3] = cursorQuery.getString(i3);
                                    } else {
                                        if (type != 4) {
                                            throw new RemoteException("Unknown column type");
                                        }
                                        objArr[i3] = cursorQuery.getBlob(i3);
                                    }
                                }
                                matrixCursor.addRow(objArr);
                            }
                            cursorQuery.close();
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                            if (matrixCursor != null) {
                                try {
                                    if (matrixCursor.moveToFirst()) {
                                        int i4 = matrixCursor.getInt(0);
                                        if (i4 > 0) {
                                            synchronized (yz0.class) {
                                                try {
                                                    f = matrixCursor.getString(2);
                                                    int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                                    if (columnIndex >= 0) {
                                                        h = matrixCursor.getInt(columnIndex);
                                                    }
                                                    int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                                    if (columnIndex2 >= 0) {
                                                        z3 = matrixCursor.getInt(columnIndex2) != 0;
                                                        g = z3;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                } finally {
                                                }
                                            }
                                            tc5 tc5Var = (tc5) j.get();
                                            if (tc5Var == null || tc5Var.a != null) {
                                                z4 = false;
                                            } else {
                                                tc5Var.a = matrixCursor;
                                            }
                                            z5 = z3;
                                            matrixCursor = z4 ? null : matrixCursor;
                                        }
                                        if (z2 && z5) {
                                            throw new vz0("forcing fallback to container DynamiteLoader impl");
                                        }
                                        if (matrixCursor != null) {
                                            matrixCursor.close();
                                        }
                                        return i4;
                                    }
                                } catch (Exception e2) {
                                    exc = e2;
                                    if (exc instanceof vz0) {
                                        throw exc;
                                    }
                                    String message = exc.getMessage();
                                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 25);
                                    sb.append("V2 version check failed: ");
                                    sb.append(message);
                                    throw new vz0(sb.toString(), exc);
                                } catch (Throwable th3) {
                                    th = th3;
                                    matrixCursor = matrixCursor;
                                    if (matrixCursor == null) {
                                        throw th;
                                    }
                                    matrixCursor.close();
                                    throw th;
                                }
                            }
                            a1.n("DynamiteModule", "Failed to retrieve remote module version.");
                            throw new vz0("Failed to connect to dynamite module ContentResolver.");
                        } catch (Throwable th4) {
                            try {
                                cursorQuery.close();
                                throw th4;
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                                throw th4;
                            }
                        }
                    }
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
                matrixCursor = null;
                if (matrixCursor != null) {
                }
                a1.n("DynamiteModule", "Failed to retrieve remote module version.");
                throw new vz0("Failed to connect to dynamite module ContentResolver.");
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e3) {
            exc = e3;
        }
    }

    public static void g(ClassLoader classLoader) throws vz0 {
        try {
            yf5 yf5Var = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                yf5Var = iInterfaceQueryLocalInterface instanceof yf5 ? (yf5) iInterfaceQueryLocalInterface : new yf5(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            n = yf5Var;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new vz0("Failed to instantiate dynamite loader", e2);
        }
    }

    public static ye5 h(Context context) {
        ye5 ye5Var;
        synchronized (yz0.class) {
            ye5 ye5Var2 = m;
            if (ye5Var2 != null) {
                return ye5Var2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    ye5Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    ye5Var = iInterfaceQueryLocalInterface instanceof ye5 ? (ye5) iInterfaceQueryLocalInterface : new ye5(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (ye5Var != null) {
                    m = ye5Var;
                    return ye5Var;
                }
            } catch (Exception e2) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                a1.d("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    public final IBinder b(String str) throws vz0 {
        try {
            return (IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new vz0("Failed to instantiate module class: ".concat(str), e2);
        }
    }
}
