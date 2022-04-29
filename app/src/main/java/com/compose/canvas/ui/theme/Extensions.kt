package com.compose.canvas.ui.theme

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope

fun DrawScope.getWidth() = this.size.width
fun DrawScope.getHeight() = this.size.height
fun DrawScope.getDrawArcSize() = Size(getWidth() * 0.50f, getHeight() * 0.50f)
