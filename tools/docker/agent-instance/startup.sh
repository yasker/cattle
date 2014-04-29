#!/bin/bash
set -e

trap cleanup EXIT

# This is copied from common/scripts.sh, if there is a change here
# make it in common and then copy here
check_debug()
{
    if [ -n "$CATTLE_SCRIPT_DEBUG" ] || echo "${@}" | grep -q -- --debug; then
        export CATTLE_SCRIPT_DEBUG=true
        export PS4='[${BASH_SOURCE##*/}:${LINENO}] '
        set -x
    fi
}

info()
{
    echo "INFO:" "${@}"
}

error()
{
    echo "ERROR:" "${@}" 1>&2
}

export CATTLE_HOME=${CATTLE_HOME:-/var/lib/cattle}

check_debug
# End copy

CONTENT_URL=/configcontent/configscripts
INSTALL_ITEMS="configscripts agent-instance-startup"

cleanup()
{
    if [ -e "$TEMP_DOWNLOAD" ]; then
        rm -rf $TEMP_DOWNLOAD
    fi
}

call_curl()
{
    local curl="curl -s" 
    if [ -n "$CATTLE_AGENT_INSTANCE_AUTH" ]; then
        $curl -H "Authorization: $CATTLE_AGENT_INSTANCE_AUTH" "$@"
    elif [ -n "$CATTLE_ACCESS_KEY" ]; then
        $curl -u ${CATTLE_ACCESS_KEY}:${CATTLE_SECRET_KEY} "$@"
    else
        $curl "$@"
    fi
}

download_agent()
{
    cleanup

    TEMP_DOWNLOAD=$(mktemp -d bootstrap.XXXXXXX)
    info Downloading agent "${CATTLE_CONFIG_URL}${CONTENT_URL}"
    call_curl --retry 5 ${CATTLE_CONFIG_URL}${CONTENT_URL} > $TEMP_DOWNLOAD/content
    tar xzf $TEMP_DOWNLOAD/content -C $TEMP_DOWNLOAD || ( cat $TEMP_DOWNLOAD/content 1>&2 && exit 1 )
    bash $TEMP_DOWNLOAD/*/config.sh $INSTALL_ITEMS

    cleanup
}

setup_config_url()
{
    if [ -n "$CATTLE_CONFIG_URL" ]; then
        return
    fi

    local host=$(ip route show dev eth0 | grep ^default | awk '{print $3}')
    CATTLE_CONFIG_URL="${CATTLE_CONFIG_URL_SCHEME:-http}"
    CATTLE_CONFIG_URL="${CATTLE_CONFIG_URL}://${CATTLE_CONFIG_URL_HOST:-$host}"
    CATTLE_CONFIG_URL="${CATTLE_CONFIG_URL}:${CATTLE_CONFIG_URL_PORT:-9342}"
    CATTLE_CONFIG_URL="${CATTLE_CONFIG_URL}${CATTLE_CONFIG_URL_PATH:-/v1}"

    export CATTLE_CONFIG_URL
}

mkdir -p $CATTLE_HOME
cd $CATTLE_HOME

# Let scripts know its being ran during startup
export CATTLE_AGENT_STARTUP=true

echo '::askfirst:-/bin/sh' > /etc/inittab

setup_config_url
download_agent

if [ "$$" = 1 ]; then
    if [ ! -e /init ]; then
        ln -s $(which busybox) /init
    fi
    exec /init
fi