package com.epam.fitnesstracker.services.utils;

import com.epam.fitnesstracker.services.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

/**
 * Utility class to handle service exceptions.
 */
public class ServiceExceptionUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceExceptionUtils.class);

    public static ServiceException handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        if (e instanceof DataAccessException) {
            return new ServiceException(ServiceException.DATA_BASE_ERROR, e);
        } else if (e instanceof ServiceException) {
            return (ServiceException) e;
        }

        return new ServiceException(ServiceException.INTERNAL_SERVER_ERROR, e);
    }
}
