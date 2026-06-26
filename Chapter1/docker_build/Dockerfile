# LICENCE: MIT

FROM debian:13

ARG TARGETPLATFORM

RUN apt update && \
    DEBIAN_FRONTEND=noninteractive apt install -y \
        build-essential \
        chrpath \
        cpio \
        debianutils \
        diffstat \
        file \
        gawk \
        gcc \
        git \
        iputils-ping \
        libacl1 \
        locales \
        python3 \
        python3-git \
        python3-jinja2 \
        python3-pexpect \
        python3-pip \
        python3-subunit \
        socat \
        texinfo \
        unzip \
        wget \
        xz-utils \
        zstd && \
        useradd -U -m yoctobuild && \
        echo 'en_US.UTF-8 UTF-8' >> /etc/locale.gen && locale-gen

USER yoctobuild
WORKDIR /home/yoctobuild
CMD ["/bin/bash"]
