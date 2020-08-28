package bobby.irawan.ministockbit.data.common

import bobby.irawan.ministockbit.data.model.Subscription

/**
 * Created by bobbyirawan09 on 27/08/20.
 */
object Constants {

    const val QUERY_PARAM_API_KEY = "api_key"
    const val QUERY_PARAM_LIMIT = "limit"
    const val QUERY_PARAM_PAGE = "page"
    const val QUERY_PARAM_TSYM = "tsym"
    val WEB_SOCKET_SUBSCRIBE_MODEL = Subscription("SubAdd", listOf("21~BTC", "21~ETH"))
}