# IP Pulse Scanner

Android benchmark app for user-supplied IP addresses. It does not scan CIDR ranges.

Features:
- User-entered IP list, one per line
- Up to 300 echo requests per destination
- Configurable interval between probes
- Min / Avg / Max RTT
- Consecutive-sample jitter estimate
- Packet loss
- Ranking by loss, jitter, then average RTT
- Stop button

Build: GitHub Actions workflow builds a debug APK and uploads it as an artifact.

Note: Android ping command behavior can vary by device/OS. The app parses RTT samples from the system ping utility available on compatible Android builds.
