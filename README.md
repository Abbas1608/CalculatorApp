# "Calcify" - The Multi-Functional Calculator App

## 1. Introduction

**Calcify** is a modern, user-friendly, and powerful calculator app built using **Jetpack Compose**. More than just basic calculations, Calcify brings you a suite of tools including:

- 🧮 Smart Calculator  
- 📏 Area & Volume Calculator  
- 📐 Geometry Formula List  
- 💸 Tip Calculator  
- ➕ And more...
  
Calcify is designed to make mathematical operations easy and accessible for everyone. Whether you're solving daily arithmetic, measuring room dimensions, or quickly checking geometry formulas, Calcify brings it all under one elegant and intuitive interface.

---

## 2. Understanding the Technology

This project is developed entirely using **Jetpack Compose**, Android's modern UI toolkit that simplifies and accelerates UI development. Its reactive programming model allows for a smooth and responsive user experience.

---

## 3. Dependencies Used

Calcify utilizes the following key libraries and dependencies:

1. Icons Support  

``` kotlin
implementation("androidx.compose.material:material-icons-extended:1.7.7")
```

2. LiveData integration with Compose

``` Kotlin
implementation("androidx.compose.runtime:runtime-livedata:1.8.2")
```

3. Mozilla Rhino for parsing and evaluating complex mathematical expressions

``` Kotlin
implementation("org.mozilla:rhino:1.7R4")
```

4. Navigation using Jetpack Compose

``` Kotlin
val nav_version = "2.9.0"
implementation("androidx.navigation:navigation-compose:$nav_version")
```
---

## 5. Conclusion

**Calcify** is more than just a calculator — it's your everyday math assistant.  From students, Calcify is designed to cater to all.

The app is open source, and contributions are welcome!
