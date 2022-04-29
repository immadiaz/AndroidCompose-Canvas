package com.compose.canvas

import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.canvas.ui.theme.*

const val INIT_VALUE = 0f
const val TARGET_VALUE = 360f
const val DURATION = 2000

@Composable
fun CanvasScreen() {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = INIT_VALUE,
        targetValue = TARGET_VALUE,
        animationSpec = infiniteRepeatable(
            animation = tween(DURATION, easing = LinearEasing)
        )
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Canvas(
            modifier = Modifier
                .size(300.dp)
                .padding(16.dp)
                .graphicsLayer {
                    // Enabled animation or disabled animation
                    rotationZ = angle
                }
        ) {

            drawArc(
                color = RedColor,
                startAngle = -90f,
                sweepAngle = 180f,
                useCenter = true,
                size = getDrawArcSize(),
                topLeft = Offset(size.width * .25f, 0f)
            )
            drawArc(
                color = BlueColor,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = true,
                size = getDrawArcSize(),
                topLeft = Offset(size.width * .50f, size.height * .25f)
            )
            drawArc(
                color = GreenColor,
                startAngle = 0f,
                sweepAngle = -180f,
                useCenter = true,
                size = getDrawArcSize(),
                topLeft = Offset(0f, size.height * .25f)
            )

            drawArc(
                color = YellowColor,
                startAngle = 270f,
                sweepAngle = -180f,
                useCenter = true,
                size = getDrawArcSize(),
                topLeft = Offset(size.width * .25f, size.height * .50f)
            )
        }
    }
}

@Composable
@Preview(name = "light_mode")
@Preview(name = "dark_mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewCanvasScreen() {
    ComposeCanvasPlaygroundTheme {
        Surface {
            CanvasScreen()
        }
    }
}

