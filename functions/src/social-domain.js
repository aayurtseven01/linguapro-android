'use strict';

const MAX_ACTIVITY_PER_DAY = 5;
function validUsername(value) {
  return typeof value === 'string' && /^[a-z0-9_.]{3,20}$/.test(value);
}
function activityAllowance(day, previousDay, count) {
  const used = previousDay === day && Number.isSafeInteger(count) && count >= 0 ? count : 0;
  return { allowed: used < MAX_ACTIVITY_PER_DAY, nextCount: used + 1 };
}
function activityText(kind, level) {
  switch (kind) {
    case 'quests': return 'Günlük görevlerini tamamladı! 🏆';
    case 'level': return `Çalışmalarına devam ediyor: seviye ${Math.max(1, Math.min(200, Number.isInteger(level) ? level : 1))}. ✨`;
    case 'checkpoint': return 'Kontrol noktası çalışması yaptı! 🏁';
    case 'story': return 'Bir hikâye çalışması tamamladı! 📖';
    default: return null;
  }
}
module.exports = { MAX_ACTIVITY_PER_DAY, validUsername, activityAllowance, activityText };
