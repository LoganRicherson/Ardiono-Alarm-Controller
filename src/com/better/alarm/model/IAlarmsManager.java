package com.better.alarm.model;

import android.database.Cursor;

/**
 * An interface for Presenter-Model interaction. Presenters can invoke
 * {@link #dismiss(Alarm)}, {@link #snooze(Alarm)} as a result of user
 * interaction. Model broadcasts intents representing lifecycle of the
 * {@link Alarm}. Each intent contains an {@link Alarm} as a parceable extra
 * with the key {@link #EXTRA_ID}
 * 
 * @author Yuriy
 * 
 */
public interface IAlarmsManager {
    /**
     * Tell the model that a certain alarm has to be snoozed because of the user
     * interaction
     * 
     * @param alarm
     */
    public void snooze(Alarm alarm);

    /**
     * Tell the model that a certain alarm has to be dismissed because of the
     * user interaction
     * 
     * @param alarm
     */
    public void dismiss(Alarm alarm);

    /**
     * Delete an Alarm with the given id from the database
     * 
     * @param id
     */
    public void delete(int id);

    /**
     * Creates a new Alarm and fills in the given alarm's id.
     * 
     * @Deprecated use {@link #set(Alarm)}
     * @param alarm
     * @return
     */
    @Deprecated
    public long add(Alarm alarm);

    public void enable(int id, boolean enable);

    /**
     * A convenience method to set an alarm in the AlarmsManager content
     * provider.
     * 
     * @return Time when the alarm will fire.
     */
    public long set(Alarm alarm);

    /**
     * Return an Alarm object representing the alarm id in the database. Returns
     * null if no alarm exists.
     */
    public Alarm getAlarm(int alarmId);

    /**
     * Queries all alarms
     * 
     * @return cursor over all alarms
     */
    public Cursor getCursor();
}
