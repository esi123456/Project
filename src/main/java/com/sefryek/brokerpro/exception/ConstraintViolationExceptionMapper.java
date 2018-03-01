package com.sefryek.brokerpro.exception;

import com.google.common.collect.Iterators;
import com.sefryek.util.ObjectUtils;

import javax.annotation.Priority;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.*;

@Provider
@Priority(Priorities.USER)
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getCode());
        Map<String, List<String>> additionalProperties = new HashMap<>();
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path.Node last = Iterators.getLast(violation.getPropertyPath().iterator());
            List<String> values = additionalProperties.get(last.getName());
            if (ObjectUtils.isNull(values)) {
                values = new ArrayList<>();
            }
            values.add(violation.getMessage());
            additionalProperties.put(last.getName(), values);
        }
        response.setAdditionalProperties(additionalProperties);
        response.setErrorDescription(ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getDescription());
        return Response.status(ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getHttpResponseCode()).entity(response).build();
        // i.e. Set an instance of Viewable to the response
        // so that Jersey MVC support can handle it.
//                .entity(new Viewable("/error", exception))
//                .build();
    }
}