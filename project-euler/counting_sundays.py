from datetime import date, timedelta


def counting_sundays(start_date, end_date):
    count = 0

    while(start_date <= end_date):
        if(start_date.day == 1 and start_date.weekday() == 6):
            count += 1
    
        start_date = start_date + timedelta(days = 1)
    
    return count

print(counting_sundays(date(1901, 1, 1), date(2000, 12, 31)))