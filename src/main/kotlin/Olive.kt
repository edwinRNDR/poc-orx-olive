package olive

import org.openrndr.Program
import org.openrndr.application
import org.operndr.extras.filewatcher.watchFile
import java.io.File

fun main() = application {
    System.setProperty("idea.io.use.fallback", "true")
    program {
        watchFile(File("src/main/kotlin/live.kts")) {
            extensions.clear()
            keyboard.keyDown.listeners.clear()
            keyboard.keyUp.listeners.clear()
            keyboard.character.listeners.clear()
            keyboard.keyRepeat.listeners.clear()
            mouse.clicked.listeners.clear()
            mouse.buttonDown.listeners.clear()
            mouse.dragged.listeners.clear()
            mouse.buttonUp.listeners.clear()
            mouse.moved.listeners.clear()
            window.drop.listeners.clear()
            window.focused.listeners.clear()
            window.minimized.listeners.clear()
            window.unfocused.listeners.clear()
            window.restored.listeners.clear()
            window.sized.listeners.clear()
            val func = KtsObjectLoader().load<Program.() -> Unit>(it.readText())
            func(this)
        }
    }
}