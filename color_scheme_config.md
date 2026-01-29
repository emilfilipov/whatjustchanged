WhatJustChanged — Core Design Tokens (v1)
1. Typography
Primary Serif (Headlines, Key Statements)
Font: Source Serif 4
 (Free, Google Fonts, excellent legibility, modern but warm)
Fallbacks:
 Georgia, Times New Roman, serif
Use for:
Onboarding headlines
Change Card titles
Key explanatory sentences
Confirmation copy (“You’re now up to date…”)
Weights used:
Regular (400)
SemiBold (600) — sparingly
Secondary Sans (UI, Metadata, Buttons)
Font: Inter
 (Neutral, readable, widely used, non-distracting)
Fallbacks:
 -apple-system, BlinkMacSystemFont, Segoe UI, sans-serif
Use for:
Buttons
Metadata lines (source, date, form)
Toggles, settings
Helper text
Weights used:
Regular (400)
Medium (500)
SemiBold (600) for buttons only
Typography Scale (recommended)
PurposeFontSizeWeightApp name / Hero headlineSource Serif 428–32px600Section titlesSource Serif 420–22px600Body explanationSource Serif 416–18px400MetadataInter13–14px400ButtonsInter15–16px600Helper textInter13px400
Line-height:
Serif text: 1.4–1.5
Sans text: 1.3–1.4
2. Colour Palette
Core Backgrounds (Warm, Calm)
These create the “helpful but serious” feel.

Background / Primary
#F7F4EF   (Warm off-white)

Card background
#FBF9F6   (Slightly lifted paper tone)

Secondary background (grouped areas)
#F1ECE5   (Soft warm grey)
Text Colours (No Pure Black)
Avoid harsh contrast; this is deliberate.

Primary text
#2E2E2C   (Charcoal)

Secondary text / metadata
#6B6B66   (Muted grey)

Helper / instructional text
#8A8A83   (Soft grey)
Accent Colour (Single Accent Only)
Used sparingly for:
Primary CTA buttons
Key links
Active states

Primary accent (Muted blue)
#3F6C8F
Hover / pressed (optional):

#345A77
Warm Highlight (Beginner-friendly emphasis)
Used for:
“Why you’re seeing this” box
Gentle callouts
Onboarding emphasis

Warm highlight background
#EDE4D7

Warm highlight border (optional)
#D9CBB6
This adds warmth without emotional manipulation.
Borders & Dividers

Subtle divider
#E1DBD3
Use 1px max. No heavy borders.
3. Buttons
Primary Button

Background: #3F6C8F
Text: #FFFFFF
Border-radius: 8–10px
Secondary Button

Background: Transparent
Text: #3F6C8F
Border: 1px solid #D9CBB6
Disabled / Quiet Button

Background: #E6E2DC
Text: #9A9A93
4. Cards (Change Cards, Alerts)

Background: #FBF9F6
Corner radius: 12px
Shadow: very subtle
  rgba(0,0,0,0.04) 0px 2px 8px
Cards should feel like documents, not widgets.
5. Icons
Use outline icons only
Stroke weight: 1.5–2px
Colour: #6B6B66
Avoid filled or colourful icons
Recommended icon sets:
SF Symbols (iOS)
Feather Icons
Lucide
6. Accessibility Notes (important)
Contrast ratios pass WCAG AA
No red/green reliance
No flashing / motion-based cues
Text always explains state (“Monitoring paused”, not colour alone)