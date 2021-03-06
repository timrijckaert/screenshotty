package eu.bolt.screenshotty.coroutines

import eu.bolt.screenshotty.Screenshot
import eu.bolt.screenshotty.ScreenshotManager
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun ScreenshotManager.makeScreenshotAsync() {
    suspendCoroutine<Screenshot> {
        makeScreenshot().observe(
            onSuccess = it::resume,
            onError = it::resumeWithException
        )
    }
}
