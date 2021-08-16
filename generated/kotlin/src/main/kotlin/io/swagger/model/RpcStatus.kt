package io.swagger.model

import io.swagger.model.ProtobufAny
/**
 * 
 * RpcStatus
 * @param code 
 * @param message 
 * @param details 
 */
data class RpcStatus (
    val code: kotlin.Int? = null,
    val message: kotlin.String? = null,
    val details: kotlin.Array<ProtobufAny>? = null
) {

}

