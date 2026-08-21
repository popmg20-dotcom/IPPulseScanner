package defpackage;

import android.animation.TypeEvaluator;
import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class td implements TypeEvaluator {
    public static final td a = new td();

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f2 = ((iIntValue >> 24) & DnsRecord.CLASS_ANY) / 255.0f;
        float f3 = ((iIntValue >> 16) & DnsRecord.CLASS_ANY) / 255.0f;
        float f4 = ((iIntValue >> 8) & DnsRecord.CLASS_ANY) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float f5 = ((iIntValue2 >> 24) & DnsRecord.CLASS_ANY) / 255.0f;
        float f6 = ((iIntValue2 >> 16) & DnsRecord.CLASS_ANY) / 255.0f;
        float f7 = ((iIntValue2 >> 8) & DnsRecord.CLASS_ANY) / 255.0f;
        float fPow = (float) Math.pow(f3, 2.2d);
        float fPow2 = (float) Math.pow(f4, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & DnsRecord.CLASS_ANY) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(f6, 2.2d);
        float fPow5 = (float) Math.pow(f7, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & DnsRecord.CLASS_ANY) / 255.0f, 2.2d);
        float fH = ha0.h(f5, f2, f, f2);
        float fH2 = ha0.h(fPow4, fPow, f, fPow);
        float fH3 = ha0.h(fPow5, fPow2, f, fPow2);
        float fH4 = ha0.h(fPow6, fPow3, f, fPow3);
        float fPow7 = ((float) Math.pow(fH2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fH3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fH4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fH * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
