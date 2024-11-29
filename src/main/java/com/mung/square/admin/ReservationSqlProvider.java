package com.mung.square.admin;

import org.apache.ibatis.jdbc.SQL;

public class ReservationSqlProvider {

    public String getFilteredReservations(
            final String status,
            final String startDate,
            final String endDate
    ) {
        return new SQL() {{
            SELECT("*");
            FROM("reservations");
            if (status != null && !status.equals("all")) {
                WHERE("status = #{status}");
            }
            if (startDate != null && endDate != null) {
                WHERE("reservation_date BETWEEN #{startDate} AND #{endDate}");
            }
        }}.toString();
    }
}

