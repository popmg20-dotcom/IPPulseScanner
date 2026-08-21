package defpackage;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RemoteViews;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.receiver.appwidget.PrivateIPProvider;
import com.getsurfboard.ui.receiver.appwidget.WidgetRetryReceiver;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.dns.DnsRecord;
import io.sentry.p4;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xb5 {
    public static final int[] b = {0, 4, 1, 5};
    public static final int[] f = {6, 2, 7, 3};
    public static final int[] z = {8, 1, 1, 1, 1, 1, 1, 3};
    public static final int[] A = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    public static final int[] X = {0, 180, 270, 90};
    public static final int[] Y = {13, 15, 14};
    public static final String[] Z = {"ad_activeview", "ad_click", "ad_exposure", "ad_query", "ad_reward", "adunit_exposure", "app_clear_data", "app_exception", "app_remove", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "app_upgrade", "app_update", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "session_start_with_rollout", "user_engagement", "ad_impression", "screen_view", "ga_extra_parameter", "app_background", "firebase_campaign"};
    public static final String[] y0 = {"ad_impression"};
    public static final String[] z0 = {"_aa", "_ac", "_xa", "_aq", "_ar", "_xu", "_cd", "_ae", "_ui", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "_ug", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_ssr", "_e", "_ai", "_vs", "_ep", "_ab", "_cmp"};
    public static final String[] A0 = {"purchase", "refund", "add_payment_info", "add_shipping_info", "add_to_cart", "add_to_wishlist", "begin_checkout", "remove_from_cart", "select_item", "select_promotion", "view_cart", "view_item", "view_item_list", "view_promotion", "ecommerce_purchase", "purchase_refund", "set_checkout_option", "checkout_progress", "select_content", "view_search_results"};

    /* JADX WARN: Removed duplicated region for block: B:141:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0956  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int B(int i, int i2) {
        double d;
        double d2;
        int iV;
        int i3;
        int iV2;
        double degrees;
        double d3;
        double d4;
        int iCeil;
        double dFloor;
        double[] dArr;
        double[] dArr2;
        double[] dArrR;
        wr4 wr4Var = wr4.k;
        int i4 = i & DnsRecord.CLASS_ANY;
        double dO = tj4.O((i & 16711680) >> 16);
        double dO2 = tj4.O((i & 65280) >> 8);
        double dO3 = tj4.O(i4);
        double d5 = 0.41233895d;
        double d6 = (dO3 * 0.18051042d) + (dO2 * 0.35762064d) + (dO * 0.41233895d);
        double d7 = (dO3 * 0.0722d) + (dO2 * 0.7152d) + (dO * 0.2126d);
        double d8 = (dO3 * 0.95034478d) + (dO2 * 0.11916382d) + (dO * 0.01932141d);
        double[][] dArr3 = vf2.z;
        double[] dArr4 = dArr3[0];
        double d9 = (dArr4[2] * d8) + (dArr4[1] * d7) + (dArr4[0] * d6);
        double[] dArr5 = dArr3[1];
        double d10 = (dArr5[2] * d8) + (dArr5[1] * d7) + (dArr5[0] * d6);
        double[] dArr6 = dArr3[2];
        double d11 = (d8 * dArr6[2]) + (d7 * dArr6[1]) + (d6 * dArr6[0]);
        double[] dArr7 = wr4Var.g;
        double d12 = wr4Var.i;
        double d13 = wr4Var.d;
        double d14 = wr4Var.a;
        double d15 = dArr7[0] * d9;
        double d16 = dArr7[1] * d10;
        double d17 = dArr7[2] * d11;
        double d18 = wr4Var.h;
        int i5 = 8;
        int i6 = 1;
        double dPow = Math.pow((Math.abs(d15) * d18) / 100.0d, 0.42d);
        double dPow2 = Math.pow((Math.abs(d16) * d18) / 100.0d, 0.42d);
        double dPow3 = Math.pow((Math.abs(d17) * d18) / 100.0d, 0.42d);
        double dSignum = ((Math.signum(d15) * 400.0d) * dPow) / (dPow + 27.13d);
        double dSignum2 = ((Math.signum(d16) * 400.0d) * dPow2) / (dPow2 + 27.13d);
        double dSignum3 = ((Math.signum(d17) * 400.0d) * dPow3) / (dPow3 + 27.13d);
        double d19 = (((dSignum2 * (-12.0d)) + (dSignum * 11.0d)) + dSignum3) / 11.0d;
        double d20 = ((dSignum + dSignum2) - (dSignum3 * 2.0d)) / 9.0d;
        double d21 = dSignum2 * 20.0d;
        double d22 = ((dSignum3 * 21.0d) + ((dSignum * 20.0d) + d21)) / 20.0d;
        double d23 = (((dSignum * 40.0d) + d21) + dSignum3) / 20.0d;
        double degrees2 = Math.toDegrees(Math.atan2(d20, d19));
        if (degrees2 < 0.0d) {
            degrees2 += 360.0d;
        } else if (degrees2 >= 360.0d) {
            degrees2 -= 360.0d;
        }
        double radians = Math.toRadians(degrees2);
        double d24 = (d23 * wr4Var.b) / d14;
        double d25 = degrees2;
        double dPow4 = (Math.pow(d24, wr4Var.j * d13) * 100.0d) / 100.0d;
        Math.sqrt(dPow4);
        double d26 = d14 + 4.0d;
        double dPow5 = Math.pow((Math.hypot(d19, d20) * (((((Math.cos(Math.toRadians(d25 < 20.14d ? d25 + 360.0d : d25) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * wr4Var.e) * wr4Var.c)) / (d22 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, wr4Var.f), 0.73d);
        double dSqrt = Math.sqrt(dPow4) * dPow5;
        Math.sqrt((dPow5 * d13) / d26);
        Math.log1p(d12 * dSqrt * 0.0228d);
        Math.cos(radians);
        Math.sin(radians);
        double[] dArr8 = {tj4.O((i >> 16) & DnsRecord.CLASS_ANY), tj4.O((i >> 8) & DnsRecord.CLASS_ANY), tj4.O(i4)};
        double[][] dArr9 = tj4.a;
        double dM = (tj4.M(yr2.R(dArr8, dArr9)[1] / 100.0d) * 116.0d) - 16.0d;
        int i7 = i2 & DnsRecord.CLASS_ANY;
        double dO4 = tj4.O((i2 & 16711680) >> 16);
        double dO5 = tj4.O((i2 & 65280) >> 8);
        double dO6 = tj4.O(i7);
        double d27 = (0.18051042d * dO6) + (0.35762064d * dO5) + (dO4 * 0.41233895d);
        double d28 = (0.0722d * dO6) + (0.7152d * dO5) + (0.2126d * dO4);
        double d29 = (dO6 * 0.95034478d) + (dO5 * 0.11916382d) + (dO4 * 0.01932141d);
        double[] dArr10 = dArr3[0];
        double d30 = (dArr10[2] * d29) + (dArr10[1] * d28) + (dArr10[0] * d27);
        double[] dArr11 = dArr3[1];
        double d31 = (dArr11[2] * d29) + (dArr11[1] * d28) + (dArr11[0] * d27);
        double[] dArr12 = dArr3[2];
        double d32 = (d29 * dArr12[2]) + (d28 * dArr12[1]) + (d27 * dArr12[0]);
        double[] dArr13 = wr4Var.g;
        double d33 = wr4Var.i;
        double d34 = wr4Var.d;
        double d35 = wr4Var.a;
        double d36 = dArr13[0] * d30;
        double d37 = dArr13[1] * d31;
        double d38 = dArr13[2] * d32;
        double d39 = wr4Var.h;
        double dPow6 = Math.pow((Math.abs(d36) * d39) / 100.0d, 0.42d);
        double dPow7 = Math.pow((Math.abs(d37) * d39) / 100.0d, 0.42d);
        double dPow8 = Math.pow((Math.abs(d38) * d39) / 100.0d, 0.42d);
        double dSignum4 = ((Math.signum(d36) * 400.0d) * dPow6) / (dPow6 + 27.13d);
        double dSignum5 = ((Math.signum(d37) * 400.0d) * dPow7) / (dPow7 + 27.13d);
        double dSignum6 = ((Math.signum(d38) * 400.0d) * dPow8) / (dPow8 + 27.13d);
        double d40 = ((((-12.0d) * dSignum5) + (dSignum4 * 11.0d)) + dSignum6) / 11.0d;
        double d41 = ((dSignum4 + dSignum5) - (dSignum6 * 2.0d)) / 9.0d;
        double d42 = dSignum5 * 20.0d;
        double d43 = ((dSignum6 * 21.0d) + ((dSignum4 * 20.0d) + d42)) / 20.0d;
        double d44 = (((dSignum4 * 40.0d) + d42) + dSignum6) / 20.0d;
        double degrees3 = Math.toDegrees(Math.atan2(d41, d40));
        if (degrees3 < 0.0d) {
            degrees3 += 360.0d;
        } else if (degrees3 >= 360.0d) {
            degrees3 -= 360.0d;
        }
        double radians2 = Math.toRadians(degrees3);
        double dPow9 = (Math.pow((d44 * wr4Var.b) / d35, wr4Var.j * d34) * 100.0d) / 100.0d;
        Math.sqrt(dPow9);
        double d45 = d35 + 4.0d;
        double dPow10 = Math.pow((Math.hypot(d40, d41) * (((((Math.cos(Math.toRadians(degrees3 < 20.14d ? degrees3 + 360.0d : degrees3) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * wr4Var.e) * wr4Var.c)) / (d43 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, wr4Var.f), 0.73d);
        double dSqrt2 = Math.sqrt(dPow9) * dPow10 * d33;
        Math.sqrt((dPow10 * d34) / d45);
        Math.log1p(dSqrt2 * 0.0228d);
        Math.cos(radians2);
        Math.sin(radians2);
        tj4.M(yr2.R(new double[]{tj4.O((i2 >> 16) & DnsRecord.CLASS_ANY), tj4.O((i2 >> 8) & DnsRecord.CLASS_ANY), tj4.O(i7)}, dArr9)[1] / 100.0d);
        double dJ0 = yr2.j0((Math.min((180.0d - Math.abs(Math.abs(d25 - degrees3) - 180.0d)) * 0.5d, 15.0d) * (yr2.j0(degrees3 - d25) <= 180.0d ? 1.0d : -1.0d)) + d25);
        double[] dArr14 = uf2.X;
        if (dSqrt >= 1.0E-4d && dM >= 1.0E-4d && dM <= 99.9999d) {
            double dJ02 = (yr2.j0(dJ0) / 180.0d) * 3.141592653589793d;
            double dN0 = tj4.n0(dM);
            double dSqrt3 = Math.sqrt(dN0) * 11.0d;
            wr4 wr4Var2 = wr4.k;
            double dPow11 = 1.0d / Math.pow(1.64d - Math.pow(0.29d, wr4Var2.f), 0.73d);
            double dCos = (Math.cos(dJ02 + 2.0d) + 3.8d) * 0.25d * 3846.153846153846d * wr4Var2.e * wr4Var2.c;
            double dSin = Math.sin(dJ02);
            double dCos2 = Math.cos(dJ02);
            d = 11.0d;
            int i8 = 0;
            while (true) {
                if (i8 >= 5) {
                    d4 = dN0;
                    d2 = d5;
                    break;
                }
                d2 = d5;
                double d46 = dSqrt3 / 100.0d;
                d4 = dN0;
                double dPow12 = Math.pow(((dSqrt == 0.0d || dSqrt3 == 0.0d) ? 0.0d : dSqrt / Math.sqrt(d46)) * dPow11, 1.1111111111111112d);
                double d47 = dSqrt3;
                double dPow13 = (Math.pow(d46, (1.0d / wr4Var2.d) / wr4Var2.j) * wr4Var2.a) / wr4Var2.b;
                double d48 = (((dPow13 + 0.305d) * 23.0d) * dPow12) / (((108.0d * dPow12) * dSin) + (((dPow12 * 11.0d) * dCos2) + (23.0d * dCos)));
                double d49 = d48 * dCos2;
                double d50 = d48 * dSin;
                double d51 = dPow13 * 460.0d;
                dArrR = yr2.R(new double[]{uf2.E(((288.0d * d50) + ((451.0d * d49) + d51)) / 1403.0d), uf2.E(((d51 - (891.0d * d49)) - (261.0d * d50)) / 1403.0d), uf2.E(((d51 - (d49 * 220.0d)) - (d50 * 6300.0d)) / 1403.0d)}, uf2.A);
                double d52 = dArrR[0];
                if (d52 < 0.0d) {
                    break;
                }
                double d53 = dArrR[1];
                if (d53 < 0.0d) {
                    break;
                }
                double d54 = dArrR[2];
                if (d54 < 0.0d) {
                    break;
                }
                double d55 = (dArr14[2] * d54) + (dArr14[1] * d53) + (dArr14[0] * d52);
                if (d55 <= 0.0d) {
                    break;
                }
                if (i8 == 4) {
                    break;
                }
                double d56 = d55 - d4;
                if (Math.abs(d56) < 0.002d) {
                    break;
                }
                dSqrt3 = d47 - ((d56 * d47) / (d55 * 2.0d));
                i8++;
                d5 = d2;
                dN0 = d4;
            }
            double d57 = dArrR[0];
            iV2 = (d57 > 100.01d || dArrR[1] > 100.01d || dArrR[2] > 100.01d) ? 0 : (tj4.v(dArrR[2]) & DnsRecord.CLASS_ANY) | ((tj4.v(d57) & DnsRecord.CLASS_ANY) << 16) | (-16777216) | ((tj4.v(dArrR[1]) & DnsRecord.CLASS_ANY) << 8);
            if (iV2 == 0) {
                double[] dArr15 = {-1.0d, -1.0d, -1.0d};
                double[] dArr16 = dArr15;
                boolean z2 = false;
                int i9 = 0;
                double d58 = 0.0d;
                double d59 = 0.0d;
                boolean z3 = true;
                while (i9 < 12) {
                    double d60 = dArr14[0];
                    double d61 = dArr14[i6];
                    double d62 = dArr14[2];
                    double d63 = i9 % 4 <= i6 ? 0.0d : 100.0d;
                    double d64 = i9 % 2 == 0 ? 0.0d : 100.0d;
                    if (i9 < 4) {
                        double d65 = ((d4 - (d61 * d63)) - (d62 * d64)) / d60;
                        dArr = uf2.F(d65) ? new double[]{d65, d63, d64} : new double[]{-1.0d, -1.0d, -1.0d};
                    } else if (i9 < i5) {
                        double d66 = ((d4 - (d60 * d64)) - (d62 * d63)) / d61;
                        if (uf2.F(d66)) {
                            dArr2 = new double[]{d64, d66, d63};
                            dArr = dArr2;
                        } else {
                            dArr = new double[]{-1.0d, -1.0d, -1.0d};
                        }
                    } else {
                        double d67 = ((d4 - (d60 * d63)) - (d61 * d64)) / d62;
                        if (uf2.F(d67)) {
                            dArr2 = new double[]{d63, d64, d67};
                            dArr = dArr2;
                        } else {
                            dArr = new double[]{-1.0d, -1.0d, -1.0d};
                        }
                    }
                    if (dArr[0] >= 0.0d) {
                        double dY = uf2.y(dArr);
                        if (!z2) {
                            dArr15 = dArr;
                            dArr16 = dArr15;
                            d58 = dY;
                            d59 = d58;
                            z2 = true;
                        } else if (z3 || uf2.b(d58, dY, d59)) {
                            if (uf2.b(d58, dJ02, dY)) {
                                dArr16 = dArr;
                                z3 = false;
                                d59 = dY;
                            } else {
                                dArr15 = dArr;
                                z3 = false;
                                d58 = dY;
                            }
                        }
                    }
                    i9++;
                    i6 = 1;
                    i5 = 8;
                }
                double[][] dArr17 = {dArr15, dArr16};
                double[] dArr18 = dArr17[0];
                double dY2 = uf2.y(dArr18);
                double[] dArr19 = dArr17[1];
                for (int i10 = 0; i10 < 3; i10++) {
                    double d68 = dArr18[i10];
                    double d69 = dArr19[i10];
                    if (d68 != d69) {
                        if (d68 < d69) {
                            iCeil = (int) Math.floor(uf2.S(d68) - 0.5d);
                            dFloor = Math.ceil(uf2.S(dArr19[i10]) - 0.5d);
                        } else {
                            iCeil = (int) Math.ceil(uf2.S(d68) - 0.5d);
                            dFloor = Math.floor(uf2.S(dArr19[i10]) - 0.5d);
                        }
                        int i11 = (int) dFloor;
                        double d70 = dY2;
                        for (int i12 = 0; i12 < 8 && Math.abs(i11 - iCeil) > 1; i12++) {
                            int iFloor = (int) Math.floor(((double) (iCeil + i11)) / 2.0d);
                            double d71 = uf2.Y[iFloor];
                            double d72 = dArr18[i10];
                            double d73 = (d71 - d72) / (dArr19[i10] - d72);
                            double d74 = dArr18[0];
                            double d75 = ((dArr19[0] - d74) * d73) + d74;
                            double d76 = dArr18[1];
                            double d77 = ((dArr19[1] - d76) * d73) + d76;
                            double d78 = dArr18[2];
                            double[] dArr20 = {d75, d77, ((dArr19[2] - d78) * d73) + d78};
                            double dY3 = uf2.y(dArr20);
                            if (uf2.b(d70, dJ02, dY3)) {
                                i11 = iFloor;
                                dArr19 = dArr20;
                            } else {
                                iCeil = iFloor;
                                dArr18 = dArr20;
                                d70 = dY3;
                            }
                        }
                        dY2 = d70;
                    }
                }
                double[] dArr21 = {(dArr18[0] + dArr19[0]) / 2.0d, (dArr18[1] + dArr19[1]) / 2.0d, (dArr18[2] + dArr19[2]) / 2.0d};
                int iV3 = tj4.v(dArr21[0]);
                int iV4 = tj4.v(dArr21[1]);
                int iV5 = tj4.v(dArr21[2]);
                i3 = ((iV3 & DnsRecord.CLASS_ANY) << 16) | (-16777216) | ((iV4 & DnsRecord.CLASS_ANY) << 8);
                iV = iV5 & DnsRecord.CLASS_ANY;
            }
            ue2 ue2Var = new ue2();
            ue2Var.b = iV2;
            wr4 wr4Var3 = wr4.k;
            int i13 = iV2 & DnsRecord.CLASS_ANY;
            double dO7 = tj4.O((iV2 & 16711680) >> 16);
            double dO8 = tj4.O((iV2 & 65280) >> 8);
            double dO9 = tj4.O(i13);
            double d79 = (0.18051042d * dO9) + (0.35762064d * dO8) + (dO7 * d2);
            double d80 = (0.0722d * dO9) + (0.7152d * dO8) + (0.2126d * dO7);
            double d81 = (dO9 * 0.95034478d) + (dO8 * 0.11916382d) + (dO7 * 0.01932141d);
            double[][] dArr22 = vf2.z;
            double[] dArr23 = dArr22[0];
            double d82 = (dArr23[2] * d81) + (dArr23[1] * d80) + (dArr23[0] * d79);
            double[] dArr24 = dArr22[1];
            double d83 = (dArr24[2] * d81) + (dArr24[1] * d80) + (dArr24[0] * d79);
            double[] dArr25 = dArr22[2];
            double d84 = (d81 * dArr25[2]) + (d80 * dArr25[1]) + (d79 * dArr25[0]);
            double[] dArr26 = wr4Var3.g;
            double d85 = wr4Var3.i;
            double d86 = wr4Var3.d;
            double d87 = wr4Var3.a;
            double d88 = dArr26[0] * d82;
            double d89 = dArr26[1] * d83;
            double d90 = dArr26[2] * d84;
            double d91 = wr4Var3.h;
            double dPow14 = Math.pow((Math.abs(d88) * d91) / 100.0d, 0.42d);
            double dPow15 = Math.pow((Math.abs(d89) * d91) / 100.0d, 0.42d);
            double dPow16 = Math.pow((Math.abs(d90) * d91) / 100.0d, 0.42d);
            double dSignum7 = ((Math.signum(d88) * 400.0d) * dPow14) / (dPow14 + 27.13d);
            double dSignum8 = ((Math.signum(d89) * 400.0d) * dPow15) / (dPow15 + 27.13d);
            double dSignum9 = ((Math.signum(d90) * 400.0d) * dPow16) / (dPow16 + 27.13d);
            double d92 = ((((-12.0d) * dSignum8) + (dSignum7 * d)) + dSignum9) / d;
            double d93 = ((dSignum7 + dSignum8) - (dSignum9 * 2.0d)) / 9.0d;
            double d94 = dSignum8 * 20.0d;
            double d95 = ((21.0d * dSignum9) + ((dSignum7 * 20.0d) + d94)) / 20.0d;
            double d96 = (((40.0d * dSignum7) + d94) + dSignum9) / 20.0d;
            degrees = Math.toDegrees(Math.atan2(d93, d92));
            if (degrees >= 0.0d) {
                degrees += 360.0d;
            } else if (degrees >= 360.0d) {
                degrees -= 360.0d;
            }
            double radians3 = Math.toRadians(degrees);
            d3 = degrees;
            double dPow17 = (Math.pow((d96 * wr4Var3.b) / d87, wr4Var3.j * d86) * 100.0d) / 100.0d;
            Math.sqrt(dPow17);
            double d97 = d87 + 4.0d;
            if (d3 < 20.14d) {
                d3 += 360.0d;
            }
            double dPow18 = Math.pow((Math.hypot(d92, d93) * (((((Math.cos(Math.toRadians(d3) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * wr4Var3.e) * wr4Var3.c)) / (d95 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, wr4Var3.f), 0.73d);
            double dSqrt4 = Math.sqrt(dPow17) * dPow18 * d85;
            Math.sqrt((dPow18 * d86) / d97);
            Math.log1p(dSqrt4 * 0.0228d);
            Math.cos(radians3);
            Math.sin(radians3);
            tj4.M(yr2.R(new double[]{tj4.O((iV2 >> 16) & DnsRecord.CLASS_ANY), tj4.O((iV2 >> 8) & DnsRecord.CLASS_ANY), tj4.O(i13)}, tj4.a)[1] / 100.0d);
            return ue2Var.b;
        }
        d = 11.0d;
        d2 = 0.41233895d;
        iV = tj4.v(tj4.n0(dM)) & DnsRecord.CLASS_ANY;
        i3 = (iV << 16) | (-16777216) | (iV << 8);
        iV2 = iV | i3;
        ue2 ue2Var2 = new ue2();
        ue2Var2.b = iV2;
        wr4 wr4Var32 = wr4.k;
        int i132 = iV2 & DnsRecord.CLASS_ANY;
        double dO72 = tj4.O((iV2 & 16711680) >> 16);
        double dO82 = tj4.O((iV2 & 65280) >> 8);
        double dO92 = tj4.O(i132);
        double d792 = (0.18051042d * dO92) + (0.35762064d * dO82) + (dO72 * d2);
        double d802 = (0.0722d * dO92) + (0.7152d * dO82) + (0.2126d * dO72);
        double d812 = (dO92 * 0.95034478d) + (dO82 * 0.11916382d) + (dO72 * 0.01932141d);
        double[][] dArr222 = vf2.z;
        double[] dArr232 = dArr222[0];
        double d822 = (dArr232[2] * d812) + (dArr232[1] * d802) + (dArr232[0] * d792);
        double[] dArr242 = dArr222[1];
        double d832 = (dArr242[2] * d812) + (dArr242[1] * d802) + (dArr242[0] * d792);
        double[] dArr252 = dArr222[2];
        double d842 = (d812 * dArr252[2]) + (d802 * dArr252[1]) + (d792 * dArr252[0]);
        double[] dArr262 = wr4Var32.g;
        double d852 = wr4Var32.i;
        double d862 = wr4Var32.d;
        double d872 = wr4Var32.a;
        double d882 = dArr262[0] * d822;
        double d892 = dArr262[1] * d832;
        double d902 = dArr262[2] * d842;
        double d912 = wr4Var32.h;
        double dPow142 = Math.pow((Math.abs(d882) * d912) / 100.0d, 0.42d);
        double dPow152 = Math.pow((Math.abs(d892) * d912) / 100.0d, 0.42d);
        double dPow162 = Math.pow((Math.abs(d902) * d912) / 100.0d, 0.42d);
        double dSignum72 = ((Math.signum(d882) * 400.0d) * dPow142) / (dPow142 + 27.13d);
        double dSignum82 = ((Math.signum(d892) * 400.0d) * dPow152) / (dPow152 + 27.13d);
        double dSignum92 = ((Math.signum(d902) * 400.0d) * dPow162) / (dPow162 + 27.13d);
        double d922 = ((((-12.0d) * dSignum82) + (dSignum72 * d)) + dSignum92) / d;
        double d932 = ((dSignum72 + dSignum82) - (dSignum92 * 2.0d)) / 9.0d;
        double d942 = dSignum82 * 20.0d;
        double d952 = ((21.0d * dSignum92) + ((dSignum72 * 20.0d) + d942)) / 20.0d;
        double d962 = (((40.0d * dSignum72) + d942) + dSignum92) / 20.0d;
        degrees = Math.toDegrees(Math.atan2(d932, d922));
        if (degrees >= 0.0d) {
        }
        double radians32 = Math.toRadians(degrees);
        d3 = degrees;
        double dPow172 = (Math.pow((d962 * wr4Var32.b) / d872, wr4Var32.j * d862) * 100.0d) / 100.0d;
        Math.sqrt(dPow172);
        double d972 = d872 + 4.0d;
        if (d3 < 20.14d) {
        }
        double dPow182 = Math.pow((Math.hypot(d922, d932) * (((((Math.cos(Math.toRadians(d3) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * wr4Var32.e) * wr4Var32.c)) / (d952 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, wr4Var32.f), 0.73d);
        double dSqrt42 = Math.sqrt(dPow172) * dPow182 * d852;
        Math.sqrt((dPow182 * d862) / d972);
        Math.log1p(dSqrt42 * 0.0228d);
        Math.cos(radians32);
        Math.sin(radians32);
        tj4.M(yr2.R(new double[]{tj4.O((iV2 >> 16) & DnsRecord.CLASS_ANY), tj4.O((iV2 >> 8) & DnsRecord.CLASS_ANY), tj4.O(i132)}, tj4.a)[1] / 100.0d);
        return ue2Var2.b;
    }

    public static final boolean C(ComponentName componentName) {
        int[] appWidgetIds;
        componentName.getClass();
        try {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(ContextUtilsKt.getContext());
            if (appWidgetManager == null || (appWidgetIds = appWidgetManager.getAppWidgetIds(componentName)) == null) {
                return false;
            }
            return !(appWidgetIds.length == 0);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object D(zd4 zd4Var, em1 em1Var, Throwable th, ie0 ie0Var) {
        lg1 lg1Var;
        if (ie0Var instanceof lg1) {
            lg1Var = (lg1) ie0Var;
            int i = lg1Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                lg1Var.Y = i - Integer.MIN_VALUE;
            } else {
                lg1Var = new lg1(ie0Var);
            }
        }
        Object obj = lg1Var.X;
        int i2 = lg1Var.Y;
        try {
            if (i2 == 0) {
                n12.S(obj);
                lg1Var.A = th;
                lg1Var.Y = 1;
                Object objE = em1Var.e(zd4Var, th, lg1Var);
                Object obj2 = mf0.b;
                if (objE == obj2) {
                    return obj2;
                }
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                th = lg1Var.A;
                n12.S(obj);
            }
            return xl4.a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                ek0.b(th2, th);
            }
            throw th2;
        }
    }

    public static boolean E(byte b2) {
        return b2 > -65;
    }

    public static int F(String str) {
        if (str.charAt(0) != '#') {
            return Color.parseColor(str);
        }
        long j = Long.parseLong(str.substring(1), 16);
        if (str.length() == 7) {
            return (int) (4278190080L | j);
        }
        if (str.length() != 9) {
            xe.k("Unknown color");
            return 0;
        }
        int i = ((int) (j >> 24)) & DnsRecord.CLASS_ANY;
        int i2 = ((int) (j >> 16)) & DnsRecord.CLASS_ANY;
        return (((int) (j & 255)) << 24) | (i << 16) | (i2 << 8) | (((int) (j >> 8)) & DnsRecord.CLASS_ANY);
    }

    public static float G(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = 0.8f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static m04 H(final float f2) {
        Object objG = new fo4(Float.valueOf(f2), "n04", uo4.b, d7.z).B("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new am1() { // from class: l04
            @Override // defpackage.am1
            public final Object g(Object obj) {
                ((Float) obj).floatValue();
                float f3 = f2;
                double d = f3;
                boolean z2 = false;
                if (0.0d <= d && d <= 1.0d && !qe.a0(Float.valueOf(f3), new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)})) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
        }).g();
        objG.getClass();
        float fFloatValue = ((Number) objG).floatValue();
        return new m04(fFloatValue, "ratio:" + fFloatValue);
    }

    public static final void I() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "PrivateIPProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "refreshWidgets() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("PrivateIPProvider", "refreshWidgets() called", null);
        }
        ei0 ei0Var = (ei0) cr2.b.d();
        if (ei0Var == null) {
            return;
        }
        ComponentName componentName = PrivateIPProvider.a;
        if (C(componentName)) {
            RemoteViews remoteViews = new RemoteViews(ContextUtilsKt.getContext().getPackageName(), R.layout.widget_private_ip);
            String str = "refreshWidgets() start update layout: " + ei0Var;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "PrivateIPProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("PrivateIPProvider", str, null);
            }
            int iOrdinal = ei0Var.a.ordinal();
            if (iOrdinal == 0) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setViewVisibility(R.id.title, 0);
                remoteViews.setViewVisibility(R.id.loading, 0);
                remoteViews.setViewVisibility(R.id.ip, 4);
                remoteViews.setViewVisibility(R.id.retry, 4);
            } else if (iOrdinal == 1) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setViewVisibility(R.id.title, 0);
                remoteViews.setViewVisibility(R.id.loading, 4);
                remoteViews.setViewVisibility(R.id.ip, 0);
                remoteViews.setViewVisibility(R.id.retry, 4);
                Object obj = ei0Var.b;
                if (obj != null) {
                    remoteViews.setTextViewText(R.id.ip, (CharSequence) obj);
                } else {
                    remoteViews.setTextViewText(R.id.ip, ContextUtilsKt.k(R.string.no_network));
                }
            } else {
                if (iOrdinal != 2) {
                    g.d();
                    return;
                }
                remoteViews.setViewVisibility(R.id.icon, 4);
                remoteViews.setViewVisibility(R.id.title, 4);
                remoteViews.setViewVisibility(R.id.loading, 4);
                remoteViews.setViewVisibility(R.id.ip, 4);
                remoteViews.setViewVisibility(R.id.retry, 0);
            }
            Intent action = new Intent(ContextUtilsKt.getContext(), (Class<?>) WidgetRetryReceiver.class).putExtra("type", "private_ip").setAction("com.getsurfboard.ACTION_WIDGET_RETRY");
            action.getClass();
            remoteViews.setOnClickPendingIntent(R.id.retry, PendingIntent.getBroadcast(ContextUtilsKt.getContext(), fj3.h, action, l72.a(134217728, true)));
            Intent intentS = p95.s(ContextUtilsKt.getContext(), false);
            intentS.setFlags(intentS.getFlags() + 67108864);
            intentS.setFlags(intentS.getFlags() + 536870912);
            intentS.putExtra("tab", "dashboard");
            remoteViews.setOnClickPendingIntent(android.R.id.background, l72.o(ContextUtilsKt.getContext(), fj3.c, intentS, true));
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(ContextUtilsKt.getContext());
            if (appWidgetManager != null) {
                appWidgetManager.updateAppWidget(componentName, remoteViews);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long J(CodeEditor codeEditor, MotionEvent motionEvent, int i) {
        int i2;
        motionEvent.getClass();
        float x = (i == -1 ? motionEvent.getX() : motionEvent.getX(i)) + codeEditor.getOffsetX();
        float y = (i == -1 ? motionEvent.getY() : motionEvent.getY(i)) + codeEditor.getOffsetY();
        float fS = codeEditor.S();
        codeEditor.getRenderer().A();
        float fT = codeEditor.T();
        int i3 = 1;
        if (x >= 0.0f) {
            if (0.0f <= x && x <= fS) {
                i2 = 1;
            } else if (fS > x || x > fS + 0.0f) {
                float f2 = fS + 0.0f;
                if (x > codeEditor.getDividerMarginLeft() + f2 || f2 > x) {
                    float dividerWidth = codeEditor.getDividerWidth() + codeEditor.getDividerMarginLeft() + f2;
                    if (x > codeEditor.getDividerWidth() + codeEditor.getDividerMarginRight() + codeEditor.getDividerMarginLeft() + f2 || dividerWidth > x) {
                        float dividerMarginLeft = codeEditor.getDividerMarginLeft() + f2;
                        if (x <= codeEditor.getDividerWidth() + codeEditor.getDividerMarginLeft() + f2 && dividerMarginLeft <= x) {
                            i2 = 4;
                        } else if (fT <= x) {
                            if (x > codeEditor.getWidth() + codeEditor.getScrollMaxX()) {
                                if (!codeEditor.Z0 || 0.0f > x || x > codeEditor.getWidth()) {
                                    i2 = 0;
                                }
                            }
                            i2 = 5;
                        }
                    } else {
                        i2 = 3;
                    }
                }
            } else {
                i2 = 2;
            }
        }
        if (y >= 0.0f) {
            if (y <= (codeEditor.getHeight() / 2) + codeEditor.getScrollMaxY()) {
                i3 = 0;
            }
        }
        return ez4.M(i2, i3);
    }

    public static final void K(z00 z00Var, ge0 ge0Var, boolean z2) {
        Object objV = z00Var.v();
        Throwable thG = z00Var.g(objV);
        Object tk3Var = thG != null ? new tk3(thG) : z00Var.h(objV);
        if (!z2) {
            ge0Var.d(tk3Var);
            return;
        }
        ge0Var.getClass();
        lv0 lv0Var = (lv0) ge0Var;
        ie0 ie0Var = lv0Var.X;
        Object obj = lv0Var.Z;
        cf0 cf0VarJ = ie0Var.j();
        Object objC = nd4.c(cf0VarJ, obj);
        bl4 bl4VarC0 = objC != nd4.a ? co4.c0(ie0Var, cf0VarJ, objC) : null;
        try {
            ie0Var.d(tk3Var);
            if (bl4VarC0 == null || bl4VarC0.n0()) {
                nd4.a(cf0VarJ, objC);
            }
        } catch (Throwable th) {
            if (bl4VarC0 == null || bl4VarC0.n0()) {
                nd4.a(cf0VarJ, objC);
            }
            throw th;
        }
    }

    public static final void L(Throwable th) {
        try {
            p4.c().x(th).getClass();
        } catch (Throwable unused) {
        }
    }

    public static int M(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 3) {
            return i != 4 ? 0 : 5;
        }
        return 4;
    }

    public static pb5 N() {
        String str;
        ClassLoader classLoader = xb5.class.getClassLoader();
        if (pb5.class.equals(pb5.class)) {
            str = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";
        } else {
            if (!pb5.class.getPackage().equals(xb5.class.getPackage())) {
                xe.k(pb5.class.getName());
                return null;
            }
            str = pb5.class.getPackage().getName() + ".BlazeGenerated" + pb5.class.getSimpleName() + "Loader";
        }
        try {
            try {
                try {
                    try {
                        dw2.I(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                        throw null;
                    } catch (InvocationTargetException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (InstantiationException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            try {
                Iterator it = Arrays.asList(new xb5[0]).iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    try {
                        if (it.next() == null) {
                            throw null;
                        }
                        throw new ClassCastException();
                    } catch (ServiceConfigurationError e5) {
                        Logger.getLogger(kb5.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(pb5.class.getSimpleName()), (Throwable) e5);
                    }
                }
                if (arrayList.size() == 1) {
                    return (pb5) arrayList.get(0);
                }
                if (arrayList.size() == 0) {
                    return null;
                }
                try {
                    return (pb5) pb5.class.getMethod("combine", Collection.class).invoke(null, arrayList);
                } catch (IllegalAccessException e6) {
                    zo2.q(e6);
                    return null;
                } catch (NoSuchMethodException e7) {
                    zo2.q(e7);
                    return null;
                } catch (InvocationTargetException e8) {
                    zo2.q(e8);
                    return null;
                }
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    public static final void c(String str) {
        String str2;
        if (fy4.b) {
            str2 = str;
            Xlog.logWrite2(0L, 1, "CrashUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
        } else {
            str2 = str;
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("CrashUtils", str2, null);
        }
        try {
            p4.c().v(str2);
        } catch (Throwable unused) {
        }
    }

    public static final int d(io3 io3Var, String str) {
        io3Var.getClass();
        int columnCount = io3Var.getColumnCount();
        int i = 0;
        while (true) {
            if (i >= columnCount) {
                i = -1;
                break;
            }
            if (str.equals(io3Var.getColumnName(i))) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return i;
        }
        String str2 = "`" + str + '`';
        int columnCount2 = io3Var.getColumnCount();
        int i2 = 0;
        while (true) {
            if (i2 >= columnCount2) {
                i2 = -1;
                break;
            }
            if (str2.equals(io3Var.getColumnName(i2))) {
                break;
            }
            i2++;
        }
        if (i2 >= 0) {
            return i2;
        }
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            int columnCount3 = io3Var.getColumnCount();
            String strConcat = ".".concat(str);
            String str3 = "." + str + '`';
            for (int i3 = 0; i3 < columnCount3; i3++) {
                String columnName = io3Var.getColumnName(i3);
                if (columnName.length() >= str.length() + 2 && (w44.d0(columnName, strConcat, false) || (columnName.charAt(0) == '`' && w44.d0(columnName, str3, false)))) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static String f(pz pzVar, Integer num, ArrayList arrayList) {
        if (num == null || !arrayList.contains("0") || !arrayList.contains("1")) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) pzVar.b("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return "1";
            }
            return null;
        }
        if (num.intValue() == 0 && ((Integer) pzVar.b("1").a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return "0";
        }
        return null;
    }

    public static ii g(en enVar) {
        long jI = 0;
        String strG = "";
        String strG2 = "";
        while (true) {
            int iH = enVar.h();
            if (iH == 0) {
                return new ii(strG, strG2, jI);
            }
            int i = iH >>> 3;
            int i2 = iH & 7;
            switch (i) {
                case 1:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 2:
                    en.b(i, 0, i2);
                    jI = enVar.i();
                    break;
                case 3:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 4:
                    en.b(i, 2, i2);
                    strG = enVar.g();
                    break;
                case 5:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 6:
                    en.b(i, 2, i2);
                    strG2 = enVar.g();
                    break;
                case 7:
                    en.b(i, 0, i2);
                    enVar.i();
                    break;
                case 8:
                    en.b(i, 2, i2);
                    enVar.g();
                    break;
                default:
                    enVar.j(i2);
                    break;
            }
        }
    }

    public static final xf2 h(String str) {
        if (str != null) {
            if (w44.j0(str, "#!MANAGED-CONFIG ", false)) {
                List<String> listK0 = p44.K0(str, new char[]{' '}, 6);
                if (!listK0.isEmpty() && listK0.size() > 1) {
                    String str2 = null;
                    Long lValueOf = null;
                    Boolean boolValueOf = null;
                    for (String str3 : listK0) {
                        if (w44.j0(p44.U0(str3).toString(), "http", false)) {
                            str2 = str3;
                        }
                        if (w44.j0(p44.U0(str3).toString(), "interval", false)) {
                            List listL0 = p44.L0(str3, new String[]{"="}, 6);
                            if (listL0.size() > 1) {
                                lValueOf = Long.valueOf(Long.parseLong(p44.U0((String) listL0.get(1)).toString()));
                            }
                        }
                        if (w44.j0(p44.U0(str3).toString(), "strict", false)) {
                            List listL02 = p44.L0(str3, new String[]{"="}, 6);
                            if (listL02.size() > 1) {
                                boolValueOf = Boolean.valueOf(ji0.W(p44.U0((String) listL02.get(1)).toString()));
                            }
                        }
                    }
                    if (str2 != null) {
                        return new xf2(str2, boolValueOf != null ? boolValueOf.booleanValue() : false, lValueOf != null ? lValueOf.longValue() : 86400L);
                    }
                }
            }
        }
        return null;
    }

    public static wl3 i(en enVar) {
        while (true) {
            int iH = enVar.h();
            if (iH == 0) {
                return new wl3(23);
            }
            int i = iH >>> 3;
            int i2 = iH & 7;
            if (i == 1) {
                en.b(i, 2, i2);
                enVar.g();
            } else if (i == 2) {
                en.b(i, 2, i2);
                enVar.g();
            } else if (i == 3) {
                en.b(i, 0, i2);
                enVar.i();
            } else if (i == 4) {
                en.b(i, 2, i2);
                enVar.e();
            } else if (i != 6) {
                enVar.j(i2);
            } else {
                en.b(i, 2, i2);
                en enVarF = enVar.f();
                while (true) {
                    int iH2 = enVarF.h();
                    if (iH2 != 0) {
                        int i3 = iH2 >>> 3;
                        int i4 = iH2 & 7;
                        if (i3 != 1) {
                            enVarF.j(i4);
                        } else {
                            en.b(i3, 2, i4);
                            enVarF.e();
                        }
                    }
                }
            }
        }
    }

    public static void j(en enVar, HashMap map) {
        int i;
        int i2;
        en enVar2;
        int i3 = 0;
        cf4 cf4Var = null;
        int i4 = 0;
        while (true) {
            int iH = enVar.h();
            if (iH == 0) {
                if (cf4Var != null) {
                    map.put(Integer.valueOf(i4), cf4Var);
                    return;
                }
                return;
            }
            int i5 = iH >>> 3;
            int i6 = iH & 7;
            int i7 = 1;
            if (i5 == 1) {
                i = i3;
                en.b(i5, i, i6);
                i4 = (int) enVar.i();
            } else if (i5 != 2) {
                enVar.j(i6);
                i = i3;
            } else {
                en.b(i5, 2, i6);
                en enVarF = enVar.f();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                int i8 = i3;
                String strG = "";
                while (true) {
                    int iH2 = enVarF.h();
                    if (iH2 != 0) {
                        int i9 = iH2 >>> 3;
                        int i10 = iH2 & 7;
                        switch (i9) {
                            case 1:
                                i2 = i3;
                                enVar2 = enVarF;
                                en.b(i9, i2, i10);
                                i8 = (int) enVar2.i();
                                break;
                            case 2:
                                enVar2 = enVarF;
                                en.b(i9, 2, i10);
                                strG = enVar2.g();
                                i2 = 0;
                                break;
                            case 3:
                                en.b(i9, 2, i10);
                                en enVarF2 = enVarF.f();
                                String strG2 = "";
                                long jI = 0;
                                while (true) {
                                    int iH3 = enVarF2.h();
                                    if (iH3 == 0) {
                                        enVar2 = enVarF;
                                        arrayList.add(new zh3(strG2, jI));
                                        i2 = 0;
                                    } else {
                                        int i11 = iH3 >>> 3;
                                        en enVar3 = enVarF;
                                        int i12 = iH3 & 7;
                                        if (i11 == i7) {
                                            en.b(i11, 2, i12);
                                            strG2 = enVarF2.g();
                                        } else if (i11 != 2) {
                                            enVarF2.j(i12);
                                        } else {
                                            en.b(i11, 0, i12);
                                            jI = enVarF2.i();
                                        }
                                        enVarF = enVar3;
                                        i7 = 1;
                                    }
                                    break;
                                }
                                break;
                            case 4:
                                en.b(i9, 2, i10);
                                arrayList4.add(g(enVarF.f()));
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            case 5:
                                en.b(i9, 2, i10);
                                arrayList5.add(i(enVarF.f()));
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            case 6:
                                en.b(i9, i3, i10);
                                enVarF.i();
                                i2 = i3;
                                enVar2 = enVarF;
                                break;
                            case 7:
                                en.b(i9, 2, i10);
                                arrayList2.add(enVarF.g());
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            case 8:
                                en.b(i9, i3, i10);
                                enVarF.i();
                                i2 = i3;
                                enVar2 = enVarF;
                                break;
                            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                en.b(i9, 2, i10);
                                arrayList3.add(enVarF.g());
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                            default:
                                enVarF.j(i10);
                                enVar2 = enVarF;
                                i2 = 0;
                                break;
                        }
                        i3 = i2;
                        enVarF = enVar2;
                        i7 = 1;
                    } else {
                        i = i3;
                        cf4Var = new cf4(i8, strG, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
                    }
                }
            }
            i3 = i;
        }
    }

    public static int[] k(cn cnVar, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (cnVar.b(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z2 = false;
        while (i < i3) {
            if (cnVar.b(i, i2) != z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (G(iArr2, iArr) < 0.42f) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i7 != length - 1 || G(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    public static xk3[] l(cn cnVar, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        boolean z2;
        int[] iArrK;
        xk3[] xk3VarArr = new xk3[4];
        int[] iArr2 = iArr;
        int[] iArr3 = new int[iArr2.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                i6 = i7;
                z2 = false;
                break;
            }
            int[] iArrK2 = k(cnVar, i4, i7, i2, iArr2, iArr3);
            if (iArrK2 != null) {
                int[] iArr4 = iArrK2;
                while (true) {
                    i6 = i7;
                    if (i6 <= 0 || (iArrK = k(cnVar, i4, i6 - 1, i2, iArr, iArr3)) == null) {
                        break;
                    }
                    iArr4 = iArrK;
                }
                float f2 = i6;
                xk3VarArr[0] = new xk3(iArr4[0], f2);
                xk3VarArr[1] = new xk3(iArr4[1], f2);
                z2 = true;
            } else {
                i7 += 5;
                iArr2 = iArr;
            }
        }
        int i8 = i6 + 1;
        if (z2) {
            int[] iArr5 = {(int) xk3VarArr[0].a, (int) xk3VarArr[1].a};
            int i9 = i8;
            int i10 = 0;
            while (i9 < i) {
                int[] iArrK3 = k(cnVar, iArr5[0], i9, i2, iArr, iArr3);
                if (iArrK3 != null && Math.abs(iArr5[0] - iArrK3[0]) < 5 && Math.abs(iArr5[1] - iArrK3[1]) < 5) {
                    iArr5 = iArrK3;
                    i10 = 0;
                } else {
                    if (i10 > 25) {
                        break;
                    }
                    i10++;
                }
                i9++;
            }
            i8 = i9 - (i10 + 1);
            float f3 = i8;
            xk3VarArr[2] = new xk3(iArr5[0], f3);
            xk3VarArr[3] = new xk3(iArr5[1], f3);
        }
        if (i8 - i6 < i5) {
            Arrays.fill(xk3VarArr, (Object) null);
        }
        return xk3VarArr;
    }

    public static final File n(Context context) {
        try {
            File file = new File(context.getExternalCacheDir(), "hprof");
            file.mkdirs();
            return file;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String o(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) "|");
            }
        }
        return sb.toString();
    }

    public static final String r() {
        TelephonyManager telephonyManager = (TelephonyManager) ContextUtilsKt.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperator();
        }
        return null;
    }

    public static final e03 s() {
        Integer numM0;
        String strR = r();
        int iIntValue = (strR == null || (numM0 = w44.m0(strR)) == null) ? 0 : numM0.intValue();
        return new e03(Integer.valueOf(iIntValue / 100), Integer.valueOf(iIntValue % 100));
    }

    public static final Object t(rn2 rn2Var, u33 u33Var, Serializable serializable) {
        rn2Var.getClass();
        u33Var.getClass();
        Object objCopyOf = rn2Var.a.get(u33Var);
        if (objCopyOf instanceof byte[]) {
            byte[] bArr = (byte[]) objCopyOf;
            objCopyOf = Arrays.copyOf(bArr, bArr.length);
        }
        return objCopyOf == null ? serializable : objCopyOf;
    }

    public static ArrayList v(rw rwVar, b00 b00Var, ArrayList arrayList) throws c02 {
        String strF;
        try {
            ArrayList arrayList2 = new ArrayList();
            if (b00Var == null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add((String) it.next());
                }
            } else {
                try {
                    strF = f(rwVar.e, b00Var.b(), arrayList);
                } catch (IllegalStateException unused) {
                    strF = null;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (!str.equals(strF)) {
                        arrayList3.add(rwVar.d(str));
                    }
                }
                Iterator it3 = b00Var.a(arrayList3).iterator();
                while (it3.hasNext()) {
                    arrayList2.add(((kz) it3.next()).d());
                }
            }
            return arrayList2;
        } catch (e00 e) {
            throw new c02(e);
        } catch (xx e2) {
            throw new c02(new e00(e2));
        }
    }

    public void A(go3 go3Var, Object obj) {
        if (obj == null) {
            return;
        }
        io3 io3VarD0 = go3Var.D0(e());
        try {
            b(io3VarD0, obj);
            io3VarD0.C0();
            vf2.e(io3VarD0, null);
            r25.C(go3Var);
        } finally {
        }
    }

    public abstract void b(io3 io3Var, Object obj);

    public abstract String e();

    public abstract Annotation m(Class cls);

    public abstract int p();

    public abstract String q();

    public abstract Class u();

    public abstract int w(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract nj4 x();

    public abstract int y();

    public abstract ViewPropertyAnimator z(View view, int i);
}
