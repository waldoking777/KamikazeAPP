package com.muaythai.kamikaze

object LocationRepository {
    private val locations = listOf(
        Location(
            id = "kamikaze_rajasi",
            name = "KAMIKAZE RAJASI",
            instructor = "Marco Sánchez (6° Khan / Azul)",
            address = "Nuevos Horizontes calle 10 y S49 (La Ecuatoriana), Quito - Ecuador",
            phone = "+593 98 359 0001",
            email = "kamikazerajasi1994muaythai@gmail.com",
            imageResId = R.drawable.rajasi
        ),
        Location(
            id = "kamikaze_team_rubio",
            name = "KAMIKAZE TEAM RUBIO",
            instructor = "Ana Gómez",
            address = "Av. Interoceánica y Scalesia, Cumbayá",
            phone = "+593 99 888 7777",
            email = "sede.valle@kamikaze.com",
            imageResId = R.drawable.kamikaze
        )
    )

    fun getLocations(): List<Location> = locations

    fun getLocationById(id: String): Location? {
        return locations.find { it.id == id }
    }
}
