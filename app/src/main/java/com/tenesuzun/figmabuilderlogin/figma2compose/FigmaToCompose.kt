//package com.tenesuzun.figmabuilderlogin.figma2compose
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
//import androidx.constraintlayout.compose.ConstraintLayout
//
//// TODO Figma 2 Compose Github project and Figma plugin
//
//@Composable()
//fun player_stop(modifier: Modifier = Modifier) {
//    ConstraintLayout(modifier = modifier) {
//        val (Vector) = createRefs()
//
//
//        /* raw vector Vector should have an export setting */
//    }
//}
//@Composable()
//fun eye_off(modifier: Modifier = Modifier) {
//    ConstraintLayout(modifier = modifier) {
//        val (Vector) = createRefs()
//
//
//        /* raw vector Vector should have an export setting */
//    }
//}
//@Composable()
//fun user(modifier: Modifier = Modifier) {
//    ConstraintLayout(modifier = modifier) {
//        val (Vector) = createRefs()
//
//
//        /* raw vector Vector should have an export setting */
//    }
//}
//@Composable()
//fun Input_Field(modifier: Modifier = Modifier) {
//    Column(modifier.width(295.0.dp), verticalArrangement = Arrangement.spacedBy(2.0.dp), horizontalAlignment = Alignment.Start) {
//
//        Row(Modifier.clip(RoundedCornerShape(100.0.dp)).height(21.0.dp).size(30.0.dp, 21.0.dp), horizontalArrangement = Arrangement.spacedBy(10.0.dp), verticalAlignment = Alignment.CenterVertically) {
//
//            Text("Email", Modifier.wrapContentHeight(Alignment.Top).size(30.0.dp, 19.0.dp), style = LocalTextStyle.current.copy(color = Color(0.42f, 0.45f, 0.47f, 1.0f), textAlign = TextAlign.Left, fontSize = 12.0.sp))
//
//
//        }
//        Row(Modifier.shadow(2.0.dp, opacity = 0.99f, shape = RoundedCornerShape(10.0.dp)).clip(RoundedCornerShape(10.0.dp)).height(46.0.dp).background(Color(1.0f, 1.0f, 1.0f, 1.0f)).size(295.0.dp, 46.0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.0.dp), verticalAlignment = Alignment.CenterVertically) {
//            Spacer(modifier = Modifier.width(14.0.dp))
//            Row(Modifier.size(267.0.dp, 21.0.dp), horizontalArrangement = Arrangement.spacedBy(12.0.dp), verticalAlignment = Alignment.CenterVertically) {
//
//                user(Modifier.size(16.0.dp, 16.0.dp))
//                Text("Loisbecket@gmail.com", Modifier.wrapContentHeight(Alignment.Top).size(207.0.dp, 21.0.dp), style = LocalTextStyle.current.copy(color = Color(0.1f, 0.11f, 0.12f, 1.0f), textAlign = TextAlign.Left, fontSize = 14.0.sp))
//
//
//            }
//            eye_off(Modifier.size(16.0.dp, 16.0.dp))
//            Spacer(modifier = Modifier.width(14.0.dp))
//        }
//
//    }
//}
//
//@Composable()
//@Preview()
//fun AndroidPreview_Field() {
//    Box(Modifier.size(360.dp, 640.dp)) {
//        Field()
//    }
//}
//
//@Composable()
//fun Field() {
//    Column(Modifier.width(295.0.dp).fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.0.dp), horizontalAlignment = Alignment.End) {
//
//        Column(Modifier.width(295.0.dp).size(295.0.dp, 98.0.dp).fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.0.dp), horizontalAlignment = Alignment.End) {
//
//            Input_Field(Modifier.size(295.0.dp, 46.0.dp).fillMaxWidth())
//            Input_Field(Modifier.size(295.0.dp, 46.0.dp).fillMaxWidth())
//
//        }
//        Row(Modifier.size(295.0.dp, 19.0.dp).fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.0.dp), verticalAlignment = Alignment.CenterVertically) {
//
//            Row(Modifier.size(106.0.dp, 19.0.dp), horizontalArrangement = Arrangement.spacedBy(5.0.dp), verticalAlignment = Alignment.CenterVertically) {
//
//                player_stop(Modifier.size(19.0.dp, 19.0.dp))
//                Text("Remember me", Modifier.wrapContentHeight(Alignment.Top).size(82.0.dp, 18.0.dp), style = LocalTextStyle.current.copy(color = Color(0.42f, 0.45f, 0.47f, 1.0f), textAlign = TextAlign.Center, fontSize = 12.0.sp))
//
//
//            }
//            Text("Forgot Password ?", Modifier.wrapContentHeight(Alignment.CenterVertically).size(106.0.dp, 17.0.dp), style = LocalTextStyle.current.copy(color = Color(0.3f, 0.51f, 0.91f, 1.0f), textAlign = TextAlign.Right, fontSize = 12.0.sp))
//        }
//
//    }
//}