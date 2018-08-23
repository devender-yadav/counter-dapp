# Counter DApp

It's a simple counter decentralized application. Anyone can read it's counter value and only contract publisher can increase/decease it. 

## How to use

Create executable file

    git clone https://github.com/devender-yadav/counter-dapp.git
    
    cd counter-dapp
    
    mvn clean install
    
`counterdapp-1.0-SNAPSHOT.war` will be created in target folder.

Start Dapp
    
    java -jar target/counterdapp-1.0-SNAPSHOT.war
    
  
 Application will run on **localhost:8080**
 
 
## Ethereum endpoint configuration

Edit `web3j.client-address` in  [application.properites](https://github.com/devender-yadav/counter-dapp/blob/master/src/main/resources/application.properties). 


_P.S. This is just a demo DApp. Feel free to edit it. _
