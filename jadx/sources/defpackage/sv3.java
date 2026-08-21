package defpackage;

import android.content.SharedPreferences;
import com.getsurfboard.backup.model.SettingValue;
import com.getsurfboard.backup.model.SettingsBackup;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sv3 {
    public final SharedPreferences a;
    public final List b;

    public sv3(SharedPreferences sharedPreferences) {
        fu3 fu3Var;
        Map map = iu3.a;
        ub2 ub2VarI = p95.i();
        Iterator it = iu3.b.iterator();
        while (it.hasNext()) {
            ub2VarI.add(new eu3((String) it.next(), fu3.b, null));
        }
        Iterator it2 = iu3.c.iterator();
        while (it2.hasNext()) {
            ub2VarI.add(new eu3((String) it2.next(), fu3.f, null));
        }
        Iterator it3 = iu3.d.iterator();
        while (true) {
            boolean zHasNext = it3.hasNext();
            fu3Var = fu3.z;
            if (!zHasNext) {
                break;
            } else {
                ub2VarI.add(new eu3((String) it3.next(), fu3Var, null));
            }
        }
        Iterator it4 = iu3.e.iterator();
        while (it4.hasNext()) {
            ub2VarI.add(new eu3((String) it4.next(), fu3.A, null));
        }
        ub2VarI.addAll(iu3.f);
        Iterator it5 = p10.A0.iterator();
        while (true) {
            w0 w0Var = (w0) it5;
            if (!w0Var.hasNext()) {
                ub2 ub2VarC = p95.c(ub2VarI);
                ub2VarC.getClass();
                this.a = sharedPreferences;
                this.b = ub2VarC;
                return;
            }
            String lowerCase = ((p10) w0Var.next()).name().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            ub2VarI.add(new eu3(lowerCase.concat("_card_display"), fu3Var, null));
        }
    }

    public final SettingValue a(eu3 eu3Var) {
        int i;
        fu3 fu3Var = eu3Var.b;
        String str = eu3Var.a;
        int iOrdinal = fu3Var.ordinal();
        SharedPreferences sharedPreferences = this.a;
        if (iOrdinal == 0) {
            String string = sharedPreferences.getString(str, null);
            if (string != null) {
                return SettingValue.Companion.ofString(string);
            }
        } else {
            if (iOrdinal == 1) {
                return SettingValue.Companion.ofInt(sharedPreferences.getInt(str, 0));
            }
            if (iOrdinal == 2) {
                return SettingValue.Companion.ofLong(sharedPreferences.getLong(str, 0L));
            }
            if (iOrdinal == 3) {
                return SettingValue.Companion.ofBoolean(sharedPreferences.getBoolean(str, false));
            }
            if (iOrdinal == 4) {
                Set<String> stringSet = sharedPreferences.getStringSet(str, null);
                if (stringSet != null) {
                    return SettingValue.Companion.ofStringSet(stringSet);
                }
            } else {
                if (iOrdinal != 5) {
                    g.d();
                    return null;
                }
                List list = (List) iu3.a.get(eu3Var.c);
                if (list != null && (i = sharedPreferences.getInt(str, -1)) >= 0 && i < list.size()) {
                    return SettingValue.Companion.ofEnum(((Enum) list.get(i)).name());
                }
            }
        }
        return null;
    }

    public final void b(SettingsBackup settingsBackup, gr3 gr3Var) {
        String str;
        settingsBackup.getClass();
        List list = gr3Var.c;
        List list2 = this.b;
        int iU = fh2.U(f70.Q(10, list2));
        if (iU < 16) {
            iU = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iU);
        for (Object obj : list2) {
            linkedHashMap.put(((eu3) obj).a, obj);
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        for (Map.Entry<String, SettingValue> entry : settingsBackup.getEntries().entrySet()) {
            String key = entry.getKey();
            SettingValue value = entry.getValue();
            eu3 eu3Var = (eu3) linkedHashMap.get(key);
            if (eu3Var == null) {
                list.add("settings: unknown key " + key);
            } else {
                fu3 fu3Var = eu3Var.b;
                editorEdit.getClass();
                String type = value.getType();
                String str2 = eu3Var.a;
                int iOrdinal = fu3Var.ordinal();
                if (iOrdinal == 0) {
                    str = SettingValue.TYPE_STRING;
                } else if (iOrdinal == 1) {
                    str = SettingValue.TYPE_INT;
                } else if (iOrdinal == 2) {
                    str = SettingValue.TYPE_LONG;
                } else if (iOrdinal == 3) {
                    str = SettingValue.TYPE_BOOLEAN;
                } else if (iOrdinal == 4) {
                    str = SettingValue.TYPE_STRING_SET;
                } else {
                    if (iOrdinal != 5) {
                        g.d();
                        return;
                    }
                    str = SettingValue.TYPE_ENUM;
                }
                if (n12.c(type, str)) {
                    int iOrdinal2 = fu3Var.ordinal();
                    if (iOrdinal2 == 0) {
                        editorEdit.putString(str2, value.getStringValue());
                    } else if (iOrdinal2 == 1) {
                        Integer intValue = value.getIntValue();
                        if ((intValue != null ? editorEdit.putInt(str2, intValue.intValue()) : null) != null) {
                        }
                    } else if (iOrdinal2 == 2) {
                        Long longValue = value.getLongValue();
                        if ((longValue != null ? editorEdit.putLong(str2, longValue.longValue()) : null) != null) {
                        }
                    } else if (iOrdinal2 == 3) {
                        Boolean boolValue = value.getBoolValue();
                        if ((boolValue != null ? editorEdit.putBoolean(str2, boolValue.booleanValue()) : null) != null) {
                        }
                    } else if (iOrdinal2 == 4) {
                        editorEdit.putStringSet(str2, value.getStringSetValue());
                    } else {
                        if (iOrdinal2 != 5) {
                            g.d();
                            return;
                        }
                        List list3 = (List) iu3.a.get(eu3Var.c);
                        if (list3 != null) {
                            Iterator it = list3.iterator();
                            int i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i = -1;
                                    break;
                                } else if (n12.c(((Enum) it.next()).name(), value.getStringValue())) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (i >= 0) {
                                editorEdit.putInt(str2, i);
                            } else {
                                list.add("settings: unknown enum value " + value.getStringValue() + " for " + str2);
                            }
                        }
                    }
                    gr3Var.b++;
                } else {
                    list.add("settings: type mismatch for " + str2);
                }
            }
        }
        editorEdit.apply();
    }
}
