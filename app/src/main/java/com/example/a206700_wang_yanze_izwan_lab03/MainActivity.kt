package com.example.a206700_wang_yanze_izwan_lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ===================== Lab3 新增：使用 Material Design 3 主题 =====================
            MaterialTheme {
                var inputNote by remember { mutableStateOf("") }
                var dynamicNotes by remember { mutableStateOf(listOf<String>()) }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF1F1F1)) // 页面背景色
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        // 顶部标题栏
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "My Notes (A206700)",
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1E88E5) // 主色调（标题）
                            )
                            Text(
                                text = "Search",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Gray // 次要文字颜色
                            )
                        }

                        // ===================== Lab3 新增：使用 Card 组件（圆角 + 阴影） =====================
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            colors = CardDefaults.cardColors(Color.White) // 卡片背景色
                        ) {
                            Column(Modifier.padding(20.dp)) {
                                Text(
                                    text = "Add New Note",
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Color.Black // 标题文字颜色
                                )

                                TextField(
                                    value = inputNote,
                                    onValueChange = { inputNote = it },
                                    label = { Text("Note Content") },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(bottom = 12.dp),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = TextFieldDefaults.colors(
                                        focusedContainerColor = Color.Transparent,
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedLabelColor = Color(0xFF1E88E5) // 输入框聚焦颜色
                                    )
                                )

                                Button(
                                    onClick = {
                                        if (inputNote.isNotBlank()) {
                                            dynamicNotes = dynamicNotes + inputNote
                                            inputNote = ""
                                        }
                                    },
                                    modifier = Modifier.align(Alignment.End),
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.buttonColors(Color(0xFF1E88E5)) // 按钮颜色
                                ) {
                                    Text("Add Note", color = Color.White)
                                }
                            }
                        }

                        // 笔记列表
                        Column(
                            modifier = Modifier.padding(top = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // 静态笔记1
                            var expanded1 by remember { mutableStateOf(false) }
                            // ===================== Lab3 新增：Card + 点击展开 + 动画 =====================
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expanded1 = !expanded1 }
                                    .animateContentSize(),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Column(Modifier.padding(20.dp)) {
                                    Text(
                                        text = "Study Jetpack Compose",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.Black
                                    )
                                    if (expanded1) {
                                        Text(
                                            text = "Learn Column, Row, Box",
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = Color.DarkGray,
                                            modifier = Modifier.padding(top = 6.dp)
                                        )
                                    }
                                }
                            }

                            // 静态笔记2
                            var expanded2 by remember { mutableStateOf(false) }
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expanded2 = !expanded2 }
                                    .animateContentSize(),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(Color.White)
                            ) {
                                Column(Modifier.padding(20.dp)) {
                                    Text(
                                        text = "Finish E-Portfolio",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.Black
                                    )
                                    if (expanded2) {
                                        Text(
                                            text = "Reverse Engineering Project",
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = Color.DarkGray
                                        )
                                    }
                                }
                            }

                            // 静态笔记3
                            var expanded3 by remember { mutableStateOf(false) }
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expanded3 = !expanded3 }
                                    .animateContentSize(),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(Color.White)
                            ) {
                                Column(Modifier.padding(20.dp)) {
                                    Text(
                                        text = "SDG 4: Quality Education",
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color.Black
                                    )
                                    if (expanded3) {
                                        Text(
                                            text = "Note taking app for students",
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = Color.DarkGray
                                        )
                                    }
                                }
                            }

                            // 动态笔记
                            dynamicNotes.forEachIndexed { index, noteContent ->
                                var expanded by remember { mutableStateOf(false) }
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { expanded = !expanded }
                                        .animateContentSize(),
                                    shape = RoundedCornerShape(16.dp),
                                    elevation = CardDefaults.cardElevation(4.dp),
                                    colors = CardDefaults.cardColors(Color.White)
                                ) {
                                    Column(Modifier.padding(20.dp)) {
                                        Text(
                                            text = "New Note ${index + 1}",
                                            style = MaterialTheme.typography.titleLarge,
                                            color = Color.Black
                                        )
                                        if (expanded) {
                                            Text(
                                                text = noteContent,
                                                style = MaterialTheme.typography.bodyLarge,
                                                color = Color.DarkGray
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}