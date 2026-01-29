# Agents.md - Antigravity Android Development Guide

## Project Overview
This project is an Android application named "WhatJustChanged" built with industry best practices.

## Guidelines for Agents
1.  **Architecture**: Follow Clean Architecture & MVVM.
    -   **Domain Layer**: Pure Kotlin, no Android dependencies (Use Cases, Models).
    -   **Data Layer**: Repositories, Data Sources (Remote/Local).
    -   **UI Layer**: Jetpack Compose, ViewModels.
2.  **Modularization**:
    -   Feature modules should be independent.
    -   Core modules (`:core:ui`, `:core:data`, `:core:network`) hold shared logic.
    -   To add a screen/feature: Create a new module (or package if small), implement `Navigation` route, add to `NavHost`.
3.  **Configuration**:
    -   Use `local.properties` for secrets (API Keys) - **NEVER COMMIT THIS**.
    -   Use `build.gradle.kts` (BuildConfig) to expose these to code.
    -   Configurable URLs/Ports should be in a dedicated Config provider (in `:core:data`).
4.  **Tech Stack**:
    -   Language: Kotlin
    -   UI: Jetpack Compose
    -   DI: Hilt
    -   Async: Coroutines & Flow
    -   Network: Retrofit
    -   Build: Gradle (Kotlin DSL)

## Workflow
-   Check `implementation_plan.md` before starting work.
-   Update `task.md` continuously.
-   When adding external service calls, update the Config Manager.

## Key Files
-   `color_scheme_config.md`: Design tokens (Colors, Typography).
-   `build.gradle.kts`: Project and Module level build configurations.
