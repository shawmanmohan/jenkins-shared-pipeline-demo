#!/usr/bin/env groovy

def call(String repoUrl, String credentialsId){
    git credentialsId: "${credentialsId}", url: "${repoUrl}"
}