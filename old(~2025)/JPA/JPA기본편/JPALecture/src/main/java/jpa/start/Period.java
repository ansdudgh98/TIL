package jpa.start;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;


@Embeddable
public class Period {
    private LocalDateTime localDateTime;
    private LocalDateTime endDate;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Period() {
    }
}
