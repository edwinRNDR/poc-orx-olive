@file:Suppress("UNUSED_LAMBDA_EXPRESSION")

import org.openrndr.Program
import org.openrndr.color.ColorRGBa
import org.openrndr.panel.ControlManager
import org.openrndr.panel.elements.button
import org.openrndr.panel.layout
import org.openrndr.panel.style.*
import org.openrndr.panel.styleSheet

val color = ColorRGBa.GRAY

{ program: Program ->
    program.apply {
        var a = false

        extend(ControlManager()) {

            styleSheet(has type "button") {
                this.background = Color.RGBa(ColorRGBa.RED)
            }
            layout {
                button {
                    label = "click me!"
                    events.clicked.subscribe {
                        a = !a
                    }
                }
            }
        }

        extend {
            drawer.translate(width / 2.0, height / 2.0)
            drawer.background(if (a) ColorRGBa.GRAY else ColorRGBa.PINK)
            drawer.fill = color
            drawer.circle(100.0 + Math.cos(seconds) * 100.0, 100.0 + Math.sin(seconds * 2.0) * 100.0, 40.0)
        }
    }
}