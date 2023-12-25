package com.example.demoapp.mappers;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateMapper {

    public OffsetDateTime toOffsetDateTime(Timestamp timestamp){
        if( timestamp == null) return null;

        return OffsetDateTime.of(
                timestamp.toLocalDateTime(), ZoneOffset.UTC );
    }

    public Timestamp toTimestamp(OffsetDateTime offsetDateTime){

        if(offsetDateTime == null) return null;

        return Timestamp.from(
                offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toInstant());
    }
}
