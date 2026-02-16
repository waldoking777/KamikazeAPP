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
            instructor = "Daniel Rubio",
            address = "La Mena",
            phone = "0987654321",
            email = "teamrubio@gmail.com",
            imageResId = R.drawable.kamikaze
        ),
        Location(
            id = "kamikaze_thai_fight",
            name = "KAMIKAZE THAI FIGHT",
            instructor = "Alejandro Sánchez (6° Khan / Azul)",
            address = "Universidad Central",
            phone = "0987654321",
            email = "ktf@gmail.com",
            imageResId = R.drawable.kamikaze
        ),
        Location(
            id = "kamikaze_next_level",
            name = "KAMIKAZE NEXT LEVEL",
            instructor = "Alex Zabala",
            address = "Norte de Quito",
            phone = "0987654321",
            email = "nextlevel@gmail.com",
            imageResId = R.drawable.kamikaze
        )
    )

    fun getLocations(): List<Location> = locations

    fun getLocationById(id: String): Location? {
        return locations.find { it.id == id }
    }
}
