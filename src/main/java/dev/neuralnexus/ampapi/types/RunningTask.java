package dev.neuralnexus.ampapi.types;

/**
 * RunningTask - A running task object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetTasks()
 */
public class RunningTask {
    /**
     * IsPrimaryTask - Whether the task is the primary task <br>
     * StartTime - The start time of the task <br>
     * Id - The ID of the task <br>
     * Name - The name of the task <br>
     * Description - The description of the task <br>
     * HideFromUI - Whether the task is hidden from the UI <br>
     * FastDismiss - Whether the task can be dismissed quickly <br>
     * LastUpdatePushed - The last time the update was pushed <br>
     * ProgressPercent - The progress percentage of the task <br>
     * IsCancellable - Whether the task is cancellable <br>
     * Origin - The origin of the task <br>
     * IsIndeterminate - Whether the task is indeterminate <br>
     * State - The state of the task <br>
     * Status - The status of the task
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
    @Override
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
