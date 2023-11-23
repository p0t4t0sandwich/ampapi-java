package dev.neuralnexus.ampapi.types;

/**
 * RunningTask - A running task object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetTasks()
 */
public class RunningTask {
    /**
     * IsPrimaryTask - Whether the task is the primary task StartTime - The start time of the task
     * Id - The ID of the task Name - The name of the task Description - The description of the task
     * HideFromUI - Whether the task is hidden from the UI FastDismiss - Whether the task can be
     * dismissed quickly LastUpdatePushed - The last time the update was pushed ProgressPercent -
     * The progress percentage of the task IsCancellable - Whether the task is cancellable Origin -
     * The origin of the task IsIndeterminate - Whether the task is indeterminate State - The state
     * of the task Status - The status of the task
     */
    public boolean IsPrimaryTask;

    public String StartTime;
    public String Id;
    public String Name;
    public String Description;
    public boolean HideFromUI;
    public boolean FastDismiss;
    public String LastUpdatePushed;
    public double ProgressPercent;
    public boolean IsCancellable;
    public String Origin;
    public boolean IsIndeterminate;
    public double State;
    public boolean Status;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "RunningTask{IsPrimaryTask="
                + this.IsPrimaryTask
                + ", StartTime="
                + this.StartTime
                + ", Id="
                + this.Id
                + ", Name="
                + this.Name
                + ", Description="
                + this.Description
                + ", HideFromUI="
                + this.HideFromUI
                + ", FastDismiss="
                + this.FastDismiss
                + ", LastUpdatePushed="
                + this.LastUpdatePushed
                + ", ProgressPercent="
                + this.ProgressPercent
                + ", IsCancellable="
                + this.IsCancellable
                + ", Origin="
                + this.Origin
                + ", IsIndeterminate="
                + this.IsIndeterminate
                + ", State="
                + this.State
                + ", Status="
                + this.Status
                + "}";
    }
}
