package defpackage;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.icu.text.BreakIterator;
import android.icu.text.DecimalFormatSymbols;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.LocaleList;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.Html;
import android.text.Spanned;
import android.view.DragEvent;
import android.view.PixelCopy;
import android.view.PointerIcon;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import androidx.fragment.app.p;
import com.getsurfboard.R;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import j$.lang.Iterable$EL;
import j$.util.Collection;
import j$.util.Objects;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ga5 {
    public static volatile mw2 a;
    public static Constructor e;
    public static final String[] b = new String[0];
    public static final Object[] c = new Object[0];
    public static final Object d = new Object();
    public static final Object f = new Object();

    public static void A(Activity activity, DragEvent dragEvent) throws oy0 {
        ClipData clipData = dragEvent.getClipData();
        if (clipData != null) {
            for (int i = 0; i < clipData.getItemCount(); i++) {
                if (clipData.getItemAt(i).getUri() != null) {
                    if (activity.requestDragAndDropPermissions(dragEvent) == null) {
                        throw new oy0("Couldn't get DragAndDropPermissions");
                    }
                    return;
                }
            }
        }
    }

    public static void B(Notification.Action.Builder builder, boolean z) {
        builder.setAllowGeneratedReplies(z);
    }

    public static void C(View view, String[] strArr, final dy0 dy0Var, d83 d83Var, final p pVar) {
        WeakHashMap weakHashMap = wp4.a;
        if (Build.VERSION.SDK_INT >= 31) {
            tp4.c(view, strArr, d83Var);
        } else {
            if (strArr.length == 0) {
                strArr = null;
            }
            boolean z = false;
            r25.f(strArr != null, "When the listener is set, MIME types must also be set");
            if (strArr != null) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (strArr[i].startsWith(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                r25.f(!z, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
            }
            view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
            view.setTag(R.id.tag_on_receive_content_listener, d83Var);
        }
        if (Build.VERSION.SDK_INT >= 31 || (view instanceof fb)) {
            view.setOnDragListener(new View.OnDragListener() { // from class: my0
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view2, DragEvent dragEvent) {
                    return dy0Var.c(view2, dragEvent);
                }
            });
        } else {
            view.setOnDragListener(new View.OnDragListener() { // from class: ny0
                @Override // android.view.View.OnDragListener
                public final boolean onDrag(View view2, DragEvent dragEvent) {
                    qd0 pd0Var;
                    Activity activity = pVar;
                    if (dragEvent.getAction() == 3) {
                        ClipData clipData = dragEvent.getClipData();
                        if (Build.VERSION.SDK_INT >= 31) {
                            pd0Var = new pd0(clipData, 3);
                        } else {
                            rd0 rd0Var = new rd0();
                            rd0Var.b = clipData;
                            rd0Var.c = 3;
                            pd0Var = rd0Var;
                        }
                        td0 td0VarBuild = pd0Var.build();
                        try {
                            ga5.A(activity, dragEvent);
                            wp4.j(view2, td0VarBuild);
                        } catch (oy0 unused) {
                            return false;
                        }
                    }
                    return dy0Var.c(view2, dragEvent);
                }
            });
        }
    }

    public static void D(Notification.Builder builder) {
        builder.setRemoteInputHistory(null);
    }

    public static int E(Collection collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static String[] F(String str, char c2) {
        if (t(str)) {
            return b;
        }
        int iIndexOf = str.indexOf(c2);
        if (iIndexOf < 0) {
            return new String[]{str};
        }
        LinkedList linkedList = new LinkedList();
        int i = 0;
        do {
            linkedList.add(str.substring(i, iIndexOf));
            i = iIndexOf + 1;
            if (i >= str.length() || (iIndexOf = str.indexOf(c2, i)) < i) {
                break;
            }
        } while (iIndexOf < str.length());
        if (i < str.length()) {
            linkedList.add(str.substring(i));
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public static Stream G(Iterable iterable) {
        boolean zU = true;
        if (iterable != null) {
            if (iterable instanceof Collection) {
                zU = u((Collection) iterable);
            } else {
                Iterator it = iterable.iterator();
                if (it != null && it.hasNext()) {
                    zU = false;
                }
            }
        }
        return zU ? Stream.CC.empty() : iterable instanceof Collection ? Collection.EL.stream((java.util.Collection) iterable) : StreamSupport.stream(Iterable$EL.spliterator(iterable), false);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[Catch: all -> 0x0022, TryCatch #2 {all -> 0x0022, all -> 0x0072, blocks: (B:6:0x0007, B:8:0x000b, B:10:0x0019, B:20:0x0036, B:77:0x017d, B:15:0x0025, B:17:0x002d, B:21:0x003a, B:23:0x0040, B:25:0x0046, B:27:0x004e, B:76:0x0179, B:78:0x0180, B:79:0x0183, B:80:0x0184, B:28:0x0052, B:30:0x0056, B:31:0x0063, B:33:0x0069, B:39:0x007f, B:41:0x0085, B:42:0x0091, B:63:0x015d, B:64:0x0160, B:72:0x0170, B:71:0x016d, B:73:0x0171, B:74:0x0176, B:75:0x0177, B:34:0x006f, B:38:0x0076), top: B:88:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.mw2 H(android.content.Context r16) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ga5.H(android.content.Context):mw2");
    }

    public static boolean a(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static TreeSet b(Object... objArr) {
        List listAsList = objArr.length <= 0 ? Collections.EMPTY_LIST : Arrays.asList(objArr);
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        Objects.requireNonNull(comparator, "No comparator");
        TreeSet treeSet = new TreeSet(comparator);
        if (E(listAsList) > 0) {
            treeSet.addAll(listAsList);
        }
        return treeSet;
    }

    public static IntStream c(CharSequence charSequence) {
        return IntStream.VivifiedWrapper.convert(charSequence.chars());
    }

    public static IntStream d(CharSequence charSequence) {
        return IntStream.VivifiedWrapper.convert(charSequence.codePoints());
    }

    public static Context e(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    public static Context f(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    public static LocaleList g(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    public static Spanned h(int i, String str) {
        return Html.fromHtml(str, i);
    }

    public static String i() {
        LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
        if (adjustedDefault.size() > 0) {
            return adjustedDefault.get(0).toLanguageTag();
        }
        return null;
    }

    public static DecimalFormatSymbols j(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }

    public static LocaleList k(Configuration configuration) {
        return configuration.getLocales();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0163 A[PHI: r6
      0x0163: PHI (r6v5 int) = (r6v2 int), (r6v7 int) binds: [B:100:0x0161, B:33:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0186 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d A[PHI: r6
      0x005d: PHI (r6v11 int) = 
      (r6v2 int)
      (r6v1 int)
      (r6v3 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v12 int)
     binds: [B:109:0x0178, B:88:0x013f, B:89:0x0141, B:86:0x0137, B:75:0x0118, B:67:0x0105, B:56:0x00e3, B:47:0x00ca, B:49:0x00d0, B:39:0x00b1, B:36:0x00a5, B:28:0x007d, B:24:0x006f, B:25:0x0071, B:21:0x0065, B:22:0x0067, B:18:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[PHI: r6
      0x00c2: PHI (r6v6 int) = (r6v2 int), (r6v4 int), (r6v7 int) binds: [B:106:0x0171, B:44:0x00c1, B:33:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int l(int r20, defpackage.ud0 r21) {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ga5.l(int, ud0):int");
    }

    public static PointerIcon m(Context context) {
        return PointerIcon.getSystemIcon(context, 1002);
    }

    public static String[] n(JobParameters jobParameters) {
        return jobParameters.getTriggeredContentAuthorities();
    }

    public static Uri[] o(JobParameters jobParameters) {
        return jobParameters.getTriggeredContentUris();
    }

    public static UserHandle p(int i) {
        Constructor declaredConstructor;
        if (Build.VERSION.SDK_INT >= 24) {
            return UserHandle.getUserHandleForUid(i);
        }
        int i2 = i / 100000;
        synchronized (f) {
            declaredConstructor = e;
            if (declaredConstructor == null) {
                try {
                    declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
                    e = declaredConstructor;
                } catch (NoSuchMethodException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        try {
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            e = e3;
        }
        try {
            return (UserHandle) declaredConstructor.newInstance(Integer.valueOf(i2));
        } catch (InstantiationException e4) {
            e = e4;
            vp1.p(e);
            return null;
        } catch (InvocationTargetException e5) {
            e = e5;
            vp1.p(e);
            return null;
        }
    }

    public static long q(ud0 ud0Var, int i, boolean z) {
        if (Build.VERSION.SDK_INT < 24 || !z) {
            return r(ud0Var, i);
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(new t30(ud0Var));
        int iFollowing = wordInstance.following(i);
        int iPrevious = wordInstance.previous();
        return (i < iPrevious || i > iFollowing) ? r(ud0Var, i) : ez4.M(iPrevious, iFollowing);
    }

    public static long r(CharSequence charSequence, int i) {
        int i2 = i;
        while (i2 < charSequence.length()) {
            if (!ao2.a(ao2.b, charSequence.charAt(i2))) {
                break;
            }
            i2++;
        }
        if (i2 > i) {
            while (i > 0) {
                if (!ao2.a(ao2.b, charSequence.charAt(i - 1))) {
                    break;
                }
                i--;
            }
        }
        return ez4.M(i, i2);
    }

    public static boolean s(Context context) {
        return context.isDeviceProtectedStorage();
    }

    public static boolean t(CharSequence charSequence) {
        return (charSequence == null ? 0 : charSequence.length()) <= 0;
    }

    public static boolean u(java.util.Collection collection) {
        return E(collection) <= 0;
    }

    public static boolean v(Activity activity) {
        return activity.isInMultiWindowMode();
    }

    public static boolean w(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }

    public static void x(CameraCaptureSession.CaptureCallback captureCallback, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
        captureCallback.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
    }

    public static void y(SurfaceView surfaceView, Bitmap bitmap, m74 m74Var, Handler handler) {
        PixelCopy.request(surfaceView, bitmap, m74Var, handler);
    }

    public static final void z(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        connectivityManager.getClass();
        networkCallback.getClass();
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
