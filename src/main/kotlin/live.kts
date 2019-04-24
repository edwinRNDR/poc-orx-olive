@file:Suppress("UNUSED_LAMBDA_EXPRESSION")

import org.openrndr.Program
import org.openrndr.color.ColorRGBa

val color = ColorRGBa.GRAY

{ program: Program ->
    program.apply {
        drawer.translate(100.0, 100.0)
        drawer.background(ColorRGBa.BLACK)
        drawer.fill = color
        drawer.circle(100.0 + Math.cos(seconds)*100.0, 100.0 + Math.sin(seconds*2.0) * 100.0, 40.0)
    }
}