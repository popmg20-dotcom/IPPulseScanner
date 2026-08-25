#!/bin/bash
if [ -z "$1" ]; then
    echo "استفاده: ./filter_errors.sh <فایل لاگ>"
    exit 1
fi
LOGFILE="$1"
if [ ! -f "$LOGFILE" ]; then
    echo "فایل $LOGFILE یافت نشد."
    exit 1
fi
echo "در حال فیلتر خطاهای مهم از $LOGFILE ..."
grep -nE "FAILURE|FAILED|error:|Exception|Caused by|BUILD FAILED|No such file|Could not|Gradle task|Execution failed|Process 'command|warning:|Note:" "$LOGFILE" > filtered_errors.txt
if [ -s filtered_errors.txt ]; then
    echo "✅ خطاهای مهم پیدا شده:"
    cat filtered_errors.txt
else
    echo "ℹ️ هیچ خطای مهمی یافت نشد. برای بررسی بیشتر، انتهای لاگ را ببینید:"
    tail -n 50 "$LOGFILE"
fi
