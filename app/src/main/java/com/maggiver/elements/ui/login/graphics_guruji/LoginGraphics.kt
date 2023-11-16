package com.maggiver.elements.ui.login.graphics_guruji

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CarCrash
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


/**
 * Created by
 * @AUTHOR: Daniel Maggiver Acevedo
 * @NICK_NAME: mackgaru
 * @DATE: 14,noviembre,2023
 * @COMPAN: Juice
 * @EMAIL: dmacevedo00@misena.edu.co
 *
 * Todos los derechos de @AUTHOR y de Propiedad Intelectual, son reservados y protegidos por su creador y se phohibe su reprodución, edición, copias, conservación, divulgación y comercialización sin consentimiento escrito.
 * En caso que un tercero haga uso indebidode esta propiedad intelectual, su @AUTHOR, puede ejercer una acción legal indemnizatoria por el uso indebido de sus obras legitimas.
 * solicitando al juez civil que condene al infractor al pago de perjuicios o, de igual forma, interponga una denuncia por ser víctima del delito de violación a los derechos morales, patrimoniales de autor y demas derechos vulnerados
 *
 *
 * Su @AUTHOR GOZA DE LOS DERECHOS DE:
 * @Derechos_de_AUTHOR: El software por ser una obra literaria goza de protección legal desde el momento de su creación.
 * @Derechos_Morales: prerrogativas irrenunciables e inalienables de las que goza el autor legítimo del software que le permite conservar la obra de forma inédita, divulgarla, oponerse a las posibles modificaciones que tenga o retirarla del mercado cuando así lo considere.
 * @Derechos_Patrimoniales: Prerrogativas de carácter económico que le permiten al autor del software obtener provecho económico de todas las utilidades que genere la reproducción o distribución del software.
 *                         pueden ser transferibles a terceros con la autorización del titular del software en virtud de la autonomía de su voluntad, en cuyo caso, el autor o titular de la obra denominado cedente transmite total o parcialmente sus derechos a un tercero a través de un contrato de cesión de derechos.
 * @Derecho_de_transformacion_distribucion_y_reproduccion_de_la_obra: facultad que tiene el titular o autor de un software de realizar cambios totales o parciales al código de su obra; ponerla a disposición del público o autorizar su difusión.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewLoginGraphics() {
    LoginGraphics(navController = rememberNavController())
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginGraphics(navController: NavHostController) {


    ConstraintLayout {

        val (mainContainer, headerContainer, bodyContainer, bottomContainer) = createRefs()
        val guideBottomHorizontal = createGuidelineFromBottom(0.2f)
        val guideBottomContainer = createGuidelineFromBottom(0.05f)

        //main
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5EEEE))
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .constrainAs(mainContainer) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guideBottomContainer)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) { }

        //header
        Column(
            Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .background(Color(0xFFE20495))
                .fillMaxHeight(0.4f)
                .constrainAs(headerContainer) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .padding(16.dp)

        ) {
            HeaderLogin()
        }

        //body
        Column(
            Modifier
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .fillMaxHeight(0.6f)
                .constrainAs(bodyContainer) {
                    top.linkTo(headerContainer.bottom)
                    start.linkTo(headerContainer.start)
                    end.linkTo(headerContainer.end)
                    bottom.linkTo(guideBottomHorizontal)
                }
        ) {
            BodyLogin(navController = navController)
        }

        //bottom
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE20495))
                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                .constrainAs(bottomContainer) {
                    top.linkTo(mainContainer.bottom)
                    start.linkTo(mainContainer.start)
                    end.linkTo(mainContainer.end)
                }
        ) {}
    }

    /* Modifier
         .offset(0.dp, (-64).dp)
         .padding(32.dp, 0.dp, 32.dp, 0.dp)
         .fillMaxHeight(0.8f)
         .background(Color(0xFFE0E0E0))
         .shadow(
             elevation = 16.dp,
             shape = RectangleShape,
             clip = true,
             ambientColor = Color(0x1F000000),
             spotColor = Color(0xD000000)
         )*/
    /*.border(
        border = BorderStroke(
            width = 10.dp,
            brush = Brush.linearGradient(
                *//*listOf(
                        Color(0xFFE0E0E0),
                        Color(0xFFFFFFFF)
                    )*//*
                    0.0f to Color(0xFFE0E0E0),
                    0.2f to Color(0xFFE7E7E7),
                    0.5f to Color(0xFFD5D5D5),
                    0.7f to Color(0xFFC5C5C5),
                    1.0f to Color(0xFFFFFFFF),
                    start = Offset(0f, 100f),
                    end = Offset(0f, 170f)
                )
            ),
            shape = RectangleShape
       )*/


}

@Composable
fun HeaderLogin() {

    Column {
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.CarCrash,
                contentDescription = "Icono de inicio",
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                tint = Color(0xFFFFFFFF)
            )
        }
        Text(
            text = "Learn Graphics and UI/UX designing with us for free with live projects.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp, 0.dp, 0.dp),
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,
            lineHeight = 18.sp,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }

}

@Composable
fun BodyLogin(navController: NavHostController) {

    var emailAddress by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5EEEE),
            contentColor = Color.White  //Card content color,e.g.text
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column(
            Modifier.padding(20.dp, 20.dp, 20.dp, 40.dp)
        ) {

            Column {

                Text(
                    text = "Email Address",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF7A7A7A),
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextFieldEmailLoginCoursera(
                    value = emailAddress,
                    onValueChange = { emailAddress = it }
                )
            }

            Column {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Password",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF7A7A7A),
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextFieldPasswordLoginCoursera(
                    value = password,
                    onValueChange = { password = it }
                )
            }

            Column {
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    colors = ButtonDefaults.elevatedButtonColors(//ButtonDefaults.buttonColors
                        containerColor = Color(0xFF4E46F1),
                        contentColor = Color(0xFFFFFFFF),
                        disabledContainerColor = Color(0xFF747474),
                        disabledContentColor = Color(0xFF222222)
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Forgot Password?",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFFE7A436),
                    textAlign = TextAlign.End,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )

            }
        }

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmailLoginCoursera(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    // parameters below will be passed to BasicTextField for correct behavior of the text field,
    // and to the decoration box for proper styling and sizing
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = true
    val colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Black,
        unfocusedBorderColor = Color.Black,
    )
    var keyBoardOptionsEmail = KeyboardOptions(keyboardType = KeyboardType.Email)

    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        // internal implementation of the BasicTextField will dispatch focus events
        interactionSource = interactionSource,
        enabled = enabled,
        keyboardOptions = keyBoardOptionsEmail,
        textStyle = MaterialTheme.typography.bodyLarge,
        singleLine = singleLine,
        cursorBrush = SolidColor(Color.Black)
    ) { innerTextField ->

        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = {
                /*Box(modifier = Modifier) {
                    if (value.isEmpty()) {
                        Text(
                            text = "Tu Email",
                            color = LocalContentColor.current.copy(alpha = 0.6f)
                        )
                    }
                }*/
                innerTextField()
            },
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            placeholder = {
                Text(
                    text = "example@gmail.com",
                    color = LocalContentColor.current.copy(alpha = 0.6f)
                )
            },
            colors = colors,
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                start = 16.dp,
                end = 8.dp,
                top = 0.dp,
                bottom = 0.dp
            ),
            // update border thickness and shape
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = enabled,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF4B47A0),
                        unfocusedBorderColor = Color(0xFF000000)
                    ),
                    shape = RoundedCornerShape(8.dp) //OutlinedTextFieldDefaults.shape
                )
            }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPasswordLoginCoursera(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val enabled = true
    val singleLine = true
    val colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Black,
        unfocusedBorderColor = Color.Black,
    )
    var expanded by remember { mutableStateOf(false) }
    var keyBoardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        interactionSource = interactionSource,
        enabled = enabled,
        textStyle = MaterialTheme.typography.bodyLarge,
        keyboardOptions = keyBoardOptions,
        visualTransformation = if (expanded) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = singleLine,
        cursorBrush = SolidColor(Color.Black)
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = value,
            innerTextField = {
                innerTextField()
            },
            enabled = enabled,
            singleLine = singleLine,
            trailingIcon = {
                var image = if (expanded) Icons.Filled.VisibilityOff
                else Icons.Filled.Visibility

                var description =
                    if (expanded) "Hide password" else "Show password"

                IconButton(
                    onClick = {
                        expanded = !expanded
                    }
                ) {
                    Icon(imageVector = image, contentDescription = description)
                }
            },
            visualTransformation = if (expanded) VisualTransformation.None else PasswordVisualTransformation(),
            interactionSource = interactionSource,
            placeholder = {
                Text(
                    text = "Tu Password",
                    color = LocalContentColor.current.copy(alpha = 0.6f)
                )
            },
            colors = colors,
            contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
                start = 16.dp,
                end = 8.dp,
                top = 0.dp,
                bottom = 0.dp
            ),
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = enabled,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF4B47A0),
                        unfocusedBorderColor = Color(0xFF000000)
                    ),
                    shape = RoundedCornerShape(8.dp) //OutlinedTextFieldDefaults.shape
                )
            }
        )
    }
}