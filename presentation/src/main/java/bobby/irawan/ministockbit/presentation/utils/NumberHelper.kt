package bobby.irawan.ministockbit.presentation.utils

import java.text.DecimalFormat

/**
 * Created by bobbyirawan09 on 26/08/20.
 */
object NumberHelper {

    fun formatPriceChanges(value: Double): String {
        return DecimalFormat("##.##").format(value)
    }

    fun formatPrice(value: Double): String {
        return DecimalFormat("#,###").format(value)
    }
}