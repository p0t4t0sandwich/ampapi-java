package dev.neuralnexus.ampapi.types;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * SettingSpec - A setting specification object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetSettingsSpec()
 */
public class SettingsSpec {
    /** result - The result */
    public Map<String, List<Spec>> result;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "SettingSpec{result=" + this.result + "}";
    }

    /**
     * Spec - A setting specification object
     *
     * @author p0t4t0sandwich
     * @see SettingsSpec
     * @see dev.neuralnexus.ampapi.apimodules.Core#GetSettingsSpec()
     */
    public static class Spec {
        /**
         * ReadOnly - Whether the setting is read-only Name - The name Description - The description
         * Category - The category CurrentValue - The current value ValType - The value type
         * EnumValues - The enum values EnumValuesAreDeferred - Whether the enum values are deferred
         * Node - The node InputType - The input type SelectionSource - The selection source
         * IsProvisionSpec - Whether the setting is a provision spec ReadOnlyProvision - Whether the
         * provision is read-only Actions - The actions Keywords - The keywords AlwaysAllowRead -
         * Whether the setting is always allowed to be read Tag - The tag MaxLength - The max length
         * Placeholder - The placeholder Suffix - The suffix Meta - The meta RequiresRestart -
         * Whether the setting requires a restart
         */
        public boolean ReadOnly;

        public String Name;
        public String Description;
        public String Category;
        public Object CurrentValue;
        public String ValType;
        public Object EnumValues;
        public boolean EnumValuesAreDeferred;
        public String Node;
        public String InputType;
        public Object SelectionSource;
        public boolean IsProvisionSpec;
        public boolean ReadOnlyProvision;
        public Object[] Actions;
        public Object Keywords;
        public boolean AlwaysAllowRead;
        public String Tag;
        public double MaxLength;
        public String Placeholder;
        public String Suffix;
        public String Meta;
        public boolean RequiresRestart;

        /**
         * toString
         *
         * @return A string representation of the object
         */
        public String toString() {
            return "Spec{"
                    + "ReadOnly="
                    + this.ReadOnly
                    + ", Name="
                    + this.Name
                    + ", Description="
                    + this.Description
                    + ", Category="
                    + this.Category
                    + ", CurrentValue="
                    + this.CurrentValue
                    + ", ValType="
                    + this.ValType
                    + ", EnumValues="
                    + this.EnumValues
                    + ", EnumValuesAreDeferred="
                    + this.EnumValuesAreDeferred
                    + ", Node="
                    + this.Node
                    + ", InputType="
                    + this.InputType
                    + ", SelectionSource="
                    + this.SelectionSource
                    + ", IsProvisionSpec="
                    + this.IsProvisionSpec
                    + ", ReadOnlyProvision="
                    + this.ReadOnlyProvision
                    + ", Actions="
                    + Arrays.toString(this.Actions)
                    + ", Keywords="
                    + this.Keywords
                    + ", AlwaysAllowRead="
                    + this.AlwaysAllowRead
                    + ", Tag="
                    + this.Tag
                    + ", MaxLength="
                    + this.MaxLength
                    + ", Placeholder="
                    + this.Placeholder
                    + ", Suffix="
                    + this.Suffix
                    + ", Meta="
                    + this.Meta
                    + ", RequiresRestart="
                    + this.RequiresRestart
                    + "}";
        }
    }
}
