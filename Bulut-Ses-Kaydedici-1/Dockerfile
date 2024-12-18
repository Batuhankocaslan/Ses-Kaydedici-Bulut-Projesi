# Android SDK Base Image
FROM openjdk:11-jdk-slim

# Android SDK ve Gradle için değişkenler
ENV ANDROID_SDK_ROOT /usr/local/android-sdk
ENV PATH $ANDROID_SDK_ROOT/cmdline-tools/tools/bin:$ANDROID_SDK_ROOT/platform-tools:$PATH

# SDK ve gerekli araçları yükleme
RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    unzip \
    git && \
    mkdir -p $ANDROID_SDK_ROOT/cmdline-tools && \
    cd $ANDROID_SDK_ROOT/cmdline-tools && \
    wget https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip -O cmdline-tools.zip && \
    unzip cmdline-tools.zip -d tools && \
    rm cmdline-tools.zip && \
    yes | sdkmanager --licenses && \
    sdkmanager "platform-tools" "platforms;android-33" "build-tools;33.0.2"

# Projeyi kopyalama ve Gradle build işlemi
WORKDIR /app
COPY app .
RUN ./gradlew build

# Çıktı APK dosyasını oluşturma
CMD ["bash", "-c", "cp app/build/outputs/apk/debug/app-debug.apk /output/app-debug.apk"]
