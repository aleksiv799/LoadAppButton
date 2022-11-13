package com.udacity

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

private const val NOTIFICATION_ID = 0
private const val REQUEST_CODE = 0
private const val FLAGS = 0

fun NotificationManager.sendNotification(message: String, applicationContext: Context, status: String) {
    val contentIntent = Intent(applicationContext, DetailActivity::class.java)
    contentIntent.apply {
        putExtra("fileName", message)
        putExtra("status", status)
    }

    val contentPendingIntent = PendingIntent.getActivity(applicationContext, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT)
    val action = NotificationCompat.Action.Builder(0, "Show details", contentPendingIntent).build()
    val notificationBuilder = NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.githubRepo_notification_channel_id))
        .setSmallIcon(R.drawable.ic_assistant_black_24dp)
        .setContentTitle("Download Finished")
        .setContentText(message)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .addAction(action)

    notify(NOTIFICATION_ID, notificationBuilder.build())
}