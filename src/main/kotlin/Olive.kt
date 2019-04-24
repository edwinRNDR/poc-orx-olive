package olive

import org.openrndr.Program
import org.openrndr.application
import org.operndr.extras.filewatcher.watchFile
import java.io.File

fun main() = application {
    program {
        val drawFunc = watchFile(File("src/main/kotlin/live.kts")) {
            KtsObjectLoader().load<Program.()->Unit>(it.readText())
        }
        extend {
            drawFunc()(this)
        }
    }
}