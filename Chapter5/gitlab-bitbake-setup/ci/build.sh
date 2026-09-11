#!/usr/bin/env bash

set -euo pipefail

: "${YOCTO_TOP_DIR:?YOCTO_TOP_DIR is not defined}"
: "${CI_PROJECT_NAME:?CI_PROJECT_NAME is not defined}"
: "${CI_PIPELINE_ID:?CI_PIPELINE_ID is not defined}"
: "${MACHINE:?MACHINE is not defined}"
: "${TARGET_IMAGE:?TARGET_IMAGE is not defined}"

safe_project_name="${CI_PROJECT_NAME//[^a-zA-Z0-9_.-]/-}"
safe_machine="${MACHINE//[^a-zA-Z0-9_.-]/-}"

setup_name="${safe_project_name}-${CI_PIPELINE_ID}-${safe_machine}"
setup_dir="${YOCTO_TOP_DIR}/${setup_name}"

init_script="${setup_dir}/build/init-build-env"

if [[ ! -f "${init_script}" ]]; then
    echo "The setup has not been initialized: ${setup_dir}" >&2
    exit 1
fi

# init-build-env intentionally modifies the current shell.
source "${init_script}"

bitbake "${TARGET_IMAGE}"
