package com.michel.nearby.data.model

import androidx.annotation.DrawableRes
import com.michel.nearby.R

enum class NearbyCategoryFilterChipView(
    val description: String,
    @DrawableRes val icon: Int
) {
    ALIMENTACAO(description = "Alimentação", icon = R.drawable.ic_tools_kitchen_2),
    COMPRAS(description = "Compras", icon = R.drawable.ic_shopping_bag),
    HOSEDAGEM(description = "Hospedagem", icon = R.drawable.ic_bed),
    SUPERMERCADO(description = "Supermercado", icon = R.drawable.ic_shopping_cart),
    ENTRETENIMENTO(description = "Entretenimento", icon = R.drawable.ic_movie),
    FARMACIA(description = "Farmacia", icon = R.drawable.ic_first_aid_kit),
    COMBUSTIVEL(description = "Combustivel", icon = R.drawable.ic_gas_station),
    PADARIA(description = "Padaria", icon = R.drawable.ic_bakery);

    companion object {
        fun fromDrescription(description: String): NearbyCategoryFilterChipView? {
            return entries.find { it.description == description }
        }
    }
}