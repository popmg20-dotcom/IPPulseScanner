package defpackage;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.getsurfboard.backup.model.SettingValue;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.HttpConstants;
import io.sentry.android.core.a1;
import io.sentry.android.core.cache.a;
import j$.util.DesugarCollections;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i71 {
    public static final byte[] A;
    public static final byte[] B;
    public static final byte[] C;
    public static final byte[] D;
    public static final String[] E;
    public static final int[] F;
    public static final byte[] G;
    public static final f71 H;
    public static final f71[][] I;
    public static final f71[] J;
    public static final HashMap[] K;
    public static final HashMap[] L;
    public static final Set M;
    public static final HashMap N;
    public static final Charset O;
    public static final byte[] P;
    public static final byte[] Q;
    public static final boolean o = Log.isLoggable("ExifInterface", 3);
    public static final int[] p;
    public static final int[] q;
    public static final byte[] r;
    public static final byte[] s;
    public static final byte[] t;
    public static final byte[] u;
    public static final byte[] v;
    public static final byte[] w;
    public static final byte[] x;
    public static final byte[] y;
    public static final byte[] z;
    public final String a;
    public final FileDescriptor b;
    public final AssetManager.AssetInputStream c;
    public int d;
    public final boolean e;
    public final HashMap[] f;
    public final HashSet g;
    public ByteOrder h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public e71 n;

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        p = new int[]{8, 8, 8};
        q = new int[]{8};
        r = new byte[]{-1, -40, -1};
        s = new byte[]{102, 116, 121, 112};
        t = new byte[]{109, 105, 102, 49};
        u = new byte[]{104, 101, 105, 99};
        v = new byte[]{97, 118, 105, 102};
        w = new byte[]{97, 118, 105, 115};
        x = new byte[]{79, 76, 89, 77, 80, 0};
        y = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        z = new byte[]{-119, 80, 78, 71, HttpConstants.CR, 10, 26, 10};
        A = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);
        B = new byte[]{82, 73, 70, 70};
        C = new byte[]{87, 69, 66, 80};
        D = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        E = new String[]{"", "BYTE", SettingValue.TYPE_STRING, "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        F = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        G = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        f71[] f71VarArr = {new f71("NewSubfileType", DnsRecord.CLASS_NONE, 4), new f71("SubfileType", DnsRecord.CLASS_ANY, 4), new f71("ImageWidth", 256, 3, 4), new f71("ImageLength", 257, 3, 4), new f71("BitsPerSample", 258, 3), new f71("Compression", 259, 3), new f71("PhotometricInterpretation", 262, 3), new f71("ImageDescription", 270, 2), new f71("Make", 271, 2), new f71("Model", 272, 2), new f71("StripOffsets", 273, 3, 4), new f71("Orientation", 274, 3), new f71("SamplesPerPixel", 277, 3), new f71("RowsPerStrip", 278, 3, 4), new f71("StripByteCounts", 279, 3, 4), new f71("XResolution", 282, 5), new f71("YResolution", 283, 5), new f71("PlanarConfiguration", 284, 3), new f71("ResolutionUnit", 296, 3), new f71("TransferFunction", 301, 3), new f71("Software", 305, 2), new f71("DateTime", 306, 2), new f71("Artist", 315, 2), new f71("WhitePoint", 318, 5), new f71("PrimaryChromaticities", 319, 5), new f71("SubIFDPointer", 330, 4), new f71("JPEGInterchangeFormat", 513, 4), new f71("JPEGInterchangeFormatLength", 514, 4), new f71("YCbCrCoefficients", 529, 5), new f71("YCbCrSubSampling", 530, 3), new f71("YCbCrPositioning", 531, 3), new f71("ReferenceBlackWhite", 532, 5), new f71("Copyright", 33432, 2), new f71("ExifIFDPointer", 34665, 4), new f71("GPSInfoIFDPointer", 34853, 4), new f71("SensorTopBorder", 4, 4), new f71("SensorLeftBorder", 5, 4), new f71("SensorBottomBorder", 6, 4), new f71("SensorRightBorder", 7, 4), new f71("ISO", 23, 3), new f71("JpgFromRaw", 46, 7), new f71("Xmp", 700, 1)};
        f71[] f71VarArr2 = {new f71("ExposureTime", 33434, 5), new f71("FNumber", 33437, 5), new f71("ExposureProgram", 34850, 3), new f71("SpectralSensitivity", 34852, 2), new f71("PhotographicSensitivity", 34855, 3), new f71("OECF", 34856, 7), new f71("SensitivityType", 34864, 3), new f71("StandardOutputSensitivity", 34865, 4), new f71("RecommendedExposureIndex", 34866, 4), new f71("ISOSpeed", 34867, 4), new f71("ISOSpeedLatitudeyyy", 34868, 4), new f71("ISOSpeedLatitudezzz", 34869, 4), new f71("ExifVersion", 36864, 2), new f71("DateTimeOriginal", 36867, 2), new f71("DateTimeDigitized", 36868, 2), new f71("OffsetTime", 36880, 2), new f71("OffsetTimeOriginal", 36881, 2), new f71("OffsetTimeDigitized", 36882, 2), new f71("ComponentsConfiguration", 37121, 7), new f71("CompressedBitsPerPixel", 37122, 5), new f71("ShutterSpeedValue", 37377, 10), new f71("ApertureValue", 37378, 5), new f71("BrightnessValue", 37379, 10), new f71("ExposureBiasValue", 37380, 10), new f71("MaxApertureValue", 37381, 5), new f71("SubjectDistance", 37382, 5), new f71("MeteringMode", 37383, 3), new f71("LightSource", 37384, 3), new f71("Flash", 37385, 3), new f71("FocalLength", 37386, 5), new f71("SubjectArea", 37396, 3), new f71("MakerNote", 37500, 7), new f71("UserComment", 37510, 7), new f71("SubSecTime", 37520, 2), new f71("SubSecTimeOriginal", 37521, 2), new f71("SubSecTimeDigitized", 37522, 2), new f71("FlashpixVersion", 40960, 7), new f71("ColorSpace", 40961, 3), new f71("PixelXDimension", 40962, 3, 4), new f71("PixelYDimension", 40963, 3, 4), new f71("RelatedSoundFile", 40964, 2), new f71("InteroperabilityIFDPointer", 40965, 4), new f71("FlashEnergy", 41483, 5), new f71("SpatialFrequencyResponse", 41484, 7), new f71("FocalPlaneXResolution", 41486, 5), new f71("FocalPlaneYResolution", 41487, 5), new f71("FocalPlaneResolutionUnit", 41488, 3), new f71("SubjectLocation", 41492, 3), new f71("ExposureIndex", 41493, 5), new f71("SensingMethod", 41495, 3), new f71("FileSource", 41728, 7), new f71("SceneType", 41729, 7), new f71("CFAPattern", 41730, 7), new f71("CustomRendered", 41985, 3), new f71("ExposureMode", 41986, 3), new f71("WhiteBalance", 41987, 3), new f71("DigitalZoomRatio", 41988, 5), new f71("FocalLengthIn35mmFilm", 41989, 3), new f71("SceneCaptureType", 41990, 3), new f71("GainControl", 41991, 3), new f71("Contrast", 41992, 3), new f71("Saturation", 41993, 3), new f71("Sharpness", 41994, 3), new f71("DeviceSettingDescription", 41995, 7), new f71("SubjectDistanceRange", 41996, 3), new f71("ImageUniqueID", 42016, 2), new f71("CameraOwnerName", 42032, 2), new f71("BodySerialNumber", 42033, 2), new f71("LensSpecification", 42034, 5), new f71("LensMake", 42035, 2), new f71("LensModel", 42036, 2), new f71("Gamma", 42240, 5), new f71("DNGVersion", 50706, 1), new f71("DefaultCropSize", 50720, 3, 4)};
        f71[] f71VarArr3 = {new f71("GPSVersionID", 0, 1), new f71("GPSLatitudeRef", 1, 2), new f71("GPSLatitude", 2, 5, 10), new f71("GPSLongitudeRef", 3, 2), new f71("GPSLongitude", 4, 5, 10), new f71("GPSAltitudeRef", 5, 1), new f71("GPSAltitude", 6, 5), new f71("GPSTimeStamp", 7, 5), new f71("GPSSatellites", 8, 2), new f71("GPSStatus", 9, 2), new f71("GPSMeasureMode", 10, 2), new f71("GPSDOP", 11, 5), new f71("GPSSpeedRef", 12, 2), new f71("GPSSpeed", 13, 5), new f71("GPSTrackRef", 14, 2), new f71("GPSTrack", 15, 5), new f71("GPSImgDirectionRef", 16, 2), new f71("GPSImgDirection", 17, 5), new f71("GPSMapDatum", 18, 2), new f71("GPSDestLatitudeRef", 19, 2), new f71("GPSDestLatitude", 20, 5), new f71("GPSDestLongitudeRef", 21, 2), new f71("GPSDestLongitude", 22, 5), new f71("GPSDestBearingRef", 23, 2), new f71("GPSDestBearing", 24, 5), new f71("GPSDestDistanceRef", 25, 2), new f71("GPSDestDistance", 26, 5), new f71("GPSProcessingMethod", 27, 7), new f71("GPSAreaInformation", 28, 7), new f71("GPSDateStamp", 29, 2), new f71("GPSDifferential", 30, 3), new f71("GPSHPositioningError", 31, 5)};
        f71[] f71VarArr4 = {new f71("InteroperabilityIndex", 1, 2)};
        f71[] f71VarArr5 = {new f71("NewSubfileType", DnsRecord.CLASS_NONE, 4), new f71("SubfileType", DnsRecord.CLASS_ANY, 4), new f71("ThumbnailImageWidth", 256, 3, 4), new f71("ThumbnailImageLength", 257, 3, 4), new f71("BitsPerSample", 258, 3), new f71("Compression", 259, 3), new f71("PhotometricInterpretation", 262, 3), new f71("ImageDescription", 270, 2), new f71("Make", 271, 2), new f71("Model", 272, 2), new f71("StripOffsets", 273, 3, 4), new f71("ThumbnailOrientation", 274, 3), new f71("SamplesPerPixel", 277, 3), new f71("RowsPerStrip", 278, 3, 4), new f71("StripByteCounts", 279, 3, 4), new f71("XResolution", 282, 5), new f71("YResolution", 283, 5), new f71("PlanarConfiguration", 284, 3), new f71("ResolutionUnit", 296, 3), new f71("TransferFunction", 301, 3), new f71("Software", 305, 2), new f71("DateTime", 306, 2), new f71("Artist", 315, 2), new f71("WhitePoint", 318, 5), new f71("PrimaryChromaticities", 319, 5), new f71("SubIFDPointer", 330, 4), new f71("JPEGInterchangeFormat", 513, 4), new f71("JPEGInterchangeFormatLength", 514, 4), new f71("YCbCrCoefficients", 529, 5), new f71("YCbCrSubSampling", 530, 3), new f71("YCbCrPositioning", 531, 3), new f71("ReferenceBlackWhite", 532, 5), new f71("Copyright", 33432, 2), new f71("ExifIFDPointer", 34665, 4), new f71("GPSInfoIFDPointer", 34853, 4), new f71("DNGVersion", 50706, 1), new f71("DefaultCropSize", 50720, 3, 4)};
        H = new f71("StripOffsets", 273, 3);
        I = new f71[][]{f71VarArr, f71VarArr2, f71VarArr3, f71VarArr4, f71VarArr5, f71VarArr, new f71[]{new f71("ThumbnailImage", 256, 7), new f71("CameraSettingsIFDPointer", 8224, 4), new f71("ImageProcessingIFDPointer", 8256, 4)}, new f71[]{new f71("PreviewImageStart", 257, 4), new f71("PreviewImageLength", 258, 4)}, new f71[]{new f71("AspectFrame", 4371, 3)}, new f71[]{new f71("ColorSpace", 55, 3)}};
        J = new f71[]{new f71("SubIFDPointer", 330, 4), new f71("ExifIFDPointer", 34665, 4), new f71("GPSInfoIFDPointer", 34853, 4), new f71("InteroperabilityIFDPointer", 40965, 4), new f71("CameraSettingsIFDPointer", 8224, 1), new f71("ImageProcessingIFDPointer", 8256, 1)};
        K = new HashMap[10];
        L = new HashMap[10];
        M = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        N = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        O = charsetForName;
        P = "Exif\u0000\u0000".getBytes(charsetForName);
        Q = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            f71[][] f71VarArr6 = I;
            if (i >= f71VarArr6.length) {
                HashMap map = N;
                f71[] f71VarArr7 = J;
                map.put(Integer.valueOf(f71VarArr7[0].a), 5);
                map.put(Integer.valueOf(f71VarArr7[1].a), 1);
                map.put(Integer.valueOf(f71VarArr7[2].a), 2);
                map.put(Integer.valueOf(f71VarArr7[3].a), 3);
                map.put(Integer.valueOf(f71VarArr7[4].a), 7);
                map.put(Integer.valueOf(f71VarArr7[5].a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            K[i] = new HashMap();
            L[i] = new HashMap();
            for (f71 f71Var : f71VarArr6[i]) {
                K[i].put(Integer.valueOf(f71Var.a), f71Var);
                L[i].put(f71Var.b, f71Var);
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7 A[Catch: all -> 0x0064, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0064, blocks: (B:14:0x0055, B:16:0x0058, B:24:0x006f, B:25:0x007d, B:31:0x008f, B:33:0x0096, B:51:0x00c7, B:38:0x00a6, B:45:0x00b4, B:48:0x00bc, B:49:0x00c0, B:50:0x00c4, B:52:0x00d1, B:54:0x00da, B:56:0x00e0, B:58:0x00e6, B:60:0x00ec, B:65:0x00f7), top: B:75:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i71(InputStream inputStream) throws IOException {
        f71[][] f71VarArr = I;
        this.f = new HashMap[f71VarArr.length];
        this.g = new HashSet(f71VarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        this.a = null;
        this.e = false;
        boolean z2 = inputStream instanceof AssetManager.AssetInputStream;
        boolean z3 = o;
        if (z2) {
            this.c = (AssetManager.AssetInputStream) inputStream;
            this.b = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            try {
                Os.lseek(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                this.c = null;
                this.b = fileInputStream.getFD();
            } catch (Exception unused) {
                if (z3) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                this.c = null;
                this.b = null;
            }
        } else {
            this.c = null;
            this.b = null;
        }
        boolean z4 = this.e;
        for (int i = 0; i < f71VarArr.length; i++) {
            try {
                try {
                    this.f[i] = new HashMap();
                } catch (Throwable th) {
                    a();
                    if (z3) {
                        r();
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                if (z3) {
                    a1.o("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file (ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (!z3) {
                    return;
                }
            } catch (UnsupportedOperationException e2) {
                e = e2;
                if (z3) {
                }
                a();
                if (!z3) {
                }
            }
        }
        if (!z4) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.d = g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        int i2 = this.d;
        if (i2 == 4 || i2 == 9 || i2 == 13 || i2 == 14) {
            d71 d71Var = new d71(inputStream);
            int i3 = this.d;
            if (i3 == 4) {
                f(d71Var, 0, 0);
            } else if (i3 == 13) {
                i(d71Var);
            } else if (i3 == 9) {
                j(d71Var);
            } else if (i3 == 14) {
                n(d71Var);
            }
        } else {
            h71 h71Var = new h71(inputStream);
            if (!z4) {
                int i4 = this.d;
                if (i4 == 12 || i4 == 15) {
                    e(h71Var, i4);
                } else if (i4 == 7) {
                    h(h71Var);
                } else if (i4 == 10) {
                    l(h71Var);
                } else {
                    k(h71Var);
                }
            } else if (!m(h71Var)) {
                a();
                if (!z3) {
                    return;
                }
                r();
            }
            h71Var.n(this.j);
            w(h71Var);
        }
        a();
        if (!z3) {
            return;
        }
        r();
    }

    public static ByteOrder s(d71 d71Var) throws IOException {
        short s2 = d71Var.readShort();
        boolean z2 = o;
        if (s2 == 18761) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 != 19789) {
            a.f(Integer.toHexString(s2), "Invalid byte order: ");
            return null;
        }
        if (z2) {
            Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.f;
        if (strB != null && b("DateTime") == null) {
            mapArr[0].put("DateTime", e71.a(strB));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", e71.b(0L, this.h));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", e71.b(0L, this.h));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", e71.b(0L, this.h));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", e71.b(0L, this.h));
        }
    }

    public final String b(String str) {
        if (str == null) {
            zo2.n("tag shouldn't be null");
            return null;
        }
        e71 e71VarD = d(str);
        if (e71VarD != null) {
            int i = e71VarD.a;
            if (str.equals("GPSTimeStamp")) {
                if (i != 5 && i != 10) {
                    a1.n("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                g71[] g71VarArr = (g71[]) e71VarD.h(this.h);
                if (g71VarArr == null || g71VarArr.length != 3) {
                    a1.n("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(g71VarArr));
                    return null;
                }
                g71 g71Var = g71VarArr[0];
                Integer numValueOf = Integer.valueOf((int) (g71Var.a / g71Var.b));
                g71 g71Var2 = g71VarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (g71Var2.a / g71Var2.b));
                g71 g71Var3 = g71VarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (g71Var3.a / g71Var3.b)));
            }
            boolean zContains = M.contains(str);
            ByteOrder byteOrder = this.h;
            if (!zContains) {
                return e71VarD.g(byteOrder);
            }
            try {
                return Double.toString(e71VarD.e(byteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int c(int i, String str) {
        e71 e71VarD = d(str);
        if (e71VarD != null) {
            try {
                return e71VarD.f(this.h);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public final e71 d(String str) {
        e71 e71Var;
        int i;
        e71 e71Var2;
        if (str == null) {
            zo2.n("tag shouldn't be null");
            return null;
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (o) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        if ("Xmp".equals(str) && (i = this.d) != 4 && ((i == 9 || i == 15 || i == 12 || i == 13) && (e71Var2 = this.n) != null)) {
            return e71Var2;
        }
        for (int i2 = 0; i2 < I.length; i2++) {
            e71 e71Var3 = (e71) this.f[i2].get(str);
            if (e71Var3 != null) {
                return e71Var3;
            }
        }
        if (!"Xmp".equals(str) || (e71Var = this.n) == null) {
            return null;
        }
        return e71Var;
    }

    public final void e(h71 h71Var, int i) {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            vp1.n("Reading EXIF from HEIC files is supported from SDK 28 and above");
            return;
        }
        if (i == 15 && i2 < 31) {
            vp1.n("Reading EXIF from AVIF files is supported from SDK 31 and above");
            return;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(new c71(h71Var));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.f;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", e71.d(Integer.parseInt(strExtractMetadata), this.h));
                }
                if (strExtractMetadata3 != null) {
                    mapArr[0].put("ImageLength", e71.d(Integer.parseInt(strExtractMetadata3), this.h));
                }
                if (strExtractMetadata2 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata2);
                    mapArr[0].put("Orientation", e71.d(i3 != 90 ? i3 != 180 ? i3 != 270 ? 1 : 8 : 3 : 6, this.h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i4 = Integer.parseInt(strExtractMetadata4);
                    int i5 = Integer.parseInt(strExtractMetadata5);
                    if (i5 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    h71Var.n(i4);
                    byte[] bArr = new byte[6];
                    h71Var.readFully(bArr);
                    int i6 = i4 + 6;
                    int i7 = i5 - 6;
                    if (!Arrays.equals(bArr, P)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i7];
                    h71Var.readFully(bArr2);
                    this.j = i6;
                    t(0, bArr2);
                }
                String strExtractMetadata8 = mediaMetadataRetriever.extractMetadata(41);
                String strExtractMetadata9 = mediaMetadataRetriever.extractMetadata(42);
                if (strExtractMetadata8 != null && strExtractMetadata9 != null) {
                    int i8 = Integer.parseInt(strExtractMetadata8);
                    int i9 = Integer.parseInt(strExtractMetadata9);
                    long j = i8;
                    h71Var.n(j);
                    byte[] bArr3 = new byte[i9];
                    h71Var.readFully(bArr3);
                    this.n = new e71(1, j, i9, bArr3);
                }
                if (o) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata3 + ", rotation " + strExtractMetadata2);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
            } finally {
            }
        } catch (RuntimeException e) {
            throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00a1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x00a4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x00a7. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014b A[LOOP:0: B:10:0x0033->B:56:0x014b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0151 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(defpackage.d71 r20, int r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i71.f(d71, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d9 A[PHI: r7 r20
      0x00d9: PHI (r7v3 d71) = (r7v4 d71), (r7v7 d71), (r7v7 d71) binds: [B:73:0x00f4, B:65:0x00df, B:62:0x00d7] A[DONT_GENERATE, DONT_INLINE]
      0x00d9: PHI (r20v2 int) = (r20v4 int), (r20v7 int), (r20v8 int) binds: [B:73:0x00f4, B:65:0x00df, B:62:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ed A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #2 {all -> 0x0066, blocks: (B:14:0x0039, B:19:0x005b, B:30:0x0078, B:33:0x007e, B:34:0x0086, B:37:0x008e, B:42:0x009a, B:45:0x00a4, B:48:0x00ae, B:50:0x00b6, B:70:0x00e9, B:72:0x00ed), top: B:155:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(BufferedInputStream bufferedInputStream) throws Throwable {
        int i;
        d71 d71Var;
        int i2;
        d71 d71Var2;
        int i3;
        int i4;
        long j;
        byte[] bArr;
        long j2;
        bufferedInputStream.mark(5000);
        byte[] bArr2 = new byte[5000];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i5 = 0;
        while (true) {
            byte[] bArr3 = r;
            if (i5 >= bArr3.length) {
                return 4;
            }
            if (bArr2[i5] != bArr3[i5]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i6 = 0; i6 < bytes.length; i6++) {
                    if (bArr2[i6] != bytes[i6]) {
                        d71 d71Var3 = null;
                        try {
                            d71Var = new d71(bArr2);
                            try {
                                try {
                                    j = d71Var.readInt();
                                    bArr = new byte[4];
                                    d71Var.readFully(bArr);
                                } catch (Exception e) {
                                    e = e;
                                    i = 0;
                                }
                            } catch (Throwable th) {
                                th = th;
                                d71Var3 = d71Var;
                                if (d71Var3 != null) {
                                    d71Var3.close();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i = 0;
                            d71Var = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (d71Var3 != null) {
                            }
                            throw th;
                        }
                        if (Arrays.equals(bArr, s)) {
                            if (j == 1) {
                                j = d71Var.readLong();
                                j2 = 16;
                                if (j < 16) {
                                }
                                d71Var.close();
                                i = 0;
                                i2 = 0;
                            } else {
                                j2 = 8;
                            }
                            if (j > 5000) {
                                j = 5000;
                            }
                            long j3 = j - j2;
                            if (j3 < 8) {
                                d71Var.close();
                                i = 0;
                                i2 = 0;
                            } else {
                                byte[] bArr4 = new byte[4];
                                boolean z2 = false;
                                boolean z3 = false;
                                boolean z4 = false;
                                for (long j4 = 0; j4 < j3 / 4; j4++) {
                                    try {
                                        d71Var.readFully(bArr4);
                                        if (j4 != 1) {
                                            i = 0;
                                            try {
                                                if (Arrays.equals(bArr4, t)) {
                                                    z2 = true;
                                                } else if (Arrays.equals(bArr4, u)) {
                                                    z3 = true;
                                                } else if (Arrays.equals(bArr4, v) || Arrays.equals(bArr4, w)) {
                                                    z4 = true;
                                                }
                                                if (z2) {
                                                    if (z3) {
                                                        d71Var.close();
                                                        i2 = 12;
                                                        break;
                                                    }
                                                    if (z4) {
                                                        d71Var.close();
                                                        i2 = 15;
                                                        break;
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                if (o) {
                                                }
                                                if (d71Var != null) {
                                                }
                                                i2 = i;
                                            }
                                        }
                                    } catch (EOFException unused) {
                                        i = 0;
                                        d71Var.close();
                                        i2 = i;
                                    }
                                }
                                i = 0;
                                d71Var.close();
                                i2 = i;
                            }
                            if (o) {
                                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                            }
                            if (d71Var != null) {
                                d71Var.close();
                            }
                            i2 = i;
                        } else {
                            d71Var.close();
                            i = 0;
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            return i2;
                        }
                        try {
                            d71Var2 = new d71(bArr2);
                            try {
                                ByteOrder byteOrderS = s(d71Var2);
                                this.h = byteOrderS;
                                d71Var2.z = byteOrderS;
                                short s2 = d71Var2.readShort();
                                i3 = (s2 == 20306 || s2 == 21330) ? 1 : i;
                                d71Var2.close();
                            } catch (Exception unused2) {
                                if (d71Var2 != null) {
                                    d71Var2.close();
                                }
                                i3 = i;
                            } catch (Throwable th3) {
                                th = th3;
                                d71Var3 = d71Var2;
                                if (d71Var3 != null) {
                                    d71Var3.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused3) {
                            d71Var2 = null;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        if (i3 != 0) {
                            return 7;
                        }
                        try {
                            d71 d71Var4 = new d71(bArr2);
                            try {
                                ByteOrder byteOrderS2 = s(d71Var4);
                                this.h = byteOrderS2;
                                d71Var4.z = byteOrderS2;
                                i4 = d71Var4.readShort() != 85 ? i : 1;
                                d71Var4.close();
                            } catch (Exception unused4) {
                                d71Var3 = d71Var4;
                                if (d71Var3 != null) {
                                    d71Var3.close();
                                }
                                i4 = i;
                            } catch (Throwable th5) {
                                th = th5;
                                d71Var3 = d71Var4;
                                if (d71Var3 != null) {
                                    d71Var3.close();
                                }
                                throw th;
                            }
                        } catch (Exception unused5) {
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        if (i4 != 0) {
                            return 10;
                        }
                        int i7 = i;
                        while (true) {
                            byte[] bArr5 = z;
                            if (i7 >= bArr5.length) {
                                return 13;
                            }
                            if (bArr2[i7] != bArr5[i7]) {
                                int i8 = i;
                                while (true) {
                                    byte[] bArr6 = B;
                                    if (i8 >= bArr6.length) {
                                        int i9 = i;
                                        while (true) {
                                            byte[] bArr7 = C;
                                            if (i9 >= bArr7.length) {
                                                return 14;
                                            }
                                            if (bArr2[bArr6.length + i9 + 4] != bArr7[i9]) {
                                                break;
                                            }
                                            i9++;
                                        }
                                    } else {
                                        if (bArr2[i8] != bArr6[i8]) {
                                            break;
                                        }
                                        i8++;
                                    }
                                }
                                return i;
                            }
                            i7++;
                        }
                    }
                }
                return 9;
            }
            i5++;
        }
    }

    public final void h(h71 h71Var) throws IOException {
        int i;
        int i2;
        k(h71Var);
        HashMap[] mapArr = this.f;
        e71 e71Var = (e71) mapArr[1].get("MakerNote");
        if (e71Var != null) {
            h71 h71Var2 = new h71(e71Var.d);
            h71Var2.z = this.h;
            byte[] bArr = x;
            byte[] bArr2 = new byte[bArr.length];
            h71Var2.readFully(bArr2);
            h71Var2.n(0L);
            byte[] bArr3 = y;
            byte[] bArr4 = new byte[bArr3.length];
            h71Var2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                h71Var2.n(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                h71Var2.n(12L);
            }
            u(h71Var2, 6);
            e71 e71Var2 = (e71) mapArr[7].get("PreviewImageStart");
            e71 e71Var3 = (e71) mapArr[7].get("PreviewImageLength");
            if (e71Var2 != null && e71Var3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", e71Var2);
                mapArr[5].put("JPEGInterchangeFormatLength", e71Var3);
            }
            e71 e71Var4 = (e71) mapArr[8].get("AspectFrame");
            if (e71Var4 != null) {
                int[] iArr = (int[]) e71Var4.h(this.h);
                if (iArr == null || iArr.length != 4) {
                    a1.n("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                e71 e71VarD = e71.d(i5, this.h);
                e71 e71VarD2 = e71.d(i6, this.h);
                mapArr[0].put("ImageWidth", e71VarD);
                mapArr[0].put("ImageLength", e71VarD2);
            }
        }
    }

    public final void i(d71 d71Var) throws IOException {
        if (o) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + d71Var);
        }
        d71Var.z = ByteOrder.BIG_ENDIAN;
        int i = d71Var.f;
        d71Var.g(z.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (z2 && z3) {
                return;
            }
            try {
                int i2 = d71Var.readInt();
                int i3 = d71Var.readInt();
                int i4 = d71Var.f;
                int i5 = i4 + i2 + 4;
                int i6 = i4 - i;
                if (i6 == 16 && i3 != 1229472850) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appear as the first chunk");
                }
                if (i3 == 1229278788) {
                    return;
                }
                if (i3 == 1700284774 && !z2) {
                    this.j = i6;
                    byte[] bArr = new byte[i2];
                    d71Var.readFully(bArr);
                    int i7 = d71Var.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(i3 >>> 24);
                    crc32.update(i3 >>> 16);
                    crc32.update(i3 >>> 8);
                    crc32.update(i3);
                    crc32.update(bArr);
                    if (((int) crc32.getValue()) != i7) {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i7 + ", calculated CRC value: " + crc32.getValue());
                    }
                    t(0, bArr);
                    z();
                    w(new d71(bArr));
                    z2 = true;
                } else if (i3 == 1767135348 && !z3) {
                    byte[] bArr2 = A;
                    if (i2 >= bArr2.length) {
                        int length = bArr2.length;
                        byte[] bArr3 = new byte[length];
                        d71Var.readFully(bArr3);
                        if (Arrays.equals(bArr3, bArr2)) {
                            int i8 = d71Var.f - i;
                            int i9 = i2 - length;
                            byte[] bArr4 = new byte[i9];
                            d71Var.readFully(bArr4);
                            this.n = new e71(1, i8, i9, bArr4);
                            z3 = true;
                        }
                    }
                }
                d71Var.g(i5 - d71Var.f);
            } catch (EOFException e) {
                throw new IOException("Encountered corrupt PNG file.", e);
            }
        }
    }

    public final void j(d71 d71Var) throws IOException {
        boolean z2 = o;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + d71Var);
        }
        d71Var.g(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        d71Var.readFully(bArr);
        d71Var.readFully(bArr2);
        d71Var.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        d71Var.g(i - d71Var.f);
        d71Var.readFully(bArr4);
        f(new d71(bArr4), i, 5);
        d71Var.g(i3 - d71Var.f);
        d71Var.z = ByteOrder.BIG_ENDIAN;
        int i4 = d71Var.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = d71Var.readUnsignedShort();
            int unsignedShort2 = d71Var.readUnsignedShort();
            if (unsignedShort == H.a) {
                short s2 = d71Var.readShort();
                short s3 = d71Var.readShort();
                e71 e71VarD = e71.d(s2, this.h);
                e71 e71VarD2 = e71.d(s3, this.h);
                HashMap[] mapArr = this.f;
                mapArr[0].put("ImageLength", e71VarD);
                mapArr[0].put("ImageWidth", e71VarD2);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s2) + ", width: " + ((int) s3));
                    return;
                }
                return;
            }
            d71Var.g(unsignedShort2);
        }
    }

    public final void k(h71 h71Var) throws IOException {
        q(h71Var);
        u(h71Var, 0);
        y(h71Var, 0);
        y(h71Var, 5);
        y(h71Var, 4);
        z();
        if (this.d == 8) {
            HashMap[] mapArr = this.f;
            e71 e71Var = (e71) mapArr[1].get("MakerNote");
            if (e71Var != null) {
                h71 h71Var2 = new h71(e71Var.d);
                h71Var2.z = this.h;
                h71Var2.g(6);
                u(h71Var2, 9);
                e71 e71Var2 = (e71) mapArr[9].get("ColorSpace");
                if (e71Var2 != null) {
                    mapArr[1].put("ColorSpace", e71Var2);
                }
            }
        }
    }

    public final void l(h71 h71Var) throws IOException {
        if (o) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + h71Var);
        }
        k(h71Var);
        HashMap[] mapArr = this.f;
        e71 e71Var = (e71) mapArr[0].get("JpgFromRaw");
        if (e71Var != null) {
            f(new d71(e71Var.d), (int) e71Var.c, 5);
        }
        e71 e71Var2 = (e71) mapArr[0].get("ISO");
        e71 e71Var3 = (e71) mapArr[1].get("PhotographicSensitivity");
        if (e71Var2 == null || e71Var3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", e71Var2);
    }

    public final boolean m(h71 h71Var) throws IOException {
        byte[] bArr = P;
        byte[] bArr2 = new byte[bArr.length];
        h71Var.readFully(bArr2);
        if (!Arrays.equals(bArr2, bArr)) {
            a1.n("ExifInterface", "Given data is not EXIF-only.");
            return false;
        }
        byte[] bArrCopyOf = new byte[1024];
        int i = 0;
        while (true) {
            if (i == bArrCopyOf.length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
            }
            int i2 = h71Var.b.read(bArrCopyOf, i, bArrCopyOf.length - i);
            if (i2 == -1) {
                byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i);
                this.j = bArr.length;
                t(0, bArrCopyOf2);
                return true;
            }
            i += i2;
            h71Var.f += i2;
        }
    }

    public final void n(d71 d71Var) throws IOException {
        if (o) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + d71Var);
        }
        d71Var.z = ByteOrder.LITTLE_ENDIAN;
        d71Var.g(B.length);
        int i = d71Var.readInt() + 8;
        byte[] bArr = C;
        d71Var.g(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                d71Var.readFully(bArr2);
                int i2 = d71Var.readInt();
                int i3 = length + 8;
                if (Arrays.equals(D, bArr2)) {
                    byte[] bArrCopyOfRange = new byte[i2];
                    d71Var.readFully(bArrCopyOfRange);
                    byte[] bArr3 = P;
                    if (l72.Y(bArrCopyOfRange, bArr3)) {
                        bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOfRange, bArr3.length, i2);
                    }
                    this.j = i3;
                    t(0, bArrCopyOfRange);
                    w(new d71(bArrCopyOfRange));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                d71Var.g(i2);
            } catch (EOFException e) {
                throw new IOException("Encountered corrupt WebP file.", e);
            }
        }
    }

    public final void o(d71 d71Var, HashMap map) throws IOException {
        e71 e71Var = (e71) map.get("JPEGInterchangeFormat");
        e71 e71Var2 = (e71) map.get("JPEGInterchangeFormatLength");
        if (e71Var == null || e71Var2 == null) {
            return;
        }
        int iF = e71Var.f(this.h);
        int iF2 = e71Var2.f(this.h);
        if (this.d == 7) {
            iF += this.k;
        }
        if (iF > 0 && iF2 > 0 && this.a == null && this.c == null && this.b == null) {
            d71Var.g(iF);
            d71Var.readFully(new byte[iF2]);
        }
        if (o) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iF + ", length: " + iF2);
        }
    }

    public final boolean p(HashMap map) {
        e71 e71Var = (e71) map.get("ImageLength");
        e71 e71Var2 = (e71) map.get("ImageWidth");
        if (e71Var == null || e71Var2 == null) {
            return false;
        }
        return e71Var.f(this.h) <= 512 && e71Var2.f(this.h) <= 512;
    }

    public final void q(h71 h71Var) throws IOException {
        ByteOrder byteOrderS = s(h71Var);
        this.h = byteOrderS;
        h71Var.z = byteOrderS;
        int unsignedShort = h71Var.readUnsignedShort();
        int i = this.d;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            a.f(Integer.toHexString(unsignedShort), "Invalid start code: ");
            return;
        }
        int i2 = h71Var.readInt();
        if (i2 < 8) {
            vp1.i(dw2.A(i2, "Invalid first Ifd offset: "));
            return;
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            h71Var.g(i3);
        }
    }

    public final void r() {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.f;
            if (i >= mapArr.length) {
                return;
            }
            StringBuilder sbD = dw2.D("The size of tag group[", i, "]: ");
            sbD.append(mapArr[i].size());
            Log.d("ExifInterface", sbD.toString());
            for (Map.Entry entry : mapArr[i].entrySet()) {
                e71 e71Var = (e71) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + e71Var.toString() + ", tagValue: '" + e71Var.g(this.h) + "'");
            }
            i++;
        }
    }

    public final void t(int i, byte[] bArr) throws IOException {
        h71 h71Var = new h71(bArr);
        q(h71Var);
        u(h71Var, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(h71 h71Var, int i) throws IOException {
        HashMap[] mapArr;
        boolean z2;
        int i2;
        int i3;
        long j;
        long j2;
        boolean z3;
        int i4;
        short s2;
        long j3;
        int i5;
        HashMap[] mapArr2;
        int unsignedShort;
        long j4;
        int i6 = i;
        int i7 = h71Var.f;
        int i8 = h71Var.X;
        Integer numValueOf = Integer.valueOf(i7);
        HashSet hashSet = this.g;
        hashSet.add(numValueOf);
        short s3 = h71Var.readShort();
        boolean z4 = o;
        if (z4) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s3));
        }
        if (s3 <= 0) {
            return;
        }
        short s4 = 0;
        while (true) {
            mapArr = this.f;
            if (s4 >= s3) {
                break;
            }
            int unsignedShort2 = h71Var.readUnsignedShort();
            int unsignedShort3 = h71Var.readUnsignedShort();
            int i9 = h71Var.readInt();
            long j5 = ((long) h71Var.f) + 4;
            short s5 = s3;
            f71 f71Var = (f71) K[i6].get(Integer.valueOf(unsignedShort2));
            if (z4) {
                i2 = 3;
                z2 = z4;
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i6), Integer.valueOf(unsignedShort2), f71Var != null ? f71Var.b : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i9)));
            } else {
                z2 = z4;
                i2 = 3;
            }
            if (f71Var == null) {
                if (z2) {
                    Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
                }
                i3 = unsignedShort2;
            } else {
                if (unsignedShort3 > 0) {
                    int[] iArr = F;
                    if (unsignedShort3 >= iArr.length) {
                        i3 = unsignedShort2;
                        if (z2) {
                            Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                        }
                    } else {
                        int i10 = f71Var.c;
                        if (i10 == 7 || unsignedShort3 == 7 || i10 == unsignedShort3 || (i4 = f71Var.d) == unsignedShort3) {
                            i3 = unsignedShort2;
                        } else {
                            i3 = unsignedShort2;
                            if (((i10 != 4 && i4 != 4) || unsignedShort3 != i2) && (((i10 != 9 && i4 != 9) || unsignedShort3 != 8) && ((i10 != 12 && i4 != 12) || unsignedShort3 != 11))) {
                                if (z2) {
                                    Log.d("ExifInterface", "Skip the tag entry since data format (" + E[unsignedShort3] + ") is unexpected for tag: " + f71Var.b);
                                }
                            }
                        }
                        if (unsignedShort3 == 7) {
                            unsignedShort3 = i10;
                        }
                        j = ((long) iArr[unsignedShort3]) * ((long) i9);
                        if (j < 0 || j > 2147483647L) {
                            if (z2) {
                                j2 = j;
                                Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i9);
                            } else {
                                j2 = j;
                            }
                            z3 = false;
                            j = j2;
                        } else {
                            z3 = true;
                        }
                    }
                }
                if (z3) {
                    h71Var.n(j5);
                    s2 = s4;
                } else {
                    s2 = s4;
                    if (j > 4) {
                        int i11 = h71Var.readInt();
                        if (z2) {
                            mapArr2 = mapArr;
                            j3 = j5;
                            Log.d("ExifInterface", "seek to data offset: " + i11);
                        } else {
                            j3 = j5;
                            mapArr2 = mapArr;
                        }
                        if (this.d != 7) {
                            i5 = i9;
                            h71Var.n(i11);
                        } else {
                            if ("MakerNote".equals(f71Var.b)) {
                                this.k = i11;
                            } else {
                                if (i6 == 6 && "ThumbnailImage".equals(f71Var.b)) {
                                    this.l = i11;
                                    this.m = i9;
                                    e71 e71VarD = e71.d(6, this.h);
                                    i5 = i9;
                                    e71 e71VarB = e71.b(this.l, this.h);
                                    e71 e71VarB2 = e71.b(this.m, this.h);
                                    mapArr2[4].put("Compression", e71VarD);
                                    mapArr2[4].put("JPEGInterchangeFormat", e71VarB);
                                    mapArr2[4].put("JPEGInterchangeFormatLength", e71VarB2);
                                }
                                h71Var.n(i11);
                            }
                            i5 = i9;
                            h71Var.n(i11);
                        }
                    } else {
                        j3 = j5;
                        i5 = i9;
                        mapArr2 = mapArr;
                    }
                    Integer num = (Integer) N.get(Integer.valueOf(i3));
                    if (z2) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                    }
                    if (num != null) {
                        if (unsignedShort3 != 3) {
                            if (unsignedShort3 == 4) {
                                j4 = ((long) h71Var.readInt()) & 4294967295L;
                            } else if (unsignedShort3 == 8) {
                                unsignedShort = h71Var.readShort();
                            } else if (unsignedShort3 == 9 || unsignedShort3 == 13) {
                                unsignedShort = h71Var.readInt();
                            } else {
                                j4 = -1;
                            }
                            if (z2) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(j4), f71Var.b));
                            }
                            if (j4 > 0 || (i8 != -1 && j4 >= i8)) {
                                if (z2) {
                                    String strJ = ha0.j(j4, "Skip jump into the IFD since its offset is invalid: ");
                                    if (i8 != -1) {
                                        strJ = strJ + " (total length: " + i8 + ")";
                                    }
                                    Log.d("ExifInterface", strJ);
                                }
                            } else if (!hashSet.contains(Integer.valueOf((int) j4))) {
                                h71Var.n(j4);
                                u(h71Var, num.intValue());
                            } else if (z2) {
                                Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j4 + ")");
                            }
                            h71Var.n(j3);
                        } else {
                            unsignedShort = h71Var.readUnsignedShort();
                        }
                        j4 = unsignedShort;
                        if (z2) {
                        }
                        if (j4 > 0) {
                            if (z2) {
                            }
                            h71Var.n(j3);
                        }
                    } else {
                        long j6 = j3;
                        int i12 = h71Var.f + this.j;
                        byte[] bArr = new byte[(int) j];
                        h71Var.readFully(bArr);
                        e71 e71Var = new e71(unsignedShort3, i12, i5, bArr);
                        HashMap map = mapArr2[i];
                        String str = f71Var.b;
                        map.put(str, e71Var);
                        if ("DNGVersion".equals(str)) {
                            this.d = 3;
                        }
                        if ((("Make".equals(str) || "Model".equals(str)) && e71Var.g(this.h).contains("PENTAX")) || ("Compression".equals(str) && e71Var.f(this.h) == 65535)) {
                            this.d = 8;
                        }
                        if (h71Var.f != j6) {
                            h71Var.n(j6);
                        }
                    }
                }
                s4 = (short) (s2 + 1);
                i6 = i;
                s3 = s5;
                z4 = z2;
            }
            z3 = false;
            j = 0;
            if (z3) {
            }
            s4 = (short) (s2 + 1);
            i6 = i;
            s3 = s5;
            z4 = z2;
        }
        boolean z5 = z4;
        int i13 = h71Var.readInt();
        if (z5) {
            Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i13)));
        }
        long j7 = i13;
        if (j7 <= 0) {
            if (z5) {
                Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i13);
                return;
            }
            return;
        }
        if (hashSet.contains(Integer.valueOf(i13))) {
            if (z5) {
                Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i13);
                return;
            }
            return;
        }
        h71Var.n(j7);
        if (mapArr[4].isEmpty()) {
            u(h71Var, 4);
        } else if (mapArr[5].isEmpty()) {
            u(h71Var, 5);
        }
    }

    public final void v(String str, int i, String str2) {
        HashMap[] mapArr = this.f;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, (e71) map.get(str));
        mapArr[i].remove(str);
    }

    public final void w(d71 d71Var) throws IOException {
        e71 e71Var;
        int iF;
        HashMap map = this.f[4];
        e71 e71Var2 = (e71) map.get("Compression");
        if (e71Var2 == null) {
            o(d71Var, map);
            return;
        }
        int iF2 = e71Var2.f(this.h);
        if (iF2 != 1) {
            if (iF2 == 6) {
                o(d71Var, map);
                return;
            } else if (iF2 != 7) {
                return;
            }
        }
        e71 e71Var3 = (e71) map.get("BitsPerSample");
        if (e71Var3 != null) {
            int[] iArr = (int[]) e71Var3.h(this.h);
            int[] iArr2 = p;
            if (Arrays.equals(iArr2, iArr) || (this.d == 3 && (e71Var = (e71) map.get("PhotometricInterpretation")) != null && (((iF = e71Var.f(this.h)) == 1 && Arrays.equals(iArr, q)) || (iF == 6 && Arrays.equals(iArr, iArr2))))) {
                e71 e71Var4 = (e71) map.get("StripOffsets");
                e71 e71Var5 = (e71) map.get("StripByteCounts");
                if (e71Var4 == null || e71Var5 == null) {
                    return;
                }
                long[] jArrG = l72.g(e71Var4.h(this.h));
                long[] jArrG2 = l72.g(e71Var5.h(this.h));
                if (jArrG == null || jArrG.length == 0) {
                    a1.n("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrG2 == null || jArrG2.length == 0) {
                    a1.n("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrG.length != jArrG2.length) {
                    a1.n("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j = 0;
                for (long j2 : jArrG2) {
                    j += j2;
                }
                byte[] bArr = new byte[(int) j];
                this.i = true;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < jArrG.length; i3++) {
                    int i4 = (int) jArrG[i3];
                    int i5 = (int) jArrG2[i3];
                    if (i3 < jArrG.length - 1 && i4 + i5 != jArrG[i3 + 1]) {
                        this.i = false;
                    }
                    int i6 = i4 - i;
                    if (i6 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    try {
                        d71Var.g(i6);
                        int i7 = i + i6;
                        byte[] bArr2 = new byte[i5];
                        try {
                            d71Var.readFully(bArr2);
                            i = i7 + i5;
                            System.arraycopy(bArr2, 0, bArr, i2, i5);
                            i2 += i5;
                        } catch (EOFException unused) {
                            Log.d("ExifInterface", "Failed to read " + i5 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d("ExifInterface", "Failed to skip " + i6 + " bytes.");
                        return;
                    }
                }
                if (this.i) {
                    long j3 = jArrG[0];
                    return;
                }
                return;
            }
        }
        if (o) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void x(int i, int i2) {
        HashMap[] mapArr = this.f;
        boolean zIsEmpty = mapArr[i].isEmpty();
        boolean z2 = o;
        if (zIsEmpty || mapArr[i2].isEmpty()) {
            if (z2) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        e71 e71Var = (e71) mapArr[i].get("ImageLength");
        e71 e71Var2 = (e71) mapArr[i].get("ImageWidth");
        e71 e71Var3 = (e71) mapArr[i2].get("ImageLength");
        e71 e71Var4 = (e71) mapArr[i2].get("ImageWidth");
        if (e71Var == null || e71Var2 == null) {
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (e71Var3 == null || e71Var4 == null) {
            if (z2) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iF = e71Var.f(this.h);
        int iF2 = e71Var2.f(this.h);
        int iF3 = e71Var3.f(this.h);
        int iF4 = e71Var4.f(this.h);
        if (iF >= iF3 || iF2 >= iF4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void y(h71 h71Var, int i) throws IOException {
        e71 e71VarD;
        e71 e71VarD2;
        HashMap[] mapArr = this.f;
        e71 e71Var = (e71) mapArr[i].get("DefaultCropSize");
        e71 e71Var2 = (e71) mapArr[i].get("SensorTopBorder");
        e71 e71Var3 = (e71) mapArr[i].get("SensorLeftBorder");
        e71 e71Var4 = (e71) mapArr[i].get("SensorBottomBorder");
        e71 e71Var5 = (e71) mapArr[i].get("SensorRightBorder");
        if (e71Var != null) {
            int i2 = e71Var.a;
            ByteOrder byteOrder = this.h;
            if (i2 == 5) {
                g71[] g71VarArr = (g71[]) e71Var.h(byteOrder);
                if (g71VarArr == null || g71VarArr.length != 2) {
                    a1.n("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(g71VarArr));
                    return;
                } else {
                    e71VarD = e71.c(new g71[]{g71VarArr[0]}, this.h);
                    e71VarD2 = e71.c(new g71[]{g71VarArr[1]}, this.h);
                }
            } else {
                int[] iArr = (int[]) e71Var.h(byteOrder);
                if (iArr == null || iArr.length != 2) {
                    a1.n("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                e71VarD = e71.d(iArr[0], this.h);
                e71VarD2 = e71.d(iArr[1], this.h);
            }
            mapArr[i].put("ImageWidth", e71VarD);
            mapArr[i].put("ImageLength", e71VarD2);
            return;
        }
        if (e71Var2 != null && e71Var3 != null && e71Var4 != null && e71Var5 != null) {
            int iF = e71Var2.f(this.h);
            int iF2 = e71Var4.f(this.h);
            int iF3 = e71Var5.f(this.h);
            int iF4 = e71Var3.f(this.h);
            if (iF2 <= iF || iF3 <= iF4) {
                return;
            }
            e71 e71VarD3 = e71.d(iF2 - iF, this.h);
            e71 e71VarD4 = e71.d(iF3 - iF4, this.h);
            mapArr[i].put("ImageLength", e71VarD3);
            mapArr[i].put("ImageWidth", e71VarD4);
            return;
        }
        e71 e71Var6 = (e71) mapArr[i].get("ImageLength");
        e71 e71Var7 = (e71) mapArr[i].get("ImageWidth");
        if (e71Var6 == null || e71Var7 == null) {
            e71 e71Var8 = (e71) mapArr[i].get("JPEGInterchangeFormat");
            e71 e71Var9 = (e71) mapArr[i].get("JPEGInterchangeFormatLength");
            if (e71Var8 == null || e71Var9 == null) {
                return;
            }
            int iF5 = e71Var8.f(this.h);
            int iF6 = e71Var8.f(this.h);
            h71Var.n(iF5);
            byte[] bArr = new byte[iF6];
            h71Var.readFully(bArr);
            f(new d71(bArr), iF5, i);
        }
    }

    public final void z() {
        x(0, 5);
        x(0, 4);
        x(5, 4);
        HashMap[] mapArr = this.f;
        e71 e71Var = (e71) mapArr[1].get("PixelXDimension");
        e71 e71Var2 = (e71) mapArr[1].get("PixelYDimension");
        if (e71Var != null && e71Var2 != null) {
            mapArr[0].put("ImageWidth", e71Var);
            mapArr[0].put("ImageLength", e71Var2);
        }
        if (mapArr[4].isEmpty() && p(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!p(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        v("ThumbnailOrientation", 0, "Orientation");
        v("ThumbnailImageLength", 0, "ImageLength");
        v("ThumbnailImageWidth", 0, "ImageWidth");
        v("ThumbnailOrientation", 5, "Orientation");
        v("ThumbnailImageLength", 5, "ImageLength");
        v("ThumbnailImageWidth", 5, "ImageWidth");
        v("Orientation", 4, "ThumbnailOrientation");
        v("ImageLength", 4, "ThumbnailImageLength");
        v("ImageWidth", 4, "ThumbnailImageWidth");
    }
}
