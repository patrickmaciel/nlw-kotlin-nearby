package info.patrickmaciel.nlw.nearby.data.model.mock

import info.patrickmaciel.nlw.nearby.data.model.Rule

var mockRules = listOf(
    Rule(
        id = "1",
        description = "Disponível até 31/12/2025",
        marketId = "1"
    ),
    Rule(
        id = "2",
        description = "Válido apenas paar consumo no local",
        marketId = "1"
    ),
    Rule(
        id = "3",
        description = "Não cumulativo com outras promoções",
        marketId = "1"
    ),
)