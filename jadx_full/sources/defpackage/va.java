package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class va extends m0 {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ za d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va(za zaVar, Context context) {
        super(zaVar);
        this.d = zaVar;
        this.e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // defpackage.m0
    public final IntentFilter g() {
        switch (this.c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // defpackage.m0
    public final int j() {
        Location location;
        boolean z;
        long j;
        int i = this.c;
        Object obj = this.e;
        switch (i) {
            case 0:
                if (!qa.a((PowerManager) obj)) {
                    break;
                }
                break;
            default:
                n02 n02Var = (n02) obj;
                LocationManager locationManager = (LocationManager) n02Var.z;
                ci4 ci4Var = (ci4) n02Var.A;
                if (ci4Var.b > System.currentTimeMillis()) {
                    z = ci4Var.a;
                } else {
                    Context context = (Context) n02Var.f;
                    Location lastKnownLocation = null;
                    if (uf2.h(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e) {
                            Log.d("TwilightManager", "Failed to get last known location", e);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (uf2.h(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e2) {
                            Log.d("TwilightManager", "Failed to get last known location", e2);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        bi4 bi4Var = bi4.e;
                        if (bi4Var == null) {
                            bi4Var = new bi4();
                            bi4.e = bi4Var;
                        }
                        bi4 bi4Var2 = bi4Var;
                        bi4Var2.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                        bi4Var2.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                        z = bi4Var2.b == 1;
                        long j2 = bi4Var2.d;
                        long j3 = bi4Var2.c;
                        bi4Var2.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis + 86400000);
                        long j4 = bi4Var2.d;
                        if (j2 == -1 || j3 == -1) {
                            j = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis > j3) {
                                j2 = j4;
                            } else if (jCurrentTimeMillis > j2) {
                                j2 = j3;
                            }
                            j = j2 + 60000;
                        }
                        ci4Var.a = z;
                        ci4Var.b = j;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i2 = Calendar.getInstance().get(11);
                        if (i2 < 6 || i2 >= 22) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    break;
                }
                break;
        }
        return 1;
    }

    @Override // defpackage.m0
    public final void o() {
        int i = this.c;
        za zaVar = this.d;
        switch (i) {
            case 0:
                zaVar.q(true, true);
                break;
            default:
                zaVar.q(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public va(za zaVar, n02 n02Var) {
        super(zaVar);
        this.d = zaVar;
        this.e = n02Var;
    }
}
