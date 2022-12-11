package tn.vapex.core.utils;


import tn.vapex.domain.exceptions.exceptions.CustomException;

import java.util.function.Supplier;

public abstract class CheckerUtils {
    private CheckerUtils() {
    }

    public static boolean returnFalseOrThrowException(Supplier<? extends CustomException> exceptionSupplier, boolean throwExceptionOnFalse) {
        if (throwExceptionOnFalse) {
            throw exceptionSupplier.get();
        }
        return false;
    }
}
