package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * SettingSpec - A setting specification object
 *
 * @author p0t4t0sandwich
 * @see SettingSpec
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetSettingsSpec()
 */
public class SettingSpec {
    /**
     * ReadOnly - Whether the setting is read-only <br>
     * Name - The name <br>
     * Description - The description <br>
     * Category - The category <br>
     * CurrentValue - The current value <br>
     * ValType - The value type <br>
     * EnumValues - The enum values <br>
     * EnumValuesAreDeferred - Whether the enum values are deferred <br>
     * Node - The node <br>
     * InputType - The input type <br>
     * SelectionSource - The selection source <br>
     * IsProvisionSpec - Whether the setting is a provision spec <br>
     * ReadOnlyProvision - Whether the provision is read-only <br>
     * Actions - The actions <br>
     * Keywords - The keywords <br>
     * AlwaysAllowRead - Whether the setting is always allowed to be read <br>
     * Tag - The tag <br>
     * MaxLength - The max length <br>
     * Placeholder - The placeholder <br>
     * Suffix - The suffix <br>
     * Meta - The meta <br>
     * RequiresRestart - Whether the setting requires a restart
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
