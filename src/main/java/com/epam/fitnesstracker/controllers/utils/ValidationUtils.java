package com.epam.fitnesstracker.controllers.utils;

import com.epam.fitnesstracker.controllers.exceptions.BadRequestException;
import com.epam.fitnesstracker.domain.Exercise;
import com.epam.fitnesstracker.domain.Set;
import com.epam.fitnesstracker.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to perform validation of request parameters.
 */
public class ValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    private static final String INCORRECT_PARAM_ERROR = "Incorrect request parameter";

    private static final String INCORRECT_USER = "Incorrect user";

    private static final String INCORRECT_EXERCISE = "Incorrect exercise";

    private static final String INCORRECT_SET = "Incorrect set";

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

    public static void validateStringParam(String param, boolean emptyAllowed, String errorMessage) throws BadRequestException {
        checkForNull(param, emptyAllowed, errorMessage);

        if (param.trim().isEmpty() && !emptyAllowed) {
            throw new BadRequestException(errorMessage);
        }
    }

    private static void checkForNull(Object param, boolean nullAllowed, String errorMessage) throws BadRequestException {
        if (param == null && !nullAllowed) {
            throw new BadRequestException(errorMessage);
        }
    }

    public static void validateUser(User user) throws BadRequestException {
        validateStringParam(user.getName(), false, INCORRECT_USER);
        checkForNull(user.getAge(), false, INCORRECT_USER);
    }

    public static void validateExercise(Exercise exercise) throws BadRequestException {
        validateStringParam(exercise.getName(), false, INCORRECT_EXERCISE);
    }

    public static void validateSet(Set set) throws BadRequestException {
        Long trainingId = set.getTraining() != null ? set.getTraining().getId() : null;
        Long exerciseId = set.getExercise() != null ? set.getExercise().getId() : null;
        checkForNull(trainingId, false, INCORRECT_SET);
        checkForNull(exerciseId, false, INCORRECT_SET);
    }
}
