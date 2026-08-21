package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionShouldUseMrirQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.camera2.internal.compat.quirk.InvalidVideoProfilesQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewUnderExposureQuirk;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureFailedForSpecificCombinationQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.compat.quirk.PreviewGreenTintQuirk;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g10 implements dd0 {
    public final /* synthetic */ int a;

    public /* synthetic */ g10(int i) {
        this.a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x027b  */
    @Override // defpackage.dd0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void accept(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        switch (this.a) {
            case 0:
                if (obj != null) {
                    throw new ClassCastException();
                }
                co4.h();
                throw null;
            case 1:
                if (obj != null) {
                    throw new ClassCastException();
                }
                co4.h();
                throw null;
            case 2:
                co4.h();
                return;
            case 3:
                ic3 ic3Var = (ic3) obj;
                ArrayList arrayList = new ArrayList();
                String str = Build.BRAND;
                if (("HUAWEI".equalsIgnoreCase(str) && "SNE-LX1".equalsIgnoreCase(Build.MODEL)) || ("HONOR".equalsIgnoreCase(str) && "STK-LX1".equalsIgnoreCase(Build.MODEL))) {
                    z = true;
                } else {
                    String str2 = Build.FINGERPRINT;
                    if (!str2.startsWith("generic") && !str2.startsWith("unknown")) {
                        String str3 = Build.MODEL;
                        if (!str3.contains("google_sdk") && !str3.contains("Emulator") && !str3.contains("Cuttlefish") && !str3.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!str.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !Build.PRODUCT.equals("google_sdk"))) {
                            Build.HARDWARE.contains("ranchu");
                        }
                    }
                    z = false;
                }
                if (ic3Var.a(ImageCaptureRotationOptionQuirk.class, z)) {
                    arrayList.add(new ImageCaptureRotationOptionQuirk());
                }
                if (ic3Var.a(SurfaceOrderQuirk.class, true)) {
                    arrayList.add(new SurfaceOrderQuirk());
                }
                HashSet hashSet = CaptureFailedRetryQuirk.a;
                Locale locale = Locale.US;
                String upperCase = str.toUpperCase(locale);
                String str4 = Build.MODEL;
                if (ic3Var.a(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.a.contains(Pair.create(upperCase, str4.toUpperCase(locale))))) {
                    arrayList.add(new CaptureFailedRetryQuirk());
                }
                if (ic3Var.a(LowMemoryQuirk.class, LowMemoryQuirk.a.contains(str4.toUpperCase(locale)))) {
                    arrayList.add(new LowMemoryQuirk());
                }
                HashSet hashSet2 = LargeJpegImageQuirk.a;
                if (ic3Var.a(LargeJpegImageQuirk.class, "Samsung".equalsIgnoreCase(str) || ("Vivo".equalsIgnoreCase(str) && LargeJpegImageQuirk.a.contains(str4.toUpperCase(locale))))) {
                    arrayList.add(new LargeJpegImageQuirk());
                }
                HashSet hashSet3 = IncorrectJpegMetadataQuirk.a;
                if (ic3Var.a(IncorrectJpegMetadataQuirk.class, "Samsung".equalsIgnoreCase(str) && IncorrectJpegMetadataQuirk.a.contains(Build.DEVICE.toUpperCase(locale)))) {
                    arrayList.add(new IncorrectJpegMetadataQuirk());
                }
                HashSet hashSet4 = ImageCaptureFailedForSpecificCombinationQuirk.a;
                if (ic3Var.a(ImageCaptureFailedForSpecificCombinationQuirk.class, ("oneplus".equalsIgnoreCase(str) && "cph2583".equalsIgnoreCase(str4)) || ("google".equalsIgnoreCase(str) && ImageCaptureFailedForSpecificCombinationQuirk.a.contains(str4.toLowerCase())))) {
                    arrayList.add(new ImageCaptureFailedForSpecificCombinationQuirk());
                }
                PreviewGreenTintQuirk previewGreenTintQuirk = PreviewGreenTintQuirk.a;
                if (ic3Var.a(PreviewGreenTintQuirk.class, "motorola".equalsIgnoreCase(str) && "moto e20".equalsIgnoreCase(str4))) {
                    arrayList.add(previewGreenTintQuirk);
                }
                vt0.a = new oj1(arrayList);
                ez4.o("DeviceQuirks", "core DeviceQuirks = ".concat(oj1.F(vt0.a)));
                return;
            case 4:
                ic3 ic3Var2 = (ic3) obj;
                ArrayList arrayList2 = new ArrayList();
                if (Build.VERSION.SDK_INT < 33) {
                    String str5 = Build.MANUFACTURER;
                    if ("SAMSUNG".equalsIgnoreCase(str5)) {
                        String str6 = Build.DEVICE;
                        if (!"F2Q".equalsIgnoreCase(str6) && !"Q2Q".equalsIgnoreCase(str6)) {
                            z2 = ("OPPO".equalsIgnoreCase(str5) && "OP4E75L1".equalsIgnoreCase(Build.DEVICE)) || ("LENOVO".equalsIgnoreCase(str5) && "Q706F".equalsIgnoreCase(Build.DEVICE));
                        }
                    }
                }
                if (ic3Var2.a(SurfaceViewStretchedQuirk.class, z2)) {
                    arrayList2.add(new SurfaceViewStretchedQuirk());
                }
                if (ic3Var2.a(SurfaceViewNotCroppedByParentQuirk.class, "XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) && "M2101K7AG".equalsIgnoreCase(Build.MODEL))) {
                    arrayList2.add(new SurfaceViewNotCroppedByParentQuirk());
                }
                wt0.a = new oj1(arrayList2);
                ez4.o("DeviceQuirks", "view DeviceQuirks = ".concat(oj1.F(wt0.a)));
                return;
            case 5:
                ic3 ic3Var3 = (ic3) obj;
                ArrayList arrayList3 = new ArrayList();
                List list = ImageCapturePixelHDRPlusQuirk.a;
                String str7 = Build.MODEL;
                if (ic3Var3.a(ImageCapturePixelHDRPlusQuirk.class, list.contains(str7) && "Google".equals(Build.MANUFACTURER) && Build.VERSION.SDK_INT >= 26)) {
                    arrayList3.add(new ImageCapturePixelHDRPlusQuirk());
                }
                if (ic3Var3.a(ExtraCroppingQuirk.class, ExtraCroppingQuirk.c())) {
                    arrayList3.add(new ExtraCroppingQuirk());
                }
                int i = Nexus4AndroidLTargetAspectRatioQuirk.a;
                String str8 = Build.BRAND;
                "GOOGLE".equalsIgnoreCase(str8);
                if (ic3Var3.a(Nexus4AndroidLTargetAspectRatioQuirk.class, false)) {
                    arrayList3.add(new Nexus4AndroidLTargetAspectRatioQuirk());
                }
                if (ic3Var3.a(ExcludedSupportedSizesQuirk.class, ("OnePlus".equalsIgnoreCase(str8) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) || ("OnePlus".equalsIgnoreCase(str8) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) || (("HUAWEI".equalsIgnoreCase(str8) && "HWANE".equalsIgnoreCase(Build.DEVICE)) || ExcludedSupportedSizesQuirk.e() || ExcludedSupportedSizesQuirk.d() || (("REDMI".equalsIgnoreCase(str8) && "joyeuse".equalsIgnoreCase(Build.DEVICE)) || ExcludedSupportedSizesQuirk.c() || ExcludedSupportedSizesQuirk.b())))) {
                    arrayList3.add(new ExcludedSupportedSizesQuirk());
                }
                List list2 = CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.a;
                Locale locale2 = Locale.US;
                if (ic3Var3.a(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class, list2.contains(str7.toUpperCase(locale2)))) {
                    arrayList3.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
                }
                List list3 = PreviewPixelHDRnetQuirk.a;
                String str9 = Build.MANUFACTURER;
                if (ic3Var3.a(PreviewPixelHDRnetQuirk.class, "Google".equals(str9) && PreviewPixelHDRnetQuirk.a.contains(Build.DEVICE.toLowerCase(Locale.getDefault())))) {
                    arrayList3.add(new PreviewPixelHDRnetQuirk());
                }
                if (ic3Var3.a(StillCaptureFlashStopRepeatingQuirk.class, "SAMSUNG".equals(str9.toUpperCase(locale2)) && str7.toUpperCase(locale2).startsWith("SM-A716"))) {
                    arrayList3.add(new StillCaptureFlashStopRepeatingQuirk());
                }
                s64 s64Var = ExtraSupportedSurfaceCombinationsQuirk.a;
                String str10 = Build.DEVICE;
                if ("heroqltevzw".equalsIgnoreCase(str10) || "heroqltetmo".equalsIgnoreCase(str10)) {
                    z3 = true;
                } else {
                    if (!(!"google".equalsIgnoreCase(str8) ? false : ExtraSupportedSurfaceCombinationsQuirk.c.contains(str7.toUpperCase(locale2))) && !ExtraSupportedSurfaceCombinationsQuirk.b()) {
                        z3 = false;
                    }
                }
                if (ic3Var3.a(ExtraSupportedSurfaceCombinationsQuirk.class, z3)) {
                    arrayList3.add(new ExtraSupportedSurfaceCombinationsQuirk());
                }
                if (ic3Var3.a(FlashAvailabilityBufferUnderflowQuirk.class, FlashAvailabilityBufferUnderflowQuirk.a.contains(new Pair(str9.toLowerCase(locale2), str7.toLowerCase(locale2))))) {
                    arrayList3.add(new FlashAvailabilityBufferUnderflowQuirk());
                }
                if (ic3Var3.a(RepeatingStreamConstraintForVideoRecordingQuirk.class, "Huawei".equalsIgnoreCase(str8) && "mha-l29".equalsIgnoreCase(str7))) {
                    arrayList3.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
                }
                int i2 = Build.VERSION.SDK_INT;
                if (ic3Var3.a(TextureViewIsClosedQuirk.class, i2 <= 23)) {
                    arrayList3.add(new TextureViewIsClosedQuirk());
                }
                if (ic3Var3.a(CaptureSessionOnClosedNotCalledQuirk.class, false)) {
                    arrayList3.add(new CaptureSessionOnClosedNotCalledQuirk());
                }
                if (ic3Var3.a(TorchIsClosedAfterImageCapturingQuirk.class, TorchIsClosedAfterImageCapturingQuirk.a.contains(str7.toLowerCase(locale2)))) {
                    arrayList3.add(new TorchIsClosedAfterImageCapturingQuirk());
                }
                List list4 = ZslDisablerQuirk.a;
                if (ic3Var3.a(ZslDisablerQuirk.class, ("samsung".equalsIgnoreCase(str8) && ZslDisablerQuirk.b(ZslDisablerQuirk.a)) || ("xiaomi".equalsIgnoreCase(str8) && ZslDisablerQuirk.b(ZslDisablerQuirk.b)))) {
                    arrayList3.add(new ZslDisablerQuirk());
                }
                if (ic3Var3.a(ExtraSupportedOutputSizeQuirk.class, "motorola".equalsIgnoreCase(str8) && "moto e5 play".equalsIgnoreCase(str7))) {
                    arrayList3.add(new ExtraSupportedOutputSizeQuirk());
                }
                List list5 = InvalidVideoProfilesQuirk.a;
                if (!"samsung".equalsIgnoreCase(str8) || !Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a")) {
                    List list6 = InvalidVideoProfilesQuirk.a;
                    Locale locale3 = Locale.ROOT;
                    if (list6.contains(str7.toLowerCase(locale3))) {
                        String str11 = Build.ID;
                        if (str11.toLowerCase(locale3).startsWith("tp1a") || str11.toLowerCase(locale3).startsWith("td1a")) {
                            z4 = true;
                        } else if ("redmi".equalsIgnoreCase(str8) || "xiaomi".equalsIgnoreCase(str8)) {
                            String str12 = Build.ID;
                            if (!str12.toLowerCase(locale3).startsWith("tkq1") && !str12.toLowerCase(locale3).startsWith("tp1a")) {
                                if ((!InvalidVideoProfilesQuirk.b.contains(str7.toLowerCase(locale3)) || i2 != 33) && (!InvalidVideoProfilesQuirk.c.contains(str7.toLowerCase(locale3)) || i2 != 33)) {
                                    z4 = false;
                                }
                            }
                        }
                    }
                }
                if (ic3Var3.a(InvalidVideoProfilesQuirk.class, z4)) {
                    arrayList3.add(new InvalidVideoProfilesQuirk());
                }
                if (ic3Var3.a(Preview3AThreadCrashQuirk.class, "samsungexynos7870".equalsIgnoreCase(Build.HARDWARE))) {
                    arrayList3.add(new Preview3AThreadCrashQuirk());
                }
                if (ic3Var3.a(SmallDisplaySizeQuirk.class, SmallDisplaySizeQuirk.a.containsKey(str7.toUpperCase(locale2)))) {
                    arrayList3.add(new SmallDisplaySizeQuirk());
                }
                if (ic3Var3.a(PreviewUnderExposureQuirk.class, PreviewUnderExposureQuirk.b)) {
                    arrayList3.add(PreviewUnderExposureQuirk.a);
                }
                if (ic3Var3.a(CaptureSessionShouldUseMrirQuirk.class, "google".equalsIgnoreCase(str8) && i2 >= 35)) {
                    arrayList3.add(new CaptureSessionShouldUseMrirQuirk());
                }
                xt0.a = new oj1(arrayList3);
                ez4.o("DeviceQuirks", "camera2 DeviceQuirks = ".concat(oj1.F(xt0.a)));
                return;
            case 6:
                TextView textView = (TextView) obj;
                Resources resources = textView.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.afs_popup_min_size);
                textView.setMinimumWidth(dimensionPixelSize);
                textView.setMinimumHeight(dimensionPixelSize);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.gravity = 21;
                layoutParams.setMarginEnd(resources.getDimensionPixelOffset(R.dimen.afs_popup_margin_end));
                textView.setLayoutParams(layoutParams);
                Context context = textView.getContext();
                textView.setBackground(new gg(vo.r(context, R.drawable.afs_popup_background)));
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setGravity(17);
                textView.setIncludeFontPadding(false);
                textView.setSingleLine(true);
                textView.setTextColor(ji0.t(context, android.R.attr.textColorPrimaryInverse));
                textView.setTextSize(0, resources.getDimensionPixelSize(R.dimen.afs_popup_text_size));
                return;
            case 7:
                TextView textView2 = (TextView) obj;
                Resources resources2 = textView2.getResources();
                textView2.setMinimumWidth(resources2.getDimensionPixelSize(R.dimen.afs_md2_popup_min_width));
                textView2.setMinimumHeight(resources2.getDimensionPixelSize(R.dimen.afs_md2_popup_min_height));
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams2.gravity = 49;
                layoutParams2.setMarginEnd(resources2.getDimensionPixelOffset(R.dimen.afs_md2_popup_margin_end));
                textView2.setLayoutParams(layoutParams2);
                Context context2 = textView2.getContext();
                textView2.setBackground(new ij2(context2));
                textView2.setElevation(resources2.getDimensionPixelOffset(R.dimen.afs_md2_popup_elevation));
                textView2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView2.setGravity(17);
                textView2.setIncludeFontPadding(false);
                textView2.setSingleLine(true);
                textView2.setTextColor(ji0.t(context2, android.R.attr.textColorPrimaryInverse));
                textView2.setTextSize(0, resources2.getDimensionPixelSize(R.dimen.afs_md2_popup_text_size));
                return;
            case 8:
                TextView textView3 = (TextView) obj;
                int i3 = RecentRequestsActivity.X0;
                ke0.d.accept(textView3);
                textView3.setTextSize(18.0f);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g10(ed4 ed4Var, int i) {
        this.a = i;
    }
}
