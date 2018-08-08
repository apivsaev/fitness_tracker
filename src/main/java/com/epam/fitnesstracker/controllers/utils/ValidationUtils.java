package com.epam.fitnesstracker.controllers.utils;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to perform validation of request parameters.
 */
public class ValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    private static final String INCORRECT_PARAM_ERROR = "Incorrect request parameter";

    public static Integer validateAdnGetIntegerParam(String param, boolean nullAllowed, String errorMessage) throws BadRequestException {
        checkForNull(param, nullAllowed, errorMessage);

        if (param == null) {
            return null;
        }

        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            LOGGER.debug(INCORRECT_PARAM_ERROR, e);
            throw new BadRequestException(errorMessage);
        }
    }

    public static Long validateAdnGetLongParam(String param, boolean nullAllowed, String errorMessage) throws BadRequestException {
        checkForNull(param, nullAllowed, errorMessage);

        if (param == null) {
            return null;
        }

        try {
            return Long.parseLong(param);
        } catch (NumberFormatException e) {
            LOGGER.debug(INCORRECT_PARAM_ERROR, e);
            throw new BadRequestException(errorMessage);
        }
    }

    public static Double validateAdnGetDoubleParam(String param, boolean nullAllowed, String errorMessage) throws BadRequestException {
        checkForNull(param, nullAllowed, errorMessage);

        if (param == null) {
            return null;
        }

        try {
            return Double.parseDouble(param);
        } catch (NumberFormatException e) {
            LOGGER.debug(INCORRECT_PARAM_ERROR, e);
            throw new BadRequestException(errorMessage);
        }
    }

    public static void checkStringParam(String param, boolean nullAllowed, String errorMessage) throws BadRequestException {
        checkForNull(param, nullAllowed, errorMessage);
    }

    private static void checkForNull(String param, boolean nullAllowed, String errorMessage) throws BadRequestException {
        if (param == null && !nullAllowed) {
            throw new BadRequestException(errorMessage);
        }
    }

    public static void validateUser(User user) throws BadRequestException {
        if (user.getName() == null || user.getName().isEmpty() || user.getAge() == null) {
            throw new BadRequestException("Incorrect user");
        }
    }

    public static void validateExercise(Exercise exercise) throws BadRequestException {
        if (exercise.getName() == null || exercise.getName().isEmpty()) {
            throw new BadRequestException("Incorrect exercise");
        }
    }
}
