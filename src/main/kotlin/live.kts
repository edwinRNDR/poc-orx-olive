@file:Suppress("UNUSED_LAMBDA_EXPRESSION")

import org.openrndr.Program
import org.openrndr.color.ColorRGBa

val color = ColorRGBa.GRAY

{ program: Program ->
    program.apply {
        var a = false
        mouse.clicked.listen {
            a = !a
        }

        extend {
            drawer.translate(width/2.0, height/2.0)
            drawer.background(if (a) ColorRGBa.RED else ColorRGBa.GREEN)
            drawer.fill = color
            drawer.circle(100.0 + Math.cos(seconds) * 100.0, 100.0 + Math.sin(seconds * 2.0) * 100.0, 40.0)
        }
    }
}