# 🔵 Fades

**Fades** is a modern image feed & stories Android app built with Kotlin, XML, and clean architecture. It uses the **Imgur API** to display dynamic image feeds and Instagram-style auto-playing stories based on categories like `hot`, `top`, and popular tags like `funny`, `meme`, etc.

---

## 🚀 Features

- ✅ Bottom Navigation for **Hot** & **Top** feeds  
- ✅ Image feed with **title** and **preview** using `RecyclerView`  
- ✅ Auto-scrolling **story viewer** at the top that changes image every 5 seconds  
- ✅ Tap on story tags like `#funny` or `#meme` to explore related stories  
- ✅ Efficient image loading using **Coil**  
- ✅ MVVM Architecture with ViewModel, Repository, and UseCase layers  
- ✅ API integration via **Retrofit** with error handling  
- ✅ Asynchronous data handling using **Coroutines + Flow**  
- ✅ Unit-tested core layers for reliability  
- ✅ Clean and scalable project structure  

---

## 🧠 How It Works

### 1. Navigation

The app has two main tabs: **Hot** and **Top**, accessible via bottom navigation.

Each tab shows:
- A **horizontal story section** (auto-playing every 5 seconds)
- A **vertical feed** of image posts below

---

### 2. Data Fetching

- On launch, the app fetches data from **Imgur's API** using Retrofit.
- Images are rendered in `RecyclerView` using a custom adapter.
- The top stories are selected from the feed and auto-scroll automatically.

---

### 3. Auto-Playing Stories

- No user action needed.  
- Every **5 seconds**, the story viewer automatically switches to the next image.
- This mimics the behavior seen in apps like Instagram.

---

## 📸 Tech Stack

- **Kotlin + XML**
- **MVVM Architecture**
- **Retrofit + Coroutines + Flow**
- **Coil** for image loading
- **Navigation Component**
- **ViewPager2** for story viewer

---
