package dev.neuralnexus.ampapi.types;

import dev.neuralnexus.ampapi.responses.Core.GetStatusResult;

/**
 * Metric - A metric and its values
 * @author p0t4t0sandwich
 * @see GetStatusResult#Metrics
 */
public class Metric {
    /**
     * RawValue - The raw value of the metric
     * MaxValue - The maximum value of the metric
     * Percent - The percentage of the metric
     * Units - The units of the metric
     * Color - The color of the metric
     * Color2 - The secondary color of the metric
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
     * @return A string representation of the object
     */
    public String toString() {
        return "StatusMetric{RawValue=" + this.RawValue + ", MaxValue=" + this.MaxValue + ", Percent=" + this.Percent + ", Units=" + this.Units + ", Color=" + this.Color + ", Color2=" + this.Color2 + ", Color3=" + this.Color3 + "}";
    }
}