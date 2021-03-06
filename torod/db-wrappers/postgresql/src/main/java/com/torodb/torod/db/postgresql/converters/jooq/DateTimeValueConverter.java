/*
 *     This file is part of ToroDB.
 *
 *     ToroDB is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ToroDB is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with ToroDB. If not, see <http://www.gnu.org/licenses/>.
 *
 *     Copyright (c) 2014, 8Kdata Technology
 *     
 */

package com.torodb.torod.db.postgresql.converters.jooq;

import com.torodb.torod.core.subdocument.BasicType;
import com.torodb.torod.core.subdocument.values.DateTimeValue;
import java.sql.Timestamp;
import org.jooq.DataType;
import org.jooq.impl.SQLDataType;
import org.threeten.bp.DateTimeUtils;

/**
 *
 */
public class DateTimeValueConverter implements SubdocValueConverter<Timestamp, DateTimeValue>{
    private static final long serialVersionUID = 1L;

    @Override
    public DataType<Timestamp> getDataType() {
        return SQLDataType.TIMESTAMP;
    }

    @Override
    public BasicType getErasuredType() {
        return BasicType.DATE;
    }

    @Override
    public DateTimeValue from(Timestamp databaseObject) {
        return new DateTimeValue(
                DateTimeUtils.toLocalDateTime(databaseObject)
        );
    }

    @Override
    public Timestamp to(DateTimeValue userObject) {
        return DateTimeUtils.toSqlTimestamp(userObject.getValue());
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<DateTimeValue> toType() {
        return DateTimeValue.class;
    }
    
}
