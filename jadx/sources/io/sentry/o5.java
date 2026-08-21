package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum o5 implements k2 {
    Session("session"),
    Event("event"),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction("transaction"),
    Profile("profile"),
    ProfileChunk("profile_chunk"),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    ReplayVideo("replay_video"),
    CheckIn("check_in"),
    Feedback("feedback"),
    Log("log"),
    TraceMetric("trace_metric"),
    Span("span"),
    Unknown("__unknown__");

    private final String itemType;

    o5(String str) {
        this.itemType = str;
    }

    public static o5 resolve(Object obj) {
        return obj instanceof f5 ? ((io.sentry.protocol.k) ((f5) obj).f.w(io.sentry.protocol.k.class, "feedback")) == null ? Event : Feedback : obj instanceof io.sentry.protocol.f0 ? Transaction : obj instanceof z6 ? Session : obj instanceof io.sentry.clientreport.b ? ClientReport : Attachment;
    }

    public static o5 valueOfLabel(String str) {
        for (o5 o5Var : values()) {
            if (o5Var.itemType.equals(str)) {
                return o5Var;
            }
        }
        return Unknown;
    }

    public String getItemType() {
        return this.itemType;
    }

    @Override // io.sentry.k2
    public void serialize(n3 n3Var, ILogger iLogger) {
        ((io.sentry.internal.debugmeta.c) n3Var).y(this.itemType);
    }
}
