#!/usr/bin/env groovy

def call(String buildResult, String hipchatRoom) {

if ( buildResult == "SUCCESS" ) {
    hipchatSend color: 'GREEN', credentialId: '975291db-b37c-42a9-a191-87f93502800a', failOnError: true, message: 'Build Successful Message', notify: true, room: "${hipchatRoom}", sendAs: 'Jenkins-Notifier', server: 'hipchat.test.com', textFormat: true, v2enabled: true
    }
else if( buildResult == "FAILURE" ) { 
    hipchatSend color: 'RED', credentialId: '975291db-b37c-42a9-a191-87f93502800a', failOnError: true, message: 'Build Successful Message', notify: true, room: "${hipchatRoom}", sendAs: 'Jenkins-Notifier', server: 'hipchat.test.com', textFormat: true, v2enabled: true
    }
else ( buildResult == "UNSTABLE" ) { 
    hipchatSend color: 'YELLOW', credentialId: '975291db-b37c-42a9-a191-87f93502800a', failOnError: true, message: 'Build Successful Message', notify: true, room: "${hipchatRoom}", sendAs: 'Jenkins-Notifier', server: 'hipchat.test.com', textFormat: true, v2enabled: true
    }
}
