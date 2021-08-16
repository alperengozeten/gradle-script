/**
* NOTE: This interface is auto generated by the swagger code generator program (2.4.22-SNAPSHOT).
* https://github.com/swagger-api/swagger-codegen
* Do not edit the class manually.
*/
package io.swagger.api;

import io.swagger.model.GoOpenapiGenHelloReply;
import io.swagger.model.GoOpenapiGenHelloRequest;
import io.swagger.model.RpcStatus;
import com.linecorp.armeria.common.*;
import com.linecorp.armeria.server.annotation.*;

interface GreeterApi {

    // Override these methods

    @Post("/v1/example/login")
    @ProducesGroup(
        Produces("application/json")
    )
    @ConsumesGroup(
        Consumes("application/json")
    )
    suspend fun greeterSayHello(body : GoOpenapiGenHelloRequest) : HttpResponse {
        return HttpResponse.of(HttpStatus.NOT_IMPLEMENTED)
    }

}
