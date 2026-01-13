# Sharp Rewards App

## 📱 Overview
Rewards-based gaming app for Gen Z users.

## ✨ Features
AUTHENTICATION
┌─────────────────────┐
│ 1. App Launch       │
│ 2. Check DB         │
│ 3. New User Setup   │
│ 4. Login w/ Name    │
└─────────────────────┘

GAME MODES
┌──────────────────────────────────────────┐
│ Daily Sprint          │  Flash Challenge   │
├───────────────────────┼──────────────────┤
│ • Daily challenges    │ • Time-based      │
│ • Streak tracking     │ • Quick tasks     │
│ • Consistent rewards  │ • High rewards    │
│                       │ • Limited time    │
└───────────────────────┴──────────────────┘
│ Weekly Arena                             │
├──────────────────────────────────────────┤
│ • Weekly competitions                    │
│ • Leaderboard ranking                    │
│ • Special rewards                        │
└──────────────────────────────────────────┘

REWARD SYSTEM
┌──────────────────────────────────────────┐
│ Wallet (Sharp Coins)                     │
├──────────────────────────────────────────┤
│ • Earned from challenges                 │
│ • Tracked per user                       │
│ • Viewable in Wallet Screen              │
├──────────────────────────────────────────┤
│ Streak Counter (🔥)                      │
├──────────────────────────────────────────┤
│ • Increments on daily completion         │
│ • Resets if missed                       │
│ • Shows consistency                      │
└──────────────────────────────────────────┘

## 🛠 Tech Stack
- Android (Java)
- Firebase / Dummy Data
- MVVM
## Data flow
User Input (Challenge Selection)
        ↓
Retrieve Challenge Data (from DB)
        ↓
Display Challenge Details
        ↓
User Completes Challenge
        ↓
Verify & Validate Answer
        ↓
Update Database:
  • Insert progress record
  • Update user wallet (+reward)
  • Update user streak (+1)
  • Update last_completed_date
        ↓
Refresh UI & Show Results


## How to Run
1. Open in Android Studio
2. Run on emulator/device

##  Demo Video
Google Drive Link:
https://drive.google.com/file/d/1W5Gk6Avmb6HuVyN0y3OkXYQZ3hBzHMol/view?usp=drive_link

##  Architecture Diagrams
Available in `/diagrams` folder
