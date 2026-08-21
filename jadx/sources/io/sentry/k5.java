package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k5 {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Runnable h;

    public final String toString() {
        return "SentryFeedbackOptions{isNameRequired=" + this.a + ", showName=" + this.b + ", isEmailRequired=" + this.c + ", showEmail=" + this.d + ", useSentryUser=" + this.e + ", showBranding=" + this.f + ", useShakeGesture=" + this.g + ", formTitle='Report a Bug', submitButtonLabel='Send Bug Report', cancelButtonLabel='Cancel', nameLabel='Name', namePlaceholder='Your Name', emailLabel='Email', emailPlaceholder='your.email@example.org', isRequiredLabel=' (Required)', messageLabel='Description', messagePlaceholder='What's the bug? What did you expect?'}";
    }
}
