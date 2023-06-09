plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.1").apply(false)
    id("com.android.library").version("7.4.1").apply(false)
    kotlin("android").version("1.8.0").apply(false)
    kotlin("multiplatform").version("1.8.0").apply(false)
    id("org.jetbrains.kotlin.plugin.serialization").version("1.5.30")
    id("com.google.dagger.hilt.android").version("2.44").apply(false)

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
