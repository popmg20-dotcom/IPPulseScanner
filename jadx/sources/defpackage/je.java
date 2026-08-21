package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.dns.AbstractDnsMessage;
import io.netty.handler.codec.dns.AbstractDnsRecord;
import io.netty.handler.codec.dns.DefaultDnsOptEcsRecord;
import io.netty.handler.codec.dns.DefaultDnsPtrRecord;
import io.netty.handler.codec.dns.DefaultDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DefaultDnsResponse;
import io.netty.handler.codec.dns.DnsOpCode;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordDecoder;
import io.netty.handler.codec.dns.DnsRecordEncoder;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.sentry.android.core.a1;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class je implements b1 {
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final e1 f = new e1(11);
    public static final char[] z = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    public static final char[] A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final String[] X = {"ga_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "ga_error", "ga_error_value", "ga_error_length", "ga_event_origin", "ga_screen", "ga_screen_class", "ga_screen_id", "ga_previous_screen", "ga_previous_class", "ga_previous_id", "manual_tracking", "message_device_time", "message_id", "message_name", "message_time", "message_tracking_id", "message_type", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "cached_campaign", "deferred_analytics_collection", "ga_session_number", "ga_session_id", "campaign_extra_referrer", "app_in_background", "firebase_feature_rollouts", "customer_type", "firebase_conversion", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "session_number", "session_id"};
    public static final String[] Y = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_mst", "_ndt", "_nmid", "_nmn", "_nmt", "_nmtid", "_nmc", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_cc", "_dac", "_sno", "_sid", "_cer", "_aib", "_ffr", "_ct", "_c", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_sno", "_sid"};
    public static final String[] Z = {"items"};
    public static final String[] y0 = {"affiliation", "coupon", "creative_name", "creative_slot", "currency", "_ct", "discount", "index", "item_id", "item_brand", "item_category", "item_category2", "item_category3", "item_category4", "item_category5", "item_list_name", "item_list_id", "item_name", "item_variant", "location_id", "payment_type", "price", "promotion_id", "promotion_name", "quantity", "shipping", "shipping_tier", "tax", "transaction_id", "value", "item_list", "checkout_step", "checkout_option", "item_location_id"};

    public static final void A(cf0 cf0Var) {
        v32 v32Var = (v32) cf0Var.Z(pr1.X);
        if (v32Var != null && !v32Var.isActive()) {
            throw v32Var.F();
        }
    }

    public static void B(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 26);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new uo3(sb.toString(), parcel);
    }

    public static final Network C(ConnectivityManager connectivityManager) {
        String str;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        Network[] allNetworks = connectivityManager.getAllNetworks();
        allNetworks.getClass();
        for (Network network : allNetworks) {
            try {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                if (l72.N(networkInfo, activeNetworkInfo)) {
                    String str2 = "getActiveNetwork return " + networkInfo;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "DnsUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                        str = str2;
                    } else {
                        str = str2;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("DnsUtils", str, null);
                    }
                    return network;
                }
                continue;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "DnsUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "getActiveNetwork return null");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("DnsUtils", "getActiveNetwork return null", null);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final byte[] D(AbstractDnsMessage abstractDnsMessage) {
        ByteBuf byteBufBuffer = Unpooled.buffer(1024);
        if (abstractDnsMessage instanceof DnsQuery) {
            DnsQuery dnsQuery = (DnsQuery) abstractDnsMessage;
            byteBufBuffer.getClass();
            byteBufBuffer.writeShort(dnsQuery.id());
            int iByteValue = (dnsQuery.opCode().byteValue() & 255) << 14;
            if (dnsQuery.isRecursionDesired()) {
                iByteValue |= 256;
            }
            byteBufBuffer.writeShort(iByteValue);
            byteBufBuffer.writeShort(dnsQuery.count(DnsSection.QUESTION));
            byteBufBuffer.writeShort(0);
            byteBufBuffer.writeShort(0);
            byteBufBuffer.writeShort(dnsQuery.count(DnsSection.ADDITIONAL));
        } else if (abstractDnsMessage instanceof DnsResponse) {
            DnsResponse dnsResponse = (DnsResponse) abstractDnsMessage;
            byteBufBuffer.getClass();
            byteBufBuffer.writeShort(dnsResponse.id());
            int iByteValue2 = (dnsResponse.opCode().byteValue() & 255) << 11;
            int i = 32768 | iByteValue2;
            if (dnsResponse.isAuthoritativeAnswer()) {
                i = 33792 | iByteValue2;
            }
            if (dnsResponse.isTruncated()) {
                i |= 512;
            }
            if (dnsResponse.isRecursionAvailable()) {
                i |= 128;
            }
            int iIntValue = dnsResponse.code().intValue() | i;
            if (dnsResponse.isRecursionDesired()) {
                iIntValue |= 256;
            }
            byteBufBuffer.writeShort(iIntValue | (dnsResponse.z() << 4));
            byteBufBuffer.writeShort(dnsResponse.count(DnsSection.QUESTION));
            byteBufBuffer.writeShort(dnsResponse.count(DnsSection.ANSWER));
            byteBufBuffer.writeShort(dnsResponse.count(DnsSection.AUTHORITY));
            byteBufBuffer.writeShort(dnsResponse.count(DnsSection.ADDITIONAL));
        }
        byteBufBuffer.getClass();
        int iCount = abstractDnsMessage.count(DnsSection.QUESTION);
        for (int i2 = 0; i2 < iCount; i2++) {
            DnsRecordEncoder.DEFAULT.encodeQuestion((DnsQuestion) abstractDnsMessage.recordAt(DnsSection.QUESTION, i2), byteBufBuffer);
        }
        if (abstractDnsMessage instanceof DnsResponse) {
            z(abstractDnsMessage, DnsSection.ANSWER, byteBufBuffer);
            z(abstractDnsMessage, DnsSection.AUTHORITY, byteBufBuffer);
        }
        z(abstractDnsMessage, DnsSection.ADDITIONAL, byteBufBuffer);
        byte[] bArr = new byte[byteBufBuffer.readableBytes()];
        byteBufBuffer.getBytes(byteBufBuffer.readerIndex(), bArr);
        return bArr;
    }

    public static final ArrayList E(DefaultDnsResponse defaultDnsResponse) {
        ArrayList arrayList = new ArrayList();
        int iCount = defaultDnsResponse.count(DnsSection.ANSWER);
        for (int i = 0; i < iCount; i++) {
            DnsRecord dnsRecordRecordAt = defaultDnsResponse.recordAt(DnsSection.ANSWER, i);
            if (dnsRecordRecordAt instanceof DnsRawRecord) {
                DnsRawRecord dnsRawRecord = (DnsRawRecord) dnsRecordRecordAt;
                if (n12.c(dnsRawRecord.type(), DnsRecordType.A) || n12.c(dnsRawRecord.type(), DnsRecordType.AAAA)) {
                    ByteBuf byteBufContent = dnsRawRecord.content();
                    byte[] bArr = new byte[byteBufContent.readableBytes()];
                    byteBufContent.getBytes(byteBufContent.readerIndex(), bArr);
                    arrayList.add(InetAddress.getByAddress(bArr));
                }
            }
        }
        return arrayList;
    }

    public static g91 F(Context context) {
        h91 h91Var = h91.f;
        if (h91.f == null) {
            ReentrantLock reentrantLock = h91.g;
            reentrantLock.lock();
            try {
                if (h91.f == null) {
                    Context applicationContext = context.getApplicationContext();
                    applicationContext.getClass();
                    h91.f = new h91(applicationContext, vf2.u(applicationContext));
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        h91 h91Var2 = h91.f;
        h91Var2.getClass();
        return new g91(h91Var2);
    }

    public static final v32 G(cf0 cf0Var) {
        v32 v32Var = (v32) cf0Var.Z(pr1.X);
        if (v32Var != null) {
            return v32Var;
        }
        ad0.o(cf0Var, "Current context doesn't contain Job in it: ");
        return null;
    }

    public static final boolean I() {
        Object systemService = ContextUtilsKt.getContext().getSystemService("camera");
        systemService.getClass();
        CameraManager cameraManager = (CameraManager) systemService;
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            cameraIdList.getClass();
            for (String str : cameraIdList) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() == 1) {
                    return true;
                }
            }
            return false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        } catch (AssertionError e2) {
            e2.printStackTrace();
            return false;
        } catch (RuntimeException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static final zv0 K(v32 v32Var, boolean z2, y32 y32Var) {
        if (v32Var instanceof e42) {
            return ((e42) v32Var).O(z2, y32Var);
        }
        return v32Var.x(y32Var.l(), z2, new x12(1, y32Var, y32.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 2));
    }

    public static boolean L(int i) {
        return (i & 4096) != 0;
    }

    public static boolean M(int i) {
        return (i & 1) != 0;
    }

    public static boolean N(int i) {
        return (i & 4) != 0;
    }

    public static boolean O(int i) {
        return (i & 1024) != 0;
    }

    public static boolean P(byte b2) {
        return b2 > -65;
    }

    public static DataInputStream Q(String str) {
        String strO = ha0.o("/tables/", str, ".bin");
        InputStream resourceAsStream = je.class.getResourceAsStream(strO);
        if (resourceAsStream != null) {
            return new DataInputStream(new BufferedInputStream(resourceAsStream));
        }
        throw new r41(ha0.o("entry: ", strO, " not found"));
    }

    public static final DefaultDnsQuery R(byte[] bArr) {
        DefaultDnsQuery defaultDnsQuery;
        ByteBuf byteBufWrappedBuffer;
        int unsignedShort;
        int unsignedShort2;
        int i;
        boolean z2;
        String str;
        try {
            byteBufWrappedBuffer = Unpooled.wrappedBuffer(bArr);
            unsignedShort = byteBufWrappedBuffer.readUnsignedShort();
            unsignedShort2 = byteBufWrappedBuffer.readUnsignedShort();
            i = unsignedShort2 >> 15;
            z2 = true;
        } catch (Exception e) {
            e = e;
            defaultDnsQuery = null;
        }
        if (i == 1) {
            String str2 = "not a query " + i;
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "DnsUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                str = str2;
            } else {
                str = str2;
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("DnsUtils", str, null);
                return null;
            }
            return null;
        }
        defaultDnsQuery = new DefaultDnsQuery(unsignedShort, DnsOpCode.valueOf((unsignedShort2 >> 11) & 15));
        if (((unsignedShort2 >> 8) & 1) != 1) {
            z2 = false;
        }
        defaultDnsQuery.setRecursionDesired(z2);
        defaultDnsQuery.setZ((unsignedShort2 >> 4) & 7);
        try {
            int unsignedShort3 = byteBufWrappedBuffer.readUnsignedShort();
            int unsignedShort4 = byteBufWrappedBuffer.readUnsignedShort();
            int unsignedShort5 = byteBufWrappedBuffer.readUnsignedShort();
            for (int unsignedShort6 = byteBufWrappedBuffer.readUnsignedShort(); unsignedShort6 > 0; unsignedShort6--) {
                defaultDnsQuery.addRecord(DnsSection.QUESTION, (DnsRecord) DnsRecordDecoder.DEFAULT.decodeQuestion(byteBufWrappedBuffer));
            }
            y(defaultDnsQuery, DnsSection.ANSWER, byteBufWrappedBuffer, unsignedShort3);
            y(defaultDnsQuery, DnsSection.AUTHORITY, byteBufWrappedBuffer, unsignedShort4);
            y(defaultDnsQuery, DnsSection.ADDITIONAL, byteBufWrappedBuffer, unsignedShort5);
            return defaultDnsQuery;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (defaultDnsQuery != null) {
                defaultDnsQuery.release();
            }
            return null;
        }
    }

    public static final DefaultDnsResponse S(byte[] bArr) {
        DefaultDnsResponse defaultDnsResponse;
        ByteBuf byteBufWrappedBuffer;
        int unsignedShort;
        int unsignedShort2;
        int i;
        String str;
        bArr.getClass();
        try {
            byteBufWrappedBuffer = Unpooled.wrappedBuffer(bArr);
            unsignedShort = byteBufWrappedBuffer.readUnsignedShort();
            unsignedShort2 = byteBufWrappedBuffer.readUnsignedShort();
            i = unsignedShort2 >> 15;
        } catch (Exception e) {
            e = e;
            defaultDnsResponse = null;
        }
        if (i == 0) {
            String str2 = "not a response " + i;
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "DnsUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
                str = str2;
            } else {
                str = str2;
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("DnsUtils", str, null);
                return null;
            }
            return null;
        }
        defaultDnsResponse = new DefaultDnsResponse(unsignedShort, DnsOpCode.valueOf((unsignedShort2 >> 11) & 15), DnsResponseCode.valueOf(unsignedShort2 & 15));
        boolean z2 = true;
        defaultDnsResponse.setRecursionDesired(((unsignedShort2 >> 8) & 1) == 1);
        defaultDnsResponse.setAuthoritativeAnswer(((unsignedShort2 >> 10) & 1) == 1);
        defaultDnsResponse.setTruncated(((unsignedShort2 >> 9) & 1) == 1);
        if (((unsignedShort2 >> 7) & 1) != 1) {
            z2 = false;
        }
        defaultDnsResponse.setRecursionAvailable(z2);
        defaultDnsResponse.setZ((unsignedShort2 >> 4) & 7);
        try {
            int unsignedShort3 = byteBufWrappedBuffer.readUnsignedShort();
            int unsignedShort4 = byteBufWrappedBuffer.readUnsignedShort();
            int unsignedShort5 = byteBufWrappedBuffer.readUnsignedShort();
            for (int unsignedShort6 = byteBufWrappedBuffer.readUnsignedShort(); unsignedShort6 > 0; unsignedShort6--) {
                defaultDnsResponse.addRecord(DnsSection.QUESTION, (DnsRecord) DnsRecordDecoder.DEFAULT.decodeQuestion(byteBufWrappedBuffer));
            }
            y(defaultDnsResponse, DnsSection.ANSWER, byteBufWrappedBuffer, unsignedShort3);
            y(defaultDnsResponse, DnsSection.AUTHORITY, byteBufWrappedBuffer, unsignedShort4);
            y(defaultDnsResponse, DnsSection.ADDITIONAL, byteBufWrappedBuffer, unsignedShort5);
            return defaultDnsResponse;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (defaultDnsResponse != null) {
                defaultDnsResponse.release();
            }
            return null;
        }
    }

    public static AbstractMap.SimpleImmutableEntry T(m60 m60Var, o91 o91Var, cm2 cm2Var) {
        Object objU = cm2Var.z;
        Object objU2 = cm2Var.X;
        while (true) {
            int iS = m60Var.s();
            if (iS == 0) {
                break;
            }
            aw4 aw4Var = (aw4) cm2Var.f;
            if (iS == (aw4Var.f | 8)) {
                objU = U(m60Var, o91Var, aw4Var, objU);
            } else {
                aw4 aw4Var2 = (aw4) cm2Var.A;
                if (iS == (aw4Var2.f | 16)) {
                    objU2 = U(m60Var, o91Var, aw4Var2, objU2);
                } else if (!m60Var.u(iS)) {
                    break;
                }
            }
        }
        return new AbstractMap.SimpleImmutableEntry(objU, objU2);
    }

    public static Object U(m60 m60Var, o91 o91Var, aw4 aw4Var, Object obj) {
        int iOrdinal = aw4Var.ordinal();
        if (iOrdinal == 9) {
            zo2.w("Groups are not allowed in maps.");
            return null;
        }
        if (iOrdinal == 10) {
            ml2 ml2VarE = ((nl2) obj).u();
            m60Var.k(ml2VarE, o91Var);
            return ml2VarE.q();
        }
        if (iOrdinal == 13) {
            return Integer.valueOf(m60Var.o());
        }
        kd1 kd1Var = kd1.d;
        return m60Var.l(aw4Var, 2);
    }

    public static boolean V(Parcel parcel, int i) {
        j0(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static IBinder W(Parcel parcel, int i) {
        int iZ = Z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iZ);
        return strongBinder;
    }

    public static int X(Parcel parcel, int i) {
        j0(parcel, i, 4);
        return parcel.readInt();
    }

    public static long Y(Parcel parcel, int i) {
        j0(parcel, i, 8);
        return parcel.readLong();
    }

    public static int Z(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static final hg0 a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return new hg0(new float[]{f2, f3, f4, f5, f6, f7, f8, f9});
    }

    public static void a0(StringBuilder sb, ld4 ld4Var, String str) {
        ArrayList arrayList;
        Iterator it;
        sb.append("tid: " + ld4Var.X);
        if (ld4Var.H().length() > 0) {
            sb.append(", name: ".concat(ld4Var.H()));
        }
        if (str != null) {
            sb.append("  (" + str + ")");
        }
        sb.append('\n');
        int i = 0;
        if (ld4Var.Z.size() > 0) {
            List list = ld4Var.Z;
            list.getClass();
            int i2 = 4;
            if (list instanceof RandomAccess) {
                int size = list.size();
                arrayList = new ArrayList((size / 4) + (size % 4 == 0 ? 0 : 1));
                for (int i3 = 0; i3 >= 0 && i3 < size; i3 += 4) {
                    int i4 = size - i3;
                    if (4 <= i4) {
                        i4 = 4;
                    }
                    ArrayList arrayList2 = new ArrayList(i4);
                    for (int i5 = 0; i5 < i4; i5++) {
                        arrayList2.add(list.get(i5 + i3));
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                it2.getClass();
                if (it2.hasNext()) {
                    ts3 ts3Var = new ts3();
                    iy3 iy3Var = new iy3(it2, ts3Var);
                    iy3Var.Z = ts3Var;
                    ts3Var.A = iy3Var;
                    it = ts3Var;
                } else {
                    it = d41.b;
                }
                while (it.hasNext()) {
                    arrayList.add((List) it.next());
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                sb.append("    ".concat(d70.j0((List) it3.next(), "    ", null, null, new q74(i2), 30)));
                sb.append('\n');
            }
        }
        g92 g92Var = ld4Var.y0;
        g92Var.getClass();
        Iterator it4 = g92Var.iterator();
        while (it4.hasNext()) {
            sb.append("    NOTE: " + ((String) it4.next()));
            sb.append('\n');
        }
        sb.append("backtrace:");
        sb.append('\n');
        List list2 = ld4Var.A0;
        list2.getClass();
        for (Object obj : list2) {
            int i6 = i + 1;
            if (i < 0) {
                e70.P();
                throw null;
            }
            hi hiVar = (hi) obj;
            String strD0 = p44.D0(String.valueOf(i), 2, '0');
            long j = hiVar.Y;
            yr2.g(16);
            String string = Long.toString(j, 16);
            string.getClass();
            sb.append("    #" + strD0 + " pc " + p44.D0(string, 8, '0'));
            if (hiVar.J().length() > 0) {
                sb.append("  ".concat(hiVar.J()));
            }
            if (hiVar.K().length() > 0) {
                sb.append(" (" + hiVar.K() + "+" + hiVar.z0 + ")");
            }
            sb.append('\n');
            i = i6;
        }
        sb.append('\n');
    }

    public static x32 b() {
        return new x32(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.netty.handler.codec.dns.DefaultDnsResponse b0(io.netty.handler.codec.dns.DefaultDnsResponse r18, java.lang.String r19, java.net.InetAddress r20) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.b0(io.netty.handler.codec.dns.DefaultDnsResponse, java.lang.String, java.net.InetAddress):io.netty.handler.codec.dns.DefaultDnsResponse");
    }

    public static final DefaultDnsResponse c0(DefaultDnsResponse defaultDnsResponse, String str, String str2) {
        DefaultDnsResponse defaultDnsResponse2 = new DefaultDnsResponse(defaultDnsResponse.id(), defaultDnsResponse.opCode(), DnsResponseCode.NOERROR);
        defaultDnsResponse2.setRecursionDesired(defaultDnsResponse.isRecursionDesired());
        defaultDnsResponse2.setRecursionAvailable(defaultDnsResponse.isRecursionDesired());
        defaultDnsResponse2.setZ(defaultDnsResponse.z());
        defaultDnsResponse2.setTruncated(false);
        defaultDnsResponse2.setAuthoritativeAnswer(false);
        int iCount = defaultDnsResponse.count(DnsSection.QUESTION);
        for (int i = 0; i < iCount; i++) {
            DnsSection dnsSection = DnsSection.QUESTION;
            DnsRecord dnsRecordRecordAt = defaultDnsResponse.recordAt(dnsSection, i);
            String strName = dnsRecordRecordAt.name();
            strName.getClass();
            defaultDnsResponse2.addRecord(dnsSection, (DnsRecord) (p44.G0(".", strName).equals(str) ? d0(dnsRecordRecordAt, str2) : r(dnsRecordRecordAt)));
        }
        int iCount2 = defaultDnsResponse.count(DnsSection.ANSWER);
        for (int i2 = 0; i2 < iCount2; i2++) {
            DnsSection dnsSection2 = DnsSection.ANSWER;
            DnsRecord dnsRecordRecordAt2 = defaultDnsResponse.recordAt(dnsSection2, i2);
            String strName2 = dnsRecordRecordAt2.name();
            strName2.getClass();
            defaultDnsResponse2.addRecord(dnsSection2, (DnsRecord) (p44.G0(".", strName2).equals(str) ? d0(dnsRecordRecordAt2, str2) : r(dnsRecordRecordAt2)));
        }
        int iCount3 = defaultDnsResponse.count(DnsSection.AUTHORITY);
        for (int i3 = 0; i3 < iCount3; i3++) {
            DnsSection dnsSection3 = DnsSection.AUTHORITY;
            DnsRecord dnsRecordRecordAt3 = defaultDnsResponse.recordAt(dnsSection3, i3);
            String strName3 = dnsRecordRecordAt3.name();
            strName3.getClass();
            defaultDnsResponse2.addRecord(dnsSection3, (DnsRecord) (p44.G0(".", strName3).equals(str) ? d0(dnsRecordRecordAt3, str2) : r(dnsRecordRecordAt3)));
        }
        int iCount4 = defaultDnsResponse.count(DnsSection.ADDITIONAL);
        for (int i4 = 0; i4 < iCount4; i4++) {
            DnsSection dnsSection4 = DnsSection.ADDITIONAL;
            DnsRecord dnsRecordRecordAt4 = defaultDnsResponse.recordAt(dnsSection4, i4);
            String strName4 = dnsRecordRecordAt4.name();
            strName4.getClass();
            defaultDnsResponse2.addRecord(dnsSection4, (DnsRecord) (p44.G0(".", strName4).equals(str) ? d0(dnsRecordRecordAt4, str2) : r(dnsRecordRecordAt4)));
        }
        return defaultDnsResponse2;
    }

    public static final AbstractDnsRecord d0(DnsRecord dnsRecord, String str) {
        if (dnsRecord instanceof DefaultDnsQuestion) {
            DefaultDnsQuestion defaultDnsQuestion = (DefaultDnsQuestion) dnsRecord;
            return new DefaultDnsQuestion(str, defaultDnsQuestion.type(), defaultDnsQuestion.dnsClass());
        }
        if (dnsRecord instanceof DefaultDnsPtrRecord) {
            DefaultDnsPtrRecord defaultDnsPtrRecord = (DefaultDnsPtrRecord) dnsRecord;
            return new DefaultDnsPtrRecord(str, defaultDnsPtrRecord.dnsClass(), defaultDnsPtrRecord.timeToLive(), defaultDnsPtrRecord.hostname());
        }
        if (!(dnsRecord instanceof DefaultDnsRawRecord)) {
            return r(dnsRecord);
        }
        DefaultDnsRawRecord defaultDnsRawRecord = (DefaultDnsRawRecord) dnsRecord;
        return new DefaultDnsRawRecord(str, defaultDnsRawRecord.type(), defaultDnsRawRecord.dnsClass(), defaultDnsRawRecord.timeToLive(), Unpooled.copiedBuffer(defaultDnsRawRecord.content()));
    }

    public static final boolean e0(as4 as4Var, as4 as4Var2, hd2 hd2Var) {
        as4Var.getClass();
        if (as4Var2 == null) {
            return true;
        }
        if ((as4Var2 instanceof zr4) && (as4Var instanceof yr4)) {
            return true;
        }
        if ((as4Var instanceof zr4) && (as4Var2 instanceof yr4)) {
            return false;
        }
        return (as4Var.c == as4Var2.c && as4Var.d == as4Var2.d && as4Var2.a(hd2Var) <= as4Var.a(hd2Var)) ? false : true;
    }

    public static final String f(CharSequence charSequence) {
        if (charSequence == null) {
            return " ";
        }
        String str = charSequence instanceof String ? (String) charSequence : null;
        return str == null ? charSequence.toString() : str;
    }

    public static void f0(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + Z(parcel, i));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(defpackage.q53 r4, defpackage.pl1 r5, defpackage.ie0 r6) {
        /*
            boolean r0 = r6 instanceof defpackage.o53
            if (r0 == 0) goto L13
            r0 = r6
            o53 r0 = (defpackage.o53) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            o53 r0 = new o53
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.X
            int r1 = r0.Y
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 != r3) goto L2a
            pl1 r5 = r0.A
            defpackage.n12.S(r6)     // Catch: java.lang.Throwable -> L28
            goto L62
        L28:
            r4 = move-exception
            goto L68
        L2a:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r2
        L30:
            defpackage.n12.S(r6)
            cf0 r6 = r0.f
            r6.getClass()
            pr1 r1 = defpackage.pr1.X
            af0 r6 = r6.Z(r1)
            if (r6 != r4) goto L6c
            r0.A = r5     // Catch: java.lang.Throwable -> L28
            r0.Y = r3     // Catch: java.lang.Throwable -> L28
            z00 r6 = new z00     // Catch: java.lang.Throwable -> L28
            ge0 r0 = defpackage.p95.u(r0)     // Catch: java.lang.Throwable -> L28
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L28
            r6.w()     // Catch: java.lang.Throwable -> L28
            p53 r0 = new p53     // Catch: java.lang.Throwable -> L28
            r1 = 0
            r0.<init>(r1, r6)     // Catch: java.lang.Throwable -> L28
            r4.m0(r0)     // Catch: java.lang.Throwable -> L28
            java.lang.Object r4 = r6.u()     // Catch: java.lang.Throwable -> L28
            mf0 r6 = defpackage.mf0.b
            if (r4 != r6) goto L62
            return r6
        L62:
            r5.a()
            xl4 r4 = defpackage.xl4.a
            return r4
        L68:
            r5.a()
            throw r4
        L6c:
            java.lang.String r4 = "awaitClose() can only be invoked from the producer context"
            defpackage.xe.q(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.g(q53, pl1, ie0):java.lang.Object");
    }

    public static void g0(ArrayList arrayList, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            j60 j60Var = (j60) it.next();
            int i3 = j60Var.a;
            if (i3 >= i) {
                i3 += i2;
                j60Var.a = i3;
            }
            int i4 = j60Var.c;
            if (i4 >= i) {
                i4 += i2;
                j60Var.c = i4;
            }
            if (i3 >= i4) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h0(android.view.View r5, int r6, int r7) {
        /*
            r0 = r7 & 1
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L17
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            boolean r3 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r3 == 0) goto L11
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            goto L12
        L11:
            r0 = r2
        L12:
            if (r0 == 0) goto L17
            int r0 = r0.topMargin
            goto L18
        L17:
            r0 = r1
        L18:
            r3 = r7 & 2
            if (r3 == 0) goto L2c
            android.view.ViewGroup$LayoutParams r3 = r5.getLayoutParams()
            boolean r4 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r4 == 0) goto L27
            r2 = r3
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
        L27:
            if (r2 == 0) goto L2c
            int r2 = r2.bottomMargin
            goto L2d
        L2c:
            r2 = r1
        L2d:
            r3 = r7 & 4
            if (r3 == 0) goto L41
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            boolean r3 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r3 == 0) goto L40
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = r6.getMarginStart()
            goto L41
        L40:
            r6 = r1
        L41:
            r7 = r7 & 8
            if (r7 == 0) goto L53
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            boolean r3 = r7 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r3 == 0) goto L53
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
            int r1 = r7.getMarginEnd()
        L53:
            android.view.ViewGroup$LayoutParams r7 = r5.getLayoutParams()
            if (r7 == 0) goto L69
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
            r7.topMargin = r0
            r7.bottomMargin = r2
            r7.setMarginStart(r6)
            r7.setMarginEnd(r1)
            r5.setLayoutParams(r7)
            return
        L69:
            java.lang.String r5 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            defpackage.zo2.n(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.h0(android.view.View, int, int):void");
    }

    public static int i0(Parcel parcel) {
        int i = parcel.readInt();
        int iZ = Z(parcel, i);
        char c = (char) i;
        int iDataPosition = parcel.dataPosition();
        if (c != 20293) {
            throw new uo3("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i2 = iZ + iDataPosition;
        if (i2 >= iDataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iDataPosition).length() + 32 + String.valueOf(i2).length());
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new uo3(sb.toString(), parcel);
    }

    public static void j0(Parcel parcel, int i, int i2) {
        int iZ = Z(parcel, i);
        if (iZ == i2) {
            return;
        }
        String hexString = Integer.toHexString(iZ);
        int length = String.valueOf(i2).length();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(iZ).length() + 4 + 1);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(iZ);
        throw new uo3(fw.z(sb, " (0x", hexString, ")"), parcel);
    }

    public static void k0(String str, int i, List list) {
        if (list.size() == i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i + " parameters found " + list.size());
    }

    public static final DefaultDnsResponse l(DefaultDnsQuery defaultDnsQuery, DnsResponseCode dnsResponseCode) {
        DefaultDnsResponse defaultDnsResponse = new DefaultDnsResponse(defaultDnsQuery.id(), defaultDnsQuery.opCode(), dnsResponseCode);
        defaultDnsResponse.setRecursionDesired(defaultDnsQuery.isRecursionDesired());
        defaultDnsResponse.setRecursionAvailable(defaultDnsQuery.isRecursionDesired());
        defaultDnsResponse.setZ(defaultDnsQuery.z());
        defaultDnsResponse.setTruncated(false);
        defaultDnsResponse.setAuthoritativeAnswer(false);
        int iCount = defaultDnsQuery.count(DnsSection.QUESTION);
        for (int i = 0; i < iCount; i++) {
            DnsSection dnsSection = DnsSection.QUESTION;
            DnsRecord dnsRecordRecordAt = defaultDnsQuery.recordAt(dnsSection, i);
            dnsRecordRecordAt.getClass();
            defaultDnsResponse.addRecord(dnsSection, (DnsRecord) r(dnsRecordRecordAt));
        }
        int iCount2 = defaultDnsQuery.count(DnsSection.AUTHORITY);
        for (int i2 = 0; i2 < iCount2; i2++) {
            DnsSection dnsSection2 = DnsSection.AUTHORITY;
            DnsRecord dnsRecordRecordAt2 = defaultDnsQuery.recordAt(dnsSection2, i2);
            dnsRecordRecordAt2.getClass();
            defaultDnsResponse.addRecord(dnsSection2, (DnsRecord) r(dnsRecordRecordAt2));
        }
        int iCount3 = defaultDnsQuery.count(DnsSection.ADDITIONAL);
        for (int i3 = 0; i3 < iCount3; i3++) {
            DnsSection dnsSection3 = DnsSection.ADDITIONAL;
            DnsRecord dnsRecordRecordAt3 = defaultDnsQuery.recordAt(dnsSection3, i3);
            dnsRecordRecordAt3.getClass();
            defaultDnsResponse.addRecord(dnsSection3, (DnsRecord) r(dnsRecordRecordAt3));
        }
        return defaultDnsResponse;
    }

    public static void l0(Parcel parcel, int i, int i2) {
        if (i == i2) {
            return;
        }
        String hexString = Integer.toHexString(i);
        int length = String.valueOf(i2).length();
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + length + 19 + String.valueOf(i).length() + 4 + 1);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(i);
        throw new uo3(fw.z(sb, " (0x", hexString, ")"), parcel);
    }

    public static final byte[] m(DefaultDnsQuery defaultDnsQuery, DnsRecord dnsRecord, e03... e03VarArr) {
        DefaultDnsResponse defaultDnsResponse = new DefaultDnsResponse(defaultDnsQuery.id(), defaultDnsQuery.opCode(), DnsResponseCode.NOERROR);
        try {
            defaultDnsResponse.setRecursionDesired(defaultDnsQuery.isRecursionDesired());
            defaultDnsResponse.setRecursionAvailable(defaultDnsQuery.isRecursionDesired());
            defaultDnsResponse.setZ(defaultDnsQuery.z());
            defaultDnsResponse.setTruncated(false);
            defaultDnsResponse.setAuthoritativeAnswer(false);
            defaultDnsResponse.addRecord(DnsSection.QUESTION, dnsRecord);
            for (e03 e03Var : e03VarArr) {
                defaultDnsResponse.addRecord(DnsSection.ANSWER, (DnsRecord) new DefaultDnsRawRecord(dnsRecord.name(), dnsRecord.type(), dnsRecord.dnsClass(), ((Number) e03Var.f).longValue(), Unpooled.copiedBuffer(((InetAddress) e03Var.b).getAddress())));
            }
            byte[] bArrD = D(defaultDnsResponse);
            defaultDnsResponse.release();
            return bArrD;
        } finally {
        }
    }

    public static void m0(String str, int i, List list) {
        if (list.size() >= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i + " parameters found " + list.size());
    }

    public static ju0 n(ez4 ez4Var) {
        int i;
        mu0 mu0Var;
        int i2;
        lu0 lu0Var;
        int i3;
        int i4;
        mu0 mu0Var2;
        mu0 mu0Var3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iA = ez4Var.A();
        int iZ = ez4Var.z();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        lu0 lu0Var2 = new lu0();
        int i14 = 0;
        lu0Var2.a = 0;
        lu0Var2.b = iA;
        lu0Var2.c = 0;
        lu0Var2.d = iZ;
        arrayList2.add(lu0Var2);
        int i15 = iA + iZ;
        int i16 = 1;
        int i17 = (((i15 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i17];
        int i18 = i17 / 2;
        int[] iArr2 = new int[i17];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            lu0 lu0Var3 = (lu0) arrayList2.remove(arrayList2.size() - i16);
            if (lu0Var3.b() < i16 || lu0Var3.a() < i16) {
                i = i18;
                mu0Var = null;
            } else {
                int iA2 = ((lu0Var3.a() + lu0Var3.b()) + i16) / 2;
                int i19 = i16 + i18;
                iArr[i19] = lu0Var3.a;
                iArr2[i19] = lu0Var3.b;
                int i20 = i14;
                while (i20 < iA2) {
                    int i21 = Math.abs(lu0Var3.b() - lu0Var3.a()) % 2 == i16 ? i16 : i14;
                    int iB = lu0Var3.b() - lu0Var3.a();
                    int i22 = -i20;
                    int i23 = i22;
                    while (true) {
                        if (i23 > i20) {
                            i3 = i14;
                            i = i18;
                            i4 = iA2;
                            mu0Var2 = null;
                            break;
                        }
                        if (i23 == i22 || (i23 != i20 && iArr[i23 + 1 + i18] > iArr[(i23 - 1) + i18])) {
                            i9 = iArr[i23 + 1 + i18];
                            i10 = i9;
                        } else {
                            i9 = iArr[(i23 - 1) + i18];
                            i10 = i9 + 1;
                        }
                        i = i18;
                        int i24 = ((i10 - lu0Var3.a) + lu0Var3.c) - i23;
                        if (i20 == 0 || i10 != i9) {
                            i11 = i10;
                            i12 = i24;
                        } else {
                            i11 = i10;
                            i12 = i24 - 1;
                        }
                        int i25 = i23;
                        int i26 = i24;
                        int i27 = i11;
                        i4 = iA2;
                        while (i27 < lu0Var3.b && i26 < lu0Var3.d && ez4Var.c(i27, i26)) {
                            i27++;
                            i26++;
                        }
                        iArr[i25 + i] = i27;
                        if (i21 != 0) {
                            int i28 = iB - i25;
                            i13 = i21;
                            if (i28 >= i22 + 1 && i28 <= i20 - 1 && iArr2[i28 + i] <= i27) {
                                mu0Var2 = new mu0();
                                mu0Var2.a = i9;
                                mu0Var2.b = i12;
                                mu0Var2.c = i27;
                                mu0Var2.d = i26;
                                i3 = 0;
                                mu0Var2.e = false;
                                break;
                            }
                        } else {
                            i13 = i21;
                        }
                        i23 = i25 + 2;
                        i14 = 0;
                        i18 = i;
                        iA2 = i4;
                        i21 = i13;
                    }
                    if (mu0Var2 != null) {
                        mu0Var = mu0Var2;
                        break;
                    }
                    int i29 = (lu0Var3.b() - lu0Var3.a()) % 2 == 0 ? 1 : i3;
                    int iB2 = lu0Var3.b() - lu0Var3.a();
                    int i30 = i22;
                    while (true) {
                        if (i30 > i20) {
                            mu0Var3 = null;
                            break;
                        }
                        if (i30 == i22 || (i30 != i20 && iArr2[i30 + 1 + i] < iArr2[(i30 - 1) + i])) {
                            i5 = iArr2[i30 + 1 + i];
                            i6 = i5;
                        } else {
                            i5 = iArr2[(i30 - 1) + i];
                            i6 = i5 - 1;
                        }
                        int i31 = lu0Var3.d - ((lu0Var3.b - i6) - i30);
                        int i32 = (i20 == 0 || i6 != i5) ? i31 : i31 + 1;
                        int i33 = i29;
                        while (i6 > lu0Var3.a && i31 > lu0Var3.c) {
                            i7 = iB2;
                            if (!ez4Var.c(i6 - 1, i31 - 1)) {
                                break;
                            }
                            i6--;
                            i31--;
                            iB2 = i7;
                        }
                        i7 = iB2;
                        iArr2[i30 + i] = i6;
                        if (i33 != 0 && (i8 = i7 - i30) >= i22 && i8 <= i20 && iArr[i8 + i] >= i6) {
                            mu0Var3 = new mu0();
                            mu0Var3.a = i6;
                            mu0Var3.b = i31;
                            mu0Var3.c = i5;
                            mu0Var3.d = i32;
                            mu0Var3.e = true;
                            break;
                        }
                        i30 += 2;
                        i29 = i33;
                        iB2 = i7;
                    }
                    if (mu0Var3 != null) {
                        mu0Var = mu0Var3;
                        break;
                    }
                    i20++;
                    i18 = i;
                    iA2 = i4;
                    i16 = 1;
                    i14 = 0;
                }
                i = i18;
                mu0Var = null;
            }
            if (mu0Var != null) {
                if (mu0Var.a() > 0) {
                    int i34 = mu0Var.d;
                    int i35 = mu0Var.b;
                    int i36 = i34 - i35;
                    int i37 = mu0Var.c;
                    int i38 = mu0Var.a;
                    int i39 = i37 - i38;
                    arrayList.add(i36 != i39 ? mu0Var.e ? new iu0(i38, i35, mu0Var.a()) : i36 > i39 ? new iu0(i38, i35 + 1, mu0Var.a()) : new iu0(i38 + 1, i35, mu0Var.a()) : new iu0(i38, i35, i39));
                }
                if (arrayList3.isEmpty()) {
                    lu0Var = new lu0();
                    i2 = 1;
                } else {
                    i2 = 1;
                    lu0Var = (lu0) arrayList3.remove(arrayList3.size() - 1);
                }
                lu0Var.a = lu0Var3.a;
                lu0Var.c = lu0Var3.c;
                lu0Var.b = mu0Var.a;
                lu0Var.d = mu0Var.b;
                arrayList2.add(lu0Var);
                lu0Var3.b = lu0Var3.b;
                lu0Var3.d = lu0Var3.d;
                lu0Var3.a = mu0Var.c;
                lu0Var3.c = mu0Var.d;
                arrayList2.add(lu0Var3);
            } else {
                i2 = 1;
                arrayList3.add(lu0Var3);
            }
            i18 = i;
            i16 = i2;
            i14 = 0;
        }
        Collections.sort(arrayList, f);
        return new ju0(ez4Var, arrayList, iArr, iArr2);
    }

    public static void n0(String str, int i, ArrayList arrayList) {
        if (arrayList.size() <= i) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i + " parameters found " + arrayList.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable o(defpackage.ph1 r4, defpackage.ag1 r5, defpackage.ie0 r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof defpackage.qg1
            if (r0 == 0) goto L13
            r0 = r6
            qg1 r0 = (defpackage.qg1) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            qg1 r0 = new qg1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.X
            int r1 = r0.Y
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 != r3) goto L2a
            bh3 r4 = r0.A
            defpackage.n12.S(r6)     // Catch: java.lang.Throwable -> L28
            goto L4a
        L28:
            r5 = move-exception
            goto L4d
        L2a:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r2
        L30:
            defpackage.n12.S(r6)
            bh3 r6 = new bh3
            r6.<init>()
            cw0 r1 = new cw0     // Catch: java.lang.Throwable -> L4b
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4b
            r0.A = r6     // Catch: java.lang.Throwable -> L4b
            r0.Y = r3     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r4 = r4.a(r1, r0)     // Catch: java.lang.Throwable -> L4b
            mf0 r5 = defpackage.mf0.b
            if (r4 != r5) goto L4a
            return r5
        L4a:
            return r2
        L4b:
            r5 = move-exception
            r4 = r6
        L4d:
            java.lang.Object r4 = r4.b
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L59
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L7c
        L59:
            cf0 r6 = r0.f
            r6.getClass()
            pr1 r0 = defpackage.pr1.X
            af0 r6 = r6.Z(r0)
            v32 r6 = (defpackage.v32) r6
            if (r6 == 0) goto L7d
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L6f
            goto L7d
        L6f:
            java.util.concurrent.CancellationException r6 = r6.F()
            if (r6 == 0) goto L7d
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L7c
            goto L7d
        L7c:
            throw r5
        L7d:
            if (r4 != 0) goto L80
            return r5
        L80:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L88
            defpackage.ek0.b(r4, r5)
            throw r4
        L88:
            defpackage.ek0.b(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.o(ph1, ag1, ie0):java.io.Serializable");
    }

    public static boolean o0(d25 d25Var) {
        if (d25Var == null) {
            return false;
        }
        Double dG = d25Var.g();
        return !dG.isNaN() && dG.doubleValue() >= 0.0d && dG.equals(Double.valueOf(Math.floor(dG.doubleValue())));
    }

    public static void p(DataInputStream dataInputStream, String str) {
        if (dataInputStream.available() == 0) {
            return;
        }
        StringBuilder sbD = fw.D("length mismatch for table: ", str, " (");
        sbD.append(dataInputStream.available());
        sbD.append(" left)");
        throw new r41(sbD.toString());
    }

    public static a35 p0(String str) {
        a35 a35Var;
        if (str == null || str.isEmpty()) {
            a35Var = null;
        } else {
            a35Var = (a35) a35.C1.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (a35Var != null) {
            return a35Var;
        }
        xe.k(ha0.n("Unsupported commandId ", str));
        return null;
    }

    public static int q(int i, int i2) {
        return Math.max(0, Math.min(i2, i));
    }

    public static boolean q0(d25 d25Var, d25 d25Var2) {
        if (!d25Var.getClass().equals(d25Var2.getClass())) {
            return false;
        }
        if ((d25Var instanceof j25) || (d25Var instanceof a25)) {
            return true;
        }
        if (!(d25Var instanceof p15)) {
            return d25Var instanceof i25 ? d25Var.h().equals(d25Var2.h()) : d25Var instanceof j15 ? d25Var.d().equals(d25Var2.d()) : d25Var == d25Var2;
        }
        if (Double.isNaN(d25Var.g().doubleValue()) || Double.isNaN(d25Var2.g().doubleValue())) {
            return false;
        }
        return d25Var.g().equals(d25Var2.g());
    }

    public static final AbstractDnsRecord r(DnsRecord dnsRecord) {
        if (dnsRecord instanceof DefaultDnsQuestion) {
            DefaultDnsQuestion defaultDnsQuestion = (DefaultDnsQuestion) dnsRecord;
            return new DefaultDnsQuestion(defaultDnsQuestion.name(), defaultDnsQuestion.type(), defaultDnsQuestion.dnsClass());
        }
        if (dnsRecord instanceof DefaultDnsPtrRecord) {
            DefaultDnsPtrRecord defaultDnsPtrRecord = (DefaultDnsPtrRecord) dnsRecord;
            return new DefaultDnsPtrRecord(defaultDnsPtrRecord.name(), defaultDnsPtrRecord.dnsClass(), defaultDnsPtrRecord.timeToLive(), defaultDnsPtrRecord.hostname());
        }
        if (dnsRecord instanceof DefaultDnsRawRecord) {
            DefaultDnsRawRecord defaultDnsRawRecord = (DefaultDnsRawRecord) dnsRecord;
            return new DefaultDnsRawRecord(defaultDnsRawRecord.name(), defaultDnsRawRecord.type(), defaultDnsRawRecord.dnsClass(), defaultDnsRawRecord.timeToLive(), Unpooled.copiedBuffer(defaultDnsRawRecord.content()));
        }
        if (dnsRecord instanceof DefaultDnsOptEcsRecord) {
            DefaultDnsOptEcsRecord defaultDnsOptEcsRecord = (DefaultDnsOptEcsRecord) dnsRecord;
            return new DefaultDnsOptEcsRecord(defaultDnsOptEcsRecord.dnsClass(), defaultDnsOptEcsRecord.extendedRcode(), defaultDnsOptEcsRecord.version(), defaultDnsOptEcsRecord.sourcePrefixLength(), defaultDnsOptEcsRecord.address());
        }
        throw new IllegalStateException(("unknown dns record type: " + dnsRecord.getClass().getCanonicalName()).toString());
    }

    public static int r0(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return 0;
        }
        return (int) ((((double) (d > 0.0d ? 1 : -1)) * Math.floor(Math.abs(d))) % 4.294967296E9d);
    }

    public static Bundle s(Parcel parcel, int i) {
        int iZ = Z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iZ);
        return bundle;
    }

    public static double s0(double d) {
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (Double.isInfinite(d) || d == 0.0d || d == 0.0d) {
            return d;
        }
        return ((double) (d > 0.0d ? 1 : -1)) * Math.floor(Math.abs(d));
    }

    public static Parcelable t(Parcel parcel, int i, Parcelable.Creator creator) {
        int iZ = Z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iZ);
        return parcelable;
    }

    public static Object t0(d25 d25Var) {
        if (d25.r0.equals(d25Var)) {
            return null;
        }
        if (d25.q0.equals(d25Var)) {
            return "";
        }
        if (d25Var instanceof y15) {
            return u0((y15) d25Var);
        }
        if (!(d25Var instanceof h15)) {
            return !d25Var.g().isNaN() ? d25Var.g() : d25Var.h();
        }
        ArrayList arrayList = new ArrayList();
        h15 h15Var = (h15) d25Var;
        int i = 0;
        while (i < h15Var.l()) {
            if (i >= h15Var.l()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i);
                throw new NoSuchElementException(sb.toString());
            }
            int i2 = i + 1;
            Object objT0 = t0(h15Var.m(i));
            if (objT0 != null) {
                arrayList.add(objT0);
            }
            i = i2;
        }
        return arrayList;
    }

    public static HashMap u0(y15 y15Var) {
        HashMap map = new HashMap();
        for (String str : new ArrayList(y15Var.b.keySet())) {
            Object objT0 = t0(y15Var.a(str));
            if (objT0 != null) {
                map.put(str, objT0);
            }
        }
        return map;
    }

    public static String v(Parcel parcel, int i) {
        int iZ = Z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iZ);
        return string;
    }

    public static void v0(ih4 ih4Var) {
        int iR0 = r0(ih4Var.o("runtime.counter").g().doubleValue() + 1.0d);
        if (iR0 <= 1000000) {
            ih4Var.m("runtime.counter", new p15(Double.valueOf(iR0)));
        } else {
            xe.q("Instructions allowed exceeded");
        }
    }

    public static Object[] w(Parcel parcel, int i, Parcelable.Creator creator) {
        int iZ = Z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iZ);
        return objArrCreateTypedArray;
    }

    public static ArrayList x(Parcel parcel, int i, Parcelable.Creator creator) {
        int iZ = Z(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iZ == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iZ);
        return arrayListCreateTypedArrayList;
    }

    public static final void y(AbstractDnsMessage abstractDnsMessage, DnsSection dnsSection, ByteBuf byteBuf, int i) {
        while (i > 0) {
            DnsRecord dnsRecordDecodeRecord = DnsRecordDecoder.DEFAULT.decodeRecord(byteBuf);
            if (dnsRecordDecodeRecord == null) {
                return;
            }
            abstractDnsMessage.addRecord(dnsSection, dnsRecordDecodeRecord);
            i--;
        }
    }

    public static final void z(AbstractDnsMessage abstractDnsMessage, DnsSection dnsSection, ByteBuf byteBuf) {
        int iCount = abstractDnsMessage.count(dnsSection);
        for (int i = 0; i < iCount; i++) {
            DnsRecordEncoder.DEFAULT.encodeRecord(abstractDnsMessage.recordAt(dnsSection, i), byteBuf);
        }
    }

    public abstract yn1 H(int i);

    public void J(go3 go3Var, Object obj) {
        go3Var.getClass();
        if (obj == null) {
            return;
        }
        io3 io3VarD0 = go3Var.D0(u());
        try {
            h(io3VarD0, obj);
            io3VarD0.C0();
            vf2.e(io3VarD0, null);
        } finally {
        }
    }

    public abstract void c(Iterable iterable);

    public abstract void e(yn1 yn1Var);

    public abstract void h(io3 io3Var, Object obj);

    public abstract k1 i();

    public t9 j(Context context, Looper looper, uf4 uf4Var, Object obj, rp1 rp1Var, sp1 sp1Var) {
        return k(context, looper, uf4Var, obj, (sz4) rp1Var, (sz4) sp1Var);
    }

    public t9 k(Context context, Looper looper, uf4 uf4Var, Object obj, sz4 sz4Var, sz4 sz4Var2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public abstract String u();
}
