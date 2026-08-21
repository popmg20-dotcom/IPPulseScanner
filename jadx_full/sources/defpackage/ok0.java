package defpackage;

import android.os.Process;
import android.util.Base64;
import com.tencent.mars.xlog.Xlog;
import io.netty.util.internal.StringUtil;
import io.sentry.android.core.a1;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ok0 {
    public static final uh3 a = new uh3("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    public static final uh3 b = new uh3("^[0-9a-fA-F]{64}(,[0-9a-fA-F]{64})*$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0efb, code lost:
    
        if (r1.equals("reject") != false) goto L619;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1093:0x19fb A[Catch: Exception -> 0x004a, TryCatch #4 {Exception -> 0x004a, blocks: (B:3:0x0034, B:5:0x003e, B:10:0x0054, B:14:0x00cc, B:17:0x00d8, B:500:0x0c71, B:502:0x0c95, B:586:0x0e55, B:505:0x0ca2, B:507:0x0cac, B:508:0x0cbb, B:510:0x0cc5, B:512:0x0cd0, B:514:0x0cda, B:518:0x0ce7, B:520:0x0cf3, B:522:0x0d08, B:524:0x0d33, B:526:0x0d41, B:528:0x0d45, B:531:0x0d54, B:533:0x0d61, B:535:0x0d67, B:537:0x0d6f, B:539:0x0d84, B:541:0x0da9, B:543:0x0db7, B:545:0x0dbb, B:548:0x0dc7, B:550:0x0dd1, B:551:0x0dd9, B:553:0x0de3, B:554:0x0deb, B:556:0x0df7, B:558:0x0e01, B:560:0x0e07, B:563:0x0e14, B:570:0x0e27, B:572:0x0e2e, B:576:0x0e38, B:582:0x0e45, B:585:0x0e4f, B:588:0x0e62, B:592:0x0e6c, B:594:0x0e72, B:598:0x0e8e, B:600:0x0e96, B:604:0x0ead, B:606:0x0eb3, B:608:0x0ec9, B:610:0x0edf, B:612:0x0eeb, B:20:0x00f6, B:22:0x00fe, B:26:0x011c, B:28:0x0134, B:153:0x040d, B:34:0x0154, B:36:0x0160, B:40:0x017a, B:42:0x0184, B:45:0x0193, B:47:0x019d, B:48:0x01a4, B:50:0x01ae, B:54:0x01ba, B:56:0x01c4, B:58:0x01ca, B:59:0x01da, B:61:0x01e0, B:63:0x01f9, B:65:0x0215, B:67:0x0221, B:68:0x0229, B:70:0x0233, B:74:0x0240, B:76:0x024c, B:78:0x0261, B:80:0x0288, B:82:0x0296, B:84:0x029a, B:90:0x02be, B:98:0x02ec, B:106:0x0324, B:112:0x033d, B:114:0x0348, B:116:0x0360, B:118:0x036c, B:119:0x037b, B:121:0x0389, B:122:0x0397, B:124:0x03a5, B:126:0x03ad, B:129:0x03be, B:136:0x03d7, B:141:0x03e7, B:145:0x03f3, B:157:0x042d, B:159:0x0435, B:164:0x044b, B:166:0x0477, B:168:0x0489, B:170:0x0497, B:232:0x05e5, B:173:0x04b5, B:175:0x04c1, B:176:0x04d5, B:178:0x04df, B:180:0x04e7, B:187:0x0512, B:189:0x051c, B:190:0x052b, B:192:0x0539, B:193:0x0547, B:195:0x0555, B:196:0x055e, B:198:0x056c, B:199:0x0572, B:201:0x057c, B:202:0x0584, B:204:0x058e, B:206:0x0594, B:209:0x05a1, B:216:0x05b6, B:218:0x05bd, B:222:0x05c7, B:231:0x05e0, B:233:0x05f6, B:238:0x0627, B:240:0x062b, B:244:0x064c, B:247:0x066d, B:1091:0x19ea, B:1093:0x19fb, B:1153:0x1b1c, B:1097:0x1a10, B:1099:0x1a1c, B:1100:0x1a2f, B:1102:0x1a39, B:1105:0x1a4f, B:1107:0x1a59, B:1109:0x1a65, B:1110:0x1a68, B:1112:0x1a6e, B:1113:0x1a71, B:1116:0x1a79, B:1118:0x1a87, B:1119:0x1a8e, B:1121:0x1a98, B:1122:0x1a9e, B:1124:0x1aa8, B:1125:0x1aaf, B:1127:0x1ab9, B:1128:0x1ac0, B:1130:0x1aca, B:1132:0x1ad0, B:1135:0x1add, B:1142:0x1af2, B:1144:0x1afa, B:1148:0x1b08, B:1154:0x1b2b, B:1156:0x1b3b, B:1159:0x1b45, B:257:0x06bb, B:260:0x06d3, B:262:0x06df, B:264:0x06eb, B:266:0x06f7, B:270:0x0709, B:272:0x0713, B:274:0x071b, B:277:0x0725, B:279:0x0733, B:281:0x0744, B:283:0x074e, B:284:0x0759, B:294:0x0791, B:302:0x07d1, B:308:0x07ec, B:310:0x07fb, B:312:0x0801, B:314:0x0809, B:316:0x081e, B:324:0x085a, B:328:0x0873, B:330:0x087f, B:332:0x088d, B:334:0x0899, B:335:0x08a0, B:337:0x08aa, B:338:0x08b6, B:340:0x08c2, B:342:0x08c8, B:345:0x08d5, B:352:0x08e8, B:354:0x08ef, B:358:0x08f9, B:374:0x0964, B:376:0x096c, B:378:0x0989, B:494:0x0c13, B:381:0x099c, B:394:0x09e2, B:398:0x09f5, B:405:0x0a0d, B:407:0x0a17, B:409:0x0a1f, B:410:0x0a31, B:412:0x0a37, B:414:0x0a51, B:418:0x0a6f, B:420:0x0a7d, B:423:0x0a8d, B:425:0x0a97, B:429:0x0aa4, B:431:0x0ab0, B:433:0x0ac7, B:435:0x0aec, B:437:0x0afa, B:439:0x0afe, B:443:0x0b17, B:445:0x0b25, B:447:0x0b2b, B:449:0x0b33, B:451:0x0b48, B:453:0x0b6d, B:455:0x0b7b, B:457:0x0b7f, B:460:0x0b8f, B:462:0x0b99, B:463:0x0ba1, B:465:0x0bab, B:466:0x0bb3, B:468:0x0bbd, B:470:0x0bc3, B:473:0x0bd0, B:480:0x0be7, B:485:0x0bf7, B:489:0x0c03, B:495:0x0c28, B:497:0x0c55, B:675:0x0fe2, B:692:0x102a, B:695:0x1033, B:697:0x103c, B:699:0x1066, B:750:0x120c, B:704:0x1088, B:707:0x1091, B:709:0x10a7, B:711:0x10b1, B:714:0x10c7, B:717:0x10d2, B:718:0x1104, B:721:0x110f, B:722:0x113a, B:724:0x1140, B:726:0x1163, B:728:0x1172, B:732:0x119e, B:735:0x11ab, B:737:0x11c1, B:739:0x11cb, B:741:0x11de, B:744:0x11eb, B:746:0x1200, B:752:0x1220, B:755:0x1231, B:757:0x123f, B:760:0x1250, B:762:0x1259, B:764:0x1264, B:765:0x126a, B:766:0x1289, B:777:0x12a9, B:780:0x12b0, B:781:0x12ca, B:788:0x12db, B:825:0x1413, B:828:0x1424, B:830:0x1430, B:832:0x143f, B:834:0x1449, B:835:0x1451, B:837:0x145b, B:839:0x1463, B:844:0x1471, B:846:0x147f, B:848:0x1487, B:851:0x1492, B:853:0x149c, B:854:0x14a8, B:856:0x14b2, B:857:0x14bd, B:859:0x14cb, B:863:0x14d8, B:865:0x14e4, B:867:0x14f9, B:869:0x1522, B:871:0x1530, B:873:0x1534, B:876:0x1544, B:878:0x1550, B:880:0x1556, B:882:0x155e, B:884:0x1573, B:886:0x1598, B:888:0x15a6, B:890:0x15aa, B:893:0x15b8, B:895:0x15c2, B:896:0x15ca, B:898:0x15d4, B:899:0x15dc, B:901:0x15e6, B:903:0x15ec, B:906:0x15f9, B:913:0x160c, B:915:0x1614, B:919:0x161f, B:992:0x178a, B:994:0x1792, B:996:0x17a5, B:1086:0x1998, B:999:0x17bc, B:1001:0x17c8, B:1003:0x17d7, B:1005:0x17e1, B:1006:0x17f4, B:1008:0x17fe, B:1012:0x180b, B:1014:0x1817, B:1016:0x182c, B:1018:0x1857, B:1020:0x1865, B:1022:0x1869, B:1028:0x1884, B:1030:0x1893, B:1032:0x1899, B:1034:0x18a1, B:1036:0x18b6, B:1038:0x18db, B:1040:0x18e9, B:1042:0x18ed, B:1046:0x1905, B:1048:0x190f, B:1050:0x1919, B:1052:0x1925, B:1053:0x192c, B:1055:0x1936, B:1056:0x193d, B:1058:0x1947, B:1060:0x194d, B:1063:0x195a, B:1070:0x196d, B:1072:0x1974, B:1076:0x197e, B:1083:0x198d, B:1087:0x19a5, B:1089:0x19ce), top: B:1174:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:1156:0x1b3b A[Catch: Exception -> 0x004a, TryCatch #4 {Exception -> 0x004a, blocks: (B:3:0x0034, B:5:0x003e, B:10:0x0054, B:14:0x00cc, B:17:0x00d8, B:500:0x0c71, B:502:0x0c95, B:586:0x0e55, B:505:0x0ca2, B:507:0x0cac, B:508:0x0cbb, B:510:0x0cc5, B:512:0x0cd0, B:514:0x0cda, B:518:0x0ce7, B:520:0x0cf3, B:522:0x0d08, B:524:0x0d33, B:526:0x0d41, B:528:0x0d45, B:531:0x0d54, B:533:0x0d61, B:535:0x0d67, B:537:0x0d6f, B:539:0x0d84, B:541:0x0da9, B:543:0x0db7, B:545:0x0dbb, B:548:0x0dc7, B:550:0x0dd1, B:551:0x0dd9, B:553:0x0de3, B:554:0x0deb, B:556:0x0df7, B:558:0x0e01, B:560:0x0e07, B:563:0x0e14, B:570:0x0e27, B:572:0x0e2e, B:576:0x0e38, B:582:0x0e45, B:585:0x0e4f, B:588:0x0e62, B:592:0x0e6c, B:594:0x0e72, B:598:0x0e8e, B:600:0x0e96, B:604:0x0ead, B:606:0x0eb3, B:608:0x0ec9, B:610:0x0edf, B:612:0x0eeb, B:20:0x00f6, B:22:0x00fe, B:26:0x011c, B:28:0x0134, B:153:0x040d, B:34:0x0154, B:36:0x0160, B:40:0x017a, B:42:0x0184, B:45:0x0193, B:47:0x019d, B:48:0x01a4, B:50:0x01ae, B:54:0x01ba, B:56:0x01c4, B:58:0x01ca, B:59:0x01da, B:61:0x01e0, B:63:0x01f9, B:65:0x0215, B:67:0x0221, B:68:0x0229, B:70:0x0233, B:74:0x0240, B:76:0x024c, B:78:0x0261, B:80:0x0288, B:82:0x0296, B:84:0x029a, B:90:0x02be, B:98:0x02ec, B:106:0x0324, B:112:0x033d, B:114:0x0348, B:116:0x0360, B:118:0x036c, B:119:0x037b, B:121:0x0389, B:122:0x0397, B:124:0x03a5, B:126:0x03ad, B:129:0x03be, B:136:0x03d7, B:141:0x03e7, B:145:0x03f3, B:157:0x042d, B:159:0x0435, B:164:0x044b, B:166:0x0477, B:168:0x0489, B:170:0x0497, B:232:0x05e5, B:173:0x04b5, B:175:0x04c1, B:176:0x04d5, B:178:0x04df, B:180:0x04e7, B:187:0x0512, B:189:0x051c, B:190:0x052b, B:192:0x0539, B:193:0x0547, B:195:0x0555, B:196:0x055e, B:198:0x056c, B:199:0x0572, B:201:0x057c, B:202:0x0584, B:204:0x058e, B:206:0x0594, B:209:0x05a1, B:216:0x05b6, B:218:0x05bd, B:222:0x05c7, B:231:0x05e0, B:233:0x05f6, B:238:0x0627, B:240:0x062b, B:244:0x064c, B:247:0x066d, B:1091:0x19ea, B:1093:0x19fb, B:1153:0x1b1c, B:1097:0x1a10, B:1099:0x1a1c, B:1100:0x1a2f, B:1102:0x1a39, B:1105:0x1a4f, B:1107:0x1a59, B:1109:0x1a65, B:1110:0x1a68, B:1112:0x1a6e, B:1113:0x1a71, B:1116:0x1a79, B:1118:0x1a87, B:1119:0x1a8e, B:1121:0x1a98, B:1122:0x1a9e, B:1124:0x1aa8, B:1125:0x1aaf, B:1127:0x1ab9, B:1128:0x1ac0, B:1130:0x1aca, B:1132:0x1ad0, B:1135:0x1add, B:1142:0x1af2, B:1144:0x1afa, B:1148:0x1b08, B:1154:0x1b2b, B:1156:0x1b3b, B:1159:0x1b45, B:257:0x06bb, B:260:0x06d3, B:262:0x06df, B:264:0x06eb, B:266:0x06f7, B:270:0x0709, B:272:0x0713, B:274:0x071b, B:277:0x0725, B:279:0x0733, B:281:0x0744, B:283:0x074e, B:284:0x0759, B:294:0x0791, B:302:0x07d1, B:308:0x07ec, B:310:0x07fb, B:312:0x0801, B:314:0x0809, B:316:0x081e, B:324:0x085a, B:328:0x0873, B:330:0x087f, B:332:0x088d, B:334:0x0899, B:335:0x08a0, B:337:0x08aa, B:338:0x08b6, B:340:0x08c2, B:342:0x08c8, B:345:0x08d5, B:352:0x08e8, B:354:0x08ef, B:358:0x08f9, B:374:0x0964, B:376:0x096c, B:378:0x0989, B:494:0x0c13, B:381:0x099c, B:394:0x09e2, B:398:0x09f5, B:405:0x0a0d, B:407:0x0a17, B:409:0x0a1f, B:410:0x0a31, B:412:0x0a37, B:414:0x0a51, B:418:0x0a6f, B:420:0x0a7d, B:423:0x0a8d, B:425:0x0a97, B:429:0x0aa4, B:431:0x0ab0, B:433:0x0ac7, B:435:0x0aec, B:437:0x0afa, B:439:0x0afe, B:443:0x0b17, B:445:0x0b25, B:447:0x0b2b, B:449:0x0b33, B:451:0x0b48, B:453:0x0b6d, B:455:0x0b7b, B:457:0x0b7f, B:460:0x0b8f, B:462:0x0b99, B:463:0x0ba1, B:465:0x0bab, B:466:0x0bb3, B:468:0x0bbd, B:470:0x0bc3, B:473:0x0bd0, B:480:0x0be7, B:485:0x0bf7, B:489:0x0c03, B:495:0x0c28, B:497:0x0c55, B:675:0x0fe2, B:692:0x102a, B:695:0x1033, B:697:0x103c, B:699:0x1066, B:750:0x120c, B:704:0x1088, B:707:0x1091, B:709:0x10a7, B:711:0x10b1, B:714:0x10c7, B:717:0x10d2, B:718:0x1104, B:721:0x110f, B:722:0x113a, B:724:0x1140, B:726:0x1163, B:728:0x1172, B:732:0x119e, B:735:0x11ab, B:737:0x11c1, B:739:0x11cb, B:741:0x11de, B:744:0x11eb, B:746:0x1200, B:752:0x1220, B:755:0x1231, B:757:0x123f, B:760:0x1250, B:762:0x1259, B:764:0x1264, B:765:0x126a, B:766:0x1289, B:777:0x12a9, B:780:0x12b0, B:781:0x12ca, B:788:0x12db, B:825:0x1413, B:828:0x1424, B:830:0x1430, B:832:0x143f, B:834:0x1449, B:835:0x1451, B:837:0x145b, B:839:0x1463, B:844:0x1471, B:846:0x147f, B:848:0x1487, B:851:0x1492, B:853:0x149c, B:854:0x14a8, B:856:0x14b2, B:857:0x14bd, B:859:0x14cb, B:863:0x14d8, B:865:0x14e4, B:867:0x14f9, B:869:0x1522, B:871:0x1530, B:873:0x1534, B:876:0x1544, B:878:0x1550, B:880:0x1556, B:882:0x155e, B:884:0x1573, B:886:0x1598, B:888:0x15a6, B:890:0x15aa, B:893:0x15b8, B:895:0x15c2, B:896:0x15ca, B:898:0x15d4, B:899:0x15dc, B:901:0x15e6, B:903:0x15ec, B:906:0x15f9, B:913:0x160c, B:915:0x1614, B:919:0x161f, B:992:0x178a, B:994:0x1792, B:996:0x17a5, B:1086:0x1998, B:999:0x17bc, B:1001:0x17c8, B:1003:0x17d7, B:1005:0x17e1, B:1006:0x17f4, B:1008:0x17fe, B:1012:0x180b, B:1014:0x1817, B:1016:0x182c, B:1018:0x1857, B:1020:0x1865, B:1022:0x1869, B:1028:0x1884, B:1030:0x1893, B:1032:0x1899, B:1034:0x18a1, B:1036:0x18b6, B:1038:0x18db, B:1040:0x18e9, B:1042:0x18ed, B:1046:0x1905, B:1048:0x190f, B:1050:0x1919, B:1052:0x1925, B:1053:0x192c, B:1055:0x1936, B:1056:0x193d, B:1058:0x1947, B:1060:0x194d, B:1063:0x195a, B:1070:0x196d, B:1072:0x1974, B:1076:0x197e, B:1083:0x198d, B:1087:0x19a5, B:1089:0x19ce), top: B:1174:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:1157:0x1b41  */
    /* JADX WARN: Removed duplicated region for block: B:1159:0x1b45 A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #4 {Exception -> 0x004a, blocks: (B:3:0x0034, B:5:0x003e, B:10:0x0054, B:14:0x00cc, B:17:0x00d8, B:500:0x0c71, B:502:0x0c95, B:586:0x0e55, B:505:0x0ca2, B:507:0x0cac, B:508:0x0cbb, B:510:0x0cc5, B:512:0x0cd0, B:514:0x0cda, B:518:0x0ce7, B:520:0x0cf3, B:522:0x0d08, B:524:0x0d33, B:526:0x0d41, B:528:0x0d45, B:531:0x0d54, B:533:0x0d61, B:535:0x0d67, B:537:0x0d6f, B:539:0x0d84, B:541:0x0da9, B:543:0x0db7, B:545:0x0dbb, B:548:0x0dc7, B:550:0x0dd1, B:551:0x0dd9, B:553:0x0de3, B:554:0x0deb, B:556:0x0df7, B:558:0x0e01, B:560:0x0e07, B:563:0x0e14, B:570:0x0e27, B:572:0x0e2e, B:576:0x0e38, B:582:0x0e45, B:585:0x0e4f, B:588:0x0e62, B:592:0x0e6c, B:594:0x0e72, B:598:0x0e8e, B:600:0x0e96, B:604:0x0ead, B:606:0x0eb3, B:608:0x0ec9, B:610:0x0edf, B:612:0x0eeb, B:20:0x00f6, B:22:0x00fe, B:26:0x011c, B:28:0x0134, B:153:0x040d, B:34:0x0154, B:36:0x0160, B:40:0x017a, B:42:0x0184, B:45:0x0193, B:47:0x019d, B:48:0x01a4, B:50:0x01ae, B:54:0x01ba, B:56:0x01c4, B:58:0x01ca, B:59:0x01da, B:61:0x01e0, B:63:0x01f9, B:65:0x0215, B:67:0x0221, B:68:0x0229, B:70:0x0233, B:74:0x0240, B:76:0x024c, B:78:0x0261, B:80:0x0288, B:82:0x0296, B:84:0x029a, B:90:0x02be, B:98:0x02ec, B:106:0x0324, B:112:0x033d, B:114:0x0348, B:116:0x0360, B:118:0x036c, B:119:0x037b, B:121:0x0389, B:122:0x0397, B:124:0x03a5, B:126:0x03ad, B:129:0x03be, B:136:0x03d7, B:141:0x03e7, B:145:0x03f3, B:157:0x042d, B:159:0x0435, B:164:0x044b, B:166:0x0477, B:168:0x0489, B:170:0x0497, B:232:0x05e5, B:173:0x04b5, B:175:0x04c1, B:176:0x04d5, B:178:0x04df, B:180:0x04e7, B:187:0x0512, B:189:0x051c, B:190:0x052b, B:192:0x0539, B:193:0x0547, B:195:0x0555, B:196:0x055e, B:198:0x056c, B:199:0x0572, B:201:0x057c, B:202:0x0584, B:204:0x058e, B:206:0x0594, B:209:0x05a1, B:216:0x05b6, B:218:0x05bd, B:222:0x05c7, B:231:0x05e0, B:233:0x05f6, B:238:0x0627, B:240:0x062b, B:244:0x064c, B:247:0x066d, B:1091:0x19ea, B:1093:0x19fb, B:1153:0x1b1c, B:1097:0x1a10, B:1099:0x1a1c, B:1100:0x1a2f, B:1102:0x1a39, B:1105:0x1a4f, B:1107:0x1a59, B:1109:0x1a65, B:1110:0x1a68, B:1112:0x1a6e, B:1113:0x1a71, B:1116:0x1a79, B:1118:0x1a87, B:1119:0x1a8e, B:1121:0x1a98, B:1122:0x1a9e, B:1124:0x1aa8, B:1125:0x1aaf, B:1127:0x1ab9, B:1128:0x1ac0, B:1130:0x1aca, B:1132:0x1ad0, B:1135:0x1add, B:1142:0x1af2, B:1144:0x1afa, B:1148:0x1b08, B:1154:0x1b2b, B:1156:0x1b3b, B:1159:0x1b45, B:257:0x06bb, B:260:0x06d3, B:262:0x06df, B:264:0x06eb, B:266:0x06f7, B:270:0x0709, B:272:0x0713, B:274:0x071b, B:277:0x0725, B:279:0x0733, B:281:0x0744, B:283:0x074e, B:284:0x0759, B:294:0x0791, B:302:0x07d1, B:308:0x07ec, B:310:0x07fb, B:312:0x0801, B:314:0x0809, B:316:0x081e, B:324:0x085a, B:328:0x0873, B:330:0x087f, B:332:0x088d, B:334:0x0899, B:335:0x08a0, B:337:0x08aa, B:338:0x08b6, B:340:0x08c2, B:342:0x08c8, B:345:0x08d5, B:352:0x08e8, B:354:0x08ef, B:358:0x08f9, B:374:0x0964, B:376:0x096c, B:378:0x0989, B:494:0x0c13, B:381:0x099c, B:394:0x09e2, B:398:0x09f5, B:405:0x0a0d, B:407:0x0a17, B:409:0x0a1f, B:410:0x0a31, B:412:0x0a37, B:414:0x0a51, B:418:0x0a6f, B:420:0x0a7d, B:423:0x0a8d, B:425:0x0a97, B:429:0x0aa4, B:431:0x0ab0, B:433:0x0ac7, B:435:0x0aec, B:437:0x0afa, B:439:0x0afe, B:443:0x0b17, B:445:0x0b25, B:447:0x0b2b, B:449:0x0b33, B:451:0x0b48, B:453:0x0b6d, B:455:0x0b7b, B:457:0x0b7f, B:460:0x0b8f, B:462:0x0b99, B:463:0x0ba1, B:465:0x0bab, B:466:0x0bb3, B:468:0x0bbd, B:470:0x0bc3, B:473:0x0bd0, B:480:0x0be7, B:485:0x0bf7, B:489:0x0c03, B:495:0x0c28, B:497:0x0c55, B:675:0x0fe2, B:692:0x102a, B:695:0x1033, B:697:0x103c, B:699:0x1066, B:750:0x120c, B:704:0x1088, B:707:0x1091, B:709:0x10a7, B:711:0x10b1, B:714:0x10c7, B:717:0x10d2, B:718:0x1104, B:721:0x110f, B:722:0x113a, B:724:0x1140, B:726:0x1163, B:728:0x1172, B:732:0x119e, B:735:0x11ab, B:737:0x11c1, B:739:0x11cb, B:741:0x11de, B:744:0x11eb, B:746:0x1200, B:752:0x1220, B:755:0x1231, B:757:0x123f, B:760:0x1250, B:762:0x1259, B:764:0x1264, B:765:0x126a, B:766:0x1289, B:777:0x12a9, B:780:0x12b0, B:781:0x12ca, B:788:0x12db, B:825:0x1413, B:828:0x1424, B:830:0x1430, B:832:0x143f, B:834:0x1449, B:835:0x1451, B:837:0x145b, B:839:0x1463, B:844:0x1471, B:846:0x147f, B:848:0x1487, B:851:0x1492, B:853:0x149c, B:854:0x14a8, B:856:0x14b2, B:857:0x14bd, B:859:0x14cb, B:863:0x14d8, B:865:0x14e4, B:867:0x14f9, B:869:0x1522, B:871:0x1530, B:873:0x1534, B:876:0x1544, B:878:0x1550, B:880:0x1556, B:882:0x155e, B:884:0x1573, B:886:0x1598, B:888:0x15a6, B:890:0x15aa, B:893:0x15b8, B:895:0x15c2, B:896:0x15ca, B:898:0x15d4, B:899:0x15dc, B:901:0x15e6, B:903:0x15ec, B:906:0x15f9, B:913:0x160c, B:915:0x1614, B:919:0x161f, B:992:0x178a, B:994:0x1792, B:996:0x17a5, B:1086:0x1998, B:999:0x17bc, B:1001:0x17c8, B:1003:0x17d7, B:1005:0x17e1, B:1006:0x17f4, B:1008:0x17fe, B:1012:0x180b, B:1014:0x1817, B:1016:0x182c, B:1018:0x1857, B:1020:0x1865, B:1022:0x1869, B:1028:0x1884, B:1030:0x1893, B:1032:0x1899, B:1034:0x18a1, B:1036:0x18b6, B:1038:0x18db, B:1040:0x18e9, B:1042:0x18ed, B:1046:0x1905, B:1048:0x190f, B:1050:0x1919, B:1052:0x1925, B:1053:0x192c, B:1055:0x1936, B:1056:0x193d, B:1058:0x1947, B:1060:0x194d, B:1063:0x195a, B:1070:0x196d, B:1072:0x1974, B:1076:0x197e, B:1083:0x198d, B:1087:0x19a5, B:1089:0x19ce), top: B:1174:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x08ec  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0c95 A[Catch: Exception -> 0x004a, TryCatch #4 {Exception -> 0x004a, blocks: (B:3:0x0034, B:5:0x003e, B:10:0x0054, B:14:0x00cc, B:17:0x00d8, B:500:0x0c71, B:502:0x0c95, B:586:0x0e55, B:505:0x0ca2, B:507:0x0cac, B:508:0x0cbb, B:510:0x0cc5, B:512:0x0cd0, B:514:0x0cda, B:518:0x0ce7, B:520:0x0cf3, B:522:0x0d08, B:524:0x0d33, B:526:0x0d41, B:528:0x0d45, B:531:0x0d54, B:533:0x0d61, B:535:0x0d67, B:537:0x0d6f, B:539:0x0d84, B:541:0x0da9, B:543:0x0db7, B:545:0x0dbb, B:548:0x0dc7, B:550:0x0dd1, B:551:0x0dd9, B:553:0x0de3, B:554:0x0deb, B:556:0x0df7, B:558:0x0e01, B:560:0x0e07, B:563:0x0e14, B:570:0x0e27, B:572:0x0e2e, B:576:0x0e38, B:582:0x0e45, B:585:0x0e4f, B:588:0x0e62, B:592:0x0e6c, B:594:0x0e72, B:598:0x0e8e, B:600:0x0e96, B:604:0x0ead, B:606:0x0eb3, B:608:0x0ec9, B:610:0x0edf, B:612:0x0eeb, B:20:0x00f6, B:22:0x00fe, B:26:0x011c, B:28:0x0134, B:153:0x040d, B:34:0x0154, B:36:0x0160, B:40:0x017a, B:42:0x0184, B:45:0x0193, B:47:0x019d, B:48:0x01a4, B:50:0x01ae, B:54:0x01ba, B:56:0x01c4, B:58:0x01ca, B:59:0x01da, B:61:0x01e0, B:63:0x01f9, B:65:0x0215, B:67:0x0221, B:68:0x0229, B:70:0x0233, B:74:0x0240, B:76:0x024c, B:78:0x0261, B:80:0x0288, B:82:0x0296, B:84:0x029a, B:90:0x02be, B:98:0x02ec, B:106:0x0324, B:112:0x033d, B:114:0x0348, B:116:0x0360, B:118:0x036c, B:119:0x037b, B:121:0x0389, B:122:0x0397, B:124:0x03a5, B:126:0x03ad, B:129:0x03be, B:136:0x03d7, B:141:0x03e7, B:145:0x03f3, B:157:0x042d, B:159:0x0435, B:164:0x044b, B:166:0x0477, B:168:0x0489, B:170:0x0497, B:232:0x05e5, B:173:0x04b5, B:175:0x04c1, B:176:0x04d5, B:178:0x04df, B:180:0x04e7, B:187:0x0512, B:189:0x051c, B:190:0x052b, B:192:0x0539, B:193:0x0547, B:195:0x0555, B:196:0x055e, B:198:0x056c, B:199:0x0572, B:201:0x057c, B:202:0x0584, B:204:0x058e, B:206:0x0594, B:209:0x05a1, B:216:0x05b6, B:218:0x05bd, B:222:0x05c7, B:231:0x05e0, B:233:0x05f6, B:238:0x0627, B:240:0x062b, B:244:0x064c, B:247:0x066d, B:1091:0x19ea, B:1093:0x19fb, B:1153:0x1b1c, B:1097:0x1a10, B:1099:0x1a1c, B:1100:0x1a2f, B:1102:0x1a39, B:1105:0x1a4f, B:1107:0x1a59, B:1109:0x1a65, B:1110:0x1a68, B:1112:0x1a6e, B:1113:0x1a71, B:1116:0x1a79, B:1118:0x1a87, B:1119:0x1a8e, B:1121:0x1a98, B:1122:0x1a9e, B:1124:0x1aa8, B:1125:0x1aaf, B:1127:0x1ab9, B:1128:0x1ac0, B:1130:0x1aca, B:1132:0x1ad0, B:1135:0x1add, B:1142:0x1af2, B:1144:0x1afa, B:1148:0x1b08, B:1154:0x1b2b, B:1156:0x1b3b, B:1159:0x1b45, B:257:0x06bb, B:260:0x06d3, B:262:0x06df, B:264:0x06eb, B:266:0x06f7, B:270:0x0709, B:272:0x0713, B:274:0x071b, B:277:0x0725, B:279:0x0733, B:281:0x0744, B:283:0x074e, B:284:0x0759, B:294:0x0791, B:302:0x07d1, B:308:0x07ec, B:310:0x07fb, B:312:0x0801, B:314:0x0809, B:316:0x081e, B:324:0x085a, B:328:0x0873, B:330:0x087f, B:332:0x088d, B:334:0x0899, B:335:0x08a0, B:337:0x08aa, B:338:0x08b6, B:340:0x08c2, B:342:0x08c8, B:345:0x08d5, B:352:0x08e8, B:354:0x08ef, B:358:0x08f9, B:374:0x0964, B:376:0x096c, B:378:0x0989, B:494:0x0c13, B:381:0x099c, B:394:0x09e2, B:398:0x09f5, B:405:0x0a0d, B:407:0x0a17, B:409:0x0a1f, B:410:0x0a31, B:412:0x0a37, B:414:0x0a51, B:418:0x0a6f, B:420:0x0a7d, B:423:0x0a8d, B:425:0x0a97, B:429:0x0aa4, B:431:0x0ab0, B:433:0x0ac7, B:435:0x0aec, B:437:0x0afa, B:439:0x0afe, B:443:0x0b17, B:445:0x0b25, B:447:0x0b2b, B:449:0x0b33, B:451:0x0b48, B:453:0x0b6d, B:455:0x0b7b, B:457:0x0b7f, B:460:0x0b8f, B:462:0x0b99, B:463:0x0ba1, B:465:0x0bab, B:466:0x0bb3, B:468:0x0bbd, B:470:0x0bc3, B:473:0x0bd0, B:480:0x0be7, B:485:0x0bf7, B:489:0x0c03, B:495:0x0c28, B:497:0x0c55, B:675:0x0fe2, B:692:0x102a, B:695:0x1033, B:697:0x103c, B:699:0x1066, B:750:0x120c, B:704:0x1088, B:707:0x1091, B:709:0x10a7, B:711:0x10b1, B:714:0x10c7, B:717:0x10d2, B:718:0x1104, B:721:0x110f, B:722:0x113a, B:724:0x1140, B:726:0x1163, B:728:0x1172, B:732:0x119e, B:735:0x11ab, B:737:0x11c1, B:739:0x11cb, B:741:0x11de, B:744:0x11eb, B:746:0x1200, B:752:0x1220, B:755:0x1231, B:757:0x123f, B:760:0x1250, B:762:0x1259, B:764:0x1264, B:765:0x126a, B:766:0x1289, B:777:0x12a9, B:780:0x12b0, B:781:0x12ca, B:788:0x12db, B:825:0x1413, B:828:0x1424, B:830:0x1430, B:832:0x143f, B:834:0x1449, B:835:0x1451, B:837:0x145b, B:839:0x1463, B:844:0x1471, B:846:0x147f, B:848:0x1487, B:851:0x1492, B:853:0x149c, B:854:0x14a8, B:856:0x14b2, B:857:0x14bd, B:859:0x14cb, B:863:0x14d8, B:865:0x14e4, B:867:0x14f9, B:869:0x1522, B:871:0x1530, B:873:0x1534, B:876:0x1544, B:878:0x1550, B:880:0x1556, B:882:0x155e, B:884:0x1573, B:886:0x1598, B:888:0x15a6, B:890:0x15aa, B:893:0x15b8, B:895:0x15c2, B:896:0x15ca, B:898:0x15d4, B:899:0x15dc, B:901:0x15e6, B:903:0x15ec, B:906:0x15f9, B:913:0x160c, B:915:0x1614, B:919:0x161f, B:992:0x178a, B:994:0x1792, B:996:0x17a5, B:1086:0x1998, B:999:0x17bc, B:1001:0x17c8, B:1003:0x17d7, B:1005:0x17e1, B:1006:0x17f4, B:1008:0x17fe, B:1012:0x180b, B:1014:0x1817, B:1016:0x182c, B:1018:0x1857, B:1020:0x1865, B:1022:0x1869, B:1028:0x1884, B:1030:0x1893, B:1032:0x1899, B:1034:0x18a1, B:1036:0x18b6, B:1038:0x18db, B:1040:0x18e9, B:1042:0x18ed, B:1046:0x1905, B:1048:0x190f, B:1050:0x1919, B:1052:0x1925, B:1053:0x192c, B:1055:0x1936, B:1056:0x193d, B:1058:0x1947, B:1060:0x194d, B:1063:0x195a, B:1070:0x196d, B:1072:0x1974, B:1076:0x197e, B:1083:0x198d, B:1087:0x19a5, B:1089:0x19ce), top: B:1174:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0e62 A[Catch: Exception -> 0x004a, TryCatch #4 {Exception -> 0x004a, blocks: (B:3:0x0034, B:5:0x003e, B:10:0x0054, B:14:0x00cc, B:17:0x00d8, B:500:0x0c71, B:502:0x0c95, B:586:0x0e55, B:505:0x0ca2, B:507:0x0cac, B:508:0x0cbb, B:510:0x0cc5, B:512:0x0cd0, B:514:0x0cda, B:518:0x0ce7, B:520:0x0cf3, B:522:0x0d08, B:524:0x0d33, B:526:0x0d41, B:528:0x0d45, B:531:0x0d54, B:533:0x0d61, B:535:0x0d67, B:537:0x0d6f, B:539:0x0d84, B:541:0x0da9, B:543:0x0db7, B:545:0x0dbb, B:548:0x0dc7, B:550:0x0dd1, B:551:0x0dd9, B:553:0x0de3, B:554:0x0deb, B:556:0x0df7, B:558:0x0e01, B:560:0x0e07, B:563:0x0e14, B:570:0x0e27, B:572:0x0e2e, B:576:0x0e38, B:582:0x0e45, B:585:0x0e4f, B:588:0x0e62, B:592:0x0e6c, B:594:0x0e72, B:598:0x0e8e, B:600:0x0e96, B:604:0x0ead, B:606:0x0eb3, B:608:0x0ec9, B:610:0x0edf, B:612:0x0eeb, B:20:0x00f6, B:22:0x00fe, B:26:0x011c, B:28:0x0134, B:153:0x040d, B:34:0x0154, B:36:0x0160, B:40:0x017a, B:42:0x0184, B:45:0x0193, B:47:0x019d, B:48:0x01a4, B:50:0x01ae, B:54:0x01ba, B:56:0x01c4, B:58:0x01ca, B:59:0x01da, B:61:0x01e0, B:63:0x01f9, B:65:0x0215, B:67:0x0221, B:68:0x0229, B:70:0x0233, B:74:0x0240, B:76:0x024c, B:78:0x0261, B:80:0x0288, B:82:0x0296, B:84:0x029a, B:90:0x02be, B:98:0x02ec, B:106:0x0324, B:112:0x033d, B:114:0x0348, B:116:0x0360, B:118:0x036c, B:119:0x037b, B:121:0x0389, B:122:0x0397, B:124:0x03a5, B:126:0x03ad, B:129:0x03be, B:136:0x03d7, B:141:0x03e7, B:145:0x03f3, B:157:0x042d, B:159:0x0435, B:164:0x044b, B:166:0x0477, B:168:0x0489, B:170:0x0497, B:232:0x05e5, B:173:0x04b5, B:175:0x04c1, B:176:0x04d5, B:178:0x04df, B:180:0x04e7, B:187:0x0512, B:189:0x051c, B:190:0x052b, B:192:0x0539, B:193:0x0547, B:195:0x0555, B:196:0x055e, B:198:0x056c, B:199:0x0572, B:201:0x057c, B:202:0x0584, B:204:0x058e, B:206:0x0594, B:209:0x05a1, B:216:0x05b6, B:218:0x05bd, B:222:0x05c7, B:231:0x05e0, B:233:0x05f6, B:238:0x0627, B:240:0x062b, B:244:0x064c, B:247:0x066d, B:1091:0x19ea, B:1093:0x19fb, B:1153:0x1b1c, B:1097:0x1a10, B:1099:0x1a1c, B:1100:0x1a2f, B:1102:0x1a39, B:1105:0x1a4f, B:1107:0x1a59, B:1109:0x1a65, B:1110:0x1a68, B:1112:0x1a6e, B:1113:0x1a71, B:1116:0x1a79, B:1118:0x1a87, B:1119:0x1a8e, B:1121:0x1a98, B:1122:0x1a9e, B:1124:0x1aa8, B:1125:0x1aaf, B:1127:0x1ab9, B:1128:0x1ac0, B:1130:0x1aca, B:1132:0x1ad0, B:1135:0x1add, B:1142:0x1af2, B:1144:0x1afa, B:1148:0x1b08, B:1154:0x1b2b, B:1156:0x1b3b, B:1159:0x1b45, B:257:0x06bb, B:260:0x06d3, B:262:0x06df, B:264:0x06eb, B:266:0x06f7, B:270:0x0709, B:272:0x0713, B:274:0x071b, B:277:0x0725, B:279:0x0733, B:281:0x0744, B:283:0x074e, B:284:0x0759, B:294:0x0791, B:302:0x07d1, B:308:0x07ec, B:310:0x07fb, B:312:0x0801, B:314:0x0809, B:316:0x081e, B:324:0x085a, B:328:0x0873, B:330:0x087f, B:332:0x088d, B:334:0x0899, B:335:0x08a0, B:337:0x08aa, B:338:0x08b6, B:340:0x08c2, B:342:0x08c8, B:345:0x08d5, B:352:0x08e8, B:354:0x08ef, B:358:0x08f9, B:374:0x0964, B:376:0x096c, B:378:0x0989, B:494:0x0c13, B:381:0x099c, B:394:0x09e2, B:398:0x09f5, B:405:0x0a0d, B:407:0x0a17, B:409:0x0a1f, B:410:0x0a31, B:412:0x0a37, B:414:0x0a51, B:418:0x0a6f, B:420:0x0a7d, B:423:0x0a8d, B:425:0x0a97, B:429:0x0aa4, B:431:0x0ab0, B:433:0x0ac7, B:435:0x0aec, B:437:0x0afa, B:439:0x0afe, B:443:0x0b17, B:445:0x0b25, B:447:0x0b2b, B:449:0x0b33, B:451:0x0b48, B:453:0x0b6d, B:455:0x0b7b, B:457:0x0b7f, B:460:0x0b8f, B:462:0x0b99, B:463:0x0ba1, B:465:0x0bab, B:466:0x0bb3, B:468:0x0bbd, B:470:0x0bc3, B:473:0x0bd0, B:480:0x0be7, B:485:0x0bf7, B:489:0x0c03, B:495:0x0c28, B:497:0x0c55, B:675:0x0fe2, B:692:0x102a, B:695:0x1033, B:697:0x103c, B:699:0x1066, B:750:0x120c, B:704:0x1088, B:707:0x1091, B:709:0x10a7, B:711:0x10b1, B:714:0x10c7, B:717:0x10d2, B:718:0x1104, B:721:0x110f, B:722:0x113a, B:724:0x1140, B:726:0x1163, B:728:0x1172, B:732:0x119e, B:735:0x11ab, B:737:0x11c1, B:739:0x11cb, B:741:0x11de, B:744:0x11eb, B:746:0x1200, B:752:0x1220, B:755:0x1231, B:757:0x123f, B:760:0x1250, B:762:0x1259, B:764:0x1264, B:765:0x126a, B:766:0x1289, B:777:0x12a9, B:780:0x12b0, B:781:0x12ca, B:788:0x12db, B:825:0x1413, B:828:0x1424, B:830:0x1430, B:832:0x143f, B:834:0x1449, B:835:0x1451, B:837:0x145b, B:839:0x1463, B:844:0x1471, B:846:0x147f, B:848:0x1487, B:851:0x1492, B:853:0x149c, B:854:0x14a8, B:856:0x14b2, B:857:0x14bd, B:859:0x14cb, B:863:0x14d8, B:865:0x14e4, B:867:0x14f9, B:869:0x1522, B:871:0x1530, B:873:0x1534, B:876:0x1544, B:878:0x1550, B:880:0x1556, B:882:0x155e, B:884:0x1573, B:886:0x1598, B:888:0x15a6, B:890:0x15aa, B:893:0x15b8, B:895:0x15c2, B:896:0x15ca, B:898:0x15d4, B:899:0x15dc, B:901:0x15e6, B:903:0x15ec, B:906:0x15f9, B:913:0x160c, B:915:0x1614, B:919:0x161f, B:992:0x178a, B:994:0x1792, B:996:0x17a5, B:1086:0x1998, B:999:0x17bc, B:1001:0x17c8, B:1003:0x17d7, B:1005:0x17e1, B:1006:0x17f4, B:1008:0x17fe, B:1012:0x180b, B:1014:0x1817, B:1016:0x182c, B:1018:0x1857, B:1020:0x1865, B:1022:0x1869, B:1028:0x1884, B:1030:0x1893, B:1032:0x1899, B:1034:0x18a1, B:1036:0x18b6, B:1038:0x18db, B:1040:0x18e9, B:1042:0x18ed, B:1046:0x1905, B:1048:0x190f, B:1050:0x1919, B:1052:0x1925, B:1053:0x192c, B:1055:0x1936, B:1056:0x193d, B:1058:0x1947, B:1060:0x194d, B:1063:0x195a, B:1070:0x196d, B:1072:0x1974, B:1076:0x197e, B:1083:0x198d, B:1087:0x19a5, B:1089:0x19ce), top: B:1174:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0e6a  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x0e72 A[Catch: Exception -> 0x004a, TryCatch #4 {Exception -> 0x004a, blocks: (B:3:0x0034, B:5:0x003e, B:10:0x0054, B:14:0x00cc, B:17:0x00d8, B:500:0x0c71, B:502:0x0c95, B:586:0x0e55, B:505:0x0ca2, B:507:0x0cac, B:508:0x0cbb, B:510:0x0cc5, B:512:0x0cd0, B:514:0x0cda, B:518:0x0ce7, B:520:0x0cf3, B:522:0x0d08, B:524:0x0d33, B:526:0x0d41, B:528:0x0d45, B:531:0x0d54, B:533:0x0d61, B:535:0x0d67, B:537:0x0d6f, B:539:0x0d84, B:541:0x0da9, B:543:0x0db7, B:545:0x0dbb, B:548:0x0dc7, B:550:0x0dd1, B:551:0x0dd9, B:553:0x0de3, B:554:0x0deb, B:556:0x0df7, B:558:0x0e01, B:560:0x0e07, B:563:0x0e14, B:570:0x0e27, B:572:0x0e2e, B:576:0x0e38, B:582:0x0e45, B:585:0x0e4f, B:588:0x0e62, B:592:0x0e6c, B:594:0x0e72, B:598:0x0e8e, B:600:0x0e96, B:604:0x0ead, B:606:0x0eb3, B:608:0x0ec9, B:610:0x0edf, B:612:0x0eeb, B:20:0x00f6, B:22:0x00fe, B:26:0x011c, B:28:0x0134, B:153:0x040d, B:34:0x0154, B:36:0x0160, B:40:0x017a, B:42:0x0184, B:45:0x0193, B:47:0x019d, B:48:0x01a4, B:50:0x01ae, B:54:0x01ba, B:56:0x01c4, B:58:0x01ca, B:59:0x01da, B:61:0x01e0, B:63:0x01f9, B:65:0x0215, B:67:0x0221, B:68:0x0229, B:70:0x0233, B:74:0x0240, B:76:0x024c, B:78:0x0261, B:80:0x0288, B:82:0x0296, B:84:0x029a, B:90:0x02be, B:98:0x02ec, B:106:0x0324, B:112:0x033d, B:114:0x0348, B:116:0x0360, B:118:0x036c, B:119:0x037b, B:121:0x0389, B:122:0x0397, B:124:0x03a5, B:126:0x03ad, B:129:0x03be, B:136:0x03d7, B:141:0x03e7, B:145:0x03f3, B:157:0x042d, B:159:0x0435, B:164:0x044b, B:166:0x0477, B:168:0x0489, B:170:0x0497, B:232:0x05e5, B:173:0x04b5, B:175:0x04c1, B:176:0x04d5, B:178:0x04df, B:180:0x04e7, B:187:0x0512, B:189:0x051c, B:190:0x052b, B:192:0x0539, B:193:0x0547, B:195:0x0555, B:196:0x055e, B:198:0x056c, B:199:0x0572, B:201:0x057c, B:202:0x0584, B:204:0x058e, B:206:0x0594, B:209:0x05a1, B:216:0x05b6, B:218:0x05bd, B:222:0x05c7, B:231:0x05e0, B:233:0x05f6, B:238:0x0627, B:240:0x062b, B:244:0x064c, B:247:0x066d, B:1091:0x19ea, B:1093:0x19fb, B:1153:0x1b1c, B:1097:0x1a10, B:1099:0x1a1c, B:1100:0x1a2f, B:1102:0x1a39, B:1105:0x1a4f, B:1107:0x1a59, B:1109:0x1a65, B:1110:0x1a68, B:1112:0x1a6e, B:1113:0x1a71, B:1116:0x1a79, B:1118:0x1a87, B:1119:0x1a8e, B:1121:0x1a98, B:1122:0x1a9e, B:1124:0x1aa8, B:1125:0x1aaf, B:1127:0x1ab9, B:1128:0x1ac0, B:1130:0x1aca, B:1132:0x1ad0, B:1135:0x1add, B:1142:0x1af2, B:1144:0x1afa, B:1148:0x1b08, B:1154:0x1b2b, B:1156:0x1b3b, B:1159:0x1b45, B:257:0x06bb, B:260:0x06d3, B:262:0x06df, B:264:0x06eb, B:266:0x06f7, B:270:0x0709, B:272:0x0713, B:274:0x071b, B:277:0x0725, B:279:0x0733, B:281:0x0744, B:283:0x074e, B:284:0x0759, B:294:0x0791, B:302:0x07d1, B:308:0x07ec, B:310:0x07fb, B:312:0x0801, B:314:0x0809, B:316:0x081e, B:324:0x085a, B:328:0x0873, B:330:0x087f, B:332:0x088d, B:334:0x0899, B:335:0x08a0, B:337:0x08aa, B:338:0x08b6, B:340:0x08c2, B:342:0x08c8, B:345:0x08d5, B:352:0x08e8, B:354:0x08ef, B:358:0x08f9, B:374:0x0964, B:376:0x096c, B:378:0x0989, B:494:0x0c13, B:381:0x099c, B:394:0x09e2, B:398:0x09f5, B:405:0x0a0d, B:407:0x0a17, B:409:0x0a1f, B:410:0x0a31, B:412:0x0a37, B:414:0x0a51, B:418:0x0a6f, B:420:0x0a7d, B:423:0x0a8d, B:425:0x0a97, B:429:0x0aa4, B:431:0x0ab0, B:433:0x0ac7, B:435:0x0aec, B:437:0x0afa, B:439:0x0afe, B:443:0x0b17, B:445:0x0b25, B:447:0x0b2b, B:449:0x0b33, B:451:0x0b48, B:453:0x0b6d, B:455:0x0b7b, B:457:0x0b7f, B:460:0x0b8f, B:462:0x0b99, B:463:0x0ba1, B:465:0x0bab, B:466:0x0bb3, B:468:0x0bbd, B:470:0x0bc3, B:473:0x0bd0, B:480:0x0be7, B:485:0x0bf7, B:489:0x0c03, B:495:0x0c28, B:497:0x0c55, B:675:0x0fe2, B:692:0x102a, B:695:0x1033, B:697:0x103c, B:699:0x1066, B:750:0x120c, B:704:0x1088, B:707:0x1091, B:709:0x10a7, B:711:0x10b1, B:714:0x10c7, B:717:0x10d2, B:718:0x1104, B:721:0x110f, B:722:0x113a, B:724:0x1140, B:726:0x1163, B:728:0x1172, B:732:0x119e, B:735:0x11ab, B:737:0x11c1, B:739:0x11cb, B:741:0x11de, B:744:0x11eb, B:746:0x1200, B:752:0x1220, B:755:0x1231, B:757:0x123f, B:760:0x1250, B:762:0x1259, B:764:0x1264, B:765:0x126a, B:766:0x1289, B:777:0x12a9, B:780:0x12b0, B:781:0x12ca, B:788:0x12db, B:825:0x1413, B:828:0x1424, B:830:0x1430, B:832:0x143f, B:834:0x1449, B:835:0x1451, B:837:0x145b, B:839:0x1463, B:844:0x1471, B:846:0x147f, B:848:0x1487, B:851:0x1492, B:853:0x149c, B:854:0x14a8, B:856:0x14b2, B:857:0x14bd, B:859:0x14cb, B:863:0x14d8, B:865:0x14e4, B:867:0x14f9, B:869:0x1522, B:871:0x1530, B:873:0x1534, B:876:0x1544, B:878:0x1550, B:880:0x1556, B:882:0x155e, B:884:0x1573, B:886:0x1598, B:888:0x15a6, B:890:0x15aa, B:893:0x15b8, B:895:0x15c2, B:896:0x15ca, B:898:0x15d4, B:899:0x15dc, B:901:0x15e6, B:903:0x15ec, B:906:0x15f9, B:913:0x160c, B:915:0x1614, B:919:0x161f, B:992:0x178a, B:994:0x1792, B:996:0x17a5, B:1086:0x1998, B:999:0x17bc, B:1001:0x17c8, B:1003:0x17d7, B:1005:0x17e1, B:1006:0x17f4, B:1008:0x17fe, B:1012:0x180b, B:1014:0x1817, B:1016:0x182c, B:1018:0x1857, B:1020:0x1865, B:1022:0x1869, B:1028:0x1884, B:1030:0x1893, B:1032:0x1899, B:1034:0x18a1, B:1036:0x18b6, B:1038:0x18db, B:1040:0x18e9, B:1042:0x18ed, B:1046:0x1905, B:1048:0x190f, B:1050:0x1919, B:1052:0x1925, B:1053:0x192c, B:1055:0x1936, B:1056:0x193d, B:1058:0x1947, B:1060:0x194d, B:1063:0x195a, B:1070:0x196d, B:1072:0x1974, B:1076:0x197e, B:1083:0x198d, B:1087:0x19a5, B:1089:0x19ce), top: B:1174:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:653:0x0f75  */
    /* JADX WARN: Removed duplicated region for block: B:729:0x1195  */
    /* JADX WARN: Removed duplicated region for block: B:914:0x1610  */
    /* JADX WARN: Type inference failed for: r22v27 */
    /* JADX WARN: Type inference failed for: r22v28 */
    /* JADX WARN: Type inference failed for: r22v37 */
    /* JADX WARN: Type inference failed for: r7v108 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ea3 a(String str, String[] strArr, Collection collection) {
        boolean z;
        String lowerCase;
        String[] strArr2;
        String str2;
        Object obj;
        String str3;
        String str4;
        String str5;
        Object obj2;
        String str6;
        String str7;
        Object obj3;
        Object obj4;
        String str8;
        tn tnVar;
        String str9;
        String str10;
        String strU;
        String lowerCase2;
        tn tnVar2;
        tn tnVar3;
        String str11;
        String str12;
        tn tnVar4;
        String str13;
        String str14;
        String str15;
        String lowerCase3;
        int i;
        String str16;
        String str17;
        String lowerCase4;
        String str18;
        String str19;
        Integer numQ;
        String str20;
        String str21;
        Object next;
        int i2;
        String str22;
        tn tnVar5;
        String[] strArr3;
        tn tnVar6;
        Iterator it;
        String lowerCase5;
        String str23;
        String[] strArr4;
        Object obj5;
        String str24;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        String str25;
        String str26;
        String str27;
        Object obj10;
        int i3;
        String str28;
        String str29;
        HashMap map;
        String str30;
        String lowerCase6;
        Object obj11;
        Object obj12;
        String str31;
        String str32;
        String str33;
        String str34;
        Integer numQ2;
        String str35;
        ArrayList arrayList;
        String str36;
        String str37;
        String str38;
        String str39;
        String strS;
        String str40;
        String lowerCase7;
        String str41;
        String str42;
        String str43;
        String str44;
        boolean z2;
        int length;
        int i4;
        String strU2;
        int i5;
        Object obj13;
        Object obj14;
        String lowerCase8;
        String str45;
        boolean zP;
        String strS2;
        boolean z3;
        char c;
        String str46;
        String strS3;
        String str47;
        String strS4;
        String str48;
        boolean z4;
        String str49;
        String str50;
        String strU3;
        String lowerCase9;
        String str51;
        int i6;
        int i7;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        String str59;
        String str60;
        String lowerCase10;
        String str61;
        Object obj15;
        Object obj16;
        String str62;
        String str63;
        int length2;
        int i8;
        String str64;
        String str65;
        String lowerCase11;
        String str66;
        String str67;
        String str68;
        String str69;
        String str70 = "section-name";
        String str71 = "username";
        tn tnVar7 = tn.f;
        tn tnVar8 = tn.z;
        ke2 ke2Var = ke2.ERROR;
        tn tnVar9 = tn.b;
        strArr.getClass();
        String str72 = "encrypt-method";
        try {
            String str73 = (String) qe.m0(0, strArr);
            if (str73 != null) {
                z = false;
                lowerCase = str73.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
            } else {
                z = false;
                lowerCase = null;
            }
            try {
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (lowerCase != null) {
            String str74 = "reuse";
            String str75 = "alpn";
            String str76 = "uuid";
            String str77 = "\"";
            String str78 = "salamander-password";
            String str79 = "port-hopping-interval";
            String str80 = "ws-headers";
            String str81 = "port-hopping";
            String str82 = "ws-path";
            String str83 = "download-bandwidth";
            String str84 = "ws";
            String str85 = "tls";
            String str86 = "obfs-uri";
            String str87 = "invalid sni value: ";
            String str88 = "obfs-host";
            String str89 = "password";
            String str90 = "obfs";
            String str91 = "version";
            String str92 = "psk";
            String str93 = "sni";
            String str94 = "skip-cert-verify";
            Object obj17 = "on";
            Object obj18 = "auto";
            String str95 = "underlying-proxy";
            String str96 = "vmess-aead";
            String str97 = "block-quic";
            try {
                try {
                } catch (Exception e3) {
                    e = e3;
                    str70 = lowerCase;
                }
            } catch (Exception e4) {
                e = e4;
            }
            switch (lowerCase.hashCode()) {
                case -1545420785:
                    strArr2 = strArr;
                    str2 = "udp-relay";
                    obj = "http";
                    str3 = str86;
                    str4 = str88;
                    str5 = str90;
                    obj2 = obj17;
                    str6 = str95;
                    str7 = str97;
                    obj3 = "tls";
                    obj4 = obj18;
                    z2 = z;
                    if (!lowerCase.equals("shadowsocks")) {
                        break;
                    }
                    lu3 lu3Var = lu3.NONE;
                    length = strArr2.length;
                    lu3 lu3Var2 = lu3Var;
                    tn tnVar10 = tnVar9;
                    String str98 = null;
                    i4 = 3;
                    strU2 = null;
                    String strS5 = null;
                    String strS6 = null;
                    String strS7 = null;
                    boolean z5 = z2;
                    while (i4 < length) {
                        int i9 = i4;
                        String str99 = (String) qe.m0(i4, strArr2);
                        if (str99 == null) {
                            obj13 = obj;
                            i5 = length;
                            obj14 = obj3;
                        } else {
                            i5 = length;
                            if (c63.d(str99, str72)) {
                                String str100 = str72;
                                strS2 = c63.s(str99, str100);
                                obj13 = obj;
                                str45 = str4;
                                str72 = str100;
                                obj14 = obj3;
                                str98 = strS2;
                                i4 = i9 + 1;
                                obj3 = obj14;
                                length = i5;
                                obj = obj13;
                                str4 = str45;
                                z5 = z5;
                            } else {
                                if (c63.d(str99, str89)) {
                                    String str101 = str89;
                                    strU2 = c63.s(str99, str101);
                                    obj13 = obj;
                                    str45 = str4;
                                    str89 = str101;
                                    obj14 = obj3;
                                    z3 = z5;
                                } else {
                                    if (c63.d(str99, str5)) {
                                        String strS8 = c63.s(str99, str5);
                                        obj14 = obj3;
                                        lu3Var2 = n12.c(strS8, obj14) ? lu3.TLS : n12.c(strS8, obj) ? lu3.HTTP : lu3.NONE;
                                        obj13 = obj;
                                        zP = z5;
                                    } else {
                                        obj13 = obj;
                                        obj14 = obj3;
                                        if (c63.d(str99, str4)) {
                                            strS6 = c63.s(str99, str4);
                                            zP = z5;
                                        } else if (c63.d(str99, str3)) {
                                            strS5 = c63.s(str99, str3);
                                            zP = z5;
                                        } else if (c63.d(str99, str2)) {
                                            zP = c63.p(str99, str2);
                                        } else if (c63.d(str99, str6)) {
                                            strS7 = c63.s(str99, str6);
                                            zP = z5;
                                        } else if (c63.d(str99, str7)) {
                                            String strS9 = c63.s(str99, str7);
                                            if (strS9 != null) {
                                                lowerCase8 = strS9.toLowerCase(Locale.ROOT);
                                                lowerCase8.getClass();
                                            } else {
                                                lowerCase8 = null;
                                            }
                                            if (lowerCase8 != null) {
                                                int iHashCode = lowerCase8.hashCode();
                                                str45 = str4;
                                                if (iHashCode != 3551) {
                                                    if (iHashCode != 109935) {
                                                        if (iHashCode == 3005871) {
                                                            lowerCase8.equals(obj4);
                                                        }
                                                    } else if (lowerCase8.equals("off")) {
                                                        tnVar10 = tnVar8;
                                                        z5 = z5;
                                                        strS2 = str98;
                                                    }
                                                } else if (lowerCase8.equals(obj2)) {
                                                    tnVar10 = tnVar7;
                                                    z5 = z5;
                                                    strS2 = str98;
                                                }
                                                str98 = strS2;
                                                i4 = i9 + 1;
                                                obj3 = obj14;
                                                length = i5;
                                                obj = obj13;
                                                str4 = str45;
                                                z5 = z5;
                                            } else {
                                                str45 = str4;
                                            }
                                            tnVar10 = tnVar9;
                                            z5 = z5;
                                            strS2 = str98;
                                            str98 = strS2;
                                            i4 = i9 + 1;
                                            obj3 = obj14;
                                            length = i5;
                                            obj = obj13;
                                            str4 = str45;
                                            z5 = z5;
                                        }
                                    }
                                    str45 = str4;
                                    z3 = zP;
                                }
                                z5 = z3;
                                strS2 = str98;
                                str98 = strS2;
                                i4 = i9 + 1;
                                obj3 = obj14;
                                length = i5;
                                obj = obj13;
                                str4 = str45;
                                z5 = z5;
                            }
                        }
                        str45 = str4;
                        z3 = z5;
                        z5 = z3;
                        strS2 = str98;
                        str98 = strS2;
                        i4 = i9 + 1;
                        obj3 = obj14;
                        length = i5;
                        obj = obj13;
                        str4 = str45;
                        z5 = z5;
                    }
                    String str102 = strArr2[1];
                    int i10 = Integer.parseInt(strArr2[2]);
                    String str103 = str98 == null ? strArr2[3] : str98;
                    if (strU2 == null) {
                        strU2 = c63.u(strArr2[4]);
                        strU2.getClass();
                    }
                    return new mu3(str, str102, i10, str103, strU2, lu3Var2, strS6, strS5, z5 ? 1 : 0, tnVar10, strS7);
                case -1412632689:
                    String str104 = "skip-cert-verify";
                    String str105 = str89;
                    if (lowerCase.equals("anytls")) {
                        int length3 = strArr.length;
                        tn tnVar11 = tnVar9;
                        String str106 = null;
                        int i11 = 3;
                        String str107 = null;
                        String str108 = null;
                        String strS10 = null;
                        boolean zP2 = false;
                        boolean zP3 = true;
                        boolean zP4 = true;
                        while (i11 < length3) {
                            int i12 = length3;
                            String str109 = (String) qe.m0(i11, strArr);
                            if (str109 == null) {
                                str8 = str107;
                                tnVar = tnVar11;
                                str9 = str105;
                                str10 = str74;
                            } else {
                                str8 = str107;
                                if (c63.d(str109, str105)) {
                                    strU = c63.s(str109, str105);
                                    str9 = str105;
                                    str107 = str8;
                                } else if (c63.d(str109, str104)) {
                                    String str110 = str104;
                                    zP2 = c63.p(str109, str110);
                                    str104 = str110;
                                    str9 = str105;
                                    str107 = str8;
                                    strU = str106;
                                } else {
                                    if (c63.d(str109, "sni")) {
                                        String strS11 = c63.s(str109, "sni");
                                        if (n12.c(strS11, "off")) {
                                            strS11 = null;
                                        }
                                        if (strS11 != null && !kx0.d(false).e(strS11)) {
                                            String str111 = "invalid sni value: " + ((Object) strS11);
                                            if (fy4.b) {
                                                tnVar4 = tnVar11;
                                                str9 = str105;
                                                Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str111);
                                                str13 = "Decoder";
                                                str14 = str111;
                                            } else {
                                                tnVar4 = tnVar11;
                                                str9 = str105;
                                                str13 = "Decoder";
                                                str14 = str111;
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.e(str13, str14, null);
                                            }
                                            strU = str106;
                                            tnVar3 = tnVar4;
                                            str10 = str74;
                                            str107 = null;
                                        }
                                        str9 = str105;
                                        tnVar3 = tnVar11;
                                        str10 = str74;
                                        str107 = strS11;
                                        strU = str106;
                                    } else {
                                        tnVar = tnVar11;
                                        str9 = str105;
                                        if (c63.d(str109, "server-cert-fingerprint-sha256")) {
                                            String strS12 = c63.s(str109, "server-cert-fingerprint-sha256");
                                            if (strS12 == null || b.d(strS12)) {
                                                str108 = strS12;
                                                tnVar3 = tnVar;
                                                str10 = str74;
                                            } else {
                                                String str112 = "invalid server-cert-fingerprint-sha256: " + ((Object) strS12);
                                                if (fy4.b) {
                                                    Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str112);
                                                    str11 = "Decoder";
                                                    str12 = str112;
                                                } else {
                                                    str11 = "Decoder";
                                                    str12 = str112;
                                                }
                                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                    a1.e(str11, str12, null);
                                                }
                                                strU = str106;
                                                tnVar3 = tnVar;
                                                str10 = str74;
                                                str107 = str8;
                                                str108 = null;
                                            }
                                        } else {
                                            if (c63.d(str109, str74)) {
                                                str10 = str74;
                                                zP3 = c63.p(str109, str10);
                                            } else {
                                                str10 = str74;
                                                if (c63.d(str109, "udp-relay")) {
                                                    zP4 = c63.p(str109, "udp-relay");
                                                } else if (c63.d(str109, str95)) {
                                                    strS10 = c63.s(str109, str95);
                                                } else if (c63.d(str109, str97)) {
                                                    String strS13 = c63.s(str109, str97);
                                                    if (strS13 != null) {
                                                        lowerCase2 = strS13.toLowerCase(Locale.ROOT);
                                                        lowerCase2.getClass();
                                                    } else {
                                                        lowerCase2 = null;
                                                    }
                                                    if (lowerCase2 == null) {
                                                        tnVar2 = tnVar9;
                                                        tnVar3 = tnVar2;
                                                    } else {
                                                        int iHashCode2 = lowerCase2.hashCode();
                                                        if (iHashCode2 != 3551) {
                                                            if (iHashCode2 != 109935) {
                                                                if (iHashCode2 == 3005871) {
                                                                    lowerCase2.equals(obj18);
                                                                }
                                                            } else if (lowerCase2.equals("off")) {
                                                                tnVar2 = tnVar8;
                                                                tnVar3 = tnVar2;
                                                            }
                                                            tnVar2 = tnVar9;
                                                            tnVar3 = tnVar2;
                                                        } else if (lowerCase2.equals(obj17)) {
                                                            tnVar2 = tnVar7;
                                                            tnVar3 = tnVar2;
                                                        } else {
                                                            tnVar2 = tnVar9;
                                                            tnVar3 = tnVar2;
                                                        }
                                                    }
                                                } else {
                                                    if (i11 == 3) {
                                                        strU = c63.u(str109);
                                                    }
                                                    tnVar3 = tnVar;
                                                    str107 = str8;
                                                }
                                            }
                                            tnVar3 = tnVar;
                                        }
                                        str107 = str8;
                                        strU = str106;
                                    }
                                    i11++;
                                    str106 = strU;
                                    str74 = str10;
                                    tnVar11 = tnVar3;
                                    length3 = i12;
                                    str105 = str9;
                                }
                                tnVar3 = tnVar11;
                                str10 = str74;
                                i11++;
                                str106 = strU;
                                str74 = str10;
                                tnVar11 = tnVar3;
                                length3 = i12;
                                str105 = str9;
                            }
                            strU = str106;
                            tnVar3 = tnVar;
                            str107 = str8;
                            i11++;
                            str106 = strU;
                            str74 = str10;
                            tnVar11 = tnVar3;
                            length3 = i12;
                            str105 = str9;
                        }
                        String str113 = strArr[1];
                        int i13 = Integer.parseInt(strArr[2]);
                        str106.getClass();
                        return new s9(str, str113, i13, str106, zP2, str107, str108, zP3, zP4, tnVar11, strS10);
                    }
                    break;
                    break;
                case -1349088399:
                    str15 = str;
                    str2 = "udp-relay";
                    obj = "http";
                    str3 = str86;
                    str4 = str88;
                    str5 = str90;
                    obj2 = obj17;
                    str6 = str95;
                    str7 = str97;
                    obj3 = "tls";
                    obj4 = obj18;
                    if (lowerCase.equals("custom")) {
                        strArr2 = strArr;
                        str89 = str89;
                        z2 = false;
                        lu3 lu3Var3 = lu3.NONE;
                        length = strArr2.length;
                        lu3 lu3Var22 = lu3Var3;
                        tn tnVar102 = tnVar9;
                        String str982 = null;
                        i4 = 3;
                        strU2 = null;
                        String strS52 = null;
                        String strS62 = null;
                        String strS72 = null;
                        boolean z52 = z2;
                        while (i4 < length) {
                        }
                        String str1022 = strArr2[1];
                        int i102 = Integer.parseInt(strArr2[2]);
                        if (str982 == null) {
                        }
                        if (strU2 == null) {
                        }
                        return new mu3(str, str1022, i102, str103, strU2, lu3Var22, strS62, strS52, z52 ? 1 : 0, tnVar102, strS72);
                    }
                    break;
                case -1331586071:
                    str15 = str;
                    if (lowerCase.equals("direct")) {
                        int length4 = strArr.length;
                        tn tnVar12 = tnVar8;
                        for (int i14 = 1; i14 < length4; i14++) {
                            String str114 = (String) qe.m0(i14, strArr);
                            if (str114 != null && c63.d(str114, str97)) {
                                String strS14 = c63.s(str114, str97);
                                if (strS14 != null) {
                                    lowerCase3 = strS14.toLowerCase(Locale.ROOT);
                                    lowerCase3.getClass();
                                } else {
                                    lowerCase3 = null;
                                }
                                if (lowerCase3 != null) {
                                    int iHashCode3 = lowerCase3.hashCode();
                                    if (iHashCode3 == 3551) {
                                        tnVar12 = !lowerCase3.equals(obj17) ? tnVar9 : tnVar7;
                                    } else if (iHashCode3 != 109935) {
                                        if (iHashCode3 == 3005871) {
                                            lowerCase3.equals(obj18);
                                        }
                                    } else if (lowerCase3.equals("off")) {
                                        tnVar12 = tnVar8;
                                    }
                                }
                            }
                        }
                        return new tu0(str15, tnVar12, 2);
                    }
                    break;
                case -974178767:
                    String str115 = "skip-cert-verify";
                    String str116 = str89;
                    try {
                        if (lowerCase.equals("tuic-v5")) {
                            int length5 = strArr.length;
                            tn tnVar13 = tnVar9;
                            Integer num = null;
                            int i15 = 3;
                            String strS15 = null;
                            String strS16 = null;
                            String str117 = null;
                            ArrayList arrayListB = null;
                            String str118 = null;
                            String str119 = null;
                            String strS17 = null;
                            boolean zP5 = false;
                            boolean zP6 = true;
                            while (i15 < length5) {
                                int i16 = length5;
                                String str120 = (String) qe.m0(i15, strArr);
                                if (str120 == null) {
                                    str16 = str116;
                                    i = i15;
                                } else {
                                    i = i15;
                                    if (c63.d(str120, str76)) {
                                        String str121 = str76;
                                        strS15 = c63.s(str120, str121);
                                        str16 = str116;
                                        str76 = str121;
                                    } else if (c63.d(str120, str116)) {
                                        strS16 = c63.s(str120, str116);
                                        str16 = str116;
                                    } else {
                                        if (c63.d(str120, str75)) {
                                            str17 = str75;
                                            String strS18 = c63.s(str120, str17);
                                            if (strS18 == null || strS18.length() == 0) {
                                                strS18 = null;
                                            }
                                            str117 = strS18;
                                            str16 = str116;
                                        } else {
                                            str16 = str116;
                                            str17 = str75;
                                            if (c63.d(str120, str81)) {
                                                String str122 = str81;
                                                String strS19 = c63.s(str120, str122);
                                                arrayListB = strS19 != null ? b(strS19) : null;
                                                str81 = str122;
                                            } else {
                                                if (c63.d(str120, str79)) {
                                                    String str123 = str79;
                                                    numQ = c63.q(str120, str123, "");
                                                    str79 = str123;
                                                    str75 = str17;
                                                } else if (c63.d(str120, str115)) {
                                                    String str124 = str115;
                                                    zP5 = c63.p(str120, str124);
                                                    str115 = str124;
                                                } else {
                                                    str75 = str17;
                                                    String str125 = str115;
                                                    if (c63.d(str120, "sni")) {
                                                        String strS20 = c63.s(str120, "sni");
                                                        if (n12.c(strS20, "off")) {
                                                            strS20 = null;
                                                        }
                                                        if (strS20 == null || kx0.d(false).e(strS20)) {
                                                            str115 = str125;
                                                            str118 = strS20;
                                                        } else {
                                                            String str126 = "invalid sni value: " + ((Object) strS20);
                                                            if (fy4.b) {
                                                                str115 = str125;
                                                                Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str126);
                                                                str20 = "Decoder";
                                                                str21 = str126;
                                                            } else {
                                                                str115 = str125;
                                                                str20 = "Decoder";
                                                                str21 = str126;
                                                            }
                                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                                a1.e(str20, str21, null);
                                                            }
                                                            numQ = num;
                                                            str118 = null;
                                                        }
                                                    } else {
                                                        str115 = str125;
                                                        if (c63.d(str120, "server-cert-fingerprint-sha256")) {
                                                            String strS21 = c63.s(str120, "server-cert-fingerprint-sha256");
                                                            if (strS21 == null || b.d(strS21)) {
                                                                str119 = strS21;
                                                            } else {
                                                                String str127 = "invalid server-cert-fingerprint-sha256: " + ((Object) strS21);
                                                                if (fy4.b) {
                                                                    Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str127);
                                                                    str18 = "Decoder";
                                                                    str19 = str127;
                                                                } else {
                                                                    str18 = "Decoder";
                                                                    str19 = str127;
                                                                }
                                                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                                    a1.e(str18, str19, null);
                                                                }
                                                                numQ = num;
                                                                str119 = null;
                                                            }
                                                        } else if (c63.d(str120, "udp-relay")) {
                                                            zP6 = c63.p(str120, "udp-relay");
                                                        } else if (c63.d(str120, str95)) {
                                                            strS17 = c63.s(str120, str95);
                                                        } else if (c63.d(str120, str97)) {
                                                            String strS22 = c63.s(str120, str97);
                                                            if (strS22 != null) {
                                                                lowerCase4 = strS22.toLowerCase(Locale.ROOT);
                                                                lowerCase4.getClass();
                                                            } else {
                                                                lowerCase4 = null;
                                                            }
                                                            if (lowerCase4 == null) {
                                                                tnVar13 = tnVar9;
                                                            } else {
                                                                int iHashCode4 = lowerCase4.hashCode();
                                                                if (iHashCode4 != 3551) {
                                                                    if (iHashCode4 != 109935) {
                                                                        if (iHashCode4 == 3005871) {
                                                                            lowerCase4.equals(obj18);
                                                                        }
                                                                    } else if (lowerCase4.equals("off")) {
                                                                        tnVar13 = tnVar8;
                                                                    }
                                                                    tnVar13 = tnVar9;
                                                                } else if (lowerCase4.equals(obj17)) {
                                                                    tnVar13 = tnVar7;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                i15 = i + 1;
                                                num = numQ;
                                                length5 = i16;
                                                str116 = str16;
                                            }
                                        }
                                        str75 = str17;
                                    }
                                }
                                numQ = num;
                                i15 = i + 1;
                                num = numQ;
                                length5 = i16;
                                str116 = str16;
                            }
                            if (strS15 != null) {
                                try {
                                    if (strS15.length() != 0) {
                                        if (!a.d(strS15)) {
                                            throw new IllegalArgumentException(("tuic-v5 uuid is not a valid UUID: " + ((Object) strS15)).toString());
                                        }
                                        if (strS16 == null || strS16.length() == 0) {
                                            throw new IllegalArgumentException(("tuic-v5 password is empty: " + str).toString());
                                        }
                                        try {
                                            return new ai4(str, strArr[1], Integer.parseInt(strArr[2]), strS15, strS16, str117, arrayListB, num, zP5, str118, str119, zP6, tnVar13, strS17);
                                        } catch (Exception e5) {
                                            e = e5;
                                            str93 = str;
                                        }
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    str93 = str;
                                }
                            }
                            throw new IllegalArgumentException(("tuic-v5 uuid is empty: " + str).toString());
                        }
                        break;
                    } catch (Exception e7) {
                        e = e7;
                        str93 = str;
                    }
                    str70 = str93;
                    st4.l(fw.u("decode proxy failed: ", str70, ", ", e.getMessage()), e);
                    return null;
                case -940771008:
                    str70 = str;
                    try {
                    } catch (Exception e8) {
                        e = e8;
                    }
                    if (lowerCase.equals("wireguard")) {
                        String str128 = (String) qe.m0(1, strArr);
                        String strS23 = (str128 == null || !c63.d(str128, "section-name")) ? null : c63.s(str128, "section-name");
                        try {
                        } catch (Exception e9) {
                            e = e9;
                        }
                        if (strS23 == null) {
                            throw new IllegalArgumentException("wireguard section-name not found: ".concat(str70).toString());
                        }
                        int length6 = strArr.length;
                        tn tnVar14 = tnVar9;
                        for (int i17 = 2; i17 < length6; i17++) {
                            String str129 = (String) qe.m0(i17, strArr);
                            if (str129 != null && c63.d(str129, str97)) {
                                String strS24 = c63.s(str129, str97);
                                if (strS24 != null) {
                                    lowerCase5 = strS24.toLowerCase(Locale.ROOT);
                                    lowerCase5.getClass();
                                } else {
                                    lowerCase5 = null;
                                }
                                if (lowerCase5 == null) {
                                    tnVar14 = tnVar9;
                                } else {
                                    int iHashCode5 = lowerCase5.hashCode();
                                    if (iHashCode5 != 3551) {
                                        if (iHashCode5 != 109935) {
                                            if (iHashCode5 == 3005871) {
                                                lowerCase5.equals(obj18);
                                            }
                                        } else if (lowerCase5.equals("off")) {
                                            tnVar14 = tnVar8;
                                        }
                                        tnVar14 = tnVar9;
                                    } else if (lowerCase5.equals(obj17)) {
                                        tnVar14 = tnVar7;
                                    }
                                }
                            }
                        }
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next = it2.next();
                                if (n12.c(((a02) next).a, "WireGuard " + ((Object) strS23))) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        a02 a02Var = (a02) next;
                        if (a02Var == null) {
                            throw new IllegalArgumentException("wireguard section " + ((Object) strS23) + " not found: " + str70);
                        }
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        ArrayList arrayList2 = new ArrayList();
                        Collection<b02> collectionB = a02Var.b();
                        collectionB.getClass();
                        int i18 = 1280;
                        String strA = null;
                        String strA2 = null;
                        String strA3 = null;
                        String str130 = null;
                        String str131 = null;
                        e03 e03VarU = null;
                        int iIntValue = 0;
                        for (b02 b02Var : collectionB) {
                            String str132 = b02Var.a;
                            switch (str132.hashCode()) {
                                case -491150233:
                                    i2 = i18;
                                    str22 = strA2;
                                    tnVar5 = tnVar14;
                                    if (str132.equals("dns-server")) {
                                        String[] strArr5 = b02Var.b;
                                        strArr5.getClass();
                                        for (String str133 : strArr5) {
                                            str133.getClass();
                                            if (!xz1.a(str133)) {
                                                throw new IllegalArgumentException(("invalid dns-server format: " + str133 + ", must be valid IP address").toString());
                                            }
                                            linkedHashSet.add(str133);
                                        }
                                    }
                                    i18 = i2;
                                    strA2 = str22;
                                    str70 = str;
                                    tnVar14 = tnVar5;
                                    break;
                                case 108462:
                                    i2 = i18;
                                    str22 = strA2;
                                    tnVar5 = tnVar14;
                                    if (str132.equals("mtu")) {
                                        String strA4 = b02Var.a();
                                        strA4.getClass();
                                        i18 = Integer.parseInt(strA4);
                                        strA2 = str22;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    } else {
                                        i18 = i2;
                                        strA2 = str22;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    }
                                    break;
                                case 3436898:
                                    if (str132.equals("peer")) {
                                        String[] strArr6 = b02Var.b;
                                        strArr6.getClass();
                                        int length7 = strArr6.length;
                                        int i19 = 0;
                                        while (i19 < length7) {
                                            int i20 = i18;
                                            String str134 = strArr6[i19];
                                            str134.getClass();
                                            String str135 = strA2;
                                            List listK0 = p44.K0(p44.G0(")", p44.F0(str134, "(")), new char[]{'='}, 6);
                                            if (listK0.size() >= 2) {
                                                String string = p44.U0((String) d70.d0(listK0)).toString();
                                                strArr3 = strArr6;
                                                switch (string.hashCode()) {
                                                    case -1745954712:
                                                        tnVar6 = tnVar14;
                                                        if (string.equals("keepalive")) {
                                                            Integer numM0 = w44.m0(p44.U0((String) listK0.get(1)).toString());
                                                            iIntValue = numM0 != null ? numM0.intValue() : 0;
                                                        }
                                                        break;
                                                    case 440207322:
                                                        tnVar6 = tnVar14;
                                                        if (string.equals("preshared-key")) {
                                                            String string2 = p44.U0((String) listK0.get(1)).toString();
                                                            str131 = (listK0.size() <= 2 || !n12.c(listK0.get(2), "")) ? string2 : ((Object) string2) + "=";
                                                        }
                                                        break;
                                                    case 1511717511:
                                                        tnVar6 = tnVar14;
                                                        if (string.equals("allowed-ips")) {
                                                            String str136 = str77;
                                                            Iterator it3 = p44.K0(p44.G0(str136, p44.F0(p44.U0((String) listK0.get(1)).toString(), str136)), new char[]{StringUtil.COMMA}, 6).iterator();
                                                            while (it3.hasNext()) {
                                                                List listK02 = p44.K0(p44.U0((String) it3.next()).toString(), new char[]{'/'}, 6);
                                                                if (listK02.size() == 2) {
                                                                    String str137 = (String) d70.d0(listK02);
                                                                    str137.getClass();
                                                                    if (xz1.a(str137)) {
                                                                        InetAddress byName = InetAddress.getByName((String) d70.d0(listK02));
                                                                        byName.getClass();
                                                                        it = it3;
                                                                        arrayList2.add(new fm3(byName, Integer.parseInt((String) listK02.get(1))));
                                                                    } else {
                                                                        it = it3;
                                                                    }
                                                                }
                                                                it3 = it;
                                                            }
                                                            str77 = str136;
                                                        }
                                                        break;
                                                    case 1741102485:
                                                        tnVar6 = tnVar14;
                                                        if (string.equals("endpoint")) {
                                                            List listK03 = p44.K0(p44.U0((String) listK0.get(1)).toString(), new char[]{':'}, 6);
                                                            e03VarU = n12.U(d70.d0(listK03), Integer.valueOf(Integer.parseInt((String) listK03.get(1))));
                                                        }
                                                        break;
                                                    case 1903323387:
                                                        tnVar6 = tnVar14;
                                                        if (string.equals("public-key")) {
                                                            String string3 = p44.U0((String) listK0.get(1)).toString();
                                                            str130 = (listK0.size() <= 2 || !n12.c(listK0.get(2), "")) ? string3 : ((Object) string3) + "=";
                                                        }
                                                        break;
                                                }
                                                i19++;
                                                i18 = i20;
                                                strA2 = str135;
                                                tnVar14 = tnVar6;
                                                strArr6 = strArr3;
                                            } else {
                                                strArr3 = strArr6;
                                            }
                                            tnVar6 = tnVar14;
                                            i19++;
                                            i18 = i20;
                                            strA2 = str135;
                                            tnVar14 = tnVar6;
                                            strArr6 = strArr3;
                                        }
                                        tnVar5 = tnVar14;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    } else {
                                        i2 = i18;
                                        str22 = strA2;
                                        tnVar5 = tnVar14;
                                        i18 = i2;
                                        strA2 = str22;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    }
                                    break;
                                case 1970454293:
                                    if (str132.equals("private-key")) {
                                        strA = b02Var.a();
                                        tnVar5 = tnVar14;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    } else {
                                        i2 = i18;
                                        str22 = strA2;
                                        tnVar5 = tnVar14;
                                        i18 = i2;
                                        strA2 = str22;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    }
                                    break;
                                case 1971158821:
                                    if (str132.equals("self-ip-v6")) {
                                        strA3 = b02Var.a();
                                        tnVar5 = tnVar14;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    } else {
                                        i2 = i18;
                                        str22 = strA2;
                                        tnVar5 = tnVar14;
                                        i18 = i2;
                                        strA2 = str22;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    }
                                    break;
                                case 1978078024:
                                    if (str132.equals("self-ip")) {
                                        strA2 = b02Var.a();
                                        tnVar5 = tnVar14;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    } else {
                                        i2 = i18;
                                        str22 = strA2;
                                        tnVar5 = tnVar14;
                                        i18 = i2;
                                        strA2 = str22;
                                        str70 = str;
                                        tnVar14 = tnVar5;
                                    }
                                    break;
                                default:
                                    i2 = i18;
                                    str22 = strA2;
                                    tnVar5 = tnVar14;
                                    i18 = i2;
                                    strA2 = str22;
                                    str70 = str;
                                    tnVar14 = tnVar5;
                                    break;
                            }
                            break;
                        }
                        int i21 = i18;
                        String str138 = strA2;
                        tn tnVar15 = tnVar14;
                        if (strA == null) {
                            throw new IllegalArgumentException(("private-key not found: " + str).toString());
                        }
                        try {
                            Base64.decode(strA, 0);
                            if (str138 == null) {
                                throw new IllegalArgumentException(("self-ip not found: " + str).toString());
                            }
                            if (!xz1.b(str138)) {
                                throw new IllegalArgumentException(("self-ip must be a valid IPv4 address: " + ((Object) str138)).toString());
                            }
                            if (strA3 != null && !xz1.c(strA3)) {
                                throw new IllegalArgumentException(("self-ip-v6 must be a valid IPv6 address: " + ((Object) strA3)).toString());
                            }
                            if (str130 == null) {
                                throw new IllegalArgumentException(("public-key not found: " + str).toString());
                            }
                            Base64.decode(str130, 0);
                            if (arrayList2.isEmpty()) {
                                throw new IllegalArgumentException(("allowed-ips not found: " + str).toString());
                            }
                            if (e03VarU == null) {
                                throw new IllegalArgumentException(("endpoint not found: " + str).toString());
                            }
                            if (str131 != null) {
                                Base64.decode(str131, 0);
                            }
                            try {
                                return new fw4(str, strA, str138, strA3, linkedHashSet, i21, new ew4(str130, str131, arrayList2, e03VarU, iIntValue), tnVar15);
                            } catch (Exception e10) {
                                e = e10;
                                str84 = str;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            str84 = str;
                        }
                        str70 = str84;
                        st4.l(fw.u("decode proxy failed: ", str70, ", ", e.getMessage()), e);
                        return null;
                    }
                    break;
                case -934710369:
                    str23 = str;
                    break;
                case -897048346:
                    strArr4 = strArr;
                    obj5 = "socks5-tls";
                    str24 = "udp-relay";
                    obj6 = "socks5";
                    obj7 = "http";
                    obj8 = "https";
                    obj9 = obj17;
                    str25 = str95;
                    str26 = str97;
                    str27 = "tls";
                    obj10 = obj18;
                    if (lowerCase.equals(obj6)) {
                        c = 1;
                        String str139 = strArr4[c];
                        int i22 = Integer.parseInt(strArr4[2]);
                        Object obj19 = obj6;
                        length2 = strArr4.length;
                        Object obj20 = obj7;
                        tn tnVar16 = tnVar9;
                        i8 = 3;
                        String str140 = null;
                        String strU4 = null;
                        String strU5 = null;
                        String str141 = null;
                        String strS25 = null;
                        boolean zP7 = false;
                        boolean zP8 = false;
                        boolean zP9 = false;
                        while (i8 < length2) {
                            int i23 = length2;
                            String str142 = (String) qe.m0(i8, strArr4);
                            if (str142 != null) {
                                if (c63.d(str142, str27)) {
                                    String str143 = str27;
                                    zP7 = c63.p(str142, str143);
                                    str65 = str94;
                                    str27 = str143;
                                    str64 = str93;
                                } else if (c63.d(str142, str94)) {
                                    zP8 = c63.p(str142, str94);
                                } else if (c63.d(str142, str93)) {
                                    String strS26 = c63.s(str142, str93);
                                    if (n12.c(strS26, "off")) {
                                        strS26 = null;
                                    }
                                    if (strS26 == null || kx0.d(false).e(strS26)) {
                                        str64 = str93;
                                        str65 = str94;
                                        str140 = strS26;
                                    } else {
                                        String str144 = "invalid sni value: " + ((Object) strS26);
                                        if (fy4.b) {
                                            str64 = str93;
                                            str65 = str94;
                                            Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str144);
                                            str68 = "Decoder";
                                            str69 = str144;
                                        } else {
                                            str64 = str93;
                                            str65 = str94;
                                            str68 = "Decoder";
                                            str69 = str144;
                                        }
                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                            a1.e(str68, str69, null);
                                        }
                                        str140 = null;
                                    }
                                } else {
                                    str64 = str93;
                                    str65 = str94;
                                    if (c63.d(str142, "server-cert-fingerprint-sha256")) {
                                        String strS27 = c63.s(str142, "server-cert-fingerprint-sha256");
                                        if (strS27 == null || b.d(strS27)) {
                                            str141 = strS27;
                                        } else {
                                            String str145 = "invalid server-cert-fingerprint-sha256: " + ((Object) strS27);
                                            if (fy4.b) {
                                                Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str145);
                                                str66 = "Decoder";
                                                str67 = str145;
                                            } else {
                                                str66 = "Decoder";
                                                str67 = str145;
                                            }
                                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                a1.e(str66, str67, null);
                                            }
                                            str141 = null;
                                        }
                                    } else if (c63.d(str142, str24)) {
                                        zP9 = c63.p(str142, str24);
                                    } else if (c63.d(str142, str25)) {
                                        strS25 = c63.s(str142, str25);
                                    } else if (!c63.d(str142, "tfo")) {
                                        if (c63.d(str142, str26)) {
                                            String strS28 = c63.s(str142, str26);
                                            if (strS28 != null) {
                                                lowerCase11 = strS28.toLowerCase(Locale.ROOT);
                                                lowerCase11.getClass();
                                            } else {
                                                lowerCase11 = null;
                                            }
                                            if (lowerCase11 != null) {
                                                int iHashCode6 = lowerCase11.hashCode();
                                                if (iHashCode6 == 3551) {
                                                    tnVar16 = !lowerCase11.equals(obj9) ? tnVar9 : tnVar7;
                                                } else if (iHashCode6 != 109935) {
                                                    if (iHashCode6 == 3005871) {
                                                        lowerCase11.equals(obj10);
                                                    }
                                                } else if (lowerCase11.equals("off")) {
                                                    tnVar16 = tnVar8;
                                                }
                                            }
                                        } else if (i8 == 3) {
                                            strU4 = c63.u(str142);
                                        } else if (i8 == 4) {
                                            strU5 = c63.u(str142);
                                        }
                                    }
                                }
                                i8++;
                                str93 = str64;
                                length2 = i23;
                                str94 = str65;
                                strArr4 = strArr;
                            }
                            str64 = str93;
                            str65 = str94;
                            i8++;
                            str93 = str64;
                            length2 = i23;
                            str94 = str65;
                            strArr4 = strArr;
                        }
                        String str146 = (str140 == null && xz1.a(str140)) ? null : str140;
                        return (!n12.c(lowerCase, obj8) || (n12.c(lowerCase, obj20) && zP7)) ? new gv1(str, str139, i22, strU4, strU5, zP8, str146, str141, tnVar16, strS25) : (n12.c(lowerCase, obj5) || (n12.c(lowerCase, obj19) && zP7)) ? new az3(str, str139, i22, strU4, strU5, zP8, str146, str141, tnVar16, strS25) : n12.c(lowerCase, obj19) ? new zy3(str, str139, i22, strU4, strU5, zP9, tnVar16, strS25) : new ou1(str, str139, i22, strU4, strU5, tnVar16, strS25);
                    }
                    break;
                    break;
                case -865292602:
                    String str147 = "invalid sni value: ";
                    String str148 = str;
                    String str149 = "ws-headers";
                    if (lowerCase.equals("trojan")) {
                        HashMap map2 = new HashMap();
                        int length8 = strArr.length;
                        Object obj21 = obj18;
                        tn tnVar17 = tnVar9;
                        String str150 = "/";
                        int i24 = 3;
                        String str151 = null;
                        String str152 = null;
                        String str153 = null;
                        String strS29 = null;
                        boolean zP10 = false;
                        boolean zP11 = false;
                        boolean zP12 = false;
                        while (i24 < length8) {
                            int i25 = i24;
                            String str154 = (String) qe.m0(i24, strArr);
                            if (str154 == null) {
                                map = map2;
                                str28 = str82;
                                i3 = length8;
                            } else {
                                i3 = length8;
                                if (c63.d(str154, str89)) {
                                    String strS30 = c63.s(str154, str89);
                                    if (strS30 == null || strS30.length() == 0) {
                                        throw new IllegalArgumentException(("trojan password is empty: " + str148).toString());
                                    }
                                    map = map2;
                                    str151 = strS30;
                                } else if (c63.d(str154, "ws")) {
                                    map = map2;
                                    zP10 = c63.p(str154, "ws");
                                } else if (c63.d(str154, str82)) {
                                    String strS31 = c63.s(str154, str82);
                                    str150 = strS31 == null ? "/" : strS31;
                                    map = map2;
                                } else {
                                    if (c63.d(str154, str149)) {
                                        str29 = str149;
                                        String strS32 = c63.s(str154, str29);
                                        if (strS32 != null) {
                                            str28 = str82;
                                            Iterator it4 = p44.K0(strS32, new char[]{'|'}, 6).iterator();
                                            while (it4.hasNext()) {
                                                Iterator it5 = it4;
                                                List listK04 = p44.K0((String) it4.next(), new char[]{':'}, 6);
                                                if (listK04.size() == 2) {
                                                    Object obj22 = listK04.get(0);
                                                    String strU6 = c63.u((String) listK04.get(1));
                                                    strU6.getClass();
                                                    map2.put(obj22, strU6);
                                                }
                                                it4 = it5;
                                            }
                                        } else {
                                            str28 = str82;
                                        }
                                        map = map2;
                                    } else {
                                        str28 = str82;
                                        str29 = str149;
                                        if (c63.d(str154, "skip-cert-verify")) {
                                            map = map2;
                                            zP11 = c63.p(str154, "skip-cert-verify");
                                        } else {
                                            if (c63.d(str154, "sni")) {
                                                String strS33 = c63.s(str154, "sni");
                                                if (n12.c(strS33, "off")) {
                                                    strS33 = null;
                                                }
                                                if (strS33 == null || kx0.d(false).e(strS33)) {
                                                    map = map2;
                                                    str30 = str147;
                                                    str152 = strS33;
                                                    obj11 = obj17;
                                                    obj12 = obj21;
                                                } else {
                                                    StringBuilder sb = new StringBuilder();
                                                    str30 = str147;
                                                    sb.append(str30);
                                                    sb.append((Object) strS33);
                                                    String string4 = sb.toString();
                                                    if (fy4.b) {
                                                        Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string4);
                                                        str33 = "Decoder";
                                                        str34 = string4;
                                                    } else {
                                                        str33 = "Decoder";
                                                        str34 = string4;
                                                    }
                                                    if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                                        map = map2;
                                                    } else {
                                                        map = map2;
                                                        a1.e(str33, str34, null);
                                                    }
                                                    obj11 = obj17;
                                                    obj12 = obj21;
                                                    str152 = null;
                                                }
                                            } else {
                                                map = map2;
                                                str30 = str147;
                                                if (c63.d(str154, "server-cert-fingerprint-sha256")) {
                                                    String strS34 = c63.s(str154, "server-cert-fingerprint-sha256");
                                                    if (strS34 == null || b.d(strS34)) {
                                                        str153 = strS34;
                                                        obj11 = obj17;
                                                        obj12 = obj21;
                                                    } else {
                                                        String str155 = "invalid server-cert-fingerprint-sha256: " + ((Object) strS34);
                                                        if (fy4.b) {
                                                            Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str155);
                                                            str31 = "Decoder";
                                                            str32 = str155;
                                                        } else {
                                                            str31 = "Decoder";
                                                            str32 = str155;
                                                        }
                                                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                            a1.e(str31, str32, null);
                                                        }
                                                        obj11 = obj17;
                                                        obj12 = obj21;
                                                        str153 = null;
                                                    }
                                                } else {
                                                    if (c63.d(str154, "udp-relay")) {
                                                        zP12 = c63.p(str154, "udp-relay");
                                                    } else if (c63.d(str154, str95)) {
                                                        strS29 = c63.s(str154, str95);
                                                    } else if (c63.d(str154, str97)) {
                                                        String strS35 = c63.s(str154, str97);
                                                        if (strS35 != null) {
                                                            lowerCase6 = strS35.toLowerCase(Locale.ROOT);
                                                            lowerCase6.getClass();
                                                        } else {
                                                            lowerCase6 = null;
                                                        }
                                                        if (lowerCase6 == null) {
                                                            obj11 = obj17;
                                                            obj12 = obj21;
                                                        } else {
                                                            int iHashCode7 = lowerCase6.hashCode();
                                                            if (iHashCode7 == 3551) {
                                                                obj11 = obj17;
                                                                obj12 = obj21;
                                                                tnVar17 = !lowerCase6.equals(obj11) ? tnVar9 : tnVar7;
                                                            } else if (iHashCode7 != 109935) {
                                                                if (iHashCode7 == 3005871) {
                                                                    obj12 = obj21;
                                                                    if (lowerCase6.equals(obj12)) {
                                                                        tnVar17 = tnVar9;
                                                                        obj11 = obj17;
                                                                    }
                                                                    obj11 = obj17;
                                                                }
                                                                obj11 = obj17;
                                                                obj12 = obj21;
                                                            } else {
                                                                obj12 = obj21;
                                                                if (lowerCase6.equals("off")) {
                                                                    tnVar17 = tnVar8;
                                                                    obj11 = obj17;
                                                                } else {
                                                                    obj11 = obj17;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    obj11 = obj17;
                                                    obj12 = obj21;
                                                }
                                            }
                                            obj21 = obj12;
                                            obj17 = obj11;
                                            str147 = str30;
                                            str149 = str29;
                                            length8 = i3;
                                            str82 = str28;
                                            str148 = str;
                                            i24 = i25 + 1;
                                            map2 = map;
                                        }
                                    }
                                    str30 = str147;
                                    obj11 = obj17;
                                    obj12 = obj21;
                                    obj21 = obj12;
                                    obj17 = obj11;
                                    str147 = str30;
                                    str149 = str29;
                                    length8 = i3;
                                    str82 = str28;
                                    str148 = str;
                                    i24 = i25 + 1;
                                    map2 = map;
                                }
                                str28 = str82;
                            }
                            str30 = str147;
                            obj11 = obj17;
                            obj12 = obj21;
                            str29 = str149;
                            obj21 = obj12;
                            obj17 = obj11;
                            str147 = str30;
                            str149 = str29;
                            length8 = i3;
                            str82 = str28;
                            str148 = str;
                            i24 = i25 + 1;
                            map2 = map;
                        }
                        HashMap map3 = map2;
                        String str156 = strArr[1];
                        int i26 = Integer.parseInt(strArr[2]);
                        str151.getClass();
                        return new xh4(str, str156, i26, str151, zP10, str150, map3, zP11, str152, str153, zP12, tnVar17, strS29);
                    }
                    break;
                    break;
                case -463551909:
                    String[] strArr7 = strArr;
                    String str157 = str95;
                    try {
                        if (lowerCase.equals("hysteria2")) {
                            int length9 = strArr7.length;
                            tn tnVar18 = tnVar9;
                            String str158 = null;
                            int i27 = 3;
                            Integer num2 = null;
                            ArrayList arrayListB2 = null;
                            Integer numQ3 = null;
                            String strS36 = null;
                            String str159 = null;
                            String str160 = null;
                            String strS37 = null;
                            boolean zP13 = false;
                            boolean zP14 = true;
                            while (i27 < length9) {
                                int i28 = i27;
                                String str161 = (String) qe.m0(i27, strArr7);
                                if (str161 == null) {
                                    numQ2 = num2;
                                    str36 = str87;
                                    arrayList = arrayListB2;
                                    str40 = str78;
                                    str35 = str89;
                                } else {
                                    numQ2 = num2;
                                    if (c63.d(str161, str89)) {
                                        str35 = str89;
                                        strS = c63.s(str161, str35);
                                        str36 = str87;
                                    } else {
                                        str35 = str89;
                                        if (c63.d(str161, str83)) {
                                            String str162 = str83;
                                            numQ2 = c63.q(str161, str162, "");
                                            str83 = str162;
                                        } else if (c63.d(str161, str81)) {
                                            String str163 = str81;
                                            String strS38 = c63.s(str161, str163);
                                            arrayListB2 = strS38 != null ? b(strS38) : null;
                                            str81 = str163;
                                        } else {
                                            arrayList = arrayListB2;
                                            String str164 = str81;
                                            if (c63.d(str161, str79)) {
                                                String str165 = str79;
                                                numQ3 = c63.q(str161, str165, "");
                                                str81 = str164;
                                                str36 = str87;
                                                str79 = str165;
                                            } else if (c63.d(str161, "skip-cert-verify")) {
                                                zP13 = c63.p(str161, "skip-cert-verify");
                                                str81 = str164;
                                                str36 = str87;
                                            } else if (c63.d(str161, "sni")) {
                                                try {
                                                    String strS39 = c63.s(str161, "sni");
                                                    if (n12.c(strS39, "off")) {
                                                        strS39 = null;
                                                    }
                                                    if (strS39 == null || kx0.d(false).e(strS39)) {
                                                        str81 = str164;
                                                        str36 = str87;
                                                        str159 = strS39;
                                                    } else {
                                                        String str166 = str87 + ((Object) strS39);
                                                        if (fy4.b) {
                                                            str81 = str164;
                                                            str36 = str87;
                                                            Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str166);
                                                            str37 = "Decoder";
                                                            str38 = str166;
                                                        } else {
                                                            str81 = str164;
                                                            str36 = str87;
                                                            str37 = "Decoder";
                                                            str38 = str166;
                                                        }
                                                        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                                            str39 = null;
                                                        } else {
                                                            str39 = null;
                                                            a1.e(str37, str38, null);
                                                        }
                                                        strS = str158;
                                                        str159 = str39;
                                                        arrayListB2 = arrayList;
                                                    }
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    str70 = str;
                                                    st4.l(fw.u("decode proxy failed: ", str70, ", ", e.getMessage()), e);
                                                    return null;
                                                }
                                            } else {
                                                str81 = str164;
                                                str36 = str87;
                                                if (c63.d(str161, "server-cert-fingerprint-sha256")) {
                                                    String strS40 = c63.s(str161, "server-cert-fingerprint-sha256");
                                                    if (strS40 == null || b.d(strS40)) {
                                                        str160 = strS40;
                                                        arrayListB2 = arrayList;
                                                        str157 = str157;
                                                        str40 = str78;
                                                        strS = str158;
                                                        str158 = strS;
                                                        str89 = str35;
                                                        str78 = str40;
                                                        i27 = i28 + 1;
                                                        num2 = numQ2;
                                                        str87 = str36;
                                                        strArr7 = strArr;
                                                    } else {
                                                        String str167 = "invalid server-cert-fingerprint-sha256: " + ((Object) strS40);
                                                        if (fy4.b) {
                                                            str41 = str157;
                                                            Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str167);
                                                            str42 = "Decoder";
                                                            str43 = str167;
                                                        } else {
                                                            str41 = str157;
                                                            str42 = "Decoder";
                                                            str43 = str167;
                                                        }
                                                        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                                            str44 = null;
                                                        } else {
                                                            str44 = null;
                                                            a1.e(str42, str43, null);
                                                        }
                                                        strS = str158;
                                                        str160 = str44;
                                                        arrayListB2 = arrayList;
                                                        str157 = str41;
                                                    }
                                                } else {
                                                    String str168 = str157;
                                                    if (c63.d(str161, str78)) {
                                                        str40 = str78;
                                                        strS36 = c63.s(str161, str40);
                                                    } else {
                                                        str40 = str78;
                                                        if (c63.d(str161, "udp-relay")) {
                                                            zP14 = c63.p(str161, "udp-relay");
                                                        } else if (c63.d(str161, str168)) {
                                                            str157 = str168;
                                                            strS37 = c63.s(str161, str157);
                                                            arrayListB2 = arrayList;
                                                            strS = str158;
                                                            str158 = strS;
                                                            str89 = str35;
                                                            str78 = str40;
                                                            i27 = i28 + 1;
                                                            num2 = numQ2;
                                                            str87 = str36;
                                                            strArr7 = strArr;
                                                        } else {
                                                            str157 = str168;
                                                            if (c63.d(str161, str97)) {
                                                                String strS41 = c63.s(str161, str97);
                                                                if (strS41 != null) {
                                                                    lowerCase7 = strS41.toLowerCase(Locale.ROOT);
                                                                    lowerCase7.getClass();
                                                                } else {
                                                                    lowerCase7 = null;
                                                                }
                                                                if (lowerCase7 == null) {
                                                                    tnVar18 = tnVar9;
                                                                } else {
                                                                    int iHashCode8 = lowerCase7.hashCode();
                                                                    if (iHashCode8 != 3551) {
                                                                        if (iHashCode8 != 109935) {
                                                                            if (iHashCode8 == 3005871) {
                                                                                lowerCase7.equals(obj18);
                                                                            }
                                                                        } else if (lowerCase7.equals("off")) {
                                                                            tnVar18 = tnVar8;
                                                                        }
                                                                        tnVar18 = tnVar9;
                                                                    } else if (lowerCase7.equals(obj17)) {
                                                                        tnVar18 = tnVar7;
                                                                    }
                                                                }
                                                                str158 = strS;
                                                                str89 = str35;
                                                                str78 = str40;
                                                                i27 = i28 + 1;
                                                                num2 = numQ2;
                                                                str87 = str36;
                                                                strArr7 = strArr;
                                                            }
                                                        }
                                                    }
                                                    arrayListB2 = arrayList;
                                                    str157 = str168;
                                                    strS = str158;
                                                    str158 = strS;
                                                    str89 = str35;
                                                    str78 = str40;
                                                    i27 = i28 + 1;
                                                    num2 = numQ2;
                                                    str87 = str36;
                                                    strArr7 = strArr;
                                                }
                                            }
                                            arrayListB2 = arrayList;
                                            str40 = str78;
                                            strS = str158;
                                            str158 = strS;
                                            str89 = str35;
                                            str78 = str40;
                                            i27 = i28 + 1;
                                            num2 = numQ2;
                                            str87 = str36;
                                            strArr7 = strArr;
                                        }
                                        str36 = str87;
                                        str40 = str78;
                                        strS = str158;
                                        str158 = strS;
                                        str89 = str35;
                                        str78 = str40;
                                        i27 = i28 + 1;
                                        num2 = numQ2;
                                        str87 = str36;
                                        strArr7 = strArr;
                                    }
                                    str40 = str78;
                                    str158 = strS;
                                    str89 = str35;
                                    str78 = str40;
                                    i27 = i28 + 1;
                                    num2 = numQ2;
                                    str87 = str36;
                                    strArr7 = strArr;
                                }
                                strS = str158;
                                arrayListB2 = arrayList;
                                str158 = strS;
                                str89 = str35;
                                str78 = str40;
                                i27 = i28 + 1;
                                num2 = numQ2;
                                str87 = str36;
                                strArr7 = strArr;
                            }
                            Integer num3 = num2;
                            ArrayList arrayList3 = arrayListB2;
                            String str169 = strArr[1];
                            int i29 = Integer.parseInt(strArr[2]);
                            str158.getClass();
                            return new jv1(str, str169, i29, str158, num3, arrayList3, numQ3, strS36, zP13, str159, str160, zP14, tnVar18, strS37);
                        }
                    } catch (Exception e13) {
                        e = e13;
                        str70 = str;
                    }
                    break;
                case 3680:
                    str2 = "udp-relay";
                    str3 = str86;
                    str4 = str88;
                    str6 = str95;
                    str7 = str97;
                    obj3 = "tls";
                    obj4 = obj18;
                    if (lowerCase.equals("ss")) {
                        strArr2 = strArr;
                        obj2 = obj17;
                        str5 = str90;
                        obj = "http";
                        z2 = false;
                        lu3 lu3Var32 = lu3.NONE;
                        length = strArr2.length;
                        lu3 lu3Var222 = lu3Var32;
                        tn tnVar1022 = tnVar9;
                        String str9822 = null;
                        i4 = 3;
                        strU2 = null;
                        String strS522 = null;
                        String strS622 = null;
                        String strS722 = null;
                        boolean z522 = z2;
                        while (i4 < length) {
                        }
                        String str10222 = strArr2[1];
                        int i1022 = Integer.parseInt(strArr2[2]);
                        if (str9822 == null) {
                        }
                        if (strU2 == null) {
                        }
                        return new mu3(str, str10222, i1022, str103, strU2, lu3Var222, strS622, strS522, z522 ? 1 : 0, tnVar1022, strS722);
                    }
                    break;
                    break;
                case 3213448:
                    str24 = "udp-relay";
                    obj8 = "https";
                    str25 = str95;
                    str26 = str97;
                    str27 = "tls";
                    obj10 = obj18;
                    if (lowerCase.equals("http")) {
                        strArr4 = strArr;
                        obj9 = obj17;
                        obj5 = "socks5-tls";
                        obj7 = "http";
                        obj6 = "socks5";
                        c = 1;
                        String str1392 = strArr4[c];
                        int i222 = Integer.parseInt(strArr4[2]);
                        Object obj192 = obj6;
                        length2 = strArr4.length;
                        Object obj202 = obj7;
                        tn tnVar162 = tnVar9;
                        i8 = 3;
                        String str1402 = null;
                        String strU42 = null;
                        String strU52 = null;
                        String str1412 = null;
                        String strS252 = null;
                        boolean zP72 = false;
                        boolean zP82 = false;
                        boolean zP92 = false;
                        while (i8 < length2) {
                        }
                        if (str1402 == null) {
                        }
                        if (n12.c(lowerCase, obj8)) {
                        }
                    }
                    break;
                case 99617003:
                    str24 = "udp-relay";
                    obj8 = "https";
                    str25 = str95;
                    str26 = str97;
                    str27 = "tls";
                    obj10 = obj18;
                    if (!lowerCase.equals(obj8)) {
                        break;
                    } else {
                        strArr4 = strArr;
                        obj9 = obj17;
                        obj5 = "socks5-tls";
                        obj6 = "socks5";
                        obj7 = "http";
                        c = 1;
                        String str13922 = strArr4[c];
                        int i2222 = Integer.parseInt(strArr4[2]);
                        Object obj1922 = obj6;
                        length2 = strArr4.length;
                        Object obj2022 = obj7;
                        tn tnVar1622 = tnVar9;
                        i8 = 3;
                        String str14022 = null;
                        String strU422 = null;
                        String strU522 = null;
                        String str14122 = null;
                        String strS2522 = null;
                        boolean zP722 = false;
                        boolean zP822 = false;
                        boolean zP922 = false;
                        while (i8 < length2) {
                        }
                        if (str14022 == null) {
                        }
                        if (n12.c(lowerCase, obj8)) {
                        }
                    }
                    break;
                case 109582442:
                    if (lowerCase.equals("snell")) {
                        String strS42 = "cloudfront.net";
                        int length10 = strArr.length;
                        tn tnVar19 = tnVar9;
                        String str170 = null;
                        String str171 = null;
                        String str172 = null;
                        boolean zP15 = false;
                        int i30 = 1;
                        String strS43 = null;
                        int i31 = 3;
                        while (i31 < length10) {
                            int i32 = length10;
                            String str173 = (String) qe.m0(i31, strArr);
                            if (str173 == null) {
                                str46 = str170;
                                strS3 = str171;
                                strS4 = str172;
                                z4 = zP15;
                                str50 = strS43;
                                str49 = str86;
                                str48 = str88;
                                str47 = str90;
                            } else {
                                str46 = str170;
                                if (c63.d(str173, str92)) {
                                    String str174 = str92;
                                    strU3 = c63.s(str173, str174);
                                    str92 = str174;
                                    strS3 = str171;
                                    strS4 = str172;
                                    str49 = str86;
                                    str48 = str88;
                                    str47 = str90;
                                } else if (c63.d(str173, str91)) {
                                    String str175 = str91;
                                    Integer numQ4 = c63.q(str173, str175, "");
                                    int iIntValue2 = numQ4 != null ? numQ4.intValue() : 1;
                                    if (iIntValue2 >= 5) {
                                        strU3 = str46;
                                        str91 = str175;
                                        strS3 = str171;
                                        strS4 = str172;
                                        str49 = str86;
                                        str48 = str88;
                                        str47 = str90;
                                        i30 = 4;
                                    } else {
                                        i30 = iIntValue2;
                                        str91 = str175;
                                        strS3 = str171;
                                        strS4 = str172;
                                        str49 = str86;
                                        str48 = str88;
                                        str47 = str90;
                                        strU3 = str46;
                                    }
                                } else {
                                    if (c63.d(str173, str90)) {
                                        str47 = str90;
                                        strS3 = c63.s(str173, str47);
                                        strS4 = str172;
                                        str49 = str86;
                                        str48 = str88;
                                    } else {
                                        strS3 = str171;
                                        str47 = str90;
                                        if (c63.d(str173, str88)) {
                                            str48 = str88;
                                            strS42 = c63.s(str173, str48);
                                            strU3 = str46;
                                            strS4 = str172;
                                            str49 = str86;
                                        } else {
                                            strS4 = str172;
                                            str48 = str88;
                                            if (c63.d(str173, str86)) {
                                                str49 = str86;
                                                strS4 = c63.s(str173, str49);
                                            } else {
                                                z4 = zP15;
                                                str49 = str86;
                                                if (c63.d(str173, "udp-relay")) {
                                                    zP15 = c63.p(str173, "udp-relay");
                                                } else if (c63.d(str173, str95)) {
                                                    strS43 = c63.s(str173, str95);
                                                    zP15 = z4;
                                                } else if (c63.d(str173, str97)) {
                                                    String strS44 = c63.s(str173, str97);
                                                    if (strS44 != null) {
                                                        lowerCase9 = strS44.toLowerCase(Locale.ROOT);
                                                        lowerCase9.getClass();
                                                    } else {
                                                        lowerCase9 = null;
                                                    }
                                                    if (lowerCase9 != null) {
                                                        int iHashCode9 = lowerCase9.hashCode();
                                                        str50 = strS43;
                                                        if (iHashCode9 != 3551) {
                                                            if (iHashCode9 != 109935) {
                                                                if (iHashCode9 == 3005871) {
                                                                    lowerCase9.equals(obj18);
                                                                }
                                                            } else if (lowerCase9.equals("off")) {
                                                                tnVar19 = tnVar8;
                                                            }
                                                        } else if (lowerCase9.equals(obj17)) {
                                                            tnVar19 = tnVar7;
                                                        }
                                                    } else {
                                                        str50 = strS43;
                                                    }
                                                    tnVar19 = tnVar9;
                                                } else {
                                                    str50 = strS43;
                                                    if (i31 == 3) {
                                                        strU3 = c63.u(str173);
                                                    }
                                                    zP15 = z4;
                                                    strS43 = str50;
                                                }
                                            }
                                        }
                                    }
                                    strU3 = str46;
                                }
                                i31++;
                                str90 = str47;
                                str88 = str48;
                                str86 = str49;
                                str171 = strS3;
                                str172 = strS4;
                                str170 = strU3;
                                length10 = i32;
                            }
                            strU3 = str46;
                            zP15 = z4;
                            strS43 = str50;
                            i31++;
                            str90 = str47;
                            str88 = str48;
                            str86 = str49;
                            str171 = strS3;
                            str172 = strS4;
                            str170 = strU3;
                            length10 = i32;
                        }
                        String str176 = strS42;
                        String str177 = str170;
                        String str178 = str171;
                        String str179 = str172;
                        boolean z6 = zP15;
                        String str180 = strS43;
                        String str181 = strArr[1];
                        int i33 = Integer.parseInt(strArr[2]);
                        str177.getClass();
                        return new sy3(str, str181, i33, str177, i30, str178, str176, str179, i30 >= 3 ? z6 : false, tnVar19, str180);
                    }
                    break;
                    break;
                case 112323438:
                    if (lowerCase.equals("vmess")) {
                        HashMap map4 = new HashMap();
                        String str182 = "udp-relay";
                        boolean zP16 = System.currentTimeMillis() >= new GregorianCalendar(2022, 1, 1).getTimeInMillis() ? true : z ? 1 : 0;
                        int length11 = strArr.length;
                        tn tnVar20 = tnVar9;
                        boolean zP17 = z ? 1 : 0;
                        boolean zP18 = zP17 ? 1 : 0;
                        boolean zP19 = zP18 ? 1 : 0;
                        boolean zP20 = zP19 ? 1 : 0;
                        String str183 = "/";
                        int i34 = 3;
                        String str184 = null;
                        String strS45 = null;
                        String str185 = null;
                        String strS46 = null;
                        boolean z7 = z;
                        while (i34 < length11) {
                            boolean z8 = zP16;
                            String str186 = (String) qe.m0(i34, strArr);
                            if (str186 == null) {
                                i6 = length11;
                            } else {
                                i6 = length11;
                                if (c63.d(str186, str71)) {
                                    strS45 = c63.s(str186, str71);
                                } else {
                                    if (c63.d(str186, str85)) {
                                        zP17 = c63.p(str186, str85);
                                    } else if (c63.d(str186, "ws")) {
                                        zP18 = c63.p(str186, "ws");
                                    } else if (c63.d(str186, "ws-path")) {
                                        String strS47 = c63.s(str186, "ws-path");
                                        str183 = strS47 == null ? "/" : strS47;
                                    } else if (c63.d(str186, str80)) {
                                        String strS48 = c63.s(str186, str80);
                                        if (strS48 != null) {
                                            i7 = i34;
                                            char[] cArr = new char[1];
                                            cArr[z7 ? 1 : 0] = '|';
                                            Iterator it6 = p44.K0(strS48, cArr, 6).iterator();
                                            ?? r22 = z7;
                                            while (it6.hasNext()) {
                                                String str187 = (String) it6.next();
                                                Iterator it7 = it6;
                                                char[] cArr2 = new char[1];
                                                cArr2[r22] = ':';
                                                List listK05 = p44.K0(str187, cArr2, 6);
                                                if (listK05.size() == 2) {
                                                    Object obj23 = listK05.get(r22 == true ? 1 : 0);
                                                    String strU7 = c63.u((String) listK05.get(1));
                                                    strU7.getClass();
                                                    map4.put(obj23, strU7);
                                                }
                                                it6 = it7;
                                                r22 = 0;
                                            }
                                        }
                                        str56 = str182;
                                        str59 = str95;
                                        str60 = str85;
                                        str58 = str71;
                                        obj16 = obj18;
                                        str57 = str97;
                                        str61 = str80;
                                        obj15 = obj17;
                                        zP16 = z8 ? 1 : 0;
                                        obj18 = obj16;
                                        obj17 = obj15;
                                        str85 = str60;
                                        str80 = str61;
                                        z7 = false;
                                        str95 = str59;
                                        str97 = str57;
                                        str71 = str58;
                                        length11 = i6;
                                        str182 = str56;
                                        i34 = i7 + 1;
                                    } else {
                                        i7 = i34;
                                        if (c63.d(str186, "skip-cert-verify")) {
                                            zP19 = c63.p(str186, "skip-cert-verify");
                                            str56 = str182;
                                            str59 = str95;
                                            zP16 = z8 ? 1 : 0;
                                            str60 = str85;
                                            str58 = str71;
                                            obj16 = obj18;
                                            str57 = str97;
                                            str61 = str80;
                                            obj15 = obj17;
                                            obj18 = obj16;
                                            obj17 = obj15;
                                            str85 = str60;
                                            str80 = str61;
                                            z7 = false;
                                            str95 = str59;
                                            str97 = str57;
                                            str71 = str58;
                                            length11 = i6;
                                            str182 = str56;
                                            i34 = i7 + 1;
                                        } else {
                                            if (c63.d(str186, "sni")) {
                                                String strS49 = c63.s(str186, "sni");
                                                if (n12.c(strS49, "off")) {
                                                    strS49 = null;
                                                }
                                                if (strS49 == null || kx0.d(false).e(strS49)) {
                                                    str52 = str71;
                                                    str184 = strS49;
                                                    str56 = str182;
                                                    str57 = str97;
                                                    zP16 = z8 ? 1 : 0;
                                                    str58 = str52;
                                                    str61 = str80;
                                                    obj15 = obj17;
                                                    str59 = str95;
                                                    str60 = str85;
                                                    obj16 = obj18;
                                                } else {
                                                    String str188 = "invalid sni value: " + ((Object) strS49);
                                                    if (fy4.b) {
                                                        str52 = str71;
                                                        Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str188);
                                                        str62 = "Decoder";
                                                        str63 = str188;
                                                    } else {
                                                        str52 = str71;
                                                        str62 = "Decoder";
                                                        str63 = str188;
                                                    }
                                                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                                        a1.e(str62, str63, null);
                                                    }
                                                    zP16 = z8 ? 1 : 0;
                                                    str56 = str182;
                                                    str57 = str97;
                                                    str184 = null;
                                                    str58 = str52;
                                                    str61 = str80;
                                                    obj15 = obj17;
                                                    str59 = str95;
                                                    str60 = str85;
                                                    obj16 = obj18;
                                                }
                                            } else {
                                                str52 = str71;
                                                if (c63.d(str186, "server-cert-fingerprint-sha256")) {
                                                    try {
                                                        String strS50 = c63.s(str186, "server-cert-fingerprint-sha256");
                                                        if (strS50 == null || b.d(strS50)) {
                                                            str185 = strS50;
                                                            str56 = str182;
                                                            str57 = str97;
                                                            zP16 = z8 ? 1 : 0;
                                                            str58 = str52;
                                                            str61 = str80;
                                                            obj15 = obj17;
                                                            str59 = str95;
                                                            str60 = str85;
                                                            obj16 = obj18;
                                                        } else {
                                                            String str189 = "invalid server-cert-fingerprint-sha256: " + ((Object) strS50);
                                                            if (fy4.b) {
                                                                Xlog.logWrite2(0L, ke2Var.a(), "Decoder", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str189);
                                                                str53 = "Decoder";
                                                                str54 = str189;
                                                            } else {
                                                                str53 = "Decoder";
                                                                str54 = str189;
                                                            }
                                                            if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                                                                str55 = null;
                                                            } else {
                                                                str55 = null;
                                                                a1.e(str53, str54, null);
                                                            }
                                                            zP16 = z8 ? 1 : 0;
                                                            str185 = str55;
                                                            str56 = str182;
                                                            str57 = str97;
                                                            str58 = str52;
                                                            str61 = str80;
                                                            obj15 = obj17;
                                                            str59 = str95;
                                                            str60 = str85;
                                                            obj16 = obj18;
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        str70 = str;
                                                        st4.l(fw.u("decode proxy failed: ", str70, ", ", e.getMessage()), e);
                                                        return null;
                                                    }
                                                } else {
                                                    if (c63.d(str186, str182)) {
                                                        str56 = str182;
                                                        zP20 = c63.p(str186, str56);
                                                        str58 = str52;
                                                        str59 = str95;
                                                        str57 = str97;
                                                        zP16 = z8 ? 1 : 0;
                                                    } else {
                                                        str56 = str182;
                                                        if (c63.d(str186, str96)) {
                                                            String str190 = str96;
                                                            zP16 = c63.p(str186, str190);
                                                            str58 = str52;
                                                            str96 = str190;
                                                            str59 = str95;
                                                            str57 = str97;
                                                        } else {
                                                            str58 = str52;
                                                            String str191 = str96;
                                                            if (c63.d(str186, str95)) {
                                                                str59 = str95;
                                                                strS46 = c63.s(str186, str59);
                                                                zP16 = z8 ? 1 : 0;
                                                                str60 = str85;
                                                                str96 = str191;
                                                                obj16 = obj18;
                                                                str57 = str97;
                                                                str61 = str80;
                                                                obj15 = obj17;
                                                            } else {
                                                                str96 = str191;
                                                                str59 = str95;
                                                                if (c63.d(str186, str97)) {
                                                                    str57 = str97;
                                                                    String strS51 = c63.s(str186, str57);
                                                                    if (strS51 != null) {
                                                                        str60 = str85;
                                                                        lowerCase10 = strS51.toLowerCase(Locale.ROOT);
                                                                        lowerCase10.getClass();
                                                                    } else {
                                                                        str60 = str85;
                                                                        lowerCase10 = null;
                                                                    }
                                                                    if (lowerCase10 != null) {
                                                                        int iHashCode10 = lowerCase10.hashCode();
                                                                        str61 = str80;
                                                                        if (iHashCode10 == 3551) {
                                                                            obj15 = obj17;
                                                                            obj16 = obj18;
                                                                            if (lowerCase10.equals(obj15)) {
                                                                                tnVar20 = tnVar7;
                                                                                zP16 = z8 ? 1 : 0;
                                                                            }
                                                                        } else if (iHashCode10 == 109935) {
                                                                            obj16 = obj18;
                                                                            if (lowerCase10.equals("off")) {
                                                                                tnVar20 = tnVar8;
                                                                                obj15 = obj17;
                                                                                zP16 = z8 ? 1 : 0;
                                                                            } else {
                                                                                obj15 = obj17;
                                                                            }
                                                                        } else if (iHashCode10 == 3005871) {
                                                                            obj16 = obj18;
                                                                            if (lowerCase10.equals(obj16)) {
                                                                                tnVar20 = tnVar9;
                                                                                obj15 = obj17;
                                                                                zP16 = z8 ? 1 : 0;
                                                                            }
                                                                            obj15 = obj17;
                                                                        }
                                                                        tnVar20 = tnVar9;
                                                                        zP16 = z8 ? 1 : 0;
                                                                    } else {
                                                                        str61 = str80;
                                                                    }
                                                                    obj15 = obj17;
                                                                    obj16 = obj18;
                                                                    tnVar20 = tnVar9;
                                                                    zP16 = z8 ? 1 : 0;
                                                                } else {
                                                                    str60 = str85;
                                                                    obj16 = obj18;
                                                                    str57 = str97;
                                                                    str61 = str80;
                                                                    obj15 = obj17;
                                                                    zP16 = z8 ? 1 : 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    str60 = str85;
                                                    str61 = str80;
                                                    obj15 = obj17;
                                                    obj16 = obj18;
                                                }
                                            }
                                            obj18 = obj16;
                                            obj17 = obj15;
                                            str85 = str60;
                                            str80 = str61;
                                            z7 = false;
                                            str95 = str59;
                                            str97 = str57;
                                            str71 = str58;
                                            length11 = i6;
                                            str182 = str56;
                                            i34 = i7 + 1;
                                        }
                                    }
                                    i7 = i34;
                                    str56 = str182;
                                    str59 = str95;
                                    zP16 = z8 ? 1 : 0;
                                    str60 = str85;
                                    str58 = str71;
                                    obj16 = obj18;
                                    str57 = str97;
                                    str61 = str80;
                                    obj15 = obj17;
                                    obj18 = obj16;
                                    obj17 = obj15;
                                    str85 = str60;
                                    str80 = str61;
                                    z7 = false;
                                    str95 = str59;
                                    str97 = str57;
                                    str71 = str58;
                                    length11 = i6;
                                    str182 = str56;
                                    i34 = i7 + 1;
                                }
                                zP16 = z8 ? 1 : 0;
                                i7 = i34;
                                str56 = str182;
                                str59 = str95;
                                str60 = str85;
                                str58 = str71;
                                obj16 = obj18;
                                str57 = str97;
                                str61 = str80;
                                obj15 = obj17;
                                obj18 = obj16;
                                obj17 = obj15;
                                str85 = str60;
                                str80 = str61;
                                z7 = false;
                                str95 = str59;
                                str97 = str57;
                                str71 = str58;
                                length11 = i6;
                                str182 = str56;
                                i34 = i7 + 1;
                            }
                            i7 = i34;
                            str56 = str182;
                            str59 = str95;
                            str60 = str85;
                            str58 = str71;
                            obj16 = obj18;
                            str57 = str97;
                            str61 = str80;
                            obj15 = obj17;
                            zP16 = z8 ? 1 : 0;
                            obj18 = obj16;
                            obj17 = obj15;
                            str85 = str60;
                            str80 = str61;
                            z7 = false;
                            str95 = str59;
                            str97 = str57;
                            str71 = str58;
                            length11 = i6;
                            str182 = str56;
                            i34 = i7 + 1;
                        }
                        boolean z9 = zP16;
                        if (zP17 && str184 == null && map4.containsKey("Host")) {
                            String str192 = (String) map4.get("Host");
                            if (kx0.c().e(str192)) {
                                str51 = str192;
                            }
                        } else {
                            str51 = str184;
                        }
                        String str193 = strArr[1];
                        int i35 = Integer.parseInt(strArr[2]);
                        strS45.getClass();
                        return new ms4(str, str193, i35, strS45, zP17 ? 1 : 0, zP18 ? 1 : 0, str183, map4, zP19 ? 1 : 0, str51, str185, zP20 ? 1 : 0, z9, tnVar20, strS46);
                    }
                    break;
                    break;
                case 372732820:
                    if (!lowerCase.equals("socks5-tls")) {
                        break;
                    } else {
                        strArr4 = strArr;
                        obj5 = "socks5-tls";
                        obj6 = "socks5";
                        obj7 = "http";
                        obj8 = "https";
                        obj9 = obj17;
                        str26 = str97;
                        c = 1;
                        str24 = "udp-relay";
                        str25 = str95;
                        str27 = "tls";
                        obj10 = obj18;
                        String str139222 = strArr4[c];
                        int i22222 = Integer.parseInt(strArr4[2]);
                        Object obj19222 = obj6;
                        length2 = strArr4.length;
                        Object obj20222 = obj7;
                        tn tnVar16222 = tnVar9;
                        i8 = 3;
                        String str140222 = null;
                        String strU4222 = null;
                        String strU5222 = null;
                        String str141222 = null;
                        String strS25222 = null;
                        boolean zP7222 = false;
                        boolean zP8222 = false;
                        boolean zP9222 = false;
                        while (i8 < length2) {
                        }
                        if (str140222 == null) {
                        }
                        if (n12.c(lowerCase, obj8)) {
                        }
                    }
                    break;
                case 939697302:
                    if (lowerCase.equals("reject-tinygif")) {
                        str23 = str;
                        return new ii3(str23);
                    }
                    break;
                    break;
            }
        }
        throw new IllegalArgumentException("proxy type " + lowerCase + " is not supported");
    }

    public static final ArrayList b(String str) {
        i23 i23Var;
        List<String> listK0 = p44.K0(str, new char[]{';'}, 6);
        ArrayList arrayList = new ArrayList(f70.Q(10, listK0));
        for (String str2 : listK0) {
            List listK02 = p44.K0(p44.U0(str2).toString(), new char[]{'-'}, 6);
            int size = listK02.size();
            if (size == 1) {
                Integer numM0 = w44.m0(p44.U0((String) listK02.get(0)).toString());
                if (numM0 == null || !lb3.c(numM0.intValue())) {
                    e04.f("invalid port in port-hopping: ".concat(str2));
                    return null;
                }
                i23Var = new i23(numM0.intValue(), numM0.intValue());
            } else {
                if (size != 2) {
                    xe.k("invalid port-hopping format: ".concat(str2));
                    return null;
                }
                Integer numM02 = w44.m0(p44.U0((String) listK02.get(0)).toString());
                Integer numM03 = w44.m0(p44.U0((String) listK02.get(1)).toString());
                if (numM02 == null || !lb3.c(numM02.intValue()) || numM03 == null || !lb3.c(numM03.intValue())) {
                    e04.f("invalid port in port-hopping: ".concat(str2));
                    return null;
                }
                i23Var = new i23(numM02.intValue(), numM03.intValue());
            }
            arrayList.add(i23Var);
        }
        return arrayList;
    }
}
