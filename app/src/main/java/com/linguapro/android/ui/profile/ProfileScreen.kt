package com.linguapro.android.ui.profile

import com.linguapro.android.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import com.linguapro.android.ui.components.*
import androidx.compose.runtime.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import com.linguapro.android.ui.components.pressScale

@Composable
internal fun ProfileScreen(name: String, email: String, level: String, completed: Int, progress: LearningProgress, username: String, avatarCode: String, onEditAvatar: () -> Unit, onSocial: () -> Unit, onBack: () -> Unit, onSettings: () -> Unit, onSignOut: () -> Unit, onDeleteAccount: (String) -> Unit, deletionBusy: Boolean = false, onPro: () -> Unit = {}) {
    var confirmDelete by remember { mutableStateOf(false) }
    var deletePassword by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(horizontal = 18.dp)) {
        BackRow("Profil", onBack)
        Spacer(Modifier.height(12.dp))
        Surface(color = Panel, shadowElevation = 2.dp, shape = RoundedCornerShape(28.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                AvatarView(AvatarConfig.decode(avatarCode), 92.dp)
                Text(name.ifBlank { "Öğrenci" }, fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp))
                if (username.isNotBlank()) Text("@$username", color = Gold, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 2.dp))
                Text(email.ifBlank { "Demo hesap • bu cihazda" }, color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 4.dp))
                // XP seviyesi: her XP seni bir üst seviyeye taşır
                val xpLevel = LevelSystem.levelFor(progress.totalXp)
                val (inLevel, needed, percent) = LevelSystem.progressToNext(progress.totalXp)
                Row(Modifier.fillMaxWidth().padding(top = 14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Surface(color = Gold, shape = RoundedCornerShape(12.dp)) {
                        Text("Lv $xpLevel", color = Navy, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(horizontal = 11.dp, vertical = 5.dp))
                    }
                    Column(Modifier.weight(1f).padding(start = 10.dp)) {
                        val levelFill by animateFloatAsState(targetValue = (percent / 100f).coerceIn(0f, 1f), animationSpec = tween(700, easing = FastOutSlowInEasing), label = "levelFill")
                        Box(Modifier.fillMaxWidth().height(8.dp).background(Panel2, RoundedCornerShape(4.dp))) {
                            Box(Modifier.fillMaxWidth(levelFill).height(8.dp).background(Gold, RoundedCornerShape(4.dp)))
                        }
                        Text("$inLevel / $needed XP • sonraki seviyeye %${100 - percent}", color = Muted, fontSize = 10.sp, modifier = Modifier.padding(top = 3.dp))
                    }
                }
            }
        }
        Spacer(Modifier.height(14.dp))
        InfoCard("CEFR: $level  •  Tamamlanan ders: $completed  •  Toplam XP: ${progress.totalXp}")
        Spacer(Modifier.height(18.dp))
        Text("Hesap ve gizlilik", color = OnBg, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text("Ders kayıtların önce cihazına kaydedilir, bağlantı geldiğinde hesabınla eşitlenir. Çalışma serisi ve beceri özeti bu cihazda tutulur. Lig XP’si sunucuda ayrı hesaplanır.", color = OnBgSoft, fontSize = 12.sp, lineHeight = 18.sp, modifier = Modifier.padding(top = 7.dp, bottom = 15.dp))
        ProfileAction(Icons.Default.AutoAwesome, "Lingua Pro • kişisel pratik", onPro)
        Spacer(Modifier.height(8.dp))
        ProfileAction(Icons.Default.Face, "Avatarını düzenle", onEditAvatar)
        Spacer(Modifier.height(8.dp))
        ProfileAction(Icons.Default.Groups, "Topluluk: Bülten • Lig • Arkadaşlar", onSocial)
        Spacer(Modifier.height(8.dp))
        ProfileAction(Icons.Default.Tune, "Öğrenme ayarları", onSettings)
        Spacer(Modifier.height(8.dp))
        ProfileAction(Icons.Default.Logout, "Oturumu kapat", onSignOut, enabled = !deletionBusy)
        Spacer(Modifier.height(8.dp))
        ProfileAction(Icons.Default.DeleteOutline, if (deletionBusy) "Hesap siliniyor…" else "Hesabı ve verileri sil",
            { confirmDelete = true }, enabled = !deletionBusy, destructive = true)
        Spacer(Modifier.height(20.dp))
    }
    if (confirmDelete) {
        AlertDialog(
            onDismissRequest = { confirmDelete = false; deletePassword = "" },
            containerColor = Panel,
            title = { Text("Hesap silinsin mi?", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    Text("Hesabın ve öğrenme verilerin kalıcı olarak silinir. Devam etmek için mevcut şifreni gir.", color = Muted, fontSize = 13.sp)
                    Text("Hesabı silmek Google Play aboneliğini iptal etmez. Varsa aboneliğini Google Play’den ayrıca iptal et.", color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp))
                    OutlinedTextField(value = deletePassword, onValueChange = { deletePassword = it }, label = { Text("Mevcut şifre") }, singleLine = true,
                        visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(), modifier = Modifier.padding(top = 12.dp))
                }
            },
            confirmButton = {
                TextButton(enabled = deletePassword.isNotBlank() && !deletionBusy, onClick = { val password = deletePassword; deletePassword = ""; confirmDelete = false; onDeleteAccount(password) }) { Text("Evet, kalıcı olarak sil", color = PinkAccent, fontWeight = FontWeight.Bold) }
            },
            dismissButton = { TextButton(onClick = { confirmDelete = false; deletePassword = "" }) { Text("Vazgeç", color = OnBg) } }
        )
    }
}



