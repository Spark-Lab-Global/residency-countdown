FROM eclipse-temurin:17-jdk-jammy

ENV ANDROID_HOME=/opt/android-sdk \
    DEBIAN_FRONTEND=noninteractive

RUN apt-get update -qq && \
    apt-get install -y --no-install-recommends unzip curl ca-certificates && \
    rm -rf /var/lib/apt/lists/*

# Android command-line tools (Linux, ~130MB)
RUN mkdir -p $ANDROID_HOME/cmdline-tools && \
    curl -fsSL "https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip" \
        -o /tmp/cmdtools.zip && \
    unzip -q /tmp/cmdtools.zip -d $ANDROID_HOME/cmdline-tools && \
    mv $ANDROID_HOME/cmdline-tools/cmdline-tools $ANDROID_HOME/cmdline-tools/latest && \
    rm /tmp/cmdtools.zip

ENV PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"

# Accept licenses + install minimal SDK (platform 34 + build-tools 34.0.0)
RUN yes | sdkmanager --licenses && \
    sdkmanager "platforms;android-34" "build-tools;34.0.0"

WORKDIR /project
