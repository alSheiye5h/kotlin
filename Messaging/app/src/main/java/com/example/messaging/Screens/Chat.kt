package com.example.messaging.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.messaging.Models.Chat
import com.example.messaging.R
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.ui.draw.rotate

var chate = Chat(
    image = "pizza1",
    username = "username1",
    Msgs = mapOf(
        "hello" to "party",
        "FontWeight" to "self",
        "hariko" to "party",
        "package com.example" to "self",
        "nseft lchakor dbk" to "self",
        "hana anseft msg dbk" to "party",
        "lapoch" to "party",
        "ramizonaf" to "self",
        "pc dialk khel" to "self",
        "ramikanouchsm" to "party",
        "helldso" to "party",
        "FontWcsqcsqeight" to "self",
        "hari<wx<wxko" to "party",
        "packdzadazdage com.ezzzxample" to "self",
        "nsedadsqdsqft lchakor dbk" to "self",
        "hacwxcxwcna anseft msg dbk" to "party",
        "lapdzadzadoch" to "party",
        "ramizkyukykonaf" to "self",
        "pc diajhyrhrlk khel" to "self",
        "ramiuykyukanouchsm" to "party",
        "hecvdscllo" to "party",
        "FontWbfdbvfeight" to "self",
        "harw< <wiko" to "party",
        "pack sq sqage com.example" to "self",
        "nse ft lchakor dbk" to "self",
        "ha dqsda anseft msg dbk" to "party",
        "lapozadd  ez ch" to "party",
        "ramizoazdazd  s q naf" to "self",
        "pc dialdsqd qsk khel" to "self",
        "ramikanazekuykouchsm" to "party",
        "hesqc<wxllo" to "party",
        "FontWe<wxsqdight" to "self",
        "haridzaabt vrfeko" to "party",
        "packqscqsage comsqc sq ad z.exdazd ample" to "self",
        "nsefaz dt lcdzad azhakor dbdd k" to "self",
        "hanadzad  ans azd eft msg dbk" to "party",
        "lap dza dazdoch" to "party",
        "ramizdsqdq sd qsonaf" to "self",
        "pcazd azd a diada dzalzakhel az dadaaz " to "self",
        "ramidaz dazkano azd efr euchsm" to "party"
    ),
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Conversation(
    navController: NavHostController,
    innerPadding: PaddingValues,
    chat: Chat = chate,
    id: Int
) {
    Scaffold (
        modifier = Modifier
            .padding(innerPadding)
        ,
        topBar = {
            TopChatBar( username = chat.username, image = chat.image, modifier = Modifier, innerPadding = innerPadding)
        },
        content = { innerPadding ->
            MsgArea(msgs = chate.Msgs, innerPadding = innerPadding)
        },
        bottomBar = {
            SendMessage()
        }
    )
}

@Composable
fun SendMessage() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center // Adds space between elements
    ) {
        var textField by remember { mutableStateOf("") }

        OutlinedTextField(
            value = textField,
            placeholder = { Text(text = "type anything...") },
            onValueChange = { textField = it },
            modifier = Modifier
                .padding(end = 8.dp)
        )

        IconButton(
            onClick = {
            },
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Blue)
        ) {
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = "Send message",
                modifier = Modifier
                    .rotate(-90f)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopChatBar(
    username: String,
    image: String,
    modifier: Modifier,
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    color = Color(219, 219, 219, 20),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }
            .padding(top = innerPadding.calculateTopPadding() - 30.dp,bottom = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza1),
            contentDescription = "User Photo",
            modifier = Modifier.size(60.dp).clip(CircleShape)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = username,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
fun MsgArea(
    msgs: Map<String, String>,
    innerPadding: PaddingValues
) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)
            .drawBehind {
                drawLine(
                    color = Color(219, 219, 219, 20),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }
            .fillMaxHeight(.97f),
    ) {
        val keysList = msgs.keys.toList()
        items(msgs.size) {index ->
            if (msgs[keysList[index]] == "party") {
                partyMsgInstance(text = keysList[index])
            } else {
                selfMsgInstance(text = keysList[index])
            }
        }

    }

}

@Composable
fun partyMsgInstance(text: String) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.Absolute.Left,
    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza1),
            contentDescription = "User Photo",
            modifier = Modifier.size(30.dp).clip(CircleShape)
        )
        Box (
            modifier = Modifier
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Blue),
            ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }
    }
}

@Composable
fun selfMsgInstance(text: String) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.Absolute.Right,
    ) {
        Box (
            modifier = Modifier
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(255, 255, 255, 50)),
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }
    }
}

















