package bobby.irawan.ministockbit.presentation.utils

import androidx.annotation.StringRes
import com.afollestad.vvalidator.field.input.InputLayoutField

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
object ValidationHelper {

    fun InputLayoutField.assertNotEmpty(@StringRes stringRes: Int = -1) {
        if (stringRes != -1) isNotEmpty().description(stringRes)
        else isNotEmpty().description("Input your ${this.view.hint}")
    }
}