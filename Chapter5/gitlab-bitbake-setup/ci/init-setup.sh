#!/usr/bin/env bash

set -euo pipefail

: "${BITBAKE_SETUP:?BITBAKE_SETUP is not defined}"
: "${YOCTO_TOP_DIR:?YOCTO_TOP_DIR is not defined}"
: "${DL_DIR:?DL_DIR is not defined}"
: "${CI_PROJECT_NAME:?CI_PROJECT_NAME is not defined}"
: "${CI_PIPELINE_ID:?CI_PIPELINE_ID is not defined}"
: "${CI_PROJECT_DIR:?CI_PROJECT_DIR is not defined}"
: "${MACHINE:?MACHINE is not defined}"

safe_project_name="${CI_PROJECT_NAME//[^a-zA-Z0-9_.-]/-}"
safe_machine="${MACHINE//[^a-zA-Z0-9_.-]/-}"

export SETUP_NAME="${safe_project_name}-${CI_PIPELINE_ID}-${safe_machine}"
export SETUP_DIR="${YOCTO_TOP_DIR}/${SETUP_NAME}"

if [[ -f "${SETUP_DIR}/build/init-build-env" ]]; then
    echo "The setup already exists: ${SETUP_DIR}"
    exit 0
fi

"${BITBAKE_SETUP}" \
    --setting default top-dir-prefix "/home/gitlab-runner" \
    --setting default top-dir-name "build" \
    --setting default dl-dir "${DL_DIR}" \
    --setting default common-sstate "yes" \
    init \
    --non-interactive \
    --setup-dir-name "${SETUP_NAME}" \
    "${CI_PROJECT_DIR}/ci/oe-nodistro-master.conf.json" \
    nodistro \
    "machine/${MACHINE}"

test -f "${SETUP_DIR}/build/init-build-env"

echo "Created setup: ${SETUP_DIR}"
