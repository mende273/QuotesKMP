package mende273.quoteskmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform