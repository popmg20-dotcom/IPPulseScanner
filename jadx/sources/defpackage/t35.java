package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface t35 extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(v35 v35Var);

    void getAppInstanceId(v35 v35Var);

    void getCachedAppInstanceId(v35 v35Var);

    void getConditionalUserProperties(String str, String str2, v35 v35Var);

    void getCurrentScreenClass(v35 v35Var);

    void getCurrentScreenName(v35 v35Var);

    void getGmpAppId(v35 v35Var);

    void getMaxUserProperties(String str, v35 v35Var);

    void getSessionId(v35 v35Var);

    void getTestFlag(v35 v35Var, int i);

    void getUserProperties(String str, String str2, boolean z, v35 v35Var);

    void initForTests(Map map);

    void initialize(wv1 wv1Var, j45 j45Var, long j);

    void isDataCollectionEnabled(v35 v35Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, v35 v35Var, long j);

    void logHealthData(int i, String str, wv1 wv1Var, wv1 wv1Var2, wv1 wv1Var3);

    void onActivityCreated(wv1 wv1Var, Bundle bundle, long j);

    void onActivityCreatedByScionActivityInfo(k45 k45Var, Bundle bundle, long j);

    void onActivityDestroyed(wv1 wv1Var, long j);

    void onActivityDestroyedByScionActivityInfo(k45 k45Var, long j);

    void onActivityPaused(wv1 wv1Var, long j);

    void onActivityPausedByScionActivityInfo(k45 k45Var, long j);

    void onActivityResumed(wv1 wv1Var, long j);

    void onActivityResumedByScionActivityInfo(k45 k45Var, long j);

    void onActivitySaveInstanceState(wv1 wv1Var, v35 v35Var, long j);

    void onActivitySaveInstanceStateByScionActivityInfo(k45 k45Var, v35 v35Var, long j);

    void onActivityStarted(wv1 wv1Var, long j);

    void onActivityStartedByScionActivityInfo(k45 k45Var, long j);

    void onActivityStopped(wv1 wv1Var, long j);

    void onActivityStoppedByScionActivityInfo(k45 k45Var, long j);

    void performAction(Bundle bundle, v35 v35Var, long j);

    void registerOnMeasurementEventListener(g45 g45Var);

    void resetAnalyticsData(long j);

    void retrieveAndUploadBatches(x35 x35Var);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(wv1 wv1Var, String str, String str2, long j);

    void setCurrentScreenByScionActivityInfo(k45 k45Var, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(g45 g45Var);

    void setInstanceIdProvider(i45 i45Var);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, wv1 wv1Var, boolean z, long j);

    void unregisterOnMeasurementEventListener(g45 g45Var);
}
