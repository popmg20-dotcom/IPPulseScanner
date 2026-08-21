package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.hardware.camera2.CameraCaptureSession;
import android.os.Build;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class v02 {
    public static Context a;
    public static Boolean b;
    public static final byte[] c = {0, 0, -92, -127};
    public static final byte[] d = {0, 0, -19, 65};

    public static void A(Throwable th) {
        if ((th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof InterruptedException) || (th instanceof ClassCircularityError) || (th instanceof ClassFormatError) || (th instanceof IncompatibleClassChangeError) || (th instanceof BootstrapMethodError) || (th instanceof VerifyError)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            vp1.p(th);
        }
    }

    public static void B(MenuItem menuItem, char c2, int i) {
        menuItem.setAlphabeticShortcut(c2, i);
    }

    public static void C(Notification.Builder builder) {
        builder.setBadgeIconType(0);
    }

    public static byte D(boolean z, byte b2, int i) {
        return z ? r25.N(b2, i) : b2;
    }

    public static void E(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setContentDescription(charSequence);
    }

    public static void F(Notification.Builder builder, int i) {
        builder.setGroupAlertBehavior(i);
    }

    public static void G(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        if (Build.VERSION.SDK_INT >= 26 || !z2 || z) {
            checkableImageButton.setLongClickable(z);
        }
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static void H(MenuItem menuItem, ColorStateList colorStateList) {
        menuItem.setIconTintList(colorStateList);
    }

    public static void I(MenuItem menuItem, PorterDuff.Mode mode) {
        menuItem.setIconTintMode(mode);
    }

    public static void J(MenuItem menuItem, char c2, int i) {
        menuItem.setNumericShortcut(c2, i);
    }

    public static void K(Notification.Builder builder) {
        builder.setSettingsText(null);
    }

    public static void L(Notification.Builder builder) {
        builder.setShortcutId(null);
    }

    public static void M(Notification.Builder builder) {
        builder.setTimeoutAfter(0L);
    }

    public static void N(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setTooltipText(charSequence);
    }

    public static void O(Context context, Intent intent) {
        context.startForegroundService(intent);
    }

    public static void P(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener, CharSequence charSequence) {
        if (!checkableImageButton.isFocusable()) {
            charSequence = null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            checkableImageButton.setTooltipText(charSequence);
        } else if (onLongClickListener == null) {
            ye.H(checkableImageButton, charSequence);
        }
    }

    public static void a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static ImageView.ScaleType b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static Notification.Builder c(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static void d(NotificationManager notificationManager, NotificationChannel notificationChannel) {
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static Icon e(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    public static void f(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i = configuration.colorMode & 3;
        int i2 = configuration2.colorMode & 3;
        if (i != i2) {
            configuration3.colorMode |= i2;
        }
        int i3 = configuration.colorMode & 12;
        int i4 = configuration2.colorMode & 12;
        if (i3 != i4) {
            configuration3.colorMode |= i4;
        }
    }

    public static final int g(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                int height = bitmap.getHeight() * bitmap.getWidth();
                Bitmap.Config config = bitmap.getConfig();
                return height * (config == Bitmap.Config.ALPHA_8 ? 1 : (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) ? 2 : (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) ? 4 : 8);
            }
        }
        StringBuilder sb = new StringBuilder("Cannot obtain size for recycled bitmap: ");
        sb.append(bitmap);
        int width = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap.Config config2 = bitmap.getConfig();
        sb.append(" [");
        sb.append(width);
        sb.append(" x ");
        sb.append(height2);
        sb.append("] + ");
        sb.append(config2);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static byte[] h(File file) {
        try {
            if (!Files.isSymbolicLink(file.toPath()) && !file.exists()) {
                return new byte[4];
            }
            Path path = file.toPath();
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                return n(path);
            }
            if (!System.getProperty("os.name").toLowerCase().contains("mac") && !System.getProperty("os.name").toLowerCase().contains("nux")) {
                return new byte[4];
            }
            return j(path);
        } catch (NoSuchMethodError unused) {
            return new byte[4];
        }
    }

    public static ArrayList i(File file, yy4 yy4Var) throws qy4 {
        if (file == null) {
            st4.j("input path is null, cannot read files in the directory");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (file.isDirectory() && file.canRead() && fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (!file2.isHidden() || yy4Var.e) {
                    arrayList.add(file2);
                    int i = yy4Var.n;
                    boolean zS = s(file2);
                    if ((zS && !fw.e(1, i)) || (!zS && file2.isDirectory())) {
                        arrayList.addAll(i(file2, yy4Var));
                    }
                }
            }
        }
        return arrayList;
    }

    public static byte[] j(Path path) {
        byte[] bArr = new byte[4];
        try {
            Set<PosixFilePermission> setPermissions = ((PosixFileAttributeView) Files.getFileAttributeView(path, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS)).readAttributes().permissions();
            boolean zIsSymbolicLink = Files.isSymbolicLink(path);
            if (zIsSymbolicLink) {
                byte bN = r25.N(bArr[3], 7);
                bArr[3] = bN;
                bArr[3] = r25.V(bN, 6);
            } else {
                bArr[3] = D(Files.isRegularFile(path, new LinkOption[0]), bArr[3], 7);
                bArr[3] = D(Files.isDirectory(path, new LinkOption[0]), bArr[3], 6);
            }
            bArr[3] = D(zIsSymbolicLink, bArr[3], 5);
            bArr[3] = D(setPermissions.contains(PosixFilePermission.OWNER_READ), bArr[3], 0);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.OWNER_WRITE), bArr[2], 7);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.OWNER_EXECUTE), bArr[2], 6);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.GROUP_READ), bArr[2], 5);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.GROUP_WRITE), bArr[2], 4);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.GROUP_EXECUTE), bArr[2], 3);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.OTHERS_READ), bArr[2], 2);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.OTHERS_WRITE), bArr[2], 1);
            bArr[2] = D(setPermissions.contains(PosixFilePermission.OTHERS_EXECUTE), bArr[2], 0);
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String k(File file, yy4 yy4Var) throws qy4 {
        try {
            File file2 = new File(file.getCanonicalPath());
            String string = yy4Var.i;
            if (!yr2.N(string)) {
                string = s(file2) ? file2.toPath().toRealPath(LinkOption.NOFOLLOW_LINKS).getFileName().toString() : file2.getName();
            }
            if (file2.isDirectory()) {
                string = string + "/";
            }
            if (yr2.N(string)) {
                return string;
            }
            StringBuilder sbD = fw.D("fileName to add to zip is empty or null. fileName: '", string, "' DefaultFolderPath: 'null' FileNameInZip: ");
            sbD.append(yy4Var.i);
            String string2 = sbD.toString();
            if (s(file)) {
                string2 = string2.concat("isSymlink: true ");
            }
            if (yr2.N(null)) {
                string2 = ha0.o("rootFolderNameInZip: '", null, "' ");
            }
            st4.j(string2);
            return null;
        } catch (IOException e) {
            throw new qy4(e);
        }
    }

    public static float l(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float m(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    public static byte[] n(Path path) {
        byte[] bArr = new byte[4];
        try {
            DosFileAttributeView dosFileAttributeView = (DosFileAttributeView) Files.getFileAttributeView(path, DosFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
            if (dosFileAttributeView != null) {
                DosFileAttributes attributes = dosFileAttributeView.readAttributes();
                bArr[0] = D(attributes.isArchive(), D(attributes.isDirectory(), D(attributes.isSystem(), D(attributes.isHidden(), D(attributes.isReadOnly(), (byte) 0, 0), 1), 2), 4), 5);
            }
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static String o(String str) throws qy4 {
        if (!yr2.N(str)) {
            st4.j("zip file name is empty or null, cannot determine zip file name");
            return null;
        }
        if (str.contains(System.getProperty("file.separator"))) {
            str = str.substring(str.lastIndexOf(System.getProperty("file.separator")) + 1);
        }
        return str.endsWith(".zip") ? str.substring(0, str.lastIndexOf(".")) : str;
    }

    public static final void p() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            ws2.a();
            NotificationChannel notificationChannel = new NotificationChannel("vpn", "VPN", 0);
            notificationChannel.setShowBadge(false);
            vs2 vs2Var = new vs2(ContextUtilsKt.getContext());
            if (i >= 26) {
                d(vs2Var.b, notificationChannel);
            }
            ws2.a();
            NotificationChannel notificationChannel2 = new NotificationChannel("explorer", "EXPLORER", 3);
            notificationChannel2.setShowBadge(true);
            vs2 vs2Var2 = new vs2(ContextUtilsKt.getContext());
            if (i >= 26) {
                d(vs2Var2.b, notificationChannel2);
            }
        }
    }

    public static final boolean q(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static synchronized boolean r(Context context) {
        Boolean boolValueOf;
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = a;
        if (context2 != null && (bool = b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        b = null;
        if (vf2.v()) {
            boolValueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            b = boolValueOf;
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                boolValueOf = Boolean.TRUE;
                b = boolValueOf;
            } catch (ClassNotFoundException unused) {
                boolValueOf = Boolean.FALSE;
                b = boolValueOf;
            }
        }
        a = applicationContext;
        return boolValueOf.booleanValue();
    }

    public static boolean s(File file) {
        try {
            return Files.isSymbolicLink(file.toPath());
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public static boolean t(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public static boolean u(File file, File file2) {
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static void v(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession) {
        stateCallback.onCaptureQueueEmpty(cameraCaptureSession);
    }

    public static String w(File file) {
        try {
            return Files.readSymbolicLink(file.toPath()).toString();
        } catch (Error | Exception unused) {
            return "";
        }
    }

    public static void x(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static Intent y(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return (i & 4) != 0 ? context.registerReceiver(broadcastReceiver, intentFilter, v9.l(context), null) : context.registerReceiver(broadcastReceiver, intentFilter, null, null, 0);
    }

    public static Intent z(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return context.registerReceiver(broadcastReceiver, intentFilter, null, null, i);
    }
}
