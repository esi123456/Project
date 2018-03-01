package com.sefryek.brokerpro.config.validation;

import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * See ContactCardTest#testAddInvalidContact.
 */
public class CustomParameterNameProvider implements ParameterNameProvider {

    private final ParameterNameProvider nameProvider;

    public CustomParameterNameProvider() {
        nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
    }

    @Override
    public List<String> getParameterNames(final Constructor<?> constructor) {
        return nameProvider.getParameterNames(constructor);
    }

    @Override
    public List<String> getParameterNames(final Method method) {
        // See ContactCardTest#testAddInvalidContact.
        if ("login".equals(method.getName())) {
//            ArrayList<String> result = new ArrayList<String>();
//            for (Parameter parameter : method.getParameters()) {
//                if (parameter.getParameterizedType().getTypeName().contains("LoginRequest")) {
//                    return Arrays.asList("asyncResponse", "login");
//                    result.add("login");
//                    result.add(parameter.getParameterizedType().getTypeName());
//                } else {
//                    result.add(parameter.getParameterizedType().getTypeName());
//                }
//            }
//            return result;
//            method.getParameters()[1].getParameterizedType().getTypeName()
//            return Arrays.asList("login");
        }
        return nameProvider.getParameterNames(method);
    }
}