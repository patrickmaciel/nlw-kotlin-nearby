package info.patrickmaciel.nlw.nearby.data.model.mock

import info.patrickmaciel.nlw.nearby.data.model.Market
import info.patrickmaciel.nlw.nearby.data.model.Rule

var mockMarkets = listOf(
    Market(
        id = "1",
        categoryId = "1",
        name = "Supermercado ABC",
        description = "Supermercado ABC",
        coupons = 10,
        rules = listOf(
            Rule(id = "1", description = "Válido até 25/12", marketId = "1"),
            Rule(id = "2", description = "Tem que comer tudo", marketId = "1"),
            Rule(id = "3", description = "Desperdício paga", marketId = "1"),
            Rule(id = "4", description = "Você não é tão bem-vindo assim", marketId = "1"),
        ),
        latitude = -23.5505199,
        longitude = -46.6333094,
        address = "Rua das Flores, 123",
        phone = "(11) 99999-9999",
        cover = "https://images.unsplash.com/photo-1612838320302-3b3b3f1b3b3b"
    ),
    Market(
        id = "2",
        categoryId = "2",
        name = "Supermercado XYZ",
        description = "Supermercado XYZ",
        coupons = 0,
        rules = emptyList(),
        latitude = -23.5505199,
        longitude = -46.6333094,
        address = "Rua das Flores, 123",
        phone = "(11) 99999-9999",
        cover = "https://images.unsplash.com/photo-1612838320302-3b3b3f1b3b3b"
    ),
    Market(
        id = "3",
        categoryId = "3",
        name = "Supermercado 123",
        description = "Supermercado 123",
        coupons = 5,
        rules = emptyList(),
        latitude = -23.5505199,
        longitude = -46.6333094,
        address = "Rua das Flores, 123",
        phone = "(11) 99999-9999",
        cover = "https://images.unsplash.com/photo-1612838320302-3b3b3f1b3b3b"
    ),
)