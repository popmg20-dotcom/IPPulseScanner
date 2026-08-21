package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import java.util.HashMap;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class s35 extends b35 implements t35 {
    public static t35 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof t35 ? (t35) iInterfaceQueryLocalInterface : new r35(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService", 2);
    }

    @Override // defpackage.b35
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        boolean z;
        v35 u35Var = null;
        x35 w35Var = null;
        v35 u35Var2 = null;
        v35 u35Var3 = null;
        v35 u35Var4 = null;
        v35 u35Var5 = null;
        g45 y35Var = null;
        g45 y35Var2 = null;
        g45 y35Var3 = null;
        v35 u35Var6 = null;
        v35 u35Var7 = null;
        v35 u35Var8 = null;
        v35 u35Var9 = null;
        v35 u35Var10 = null;
        v35 u35Var11 = null;
        i45 h45Var = null;
        v35 u35Var12 = null;
        v35 u35Var13 = null;
        v35 u35Var14 = null;
        v35 u35Var15 = null;
        v35 u35Var16 = null;
        switch (i) {
            case 1:
                wv1 wv1VarF = bu2.F(parcel.readStrongBinder());
                j45 j45Var = (j45) d35.a(parcel, j45.CREATOR);
                long j = parcel.readLong();
                d35.d(parcel);
                initialize(wv1VarF, j45Var, j);
                break;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) d35.a(parcel, Bundle.CREATOR);
                if (parcel.readInt() != 0) {
                    z = false;
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = parcel.readInt() != 0 ? true : z;
                long j2 = parcel.readLong();
                d35.d(parcel);
                logEvent(string, string2, bundle, z, z2, j2);
                break;
            case 3:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                Bundle bundle2 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var = iInterfaceQueryLocalInterface instanceof v35 ? (v35) iInterfaceQueryLocalInterface : new u35(strongBinder);
                }
                v35 v35Var = u35Var;
                long j3 = parcel.readLong();
                d35.d(parcel);
                logEventAndBundle(string3, string4, bundle2, v35Var, j3);
                break;
            case 4:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                wv1 wv1VarF2 = bu2.F(parcel.readStrongBinder());
                ClassLoader classLoader = d35.a;
                z = parcel.readInt() != 0;
                long j4 = parcel.readLong();
                d35.d(parcel);
                setUserProperty(string5, string6, wv1VarF2, z, j4);
                break;
            case 5:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                ClassLoader classLoader2 = d35.a;
                z = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var16 = iInterfaceQueryLocalInterface2 instanceof v35 ? (v35) iInterfaceQueryLocalInterface2 : new u35(strongBinder2);
                }
                d35.d(parcel);
                getUserProperties(string7, string8, z, u35Var16);
                break;
            case 6:
                String string9 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var15 = iInterfaceQueryLocalInterface3 instanceof v35 ? (v35) iInterfaceQueryLocalInterface3 : new u35(strongBinder3);
                }
                d35.d(parcel);
                getMaxUserProperties(string9, u35Var15);
                break;
            case 7:
                String string10 = parcel.readString();
                long j5 = parcel.readLong();
                d35.d(parcel);
                setUserId(string10, j5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                long j6 = parcel.readLong();
                d35.d(parcel);
                setConditionalUserProperty(bundle3, j6);
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                Bundle bundle4 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                d35.d(parcel);
                clearConditionalUserProperty(string11, string12, bundle4);
                break;
            case 10:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var14 = iInterfaceQueryLocalInterface4 instanceof v35 ? (v35) iInterfaceQueryLocalInterface4 : new u35(strongBinder4);
                }
                d35.d(parcel);
                getConditionalUserProperties(string13, string14, u35Var14);
                break;
            case 11:
                ClassLoader classLoader3 = d35.a;
                z = parcel.readInt() != 0;
                long j7 = parcel.readLong();
                d35.d(parcel);
                setMeasurementEnabled(z, j7);
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                long j8 = parcel.readLong();
                d35.d(parcel);
                resetAnalyticsData(j8);
                break;
            case 13:
                long j9 = parcel.readLong();
                d35.d(parcel);
                setMinimumSessionDuration(j9);
                break;
            case 14:
                long j10 = parcel.readLong();
                d35.d(parcel);
                setSessionTimeoutDuration(j10);
                break;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                wv1 wv1VarF3 = bu2.F(parcel.readStrongBinder());
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                long j11 = parcel.readLong();
                d35.d(parcel);
                setCurrentScreen(wv1VarF3, string15, string16, j11);
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var13 = iInterfaceQueryLocalInterface5 instanceof v35 ? (v35) iInterfaceQueryLocalInterface5 : new u35(strongBinder5);
                }
                d35.d(parcel);
                getCurrentScreenName(u35Var13);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var12 = iInterfaceQueryLocalInterface6 instanceof v35 ? (v35) iInterfaceQueryLocalInterface6 : new u35(strongBinder6);
                }
                d35.d(parcel);
                getCurrentScreenClass(u35Var12);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    h45Var = iInterfaceQueryLocalInterface7 instanceof i45 ? (i45) iInterfaceQueryLocalInterface7 : new h45(strongBinder7, "com.google.android.gms.measurement.api.internal.IStringProvider", 2);
                }
                d35.d(parcel);
                setInstanceIdProvider(h45Var);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var11 = iInterfaceQueryLocalInterface8 instanceof v35 ? (v35) iInterfaceQueryLocalInterface8 : new u35(strongBinder8);
                }
                d35.d(parcel);
                getCachedAppInstanceId(u35Var11);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var10 = iInterfaceQueryLocalInterface9 instanceof v35 ? (v35) iInterfaceQueryLocalInterface9 : new u35(strongBinder9);
                }
                d35.d(parcel);
                getAppInstanceId(u35Var10);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var9 = iInterfaceQueryLocalInterface10 instanceof v35 ? (v35) iInterfaceQueryLocalInterface10 : new u35(strongBinder10);
                }
                d35.d(parcel);
                getGmpAppId(u35Var9);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var8 = iInterfaceQueryLocalInterface11 instanceof v35 ? (v35) iInterfaceQueryLocalInterface11 : new u35(strongBinder11);
                }
                d35.d(parcel);
                generateEventId(u35Var8);
                break;
            case 23:
                String string17 = parcel.readString();
                long j12 = parcel.readLong();
                d35.d(parcel);
                beginAdUnitExposure(string17, j12);
                break;
            case 24:
                String string18 = parcel.readString();
                long j13 = parcel.readLong();
                d35.d(parcel);
                endAdUnitExposure(string18, j13);
                break;
            case 25:
                wv1 wv1VarF4 = bu2.F(parcel.readStrongBinder());
                long j14 = parcel.readLong();
                d35.d(parcel);
                onActivityStarted(wv1VarF4, j14);
                break;
            case 26:
                wv1 wv1VarF5 = bu2.F(parcel.readStrongBinder());
                long j15 = parcel.readLong();
                d35.d(parcel);
                onActivityStopped(wv1VarF5, j15);
                break;
            case 27:
                wv1 wv1VarF6 = bu2.F(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                long j16 = parcel.readLong();
                d35.d(parcel);
                onActivityCreated(wv1VarF6, bundle5, j16);
                break;
            case 28:
                wv1 wv1VarF7 = bu2.F(parcel.readStrongBinder());
                long j17 = parcel.readLong();
                d35.d(parcel);
                onActivityDestroyed(wv1VarF7, j17);
                break;
            case 29:
                wv1 wv1VarF8 = bu2.F(parcel.readStrongBinder());
                long j18 = parcel.readLong();
                d35.d(parcel);
                onActivityPaused(wv1VarF8, j18);
                break;
            case 30:
                wv1 wv1VarF9 = bu2.F(parcel.readStrongBinder());
                long j19 = parcel.readLong();
                d35.d(parcel);
                onActivityResumed(wv1VarF9, j19);
                break;
            case 31:
                wv1 wv1VarF10 = bu2.F(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var7 = iInterfaceQueryLocalInterface12 instanceof v35 ? (v35) iInterfaceQueryLocalInterface12 : new u35(strongBinder12);
                }
                long j20 = parcel.readLong();
                d35.d(parcel);
                onActivitySaveInstanceState(wv1VarF10, u35Var7, j20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var6 = iInterfaceQueryLocalInterface13 instanceof v35 ? (v35) iInterfaceQueryLocalInterface13 : new u35(strongBinder13);
                }
                long j21 = parcel.readLong();
                d35.d(parcel);
                performAction(bundle6, u35Var6, j21);
                break;
            case 33:
                int i2 = parcel.readInt();
                String string19 = parcel.readString();
                wv1 wv1VarF11 = bu2.F(parcel.readStrongBinder());
                wv1 wv1VarF12 = bu2.F(parcel.readStrongBinder());
                wv1 wv1VarF13 = bu2.F(parcel.readStrongBinder());
                d35.d(parcel);
                logHealthData(i2, string19, wv1VarF11, wv1VarF12, wv1VarF13);
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    y35Var3 = iInterfaceQueryLocalInterface14 instanceof g45 ? (g45) iInterfaceQueryLocalInterface14 : new y35(strongBinder14);
                }
                d35.d(parcel);
                setEventInterceptor(y35Var3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    y35Var2 = iInterfaceQueryLocalInterface15 instanceof g45 ? (g45) iInterfaceQueryLocalInterface15 : new y35(strongBinder15);
                }
                d35.d(parcel);
                registerOnMeasurementEventListener(y35Var2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    y35Var = iInterfaceQueryLocalInterface16 instanceof g45 ? (g45) iInterfaceQueryLocalInterface16 : new y35(strongBinder16);
                }
                d35.d(parcel);
                unregisterOnMeasurementEventListener(y35Var);
                break;
            case 37:
                HashMap hashMap = parcel.readHashMap(d35.a);
                d35.d(parcel);
                initForTests(hashMap);
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var5 = iInterfaceQueryLocalInterface17 instanceof v35 ? (v35) iInterfaceQueryLocalInterface17 : new u35(strongBinder17);
                }
                int i3 = parcel.readInt();
                d35.d(parcel);
                getTestFlag(u35Var5, i3);
                break;
            case 39:
                ClassLoader classLoader4 = d35.a;
                z = parcel.readInt() != 0;
                d35.d(parcel);
                setDataCollectionEnabled(z);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var4 = iInterfaceQueryLocalInterface18 instanceof v35 ? (v35) iInterfaceQueryLocalInterface18 : new u35(strongBinder18);
                }
                d35.d(parcel);
                isDataCollectionEnabled(u35Var4);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                d35.d(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long j22 = parcel.readLong();
                d35.d(parcel);
                clearMeasurementEnabled(j22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                long j23 = parcel.readLong();
                d35.d(parcel);
                setConsent(bundle8, j23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                long j24 = parcel.readLong();
                d35.d(parcel);
                setConsentThirdParty(bundle9, j24);
                break;
            case 46:
                IBinder strongBinder19 = parcel.readStrongBinder();
                if (strongBinder19 != null) {
                    IInterface iInterfaceQueryLocalInterface19 = strongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var3 = iInterfaceQueryLocalInterface19 instanceof v35 ? (v35) iInterfaceQueryLocalInterface19 : new u35(strongBinder19);
                }
                d35.d(parcel);
                getSessionId(u35Var3);
                break;
            case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                Intent intent = (Intent) d35.a(parcel, Intent.CREATOR);
                d35.d(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                k45 k45Var = (k45) d35.a(parcel, k45.CREATOR);
                String string20 = parcel.readString();
                String string21 = parcel.readString();
                long j25 = parcel.readLong();
                d35.d(parcel);
                setCurrentScreenByScionActivityInfo(k45Var, string20, string21, j25);
                break;
            case 51:
                k45 k45Var2 = (k45) d35.a(parcel, k45.CREATOR);
                long j26 = parcel.readLong();
                d35.d(parcel);
                onActivityStartedByScionActivityInfo(k45Var2, j26);
                break;
            case 52:
                k45 k45Var3 = (k45) d35.a(parcel, k45.CREATOR);
                long j27 = parcel.readLong();
                d35.d(parcel);
                onActivityStoppedByScionActivityInfo(k45Var3, j27);
                break;
            case 53:
                k45 k45Var4 = (k45) d35.a(parcel, k45.CREATOR);
                Bundle bundle10 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                long j28 = parcel.readLong();
                d35.d(parcel);
                onActivityCreatedByScionActivityInfo(k45Var4, bundle10, j28);
                break;
            case 54:
                k45 k45Var5 = (k45) d35.a(parcel, k45.CREATOR);
                long j29 = parcel.readLong();
                d35.d(parcel);
                onActivityDestroyedByScionActivityInfo(k45Var5, j29);
                break;
            case 55:
                k45 k45Var6 = (k45) d35.a(parcel, k45.CREATOR);
                long j30 = parcel.readLong();
                d35.d(parcel);
                onActivityPausedByScionActivityInfo(k45Var6, j30);
                break;
            case 56:
                k45 k45Var7 = (k45) d35.a(parcel, k45.CREATOR);
                long j31 = parcel.readLong();
                d35.d(parcel);
                onActivityResumedByScionActivityInfo(k45Var7, j31);
                break;
            case 57:
                k45 k45Var8 = (k45) d35.a(parcel, k45.CREATOR);
                IBinder strongBinder20 = parcel.readStrongBinder();
                if (strongBinder20 != null) {
                    IInterface iInterfaceQueryLocalInterface20 = strongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    u35Var2 = iInterfaceQueryLocalInterface20 instanceof v35 ? (v35) iInterfaceQueryLocalInterface20 : new u35(strongBinder20);
                }
                long j32 = parcel.readLong();
                d35.d(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(k45Var8, u35Var2, j32);
                break;
            case 58:
                IBinder strongBinder21 = parcel.readStrongBinder();
                if (strongBinder21 != null) {
                    IInterface iInterfaceQueryLocalInterface21 = strongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    w35Var = iInterfaceQueryLocalInterface21 instanceof x35 ? (x35) iInterfaceQueryLocalInterface21 : new w35(strongBinder21, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback", 2);
                }
                d35.d(parcel);
                retrieveAndUploadBatches(w35Var);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
