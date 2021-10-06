#!/usr/bin/env bash
source vault_env.sh 
$HOME/Downloads/vault kv put secret/bootiful message-from-vault-server="Hello Spring Cloud Vault"
