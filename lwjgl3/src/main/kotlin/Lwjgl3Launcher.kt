import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

/** Launches the desktop (LWJGL3) application.  */
object Lwjgl3Launcher {
    private val configuration: Lwjgl3ApplicationConfiguration
        get() {
            val configuration = Lwjgl3ApplicationConfiguration()

            configuration.setTitle("Test Imgui")

            configuration.setResizable(true)
            configuration.useVsync(true)

            return configuration
        }
    @JvmStatic
    fun main(args: Array<String>) {
        Lwjgl3Application(Game(), configuration)
    }
}