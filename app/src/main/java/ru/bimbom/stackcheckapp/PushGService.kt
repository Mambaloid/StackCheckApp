package ru.bimbom.stackcheckapp

import com.google.firebase.messaging.RemoteMessage
import org.push.sdk.model.messaging.PushFcmService
import org.push.sdk.model.messaging.PushRuStoreService

class PushGService : PushFcmService() {

    override fun modifyMessage(remoteMessage: RemoteMessage): RemoteMessage? {
        return remoteMessage;
    }

    override fun messageReceived(
        remoteMessage: RemoteMessage?,
        notificationId: Int,
        channelId: String?
    ) {

    }

    override fun getDefaultAddress(): String {
        return ""
    }
}

class PushRuService: PushRuStoreService() {

    override fun getDefaultAddress(): String {
        return ""
    }

    override fun messageReceived(
        remoteMessage: ru.rustore.sdk.pushclient.messaging.model.RemoteMessage?,
        notificationId: Int,
        channelId: String?
    ) {

    }
}