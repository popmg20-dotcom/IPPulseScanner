package defpackage;

import android.R;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.NetworkOnMainThreadException;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.RemoteViews;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.receiver.appwidget.PublicIPProvider;
import com.getsurfboard.ui.receiver.appwidget.WidgetRetryReceiver;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.sentry.android.core.a1;
import j$.util.Objects;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function2;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l72 {
    public static final int[][] a = {new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, 151, 150, 157, 156, 163, 162, 169, 168, 175, 174, 181, 180, 187, 186, 193, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, 140, 147, 146, 153, 152, 159, 158, 165, 164, 171, 170, 177, 176, 183, 182, 189, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, 142, 149, 148, ModuleDescriptor.MODULE_VERSION, 154, 161, 160, 167, 166, 173, 172, 179, 178, 185, 184, 191, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, 253, 252, 247, 246, 241, 240, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, DnsRecord.CLASS_ANY, DnsRecord.CLASS_NONE, 249, 248, 243, 242, 237, 236, 231, 230, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, 250, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, 308, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    public static final Type[] b = new Type[0];
    public static final String[] c = {"root_id", "flags", "icon", "title", "summary", "document_id", "mime_types", "available_bytes"};
    public static final String[] d = {"document_id", "mime_type", "_display_name", "last_modified", "flags", "_size"};

    public static final String A() {
        Network network;
        LinkProperties linkProperties;
        List<LinkAddress> linkAddresses;
        Object next;
        InetAddress address;
        NetworkInfo activeNetworkInfo = ContextUtilsKt.b().getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            Network[] allNetworks = ContextUtilsKt.b().getAllNetworks();
            allNetworks.getClass();
            int length = allNetworks.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    network = null;
                    break;
                }
                network = allNetworks[i];
                if (N(ContextUtilsKt.b().getNetworkInfo(network), activeNetworkInfo)) {
                    break;
                }
                i++;
            }
            if (network != null && (linkProperties = ContextUtilsKt.b().getLinkProperties(network)) != null && (linkAddresses = linkProperties.getLinkAddresses()) != null) {
                Iterator<T> it = linkAddresses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    InetAddress address2 = ((LinkAddress) next).getAddress();
                    address2.getClass();
                    Pattern pattern = xz1.b;
                    if (xz1.b(address2.getHostAddress())) {
                        break;
                    }
                }
                LinkAddress linkAddress = (LinkAddress) next;
                if (linkAddress != null && (address = linkAddress.getAddress()) != null) {
                    return address.getHostAddress();
                }
            }
        }
        return null;
    }

    public static Class B(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) B(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return B(((WildcardType) type).getUpperBounds()[0]);
        }
        ad0.k("Expected a Class, ParameterizedType, or GenericArrayType, but <", type, "> is of type ", type == null ? "null" : type.getClass().getName());
        return null;
    }

    public static final sr3 C(Object obj) {
        if (obj != fa0.a) {
            return (sr3) obj;
        }
        xe.q("Does not contain segment");
        return null;
    }

    public static Type D(Type type, Class cls, Class cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        if (cls2.isAssignableFrom(cls)) {
            return V(type, cls, v(type, cls, cls2), new HashMap());
        }
        throw new IllegalArgumentException(cls + " is not the same as or a subtype of " + cls2);
    }

    public static final String E(File file) {
        if (file.isDirectory()) {
            return "vnd.android.document/directory";
        }
        String strS = le1.S(file);
        if (strS.equals("conf")) {
            return HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strS);
        return mimeTypeFromExtension == null ? HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE : mimeTypeFromExtension;
    }

    public static int F(Context context, int i) {
        if (i == 0) {
            return 0;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, rc3.C);
        TypedValue typedValue = new TypedValue();
        boolean value = typedArrayObtainStyledAttributes.getValue(4, typedValue);
        if (!value) {
            value = typedArrayObtainStyledAttributes.getValue(2, typedValue);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!value) {
            return 0;
        }
        int complexUnit = typedValue.getComplexUnit();
        int i2 = typedValue.data;
        return complexUnit == 2 ? Math.round(TypedValue.complexToFloat(i2) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(i2, context.getResources().getDisplayMetrics());
    }

    public static boolean G(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static final void H(Activity activity) {
        activity.getClass();
        activity.getWindow().requestFeature(13);
        activity.findViewById(R.id.content).setTransitionName("shared_element_end_root");
        activity.setEnterSharedElementCallback(new vi2());
        activity.getWindow().setSharedElementEnterTransition(c(activity, true));
        activity.getWindow().setSharedElementReturnTransition(c(activity, false));
    }

    public static final boolean I(Object obj) {
        return obj == fa0.a;
    }

    public static boolean J(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean K(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean L(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static boolean M(pj2 pj2Var) {
        pj2Var.getClass();
        String str = pj2Var.b;
        if (str.equals("text")) {
            return true;
        }
        if (str.equals("application")) {
            return qe.a0(pj2Var.c, new String[]{"html", "xml"});
        }
        return false;
    }

    public static final boolean N(NetworkInfo networkInfo, NetworkInfo networkInfo2) {
        return networkInfo != null && networkInfo2 != null && networkInfo.isConnected() == networkInfo2.isConnected() && networkInfo.isAvailable() == networkInfo2.isAvailable() && networkInfo.isConnectedOrConnecting() == networkInfo2.isConnectedOrConnecting() && networkInfo.isFailover() == networkInfo2.isFailover() && networkInfo.isRoaming() == networkInfo2.isRoaming() && networkInfo.getType() == networkInfo2.getType() && networkInfo.getSubtype() == networkInfo2.getSubtype() && networkInfo.getState() == networkInfo2.getState() && networkInfo.getDetailedState() == networkInfo2.getDetailedState() && Objects.equals(networkInfo.getExtraInfo(), networkInfo2.getExtraInfo()) && Objects.equals(networkInfo.getReason(), networkInfo2.getReason()) && Objects.equals(networkInfo.getTypeName(), networkInfo2.getTypeName()) && Objects.equals(networkInfo.getSubtypeName(), networkInfo2.getSubtypeName());
    }

    public static TypedArray O(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static xo4 P(String str) {
        String strGroup;
        if (str == null || p44.x0(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
        if (!matcher.matches() || (strGroup = matcher.group(1)) == null) {
            return null;
        }
        int i = Integer.parseInt(strGroup);
        String strGroup2 = matcher.group(2);
        if (strGroup2 == null) {
            return null;
        }
        int i2 = Integer.parseInt(strGroup2);
        String strGroup3 = matcher.group(3);
        if (strGroup3 == null) {
            return null;
        }
        int i3 = Integer.parseInt(strGroup3);
        String strGroup4 = matcher.group(4) != null ? matcher.group(4) : "";
        strGroup4.getClass();
        return new xo4(i, i2, i3, strGroup4);
    }

    public static InetSocketAddress Q(int i, int i2, byte[] bArr) {
        if (i2 < 8 || (bArr[i + 1] & 255) != 1) {
            return null;
        }
        return new InetSocketAddress(InetAddress.getByAddress(qe.h0(i + 4, i + 8, bArr)), ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255));
    }

    public static y44 R(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        e03 e03Var;
        int i3 = i;
        int i4 = 20;
        if (i3 >= 20) {
            int i5 = 8;
            int i6 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
            if (i6 == 257 || i6 == 273) {
                int i7 = 4;
                if ((((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | (bArr[7] & 255)) == 554869826 && Arrays.equals(qe.h0(8, 20, bArr), bArr2)) {
                    int i8 = (((bArr[2] & DnsRecord.CLASS_ANY) << 8) | (bArr[3] & DnsRecord.CLASS_ANY)) + 20;
                    if (i8 <= i3) {
                        i3 = i8;
                    }
                    InetSocketAddress inetSocketAddressQ = null;
                    InetSocketAddress inetSocketAddressQ2 = null;
                    Integer num = null;
                    String str = null;
                    while (true) {
                        int i9 = i4 + 4;
                        if (i9 > i3) {
                            break;
                        }
                        int i10 = (bArr[i4 + 1] & DnsRecord.CLASS_ANY) | ((bArr[i4] & DnsRecord.CLASS_ANY) << i5);
                        int i11 = (bArr[i4 + 3] & DnsRecord.CLASS_ANY) | ((bArr[i4 + 2] & DnsRecord.CLASS_ANY) << i5);
                        if (i9 + i11 > i3) {
                            break;
                        }
                        if (i10 == 1) {
                            i2 = i7;
                            if (inetSocketAddressQ == null) {
                                inetSocketAddressQ = Q(i9, i11, bArr);
                            }
                        } else if (i10 == 5) {
                            i2 = i7;
                            if (inetSocketAddressQ2 == null) {
                                inetSocketAddressQ2 = Q(i9, i11, bArr);
                            }
                        } else if (i10 != 9) {
                            if (i10 != 32) {
                                if (i10 == 32812) {
                                    inetSocketAddressQ2 = Q(i9, i11, bArr);
                                }
                            } else if (i11 >= i5 && (bArr[i4 + 5] & 255) == 1) {
                                int i12 = (((bArr[i4 + 6] & DnsRecord.CLASS_ANY) << i5) | (bArr[i4 + 7] & DnsRecord.CLASS_ANY)) ^ 8466;
                                byte[] bArr3 = new byte[i7];
                                for (int i13 = 0; i13 < i7; i13++) {
                                    bArr3[i13] = (byte) (bArr[(i4 + 8) + i13] ^ ((554869826 >> (24 - (i13 * 8))) & DnsRecord.CLASS_ANY));
                                }
                                inetSocketAddressQ = new InetSocketAddress(InetAddress.getByAddress(bArr3), i12);
                            } else {
                                inetSocketAddressQ = null;
                            }
                            i2 = i7;
                        } else {
                            if (i11 < i7) {
                                i2 = i7;
                                e03Var = null;
                            } else {
                                i2 = i7;
                                e03Var = new e03(Integer.valueOf(((bArr[i4 + 6] & 255) * 100) + (bArr[i4 + 7] & 255)), new String(bArr, i4 + 8, i11 - 4, y30.a));
                            }
                            if (e03Var != null) {
                                num = (Integer) e03Var.b;
                                str = (String) e03Var.f;
                            }
                        }
                        i4 += ((i11 + 3) & (-4)) + 4;
                        i7 = i2;
                        i5 = 8;
                    }
                    return new y44(inetSocketAddressQ, inetSocketAddressQ2, num, str);
                }
            }
        }
        return null;
    }

    public static final byte[] S(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        h(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public static final String T(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[8192];
        int i = reader.read(cArr);
        while (i >= 0) {
            stringWriter.write(cArr, 0, i);
            i = reader.read(cArr);
        }
        String string = stringWriter.toString();
        string.getClass();
        return string;
    }

    public static final void U() throws UnknownHostException {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "PublicIPProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "refreshWidgets() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("PublicIPProvider", "refreshWidgets() called", null);
        }
        ei0 ei0Var = (ei0) cr2.a.d();
        if (ei0Var != null && xb5.C(PublicIPProvider.a)) {
            RemoteViews remoteViews = new RemoteViews(ContextUtilsKt.getContext().getPackageName(), com.getsurfboard.R.layout.widget_public_ip);
            String str = "refreshWidgets() start update layout: " + ei0Var;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "PublicIPProvider", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("PublicIPProvider", str, null);
            }
            int iOrdinal = ei0Var.a.ordinal();
            if (iOrdinal == 0) {
                remoteViews.setViewVisibility(com.getsurfboard.R.id.icon, 0);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.title, 0);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.loading, 0);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.ip, 4);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.retry, 4);
            } else if (iOrdinal == 1) {
                remoteViews.setViewVisibility(com.getsurfboard.R.id.icon, 0);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.title, 0);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.loading, 4);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.ip, 0);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.retry, 4);
                Object obj = ei0Var.b;
                if (obj != null) {
                    remoteViews.setTextViewText(com.getsurfboard.R.id.ip, (CharSequence) obj);
                    try {
                        InetAddress byName = InetAddress.getByName((String) ei0Var.b);
                        zm1 zm1Var = an1.a;
                        byName.getClass();
                        String strD = zm1Var.d(byName);
                        if (strD != null) {
                            remoteViews.setTextViewText(com.getsurfboard.R.id.title, ContextUtilsKt.k(com.getsurfboard.R.string.public_ip) + " " + ji0.g(strD));
                        }
                    } catch (NetworkOnMainThreadException e) {
                        e.printStackTrace();
                    }
                } else {
                    remoteViews.setTextViewText(com.getsurfboard.R.id.ip, ContextUtilsKt.k(com.getsurfboard.R.string.no_network));
                }
            } else {
                if (iOrdinal != 2) {
                    g.d();
                    return;
                }
                remoteViews.setViewVisibility(com.getsurfboard.R.id.icon, 4);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.title, 4);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.loading, 4);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.ip, 4);
                remoteViews.setViewVisibility(com.getsurfboard.R.id.retry, 0);
            }
            Intent action = new Intent(ContextUtilsKt.getContext(), (Class<?>) WidgetRetryReceiver.class).putExtra("type", "public_ip").setAction("com.getsurfboard.ACTION_WIDGET_RETRY");
            action.getClass();
            remoteViews.setOnClickPendingIntent(com.getsurfboard.R.id.retry, PendingIntent.getBroadcast(ContextUtilsKt.getContext(), fj3.f, action, a(134217728, true)));
            Intent intentS = p95.s(ContextUtilsKt.getContext(), false);
            intentS.setFlags(intentS.getFlags() + 67108864);
            intentS.setFlags(intentS.getFlags() + 536870912);
            intentS.putExtra("tab", "dashboard");
            remoteViews.setOnClickPendingIntent(R.id.background, o(ContextUtilsKt.getContext(), fj3.c, intentS, true));
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(ContextUtilsKt.getContext());
            if (appWidgetManager != null) {
                appWidgetManager.updateAppWidget(PublicIPProvider.a, remoteViews);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0142 A[EDGE_INSN: B:92:0x0142->B:84:0x0142 BREAK  A[LOOP:0: B:3:0x0002->B:95:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[LOOP:0: B:3:0x0002->B:95:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r12v3, types: [mq1] */
    /* JADX WARN: Type inference failed for: r12v4, types: [mq1] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type V(java.lang.reflect.Type r10, java.lang.Class r11, java.lang.reflect.Type r12, java.util.HashMap r13) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l72.V(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.HashMap):java.lang.reflect.Type");
    }

    public static TimeInterpolator W(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            xe.k("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
            return null;
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!L(strValueOf, "cubic-bezier") && !L(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!L(strValueOf, "cubic-bezier")) {
            if (L(strValueOf, "path")) {
                return new PathInterpolator(n12.t(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            xe.k("Invalid motion easing type: ".concat(strValueOf));
            return null;
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(w(strArrSplit, 0), w(strArrSplit, 1), w(strArrSplit, 2), w(strArrSplit, 3));
        }
        a71.e(strArrSplit.length, "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
        return null;
    }

    public static x04 X(Context context) {
        TypedValue typedValueA = ek0.A(context, com.getsurfboard.R.attr.motionSpringFastSpatial);
        int[] iArr = rc3.A;
        TypedArray typedArrayObtainStyledAttributes = typedValueA == null ? context.obtainStyledAttributes(null, iArr, 0, com.getsurfboard.R.style.Motion_Material3_Spring_Standard_Fast_Spatial) : context.obtainStyledAttributes(typedValueA.resourceId, iArr);
        x04 x04Var = new x04();
        try {
            float f = typedArrayObtainStyledAttributes.getFloat(1, Float.MIN_VALUE);
            if (f == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f2 = typedArrayObtainStyledAttributes.getFloat(0, Float.MIN_VALUE);
            if (f2 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            x04Var.b(f);
            x04Var.a(f2);
            return x04Var;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static boolean Y(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i = 0; i < bArr2.length; i++) {
                if (bArr[i] == bArr2[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public static final String Z(int i) {
        if (i == 0) {
            return "0";
        }
        char[] cArr = je.b;
        int i2 = 0;
        char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
        while (i2 < 8 && cArr2[i2] == '0') {
            i2++;
        }
        if (i2 < 0) {
            s53.k(ha0.k("startIndex: ", i2, ", endIndex: 8, size: 8"));
            return null;
        }
        if (i2 <= 8) {
            return new String(cArr2, i2, 8 - i2);
        }
        xe.k(ha0.k("startIndex: ", i2, " > endIndex: 8"));
        return null;
    }

    public static int a(int i, boolean z) {
        int i2;
        if (!z) {
            i2 = 67108864;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i;
            }
            i2 = 33554432;
        }
        return i | i2;
    }

    public static String a0(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static final boolean b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        bArr.getClass();
        bArr2.getClass();
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final Object b0(cf0 cf0Var, Object obj, Object obj2, Function2 function2, ge0 ge0Var) {
        Object objC = nd4.c(cf0Var, obj2);
        try {
            m14 m14Var = new m14(ge0Var, cf0Var);
            tj4.c(2, function2);
            Object objK = function2.k(obj, m14Var);
            nd4.a(cf0Var, objC);
            if (objK == mf0.b) {
                ge0Var.getClass();
            }
            return objK;
        } catch (Throwable th) {
            nd4.a(cf0Var, objC);
            throw th;
        }
    }

    public static final si2 c(Activity activity, boolean z) {
        si2 si2Var = new si2();
        si2Var.b = false;
        si2Var.f = false;
        si2Var.z = false;
        si2Var.A = R.id.content;
        si2Var.X = -1;
        si2Var.Y = -1;
        si2Var.Z = 0;
        si2Var.y0 = 0;
        si2Var.z0 = 0;
        si2Var.A0 = 1375731712;
        si2Var.B0 = Build.VERSION.SDK_INT >= 28;
        si2Var.C0 = -1.0f;
        si2Var.D0 = -1.0f;
        si2Var.b(activity, z);
        si2Var.z = true;
        int iA = n12.A(activity.findViewById(R.id.content), com.getsurfboard.R.attr.colorSurface);
        si2Var.Z = iA;
        si2Var.y0 = iA;
        si2Var.z0 = iA;
        si2Var.addTarget(R.id.content);
        si2Var.setDuration(ContextUtilsKt.getContext().getResources().getInteger(R.integer.config_mediumAnimTime));
        si2Var.setInterpolator(new ub1());
        return si2Var;
    }

    public static String c0(hb5 hb5Var) {
        StringBuilder sb = new StringBuilder(hb5Var.c());
        for (int i = 0; i < hb5Var.c(); i++) {
            byte bA = hb5Var.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static Type d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new kq1(d(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new lq1(parameterizedType.getOwnerType(), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new kq1(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new mq1(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static void e(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            xe.k("Primitive type is not allowed");
        }
    }

    public static final void f(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            StringBuilder sbC = fw.C("size=", " offset=", j);
            sbC.append(j2);
            sbC.append(" byteCount=");
            sbC.append(j3);
            throw new ArrayIndexOutOfBoundsException(sbC.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] g(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static final long h(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i = inputStream.read(bArr);
        long j = 0;
        while (i >= 0) {
            outputStream.write(bArr, 0, i);
            j += (long) i;
            i = inputStream.read(bArr);
        }
        return j;
    }

    public static x80 i(String str, String str2) {
        zg zgVar = new zg(str, str2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3.a(zg.class));
        return new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new w80(0, zgVar), hashSet3);
    }

    public static final ml3 j(Context context, Class cls, String str) {
        context.getClass();
        if (p44.x0(str)) {
            xe.k("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
            return null;
        }
        if (!str.equals(":memory:")) {
            return new ml3(context, cls, str);
        }
        xe.k("Cannot build a database with the special name ':memory:'. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        return null;
    }

    public static boolean k(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return Objects.equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return k(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return Objects.equals(typeVariable.getGenericDeclaration(), typeVariable2.getGenericDeclaration()) && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static x80 l(String str, a71 a71Var) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(fc3.a(zg.class));
        for (Class cls : new Class[0]) {
            ez4.k(cls, "Null interface");
            hashSet.add(fc3.a(cls));
        }
        ho0 ho0VarA = ho0.a(Context.class);
        if (hashSet.contains(ho0VarA.a)) {
            xe.k("Components are not allowed to depend on interfaces they themselves provide.");
            return null;
        }
        hashSet2.add(ho0VarA);
        return new x80(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new ed(8, str, a71Var), hashSet3);
    }

    public static final vw4 m(gx4 gx4Var) {
        gx4Var.getClass();
        return new vw4(gx4Var.a, gx4Var.t);
    }

    public static final Object n(ez2 ez2Var, int i) {
        if (i < 0 || i >= ez2Var.f()) {
            zo2.j(ez2Var.f(), dw2.D("Index: ", i, ", Size: "));
            return null;
        }
        int i2 = i - ez2Var.c;
        if (i2 < 0 || i2 >= ez2Var.b) {
            return null;
        }
        return ez2Var.c(i2);
    }

    public static PendingIntent o(Context context, int i, Intent intent, boolean z) {
        return PendingIntent.getActivity(context, i, intent, a(134217728, z));
    }

    public static int p(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static ColorStateList q(Context context, n02 n02Var, int i) {
        int resourceId;
        ColorStateList colorStateListG;
        TypedArray typedArray = (TypedArray) n02Var.z;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListG = v9.g(context, resourceId)) == null) ? n02Var.n(i) : colorStateListG;
    }

    public static ColorStateList r(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListG;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListG = v9.g(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListG;
    }

    public static int s(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static void t(nc2 nc2Var) {
        boolean z = false;
        if (!nc2Var.isDone()) {
            xe.q(ek0.w("Future was expected to be done: %s", nc2Var));
            return;
        }
        while (true) {
            try {
                nc2Var.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static Drawable u(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableR;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableR = vo.r(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableR;
    }

    public static Type v(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return v(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return v(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static float w(String[] strArr, int i) {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    public static qt x(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        qt qtVarE;
        String attributeValue = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str);
        int i2 = 7;
        Object obj = null;
        int i3 = 0;
        if (attributeValue != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return new qt(obj, obj, typedValue.data, i2);
            }
            try {
                qtVarE = qt.e(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception e) {
                a1.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                qtVarE = null;
            }
            if (qtVarE != null) {
                return qtVarE;
            }
        }
        return new qt(obj, obj, i3, i2);
    }

    public static String y(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (G(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.os.Bundle z(android.view.View r11) {
        /*
            r11.getClass()
            android.content.Context r0 = r11.getContext()
            r0.getClass()
            g91 r1 = defpackage.je.F(r0)
            h91 r1 = r1.a
            n84 r1 = r1.e
            java.lang.Object r1 = r1.getValue()
            o04 r1 = (defpackage.o04) r1
            o04 r2 = defpackage.o04.b
            boolean r1 = defpackage.n12.c(r1, r2)
            boolean r2 = r0 instanceof android.app.Activity
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L87
            r5 = r0
            android.app.Activity r5 = (android.app.Activity) r5
            android.view.Window r6 = r5.getWindow()
            android.view.View r6 = r6.getDecorView()
            int r6 = r6.getWidth()
            r7 = 1146224640(0x44520000, float:840.0)
            int r7 = com.getsurfboard.base.ContextUtilsKt.c(r7)
            if (r6 < r7) goto L3d
            r6 = r3
            goto L3e
        L3d:
            r6 = r4
        L3e:
            boolean r7 = r0 instanceof com.getsurfboard.ui.activity.MainActivity
            if (r7 == 0) goto L85
            android.content.Context r7 = r11.getContext()
            r7.getClass()
            h91 r8 = defpackage.h91.f
            h91 r8 = defpackage.h91.f
            if (r8 != 0) goto L75
            java.util.concurrent.locks.ReentrantLock r8 = defpackage.h91.g
            r8.lock()
            h91 r9 = defpackage.h91.f     // Catch: java.lang.Throwable -> L6b
            if (r9 != 0) goto L6d
            android.content.Context r7 = r7.getApplicationContext()     // Catch: java.lang.Throwable -> L6b
            r7.getClass()     // Catch: java.lang.Throwable -> L6b
            b31 r9 = defpackage.vf2.u(r7)     // Catch: java.lang.Throwable -> L6b
            h91 r10 = new h91     // Catch: java.lang.Throwable -> L6b
            r10.<init>(r7, r9)     // Catch: java.lang.Throwable -> L6b
            defpackage.h91.f = r10     // Catch: java.lang.Throwable -> L6b
            goto L6d
        L6b:
            r11 = move-exception
            goto L71
        L6d:
            r8.unlock()
            goto L75
        L71:
            r8.unlock()
            throw r11
        L75:
            h91 r7 = defpackage.h91.f
            r7.getClass()
            c31 r7 = r7.b
            if (r7 == 0) goto L85
            b31 r7 = (defpackage.b31) r7
            boolean r5 = r7.a(r5)
            goto L89
        L85:
            r5 = r4
            goto L89
        L87:
            r5 = r4
            r6 = r5
        L89:
            if (r6 != 0) goto L8f
            if (r5 == 0) goto L8e
            goto L8f
        L8e:
            r3 = r4
        L8f:
            boolean r4 = r0 instanceof com.getsurfboard.ui.activity.MainActivity
            r5 = 0
            if (r4 == 0) goto L9a
            if (r1 == 0) goto L9a
            if (r3 == 0) goto L9a
        L98:
            r11 = r5
            goto La4
        L9a:
            if (r2 == 0) goto L98
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.String r1 = "shared_element_end_root"
            android.app.ActivityOptions r11 = android.app.ActivityOptions.makeSceneTransitionAnimation(r0, r11, r1)
        La4:
            if (r11 == 0) goto Lab
            android.os.Bundle r11 = r11.toBundle()
            return r11
        Lab:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l72.z(android.view.View):android.os.Bundle");
    }
}
