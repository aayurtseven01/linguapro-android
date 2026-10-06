# Lingua Pro brand system

The app uses one shared visual language across the welcome flow, learning dashboard, avatar editor and splash screen.

| Token | Hex | Use |
|---|---:|---|
| Midnight | `#0B1423` | Primary background |
| Deep blue | `#14263D` | Gradient background |
| Mint | `#6DE8C1` | Primary accent and progress |
| Lavender | `#B7A4FF` | Secondary accent |
| Coral | `#FF9586` | Error and warm accent |
| Primary text | `#F3F7FD` | Headlines |
| Secondary text | `#C3CEE0` | Supporting copy |

## Splash asset

`app/src/main/res/raw/splash_logo.mp4` is a 720 × 1280, 30 fps, 3.4 second H.264 MP4 with a `yuv420p` pixel format and fast-start metadata. It has no audio track. The animation introduces the gradient L mark first, then the Lingua Pro wordmark and product descriptor. Its final frame matches the app background so the transition into Compose does not flash.
