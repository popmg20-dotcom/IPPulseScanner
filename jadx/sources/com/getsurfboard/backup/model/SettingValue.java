package com.getsurfboard.backup.model;

import defpackage.al0;
import defpackage.fw;
import defpackage.n12;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SettingValue {
    public static final Companion Companion = new Companion(null);
    public static final String TYPE_BOOLEAN = "BOOLEAN";
    public static final String TYPE_ENUM = "ENUM";
    public static final String TYPE_INT = "INT";
    public static final String TYPE_LONG = "LONG";
    public static final String TYPE_STRING = "STRING";
    public static final String TYPE_STRING_SET = "STRING_SET";
    private final Boolean boolValue;
    private final Integer intValue;
    private final Long longValue;
    private final Set<String> stringSetValue;
    private final String stringValue;
    private final String type;

    public /* synthetic */ SettingValue(String str, String str2, Integer num, Long l, Boolean bool, Set set, int i, al0 al0Var) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SettingValue copy$default(SettingValue settingValue, String str, String str2, Integer num, Long l, Boolean bool, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingValue.type;
        }
        if ((i & 2) != 0) {
            str2 = settingValue.stringValue;
        }
        if ((i & 4) != 0) {
            num = settingValue.intValue;
        }
        if ((i & 8) != 0) {
            l = settingValue.longValue;
        }
        if ((i & 16) != 0) {
            bool = settingValue.boolValue;
        }
        if ((i & 32) != 0) {
            set = settingValue.stringSetValue;
        }
        Boolean bool2 = bool;
        Set set2 = set;
        return settingValue.copy(str, str2, num, l, bool2, set2);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.stringValue;
    }

    public final Integer component3() {
        return this.intValue;
    }

    public final Long component4() {
        return this.longValue;
    }

    public final Boolean component5() {
        return this.boolValue;
    }

    public final Set<String> component6() {
        return this.stringSetValue;
    }

    public final SettingValue copy(String str, String str2, Integer num, Long l, Boolean bool, Set<String> set) {
        str.getClass();
        return new SettingValue(str, str2, num, l, bool, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingValue)) {
            return false;
        }
        SettingValue settingValue = (SettingValue) obj;
        return n12.c(this.type, settingValue.type) && n12.c(this.stringValue, settingValue.stringValue) && n12.c(this.intValue, settingValue.intValue) && n12.c(this.longValue, settingValue.longValue) && n12.c(this.boolValue, settingValue.boolValue) && n12.c(this.stringSetValue, settingValue.stringSetValue);
    }

    public final Boolean getBoolValue() {
        return this.boolValue;
    }

    public final Integer getIntValue() {
        return this.intValue;
    }

    public final Long getLongValue() {
        return this.longValue;
    }

    public final Set<String> getStringSetValue() {
        return this.stringSetValue;
    }

    public final String getStringValue() {
        return this.stringValue;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.stringValue;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.intValue;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.longValue;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Boolean bool = this.boolValue;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Set<String> set = this.stringSetValue;
        return iHashCode5 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.stringValue;
        Integer num = this.intValue;
        Long l = this.longValue;
        Boolean bool = this.boolValue;
        Set<String> set = this.stringSetValue;
        StringBuilder sbE = fw.E("SettingValue(type=", str, ", stringValue=", str2, ", intValue=");
        sbE.append(num);
        sbE.append(", longValue=");
        sbE.append(l);
        sbE.append(", boolValue=");
        sbE.append(bool);
        sbE.append(", stringSetValue=");
        sbE.append(set);
        sbE.append(")");
        return sbE.toString();
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Companion {
        public /* synthetic */ Companion(al0 al0Var) {
            this();
        }

        public final SettingValue ofBoolean(boolean z) {
            return new SettingValue(SettingValue.TYPE_BOOLEAN, null, null, null, Boolean.valueOf(z), null, 46, null);
        }

        public final SettingValue ofEnum(String str) {
            str.getClass();
            return new SettingValue(SettingValue.TYPE_ENUM, str, null, null, null, null, 60, null);
        }

        public final SettingValue ofInt(int i) {
            return new SettingValue(SettingValue.TYPE_INT, null, Integer.valueOf(i), null, null, null, 58, null);
        }

        public final SettingValue ofLong(long j) {
            return new SettingValue(SettingValue.TYPE_LONG, null, null, Long.valueOf(j), null, null, 54, null);
        }

        public final SettingValue ofString(String str) {
            str.getClass();
            return new SettingValue(SettingValue.TYPE_STRING, str, null, null, null, null, 60, null);
        }

        public final SettingValue ofStringSet(Set<String> set) {
            set.getClass();
            return new SettingValue(SettingValue.TYPE_STRING_SET, null, null, null, null, set, 30, null);
        }

        private Companion() {
        }
    }

    public SettingValue(String str, String str2, Integer num, Long l, Boolean bool, Set<String> set) {
        str.getClass();
        this.type = str;
        this.stringValue = str2;
        this.intValue = num;
        this.longValue = l;
        this.boolValue = bool;
        this.stringSetValue = set;
    }
}
