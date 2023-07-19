package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.LightError
import com.chocolate.triviatitans.presentation.theme.OnPrimary
import com.chocolate.triviatitans.presentation.theme.Primary

@Composable
fun ExitDialogBox(
    negativeButtonColor: Color = Primary,
    positiveButtonColor: Color = LightError,
    spaceBetweenElements: Dp = 18.dp,
    OnBackToLevel: () -> Unit
) {

    var dialogOpen by remember {
        mutableStateOf(true)
    }

    if (dialogOpen) {
        Dialog(onDismissRequest = {
            dialogOpen = false
        }
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(0.92f),
                color = Color.Transparent
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(percent = 10)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(height = 36.dp))

                        Text(
                            text = "Exit?",
                            fontFamily = FontFamily(Font(R.font.firasans_medium, FontWeight.Bold)),
                            fontSize = 24.sp
                        )

                        Spacer(modifier = Modifier.height(height = spaceBetweenElements))

                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = "Are you sure, you want to Exit?",
                            fontFamily = FontFamily(
                                Font(
                                    R.font.firasans_regular,
                                    FontWeight.Normal
                                )
                            ),
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(height = spaceBetweenElements))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            DialogButton(buttonColor = negativeButtonColor, buttonText = "No") {
                                dialogOpen = false
                            }
                            DialogButton(buttonColor = positiveButtonColor, buttonText = "Yes") {
                                Modifier.clickable { OnBackToLevel() }
                                dialogOpen = false
                            }
                        }

                        Spacer(modifier = Modifier.height(height = spaceBetweenElements * 2))
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "",
                        tint = positiveButtonColor,
                        modifier = Modifier
                            .background(color = Color.White, shape = CircleShape)
                            .border(width = 2.dp, shape = CircleShape, color = positiveButtonColor)
                            .padding(all = 16.dp)
                            .align(alignment = Alignment.TopCenter)
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun DialogPre() {
    ExitDialogBox(
        OnPrimary,
        LightError,
        18.dp,
        OnBackToLevel = {}
    )
}