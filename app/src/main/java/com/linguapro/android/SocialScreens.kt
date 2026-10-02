package com.linguapro.android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.linguapro.android.data.BoardEntry
import com.linguapro.android.data.FeedItem
import com.linguapro.android.data.SocialRepository

private val ScPanel = Color(0xFF281A4A)
private val ScPanel2 = Color(0xFF342457)
private val ScGold = Color(0xFFC6FF4A)
private val ScPink = Color(0xFFFF5CA8)
private val ScMuted = Color(0xFFA99BC9)
private val ScText = Color(0xFFF5F1FF)
private val ScNavy = Color(0xFF1A0E2E)

private fun timeAgo(millis: Long): String {
    if (millis <= 0L) return ""
    val diff = (System.currentTimeMillis() - millis) / 1000
    return when {
        diff < 60 -> "az önce"
        diff < 3600 -> "${diff / 60} dk önce"
        diff < 86_400 -> "${diff / 3600} sa önce"
        else -> "${diff / 86_400} gün önce"
    }
}

/**
 * Topluluk ekranı: Bülten (arkadaş başarıları), Lig (XP sıralaması) ve Arkadaşlar
 * (kullanıcı adıyla arama + ekleme/çıkarma) sekmeleri.
 */
@Composable
fun SocialScreen(
    uid: String,
    username: String,
    totalXp: Int,
    avatarCode: String,
    social: SocialRepository,
    onSaveUsername: (String) -> Unit,
    onEditAvatar: () -> Unit,
    onBack: () -> Unit
) {
    var tab by remember { mutableIntStateOf(0) }
    var board by remember { mutableStateOf<List<BoardEntry>>(emptyList()) }
    var friends by remember { mutableStateOf<List<BoardEntry>>(emptyList()) }
    var feed by remember { mutableStateOf<List<FeedItem>>(emptyList()) }
    var statusMessage by remember { mutableStateOf("") }
    var searchQuery by remember { mutableStateOf("") }
    var searchResults by remember { mutableStateOf<List<BoardEntry>>(emptyList()) }
    var nameDraft by remember { mutableStateOf(username) }
    var refresh by remember { mutableIntStateOf(0) }

    LaunchedEffect(refresh, uid) {
        social.fetchTop { list, err -> board = list; if (err != null) statusMessage = err }
        if (uid.isNotBlank()) {
            social.loadFriends(uid) { list, _ ->
                friends = list
                social.loadFeed(list.map { it.uid } + uid) { items, _ -> feed = items }
            }
        }
    }

    Column(
        Modifier.fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF2E1660), Color(0xFF150A30))))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp)
    ) {
        Spacer(Modifier.height(14.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(onClick = onBack, color = ScPanel, shape = RoundedCornerShape(12.dp)) {
                Text("←", color = ScText, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp))
            }
            Text("Topluluk", color = ScText, fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 12.dp))
        }
        Spacer(Modifier.height(12.dp))

        if (uid.isBlank()) {
            Surface(color = ScPanel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                Text("Topluluk özellikleri için hesabınla giriş yapmalısın.", color = ScMuted, fontSize = 13.sp, modifier = Modifier.padding(16.dp))
            }
            return@Column
        }

        // Kullanıcı adı yoksa önce onu belirlet
        if (username.isBlank()) {
            Surface(color = ScPanel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("Kullanıcı adını seç", color = ScGold, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text("Arkadaşların seni bu adla bulur. 3-20 karakter; küçük harf, rakam, nokta ve alt çizgi.", color = ScMuted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 5.dp))
                    OutlinedTextField(
                        value = nameDraft,
                        onValueChange = { nameDraft = it.lowercase().filter { ch -> ch.isLetterOrDigit() || ch == '.' || ch == '_' }.take(20) },
                        singleLine = true,
                        label = { Text("kullanıcı adı") },
                        modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ScGold, unfocusedBorderColor = ScPanel2, focusedLabelColor = ScGold, unfocusedLabelColor = ScMuted, cursorColor = ScGold)
                    )
                    Surface(
                        onClick = { if (nameDraft.length >= 3) { onSaveUsername(nameDraft); refresh++ } },
                        color = if (nameDraft.length >= 3) ScGold else ScPanel2,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        Text("Kaydet ve katıl", color = if (nameDraft.length >= 3) ScNavy else ScMuted, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 16.dp, vertical = 9.dp))
                    }
                }
            }
            Spacer(Modifier.height(24.dp))
            return@Column
        }

        // Sekmeler
        Row(Modifier.fillMaxWidth().background(ScPanel, RoundedCornerShape(16.dp)).padding(4.dp)) {
            listOf("📣 Bülten", "🏆 Lig", "👥 Arkadaşlar").forEachIndexed { i, label ->
                val active = tab == i
                Surface(
                    onClick = { tab = i },
                    color = if (active) ScGold else Color.Transparent,
                    shape = RoundedCornerShape(13.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(label, color = if (active) ScNavy else ScMuted, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 9.dp), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        if (statusMessage.isNotBlank()) {
            Text(statusMessage, color = ScPink, fontSize = 12.sp, modifier = Modifier.padding(bottom = 8.dp))
        }

        when (tab) {
            // ---- Bülten ----
            0 -> {
                if (feed.isEmpty()) {
                    Surface(color = ScPanel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                        Text("Bülten boş. Arkadaş ekle; onların başarıları (seviye atlama, Checkpoint, günlük görevler) burada görünecek.", color = ScMuted, fontSize = 13.sp, lineHeight = 19.sp, modifier = Modifier.padding(16.dp))
                    }
                }
                feed.forEach { item ->
                    Surface(color = ScPanel, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            AvatarView(AvatarConfig.decode(item.avatar), 40.dp)
                            Column(Modifier.weight(1f).padding(start = 10.dp)) {
                                Row {
                                    Text("@${item.username}", color = ScGold, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                    if (item.uid == uid) Text("  (sen)", color = ScMuted, fontSize = 11.sp)
                                }
                                Text(item.text, color = ScText, fontSize = 13.sp, lineHeight = 18.sp, modifier = Modifier.padding(top = 2.dp))
                                Text(timeAgo(item.createdAt), color = ScMuted, fontSize = 10.sp, modifier = Modifier.padding(top = 3.dp))
                            }
                        }
                    }
                }
            }
            // ---- Lig ----
            1 -> {
                val myRank = board.indexOfFirst { it.uid == uid }
                Surface(color = ScPanel, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)) {
                    Row(Modifier.padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
                        AvatarView(AvatarConfig.decode(avatarCode), 38.dp)
                        Column(Modifier.weight(1f).padding(start = 10.dp)) {
                            Text("@$username", color = ScGold, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Text("Seviye ${LevelSystem.levelFor(totalXp)} • $totalXp XP", color = ScMuted, fontSize = 11.sp)
                        }
                        Text(if (myRank >= 0) "#${myRank + 1}" else "#50+", color = ScPink, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    }
                }
                board.forEachIndexed { i, entry ->
                    val mine = entry.uid == uid
                    Surface(color = if (mine) Color(0xFF3E2B6E) else ScPanel, shape = RoundedCornerShape(14.dp), modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)) {
                        Row(Modifier.padding(horizontal = 12.dp, vertical = 9.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                when (i) { 0 -> "🥇"; 1 -> "🥈"; 2 -> "🥉"; else -> "${i + 1}" },
                                color = ScMuted, fontSize = 14.sp, fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            AvatarView(AvatarConfig.decode(entry.avatar), 32.dp)
                            Column(Modifier.weight(1f).padding(start = 10.dp)) {
                                Text("@${entry.username}", color = ScText, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                                Text("Seviye ${entry.level}", color = ScMuted, fontSize = 10.sp)
                            }
                            Text("${entry.totalXp} XP", color = ScGold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                if (board.isEmpty()) {
                    Surface(color = ScPanel, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                        Text("Lig henüz boş — ders tamamlayan ilk kişi ol!", color = ScMuted, fontSize = 13.sp, modifier = Modifier.padding(16.dp))
                    }
                }
            }
            // ---- Arkadaşlar ----
            else -> {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it.lowercase().filter { ch -> ch.isLetterOrDigit() || ch == '.' || ch == '_' } },
                    singleLine = true,
                    label = { Text("Kullanıcı adıyla ara") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = ScGold, unfocusedBorderColor = ScPanel2, focusedLabelColor = ScGold, unfocusedLabelColor = ScMuted, cursorColor = ScGold)
                )
                Surface(
                    onClick = {
                        if (searchQuery.length >= 3) social.search(searchQuery) { r, err ->
                            searchResults = r.filter { it.uid != uid }
                            statusMessage = err ?: if (r.isEmpty()) "'$searchQuery' bulunamadı." else ""
                        }
                    },
                    color = ScGold, shape = RoundedCornerShape(14.dp), modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text("Ara", color = ScNavy, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 18.dp, vertical = 9.dp))
                }
                searchResults.forEach { result ->
                    val already = friends.any { it.uid == result.uid }
                    Surface(color = ScPanel, shape = RoundedCornerShape(14.dp), modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            AvatarView(AvatarConfig.decode(result.avatar), 34.dp)
                            Column(Modifier.weight(1f).padding(start = 10.dp)) {
                                Text("@${result.username}", color = ScText, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                                Text("Seviye ${result.level} • ${result.totalXp} XP", color = ScMuted, fontSize = 11.sp)
                            }
                            Surface(
                                onClick = {
                                    if (!already) social.addFriend(uid, result) { err ->
                                        if (err == null) { statusMessage = "@${result.username} eklendi!"; refresh++ } else statusMessage = err
                                    }
                                },
                                color = if (already) ScPanel2 else ScGold, shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(if (already) "Ekli ✓" else "+ Ekle", color = if (already) ScMuted else ScNavy, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp))
                            }
                        }
                    }
                }
                Spacer(Modifier.height(14.dp))
                Text("Arkadaşların (${friends.size})", color = ScText, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                if (friends.isEmpty()) {
                    Text("Henüz arkadaşın yok. Yukarıdan kullanıcı adıyla ara ve ekle.", color = ScMuted, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp))
                }
                friends.forEach { friend ->
                    Surface(color = ScPanel, shape = RoundedCornerShape(14.dp), modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            AvatarView(AvatarConfig.decode(friend.avatar), 34.dp)
                            Text("@${friend.username}", color = ScText, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f).padding(start = 10.dp))
                            Text(
                                "Çıkar",
                                color = ScPink, fontSize = 12.sp, fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .clickable {
                                        social.removeFriend(uid, friend.uid) { err ->
                                            if (err == null) refresh++ else statusMessage = err
                                        }
                                    }
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(24.dp))
    }
}
