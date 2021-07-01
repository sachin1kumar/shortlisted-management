/*
package com.shortlisted.management.shortlistedmanagement.messaging;

import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

import static com.shortlisted.management.shortlistedmanagement.messaging.TopicPrefix.COMMAND;
import static com.shortlisted.management.shortlistedmanagement.messaging.TopicSuffix.CREATE;
import static com.shortlisted.management.shortlistedmanagement.messaging.TopicSuffix.DELETE;

public class Topic {

    public static String commandCreateTopic(@NonNull final String aggregateRootName) {
        return buildTopic(COMMAND.getPrefix(), aggregateRootName, CREATE.getSuffix());
    }

    public static String commandDeleteTopic(@NonNull final String aggregateRootName) {
        return buildTopic(COMMAND.getPrefix(), aggregateRootName, DELETE.getSuffix());
    }

    private static String buildTopic(@NonNull final String prefix,
                                     @NonNull final String aggregateRootName,
                                     @NonNull final String suffix) {
        if(StringUtils.containsWhitespace(aggregateRootName)) {
            throw new IllegalArgumentException("Aggregate root name cannot contain whitespace: '" + aggregateRootName +
                    "'");
        }
        return prefix + aggregateRootName + suffix;
    }
}
*/
