#!/usr/bin/env bash

export VAULT_TOKEN=00000000-0000-0000-0000-000000000000
export VAULT_ADDR=http://127.0.0.1:8200

# docker run --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -p 8200:8200 -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' vault:1.2.1

# vault server --dev --dev-root-token-id="$VAULT_TOKEN"

vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"
