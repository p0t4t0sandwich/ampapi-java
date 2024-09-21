/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Metric - A metric and its values
 *
 * @author p0t4t0sandwich
 */
public class Metric {
    /**
     * RawValue - The raw value of the metric <br>
     * MaxValue - The maximum value of the metric <br>
     * Percent - The percentage of the metric Units - The units of the metric <br>
     * Color - The color of the metric <br>
     * Color2 - The secondary color of the metric <br>
     * Color3 - The tertiary color of the metric
     */
    public int RawValue;

    public int MaxValue;
    public double Percent;
    public String Units;
    public String Color;
    public String Color2;
    public String Color3;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "StatusMetric{RawValue="
                + this.RawValue
                + ", MaxValue="
                + this.MaxValue
                + ", Percent="
                + this.Percent
                + ", Units="
                + this.Units
                + ", Color="
                + this.Color
                + ", Color2="
                + this.Color2
                + ", Color3="
                + this.Color3
                + "}";
    }
}
