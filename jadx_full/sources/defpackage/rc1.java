package defpackage;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Bundle;
import android.util.Size;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rc1 implements mc1 {
    public static final qc1 z0 = new qc1();
    public final n84 A;
    public final n84 X;
    public final n84 Y;
    public final n84 Z;
    public final Context b;
    public final String f;
    public final n84 y0;
    public final pz z;

    public rc1(Context context, String str, pz pzVar) {
        context.getClass();
        str.getClass();
        pzVar.getClass();
        this.b = context;
        this.f = str;
        this.z = pzVar;
        final int i = 0;
        this.A = new n84(new pl1(this) { // from class: oc1
            public final /* synthetic */ rc1 f;

            {
                this.f = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.pl1
            public final Object a() throws e00 {
                String string;
                int i2 = i;
                qw qwVar = null;
                Boolean bool = null;
                qwVar = null;
                qwVar = null;
                rc1 rc1Var = this.f;
                switch (i2) {
                    case 0:
                        Context context2 = rc1Var.b;
                        qw qwVar2 = Build.VERSION.SDK_INT >= 35 ? new qw(context2) : null;
                        try {
                            ServiceInfo[] serviceInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 132).services;
                            if (serviceInfoArr != null) {
                                String str2 = null;
                                for (ServiceInfo serviceInfo : serviceInfoArr) {
                                    Bundle bundle = serviceInfo.metaData;
                                    if (bundle != null && (string = bundle.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY")) != null) {
                                        if (str2 != null) {
                                            xe.q("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                                            return null;
                                        }
                                        str2 = string;
                                    }
                                }
                                if (str2 != null) {
                                    try {
                                        qwVar = (qw) Class.forName(str2).getConstructor(Context.class).newInstance(context2);
                                    } catch (Exception e) {
                                        e04.l("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e);
                                        return null;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        String str3 = rc1Var.f;
                        ArrayList arrayList = new ArrayList();
                        if (qwVar != null) {
                            arrayList.add(new pw(qwVar.a, str3));
                        }
                        if (qwVar2 != null) {
                            try {
                                arrayList.add(new pw(qwVar2.a, str3));
                                break;
                            } catch (UnsupportedOperationException unused2) {
                            }
                        }
                        return new l6(arrayList);
                    case 1:
                        return rc1.a(rc1Var);
                    case 2:
                        try {
                            return rc1Var.z.b(rc1Var.f);
                        } catch (xx e2) {
                            throw new e00(e2);
                        }
                    case 3:
                        sz0 sz0VarD = sz0.d((sy) rc1Var.Y.getValue());
                        r25.j("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", Build.VERSION.SDK_INT >= 33);
                        return ((rz0) sz0VarD.a).a();
                    default:
                        Context context3 = rc1Var.b;
                        try {
                            ServiceInfo[] serviceInfoArr2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 132).services;
                            if (serviceInfoArr2 == null) {
                                bool = Boolean.FALSE;
                            } else {
                                int i3 = 0;
                                while (true) {
                                    if ((i3 < serviceInfoArr2.length) == true) {
                                        int i4 = i3 + 1;
                                        try {
                                            Bundle bundle2 = serviceInfoArr2[i3].metaData;
                                            if (bundle2 == null || bundle2.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY") == null) {
                                                i3 = i4;
                                            } else {
                                                bool = Boolean.TRUE;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException e3) {
                                            e04.h(e3.getMessage());
                                            return null;
                                        }
                                    } else {
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                        }
                        return Boolean.valueOf(n12.c(bool, Boolean.FALSE));
                }
            }
        });
        final int i2 = 1;
        this.X = new n84(new pl1(this) { // from class: oc1
            public final /* synthetic */ rc1 f;

            {
                this.f = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.pl1
            public final Object a() throws e00 {
                String string;
                int i22 = i2;
                qw qwVar = null;
                Boolean bool = null;
                qwVar = null;
                qwVar = null;
                rc1 rc1Var = this.f;
                switch (i22) {
                    case 0:
                        Context context2 = rc1Var.b;
                        qw qwVar2 = Build.VERSION.SDK_INT >= 35 ? new qw(context2) : null;
                        try {
                            ServiceInfo[] serviceInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 132).services;
                            if (serviceInfoArr != null) {
                                String str2 = null;
                                for (ServiceInfo serviceInfo : serviceInfoArr) {
                                    Bundle bundle = serviceInfo.metaData;
                                    if (bundle != null && (string = bundle.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY")) != null) {
                                        if (str2 != null) {
                                            xe.q("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                                            return null;
                                        }
                                        str2 = string;
                                    }
                                }
                                if (str2 != null) {
                                    try {
                                        qwVar = (qw) Class.forName(str2).getConstructor(Context.class).newInstance(context2);
                                    } catch (Exception e) {
                                        e04.l("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e);
                                        return null;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        String str3 = rc1Var.f;
                        ArrayList arrayList = new ArrayList();
                        if (qwVar != null) {
                            arrayList.add(new pw(qwVar.a, str3));
                        }
                        if (qwVar2 != null) {
                            try {
                                arrayList.add(new pw(qwVar2.a, str3));
                                break;
                            } catch (UnsupportedOperationException unused2) {
                            }
                        }
                        return new l6(arrayList);
                    case 1:
                        return rc1.a(rc1Var);
                    case 2:
                        try {
                            return rc1Var.z.b(rc1Var.f);
                        } catch (xx e2) {
                            throw new e00(e2);
                        }
                    case 3:
                        sz0 sz0VarD = sz0.d((sy) rc1Var.Y.getValue());
                        r25.j("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", Build.VERSION.SDK_INT >= 33);
                        return ((rz0) sz0VarD.a).a();
                    default:
                        Context context3 = rc1Var.b;
                        try {
                            ServiceInfo[] serviceInfoArr2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 132).services;
                            if (serviceInfoArr2 == null) {
                                bool = Boolean.FALSE;
                            } else {
                                int i3 = 0;
                                while (true) {
                                    if ((i3 < serviceInfoArr2.length) == true) {
                                        int i4 = i3 + 1;
                                        try {
                                            Bundle bundle2 = serviceInfoArr2[i3].metaData;
                                            if (bundle2 == null || bundle2.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY") == null) {
                                                i3 = i4;
                                            } else {
                                                bool = Boolean.TRUE;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException e3) {
                                            e04.h(e3.getMessage());
                                            return null;
                                        }
                                    } else {
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                        }
                        return Boolean.valueOf(n12.c(bool, Boolean.FALSE));
                }
            }
        });
        final int i3 = 2;
        this.Y = new n84(new pl1(this) { // from class: oc1
            public final /* synthetic */ rc1 f;

            {
                this.f = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.pl1
            public final Object a() throws e00 {
                String string;
                int i22 = i3;
                qw qwVar = null;
                Boolean bool = null;
                qwVar = null;
                qwVar = null;
                rc1 rc1Var = this.f;
                switch (i22) {
                    case 0:
                        Context context2 = rc1Var.b;
                        qw qwVar2 = Build.VERSION.SDK_INT >= 35 ? new qw(context2) : null;
                        try {
                            ServiceInfo[] serviceInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 132).services;
                            if (serviceInfoArr != null) {
                                String str2 = null;
                                for (ServiceInfo serviceInfo : serviceInfoArr) {
                                    Bundle bundle = serviceInfo.metaData;
                                    if (bundle != null && (string = bundle.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY")) != null) {
                                        if (str2 != null) {
                                            xe.q("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                                            return null;
                                        }
                                        str2 = string;
                                    }
                                }
                                if (str2 != null) {
                                    try {
                                        qwVar = (qw) Class.forName(str2).getConstructor(Context.class).newInstance(context2);
                                    } catch (Exception e) {
                                        e04.l("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e);
                                        return null;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        String str3 = rc1Var.f;
                        ArrayList arrayList = new ArrayList();
                        if (qwVar != null) {
                            arrayList.add(new pw(qwVar.a, str3));
                        }
                        if (qwVar2 != null) {
                            try {
                                arrayList.add(new pw(qwVar2.a, str3));
                                break;
                            } catch (UnsupportedOperationException unused2) {
                            }
                        }
                        return new l6(arrayList);
                    case 1:
                        return rc1.a(rc1Var);
                    case 2:
                        try {
                            return rc1Var.z.b(rc1Var.f);
                        } catch (xx e2) {
                            throw new e00(e2);
                        }
                    case 3:
                        sz0 sz0VarD = sz0.d((sy) rc1Var.Y.getValue());
                        r25.j("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", Build.VERSION.SDK_INT >= 33);
                        return ((rz0) sz0VarD.a).a();
                    default:
                        Context context3 = rc1Var.b;
                        try {
                            ServiceInfo[] serviceInfoArr2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 132).services;
                            if (serviceInfoArr2 == null) {
                                bool = Boolean.FALSE;
                            } else {
                                int i32 = 0;
                                while (true) {
                                    if ((i32 < serviceInfoArr2.length) == true) {
                                        int i4 = i32 + 1;
                                        try {
                                            Bundle bundle2 = serviceInfoArr2[i32].metaData;
                                            if (bundle2 == null || bundle2.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY") == null) {
                                                i32 = i4;
                                            } else {
                                                bool = Boolean.TRUE;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException e3) {
                                            e04.h(e3.getMessage());
                                            return null;
                                        }
                                    } else {
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                        }
                        return Boolean.valueOf(n12.c(bool, Boolean.FALSE));
                }
            }
        });
        final int i4 = 3;
        this.Z = new n84(new pl1(this) { // from class: oc1
            public final /* synthetic */ rc1 f;

            {
                this.f = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.pl1
            public final Object a() throws e00 {
                String string;
                int i22 = i4;
                qw qwVar = null;
                Boolean bool = null;
                qwVar = null;
                qwVar = null;
                rc1 rc1Var = this.f;
                switch (i22) {
                    case 0:
                        Context context2 = rc1Var.b;
                        qw qwVar2 = Build.VERSION.SDK_INT >= 35 ? new qw(context2) : null;
                        try {
                            ServiceInfo[] serviceInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 132).services;
                            if (serviceInfoArr != null) {
                                String str2 = null;
                                for (ServiceInfo serviceInfo : serviceInfoArr) {
                                    Bundle bundle = serviceInfo.metaData;
                                    if (bundle != null && (string = bundle.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY")) != null) {
                                        if (str2 != null) {
                                            xe.q("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                                            return null;
                                        }
                                        str2 = string;
                                    }
                                }
                                if (str2 != null) {
                                    try {
                                        qwVar = (qw) Class.forName(str2).getConstructor(Context.class).newInstance(context2);
                                    } catch (Exception e) {
                                        e04.l("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e);
                                        return null;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        String str3 = rc1Var.f;
                        ArrayList arrayList = new ArrayList();
                        if (qwVar != null) {
                            arrayList.add(new pw(qwVar.a, str3));
                        }
                        if (qwVar2 != null) {
                            try {
                                arrayList.add(new pw(qwVar2.a, str3));
                                break;
                            } catch (UnsupportedOperationException unused2) {
                            }
                        }
                        return new l6(arrayList);
                    case 1:
                        return rc1.a(rc1Var);
                    case 2:
                        try {
                            return rc1Var.z.b(rc1Var.f);
                        } catch (xx e2) {
                            throw new e00(e2);
                        }
                    case 3:
                        sz0 sz0VarD = sz0.d((sy) rc1Var.Y.getValue());
                        r25.j("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", Build.VERSION.SDK_INT >= 33);
                        return ((rz0) sz0VarD.a).a();
                    default:
                        Context context3 = rc1Var.b;
                        try {
                            ServiceInfo[] serviceInfoArr2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 132).services;
                            if (serviceInfoArr2 == null) {
                                bool = Boolean.FALSE;
                            } else {
                                int i32 = 0;
                                while (true) {
                                    if ((i32 < serviceInfoArr2.length) == true) {
                                        int i42 = i32 + 1;
                                        try {
                                            Bundle bundle2 = serviceInfoArr2[i32].metaData;
                                            if (bundle2 == null || bundle2.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY") == null) {
                                                i32 = i42;
                                            } else {
                                                bool = Boolean.TRUE;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException e3) {
                                            e04.h(e3.getMessage());
                                            return null;
                                        }
                                    } else {
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                        }
                        return Boolean.valueOf(n12.c(bool, Boolean.FALSE));
                }
            }
        });
        final int i5 = 4;
        this.y0 = new n84(new pl1(this) { // from class: oc1
            public final /* synthetic */ rc1 f;

            {
                this.f = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // defpackage.pl1
            public final Object a() throws e00 {
                String string;
                int i22 = i5;
                qw qwVar = null;
                Boolean bool = null;
                qwVar = null;
                qwVar = null;
                rc1 rc1Var = this.f;
                switch (i22) {
                    case 0:
                        Context context2 = rc1Var.b;
                        qw qwVar2 = Build.VERSION.SDK_INT >= 35 ? new qw(context2) : null;
                        try {
                            ServiceInfo[] serviceInfoArr = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 132).services;
                            if (serviceInfoArr != null) {
                                String str2 = null;
                                for (ServiceInfo serviceInfo : serviceInfoArr) {
                                    Bundle bundle = serviceInfo.metaData;
                                    if (bundle != null && (string = bundle.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY")) != null) {
                                        if (str2 != null) {
                                            xe.q("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                                            return null;
                                        }
                                        str2 = string;
                                    }
                                }
                                if (str2 != null) {
                                    try {
                                        qwVar = (qw) Class.forName(str2).getConstructor(Context.class).newInstance(context2);
                                    } catch (Exception e) {
                                        e04.l("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e);
                                        return null;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                        String str3 = rc1Var.f;
                        ArrayList arrayList = new ArrayList();
                        if (qwVar != null) {
                            arrayList.add(new pw(qwVar.a, str3));
                        }
                        if (qwVar2 != null) {
                            try {
                                arrayList.add(new pw(qwVar2.a, str3));
                                break;
                            } catch (UnsupportedOperationException unused2) {
                            }
                        }
                        return new l6(arrayList);
                    case 1:
                        return rc1.a(rc1Var);
                    case 2:
                        try {
                            return rc1Var.z.b(rc1Var.f);
                        } catch (xx e2) {
                            throw new e00(e2);
                        }
                    case 3:
                        sz0 sz0VarD = sz0.d((sy) rc1Var.Y.getValue());
                        r25.j("DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.", Build.VERSION.SDK_INT >= 33);
                        return ((rz0) sz0VarD.a).a();
                    default:
                        Context context3 = rc1Var.b;
                        try {
                            ServiceInfo[] serviceInfoArr2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 132).services;
                            if (serviceInfoArr2 == null) {
                                bool = Boolean.FALSE;
                            } else {
                                int i32 = 0;
                                while (true) {
                                    if ((i32 < serviceInfoArr2.length) == true) {
                                        int i42 = i32 + 1;
                                        try {
                                            Bundle bundle2 = serviceInfoArr2[i32].metaData;
                                            if (bundle2 == null || bundle2.getString("androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY") == null) {
                                                i32 = i42;
                                            } else {
                                                bool = Boolean.TRUE;
                                            }
                                        } catch (ArrayIndexOutOfBoundsException e3) {
                                            e04.h(e3.getMessage());
                                            return null;
                                        }
                                    } else {
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException unused3) {
                        }
                        return Boolean.valueOf(n12.c(bool, Boolean.FALSE));
                }
            }
        });
    }

    public static final CameraDevice.CameraDeviceSetup a(rc1 rc1Var) {
        pz pzVar = rc1Var.z;
        CameraManager cameraManager = (CameraManager) pzVar.a.f;
        String str = rc1Var.f;
        if (cameraManager.isCameraDeviceSetupSupported(str)) {
            return ((CameraManager) pzVar.a.f).getCameraDeviceSetup(str);
        }
        return null;
    }

    @Override // defpackage.mc1
    public final boolean b(tt3 tt3Var) throws Exception {
        pc1 pc1Var;
        OutputConfiguration outputConfiguration;
        f10 f10Var = tt3Var.g;
        ArrayList<fh> arrayList = tt3Var.a;
        ArrayList<AutoCloseable> arrayList2 = new ArrayList(f70.Q(10, arrayList));
        for (fh fhVar : arrayList) {
            if (((Boolean) this.y0.getValue()).booleanValue()) {
                fhVar.getClass();
                dn0 dn0Var = fhVar.a;
                Class cls = dn0Var.j;
                StringBuilder sb = new StringBuilder("toDeferredOutputConfiguration: surface containerClass = ");
                Class cls2 = dn0Var.j;
                Size size = dn0Var.h;
                sb.append(cls2);
                ez4.o("FeatureCombinationQueryImpl", sb.toString());
                if (cls == null) {
                    outputConfiguration = new OutputConfiguration(dn0Var.i, size);
                } else {
                    if (size == null) {
                        xe.k("Required value was null.");
                        return false;
                    }
                    outputConfiguration = new OutputConfiguration(size, cls);
                }
                pc1Var = new pc1(outputConfiguration, null);
            } else {
                fhVar.getClass();
                dn0 dn0Var2 = fhVar.a;
                Class cls3 = dn0Var2.j;
                long j = n12.c(cls3, MediaCodec.class) ? 65536L : n12.c(cls3, SurfaceHolder.class) ? 2048L : n12.c(cls3, SurfaceTexture.class) ? 256L : 0L;
                StringBuilder sb2 = new StringBuilder("toConcreteOutputConfiguration: surface containerClass = ");
                Class cls4 = dn0Var2.j;
                Size size2 = dn0Var2.h;
                sb2.append(cls4);
                sb2.append(", usageFlag = ");
                sb2.append(j);
                ez4.o("FeatureCombinationQueryImpl", sb2.toString());
                ImageReader imageReaderNewInstance = ImageReader.newInstance(size2.getWidth(), size2.getHeight(), dn0Var2.i, 1, j);
                imageReaderNewInstance.getClass();
                pc1Var = new pc1(new OutputConfiguration(imageReaderNewInstance.getSurface()), imageReaderNewInstance);
            }
            if (fhVar.a.j != null) {
                OutputConfiguration outputConfiguration2 = pc1Var.b;
                DynamicRangeProfiles dynamicRangeProfilesB = a71.b(this.Z.getValue());
                if (dynamicRangeProfilesB != null) {
                    Long lA = pz0.a(fhVar.e, dynamicRangeProfilesB);
                    if (lA == null) {
                        xe.k("Required value was null.");
                        return false;
                    }
                    outputConfiguration2.setDynamicRangeProfile(lA.longValue());
                } else {
                    continue;
                }
            }
            arrayList2.add(pc1Var);
        }
        ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((pc1) it.next()).b);
        }
        SessionConfiguration sessionConfiguration = new SessionConfiguration(0, arrayList3, yu0.a(), z0);
        CameraDevice.CameraDeviceSetup cameraDeviceSetup = (CameraDevice.CameraDeviceSetup) this.X.getValue();
        if (cameraDeviceSetup == null) {
            sessionConfiguration = null;
        } else {
            CaptureRequest.Builder builderCreateCaptureRequest = cameraDeviceSetup.createCaptureRequest(f10Var.c);
            builderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, f10Var.a());
            if (f10Var.b() == 2) {
                builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
            }
            sessionConfiguration.setSessionParameters(builderCreateCaptureRequest.build());
        }
        if (sessionConfiguration == null) {
            return false;
        }
        int i = ((dz) this.A.getValue()).a(sessionConfiguration).b;
        StringBuilder sbD = dw2.D("isSupported: supported = ", i, " for session config with ");
        StringBuilder sb3 = new StringBuilder("sessionParameters=[");
        sb3.append("fpsRange=" + f10Var.a());
        sb3.append(", previewStabilizationMode=" + f10Var.b());
        sb3.append("], outputConfigurations=[");
        int i2 = 0;
        for (Object obj : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                e70.P();
                throw null;
            }
            fh fhVar2 = (fh) obj;
            if (i2 != 0) {
                sb3.append(",");
            }
            StringBuilder sb4 = new StringBuilder("{format=");
            dn0 dn0Var3 = fhVar2.a;
            sb4.append(dn0Var3.i);
            sb4.append(", size=");
            sb4.append(dn0Var3.h);
            sb4.append(", dynamicRange=");
            sb4.append(fhVar2.e);
            sb4.append(", class=");
            sb4.append(dn0Var3.j);
            sb4.append('}');
            sb3.append(sb4.toString());
            i2 = i3;
        }
        sb3.append("]");
        sbD.append(sb3.toString());
        ez4.o("FeatureCombinationQueryImpl", sbD.toString());
        boolean z = i == 1;
        for (AutoCloseable autoCloseable : arrayList2) {
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
            } else if (autoCloseable instanceof ExecutorService) {
                ExecutorService executorService = (ExecutorService) autoCloseable;
                if (Build.VERSION.SDK_INT <= 23 || executorService != ForkJoinPool.commonPool()) {
                    boolean zIsTerminated = executorService.isTerminated();
                    if (!zIsTerminated) {
                        executorService.shutdown();
                        boolean z2 = false;
                        while (!zIsTerminated) {
                            try {
                                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
                            } catch (InterruptedException unused) {
                                if (!z2) {
                                    executorService.shutdownNow();
                                    z2 = true;
                                }
                            }
                        }
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            } else if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
            } else if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    s53.d();
                    return false;
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }
        return z;
    }
}
